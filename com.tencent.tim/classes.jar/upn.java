import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;

public class upn
  implements View.OnLayoutChangeListener
{
  private boolean hasScrolled;
  
  public upn(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (!this.hasScrolled)
    {
      Looper.myQueue().addIdleHandler(new upo(this));
      this.hasScrolled = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     upn
 * JD-Core Version:    0.7.0.1
 */