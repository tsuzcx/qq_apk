import android.view.View;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class dst
  implements ActionSheet.OnButtonClickListener
{
  public dst(TroopRequestActivity paramTroopRequestActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (NetworkUtil.e(BaseApplication.getContext())) {}
      try
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.b.a();
        ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity, "", TroopRequestActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity), paramView, false);
        for (;;)
        {
          label66:
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.b, "P_CliOper", "Grp_sysmsg", "", "verify_msg", "report", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.p, TroopRequestActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity), "", "");
          break;
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity, 2131562449, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.d());
        }
      }
      catch (Exception paramView)
      {
        break label66;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dst
 * JD-Core Version:    0.7.0.1
 */