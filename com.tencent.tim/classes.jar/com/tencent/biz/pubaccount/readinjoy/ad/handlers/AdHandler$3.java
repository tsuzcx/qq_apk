package com.tencent.biz.pubaccount.readinjoy.ad.handlers;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import klc;

public class AdHandler$3
  implements Runnable
{
  public AdHandler$3(klc paramklc, View paramView, AbsListView paramAbsListView, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int i = this.jL.getBottom() - this.b.getBottom() - this.b.getPaddingBottom() + klc.a(this.this$0);
    this.b.setInterpolator(klc.a(this.this$0));
    if (QLog.isColorLevel()) {
      QLog.d("AdHandler", 2, "adjust scroll Before:" + (this.aJV - i) + ", After:" + this.aJW / 1);
    }
    i = i + this.aJW / 1 + 1;
    int j = (int)(klc.a(this.this$0) * 1000.0F * 2.0F * i / this.b.getFlingVelocityY());
    this.b.smoothScrollByImmediately(i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.handlers.AdHandler.3
 * JD-Core Version:    0.7.0.1
 */