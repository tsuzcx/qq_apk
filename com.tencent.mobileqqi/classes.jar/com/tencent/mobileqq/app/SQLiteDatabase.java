package com.tencent.mobileqq.app;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.persistence.TableNameCache;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLiteDatabase
{
  static final String jdField_a_of_type_JavaLangString = "select sql from sqlite_master where type=? and name=?";
  public static boolean a = false;
  private static final String jdField_b_of_type_JavaLangString = "db";
  private static final boolean jdField_b_of_type_Boolean = false;
  private static final String c = "SQLiteDataBaseLog";
  final android.database.sqlite.SQLiteDatabase jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
  private TableNameCache jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache = null;
  private final Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private final Map jdField_b_of_type_JavaUtilMap;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  SQLiteDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, TableNameCache paramTableNameCache)
  {
    this.b = new HashMap();
    this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = paramSQLiteDatabase;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache = paramTableNameCache;
  }
  
  private ContentValues a(String paramString, ContentValues paramContentValues)
  {
    if ((paramContentValues == null) || (paramContentValues.size() <= 0)) {
      return paramContentValues;
    }
    ContentValues localContentValues = new ContentValues(paramContentValues);
    paramString = a(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        if (paramContentValues.containsKey(str))
        {
          Object localObject = paramContentValues.get(str);
          if ((localObject instanceof String))
          {
            localObject = (String)paramContentValues.get(str);
            if ((localObject != null) && (((String)localObject).length() > 0)) {
              localContentValues.put(str, a(localObject));
            }
          }
          else if ((localObject instanceof byte[]))
          {
            localContentValues.put(str, a((byte[])localObject));
          }
        }
      }
    }
    return localContentValues;
  }
  
  /* Error */
  private Cursor a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    // Byte code:
    //   0: invokestatic 105	java/lang/System:currentTimeMillis	()J
    //   3: lstore 10
    //   5: aload_0
    //   6: aload_2
    //   7: aload 4
    //   9: aload 5
    //   11: invokespecial 108	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 39	com/tencent/mobileqq/app/SQLiteDatabase:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   18: iconst_0
    //   19: aload_2
    //   20: aload_3
    //   21: aload 4
    //   23: aload 5
    //   25: aload 6
    //   27: aload 7
    //   29: aload 8
    //   31: aload 9
    //   33: invokevirtual 113	android/database/sqlite/SQLiteDatabase:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore 14
    //   38: invokestatic 105	java/lang/System:currentTimeMillis	()J
    //   41: lstore 12
    //   43: aload 14
    //   45: astore 15
    //   47: getstatic 23	com/tencent/mobileqq/app/SQLiteDatabase:jdField_a_of_type_Boolean	Z
    //   50: ifeq +95 -> 145
    //   53: ldc 114
    //   55: aload_2
    //   56: new 116	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   63: aload_3
    //   64: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   67: ldc 123
    //   69: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload 4
    //   74: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc 123
    //   79: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload 5
    //   84: invokestatic 129	com/tencent/mobileqq/app/SQLiteDatabase:a	([Ljava/lang/Object;)Ljava/lang/String;
    //   87: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc 123
    //   92: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload 6
    //   97: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc 123
    //   102: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload 7
    //   107: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc 123
    //   112: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 8
    //   117: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 123
    //   122: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 9
    //   127: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: lload 12
    //   135: lload 10
    //   137: lsub
    //   138: invokestatic 136	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    //   141: aload 14
    //   143: astore 15
    //   145: invokestatic 141	com/tencent/util/MsgAutoMonitorUtil:a	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   148: invokestatic 105	java/lang/System:currentTimeMillis	()J
    //   151: lload 10
    //   153: lsub
    //   154: invokevirtual 144	com/tencent/util/MsgAutoMonitorUtil:a	(J)V
    //   157: aload 15
    //   159: areturn
    //   160: astore_2
    //   161: aconst_null
    //   162: astore 14
    //   164: aload_0
    //   165: aload_2
    //   166: invokespecial 147	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/Throwable;)V
    //   169: aload 14
    //   171: astore 15
    //   173: goto -28 -> 145
    //   176: astore_2
    //   177: aload_2
    //   178: athrow
    //   179: astore_2
    //   180: goto -16 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	SQLiteDatabase
    //   0	183	1	paramBoolean	boolean
    //   0	183	2	paramString1	String
    //   0	183	3	paramArrayOfString1	String[]
    //   0	183	4	paramString2	String
    //   0	183	5	paramArrayOfString2	String[]
    //   0	183	6	paramString3	String
    //   0	183	7	paramString4	String
    //   0	183	8	paramString5	String
    //   0	183	9	paramString6	String
    //   3	149	10	l1	long
    //   41	93	12	l2	long
    //   36	134	14	localCursor1	Cursor
    //   45	127	15	localCursor2	Cursor
    // Exception table:
    //   from	to	target	type
    //   14	38	160	java/lang/Throwable
    //   14	38	176	finally
    //   38	43	176	finally
    //   47	141	176	finally
    //   164	169	176	finally
    //   38	43	179	java/lang/Throwable
    //   47	141	179	java/lang/Throwable
  }
  
  private String a(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    String str;
    do
    {
      return paramObject;
      str = paramObject.toString();
      paramObject = str;
    } while (str.length() <= 0);
    return SecurityUtile.b(str);
  }
  
  private static String a(Object[] paramArrayOfObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfObject.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramArrayOfObject[i];
      if (localObject == null) {
        localStringBuilder.append("null,");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(localObject.toString()).append(',');
      }
    }
    return localStringBuilder.toString();
  }
  
  private ArrayList a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      Cursor localCursor = a("select sql from sqlite_master where type=? and name=?", new String[] { "table", paramString });
      if (localCursor != null)
      {
        if (localCursor.moveToFirst())
        {
          ArrayList localArrayList = a(SecurityUtile.a(localCursor.getString(0)), new String[] { "TEXT", "BLOB" });
          this.jdField_a_of_type_JavaUtilMap.put(paramString, localArrayList);
        }
        localCursor.close();
      }
    }
    return (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  private ArrayList a(String paramString, String[] paramArrayOfString)
  {
    paramString = paramString.substring(paramString.indexOf("(") + 1, paramString.indexOf(")")).split(",");
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfString.length;
    int i = 0;
    while (i < k)
    {
      String str = paramArrayOfString[i].toLowerCase();
      int m = paramString.length;
      int j = 0;
      while (j < m)
      {
        String[] arrayOfString = paramString[j].trim().split(" ");
        if ((arrayOfString.length > 1) && (str.equals(arrayOfString[1].toLowerCase()))) {
          localArrayList.add(arrayOfString[0]);
        }
        j += 1;
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static Map a()
  {
    return null;
  }
  
  public static void a()
  {
    jdField_a_of_type_Boolean = BaseApplicationImpl.a().getSharedPreferences("mobileQQi", 0).getBoolean("isLogcatDBOperation", false);
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    Object localObject = Thread.currentThread();
    String str = ((Thread)localObject).getName();
    if (localObject == Looper.getMainLooper().getThread()) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TableName:").append(paramString2).append('|');
      ((StringBuilder)localObject).append("ExecuteType:").append(paramString1).append("|");
      ((StringBuilder)localObject).append("CurrentThreadName:").append(str).append('|');
      ((StringBuilder)localObject).append("IsMainThread:").append(bool).append('|');
      ((StringBuilder)localObject).append("Cost:").append(paramLong).append('|');
      ((StringBuilder)localObject).append("CMD:").append(paramString3);
      paramString1 = ((StringBuilder)localObject).toString();
      if (QLog.isColorLevel()) {
        QLog.d("SQLiteDataBaseLog", 2, paramString1);
      }
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if ((paramString2 == null) || (paramArrayOfString == null)) {}
    for (;;)
    {
      return;
      paramString1 = a(paramString1);
      if (paramString1 != null)
      {
        paramString2 = b(paramString2);
        int i = 0;
        while (i < paramString2.size())
        {
          if ((paramString1.contains(paramString2.get(i))) && ((paramArrayOfString[i] instanceof String))) {
            paramArrayOfString[i] = a(paramArrayOfString[i]);
          }
          i += 1;
        }
      }
    }
  }
  
  private void a(Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SQLiteDatabase", 2, paramThrowable.getMessage());
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if ((jdField_a_of_type_Boolean ^ paramBoolean))
    {
      jdField_a_of_type_Boolean = paramBoolean;
      SharedPreferences.Editor localEditor = BaseApplicationImpl.a().getSharedPreferences("mobileQQi", 0).edit();
      localEditor.putBoolean("isLogcatDBOperation", paramBoolean);
      localEditor.commit();
    }
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramArrayOfByte;
    }
    return SecurityUtile.a(paramArrayOfByte);
  }
  
  private ArrayList b(String paramString)
  {
    if (this.b.containsKey(paramString)) {
      return (ArrayList)this.b.get(paramString);
    }
    Matcher localMatcher = Pattern.compile("\\s*\\w+\\s*(>|<|=|>=|<=|!=|=!|<>)\\s*\\?\\s*").matcher(paramString);
    ArrayList localArrayList = new ArrayList();
    while (localMatcher.find())
    {
      Object localObject = localMatcher.group().trim();
      localObject = Pattern.compile("\\w+").matcher((CharSequence)localObject);
      ((Matcher)localObject).find();
      localArrayList.add(((Matcher)localObject).group());
    }
    this.b.put(paramString, localArrayList);
    return localArrayList;
  }
  
  public static void f() {}
  
  public static void g() {}
  
  private void h()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache.jdField_a_of_type_Boolean)
    {
      String[] arrayOfString = a();
      this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache.a(arrayOfString);
    }
  }
  
  public int a(String paramString)
  {
    int i = 0;
    int j = 0;
    long l = System.currentTimeMillis();
    paramString = a("select count() from " + paramString, null);
    if (paramString != null)
    {
      i = j;
      if (paramString.moveToFirst()) {
        i = paramString.getInt(0);
      }
      paramString.close();
    }
    MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
    return i;
  }
  
  public int a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    long l = System.currentTimeMillis();
    paramContentValues = a(paramString1, paramContentValues);
    a(paramString1, paramString2, paramArrayOfString);
    try
    {
      int i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      l = System.currentTimeMillis() - l;
      if (jdField_a_of_type_Boolean) {
        a("update", paramString1, paramContentValues + ";" + paramString2 + ";" + a(paramArrayOfString), l);
      }
      MsgAutoMonitorUtil.a().a(l);
      return i;
    }
    catch (Throwable paramString1)
    {
      a(paramString1);
    }
    return -1;
  }
  
  public int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    long l1 = System.currentTimeMillis();
    a(paramString1, paramString2, paramArrayOfString);
    try
    {
      int i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete(paramString1, paramString2, paramArrayOfString);
      long l2 = System.currentTimeMillis() - l1;
      if (jdField_a_of_type_Boolean) {
        a("delete", paramString1, paramString2 + ";" + a(paramArrayOfString), l2);
      }
      MsgAutoMonitorUtil.a().a(l2);
      return i;
    }
    catch (Throwable paramString1)
    {
      a(paramString1);
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l1);
    }
    return -1;
  }
  
  public long a(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    long l2 = System.currentTimeMillis();
    paramContentValues = a(paramString1, paramContentValues);
    try
    {
      long l1 = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.insert(paramString1, paramString2, paramContentValues);
      l2 = System.currentTimeMillis() - l2;
      if (jdField_a_of_type_Boolean) {
        a("insert", paramString1, paramString2 + ";" + paramContentValues, l2);
      }
      MsgAutoMonitorUtil.a().a(l2);
      return l1;
    }
    catch (Throwable paramString1)
    {
      a(paramString1);
    }
    return -1L;
  }
  
  /* Error */
  public Cursor a(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: invokestatic 105	java/lang/System:currentTimeMillis	()J
    //   3: lstore 5
    //   5: aload_0
    //   6: aload_2
    //   7: aload_3
    //   8: aload 4
    //   10: invokespecial 108	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 39	com/tencent/mobileqq/app/SQLiteDatabase:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   17: aload_1
    //   18: aload 4
    //   20: invokevirtual 390	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore 9
    //   25: invokestatic 105	java/lang/System:currentTimeMillis	()J
    //   28: lstore 7
    //   30: aload 9
    //   32: astore 10
    //   34: getstatic 23	com/tencent/mobileqq/app/SQLiteDatabase:jdField_a_of_type_Boolean	Z
    //   37: ifeq +55 -> 92
    //   40: ldc_w 391
    //   43: aload_2
    //   44: new 116	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   51: aload_1
    //   52: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 123
    //   57: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_3
    //   61: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 123
    //   66: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload 4
    //   71: invokestatic 129	com/tencent/mobileqq/app/SQLiteDatabase:a	([Ljava/lang/Object;)Ljava/lang/String;
    //   74: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: lload 7
    //   82: lload 5
    //   84: lsub
    //   85: invokestatic 136	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    //   88: aload 9
    //   90: astore 10
    //   92: invokestatic 141	com/tencent/util/MsgAutoMonitorUtil:a	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   95: invokestatic 105	java/lang/System:currentTimeMillis	()J
    //   98: lload 5
    //   100: lsub
    //   101: invokevirtual 144	com/tencent/util/MsgAutoMonitorUtil:a	(J)V
    //   104: aload 10
    //   106: areturn
    //   107: astore_1
    //   108: aconst_null
    //   109: astore 9
    //   111: aload_0
    //   112: aload_1
    //   113: invokespecial 147	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/Throwable;)V
    //   116: aload 9
    //   118: astore 10
    //   120: goto -28 -> 92
    //   123: astore_1
    //   124: aload_1
    //   125: athrow
    //   126: astore_1
    //   127: goto -16 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	SQLiteDatabase
    //   0	130	1	paramString1	String
    //   0	130	2	paramString2	String
    //   0	130	3	paramString3	String
    //   0	130	4	paramArrayOfString	String[]
    //   3	96	5	l1	long
    //   28	53	7	l2	long
    //   23	94	9	localCursor1	Cursor
    //   32	87	10	localCursor2	Cursor
    // Exception table:
    //   from	to	target	type
    //   13	25	107	java/lang/Throwable
    //   13	25	123	finally
    //   25	30	123	finally
    //   34	88	123	finally
    //   111	116	123	finally
    //   25	30	126	java/lang/Throwable
    //   34	88	126	java/lang/Throwable
  }
  
  public Cursor a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return a(false, paramString1, null, paramString2, paramArrayOfString, null, null, null, null);
  }
  
  @Deprecated
  public Cursor a(String paramString, String[] paramArrayOfString)
  {
    long l = System.currentTimeMillis();
    Object localObject = null;
    try
    {
      paramString = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.rawQuery(paramString, paramArrayOfString);
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      return paramString;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString = paramString;
        a(paramString);
        paramString = localObject;
      }
    }
    finally {}
  }
  
  public Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4)
  {
    return a(false, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, paramString3, paramString4);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache.a(paramString);
  }
  
  public boolean a(String paramString)
  {
    long l = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.execSQL(paramString);
      l = System.currentTimeMillis() - l;
      if (jdField_a_of_type_Boolean) {
        a("execSQL", "", paramString, l);
      }
      MsgAutoMonitorUtil.a().a(l);
      return true;
    }
    catch (Throwable paramString)
    {
      a(paramString);
    }
    return false;
  }
  
  public boolean a(String paramString, Object[] paramArrayOfObject)
  {
    long l = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.execSQL(paramString, paramArrayOfObject);
      l = System.currentTimeMillis() - l;
      if (jdField_a_of_type_Boolean) {
        a("execSQL", "", paramString + ";" + a(paramArrayOfObject), l);
      }
      MsgAutoMonitorUtil.a().a(l);
      return true;
    }
    catch (Throwable paramString)
    {
      a(paramString);
    }
    return false;
  }
  
  public String[] a()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    long l = System.currentTimeMillis();
    Cursor localCursor;
    int i;
    if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null)
    {
      localCursor = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
      localObject1 = localObject2;
      if (localCursor != null)
      {
        localObject1 = localObject2;
        if (localCursor.moveToFirst())
        {
          localObject1 = new String[localCursor.getCount()];
          i = 0;
        }
      }
    }
    for (;;)
    {
      localObject1[i] = SecurityUtile.a(localCursor.getString(0));
      if (!localCursor.moveToNext())
      {
        if (localCursor != null) {
          localCursor.close();
        }
        MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
        return localObject1;
      }
      i += 1;
    }
  }
  
  public int b(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    long l = System.currentTimeMillis();
    String str2 = "select count(*) from " + paramString1;
    String str1 = str2;
    if (paramString2 != null)
    {
      str1 = str2;
      if (paramArrayOfString != null)
      {
        a(paramString1, paramString2, paramArrayOfString);
        str1 = str2 + " where " + paramString2;
      }
    }
    paramString1 = a(str1, paramArrayOfString);
    int i;
    if (paramString1 != null)
    {
      paramString1.moveToFirst();
      i = paramString1.getInt(0);
      paramString1.close();
    }
    for (;;)
    {
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      return i;
      i = 0;
    }
  }
  
  public long b(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    long l2 = System.currentTimeMillis();
    paramContentValues = a(paramString1, paramContentValues);
    try
    {
      long l1 = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace(paramString1, paramString2, paramContentValues);
      l2 = System.currentTimeMillis() - l2;
      if (jdField_a_of_type_Boolean) {
        a("replace", paramString1, paramString2 + ";" + paramContentValues, l2);
      }
      MsgAutoMonitorUtil.a().a(l2);
      return l1;
    }
    catch (Throwable paramString1)
    {
      a(paramString1);
    }
    return -1L;
  }
  
  public void b()
  {
    long l = System.currentTimeMillis();
    try
    {
      f();
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.beginTransaction();
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      MsgAutoMonitorUtil.a().b(1L);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable);
      }
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache.b(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.setLockingEnabled(paramBoolean);
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable);
      }
    }
  }
  
  public boolean b(String paramString)
  {
    h();
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache.a(paramString);
  }
  
  public String[] b()
  {
    h();
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache.a();
  }
  
  public void c()
  {
    long l = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable);
      }
    }
  }
  
  public void d()
  {
    long l = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.endTransaction();
      g();
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable);
      }
    }
  }
  
  public void e()
  {
    long l = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.setTransactionSuccessful();
      MsgAutoMonitorUtil.a().a(System.currentTimeMillis() - l);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a(localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SQLiteDatabase
 * JD-Core Version:    0.7.0.1
 */