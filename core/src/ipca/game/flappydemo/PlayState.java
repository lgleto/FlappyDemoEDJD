package ipca.game.flappydemo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Gdx2DPixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;


/**
 * Created by lourencogomes on 27/11/17.
 */

public class PlayState extends State {

    private static final int TUBE_SPACING = 125;
    private static final int TUBE_COUNT = 4;

    Bird bird;

    Texture background;

    Array <Tube> tubes;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, FlappyDemoGame.WIDTH/2, FlappyDemoGame.HEIGHT/2);
        background = new Texture("bg_sky_1.png");

        bird = new Bird(50,300);
        tubes=new Array<Tube>();
        for (int i=0; i <= TUBE_COUNT; i++){
            tubes.add(new Tube(i * (TUBE_SPACING + Tube.TUBE_WIDTH)));
        }


    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            bird.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();

        bird.update(dt);
        cam.position.set(bird.getPosition().x + 80, cam.viewportHeight / 2, 0);
        for (Tube tube: tubes){
            if (cam.position.x - cam.viewportWidth/2 > tube.getPosBotTube().x + tube.getTopTube().getWidth())
                tube.repsotion(tube.getPosTopTube().x+(Tube.TUBE_WIDTH + TUBE_SPACING)*TUBE_COUNT);
        }

        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        //sb.draw(background,0,0,FlappyDemoGame.WIDTH,FlappyDemoGame.HEIGHT);
        sb.draw(background,cam.position.x - (cam.viewportWidth/2), 0);
        for(Tube tube : tubes){
            sb.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
            sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
        }
        sb.draw(bird.getBird(), bird.getPosition().x, bird.getPosition().y);
        sb.end();

    }

    @Override
    public void dispose() {
        bird.dispose();
    }
}
