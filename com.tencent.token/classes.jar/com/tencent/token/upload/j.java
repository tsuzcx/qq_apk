package com.tencent.token.upload;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import org.json.JSONArray;

class j
  extends Handler
{
  j(NetInfoService paramNetInfoService) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramMessage.arg1 == 0);
        paramMessage = (f)paramMessage.obj;
        h.c("K_MSG_DEVICE_INFO_REPORT" + paramMessage.c);
        return;
      } while (paramMessage.arg1 != 0);
      paramMessage = (JSONArray)paramMessage.obj;
    } while ((paramMessage == null) || (paramMessage.length() <= 0));
    try
    {
      HandlerThread localHandlerThread = new HandlerThread("dynamicdomainreport", 1);
      localHandlerThread.start();
      new Handler(localHandlerThread.getLooper()).postDelayed(new k(this, paramMessage), 1000L);
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.upload.j
 * JD-Core Version:    0.7.0.1
 */