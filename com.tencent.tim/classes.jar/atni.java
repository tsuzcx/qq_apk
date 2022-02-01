import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import cooperation.dingdong.DingdongPluginProxyActivity;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;

public class atni
{
  public static String PACKAGE_NAME = "com.dingdong";
  public static int eqA = 1;
  public static int eqy = 3;
  public static int eqz = 2;
  
  public static void K(int paramInt, Intent paramIntent)
  {
    new atnj(paramIntent, paramInt).execute(new Void[] { null, null, null });
  }
  
  public static AppInterface a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      Class localClass1 = Class.forName("com.dingdong.app.DingdongAppInterface");
      if (localClass1 == null) {
        return null;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Class localClass2;
      try
      {
        ClassLoader localClassLoader = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "dingdong_plugin.apk");
        localClass2 = localClassLoader.loadClass("com.dingdong.app.DingdongAppInterface");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
      catch (ClassNotFoundException paramBaseApplicationImpl)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
      do
      {
        return null;
        paramBaseApplicationImpl = localClass2.getDeclaredConstructor(new Class[] { paramBaseApplicationImpl.getClass(), paramString.getClass() }).newInstance(new Object[] { paramBaseApplicationImpl, paramString });
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppInterface)));
      paramBaseApplicationImpl = (AppInterface)paramBaseApplicationImpl;
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
  }
  
  public static boolean a(ArrayList<Long> paramArrayList, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramInt == 1) || (paramLong1 > paramLong3) || (paramArrayList == null) || (paramArrayList.size() == 0))
    {
      bool2 = false;
      return bool2;
    }
    boolean bool2 = false;
    if (paramLong1 > paramLong2) {
      paramLong2 = paramLong1;
    }
    for (;;)
    {
      Calendar localCalendar1 = Calendar.getInstance();
      localCalendar1.setTimeInMillis(paramLong1);
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar2.setTimeInMillis(paramLong2);
      localCalendar2.set(11, localCalendar1.get(11));
      localCalendar2.set(12, localCalendar1.get(12));
      localCalendar2.set(13, localCalendar1.get(13));
      localCalendar2.set(14, localCalendar1.get(14));
      switch (paramInt)
      {
      default: 
        return false;
      case 2: 
        return a(paramArrayList, localCalendar2, paramLong2, paramLong3, 5, 1);
      case 3: 
        localCalendar2.set(7, localCalendar1.get(7));
        return a(paramArrayList, localCalendar2, paramLong2, paramLong3, 5, 7);
      case 4: 
        localCalendar2.set(7, localCalendar1.get(7));
        if ((localCalendar2.getTimeInMillis() - localCalendar1.getTimeInMillis()) / 604800000L % 2L == 1L) {
          localCalendar2.add(5, 7);
        }
        return a(paramArrayList, localCalendar2, paramLong2, paramLong3, 5, 14);
      case 5: 
        localCalendar2.setTimeInMillis(paramLong1);
        return a(paramArrayList, localCalendar2, paramLong2, paramLong3, 2, 1);
      case 7: 
        localCalendar2.setTimeInMillis(paramLong1);
        return a(paramArrayList, localCalendar2, paramLong2, paramLong3, 1, 1);
      }
      boolean bool1;
      if (localCalendar2.get(7) == 7)
      {
        localCalendar2.add(5, 2);
        bool1 = bool2;
      }
      for (;;)
      {
        bool2 = bool1;
        if (localCalendar2.getTimeInMillis() > paramLong3) {
          break;
        }
        if (paramLong2 > localCalendar2.getTimeInMillis())
        {
          if (localCalendar2.get(7) == 6)
          {
            localCalendar2.add(5, 3);
            continue;
            bool1 = bool2;
            if (localCalendar2.get(7) == 1)
            {
              localCalendar2.add(5, 1);
              bool1 = bool2;
            }
          }
          else
          {
            localCalendar2.add(5, 1);
          }
        }
        else
        {
          if (c(paramArrayList, localCalendar2.getTimeInMillis())) {
            bool1 = true;
          }
          if (localCalendar2.get(7) == 6) {
            localCalendar2.add(5, 3);
          } else {
            localCalendar2.add(5, 1);
          }
        }
      }
    }
  }
  
  private static boolean a(ArrayList<Long> paramArrayList, Calendar paramCalendar, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    long l = paramCalendar.getTimeInMillis();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (paramCalendar.getTimeInMillis() <= paramLong2)
      {
        if (paramLong1 > paramCalendar.getTimeInMillis())
        {
          paramCalendar.setTimeInMillis(l);
          i += paramInt2;
          paramCalendar.add(paramInt1, i);
          continue;
        }
        if (c(paramArrayList, paramCalendar.getTimeInMillis())) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      paramCalendar.setTimeInMillis(l);
      i += paramInt2;
      paramCalendar.add(paramInt1, i);
    }
  }
  
  public static boolean aJj()
  {
    return false;
  }
  
  public static void aU(String paramString, int paramInt1, int paramInt2) {}
  
  public static String c(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      switch (paramInt)
      {
      default: 
        paramString1 = aqgv.o((QQAppInterface)localObject, paramString2);
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramString1))
      {
        return paramString2;
        paramString1 = aqgv.h((QQAppInterface)localObject, paramString1, paramString2);
        continue;
        paramString1 = aqgv.k((QQAppInterface)localObject, paramString1, paramString2);
      }
      else
      {
        return paramString1;
        paramString1 = null;
      }
    }
  }
  
  private static boolean c(ArrayList<Long> paramArrayList, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (paramArrayList != null)
    {
      bool1 = bool2;
      if (paramArrayList.size() > 0)
      {
        bool1 = bool2;
        if (paramArrayList.size() % 2 == 0) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramArrayList.size())
      {
        long l3 = ((Long)paramArrayList.get(i)).longValue();
        long l2 = ((Long)paramArrayList.get(i + 1)).longValue();
        long l1 = l2;
        if (l2 == -1L) {
          l1 = 9223372036854775807L;
        }
        if ((l3 <= paramLong) && (paramLong <= l1)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 2;
    }
  }
  
  public static boolean cy(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext()) {
          if ("com.tencent.tim:dingdong".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean cz(Context paramContext)
  {
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      paramContext = paramContext.getApplicationContext().getPackageName();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if ((100 == localRunningAppProcessInfo.importance) && (localRunningAppProcessInfo.processName.startsWith(paramContext))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static void eM(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    if (localSharedPreferences.getLong("schedule_last_fetch_time", 0L) + 86400L < NetConnInfoCenter.getServerTime())
    {
      localSharedPreferences.edit().putLong("schedule_last_fetch_time", NetConnInfoCenter.getServerTime()).commit();
      ((aufy)paramQQAppInterface.getBusinessHandler(183)).aaH(2021);
    }
  }
  
  public static String f(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    Object localObject = Calendar.getInstance();
    if (isSameDay(localCalendar1, localCalendar2)) {
      if ((paramBoolean) && (isSameDay((Calendar)localObject, localCalendar1)))
      {
        localObject = new SimpleDateFormat("HH:mm", Locale.getDefault());
        localStringBuilder.append(((SimpleDateFormat)localObject).format(localCalendar1.getTime()));
        localStringBuilder.append("~");
        localStringBuilder.append(((SimpleDateFormat)localObject).format(localCalendar2.getTime()));
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(new SimpleDateFormat("M月d日 HH:mm", Locale.getDefault()).format(localCalendar1.getTime()));
      localStringBuilder.append("~");
      localStringBuilder.append(new SimpleDateFormat("HH:mm", Locale.getDefault()).format(localCalendar2.getTime()));
      continue;
      if (paramBoolean)
      {
        if (isSameDay((Calendar)localObject, localCalendar1))
        {
          localStringBuilder.append(new SimpleDateFormat("今天 HH:mm", Locale.getDefault()).format(localCalendar1.getTime()));
          localStringBuilder.append("~");
          localStringBuilder.append(new SimpleDateFormat("M月d日 HH:mm", Locale.getDefault()).format(localCalendar2.getTime()));
        }
      }
      else
      {
        localObject = new SimpleDateFormat("M月d日 HH:mm", Locale.getDefault());
        localStringBuilder.append("开始：");
        localStringBuilder.append(((SimpleDateFormat)localObject).format(localCalendar1.getTime()));
        localStringBuilder.append("\r\n结束：");
        localStringBuilder.append(((SimpleDateFormat)localObject).format(localCalendar2.getTime()));
      }
    }
  }
  
  public static void gN(String paramString, int paramInt)
  {
    if (paramInt > 0)
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label56;
      }
    }
    label56:
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      anot.b((QQAppInterface)localObject, "CliOper", "", "", "ScheduleClickReport", paramString, 0, paramInt, 0, "", "", "", "");
      return;
    }
  }
  
  public static boolean isSameDay(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    return (paramCalendar1.get(5) == paramCalendar2.get(5)) && (paramCalendar1.get(2) == paramCalendar2.get(2)) && (paramCalendar1.get(1) == paramCalendar2.get(1));
  }
  
  public static int lb(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 3000;
  }
  
  public static void startPluginActivityForResult(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    if (paramIntent == null) {
      paramIntent = new Intent();
    }
    for (;;)
    {
      DingdongPluginProxyActivity.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramActivity, paramString, paramIntent, paramInt, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atni
 * JD-Core Version:    0.7.0.1
 */