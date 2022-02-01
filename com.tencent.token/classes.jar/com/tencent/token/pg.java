package com.tencent.token;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.database.Cursor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class pg
  implements SharedPreferences
{
  private final ContentResolver a;
  private final String[] b = { "_id", "key", "type", "value" };
  private final HashMap<String, Object> c = new HashMap();
  private a d = null;
  
  public pg(Context paramContext)
  {
    this.a = paramContext.getContentResolver();
  }
  
  private Object a(String paramString)
  {
    for (;;)
    {
      try
      {
        Cursor localCursor = this.a.query(pm.b.a, this.b, "key = ?", new String[] { paramString }, null);
        if (localCursor == null) {
          return null;
        }
        int i = localCursor.getColumnIndex("type");
        int j = localCursor.getColumnIndex("value");
        if (localCursor.moveToFirst())
        {
          paramString = pm.a.a(localCursor.getInt(i), localCursor.getString(j));
          localCursor.close();
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        new StringBuilder("getValue exception:").append(paramString.getMessage());
        return null;
      }
      paramString = null;
    }
  }
  
  public final boolean contains(String paramString)
  {
    return a(paramString) != null;
  }
  
  public final SharedPreferences.Editor edit()
  {
    if (this.d == null) {
      this.d = new a(this.a);
    }
    return this.d;
  }
  
  public final Map<String, ?> getAll()
  {
    try
    {
      Object localObject1 = this.a.query(pm.b.a, this.b, null, null, null);
      if (localObject1 == null) {
        return null;
      }
      int i = ((Cursor)localObject1).getColumnIndex("key");
      int j = ((Cursor)localObject1).getColumnIndex("type");
      int k = ((Cursor)localObject1).getColumnIndex("value");
      while (((Cursor)localObject1).moveToNext())
      {
        Object localObject2 = pm.a.a(((Cursor)localObject1).getInt(j), ((Cursor)localObject1).getString(k));
        this.c.put(((Cursor)localObject1).getString(i), localObject2);
      }
      ((Cursor)localObject1).close();
      localObject1 = this.c;
      return localObject1;
    }
    catch (Exception localException)
    {
      new StringBuilder("getAll exception:").append(localException.getMessage());
    }
    return this.c;
  }
  
  public final boolean getBoolean(String paramString, boolean paramBoolean)
  {
    paramString = a(paramString);
    if ((paramString != null) && ((paramString instanceof Boolean))) {
      return ((Boolean)paramString).booleanValue();
    }
    return paramBoolean;
  }
  
  public final float getFloat(String paramString, float paramFloat)
  {
    paramString = a(paramString);
    if ((paramString != null) && ((paramString instanceof Float))) {
      return ((Float)paramString).floatValue();
    }
    return paramFloat;
  }
  
  public final int getInt(String paramString, int paramInt)
  {
    paramString = a(paramString);
    if ((paramString != null) && ((paramString instanceof Integer))) {
      return ((Integer)paramString).intValue();
    }
    return paramInt;
  }
  
  public final long getLong(String paramString, long paramLong)
  {
    paramString = a(paramString);
    if ((paramString != null) && ((paramString instanceof Long))) {
      return ((Long)paramString).longValue();
    }
    return paramLong;
  }
  
  public final String getString(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    if ((paramString1 != null) && ((paramString1 instanceof String))) {
      return (String)paramString1;
    }
    return paramString2;
  }
  
  public final Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    return null;
  }
  
  public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  static final class a
    implements SharedPreferences.Editor
  {
    private Map<String, Object> a = new HashMap();
    private Set<String> b = new HashSet();
    private boolean c = false;
    private ContentResolver d;
    
    public a(ContentResolver paramContentResolver)
    {
      this.d = paramContentResolver;
    }
    
    public final void apply() {}
    
    public final SharedPreferences.Editor clear()
    {
      this.c = true;
      return this;
    }
    
    public final boolean commit()
    {
      ContentValues localContentValues = new ContentValues();
      if (this.c)
      {
        this.d.delete(pm.b.a, null, null);
        this.c = false;
      }
      Iterator localIterator = this.b.iterator();
      Object localObject1;
      while (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        this.d.delete(pm.b.a, "key = ?", new String[] { localObject1 });
      }
      localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (Map.Entry)localIterator.next();
        Object localObject2 = ((Map.Entry)localObject1).getValue();
        if (localObject2 == null) {}
        int i;
        for (;;)
        {
          i = 0;
          break;
          if ((localObject2 instanceof Integer))
          {
            i = 1;
            break;
          }
          if ((localObject2 instanceof Long))
          {
            i = 2;
            break;
          }
          if ((localObject2 instanceof String))
          {
            i = 3;
            break;
          }
          if ((localObject2 instanceof Boolean))
          {
            i = 4;
            break;
          }
          if ((localObject2 instanceof Float))
          {
            i = 5;
            break;
          }
          if ((localObject2 instanceof Double))
          {
            i = 6;
            break;
          }
          new StringBuilder("unresolve failed, unknown type=").append(localObject2.getClass().toString());
        }
        if (i == 0)
        {
          i = 0;
        }
        else
        {
          localContentValues.put("type", Integer.valueOf(i));
          localContentValues.put("value", localObject2.toString());
          i = 1;
        }
        if (i != 0) {
          this.d.update(pm.b.a, localContentValues, "key = ?", new String[] { (String)((Map.Entry)localObject1).getKey() });
        }
      }
      return true;
    }
    
    public final SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
    {
      this.a.put(paramString, Boolean.valueOf(paramBoolean));
      this.b.remove(paramString);
      return this;
    }
    
    public final SharedPreferences.Editor putFloat(String paramString, float paramFloat)
    {
      this.a.put(paramString, Float.valueOf(paramFloat));
      this.b.remove(paramString);
      return this;
    }
    
    public final SharedPreferences.Editor putInt(String paramString, int paramInt)
    {
      this.a.put(paramString, Integer.valueOf(paramInt));
      this.b.remove(paramString);
      return this;
    }
    
    public final SharedPreferences.Editor putLong(String paramString, long paramLong)
    {
      this.a.put(paramString, Long.valueOf(paramLong));
      this.b.remove(paramString);
      return this;
    }
    
    public final SharedPreferences.Editor putString(String paramString1, String paramString2)
    {
      this.a.put(paramString1, paramString2);
      this.b.remove(paramString1);
      return this;
    }
    
    public final SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
    {
      return null;
    }
    
    public final SharedPreferences.Editor remove(String paramString)
    {
      this.b.add(paramString);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.pg
 * JD-Core Version:    0.7.0.1
 */