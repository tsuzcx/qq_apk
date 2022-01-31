import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;
import mqq.os.MqqHandler;

class vqi
  implements Runnable
{
  vqi(vqh paramvqh) {}
  
  public void run()
  {
    Message localMessage = FriendChatPie.a(this.a.a).obtainMessage(42);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("showRedDot", false);
    localMessage.setData(localBundle);
    FriendChatPie.b(this.a.a).sendMessage(localMessage);
    SharedPreUtils.b(this.a.a.a.getCurrentAccountUin()).edit().putBoolean("aio_jump_lightalk_red_dot", false).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vqi
 * JD-Core Version:    0.7.0.1
 */