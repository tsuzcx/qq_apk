import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.tencent.mobileqq.richmedia.capture.gesture.GL3DGesture.1;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.GameplayEngine;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;

public class alws
  implements GLGestureListener
{
  public GameplayEngine a;
  
  public int onGetPriority()
  {
    return 1040;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    paramMotionEvent = new anjj.a(paramMotionEvent);
    GLGestureProxy.getInstance().getGLSurfaceView().queueEvent(new GL3DGesture.1(this, paramMotionEvent));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alws
 * JD-Core Version:    0.7.0.1
 */