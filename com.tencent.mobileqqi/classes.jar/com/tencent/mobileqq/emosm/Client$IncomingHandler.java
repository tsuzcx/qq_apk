package com.tencent.mobileqq.emosm;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class Client$IncomingHandler
  extends Handler
{
  Client$IncomingHandler(Client paramClient) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
    }
    do
    {
      do
      {
        return;
        Client.access$100(this.this$0, paramMessage.getData());
      } while (!QLog.isColorLevel());
      QLog.i("Q.emoji.web.Client", 2, "resp from server MSG_CLIENT_RESP");
      return;
      Client.access$200(this.this$0, paramMessage.getData());
    } while (!QLog.isColorLevel());
    QLog.i("Q.emoji.web.Client", 2, "resp from server MSG_SERVER_DOWNLOAD_STATE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.Client.IncomingHandler
 * JD-Core Version:    0.7.0.1
 */