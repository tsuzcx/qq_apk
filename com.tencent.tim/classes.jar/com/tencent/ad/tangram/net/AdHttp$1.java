package com.tencent.ad.tangram.net;

import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;

final class AdHttp$1
  implements Runnable
{
  AdHttp$1(AdHttp.Params paramParams, WeakReference paramWeakReference) {}
  
  public void run()
  {
    AdHttp.send(this.val$params);
    if (this.val$listener == null) {
      return;
    }
    AdThreadManager.INSTANCE.post(new AdHttp.1.1(this), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.net.AdHttp.1
 * JD-Core Version:    0.7.0.1
 */