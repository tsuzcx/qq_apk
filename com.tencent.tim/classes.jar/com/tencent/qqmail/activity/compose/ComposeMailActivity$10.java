package com.tencent.qqmail.activity.compose;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

class ComposeMailActivity$10
  implements Runnable
{
  ComposeMailActivity$10(ComposeMailActivity paramComposeMailActivity) {}
  
  public void run()
  {
    if (this.this$0.isDestroyed()) {}
    while (ComposeMailActivity.access$500(this.this$0) == null) {
      return;
    }
    ComposeMailActivity.access$500(this.this$0).clearFocus();
    ((InputMethodManager)this.this$0.getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(ComposeMailActivity.access$500(this.this$0).getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.10
 * JD-Core Version:    0.7.0.1
 */