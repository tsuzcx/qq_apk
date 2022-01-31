import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.CameraUtil;
import com.tencent.mobileqq.widget.CameraFrameLayout;

class hjs
  implements View.OnClickListener
{
  hjs(hjr paramhjr) {}
  
  public void onClick(View paramView)
  {
    if (!CameraFrameLayout.a(this.a.a)) {
      return;
    }
    paramView = (QQAppInterface)((BaseActivity)this.a.a.getContext()).getAppRuntime();
    ReportController.b(paramView, "CliOper", "", "", "background", "bkground_shut", 0, 0, "1", "", "", "");
    CameraUtil.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hjs
 * JD-Core Version:    0.7.0.1
 */