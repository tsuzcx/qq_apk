import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.RecommendTroopInfo;
import com.tencent.mobileqq.newfriend.RecommendTroopMessage;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

public class ghv
  implements View.OnClickListener
{
  ghv(RecommendTroopMessage paramRecommendTroopMessage) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(RecommendTroopMessage.a(this.a), "P_CliOper", "Grp_contacts", "", "Grp_ask", "Clk_oneblue_join", 0, 0, "", "", "", "");
    paramView = (RecommendTroopInfo)RecommendTroopMessage.a(this.a).get(0);
    TroopHandler localTroopHandler = (TroopHandler)RecommendTroopMessage.a(this.a).a(1);
    if (localTroopHandler != null) {
      RecommendTroopMessage.a(this.a).a(this.a.a);
    }
    try
    {
      localTroopHandler.a(Long.parseLong(paramView.uin), 8388736);
      return;
    }
    catch (Exception paramView)
    {
      RecommendTroopMessage.a(this.a).c(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ghv
 * JD-Core Version:    0.7.0.1
 */