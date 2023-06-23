package com.WorkshopJava.app;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class AnimationComponent extends Component {

    private float speed = 0.0f;

    private AnimatedTexture texture;
    private AnimationChannel animIdle;
    private AnimationChannel animWalk;
    public AnimationComponent(String file, int frames, int width, int height, float speed) {
        animIdle = new AnimationChannel(FXGL.image(file), frames, width, height, Duration.seconds(speed), 0, 3);
        animWalk = new AnimationChannel(FXGL.image(file), frames, width, height, Duration.seconds(speed), 4, 7);

        texture = new AnimatedTexture(animIdle);
        texture.loopAnimationChannel(animIdle);
    }

    @Override
    public void onAdded() {
        entity.getViewComponent().addChild(texture);
    }

    @Override
    public void onUpdate(double tpf) {
        if (speed != 0) {
            speed = 0;
            if (texture.getAnimationChannel() != animWalk) {
                texture.loopAnimationChannel(animWalk);
            }
        } else {
            if (texture.getAnimationChannel() != animIdle) {
                texture.loopAnimationChannel(animIdle);
            }
        }
    }

    public void move() {
        speed = 1;
    }

}
