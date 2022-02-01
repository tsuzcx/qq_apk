import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.huayang.HuayangOpenHelper.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class aidn
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HuayangOpenHelper", 2, String.format("appType = %s,openType = %s, fromId = %s, uri = %s ，action = %s,pkgName = %s", new Object[] { paramString1, paramString2, paramString4, paramString3, paramString5, paramString6 }));
    }
    aidt.bC(paramQQAppInterface.getApp(), paramString1);
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString6)))
    {
      if (!"slientDownload".equals(paramString5)) {
        break label156;
      }
      aids.Lb("2587808");
      paramString7 = IVPluginInfo.s(paramString7);
      paramString4 = paramString7;
      if (paramString7.size() == 0) {
        paramString4 = IVPluginInfo.ao();
      }
      if (!TextUtils.isEmpty(paramString1)) {
        break label209;
      }
      paramString1 = "hy_sixgod";
    }
    label156:
    label209:
    for (;;)
    {
      ThreadManagerV2.executeOnSubThread(new HuayangOpenHelper.1(paramString1, aidf.a(paramQQAppInterface.getApp(), paramString6, paramString1), paramQQAppInterface, paramString3, paramString5, paramString4));
      go(paramString2, paramString2);
      return;
      if (!"download".equals(paramString5)) {
        break;
      }
      if (aidi.mU(paramString6))
      {
        aids.Lb("2691701");
        break;
      }
      if (aidi.mV(paramString6))
      {
        aids.Lb("2597718");
        break;
      }
      aidt.bD(paramQQAppInterface.getApp(), paramString1);
      break;
    }
  }
  
  public static void bB(Context paramContext, String paramString)
  {
    if (paramString == null) {}
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      return;
      while (!paramContext.hasNext())
      {
        do
        {
          paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        } while ((paramContext == null) || (paramContext.size() == 0));
        paramContext = paramContext.iterator();
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
    } while (!paramString.equals(localRunningAppProcessInfo.processName));
    if (QLog.isColorLevel()) {
      QLog.d("HuayangOpenHelper", 2, "杀死进程：" + paramString);
    }
    Process.killProcess(localRunningAppProcessInfo.pid);
  }
  
  private static void go(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "HyProxy";
    }
    rar.a("huayang", "openHy", 0, 0, new String[] { str, paramString2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aidn
 * JD-Core Version:    0.7.0.1
 */