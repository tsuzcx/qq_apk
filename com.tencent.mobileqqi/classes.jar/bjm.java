import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.Switch;

public class bjm
  implements CompoundButton.OnCheckedChangeListener
{
  public bjm(AccountDetailActivity paramAccountDetailActivity, mobileqq_mp.ConfigInfo paramConfigInfo, Switch paramSwitch, View paramView) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.e)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.e = true;
      return;
    }
    label49:
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.confirm_flag.get() == 1)
    {
      AccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
      if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.state_id.get() != 5) {
        break label248;
      }
      str = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.getString(2131560565);
      if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.state.get() == 1) {
        break label250;
      }
    }
    label248:
    label250:
    for (paramCompoundButton = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.getString(2131562562);; paramCompoundButton = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.getString(2131561841))
    {
      paramCompoundButton = String.format(str, new Object[] { paramCompoundButton });
      this.jdField_a_of_type_AndroidViewView.setContentDescription(paramCompoundButton);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.confirm_flag.get() == 2)
      {
        if (paramBoolean)
        {
          AccountDetailActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
          break label49;
        }
        AccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        break label49;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.confirm_flag.get() == 3)
      {
        if (!paramBoolean)
        {
          AccountDetailActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
          break label49;
        }
        AccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        break label49;
      }
      AccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
      break label49;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bjm
 * JD-Core Version:    0.7.0.1
 */