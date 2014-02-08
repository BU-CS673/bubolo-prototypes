package bubolotest;

import com.badlogic.gdx.graphics.Camera;

/**
 * 
 * @author Christopher D. Canfield
 */
public abstract class CameraController 
{
	private Camera camera;
	
	protected CameraController(Camera camera)
	{
		this.camera = camera;
	}
	
	protected void moveCamera(float xOffset, float offsetY)
	{
		// Ensure the camera stays within the world boundaries. This example world is
		// 1024 pixels wide, and 1024 pixels tall.
		if ((xOffset > 0 && camera.position.x < 0) ||
			(xOffset < 0 && camera.position.x > -1024 + Application.SCREEN_WIDTH))
		{
			camera.translate(xOffset, 0.f, 0.f);
		}
		
		if ((offsetY > 0 && camera.position.y < 0) ||
				(offsetY < 0 && (camera.position.y > -1024 + Application.SCREEN_HEIGHT)))
		{
			camera.translate(0.f, offsetY, 0.f);
		}
	}
		
	public abstract void update();
}
