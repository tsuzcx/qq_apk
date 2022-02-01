package com.tencent.qqmail.model.cache;

import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderCache$3
  implements IQuery<QMFolder>
{
  QMFolderCache$3(QMFolderCache paramQMFolderCache, IQuery paramIQuery) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    return this.val$query.map(paramQMFolder);
  }
  
  public void reduce(QMFolder paramQMFolder)
  {
    this.val$query.reduce(paramQMFolder);
    QMFolderCache.access$000(this.this$0).ensureIndexes(paramQMFolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.cache.QMFolderCache.3
 * JD-Core Version:    0.7.0.1
 */