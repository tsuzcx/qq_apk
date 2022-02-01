package com.tencent.qqmail.utilities.audio;

import android.app.Dialog;
import android.os.Handler;
import android.widget.TextView;

class QMAudioRecorder$2
  implements Runnable
{
  QMAudioRecorder$2(QMAudioRecorder paramQMAudioRecorder) {}
  
  public void run()
  {
    if (QMAudioRecorder.access$100(this.this$0))
    {
      ((TextView)QMAudioRecorder.access$000(this.this$0).findViewById(2131376988)).setText(QMAudioRecorder.access$600(this.this$0, QMAudioRecorder.access$500(this.this$0) / 3600) + ":" + QMAudioRecorder.access$600(this.this$0, QMAudioRecorder.access$500(this.this$0) % 3600 / 60) + ":" + QMAudioRecorder.access$600(this.this$0, QMAudioRecorder.access$500(this.this$0) % 60));
      QMAudioRecorder.access$508(this.this$0);
      QMAudioRecorder.access$400(this.this$0).postDelayed(QMAudioRecorder.access$700(this.this$0), 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.audio.QMAudioRecorder.2
 * JD-Core Version:    0.7.0.1
 */