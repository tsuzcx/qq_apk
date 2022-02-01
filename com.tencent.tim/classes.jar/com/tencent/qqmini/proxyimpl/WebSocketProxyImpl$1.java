package com.tencent.qqmini.proxyimpl;

import asxq;
import asxq.a;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener;

public class WebSocketProxyImpl$1
  implements Runnable
{
  public WebSocketProxyImpl$1(asxq paramasxq, asxq.a parama, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    if (!this.a.socketClosedCallbacked) {
      this.a.mListener.onClose(this.enZ, this.val$code, this.val$reason);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.WebSocketProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */