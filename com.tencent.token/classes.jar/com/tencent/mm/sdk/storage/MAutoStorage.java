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
    if (Util.isNullOrNil(paramMAutoDBInfo.primaryKey)) {
      paramISQLiteDatabase = "rowid";
    } else {
      paramISQLiteDatabase = this.bT.primaryKey;
    }
    paramMAutoDBInfo.primaryKey = paramISQLiteDatabase;
    this.bU = paramString;
    paramISQLiteDatabase = getUpdateSQLs(this.bT, getTableName(), this.bS);
    int j = 0;
    int i = 0;
    while (i < paramISQLiteDatabase.size())
    {
      this.bS.execSQL(this.bU, (String)paramISQLiteDatabase.get(i));
      i += 1;
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
    StringBuilder localStringBuilder1 = new StringBuilder();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(str);
      localStringBuilder2.append(" = ? AND ");
      localStringBuilder1.append(localStringBuilder2.toString());
      if (paramContentValues.get(str) == null) {
        return null;
      }
      i += 1;
    }
    localStringBuilder1.append(" 1=1");
    return localStringBuilder1;
  }
  
  private boolean a(ContentValues paramContentValues)
  {
    Object localObject = this.bS;
    String str = getTableName();
    String[] arrayOfString = this.bT.columns;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.bT.primaryKey);
    localStringBuilder.append(" = ?");
    localObject = ((ISQLiteDatabase)localObject).query(str, arrayOfString, localStringBuilder.toString(), new String[] { Util.nullAsNil(paramContentValues.getAsString(this.bT.primaryKey)) }, null, null, null);
    boolean bool = IAutoDBItem.checkIOEqual(paramContentValues, (Cursor)localObject);
    ((Cursor)localObject).close();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getTableName());
    localStringBuilder.append(":");
    localStringBuilder.append(paramString);
    Log.d("MicroMsg.SDK.MAutoStorage", localStringBuilder.toString());
  }
  
  private void g(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getTableName());
    localStringBuilder.append(":");
    localStringBuilder.append(paramString);
    Log.e("MicroMsg.SDK.MAutoStorage", localStringBuilder.toString());
  }
  
  public static String getCreateSQLs(IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder2.append(paramString);
    localStringBuilder2.append(" ( ");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(paramMAutoDBInfo.sql);
    localStringBuilder1.append(");");
    return localStringBuilder1.toString();
  }
  
  public static List<String> getUpdateSQLs(IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, ISQLiteDatabase paramISQLiteDatabase)
  {
    LinkedList localLinkedList = new LinkedList();
    HashMap localHashMap = new HashMap();
    Object localObject1 = new StringBuilder("PRAGMA table_info( ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" )");
    paramISQLiteDatabase = paramISQLiteDatabase.rawQuery(((StringBuilder)localObject1).toString(), new String[0]);
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
      localObject1 = (Map.Entry)paramMAutoDBInfo.next();
      paramISQLiteDatabase = (String)((Map.Entry)localObject1).getValue();
      localObject1 = (String)((Map.Entry)localObject1).getKey();
      if ((paramISQLiteDatabase != null) && (paramISQLiteDatabase.length() > 0))
      {
        Object localObject2 = (String)localHashMap.get(localObject1);
        if (localObject2 == null)
        {
          localObject2 = new StringBuilder("ALTER TABLE ");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(" ADD COLUMN ");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(" ");
          ((StringBuilder)localObject2).append(paramISQLiteDatabase);
          ((StringBuilder)localObject2).append(";");
          localLinkedList.add(((StringBuilder)localObject2).toString());
        }
        for (;;)
        {
          localHashMap.remove(localObject1);
          break;
          if (((String)localObject2).equalsIgnoreCase(paramISQLiteDatabase)) {
            break;
          }
          StringBuilder localStringBuilder = new StringBuilder("conflicting alter table on column: ");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(", ");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("<o-n>");
          localStringBuilder.append(paramISQLiteDatabase);
          Log.e("MicroMsg.SDK.MAutoStorage", localStringBuilder.toString());
        }
      }
    }
    return localLinkedList;
  }
  
  public boolean delete(long paramLong)
  {
    ISQLiteDatabase localISQLiteDatabase = this.bS;
    String str = getTableName();
    boolean bool = false;
    if (localISQLiteDatabase.delete(str, "rowid = ?", new String[] { String.valueOf(paramLong) }) > 0) {
      bool = true;
    }
    if (bool) {
      notify();
    }
    return bool;
  }
  
  public boolean delete(T paramT, String... paramVarArgs)
  {
    paramT = paramT.convertTo();
    boolean bool = false;
    Object localObject;
    if ((paramT != null) && (paramT.size() > 0)) {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        localObject = a(paramT, paramVarArgs);
        if (localObject == null) {
          paramT = "delete failed, check keys failed";
        }
      }
    }
    for (;;)
    {
      g(paramT);
      return false;
      if (this.bS.delete(getTableName(), ((StringBuilder)localObject).toString(), a(paramVarArgs, paramT)) > 0)
      {
        doNotify(this.bT.primaryKey);
        return true;
      }
      paramT = "delete failed";
      continue;
      f("delete with primary key");
      paramVarArgs = this.bS;
      localObject = getTableName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.bT.primaryKey);
      localStringBuilder.append(" = ?");
      if (paramVarArgs.delete((String)localObject, localStringBuilder.toString(), new String[] { Util.nullAsNil(paramT.getAsString(this.bT.primaryKey)) }) > 0) {
        bool = true;
      }
      if (bool) {
        doNotify();
      }
      return bool;
      paramT = "delete failed, value.size <= 0";
    }
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
    if ((localContentValues != null) && (localContentValues.size() > 0))
    {
      Object localObject;
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        localObject = a(localContentValues, paramVarArgs);
        if (localObject == null)
        {
          g("get failed, check keys failed");
          return false;
        }
        paramVarArgs = this.bS.query(getTableName(), this.bT.columns, ((StringBuilder)localObject).toString(), a(paramVarArgs, localContentValues), null, null, null);
        if (!paramVarArgs.moveToFirst()) {}
      }
      do
      {
        paramT.convertFrom(paramVarArgs);
        paramVarArgs.close();
        return true;
        paramVarArgs.close();
        f("get failed, not found");
        return false;
        f("get with primary key");
        paramVarArgs = this.bS;
        localObject = getTableName();
        String[] arrayOfString = this.bT.columns;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.bT.primaryKey);
        localStringBuilder.append(" = ?");
        paramVarArgs = paramVarArgs.query((String)localObject, arrayOfString, localStringBuilder.toString(), new String[] { Util.nullAsNil(localContentValues.getAsString(this.bT.primaryKey)) }, null, null, null);
      } while (paramVarArgs.moveToFirst());
      paramVarArgs.close();
      return false;
    }
    g("get failed, value.size <= 0");
    return false;
  }
  
  public Cursor getAll()
  {
    return this.bS.query(getTableName(), this.bT.columns, null, null, null, null, null);
  }
  
  public int getCount()
  {
    Object localObject = new StringBuilder("select count(*) from ");
    ((StringBuilder)localObject).append(getTableName());
    localObject = ((StringBuilder)localObject).toString();
    int i = 0;
    localObject = rawQuery((String)localObject, new String[0]);
    if (localObject != null)
    {
      ((Cursor)localObject).moveToFirst();
      i = ((Cursor)localObject).getInt(0);
      ((Cursor)localObject).close();
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
    if ((localContentValues != null) && (localContentValues.size() > 0))
    {
      paramT.systemRowid = this.bS.insert(getTableName(), this.bT.primaryKey, localContentValues);
      if (paramT.systemRowid > 0L) {}
    }
    for (paramT = "insert failed";; paramT = "insert failed, value.size <= 0")
    {
      g(paramT);
      return false;
      localContentValues.put("rowid", Long.valueOf(paramT.systemRowid));
      doNotify(localContentValues.getAsString(this.bT.primaryKey));
      return true;
    }
  }
  
  public Cursor rawQuery(String paramString, String... paramVarArgs)
  {
    return this.bS.rawQuery(paramString, paramVarArgs);
  }
  
  public boolean replace(T paramT)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean update(long paramLong, T paramT)
  {
    paramT = paramT.convertTo();
    boolean bool = false;
    if ((paramT != null) && (paramT.size() > 0))
    {
      Cursor localCursor = this.bS.query(getTableName(), this.bT.columns, "rowid = ?", new String[] { String.valueOf(paramLong) }, null, null, null);
      if (IAutoDBItem.checkIOEqual(paramT, localCursor))
      {
        localCursor.close();
        f("no need replace , fields no change");
        return true;
      }
      localCursor.close();
      if (this.bS.update(getTableName(), paramT, "rowid = ?", new String[] { String.valueOf(paramLong) }) > 0) {
        bool = true;
      }
      if (bool) {
        doNotify();
      }
      return bool;
    }
    g("update failed, value.size <= 0");
    return false;
  }
  
  public boolean update(T paramT, String... paramVarArgs)
  {
    paramT = paramT.convertTo();
    boolean bool = false;
    Object localObject;
    if ((paramT != null) && (paramT.size() > 0)) {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        localObject = a(paramT, paramVarArgs);
        if (localObject == null) {
          paramT = "update failed, check keys failed";
        }
      }
    }
    for (;;)
    {
      g(paramT);
      return false;
      if (this.bS.update(getTableName(), paramT, ((StringBuilder)localObject).toString(), a(paramVarArgs, paramT)) > 0)
      {
        doNotify(this.bT.primaryKey);
        return true;
      }
      paramT = "update failed";
      continue;
      f("update with primary key");
      if (a(paramT))
      {
        f("no need replace , fields no change");
        return true;
      }
      paramVarArgs = this.bS;
      localObject = getTableName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.bT.primaryKey);
      localStringBuilder.append(" = ?");
      if (paramVarArgs.update((String)localObject, paramT, localStringBuilder.toString(), new String[] { Util.nullAsNil(paramT.getAsString(this.bT.primaryKey)) }) > 0) {
        bool = true;
      }
      if (bool) {
        doNotify();
      }
      return bool;
      paramT = "update failed, value.size <= 0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.MAutoStorage
 * JD-Core Version:    0.7.0.1
 */