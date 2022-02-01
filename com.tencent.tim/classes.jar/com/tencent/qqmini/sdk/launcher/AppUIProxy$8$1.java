package com.tencent.qqmini.sdk.launcher;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.OnDismissListener;

class AppUIProxy$8$1
  implements MiniLoadingAdManager.OnDismissListener
{
  AppUIProxy$8$1(AppUIProxy.8 param8) {}
  
  public void onDismiss()
  {
    if ((this.this$1.this$0.mCurrRuntimeLoader != null) && (this.this$1.this$0.mCurrRuntimeLoader.mRuntime != null)) {
      this.this$1.this$0.mCurrRuntimeLoader.mRuntime.setLoadingAdStatus(3);
    }
    DisplayUtil.setSystemUIVisible(this.this$1.val$activity, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppUIProxy.8.1
 * JD-Core Version:    0.7.0.1
 */