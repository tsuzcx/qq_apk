import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;

public class zhv
  implements View.OnTouchListener
{
  public zhv(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment, InputMethodManager paramInputMethodManager) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.b.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zhv
 * JD-Core Version:    0.7.0.1
 */