import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.16.1.1;

public class akde
  implements ausj.a
{
  akde(akdd paramakdd, ausj paramausj) {}
  
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
    if (akcx.a(this.a.this$0).nowUserType == 1)
    {
      ThreadManagerV2.getUIHandlerV2().postDelayed(new NearbyProfileDisplayPanel.16.1.1(this), 500L);
      this.val$actionSheet.dismiss();
      return;
    }
    this.a.this$0.crS = true;
    Object localObject1 = this.a.this$0.a.e.uin;
    paramView = (View)localObject1;
    if (aqmr.isEmpty((String)localObject1))
    {
      paramView = (View)localObject1;
      if (akcx.a(this.a.this$0) != null) {
        paramView = akcx.a(this.a.this$0).uin;
      }
    }
    if (aqmr.isEmpty(paramView)) {
      paramView = "0";
    }
    for (;;)
    {
      long l;
      if (this.a.this$0.a.adP == 0L) {
        if (akcx.a(this.a.this$0) != null)
        {
          l = akcx.a(this.a.this$0).tinyId;
          label203:
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
          if ((akcx.a(this.a.this$0) != null) && (akcx.a(this.a.this$0).iIsGodFlag == 1))
          {
            if (akcx.a(this.a.this$0).gender != 0) {
              break label673;
            }
            anot.a(this.a.this$0.a.app, "CliOper", "", "", "0X800528E", "0X800528E", 0, 0, "", "", "", "");
          }
        }
      }
      for (;;)
      {
        anot.a(this.a.this$0.a.app, "dc00899", "grp_lbs", akcx.a(this.a.this$0), "data_card", "clk_report", 0, 0, "", "", "", "");
        if (!ProfileActivity.gg(this.a.this$0.a.e.bJa)) {
          break;
        }
        anot.a(this.a.this$0.a.app, "CliOper", "", "", "0X800523E", "0X800523E", 0, 0, "", "", "", "");
        break;
        l = 0L;
        break label203;
        l = this.a.this$0.a.adP;
        break label203;
        label673:
        if (akcx.a(this.a.this$0).gender == 1) {
          anot.a(this.a.this$0.a.app, "CliOper", "", "", "0X800528F", "0X800528F", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akde
 * JD-Core Version:    0.7.0.1
 */