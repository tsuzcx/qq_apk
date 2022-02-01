import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteWifiphotoActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;

public class eoj
  implements View.OnClickListener
{
  public eoj(BannerManager paramBannerManager) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eoj
 * JD-Core Version:    0.7.0.1
 */