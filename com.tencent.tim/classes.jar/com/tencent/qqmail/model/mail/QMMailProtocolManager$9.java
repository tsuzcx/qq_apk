package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.callback.IListStatusCallback;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import java.util.ArrayList;

class QMMailProtocolManager$9
  implements Runnable
{
  QMMailProtocolManager$9(QMMailProtocolManager paramQMMailProtocolManager, ArrayList paramArrayList, QMFolder paramQMFolder, IListStatusCallback paramIListStatusCallback) {}
  
  public void run()
  {
    synchronized (this.val$dispatchFolders)
    {
      if (this.val$dispatchFolders.contains(Integer.valueOf(this.val$folder.getId()))) {
        this.val$dispatchFolders.remove(Integer.valueOf(this.val$folder.getId()));
      }
      if ((this.val$dispatchFolders.size() == 0) && (this.val$callback != null)) {
        this.val$callback.success(false, 0, 0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.9
 * JD-Core Version:    0.7.0.1
 */