package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import jpa;
import lvi;
import lvj;

public class PTSJSCLoader$3
  implements Runnable
{
  public PTSJSCLoader$3(lvi paramlvi) {}
  
  public void run()
  {
    lvj locallvj = new lvj(this);
    try
    {
      jpa.init();
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        try
        {
          jpa.b("4044", BaseApplicationImpl.getApplication().getRuntime(), locallvj, true, 0, true);
          return;
        }
        catch (Throwable localThrowable1)
        {
          QLog.i("PTSJSCLoader", 1, "[updatePTSJSC], t = " + localThrowable1);
        }
        localThrowable2 = localThrowable2;
        QLog.e("PTSJSCLoader", 1, "[updatePTSJSC], t = " + localThrowable2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.3
 * JD-Core Version:    0.7.0.1
 */