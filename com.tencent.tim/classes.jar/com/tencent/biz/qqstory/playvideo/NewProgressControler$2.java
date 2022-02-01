package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import java.lang.ref.WeakReference;
import qfm;
import qlb;

public class NewProgressControler$2
  implements Runnable
{
  public NewProgressControler$2(qfm paramqfm) {}
  
  public void run()
  {
    if (this.this$0.aDd) {}
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
      qfm.a(this.this$0, localqlb.getCurrentPosition(), localqlb.getDuration());
      qfm.a(this.this$0);
      return;
    }
    this.this$0.mUIHandler.postDelayed(this, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.NewProgressControler.2
 * JD-Core Version:    0.7.0.1
 */