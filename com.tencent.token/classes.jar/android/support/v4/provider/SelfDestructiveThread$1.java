package android.support.v4.provider;

import android.os.Handler.Callback;
import android.os.Message;

class SelfDestructiveThread$1
  implements Handler.Callback
{
  SelfDestructiveThread$1(SelfDestructiveThread paramSelfDestructiveThread) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
      SelfDestructiveThread.access$000(this.this$0, (Runnable)paramMessage.obj);
      return true;
    }
    SelfDestructiveThread.access$100(this.this$0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.provider.SelfDestructiveThread.1
 * JD-Core Version:    0.7.0.1
 */