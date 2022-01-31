import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatForEnterpriseActivity;
import com.tencent.mobileqq.app.PublicAccountDataManager;

public class cbf
  implements DialogInterface.OnClickListener
{
  public cbf(ChatForEnterpriseActivity paramChatForEnterpriseActivity, PublicAccountDataManager paramPublicAccountDataManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatForEnterpriseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatForEnterpriseActivity).mIsAgreeSyncLbs = false;
    ChatForEnterpriseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatForEnterpriseActivity).mIsSyncLbsSelected = true;
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager.a(ChatForEnterpriseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatForEnterpriseActivity));
    ChatForEnterpriseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatForEnterpriseActivity, 2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cbf
 * JD-Core Version:    0.7.0.1
 */