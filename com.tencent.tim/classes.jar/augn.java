import android.os.Bundle;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import mqq.app.AppRuntime;

public class augn
{
  public static final AppRuntime b(BaseApplicationImpl paramBaseApplicationImpl, String paramString1, String paramString2)
  {
    if (paramBaseApplicationImpl == null) {
      return null;
    }
    try
    {
      Class localClass = Class.forName("com.tencent.androidqqmail.tim.QMAppInterface");
      paramString1 = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        QLog.d("MailPluginHelper", 2, "getOrCreateClassLoader application = " + paramBaseApplicationImpl + ", pluginID = " + paramString1);
        localObject = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, paramString1);
        paramString1 = ((ClassLoader)localObject).loadClass("com.tencent.androidqqmail.tim.QMAppInterface");
        BasicClassTypeUtil.setClassLoader(true, (ClassLoader)localObject);
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      paramBaseApplicationImpl.printStackTrace();
      QLog.e("MailPluginHelper", 2, "createMailPluginAppInterface, ex:", paramBaseApplicationImpl);
      return null;
    }
    QLog.d("MailPluginHelper", 2, "createMailPluginAppInterface , cls:" + paramString1);
    if (paramString1 == null)
    {
      QLog.e("MailPluginHelper", 2, "load class fail");
      return null;
    }
    QLog.d("MailPluginHelper", 2, "load class succ, uin:" + paramString2);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("uin", paramString2);
    ((Bundle)localObject).putInt("notification_icon", 2130842251);
    paramBaseApplicationImpl = paramString1.getDeclaredConstructor(new Class[] { BaseApplication.class, Bundle.class }).newInstance(new Object[] { paramBaseApplicationImpl, localObject });
    if ((paramBaseApplicationImpl instanceof AppRuntime))
    {
      paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     augn
 * JD-Core Version:    0.7.0.1
 */