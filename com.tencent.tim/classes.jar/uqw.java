import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uqw
  implements View.OnClickListener
{
  public uqw(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    ChatSettingForTroop.e(this.this$0);
    aqfr.b("Grp_set_new", "grpData_admin", "clk_quitgrp", 0, 0, new String[] { this.this$0.a.troopUin, aqfr.a(this.this$0.a) });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uqw
 * JD-Core Version:    0.7.0.1
 */