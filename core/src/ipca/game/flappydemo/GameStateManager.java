package ipca.game.flappydemo;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by lourencogomes on 27/11/17.
 */

public class GameStateManager {

    private Stack<State> states;

    public GameStateManager(){
        states=new Stack<State>();
    }

    public void push(State state){
        states.push(state);
    }

    public void pop(){
        states.pop();
    }

    public void setState(State state){
        states.pop();
        states.push(state);
    }

    public void upate(float dt){
        states.peek().update(dt);
    }

    public  void render(SpriteBatch sb){
        states.peek().render(sb);
    }
}
