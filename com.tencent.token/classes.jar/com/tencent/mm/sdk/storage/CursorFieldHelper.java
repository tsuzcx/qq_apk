package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class CursorFieldHelper
{
  private static final Map<Class<?>, ISetMethod> bP = new HashMap();
  private static final Map<Class<?>, IGetMethod> bQ = new HashMap();
  private static final Map<Class<?>, String> bR = new HashMap();
  
  static
  {
    try
    {
      bP.put([B.class, new CursorFieldHelper.1());
      bP.put(Short.TYPE, new CursorFieldHelper.2());
      bP.put(Short.class, new CursorFieldHelper.3());
      bP.put(Boolean.TYPE, new CursorFieldHelper.4());
      bP.put(Boolean.class, new CursorFieldHelper.5());
      bP.put(Integer.TYPE, new CursorFieldHelper.6());
      bP.put(Integer.class, new CursorFieldHelper.7());
      bP.put(Float.TYPE, new CursorFieldHelper.8());
      bP.put(Float.class, new CursorFieldHelper.9());
      bP.put(Double.TYPE, new CursorFieldHelper.10());
      bP.put(Double.class, new CursorFieldHelper.11());
      bP.put(Long.TYPE, new CursorFieldHelper.12());
      bP.put(Long.class, new CursorFieldHelper.13());
      bP.put(String.class, new CursorFieldHelper.14());
      bQ.put([B.class, new CursorFieldHelper.15());
      bQ.put(Short.TYPE, new CursorFieldHelper.16());
      bQ.put(Short.class, new CursorFieldHelper.17());
      bQ.put(Boolean.TYPE, new CursorFieldHelper.18());
      bQ.put(Boolean.class, new CursorFieldHelper.19());
      bQ.put(Integer.TYPE, new CursorFieldHelper.20());
      bQ.put(Integer.class, new CursorFieldHelper.21());
      bQ.put(Float.TYPE, new CursorFieldHelper.22());
      bQ.put(Float.class, new CursorFieldHelper.23());
      bQ.put(Double.TYPE, new CursorFieldHelper.24());
      bQ.put(Double.class, new CursorFieldHelper.25());
      bQ.put(Long.TYPE, new CursorFieldHelper.26());
      bQ.put(Long.class, new CursorFieldHelper.27());
      bQ.put(String.class, new CursorFieldHelper.28());
      bR.put([B.class, "BLOB");
      bR.put(Short.TYPE, "SHORT");
      bR.put(Short.class, "SHORT");
      bR.put(Boolean.TYPE, "INTEGER");
      bR.put(Boolean.class, "INTEGER");
      bR.put(Integer.TYPE, "INTEGER");
      bR.put(Integer.class, "INTEGER");
      bR.put(Float.TYPE, "FLOAT");
      bR.put(Float.class, "FLOAT");
      bR.put(Double.TYPE, "DOUBLE");
      bR.put(Double.class, "DOUBLE");
      bR.put(Long.TYPE, "LONG");
      bR.put(Long.class, "LONG");
      bR.put(String.class, "TEXT");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static IGetMethod getter(Class<?> paramClass)
  {
    return (IGetMethod)bQ.get(paramClass);
  }
  
  public static void keep_getBlob(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      paramContentValues.put(MAutoDBItem.getColName(paramField), (byte[])paramField.get(paramObject));
      return;
    }
    catch (Exception paramField)
    {
      paramField.printStackTrace();
    }
  }
  
  public static void keep_getBoolean(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      String str = MAutoDBItem.getColName(paramField);
      if (paramField.getBoolean(paramObject)) {}
      for (int i = 1;; i = 0)
      {
        paramContentValues.put(str, Integer.valueOf(i));
        return;
      }
      return;
    }
    catch (Exception paramField)
    {
      paramField.printStackTrace();
    }
  }
  
  public static void keep_getDouble(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      if (!paramField.getType().equals(Double.TYPE))
      {
        paramContentValues.put(MAutoDBItem.getColName(paramField), (Double)paramField.get(paramObject));
        return;
      }
      paramContentValues.put(MAutoDBItem.getColName(paramField), Double.valueOf(paramField.getDouble(paramObject)));
      return;
    }
    catch (Exception paramField)
    {
      paramField.printStackTrace();
    }
  }
  
  public static void keep_getFloat(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      if (!paramField.getType().equals(Float.TYPE))
      {
        paramContentValues.put(MAutoDBItem.getColName(paramField), (Float)paramField.get(paramObject));
        return;
      }
      paramContentValues.put(MAutoDBItem.getColName(paramField), Float.valueOf(paramField.getFloat(paramObject)));
      return;
    }
    catch (Exception paramField)
    {
      paramField.printStackTrace();
    }
  }
  
  public static void keep_getInt(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      if (!paramField.getType().equals(Integer.TYPE))
      {
        paramContentValues.put(MAutoDBItem.getColName(paramField), (Integer)paramField.get(paramObject));
        return;
      }
      paramContentValues.put(MAutoDBItem.getColName(paramField), Integer.valueOf(paramField.getInt(paramObject)));
      return;
    }
    catch (Exception paramField)
    {
      paramField.printStackTrace();
    }
  }
  
  public static void keep_getLong(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      if (!paramField.getType().equals(Long.TYPE))
      {
        paramContentValues.put(MAutoDBItem.getColName(paramField), (Long)paramField.get(paramObject));
        return;
      }
      paramContentValues.put(MAutoDBItem.getColName(paramField), Long.valueOf(paramField.getLong(paramObject)));
      return;
    }
    catch (Exception paramField)
    {
      paramField.printStackTrace();
    }
  }
  
  public static void keep_getShort(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      paramContentValues.put(MAutoDBItem.getColName(paramField), Short.valueOf(paramField.getShort(paramObject)));
      return;
    }
    catch (Exception paramField)
    {
      paramField.printStackTrace();
    }
  }
  
  public static void keep_getString(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      paramContentValues.put(MAutoDBItem.getColName(paramField), (String)paramField.get(paramObject));
      return;
    }
    catch (Exception paramField)
    {
      paramField.printStackTrace();
    }
  }
  
  public static void keep_setBlob(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    try
    {
      paramField.set(paramObject, paramCursor.getBlob(paramInt));
      return;
    }
    catch (Exception paramField)
    {
      paramField.printStackTrace();
    }
  }
  
  public static void keep_setBoolean(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (paramField.getType().equals(Boolean.TYPE))
        {
          if (paramCursor.getInt(paramInt) != 0)
          {
            bool = true;
            paramField.setBoolean(paramObject, bool);
          }
        }
        else
        {
          paramField.set(paramObject, Integer.valueOf(paramCursor.getInt(paramInt)));
          return;
        }
      }
      catch (Exception paramField)
      {
        paramField.printStackTrace();
        return;
      }
      boolean bool = false;
    }
  }
  
  public static void keep_setDouble(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    try
    {
      if (paramField.getType().equals(Double.TYPE))
      {
        paramField.setDouble(paramObject, paramCursor.getDouble(paramInt));
        return;
      }
      paramField.set(paramObject, Double.valueOf(paramCursor.getDouble(paramInt)));
      return;
    }
    catch (Exception paramField)
    {
      paramField.printStackTrace();
    }
  }
  
  public static void keep_setFloat(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    try
    {
      if (paramField.getType().equals(Float.TYPE))
      {
        paramField.setFloat(paramObject, paramCursor.getFloat(paramInt));
        return;
      }
      paramField.set(paramObject, Float.valueOf(paramCursor.getFloat(paramInt)));
      return;
    }
    catch (Exception paramField)
    {
      paramField.printStackTrace();
    }
  }
  
  public static void keep_setInt(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    try
    {
      if (paramField.getType().equals(Integer.TYPE))
      {
        paramField.setInt(paramObject, paramCursor.getInt(paramInt));
        return;
      }
      paramField.set(paramObject, Integer.valueOf(paramCursor.getInt(paramInt)));
      return;
    }
    catch (Exception paramField)
    {
      paramField.printStackTrace();
    }
  }
  
  public static void keep_setLong(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    try
    {
      if (paramField.getType().equals(Long.TYPE))
      {
        paramField.setLong(paramObject, paramCursor.getLong(paramInt));
        return;
      }
      paramField.set(paramObject, Long.valueOf(paramCursor.getLong(paramInt)));
      return;
    }
    catch (Exception paramField)
    {
      paramField.printStackTrace();
    }
  }
  
  public static void keep_setShort(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    try
    {
      if (paramField.getType().equals(Short.TYPE))
      {
        paramField.setShort(paramObject, paramCursor.getShort(paramInt));
        return;
      }
      paramField.set(paramObject, Short.valueOf(paramCursor.getShort(paramInt)));
      return;
    }
    catch (Exception paramField)
    {
      paramField.printStackTrace();
    }
  }
  
  public static void keep_setString(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    try
    {
      paramField.set(paramObject, paramCursor.getString(paramInt));
      return;
    }
    catch (Exception paramField)
    {
      paramField.printStackTrace();
    }
  }
  
  public static ISetMethod setter(Class<?> paramClass)
  {
    return (ISetMethod)bP.get(paramClass);
  }
  
  public static String type(Class<?> paramClass)
  {
    return (String)bR.get(paramClass);
  }
  
  public static abstract interface IGetMethod
  {
    public abstract void invoke(Field paramField, Object paramObject, ContentValues paramContentValues);
  }
  
  public static abstract interface ISetMethod
  {
    public abstract void invoke(Field paramField, Object paramObject, Cursor paramCursor, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.CursorFieldHelper
 * JD-Core Version:    0.7.0.1
 */