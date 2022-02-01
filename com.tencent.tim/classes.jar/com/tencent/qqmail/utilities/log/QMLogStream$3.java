package com.tencent.qqmail.utilities.log;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

final class QMLogStream$3
  implements Runnable
{
  QMLogStream$3(String paramString) {}
  
  public void run()
  {
    Log.v("mason", "saveLogSync:" + this.val$msg);
    String str = this.val$msg.replaceAll("\\|", " ");
    if (!QMLogStream.access$500().isDirectory())
    {
      if ((QMLogStream.access$500().mkdirs()) || (QMLogStream.access$500().isDirectory()))
      {
        QMLogStream.access$500().setReadable(true, true);
        QMLogStream.access$500().setWritable(true, true);
      }
    }
    else if ((QMLogStream.access$000() != null) && (QMLogStream.access$600().exists())) {}
    try
    {
      QMLogStream.access$000().close();
      label106:
      QMLogStream.access$002(new BufferedWriter(new FileWriter(QMLogStream.access$600(), true)));
      try
      {
        label128:
        QMLogStream.access$000().write(str);
        QMLogStream.access$000().newLine();
        return;
      }
      catch (Exception localException1) {}
    }
    catch (IOException localIOException)
    {
      break label128;
    }
    catch (Exception localException2)
    {
      break label106;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.QMLogStream.3
 * JD-Core Version:    0.7.0.1
 */