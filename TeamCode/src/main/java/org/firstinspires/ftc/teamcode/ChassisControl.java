package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.Gamepad;

//import static com.qualcomm.robotcore.hardware.Servo.MIN_POSITION;
import static java.lang.Math.*;

public class ChassisControl 
{

    private DcMotor left;
    private DcMotor right;

    private DcMotor ArmSwing;
    private DcMotor ArmExtend;
    private DcMotor BucketSuck;
    //private Servo BucketSwing;

    private Gamepad gamepad1;
    private Gamepad gamepad2;

    private OpMode opMode;

    public ChassisControl(OpMode opMode) 
    {
        this.opMode = opMode;
    }

    public void init() 
    {
        left = opMode.hardwareMap.dcMotor.get("left");
        right = opMode.hardwareMap.dcMotor.get("right");
        ArmSwing = opMode.hardwareMap.dcMotor.get("Arm Swing");
        ArmExtend = opMode.hardwareMap.dcMotor.get("Arm Extend");
        //BucketSwing = opMode.hardwareMap.servo.get("Bucket Swing");
        BucketSuck = opMode.hardwareMap.dcMotor.get("Bucket Suck");
        gamepad1 = opMode.gamepad1;
        gamepad2 = opMode.gamepad2;
    }

    public void loop() 
    {
        //Left stick y axis, right stick x axis
        float ly = gamepad1.left_stick_y;
        float rx = gamepad1.right_stick_x;

        //Gamepad 2 variables
        boolean dpad_up = gamepad2.dpad_up;
        boolean dpad_down = gamepad2.dpad_down;
        boolean lbump = gamepad2.left_bumper;
        boolean rbump = gamepad2.right_bumper;
        //double position = BucketSwing.getPosition();

        //CHASSIS CONTROL
        if(abs(ly) > 0.05f || abs(rx) > 0.05f)
	    {
            left.setPower(ly + rx);
            right.setPower(ly - rx);
        }
	    else
	    {
            left.setPower(0);
            right.setPower(0);
        }

        //OTHER MECHS CONTROL
        ArmExtend.getCurrentPosition();

        if(dpad_up)
        {
            if(gamepad2.x)
            {
                ArmExtend.setPower(50);
            }
            else
            {
                ArmSwing.setPower(-20);
            }
        }
        else if(dpad_down)
        {
            if(gamepad2.x)
            {

                ArmExtend.setPower(-50);
            }
            else
            {
                ArmSwing.setPower(30);
            }
        }
        else
        {
            ArmSwing.setPower(0);
            ArmExtend.setPower(0);
        }


        if (lbump)
        {
            BucketSuck.setPower(75);
        }
        else if (rbump)
        {
            BucketSuck.setPower(-75);
        }
        else
        {
            BucketSuck.setPower(0);
        }


        // ****test servo positions****

        //float position = BucketSwing.getPosition();

        //MIN_POSITION BucketSwing = (insert here);
        //MAX_POSITION BucketSwing = (insert here);
        //
        /*
        if (gamepad2.y = true)
        {
            BucketSwing.setPosition(position + 5);
            position = BucketSwing.getPosition();
        }
        else if (gamepad2.b = true)
        {
            BucketSwing.setPosition(position - 5);
            position = BucketSwing.getPosition();
        }
        */




    }


}