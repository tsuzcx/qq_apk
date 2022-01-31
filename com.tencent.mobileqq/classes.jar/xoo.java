import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.ArkTipsManager;

public class xoo
  implements View.OnClickListener
{
  public xoo(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    if (BannerManager.a(this.a) != null) {}
    for (paramView = BannerManager.a(this.a).app;; paramView = null)
    {
      if (paramView != null) {
        ArkTipsManager.a().a(BannerManager.a(this.a), paramView);
      }
      ArkTipsManager.a().a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xoo
 * JD-Core Version:    0.7.0.1
 */