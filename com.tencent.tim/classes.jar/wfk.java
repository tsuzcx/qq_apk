import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.VerifyCodeActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wfk
  implements View.OnClickListener
{
  public wfk(VerifyCodeActivity paramVerifyCodeActivity) {}
  
  public void onClick(View paramView)
  {
    QLog.d("VerifyCodeActivity", 1, new Object[] { "refreshVerifyCode isRefresh=", Boolean.valueOf(this.a.isRefresh) });
    if (!this.a.isRefresh) {
      this.a.qW();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     wfk
 * JD-Core Version:    0.7.0.1
 */