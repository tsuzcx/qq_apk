package com.tencent.mobileqq.teamwork.spread;

import acde;
import acqp;
import acxt;
import aetr.b;
import anaz;
import anot;
import aocy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DataLineMessageSpreadManager$2
  implements Runnable
{
  public DataLineMessageSpreadManager$2(aocy paramaocy, DataLineMsgRecord paramDataLineMsgRecord, String paramString1, aetr.b paramb, String paramString2, String paramString3) {}
  
  public void run()
  {
    Object localObject2 = aocy.a(this.this$0).b().a(aocy.a(this.this$0)).a(this.i.sessionid);
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DataLineMessageSpreadManager", 1, "cant find cache msg,uniseq:" + this.i.uniseq);
      }
      localObject2 = this.i;
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      Object localObject1 = this.val$tips;
      if ((this.val$tips.contains("%s")) && (this.a != null)) {}
      DataLineMsgRecord localDataLineMsgRecord;
      for (;;)
      {
        try
        {
          localObject3 = String.format(this.val$tips, new Object[] { this.a.keyword, this.a.keyword });
          localObject1 = localObject3;
          localHashMap.put("tim_aio_file_tips", localObject3);
          localObject1 = localObject3;
          localHashMap.put("tim_aio_file_link", String.format(this.pc, new Object[] { this.a.keyword }));
          localObject1 = localObject3;
        }
        catch (Exception localException)
        {
          Object localObject3;
          Long localLong;
          QLog.e("DataLineMessageSpreadManager", 2, localException.toString());
          continue;
        }
        localHashMap.put("tim_aio_file_msg_uiniseq", String.valueOf(this.i.sessionid));
        localHashMap.put("tim_aio_tips_type", this.ckd);
        if (this.a != null)
        {
          localHashMap.put("tim_aio_tips_template_id", String.valueOf(this.a.templateId));
          localHashMap.put("tim_aio_tips_template_type", String.valueOf(this.a.templateType));
          localHashMap.put("tim_aio_tips_keyword", String.valueOf(this.a.keyword));
          localHashMap.put("tim_aio_tips_type", String.valueOf(this.a.templateType));
        }
        localObject3 = (acde)aocy.a(this.this$0).getBusinessHandler(8);
        localLong = ((acde)localObject3).a(0, aocy.a(this.this$0));
        localDataLineMsgRecord = new DataLineMsgRecord();
        localDataLineMsgRecord.msgId = localLong.longValue();
        localDataLineMsgRecord.sessionid = localLong.longValue();
        localDataLineMsgRecord.msgtype = -5041;
        localDataLineMsgRecord.time = anaz.gQ();
        localDataLineMsgRecord.selfuin = aocy.a(this.this$0).getCurrentAccountUin();
        localDataLineMsgRecord.frienduin = ((DataLineMsgRecord)localObject2).frienduin;
        localDataLineMsgRecord.senderuin = aocy.a(this.this$0).getCurrentAccountUin();
        localDataLineMsgRecord.msg = ((String)localObject1);
        localDataLineMsgRecord.isread = true;
        localDataLineMsgRecord.issend = 0;
        localDataLineMsgRecord.msgseq = ((DataLineMsgRecord)localObject2).shmsgseq;
        localDataLineMsgRecord.shmsgseq = ((DataLineMsgRecord)localObject2).shmsgseq;
        localDataLineMsgRecord.msgUid = ((DataLineMsgRecord)localObject2).msgUid;
        localDataLineMsgRecord.time = anaz.gQ();
        if ((localHashMap == null) || (localHashMap.size() <= 0)) {
          break;
        }
        localObject1 = localHashMap.keySet().iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (String)((Iterator)localObject1).next();
        localDataLineMsgRecord.saveExtInfoToExtStr((String)localObject2, (String)localHashMap.get(localObject2));
        continue;
        localHashMap.put("tim_aio_file_tips", this.val$tips);
        localHashMap.put("tim_aio_file_link", this.pc);
      }
      localDataLineMsgRecord.extraflag |= 0xFFFF7FFF;
      anot.a(aocy.a(this.this$0), "dc00898", "", "", "0X80098F7", "0X80098F7", 0, 0, "", "", "", "");
      aocy.a(this.this$0).a(aocy.a(this.this$0)).c(localDataLineMsgRecord);
      localException.e(11, true, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.DataLineMessageSpreadManager.2
 * JD-Core Version:    0.7.0.1
 */