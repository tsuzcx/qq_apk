import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.apollo.process.data.CmGameMainManager;

public class xju
  implements View.OnClickListener
{
  public xju(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    paramView = CmGameMainManager.a();
    if (paramView != null)
    {
      paramView.a(BannerManager.a(this.a));
      paramView.a();
      CmGameMainManager.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xju
 * JD-Core Version:    0.7.0.1
 */