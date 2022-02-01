import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class yab
  implements ausj.a
{
  yab(xzp paramxzp, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.val$sheet.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      if (aqiw.isNetSupport(this.this$0.a())) {
        try
        {
          ((ardq)this.this$0.app.getBusinessHandler(107)).a(this.this$0.b, new yac(this));
          this.this$0.A = new arhz(this.this$0.a(), this.this$0.getTitleBarHeight());
          this.this$0.A.setContentView(2131562991);
          this.this$0.A.setMessage(this.this$0.a().getString(2131693294));
          this.this$0.A.setCancelable(false);
          this.this$0.A.show();
          paramView = this.this$0.a.a();
          if ((paramView == null) || (!paramView.isPlaying())) {
            continue;
          }
          anot.a(this.this$0.app, "dc00899", "Grp_wolf", "", "in_game", "run_away", 0, 0, "", "", "", "");
        }
        catch (Exception paramView)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(this.this$0.TAG, 2, "the sessionInfo.curFriendUin is wrong: " + this.this$0.sessionInfo.aTl);
          continue;
        }
      } else {
        QQToast.a(this.this$0.a(), 2130840095, this.this$0.a().getResources().getString(2131696348), 0).show(this.this$0.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     yab
 * JD-Core Version:    0.7.0.1
 */