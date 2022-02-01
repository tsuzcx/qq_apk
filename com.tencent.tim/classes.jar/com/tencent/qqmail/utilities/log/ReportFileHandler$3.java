package com.tencent.qqmail.utilities.log;

import java.io.File;
import java.util.List;
import rx.functions.Action1;

class ReportFileHandler$3
  implements Action1<File>
{
  ReportFileHandler$3(ReportFileHandler paramReportFileHandler, List paramList) {}
  
  public void call(File paramFile)
  {
    this.val$uploadFileList.add(paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.ReportFileHandler.3
 * JD-Core Version:    0.7.0.1
 */