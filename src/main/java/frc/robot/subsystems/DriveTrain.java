package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Timer;

public class DriveTrain extends SubsystemBase {
    public static DriveTrain instance;
    public static TalonSRX leftFront, leftBack, rightFront, rightBack;

    public static DriveTrain getInstance(){ // check to see if drivetrain instance exists
        if (instance == null){
            instance = new DriveTrain();
        }

        return instance;
    }

    public DriveTrain(){ //device num
        leftFront = new TalonSRX(Constants.DT_LEFT_FRONT);
        leftBack = new TalonSRX(Constants.DT_LEFT_BACK);
        rightFront = new TalonSRX(Constants.DT_RIGHT_FRONT);
        rightBack = new TalonSRX(Constants.DT_RIGHT_BACK);
    }

    public static void SetPowers(double leftP, double rightP){ // set powers, drive function
        leftFront.set(ControlMode.PercentOutput, leftP);
        leftBack.set(ControlMode.PercentOutput, leftP);
        rightFront.set(ControlMode.PercentOutput, rightP);
        rightBack.set(ControlMode.PercentOutput, rightP);
    }

    public static void Stop(){ // stop
         SetPowers(0, 0);
    }

    public static void Tank(double leftP, double rightP){ //tank drive
        if(Math.abs(leftP) > 0.02 || Math.abs(rightP) > 0.02){
            SetPowers(leftP, rightP);
        }
    }

    public void ArcadeDrive(double leftStickY, double rightStickX)
    // Use
    {
        double leftPower = leftStickY;
        double rightPower = leftStickY;

        if(rightStickX > 0)
        {
            leftPower += Math.pow(Math.abs(rightStickX), 2) * Constants.SENSITIVITY;
        }
        else
        {
            rightPower += Math.pow(Math.abs(rightStickX), 2) * Constants.SENSITIVITY;
        }

        rightPower -= leftPower % 100;
        leftPower -= rightPower % 100;

        SetPowers(leftPower, rightPower);
    }

    @Override
    public void periodic() { }

    @Override
    public void simulationPeriodic() 
    { 
        /* Simulations are for those who fear mechanical! Don't fear mechanical. */ 
    }
}