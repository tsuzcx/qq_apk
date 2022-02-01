package com.tencent.qqmail.utilities.log;

import rx.functions.Action1;

class ReportFileHandler$4
  implements Action1<Throwable>
{
  ReportFileHandler$4(ReportFileHandler paramReportFileHandler) {}
  
  public void call(Throwable paramThrowable)
  {
    QMLog.log(5, "ReportFileHandler", "getFileListBySuffixes: " + ReportFileHandler.access$200(this.this$0), paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.ReportFileHandler.4
 * JD-Core Version:    0.7.0.1
 */