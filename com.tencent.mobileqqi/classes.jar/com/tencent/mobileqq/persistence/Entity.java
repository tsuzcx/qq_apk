package com.tencent.mobileqq.persistence;

import android.database.Cursor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public abstract class Entity
{
  public static final int DETACHED = 1002;
  public static final int MANAGED = 1001;
  public static final int NEW = 1000;
  public static final int REMOVED = 1003;
  long _id = -1L;
  int _status = 1000;
  
  public boolean entityByCursor(Cursor paramCursor)
  {
    return false;
  }
  
  public Class getClassForTable()
  {
    return getClass();
  }
  
  public long getId()
  {
    return this._id;
  }
  
  public int getStatus()
  {
    return this._status;
  }
  
  public String getTableName()
  {
    return getClass().getSimpleName();
  }
  
  public void postRead() {}
  
  public void postwrite() {}
  
  public void prewrite() {}
  
  public void setId(long paramLong)
  {
    this._id = paramLong;
  }
  
  public void setStatus(int paramInt)
  {
    this._status = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    switch (this._status)
    {
    default: 
      localStringBuilder.append("_id=" + this._id);
    }
    for (Class localClass = getClass();; localClass = localClass.getSuperclass())
    {
      if (localClass == Entity.class) {
        break label245;
      }
      Field[] arrayOfField = localClass.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      label95:
      if (i < j)
      {
        Object localObject = arrayOfField[i];
        if (Modifier.isStatic(((Field)localObject).getModifiers())) {}
        for (;;)
        {
          i += 1;
          break label95;
          localStringBuilder.append("NEW,");
          break;
          localStringBuilder.append("MANAGED,");
          break;
          localStringBuilder.append("DETACHED,");
          break;
          localStringBuilder.append("REMOVED,");
          break;
          if (!((Field)localObject).isAccessible()) {
            ((Field)localObject).setAccessible(true);
          }
          String str = ((Field)localObject).getName();
          try
          {
            localObject = ((Field)localObject).get(this);
            localStringBuilder.append(',');
            localStringBuilder.append(str);
            localStringBuilder.append('=');
            localStringBuilder.append(localObject);
          }
          catch (Exception localException) {}
        }
      }
    }
    label245:
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.Entity
 * JD-Core Version:    0.7.0.1
 */