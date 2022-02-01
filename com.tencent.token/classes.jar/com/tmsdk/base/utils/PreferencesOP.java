package com.tmsdk.base.utils;

import btmsdkobf.ec;
import java.util.Map;

public class PreferencesOP
{
  private ec O;
  
  public PreferencesOP(String paramString)
  {
    this.O = new ec(paramString);
  }
  
  public static PreferencesOP getDefaultPreferences()
  {
    return new PreferencesOP("tms");
  }
  
  public void clear()
  {
    this.O.clear();
  }
  
  public Map<String, ?> getAll()
  {
    return this.O.getAll();
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return this.O.getBoolean(paramString, paramBoolean);
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    return this.O.getFloat(paramString, paramFloat);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return this.O.getInt(paramString, paramInt);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    return this.O.getLong(paramString, paramLong);
  }
  
  public String getString(String paramString1, String paramString2)
  {
    return this.O.getString(paramString1, paramString2);
  }
  
  public void putBoolean(String paramString, boolean paramBoolean)
  {
    this.O.putBoolean(paramString, paramBoolean);
  }
  
  public void putInt(String paramString, int paramInt)
  {
    this.O.putInt(paramString, paramInt);
  }
  
  public void putLong(String paramString, long paramLong)
  {
    this.O.putLong(paramString, paramLong);
  }
  
  public void putString(String paramString1, String paramString2)
  {
    this.O.putString(paramString1, paramString2);
  }
  
  public void remove(String paramString)
  {
    this.O.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.utils.PreferencesOP
 * JD-Core Version:    0.7.0.1
 */