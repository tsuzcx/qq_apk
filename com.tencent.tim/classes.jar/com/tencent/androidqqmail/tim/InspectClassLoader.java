package com.tencent.androidqqmail.tim;

import android.app.Activity;
import com.tencent.qqmail.utilities.log.QMLog;
import java.lang.reflect.Field;
import java.util.HashMap;

public class InspectClassLoader
  extends ClassLoader
{
  private static final String TAG = InspectClassLoader.class.getSimpleName();
  private final WrapClassLoader classLoader;
  private final HashMap<String, Boolean> hasFindClass = new HashMap();
  
  public InspectClassLoader(ClassLoader paramClassLoader)
  {
    super(paramClassLoader.getParent());
    this.classLoader = new WrapClassLoader(paramClassLoader);
  }
  
  public static void inspect(Activity paramActivity)
  {
    try
    {
      Field localField = ClassLoader.class.getDeclaredField("parent");
      localField.setAccessible(true);
      paramActivity = paramActivity.getClassLoader();
      localField.set(paramActivity, new InspectClassLoader(paramActivity));
      return;
    }
    catch (Exception paramActivity)
    {
      throw new RuntimeException("Inspect class loader", paramActivity);
    }
  }
  
  protected Class<?> findClass(String paramString)
    throws ClassNotFoundException
  {
    this.hasFindClass.put(paramString, Boolean.TRUE);
    return this.classLoader.findClass(paramString);
  }
  
  protected Class<?> loadClass(String paramString, boolean paramBoolean)
    throws ClassNotFoundException
  {
    if (("android.util.Log".equals(paramString)) || (paramString.startsWith("java."))) {
      return super.loadClass(paramString, paramBoolean);
    }
    this.hasFindClass.put(paramString, Boolean.FALSE);
    try
    {
      Class localClass = super.loadClass(paramString, paramBoolean);
      if (this.hasFindClass.get(paramString) == Boolean.TRUE)
      {
        QMLog.log(3, TAG, "loadClass:" + paramString + ", in_qqmail");
        return localClass;
      }
      QMLog.log(3, TAG, "loadClass:" + paramString + ", in_tim");
      return localClass;
    }
    finally
    {
      if (this.hasFindClass.get(paramString) != Boolean.TRUE) {
        break label172;
      }
    }
    QMLog.log(3, TAG, "loadClass:" + paramString + ", in_qqmail");
    for (;;)
    {
      throw localObject;
      label172:
      QMLog.log(3, TAG, "loadClass:" + paramString + ", in_tim");
    }
  }
  
  static class WrapClassLoader
    extends ClassLoader
  {
    protected WrapClassLoader(ClassLoader paramClassLoader)
    {
      super();
    }
    
    protected Class<?> findClass(String paramString)
      throws ClassNotFoundException
    {
      throw new ClassNotFoundException("not support " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.InspectClassLoader
 * JD-Core Version:    0.7.0.1
 */