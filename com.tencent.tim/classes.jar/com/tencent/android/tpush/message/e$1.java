package com.tencent.android.tpush.message;

import android.content.Intent;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.f;
import com.tencent.android.tpush.stat.ServiceStat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class e$1
  implements Runnable
{
  e$1(e parame, Intent paramIntent) {}
  
  public void run()
  {
    if ((this.a.getLongExtra("type", -1L) == 7L) && (!XGPushConfig.isEnableShowInMsg(e.a(this.b))))
    {
      TLogger.w("PushMessageHandler", "handle pushMessage inMsg not allowed");
      ServiceStat.appReportInMsgUserDisabled(e.a(this.b), this.a);
      return;
    }
    String str = this.a.getStringExtra("date");
    if (this.a.getLongExtra("msgId", -1L) < 0L)
    {
      SimpleDateFormat localSimpleDateFormat;
      try
      {
        localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        if ((!i.b(str)) && ((i.b(str)) || (localSimpleDateFormat.parse(str).compareTo(localSimpleDateFormat.parse(localSimpleDateFormat.format(new Date()))) != 0))) {
          break label187;
        }
        if (f.a(this.a))
        {
          this.b.a(this.a);
          return;
        }
      }
      catch (ParseException localParseException)
      {
        TLogger.ee("PushMessageHandler", "try to handlerPushMessage, but ParseException : " + localParseException);
        return;
      }
      TLogger.w("PushMessageHandler", "can not handle the local message because of the time");
      return;
      label187:
      if ((!i.b(localParseException)) && (localSimpleDateFormat.parse(localParseException).compareTo(localSimpleDateFormat.parse(localSimpleDateFormat.format(new Date()))) < 0))
      {
        this.b.a(this.a);
        return;
      }
      TLogger.w("PushMessageHandler", "can not handle the local message because of the date");
      return;
    }
    if (f.a(this.a))
    {
      this.b.a(this.a);
      return;
    }
    TLogger.w("PushMessageHandler", "can not handle the message because of the time");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.message.e.1
 * JD-Core Version:    0.7.0.1
 */