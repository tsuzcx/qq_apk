import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;

public class zhs
  implements View.OnTouchListener
{
  public zhs(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.this$0.ayl();
      paramView = this.this$0.aQS;
      this.this$0.af("Clk_find", paramView, "");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zhs
 * JD-Core Version:    0.7.0.1
 */