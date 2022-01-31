import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.util.VersionUtils;

public class xoh
  implements View.OnClickListener
{
  public xoh(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    if (VersionUtils.e())
    {
      BannerManager.a(this.a).startActivity(new Intent("android.settings.SETTINGS"));
      return;
    }
    BannerManager.a(this.a).startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xoh
 * JD-Core Version:    0.7.0.1
 */