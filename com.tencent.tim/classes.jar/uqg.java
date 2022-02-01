import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.data.AccountDetail;

public class uqg
  extends aprz.b
{
  public uqg(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(boolean paramBoolean, long paramLong, AccountDetail paramAccountDetail)
  {
    if (paramBoolean)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 16;
      Bundle localBundle = new Bundle();
      localBundle.putString("uinname", paramAccountDetail.name);
      localBundle.putString("extra_type", paramAccountDetail.summary);
      localBundle.putLong("uin", paramLong);
      localMessage.setData(localBundle);
      this.this$0.mUIHandler.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uqg
 * JD-Core Version:    0.7.0.1
 */