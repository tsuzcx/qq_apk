package com.tencent.biz.qqstory.takevideo;

import ram;
import rbe;
import rbe.a;
import rbn;
import rdc;

public class EditJumpToPtu$1
  implements Runnable
{
  public EditJumpToPtu$1(rbe paramrbe) {}
  
  public void run()
  {
    rbe.a(this.this$0, rbn.azs + "qq_pic_Jump_" + System.currentTimeMillis() + ".png");
    if (this.this$0.ft(rbe.a(this.this$0)))
    {
      this.this$0.a.sendEmptyMessage(1);
      return;
    }
    rbe.a(this.this$0, null);
    ram.e("EditJumpToPtu", "get rawBitmap error!");
    this.this$0.b.changeState(0);
    this.this$0.a.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditJumpToPtu.1
 * JD-Core Version:    0.7.0.1
 */