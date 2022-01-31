package com.tencent.token.ui.qqpim;

import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

class q
  implements Runnable
{
  q(o paramo, float paramFloat) {}
  
  public void run()
  {
    QQPimNewActivity.access$300(this.b.a).setVisibility(4);
    QQPimNewActivity.access$400(this.b.a).setVisibility(0);
    QQPimNewActivity.access$900(this.b.a).setTextWhiteLength(this.a);
    QQPimNewActivity.access$1000(this.b.a).setProgress((int)(this.a * 100.0F));
    QQPimNewActivity.access$900(this.b.a).setText("下载中..." + (int)(this.a * 100.0F) + "%");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qqpim.q
 * JD-Core Version:    0.7.0.1
 */