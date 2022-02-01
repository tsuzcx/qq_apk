package com.tencent.qqmail.model.cache;

import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderCache$6
  implements IMapper<QMFolder>
{
  QMFolderCache$6(QMFolderCache paramQMFolderCache, IMapper paramIMapper) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    boolean bool = this.val$mapper.map(paramQMFolder);
    if (bool) {
      QMFolderCache.access$000(this.this$0).dropIndexes(paramQMFolder);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.cache.QMFolderCache.6
 * JD-Core Version:    0.7.0.1
 */