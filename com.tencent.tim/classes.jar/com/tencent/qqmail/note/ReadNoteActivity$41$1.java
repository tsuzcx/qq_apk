package com.tencent.qqmail.note;

import android.util.Log;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;

class ReadNoteActivity$41$1
  implements Runnable
{
  ReadNoteActivity$41$1(ReadNoteActivity.41 param41) {}
  
  public void run()
  {
    Log.e("algerPlayAudio1", "algerPlayAudio11111end");
    ReadNoteActivity.access$1900(this.this$1.this$0).execJs("notifyClear();");
    this.this$1.this$0.shakeWebViewWrapper();
    ReadNoteActivity.access$3700(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.41.1
 * JD-Core Version:    0.7.0.1
 */