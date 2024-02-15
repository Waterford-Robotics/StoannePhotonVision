package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;

public class DriveArcadeStyle extends Command{
    
    private DriveTrain m_drivetrain;
    private DoubleSupplier m_forwardSpeedSupplier;
    private DoubleSupplier m_turnSpeedSupplier;

    // Declaring your drive train
    public DriveArcadeStyle(DriveTrain drivetrain, DoubleSupplier forwardSpeedSupplier, DoubleSupplier turnSpeedSupplier){
        addRequirements(drivetrain);
        m_drivetrain = drivetrain;
        m_forwardSpeedSupplier = forwardSpeedSupplier;
        m_turnSpeedSupplier = turnSpeedSupplier;
    }

    // Initializing the method
    @Override
    public void initialize(){}

    // Executing code to make drive train move
    @Override
    public void execute(){
        m_drivetrain.drive(m_forwardSpeedSupplier.getAsDouble(), m_turnSpeedSupplier.getAsDouble());
    }

    // Stop driving when input is interrupted
    @Override
    public void end(boolean interrupted){
        m_drivetrain.stop();
    }

    // Determines when drive code is finished
    @Override
    public boolean isFinished(){
        return false;
    }
}
