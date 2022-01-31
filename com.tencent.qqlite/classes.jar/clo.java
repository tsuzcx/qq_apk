import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.LoginManagerActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;

public class clo
  implements View.OnClickListener
{
  public clo(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297378: 
      paramView = new Intent(BannerManager.a(this.a), LoginManagerActivity.class);
      paramView.putExtra("loginInfo", this.a.d);
      BannerManager.a(this.a).startActivity(paramView);
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     clo
 * JD-Core Version:    0.7.0.1
 */