package com.tencent.qqmail.utilities.log;

import java.util.List;

final class FeedbackManager$1
  implements Runnable
{
  FeedbackManager$1(String paramString, List paramList) {}
  
  public void run()
  {
    FeedbackManager.sendLog("mailapppushlog@qq.com", "mailapppushlog", "d90Ebe5$2c848j57", "helpapp@qq.com", this.val$subject, FeedbackManager.feedBackDeviceInfos(), this.val$dbFiles, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.FeedbackManager.1
 * JD-Core Version:    0.7.0.1
 */