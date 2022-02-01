package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.action.GetShareState;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.model.ShareState;

class UIJsPlugin$5
  implements Runnable
{
  UIJsPlugin$5(UIJsPlugin paramUIJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    if (UIJsPlugin.access$900(this.this$0))
    {
      ShareState localShareState = GetShareState.obtain(UIJsPlugin.access$1000(this.this$0));
      if (localShareState != null)
      {
        localShareState.showRestart = false;
        this.val$req.ok();
        return;
      }
      this.val$req.fail();
      return;
    }
    if (PageAction.obtain(UIJsPlugin.access$1100(this.this$0)).getPageUrl() != null)
    {
      GetShareState.obtain(UIJsPlugin.access$1200(this.this$0)).showRestart = false;
      this.val$req.ok();
      return;
    }
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.UIJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */