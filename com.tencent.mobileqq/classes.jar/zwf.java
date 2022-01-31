import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;

public class zwf
  implements View.OnClickListener
{
  public zwf(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    PublicFragmentActivity.a(this.a, paramView, AccountOnlineStateActivity.class, 0);
    atlh.a(this.a.app);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     zwf
 * JD-Core Version:    0.7.0.1
 */