import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.qphone.base.util.QLog;

public class vut
  implements Runnable
{
  public vut(HotChatPie paramHotChatPie) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getVisibility() == 0) {
      this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(4);
    }
    int i = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount();
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) && (this.a.r != i)) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(true);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a() > 0)) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.c(4);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPieQ.hotchat.aio_post_red_point", 2, "update, mLastMsgCountBeforeSwitch2PostTab:" + this.a.r + ",current msgItemCount:" + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vut
 * JD-Core Version:    0.7.0.1
 */