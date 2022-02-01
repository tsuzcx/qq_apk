package com.tencent.qqmail.model.task;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteDatabase.CursorFactory;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.QMBaseSQLiteOpenHelper;
import com.tencent.qqmail.model.mail.QMMailDBUtils;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.ObjectSerializable;
import com.tencent.qqmail.model.sendmail.SendMailTaskAttachInfo;
import com.tencent.qqmail.model.sendmail.SendMailTaskFtnInfo;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.RxUtil;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;

public class QMTaskSQLiteHelper
  extends QMBaseSQLiteOpenHelper
{
  protected static final String FIELD_RTA_FILED_ID = "fileId";
  protected static final String FIELD_RTA_PATH = "path";
  protected static final String FIELD_RTA_SEND_MAIL_TASK_ID = "taskId";
  protected static final String FIELD_RTA_URL = "url";
  protected static final String FIELD_RTF_ATTACH_ID = "attachId";
  protected static final String FIELD_RTF_SEND_MAIL_TASK_ID = "taskId";
  protected static final String FIELD_RTF_UPLOAD_FID = "fid";
  protected static final String FIELD_RTF_UPLOAD_RID = "rid";
  protected static final String FIELD_TASK_AID = "accountId";
  protected static final String FIELD_TASK_CONTENT = "content";
  protected static final String FIELD_TASK_ID = "id";
  protected static final String FIELD_TASK_INFO = "info";
  protected static final String FIELD_TASK_RETRY_COUNT = "retryCount";
  protected static final String FIELD_TASK_STATE = "state";
  protected static final String FIELD_TASK_TYPE = "type";
  protected static final String FIELD_TASK_UPDATE_TIME = "updateTime";
  protected static final String FIELD_TASK_VERIFYKEY = "verifyKey";
  protected static final String FILENAME = "QMTaskDB";
  private static final String ORDER_BY_UTC = " ORDER BY updateTime DESC ";
  private static final String SELECT_TASK = "SELECT * FROM QM_TASK";
  protected static final String TABLE_REF_TASK_ATTACH = "QM_REF_TASK_ATTACH";
  protected static final String TABLE_REF_TASK_FTN = "QM_REF_TASK_FTN";
  protected static final String TABLE_TASK = "QM_TASK";
  private static final String TAG = "QMTaskSQLiteHelper";
  protected static final String TASK_ATTACH_INDEX = "TASK_ATTACH_INDEX";
  private static final String UPDATE_TASK = "UPDATE QM_TASK SET state = ?, info = ?, retryCount = ?, verifyKey = ?";
  @NonNull
  private static QMTaskSQLiteHelper _instance = new QMTaskSQLiteHelper(QMApplicationContext.sharedInstance());
  protected static final SQLiteDatabase.CursorFactory cursorFactory;
  private static final String sqlCreateRefTaskAttachTable = "CREATE TABLE IF NOT EXISTS QM_REF_TASK_ATTACH(taskId integer, path varchar, url varchar, fileId varchar) ";
  private static final String sqlCreateRefTaskFtnTable = "CREATE TABLE IF NOT EXISTS QM_REF_TASK_FTN(taskId integer, attachId integer, rid varchar, fid varchar) ";
  private static final String sqlCreateTaskFtnIndex = "CREATE UNIQUE INDEX IF NOT EXISTS TASK_ATTACH_INDEX ON QM_REF_TASK_FTN (taskId,attachId)";
  private static final String sqlCreateTaskTable = "CREATE TABLE IF NOT EXISTS QM_TASK(id integer primary key, accountId integer, type integer, state integer, updateTime integer, retryCount integer, info blob, content blob,verifyKey varchar) ";
  private static final String sqlDeleteMail = "DELETE FROM QM_TASK WHERE id IN ";
  private static final String sqlDropRefTaskAttachTable = "DROP TABLE IF EXISTS QM_REF_TASK_ATTACH";
  private static final String sqlDropRefTaskFtnTable = "DROP TABLE IF EXISTS QM_REF_TASK_FTN";
  private static final String sqlDropTaskFtnIndex = "DROP INDEX IF EXISTS TASK_ATTACH_INDEX";
  private static final String sqlDropTaskTable = "DROP TABLE IF EXISTS QM_TASK";
  private static final String sqlInsertTask = "REPLACE INTO QM_TASK (id,accountId,type,state,updateTime,retryCount,info,content,verifyKey) VALUES (?,?,?,?,?,?,?,?,?)";
  private static final String sqlInsertTaskAttach = "REPLACE INTO QM_REF_TASK_ATTACH (taskId,path,url,fileId) VALUES (?,?,?,?)";
  private static final String sqlInsertTaskFtnRid = "REPLACE INTO QM_REF_TASK_FTN (taskId,attachId,rid) VALUES (?,?,?)";
  private static final String sqlQueryTask = "SELECT * FROM QM_TASK WHERE id = ? AND type = ?";
  private static final String sqlQueryTaskAttach = "SELECT * FROM QM_REF_TASK_ATTACH WHERE taskId= ?";
  private static final String sqlQueryTaskFtn = "SELECT attachId, rid, fid FROM QM_REF_TASK_FTN WHERE taskId= ?";
  private static final String sqlQueryTaskFtnByTaskIdAndAttachId = "SELECT rid, fid FROM QM_REF_TASK_FTN WHERE taskId= ? AND attachId= ?";
  private static final String sqlQueryTaskList = "SELECT * FROM QM_TASK WHERE type = ? ORDER BY updateTime DESC ";
  private static final String sqlUpdateSendMailTask = "UPDATE QM_TASK SET state = ?, info = ?, retryCount = ?, verifyKey = ? WHERE id = ?";
  static final QMTaskSQLiteDatabaseUpgradeManager upgradeManager = new QMTaskSQLiteDatabaseUpgradeManager();
  
  static
  {
    cursorFactory = null;
  }
  
  public QMTaskSQLiteHelper(Context paramContext)
  {
    super(paramContext, "QMTaskDB", cursorFactory, upgradeManager.getVersion());
  }
  
  private void createIndex(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS TASK_ATTACH_INDEX ON QM_REF_TASK_FTN (taskId,attachId)");
  }
  
  private String getInClause(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramInt)
    {
      if (i != 0) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append("?");
      i += 1;
    }
    return "(" + localStringBuilder.toString() + ")";
  }
  
  @NonNull
  public static QMTaskSQLiteHelper sharedInstance()
  {
    return _instance;
  }
  
  /* Error */
  private boolean updateQMSendMailTask(QMSendMailTask paramQMSendMailTask)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 216	com/tencent/qqmail/model/task/QMSendMailTask:getMail	()Lcom/tencent/qqmail/model/uidomain/ComposeMailUI;
    //   4: astore 6
    //   6: aload 6
    //   8: invokestatic 222	com/tencent/qqmail/model/qmdomain/ObjectSerializable:toByte	(Ljava/lang/Object;)[B
    //   11: astore 5
    //   13: new 189	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   20: aload 6
    //   22: invokevirtual 228	com/tencent/qqmail/model/uidomain/ComposeMailUI:getInformation	()Lcom/tencent/qqmail/model/qmdomain/MailInformation;
    //   25: invokevirtual 233	com/tencent/qqmail/model/qmdomain/MailInformation:getAccountId	()I
    //   28: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: ldc 238
    //   33: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload 6
    //   38: invokevirtual 228	com/tencent/qqmail/model/uidomain/ComposeMailUI:getInformation	()Lcom/tencent/qqmail/model/qmdomain/MailInformation;
    //   41: invokevirtual 241	com/tencent/qqmail/model/qmdomain/MailInformation:getRemoteId	()Ljava/lang/String;
    //   44: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 247	com/tencent/qqmail/utilities/QMMath:hashInt	(Ljava/lang/String;)I
    //   53: pop
    //   54: aload_1
    //   55: invokevirtual 251	com/tencent/qqmail/model/task/QMSendMailTask:getTaskState	()Lcom/tencent/qqmail/model/task/QMTask$QMTaskState;
    //   58: invokevirtual 256	com/tencent/qqmail/model/task/QMTask$QMTaskState:ordinal	()I
    //   61: istore_2
    //   62: aload_1
    //   63: invokevirtual 259	com/tencent/qqmail/model/task/QMSendMailTask:getRetryCount	()I
    //   66: istore_3
    //   67: aload_1
    //   68: invokevirtual 262	com/tencent/qqmail/model/task/QMSendMailTask:getVerifyKey	()Ljava/lang/String;
    //   71: astore 6
    //   73: aload_1
    //   74: invokevirtual 265	com/tencent/qqmail/model/task/QMSendMailTask:getId	()I
    //   77: istore 4
    //   79: aload_0
    //   80: invokevirtual 269	com/tencent/qqmail/model/task/QMTaskSQLiteHelper:getWritableDatabase	()Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   83: astore_1
    //   84: aload_1
    //   85: ifnonnull +5 -> 90
    //   88: iconst_0
    //   89: ireturn
    //   90: aload_1
    //   91: ldc 139
    //   93: iconst_5
    //   94: anewarray 271	java/lang/Object
    //   97: dup
    //   98: iconst_0
    //   99: iload_2
    //   100: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: aastore
    //   104: dup
    //   105: iconst_1
    //   106: aload 5
    //   108: aastore
    //   109: dup
    //   110: iconst_2
    //   111: iload_3
    //   112: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   115: aastore
    //   116: dup
    //   117: iconst_3
    //   118: aload 6
    //   120: aastore
    //   121: dup
    //   122: iconst_4
    //   123: iload 4
    //   125: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   128: aastore
    //   129: invokevirtual 280	com/tencent/moai/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: iconst_1
    //   133: ireturn
    //   134: astore_1
    //   135: aload_1
    //   136: athrow
    //   137: astore_1
    //   138: iconst_0
    //   139: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	QMTaskSQLiteHelper
    //   0	140	1	paramQMSendMailTask	QMSendMailTask
    //   61	39	2	i	int
    //   66	46	3	j	int
    //   77	47	4	k	int
    //   11	96	5	arrayOfByte	byte[]
    //   4	115	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   90	132	134	finally
    //   90	132	137	java/lang/Exception
  }
  
  public void createTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_TASK(id integer primary key, accountId integer, type integer, state integer, updateTime integer, retryCount integer, info blob, content blob,verifyKey varchar) ");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_REF_TASK_ATTACH(taskId integer, path varchar, url varchar, fileId varchar) ");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_REF_TASK_FTN(taskId integer, attachId integer, rid varchar, fid varchar) ");
  }
  
  /* Error */
  public boolean deleteTasks(ArrayList<java.lang.Integer> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 288	java/util/ArrayList:size	()I
    //   5: invokespecial 290	com/tencent/qqmail/model/task/QMTaskSQLiteHelper:getInClause	(I)Ljava/lang/String;
    //   8: astore_2
    //   9: aload_1
    //   10: invokevirtual 294	java/util/ArrayList:toArray	()[Ljava/lang/Object;
    //   13: astore_1
    //   14: aload_0
    //   15: invokevirtual 269	com/tencent/qqmail/model/task/QMTaskSQLiteHelper:getWritableDatabase	()Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   18: astore_3
    //   19: aload_3
    //   20: ifnonnull +5 -> 25
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_3
    //   26: new 189	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   33: ldc 100
    //   35: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_2
    //   39: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: aload_1
    //   46: invokevirtual 280	com/tencent/moai/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   49: iconst_1
    //   50: ireturn
    //   51: astore_1
    //   52: aload_1
    //   53: athrow
    //   54: astore_1
    //   55: iconst_0
    //   56: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	QMTaskSQLiteHelper
    //   0	57	1	paramArrayList	ArrayList<java.lang.Integer>
    //   8	31	2	str	String
    //   18	8	3	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   25	49	51	finally
    //   25	49	54	java/lang/Exception
  }
  
  /* Error */
  public boolean deleteTasksAttachByTaskId(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 269	com/tencent/qqmail/model/task/QMTaskSQLiteHelper:getWritableDatabase	()Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnonnull +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: aload_2
    //   12: ldc 66
    //   14: ldc_w 300
    //   17: iconst_1
    //   18: anewarray 302	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: iload_1
    //   24: invokestatic 304	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   27: aastore
    //   28: invokevirtual 308	com/tencent/moai/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   31: pop
    //   32: iconst_1
    //   33: ireturn
    //   34: astore_2
    //   35: aload_2
    //   36: athrow
    //   37: astore_2
    //   38: iconst_0
    //   39: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	QMTaskSQLiteHelper
    //   0	40	1	paramInt	int
    //   4	8	2	localSQLiteDatabase	SQLiteDatabase
    //   34	2	2	localObject	Object
    //   37	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   11	32	34	finally
    //   11	32	37	java/lang/Exception
  }
  
  /* Error */
  public boolean deleteTasksFtnByTaskId(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 269	com/tencent/qqmail/model/task/QMTaskSQLiteHelper:getWritableDatabase	()Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnonnull +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: aload_2
    //   12: ldc 69
    //   14: ldc_w 300
    //   17: iconst_1
    //   18: anewarray 302	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: iload_1
    //   24: invokestatic 304	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   27: aastore
    //   28: invokevirtual 308	com/tencent/moai/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   31: pop
    //   32: iconst_1
    //   33: ireturn
    //   34: astore_2
    //   35: aload_2
    //   36: athrow
    //   37: astore_2
    //   38: iconst_0
    //   39: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	QMTaskSQLiteHelper
    //   0	40	1	paramInt	int
    //   4	8	2	localSQLiteDatabase	SQLiteDatabase
    //   34	2	2	localObject	Object
    //   37	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   11	32	34	finally
    //   11	32	37	java/lang/Exception
  }
  
  public void dropIndex(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS TASK_ATTACH_INDEX");
  }
  
  public void dropTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_TASK");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_REF_TASK_ATTACH");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_REF_TASK_FTN");
  }
  
  public QMTask generateQMTask(Cursor paramCursor, int paramInt)
  {
    QMSendMailTask localQMSendMailTask;
    if (paramInt == 1)
    {
      localQMSendMailTask = new QMSendMailTask();
      paramInt = paramCursor.getInt(paramCursor.getColumnIndex("id"));
      int i = paramCursor.getInt(paramCursor.getColumnIndex("accountId"));
      int j = paramCursor.getInt(paramCursor.getColumnIndex("state"));
      int k = paramCursor.getInt(paramCursor.getColumnIndex("retryCount"));
      byte[] arrayOfByte = paramCursor.getBlob(paramCursor.getColumnIndex("info"));
      Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("content"));
      paramCursor = paramCursor.getString(paramCursor.getColumnIndex("verifyKey"));
      localQMSendMailTask.setId(paramInt);
      localQMSendMailTask.setAccountId(i);
      localQMSendMailTask.setRetryCount(k);
      localQMSendMailTask.setVerifyKey(paramCursor);
      paramCursor = (ComposeMailUI)ObjectSerializable.fromByte(arrayOfByte);
      if ((paramCursor == null) || (paramCursor.getInformation() == null)) {
        return null;
      }
      localObject = QMMailDBUtils.getMailContent(paramCursor.getInformation().getId() + "", (byte[])localObject);
      if ((localObject != null) && (paramCursor != null)) {
        paramCursor.setContent((MailContent)localObject);
      }
      paramCursor.getInformation().setAccountId(i);
      ((QMSendMailTask)localQMSendMailTask).setMail(paramCursor);
      localQMSendMailTask.setTaskState(QMTask.QMTaskState.values()[j]);
    }
    for (paramCursor = localQMSendMailTask;; paramCursor = null) {
      return paramCursor;
    }
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    return super.getReadableDatabase();
  }
  
  public List<SendMailTaskAttachInfo> getSendMailTaskAttachInfo(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == -1) {}
    Object localObject2;
    do
    {
      do
      {
        return localArrayList;
        localObject2 = getReadableDatabase();
      } while (localObject2 == null);
      localObject2 = ((SQLiteDatabase)localObject2).rawQuery("SELECT * FROM QM_REF_TASK_ATTACH WHERE taskId= ?", new String[] { paramInt + "" });
    } while (localObject2 == null);
    try
    {
      if (((Cursor)localObject2).moveToFirst())
      {
        boolean bool;
        do
        {
          localArrayList.add(new SendMailTaskAttachInfo(paramInt, ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("path")), ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("url")), ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("fileId"))));
          bool = ((Cursor)localObject2).moveToNext();
        } while (bool);
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      return localArrayList;
    }
    finally
    {
      ((Cursor)localObject2).close();
    }
  }
  
  /* Error */
  public SendMailTaskFtnInfo getSendMailTaskFtnInfos(int paramInt, long paramLong)
  {
    // Byte code:
    //   0: iload_1
    //   1: iconst_m1
    //   2: if_icmpne +5 -> 7
    //   5: aconst_null
    //   6: areturn
    //   7: aload_0
    //   8: invokevirtual 387	com/tencent/qqmail/model/task/QMTaskSQLiteHelper:getReadableDatabase	()Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   11: astore 4
    //   13: aload 4
    //   15: ifnull -10 -> 5
    //   18: aload 4
    //   20: ldc 133
    //   22: iconst_2
    //   23: anewarray 302	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: new 189	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   35: iload_1
    //   36: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: ldc_w 357
    //   42: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: new 189	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   58: lload_2
    //   59: invokevirtual 355	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   62: ldc_w 357
    //   65: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: aastore
    //   72: invokevirtual 391	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   75: astore 5
    //   77: aload 5
    //   79: ifnull -74 -> 5
    //   82: aload 5
    //   84: invokeinterface 395 1 0
    //   89: ifeq +78 -> 167
    //   92: new 417	com/tencent/qqmail/model/sendmail/SendMailTaskFtnInfo
    //   95: dup
    //   96: lload_2
    //   97: aload 5
    //   99: aload 5
    //   101: ldc 27
    //   103: invokeinterface 319 2 0
    //   108: invokeinterface 330 2 0
    //   113: aload 5
    //   115: aload 5
    //   117: ldc 24
    //   119: invokeinterface 319 2 0
    //   124: invokeinterface 330 2 0
    //   129: invokespecial 420	com/tencent/qqmail/model/sendmail/SendMailTaskFtnInfo:<init>	(JLjava/lang/String;Ljava/lang/String;)V
    //   132: astore 4
    //   134: aload 5
    //   136: invokeinterface 412 1 0
    //   141: aload 4
    //   143: areturn
    //   144: astore 4
    //   146: aload 5
    //   148: invokeinterface 412 1 0
    //   153: aconst_null
    //   154: areturn
    //   155: astore 4
    //   157: aload 5
    //   159: invokeinterface 412 1 0
    //   164: aload 4
    //   166: athrow
    //   167: aconst_null
    //   168: astore 4
    //   170: goto -36 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	QMTaskSQLiteHelper
    //   0	173	1	paramInt	int
    //   0	173	2	paramLong	long
    //   11	131	4	localObject1	Object
    //   144	1	4	localException	Exception
    //   155	10	4	localObject2	Object
    //   168	1	4	localObject3	Object
    //   75	83	5	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   82	134	144	java/lang/Exception
    //   82	134	155	finally
  }
  
  public List<SendMailTaskFtnInfo> getSendMailTaskFtnInfos(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == -1) {}
    Object localObject2;
    do
    {
      do
      {
        return localArrayList;
        localObject2 = getReadableDatabase();
      } while (localObject2 == null);
      localObject2 = ((SQLiteDatabase)localObject2).rawQuery("SELECT attachId, rid, fid FROM QM_REF_TASK_FTN WHERE taskId= ?", new String[] { paramInt + "" });
    } while (localObject2 == null);
    try
    {
      if (((Cursor)localObject2).moveToFirst())
      {
        boolean bool;
        do
        {
          localArrayList.add(new SendMailTaskFtnInfo(((Cursor)localObject2).getLong(((Cursor)localObject2).getColumnIndex("attachId")), ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("rid")), ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("fid"))));
          bool = ((Cursor)localObject2).moveToNext();
        } while (bool);
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      return localArrayList;
    }
    finally
    {
      ((Cursor)localObject2).close();
    }
  }
  
  public QMTask getTask(int paramInt1, int paramInt2)
  {
    QMTask localQMTask = null;
    Object localObject = getReadableDatabase();
    if (localObject == null) {}
    do
    {
      return null;
      localObject = ((SQLiteDatabase)localObject).rawQuery("SELECT * FROM QM_TASK WHERE id = ? AND type = ?", new String[] { paramInt2 + "", paramInt1 + "" });
    } while (localObject == null);
    if (((Cursor)localObject).moveToFirst()) {
      localQMTask = generateQMTask((Cursor)localObject, paramInt1);
    }
    ((Cursor)localObject).close();
    return localQMTask;
  }
  
  public ArrayList<QMTask> getTaskList(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = getReadableDatabase();
    if (localObject == null) {}
    do
    {
      return localArrayList;
      localObject = ((SQLiteDatabase)localObject).rawQuery("SELECT * FROM QM_TASK WHERE type = ? ORDER BY updateTime DESC ", new String[] { paramInt + "" });
    } while (localObject == null);
    if (((Cursor)localObject).moveToFirst()) {
      do
      {
        QMTask localQMTask = generateQMTask((Cursor)localObject, paramInt);
        if (localQMTask != null) {
          localArrayList.add(localQMTask);
        }
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    return localArrayList;
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    return super.getWritableDatabase();
  }
  
  /* Error */
  public boolean insertTaskAttach(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 269	com/tencent/qqmail/model/task/QMTaskSQLiteHelper:getWritableDatabase	()Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   4: astore 5
    //   6: aload 5
    //   8: ifnonnull +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload 5
    //   15: ldc 118
    //   17: iconst_4
    //   18: anewarray 271	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: iload_1
    //   24: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: aload_2
    //   31: aastore
    //   32: dup
    //   33: iconst_2
    //   34: aload_3
    //   35: aastore
    //   36: dup
    //   37: iconst_3
    //   38: aload 4
    //   40: aastore
    //   41: invokevirtual 280	com/tencent/moai/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   44: iconst_1
    //   45: ireturn
    //   46: astore_2
    //   47: aload_2
    //   48: athrow
    //   49: astore_2
    //   50: iconst_0
    //   51: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	QMTaskSQLiteHelper
    //   0	52	1	paramInt	int
    //   0	52	2	paramString1	String
    //   0	52	3	paramString2	String
    //   0	52	4	paramString3	String
    //   4	10	5	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   13	44	46	finally
    //   13	44	49	java/lang/Exception
  }
  
  /* Error */
  public boolean insertTaskFtnRid(int paramInt, long paramLong, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 269	com/tencent/qqmail/model/task/QMTaskSQLiteHelper:getWritableDatabase	()Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   4: astore 5
    //   6: aload 5
    //   8: ifnonnull +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload 5
    //   15: ldc 121
    //   17: iconst_3
    //   18: anewarray 271	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: iload_1
    //   24: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: lload_2
    //   31: invokestatic 443	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   34: aastore
    //   35: dup
    //   36: iconst_2
    //   37: aload 4
    //   39: aastore
    //   40: invokevirtual 280	com/tencent/moai/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: iconst_1
    //   44: ireturn
    //   45: astore 4
    //   47: aload 4
    //   49: athrow
    //   50: astore 4
    //   52: iconst_0
    //   53: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	QMTaskSQLiteHelper
    //   0	54	1	paramInt	int
    //   0	54	2	paramLong	long
    //   0	54	4	paramString	String
    //   4	10	5	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   13	43	45	finally
    //   13	43	50	java/lang/Exception
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    createTable(paramSQLiteDatabase);
    createIndex(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    QMLog.log(4, "QMTaskSQLiteHelper", "Try Upgrade: from " + paramInt1 + " to " + paramInt2 + ", minVer:" + upgradeManager.getMinSupportVersion());
    if (paramInt1 < upgradeManager.getMinSupportVersion())
    {
      dropTable(paramSQLiteDatabase);
      dropIndex(paramSQLiteDatabase);
      createTable(paramSQLiteDatabase);
      return;
    }
    if (upgradeManager.upgrade(this, paramSQLiteDatabase, paramInt1))
    {
      QMLog.log(4, "QMTaskSQLiteHelper", "Upgraded from " + paramInt1 + " to " + paramInt2);
      return;
    }
    QMLog.log(4, "QMTaskSQLiteHelper", "No need upgrade from " + paramInt1 + " to " + paramInt2);
  }
  
  /* Error */
  public boolean saveQMSendMailTask(QMSendMailTask paramQMSendMailTask)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 216	com/tencent/qqmail/model/task/QMSendMailTask:getMail	()Lcom/tencent/qqmail/model/uidomain/ComposeMailUI;
    //   4: astore 9
    //   6: aload 9
    //   8: invokevirtual 228	com/tencent/qqmail/model/uidomain/ComposeMailUI:getInformation	()Lcom/tencent/qqmail/model/qmdomain/MailInformation;
    //   11: invokevirtual 352	com/tencent/qqmail/model/qmdomain/MailInformation:getId	()J
    //   14: aload 9
    //   16: invokevirtual 482	com/tencent/qqmail/model/uidomain/ComposeMailUI:getContent	()Lcom/tencent/qqmail/model/qmdomain/MailContent;
    //   19: invokestatic 486	com/tencent/qqmail/model/mail/QMMailDBUtils:getContentBytes	(JLcom/tencent/qqmail/model/qmdomain/MailContent;)[B
    //   22: astore 8
    //   24: aload 9
    //   26: invokestatic 222	com/tencent/qqmail/model/qmdomain/ObjectSerializable:toByte	(Ljava/lang/Object;)[B
    //   29: astore 9
    //   31: aload_1
    //   32: invokevirtual 265	com/tencent/qqmail/model/task/QMSendMailTask:getId	()I
    //   35: istore_2
    //   36: aload_1
    //   37: invokevirtual 487	com/tencent/qqmail/model/task/QMSendMailTask:getAccountId	()I
    //   40: istore_3
    //   41: aload_1
    //   42: invokevirtual 251	com/tencent/qqmail/model/task/QMSendMailTask:getTaskState	()Lcom/tencent/qqmail/model/task/QMTask$QMTaskState;
    //   45: invokevirtual 256	com/tencent/qqmail/model/task/QMTask$QMTaskState:ordinal	()I
    //   48: istore 4
    //   50: invokestatic 492	java/lang/System:currentTimeMillis	()J
    //   53: lstore 6
    //   55: aload_1
    //   56: invokevirtual 259	com/tencent/qqmail/model/task/QMSendMailTask:getRetryCount	()I
    //   59: istore 5
    //   61: aload_1
    //   62: invokevirtual 262	com/tencent/qqmail/model/task/QMSendMailTask:getVerifyKey	()Ljava/lang/String;
    //   65: astore_1
    //   66: aload_0
    //   67: invokevirtual 269	com/tencent/qqmail/model/task/QMTaskSQLiteHelper:getWritableDatabase	()Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   70: astore 10
    //   72: aload 10
    //   74: ifnonnull +5 -> 79
    //   77: iconst_0
    //   78: ireturn
    //   79: aload 10
    //   81: ldc 115
    //   83: bipush 9
    //   85: anewarray 271	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: iload_2
    //   91: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: iload_3
    //   98: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   101: aastore
    //   102: dup
    //   103: iconst_2
    //   104: iconst_1
    //   105: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   108: aastore
    //   109: dup
    //   110: iconst_3
    //   111: iload 4
    //   113: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   116: aastore
    //   117: dup
    //   118: iconst_4
    //   119: lload 6
    //   121: invokestatic 443	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   124: aastore
    //   125: dup
    //   126: iconst_5
    //   127: iload 5
    //   129: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   132: aastore
    //   133: dup
    //   134: bipush 6
    //   136: aload 9
    //   138: aastore
    //   139: dup
    //   140: bipush 7
    //   142: aload 8
    //   144: aastore
    //   145: dup
    //   146: bipush 8
    //   148: aload_1
    //   149: aastore
    //   150: invokevirtual 280	com/tencent/moai/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: iconst_1
    //   154: ireturn
    //   155: astore_1
    //   156: aload_1
    //   157: athrow
    //   158: astore_1
    //   159: iconst_0
    //   160: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	QMTaskSQLiteHelper
    //   0	161	1	paramQMSendMailTask	QMSendMailTask
    //   35	56	2	i	int
    //   40	58	3	j	int
    //   48	64	4	k	int
    //   59	69	5	m	int
    //   53	67	6	l	long
    //   22	121	8	arrayOfByte	byte[]
    //   4	133	9	localObject	Object
    //   70	10	10	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   79	153	155	finally
    //   79	153	158	java/lang/Exception
  }
  
  public int updateQMSendMailTask(int paramInt, long paramLong, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("fid", paramString);
    return getWritableDatabase().update("QM_REF_TASK_FTN", localContentValues, "taskId=? AND attachId=?", new String[] { paramInt + "", paramLong + "" });
  }
  
  public Observable<Boolean> updateQMSendMailTaskInObservable(QMSendMailTask paramQMSendMailTask)
  {
    return RxUtil.runInBackgroundThenBackToCallerThread(new QMTaskSQLiteHelper.1(this, paramQMSendMailTask));
  }
  
  public void upgradeTableFor4(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_TASK ADD COLUMN verifyKey VARCHAR");
  }
  
  public void upgradeTableFor5230(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_REF_TASK_ATTACH(taskId integer, path varchar, url varchar, fileId varchar) ");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_REF_TASK_FTN(taskId integer, attachId integer, rid varchar, fid varchar) ");
  }
  
  public void upgradeTableFor5310(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS TASK_ATTACH_INDEX ON QM_REF_TASK_FTN (taskId,attachId)");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMTaskSQLiteHelper
 * JD-Core Version:    0.7.0.1
 */