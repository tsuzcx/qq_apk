package com.tencent.mobileqq.app.proxy;

import acxt;
import acxt.a;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

public class DataLineMsgProxy$13
  implements Runnable
{
  public DataLineMsgProxy$13(acxt paramacxt, long paramLong, int paramInt, acxt.a parama) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.this$0.app.a().createEntityManager();
    if (acxt.a(this.this$0.a, this.this$0.bqX)) {
      this.this$0.a.transSaveToDatabase(localEntityManager);
    }
    List localList = localEntityManager.rawQuery(DataLineMsgRecord.class, acxt.a(this.this$0, this.Rw, this.val$count), new String[] { String.valueOf(this.Rw) });
    localEntityManager.close();
    new Handler(Looper.getMainLooper()).post(new DataLineMsgProxy.13.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.13
 * JD-Core Version:    0.7.0.1
 */