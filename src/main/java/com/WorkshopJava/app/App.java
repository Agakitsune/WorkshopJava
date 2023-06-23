package com.WorkshopJava.app;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class App extends GameApplication {
    public Entity player;
    public Entity enemy;

    public UserAction up;
    public UserAction left;
    public UserAction right;
    public UserAction down;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initSettings(GameSettings settings) {
        settings.setTitle("Basalt");
        settings.setWidth(800);
        settings.setHeight(600);
        settings.setManualResizeEnabled(false);
        settings.setFullScreenAllowed(false);
        settings.setFullScreenFromStart(false);

        up = new UserAction("Up") {
            @Override
            protected void onAction() {
                Point2D pos = player.getPosition();
                pos = pos.add(0, -1);
                player.setPosition(pos);
                player.getComponent()
            }

            @Override
            protected void onActionBegin() {
                Point2D pos = player.getPosition();
                pos = pos.add(0, -1);
                player.setPosition(pos);
            }
        };

        left = new UserAction("Left") {
            @Override
            protected void onAction() {
                Point2D pos = player.getPosition();
                pos = pos.add(-1, 0);
                player.setPosition(pos);
            }

            @Override
            protected void onActionBegin() {
                Point2D pos = player.getPosition();
                pos = pos.add(-1, 0);
                player.setPosition(pos);
            }
        };

        right = new UserAction("Right") {
            @Override
            protected void onAction() {
                Point2D pos = player.getPosition();
                pos = pos.add(1, 0);
                player.setPosition(pos);
            }

            @Override
            protected void onActionBegin() {
                Point2D pos = player.getPosition();
                pos = pos.add(0, -1);
                player.setPosition(pos);
            }
        };

        down = new UserAction("Down") {
            @Override
            protected void onAction() {
                Point2D pos = player.getPosition();
                pos = pos.add(0, 1);
                player.setPosition(pos);
            }

            @Override
            protected void onActionBegin() {
                Point2D pos = player.getPosition();
                pos = pos.add(0, 1);
                player.setPosition(pos);
            }
        };
    }

    @Override
    public void initGame() {
        player = FXGL.entityBuilder()
                .type(EntityType.PLAYER)
                .with(new CollidableComponent(true))
                .with(new AnimationComponent("hunter.png", 4, 16, 24, 1.5f))
                .scale(2.0, 2.0)
                .at(0, 0)
                .buildAndAttach();

        FXGL.getGameWorld().addEntityFactory(new Factory());

        enemy = FXGL.spawn("enemy", 20, 20);
    }

    @Override
    public void initInput() {
        Input input = FXGL.getInput();

        FXGL.onKeyDown(KeyCode.K, () -> {
            FXGL.inc("pixelsMoved", 1);
        });

        if (input != null) {
            input.addAction(up, KeyCode.Z);
            input.addAction(down, KeyCode.S);
            input.addAction(left, KeyCode.Q);
            input.addAction(right, KeyCode.D);
        }
    }

    @Override
    public void initUI() {
        Text txt = new Text("Wouaou");
        txt.setTranslateX(50);
        txt.setTranslateY(50);
        Text pix = new Text();
        pix.setTranslateY(70);
        pix.setTranslateX(50);
        pix.textProperty().bind(FXGL.getWorldProperties().intProperty("pixelsMoved").asString());
        FXGL.getGameScene().addUINode(txt);
        FXGL.getGameScene().addUINode(pix);
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("pixelsMoved", 0);
    }

    @Override
    public void initPhysics() {
        FXGL.onCollisionBegin(EntityType.PLAYER, EntityType.ENEMY, (player, enemy) -> {
            System.out.println("U R DED");
        });
    }
}
