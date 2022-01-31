import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.qphone.base.util.QLog;

class wdf
  implements Runnable
{
  wdf(wde paramwde) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "do delete uniseq=" + this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq + ",id=" + this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getId());
    }
    QSlowTableManager localQSlowTableManager = (QSlowTableManager)this.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.a.getManager(200);
    if (localQSlowTableManager != null) {
      localQSlowTableManager.a(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage, false);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.a.a().a(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage, true);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForApollo)) {
      SpriteCommFunc.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListForTroopFragment.a, "chat_history_start_del_msg");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wdf
 * JD-Core Version:    0.7.0.1
 */