import android.content.res.Resources;
import android.os.Vibrator;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FrameHelperActivity.HeadViewLongClick;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.AssociatedAccountOptPopBar;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class zkr
  implements View.OnLongClickListener
{
  public zkr(FrameHelperActivity paramFrameHelperActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((this.a.getActivity() == null) || (this.a.getActivity().isFinishing())) {}
    while ((!SubAccountControll.c(this.a.getActivity().app, false)) || ((this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b()))) {
      return true;
    }
    if ((paramView == this.a.b) && (this.a.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountOptPopBar != null)) {
      if ((this.a.getActivity().app != null) && (this.a.getActivity().app.getApp() != null))
      {
        paramView = (Vibrator)this.a.getActivity().app.getApp().getSystemService("vibrator");
        if (paramView != null) {
          paramView.vibrate(new long[] { 0L, 1L, 20L, 21L }, -1);
        }
      }
    }
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountOptPopBar.a(this.a.b, this.a.getResources().getDimensionPixelSize(2131558953), this.a.getResources().getDimensionPixelSize(2131558954));
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$HeadViewLongClick != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$HeadViewLongClick.a();
      }
      ReportController.b(this.a.getActivity().app, "CliOper", "", "", "0X80072D1", "0X80072D1", 0, 0, "", "", "", "");
      return true;
    }
    catch (WindowManager.BadTokenException paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
        QLog.i("Q.recent", 1, "onLongClick show optpopbar error:" + paramView.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zkr
 * JD-Core Version:    0.7.0.1
 */