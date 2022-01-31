import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.Switch;

public class bpb
  implements DialogInterface.OnClickListener
{
  public bpb(EnterpriseDetailActivity paramEnterpriseDetailActivity, mobileqq_mp.ConfigInfo paramConfigInfo, Switch paramSwitch, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0) {
      if ((3 == this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.state_id.get()) && (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.state.get() == 0))
      {
        paramDialogInterface = this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity;
        localConfigInfo = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo;
        localSwitch = this.jdField_a_of_type_ComTencentWidgetSwitch;
        if (!this.jdField_a_of_type_Boolean)
        {
          bool = true;
          EnterpriseDetailActivity.a(paramDialogInterface, localConfigInfo, localSwitch, bool);
        }
      }
      else
      {
        EnterpriseDetailActivity.a(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch);
        this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.a.isConfirmed = true;
        EnterpriseDetailActivity.b(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity, this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.a);
        this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.g = false;
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        mobileqq_mp.ConfigInfo localConfigInfo;
        Switch localSwitch;
        return;
        boolean bool = false;
      }
    }
    EnterpriseDetailActivity.a(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.a.isConfirmed = true;
    EnterpriseDetailActivity.b(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity, this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.a);
    this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.g = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bpb
 * JD-Core Version:    0.7.0.1
 */