package com.tencent.qqmail.utilities.log;

import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMGeneralCallback;
import java.io.File;

final class FeedbackManager$2
  implements QMGeneralCallback
{
  FeedbackManager$2(String paramString1, String paramString2, QMGeneralCallback paramQMGeneralCallback) {}
  
  private void delPushLogFile()
  {
    File localFile = new File(this.val$attachPath);
    if ((localFile != null) && (localFile.exists())) {
      localFile.delete();
    }
    FileUtil.delAllFile(this.val$CacheFilePath);
    FileUtil.delFile(this.val$CacheFilePath);
  }
  
  public void onError()
  {
    delPushLogFile();
    if (this.val$callback != null) {
      this.val$callback.onError();
    }
  }
  
  public void onSuccess()
  {
    delPushLogFile();
    if (this.val$callback != null) {
      this.val$callback.onSuccess();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.FeedbackManager.2
 * JD-Core Version:    0.7.0.1
 */