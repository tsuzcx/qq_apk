package com.tencent.ditto.reflect;

import com.tencent.ditto.shell.DittoUIEngine;

public abstract class DittoValue
{
  public abstract Object getValue(Object paramObject);
  
  public abstract void setValue(Object paramObject, String paramString);
  
  public abstract void setValue(Object paramObject, boolean paramBoolean);
  
  public static class GLOBAL
  {
    private static final GLOBAL sInstance = new GLOBAL();
    public static final int screenWidth = (int)DittoUIEngine.getScreenWidth();
    
    public static GLOBAL getInstance()
    {
      if (DittoUIEngine.getOuterGlobalData() != null) {
        return DittoUIEngine.getOuterGlobalData();
      }
      return sInstance;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ditto.reflect.DittoValue
 * JD-Core Version:    0.7.0.1
 */