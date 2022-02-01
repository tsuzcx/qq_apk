import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.widget.RotateSwitchImageView;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ucj
  implements View.OnClickListener
{
  public ucj(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (!(paramView instanceof RotateSwitchImageView)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      View localView1 = AccountManageActivity.a(this.this$0, paramView);
      View localView2 = AccountManageActivity.b(this.this$0, paramView);
      ViewGroup.LayoutParams localLayoutParams;
      if (AccountManageActivity.a(this.this$0) == null)
      {
        AccountManageActivity.a(this.this$0, (RotateSwitchImageView)paramView);
        ((RotateSwitchImageView)paramView).eiL();
        localLayoutParams = localView2.getLayoutParams();
        localLayoutParams.width = ((int)(AccountManageActivity.a(this.this$0) - AccountManageActivity.g(this.this$0) * 75.0F));
        localView2.setLayoutParams(localLayoutParams);
        if ((localView1 instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localView1).eiU();
        }
        if (AppSetting.enableTalkBack) {
          paramView.setContentDescription(this.this$0.getString(2131692118));
        }
      }
      else if (AccountManageActivity.a(this.this$0) == paramView)
      {
        AccountManageActivity.a(this.this$0).eiK();
        localLayoutParams = localView2.getLayoutParams();
        localLayoutParams.width = ((int)(AccountManageActivity.a(this.this$0) - AccountManageActivity.h(this.this$0) * 40.0F));
        localView2.setLayoutParams(localLayoutParams);
        if ((localView1 instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localView1).eiX();
        }
        AccountManageActivity.a(this.this$0, null);
        if (AppSetting.enableTalkBack) {
          paramView.setContentDescription(this.this$0.getString(2131692130));
        }
      }
      else
      {
        AccountManageActivity.a(this.this$0).eiK();
        ((RotateSwitchImageView)paramView).eiL();
        AccountManageActivity.b(this.this$0, AccountManageActivity.a(this.this$0)).getLayoutParams().width = ((int)(AccountManageActivity.a(this.this$0) - AccountManageActivity.i(this.this$0) * 40.0F));
        localLayoutParams = localView2.getLayoutParams();
        localLayoutParams.width = ((int)(AccountManageActivity.a(this.this$0) - AccountManageActivity.j(this.this$0) * 75.0F));
        localView2.setLayoutParams(localLayoutParams);
        if ((localView1 instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localView1).eiU();
        }
        localView1 = AccountManageActivity.a(this.this$0, AccountManageActivity.a(this.this$0));
        if ((localView1 instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localView1).eiX();
        }
        AccountManageActivity.a(this.this$0, (RotateSwitchImageView)paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ucj
 * JD-Core Version:    0.7.0.1
 */