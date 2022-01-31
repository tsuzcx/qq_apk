import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class wcy
  implements Runnable
{
  public wcy(ChatHistoryBubbleListForTroopFragment paramChatHistoryBubbleListForTroopFragment) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(this.a.jdField_a_of_type_JavaLangString, 1, this.a.c);
    if (localMessageRecord != null)
    {
      List localList = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_JavaLangString, 1, localMessageRecord.shmsgseq, 20);
      localList.add(0, localMessageRecord);
      ThreadManager.getUIHandler().post(new wcz(this, localList));
      return;
    }
    TroopTechReportUtils.a("chat_history", "target_404", String.valueOf(this.a.c), String.valueOf(this.a.b), "", "");
    if (QLog.isColorLevel()) {
      QLog.e("chatHistory.troop.msgList", 2, "msg not found, fallback to loadData");
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wcy
 * JD-Core Version:    0.7.0.1
 */