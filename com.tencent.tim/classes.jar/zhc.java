import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment.8.1;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment.8.2;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment.8.3;
import com.tencent.mobileqq.app.ThreadManagerV2;

public class zhc
  extends smq.d
{
  public zhc(ChatHistoryTroopFileFragment paramChatHistoryTroopFileFragment) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.this$0.getActivity() == null) || (this.this$0.getActivity().isFinishing())) {}
    while (!paramBoolean1) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new ChatHistoryTroopFileFragment.8.1(this, paramInt1));
    if (paramBoolean2)
    {
      ThreadManagerV2.getUIHandlerV2().postDelayed(new ChatHistoryTroopFileFragment.8.2(this), 1000L);
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new ChatHistoryTroopFileFragment.8.3(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zhc
 * JD-Core Version:    0.7.0.1
 */