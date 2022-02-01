import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class upp
  implements View.OnClickListener
{
  public upp(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131369579: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        ChatSettingForTroop.f(this.this$0);
        this.this$0.finish();
      }
    }
    ChatSettingForTroop.g(this.this$0);
    String str1;
    label80:
    String str3;
    if (this.this$0.a.isMember)
    {
      str1 = "grpData_admin";
      str3 = this.this$0.a.troopUin;
      if (!this.this$0.a.isMember) {
        break label148;
      }
    }
    label148:
    for (String str2 = aqfr.a(this.this$0.a);; str2 = "0")
    {
      aqfr.b("Grp_set_new", str1, "clk_upright", 0, 0, new String[] { str3, str2 });
      break;
      str1 = "grpData_visitor";
      break label80;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     upp
 * JD-Core Version:    0.7.0.1
 */