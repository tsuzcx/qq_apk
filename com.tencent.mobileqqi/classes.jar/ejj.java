import com.tencent.mobileqq.activity.messagesearch.MessageResultAdapter;
import com.tencent.mobileqq.activity.messagesearch.MessageResultAdapter.LOAD_TYPE;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.utils.HistoryChatMsgSearchKeyUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.List;

public class ejj
  implements Runnable
{
  public ejj(MessageResultAdapter paramMessageResultAdapter, String paramString, MessageResultAdapter.LOAD_TYPE paramLOAD_TYPE) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(MessageResultAdapter.b(), 2, "loadMessageResult, run(), keyword = " + this.jdField_a_of_type_JavaLangString + ", loadType = " + this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter$LOAD_TYPE.ordinal());
    }
    ??? = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter$LOAD_TYPE == MessageResultAdapter.LOAD_TYPE.LOAD_REFRESH)
    {
      ??? = MessageResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter).a().a(MessageResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter), this.jdField_a_of_type_JavaLangString);
      HistoryChatMsgSearchKeyUtil.a(MessageResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter).a(), this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      ChatHistorySearchData localChatHistorySearchData = MessageResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter, (ChatHistorySearchData)???, localArrayList);
      if (QLog.isColorLevel()) {
        QLog.i(MessageResultAdapter.b(), 2, "loadMessageResult, get: messageItems[] = " + localArrayList);
      }
      synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.jdField_a_of_type_JavaLangObject)
      {
        if (MessageResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter) == this.jdField_a_of_type_JavaLangString)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter$LOAD_TYPE != MessageResultAdapter.LOAD_TYPE.LOAD_REFRESH) {
            break label241;
          }
          MessageResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter, localArrayList);
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.jdField_a_of_type_ComTencentMobileqqDataChatHistorySearchData = localChatHistorySearchData;
          MessageResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter).sendEmptyMessage(2);
        }
        label241:
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter$LOAD_TYPE != MessageResultAdapter.LOAD_TYPE.LOAD_MORE) {
              break;
            }
            ??? = this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.jdField_a_of_type_ComTencentMobileqqDataChatHistorySearchData;
            break;
          } while (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter$LOAD_TYPE != MessageResultAdapter.LOAD_TYPE.LOAD_MORE);
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.jdField_a_of_type_ComTencentMobileqqDataChatHistorySearchData = localChatHistorySearchData;
        } while (localArrayList.size() <= 0);
        MessageResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter).addAll(localArrayList);
        MessageResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter).sendEmptyMessage(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ejj
 * JD-Core Version:    0.7.0.1
 */