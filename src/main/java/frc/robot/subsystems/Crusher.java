// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CrusherConstants;

// Indexer - Y
// Crush Cylinder A
// denting cylinder B
// Eject X

// PCM CANID = 25
// PDP CANID = 10
// head motor CANID = 20

public class Crusher extends SubsystemBase {
    /** Creates a new Crusher. */

    DoubleSolenoid indexer = new DoubleSolenoid(
            CrusherConstants.kDoubleSolenoidModuleID, PneumaticsModuleType.CTREPCM,
            CrusherConstants.kIndexerFowardChannel, CrusherConstants.kIndexerReverseChannel);
    DoubleSolenoid crush = new DoubleSolenoid(
            CrusherConstants.kDoubleSolenoidModuleID, PneumaticsModuleType.CTREPCM,
            CrusherConstants.kCrushFowardChannel, CrusherConstants.kCrushReverseChannel);
    DoubleSolenoid dent = new DoubleSolenoid(
            CrusherConstants.kDoubleSolenoidModuleID, PneumaticsModuleType.CTREPCM, CrusherConstants.kDentFowardChannel,
            CrusherConstants.kDentReverseChannel);
    DoubleSolenoid eject = new DoubleSolenoid(
            CrusherConstants.kDoubleSolenoidModuleID, PneumaticsModuleType.CTREPCM,
            CrusherConstants.kEjectFowardChannel, CrusherConstants.kEjectReverseChannel);

    private enum RobotState {
        STARTUP1,
        STARTUP2,
        LOADING,
        INDEX,
        DENTING,
        READYTOCRUSH,
        CRUSH,
        UNCRUSH,
        EJECT,
        UNEJECT
    }

    private RobotState currentState = RobotState.STARTUP1;
    private Timer stateTimer = new Timer();

    public Crusher() {
        ShuffleboardTab crushTab = Shuffleboard.getTab("Crusher");
        crushTab.addString("State Machine", () -> currentState.toString());
        crushTab.addDouble("State Timer", () -> stateTimer.get());
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

        if (DriverStation.isTeleopEnabled()) {
            switch (currentState) {
                case STARTUP1:
                    goToState(RobotState.STARTUP2, 0);

                case STARTUP2:
                    indexer.set(DoubleSolenoid.Value.kOff);
                    dent.set(DoubleSolenoid.Value.kReverse);
                    crush.set(DoubleSolenoid.Value.kReverse);
                    eject.set(DoubleSolenoid.Value.kReverse);

                    goToState(RobotState.LOADING, 3);
                    break;

                case LOADING:
                    indexer.set(DoubleSolenoid.Value.kForward);
                    dent.set(DoubleSolenoid.Value.kReverse);
                    crush.set(DoubleSolenoid.Value.kReverse);
                    eject.set(DoubleSolenoid.Value.kReverse);

                    break;

                case INDEX:
                    indexer.set(DoubleSolenoid.Value.kReverse);
                    dent.set(DoubleSolenoid.Value.kReverse);
                    crush.set(DoubleSolenoid.Value.kReverse);
                    eject.set(DoubleSolenoid.Value.kReverse);

                    goToState(RobotState.DENTING, 3);
                    break;
                case DENTING:
                    indexer.set(DoubleSolenoid.Value.kReverse);
                    dent.set(DoubleSolenoid.Value.kForward);
                    crush.set(DoubleSolenoid.Value.kReverse);
                    eject.set(DoubleSolenoid.Value.kReverse);

                    goToState(RobotState.READYTOCRUSH, 3);
                    break;

                case READYTOCRUSH:
                    indexer.set(DoubleSolenoid.Value.kReverse);
                    dent.set(DoubleSolenoid.Value.kReverse);
                    crush.set(DoubleSolenoid.Value.kReverse);
                    eject.set(DoubleSolenoid.Value.kReverse);

                    break;

                case CRUSH:
                    indexer.set(DoubleSolenoid.Value.kReverse);
                    dent.set(DoubleSolenoid.Value.kReverse);
                    crush.set(DoubleSolenoid.Value.kForward);
                    eject.set(DoubleSolenoid.Value.kReverse);

                    goToState(RobotState.UNCRUSH, 5);
                    break;

                case UNCRUSH:
                    indexer.set(DoubleSolenoid.Value.kReverse);
                    dent.set(DoubleSolenoid.Value.kReverse);
                    crush.set(DoubleSolenoid.Value.kReverse);
                    eject.set(DoubleSolenoid.Value.kReverse);

                    break;

                case EJECT:
                    indexer.set(DoubleSolenoid.Value.kReverse);
                    dent.set(DoubleSolenoid.Value.kReverse);
                    crush.set(DoubleSolenoid.Value.kReverse);
                    eject.set(DoubleSolenoid.Value.kForward);

                    goToState(RobotState.UNEJECT, 3);
                    break;

                case UNEJECT:
                    indexer.set(DoubleSolenoid.Value.kReverse);
                    dent.set(DoubleSolenoid.Value.kReverse);
                    crush.set(DoubleSolenoid.Value.kReverse);
                    eject.set(DoubleSolenoid.Value.kReverse);

                    break;

            }
        }

    }

    void goToState(RobotState nextState, double time) {
        if (stateTimer.get() >= time) {
            currentState = nextState;
            stateTimer.reset();
            stateTimer.start();
        }

    }

    public void advanceState() {
        switch (currentState) {
            case LOADING:
                goToState(RobotState.INDEX, 1);
                break;

            case READYTOCRUSH:
                goToState(RobotState.CRUSH, 1);
                break;

            case UNCRUSH:
                goToState(RobotState.EJECT, 1);
                break;

            case UNEJECT:
                goToState(RobotState.LOADING, 1);
                break;

            default:

        }
    }

    public void reverseState() {
        switch (currentState) {
            case UNEJECT:
                goToState(RobotState.UNCRUSH, 1);
                break;

            case UNCRUSH:
                goToState(RobotState.READYTOCRUSH, 1);
                break;

            case READYTOCRUSH:
                goToState(RobotState.LOADING, 1);
                break;

            case LOADING:
                goToState(RobotState.UNEJECT, 1);
                break;

            default:

        }
    }
}
