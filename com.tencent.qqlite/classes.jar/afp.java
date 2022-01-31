import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;

public class afp
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public afp(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onGlobalLayout()
  {
    if (this.a.ap >= 0) {
      ChatSettingForTroop.a(this.a, this.a.ap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     afp
 * JD-Core Version:    0.7.0.1
 */