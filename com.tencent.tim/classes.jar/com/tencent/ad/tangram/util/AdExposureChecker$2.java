package com.tencent.ad.tangram.util;

import com.tencent.ad.tangram.log.AdLog;

class AdExposureChecker$2
  implements Runnable
{
  AdExposureChecker$2(AdExposureChecker paramAdExposureChecker) {}
  
  public void run()
  {
    AdLog.d("AdExposureChecker", "onActivityResume");
    AdExposureChecker.access$802(this.this$0, true);
    AdExposureChecker.access$900(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdExposureChecker.2
 * JD-Core Version:    0.7.0.1
 */