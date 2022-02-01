import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;

public class sxd
  implements sxe
{
  private SQLiteDatabase jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
  private sxf jdField_a_of_type_Sxf;
  private SQLiteDatabase d;
  
  public sxd(Context paramContext)
  {
    this.jdField_a_of_type_Sxf = new sxf(paramContext, "config_db", null, 15);
  }
  
  public boolean Nw()
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen()) {
        break label53;
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_Sxf.getWritableDatabase();
      if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen()) {}
      }
      else
      {
        bool1 = false;
      }
      label53:
      return bool1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZConfigSqliteManager", 2, "provider获取数据库出错", localException);
        }
      }
    }
  }
  
  public boolean Nx()
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.d != null)
    {
      bool1 = bool2;
      if (this.d.isOpen()) {
        break label53;
      }
    }
    try
    {
      this.d = this.jdField_a_of_type_Sxf.getReadableDatabase();
      if (this.d != null)
      {
        bool1 = bool2;
        if (this.d.isOpen()) {}
      }
      else
      {
        bool1 = false;
      }
      label53:
      return bool1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZConfigSqliteManager", 2, "provider获取数据库出错", localException);
        }
      }
    }
  }
  
  /* Error */
  public int a(Uri paramUri, String paramString, ContentValues[] paramArrayOfContentValues)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: invokevirtual 64	sxd:Nw	()Z
    //   7: ifeq +123 -> 130
    //   10: aload_3
    //   11: arraylength
    //   12: istore 4
    //   14: invokestatic 70	java/lang/System:currentTimeMillis	()J
    //   17: lstore 7
    //   19: aload_0
    //   20: getfield 31	sxd:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   23: invokevirtual 73	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   26: aload_3
    //   27: arraylength
    //   28: istore 6
    //   30: iconst_0
    //   31: istore 5
    //   33: iload 5
    //   35: iload 6
    //   37: if_icmpge +111 -> 148
    //   40: aload_3
    //   41: iload 5
    //   43: aaload
    //   44: astore 11
    //   46: aload_0
    //   47: getfield 31	sxd:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   50: aload_2
    //   51: ldc 75
    //   53: aload 11
    //   55: invokevirtual 79	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   58: lconst_0
    //   59: lcmp
    //   60: ifgt +73 -> 133
    //   63: new 62	android/database/SQLException
    //   66: dup
    //   67: new 81	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   74: ldc 84
    //   76: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_1
    //   80: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokespecial 98	android/database/SQLException:<init>	(Ljava/lang/String;)V
    //   89: athrow
    //   90: astore_1
    //   91: ldc 47
    //   93: iconst_1
    //   94: new 81	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   101: ldc 100
    //   103: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_1
    //   107: invokevirtual 103	android/database/SQLException:getMessage	()Ljava/lang/String;
    //   110: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload_0
    //   120: getfield 31	sxd:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   123: invokevirtual 109	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   126: aload_0
    //   127: invokevirtual 112	sxd:bBM	()V
    //   130: iload 4
    //   132: ireturn
    //   133: iload 5
    //   135: iconst_1
    //   136: iadd
    //   137: istore 5
    //   139: iload 4
    //   141: iconst_1
    //   142: iadd
    //   143: istore 4
    //   145: goto -112 -> 33
    //   148: aload_0
    //   149: getfield 31	sxd:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   152: invokevirtual 115	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   155: invokestatic 70	java/lang/System:currentTimeMillis	()J
    //   158: lstore 9
    //   160: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   163: ifeq +51 -> 214
    //   166: ldc 47
    //   168: iconst_2
    //   169: new 81	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   176: ldc 117
    //   178: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_1
    //   182: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   185: ldc 119
    //   187: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: lload 9
    //   192: lload 7
    //   194: lsub
    //   195: invokevirtual 122	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   198: ldc 124
    //   200: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: iload 4
    //   205: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 130	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aload_0
    //   215: getfield 31	sxd:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   218: invokevirtual 109	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   221: goto -95 -> 126
    //   224: astore_1
    //   225: aload_0
    //   226: getfield 31	sxd:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   229: invokevirtual 109	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   232: aload_1
    //   233: athrow
    //   234: astore_1
    //   235: goto -144 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	sxd
    //   0	238	1	paramUri	Uri
    //   0	238	2	paramString	String
    //   0	238	3	paramArrayOfContentValues	ContentValues[]
    //   1	203	4	i	int
    //   31	107	5	j	int
    //   28	10	6	k	int
    //   17	176	7	l1	long
    //   158	33	9	l2	long
    //   44	10	11	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   46	90	90	android/database/SQLException
    //   148	214	90	android/database/SQLException
    //   14	30	224	finally
    //   46	90	224	finally
    //   91	119	224	finally
    //   148	214	224	finally
    //   14	30	234	android/database/SQLException
  }
  
  public Cursor a(String[] paramArrayOfString)
  {
    Cursor localCursor = null;
    if (Nx())
    {
      localCursor = this.d.query("qz_cookie", paramArrayOfString, null, null, null, null, null);
      bBM();
    }
    return localCursor;
  }
  
  public Cursor a(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    Cursor localCursor = null;
    if (Nx())
    {
      localCursor = this.d.query("qz_navigator_bar", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
      bBM();
    }
    return localCursor;
  }
  
  public Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    if (Nw())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_configs", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(l, l);
      bBM();
      return paramUri;
    }
    return null;
  }
  
  public int b(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    if (Nw())
    {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_configs", paramString, paramArrayOfString);
      bBM();
    }
    return i;
  }
  
  public Cursor b(String[] paramArrayOfString)
  {
    Cursor localCursor = null;
    if (Nx())
    {
      localCursor = this.d.query("qz_check_time", paramArrayOfString, null, null, null, null, null);
      bBM();
    }
    return localCursor;
  }
  
  public Cursor b(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    Cursor localCursor = null;
    if (Nx())
    {
      localCursor = this.d.query("qz_configs", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
      bBM();
    }
    return localCursor;
  }
  
  public Uri b(Uri paramUri, ContentValues paramContentValues)
  {
    if (Nw())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_navigator_bar", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(t, l);
      bBM();
      return paramUri;
    }
    return null;
  }
  
  public void bBM() {}
  
  public int c(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    if (Nw())
    {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_isp_config", paramString, paramArrayOfString);
      bBM();
    }
    return i;
  }
  
  public Cursor c(String[] paramArrayOfString)
  {
    Cursor localCursor = null;
    if (Nx())
    {
      localCursor = this.d.query("qz_update", paramArrayOfString, null, null, null, null, null);
      bBM();
    }
    return localCursor;
  }
  
  public Cursor c(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    Cursor localCursor = null;
    if (Nx())
    {
      localCursor = this.d.query("qz_isp_config", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
      bBM();
    }
    return localCursor;
  }
  
  public Uri c(Uri paramUri, ContentValues paramContentValues)
  {
    if (Nw())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_isp_config", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(r, l);
      bBM();
      return paramUri;
    }
    return null;
  }
  
  public int d(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    if (Nw())
    {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_navigator_bar", paramString, paramArrayOfString);
      bBM();
    }
    return i;
  }
  
  public Cursor d(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    Object localObject = null;
    if (Nx())
    {
      paramArrayOfString1 = this.d.query("table_qz_unread", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
      bBM();
    }
    do
    {
      return paramArrayOfString1;
      paramArrayOfString1 = localObject;
    } while (!QLog.isColorLevel());
    QLog.e("QZConfigSqliteManager", 2, "", new SQLException("cannot openWriteSqlite"));
    return null;
  }
  
  public Uri d(Uri paramUri, ContentValues paramContentValues)
  {
    if (Nw())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_cookie", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(m, l);
      bBM();
      return paramUri;
    }
    return null;
  }
  
  public int e(String paramString, String[] paramArrayOfString)
  {
    if (Nw()) {
      return this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("table_qz_unread", paramString, paramArrayOfString);
    }
    if (QLog.isColorLevel()) {
      QLog.e("QZConfigSqliteManager", 2, "", new SQLException("cannot openWriteSqlite,failed deleteQzoneUnread"));
    }
    return 0;
  }
  
  public Uri e(Uri paramUri, ContentValues paramContentValues)
  {
    if (Nw())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_check_time", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(s, l);
      bBM();
      return paramUri;
    }
    return null;
  }
  
  public Uri f(Uri paramUri, ContentValues paramContentValues)
  {
    if (Nw())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_update", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(o, l);
      bBM();
      return paramUri;
    }
    return null;
  }
  
  public Uri g(Uri paramUri, ContentValues paramContentValues)
  {
    if (Nw())
    {
      long l = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("table_qz_unread", "", paramContentValues);
      bBM();
      if (l > 0L) {
        return ContentUris.withAppendedId(paramUri, l);
      }
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigSqliteManager", 2, "", new SQLException("failed to insert row into " + paramUri));
      }
    }
    for (;;)
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigSqliteManager", 2, "", new SQLException("cannot openWriteSqlite,failed to insert row into " + paramUri));
      }
    }
  }
  
  public int uC()
  {
    int i = 0;
    if (Nw())
    {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_cookie", null, null);
      bBM();
    }
    return i;
  }
  
  public int uD()
  {
    int i = 0;
    if (Nw())
    {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_check_time", null, null);
      bBM();
    }
    return i;
  }
  
  public int uE()
  {
    int i = 0;
    if (Nw()) {
      i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_update", null, null);
    }
    return i;
  }
  
  public int uF()
  {
    return 0 + uC() + b(null, null) + uE() + uD() + c(null, null) + d(null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     sxd
 * JD-Core Version:    0.7.0.1
 */