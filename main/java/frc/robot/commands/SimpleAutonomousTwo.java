/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ShootyThing;

public class SimpleAutonomousTwo extends CommandBase {
  /**
   * Creates a new SimpleAutonomousTwo.
   */
  private final DriveTrain m_driveTrain;
  private final ShootyThing m_shootyThing;
  double timer;
  public SimpleAutonomousTwo(DriveTrain subsystem, ShootyThing subsystem2) {
    m_driveTrain = subsystem;
    addRequirements(m_driveTrain);
    m_shootyThing = subsystem2;
    addRequirements(m_shootyThing);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    timer++;
    if (timer <= 100){
      m_shootyThing.shooty();
      if(m_shootyThing.getShootyEncoderVel() >= 12000) {
        m_shootyThing.sucky(-1.0);
      }
      
    }
    if (timer >= 100 && timer <=101){
      m_shootyThing.shootyStop();
    }
    if(timer >= 102 && timer <= 152) {
      m_driveTrain.setArcadeDrive(0.4, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveTrain.setArcadeDrive(0, 0);
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer >= 152;
  }
}
