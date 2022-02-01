package moai.storage;

import android.database.Cursor;
import android.util.SparseBooleanArray;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import java.util.Iterator;
import java.util.Map;

class Cache$3
  extends CacheLoader<Integer, Optional<Domain>>
{
  private final Joiner joiner = Joiner.on(",");
  
  Cache$3(Cache paramCache, Cache.Loader paramLoader) {}
  
  public Optional<Domain> load(Integer paramInteger)
    throws Exception
  {
    SQLiteDatabase localSQLiteDatabase = Cache.access$000(this.this$0).getReadableDatabase();
    Class localClass = this.val$queryLoader.parameterizedType;
    Cursor localCursor = localSQLiteDatabase.rawQuery(this.val$queryLoader.sql, new String[] { String.valueOf(paramInteger) });
    paramInteger = null;
    localSQLiteDatabase = null;
    if (localCursor != null)
    {
      paramInteger = localSQLiteDatabase;
      if (localCursor.moveToFirst())
      {
        paramInteger = (Domain)localClass.newInstance();
        paramInteger.convertFrom(localCursor);
      }
      localCursor.close();
    }
    return Optional.fromNullable(paramInteger);
  }
  
  public Map<Integer, Optional<Domain>> loadAll(Iterable<? extends Integer> paramIterable)
    throws Exception
  {
    Object localObject = Cache.access$000(this.this$0).getReadableDatabase();
    Class localClass = this.val$queryLoader.parameterizedType;
    Cursor localCursor = ((SQLiteDatabase)localObject).rawQuery(this.val$queryLoader.sql.replace("?", this.joiner.join(paramIterable)), null);
    localObject = ImmutableMap.builder();
    SparseBooleanArray localSparseBooleanArray = new SparseBooleanArray();
    int i;
    if (localCursor != null)
    {
      i = 0;
      while (i < localCursor.getCount())
      {
        localCursor.moveToPosition(i);
        Domain localDomain = (Domain)localClass.newInstance();
        localDomain.convertFrom(localCursor);
        localSparseBooleanArray.put(localDomain.getPrimaryKeyValue(), true);
        ((ImmutableMap.Builder)localObject).put(Integer.valueOf(localDomain.getPrimaryKeyValue()), Optional.of(localDomain));
        i += 1;
      }
      localCursor.close();
    }
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      i = ((Integer)paramIterable.next()).intValue();
      if (!localSparseBooleanArray.get(i, false)) {
        ((ImmutableMap.Builder)localObject).put(Integer.valueOf(i), Optional.absent());
      }
    }
    return ((ImmutableMap.Builder)localObject).build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.storage.Cache.3
 * JD-Core Version:    0.7.0.1
 */