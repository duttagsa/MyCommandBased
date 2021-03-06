// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
     // DriveTrain
     
    // device numbers? 
    public static final int DT_LEFT_FRONT = 13;
    public static final int DT_LEFT_BACK = 15; 
    public static final int DT_RIGHT_FRONT = 2;
    public static final int DT_RIGHT_BACK = 20;

    //Ingestor
	public static final int INGESTOR_TALON_CARGO = 10;
	public static final int INGESTOR_TALON_BELT = 11;

    public static final double INGESTOR_BELT_POWER = -1;
    
    //Shooter
    public static final int S_POW = 10;

    // Stick Sensitivity
    public static final double SENSITIVITY = 0.4;


}
