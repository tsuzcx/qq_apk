import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

public final class zny
{
  private final znz a;
  
  public zny(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this(paramContext, paramOnGestureListener, null);
  }
  
  public zny(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
  {
    this.a = new zoa(paramContext, paramOnGestureListener, paramHandler);
  }
  
  public void a(int paramInt)
  {
    zoa.a(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zny
 * JD-Core Version:    0.7.0.1
 */