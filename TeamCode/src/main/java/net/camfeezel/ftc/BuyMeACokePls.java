package net.camfeezel.ftc;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "BuyMeACokePls")
public class BuyMeACokePls extends LinearOpMode {

    private DcMotor left,right,lift;

    @Override
    public void runOpMode() {
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");
        try {
            lift = hardwareMap.dcMotor.get("lift");
        } catch (Exception exc) {
            telemetry.addLine("-- No Lift Motor --");
        }
        telemetry.addLine("Made by 8497 because 7601 can't make their own code.");
        telemetry.update();
        waitForStart();
        while(opModeIsActive()) {
            float ly = gamepad1.left_stick_y;
            float lx = gamepad1.left_stick_x;
            if(Math.abs(ly) > 0.1f) {
                left.setPower(ly*ly*ly);
                right.setPower(ly*ly*ly);
            } else if(Math.abs(lx) > 0.1f) {
                left.setPower(-lx);
                right.setPower(lx);
            }
            if(lift != null) {
                if(gamepad1.y) {
                    lift.setPower(0.2f);
                } else if(gamepad1.a) {
                    lift.setPower(-0.2f);
                }
            }
        }
    }
}
