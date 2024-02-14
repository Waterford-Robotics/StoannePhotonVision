package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;

public class DriveArcadeStyle extends Command{
    
    private DriveTrain m_drivetrain;
    private DoubleSupplier m_forwardSpeedSupplier;
    private DoubleSupplier m_turnSpeedSupplier;

    public DriveArcadeStyle(DriveTrain drivetrain, DoubleSupplier forwardSpeedSupplier, DoubleSupplier turnSpeedSupplier){
        addRequirements(drivetrain);
        m_drivetrain = drivetrain;
        m_forwardSpeedSupplier = forwardSpeedSupplier;
        m_turnSpeedSupplier = turnSpeedSupplier;
    }

    @Override
    public void initialize(){}

    @Override
    public void execute(){
        m_drivetrain.drive(m_forwardSpeedSupplier.getAsDouble(), m_turnSpeedSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted){
        m_drivetrain.stop();
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
