import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.widget.Switch;

public class bjx
  implements DialogInterface.OnClickListener
{
  public bjx(AccountDetailActivity paramAccountDetailActivity, mobileqq_mp.ConfigInfo paramConfigInfo, Switch paramSwitch, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      AccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a.isConfirmed = true;
      AccountDetailActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.g = false;
    }
    while (paramInt != 1) {
      return;
    }
    AccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a.isConfirmed = true;
    AccountDetailActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.g = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bjx
 * JD-Core Version:    0.7.0.1
 */