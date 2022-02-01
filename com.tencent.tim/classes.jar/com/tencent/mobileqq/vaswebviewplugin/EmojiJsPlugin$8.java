package com.tencent.mobileqq.vaswebviewplugin;

import aqzv;
import ardm.n;
import arhz;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;

class EmojiJsPlugin$8
  implements Runnable
{
  EmojiJsPlugin$8(EmojiJsPlugin paramEmojiJsPlugin) {}
  
  public void run()
  {
    aqzv localaqzv = this.this$0.mRuntime.a(this.this$0.mRuntime.getActivity());
    if ((localaqzv != null) && ((localaqzv instanceof ardm.n)))
    {
      this.this$0.progressDialog = new arhz(this.this$0.mRuntime.getActivity(), ((ardm.n)localaqzv).getTitleBarHeight());
      this.this$0.progressDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */