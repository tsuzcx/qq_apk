package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IMapper;
import com.tencent.qqmail.model.cache.IQuery;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import java.util.TreeSet;

class QMFolderSQLite$45
  implements IQuery<QMFolder>
{
  QMFolderSQLite$45(QMFolderSQLite paramQMFolderSQLite, TreeSet paramTreeSet, IMapper paramIMapper) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    return this.val$mapper.map(paramQMFolder);
  }
  
  public void reduce(QMFolder paramQMFolder)
  {
    this.val$folders.add(paramQMFolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.45
 * JD-Core Version:    0.7.0.1
 */