package com.tencent.qqmail.utilities.audio;

import android.app.Dialog;
import android.content.res.Resources;
import android.media.MediaRecorder;
import android.os.Handler;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.qqmail.QMApplicationContext;

class QMAudioRecorder$1
  implements Runnable
{
  private ViewGroup.LayoutParams lp;
  private final int maxHeight = QMApplicationContext.sharedInstance().getResources().getDimensionPixelSize(2131299297);
  private final int minHeight = QMApplicationContext.sharedInstance().getResources().getDimensionPixelSize(2131299298);
  private ImageView recordAmplitudeView;
  
  QMAudioRecorder$1(QMAudioRecorder paramQMAudioRecorder) {}
  
  public void run()
  {
    if (this.recordAmplitudeView == null)
    {
      this.recordAmplitudeView = ((ImageView)QMAudioRecorder.access$000(this.this$0).findViewById(2131376954));
      this.lp = this.recordAmplitudeView.getLayoutParams();
    }
    if ((QMAudioRecorder.access$100(this.this$0)) && (QMAudioRecorder.access$200(this.this$0) != null))
    {
      int j = QMAudioRecorder.access$200(this.this$0).getMaxAmplitude() / 260 + this.minHeight;
      int i = j;
      if (j > this.maxHeight) {
        i = this.maxHeight;
      }
      this.lp.height = i;
      this.recordAmplitudeView.setLayoutParams(this.lp);
      QMAudioRecorder.access$400(this.this$0).postDelayed(QMAudioRecorder.access$300(this.this$0), 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.audio.QMAudioRecorder.1
 * JD-Core Version:    0.7.0.1
 */