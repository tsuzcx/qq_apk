import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.AccountManageActivity.3.1;
import com.tencent.mobileqq.widget.RotateSwitchImageView;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class ucv
  implements View.OnClickListener
{
  public ucv(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.this$0.aQU)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    Object localObject = this.this$0;
    boolean bool;
    if (!this.this$0.fk)
    {
      bool = true;
      label35:
      ((AccountManageActivity)localObject).fk = bool;
      if (!this.this$0.fk) {
        break label254;
      }
      this.this$0.rightViewText.setVisibility(8);
      this.this$0.rightHighLView.setVisibility(0);
      this.this$0.rightViewText.setText(2131721066);
      this.this$0.BA.setTextColor(this.this$0.getResources().getColor(2131167385));
    }
    for (;;)
    {
      if (AccountManageActivity.a(this.this$0) != null)
      {
        localObject = AccountManageActivity.a(this.this$0, AccountManageActivity.a(this.this$0));
        if ((localObject instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localObject).eiX();
        }
        AccountManageActivity.a(this.this$0).eiK();
        AccountManageActivity.a(this.this$0, null);
      }
      this.this$0.bFm();
      this.this$0.vG(this.this$0.fk);
      this.this$0.aQU = false;
      AccountManageActivity.a(this.this$0).postDelayed(new AccountManageActivity.3.1(this), 400L);
      anot.a(this.this$0.app, "CliOper", "", "", "Setting_tab", "Clk_acc_edit", 0, 0, "", "", "", "");
      break;
      bool = false;
      break label35;
      label254:
      this.this$0.rightViewText.setVisibility(0);
      this.this$0.rightHighLView.setVisibility(8);
      this.this$0.rightViewText.setText(2131721064);
      this.this$0.BA.setTextColor(this.this$0.getResources().getColorStateList(2131167312));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ucv
 * JD-Core Version:    0.7.0.1
 */