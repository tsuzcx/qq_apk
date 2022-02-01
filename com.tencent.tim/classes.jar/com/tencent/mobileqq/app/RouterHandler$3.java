package com.tencent.mobileqq.app;

import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgHeader;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RouterMsgRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class RouterHandler$3
  implements Runnable
{
  RouterHandler$3(RouterHandler paramRouterHandler, long paramLong, MsgHeader paramMsgHeader) {}
  
  public void run()
  {
    Object localObject2 = (Session)this.this$0.iF.get(Long.valueOf(this.EN));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.this$0.app.a().createEntityManager();
      List localList = ((EntityManager)localObject1).rawQuery(RouterMsgRecord.class, "select * from " + RouterMsgRecord.sBasicTableName + this.a.uint64_src_uin + " where uSessionID=?", new String[] { String.valueOf(this.EN) });
      ((EntityManager)localObject1).close();
      if ((localList == null) || (localList.size() <= 0)) {
        break label265;
      }
      localObject1 = (RouterMsgRecord)localList.get(0);
      localObject2 = this.this$0.a.genSession(0, ((RouterMsgRecord)localObject1).filename, null, 0, 0, this.EN, 0, 0, 0);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        if (0L == ((Session)localObject2).uSessionID) {
          ((Session)localObject2).uSessionID = this.this$0.b.generateSessionID(0);
        }
        ((Session)localObject2).msgHeader = this.this$0.a.msgHeader(this.a.uint64_src_uin);
        this.this$0.a.fillService((Session)localObject2, null, null);
        this.this$0.iF.put(Long.valueOf(((Session)localObject2).uSessionID), localObject2);
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null)
    {
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(localObject1);
      this.this$0.A((ArrayList)localObject2, true);
    }
    label265:
    while (!QLog.isColorLevel())
    {
      return;
      localObject1 = localObject2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("dataline.Router", 2, "cannot find session from db and memory, sessiondi=" + this.EN);
      localObject1 = localObject2;
      break;
    }
    QLog.d("dataline.Router", 2, "cannot handle session, sessiondi=" + this.EN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.RouterHandler.3
 * JD-Core Version:    0.7.0.1
 */