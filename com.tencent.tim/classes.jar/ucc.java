import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ucc
  implements View.OnClickListener
{
  public ucc(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = null;
      if ((paramView.getTag() instanceof String)) {
        localObject = String.valueOf(paramView.getTag());
      }
      if ("0X8004001".equals(localObject))
      {
        anot.a(this.this$0.app, "CliOper", "", "", "0X8004002", "0X8004002", 0, 0, "", "", "", "");
        localObject = new Intent(this.this$0, SubAccountUgActivity.class);
        ((Intent)localObject).putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
        this.this$0.startActivity((Intent)localObject);
      }
      else if ("0X8004456".equals(localObject))
      {
        anot.a(this.this$0.app, "CliOper", "", "", "0X8004457", "0X8004457", 0, 0, "", "", "", "");
        localObject = new Intent(this.this$0, SubAccountBindActivity.class);
        ((Intent)localObject).putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
        this.this$0.startActivity((Intent)localObject);
        aqgx.a().dl(this.this$0.app.getCurrentAccountUin(), true);
        continue;
        localObject = new Intent();
        ((Intent)localObject).setClass(paramView.getContext(), AssociatedAccountActivity.class);
        ((Intent)localObject).putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
        paramView.getContext().startActivity((Intent)localObject);
        anot.a(this.this$0.app, "CliOper", "", "", "0X8004039", "0X8004039", 0, 0, "", "", "", "");
        anot.a(this.this$0.app, "dc00898", "", "", "0X800AC39", "0X800AC39", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ucc
 * JD-Core Version:    0.7.0.1
 */