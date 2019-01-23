package net.camfeezel.ftc;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "PlsBuyMeADrPepperKaitlin")
public class PlsBuyMeADrPepperKaitlin extends LinearOpMode {

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
        telemetry.addLine("FIXED by Brig. You're welcome :)");
        telemetry.update();
        waitForStart();

        if(lift == null) {
            telemetry.addLine("You forgot to plug it in dumbass");
            return;
        }
        lift.setPower(0.3);
        sleep(10000);
        lift.setPower(0);
        sleep(200);
        left.setPower(0.2);
        right.setPower(-0.2);
        sleep(2000);
        left.setPower(-0.3);
        right.setPower(-0.3);
        sleep(3000);
        left.setPower(0);
        right.setPower(0);

    }
}
