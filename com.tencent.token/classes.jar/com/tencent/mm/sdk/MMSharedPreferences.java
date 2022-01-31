package com.tencent.mm.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.database.Cursor;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants.Resolver;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants.SharedPref;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MMSharedPreferences
  implements SharedPreferences
{
  private final String[] columns = { "_id", "key", "type", "value" };
  private final ContentResolver i;
  private final HashMap j = new HashMap();
  private MMSharedPreferences.REditor k = null;
  
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
      this.k = new MMSharedPreferences.REditor(this.i);
    }
    return this.k;
  }
  
  public Map getAll()
  {
    try
    {
      Cursor localCursor = this.i.query(MMPluginProviderConstants.SharedPref.CONTENT_URI, this.columns, null, null, null);
      if (localCursor == null) {
        return null;
      }
      int m = localCursor.getColumnIndex("key");
      int n = localCursor.getColumnIndex("type");
      int i1 = localCursor.getColumnIndex("value");
      while (localCursor.moveToNext())
      {
        Object localObject = MMPluginProviderConstants.Resolver.resolveObj(localCursor.getInt(n), localCursor.getString(i1));
        this.j.put(localCursor.getString(m), localObject);
      }
      localException.close();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return this.j;
    }
    HashMap localHashMap = this.j;
    return localHashMap;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    paramString = getValue(paramString);
    boolean bool = paramBoolean;
    if (paramString != null)
    {
      bool = paramBoolean;
      if ((paramString instanceof Boolean)) {
        bool = ((Boolean)paramString).booleanValue();
      }
    }
    return bool;
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    paramString = getValue(paramString);
    float f = paramFloat;
    if (paramString != null)
    {
      f = paramFloat;
      if ((paramString instanceof Float)) {
        f = ((Float)paramString).floatValue();
      }
    }
    return f;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    paramString = getValue(paramString);
    int m = paramInt;
    if (paramString != null)
    {
      m = paramInt;
      if ((paramString instanceof Integer)) {
        m = ((Integer)paramString).intValue();
      }
    }
    return m;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    paramString = getValue(paramString);
    long l = paramLong;
    if (paramString != null)
    {
      l = paramLong;
      if ((paramString instanceof Long)) {
        l = ((Long)paramString).longValue();
      }
    }
    return l;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    paramString1 = getValue(paramString1);
    if ((paramString1 != null) && ((paramString1 instanceof String))) {
      return (String)paramString1;
    }
    return paramString2;
  }
  
  public Set getStringSet(String paramString, Set paramSet)
  {
    return null;
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.MMSharedPreferences
 * JD-Core Version:    0.7.0.1
 */