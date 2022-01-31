import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteWifiphotoActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;

public class ckd
  implements View.OnClickListener
{
  public ckd(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = new Intent(BannerManager.a(this.a), LiteWifiphotoActivity.class);
    paramView.putExtra("isFromStatusbar", true);
    BannerManager.a(this.a).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ckd
 * JD-Core Version:    0.7.0.1
 */