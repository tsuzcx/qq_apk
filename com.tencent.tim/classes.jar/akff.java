import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class akff
  implements akho
{
  akff(akef paramakef, String paramString) {}
  
  public void a(View paramView, int paramInt, InterestTagInfo paramInterestTagInfo)
  {
    if (paramInterestTagInfo.tagJumpUrl.equals("icon_more_url"))
    {
      paramView = new Intent(this.this$0.a, QQBrowserActivity.class);
      paramView.putExtra("url", this.bTm);
      this.this$0.a.startActivity(paramView);
      paramInterestTagInfo = this.this$0.a.app;
      if (this.this$0.a.mMode == 2) {}
      for (paramView = "1";; paramView = "2")
      {
        anot.a(paramInterestTagInfo, "dc00899", "grp_lbs", "", "data_card", "clk_more_tribe", 0, 0, paramView, "", "", "");
        return;
      }
    }
    paramView = new Intent(this.this$0.a, QQBrowserActivity.class);
    paramView.putExtra("url", paramInterestTagInfo.tagJumpUrl);
    this.this$0.a.startActivity(paramView);
    paramInterestTagInfo = this.this$0.a.app;
    if (this.this$0.a.mMode == 2) {}
    for (paramView = "1";; paramView = "2")
    {
      anot.a(paramInterestTagInfo, "dc00899", "grp_lbs", "", "data_card", "clk_tribe", 0, 0, paramView, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akff
 * JD-Core Version:    0.7.0.1
 */