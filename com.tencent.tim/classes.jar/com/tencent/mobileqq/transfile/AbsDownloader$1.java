package com.tencent.mobileqq.transfile;

import aoiz;
import aokj.a;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class AbsDownloader$1
  implements Runnable
{
  public AbsDownloader$1(aoiz paramaoiz, aokj.a parama) {}
  
  public void run()
  {
    try
    {
      this.a.I();
      return;
    }
    catch (IOException localIOException)
    {
      do
      {
        QLog.e("AbsDownloader", 2, localIOException.getMessage());
      } while (this.a == null);
      this.a.abort(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AbsDownloader.1
 * JD-Core Version:    0.7.0.1
 */