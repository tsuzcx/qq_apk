import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.qphone.base.util.QLog;

public class usf
  implements View.OnTouchListener
{
  public usf(Conversation paramConversation) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder().append("statusTitle onTouch event :").append(paramMotionEvent.toString()).append(", mGestureDetector is null ");
      if (this.this$0.mGestureDetector == null) {
        break label81;
      }
    }
    label81:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.recent", 2, bool);
      if (this.this$0.mGestureDetector != null) {
        this.this$0.mGestureDetector.onTouchEvent(paramMotionEvent);
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     usf
 * JD-Core Version:    0.7.0.1
 */