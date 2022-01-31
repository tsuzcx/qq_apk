import android.os.Handler;
import android.view.View;
import com.tencent.biz.ui.CustomMenuBar.OnMenuItemClickListener;
import com.tencent.crmqq.structmsg.StructMsg.ButtonInfo;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.statistics.ReportController;

public class vny
  implements CustomMenuBar.OnMenuItemClickListener
{
  public vny(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.m = true;
    this.a.p.setVisibility(0);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 10000L);
    StructMsg.ButtonInfo localButtonInfo = this.a.a(paramInt1);
    EnterpriseQQManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramString, this.a.a(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a(), localButtonInfo);
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Bqq_Crm", "", "Aio_menu", "Clk_menu", 0, 0, this.a.a(), paramInt1 + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vny
 * JD-Core Version:    0.7.0.1
 */