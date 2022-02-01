package moai.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.FluentIterable;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import moai.io.Hashes;

public abstract class Domain
  implements Cloneable, Convertable
{
  protected static Joiner commaJoiner = Joiner.on(",").skipNulls();
  private static final LoadingCache<String, Set<Domain>> dirtyGuards = CacheBuilder.newBuilder().build(new Domain.3());
  private static final Joiner joiner = Joiner.on("_").skipNulls();
  protected static final Predicate<Domain> nullPredicate = new Domain.1();
  private final BitSet bitSet = new BitSet();
  private boolean dirty;
  private ArrayDeque<Domain> flatDomainList = new ArrayDeque();
  
  protected static <T extends Domain> Function<T, T> cloneFunc(Class<T> paramClass)
  {
    return new Domain.2();
  }
  
  public static void createTable(SQLiteDatabase paramSQLiteDatabase, String paramString, Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create table if not exists ").append(paramString).append(" (");
    paramString = paramMap.entrySet().iterator();
    while (paramString.hasNext())
    {
      paramMap = (Map.Entry)paramString.next();
      localStringBuilder.append((String)paramMap.getKey()).append(" ").append((String)paramMap.getValue());
      if (paramString.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append(")");
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
  }
  
  protected static Set<Domain> dirtyGuard(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.hashCode() + paramString + paramInt;
    return (Set)dirtyGuards.getUnchecked(paramSQLiteDatabase);
  }
  
  public static void dropTable(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramSQLiteDatabase.execSQL("drop table if exists " + paramString);
  }
  
  public static String generatePrefixedFields(String paramString, String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(".");
      localStringBuilder.append(paramArrayOfString[i]);
      localStringBuilder.append(" AS ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append(paramArrayOfString[i]);
      if (i + 1 < paramArrayOfString.length) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static List<String> getExistColumns(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("PRAGMA table_info('" + paramString + "')", null);
    if (paramSQLiteDatabase != null)
    {
      int i = 0;
      while (i < paramSQLiteDatabase.getCount())
      {
        paramSQLiteDatabase.moveToPosition(i);
        localArrayList.add(paramSQLiteDatabase.getString(1));
        i += 1;
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  protected static int hashId(Object... paramVarArgs)
  {
    return Hashes.BKDRHashPositiveInt(joiner.join(paramVarArgs));
  }
  
  public static String listToString(List<String> paramList)
  {
    if (paramList == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (i != 0) {
        localStringBuilder.append(",");
      }
      for (;;)
      {
        localStringBuilder.append(str);
        break;
        i = 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void markDirty(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt)
  {
    paramSQLiteDatabase = dirtyGuard(paramSQLiteDatabase, paramString, paramInt).iterator();
    while (paramSQLiteDatabase.hasNext()) {
      ((Domain)paramSQLiteDatabase.next()).dirty = true;
    }
  }
  
  protected static String toJSONString(Object paramObject)
  {
    return JSON.toJSONString(paramObject, new Domain.4(), new SerializerFeature[0]);
  }
  
  public static LinkedHashMap<String, String> upgradeTable(SQLiteDatabase paramSQLiteDatabase, String paramString, Map<String, String> paramMap)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(paramMap);
    Object localObject = paramSQLiteDatabase.rawQuery("pragma table_info('" + paramString + "')", null);
    if (localObject != null)
    {
      int i = 0;
      while (i < ((Cursor)localObject).getCount())
      {
        ((Cursor)localObject).moveToPosition(i);
        localLinkedHashMap.remove(((Cursor)localObject).getString(1));
        i += 1;
      }
      ((Cursor)localObject).close();
    }
    if (localLinkedHashMap.size() > 0) {
      try
      {
        localObject = localLinkedHashMap.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          paramSQLiteDatabase.execSQL("alter table " + paramString + " add column " + (String)localEntry.getKey() + " " + (String)localEntry.getValue());
        }
        return localLinkedHashMap;
      }
      catch (SQLiteException localSQLiteException)
      {
        localLinkedHashMap.clear();
        localLinkedHashMap = new LinkedHashMap(paramMap);
        createTable(paramSQLiteDatabase, paramString, paramMap);
        return localLinkedHashMap;
      }
    }
    return localLinkedHashMap;
  }
  
  protected ContentValues addAttrContentValues(ContentValues paramContentValues)
  {
    return paramContentValues;
  }
  
  protected void addFlatDomainForUpdate(List<? extends Domain> paramList)
  {
    try
    {
      this.flatDomainList.addAll(paramList);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      paramList = FluentIterable.from(paramList).filter(nullPredicate).toList();
      this.flatDomainList.addAll(paramList);
    }
  }
  
  protected void addFlatDomainForUpdate(Domain paramDomain)
  {
    this.flatDomainList.add(paramDomain);
  }
  
  public int cardinality()
  {
    return this.bitSet.cardinality();
  }
  
  protected void clearMask(int paramInt)
  {
    this.bitSet.set(paramInt, false);
  }
  
  public abstract <T extends Domain> void cloneFrom(T paramT);
  
  public abstract ContentValues convertTo();
  
  public final int delete(SQLiteDatabase paramSQLiteDatabase)
  {
    generatePrimaryKeyOrThrow();
    int i = paramSQLiteDatabase.delete(getTableName(), String.format("%s = ?", new Object[] { getPrimaryKeyName() }), new String[] { String.valueOf(getPrimaryKeyValue()) });
    onDelete(paramSQLiteDatabase);
    return i;
  }
  
  protected void generatePrimaryKeyOrThrow() {}
  
  protected int getIntegratedAttrCount()
  {
    return 0;
  }
  
  public abstract String getPrimaryKeyName();
  
  public abstract int getPrimaryKeyValue();
  
  protected abstract String getTableName();
  
  protected boolean hasMask(int paramInt)
  {
    return this.bitSet.get(paramInt);
  }
  
  public boolean isDirty()
  {
    return this.dirty;
  }
  
  protected abstract void onDelete(SQLiteDatabase paramSQLiteDatabase);
  
  protected abstract void onReplace(SQLiteDatabase paramSQLiteDatabase);
  
  protected abstract void onUpdate(SQLiteDatabase paramSQLiteDatabase);
  
  public int replace(SQLiteDatabase paramSQLiteDatabase)
  {
    generatePrimaryKeyOrThrow();
    ContentValues localContentValues = addAttrContentValues(convertTo());
    int j = (int)paramSQLiteDatabase.replace(getTableName(), null, localContentValues);
    int i = j;
    if (j > 0)
    {
      int k = updateIntegratedAttr(paramSQLiteDatabase);
      i = j;
      if (k > 0) {
        i = j + k;
      }
    }
    if (i > 0) {
      onReplace(paramSQLiteDatabase);
    }
    return i;
  }
  
  public final int replaceAll(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.beginTransactionNonExclusive();
    try
    {
      Domain localDomain;
      for (int i = 0 + replace(paramSQLiteDatabase);; i = localDomain.replaceAll(paramSQLiteDatabase) + i)
      {
        localDomain = (Domain)this.flatDomainList.poll();
        if (localDomain == null) {
          break;
        }
      }
      paramSQLiteDatabase.setTransactionSuccessful();
      return i;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  protected void setMask(int paramInt)
  {
    this.bitSet.set(paramInt, true);
  }
  
  public int update(SQLiteDatabase paramSQLiteDatabase)
  {
    generatePrimaryKeyOrThrow();
    int j = paramSQLiteDatabase.update(getTableName(), convertTo(), getPrimaryKeyName() + " = ?", new String[] { String.valueOf(getPrimaryKeyValue()) });
    int i = j;
    if (j > 0)
    {
      int k = updateIntegratedAttr(paramSQLiteDatabase);
      i = j;
      if (k > 0) {
        i = j + k;
      }
    }
    if (i > 0) {
      onUpdate(paramSQLiteDatabase);
    }
    return i;
  }
  
  public final int updateAll(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.beginTransactionNonExclusive();
    try
    {
      Domain localDomain;
      for (int i = 0 + update(paramSQLiteDatabase);; i = localDomain.updateAll(paramSQLiteDatabase) + i)
      {
        localDomain = (Domain)this.flatDomainList.poll();
        if (localDomain == null) {
          break;
        }
      }
      paramSQLiteDatabase.setTransactionSuccessful();
      return i;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  protected int updateIntegratedAttr(SQLiteDatabase paramSQLiteDatabase)
  {
    return 0;
  }
  
  public final int updateOrReplace(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = update(paramSQLiteDatabase);
    if (i > 0) {
      return i;
    }
    return replace(paramSQLiteDatabase);
  }
  
  public final int updateOrReplaceAll(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.beginTransactionNonExclusive();
    try
    {
      Domain localDomain;
      for (int i = 0 + updateOrReplace(paramSQLiteDatabase);; i = localDomain.updateOrReplaceAll(paramSQLiteDatabase) + i)
      {
        localDomain = (Domain)this.flatDomainList.poll();
        if (localDomain == null) {
          break;
        }
      }
      paramSQLiteDatabase.setTransactionSuccessful();
      return i;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.storage.Domain
 * JD-Core Version:    0.7.0.1
 */