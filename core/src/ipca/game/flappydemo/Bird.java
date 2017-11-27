package ipca.game.flappydemo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by lourencogomes on 27/11/17.
 */

public class Bird {

    public static final int GRAVITY = -15;

    Texture bird;

    Vector3 position;
    Vector3 velocity;

    public Bird(int x, int y){

        bird = new Texture("bird.png");

        position = new Vector3(x,y,0);
        velocity = new Vector3(0,0,0);

    }

    public void update(float dt){
        if (position.y > 0)
            velocity.add(0, GRAVITY, 0);
        velocity.scl(dt);
        position.add(0, velocity.y,0);
        if (position.y<0)
            position.y=0;
        velocity.scl(1/dt);

    }

    public Texture getBird() {
        return bird;
    }

    public Vector3 getPosition() {
        return position;
    }

    public void dispose(){
        bird.dispose();
    }

    public void jump(){
        velocity.y=250;
    }
}
