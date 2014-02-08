package bubolotest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

public class Application implements ApplicationListener
{
	public static void main(String[] args)
	{
		
	}
	
	private static final float SCREEN_WIDTH = 800;
	private static final float SCREEN_HEIGHT = 600;
	
	private Camera camera;
	private List<CameraController> cameraControllers = new ArrayList<CameraController>();
	
	private Texture image;

	@Override
	public void create()
	{
		camera = new OrthographicCamera(SCREEN_WIDTH, SCREEN_HEIGHT);
		cameraControllers.add(new KeyboardCameraController());
		
		image = new Texture(new FileHandle(new File("res/test.png")));
	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render()
	{
		// TODO Auto-generated method stub
		
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

	
}
