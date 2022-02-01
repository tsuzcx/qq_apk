import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.voip.VoipContact;
import com.tencent.mobileqq.activity.voip.VoipDialData;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;
import com.tencent.mobileqq.activity.voip.VoipPhoneNumber;
import com.tencent.mobileqq.activity.voip.VoipQCallTimeOutActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;

public class ewz
  implements View.OnClickListener
{
  public ewz(VoipQCallTimeOutActivity paramVoipQCallTimeOutActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipQCallTimeOutActivity.b.getManager(10);
    if (localPhoneContactManager != null)
    {
      VoipQCallTimeOutActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipQCallTimeOutActivity, localPhoneContactManager.a(this.jdField_a_of_type_JavaLangString, null, null));
      if (VoipQCallTimeOutActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipQCallTimeOutActivity).phoneNumber != null) {}
    }
    else
    {
      return;
    }
    if (VoipQCallTimeOutActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipQCallTimeOutActivity).phoneNumber.jdField_a_of_type_JavaLangString.length() > 0)
    {
      paramView.putExtra("dialData", new VoipDialData(VoipQCallTimeOutActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipQCallTimeOutActivity).phoneNumber.b, VoipQCallTimeOutActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipQCallTimeOutActivity).phoneNumber.jdField_a_of_type_JavaLangString));
      paramView.putExtra("callNow", 0);
    }
    paramView.setClass(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipQCallTimeOutActivity, VoipDialInterfaceActivity.class);
    this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipQCallTimeOutActivity.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ewz
 * JD-Core Version:    0.7.0.1
 */