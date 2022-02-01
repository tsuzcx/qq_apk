package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.miniapp.core.page.widget.WebInputHandler;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;

class NativeViewContainer$5
  implements Runnable
{
  NativeViewContainer$5(NativeViewContainer paramNativeViewContainer, NativeViewRequestEvent paramNativeViewRequestEvent) {}
  
  public void run()
  {
    if (NativeViewContainer.access$000(this.this$0) != null) {
      NativeViewContainer.access$000(this.this$0).setKeyboardValue(this.val$req);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.NativeViewContainer.5
 * JD-Core Version:    0.7.0.1
 */