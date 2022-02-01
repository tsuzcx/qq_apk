package mqq.app;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class QQPermissionHelper
{
  private static final String TAG = "QQPermissionHelper";
  
  public static void doExecuteFail(Object paramObject, int paramInt)
  {
    try
    {
      executeMethod(paramObject, findMethodWithRequestCode(paramObject.getClass(), QQPermissionDenied.class, paramInt));
      return;
    }
    catch (Exception paramObject) {}
  }
  
  public static void doExecuteSuccess(Object paramObject, int paramInt)
  {
    executeMethod(paramObject, findMethodWithRequestCode(paramObject.getClass(), QQPermissionGrant.class, paramInt));
  }
  
  private static void executeMethod(Object paramObject, Method paramMethod)
  {
    if (paramMethod != null) {}
    try
    {
      if (!paramMethod.isAccessible()) {
        paramMethod.setAccessible(true);
      }
      paramMethod.invoke(paramObject, null);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      paramObject.printStackTrace();
      return;
    }
    catch (InvocationTargetException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  public static <A extends Annotation> Method findMethodWithRequestCode(Class paramClass, Class<A> paramClass1, int paramInt)
  {
    paramClass = paramClass.getMethods();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = paramClass[i];
      if ((localMethod.isAnnotationPresent(paramClass1)) && (isEqualRequestCodeFromAnntation(localMethod, paramClass1, paramInt))) {
        return localMethod;
      }
      i += 1;
    }
    return null;
  }
  
  public static boolean isEqualRequestCodeFromAnntation(Method paramMethod, Class paramClass, int paramInt)
  {
    boolean bool = true;
    if (paramClass.equals(QQPermissionDenied.class)) {
      return paramInt == ((QQPermissionDenied)paramMethod.getAnnotation(QQPermissionDenied.class)).value();
    }
    if (paramClass.equals(QQPermissionGrant.class))
    {
      if (paramInt == ((QQPermissionGrant)paramMethod.getAnnotation(QQPermissionGrant.class)).value()) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    return false;
  }
  
  public static void requestResult(Object paramObject, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[i] != 0) {
        localArrayList.add(paramArrayOfString[i]);
      }
      i += 1;
    }
    if (localArrayList.size() > 0)
    {
      doExecuteFail(paramObject, paramInt);
      return;
    }
    doExecuteSuccess(paramObject, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.app.QQPermissionHelper
 * JD-Core Version:    0.7.0.1
 */