import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.jumplightalk.AIOJumpLightalkConfig;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import mqq.os.MqqHandler;

public class vtm
  implements Runnable
{
  public vtm(FriendChatPie paramFriendChatPie) {}
  
  public void run()
  {
    FriendChatPie.a(this.a, AIOJumpLightalkConfig.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    if ((FriendChatPie.a(this.a) != null) && (!Utils.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      FriendChatPie.a(this.a, SharedPreUtils.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).getBoolean("aio_jump_lightalk_red_dot", false));
      Message localMessage = FriendChatPie.e(this.a).obtainMessage(42);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("showRedDot", FriendChatPie.a(this.a));
      localMessage.setData(localBundle);
      FriendChatPie.f(this.a).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vtm
 * JD-Core Version:    0.7.0.1
 */