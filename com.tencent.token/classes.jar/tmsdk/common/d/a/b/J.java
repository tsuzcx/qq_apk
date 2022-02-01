package tmsdk.common.d.a.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class J
  extends Handler
{
  WeakReference a = null;
  
  public J(z paramz, Context paramContext)
  {
    super(paramContext.getMainLooper());
    this.a = new WeakReference(paramz);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    z localz = (z)this.a.get();
    if (localz == null) {
      return;
    }
    if (paramMessage.what != 0) {
      return;
    }
    if (localz.l() < localz.m())
    {
      if (localz.g()) {
        localz.n();
      }
    }
    else {
      localz.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.J
 * JD-Core Version:    0.7.0.1
 */