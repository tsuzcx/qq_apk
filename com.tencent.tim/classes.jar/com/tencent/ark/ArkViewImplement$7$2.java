package com.tencent.ark;

import android.content.Context;
import android.text.ClipboardManager;
import android.view.View;

class ArkViewImplement$7$2
  implements Runnable
{
  ArkViewImplement$7$2(ArkViewImplement.7 param7, String paramString) {}
  
  public void run()
  {
    ((ClipboardManager)this.this$1.this$0.mArkView.getContext().getSystemService("clipboard")).setText(this.val$selectText);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkViewImplement.7.2
 * JD-Core Version:    0.7.0.1
 */