package com.tencent.qqmail.protocol;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.ReportFileHandler;
import java.util.List;

final class DataCollectorImpl$1
  extends SimpleOnProtocolListener
{
  DataCollectorImpl$1(List paramList) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    if (paramCloudProtocolResult.error_code_ == 0)
    {
      QMLog.log(4, "DataCollectorImpl", "uma report success, delete files");
      ReportFileHandler.deleteFiles(this.val$files);
    }
    for (;;)
    {
      DataCollectorImpl.access$000().finishUpload();
      return;
      QMLog.log(5, "DataCollectorImpl", "uma report failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.DataCollectorImpl.1
 * JD-Core Version:    0.7.0.1
 */