package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class EntityManager
{
  private static final String jdField_a_of_type_JavaLangString = "EntityManager";
  private static final Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private static final String b = "The EntityManager has been already closed";
  private SQLiteDatabase jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase;
  private SQLiteOpenHelper jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper;
  private EntityTransaction jdField_a_of_type_ComTencentMobileqqPersistenceEntityTransaction;
  private boolean jdField_a_of_type_Boolean;
  
  EntityManager(SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper = paramSQLiteOpenHelper;
  }
  
  private List a(Class paramClass, String paramString, Cursor paramCursor)
  {
    localObject3 = null;
    localObject2 = null;
    Object localObject1 = localObject2;
    if (paramCursor != null)
    {
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    try
    {
      int i;
      if (paramCursor.moveToFirst())
      {
        localObject2 = localObject3;
        i = paramCursor.getCount();
        localObject1 = null;
      }
      Entity localEntity;
      boolean bool;
      for (;;)
      {
        localObject3 = localObject1;
      }
    }
    catch (Exception paramClass)
    {
      do
      {
        try
        {
          localEntity = a(paramClass, paramString, paramCursor);
          localObject2 = localObject1;
          if (localEntity != null)
          {
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              localObject3 = localObject1;
              localObject2 = new ArrayList(i);
            }
            localObject3 = localObject2;
            ((List)localObject2).add(localEntity);
          }
          localObject1 = localObject2;
          localObject2 = localObject1;
          bool = paramCursor.moveToNext();
          if (bool) {
            break label162;
          }
          return localObject1;
        }
        catch (Exception paramClass)
        {
          for (;;)
          {
            localObject2 = localObject3;
          }
        }
        paramClass = paramClass;
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e("EntityManager", 2, Log.getStackTraceString(paramClass));
      return localObject2;
    }
  }
  
  private void a(Entity paramEntity, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {
      throw new IllegalStateException("The EntityManager has been already closed");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.a();
    }
    String str;
    if (paramEntity._status == 1000)
    {
      str = paramEntity.getTableName();
      a(str, paramEntity, false);
      paramEntity.prewrite();
    }
    for (;;)
    {
      try
      {
        localContentValues = a(paramEntity);
        if (!paramBoolean) {
          continue;
        }
        l1 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.b(str, null, localContentValues);
        l2 = l1;
        if (l1 == -1L)
        {
          l2 = l1;
          if (a(str, paramEntity, true))
          {
            if (!paramBoolean) {
              continue;
            }
            l2 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.b(str, null, localContentValues);
          }
        }
        if (l2 != -1L)
        {
          paramEntity._id = l2;
          paramEntity._status = 1001;
        }
      }
      catch (Exception localException)
      {
        ContentValues localContentValues;
        long l1;
        long l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("EntityManager", 2, Log.getStackTraceString(localException));
        continue;
      }
      paramEntity.postwrite();
      return;
      l1 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str, null, localContentValues);
      continue;
      l2 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str, null, localContentValues);
    }
  }
  
  private boolean a(String paramString, Entity paramEntity, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!paramBoolean)
    {
      bool1 = bool2;
      if (jdField_a_of_type_JavaUtilHashtable.containsKey(paramString)) {
        bool1 = ((Boolean)jdField_a_of_type_JavaUtilHashtable.get(paramString)).booleanValue();
      }
    }
    bool2 = bool1;
    if (!bool1)
    {
      bool1 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(TableBuilder.a(paramEntity));
      jdField_a_of_type_JavaUtilHashtable.put(paramString, Boolean.valueOf(bool1));
      if (QLog.isColorLevel()) {
        QLog.d("EntityManager", 2, "createTable, tableName=" + paramString + ", isCreated=" + bool1 + ", isForceCreate=" + paramBoolean);
      }
      bool2 = bool1;
      if (bool1)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(paramString);
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  protected ContentValues a(Entity paramEntity)
  {
    ContentValues localContentValues = new ContentValues();
    Iterator localIterator = TableBuilder.a(paramEntity.getClassForTable()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Field)localIterator.next();
      String str = ((Field)localObject).getName();
      if (!((Field)localObject).isAccessible()) {
        ((Field)localObject).setAccessible(true);
      }
      localObject = ((Field)localObject).get(paramEntity);
      if ((localObject instanceof Integer)) {
        localContentValues.put(str, (Integer)localObject);
      } else if ((localObject instanceof Long)) {
        localContentValues.put(str, (Long)localObject);
      } else if ((localObject instanceof String)) {
        localContentValues.put(str, (String)localObject);
      } else if ((localObject instanceof byte[])) {
        localContentValues.put(str, (byte[])localObject);
      } else if ((localObject instanceof Short)) {
        localContentValues.put(str, (Short)localObject);
      } else if ((localObject instanceof Boolean)) {
        localContentValues.put(str, (Boolean)localObject);
      } else if ((localObject instanceof Double)) {
        localContentValues.put(str, (Double)localObject);
      } else if ((localObject instanceof Float)) {
        localContentValues.put(str, (Float)localObject);
      } else if ((localObject instanceof Byte)) {
        localContentValues.put(str, (Byte)localObject);
      } else if ((localObject instanceof Boolean)) {
        localContentValues.put(str, (Boolean)localObject);
      }
    }
    return localContentValues;
  }
  
  public Cursor a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (this.jdField_a_of_type_Boolean) {
      throw new IllegalStateException("The EntityManager has been already closed");
    }
    try
    {
      if (d(paramString1))
      {
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.b().a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString5, paramString6);
        return paramString1;
      }
    }
    catch (Exception paramString1)
    {
      paramString1 = paramString1;
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, Log.getStackTraceString(paramString1));
      }
      return null;
    }
    finally {}
  }
  
  public Entity a(Class paramClass, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {
      throw new IllegalStateException("The EntityManager has been already closed");
    }
    paramClass = a(paramClass, false, "_id=?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
    if (paramClass != null) {
      return (Entity)paramClass.get(0);
    }
    return null;
  }
  
  public Entity a(Class paramClass, Cursor paramCursor)
  {
    try
    {
      paramClass = a(paramClass, ((Entity)paramClass.newInstance()).getTableName(), paramCursor);
      return paramClass;
    }
    catch (Exception paramClass) {}
    return null;
  }
  
  public Entity a(Class paramClass, String paramString)
  {
    Object localObject2 = null;
    Iterator localIterator = TableBuilder.a(paramClass).iterator();
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (Field)localIterator.next();
    } while (!((Field)localObject1).isAnnotationPresent(unique.class));
    Object localObject1 = ((Field)localObject1).getName();
    paramClass = a(paramClass, false, (String)localObject1 + "=?", new String[] { paramString }, null, null, null, null);
    localObject1 = localObject2;
    if (paramClass != null) {
      localObject1 = (Entity)paramClass.get(0);
    }
    return localObject1;
  }
  
  public Entity a(Class paramClass, String paramString, Cursor paramCursor)
  {
    if (paramCursor.isBeforeFirst()) {
      paramCursor.moveToFirst();
    }
    try
    {
      if (paramCursor.getColumnIndex("_id") >= 0) {
        l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      }
      try
      {
        for (;;)
        {
          Entity localEntity1 = (Entity)paramClass.newInstance();
          paramClass = localEntity1;
          if (localEntity1 == null) {
            break;
          }
          localEntity1._id = l;
          if (!localEntity1.entityByCursor(paramCursor))
          {
            paramClass = TableBuilder.a(localEntity1).iterator();
            while (paramClass.hasNext())
            {
              Field localField = (Field)paramClass.next();
              Class localClass = localField.getType();
              if (Entity.class.isAssignableFrom(localClass))
              {
                Entity localEntity2 = a(localClass, paramCursor);
                localEntity2._status = 1002;
                localField.set(localEntity1, localEntity2);
              }
              int i = paramCursor.getColumnIndex(localField.getName());
              if (i != -1)
              {
                if (!localField.isAccessible()) {
                  localField.setAccessible(true);
                }
                if (localClass == Long.TYPE)
                {
                  localField.set(localEntity1, Long.valueOf(paramCursor.getLong(i)));
                }
                else if (localClass == Integer.TYPE)
                {
                  localField.set(localEntity1, Integer.valueOf(paramCursor.getInt(i)));
                }
                else if (localClass == String.class)
                {
                  localField.set(localEntity1, paramCursor.getString(i));
                }
                else if (localClass == Byte.TYPE)
                {
                  localField.set(localEntity1, Byte.valueOf((byte)paramCursor.getShort(i)));
                }
                else if (localClass == [B.class)
                {
                  localField.set(localEntity1, paramCursor.getBlob(i));
                }
                else if (localClass == Short.TYPE)
                {
                  localField.set(localEntity1, Short.valueOf(paramCursor.getShort(i)));
                }
                else if (localClass == Boolean.TYPE)
                {
                  if (paramCursor.getInt(i) == 0) {
                    break label510;
                  }
                  bool = true;
                  localField.set(localEntity1, Boolean.valueOf(bool));
                }
                else if (localClass == Float.TYPE)
                {
                  localField.set(localEntity1, Float.valueOf(paramCursor.getFloat(i)));
                }
                else if (localClass == Double.TYPE)
                {
                  localField.set(localEntity1, Double.valueOf(paramCursor.getDouble(i)));
                }
              }
            }
          }
          if ((l != -1L) && (paramString != null)) {}
          for (localEntity1._status = 1001;; localEntity1._status = 1002)
          {
            localEntity1.postRead();
            return localEntity1;
          }
          l = -1L;
        }
        return paramClass;
      }
      catch (Exception paramClass)
      {
        paramClass = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l = -1L;
        continue;
        label510:
        boolean bool = false;
      }
    }
  }
  
  public Entity a(Class paramClass, String paramString, String[] paramArrayOfString)
  {
    paramClass = a(paramClass, true, paramString, paramArrayOfString, null, null, null, "1");
    if (paramClass != null) {
      return (Entity)paramClass.get(0);
    }
    return null;
  }
  
  public Entity a(Class paramClass, String... paramVarArgs)
  {
    if (!paramClass.isAnnotationPresent(uniqueConstraints.class)) {
      throw new IllegalStateException("No uniqueConstraints annotation in the Entity " + paramClass.getSimpleName());
    }
    String[] arrayOfString = ((uniqueConstraints)paramClass.getAnnotation(uniqueConstraints.class)).columnNames().split(",");
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < arrayOfString.length)
    {
      localStringBuffer.append(arrayOfString[i]);
      if (i == arrayOfString.length - 1) {
        localStringBuffer.append("=?");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append("=? and ");
      }
    }
    paramClass = a(paramClass, false, localStringBuffer.toString(), paramVarArgs, null, null, null, null);
    if (paramClass != null) {
      return (Entity)paramClass.get(0);
    }
    return null;
  }
  
  public EntityTransaction a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityTransaction == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityTransaction = new EntityTransaction(this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper);
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityTransaction;
  }
  
  public List a(Class paramClass)
  {
    return a(paramClass, false, null, null, null, null, null, null);
  }
  
  /* Error */
  public List a(Class paramClass, String paramString1, boolean paramBoolean, String paramString2, String[] paramArrayOfString, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 78	com/tencent/mobileqq/persistence/EntityManager:jdField_a_of_type_Boolean	Z
    //   4: ifeq +13 -> 17
    //   7: new 80	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc 12
    //   13: invokespecial 83	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: iconst_0
    //   18: ifeq +53 -> 71
    //   21: aload_0
    //   22: getfield 30	com/tencent/mobileqq/persistence/EntityManager:jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper	Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   25: invokevirtual 261	com/tencent/mobileqq/app/SQLiteOpenHelper:b	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   28: aconst_null
    //   29: aload_2
    //   30: aload 4
    //   32: aload 5
    //   34: invokevirtual 422	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore 4
    //   39: aload 4
    //   41: ifnull +124 -> 165
    //   44: aload 4
    //   46: astore 5
    //   48: aload_0
    //   49: aload_1
    //   50: aload_2
    //   51: aload 4
    //   53: invokespecial 424	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;)Ljava/util/List;
    //   56: astore_1
    //   57: aload 4
    //   59: ifnull +10 -> 69
    //   62: aload 4
    //   64: invokeinterface 427 1 0
    //   69: aload_1
    //   70: areturn
    //   71: aload_0
    //   72: iload_3
    //   73: aload_2
    //   74: aconst_null
    //   75: aload 4
    //   77: aload 5
    //   79: aload 6
    //   81: aload 7
    //   83: aload 8
    //   85: aload 9
    //   87: invokevirtual 429	com/tencent/mobileqq/persistence/EntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   90: astore 4
    //   92: goto -53 -> 39
    //   95: astore_1
    //   96: aconst_null
    //   97: astore 4
    //   99: aload 4
    //   101: astore 5
    //   103: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +17 -> 123
    //   109: aload 4
    //   111: astore 5
    //   113: ldc 8
    //   115: iconst_2
    //   116: aload_1
    //   117: invokestatic 71	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   120: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload 4
    //   125: ifnull +38 -> 163
    //   128: aload 4
    //   130: invokeinterface 427 1 0
    //   135: aconst_null
    //   136: areturn
    //   137: astore_1
    //   138: aconst_null
    //   139: astore 5
    //   141: aload 5
    //   143: ifnull +10 -> 153
    //   146: aload 5
    //   148: invokeinterface 427 1 0
    //   153: aload_1
    //   154: athrow
    //   155: astore_1
    //   156: goto -15 -> 141
    //   159: astore_1
    //   160: goto -61 -> 99
    //   163: aconst_null
    //   164: areturn
    //   165: aconst_null
    //   166: astore_1
    //   167: goto -110 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	EntityManager
    //   0	170	1	paramClass	Class
    //   0	170	2	paramString1	String
    //   0	170	3	paramBoolean	boolean
    //   0	170	4	paramString2	String
    //   0	170	5	paramArrayOfString	String[]
    //   0	170	6	paramString3	String
    //   0	170	7	paramString4	String
    //   0	170	8	paramString5	String
    //   0	170	9	paramString6	String
    // Exception table:
    //   from	to	target	type
    //   21	39	95	java/lang/Exception
    //   71	92	95	java/lang/Exception
    //   21	39	137	finally
    //   71	92	137	finally
    //   48	57	155	finally
    //   103	109	155	finally
    //   113	123	155	finally
    //   48	57	159	java/lang/Exception
  }
  
  /* Error */
  public List a(Class paramClass, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: getfield 78	com/tencent/mobileqq/persistence/EntityManager:jdField_a_of_type_Boolean	Z
    //   10: ifeq +13 -> 23
    //   13: new 80	java/lang/IllegalStateException
    //   16: dup
    //   17: ldc 12
    //   19: invokespecial 83	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   22: athrow
    //   23: aload_0
    //   24: getfield 30	com/tencent/mobileqq/persistence/EntityManager:jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper	Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   27: invokevirtual 261	com/tencent/mobileqq/app/SQLiteOpenHelper:b	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   30: aload_2
    //   31: aload_3
    //   32: invokevirtual 433	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   35: astore_2
    //   36: aload 5
    //   38: astore_3
    //   39: aload_2
    //   40: ifnull +15 -> 55
    //   43: aload_2
    //   44: astore_3
    //   45: aload_0
    //   46: aload_1
    //   47: aconst_null
    //   48: aload_2
    //   49: invokespecial 424	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;)Ljava/util/List;
    //   52: astore_1
    //   53: aload_1
    //   54: astore_3
    //   55: aload_3
    //   56: astore_1
    //   57: aload_2
    //   58: ifnull +11 -> 69
    //   61: aload_2
    //   62: invokeinterface 427 1 0
    //   67: aload_3
    //   68: astore_1
    //   69: aload_1
    //   70: areturn
    //   71: astore_1
    //   72: aconst_null
    //   73: astore_2
    //   74: aload_2
    //   75: astore_3
    //   76: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +15 -> 94
    //   82: aload_2
    //   83: astore_3
    //   84: ldc 8
    //   86: iconst_2
    //   87: aload_1
    //   88: invokestatic 71	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   91: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: aload 4
    //   96: astore_1
    //   97: aload_2
    //   98: ifnull -29 -> 69
    //   101: aload_2
    //   102: invokeinterface 427 1 0
    //   107: aconst_null
    //   108: areturn
    //   109: astore_1
    //   110: aconst_null
    //   111: astore_3
    //   112: aload_3
    //   113: ifnull +9 -> 122
    //   116: aload_3
    //   117: invokeinterface 427 1 0
    //   122: aload_1
    //   123: athrow
    //   124: astore_1
    //   125: goto -13 -> 112
    //   128: astore_1
    //   129: goto -55 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	EntityManager
    //   0	132	1	paramClass	Class
    //   0	132	2	paramString	String
    //   0	132	3	paramArrayOfString	String[]
    //   1	94	4	localObject1	Object
    //   4	33	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   23	36	71	java/lang/Exception
    //   23	36	109	finally
    //   45	53	124	finally
    //   76	82	124	finally
    //   84	94	124	finally
    //   45	53	128	java/lang/Exception
  }
  
  public List a(Class paramClass, boolean paramBoolean, String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      paramString1 = a(paramClass, ((Entity)paramClass.newInstance()).getTableName(), paramBoolean, paramString1, paramArrayOfString, paramString2, paramString3, paramString4, paramString5);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("EntityManager", 2, "query Exception, table : " + paramClass);
        QLog.d("EntityManager", 2, Log.getStackTraceString(paramString1));
      }
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      throw new IllegalStateException("The EntityManager has been already closed");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper = null;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(Entity paramEntity)
  {
    a(paramEntity, false);
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(Entity paramEntity)
  {
    if (this.jdField_a_of_type_Boolean) {
      throw new IllegalStateException("The EntityManager has been already closed");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.a();
    }
    paramEntity.prewrite();
    try
    {
      if ((paramEntity._status == 1001) || (paramEntity._status == 1002))
      {
        ContentValues localContentValues = a(paramEntity);
        int i = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(paramEntity.getTableName(), localContentValues, "_id=?", new String[] { String.valueOf(paramEntity._id) });
        return i > 0;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, Log.getStackTraceString(localException));
      }
      paramEntity.postwrite();
    }
    return false;
  }
  
  public boolean a(Class paramClass)
  {
    if (this.jdField_a_of_type_Boolean) {
      throw new IllegalStateException("The EntityManager has been already closed");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.a();
    }
    try
    {
      paramClass = ((Entity)paramClass.newInstance()).getTableName();
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a("DROP TABLE IF EXISTS " + paramClass);
      jdField_a_of_type_JavaUtilHashtable.remove(paramClass);
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.b(paramClass);
      return true;
    }
    catch (Exception paramClass)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, Log.getStackTraceString(paramClass));
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      throw new IllegalStateException("The EntityManager has been already closed");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.a();
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a("DROP TABLE IF EXISTS " + paramString);
      jdField_a_of_type_JavaUtilHashtable.remove(paramString);
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.b(paramString);
      return true;
    }
    catch (SQLException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, Log.getStackTraceString(paramString));
      }
    }
    return false;
  }
  
  public boolean a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Boolean) {
      throw new IllegalStateException("The EntityManager has been already closed");
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.a();
      int i = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(paramString1, paramContentValues, paramString2, paramArrayOfString);
      if (i >= 0) {
        bool = true;
      }
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EntityManager", 2, Log.getStackTraceString(paramString1));
    }
    return bool;
    return false;
  }
  
  public boolean a(String paramString, Object[] paramArrayOfObject)
  {
    if (this.jdField_a_of_type_Boolean) {
      throw new IllegalStateException("The EntityManager has been already closed");
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.a();
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(paramString, paramArrayOfObject);
      return false;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EntityManager", 2, Log.getStackTraceString(paramString));
        }
      }
    }
  }
  
  public void b(Entity paramEntity)
  {
    a(paramEntity, true);
  }
  
  public boolean b(Entity paramEntity)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Boolean) {
      throw new IllegalStateException("The EntityManager has been already closed");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.a();
    }
    paramEntity.prewrite();
    if (paramEntity._status == 1001) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(paramEntity.getTableName(), "_id=?", new String[] { String.valueOf(paramEntity._id) }) > 0) {
        paramEntity._status = 1003;
      }
    }
    for (;;)
    {
      paramEntity.postwrite();
      return bool;
      bool = false;
      break;
      bool = false;
    }
  }
  
  public boolean b(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      throw new IllegalStateException("The EntityManager has been already closed");
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.b().a(paramString);
      return true;
    }
    catch (Exception paramString)
    {
      paramString = paramString;
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, Log.getStackTraceString(paramString));
      }
      return false;
    }
    finally {}
  }
  
  public void c(Entity paramEntity)
  {
    if (this.jdField_a_of_type_Boolean) {
      throw new IllegalStateException("The EntityManager has been already closed");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.a();
    }
    String str = paramEntity.getTableName();
    a(str, paramEntity, false);
    paramEntity.prewrite();
    try
    {
      ContentValues localContentValues = a(paramEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a("delete from " + str);
      long l2 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str, null, localContentValues);
      long l1 = l2;
      if (l2 == -1L)
      {
        l1 = l2;
        if (a(str, paramEntity, true)) {
          l1 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str, null, localContentValues);
        }
      }
      if (l1 != -1L)
      {
        paramEntity._id = l1;
        paramEntity._status = 1001;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EntityManager", 2, Log.getStackTraceString(localException));
        }
      }
    }
    paramEntity.postwrite();
  }
  
  public boolean c(String paramString)
  {
    return a(paramString, null);
  }
  
  public boolean d(String paramString)
  {
    boolean bool1;
    if (paramString == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      if ("Sqlite_master".equalsIgnoreCase(paramString)) {
        return true;
      }
      bool2 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.b().b(paramString);
      bool1 = bool2;
    } while (!QLog.isDevelopLevel());
    QLog.d("EntityManager", 2, " TABLECACHE tabbleIsExist : tableName:" + paramString + " isExist:" + bool2);
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.EntityManager
 * JD-Core Version:    0.7.0.1
 */