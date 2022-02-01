package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.cache.IQuery;
import com.tencent.qqmail.model.cache.QMFolderCache;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import java.util.ArrayList;

class QMFolderSQLite$70
  implements IQuery<QMFolder>
{
  QMFolderSQLite$70(QMFolderSQLite paramQMFolderSQLite, SQLiteDatabase paramSQLiteDatabase, int paramInt) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    return paramQMFolder.getId() == this.val$folderId;
  }
  
  public void reduce(QMFolder paramQMFolder)
  {
    paramQMFolder = QMFolderSQLite.access$300(this.this$0, this.val$writableDb, "SELECT * FROM QM_FOLDER WHERE id=?", new String[] { String.valueOf(this.val$folderId) });
    if (paramQMFolder.size() == 1) {
      QMFolderSQLite.access$400(this.this$0).insert(Integer.valueOf(this.val$folderId), (QMFolder)paramQMFolder.get(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.70
 * JD-Core Version:    0.7.0.1
 */