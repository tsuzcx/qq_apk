import android.content.res.Resources;
import android.os.Vibrator;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FrameHelperActivity.HeadViewLongClick;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.AssociatedAccountOptPopBar;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.qphone.base.util.BaseApplication;

public class zak
  implements View.OnLongClickListener
{
  public zak(FrameHelperActivity paramFrameHelperActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if (!SubAccountControll.c(this.a.getActivity().app, false)) {}
    while ((this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b())) {
      return true;
    }
    if ((paramView == this.a.b) && (this.a.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountOptPopBar != null))
    {
      if ((this.a.getActivity().app != null) && (this.a.getActivity().app.getApp() != null))
      {
        paramView = (Vibrator)this.a.getActivity().app.getApp().getSystemService("vibrator");
        if (paramView != null) {
          paramView.vibrate(new long[] { 0L, 1L, 20L, 21L }, -1);
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountOptPopBar.a(this.a.b, this.a.getResources().getDimensionPixelSize(2131558951), this.a.getResources().getDimensionPixelSize(2131558952));
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$HeadViewLongClick != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$HeadViewLongClick.a();
    }
    ReportController.b(this.a.getActivity().app, "CliOper", "", "", "0X80072D1", "0X80072D1", 0, 0, "", "", "", "");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zak
 * JD-Core Version:    0.7.0.1
 */