import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akec
  implements View.OnClickListener
{
  akec(akcx paramakcx, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0.a, QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder().append(this.bTj).append("&from=");
    Object localObject = this.this$0.a;
    if (NearbyPeopleProfileActivity.kI(this.this$0.a.from)) {}
    for (localObject = "1";; localObject = "2")
    {
      localIntent.putExtra("url", (String)localObject);
      anot.a(this.this$0.a.app, "dc00899", "grp_lbs", "", "data_card", "clk_focus", 0, 0, "", "", "", "");
      this.this$0.a.startActivity(localIntent);
      this.this$0.a.crD = true;
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akec
 * JD-Core Version:    0.7.0.1
 */