import android.view.View;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class dyk
  implements ActionSheet.OnButtonClickListener
{
  public dyk(TroopRequestActivity paramTroopRequestActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    if (NetworkUtil.e(BaseApplication.getContext())) {
      TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity);
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.b, "P_CliOper", "Grp_sysmsg", "", "verify_msg", "black", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.p, TroopRequestActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity), "", "");
      break;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity, 2131562449, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dyk
 * JD-Core Version:    0.7.0.1
 */