package com.tencent.biz.qqstory.playmode.util;

import com.tencent.biz.qqstory.base.ErrorMessage;
import qac;
import qem.c;
import qeq;

public class PlayModeUtils$6$1
  implements Runnable
{
  public PlayModeUtils$6$1(qeq paramqeq, qac paramqac, ErrorMessage paramErrorMessage) {}
  
  public void run()
  {
    if ((this.a != null) && (this.f.isSuccess()))
    {
      this.this$0.a.wg(this.a.blC);
      return;
    }
    this.this$0.a.wg(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils.6.1
 * JD-Core Version:    0.7.0.1
 */