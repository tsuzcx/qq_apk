import android.os.Handler;
import android.view.View;
import com.tencent.biz.ui.CustomMenuBar.OnMenuItemClickListener;
import com.tencent.crmqq.structmsg.StructMsg.ButtonInfo;
import com.tencent.mobileqq.activity.ChatForEnterpriseActivity;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.statistics.ReportController;

public class cbb
  implements CustomMenuBar.OnMenuItemClickListener
{
  public cbb(ChatForEnterpriseActivity paramChatForEnterpriseActivity) {}
  
  public void a(String paramString, int paramInt)
  {
    ChatForEnterpriseActivity.a(this.a).setVisibility(0);
    ChatForEnterpriseActivity.a(this.a).sendEmptyMessageDelayed(0, 10000L);
    StructMsg.ButtonInfo localButtonInfo = ChatForEnterpriseActivity.a(this.a, paramInt);
    EnterpriseQQManager.a(this.a.b).a(paramString, this.a.a(), this.a.b, this.a.c(), localButtonInfo);
    ReportController.b(this.a.b, "P_CliOper", "Bqq_Crm", "", "Aio_menu", "Clk_menu", 0, 0, this.a.c(), paramInt + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cbb
 * JD-Core Version:    0.7.0.1
 */