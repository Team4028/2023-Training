// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Turret extends SubsystemBase {
  private WPI_TalonSRX m_turretMotor;

  private static Turret m_instance;

  /** Creates a new Turret. */
  public Turret() {
    m_turretMotor = new WPI_TalonSRX(4);
  }

  public void runTurret(double vbus) {
    m_turretMotor.set(vbus);
  }

  public void stopTurret() {
    m_turretMotor.stopMotor();
  }

  public static Turret getInstance() {
    if (m_instance == null) {
      m_instance = new Turret();
    }
    return m_instance;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
