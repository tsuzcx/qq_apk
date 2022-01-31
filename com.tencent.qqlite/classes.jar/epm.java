import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView.FlingGestureListener;

public class epm
  extends TroopAioFeedsCenterView.FlingGestureListener
{
  public epm(TroopFeedsCenterLogic paramTroopFeedsCenterLogic) {}
  
  public void a()
  {
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_fold", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "1", "", "");
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     epm
 * JD-Core Version:    0.7.0.1
 */