import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.messagesearch.C2CMessageResultAdapter;
import com.tencent.mobileqq.activity.messagesearch.MessageItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.HashMap;
import java.util.List;

public class wnx
  implements Runnable
{
  public wnx(C2CMessageResultAdapter paramC2CMessageResultAdapter, String paramString, long paramLong, List paramList) {}
  
  public void run()
  {
    int j = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangString);
    int i;
    MessageRecord localMessageRecord;
    if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData1 != null) && (!((ChatHistorySearchData)localObject).mSearchData1.isEmpty()))
    {
      i = 0;
      while (i < ((ChatHistorySearchData)localObject).mSearchData1.size())
      {
        localMessageRecord = (MessageRecord)((ChatHistorySearchData)localObject).mSearchData1.get(i);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.a(localMessageRecord)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.b.add(new MessageItem(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord));
        }
        i += 1;
      }
    }
    if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData2 != null) && (!((ChatHistorySearchData)localObject).mSearchData2.isEmpty()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((ChatHistorySearchData)localObject).mSearchData2);
      if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData1 != null))
      {
        i = j;
        while (i < ((ChatHistorySearchData)localObject).mSearchData1.size())
        {
          localMessageRecord = (MessageRecord)((ChatHistorySearchData)localObject).mSearchData1.get(i);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.a(localMessageRecord)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.b.add(new MessageItem(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord));
          }
          i += 1;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CMessageResultAdapter", 2, "localCacheMsgs size: " + this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.b.size());
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("keyword", this.jdField_a_of_type_JavaLangString);
    ((HashMap)localObject).put("sequence", Long.valueOf(this.jdField_a_of_type_Long));
    ((HashMap)localObject).put("data", this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(6, localObject).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wnx
 * JD-Core Version:    0.7.0.1
 */