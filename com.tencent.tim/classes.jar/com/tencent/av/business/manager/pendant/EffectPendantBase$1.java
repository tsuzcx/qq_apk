package com.tencent.av.business.manager.pendant;

import com.tencent.qphone.base.util.QLog;
import iki;
import java.io.File;
import jqp;

public class EffectPendantBase$1
  implements Runnable
{
  public EffectPendantBase$1(iki paramiki, File paramFile, String paramString) {}
  
  public void run()
  {
    try
    {
      jqp.b(this.y, this.Nw);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(this.this$0.TAG, 2, "isTemplateUsable unzip error", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantBase.1
 * JD-Core Version:    0.7.0.1
 */