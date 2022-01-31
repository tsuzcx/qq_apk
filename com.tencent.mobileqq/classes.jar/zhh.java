import android.database.SQLException;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class zhh
  implements Runnable
{
  public zhh(MessageRoamManager paramMessageRoamManager, String paramString1, String paramString2, String paramString3, Pair paramPair, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {}
    for (long l1 = SystemClock.uptimeMillis();; l1 = 0L)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a.a().d();
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a.getHandler(ChatHistoryForC2C.class);
      ArrayList localArrayList;
      try
      {
        List localList1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(this.jdField_a_of_type_JavaLangString, this.b, this.c, ((Long)this.jdField_a_of_type_AndroidUtilPair.first).longValue(), this.jdField_a_of_type_Long);
        if (localList1 == null) {
          break label313;
        }
        localObject2 = localMqqHandler.obtainMessage(23);
        localArrayList = new ArrayList(localList1.size());
        Iterator localIterator = localList1.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add((ChatMessage)localIterator.next());
        }
      }
      catch (SQLException localSQLException)
      {
        for (;;)
        {
          List localList2 = ((MessageRecordEntityManager)this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a.getEntityManagerFactory().createMessageRecordEntityManager()).a(MessageRecord.class, this.jdField_a_of_type_JavaLangString, false, this.c, null, null, null, null, null);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            localException.printStackTrace();
            QLog.d("Q.roammsg.MessageRoamManager", 2, "getMessageByDay: ", localException);
          }
          Object localObject1 = null;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.roammsg.MessageRoamManager", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", localOutOfMemoryError);
        }
      }
      do
      {
        return;
        ((Message)localObject2).obj = localArrayList;
        localMqqHandler.sendMessage((Message)localObject2);
      } while (!QLog.isColorLevel());
      long l2 = SystemClock.uptimeMillis();
      Object localObject2 = new StringBuilder().append("queryMessageByDayFromDB: costTime: ").append(l2 - l1).append(",records num: ");
      if (localOutOfMemoryError == null) {}
      for (int i = 0;; i = localOutOfMemoryError.size())
      {
        QLog.d("Q.roammsg.MessageRoamManager", 2, i);
        return;
        label313:
        localObject2 = localMqqHandler.obtainMessage(22);
        ((Message)localObject2).obj = null;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zhh
 * JD-Core Version:    0.7.0.1
 */