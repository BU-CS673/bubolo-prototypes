package bubolotest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Camera;

/**
 * 
 * @author Christopher D. Canfield
 */
public class KeyboardCameraController extends CameraController
{
	public KeyboardCameraController(Camera camera)
	{
		super(camera);
	}
	
	@Override
	public void update()
	{
		if (Gdx.input.isKeyPressed(Keys.LEFT))
		{
			moveCamera(5.f, 0.f);
		}
		else if (Gdx.input.isKeyPressed(Keys.RIGHT))
		{
			moveCamera(-5.f, 0.f);
		}
		
		if (Gdx.input.isKeyPressed(Keys.UP))
		{
			moveCamera(0.f, -5.f);
		}
		else if (Gdx.input.isKeyPressed(Keys.DOWN))
		{
			moveCamera(0.f, 5.f);
		}
	}
}
