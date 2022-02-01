import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msgbackup.data.MsgBackupExtraEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory.SQLiteOpenHelperImpl;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ajeq
  extends EntityManagerFactory
{
  public ajeq(String paramString)
  {
    super(paramString);
  }
  
  public List<MsgBackupMsgEntity> a(long paramLong, int paramInt)
  {
    Object localObject1 = String.format("select * from %s where _id>=%d limit %d", new Object[] { "msg", Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    Object localObject2 = this.mInnerDbHelper.getWritableDatabase();
    if (localObject2 == null)
    {
      ajgv.b("MsgBackup_db", "db is null queryMsg ..125.", new Object[0]);
      return new ArrayList();
    }
    localObject1 = ((SQLiteDatabase)localObject2).rawQuery((String)localObject1, null);
    localObject2 = cursor2List(MsgBackupMsgEntity.class, "msg", (Cursor)localObject1, null);
    ((Cursor)localObject1).close();
    return localObject2;
  }
  
  protected void a(String paramString, Cursor paramCursor, NoColumnErrorHandler paramNoColumnErrorHandler, long paramLong, Entity paramEntity)
    throws IllegalAccessException
  {
    if (paramEntity != null)
    {
      paramEntity.setId(paramLong);
      List localList = TableBuilder.getValidField(paramEntity);
      int j = localList.size();
      int i = 0;
      if (i < j)
      {
        Field localField = (Field)localList.get(i);
        Class localClass = localField.getType();
        String str = localField.getName();
        int k = paramCursor.getColumnIndex(str);
        if (k != -1)
        {
          if (!localField.isAccessible()) {
            localField.setAccessible(true);
          }
          if (localClass == Long.TYPE) {
            localField.set(paramEntity, Long.valueOf(paramCursor.getLong(k)));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (localClass == Integer.TYPE)
          {
            localField.set(paramEntity, Integer.valueOf(paramCursor.getInt(k)));
          }
          else if (localClass == String.class)
          {
            localField.set(paramEntity, paramCursor.getString(k));
          }
          else if (localClass == Byte.TYPE)
          {
            localField.set(paramEntity, Byte.valueOf((byte)paramCursor.getShort(k)));
          }
          else if (localClass == [B.class)
          {
            localField.set(paramEntity, paramCursor.getBlob(k));
          }
          else if (localClass == Short.TYPE)
          {
            localField.set(paramEntity, Short.valueOf(paramCursor.getShort(k)));
          }
          else
          {
            if (localClass == Boolean.TYPE)
            {
              if (paramCursor.getInt(k) != 0) {}
              for (boolean bool = true;; bool = false)
              {
                localField.set(paramEntity, Boolean.valueOf(bool));
                break;
              }
            }
            if (localClass == Float.TYPE)
            {
              localField.set(paramEntity, Float.valueOf(paramCursor.getFloat(k)));
            }
            else if (localClass == Double.TYPE)
            {
              localField.set(paramEntity, Double.valueOf(paramCursor.getDouble(k)));
              continue;
              if (paramNoColumnErrorHandler != null) {
                paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError(str, localClass));
              }
            }
          }
        }
      }
      if ((paramLong == -1L) || (paramString == null)) {
        break label432;
      }
      paramEntity.setStatus(1001);
      if (!(paramEntity instanceof MsgBackupMsgEntity)) {
        break label443;
      }
      ((MsgBackupMsgEntity)paramEntity).postRead();
    }
    label432:
    label443:
    while (!(paramEntity instanceof MsgBackupResEntity))
    {
      return;
      paramEntity.setStatus(1002);
      break;
    }
    ((MsgBackupResEntity)paramEntity).postRead();
  }
  
  public List<MsgBackupResEntity> b(long paramLong, int paramInt)
  {
    Object localObject1 = String.format("select * from %s where _id>=%d limit %d", new Object[] { "res", Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    Object localObject2 = this.mInnerDbHelper.getWritableDatabase();
    if (localObject2 == null)
    {
      ajgv.b("MsgBackup_db", "db is null queryRes ...135", new Object[0]);
      return new ArrayList();
    }
    localObject1 = ((SQLiteDatabase)localObject2).rawQuery((String)localObject1, null);
    localObject2 = cursor2List(MsgBackupResEntity.class, "res", (Cursor)localObject1, null);
    ((Cursor)localObject1).close();
    return localObject2;
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.mInnerDbHelper == null)
    {
      this.mInnerDbHelper = new EntityManagerFactory.SQLiteOpenHelperImpl(this, paramString, null, 1);
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
      createDatabase(this.mInnerDbHelper.getWritableDatabase());
    }
    return this.dbHelper;
  }
  
  public void createDatabase(SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase == null)
    {
      ajgv.c("MsgBackup_db", "db create is null", new Object[0]);
      return;
    }
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MsgBackupMsgEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MsgBackupResEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MsgBackupExtraEntity()));
  }
  
  public Entity cursor2Entity(Class<? extends Entity> paramClass, String paramString, Cursor paramCursor, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    if (paramCursor.isBeforeFirst()) {
      paramCursor.moveToFirst();
    }
    long l = -1L;
    try
    {
      if (paramCursor.getColumnIndex("_id") >= 0) {
        l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramClass = (Entity)paramClass.newInstance();
          a(paramString, paramCursor, paramNoColumnErrorHandler, l, paramClass);
          return paramClass;
        }
        catch (Exception paramClass)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("MsgBackup_db", 2, MsfSdkUtils.getStackTraceString(paramClass));
          return null;
        }
        catch (OutOfMemoryError paramClass)
        {
          if (!QLog.isColorLevel()) {
            break label117;
          }
          QLog.e("MsgBackup_db", 2, MsfSdkUtils.getStackTraceString(paramClass));
        }
        localException = localException;
        l = -1L;
      }
    }
    label117:
    return null;
  }
  
  protected List<? extends Entity> cursor2List(Class<? extends Entity> paramClass, String paramString, Cursor paramCursor, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    localObject4 = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramCursor != null)
    {
      localObject1 = localObject2;
      localObject2 = localObject4;
    }
    try
    {
      int i;
      if (paramCursor.moveToFirst())
      {
        localObject2 = localObject4;
        i = paramCursor.getCount();
        localObject1 = null;
      }
      Entity localEntity;
      label112:
      boolean bool;
      Object localObject3;
      for (;;)
      {
        localObject4 = localObject1;
      }
    }
    catch (Exception paramClass)
    {
      do
      {
        try
        {
          localEntity = cursor2Entity(paramClass, paramString, paramCursor, paramNoColumnErrorHandler);
          localObject2 = localObject1;
          if (localEntity != null)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject4 = localObject1;
            }
          }
          try
          {
            localObject2 = new ArrayList(i);
            localObject4 = localObject2;
            ((List)localObject2).add(localEntity);
            localObject1 = localObject2;
          }
          catch (Throwable localThrowable)
          {
            break label112;
          }
          localObject2 = localObject1;
          bool = paramCursor.moveToNext();
          if (bool) {
            break label169;
          }
          return localObject1;
        }
        catch (Exception paramClass)
        {
          for (;;)
          {
            localObject3 = localObject4;
          }
        }
        paramClass = paramClass;
        localObject1 = localThrowable;
      } while (!QLog.isColorLevel());
      QLog.e("MsgBackup_db", 2, MsfSdkUtils.getStackTraceString(paramClass));
      return localThrowable;
    }
  }
  
  /* Error */
  public int dA(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_2
    //   5: aload_0
    //   6: getfield 38	ajeq:mInnerDbHelper	Lcom/tencent/mobileqq/persistence/EntityManagerFactory$SQLiteOpenHelperImpl;
    //   9: invokevirtual 44	com/tencent/mobileqq/persistence/EntityManagerFactory$SQLiteOpenHelperImpl:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore 5
    //   14: aload 5
    //   16: ifnonnull +17 -> 33
    //   19: ldc 46
    //   21: ldc_w 316
    //   24: iconst_0
    //   25: anewarray 15	java/lang/Object
    //   28: invokestatic 54	ajgv:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: iconst_0
    //   32: ireturn
    //   33: iload 4
    //   35: istore_3
    //   36: aload 5
    //   38: new 318	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   45: ldc_w 321
    //   48: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_1
    //   52: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 328	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: aconst_null
    //   59: invokevirtual 65	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   62: astore_1
    //   63: aload_1
    //   64: ifnull -33 -> 31
    //   67: aload_1
    //   68: invokeinterface 270 1 0
    //   73: ifeq +11 -> 84
    //   76: aload_1
    //   77: iconst_0
    //   78: invokeinterface 142 2 0
    //   83: istore_2
    //   84: iload_2
    //   85: istore_3
    //   86: aload_1
    //   87: invokeinterface 76 1 0
    //   92: iload_2
    //   93: ireturn
    //   94: astore_1
    //   95: ldc 46
    //   97: iconst_1
    //   98: new 318	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   105: ldc_w 330
    //   108: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_1
    //   112: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 328	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: iload_3
    //   122: ireturn
    //   123: astore 5
    //   125: ldc 46
    //   127: iconst_1
    //   128: new 318	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 338
    //   138: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload 5
    //   143: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 328	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: iload 4
    //   154: istore_3
    //   155: aload_1
    //   156: invokeinterface 76 1 0
    //   161: iconst_0
    //   162: ireturn
    //   163: astore 5
    //   165: iload 4
    //   167: istore_3
    //   168: aload_1
    //   169: invokeinterface 76 1 0
    //   174: iload 4
    //   176: istore_3
    //   177: aload 5
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	ajeq
    //   0	180	1	paramString	String
    //   4	89	2	i	int
    //   35	142	3	j	int
    //   1	174	4	k	int
    //   12	25	5	localSQLiteDatabase	SQLiteDatabase
    //   123	19	5	localThrowable	Throwable
    //   163	15	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   36	63	94	java/lang/Exception
    //   86	92	94	java/lang/Exception
    //   155	161	94	java/lang/Exception
    //   168	174	94	java/lang/Exception
    //   177	180	94	java/lang/Exception
    //   67	84	123	java/lang/Throwable
    //   67	84	163	finally
    //   125	152	163	finally
  }
  
  /* Error */
  public int dz(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_2
    //   5: aload_0
    //   6: getfield 38	ajeq:mInnerDbHelper	Lcom/tencent/mobileqq/persistence/EntityManagerFactory$SQLiteOpenHelperImpl;
    //   9: invokevirtual 44	com/tencent/mobileqq/persistence/EntityManagerFactory$SQLiteOpenHelperImpl:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore 5
    //   14: aload 5
    //   16: ifnonnull +17 -> 33
    //   19: ldc 46
    //   21: ldc_w 341
    //   24: iconst_0
    //   25: anewarray 15	java/lang/Object
    //   28: invokestatic 54	ajgv:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: iconst_0
    //   32: ireturn
    //   33: iload 4
    //   35: istore_3
    //   36: aload 5
    //   38: new 318	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   45: ldc_w 321
    //   48: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_1
    //   52: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 328	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: aconst_null
    //   59: invokevirtual 65	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   62: astore_1
    //   63: aload_1
    //   64: ifnull -33 -> 31
    //   67: aload_1
    //   68: invokeinterface 270 1 0
    //   73: ifeq +11 -> 84
    //   76: aload_1
    //   77: iconst_0
    //   78: invokeinterface 142 2 0
    //   83: istore_2
    //   84: iload_2
    //   85: istore_3
    //   86: aload_1
    //   87: invokeinterface 76 1 0
    //   92: iload_2
    //   93: ireturn
    //   94: astore_1
    //   95: ldc 46
    //   97: iconst_1
    //   98: new 318	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   105: ldc_w 343
    //   108: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_1
    //   112: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 328	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: iload_3
    //   122: ireturn
    //   123: astore 5
    //   125: ldc 46
    //   127: iconst_1
    //   128: new 318	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 338
    //   138: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload 5
    //   143: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 328	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: iload 4
    //   154: istore_3
    //   155: aload_1
    //   156: invokeinterface 76 1 0
    //   161: iconst_0
    //   162: ireturn
    //   163: astore 5
    //   165: iload 4
    //   167: istore_3
    //   168: aload_1
    //   169: invokeinterface 76 1 0
    //   174: iload 4
    //   176: istore_3
    //   177: aload 5
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	ajeq
    //   0	180	1	paramString	String
    //   4	89	2	i	int
    //   35	142	3	j	int
    //   1	174	4	k	int
    //   12	25	5	localSQLiteDatabase	SQLiteDatabase
    //   123	19	5	localThrowable	Throwable
    //   163	15	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   36	63	94	java/lang/Exception
    //   86	92	94	java/lang/Exception
    //   155	161	94	java/lang/Exception
    //   168	174	94	java/lang/Exception
    //   177	180	94	java/lang/Exception
    //   67	84	123	java/lang/Throwable
    //   67	84	163	finally
    //   125	152	163	finally
  }
  
  public List<MsgBackupExtraEntity> fD()
  {
    Object localObject1 = String.format("select * from %s", new Object[] { "ex_info" });
    Object localObject2 = this.mInnerDbHelper.getWritableDatabase();
    if (localObject2 == null)
    {
      ajgv.b("MsgBackup_db", "db is null queryExtraInfo ...", new Object[0]);
      return new ArrayList();
    }
    localObject1 = ((SQLiteDatabase)localObject2).rawQuery((String)localObject1, null);
    localObject2 = cursor2List(MsgBackupExtraEntity.class, "ex_info", (Cursor)localObject1, null);
    ((Cursor)localObject1).close();
    return localObject2;
  }
  
  public String getPackageName()
  {
    return getClass().getPackage().getName();
  }
  
  public boolean isNeedEncrypt()
  {
    return false;
  }
  
  public List<MsgBackupResEntity> j(long paramLong1, long paramLong2)
  {
    Object localObject1 = String.format("select * from %s where msgSeq = %d and msgRandom = %d", new Object[] { "res", Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    Object localObject2 = this.mInnerDbHelper.getWritableDatabase();
    if (localObject2 == null)
    {
      ajgv.b("MsgBackup_db", "db is null queryRes ...", new Object[0]);
      return new ArrayList();
    }
    localObject1 = ((SQLiteDatabase)localObject2).rawQuery((String)localObject1, null);
    localObject2 = cursor2List(MsgBackupResEntity.class, "res", (Cursor)localObject1, null);
    ((Cursor)localObject1).close();
    return localObject2;
  }
  
  public void lr(List<MsgBackupMsgEntity> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    SQLiteDatabase localSQLiteDatabase = this.mInnerDbHelper.getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MsgBackupMsgEntity localMsgBackupMsgEntity = (MsgBackupMsgEntity)paramList.next();
      localMsgBackupMsgEntity.prewrite();
      localContentValues.put("chatUin", localMsgBackupMsgEntity.chatUin);
      localContentValues.put("chatType", Integer.valueOf(localMsgBackupMsgEntity.chatType));
      localContentValues.put("msgType", Integer.valueOf(localMsgBackupMsgEntity.msgType));
      localContentValues.put("msgTime", Long.valueOf(localMsgBackupMsgEntity.msgTime));
      localContentValues.put("msgSeq", Long.valueOf(localMsgBackupMsgEntity.msgSeq));
      localContentValues.put("msgRandom", Long.valueOf(localMsgBackupMsgEntity.msgRandom));
      localContentValues.put("extensionData", localMsgBackupMsgEntity.extensionData);
      localContentValues.put("extraData", localMsgBackupMsgEntity.extraData);
      localSQLiteDatabase.insert("msg", null, localContentValues);
    }
    localSQLiteDatabase.setTransactionSuccessful();
    localSQLiteDatabase.endTransaction();
  }
  
  public void ls(List<MsgBackupResEntity> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    SQLiteDatabase localSQLiteDatabase = this.mInnerDbHelper.getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MsgBackupResEntity localMsgBackupResEntity = (MsgBackupResEntity)paramList.next();
      localMsgBackupResEntity.prewrite();
      localContentValues.put("msgSeq", Long.valueOf(localMsgBackupResEntity.msgSeq));
      localContentValues.put("msgRandom", Long.valueOf(localMsgBackupResEntity.msgRandom));
      localContentValues.put("msgType", Integer.valueOf(localMsgBackupResEntity.msgType));
      localContentValues.put("msgSubType", Integer.valueOf(localMsgBackupResEntity.msgSubType));
      localContentValues.put("filePath", localMsgBackupResEntity.filePath);
      localContentValues.put("fileSize", Long.valueOf(localMsgBackupResEntity.fileSize));
      localContentValues.put("extraData", localMsgBackupResEntity.extraData);
      localSQLiteDatabase.insert("res", null, localContentValues);
    }
    localSQLiteDatabase.setTransactionSuccessful();
    localSQLiteDatabase.endTransaction();
  }
  
  public void lu(List<MsgBackupExtraEntity> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    SQLiteDatabase localSQLiteDatabase = this.mInnerDbHelper.getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MsgBackupExtraEntity localMsgBackupExtraEntity = (MsgBackupExtraEntity)paramList.next();
      localContentValues.put("name", localMsgBackupExtraEntity.name);
      localContentValues.put("value", localMsgBackupExtraEntity.value);
      localSQLiteDatabase.insert("ex_info", null, localContentValues);
    }
    localSQLiteDatabase.setTransactionSuccessful();
    localSQLiteDatabase.endTransaction();
  }
  
  public void upgradeDatabase(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajeq
 * JD-Core Version:    0.7.0.1
 */