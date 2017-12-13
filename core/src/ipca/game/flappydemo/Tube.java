package ipca.game.flappydemo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by lourencogomes on 28/11/17.
 */

public class Tube {

    public static final int TUBE_WIDTH = 50;
    private static final int TUBE_GAP = 100;
    private static final int TUBE_OPENING = 120;
    private static final int TUBE_FLUTUATION = 100;

    private Texture topTube, bottomTube;

    private Vector2 posTopTube, posBotTube;
    private Random rand;

    public Tube (float x){
        topTube = new Texture("toptube.png");
        bottomTube = new Texture("bottomtube.png");
        rand  = new Random();

        posTopTube = new Vector2(x, rand.nextInt(TUBE_FLUTUATION) + TUBE_OPENING + TUBE_GAP);
        posBotTube  = new Vector2(x, posTopTube.y - TUBE_GAP - topTube.getHeight());
    }


    public Texture getTopTube() {
        return topTube;
    }

    public void setTopTube(Texture topTube) {
        this.topTube = topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public void setBottomTube(Texture bottomTube) {
        this.bottomTube = bottomTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public void setPosTopTube(Vector2 posTopTube) {
        this.posTopTube = posTopTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }

    public void setPosBotTube(Vector2 posBotTube) {
        this.posBotTube = posBotTube;
    }

    public void repsotion (float x){
        posTopTube.set(x, rand.nextInt(TUBE_FLUTUATION) + TUBE_OPENING + TUBE_GAP);
        posBotTube.set(x, posTopTube.y - TUBE_GAP - topTube.getHeight());
    }


}
