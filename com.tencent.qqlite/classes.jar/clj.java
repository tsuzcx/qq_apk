import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.util.VersionUtils;

public class clj
  implements View.OnClickListener
{
  public clj(BannerManager paramBannerManager) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     clj
 * JD-Core Version:    0.7.0.1
 */