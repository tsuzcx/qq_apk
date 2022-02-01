package com.tencent.mobileqq.richmedia.capture.util;

import alxf;
import aqhq;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils.BadDataFrame;
import java.util.ArrayList;

public final class ReportBadCase$2
  implements Runnable
{
  public void run()
  {
    for (;;)
    {
      int i;
      synchronized ()
      {
        int j = alxf.access$200().size();
        if (j > 0)
        {
          i = 0;
          if (i < j)
          {
            BadcaseReportUtils.BadDataFrame localBadDataFrame = (BadcaseReportUtils.BadDataFrame)alxf.access$200().get(i);
            if ((!localBadDataFrame.mZipSuccess) || (localBadDataFrame.zipPath == null) || ("".equals(localBadDataFrame.zipPath))) {
              break label96;
            }
            aqhq.deleteFile(localBadDataFrame.zipPath);
            break label96;
          }
        }
        alxf.access$200().clear();
        alxf.access$300();
        return;
      }
      label96:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.ReportBadCase.2
 * JD-Core Version:    0.7.0.1
 */