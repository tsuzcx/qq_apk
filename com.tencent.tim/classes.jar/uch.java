import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class uch
  implements View.OnClickListener
{
  public uch(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    anot.a(this.this$0.app, "CliOper", "", "", "0X8004038", "0X8004038", 0, 0, String.valueOf(this.this$0.qg.size()), "", "", "");
    if (!akwp.a().a(this.this$0.app, this.this$0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      AccountManageActivity.a(this.this$0, anxk.bE(this.this$0.app));
      if (this.this$0.aQV)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AccountManage", 2, "onClick v.hashCode()" + paramView.hashCode());
        }
      }
      else
      {
        Object localObject = paramView.getTag();
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Switch_Account", 2, "switch a non-existing account");
          }
        }
        else
        {
          int i = ((Integer)localObject).intValue();
          localObject = (SimpleAccount)this.this$0.qg.get(i);
          if (QLog.isColorLevel()) {
            QLog.d("Switch_Account", 2, "switch uin:" + ((SimpleAccount)localObject).getUin());
          }
          if ((localObject != null) && (!((SimpleAccount)localObject).getUin().equals(this.this$0.app.getCurrentAccountUin())))
          {
            anot.a(this.this$0.app, "CliOper", "", "", "0X8009C05", "0X8009C05", 0, 0, "", "", "", "");
            this.this$0.atg();
            this.this$0.a = ((SimpleAccount)localObject);
            AccountManageActivity.b(this.this$0, true);
            AccountManageActivity.c(this.this$0, true);
            anot.a(this.this$0.app, "dc00898", "", "", "0X800AC38", "0X800AC38", 0, 0, "", "", "", "");
            this.this$0.app.switchAccount((SimpleAccount)localObject, null);
            anxj.j(this.this$0.app, this.this$0);
          }
          aqfy.edD();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uch
 * JD-Core Version:    0.7.0.1
 */