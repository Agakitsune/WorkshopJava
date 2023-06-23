package com.WorkshopJava.app;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Factory implements EntityFactory {

    @Spawns("enemy")
    public Entity newEnemy(SpawnData data) {
        Entity enemy = FXGL.entityBuilder(data)
                .type(EntityType.ENEMY)
                .with(new CollidableComponent(true))
                .viewWithBBox(new Rectangle(25, 25, Color.RED))
                .build();
        return enemy;
    }
}
