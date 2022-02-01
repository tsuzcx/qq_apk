package wf7;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class gt
{
  public static Object a(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    Class localClass = paramObject.getClass();
    Class[] arrayOfClass = new Class[paramArrayOfObject.length];
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      arrayOfClass[i] = paramArrayOfObject[i].getClass();
      if (arrayOfClass[i] == Integer.class) {
        arrayOfClass[i] = Integer.TYPE;
      } else if (arrayOfClass[i] == Boolean.class) {
        arrayOfClass[i] = Boolean.TYPE;
      }
      i += 1;
    }
    return localClass.getMethod(paramString, arrayOfClass).invoke(paramObject, paramArrayOfObject);
  }
  
  public static Object a(String paramString, Object[] paramArrayOfObject)
  {
    Class localClass = Class.forName(paramString);
    if (paramArrayOfObject == null)
    {
      paramString = null;
    }
    else
    {
      Class[] arrayOfClass = new Class[paramArrayOfObject.length];
      int i = 0;
      int j = paramArrayOfObject.length;
      for (;;)
      {
        paramString = arrayOfClass;
        if (i >= j) {
          break;
        }
        arrayOfClass[i] = paramArrayOfObject[i].getClass();
        i += 1;
      }
    }
    return localClass.getConstructor(paramString).newInstance(paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.gt
 * JD-Core Version:    0.7.0.1
 */