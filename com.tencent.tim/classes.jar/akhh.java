import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment.4.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akhh
  implements View.OnClickListener
{
  public akhh(NearbyProfileFragment paramNearbyProfileFragment) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.b.a, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://nearby.qq.com/nearby-visitor/index.html?_proxy=1&_wwv=128");
    this.b.a.startActivity(localIntent);
    NearbyProfileFragment.a(this.b, null);
    ThreadManager.post(new NearbyProfileFragment.4.1(this), 5, null, false);
    anot.a(this.b.a.app, "dc00899", "grp_lbs", "", "data_card", "clk_visit", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akhh
 * JD-Core Version:    0.7.0.1
 */