import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.mobileqq.widget.ClearableEditText;

public class apqg
  implements View.OnTouchListener
{
  public apqg(BulkSendMessageFragment paramBulkSendMessageFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = this.this$0.k.canScrollVertically(-1);
    boolean bool2 = this.this$0.k.canScrollVertically(1);
    if ((paramView.isFocused()) && ((bool1) || (bool2))) {
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return false;
    }
    paramView.getParent().requestDisallowInterceptTouchEvent(false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apqg
 * JD-Core Version:    0.7.0.1
 */