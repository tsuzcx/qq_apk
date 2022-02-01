package com.tencent.qqmail.utilities.translate;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import android.os.SystemClock;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.concurrent.atomic.AtomicBoolean;

class ClientTranslateHandler$1
  implements ServiceConnection
{
  ClientTranslateHandler$1(ClientTranslateHandler paramClientTranslateHandler) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QMLog.log(4, "ClientTranslateHandler", "TranslateService connected, elapse: " + (SystemClock.elapsedRealtime() - ClientTranslateHandler.access$300(this.this$0)) + "ms");
    ClientTranslateHandler.access$102(this.this$0, true);
    ClientTranslateHandler.access$400(this.this$0).getAndSet(false);
    ClientTranslateHandler.access$202(this.this$0, new Messenger(paramIBinder));
    ClientTranslateHandler.access$500(this.this$0);
    ClientTranslateHandler.access$600(this.this$0);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QMLog.log(4, "ClientTranslateHandler", "TranslateService disconnected");
    ClientTranslateHandler.access$102(this.this$0, false);
    ClientTranslateHandler.access$202(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.translate.ClientTranslateHandler.1
 * JD-Core Version:    0.7.0.1
 */