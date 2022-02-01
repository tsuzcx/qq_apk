import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import mqq.app.AppRuntime;

public class awjl
{
  public static final AppRuntime n(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if (paramBaseApplicationImpl == null) {
      return null;
    }
    if ("troop_member_card_plugin.apk".equals(paramString)) {}
    label158:
    for (String str = "com.tencent.mobileqq.memcard.base.TroopMemberCardAppInterface";; str = null) {
      try
      {
        for (;;)
        {
          Class localClass = Class.forName(str);
          paramBaseApplicationImpl = localClass;
          if (paramBaseApplicationImpl != null) {
            break;
          }
          try
          {
            QLog.e("TroopMemCardLog", 1, "*createTroopMemcardAppInterface load class fail");
            return null;
          }
          catch (ClassNotFoundException paramBaseApplicationImpl)
          {
            paramBaseApplicationImpl.printStackTrace();
            return null;
          }
          if (!"troop_manage_plugin.apk".equals(paramString)) {
            break label158;
          }
          str = "com.tencent.mobileqq.base.TroopManageAppInterface";
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, paramString);
          paramBaseApplicationImpl = paramString.loadClass(str);
          BasicClassTypeUtil.setClassLoader(true, paramString);
        }
      }
      catch (IllegalArgumentException paramBaseApplicationImpl)
      {
        paramBaseApplicationImpl.printStackTrace();
        return null;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime))) {
          break;
        }
        paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
        return paramBaseApplicationImpl;
      }
      catch (IllegalAccessException paramBaseApplicationImpl)
      {
        paramBaseApplicationImpl.printStackTrace();
        return null;
      }
      catch (InstantiationException paramBaseApplicationImpl)
      {
        paramBaseApplicationImpl.printStackTrace();
        return null;
      }
      catch (InvocationTargetException paramBaseApplicationImpl)
      {
        paramBaseApplicationImpl.printStackTrace();
        return null;
      }
      catch (NoSuchMethodException paramBaseApplicationImpl)
      {
        paramBaseApplicationImpl.printStackTrace();
        return null;
      }
      catch (Exception paramBaseApplicationImpl)
      {
        paramBaseApplicationImpl.printStackTrace();
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awjl
 * JD-Core Version:    0.7.0.1
 */