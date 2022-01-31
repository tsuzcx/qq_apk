import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.LoginManagerActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;

public class enx
  implements View.OnClickListener
{
  public enx(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131232014: 
      paramView = new Intent(BannerManager.a(this.a), LoginManagerActivity.class);
      paramView.putExtra("loginInfo", this.a.e);
      BannerManager.a(this.a).startActivity(paramView);
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     enx
 * JD-Core Version:    0.7.0.1
 */