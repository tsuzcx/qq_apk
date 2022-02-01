package com.tencent.qqmail.utilities.log;

import java.io.File;
import rx.functions.Func1;

class ReportFileHandler$5
  implements Func1<File, Boolean>
{
  ReportFileHandler$5(ReportFileHandler paramReportFileHandler, String[] paramArrayOfString) {}
  
  public Boolean call(File paramFile)
  {
    boolean bool = false;
    String[] arrayOfString = this.val$suffixes;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = arrayOfString[i];
        bool = paramFile.getPath().endsWith(str);
        if (!bool) {}
      }
      else
      {
        return Boolean.valueOf(bool);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.ReportFileHandler.5
 * JD-Core Version:    0.7.0.1
 */