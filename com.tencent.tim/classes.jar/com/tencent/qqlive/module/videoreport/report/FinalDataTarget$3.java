package com.tencent.qqlive.module.videoreport.report;

import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;

final class FinalDataTarget$3
  implements Runnable
{
  FinalDataTarget$3(FinalData paramFinalData) {}
  
  public void run()
  {
    ReusablePool.recycle(this.val$finalData, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.FinalDataTarget.3
 * JD-Core Version:    0.7.0.1
 */