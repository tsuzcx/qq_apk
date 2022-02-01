package com.tencent.biz.qqstory.msgTabNode.view;

import android.os.Handler;

class MsgTabStoryNodeView$1
  implements Runnable
{
  int bla = 0;
  
  MsgTabStoryNodeView$1(MsgTabStoryNodeView paramMsgTabStoryNodeView) {}
  
  public void run()
  {
    this.this$0.wd(this.bla);
    this.this$0.invalidate(this.this$0.mVisibleRect);
    if (!this.this$0.mDetached) {
      if (this.bla >= 110) {
        break label70;
      }
    }
    label70:
    for (this.bla += 1;; this.bla = -10)
    {
      this.this$0.mHandler.postDelayed(this, 1000L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView.1
 * JD-Core Version:    0.7.0.1
 */