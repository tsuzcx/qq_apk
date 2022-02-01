package com.tencent.qqmail.activity.compose;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class MailAddrsViewControl$8
  implements TextView.OnEditorActionListener
{
  MailAddrsViewControl$8(MailAddrsViewControl paramMailAddrsViewControl) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 5) || (paramInt == 0) || (paramInt == 6) || (paramInt == 2)) {
      MailAddrsViewControl.access$500(this.this$0);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.MailAddrsViewControl.8
 * JD-Core Version:    0.7.0.1
 */