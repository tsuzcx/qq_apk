package com.tencent.smtt.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class TbsLogReport$1
  extends Handler
{
  TbsLogReport$1(TbsLogReport paramTbsLogReport, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 600) {
      if (!(paramMessage.obj instanceof TbsLogReport.TbsLogInfo)) {}
    }
    while (paramMessage.what != 601) {
      try
      {
        TbsLogReport.TbsLogInfo localTbsLogInfo = (TbsLogReport.TbsLogInfo)paramMessage.obj;
        int i = paramMessage.arg1;
        TbsLogReport.a(this.a, i, localTbsLogInfo);
        return;
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        return;
      }
    }
    TbsLogReport.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport.1
 * JD-Core Version:    0.7.0.1
 */