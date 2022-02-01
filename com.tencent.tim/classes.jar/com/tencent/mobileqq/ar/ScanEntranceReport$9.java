package com.tencent.mobileqq.ar;

import adfx;
import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ScanEntranceReport$9
  implements Runnable
{
  public ScanEntranceReport$9(adfx paramadfx) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    anpc.a(BaseApplication.getContext()).collectPerformance("", "scanner_zoom_camera", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.9
 * JD-Core Version:    0.7.0.1
 */