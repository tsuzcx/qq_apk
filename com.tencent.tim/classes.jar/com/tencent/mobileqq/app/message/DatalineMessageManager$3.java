package com.tencent.mobileqq.app.message;

import acqp;
import acxt;
import acxw;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Map;
import top;

public class DatalineMessageManager$3
  implements Runnable
{
  public DatalineMessageManager$3(acqp paramacqp, DataLineMsgSet paramDataLineMsgSet) {}
  
  public void run()
  {
    boolean bool = false;
    Object localObject1;
    int i;
    if (this.this$0.a().b(this.b) > 0)
    {
      localObject1 = top.u(String.valueOf(this.this$0.bqy), this.this$0.czi);
      if (!this.this$0.b.gP.containsKey(localObject1)) {
        break label406;
      }
      bool = ((QQMessageFacade.Message)this.this$0.b.gP.get(localObject1)).hasReply;
      i = ((QQMessageFacade.Message)this.this$0.b.gP.get(localObject1)).counter;
      this.this$0.b.gP.remove(localObject1);
    }
    for (;;)
    {
      long l = this.this$0.a().a().size();
      if (l > 0L)
      {
        localObject2 = this.this$0.a().a();
        localObject1 = localObject2;
        if (localObject2 != null) {
          if ((((DataLineMsgRecord)localObject2).msgtype != -5000) && (((DataLineMsgRecord)localObject2).msgtype != -5041))
          {
            localObject1 = localObject2;
            if (((DataLineMsgRecord)localObject2).msgtype != -2073) {}
          }
          else
          {
            localObject1 = localObject2;
            if (l > 1L) {
              localObject1 = this.this$0.a().a().get((int)(l - 2L)).getLastItem();
            }
          }
        }
        localObject2 = new QQMessageFacade.Message();
        if (localObject1 != null)
        {
          MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject2, (MessageRecord)localObject1);
          ((QQMessageFacade.Message)localObject2).emoRecentMsg = null;
          ((QQMessageFacade.Message)localObject2).counter = i;
          ((QQMessageFacade.Message)localObject2).hasReply = bool;
          this.this$0.b.b((QQMessageFacade.Message)localObject2);
          this.this$0.b.gP.put(top.u(String.valueOf(this.this$0.bqy), this.this$0.czi), localObject2);
        }
      }
      Object localObject2 = this.this$0.app.a().a();
      localObject1 = this.this$0.app.a().createEntityManager();
      localObject2 = ((acxw)localObject2).a(String.valueOf(this.this$0.bqy), this.this$0.czi);
      ((EntityManager)localObject1).close();
      if (localObject2 != null) {
        this.this$0.b.as(localObject2);
      }
      return;
      label406:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DatalineMessageManager.3
 * JD-Core Version:    0.7.0.1
 */