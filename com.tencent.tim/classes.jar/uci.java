import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class uci
  implements View.OnClickListener
{
  public uci(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "add account");
    }
    if (!akwp.a().a(this.this$0.app, this.this$0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.this$0.qg != null) && (this.this$0.qg.size() - 1 >= 8))
      {
        QQToast.a(this.this$0, 2131695539, 0).show();
      }
      else
      {
        AccountManageActivity.a(this.this$0, anxk.bE(this.this$0.app));
        Intent localIntent = new Intent();
        localIntent.setPackage(this.this$0.getPackageName());
        localIntent.setClass(this.this$0, AddAccountActivity.class);
        this.this$0.startActivityForResult(localIntent, 1000);
        this.this$0.overridePendingTransition(2130772009, 2130772002);
        anxj.l(this.this$0.app, this.this$0);
        anot.a(this.this$0.app, "CliOper", "", "", "Setting_tab", "Clk_acc_add", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uci
 * JD-Core Version:    0.7.0.1
 */