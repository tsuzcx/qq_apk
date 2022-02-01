package com.tencent.mm.sdk;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.database.Cursor;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants.Resolver;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants.SharedPref;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MMSharedPreferences
  implements SharedPreferences
{
  private final String[] columns = { "_id", "key", "type", "value" };
  private final ContentResolver i;
  private final HashMap<String, Object> j = new HashMap();
  private REditor k = null;
  
  public MMSharedPreferences(Context paramContext)
  {
    this.i = paramContext.getContentResolver();
  }
  
  private Object getValue(String paramString)
  {
    for (;;)
    {
      try
      {
        Cursor localCursor = this.i.query(MMPluginProviderConstants.SharedPref.CONTENT_URI, this.columns, "key = ?", new String[] { paramString }, null);
        if (localCursor == null) {
          return null;
        }
        int m = localCursor.getColumnIndex("type");
        int n = localCursor.getColumnIndex("value");
        if (localCursor.moveToFirst())
        {
          paramString = MMPluginProviderConstants.Resolver.resolveObj(localCursor.getInt(m), localCursor.getString(n));
          localCursor.close();
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      paramString = null;
    }
  }
  
  public boolean contains(String paramString)
  {
    return getValue(paramString) != null;
  }
  
  public SharedPreferences.Editor edit()
  {
    if (this.k == null) {
      this.k = new REditor(this.i);
    }
    return this.k;
  }
  
  public Map<String, ?> getAll()
  {
    try
    {
      Object localObject1 = this.i.query(MMPluginProviderConstants.SharedPref.CONTENT_URI, this.columns, null, null, null);
      if (localObject1 == null) {
        return null;
      }
      int m = ((Cursor)localObject1).getColumnIndex("key");
      int n = ((Cursor)localObject1).getColumnIndex("type");
      int i1 = ((Cursor)localObject1).getColumnIndex("value");
      while (((Cursor)localObject1).moveToNext())
      {
        Object localObject2 = MMPluginProviderConstants.Resolver.resolveObj(((Cursor)localObject1).getInt(n), ((Cursor)localObject1).getString(i1));
        this.j.put(((Cursor)localObject1).getString(m), localObject2);
      }
      ((Cursor)localObject1).close();
      localObject1 = this.j;
      return localObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this.j;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    paramString = getValue(paramString);
    if ((paramString != null) && ((paramString instanceof Boolean))) {
      return ((Boolean)paramString).booleanValue();
    }
    return paramBoolean;
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    paramString = getValue(paramString);
    if ((paramString != null) && ((paramString instanceof Float))) {
      return ((Float)paramString).floatValue();
    }
    return paramFloat;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    paramString = getValue(paramString);
    if ((paramString != null) && ((paramString instanceof Integer))) {
      return ((Integer)paramString).intValue();
    }
    return paramInt;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    paramString = getValue(paramString);
    if ((paramString != null) && ((paramString instanceof Long))) {
      return ((Long)paramString).longValue();
    }
    return paramLong;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    paramString1 = getValue(paramString1);
    if ((paramString1 != null) && ((paramString1 instanceof String))) {
      return (String)paramString1;
    }
    return paramString2;
  }
  
  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    return null;
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  private static class REditor
    implements SharedPreferences.Editor
  {
    private ContentResolver i;
    private Map<String, Object> l = new HashMap();
    private Set<String> m = new HashSet();
    private boolean n = false;
    
    public REditor(ContentResolver paramContentResolver)
    {
      this.i = paramContentResolver;
    }
    
    public void apply() {}
    
    public SharedPreferences.Editor clear()
    {
      this.n = true;
      return this;
    }
    
    public boolean commit()
    {
      ContentValues localContentValues = new ContentValues();
      if (this.n)
      {
        this.i.delete(MMPluginProviderConstants.SharedPref.CONTENT_URI, null, null);
        this.n = false;
      }
      Iterator localIterator = this.m.iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        this.i.delete(MMPluginProviderConstants.SharedPref.CONTENT_URI, "key = ?", new String[] { localObject });
      }
      localIterator = this.l.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        if (MMPluginProviderConstants.Resolver.unresolveObj(localContentValues, ((Map.Entry)localObject).getValue())) {
          this.i.update(MMPluginProviderConstants.SharedPref.CONTENT_URI, localContentValues, "key = ?", new String[] { (String)((Map.Entry)localObject).getKey() });
        }
      }
      return true;
    }
    
    public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
    {
      this.l.put(paramString, Boolean.valueOf(paramBoolean));
      this.m.remove(paramString);
      return this;
    }
    
    public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
    {
      this.l.put(paramString, Float.valueOf(paramFloat));
      this.m.remove(paramString);
      return this;
    }
    
    public SharedPreferences.Editor putInt(String paramString, int paramInt)
    {
      this.l.put(paramString, Integer.valueOf(paramInt));
      this.m.remove(paramString);
      return this;
    }
    
    public SharedPreferences.Editor putLong(String paramString, long paramLong)
    {
      this.l.put(paramString, Long.valueOf(paramLong));
      this.m.remove(paramString);
      return this;
    }
    
    public SharedPreferences.Editor putString(String paramString1, String paramString2)
    {
      this.l.put(paramString1, paramString2);
      this.m.remove(paramString1);
      return this;
    }
    
    public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
    {
      return null;
    }
    
    public SharedPreferences.Editor remove(String paramString)
    {
      this.m.add(paramString);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.MMSharedPreferences
 * JD-Core Version:    0.7.0.1
 */