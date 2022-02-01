package com.tencent.qqmail.note;

import android.util.Log;
import com.tencent.qqmail.utilities.audio.QMAudioPlayBar;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;

class ReadNoteActivity$44$1
  implements Runnable
{
  ReadNoteActivity$44$1(ReadNoteActivity.44 param44) {}
  
  public void run()
  {
    Log.e("audio", "audiocomplete");
    if ((ReadNoteActivity.access$1900(this.this$1.this$0) != null) && (ReadNoteActivity.access$1900(this.this$1.this$0).getWebView() != null))
    {
      ReadNoteActivity.access$1900(this.this$1.this$0).execJs("notifyClear();");
      this.this$1.this$0.shakeWebViewWrapper();
      ReadNoteActivity.access$3700(this.this$1.this$0);
    }
    ReadNoteActivity.access$3900(this.this$1.this$0).close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.44.1
 * JD-Core Version:    0.7.0.1
 */