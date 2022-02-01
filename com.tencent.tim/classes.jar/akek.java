import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.13;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.13.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akek
  implements View.OnClickListener
{
  public akek(NearbyProfileDisplayTribePanel.13.1 param1) {}
  
  public void onClick(View paramView)
  {
    if (TextUtils.isEmpty(akef.a(this.a.a.this$0).strGodJumpUrl))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    Object localObject1 = new Intent(this.a.a.this$0.a, QQBrowserActivity.class);
    Object localObject2 = new StringBuilder().append(akef.a(this.a.a.this$0).strGodJumpUrl).append("&gender=");
    int i;
    if (this.a.i == null)
    {
      i = 0;
      label98:
      ((Intent)localObject1).putExtra("url", i);
      this.a.a.this$0.a.startActivity((Intent)localObject1);
      localObject2 = this.a.a.this$0.a.app;
      if (this.a.a.this$0.a.mMode != 2) {
        break label215;
      }
    }
    label215:
    for (localObject1 = "1";; localObject1 = "2")
    {
      anot.a((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "rank_list", "clk_icon", 0, 0, (String)localObject1, "", "", "");
      break;
      i = this.a.i.shGender + 1;
      break label98;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akek
 * JD-Core Version:    0.7.0.1
 */