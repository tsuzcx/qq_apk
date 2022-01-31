import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioNewMessageBar;
import com.tencent.mobileqq.widget.ScrollerRunnable;

public class emf
  implements View.OnClickListener
{
  public emf(TroopAioNewMessageBar paramTroopAioNewMessageBar) {}
  
  public void onClick(View paramView)
  {
    TroopAioNewMessageBar.a(this.a);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.b() - 1);
    if (TroopAioNewMessageBar.a(this.a) == TroopAioNewMessageBar.c()) {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_newmsgcue", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
    }
    while (TroopAioNewMessageBar.a(this.a) != TroopAioNewMessageBar.b()) {
      return;
    }
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_backbase", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     emf
 * JD-Core Version:    0.7.0.1
 */