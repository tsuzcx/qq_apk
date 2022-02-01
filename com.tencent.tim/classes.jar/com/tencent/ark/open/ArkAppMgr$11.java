package com.tencent.ark.open;

import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.ark.open.delegate.IArkDelegateNet;
import java.lang.ref.WeakReference;

class ArkAppMgr$11
  implements Runnable
{
  ArkAppMgr$11(ArkAppMgr paramArkAppMgr, ArkAppMgr.ICheckNetworkCallback paramICheckNetworkCallback) {}
  
  public void run()
  {
    IArkDelegateNet localIArkDelegateNet = ArkDelegateManager.getInstance().getNetDelegate();
    if (localIArkDelegateNet != null) {}
    for (boolean bool = localIArkDelegateNet.isNetworkAvailable();; bool = true)
    {
      if ((ArkAppMgr)ArkAppMgr.access$1500(this.this$0).get() != null) {
        this.val$callback.onCheckNetwork(bool);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.11
 * JD-Core Version:    0.7.0.1
 */