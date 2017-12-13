package ipca.game.flappydemo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

/**
 * Created by lourencogomes on 27/11/17.
 */

public class MenuState extends State {

    Texture background;
    Texture btn;


    protected MenuState(GameStateManager gsm) {
        super(gsm);

        cam.setToOrtho(false, FlappyDemoGame.WIDTH/2, FlappyDemoGame.HEIGHT/2);
        background = new Texture("bg_sky_1.png");
        btn = new Texture("playbtn.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.setState(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0,0,FlappyDemoGame.WIDTH,FlappyDemoGame.HEIGHT);
        //sb.draw(background,cam.position.x - (cam.viewportWidth/2), 0);
        sb.draw(btn, (FlappyDemoGame.WIDTH/2-btn.getWidth()/2),
            FlappyDemoGame.HEIGHT/2);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        btn.dispose();
    }
}
