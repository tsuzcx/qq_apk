package com.tencent.qqmail.activity.compose;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

class ComposeNoteActivity$21
  implements Runnable
{
  ComposeNoteActivity$21(ComposeNoteActivity paramComposeNoteActivity) {}
  
  public void run()
  {
    if (ComposeNoteActivity.access$2700(this.this$0) != null)
    {
      ComposeNoteActivity.access$2700(this.this$0).clearFocus();
      ComposeNoteActivity.access$1400(this.this$0).clearFocusCursor();
      ((InputMethodManager)this.this$0.getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(ComposeNoteActivity.access$2700(this.this$0).getWindowToken(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.21
 * JD-Core Version:    0.7.0.1
 */