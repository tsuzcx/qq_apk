import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akei
  implements View.OnClickListener
{
  akei(akef paramakef) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0.a, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://imgcache.qq.com/club/client/flower/release/html/points.html?source=501");
    localIntent.putExtra("url", "https://imgcache.qq.com/club/client/flower/release/html/points.html?source=501");
    this.this$0.a.startActivity(localIntent);
    anot.a(null, "dc00899", "grp_lbs", "", "rank_data", "clk_gift", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akei
 * JD-Core Version:    0.7.0.1
 */