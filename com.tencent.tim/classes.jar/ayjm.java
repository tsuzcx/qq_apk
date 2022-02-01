import android.graphics.Canvas;
import android.view.MotionEvent;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public final class ayjm
  extends aykd
{
  public static final String TAG = ayjm.class.getSimpleName();
  
  public ayjm(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  public boolean H(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean I(MotionEvent paramMotionEvent)
  {
    ram.d(TAG, "EmptyLayer handle touch event.");
    return false;
  }
  
  public boolean aN(long paramLong)
  {
    return true;
  }
  
  protected void an(Canvas paramCanvas) {}
  
  public void ao(Canvas paramCanvas) {}
  
  public void b(Canvas paramCanvas, float paramFloat) {}
  
  public void clear() {}
  
  public String getTag()
  {
    return TAG;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayjm
 * JD-Core Version:    0.7.0.1
 */