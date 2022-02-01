package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import aqhq;
import com.tencent.qphone.base.util.QLog;
import lvg;
import lwc;

public class PTSEngineLoader$5
  implements Runnable
{
  public PTSEngineLoader$5(lvg paramlvg) {}
  
  public void run()
  {
    if (this.this$0.BJ())
    {
      QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], has loaded, do not load again.");
      return;
    }
    String str = lvg.b(this.this$0) + "/" + "libpts.so";
    QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], soFullPath = " + str);
    try
    {
      if (aqhq.fileExists(str))
      {
        System.load(str);
        lvg.a(this.this$0, true);
        QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], load so success.");
        lwc.bE("[loadPTSEngineImpl] pts succeed.", "2");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("PTSEngineLoader", 1, "[loadPTSEngineImpl] error, t = " + localThrowable);
      lwc.bD(localThrowable.toString(), "2");
      return;
    }
    QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], pts so does not exists.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader.5
 * JD-Core Version:    0.7.0.1
 */