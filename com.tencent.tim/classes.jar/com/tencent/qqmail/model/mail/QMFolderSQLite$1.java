package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.log.QMLog;

class QMFolderSQLite$1
  implements Runnable
{
  QMFolderSQLite$1(QMFolderSQLite paramQMFolderSQLite, QMFolder paramQMFolder, SQLiteDatabase paramSQLiteDatabase) {}
  
  public void run()
  {
    int i = this.val$folder.getId();
    int j = this.val$folder.getAccountId();
    String str1 = this.val$folder.getRemoteId();
    int k = this.val$folder.getParentId();
    int m = this.val$folder.getType();
    int n = this.val$folder.getSvrCount();
    int i1 = this.val$folder.getSvrUnreadCount();
    int i2 = this.val$folder.getCliUnreadCount();
    int i3 = this.val$folder.getCliUnreadCount();
    int i4 = this.val$folder.getSequence();
    boolean bool1 = this.val$folder.isVirtual();
    boolean bool2 = this.val$folder.isDisplay();
    String str2 = this.val$folder.getName();
    String str3 = this.val$folder.getPopId();
    String str4 = this.val$folder.getPopEmail();
    boolean bool3 = this.val$folder.isOverdue();
    boolean bool4 = this.val$folder.isLocked();
    String str5 = this.val$folder.getColorId();
    String str6 = this.val$folder.getParentName();
    long l = this.val$folder.getFromTime();
    int i5 = this.val$folder.getPersonalCount();
    try
    {
      this.val$writableDb.execSQL("REPLACE INTO QM_FOLDER (id,accountId,remoteId,parentId,type,svrCount,svrUnreadCount,cliUnreadCount,cliConvUnreadCount,sequence,isVirtual,isDisplay,name,popId,popEmail,overdue,locked,colorId,parentname,fromtime,personalCount) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { Integer.valueOf(i), Integer.valueOf(j), str1, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(bool1), Boolean.valueOf(bool2), str2, str3, str4, Boolean.valueOf(bool3), Boolean.valueOf(bool4), str5, str6, Long.valueOf(l), Integer.valueOf(i5) });
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMMailSQLite", "insert folder err : " + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.1
 * JD-Core Version:    0.7.0.1
 */