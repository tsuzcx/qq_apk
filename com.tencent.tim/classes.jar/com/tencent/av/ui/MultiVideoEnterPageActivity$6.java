package com.tencent.av.ui;

import aqiw;
import com.tencent.av.VideoController;

class MultiVideoEnterPageActivity$6
  implements Runnable
{
  MultiVideoEnterPageActivity$6(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void run()
  {
    if ((aqiw.getSystemNetwork(this.this$0) == 0) && (!this.this$0.Xn))
    {
      this.this$0.finish();
      MultiVideoEnterPageActivity.a(this.this$0, 0, 2130772209);
      if (this.this$0.a != null) {
        this.this$0.a.a(this.this$0.aqx, this.this$0.md, 22, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.6
 * JD-Core Version:    0.7.0.1
 */