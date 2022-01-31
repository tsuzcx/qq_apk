import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.AccountManageActivity;

public class brv
  implements View.OnClickListener
{
  public brv(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    View localView = AccountManageActivity.a(this.a, paramView);
    if (this.a.a == null)
    {
      this.a.a = paramView;
      this.a.a(paramView, 2130968586, 2);
      localObject = localView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = ((int)(AccountManageActivity.a(this.a) - AccountManageActivity.c(this.a) * 75.0F));
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramView.setContentDescription(this.a.getString(2131562854));
      return;
    }
    if (this.a.a == paramView)
    {
      this.a.a(this.a.a, 2130968585, 3);
      localObject = localView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = ((int)(AccountManageActivity.a(this.a) - AccountManageActivity.d(this.a) * 40.0F));
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.a.a = null;
      paramView.setContentDescription(this.a.getString(2131558457));
      return;
    }
    this.a.a(this.a.a, 2130968585, 3);
    Object localObject = AccountManageActivity.a(this.a, this.a.a);
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
    localLayoutParams.width = ((int)(AccountManageActivity.a(this.a) - AccountManageActivity.e(this.a) * 40.0F));
    ((View)localObject).setLayoutParams(localLayoutParams);
    this.a.a(paramView, 2130968586, 2);
    localObject = localView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = ((int)(AccountManageActivity.a(this.a) - AccountManageActivity.f(this.a) * 75.0F));
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramView.setContentDescription(this.a.getString(2131562854));
    this.a.a.setContentDescription(this.a.getString(2131558457));
    this.a.a = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     brv
 * JD-Core Version:    0.7.0.1
 */