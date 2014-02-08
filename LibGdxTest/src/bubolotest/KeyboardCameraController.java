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
//			if (camera.position.x < 0)
//			{
//				camera.translate(5.f, 0.f, 0.f);
//			}
		}
		else if (Gdx.input.isKeyPressed(Keys.RIGHT))
		{
			moveCamera(-5.f, 0.f);
//			if (camera.position.x > -1024 + Application.SCREEN_WIDTH)
//			{
//				camera.translate(-5.f, 0.f, 0.f);
//			}
		}
		
		if (Gdx.input.isKeyPressed(Keys.UP))
		{
			moveCamera(0.f, -5.f);
//			if (camera.position.y > -1024 + Application.SCREEN_HEIGHT)
//			{
//				camera.translate(0.f, -5.f, 0.f);
//			}
		}
		else if (Gdx.input.isKeyPressed(Keys.DOWN))
		{
			moveCamera(0.f, 5.f);
//			if (camera.position.y < 0)
//			{
//				camera.translate(0.f, 5.f, 0.f);
//			}
		}
	}
}
