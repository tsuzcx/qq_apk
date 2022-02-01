import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;

public class afum
  implements GestureDetector.OnGestureListener
{
  public afum(ExtendFriendEditFragment paramExtendFriendEditFragment) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    int j = 1;
    if ((paramMotionEvent1 != null) && (paramMotionEvent2 != null)) {
      if (paramMotionEvent1.getY() - paramMotionEvent2.getY() <= 50.0F) {
        break label102;
      }
    }
    label102:
    for (int i = 1;; i = 0)
    {
      if (paramMotionEvent2.getY() - paramMotionEvent1.getY() > 50.0F) {
        i = j;
      }
      for (;;)
      {
        if ((i != 0) && (this.a.a != null))
        {
          this.a.a.hideSoftInput();
          ExtendFriendEditFragment.a(this.a).setVisibility(8);
          this.a.iL.setVisibility(8);
        }
        return false;
      }
    }
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afum
 * JD-Core Version:    0.7.0.1
 */