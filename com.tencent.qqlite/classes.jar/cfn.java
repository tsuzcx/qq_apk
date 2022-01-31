import android.os.Message;
import com.tencent.mobileqq.activity.messagesearch.MessageResultAdapter;
import com.tencent.mobileqq.activity.messagesearch.MessageResultAdapter.LOAD_TYPE;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.utils.HistoryChatMsgSearchKeyUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;

public class cfn
  implements Runnable
{
  public cfn(MessageResultAdapter paramMessageResultAdapter, String paramString, MessageResultAdapter.LOAD_TYPE paramLOAD_TYPE) {}
  
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
      Object localObject2 = new ArrayList();
      ChatHistorySearchData localChatHistorySearchData = MessageResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter, (ChatHistorySearchData)???, (ArrayList)localObject2);
      if (QLog.isColorLevel()) {
        QLog.i(MessageResultAdapter.b(), 2, "loadMessageResult, get: messageItems[] = " + localObject2);
      }
      synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.jdField_a_of_type_JavaLangObject)
      {
        if (MessageResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter) == this.jdField_a_of_type_JavaLangString)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter$LOAD_TYPE != MessageResultAdapter.LOAD_TYPE.LOAD_REFRESH) {
            break label247;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.jdField_a_of_type_ComTencentMobileqqDataChatHistorySearchData = localChatHistorySearchData;
          localObject2 = MessageResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter).obtainMessage(2, localObject2);
          ((Message)localObject2).arg1 = MessageResultAdapter.LOAD_TYPE.LOAD_REFRESH.mValue;
          ((Message)localObject2).sendToTarget();
        }
        label247:
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
        } while (((ArrayList)localObject2).size() <= 0);
        localObject2 = MessageResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter).obtainMessage(2, localObject2);
        ((Message)localObject2).arg1 = MessageResultAdapter.LOAD_TYPE.LOAD_MORE.mValue;
        ((Message)localObject2).sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cfn
 * JD-Core Version:    0.7.0.1
 */