package com.tencent.gdtad.adapter;

import com.tencent.mobileqq.app.ThreadManager;
import tfw;

public class GdtThreadManagerAdapter$2
  implements Runnable
{
  public GdtThreadManagerAdapter$2(tfw paramtfw, Runnable paramRunnable, int paramInt) {}
  
  public void run()
  {
    ThreadManager.excute(this.val$runnable, this.aMY, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtThreadManagerAdapter.2
 * JD-Core Version:    0.7.0.1
 */