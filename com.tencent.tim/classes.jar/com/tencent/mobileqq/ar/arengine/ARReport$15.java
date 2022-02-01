package com.tencent.mobileqq.ar.arengine;

import android.os.Build;
import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARReport$15
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ar_model", Build.MODEL);
    localHashMap.put("result", this.val$result + "");
    localHashMap.put("alltime", String.valueOf(this.TM));
    anpc.a(BaseApplication.getContext()).collectPerformance("", "AREngine_openCamera", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.15
 * JD-Core Version:    0.7.0.1
 */