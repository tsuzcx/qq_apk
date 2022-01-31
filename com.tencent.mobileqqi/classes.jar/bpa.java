import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.widget.Switch;

public class bpa
  implements DialogInterface.OnCancelListener
{
  public bpa(EnterpriseDetailActivity paramEnterpriseDetailActivity, mobileqq_mp.ConfigInfo paramConfigInfo, Switch paramSwitch) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    EnterpriseDetailActivity.a(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch);
    this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.g = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bpa
 * JD-Core Version:    0.7.0.1
 */