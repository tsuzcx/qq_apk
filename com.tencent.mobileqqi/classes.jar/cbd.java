import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatForEnterpriseActivity;
import com.tencent.mobileqq.app.PublicAccountDataManager;

public class cbd
  implements DialogInterface.OnClickListener
{
  public cbd(ChatForEnterpriseActivity paramChatForEnterpriseActivity, PublicAccountDataManager paramPublicAccountDataManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatForEnterpriseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatForEnterpriseActivity).mIsAgreeSyncLbs = true;
    ChatForEnterpriseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatForEnterpriseActivity).mIsSyncLbsSelected = true;
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager.a(ChatForEnterpriseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatForEnterpriseActivity));
    ChatForEnterpriseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatForEnterpriseActivity, 1, null);
    ChatForEnterpriseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatForEnterpriseActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cbd
 * JD-Core Version:    0.7.0.1
 */