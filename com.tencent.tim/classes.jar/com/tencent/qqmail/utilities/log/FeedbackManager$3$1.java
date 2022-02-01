package com.tencent.qqmail.utilities.log;

import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMGeneralCallback;

class FeedbackManager$3$1
  implements QMGeneralCallback
{
  FeedbackManager$3$1(FeedbackManager.3 param3) {}
  
  public void onError()
  {
    QMLog.log(4, "QMDebuglogManager", "cheackJniCrashAndSendFeedback fail");
  }
  
  public void onSuccess()
  {
    FileUtil.delAllFile(LogPathManager.getInstance().getTombstoneDirPath());
    QMLog.log(4, "QMDebuglogManager", "cheackJniCrashAndSendFeedback success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.FeedbackManager.3.1
 * JD-Core Version:    0.7.0.1
 */