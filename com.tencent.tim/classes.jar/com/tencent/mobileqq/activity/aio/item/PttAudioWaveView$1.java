package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewParent;

class PttAudioWaveView$1
  implements Runnable
{
  PttAudioWaveView$1(PttAudioWaveView paramPttAudioWaveView) {}
  
  public void run()
  {
    this.this$0.bho = true;
    View localView = (View)this.this$0.getParent().getParent().getParent();
    PttAudioWaveView.a(this.this$0, localView, false);
    if (this.this$0.c != null) {
      this.this$0.c.onLongClick(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttAudioWaveView.1
 * JD-Core Version:    0.7.0.1
 */