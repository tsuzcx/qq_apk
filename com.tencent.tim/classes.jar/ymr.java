import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment.c;

public class ymr
  implements View.OnTouchListener
{
  public ymr(TroopMemberHistoryFragment paramTroopMemberHistoryFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return (paramMotionEvent.getAction() == 2) && ((this.this$0.a == null) || (this.this$0.a.getCount() == 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ymr
 * JD-Core Version:    0.7.0.1
 */