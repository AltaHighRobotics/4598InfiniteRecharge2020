/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
public class LiftyThing extends SubsystemBase {
  private CANSparkMax leftMotor;
  // private CANSparkMax rightMotor;
  //Right motor is commented out because it's broken. 
  private CANEncoder rightEncoder;
  private CANEncoder leftEncoder;
  private Solenoid clawOne;
  private Solenoid clawTwo;
  private Solenoid liftStopPiston;
  
  private boolean clawOneOn = false;
  private boolean clawTwoOn = false;
  private boolean liftStopPistonOn = false;



    public LiftyThing() {
      leftMotor = new CANSparkMax(Constants.Lifty.motor1, MotorType.kBrushless);
      // rightMotor = new CANSparkMax(Constants.Lifty.motor2, MotorType.kBrushless);
      // rightMotor.clearFaults();
      leftMotor.clearFaults();
      // rightEncoder = rightMotor.getEncoder();
      leftEncoder = leftMotor.getEncoder();
      // rightMotor.setOpenLoopRampRate(2);
      leftMotor.setOpenLoopRampRate(2);
      leftMotor.setClosedLoopRampRate(2);
      // rightMotor.setSoftLimit(SoftLimitDirection.kForward, (float)44.047149658);
      // rightMotor.setSoftLimit(SoftLimitDirection.kReverse, 0);
      leftMotor.setSoftLimit(SoftLimitDirection.kForward, (float)44.047149658);
      leftMotor.setSoftLimit(SoftLimitDirection.kReverse, 0);
      //this is so I wouldn't have to set both to the same value
      clawOne = new Solenoid(Constants.pcmChannel, Constants.Lifty.clawOne);
      clawTwo = new Solenoid(Constants.pcmChannel, Constants.Lifty.clawTwo);
      liftStopPiston = new Solenoid(Constants.pcmChannel,Constants.Lifty.liftStopPiston);
      
      liftStopPiston.set(true);
      clawOne.set(false);
      clawTwo.set(false);
      
  }
  public void rightArmUp(){
    System.out.println(rightEncoder.getPosition());
    System.out.println("Is left following?: " + leftMotor.isFollower());
    //44.047149658
    // rightMotor.set(0.65);
  }
  public void rightArmDown(){
    System.out.println(rightEncoder.getPosition());
    // rightMotor.set(-0.65);
  }
  public void leftArmUp(){
    // System.out.println("Is right following?: " + rightMotor.isFollower());
    leftMotor.set(0.65);
  }
  public void leftArmDown(){
    leftMotor.set(-0.65);
  }
  public void clawOneSolenoidOn() {
    System.out.println("changed claw solenoid state");
    clawOneOn = !clawOneOn;
    clawOne.set(clawOneOn);
  }

  public void clawTwoSolenoidOn(){
    clawTwoOn = !clawTwoOn;
    clawTwo.set(clawTwoOn);
  }

  public void setLiftStopPiston() {
    liftStopPistonOn = !liftStopPistonOn;
    liftStopPiston.set(liftStopPistonOn);
  }
  public void rightStopLift(){
    // rightMotor.stopMotor();
  }
  public void leftStopLift(){
    leftMotor.stopMotor();
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
