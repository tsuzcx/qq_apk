package com.tencent.mobileqq.app.automator.step;

import ajdp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class GetQZoneFeedCount
  extends AsyncStep
{
  public int od()
  {
    ajdp localajdp;
    if ((this.a != null) && (this.a.app != null))
    {
      localajdp = (ajdp)this.a.app.getManager(10);
      if (localajdp != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GetQZoneFeedCount", 2, "GetQZoneFeedCount isFirstGetUnread:" + localajdp.aqs() + ",isBackground_Pause:" + this.a.app.isBackground_Pause);
        }
        if (!localajdp.aqs()) {
          break label120;
        }
        localajdp.gH(this.a.app.getAccount(), null);
      }
    }
    for (;;)
    {
      return 7;
      label120:
      if (this.a.app.isBackground_Pause) {
        localajdp.QD(6);
      } else {
        localajdp.QC(5);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetQZoneFeedCount
 * JD-Core Version:    0.7.0.1
 */