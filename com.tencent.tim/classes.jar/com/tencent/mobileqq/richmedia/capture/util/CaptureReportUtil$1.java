package com.tencent.mobileqq.richmedia.capture.util;

import alwx;
import alwz;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport.BoyItem;
import java.util.ArrayList;
import java.util.Iterator;

public final class CaptureReportUtil$1
  implements Runnable
{
  public CaptureReportUtil$1(BoyDataReport paramBoyDataReport) {}
  
  public void run()
  {
    alwx.aG(this.a.mGameTotalScore, this.a.mGameDuration);
    Iterator localIterator = this.a.mBoyData.iterator();
    while (localIterator.hasNext())
    {
      BoyDataReport.BoyItem localBoyItem = (BoyDataReport.BoyItem)localIterator.next();
      if (localBoyItem.mEnd) {
        alwx.aQ(localBoyItem.mId, "" + localBoyItem.mScore, alwx.eS(localBoyItem.status));
      }
    }
    alwz.a().b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.1
 * JD-Core Version:    0.7.0.1
 */