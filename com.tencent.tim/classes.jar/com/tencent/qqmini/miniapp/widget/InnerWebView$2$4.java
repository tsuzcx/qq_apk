package com.tencent.qqmini.miniapp.widget;

import android.content.Intent;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;

class InnerWebView$2$4
  implements IActivityResultListener
{
  InnerWebView$2$4(InnerWebView.2 param2) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2019)
    {
      this.this$1.this$0.onActivityResult(paramInt1, paramInt2, paramIntent);
      ActivityResultManager.g().removeActivityResultListener(this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.InnerWebView.2.4
 * JD-Core Version:    0.7.0.1
 */