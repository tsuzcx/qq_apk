import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akhj
  implements View.OnClickListener
{
  public akhj(NearbyProfileFragment paramNearbyProfileFragment, sna.c paramc) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_b_of_type_Sna$c != null) {}
    for (String str = this.jdField_b_of_type_Sna$c.jumpUrl;; str = "https://imgcache.qq.com/club/client/flower/release/html/points.html?source=501")
    {
      Intent localIntent = new Intent(this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      localIntent.putExtra("url", str);
      this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a.startActivity(localIntent);
      anot.a(null, "dc00899", "grp_lbs", "", "rank_data", "clk_gift", 0, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akhj
 * JD-Core Version:    0.7.0.1
 */