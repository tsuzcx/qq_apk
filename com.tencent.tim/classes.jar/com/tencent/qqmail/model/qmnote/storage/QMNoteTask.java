package com.tencent.qqmail.model.qmnote.storage;

import android.database.Cursor;
import androidx.annotation.Nullable;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.QQMailAccount;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class QMNoteTask
{
  public static final int MOVE = 6;
  public static final String NOTE_TASK_ID = "taskId";
  public static final String NOTE_TASK_NOTEID = "noteId";
  public static final String NOTE_TASK_OPCODE = "opCode";
  public static final String NOTE_TASK_OPPARAM = "opParam";
  public static final int STAR = 5;
  private static QMNoteTask _instance = null;
  private QMNoteBaseSqlite conn = null;
  public QQMailAccount mDefaultFtnAccount = null;
  private SQLiteDatabase mRead = null;
  private SQLiteDatabase mWrite = null;
  
  private QMNoteTask(QQMailAccount paramQQMailAccount)
  {
    this.mDefaultFtnAccount = paramQQMailAccount;
    this.conn = new QMNoteBaseSqlite(QMApplicationContext.sharedInstance(), paramQQMailAccount.getUin());
    this.mWrite = this.conn.getWritableDatabase();
    this.mRead = this.conn.getReadableDatabase();
    if ((this.mWrite == null) || (this.mRead == null)) {
      throw new RuntimeException("db init error");
    }
  }
  
  public static String getString(Cursor paramCursor, String paramString)
  {
    return paramCursor.getString(paramCursor.getColumnIndex(paramString));
  }
  
  public static HashMap<String, String> mapGeneratorHelper(Cursor paramCursor, String[] paramArrayOfString)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      localHashMap.put(str, getString(paramCursor, str));
      i += 1;
    }
    return localHashMap;
  }
  
  private void setExpired() {}
  
  @Nullable
  public static QMNoteTask sharedInstance()
  {
    QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
    if (_instance == null)
    {
      if (localQQMailAccount != null) {
        _instance = new QMNoteTask(localQQMailAccount);
      }
      return _instance;
    }
    if (localQQMailAccount == null) {
      return null;
    }
    if (StringUtils.equals(localQQMailAccount.getUin(), _instance.mDefaultFtnAccount.getUin())) {
      return _instance;
    }
    _instance.setExpired();
    _instance = new QMNoteTask(localQQMailAccount);
    return _instance;
  }
  
  /* Error */
  public boolean addTask(String paramString1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: getfield 46	com/tencent/qqmail/model/qmnote/storage/QMNoteTask:mRead	Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   7: ldc 137
    //   9: iconst_2
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: ldc 11
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: ldc 139
    //   22: aastore
    //   23: invokestatic 145	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   26: iconst_2
    //   27: anewarray 141	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: aload_1
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: new 147	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   43: ldc 150
    //   45: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload_2
    //   49: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: aastore
    //   56: invokevirtual 166	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   59: astore 8
    //   61: aload 8
    //   63: invokeinterface 170 1 0
    //   68: ifeq +12 -> 80
    //   71: aload 8
    //   73: ldc 11
    //   75: invokestatic 97	com/tencent/qqmail/model/qmnote/storage/QMNoteTask:getString	(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
    //   78: astore 7
    //   80: new 172	android/content/ContentValues
    //   83: dup
    //   84: invokespecial 173	android/content/ContentValues:<init>	()V
    //   87: astore 9
    //   89: aload 9
    //   91: ldc 11
    //   93: aload 7
    //   95: invokevirtual 176	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload 9
    //   100: ldc 14
    //   102: aload_1
    //   103: invokevirtual 176	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: aload 9
    //   108: ldc 17
    //   110: iload_2
    //   111: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   114: invokevirtual 185	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   117: aload 9
    //   119: ldc 20
    //   121: aload_3
    //   122: invokevirtual 176	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload_0
    //   126: getfield 44	com/tencent/qqmail/model/qmnote/storage/QMNoteTask:mWrite	Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   129: ldc 139
    //   131: aconst_null
    //   132: aload 9
    //   134: invokevirtual 189	com/tencent/moai/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   137: lstore 4
    //   139: lload 4
    //   141: lconst_0
    //   142: lcmp
    //   143: ifle +21 -> 164
    //   146: iconst_1
    //   147: istore 6
    //   149: aload 8
    //   151: ifnull +10 -> 161
    //   154: aload 8
    //   156: invokeinterface 192 1 0
    //   161: iload 6
    //   163: ireturn
    //   164: iconst_0
    //   165: istore 6
    //   167: goto -18 -> 149
    //   170: astore_1
    //   171: aload 8
    //   173: ifnull +10 -> 183
    //   176: aload 8
    //   178: invokeinterface 192 1 0
    //   183: aload_1
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	QMNoteTask
    //   0	185	1	paramString1	String
    //   0	185	2	paramInt	int
    //   0	185	3	paramString2	String
    //   137	3	4	l	long
    //   147	19	6	bool	boolean
    //   1	93	7	str	String
    //   59	118	8	localCursor	Cursor
    //   87	46	9	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   125	139	170	finally
  }
  
  public boolean addTasks(List<String> paramList, int paramInt, String paramString)
  {
    paramList = paramList.iterator();
    boolean bool = true;
    if (paramList.hasNext())
    {
      if ((addTask((String)paramList.next(), paramInt, paramString)) && (bool)) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    return bool;
  }
  
  public List<HashMap<String, String>> getAllTaskList()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.mRead.rawQuery("select * from QMNoteTask", new String[0]);
    if (localCursor != null) {
      try
      {
        if (localCursor.moveToNext()) {
          localArrayList.add(mapGeneratorHelper(localCursor, new String[] { "taskId", "noteId", "opCode", "opParam" }));
        }
        return localList;
      }
      finally
      {
        localCursor.close();
      }
    }
  }
  
  public boolean removeTaskById(String paramString)
  {
    return this.mWrite.delete("QMNoteTask", String.format(" %s  = ? ", new Object[] { "taskId" }), new String[] { paramString }) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmnote.storage.QMNoteTask
 * JD-Core Version:    0.7.0.1
 */