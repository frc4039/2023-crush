// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static class DriverConstants {
        public static final int kDriverControllerPort = 0;
    }

    public static class DriveTrainConstants {
        public static final int kLeftDriveMotorDeviceID = 1;
        public static final int kRightDriveMotorDeviceID = 2;
        public static final double kOpenLoopRampRate = 0.3;
    }

    public static class HeadConstants {
        public static final int kHeadMotorDeviceID = 20;
        public static final double kCWSpeed = 0.5;
        public static final double kCCWSpeed = -0.5;
    }

    public static class CrusherConstants {
        public static final int kDoubleSolenoidModuleID = 25;
        public static final int kIndexerFowardChannel = 0;
        public static final int kIndexerReverseChannel = 1;
        public static final int kCrushFowardChannel = 2;
        public static final int kCrushReverseChannel = 3;
        public static final int kDentFowardChannel = 4;
        public static final int kDentReverseChannel = 5;
        public static final int kEjectFowardChannel = 6;
        public static final int kEjectReverseChannel = 7;
    }
}
