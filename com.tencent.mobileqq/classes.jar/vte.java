import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.utils.VipUtils;

public class vte
  implements Runnable
{
  public vte(FriendChatPie paramFriendChatPie) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin"), this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("uintype", 0)).time < FriendChatPie.a(this.a)) {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "FriendAIO", "SilentCare", 0, 0, new String[] { this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin") });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vte
 * JD-Core Version:    0.7.0.1
 */