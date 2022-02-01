package com.tencent.av.redpacket.ui;

import android.graphics.Bitmap;
import android.view.ViewGroup;

class RedPacketGameView$4
  implements Runnable
{
  RedPacketGameView$4(RedPacketGameView paramRedPacketGameView, ViewGroup paramViewGroup) {}
  
  public void run()
  {
    this.val$parent.removeView(this.this$0.hL);
    this.this$0.hL = null;
    if (this.this$0.bm != null)
    {
      this.this$0.bm.recycle();
      this.this$0.bm = null;
    }
    if (this.this$0.bi != null)
    {
      this.this$0.bi.recycle();
      this.this$0.bi = null;
    }
    if (this.this$0.bl != null)
    {
      this.this$0.bl.recycle();
      this.this$0.bl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameView.4
 * JD-Core Version:    0.7.0.1
 */