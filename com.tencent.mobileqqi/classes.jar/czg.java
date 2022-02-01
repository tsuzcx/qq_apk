import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.activity.StrangerManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

public class czg
  implements View.OnClickListener
{
  public czg(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.a.jdField_a_of_type_AndroidViewView)
    {
      this.a.c();
      ReportController.b(this.a.b, "CliOper", "", "", "Setting_tab", "Vfc_method_clk", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if (paramView == this.a.d)
      {
        paramView = QZoneHelper.UserInfo.a();
        paramView.a = this.a.b.a();
        paramView.b = this.a.b.e();
        paramView.c = this.a.b.getSid();
        QZoneHelper.c(this.a, paramView, -1);
        return;
      }
      if (paramView == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem)
      {
        paramView = (ActionSheet)ActionSheetHelper.a(paramView.getContext(), null);
        paramView.a(2131562384);
        paramView.a(2131563090, 1);
        paramView.a(2131561944, 1);
        paramView.setCanceledOnTouchOutside(true);
        paramView.a(new czh(this, paramView));
        paramView.d(2131561746);
        paramView.show();
        return;
      }
    } while (paramView != PermisionPrivacyActivity.a(this.a));
    StrangerManageActivity.a(this.a);
    ReportController.b(this.a.b, "CliOper", "", "", "Setting_tab", "Manage_stranger_clk", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     czg
 * JD-Core Version:    0.7.0.1
 */