import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.10.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akeh
  implements View.OnClickListener
{
  akeh(akef paramakef) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0.a, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://nearby.qq.com/nearby-visitor/index.html?_proxy=1&_wwv=128");
    this.this$0.a.startActivity(localIntent);
    akef.a(this.this$0, null);
    ThreadManager.post(new NearbyProfileDisplayTribePanel.10.1(this), 5, null, false);
    anot.a(this.this$0.a.app, "dc00899", "grp_lbs", "", "data_card", "clk_visit", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akeh
 * JD-Core Version:    0.7.0.1
 */