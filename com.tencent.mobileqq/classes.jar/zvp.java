import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.widget.RotateSwitchImageView;
import com.tencent.mobileqq.widget.ShaderAnimLayout;

public class zvp
  implements View.OnClickListener
{
  public zvp(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (!(paramView instanceof RotateSwitchImageView)) {}
    View localView2;
    do
    {
      do
      {
        return;
        localView1 = AccountManageActivity.a(this.a, paramView);
        localView2 = AccountManageActivity.b(this.a, paramView);
        if (AccountManageActivity.a(this.a) != null) {
          break;
        }
        AccountManageActivity.a(this.a, (RotateSwitchImageView)paramView);
        ((RotateSwitchImageView)paramView).b();
        localLayoutParams = localView2.getLayoutParams();
        localLayoutParams.width = ((int)(AccountManageActivity.a(this.a) - AccountManageActivity.g(this.a) * 75.0F));
        localView2.setLayoutParams(localLayoutParams);
        if ((localView1 instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localView1).b();
        }
      } while (!AppSetting.c);
      paramView.setContentDescription(this.a.getString(2131625534));
      return;
      if (AccountManageActivity.a(this.a) != paramView) {
        break;
      }
      AccountManageActivity.a(this.a).a();
      localLayoutParams = localView2.getLayoutParams();
      localLayoutParams.width = ((int)(AccountManageActivity.a(this.a) - AccountManageActivity.h(this.a) * 40.0F));
      localView2.setLayoutParams(localLayoutParams);
      if ((localView1 instanceof ShaderAnimLayout)) {
        ((ShaderAnimLayout)localView1).f();
      }
      AccountManageActivity.a(this.a, null);
    } while (!AppSetting.c);
    paramView.setContentDescription(this.a.getString(2131625546));
    return;
    AccountManageActivity.a(this.a).a();
    ((RotateSwitchImageView)paramView).b();
    AccountManageActivity.b(this.a, AccountManageActivity.a(this.a)).getLayoutParams().width = ((int)(AccountManageActivity.a(this.a) - AccountManageActivity.i(this.a) * 40.0F));
    ViewGroup.LayoutParams localLayoutParams = localView2.getLayoutParams();
    localLayoutParams.width = ((int)(AccountManageActivity.a(this.a) - AccountManageActivity.j(this.a) * 75.0F));
    localView2.setLayoutParams(localLayoutParams);
    if ((localView1 instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)localView1).b();
    }
    View localView1 = AccountManageActivity.a(this.a, AccountManageActivity.a(this.a));
    if ((localView1 instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)localView1).f();
    }
    AccountManageActivity.a(this.a, (RotateSwitchImageView)paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     zvp
 * JD-Core Version:    0.7.0.1
 */