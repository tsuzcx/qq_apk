package com.tencent.biz.pubaccount.readinjoy.ad.view;

import android.os.Handler;

class ReadInJoyAdGestureView$1
  implements Runnable
{
  ReadInJoyAdGestureView$1(ReadInJoyAdGestureView paramReadInJoyAdGestureView) {}
  
  public void run()
  {
    if ((this.this$0.NI) && (ReadInJoyAdGestureView.a(this.this$0)) && (ReadInJoyAdGestureView.mHandler != null))
    {
      ReadInJoyAdGestureView.mHandler.removeCallbacksAndMessages(null);
      return;
    }
    if (this.this$0.iZ >= 15.0F)
    {
      this.this$0.iZ -= 2.0F;
      this.this$0.agO = false;
    }
    for (;;)
    {
      this.this$0.invalidate();
      if (ReadInJoyAdGestureView.mHandler == null) {
        break;
      }
      ReadInJoyAdGestureView.mHandler.postDelayed(this, 5L);
      return;
      if (this.this$0.iZ <= -15.0F)
      {
        this.this$0.iZ += 2.0F;
        this.this$0.agO = true;
      }
      else if (this.this$0.iZ == 0.0F)
      {
        if (this.this$0.agO) {
          this.this$0.iZ += 2.0F;
        } else {
          this.this$0.iZ -= 2.0F;
        }
      }
      else if ((this.this$0.iZ > -15.0F) && (this.this$0.iZ < 15.0F))
      {
        if (this.this$0.agO) {
          this.this$0.iZ += 2.0F;
        } else {
          this.this$0.iZ -= 2.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdGestureView.1
 * JD-Core Version:    0.7.0.1
 */