import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

public class byc
  implements View.OnClickListener
{
  public byc(ChatActivity paramChatActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a.jdField_a_of_type_Int == 1008) || (CrmUtils.a(this.a.b, this.a.a.jdField_a_of_type_JavaLangString)))
    {
      ChatActivity.a(this.a).a();
      ChatActivity.b(this.a, false);
      this.a.e();
      ReportController.b(this.a.b, "P_CliOper", "Pb_account_lifeservice", this.a.b.getAccount(), "mp_msg_zhushou_5", "share_succ", 0, 0, "", "", "", "");
      return;
    }
    this.a.b.a(this.a.a.jdField_a_of_type_JavaLangString, Integer.valueOf(4));
    ChatActivity.a(this.a).a();
    ChatActivity.c(this.a, false);
    TroopAssistantManager.a().a(this.a.b, this.a.a.jdField_a_of_type_JavaLangString);
    QQToast.a(this.a, 2, 2131563074, 0).b(this.a.d());
    ReportController.b(this.a.b, "P_CliOper", "Grp_msg", "", "AIOchat", "Clk_setmsg", 0, 0, this.a.a.jdField_a_of_type_JavaLangString, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     byc
 * JD-Core Version:    0.7.0.1
 */