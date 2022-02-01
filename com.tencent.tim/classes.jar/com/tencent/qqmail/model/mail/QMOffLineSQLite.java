package com.tencent.qqmail.model.mail;

import android.content.Context;
import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.qmdomain.QMOffLineOperation;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QMOffLineSQLite
  extends QMMailSQLiteHelper.UnsupportedGetDatabase
{
  private static final String ORDER_ACC_FR_OPER = " ORDER BY oper ASC , accountid , folderid";
  private static final String ORDER_ACC_OPER = " ORDER BY accountid , oper";
  private static final String sqlCreateOffLineOper = "CREATE TABLE IF NOT EXISTS QM_OFF_LINE_OPER(id integer primary key, accountid integer, mailid varchar, oper integer, param varchar, class integer )";
  private static final String sqlCreateOffLineOperInfo = "CREATE TABLE IF NOT EXISTS QM_OFF_LINE_OPER_INFO(mailid varchar primary key, id integer, svrkey varchar, folderid integer, accountid integer)";
  private static final String sqlDelOfflineOper = "DELETE FROM QM_OFF_LINE_OPER WHERE id in ? ";
  private static final String sqlDelOfflineOperInfo = "DELETE FROM QM_OFF_LINE_OPER_INFO WHERE id in ? ";
  private static final String sqlDeleteOper = "DELETE FROM QM_OFF_LINE_OPER";
  private static final String sqlDeleteOperByAccount = "DELETE FROM QM_OFF_LINE_OPER WHERE accountid =?";
  private static final String sqlDeleteOperByAccountIdAndType = "DELETE FROM QM_OFF_LINE_OPER WHERE accountid = ? AND class =?";
  private static final String sqlDeleteOperByType = "DELETE FROM QM_OFF_LINE_OPER WHERE class =?";
  private static final String sqlDeleteOperInfo = "DELETE FROM QM_OFF_LINE_OPER_INFO";
  private static final String sqlDeleteOperInfoByAccount = "DELETE FROM QM_OFF_LINE_OPER WHERE accountid =?";
  private static final String sqlDeleteOperUMAGlobalSetting = "DELETE FROM QM_OFF_LINE_OPER where class = 3 and accountid =-1";
  private static final String sqlDropOffLineOper = "DROP TABLE IF EXISTS QM_OFF_LINE_OPER";
  private static final String sqlDropOffLineOperInfo = "DROP TABLE IF EXISTS QM_OFF_LINE_OPER_INFO";
  private static final String sqlInsertOper = "REPLACE INTO QM_OFF_LINE_OPER ( id,accountid,mailid,oper,param,class) VALUES (?,?,?,?,?,?)";
  private static final String sqlInsertOperInfo = "INSERT OR IGNORE INTO QM_OFF_LINE_OPER_INFO ( mailid,id,svrkey,folderid,accountid) VALUES (?,?,?,?,?)";
  private static final String sqlQueryMailDelSpamOperation = "SELECT OPER.*, INFO.* FROM QM_OFF_LINE_OPER AS OPER , QM_OFF_LINE_OPER_INFO AS INFO WHERE OPER.mailid = INFO.mailid AND OPER.oper =2 AND (OPER.param =0 or param =1) AND class =?  ORDER BY oper ASC , accountid , folderid,param";
  private static final String sqlQueryMailOtherOperation = "SELECT OPER.*, INFO.* FROM QM_OFF_LINE_OPER AS OPER , QM_OFF_LINE_OPER_INFO AS INFO WHERE OPER.mailid = INFO.mailid AND param !=0 AND param != 1 AND class =?  ORDER BY oper ASC , accountid , folderid,param";
  private static final String sqlQueryOperation = "SELECT OPER.*, INFO.* FROM QM_OFF_LINE_OPER AS OPER , QM_OFF_LINE_OPER_INFO AS INFO WHERE OPER.mailid = INFO.mailid";
  private static final String sqlQueryPushAccountFolderStr = "select param from QM_OFF_LINE_OPER where accountid=? and oper=8";
  private static final String sqlQuerySettingOperation = "SELECT * FROM QM_OFF_LINE_OPER WHERE class =?  ORDER BY accountid , oper";
  private String TAG = "QMOffLineOperation";
  
  public QMOffLineSQLite(Context paramContext)
  {
    super(paramContext, false);
  }
  
  private QMOffLineOperation fillOper(Cursor paramCursor, boolean paramBoolean)
  {
    QMOffLineOperation localQMOffLineOperation = new QMOffLineOperation();
    localQMOffLineOperation.setType(paramCursor.getInt(paramCursor.getColumnIndex("oper")));
    localQMOffLineOperation.setAccountId(paramCursor.getInt(paramCursor.getColumnIndex("accountid")));
    if (!paramBoolean)
    {
      localQMOffLineOperation.setFolderId(paramCursor.getInt(paramCursor.getColumnIndex("folderid")));
      localQMOffLineOperation.setMailid(paramCursor.getString(paramCursor.getColumnIndex("mailid")));
      localQMOffLineOperation.setSvrKey(paramCursor.getString(paramCursor.getColumnIndex("svrkey")));
    }
    localQMOffLineOperation.setParam(paramCursor.getString(paramCursor.getColumnIndex("param")));
    return localQMOffLineOperation;
  }
  
  public void createIndex(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void createTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_OFF_LINE_OPER(id integer primary key, accountid integer, mailid varchar, oper integer, param varchar, class integer )");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_OFF_LINE_OPER_INFO(mailid varchar primary key, id integer, svrkey varchar, folderid integer, accountid integer)");
    QMLog.log(4, this.TAG, "create table");
  }
  
  public void delAccountOfflinePushFolder(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    paramSQLiteDatabase.delete("QM_OFF_LINE_OPER", "accountid=? and oper=8", new String[] { paramInt + "" });
  }
  
  public void delOffLineOpers(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    try
    {
      paramSQLiteDatabase.beginTransactionNonExclusive();
      paramSQLiteDatabase.execSQL("DELETE FROM QM_OFF_LINE_OPER WHERE accountid =?", new String[] { paramInt + "" });
      paramSQLiteDatabase.execSQL("DELETE FROM QM_OFF_LINE_OPER WHERE accountid =?", new String[] { paramInt + "" });
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, this.TAG, "del offline opers fail : " + localException.toString());
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public void delOffLineOpers(SQLiteDatabase paramSQLiteDatabase, int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      QMLog.log(5, this.TAG, "delOffLineOpers by account. types invalid");
      return;
    }
    try
    {
      paramSQLiteDatabase.beginTransactionNonExclusive();
      while (i < paramArrayOfInt.length)
      {
        paramSQLiteDatabase.execSQL("DELETE FROM QM_OFF_LINE_OPER WHERE accountid = ? AND class =?", new String[] { String.valueOf(paramInt), String.valueOf(paramArrayOfInt[i]) });
        i += 1;
      }
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception paramArrayOfInt)
    {
      QMLog.log(6, this.TAG, "del offline opers by accountid fail : " + paramArrayOfInt.toString());
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public void delOffLineOpers(SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt)
  {
    int i = 0;
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      QMLog.log(5, this.TAG, "delOffLineOpers. types invalid");
      return;
    }
    try
    {
      paramSQLiteDatabase.beginTransactionNonExclusive();
      while (i < paramArrayOfInt.length)
      {
        paramSQLiteDatabase.execSQL("DELETE FROM QM_OFF_LINE_OPER WHERE class =?", new String[] { paramArrayOfInt[i] + "" });
        i += 1;
      }
      paramSQLiteDatabase.execSQL("DELETE FROM QM_OFF_LINE_OPER_INFO");
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception paramArrayOfInt)
    {
      QMLog.log(6, this.TAG, "del offline opers fail : " + paramArrayOfInt.toString());
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public void dropIndex(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void dropTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_OFF_LINE_OPER");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_OFF_LINE_OPER_INFO");
    QMLog.log(4, this.TAG, "create table");
  }
  
  public Set<String> getOffLineOperTypeOfUMA(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_OFF_LINE_OPER WHERE class =?  ORDER BY accountid , oper", new String[] { "3" });
    HashSet localHashSet = new HashSet();
    if (paramSQLiteDatabase != null) {
      if (!paramSQLiteDatabase.moveToFirst()) {}
    }
    for (;;)
    {
      if (paramSQLiteDatabase.getColumnIndex("accountid") == -1) {
        localHashSet.add(paramSQLiteDatabase.getColumnIndex("oper") + "");
      }
      while (!paramSQLiteDatabase.moveToNext())
      {
        paramSQLiteDatabase.close();
        return localHashSet;
        localHashSet.add(paramSQLiteDatabase.getColumnIndex("accountid") + "_" + paramSQLiteDatabase.getColumnIndex("oper"));
      }
    }
  }
  
  public String getPushFolderStr(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    Cursor localCursor = paramSQLiteDatabase.rawQuery("select param from QM_OFF_LINE_OPER where accountid=? and oper=8", new String[] { paramInt + "" });
    paramSQLiteDatabase = "";
    SQLiteDatabase localSQLiteDatabase = paramSQLiteDatabase;
    if (localCursor != null)
    {
      if (localCursor.moveToFirst()) {
        paramSQLiteDatabase = localCursor.getString(0);
      }
      localCursor.close();
      localSQLiteDatabase = paramSQLiteDatabase;
    }
    return localSQLiteDatabase;
  }
  
  public void insertOperations(SQLiteDatabase paramSQLiteDatabase, List<QMOffLineOperation> paramList)
  {
    paramSQLiteDatabase.beginTransactionNonExclusive();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramList.size())
        {
          QMOffLineOperation localQMOffLineOperation = (QMOffLineOperation)paramList.get(i);
          long l1;
          if (localQMOffLineOperation.getCategory() == 2)
          {
            if (QMOffLineOperation.isGlobalSetting(localQMOffLineOperation.getType()))
            {
              l1 = QMOffLineOperation.generateGlobalSettingId(localQMOffLineOperation.getType());
              if (localQMOffLineOperation.getType() == 3)
              {
                long l2 = QMOffLineOperation.generateMailOperId(localQMOffLineOperation.getAccountId(), localQMOffLineOperation.getFolderId(), localQMOffLineOperation.getMailid(), 1);
                long l3 = QMOffLineOperation.generateMailOperId(localQMOffLineOperation.getAccountId(), localQMOffLineOperation.getFolderId(), localQMOffLineOperation.getMailid(), 0);
                long l4 = QMOffLineOperation.generateMailOperId(localQMOffLineOperation.getAccountId(), localQMOffLineOperation.getFolderId(), localQMOffLineOperation.getMailid(), 2);
                paramSQLiteDatabase.execSQL("DELETE FROM QM_OFF_LINE_OPER WHERE id in ? ", new String[] { String.valueOf(l2), String.valueOf(l3), String.valueOf(l4) });
                paramSQLiteDatabase.execSQL("DELETE FROM QM_OFF_LINE_OPER_INFO WHERE id in ? ", new String[] { String.valueOf(l2), String.valueOf(l3), String.valueOf(l4) });
              }
              int j = localQMOffLineOperation.getAccountId();
              String str1 = localQMOffLineOperation.getMailid();
              int k = localQMOffLineOperation.getType();
              String str2 = localQMOffLineOperation.getParam();
              int m = localQMOffLineOperation.getCategory();
              String str3 = localQMOffLineOperation.getMailid();
              String str4 = localQMOffLineOperation.getSvrKey();
              int n = localQMOffLineOperation.getFolderId();
              int i1 = localQMOffLineOperation.getAccountId();
              paramSQLiteDatabase.execSQL("REPLACE INTO QM_OFF_LINE_OPER ( id,accountid,mailid,oper,param,class) VALUES (?,?,?,?,?,?)", new Object[] { Long.valueOf(l1), Integer.valueOf(j), str1, Integer.valueOf(k), str2, Integer.valueOf(m) });
              if (localQMOffLineOperation.getCategory() == 1) {
                paramSQLiteDatabase.execSQL("INSERT OR IGNORE INTO QM_OFF_LINE_OPER_INFO ( mailid,id,svrkey,folderid,accountid) VALUES (?,?,?,?,?)", new Object[] { str3, Long.valueOf(l1), str4, Integer.valueOf(n), Integer.valueOf(i1) });
              }
            }
            else
            {
              l1 = QMOffLineOperation.generateAccountSettingId(localQMOffLineOperation.getAccountId(), localQMOffLineOperation.getType());
              continue;
            }
          }
          else
          {
            if (localQMOffLineOperation.getCategory() == 3)
            {
              l1 = QMOffLineOperation.generateUMASettingId(localQMOffLineOperation.getType());
              continue;
            }
            l1 = QMOffLineOperation.generateMailOperId(localQMOffLineOperation.getAccountId(), localQMOffLineOperation.getFolderId(), localQMOffLineOperation.getMailid(), localQMOffLineOperation.getType());
            continue;
          }
        }
        else
        {
          paramSQLiteDatabase.setTransactionSuccessful();
          return;
        }
      }
      catch (Exception paramList)
      {
        QMLog.log(6, this.TAG, "insertOperation fail : " + paramList.toString());
        return;
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
      }
      i += 1;
    }
  }
  
  public List<QMOffLineOperation> readDelSpamOpers(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT OPER.*, INFO.* FROM QM_OFF_LINE_OPER AS OPER , QM_OFF_LINE_OPER_INFO AS INFO WHERE OPER.mailid = INFO.mailid AND OPER.oper =2 AND (OPER.param =0 or param =1) AND class =?  ORDER BY oper ASC , accountid , folderid,param", new String[] { "1" });
    ArrayList localArrayList = new ArrayList();
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        do
        {
          localArrayList.add(fillOper(paramSQLiteDatabase, false));
        } while (paramSQLiteDatabase.moveToNext());
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  public List<QMOffLineOperation> readMailOper(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT OPER.*, INFO.* FROM QM_OFF_LINE_OPER AS OPER , QM_OFF_LINE_OPER_INFO AS INFO WHERE OPER.mailid = INFO.mailid AND param !=0 AND param != 1 AND class =?  ORDER BY oper ASC , accountid , folderid,param", new String[] { "1" });
    ArrayList localArrayList = new ArrayList();
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        do
        {
          localArrayList.add(fillOper(paramSQLiteDatabase, false));
        } while (paramSQLiteDatabase.moveToNext());
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  public List<QMOffLineOperation> readSettingOpers(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_OFF_LINE_OPER WHERE class =?  ORDER BY accountid , oper", new String[] { String.valueOf(2) });
    ArrayList localArrayList = new ArrayList();
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        do
        {
          localArrayList.add(fillOper(paramSQLiteDatabase, true));
        } while (paramSQLiteDatabase.moveToNext());
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  public List<QMOffLineOperation> readUMASettingOpers(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_OFF_LINE_OPER WHERE class =?  ORDER BY accountid , oper", new String[] { String.valueOf(3) });
    ArrayList localArrayList = new ArrayList();
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        do
        {
          localArrayList.add(fillOper(paramSQLiteDatabase, true));
        } while (paramSQLiteDatabase.moveToNext());
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMOffLineSQLite
 * JD-Core Version:    0.7.0.1
 */