import android.graphics.Canvas;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public final class rfs
  extends rgf
{
  public rfs(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  public boolean H(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean I(MotionEvent paramMotionEvent)
  {
    ram.d("EmptyLayer", "EmptyLayer handle touch event.");
    return false;
  }
  
  public boolean J(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected void an(Canvas paramCanvas) {}
  
  public void ao(Canvas paramCanvas) {}
  
  public void clear() {}
  
  public String getTag()
  {
    return "EmptyLayer";
  }
  
  public boolean isEmpty()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rfs
 * JD-Core Version:    0.7.0.1
 */