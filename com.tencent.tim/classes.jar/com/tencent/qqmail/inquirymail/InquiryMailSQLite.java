package com.tencent.qqmail.inquirymail;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.inquirymail.model.InquiryMail;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper.UnsupportedGetDatabase;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class InquiryMailSQLite
  extends QMMailSQLiteHelper.UnsupportedGetDatabase
{
  private static final String TAG = "InquiryMailSQLite";
  private static final String sqlCreate = "CREATE TABLE IF NOT EXISTS QM_INQUIRY_MAIL(id integer, time integer, senderName varchar, senderAddress varchar, subject varchar, restore integer, msgId varchar, folder integer, folderId integer, idx varchar, reason integer, mailId varchar, accountId integer, page integer,edgeTime integer )";
  private static final String sqlCreateForUpgrade = "CREATE TABLE IF NOT EXISTS QM_INQUIRY_MAIL(id integer, time integer, senderName varchar, senderAddress varchar, subject varchar, restore integer, msgId varchar, folder integer, folderId integer, idx varchar, reason integer, mailId varchar, accountId integer, page integer,edgeTime integer )";
  private static final String sqlDeleteInquiryMailByAccount = "DELETE FROM QM_INQUIRY_MAIL WHERE accountId=?";
  private static final String sqlDrop = "DROP TABLE IF EXISTS QM_INQUIRY_MAIL";
  private static final String sqlInsert = "REPLACE INTO QM_INQUIRY_MAIL (id , time , senderName , senderAddress , subject , restore , msgId , folder , folderId , idx , reason , mailId , accountId , page ,edgeTime  ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  private static final String sqlQueryInquiryMailByAccount = "SELECT * FROM QM_INQUIRY_MAIL WHERE accountId=? ORDER BY time DESC";
  private static final String sqlUpdate = "UPDATE QM_INQUIRY_MAIL SET time = ?, senderName = ?, senderAddress = ?, subject = ?, restore = ?, msgId = ?, folder = ?, folderId = ?, idx = ?, reason = ?, mailId = ?, accountId = ?, page = ?,edgeTime = ?  WHERE id = ?";
  private static final String sqlUpdateFolderByRemoteId = "UPDATE QM_INQUIRY_MAIL SET folder = ?, folderId = ?, idx = ?  WHERE mailId IN ";
  private static final String sqlUpdateReasonByReasonAndSenderAddress = "UPDATE QM_INQUIRY_MAIL SET reason = ?  WHERE senderAddress = ? AND reason IN ";
  
  public InquiryMailSQLite(Context paramContext)
  {
    super(paramContext, false);
  }
  
  private static void beginColumnIndex(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null) {
      paramArrayOfInt[0] = 0;
    }
  }
  
  public static void fillInquiryMail(InquiryMail paramInquiryMail, Cursor paramCursor, int[] paramArrayOfInt)
  {
    beginColumnIndex(paramArrayOfInt);
    paramInquiryMail.setId(paramCursor.getLong(getColumnIndex(paramArrayOfInt, paramCursor, "id")));
    paramInquiryMail.setTime(paramCursor.getLong(getColumnIndex(paramArrayOfInt, paramCursor, "time")));
    paramInquiryMail.setSenderName(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "senderName")));
    paramInquiryMail.setSenderAddress(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "senderAddress")));
    paramInquiryMail.setSubject(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "subject")));
    paramInquiryMail.setRestore(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "restore")));
    paramInquiryMail.setMsgId(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "msgId")));
    paramInquiryMail.setFolder(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "folder")));
    paramInquiryMail.setFolderId(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "folderId")));
    paramInquiryMail.setIdx(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "idx")));
    paramInquiryMail.setReason(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "reason")));
    paramInquiryMail.setMailId(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "mailId")));
    paramInquiryMail.setAccountId(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "accountId")));
    paramInquiryMail.setPage(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "page")));
    paramInquiryMail.setEdgeTime(paramCursor.getLong(getColumnIndex(paramArrayOfInt, paramCursor, "edgeTime")));
  }
  
  private static int getColumnIndex(int[] paramArrayOfInt, Cursor paramCursor, String paramString)
  {
    if (paramArrayOfInt == null) {
      return paramCursor.getColumnIndex(paramString);
    }
    int i = paramArrayOfInt[0] + 1;
    paramArrayOfInt[0] = i;
    if ((paramArrayOfInt[i] > -2147483648) && (paramArrayOfInt[i] != -1)) {
      return paramArrayOfInt[i];
    }
    paramArrayOfInt[i] = paramCursor.getColumnIndex(paramString);
    return paramArrayOfInt[i];
  }
  
  public void createIndex(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void createTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_INQUIRY_MAIL(id integer, time integer, senderName varchar, senderAddress varchar, subject varchar, restore integer, msgId varchar, folder integer, folderId integer, idx varchar, reason integer, mailId varchar, accountId integer, page integer,edgeTime integer )");
    QMLog.log(4, "InquiryMailSQLite", "create table");
  }
  
  public void deleteInquiryMail(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_INQUIRY_MAIL WHERE accountId=?", new Object[] { String.valueOf(paramInt) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "InquiryMailSQLite", Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void dropIndex(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void dropTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_INQUIRY_MAIL");
    QMLog.log(4, "InquiryMailSQLite", "drop table");
  }
  
  public Cursor getInquiryMailCursor(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_INQUIRY_MAIL WHERE accountId=? ORDER BY time DESC", new String[] { String.valueOf(paramInt) });
      return paramSQLiteDatabase;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "InquiryMailSQLite", Log.getStackTraceString(paramSQLiteDatabase));
    }
    return null;
  }
  
  public void insertInquiryMail(SQLiteDatabase paramSQLiteDatabase, ArrayList<InquiryMail> paramArrayList)
  {
    if (paramArrayList != null) {
      try
      {
        if (paramArrayList.size() > 0)
        {
          paramArrayList = paramArrayList.iterator();
          while (paramArrayList.hasNext())
          {
            InquiryMail localInquiryMail = (InquiryMail)paramArrayList.next();
            paramSQLiteDatabase.execSQL("REPLACE INTO QM_INQUIRY_MAIL (id , time , senderName , senderAddress , subject , restore , msgId , folder , folderId , idx , reason , mailId , accountId , page ,edgeTime  ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { Long.valueOf(localInquiryMail.getId()), Long.valueOf(localInquiryMail.getTime()), localInquiryMail.getSenderName(), localInquiryMail.getSenderAddress(), localInquiryMail.getSubject(), Integer.valueOf(localInquiryMail.getRestore()), localInquiryMail.getMsgId(), Integer.valueOf(localInquiryMail.getFolder()), Integer.valueOf(localInquiryMail.getFolderId()), localInquiryMail.getIdx(), Integer.valueOf(localInquiryMail.getReason()), localInquiryMail.getMailId(), Integer.valueOf(localInquiryMail.getAccountId()), Integer.valueOf(localInquiryMail.getPage()), Long.valueOf(localInquiryMail.getEdgeTime()) });
          }
        }
        return;
      }
      catch (Exception paramSQLiteDatabase)
      {
        QMLog.log(6, "InquiryMailSQLite", Log.getStackTraceString(paramSQLiteDatabase));
      }
    }
  }
  
  public void moveInquiryMailToTrash(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString, boolean paramBoolean)
  {
    int j = 0;
    int i;
    if (paramBoolean)
    {
      i = 7;
      if (!paramBoolean) {
        break label105;
      }
    }
    for (;;)
    {
      if (paramBoolean) {}
      for (String str = "0__";; str = "5__") {
        try
        {
          paramSQLiteDatabase.execSQL("UPDATE QM_INQUIRY_MAIL SET folder = ?, folderId = ?, idx = ?  WHERE mailId IN " + getInClause(paramArrayOfString), new Object[] { Integer.valueOf(i), Integer.valueOf(j), str });
          return;
        }
        catch (Exception paramSQLiteDatabase)
        {
          QMLog.log(6, "InquiryMailSQLite", Log.getStackTraceString(paramSQLiteDatabase));
          return;
        }
      }
      i = 6;
      break;
      label105:
      j = 5;
    }
  }
  
  public void updateInquiryMail(SQLiteDatabase paramSQLiteDatabase, ArrayList<InquiryMail> paramArrayList)
  {
    if (paramArrayList != null) {
      try
      {
        if (paramArrayList.size() > 0)
        {
          paramArrayList = paramArrayList.iterator();
          while (paramArrayList.hasNext())
          {
            InquiryMail localInquiryMail = (InquiryMail)paramArrayList.next();
            paramSQLiteDatabase.execSQL("UPDATE QM_INQUIRY_MAIL SET time = ?, senderName = ?, senderAddress = ?, subject = ?, restore = ?, msgId = ?, folder = ?, folderId = ?, idx = ?, reason = ?, mailId = ?, accountId = ?, page = ?,edgeTime = ?  WHERE id = ?", new Object[] { Long.valueOf(localInquiryMail.getTime()), localInquiryMail.getSenderName(), localInquiryMail.getSenderAddress(), localInquiryMail.getSubject(), Integer.valueOf(localInquiryMail.getRestore()), localInquiryMail.getMsgId(), Integer.valueOf(localInquiryMail.getFolder()), Integer.valueOf(localInquiryMail.getFolderId()), localInquiryMail.getIdx(), Integer.valueOf(localInquiryMail.getReason()), localInquiryMail.getMailId(), Integer.valueOf(localInquiryMail.getAccountId()), Integer.valueOf(localInquiryMail.getPage()), Long.valueOf(localInquiryMail.getEdgeTime()), Long.valueOf(localInquiryMail.getId()) });
          }
        }
        return;
      }
      catch (Exception paramSQLiteDatabase)
      {
        QMLog.log(6, "InquiryMailSQLite", Log.getStackTraceString(paramSQLiteDatabase));
      }
    }
  }
  
  public void updateInquiryMailReasonBySenderAddressAndReason(SQLiteDatabase paramSQLiteDatabase, int paramInt, int[] paramArrayOfInt, String paramString)
  {
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE QM_INQUIRY_MAIL SET reason = ?  WHERE senderAddress = ? AND reason IN " + getInClause(paramArrayOfInt), new Object[] { Integer.valueOf(paramInt), paramString });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "InquiryMailSQLite", Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void upgradeTableFor5005(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_INQUIRY_MAIL(id integer, time integer, senderName varchar, senderAddress varchar, subject varchar, restore integer, msgId varchar, folder integer, folderId integer, idx varchar, reason integer, mailId varchar, accountId integer, page integer,edgeTime integer )");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.InquiryMailSQLite
 * JD-Core Version:    0.7.0.1
 */