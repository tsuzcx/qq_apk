package com.tencent.biz.pubaccount.readinjoy.view;

import mye;
import mza;
import ndi;
import ndx;

public class ReadInJoyBaseAdapter$29$4
  implements Runnable
{
  public ReadInJoyBaseAdapter$29$4(ndx paramndx) {}
  
  public void run()
  {
    this.a.this$0.notifyDataSetChanged();
    if (this.a.this$0.a.isPlaying())
    {
      this.a.this$0.a.pause(true);
      this.a.this$0.a.a().aRZ();
    }
    while ((this.a.this$0.mIsResume) || (!this.a.this$0.a.isPause())) {
      return;
    }
    this.a.this$0.a.oM(true);
    this.a.this$0.a.a().aRZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.4
 * JD-Core Version:    0.7.0.1
 */