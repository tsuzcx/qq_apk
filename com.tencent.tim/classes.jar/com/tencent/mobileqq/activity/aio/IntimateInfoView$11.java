package com.tencent.mobileqq.activity.aio;

import com.tencent.image.URLDrawable;
import wll;

public class IntimateInfoView$11
  implements Runnable
{
  public IntimateInfoView$11(wll paramwll) {}
  
  public void run()
  {
    if (wll.a(this.this$0).getStatus() == 0)
    {
      wll.a(this.this$0).downloadImediatly();
      return;
    }
    wll.a(this.this$0).restartDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.11
 * JD-Core Version:    0.7.0.1
 */