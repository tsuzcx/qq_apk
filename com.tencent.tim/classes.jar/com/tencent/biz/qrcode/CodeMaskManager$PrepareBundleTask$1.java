package com.tencent.biz.qrcode;

import android.os.Bundle;

class CodeMaskManager$PrepareBundleTask$1
  implements Runnable
{
  CodeMaskManager$PrepareBundleTask$1(CodeMaskManager.PrepareBundleTask paramPrepareBundleTask, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.b.this$0.isReleased) {
      return;
    }
    if (this.N == null) {
      this.b.b.aX(CodeMaskManager.a(this.b.this$0));
    }
    for (;;)
    {
      CodeMaskManager.a(this.b.this$0);
      return;
      this.b.b.aX((Bundle)this.N.clone());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.CodeMaskManager.PrepareBundleTask.1
 * JD-Core Version:    0.7.0.1
 */