import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc00518;

public class wha
  implements ausj.a
{
  public wha(ActivateFriendActivity paramActivateFriendActivity, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 1;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$sheet.dismiss();
      return;
      if (ActivateFriendActivity.a(this.this$0) == null) {
        ActivateFriendActivity.a(this.this$0, (acof)this.this$0.app.getManager(85));
      }
      if (aqiw.isNetSupport(this.this$0))
      {
        paramView = ActivateFriendActivity.a(this.this$0);
        boolean bool;
        if (!ActivateFriendActivity.a(this.this$0))
        {
          bool = true;
          label92:
          paramView.bM(bool, true);
          paramInt = i;
          if (ActivateFriendActivity.a(this.this$0)) {
            paramInt = 2;
          }
          LpReportInfo_dc00518.report(100, paramInt, paramInt);
          if (!ActivateFriendActivity.a(this.this$0)) {
            break label202;
          }
        }
        label202:
        for (paramView = "QQnotice.aio.detail.seton";; paramView = "QQnotice.aio.detail.setoff")
        {
          if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.MainActivity", 2, "do report: " + paramView);
          }
          anot.a(this.this$0.app, "P_CliOper", "QQnotice", "", "", paramView, 0, 0, "", "", "", "");
          break;
          bool = false;
          break label92;
        }
      }
      if ((!this.this$0.isFinishing()) && (this.this$0 != null)) {
        QQToast.a(this.this$0, 1, this.this$0.getResources().getString(2131696272), 0).show(this.this$0.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wha
 * JD-Core Version:    0.7.0.1
 */