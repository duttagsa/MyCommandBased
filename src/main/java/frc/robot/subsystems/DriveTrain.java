package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Timer;

public class DriveTrain extends SubsystemBase {

    public static DriveTrain instance;
    public static TalonSRX leftFront, leftBack, rightFront, rightBack;
    
    public DriveTrain(){ //device num
        leftFront = new TalonSRX(frc.robot.Constants.DT_LEFT_FRONT);
        leftBack = new TalonSRX(frc.robot.Constants.DT_LEFT_BACK);
        rightFront = new TalonSRX(frc.robot.Constants.DT_RIGHT_FRONT);
        rightBack = new TalonSRX(frc.robot.Constants.DT_RIGHT_BACK);
        }

    public static void setPow(double leftP, double rightP){ // set powers, drive function
        leftFront.set(ControlMode.PercentOutput, leftP);
        leftBack.set(ControlMode.PercentOutput, leftP);
        rightFront.set(ControlMode.PercentOutput, rightP);
        rightBack.set(ControlMode.PercentOutput, rightP);
    }

    public static void Stop(){ // stop
        setPow(0, 0);
    }

    public static void Tank(double leftP, double rightP){ //tank drive
        if(Math.abs(leftP) > 0.02 || Math.abs(rightP) > 0.02){
            setPow(leftP, rightP);
        }
    }


    public void ArcadeDrive(double leftStickY, double rightStickX)
    // Use     
    {
        double leftPower = leftStickY;
        double rightPower = leftStickY;

        if(rightStickX > 0)
        {
            leftPower += Math.abs(rightStickX); // times stick sensitivity
        }
        else
        {
            rightPower += Math.abs(rightStickX);
        }
        
        rightPower -= leftPower % 100;
        leftPower -= rightPower % 100;

        setPow(leftPower, rightPower);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // !!!!!!!!! do you put anything in here?
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
