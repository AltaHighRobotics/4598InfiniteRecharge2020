/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShootyThing;

public class SpinnyCommand extends CommandBase {
  /**
   * Creates a new SpinnyCommand.
   */
  public final ShootyThing m_shootyThing;
  public final String leftRight;
  public SpinnyCommand(ShootyThing subsystem, String leftright) {
    m_shootyThing = subsystem;
    leftRight = leftright;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_shootyThing);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shootyThing.spinny(leftRight);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shootyThing.stopSpinnyMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
