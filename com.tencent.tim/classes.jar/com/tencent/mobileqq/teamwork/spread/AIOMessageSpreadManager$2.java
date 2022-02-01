package com.tencent.mobileqq.teamwork.spread;

import aeur.b;
import agkf;
import aocq;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class AIOMessageSpreadManager$2
  implements Runnable
{
  public AIOMessageSpreadManager$2(aocq paramaocq, ChatMessage paramChatMessage, String paramString1, aeur.b paramb, String paramString2, String paramString3) {}
  
  public void run()
  {
    Object localObject1 = aocq.a(this.this$0).b().a(this.y.frienduin, this.y.istroop, this.y.uniseq);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AIOMessageSpreadManager", 1, "cant find cache msg,uniseq:" + this.y.uniseq);
      }
      localObject2 = this.y;
    }
    HashMap localHashMap = new HashMap();
    localObject1 = this.val$tips;
    if ((this.val$tips.contains("%s")) && (this.a != null)) {}
    for (;;)
    {
      try
      {
        String str = String.format(this.val$tips, new Object[] { this.a.keyword, this.a.keyword });
        localObject1 = str;
        localHashMap.put("tim_aio_file_tips", str);
        localObject1 = str;
        localHashMap.put("tim_aio_file_link", String.format(this.pc, new Object[] { this.a.keyword }));
        localObject1 = str;
      }
      catch (Exception localException)
      {
        long l;
        QLog.e("AIOMessageSpreadManager", 2, localException.toString());
        continue;
      }
      localHashMap.put("tim_aio_file_msg_uiniseq", String.valueOf(((MessageRecord)localObject2).uniseq));
      localHashMap.put("tim_aio_tips_type", this.ckd);
      if (this.a != null)
      {
        localHashMap.put("tim_aio_tips_template_id", String.valueOf(this.a.templateId));
        localHashMap.put("tim_aio_tips_template_type", String.valueOf(this.a.templateType));
        localHashMap.put("tim_aio_tips_keyword", String.valueOf(this.a.keyword));
        localHashMap.put("tim_aio_tips_type", String.valueOf(this.a.templateType));
      }
      l = aocq.a(this.this$0).a().a(((MessageRecord)localObject2).frienduin, aocq.a(this.this$0).getCurrentAccountUin(), ((MessageRecord)localObject2).istroop, -3016, localHashMap, (String)localObject1, ((MessageRecord)localObject2).msgUid, ((MessageRecord)localObject2).shmsgseq, ((MessageRecord)localObject2).time);
      if (QLog.isDebugVersion()) {
        QLog.i("AIOMessageSpreadManager", 1, "insertGaryTips:" + l + "findMsg:" + localObject2.hashCode());
      }
      ((MessageRecord)localObject2).saveExtInfoToExtStr("tim_aio_gary_uniseq", String.valueOf(l));
      aocq.a(this.this$0).b().a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, "extStr", ((MessageRecord)localObject2).getExtInfoString());
      aocq.a(this.this$0).b().a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, "extLong", Integer.valueOf(((MessageRecord)localObject2).extLong));
      return;
      localHashMap.put("tim_aio_file_tips", this.val$tips);
      localHashMap.put("tim_aio_file_link", this.pc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager.2
 * JD-Core Version:    0.7.0.1
 */