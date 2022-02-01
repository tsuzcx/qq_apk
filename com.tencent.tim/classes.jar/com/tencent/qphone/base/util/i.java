package com.tencent.qphone.base.util;

import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

final class i
  extends Thread
{
  i(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    Object localObject1 = Calendar.getInstance();
    Object localObject2 = QLog.logFileFormatter.format(((Calendar)localObject1).getTime());
    ((Calendar)localObject1).add(11, -1);
    String str = QLog.logFileFormatter.format(((Calendar)localObject1).getTime());
    File[] arrayOfFile = new File(QLog.access$600()).listFiles();
    ArrayList localArrayList;
    int j;
    File localFile;
    int i;
    if ((arrayOfFile != null) && (arrayOfFile.length > 0))
    {
      localArrayList = new ArrayList();
      int k = arrayOfFile.length;
      j = 0;
      if (j < k)
      {
        localFile = arrayOfFile[j];
        localObject1 = localFile.getName();
        if (((String)localObject1).endsWith(".log"))
        {
          localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 4);
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (((i != 0) && (((String)localObject1).endsWith((String)localObject2))) || (((String)localObject1).endsWith(str))) {
        localArrayList.add(new QLog.a(localFile.getPath()));
      }
      j += 1;
      break;
      if (((String)localObject1).endsWith(".log.zip"))
      {
        localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 8);
        i = 1;
      }
      else
      {
        if (((String)localObject1).endsWith(".qlog"))
        {
          localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 5);
          i = 1;
          continue;
          if (this.a) {
            com.tencent.mobileqq.msf.core.i.a(localArrayList);
          }
          QLog.access$702(QLog.access$700().replace(":", "_"));
          localObject1 = QLog.access$600() + QLog.access$700() + "_" + QLog.getReportLevel(QLog.getUIN_REPORTLOG_LEVEL()) + ".zip";
          localObject2 = new File((String)localObject1);
          ((File)localObject2).delete();
          try
          {
            ((File)localObject2).createNewFile();
            com.tencent.mobileqq.msf.core.i.a(localArrayList, (String)localObject1);
            com.tencent.mobileqq.msf.core.i.a(this.b, (String)localObject1, this.c, this.d, this.e, this.f);
            ((File)localObject2).delete();
            if (this.a)
            {
              localObject1 = new File(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/corruptInfo");
              if (((File)localObject1).exists()) {
                ((File)localObject1).delete();
              }
            }
            return;
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              QLog.d("MSF.D.QLog", 1, "doReportLogSelf exception " + localIOException);
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              QLog.d("MSF.D.QLog", 1, "doReportLogSelf error " + localThrowable);
            }
          }
        }
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.i
 * JD-Core Version:    0.7.0.1
 */