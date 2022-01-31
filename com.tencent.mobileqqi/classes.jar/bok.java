import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.Switch;

public class bok
  implements CompoundButton.OnCheckedChangeListener
{
  public bok(EnterpriseDetailActivity paramEnterpriseDetailActivity, mobileqq_mp.ConfigInfo paramConfigInfo, Switch paramSwitch, View paramView) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.e)
    {
      this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.e = true;
      return;
    }
    label88:
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.confirm_flag.get() == 1)
    {
      EnterpriseDetailActivity.a(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
      if (!paramBoolean) {
        ReportController.b(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.a, "CliOper", "", "", "Biz_card", "Biz_card_distalk", 0, 0, this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.b, "", "", "");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.state_id.get() != 5) {
        break label396;
      }
      str = this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.getString(2131560565);
      if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.state.get() == 1) {
        break label398;
      }
    }
    label396:
    label398:
    for (paramCompoundButton = this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.getString(2131562562);; paramCompoundButton = this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.getString(2131561841))
    {
      paramCompoundButton = String.format(str, new Object[] { paramCompoundButton });
      this.jdField_a_of_type_AndroidViewView.setContentDescription(paramCompoundButton);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.confirm_flag.get() == 2)
      {
        if (paramBoolean)
        {
          EnterpriseDetailActivity.b(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
          break label88;
        }
        EnterpriseDetailActivity.a(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        ReportController.b(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.a, "CliOper", "", "", "Biz_card", "Biz_card_distalk", 0, 0, this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.b, "", "", "");
        break label88;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.confirm_flag.get() == 3)
      {
        if (!paramBoolean)
        {
          EnterpriseDetailActivity.b(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
          ReportController.b(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.a, "CliOper", "", "", "Biz_card", "Biz_card_distalk", 0, 0, this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.b, "", "", "");
          break label88;
        }
        EnterpriseDetailActivity.a(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        break label88;
      }
      EnterpriseDetailActivity.a(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
      if (paramBoolean) {
        break label88;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.a, "CliOper", "", "", "Biz_card", "Biz_card_distalk", 0, 0, this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.b, "", "", "");
      break label88;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bok
 * JD-Core Version:    0.7.0.1
 */