package com.tencent.biz.pubaccount.readinjoy.pts;

import android.app.Activity;
import com.tencent.pts.bridge.PTSJSBridgeManager;
import com.tencent.pts.core.PTSAppInstance;

class PTSFragment$1
  implements Runnable
{
  PTSFragment$1(PTSFragment paramPTSFragment, Activity paramActivity) {}
  
  public void run()
  {
    if (PTSFragment.a(this.this$0) != null) {
      PTSFragment.a(this.this$0).onDestroy();
    }
    if (this.val$activity != null) {
      PTSJSBridgeManager.getInstance().destroyJSBridge(this.val$activity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment.1
 * JD-Core Version:    0.7.0.1
 */