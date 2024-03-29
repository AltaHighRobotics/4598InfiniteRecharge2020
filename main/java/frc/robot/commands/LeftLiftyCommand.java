/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LiftyThing;

public class LeftLiftyCommand extends CommandBase {
  /**
   * Creates a new LiftyCommand.
   */
  private final LiftyThing m_liftyThing;
  private final String upDown;
  public LeftLiftyCommand(LiftyThing subsystem, String updown) {
    m_liftyThing = subsystem;
    upDown = updown;
    addRequirements(m_liftyThing);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("Lift Command running");
    
    if (upDown == "up"){
      m_liftyThing.leftArmUp();
    }
    if (upDown == "down"){
      m_liftyThing.leftArmDown();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("COMMAND STOPPED");
    m_liftyThing.leftStopLift();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
