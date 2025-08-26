package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class YianCanLearnDidUknow extends OpMode {
    private DcMotor myMotor;
    public void init() {
        myMotor=hardwareMap.get(DcMotor.class, "mototo");
        myMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        myMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void loop() {
        int targetPosition = 1000;
        myMotor.setTargetPosition(targetPosition);
        myMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        myMotor.setPower(1.0);
        while (myMotor.isBusy()) {
            telemetry.addData("Current Position", myMotor.getCurrentPosition());
            telemetry.update();
        }
        myMotor.setPower(0.0);
    }

}


