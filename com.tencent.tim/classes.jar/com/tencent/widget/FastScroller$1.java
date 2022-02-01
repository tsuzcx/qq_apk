package com.tencent.widget;

class FastScroller$1
  implements Runnable
{
  FastScroller$1(FastScroller paramFastScroller) {}
  
  public void run()
  {
    int k;
    int j;
    int i;
    if (this.this$0.f.mIsAttached)
    {
      this.this$0.ewP();
      k = this.this$0.f.getHeight();
      j = (int)this.this$0.mInitialTouchY - this.this$0.etj + 10;
      if (j >= 0) {
        break label100;
      }
      i = 0;
    }
    for (;;)
    {
      this.this$0.etl = i;
      this.this$0.bk(this.this$0.etl / (k - this.this$0.etj));
      this.this$0.dkp = false;
      return;
      label100:
      i = j;
      if (this.this$0.etj + j > k) {
        i = k - this.this$0.etj;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.widget.FastScroller.1
 * JD-Core Version:    0.7.0.1
 */