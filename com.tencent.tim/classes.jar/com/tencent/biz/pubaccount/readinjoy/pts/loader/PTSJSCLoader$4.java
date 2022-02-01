package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import aqhq;
import com.tencent.qphone.base.util.QLog;
import lvi;
import lvk;

public class PTSJSCLoader$4
  implements Runnable
{
  public PTSJSCLoader$4(lvi paramlvi) {}
  
  public void run()
  {
    if (!aqhq.fileExists(lvi.b(this.this$0)))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJSC], offline dir does not exist.");
      return;
    }
    if (!lvk.H(lvi.b(this.this$0), "4044"))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJSC], offline dir is not valid.");
      return;
    }
    if (!lvk.dO(lvi.b(this.this$0) + "/" + "pts_jsc_config.json"))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJC], offline version is not valid.");
      return;
    }
    if (aqhq.fileExists(lvi.a(this.this$0)))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJC], delete inner dir, dir = " + lvi.a(this.this$0));
      aqhq.cn(lvi.a(this.this$0));
    }
    try
    {
      boolean bool1 = aqhq.copyFile(lvi.b(this.this$0) + "/" + "libjsc.so", lvi.a(this.this$0) + "/" + "libjsc.so");
      boolean bool2 = aqhq.copyFile(lvi.b(this.this$0) + "/" + "pts_jsc_config.json", lvi.a(this.this$0) + "/" + "pts_jsc_config.json");
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJSC], copyJSCSoSuccess = " + bool1 + ", copyConfigSuccess = " + bool2);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PTSJSCLoader", 1, "[handleDownloadPTSJSC], e = " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.4
 * JD-Core Version:    0.7.0.1
 */