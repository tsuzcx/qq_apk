package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import xci;

public class GrayTipsItemBuilder$23
  implements Runnable
{
  public GrayTipsItemBuilder$23(xci paramxci, String paramString1, int paramInt, long paramLong, String paramString2) {}
  
  public void run()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null)
    {
      localObject = (QQMessageFacade)((AppRuntime)localObject).getManager(20);
      if (localObject != null)
      {
        MessageRecord localMessageRecord = ((QQMessageFacade)localObject).a(this.aUL, this.bTa, this.IR);
        if ((localMessageRecord != null) && (!TextUtils.equals(localMessageRecord.getExtInfoFromExtStr("sens_msg_original_text"), this.aUM)))
        {
          localMessageRecord.saveExtInfoToExtStr("sens_msg_original_text", this.aUM);
          ((QQMessageFacade)localObject).a(this.aUL, this.bTa, this.IR, "extLong", Integer.valueOf(localMessageRecord.extLong));
          ((QQMessageFacade)localObject).a(this.aUL, this.bTa, this.IR, "extStr", localMessageRecord.extStr);
          ((QQMessageFacade)localObject).as(localMessageRecord);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.23
 * JD-Core Version:    0.7.0.1
 */