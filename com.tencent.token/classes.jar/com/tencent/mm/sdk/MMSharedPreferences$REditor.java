package com.tencent.mm.sdk;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants.Resolver;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants.SharedPref;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class MMSharedPreferences$REditor
  implements SharedPreferences.Editor
{
  private ContentResolver i;
  private Map l = new HashMap();
  private Set m = new HashSet();
  private boolean n = false;
  
  public MMSharedPreferences$REditor(ContentResolver paramContentResolver)
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
  
  public SharedPreferences.Editor putStringSet(String paramString, Set paramSet)
  {
    return null;
  }
  
  public SharedPreferences.Editor remove(String paramString)
  {
    this.m.add(paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.MMSharedPreferences.REditor
 * JD-Core Version:    0.7.0.1
 */