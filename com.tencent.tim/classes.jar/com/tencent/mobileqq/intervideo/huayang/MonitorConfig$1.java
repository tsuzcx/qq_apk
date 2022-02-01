package com.tencent.mobileqq.intervideo.huayang;

import aids;
import aidt;
import android.content.Context;
import java.util.Map;

public final class MonitorConfig$1
  implements Runnable
{
  public MonitorConfig$1(Context paramContext, String paramString) {}
  
  public void run()
  {
    aidt.bC(this.val$context, this.val$appType);
    if (aidt.ls.get(this.val$appType) != null)
    {
      aids.report(String.valueOf(((aidt)aidt.ls.get(this.val$appType)).dda));
      return;
    }
    aids.report("3235983");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.MonitorConfig.1
 * JD-Core Version:    0.7.0.1
 */