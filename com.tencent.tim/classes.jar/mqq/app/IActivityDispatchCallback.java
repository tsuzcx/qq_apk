package mqq.app;

import android.app.Activity;
import android.view.MotionEvent;

public abstract interface IActivityDispatchCallback
{
  public abstract void disaptchTouchEventCallback(Activity paramActivity, MotionEvent paramMotionEvent);
  
  public abstract void onWindowFocusChanged(Activity paramActivity, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.app.IActivityDispatchCallback
 * JD-Core Version:    0.7.0.1
 */