package com.tencent.mobileqq.mini.entry;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import arcz.b;
import com.tencent.qphone.base.util.QLog;

final class MiniAppUtils$5
  extends Handler
{
  MiniAppUtils$5(Looper paramLooper, Context paramContext, String paramString1, String paramString2)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if ((paramMessage.obj instanceof arcz.b))
    {
      arcz.b localb = (arcz.b)paramMessage.obj;
      if (localb.resultCode == 0)
      {
        QLog.d("MiniAppUtils", 2, "handleMessage() called with: msg = [" + paramMessage + "]");
        MiniAppUtils.access$000(this.val$context, this.val$appId, this.val$dataCacheKey, localb.czO);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.5
 * JD-Core Version:    0.7.0.1
 */