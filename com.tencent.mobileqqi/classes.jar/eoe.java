import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.Banner;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.ADView;

public class eoe
  implements View.OnClickListener
{
  public eoe(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    BannerManager.a(this.a).getSharedPreferences("mobileQQi", 0).edit().putBoolean("push_banner_display" + BannerManager.a(this.a).b.getAccount(), false).commit();
    paramView = BannerManager.a(this.a)[14];
    if ((paramView != null) && (paramView.a != null))
    {
      paramView = (ADView)paramView.a.findViewById(2131232088);
      if (paramView != null) {
        paramView.a();
      }
    }
    this.a.a(14, 0);
    this.a.a(null);
    this.a.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eoe
 * JD-Core Version:    0.7.0.1
 */