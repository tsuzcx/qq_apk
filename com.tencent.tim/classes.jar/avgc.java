import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.IPluginAdapter;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;

public class avgc
  implements IPluginAdapter
{
  public static HashMap<String, Integer> qw = new HashMap();
  
  static
  {
    qw.put("mail_plugin.apk", Integer.valueOf(2));
  }
  
  public static int fS(String paramString)
  {
    if ((Integer)qw.get(paramString) == null) {
      return 1;
    }
    return ((Integer)qw.get(paramString)).intValue();
  }
  
  public Object invoke(int paramInt, Object paramObject)
  {
    int i = 4;
    boolean bool = false;
    String str;
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      paramObject = BaseApplicationImpl.getApplication();
      str = IPluginAdapterProxy.getProxy().currentUin;
      if (!TextUtils.isEmpty(str))
      {
        if (Build.VERSION.SDK_INT > 10) {}
        for (;;)
        {
          paramObject = paramObject.getSharedPreferences(str, i).getString("currentThemeId_6.3.5", "1000");
          if ((!"1103".equals(paramObject)) && (!"2920".equals(paramObject))) {
            break;
          }
          return Boolean.valueOf(true);
          i = 0;
        }
      }
      return Boolean.valueOf(false);
    case 3: 
      paramObject = BaseApplicationImpl.getApplication();
      str = IPluginAdapterProxy.getProxy().currentUin;
      if (!TextUtils.isEmpty(str))
      {
        if (Build.VERSION.SDK_INT > 10) {}
        for (;;)
        {
          paramObject = paramObject.getSharedPreferences(str, i).getString("currentThemeId_6.3.5", "1000");
          if ((!"1000".equals(paramObject)) && (!"999".equals(paramObject))) {
            break;
          }
          return Boolean.valueOf(true);
          i = 0;
        }
      }
      return Boolean.valueOf(false);
    case 2: 
      return ThreadManager.getSubThreadLooper();
    case 4: 
      if (fS((String)paramObject) > 1) {
        bool = true;
      }
      return Boolean.valueOf(bool);
    }
    return Integer.valueOf(ImmersiveUtils.isSupporImmersive());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     avgc
 * JD-Core Version:    0.7.0.1
 */