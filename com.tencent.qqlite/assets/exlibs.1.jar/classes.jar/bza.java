import android.os.Handler;
import android.view.View;
import com.tencent.biz.ui.CustomMenuBar.OnMenuItemClickListener;
import com.tencent.crmqq.structmsg.StructMsg.ButtonInfo;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.statistics.ReportController;

public class bza
  implements CustomMenuBar.OnMenuItemClickListener
{
  public bza(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    BusinessCmrTmpChatPie.a(this.a).setVisibility(0);
    BusinessCmrTmpChatPie.a(this.a).sendEmptyMessageDelayed(0, 10000L);
    StructMsg.ButtonInfo localButtonInfo = BusinessCmrTmpChatPie.a(this.a, paramInt1);
    EnterpriseQQManager.a(BusinessCmrTmpChatPie.b(this.a)).a(paramString, this.a.a(), BusinessCmrTmpChatPie.a(this.a), this.a.a(), localButtonInfo);
    ReportController.b(BusinessCmrTmpChatPie.c(this.a), "P_CliOper", "Bqq_Crm", "", "Aio_menu", "Clk_menu", 0, 0, this.a.a(), paramInt1 + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bza
 * JD-Core Version:    0.7.0.1
 */