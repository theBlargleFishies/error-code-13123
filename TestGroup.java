// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TestGroup extends SequentialCommandGroup {
  /** Creates a new TestGroup. */
  double s;
  DriveTrain dTrain;

  public TestGroup(DriveTrain dt, double speed) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    dTrain = dt;
    s = speed;
    
    addCommands(new SetDrive(dt, speed),new AutoDrive(dt, speed));
    
  }
}
