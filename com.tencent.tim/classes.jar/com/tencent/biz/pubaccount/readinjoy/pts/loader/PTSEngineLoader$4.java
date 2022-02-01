package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import aqhq;
import com.tencent.qphone.base.util.QLog;
import lvg;
import lvk;

public class PTSEngineLoader$4
  implements Runnable
{
  public PTSEngineLoader$4(lvg paramlvg) {}
  
  public void run()
  {
    if (!aqhq.fileExists(lvg.a(this.this$0)))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir does not exist.");
      return;
    }
    if (!lvk.H(lvg.a(this.this$0), "3980"))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir is not valid.");
      return;
    }
    if (!lvk.dO(lvg.a(this.this$0) + "/" + "pts_config.json"))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir version is not valid.");
      return;
    }
    if (aqhq.fileExists(lvg.b(this.this$0)))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], delete inner dir, dir = " + lvg.b(this.this$0));
      aqhq.cn(lvg.b(this.this$0));
    }
    try
    {
      boolean bool1 = aqhq.copyFile(lvg.a(this.this$0) + "/" + "libpts.so", lvg.b(this.this$0) + "/" + "libpts.so");
      boolean bool2 = aqhq.copyFile(lvg.a(this.this$0) + "/" + "pts_config.json", lvg.b(this.this$0) + "/" + "pts_config.json");
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], copySoSuccess = " + bool1 + ", copyConfigSuccess = " + bool2);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PTSEngineLoader", 1, "[handleDownloadPTSEngine], e = " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.4
 * JD-Core Version:    0.7.0.1
 */