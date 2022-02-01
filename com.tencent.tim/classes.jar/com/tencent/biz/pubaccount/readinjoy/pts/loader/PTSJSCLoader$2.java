package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import aqhq;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import lvi;
import lwc;
import mqq.os.MqqHandler;

public class PTSJSCLoader$2
  implements Runnable
{
  public PTSJSCLoader$2(lvi paramlvi, Runnable paramRunnable) {}
  
  public void run()
  {
    if (this.this$0.CK())
    {
      QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], jsc has loaded, no need to load again.");
      if (this.cI != null) {
        ThreadManager.getFileThreadHandler().post(this.cI);
      }
    }
    for (;;)
    {
      return;
      String str = lvi.a(this.this$0) + "/" + "libjsc.so";
      QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], jscSoFullPath = " + str);
      try
      {
        if (aqhq.fileExists(str))
        {
          System.load(str);
          lvi.a(this.this$0, true);
          QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], load jsc so success");
          lwc.bE("[loadPTSJSC] succeed", "1");
          if (this.cI == null) {
            continue;
          }
          ThreadManager.getFileThreadHandler().post(this.cI);
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("PTSJSCLoader", 1, "[loadPTSJSC] error, t = " + localThrowable);
        lwc.bD(localThrowable.toString(), "1");
        return;
      }
    }
    QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], jsc so does not exists.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.2
 * JD-Core Version:    0.7.0.1
 */