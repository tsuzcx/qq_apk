package com.tencent.qqmail.movemail;

import com.tencent.qqmail.folderlist.QMFolderManager.FolderOperationType;
import com.tencent.qqmail.model.mail.watcher.FolderOperationWatcher;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.thread.Threads;

class ManageFolderActivity$1
  implements FolderOperationWatcher
{
  ManageFolderActivity$1(ManageFolderActivity paramManageFolderActivity) {}
  
  public void onError(QMFolderManager.FolderOperationType paramFolderOperationType, QMNetworkError paramQMNetworkError)
  {
    Threads.runOnMainThread(new ManageFolderActivity.1.2(this, paramFolderOperationType));
  }
  
  public void onProcess() {}
  
  public void onSuccess(QMFolderManager.FolderOperationType paramFolderOperationType, QMFolder paramQMFolder, boolean paramBoolean)
  {
    Threads.runOnMainThread(new ManageFolderActivity.1.1(this, paramQMFolder, paramFolderOperationType, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movemail.ManageFolderActivity.1
 * JD-Core Version:    0.7.0.1
 */