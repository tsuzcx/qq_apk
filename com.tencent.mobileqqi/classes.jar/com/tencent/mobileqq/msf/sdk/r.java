package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.msf.core.e;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

final class r
  extends Thread
{
  r(int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject1 = Calendar.getInstance();
    Object localObject2 = new SimpleDateFormat("yy.MM.dd.HH");
    String str = ((SimpleDateFormat)localObject2).format(((Calendar)localObject1).getTime()) + ".log";
    ((Calendar)localObject1).add(11, -1);
    localObject2 = ((SimpleDateFormat)localObject2).format(((Calendar)localObject1).getTime()) + ".log";
    File[] arrayOfFile = new File(n.m()).listFiles();
    if ((arrayOfFile != null) && (arrayOfFile.length > 0))
    {
      localObject1 = new ArrayList();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        if ((localFile.getName().endsWith(str)) || (localFile.getName().endsWith((String)localObject2))) {
          ((ArrayList)localObject1).add(localFile);
        }
        i += 1;
      }
      n.e(n.n().replace(":", "_"));
      str = n.m() + n.n() + ".zip";
      localObject2 = new File(str);
      ((File)localObject2).delete();
    }
    try
    {
      ((File)localObject2).createNewFile();
      e.a((ArrayList)localObject1, str);
      e.a(this.a, str, this.b, this.c);
      ((File)localObject2).delete();
      return;
    }
    catch (IOException localIOException)
    {
      QLog.d("MSF.D.QLogImpl", 1, "doReportLogSelf exception " + localIOException);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("MSF.D.QLogImpl", 1, "doReportLogSelf error " + localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.r
 * JD-Core Version:    0.7.0.1
 */