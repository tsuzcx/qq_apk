package com.tencent.qqmail.note;

import android.util.Log;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;

class ReadNoteActivity$42
  implements Runnable
{
  ReadNoteActivity$42(ReadNoteActivity paramReadNoteActivity, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    ReadNoteActivity.access$1900(this.this$0).execJs("notifyPlaying()");
    this.this$0.shakeWebViewWrapper();
    ReadNoteActivity.access$3700(this.this$0);
    Log.d("jstest", "play audio4");
    this.this$0.playAudioWrapper(this.val$name, this.val$src, this.val$size);
    Log.d("jstest", "play audio5");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.42
 * JD-Core Version:    0.7.0.1
 */