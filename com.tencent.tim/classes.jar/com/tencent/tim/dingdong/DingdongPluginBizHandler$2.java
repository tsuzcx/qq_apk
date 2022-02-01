package com.tencent.tim.dingdong;

import acxw;
import android.text.TextUtils;
import atnf;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class DingdongPluginBizHandler$2
  implements Runnable
{
  public DingdongPluginBizHandler$2(atnf paramatnf, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    label10:
    Iterator localIterator;
    if (this.this$0.app == null) {
      return;
    } else {
      localIterator = this.this$0.app.a().a().q(true).iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label10;
      }
      Object localObject1 = (RecentUser)localIterator.next();
      Object localObject2 = ((RecentUser)localObject1).uin;
      localObject1 = this.this$0.app.b().k((String)localObject2, ((RecentUser)localObject1).getType());
      if ((localObject1 == null) || (((List)localObject1).size() == 0)) {
        break;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((localObject2 instanceof MessageForDingdongSchedule))
        {
          String str = ((MessageForDingdongSchedule)localObject2).getSummaryData().id;
          if ((!TextUtils.isEmpty(str)) && (str.equals(this.aLH)))
          {
            if (QLog.isDebugVersion()) {
              QLog.i("DingdongPluginBizHandler", 1, "from : " + this.aLG + "updateScheduleMsg found scheduleId in AIO list : " + str + "     sequence : " + ((MessageForDingdongSchedule)localObject2).uniseq);
            }
            if (!((MessageRecord)localObject2).getExtInfoFromExtStr("schedule_msg_accept_status").equals(this.aLI))
            {
              if (QLog.isDebugVersion()) {
                QLog.i("DingdongPluginBizHandler", 1, "from : " + this.aLG + "updateScheduleMsg schedule message modified : " + str + "   uniseq : " + ((MessageRecord)localObject2).uniseq);
              }
              ((MessageRecord)localObject2).saveExtInfoToExtStr("schedule_msg_accept_status", this.aLI);
              this.this$0.app.b().a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, "extStr", ((MessageRecord)localObject2).getExtInfoString());
              this.this$0.app.b().a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, "extLong", Integer.valueOf(((MessageRecord)localObject2).extLong));
            }
            else if (QLog.isDebugVersion())
            {
              QLog.i("DingdongPluginBizHandler", 1, "from : " + this.aLG + "updateScheduleMsg no need to update schedule message through callback : " + ((MessageRecord)localObject2).uniseq);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.dingdong.DingdongPluginBizHandler.2
 * JD-Core Version:    0.7.0.1
 */