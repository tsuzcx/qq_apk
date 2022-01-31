package tmsdk.common.module.pgsdk.manager;

import java.util.Map;

public abstract interface ITaijiPreferenceManager
{
  public abstract void beginTransaction();
  
  public abstract void clear();
  
  public abstract boolean contains(String paramString);
  
  public abstract boolean endTransaction();
  
  public abstract Map getAll();
  
  public abstract boolean getBoolean(String paramString);
  
  public abstract boolean getBoolean(String paramString, boolean paramBoolean);
  
  public abstract float getFloat(String paramString);
  
  public abstract float getFloat(String paramString, float paramFloat);
  
  public abstract int getInt(String paramString);
  
  public abstract int getInt(String paramString, int paramInt);
  
  public abstract long getLong(String paramString);
  
  public abstract long getLong(String paramString, long paramLong);
  
  public abstract String getString(String paramString);
  
  public abstract String getString(String paramString1, String paramString2);
  
  public abstract boolean putBoolean(String paramString, boolean paramBoolean);
  
  public abstract boolean putFloat(String paramString, float paramFloat);
  
  public abstract boolean putInt(String paramString, int paramInt);
  
  public abstract boolean putLong(String paramString, long paramLong);
  
  public abstract boolean putString(String paramString1, String paramString2);
  
  public abstract boolean remove(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.module.pgsdk.manager.ITaijiPreferenceManager
 * JD-Core Version:    0.7.0.1
 */