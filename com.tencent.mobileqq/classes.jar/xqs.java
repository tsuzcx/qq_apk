import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

public final class xqs
{
  private final xqt a;
  
  public xqs(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this(paramContext, paramOnGestureListener, null);
  }
  
  public xqs(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
  {
    this.a = new xqu(paramContext, paramOnGestureListener, paramHandler);
  }
  
  public void a(int paramInt)
  {
    xqu.a(paramInt);
  }
  
  public void a(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.a.a(paramOnDoubleTapListener);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return this.a.a(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xqs
 * JD-Core Version:    0.7.0.1
 */