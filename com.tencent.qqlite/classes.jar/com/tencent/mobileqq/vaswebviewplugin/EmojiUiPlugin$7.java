package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.widget.QQProgressDialog;

class EmojiUiPlugin$7
  implements Runnable
{
  EmojiUiPlugin$7(EmojiUiPlugin paramEmojiUiPlugin) {}
  
  public void run()
  {
    if (this.this$0.progressDialog != null)
    {
      this.this$0.progressDialog.cancel();
      this.this$0.progressDialog = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin.7
 * JD-Core Version:    0.7.0.1
 */