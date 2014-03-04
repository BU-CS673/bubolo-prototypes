package bubolotest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * 
 * @author Christopher D. Canfield
 */
public class Application implements ApplicationListener
{
	public static void main(String[] args)
	{
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Drop";
		cfg.width = 800;
		cfg.height = 480;
		cfg.useGL20 = true;
		new LwjglApplication(new Application(), cfg);
	}
	
	public static final float SCREEN_WIDTH = 800;
	public static final float SCREEN_HEIGHT = 600;
	
	private static final int spriteX = 800;
	private static final int spriteY = 550;
	
	private Camera camera;
	private List<CameraController> cameraControllers = new ArrayList<CameraController>();
	
	private SpriteBatch batch;
	
	private Texture image;
	private Texture mapImage;

	@Override
	public void create()
	{
		camera = new OrthographicCamera(SCREEN_WIDTH, SCREEN_HEIGHT);
		cameraControllers.add(new KeyboardCameraController(camera));
		
		batch = new SpriteBatch();
		
		image = new Texture(new FileHandle(new File("res/test.png")));
		mapImage = new Texture(new FileHandle(new File("res/maptest.png")));
	}

	@Override
	public void dispose()
	{
		image.dispose();
		batch.dispose();
	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render()
	{
		Gdx.gl.glClearColor(255, 255, 255, 255);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.draw(mapImage, (int)camera.position.x, (int)camera.position.y);
		if (withinCameraView(camera, image, spriteX, spriteY))
		{
			System.out.println("Draw");
			batch.draw(image, spriteX + camera.position.x, spriteY + camera.position.y);
		}
		batch.end();
		
		for (CameraController c : cameraControllers)
		{
			c.update();
		}
		camera.update();
	}

	@Override
	public void resize(int width, int height)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub
		
	}

	private static boolean withinCameraView(Camera camera, Texture texture, int spriteXPos, int spriteYPos)
	{
		return (spriteXPos + texture.getWidth() + camera.position.x > 0 &&
				spriteXPos + camera.position.x < camera.viewportWidth &&
				spriteYPos + texture.getHeight() + camera.position.y > 0 &&
				spriteYPos - camera.position.y > camera.viewportHeight);
	}
}
