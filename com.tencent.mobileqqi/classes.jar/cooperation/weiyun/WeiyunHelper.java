package cooperation.weiyun;

import android.content.Context;
import android.content.Intent;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class WeiyunHelper
{
  public static final String a = "enter_file_assit";
  public static final String b = "exit_file_assit";
  private static final String c = "com.weiyun.plugin.app.WeiyunRuntime";
  
  public static PluginRuntime a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    try
    {
      Class localClass = Class.forName("com.weiyun.plugin.app.WeiyunRuntime");
      paramBaseApplicationImpl = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      try
      {
        ClassLoader localClassLoader = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "WeiyunPlugin.apk");
        paramBaseApplicationImpl = localClassLoader.loadClass("com.weiyun.plugin.app.WeiyunRuntime");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
      catch (ClassNotFoundException paramBaseApplicationImpl)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
      do
      {
        return null;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof PluginRuntime)));
      paramBaseApplicationImpl = (PluginRuntime)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    if (paramBaseApplicationImpl == null) {
      return null;
    }
  }
  
  public static void a(Context paramContext)
  {
    paramContext.sendBroadcast(new Intent("enter_file_assit"), "com.tencent.msg.permission.pushnotify");
  }
  
  public static void b(Context paramContext)
  {
    paramContext.sendBroadcast(new Intent("exit_file_assit"), "com.tencent.msg.permission.pushnotify");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.weiyun.WeiyunHelper
 * JD-Core Version:    0.7.0.1
 */