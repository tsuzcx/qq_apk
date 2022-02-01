package com.tencent.viola.core;

import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.util.HashMap;

class ViolaReportManager$1
  implements Runnable
{
  ViolaReportManager$1(ViolaReportManager paramViolaReportManager, HashMap paramHashMap, String paramString) {}
  
  public void run()
  {
    if ((this.val$hashMap != null) && (!this.val$hashMap.isEmpty())) {}
    try
    {
      HashMap localHashMap = ViolaUtils.copyMap(this.val$hashMap);
      ViolaReportManager.access$000(this.this$0, this.val$eventName, localHashMap);
      ViolaReportManager.access$100(this.this$0, localHashMap);
      return;
    }
    catch (Exception localException)
    {
      ViolaLogUtils.e("ViolaReportManager", "postDataToBeacon runnable error:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.core.ViolaReportManager.1
 * JD-Core Version:    0.7.0.1
 */