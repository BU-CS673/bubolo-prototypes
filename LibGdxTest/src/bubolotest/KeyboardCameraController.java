package bubolotest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Camera;

/**
 * 
 * @author Christopher D. Canfield
 */
public class KeyboardCameraController implements CameraController
{
	@Override
	public void update(Camera camera)
	{
		if (Gdx.input.isKeyPressed(Keys.LEFT))
		{
			camera.translate(5.f, 0.f, 0.f);
		}
		else if (Gdx.input.isKeyPressed(Keys.RIGHT))
		{
			camera.translate(-5.f, 0.f, 0.f);
		}
		
		if (Gdx.input.isKeyPressed(Keys.UP))
		{
			camera.translate(0.f, -5.f, 0.f);
		}
		else if (Gdx.input.isKeyPressed(Keys.DOWN))
		{
			camera.translate(0.f, 5.f, 0.f);
		}
	}
}
