import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;

public class agqf
  extends GestureDetector.SimpleOnGestureListener
{
  public agqf(FileBrowserActivity paramFileBrowserActivity, int paramInt) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {}
    do
    {
      return false;
      paramFloat1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      paramFloat2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat1);
    } while ((paramFloat1 > -this.lI) || (paramFloat2 >= 0.5F) || (this.this$0.a == null) || (!this.this$0.a.amk()));
    return this.this$0.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agqf
 * JD-Core Version:    0.7.0.1
 */