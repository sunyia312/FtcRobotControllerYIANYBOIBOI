package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.concurrent.TimeUnit;

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

    public void forward() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        myMotor.setDirection(DcMotor.Direction.FORWARD);
        myMotor.setPower(0.5);
        boolean keep = true;
        while (keep) {
            if (Math.random() < 0.1) {
                keep = false;
            }
            try {
                Thread.sleep(500); // Pause for 5 seconds (5000 milliseconds)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore the interrupted status
                System.out.println("Thread was interrupted while sleeping.");
            }
        }
        myMotor.setPower(0.0);
    }

}


