package com.tencent.qqmail.paintpad;

import android.content.Intent;

class MailPaintPadActivity$3$1$1
  implements Runnable
{
  MailPaintPadActivity$3$1$1(MailPaintPadActivity.3.1 param1) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("EXTRA_RESULT_PATH", MailPaintPadActivity.access$000(this.this$2.this$1.this$0));
    this.this$2.this$1.this$0.setResult(-1, localIntent);
    this.this$2.this$1.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.paintpad.MailPaintPadActivity.3.1.1
 * JD-Core Version:    0.7.0.1
 */