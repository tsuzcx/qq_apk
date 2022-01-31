import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;

public class cbe
  implements View.OnClickListener
{
  public cbe(TroopChatPie paramTroopChatPie) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = new TroopFeedsCenterLogic(TroopChatPie.a(this.a), TroopChatPie.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, TroopChatPie.a(this.a), TroopChatPie.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cbe
 * JD-Core Version:    0.7.0.1
 */