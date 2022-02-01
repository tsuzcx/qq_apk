import android.support.v4.app.FragmentActivity;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.ChatActivityUtils;

class xlj
  extends GestureDetector.SimpleOnGestureListener
{
  xlj(xlh.a parama) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a.a.Rk()) {
      return false;
    }
    wja.bcO = true;
    ChatActivityUtils.a(this.a.a.app, this.a.mView, (FragmentActivity)this.a.a.mContext);
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.a.b != null) {
      this.a.b.onLongClick(this.a.mView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xlj
 * JD-Core Version:    0.7.0.1
 */