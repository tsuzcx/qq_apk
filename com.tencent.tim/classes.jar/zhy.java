import android.os.Handler;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.qphone.base.util.QLog;

public class zhy
  extends apsy
{
  public zhy(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void a(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.BaseFragment", 2, "onGetGiftMemberList");
    }
    ChatHistoryTroopMemberFragment.a(this.this$0, paramArrayOfLong1);
    ChatHistoryTroopMemberFragment.b(this.this$0, paramArrayOfLong2);
    ChatHistoryTroopMemberFragment.c(this.this$0, paramArrayOfLong3);
    ChatHistoryTroopMemberFragment.a(this.this$0, true);
    if (ChatHistoryTroopMemberFragment.b(this.this$0))
    {
      paramArrayOfLong1 = this.this$0.mHandler.obtainMessage(12, null);
      this.this$0.mHandler.sendMessage(paramArrayOfLong1);
    }
  }
  
  public void onError(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.BaseFragment", 2, "onGetGiftMemberList error");
    }
    ChatHistoryTroopMemberFragment.a(this.this$0, true);
    if (ChatHistoryTroopMemberFragment.b(this.this$0))
    {
      paramString = this.this$0.mHandler.obtainMessage(12, null);
      this.this$0.mHandler.sendMessage(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zhy
 * JD-Core Version:    0.7.0.1
 */