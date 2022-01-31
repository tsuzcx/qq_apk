package com.tencent.wcdb;

import android.content.ContentValues;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteStatement;
import com.tencent.wcdb.support.Log;
import java.util.HashMap;

@Deprecated
public class DatabaseUtils$InsertHelper
{
  public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
  public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
  private HashMap mColumns;
  private final SQLiteDatabase mDb;
  private String mInsertSQL = null;
  private SQLiteStatement mInsertStatement = null;
  private SQLiteStatement mPreparedStatement = null;
  private SQLiteStatement mReplaceStatement = null;
  private final String mTableName;
  
  public DatabaseUtils$InsertHelper(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    this.mDb = paramSQLiteDatabase;
    this.mTableName = paramString;
  }
  
  private void buildSQL()
  {
    Object localObject1 = null;
    StringBuilder localStringBuilder1 = new StringBuilder(128);
    localStringBuilder1.append("INSERT INTO ");
    localStringBuilder1.append(this.mTableName);
    localStringBuilder1.append(" (");
    StringBuilder localStringBuilder2 = new StringBuilder(128);
    localStringBuilder2.append("VALUES (");
    Cursor localCursor;
    for (;;)
    {
      try
      {
        localCursor = this.mDb.rawQuery("PRAGMA table_info(" + this.mTableName + ")", null);
        localObject1 = localCursor;
        this.mColumns = new HashMap(localCursor.getCount());
        int i = 1;
        localObject1 = localCursor;
        if (!localCursor.moveToNext()) {
          break;
        }
        localObject1 = localCursor;
        String str1 = localCursor.getString(1);
        localObject1 = localCursor;
        String str3 = localCursor.getString(4);
        localObject1 = localCursor;
        this.mColumns.put(str1, Integer.valueOf(i));
        localObject1 = localCursor;
        localStringBuilder1.append("'");
        localObject1 = localCursor;
        localStringBuilder1.append(str1);
        localObject1 = localCursor;
        localStringBuilder1.append("'");
        if (str3 == null)
        {
          localObject1 = localCursor;
          localStringBuilder2.append("?");
          localObject1 = localCursor;
          if (i == localCursor.getCount())
          {
            str1 = ") ";
            localObject1 = localCursor;
            localStringBuilder1.append(str1);
            localObject1 = localCursor;
            if (i != localCursor.getCount()) {
              break label338;
            }
            str1 = ");";
            localObject1 = localCursor;
            localStringBuilder2.append(str1);
            i += 1;
          }
        }
        else
        {
          localObject1 = localCursor;
          localStringBuilder2.append("COALESCE(?, ");
          localObject1 = localCursor;
          localStringBuilder2.append(str3);
          localObject1 = localCursor;
          localStringBuilder2.append(")");
          continue;
        }
        str2 = ", ";
      }
      finally
      {
        if (localObject1 != null) {
          localObject1.close();
        }
      }
      continue;
      label338:
      String str2 = ", ";
    }
    if (localCursor != null) {
      localCursor.close();
    }
    localStringBuilder1.append(localStringBuilder2);
    this.mInsertSQL = localStringBuilder1.toString();
  }
  
  private SQLiteStatement getStatement(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mReplaceStatement == null)
      {
        if (this.mInsertSQL == null) {
          buildSQL();
        }
        String str = "INSERT OR REPLACE" + this.mInsertSQL.substring(6);
        this.mReplaceStatement = this.mDb.compileStatement(str);
      }
      return this.mReplaceStatement;
    }
    if (this.mInsertStatement == null)
    {
      if (this.mInsertSQL == null) {
        buildSQL();
      }
      this.mInsertStatement = this.mDb.compileStatement(this.mInsertSQL);
    }
    return this.mInsertStatement;
  }
  
  /* Error */
  private long insertInternal(ContentValues paramContentValues, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	com/tencent/wcdb/DatabaseUtils$InsertHelper:mDb	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   4: invokevirtual 139	com/tencent/wcdb/database/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   7: aload_0
    //   8: iload_2
    //   9: invokespecial 141	com/tencent/wcdb/DatabaseUtils$InsertHelper:getStatement	(Z)Lcom/tencent/wcdb/database/SQLiteStatement;
    //   12: astore 5
    //   14: aload 5
    //   16: invokevirtual 146	com/tencent/wcdb/database/SQLiteStatement:clearBindings	()V
    //   19: aload_1
    //   20: invokevirtual 152	android/content/ContentValues:valueSet	()Ljava/util/Set;
    //   23: invokeinterface 158 1 0
    //   28: astore 6
    //   30: aload 6
    //   32: invokeinterface 163 1 0
    //   37: ifeq +102 -> 139
    //   40: aload 6
    //   42: invokeinterface 167 1 0
    //   47: checkcast 169	java/util/Map$Entry
    //   50: astore 7
    //   52: aload 5
    //   54: aload_0
    //   55: aload 7
    //   57: invokeinterface 172 1 0
    //   62: checkcast 125	java/lang/String
    //   65: invokevirtual 176	com/tencent/wcdb/DatabaseUtils$InsertHelper:getColumnIndex	(Ljava/lang/String;)I
    //   68: aload 7
    //   70: invokeinterface 179 1 0
    //   75: invokestatic 185	com/tencent/wcdb/DatabaseUtils:bindObjectToProgram	(Lcom/tencent/wcdb/database/SQLiteProgram;ILjava/lang/Object;)V
    //   78: goto -48 -> 30
    //   81: astore 5
    //   83: ldc 187
    //   85: new 42	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   92: ldc 189
    //   94: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_1
    //   98: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   101: ldc 194
    //   103: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_0
    //   107: getfield 38	com/tencent/wcdb/DatabaseUtils$InsertHelper:mTableName	Ljava/lang/String;
    //   110: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: iconst_1
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload 5
    //   124: aastore
    //   125: invokestatic 200	com/tencent/wcdb/support/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload_0
    //   129: getfield 36	com/tencent/wcdb/DatabaseUtils$InsertHelper:mDb	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   132: invokevirtual 203	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   135: ldc2_w 204
    //   138: lreturn
    //   139: aload 5
    //   141: invokevirtual 209	com/tencent/wcdb/database/SQLiteStatement:executeInsert	()J
    //   144: lstore_3
    //   145: aload_0
    //   146: getfield 36	com/tencent/wcdb/DatabaseUtils$InsertHelper:mDb	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   149: invokevirtual 212	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   152: aload_0
    //   153: getfield 36	com/tencent/wcdb/DatabaseUtils$InsertHelper:mDb	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   156: invokevirtual 203	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   159: lload_3
    //   160: lreturn
    //   161: astore_1
    //   162: aload_0
    //   163: getfield 36	com/tencent/wcdb/DatabaseUtils$InsertHelper:mDb	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   166: invokevirtual 203	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   169: aload_1
    //   170: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	InsertHelper
    //   0	171	1	paramContentValues	ContentValues
    //   0	171	2	paramBoolean	boolean
    //   144	16	3	l	long
    //   12	41	5	localSQLiteStatement	SQLiteStatement
    //   81	59	5	localSQLException	SQLException
    //   28	13	6	localIterator	java.util.Iterator
    //   50	19	7	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   7	30	81	com/tencent/wcdb/SQLException
    //   30	78	81	com/tencent/wcdb/SQLException
    //   139	152	81	com/tencent/wcdb/SQLException
    //   7	30	161	finally
    //   30	78	161	finally
    //   83	128	161	finally
    //   139	152	161	finally
  }
  
  public void bind(int paramInt, double paramDouble)
  {
    this.mPreparedStatement.bindDouble(paramInt, paramDouble);
  }
  
  public void bind(int paramInt, float paramFloat)
  {
    this.mPreparedStatement.bindDouble(paramInt, paramFloat);
  }
  
  public void bind(int paramInt1, int paramInt2)
  {
    this.mPreparedStatement.bindLong(paramInt1, paramInt2);
  }
  
  public void bind(int paramInt, long paramLong)
  {
    this.mPreparedStatement.bindLong(paramInt, paramLong);
  }
  
  public void bind(int paramInt, String paramString)
  {
    if (paramString == null)
    {
      this.mPreparedStatement.bindNull(paramInt);
      return;
    }
    this.mPreparedStatement.bindString(paramInt, paramString);
  }
  
  public void bind(int paramInt, boolean paramBoolean)
  {
    SQLiteStatement localSQLiteStatement = this.mPreparedStatement;
    if (paramBoolean) {}
    for (long l = 1L;; l = 0L)
    {
      localSQLiteStatement.bindLong(paramInt, l);
      return;
    }
  }
  
  public void bind(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      this.mPreparedStatement.bindNull(paramInt);
      return;
    }
    this.mPreparedStatement.bindBlob(paramInt, paramArrayOfByte);
  }
  
  public void bindNull(int paramInt)
  {
    this.mPreparedStatement.bindNull(paramInt);
  }
  
  public void close()
  {
    if (this.mInsertStatement != null)
    {
      this.mInsertStatement.close();
      this.mInsertStatement = null;
    }
    if (this.mReplaceStatement != null)
    {
      this.mReplaceStatement.close();
      this.mReplaceStatement = null;
    }
    this.mInsertSQL = null;
    this.mColumns = null;
  }
  
  public long execute()
  {
    if (this.mPreparedStatement == null) {
      throw new IllegalStateException("you must prepare this inserter before calling execute");
    }
    try
    {
      long l = this.mPreparedStatement.executeInsert();
      return l;
    }
    catch (SQLException localSQLException)
    {
      Log.e("WCDB.DatabaseUtils", "Error executing InsertHelper with table " + this.mTableName, new Object[] { localSQLException });
      return -1L;
    }
    finally
    {
      this.mPreparedStatement = null;
    }
  }
  
  public int getColumnIndex(String paramString)
  {
    getStatement(false);
    Integer localInteger = (Integer)this.mColumns.get(paramString);
    if (localInteger == null) {
      throw new IllegalArgumentException("column '" + paramString + "' is invalid");
    }
    return localInteger.intValue();
  }
  
  public long insert(ContentValues paramContentValues)
  {
    return insertInternal(paramContentValues, false);
  }
  
  public void prepareForInsert()
  {
    this.mPreparedStatement = getStatement(false);
    this.mPreparedStatement.clearBindings();
  }
  
  public void prepareForReplace()
  {
    this.mPreparedStatement = getStatement(true);
    this.mPreparedStatement.clearBindings();
  }
  
  public long replace(ContentValues paramContentValues)
  {
    return insertInternal(paramContentValues, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.DatabaseUtils.InsertHelper
 * JD-Core Version:    0.7.0.1
 */