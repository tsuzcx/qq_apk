package com.tencent.qqmini.sdk.core.manager;

import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class PreCacheManager$5
  implements Runnable
{
  PreCacheManager$5(PreCacheManager paramPreCacheManager, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    this.this$0.doFetchPreResourceIfNeed(this.val$miniAppConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.PreCacheManager.5
 * JD-Core Version:    0.7.0.1
 */