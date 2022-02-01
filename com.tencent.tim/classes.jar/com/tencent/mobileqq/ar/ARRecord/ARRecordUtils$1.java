package com.tencent.mobileqq.ar.ARRecord;

import acfp;
import adci;
import adcl;
import aqha;
import aqju;

public final class ARRecordUtils$1
  implements Runnable
{
  public ARRecordUtils$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      aqha.a(adcl.a().getContext(), 230, this.val$title, this.val$content, "", acfp.m(2131702866), new adci(this), null).show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARRecordUtils.1
 * JD-Core Version:    0.7.0.1
 */