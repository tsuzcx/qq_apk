package com.tencent.mobileqq.app;

import acne;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.LinkedBlockingQueue;

public class TroopQZoneUploadAlbumHandler$2
  implements Runnable
{
  public TroopQZoneUploadAlbumHandler$2(acne paramacne) {}
  
  public void run()
  {
    while (!acne.a(this.this$0)) {
      try
      {
        i = ((Integer)acne.a(this.this$0).take()).intValue();
        if ((this.this$0.i == null) || (this.this$0.i.getBinder() == null) || (!this.this$0.i.getBinder().isBinderAlive()) || (!this.this$0.i.getBinder().pingBinder()))
        {
          QLog.i("UploadPhoto", 1, "需要重新创建连接");
          this.this$0.cMZ();
          acne.a(this.this$0);
          acne.a(this.this$0).offer(Integer.valueOf(i));
          acne.a(this.this$0, true);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        int i;
        acne.a(this.this$0, true);
        QLog.e("UploadPhoto", 1, localInterruptedException, new Object[0]);
        continue;
        Message localMessage = Message.obtain(null, 998, i, 0);
        if (this.this$0.mMessenger == null) {
          this.this$0.mMessenger = new Messenger(this.this$0.handler);
        }
        localMessage.replyTo = this.this$0.mMessenger;
        this.this$0.i.send(localMessage);
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("UploadPhoto", 1, localRemoteException, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler.2
 * JD-Core Version:    0.7.0.1
 */