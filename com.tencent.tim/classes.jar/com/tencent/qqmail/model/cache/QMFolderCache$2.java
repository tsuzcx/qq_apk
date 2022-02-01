package com.tencent.qqmail.model.cache;

import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderCache$2
  implements IReducer<QMFolder>
{
  QMFolderCache$2(QMFolderCache paramQMFolderCache, IReducer paramIReducer) {}
  
  public void reduce(QMFolder paramQMFolder)
  {
    this.val$reducer.reduce(paramQMFolder);
    QMFolderCache.access$000(this.this$0).ensureIndexes(paramQMFolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.cache.QMFolderCache.2
 * JD-Core Version:    0.7.0.1
 */