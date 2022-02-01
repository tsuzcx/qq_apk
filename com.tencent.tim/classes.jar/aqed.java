import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.widget.TextView;
import com.tencent.mobileqq.activity.KeepAliveGuideActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.KeepAliveGuideUtil.1;
import com.tencent.mobileqq.util.KeepAliveGuideUtil.2;
import com.tencent.mobileqq.util.KeepAliveGuideUtil.3;
import com.tencent.mobileqq.util.KeepAliveGuideUtil.4;
import com.tencent.mobileqq.util.KeepAliveGuideUtil.5;
import com.tencent.mobileqq.util.KeepAliveGuideUtil.6;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class aqed
{
  private static int WHITELIST = 1;
  private static int dYN;
  public static Map<String, String[]> oa = new KeepAliveGuideUtil.1();
  public static Map<String, String[]> ob = new KeepAliveGuideUtil.2();
  private static Map<String, String[]> oc = new KeepAliveGuideUtil.3();
  private static Map<String, String[]> od = new KeepAliveGuideUtil.4();
  private static Map<String, String> oe = new KeepAliveGuideUtil.5();
  private static Map<String, String> of = new KeepAliveGuideUtil.6();
  
  public static String BP()
  {
    String str = (String)of.get(getMobileType());
    if ((str != null) && (!str.equals(""))) {
      return str;
    }
    return "请到手机的系统设置中手动设置允许TIM后台运行";
  }
  
  public static String BQ()
  {
    String str = (String)oe.get(getMobileType());
    if ((str != null) && (!str.equals(""))) {
      return str;
    }
    return "请到手机的系统设置中手动设置允许TIM开机启动";
  }
  
  private static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (paramInt == dYN) {
      if (QLog.isColorLevel()) {
        QLog.d("KeepAliveGuideUtil", 2, "失败，显示自启提示" + (String)oe.get(getMobileType()));
      }
    }
    for (String str = (String)oe.get(getMobileType());; str = (String)of.get(getMobileType()))
    {
      aqju localaqju = new aqju(paramContext, 2131756467);
      localaqju.setContentView(2131559151);
      localaqju.getTitleTextView().setVisibility(8);
      localaqju.setMessage(str);
      localaqju.setPositiveButton(2131695169, new aqef(paramInt, paramContext, paramQQAppInterface));
      localaqju.setCanceledOnTouchOutside(false);
      localaqju.setCancelable(false);
      localaqju.show();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("KeepAliveGuideUtil", 2, "失败，显示白名单提示" + (String)of.get(getMobileType()));
      }
    }
  }
  
  public static boolean aBX()
  {
    return ("HUAWEI".equalsIgnoreCase(getMobileType())) || ("xiaomi".equalsIgnoreCase(getMobileType())) || ("vivo".equalsIgnoreCase(getMobileType())) || ("OPPO".equalsIgnoreCase(getMobileType())) || ("meizu".equalsIgnoreCase(getMobileType())) || ("samsung".equalsIgnoreCase(getMobileType()));
  }
  
  private static void b(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (paramInt == dYN)
    {
      paramQQAppInterface = (String[])oc.get(getMobileType());
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length != 0)) {
        break label54;
      }
      fv(paramContext);
    }
    label180:
    for (;;)
    {
      return;
      paramQQAppInterface = (String[])od.get(getMobileType());
      break;
      label54:
      new Intent().addFlags(268435456);
      int i = 0;
      for (;;)
      {
        for (;;)
        {
          if (i >= paramQQAppInterface.length) {
            break label180;
          }
          try
          {
            ((KeepAliveGuideActivity)paramContext).superStartActivityForResult(paramContext.getPackageManager().getLaunchIntentForPackage(paramQQAppInterface[i]), -1, null);
            if (paramInt != dYN) {
              break;
            }
            return;
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("KeepAliveGuideUtil", 2, "跳转手机管家失败： " + localException.toString());
            }
            if (i == paramQQAppInterface.length - 1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("KeepAliveGuideUtil", 2, "所有策略跳转白名单失败，跳设置页面");
              }
              if (paramInt == dYN) {}
              cm(paramContext, "请前往手机的设置页面手动设置。");
              return;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private static void cm(Context paramContext, String paramString)
  {
    aqju localaqju = new aqju(paramContext, 2131756467);
    localaqju.setContentView(2131559151);
    localaqju.getTitleTextView().setVisibility(8);
    localaqju.setMessage(paramString);
    localaqju.setPositiveButton(2131695169, new aqee(paramContext));
    localaqju.setCanceledOnTouchOutside(false);
    localaqju.setCancelable(false);
    localaqju.show();
  }
  
  public static void e(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("KeepAliveGuideUtil", 2, "品牌: " + getMobileType());
    }
    String[] arrayOfString = (String[])oa.get(getMobileType());
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {
      fv(paramContext);
    }
    label272:
    for (;;)
    {
      return;
      Intent localIntent = new Intent();
      localIntent.addFlags(268435456);
      int i = 0;
      int j = 0;
      for (;;)
      {
        for (;;)
        {
          if (i >= arrayOfString.length) {
            break label272;
          }
          try
          {
            if (QLog.isColorLevel()) {
              QLog.d("KeepAliveGuideUtil", 2, "尝试 " + arrayOfString[i]);
            }
            localIntent.setComponent(ComponentName.unflattenFromString(arrayOfString[i]));
            ((KeepAliveGuideActivity)paramContext).superStartActivityForResult(localIntent, -1, null);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("KeepAliveGuideUtil", 2, "跳白名单成功");
            return;
          }
          catch (Exception localException)
          {
            if ((localException instanceof SecurityException)) {
              j = 1;
            }
            if (QLog.isColorLevel()) {
              QLog.d("KeepAliveGuideUtil", 2, "失败" + (i + 1) + "  " + localException.toString());
            }
            if (i == arrayOfString.length - 1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("KeepAliveGuideUtil", 2, "所有策略跳转白名单失败");
              }
              if (j != 0)
              {
                a(WHITELIST, paramContext, paramQQAppInterface);
                return;
              }
              cm(paramContext, "无法自动跳转到进程白名单页面，请前往手机的相关设置页面手动设置。");
              return;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  public static void f(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("KeepAliveGuideUtil", 2, "品牌: " + getMobileType());
    }
    String[] arrayOfString = (String[])ob.get(getMobileType());
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {
      fv(paramContext);
    }
    label275:
    for (;;)
    {
      return;
      Intent localIntent = new Intent();
      localIntent.addFlags(268435456);
      int i = 0;
      int j = 0;
      for (;;)
      {
        for (;;)
        {
          if (i >= arrayOfString.length) {
            break label275;
          }
          try
          {
            if (QLog.isColorLevel()) {
              QLog.d("KeepAliveGuideUtil", 2, "尝试 " + arrayOfString[i]);
            }
            localIntent.setComponent(ComponentName.unflattenFromString(arrayOfString[i]));
            ((KeepAliveGuideActivity)paramContext).superStartActivityForResult(localIntent, -1, null);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("KeepAliveGuideUtil", 2, "跳自启动成功");
            return;
          }
          catch (Exception localException)
          {
            if ((localException instanceof SecurityException)) {
              j = 1;
            }
            if (QLog.isColorLevel()) {
              QLog.d("KeepAliveGuideUtil", 2, "失败" + (i + 1) + "  " + localException.toString());
            }
            if (i == arrayOfString.length - 1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("KeepAliveGuideUtil", 2, "所有策略跳转自启失败");
              }
              if (j != 0)
              {
                a(dYN, paramContext, paramQQAppInterface);
                return;
              }
              cm(paramContext, "无法自动跳转到自启动管理页面，请前往手机的相关设置页面手动设置。");
              return;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private static void fv(Context paramContext)
  {
    Intent localIntent = new Intent("android.settings.SETTINGS");
    localIntent.addFlags(268435456);
    ((KeepAliveGuideActivity)paramContext).superStartActivityForResult(localIntent, -1, null);
  }
  
  public static String getMobileType()
  {
    return Build.MANUFACTURER;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqed
 * JD-Core Version:    0.7.0.1
 */