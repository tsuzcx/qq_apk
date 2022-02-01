import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class akeo
  implements ausj.a
{
  akeo(aken paramaken, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (this.val$actionSheet != null) {
        this.val$actionSheet.dismiss();
      }
      return;
    }
    this.a.this$0.crS = true;
    Object localObject1 = this.a.this$0.a.e.uin;
    paramView = (View)localObject1;
    if (aqmr.isEmpty((String)localObject1))
    {
      paramView = (View)localObject1;
      if (akef.a(this.a.this$0) != null) {
        paramView = akef.a(this.a.this$0).uin;
      }
    }
    if (aqmr.isEmpty(paramView)) {
      paramView = "0";
    }
    for (;;)
    {
      long l;
      if (this.a.this$0.a.adP == 0L) {
        if (akef.a(this.a.this$0) != null)
        {
          l = akef.a(this.a.this$0).tinyId;
          label160:
          if ((!"0".equals(paramView)) || (l != 0L))
          {
            Object localObject2 = null;
            paramInt = 20003;
            localObject1 = null;
            if (this.a.this$0.a.app != null) {
              localObject1 = this.a.this$0.a.app.a(false);
            }
            if (((localObject1 == null) || (!((HotChatManager)localObject1).kj(this.a.this$0.a.e.troopUin))) && (this.a.this$0.a.e.bJa != 33) && (this.a.this$0.a.e.bJa != 4))
            {
              localObject1 = localObject2;
              if (this.a.this$0.a.e.bJa != 31) {}
            }
            else
            {
              paramInt = 20012;
              localObject1 = this.a.this$0.a.e.troopUin;
            }
            stj.a(this.a.this$0.a, this.a.this$0.a.adP, paramView, (String)localObject1, paramInt, "", this.a.this$0.a.e.ae);
          }
          anot.a(this.a.this$0.a.app, "CliOper", "", "", "0X8004828", "0X8004828", 0, 0, "", "", "", "");
          if ((akef.a(this.a.this$0) != null) && (akef.a(this.a.this$0).iIsGodFlag == 1))
          {
            if (akef.a(this.a.this$0).gender != 0) {
              break label622;
            }
            anot.a(this.a.this$0.a.app, "CliOper", "", "", "0X800528E", "0X800528E", 0, 0, "", "", "", "");
          }
        }
      }
      for (;;)
      {
        anot.a(this.a.this$0.a.app, "dc00899", "grp_lbs", "", "data_card", "clk_report", 0, 0, "", "", "", "");
        if (!ProfileActivity.gg(this.a.this$0.a.e.bJa)) {
          break;
        }
        anot.a(this.a.this$0.a.app, "CliOper", "", "", "0X800523E", "0X800523E", 0, 0, "", "", "", "");
        break;
        l = 0L;
        break label160;
        l = this.a.this$0.a.adP;
        break label160;
        label622:
        if (akef.a(this.a.this$0).gender == 1) {
          anot.a(this.a.this$0.a.app, "CliOper", "", "", "0X800528F", "0X800528F", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akeo
 * JD-Core Version:    0.7.0.1
 */