import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.mobileqq.troop.activity.TroopAdminList.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aosv
  implements View.OnClickListener
{
  public aosv(TroopAdminList paramTroopAdminList) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = (TroopAdminList.b)paramView.getTag();
    if (localObject1 != null)
    {
      localObject1 = ((TroopAdminList.b)localObject1).uin;
      if (!this.this$0.app.getCurrentAccountUin().equals(localObject1)) {
        break label60;
      }
      localObject1 = new ProfileActivity.AllInOne((String)localObject1, 0);
    }
    for (;;)
    {
      ProfileActivity.b(this.this$0, (ProfileActivity.AllInOne)localObject1);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label60:
      int i = this.this$0.getIntent().getIntExtra("t_s_f", -1);
      Object localObject2 = ((acff)this.this$0.app.getManager(51)).e((String)localObject1);
      TroopInfo localTroopInfo = ((TroopManager)this.this$0.app.getManager(52)).b(this.this$0.mTroopUin);
      if ((localObject2 != null) && (((Friends)localObject2).isFriend()))
      {
        if (localTroopInfo != null)
        {
          localObject1 = new ProfileActivity.AllInOne((String)localObject1, 20);
          ((ProfileActivity.AllInOne)localObject1).troopUin = this.this$0.aKI;
          ((ProfileActivity.AllInOne)localObject1).troopcode = this.this$0.mTroopUin;
        }
        for (;;)
        {
          ((ProfileActivity.AllInOne)localObject1).nickname = ((Friends)localObject2).name;
          ((ProfileActivity.AllInOne)localObject1).remark = ((Friends)localObject2).remark;
          break;
          localObject1 = new ProfileActivity.AllInOne((String)localObject1, 1);
        }
      }
      if (i == 1002)
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 97);
      }
      else if (localTroopInfo != null)
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 21);
        ((ProfileActivity.AllInOne)localObject1).troopUin = this.this$0.aKI;
        ((ProfileActivity.AllInOne)localObject1).troopcode = this.this$0.mTroopUin;
        ((ProfileActivity.AllInOne)localObject1).subSourceId = 12;
      }
      else
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 23);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("troop_code", this.this$0.aKI);
        ((Bundle)localObject2).putString("troop_uin", this.this$0.mTroopUin);
        ((ProfileActivity.AllInOne)localObject1).data.putBundle("flc_extra_param", (Bundle)localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aosv
 * JD-Core Version:    0.7.0.1
 */