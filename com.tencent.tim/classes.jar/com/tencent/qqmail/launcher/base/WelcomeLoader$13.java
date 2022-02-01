package com.tencent.qqmail.launcher.base;

import android.content.ComponentName;
import android.os.RemoteException;
import com.tencent.qqmail.utilities.log.QMLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

class WelcomeLoader$13
  implements InvocationHandler
{
  WelcomeLoader$13(WelcomeLoader paramWelcomeLoader, Object paramObject) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable
  {
    if ("startService".equals(paramMethod.getName())) {
      try
      {
        paramMethod = (ComponentName)paramMethod.invoke(this.val$iam, paramArrayOfObject);
        paramObject = paramMethod;
        if (paramMethod != null) {
          if (!"!".equals(paramMethod.getPackageName()))
          {
            boolean bool = "!!".equals(paramMethod.getPackageName());
            paramObject = paramMethod;
            if (!bool) {}
          }
          else
          {
            paramObject = null;
          }
        }
        return paramObject;
      }
      catch (Throwable paramObject)
      {
        return null;
      }
    }
    try
    {
      paramObject = paramMethod.invoke(this.val$iam, paramArrayOfObject);
      return paramObject;
    }
    catch (Throwable localThrowable)
    {
      QMLog.log(6, "WelcomeLoader", "ActivityManger proxy invoke method failed, method: " + paramMethod + ", args: " + Arrays.toString(paramArrayOfObject), localThrowable);
      for (paramObject = localThrowable; paramObject != null; paramObject = paramObject.getCause()) {
        if ((paramObject instanceof RemoteException)) {
          return WelcomeLoader.access$400(this.this$0, paramMethod);
        }
      }
      throw localThrowable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.base.WelcomeLoader.13
 * JD-Core Version:    0.7.0.1
 */