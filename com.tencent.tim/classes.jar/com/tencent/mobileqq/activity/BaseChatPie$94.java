package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.dingdong.DingdongPluginDataFactory.ScheduleSummaryData;
import com.tencent.tim.dingdong.MessageForDingdongSchedule;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import wki;

class BaseChatPie$94
  implements Runnable
{
  BaseChatPie$94(BaseChatPie paramBaseChatPie, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.this$0.a == null) {}
    int i;
    do
    {
      return;
      if (QLog.isDebugVersion()) {
        QLog.i(this.this$0.TAG, 1, "from : " + this.aLG + "updateScheduleMsg AIO list size is : " + this.this$0.a.getList().size());
      }
      Iterator localIterator = this.this$0.a.getList().iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        if ((localChatMessage instanceof MessageForDingdongSchedule))
        {
          String str = ((MessageForDingdongSchedule)localChatMessage).getSummaryData().id;
          if ((!TextUtils.isEmpty(str)) && (str.equals(this.aLH)))
          {
            if (QLog.isDebugVersion()) {
              QLog.i(this.this$0.TAG, 1, "from : " + this.aLG + "updateScheduleMsg found scheduleId in AIO list : " + str + "     sequence : " + ((MessageForDingdongSchedule)localChatMessage).uniseq);
            }
            if (this.this$0.app != null) {
              if (!localChatMessage.getExtInfoFromExtStr("schedule_msg_accept_status").equals(this.aLI))
              {
                if (QLog.isDebugVersion()) {
                  QLog.i(this.this$0.TAG, 1, "from : " + this.aLG + "updateScheduleMsg schedule message modified : " + str + "  uniseq : " + localChatMessage.uniseq);
                }
                localChatMessage.saveExtInfoToExtStr("schedule_msg_accept_status", this.aLI);
                if (this.aTg) {
                  localChatMessage.saveExtInfoToExtStr("schedule_msg_has_fetch_detail", "1");
                }
                this.this$0.app.b().a(localChatMessage.frienduin, localChatMessage.istroop, localChatMessage.uniseq, "extStr", localChatMessage.getExtInfoString());
                this.this$0.app.b().a(localChatMessage.frienduin, localChatMessage.istroop, localChatMessage.uniseq, "extLong", Integer.valueOf(localChatMessage.extLong));
                i = 1;
              }
            }
          }
        }
        for (;;)
        {
          break;
          if (QLog.isDebugVersion()) {
            QLog.i(this.this$0.TAG, 1, "from : " + this.aLG + "updateScheduleMsg no need to update schedule message through callback : " + localChatMessage.uniseq);
          }
        }
      }
    } while (i == 0);
    this.this$0.uiHandler.post(new BaseChatPie.94.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.94
 * JD-Core Version:    0.7.0.1
 */