package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public abstract class MAutoStorage<T extends IAutoDBItem>
  extends MStorage
{
  private final ISQLiteDatabase bS;
  private final IAutoDBItem.MAutoDBInfo bT;
  private final String bU;
  
  public MAutoStorage(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    this.bS = paramISQLiteDatabase;
    this.bT = paramMAutoDBInfo;
    paramMAutoDBInfo = this.bT;
    if (Util.isNullOrNil(this.bT.primaryKey)) {}
    int i;
    for (paramISQLiteDatabase = "rowid";; paramISQLiteDatabase = this.bT.primaryKey)
    {
      paramMAutoDBInfo.primaryKey = paramISQLiteDatabase;
      this.bU = paramString;
      paramISQLiteDatabase = getUpdateSQLs(this.bT, getTableName(), this.bS);
      i = 0;
      while (i < paramISQLiteDatabase.size())
      {
        this.bS.execSQL(this.bU, (String)paramISQLiteDatabase.get(i));
        i += 1;
      }
    }
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      i = j;
      while (i < paramArrayOfString.length)
      {
        this.bS.execSQL(this.bU, paramArrayOfString[i]);
        i += 1;
      }
    }
  }
  
  private static StringBuilder a(ContentValues paramContentValues, String... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      localStringBuilder.append(str + " = ? AND ");
      if (paramContentValues.get(str) == null) {
        return null;
      }
      i += 1;
    }
    localStringBuilder.append(" 1=1");
    return localStringBuilder;
  }
  
  private boolean a(ContentValues paramContentValues)
  {
    Cursor localCursor = this.bS.query(getTableName(), this.bT.columns, this.bT.primaryKey + " = ?", new String[] { Util.nullAsNil(paramContentValues.getAsString(this.bT.primaryKey)) }, null, null, null);
    boolean bool = IAutoDBItem.checkIOEqual(paramContentValues, localCursor);
    localCursor.close();
    return bool;
  }
  
  private static String[] a(String[] paramArrayOfString, ContentValues paramContentValues)
  {
    String[] arrayOfString = new String[paramArrayOfString.length];
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = Util.nullAsNil(paramContentValues.getAsString(paramArrayOfString[i]));
      i += 1;
    }
    return arrayOfString;
  }
  
  private void f(String paramString)
  {
    Log.d("MicroMsg.SDK.MAutoStorage", getTableName() + ":" + paramString);
  }
  
  private void g(String paramString)
  {
    Log.e("MicroMsg.SDK.MAutoStorage", getTableName() + ":" + paramString);
  }
  
  public static String getCreateSQLs(IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS " + paramString + " ( ");
    localStringBuilder.append(paramMAutoDBInfo.sql);
    localStringBuilder.append(");");
    return localStringBuilder.toString();
  }
  
  public static List<String> getUpdateSQLs(IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, ISQLiteDatabase paramISQLiteDatabase)
  {
    LinkedList localLinkedList = new LinkedList();
    HashMap localHashMap = new HashMap();
    paramISQLiteDatabase = paramISQLiteDatabase.rawQuery("PRAGMA table_info( " + paramString + " )", new String[0]);
    if (paramISQLiteDatabase == null) {
      return localLinkedList;
    }
    while (paramISQLiteDatabase.moveToNext()) {
      localHashMap.put(paramISQLiteDatabase.getString(paramISQLiteDatabase.getColumnIndex("name")), paramISQLiteDatabase.getString(paramISQLiteDatabase.getColumnIndex("type")));
    }
    paramISQLiteDatabase.close();
    paramMAutoDBInfo = paramMAutoDBInfo.colsMap.entrySet().iterator();
    while (paramMAutoDBInfo.hasNext())
    {
      Object localObject = (Map.Entry)paramMAutoDBInfo.next();
      paramISQLiteDatabase = (String)((Map.Entry)localObject).getValue();
      localObject = (String)((Map.Entry)localObject).getKey();
      if ((paramISQLiteDatabase != null) && (paramISQLiteDatabase.length() > 0))
      {
        String str = (String)localHashMap.get(localObject);
        if (str == null)
        {
          localLinkedList.add("ALTER TABLE " + paramString + " ADD COLUMN " + (String)localObject + " " + paramISQLiteDatabase + ";");
          localHashMap.remove(localObject);
        }
        else if (!str.equalsIgnoreCase(paramISQLiteDatabase))
        {
          Log.e("MicroMsg.SDK.MAutoStorage", "conflicting alter table on column: " + (String)localObject + ", " + str + "<o-n>" + paramISQLiteDatabase);
          localHashMap.remove(localObject);
        }
      }
    }
    return localLinkedList;
  }
  
  public boolean delete(long paramLong)
  {
    boolean bool = true;
    if (this.bS.delete(getTableName(), "rowid = ?", new String[] { String.valueOf(paramLong) }) > 0) {}
    for (;;)
    {
      if (bool) {
        notify();
      }
      return bool;
      bool = false;
    }
  }
  
  public boolean delete(T paramT, String... paramVarArgs)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    paramT = paramT.convertTo();
    if ((paramT == null) || (paramT.size() <= 0)) {
      g("delete failed, value.size <= 0");
    }
    do
    {
      return bool2;
      if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
        break;
      }
      f("delete with primary key");
      if (this.bS.delete(getTableName(), this.bT.primaryKey + " = ?", new String[] { Util.nullAsNil(paramT.getAsString(this.bT.primaryKey)) }) > 0) {
        bool1 = true;
      }
      bool2 = bool1;
    } while (!bool1);
    doNotify();
    return bool1;
    StringBuilder localStringBuilder = a(paramT, paramVarArgs);
    if (localStringBuilder == null)
    {
      g("delete failed, check keys failed");
      return false;
    }
    if (this.bS.delete(getTableName(), localStringBuilder.toString(), a(paramVarArgs, paramT)) > 0)
    {
      doNotify(this.bT.primaryKey);
      return true;
    }
    g("delete failed");
    return false;
  }
  
  public boolean get(long paramLong, T paramT)
  {
    Cursor localCursor = this.bS.query(getTableName(), this.bT.columns, "rowid = ?", new String[] { String.valueOf(paramLong) }, null, null, null);
    if (localCursor.moveToFirst())
    {
      paramT.convertFrom(localCursor);
      localCursor.close();
      return true;
    }
    localCursor.close();
    return false;
  }
  
  public boolean get(T paramT, String... paramVarArgs)
  {
    ContentValues localContentValues = paramT.convertTo();
    if ((localContentValues == null) || (localContentValues.size() <= 0))
    {
      g("get failed, value.size <= 0");
      return false;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
    {
      f("get with primary key");
      paramVarArgs = this.bS.query(getTableName(), this.bT.columns, this.bT.primaryKey + " = ?", new String[] { Util.nullAsNil(localContentValues.getAsString(this.bT.primaryKey)) }, null, null, null);
      if (paramVarArgs.moveToFirst())
      {
        paramT.convertFrom(paramVarArgs);
        paramVarArgs.close();
        return true;
      }
      paramVarArgs.close();
      return false;
    }
    StringBuilder localStringBuilder = a(localContentValues, paramVarArgs);
    if (localStringBuilder == null)
    {
      g("get failed, check keys failed");
      return false;
    }
    paramVarArgs = this.bS.query(getTableName(), this.bT.columns, localStringBuilder.toString(), a(paramVarArgs, localContentValues), null, null, null);
    if (paramVarArgs.moveToFirst())
    {
      paramT.convertFrom(paramVarArgs);
      paramVarArgs.close();
      return true;
    }
    paramVarArgs.close();
    f("get failed, not found");
    return false;
  }
  
  public Cursor getAll()
  {
    return this.bS.query(getTableName(), this.bT.columns, null, null, null, null, null);
  }
  
  public int getCount()
  {
    int i = 0;
    Cursor localCursor = rawQuery("select count(*) from " + getTableName(), new String[0]);
    if (localCursor != null)
    {
      localCursor.moveToFirst();
      i = localCursor.getInt(0);
      localCursor.close();
    }
    return i;
  }
  
  public String getPrimaryKey()
  {
    return this.bT.primaryKey;
  }
  
  public String getTableName()
  {
    return this.bU;
  }
  
  public boolean insert(T paramT)
  {
    ContentValues localContentValues = paramT.convertTo();
    if ((localContentValues == null) || (localContentValues.size() <= 0))
    {
      g("insert failed, value.size <= 0");
      return false;
    }
    paramT.systemRowid = this.bS.insert(getTableName(), this.bT.primaryKey, localContentValues);
    if (paramT.systemRowid <= 0L)
    {
      g("insert failed");
      return false;
    }
    localContentValues.put("rowid", Long.valueOf(paramT.systemRowid));
    doNotify(localContentValues.getAsString(this.bT.primaryKey));
    return true;
  }
  
  public Cursor rawQuery(String paramString, String... paramVarArgs)
  {
    return this.bS.rawQuery(paramString, paramVarArgs);
  }
  
  public boolean replace(T paramT)
  {
    boolean bool;
    ContentValues localContentValues;
    int j;
    int k;
    if (!Util.isNullOrNil(this.bT.primaryKey))
    {
      bool = true;
      Assert.assertTrue("replace primaryKey == null", bool);
      localContentValues = paramT.convertTo();
      if (localContentValues != null)
      {
        j = localContentValues.size();
        k = paramT.getDBInfo().fields.length;
        if (!localContentValues.containsKey("rowid")) {
          break label86;
        }
      }
    }
    label86:
    for (int i = 1;; i = 0)
    {
      if (j == i + k) {
        break label91;
      }
      g("replace failed, cv.size() != item.fields().length");
      return false;
      bool = false;
      break;
    }
    label91:
    if (a(localContentValues))
    {
      f("no need replace , fields no change");
      return true;
    }
    if (this.bS.replace(getTableName(), this.bT.primaryKey, localContentValues) > 0L)
    {
      doNotify(this.bT.primaryKey);
      return true;
    }
    g("replace failed");
    return false;
  }
  
  public boolean update(long paramLong, T paramT)
  {
    paramT = paramT.convertTo();
    boolean bool2;
    if ((paramT == null) || (paramT.size() <= 0))
    {
      g("update failed, value.size <= 0");
      bool2 = false;
      return bool2;
    }
    Cursor localCursor = this.bS.query(getTableName(), this.bT.columns, "rowid = ?", new String[] { String.valueOf(paramLong) }, null, null, null);
    if (IAutoDBItem.checkIOEqual(paramT, localCursor))
    {
      localCursor.close();
      f("no need replace , fields no change");
      return true;
    }
    localCursor.close();
    if (this.bS.update(getTableName(), paramT, "rowid = ?", new String[] { String.valueOf(paramLong) }) > 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      doNotify();
      return bool1;
    }
  }
  
  public boolean update(T paramT, String... paramVarArgs)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    paramT = paramT.convertTo();
    if ((paramT == null) || (paramT.size() <= 0)) {
      g("update failed, value.size <= 0");
    }
    do
    {
      return bool2;
      if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
        break;
      }
      f("update with primary key");
      if (a(paramT))
      {
        f("no need replace , fields no change");
        return true;
      }
      if (this.bS.update(getTableName(), paramT, this.bT.primaryKey + " = ?", new String[] { Util.nullAsNil(paramT.getAsString(this.bT.primaryKey)) }) > 0) {
        bool1 = true;
      }
      bool2 = bool1;
    } while (!bool1);
    doNotify();
    return bool1;
    StringBuilder localStringBuilder = a(paramT, paramVarArgs);
    if (localStringBuilder == null)
    {
      g("update failed, check keys failed");
      return false;
    }
    if (this.bS.update(getTableName(), paramT, localStringBuilder.toString(), a(paramVarArgs, paramT)) > 0)
    {
      doNotify(this.bT.primaryKey);
      return true;
    }
    g("update failed");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.MAutoStorage
 * JD-Core Version:    0.7.0.1
 */