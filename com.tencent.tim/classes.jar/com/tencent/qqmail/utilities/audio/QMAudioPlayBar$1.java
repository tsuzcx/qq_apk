package com.tencent.qqmail.utilities.audio;

import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.SeekBar;

class QMAudioPlayBar$1
  implements Runnable
{
  QMAudioPlayBar$1(QMAudioPlayBar paramQMAudioPlayBar) {}
  
  public void run()
  {
    if (QMAudioPlayBar.access$000(this.this$0) != null)
    {
      int i = QMAudioPlayBar.access$000(this.this$0).getCurrentPosition();
      QMAudioPlayBar.access$100(this.this$0).setProgress(i / 1000);
      QMAudioPlayBar.access$300(this.this$0).postDelayed(QMAudioPlayBar.access$200(this.this$0), 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.audio.QMAudioPlayBar.1
 * JD-Core Version:    0.7.0.1
 */