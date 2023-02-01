// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoDrive extends CommandBase {
  /** Creates a new AutoDrive. */
  DriveTrain aTrain;
  private boolean finished = false;
  private static  double leftdistance; 
  private double rightdistance;
  
  double s;
  public AutoDrive(DriveTrain d, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    aTrain = d;
    s = speed;
    addRequirements(aTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   aTrain.encoderreset();
   leftdistance = 0;
   rightdistance = 0;

    while (leftdistance < 207 && rightdistance < 207){
        leftdistance = Math.abs(DriveTrain.getleftdistance());
        rightdistance = Math.abs(DriveTrain.getrightdistance());
        aTrain.setdrive(s);
    } 
    finished = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}

