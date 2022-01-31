package com.tencent.mobileqq.msf.core.a;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.f;
import com.tencent.mobileqq.msf.core.l;
import com.tencent.mobileqq.msf.sdk.k;
import com.tencent.msf.service.protocol.serverconfig.a;
import com.tencent.msf.service.protocol.serverconfig.j;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class e
  extends Thread
{
  e(d paramd, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    for (;;)
    {
      a locala;
      Object localObject;
      try
      {
        locala = (a)d.a(this.a).k();
        if (QLog.isColorLevel()) {
          QLog.i("MSF.C.SsoListManager", 2, "zip file start");
        }
        localObject = f.a(locala.b.a, locala.b.b, locala.b.c, locala.b.d, locala.c.a, locala.c.b, locala.c.c, locala.c.d);
        if (QLog.isColorLevel()) {
          QLog.i("MSF.C.SsoListManager", 2, "zip file finish");
        }
        if (localObject == null) {
          continue;
        }
        localObject = new File((String)localObject);
        boolean bool = ((File)localObject).exists();
        if (!bool) {
          break label252;
        }
      }
      catch (Exception localException1) {}
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("MSF.C.SsoListManager", 2, "report file start");
        }
        f.a(this.a.e.sender.i(), (File)localObject, locala.f);
        if (QLog.isColorLevel()) {
          QLog.i("MSF.C.SsoListManager", 2, "report file finish");
        }
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("MSF.C.SsoListManager", 2, "report log error " + localException2, localException2);
        continue;
      }
      ((File)localObject).deleteOnExit();
      continue;
      if (QLog.isColorLevel())
      {
        QLog.w("MSF.C.SsoListManager", 2, "handle report log error " + localException1, localException1);
        continue;
        label252:
        if (QLog.isColorLevel()) {
          QLog.w("MSF.C.SsoListManager", 2, "zip file not existed.");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.a.e
 * JD-Core Version:    0.7.0.1
 */