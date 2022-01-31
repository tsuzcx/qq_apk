package com.tencent.mobileqq.startup.step;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Method;

public class QZonePreLoader
  extends Step
{
  private static final String b = "com.qzone.util.ResourceLoader";
  private static final String c = "preloadResource";
  
  private void a()
  {
    Object localObject1 = PluginUtils.getInstallPath(BaseApplicationImpl.getContext(), "qzone_plugin.apk");
    if (((File)localObject1).exists()) {}
    try
    {
      localObject1 = ((File)localObject1).getCanonicalPath();
      Object localObject2 = PluginStatic.getOrCreateClassLoader(BaseApplicationImpl.getContext(), "qzone_plugin.apk");
      localObject1 = new QZonePreLoader.QzonePluginContext(BaseApplicationImpl.getContext(), 0, (String)localObject1, (ClassLoader)localObject2, BaseApplicationImpl.getContext().getResources());
      localObject2 = ((ClassLoader)localObject2).loadClass("com.qzone.util.ResourceLoader");
      Object localObject3 = ((Class)localObject2).getMethod("get", new Class[0]).invoke(null, new Object[0]);
      ((Class)localObject2).getMethod("preloadResource", new Class[] { Context.class }).invoke(localObject3, new Object[] { localObject1 });
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      do
      {
        localClassNotFoundException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("exception", 2, localClassNotFoundException.getMessage());
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("exception", 2, localException.getMessage());
    }
  }
  
  protected boolean a()
  {
    a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.QZonePreLoader
 * JD-Core Version:    0.7.0.1
 */