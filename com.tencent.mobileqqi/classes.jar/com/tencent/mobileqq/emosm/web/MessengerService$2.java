package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.QLog;

class MessengerService$2
  extends IPCDownloadListener
{
  MessengerService$2(MessengerService paramMessengerService) {}
  
  public void onDone(long paramLong, int paramInt, Bundle paramBundle)
  {
    if (this.this$0.mClient != null) {}
    try
    {
      Message localMessage = Message.obtain(null, 5);
      paramBundle.putInt("id", (int)paramLong);
      paramBundle.putInt("result", paramInt);
      localMessage.setData(paramBundle);
      this.this$0.mClient.send(localMessage);
      return;
    }
    catch (Exception paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.emoji.web.MessengerService", 2, paramBundle.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.2
 * JD-Core Version:    0.7.0.1
 */