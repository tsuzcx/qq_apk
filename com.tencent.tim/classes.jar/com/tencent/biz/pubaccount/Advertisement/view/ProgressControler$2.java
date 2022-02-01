package com.tencent.biz.pubaccount.Advertisement.view;

import android.os.Handler;
import java.lang.ref.WeakReference;
import jxs;
import qlb;

public class ProgressControler$2
  implements Runnable
{
  public ProgressControler$2(jxs paramjxs) {}
  
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
      this.this$0.a(this.this$0.mCurrentIndex, localqlb.getCurrentPosition(), localqlb.getDuration(), localqlb);
      return;
    }
    this.this$0.mUIHandler.postDelayed(this, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.ProgressControler.2
 * JD-Core Version:    0.7.0.1
 */