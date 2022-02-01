import android.view.View;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkFragment.3.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class zfv
  implements ausj.a
{
  public zfv(ChatHistoryC2CLinkFragment paramChatHistoryC2CLinkFragment, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = ChatHistoryC2CLinkFragment.a(this.this$0);
    if (paramView.size() > 0)
    {
      ThreadManager.post(new ChatHistoryC2CLinkFragment.3.1(this, paramView), 8, null, true);
      this.this$0.coI();
      anot.a(this.this$0.mApp, "dc00898", "", "", "0X800A0B5", "0X800A0B5", 4, 0, "", "", "", "");
    }
    if (this.c.isShowing()) {
      this.c.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zfv
 * JD-Core Version:    0.7.0.1
 */