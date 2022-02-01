package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.f.a;

class TbsLogReport$3
  implements f.a
{
  TbsLogReport$3(TbsLogReport paramTbsLogReport) {}
  
  public void a(int paramInt)
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:" + paramInt);
    if (paramInt < 300) {
      TbsLogReport.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport.3
 * JD-Core Version:    0.7.0.1
 */