import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class acej
{
  private static final String[] ec = { "com.tencent.tim:tool", "com.tencent.tim:picture", "com.tencent.tim:qqreader", "com.tencent.tim:story", "com.tencent.tim:troopmanage", "com.tencent.tim:qzone", "com.tencent.tim:qwallet", "com.tencent.tim:qqwifi", "com.tencent.tim:qqfav", "com.tencent.tim:dingdong", "com.tencent.tim:buscard", "com.tencent.tim:qqhotspot", "com.tencent.tim" };
  private static final String[] ed;
  private static final String[] ee = { "vivo Y13", "vivo X3t", "vivo Y11i T", "MI-ONE Plus", "vivoY11iT", "Coolpad 7270", "Coolpad 8122", "Lenovo A708T", "Lenovo S820", "Lenovo S898t", "GT-I9050", "GT-S7568", "DOOV S2y", "TCL J928", "vivo Y22", "ChanghongZ8t", "HUAWEI Y516-T00", "Lenovo A678t", "K-Touch T60", "vivo X710L", "HM MOTE 1TD", "Redmi 3" };
  private static final String[][] f;
  public static DisplayMetrics k = new DisplayMetrics();
  public static DisplayMetrics l = new DisplayMetrics();
  private static float sP = 16.0F;
  
  static
  {
    ed = new String[] { "com.tencent.tim:qqreader", "com.tencent.tim:photoplus", "com.tencent.tim:video", "com.tencent.tim:mini_internal", "com.tencent.tim:mini", "com.tencent.tim:mini1", "com.tencent.tim:mini2", "com.tencent.tim:mini3", "com.tencent.tim:mini4", "com.tencent.tim:mini5", "com.tencent.tim:mini6", "com.tencent.tim:mini7" };
    f = new String[][] { { "OPPO", "PHILIPS", "KONKA", "Sony", "Meitu", "GiONEE", "GiONEE", "GiONEE", "GiONEE", "alps", "Xiaomi", "Xiaomi", "Xiaomi", "Huawei", "BBK", "LGE" }, { "R815T", "W6500", "K5", "S39h", "MK150", "GN137", "GN705T", "GN708T", "E3T", "K5", "Mi-4c", "MI 4S", "MI NOTE Pro", "Nexus 6P", "vivo X3S W", "Nexus 5X" } };
  }
  
  public static boolean ZT()
  {
    Object localObject = aqgz.BY();
    String str = aqgz.getDeviceModel();
    if (QLog.isColorLevel()) {
      QLog.d("FontSettingManager", 2, "current machine brandName:" + (String)localObject + ", modelName:" + str);
    }
    int i = f[0].length - 1;
    while (i >= 0)
    {
      if ((((String)localObject).equals(f[0][i])) && (str.equals(f[1][i]))) {
        return false;
      }
      i -= 1;
    }
    localObject = ee;
    int j = localObject.length;
    i = 0;
    for (;;)
    {
      if (i >= j) {
        break label129;
      }
      if (str.equals(localObject[i])) {
        break;
      }
      i += 1;
    }
    label129:
    return true;
  }
  
  public static boolean ZU()
  {
    String str1 = aqgz.BY();
    String str2 = aqgz.getDeviceModel();
    if (QLog.isColorLevel()) {
      QLog.d("FontSettingManager", 2, "current machine brandName:" + str1 + ", modelName:" + str2);
    }
    return ((!str1.equals("Xiaomi")) || (!str2.equals("MI 4S"))) && ((!str1.equals("Huawei")) || (!str2.equals("Nexus 6P"))) && ((!str1.equals("BBK")) || (!str2.equals("vivo X3S W"))) && ((!str1.equals("LGE")) || (!str2.equals("Nexus 5X"))) && (!str2.equals("Redmi 3"));
  }
  
  public static boolean a(Context paramContext, float paramFloat, boolean paramBoolean)
  {
    if (!j(paramFloat)) {
      if (QLog.isColorLevel()) {
        QLog.d("FontSettingManager", 2, "wrong scale vale : " + paramFloat);
      }
    }
    do
    {
      DisplayMetrics localDisplayMetrics;
      do
      {
        return false;
        float f1 = paramFloat / 16.0F;
        localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
        b(localDisplayMetrics);
        localDisplayMetrics.density = (k.density * f1);
        localDisplayMetrics.scaledDensity = (k.density * f1);
        localDisplayMetrics.densityDpi = ((int)(f1 * k.densityDpi));
        QLog.d("FontSettingManager", 1, new Object[] { "currentDm: ", Float.valueOf(localDisplayMetrics.density), ", ", Float.valueOf(localDisplayMetrics.scaledDensity), ", ", Integer.valueOf(localDisplayMetrics.densityDpi) });
      } while (!paramBoolean);
      l.setTo(localDisplayMetrics);
    } while (sP == paramFloat);
    sP = paramFloat;
    b(paramContext, paramFloat);
    return true;
  }
  
  public static float aV()
  {
    return sP;
  }
  
  private static void b(Context paramContext, float paramFloat)
  {
    if (paramContext == null) {
      return;
    }
    aczz.save(paramContext, "key_font_level", String.valueOf(paramFloat));
  }
  
  private static void b(DisplayMetrics paramDisplayMetrics)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setTo(paramDisplayMetrics);
    localDisplayMetrics.density = k.density;
    localDisplayMetrics.scaledDensity = k.scaledDensity;
    localDisplayMetrics.densityDpi = k.densityDpi;
    if (QLog.isColorLevel())
    {
      QLog.d("FontSettingManager", 2, "systemMetrics.density : " + k.density);
      QLog.d("FontSettingManager", 2, "systemMetrics.scaledDensity : " + k.scaledDensity);
      QLog.d("FontSettingManager", 2, "systemMetrics.densityDpi : " + k.densityDpi);
    }
    k = localDisplayMetrics;
  }
  
  private static boolean bb(Context paramContext)
  {
    paramContext = BaseApplicationImpl.processName;
    String[] arrayOfString = ed;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(paramContext)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static void c(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    Resources localResources = paramContext.getResources();
    if ((localResources != null) && ((Math.abs(l.density - localResources.getDisplayMetrics().density) > 0.01F) || (Math.abs(l.scaledDensity - localResources.getDisplayMetrics().scaledDensity) > 0.01F) || (l.densityDpi != localResources.getDisplayMetrics().densityDpi)))
    {
      k.setTo(localResources.getDisplayMetrics());
      if (QLog.isColorLevel()) {
        QLog.i("FontSettingManager", 2, "current density: " + k.density + ", custom density: " + l.density);
      }
      d(paramContext, paramBoolean1, paramBoolean2);
    }
  }
  
  public static void cIt()
  {
    String[] arrayOfString = ec;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      killProcess(BaseApplicationImpl.getContext(), str);
      i += 1;
    }
  }
  
  public static void d(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!bb(paramContext))
    {
      l.setTo(paramContext.getResources().getDisplayMetrics());
      return;
    }
    if (paramBoolean1) {}
    for (float f1 = sP;; f1 = f(paramContext))
    {
      a(paramContext, f1, paramBoolean2);
      return;
    }
  }
  
  public static void dK(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    paramContext.density = l.density;
    paramContext.scaledDensity = l.density;
    paramContext.densityDpi = l.densityDpi;
  }
  
  public static void dL(Context paramContext)
  {
    if (paramContext.getResources().getDisplayMetrics().density != k.density) {
      a(paramContext, 16.0F, true);
    }
  }
  
  private static float f(Context paramContext)
  {
    if (paramContext == null) {
      return -1000.0F;
    }
    float f2 = Float.valueOf(aczz.h(paramContext, "key_font_level", String.valueOf(16.0F))).floatValue();
    float f1;
    if (f2 >= 13.92F)
    {
      f1 = f2;
      if (f2 <= 18.0F) {}
    }
    else
    {
      f1 = 16.0F;
    }
    sP = f1;
    return sP;
  }
  
  private static boolean j(float paramFloat)
  {
    return (paramFloat > 13.82F) && (paramFloat < 18.1F);
  }
  
  private static boolean killProcess(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.processName.equals(paramString))
      {
        Process.killProcess(localRunningAppProcessInfo.pid);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acej
 * JD-Core Version:    0.7.0.1
 */