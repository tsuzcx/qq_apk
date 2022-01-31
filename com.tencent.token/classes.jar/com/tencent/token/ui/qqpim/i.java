package com.tencent.token.ui.qqpim;

import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

class i
  implements Runnable
{
  i(g paramg, float paramFloat) {}
  
  public void run()
  {
    QQPimActivity.access$000(this.b.a).setVisibility(4);
    QQPimActivity.access$100(this.b.a).setVisibility(0);
    QQPimActivity.access$600(this.b.a).setTextWhiteLength(this.a);
    QQPimActivity.access$700(this.b.a).setProgress((int)(this.a * 100.0F));
    QQPimActivity.access$600(this.b.a).setText("下载中..." + (int)(this.a * 100.0F) + "%");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qqpim.i
 * JD-Core Version:    0.7.0.1
 */