package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.view.MotionEvent;

class MystoryListView$3
  implements Runnable
{
  int index = -1;
  
  MystoryListView$3(MystoryListView paramMystoryListView, int[] paramArrayOfInt1, int[] paramArrayOfInt2, float[] paramArrayOfFloat) {}
  
  public void run()
  {
    int i = 0;
    if (this.index >= this.dT.length) {}
    do
    {
      return;
      if (this.index < 0)
      {
        this.index += 1;
        if (this.index >= 0) {
          i = this.dU[this.index];
        }
        this.this$0.postDelayed(this, i);
        return;
      }
      long l = System.currentTimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, this.dT[this.index], this.this$0.getWidth() / 2, this.aE[this.index], 0);
      this.this$0.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      this.index += 1;
    } while (this.index >= this.dT.length);
    this.this$0.postDelayed(this, this.dU[this.index]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView.3
 * JD-Core Version:    0.7.0.1
 */