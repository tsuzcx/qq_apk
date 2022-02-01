package com.tencent.mobileqq.app;

import achs;
import akvm;
import android.database.SQLException;
import android.os.SystemClock;
import android.util.Pair;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageRoamManager$2
  implements Runnable
{
  public MessageRoamManager$2(achs paramachs, String paramString1, String paramString2, String paramString3, Pair paramPair, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {}
    for (long l1 = SystemClock.uptimeMillis();; l1 = 0L)
    {
      this.this$0.app.a().transSaveToDatabase();
      Object localObject2;
      try
      {
        List localList1 = this.this$0.a(this.boG, this.boH, this.boI, ((Long)this.k.first).longValue(), this.Qy);
        if (localList1 == null) {
          break label269;
        }
        localObject2 = new ArrayList(localList1.size());
        Iterator localIterator = localList1.iterator();
        while (localIterator.hasNext()) {
          ((List)localObject2).add((ChatMessage)localIterator.next());
        }
      }
      catch (SQLException localSQLException)
      {
        for (;;)
        {
          List localList2 = ((akvm)this.this$0.app.a().createMessageRecordEntityManager()).query(MessageRecord.class, this.boG, false, this.boI, null, null, null, null, null);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("Q.roammsg.MessageRoamManager", 1, "getMessageByDay: ", localException);
          Object localObject1 = null;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("Q.roammsg.MessageRoamManager", 1, "handlePBGetRoamMsg OutOfMemoryError ! ", localOutOfMemoryError);
      }
      return;
      this.this$0.z(23, localObject2);
      label209:
      if (QLog.isColorLevel())
      {
        long l2 = SystemClock.uptimeMillis();
        localObject2 = new StringBuilder().append("queryMessageByDayFromDB: costTime: ").append(l2 - l1).append(",records num: ");
        if (localOutOfMemoryError != null) {
          break label282;
        }
      }
      label269:
      label282:
      for (int i = 0;; i = localOutOfMemoryError.size())
      {
        QLog.d("Q.roammsg.MessageRoamManager", 2, i);
        return;
        this.this$0.z(22, null);
        break label209;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.2
 * JD-Core Version:    0.7.0.1
 */