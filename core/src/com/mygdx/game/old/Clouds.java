package com.mygdx.game.old;

/**
 * Created by Ian on 2/7/2015.
 */
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Assets;
import com.mygdx.game.entities.AbstractDynamicObject;

public class Clouds extends AbstractDynamicObject {

    private float length;

    private Array<TextureRegion> regClouds;
    private Array<Cloud> clouds;

    private class Cloud extends AbstractDynamicObject {
        private TextureRegion regCloud;
        public Cloud (int id) {
            super(id, "cloud");
        }

        public void setRegion (TextureRegion region) {
            regCloud = region;
        }

        @Override
        public void render (SpriteBatch batch) {
            TextureRegion reg = regCloud;
            batch.draw(reg.getTexture(),
                    position.x + origin.x, position.y + origin.y,
                    origin.x, origin.y,
                    dimension.x, dimension.y,
                    scale.x, scale.y,
                    rotation,
                    reg.getRegionX(), reg.getRegionY(),
                    reg.getRegionWidth(), reg.getRegionHeight(),
                    false, false);
        }
    }

    public Clouds (int id, float length) {
        super(id, "cloud");
        this.length = length;
        init();
    }


    private void init () {
        dimension.set(3.0f, 1.5f);
        regClouds = new Array<TextureRegion>();
        regClouds.add(Assets.instance.decoration.cloudOne);
        regClouds.add(Assets.instance.decoration.cloudTwo);

        int distFac = 5;
        int numClouds = (int)(length / distFac);
        clouds = new Array<Cloud>(2 * numClouds);
        for (int i = 0; i < numClouds; i++) {
            Cloud cloud = spawnCloud();
            cloud.position.x = i * distFac;
            clouds.add(cloud);
        }
    }
    private Cloud spawnCloud () {
        Cloud cloud = new Cloud(id);
        cloud.dimension.set(dimension);

        // select random cloud image
        cloud.setRegion(regClouds.random());

        // position
        Vector2 pos = new Vector2();
        pos.x = length + 10; // position after end of level
        pos.y += 1.75; // base position

        // random additional position
        pos.y += MathUtils.random(0.0f, 0.2f)
                * (MathUtils.randomBoolean() ? 1 : -1);
        cloud.position.set(pos);
        return cloud;
    }

    @Override
    public void render (SpriteBatch batch) {
        for (Cloud cloud : clouds)
            cloud.render(batch);
    }
}