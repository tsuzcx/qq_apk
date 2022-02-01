package com.tencent.qqmail.utilities.log;

import android.os.Handler;
import java.io.BufferedWriter;

final class QMLogStream$1
  implements Runnable
{
  public void run()
  {
    try
    {
      QMLogStream.access$000().flush();
      label6:
      QMLogStream.access$200().postDelayed(QMLogStream.access$100(), 10000L);
      return;
    }
    catch (Exception localException)
    {
      break label6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.QMLogStream.1
 * JD-Core Version:    0.7.0.1
 */