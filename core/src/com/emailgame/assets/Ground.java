package com.emailgame.assets;//package com.mygdx.game.assets;
//
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.mygdx.assets.Assets;
//import com.mygdx.game.AbstractGameObject;
//
///**
// * Created by Ian on 2/5/2015.
// */
//
//public class Ground extends AbstractGameObject {
//    private TextureRegion regEdge;
//    private TextureRegion regMiddle;
//    private int length;
//
//
//
//    public Ground () {
//        loadAssets();
//    }
//
//
//
//    private void loadAssets () {
//        dimension.set(1, 1.5f);
//        regEdge = Assets.instance.groundTwo.edge;
//        regMiddle = Assets.instance.groundTwo.middle;
//        // Start length of this rock
//        setLength(1);
//    }
//    public void setLength (int length) {
//        this.length = length;
//    }
//    public void increaseLength (int amount) {
//        setLength(length + amount);
//    }
//
//
//
//
//    @Override
//    public void render(SpriteBatch batch) {
//
//        TextureRegion reg = null;
//
//        float relX = 0;
//        float relY = 0;
//
//        // Draw left edge
//        reg = regEdge;
//        relX -= dimension.x / 4;
//        batch.draw(reg.getTexture(),
//                position.x + relX, position.y + relY,
//                origin.x, origin.y,
//                dimension.x / 4, dimension.y,
//                scale.x, scale.y,
//                rotation,
//                reg.getRegionX(), reg.getRegionY(),
//                reg.getRegionWidth(), reg.getRegionHeight(),
//                false, false);
//
//        // Draw middle
//        relX = 0;
//        reg = regMiddle;
//        for (int i = 0; i < length; i++) {
//            batch.draw(reg.getTexture(),
//                    position.x + relX, position.y + relY,
//                    origin.x, origin.y,
//                    dimension.x, dimension.y,
//                    scale.x, scale.y,
//                    rotation,
//                    reg.getRegionX(), reg.getRegionY(),
//                    reg.getRegionWidth(), reg.getRegionHeight(),
//                    false, false);
//            relX += dimension.x;
//        }
//
//        // Draw right edge
//        reg = regEdge;
//        batch.draw(reg.getTexture(),
//                position.x + relX, position.y + relY,
//                origin.x + dimension.x / 8, origin.y,
//                dimension.x / 4, dimension.y,
//                scale.x, scale.y,
//                rotation,
//                reg.getRegionX(), reg.getRegionY(),
//                reg.getRegionWidth(), reg.getRegionHeight(),
//                true, false);
//        }
//
//    }
//
//
