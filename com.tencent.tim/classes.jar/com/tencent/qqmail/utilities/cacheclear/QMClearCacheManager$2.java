package com.tencent.qqmail.utilities.cacheclear;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import com.tencent.qqmail.utilities.log.QMLog;

class QMClearCacheManager$2
  implements Runnable
{
  QMClearCacheManager$2(QMClearCacheManager paramQMClearCacheManager) {}
  
  public void run()
  {
    try
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      Bundle localBundle = new Bundle();
      localBundle.putStringArrayList("cache_paths_to_delete", QMClearCacheManager.prepareAttachPathsToDelete());
      localMessage.setData(localBundle);
      QMClearCacheManager.access$200(this.this$0).send(localMessage);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.log(5, "QMClearCacheManager", "submitClearTask error!!", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.cacheclear.QMClearCacheManager.2
 * JD-Core Version:    0.7.0.1
 */