import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.voip.VoipQCallTimeOutActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class fbn
  implements View.OnClickListener
{
  public fbn(VoipQCallTimeOutActivity paramVoipQCallTimeOutActivity, Intent paramIntent, String paramString) {}
  
  public void onClick(View paramView)
  {
    boolean bool1 = false;
    paramView = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("senderUin");
    String str1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("friendUin");
    int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("uinType", 0);
    boolean bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isVideoMsg", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipQCallTimeOutActivity.b.e();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipQCallTimeOutActivity.b;
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipQCallTimeOutActivity.a();
    String str2 = this.jdField_a_of_type_JavaLangString;
    if (!bool2) {
      bool1 = true;
    }
    ChatActivityUtils.a(localQQAppInterface, localActivity, i, str1, str2, null, bool1, paramView, true, true, null, "from_internal");
    this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipQCallTimeOutActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fbn
 * JD-Core Version:    0.7.0.1
 */