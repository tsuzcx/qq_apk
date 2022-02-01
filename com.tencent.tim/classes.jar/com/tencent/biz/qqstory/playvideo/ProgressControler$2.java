package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import java.lang.ref.WeakReference;
import qfo;
import qlb;

public class ProgressControler$2
  implements Runnable
{
  public ProgressControler$2(qfo paramqfo) {}
  
  public void run()
  {
    if (this.this$0.bCancel) {}
    qlb localqlb;
    do
    {
      do
      {
        return;
      } while (this.this$0.bY == null);
      localqlb = (qlb)this.this$0.bY.get();
    } while (localqlb == null);
    if (localqlb.getDuration() > 0L)
    {
      this.this$0.b(localqlb.getCurrentPosition(), localqlb.getDuration(), localqlb);
      return;
    }
    this.this$0.mUIHandler.postDelayed(this, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.ProgressControler.2
 * JD-Core Version:    0.7.0.1
 */