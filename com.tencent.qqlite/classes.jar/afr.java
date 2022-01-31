import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.DBUtils;
import mqq.manager.TicketManager;

public class afr
  implements View.OnClickListener
{
  public afr(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    Long localLong;
    do
    {
      do
      {
        return;
        localLong = (Long)paramView.getTag();
        localObject1 = (TroopInfoManager)this.a.app.getManager(33);
      } while (localObject1 == null);
      localObject1 = ((TroopInfoManager)localObject1).a(localLong);
    } while (localObject1 == null);
    DBUtils.a(this.a.app.a(), ((TroopAppInfo)localObject1).appId + "", this.a.a.c, 0);
    this.a.a(paramView, 0, false);
    Object localObject1 = ((TroopAppInfo)localObject1).appUrl.replace("$LANG$", "2052").replace("$UIN$", this.a.app.a()).replace("$GCODE$", this.a.a.c);
    Object localObject2 = (TicketManager)this.a.app.getManager(2);
    if (localObject2 != null) {
      localObject1 = ((String)localObject1).replace("$KEY$", ((TicketManager)localObject2).getStweb(this.a.app.a()));
    }
    for (;;)
    {
      localObject1 = ((String)localObject1).replace("$CLIENTVER$", "5.1");
      localObject2 = new Intent(this.a, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("webStyle", "noBottomBar");
      this.a.startActivity((Intent)localObject2);
      if (this.a.a == null) {
        break;
      }
      ReportController.b(this.a.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_data_appEntry", 0, 0, this.a.a.c, "", "", "" + localLong);
      if (((TextView)paramView.findViewById(2131297872)).getVisibility() != 0) {
        break;
      }
      ReportController.b(this.a.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_data_appEntry_new", 0, 0, this.a.a.c, "", "", "" + localLong);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     afr
 * JD-Core Version:    0.7.0.1
 */