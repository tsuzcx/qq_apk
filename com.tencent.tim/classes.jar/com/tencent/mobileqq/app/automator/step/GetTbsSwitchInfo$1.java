package com.tencent.mobileqq.app.automator.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.smtt.sdk.TbsDownloader;

class GetTbsSwitchInfo$1
  implements Runnable
{
  GetTbsSwitchInfo$1(GetTbsSwitchInfo paramGetTbsSwitchInfo) {}
  
  public void run()
  {
    TbsDownloader.needDownload(BaseApplicationImpl.getContext(), false, false, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetTbsSwitchInfo.1
 * JD-Core Version:    0.7.0.1
 */