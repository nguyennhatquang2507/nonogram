package org.example;

import javax.swing.*;
import java.awt.*;

public class NonogramDisplay {

    private final int width;

    private final int height;

    private final int DISTANCE = 100;

    private final NonogramMatrix nonogramMatrix;

    public NonogramDisplay(NonogramMatrix nonogramMatrix) {
        this.nonogramMatrix = nonogramMatrix;
        this.width = nonogramMatrix.getColumn() * DISTANCE;
        this.height = nonogramMatrix.getRow() * DISTANCE;
    }

    public void show() {
        JFrame window = new JFrame();
        // setting closing operation
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setting size of the pop window
        window.setBounds(500, 200,
                width + nonogramMatrix.getColumn() * 10,
                height + nonogramMatrix.getRow() * 10);
        // setting canvas for draw
        window.getContentPane().add(new Grid());
        // set visibility
        window.setVisible(true);
    }

    class Grid extends JComponent {
        public void paint(Graphics graphics) {
            for (NonogramPoint point : nonogramMatrix.getPointList()) {
                if (point.isPoint()) {
                    graphics.setColor(Color.RED);
                    graphics.fill3DRect(point.x * DISTANCE, point.y * DISTANCE, DISTANCE, DISTANCE, true);
                    graphics.setColor(Color.BLUE);
                    graphics.fill3DRect(point.x * DISTANCE + 100, point.y * DISTANCE + 100, DISTANCE, DISTANCE, true);
//                    graphics.fillRect(point.x * DISTANCE, point.y * DISTANCE, DISTANCE, DISTANCE);
                } else {
                    graphics.drawRect(point.x * DISTANCE, point.y * DISTANCE, DISTANCE, DISTANCE);
                }
            }
        }
    }
}
