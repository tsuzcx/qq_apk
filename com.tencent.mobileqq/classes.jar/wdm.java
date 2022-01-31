import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;

public class wdm
  implements View.OnClickListener
{
  public wdm(TroopAssistTipsBar paramTroopAssistTipsBar) {}
  
  public void onClick(View paramView)
  {
    TroopAssistTipsBar.a(this.a).a(TroopAssistTipsBar.a(this.a).a, Integer.valueOf(4));
    TroopAssistTipsBar.a(this.a).a();
    TroopAssistantManager.a().c(TroopAssistTipsBar.a(this.a).a, TroopAssistTipsBar.a(this.a));
    TroopAssistantManager.a().c(TroopAssistTipsBar.a(this.a), TroopAssistTipsBar.a(this.a).a);
    ReportController.b(TroopAssistTipsBar.a(this.a), "P_CliOper", "Grp_msg", "", "AIOchat", "Clk_setmsg", 0, 0, TroopAssistTipsBar.a(this.a).a, "", "", "");
    QQAppInterface localQQAppInterface = TroopAssistTipsBar.a(this.a);
    String str = TroopAssistTipsBar.a(this.a).a;
    if (TroopAssistTipsBar.a(this.a).b(TroopAssistTipsBar.a(this.a).a) == 3) {}
    for (paramView = "1";; paramView = "0")
    {
      ReportController.b(localQQAppInterface, "dc00899", "Grp_msg", "", "aio-topbar", "Clk_confirm", 0, 0, str, paramView, "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wdm
 * JD-Core Version:    0.7.0.1
 */