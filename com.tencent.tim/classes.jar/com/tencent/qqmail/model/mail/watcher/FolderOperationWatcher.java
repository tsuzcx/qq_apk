package com.tencent.qqmail.model.mail.watcher;

import com.tencent.qqmail.folderlist.QMFolderManager.FolderOperationType;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface FolderOperationWatcher
  extends Watchers.Watcher
{
  public abstract void onError(QMFolderManager.FolderOperationType paramFolderOperationType, QMNetworkError paramQMNetworkError);
  
  public abstract void onProcess();
  
  public abstract void onSuccess(QMFolderManager.FolderOperationType paramFolderOperationType, QMFolder paramQMFolder, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.FolderOperationWatcher
 * JD-Core Version:    0.7.0.1
 */