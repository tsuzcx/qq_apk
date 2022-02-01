package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.f.a;
import java.util.Map;

final class TbsDownloader$3
  implements f.a
{
  TbsDownloader$3(TbsDownloadConfig paramTbsDownloadConfig, boolean paramBoolean) {}
  
  public void a(int paramInt)
  {
    long l = System.currentTimeMillis();
    this.a.mSyncMap.put("last_check", Long.valueOf(l));
    this.a.commit();
    TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] httpResponseCode=" + paramInt);
    if ((TbsShareManager.isThirdPartyApp(TbsDownloader.a())) && (paramInt == 200))
    {
      this.a.mSyncMap.put("last_request_success", Long.valueOf(System.currentTimeMillis()));
      this.a.mSyncMap.put("request_fail", Long.valueOf(0L));
      this.a.mSyncMap.put("count_request_fail_in_24hours", Long.valueOf(0L));
      this.a.commit();
    }
    if (paramInt >= 300)
    {
      if (this.b) {
        this.a.setDownloadInterruptCode(-107);
      }
    }
    else {
      return;
    }
    this.a.setDownloadInterruptCode(-207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloader.3
 * JD-Core Version:    0.7.0.1
 */