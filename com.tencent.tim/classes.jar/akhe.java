import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akhe
  implements View.OnClickListener
{
  public akhe(NearbyProfileFragment paramNearbyProfileFragment, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.b.a, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.bTq);
    this.b.a.startActivity((Intent)localObject);
    anov localanov = new anov(this.b.a.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_click");
    String str1 = "" + (NearbyProfileFragment.a(this.b).gender + 1);
    String str2 = "" + this.dmP;
    if (this.b.a.mMode == 3) {}
    for (localObject = "2";; localObject = "1")
    {
      localanov.a(new String[] { "", str1, str2, localObject }).report();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akhe
 * JD-Core Version:    0.7.0.1
 */