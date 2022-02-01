package com.tencent.mobileqq.activity.aio.doodle;

import amjb;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.widget.QQToast;
import wrl;

public class DoodlePanel$5$1
  implements Runnable
{
  public DoodlePanel$5$1(wrl paramwrl, int paramInt) {}
  
  public void run()
  {
    this.a.b.cancleProgressDailog();
    if (this.bRg == amjb.RESULT_SUCCESS)
    {
      this.a.b.reset();
      return;
    }
    QQToast.a(this.a.b.getContext(), 2131690124, 0).show(DoodlePanel.a(this.a.b).getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodlePanel.5.1
 * JD-Core Version:    0.7.0.1
 */