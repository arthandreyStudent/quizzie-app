package com.csit228.quizzie.util;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Animator {

    public static void playEntryAnimation(Node node, double ms) {
        node.setOpacity(0);

        FadeTransition fade = new FadeTransition(Duration.millis(ms), node);
        fade.setToValue(1);
        fade.play();
    }
}
