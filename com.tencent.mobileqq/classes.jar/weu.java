import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.utils.BatchAddFriendData;
import com.tencent.mobileqq.troop.utils.TroopMemberGlobalLevelUtils;

public class weu
  implements Runnable
{
  public weu(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    TroopMemberGlobalLevelUtils.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    String str = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    BatchAddFriendData.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     weu
 * JD-Core Version:    0.7.0.1
 */