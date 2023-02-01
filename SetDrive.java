// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class SetDrive extends CommandBase {
  /** Creates a new SetDrive. */
  DriveTrain aTrain;
  private boolean finished = false;
  Timer timer;
  double s;
  public SetDrive(DriveTrain d, double speed) {
    aTrain = d;
    s = speed;
    addRequirements(aTrain);
    timer = new Timer();
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    while(timer.get() < 3) {
      aTrain.setdrive(-s);
    }
  timer.reset();
  timer.start();
  while(timer.get() < 3) {
    aTrain.setdrive(s);
  }
  timer.reset();
  timer.start();
  while(timer.get() < 3) {
    aTrain.setturn(-s, s);
  }
  timer.reset();
  timer.start();
  while(timer.get() < 3) {
    aTrain.setturn(s, -s);
  }
  finished = true;
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    aTrain.drivestop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
