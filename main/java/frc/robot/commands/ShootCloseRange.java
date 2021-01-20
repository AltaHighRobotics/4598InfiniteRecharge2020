/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShootyThing;

public class ShootCloseRange extends CommandBase {
  /**
   * Creates a new ShootCloseRange.
   */
  public final ShootyThing m_shootyThing;
  private final XboxController m_xbox;
  public ShootCloseRange(ShootyThing subsystem, XboxController xbox) {
    m_shootyThing = subsystem;
    m_xbox = xbox;
    addRequirements(m_shootyThing);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double triggerAxisLeft = m_xbox.getRawAxis(2);
    if(triggerAxisLeft >= 0.05) {
      m_shootyThing.sucky(-triggerAxisLeft);
    } else {
      m_shootyThing.sucky(0.0);
    }
    // m_shootyThing.shooty();
    m_shootyThing.setShootyCloseRangeVelocity();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shootyThing.shootyStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
