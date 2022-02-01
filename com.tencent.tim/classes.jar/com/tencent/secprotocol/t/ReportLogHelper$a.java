package com.tencent.secprotocol.t;

import com.tencent.secprotocol.ByteData;
import java.util.TimerTask;

public final class ReportLogHelper$a
  extends TimerTask
{
  public void run()
  {
    if (ReportLogHelper.access$000() == 5)
    {
      ReportLogHelper.stopTimeTask();
      return;
    }
    ReportLogHelper.access$102(true);
    ByteData.getInstance().runTime(12, ReportLogHelper.access$200(1, 0, ReportLogHelper.access$000()), 0);
    ReportLogHelper.access$008();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.secprotocol.t.ReportLogHelper.a
 * JD-Core Version:    0.7.0.1
 */