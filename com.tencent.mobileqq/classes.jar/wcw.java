import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.statistics.ReportController;

public class wcw
  implements View.OnClickListener
{
  public wcw(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.m = true;
    this.a.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
    if (this.a.b != null) {
      this.a.b.setVisibility(0);
    }
    if (this.a.j != null) {
      this.a.j.setVisibility(0);
    }
    if (this.a.k != null) {
      this.a.k.setVisibility(0);
    }
    this.a.ap();
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.b(this.a.a()) != 0) {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005EC5", "0X8005EC5", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wcw
 * JD-Core Version:    0.7.0.1
 */