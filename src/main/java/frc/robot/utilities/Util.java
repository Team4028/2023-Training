// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.utilities;

import edu.wpi.first.math.util.Units;

/** Useful utility functions for drive. */
public final class Util {
    /**
     * Convert native units of an encoder
     * into a distance in inches travelled
     * by a wheel.
     * 
     * @param nu            Native units to convert.
     * @param cpr           Encoder ticks per motor revolution.
     * @param gearRatio     Motor rotations per gearbox shaft rotation.
     * @param wheelDiameter Diameter of the wheel, in inches.
     * 
     * @return <p>Wheel travel in meters.
     *         </p>
     * 
     *         Example:
     *         TalonSRX reports a velocity of 8192 NU/100ms, with a 10.75:1 gear
     *         ratio, on a 4-inch wheel.
     * 
     *         <pre>
     * {@code
     * double travelMeters = Util.NUtoMeters(8192, 4096, 10.75, 4)
     * }
     * </pre>
     * 
     * <p>- 2 rotations of the motor (8192NU travel / 4096NU CPR)
     * </p>
     * <p>- ~.186 rotations of the wheel (2 motor rotations / 10.75 gear ratio)
     * </p>
     * <p>- ~2.34 in travel (.186 shaft rotations * (PI * 4 in))
     */
    public static double NUtoMeters(double nu, double cpr, double gearRatio, double wheelDiameter) {
        double motorRotations = (double) nu / cpr; // How many rotations of the motor in this amount of NU.
        double wheelRotations = motorRotations / gearRatio; // How many rotations of the gearbox (wheel).
        double positionMeters = wheelRotations * (Math.PI * Units.inchesToMeters(wheelDiameter)); // The distance
                                                                                                  // travelled by the
                                                                                                  // wheel.
        return positionMeters;
    }
}
