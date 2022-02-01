import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.PublicAccountChatActivity;
import com.tencent.mobileqq.data.AccountDetail;

public class das
  implements DialogInterface.OnClickListener
{
  public das(PublicAccountChatActivity paramPublicAccountChatActivity, AccountDetail paramAccountDetail) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.isAgreeSyncLbs = true;
    PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountChatActivity.b, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    PublicAccountChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountChatActivity, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     das
 * JD-Core Version:    0.7.0.1
 */