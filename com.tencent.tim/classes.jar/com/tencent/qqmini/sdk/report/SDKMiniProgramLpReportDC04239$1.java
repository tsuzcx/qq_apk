package com.tencent.qqmini.sdk.report;

import android.os.Bundle;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;

final class SDKMiniProgramLpReportDC04239$1
  implements Runnable
{
  public void run()
  {
    if (SDKMiniProgramLpReportDC04239.access$000() != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("app_config", SDKMiniProgramLpReportDC04239.access$000());
      localBundle.putLong("add_duration_ms", SDKMiniProgramLpReportDC04239.access$100());
      AppBrandCmdProxy.g().sendCmd("record_duration", localBundle, null);
      SDKMiniProgramLpReportDC04239.access$200();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.1
 * JD-Core Version:    0.7.0.1
 */