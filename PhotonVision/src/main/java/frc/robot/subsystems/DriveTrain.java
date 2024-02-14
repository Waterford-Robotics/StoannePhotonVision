package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class DriveTrain extends SubsystemBase{
    
    private static final int kLeft1MotorId = 1;
    private static final int kLeft2MotorId = 7;
    private static final int kRight1MotorId = 6;
    private static final int kRight2MotorId = 23;

    private WPI_TalonSRX m_left1Motor = new WPI_TalonSRX(kLeft1MotorId);
    private WPI_TalonSRX m_left2Motor = new WPI_TalonSRX(kLeft2MotorId);
    private WPI_TalonSRX m_right1Motor = new WPI_TalonSRX(kRight1MotorId);
    private WPI_TalonSRX m_right2Motor = new WPI_TalonSRX(kRight2MotorId);

    private DifferentialDrive m_differentialDrive = new DifferentialDrive(m_left1Motor::set, m_right1Motor::set);

    public void DriveSubsystem() {
        m_left2Motor.follow(m_left1Motor);
        m_right2Motor.follow(m_right1Motor);

        m_right1Motor.setInverted(true);
    }

    @Override
    public void periodic(){}

    public void drive(double forwardSpeed, double turnSpeed){
        m_differentialDrive.arcadeDrive(forwardSpeed, turnSpeed);
    }

    public void drive(double forwardSpeed, double turnSpeed, boolean squareInputs){
        m_differentialDrive.arcadeDrive(forwardSpeed, turnSpeed, squareInputs);
    }

    public void stop(){}
}
