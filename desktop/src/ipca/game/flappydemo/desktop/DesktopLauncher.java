package ipca.game.flappydemo.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ipca.game.flappydemo.FlappyDemoGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=FlappyDemoGame.WIDTH;
		config.height=FlappyDemoGame.HEIGHT;
		config.title="FlappyBird";
		new LwjglApplication(new FlappyDemoGame(), config);
	}
}
