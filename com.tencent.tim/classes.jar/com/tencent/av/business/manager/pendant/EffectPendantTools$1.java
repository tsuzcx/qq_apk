package com.tencent.av.business.manager.pendant;

import com.tencent.qphone.base.util.QLog;
import ikl;
import java.io.File;
import jqp;

public class EffectPendantTools$1
  implements Runnable
{
  public EffectPendantTools$1(ikl paramikl, File paramFile, PendantItem paramPendantItem) {}
  
  public void run()
  {
    try
    {
      jqp.b(this.y, this.this$0.b(this.c));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantTools.1
 * JD-Core Version:    0.7.0.1
 */