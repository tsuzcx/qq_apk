package com.tencent.biz.qqcircle.fragments.content;

import android.widget.TextView;
import com.tencent.superplayer.api.ISuperPlayer;
import pdx;

class QCircleContentVideo$2
  implements Runnable
{
  QCircleContentVideo$2(QCircleContentVideo paramQCircleContentVideo, ISuperPlayer paramISuperPlayer) {}
  
  public void run()
  {
    if ((QCircleContentVideo.a(this.this$0) != null) && (QCircleContentVideo.a(this.this$0).wk != null)) {
      QCircleContentVideo.a(this.this$0).wk.setText(pdx.bO((int)this.c.getDurationMs()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo.2
 * JD-Core Version:    0.7.0.1
 */