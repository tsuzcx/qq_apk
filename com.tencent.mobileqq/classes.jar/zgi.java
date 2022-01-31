import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Pair;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.MemoryConfigs;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.SortUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zgi
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public zgi(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    if (MemoryManager.a() == null)
    {
      MemoryManager.a(new ArrayList());
      MemoryManager.a().add("com.android.browser");
      MemoryManager.a().add("com.android.email");
      MemoryManager.a().add("com.sec.android.app.readershub");
    }
    if (MemoryManager.b() == null)
    {
      MemoryManager.b(new ArrayList());
      paramQQAppInterface = Pattern.compile("^com.*.android.*");
      MemoryManager.b().add(paramQQAppInterface);
    }
    if (MemoryManager.c() == null)
    {
      MemoryManager.c(new ArrayList());
      MemoryManager.c().add("system");
      MemoryManager.c().add("com.android.");
      MemoryManager.c().add("com.google.process.");
      MemoryManager.c().add("android.process.");
    }
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramString.startsWith("com.tencent.mobileqq"))
    {
      bool1 = true;
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      if (i >= MemoryManager.a().size()) {
        break label56;
      }
      bool1 = bool2;
      if (paramString.equals(MemoryManager.a().get(i))) {
        break;
      }
      i += 1;
    }
    label56:
    i = 0;
    while (i < MemoryManager.b().size())
    {
      if (((Pattern)MemoryManager.b().get(i)).matcher(paramString).find()) {
        return true;
      }
      i += 1;
    }
    i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= MemoryManager.c().size()) {
        break;
      }
      if (paramString.startsWith((String)MemoryManager.c().get(i))) {
        return true;
      }
      i += 1;
    }
  }
  
  @SuppressLint({"NewApi"})
  public void run()
  {
    for (;;)
    {
      long l3;
      try
      {
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.l;
        if (bool) {
          return;
        }
        int i = this.jdField_a_of_type_Int;
        switch (i)
        {
        default: 
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Intent localIntent;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.Memory.MemoryManager", 2, "AlertMemoryRunner exception, actionType=" + this.jdField_a_of_type_Int, localThrowable);
        localThrowable.printStackTrace();
        return;
        l1 = DeviceInfoUtil.f();
        l2 = DeviceInfoUtil.e();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.Memory.MemoryManager", 2, "clear memory, availMemSize=" + l1 / 1048576L + "M, totalMemSize=" + l2 / 1048576L + "M");
        l3 = MemoryConfigs.a().jdField_a_of_type_Int * l2 / 100L;
        if (l1 < l3) {
          continue;
        }
        return;
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("MemoryManagerMemoryStat", 0);
        l4 = ((SharedPreferences)localObject1).getLong("lastClearTime", 0L);
        long l5 = System.currentTimeMillis();
        if (l5 >= l4) {
          continue;
        }
        localObject1 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject1).putLong("lastClearTime", l5);
        ((SharedPreferences.Editor)localObject1).commit();
        return;
        MemoryManager.a().a(l3, l1);
        l4 = l5 - l4;
        l5 = MemoryConfigs.a().jdField_a_of_type_Long;
        if (l4 >= l5) {
          continue;
        }
        return;
        MemoryManager.a().b(l3, l1);
        localObject4 = new ArrayList();
        Iterator localIterator = ((ActivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("activity")).getRunningAppProcesses().iterator();
        if (!localIterator.hasNext()) {
          break label637;
        }
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        String str = localRunningAppProcessInfo.processName;
        if ((localRunningAppProcessInfo.importance == 100) || ((localRunningAppProcessInfo.importance == 200) && ((localRunningAppProcessInfo.importance != 200) || (localRunningAppProcessInfo.importanceReasonCode == 0))) || (a(str))) {
          continue;
        }
        ((ArrayList)localObject4).add(Pair.create(str, Long.valueOf(DeviceInfoUtil.a(localRunningAppProcessInfo.pid))));
        continue;
      }
      finally
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
        this.jdField_a_of_type_AndroidContentContext = null;
      }
      long l1 = DeviceInfoUtil.f();
      long l2 = DeviceInfoUtil.e();
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "check memory, availMemSize=" + l1 / 1048576L + "M, totalMemSize=" + l2 / 1048576L + "M");
      }
      l2 = l2 * MemoryConfigs.a().jdField_a_of_type_Int / 100L;
      if (l1 >= l2)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
        this.jdField_a_of_type_AndroidContentContext = null;
        return;
      }
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, NotificationActivity.class);
      localIntent.putExtra("type", 10);
      localIntent.setFlags(872415232);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      continue;
      long l4;
      label637:
      SortUtils.a((ArrayList)localObject4);
      Object localObject4 = (ActivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("activity");
      Object localObject3 = localObject2.edit();
      ((SharedPreferences.Editor)localObject3).putLong("lastClearTime", System.currentTimeMillis());
      ((SharedPreferences.Editor)localObject3).commit();
      localObject3 = StatisticCollector.a(BaseApplication.getContext());
      localObject4 = new HashMap();
      ((HashMap)localObject4).put("osVersion", Build.VERSION.RELEASE);
      ((HashMap)localObject4).put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
      ((HashMap)localObject4).put("remainMemSize", String.valueOf(l1));
      ((HashMap)localObject4).put("totalMemSize", String.valueOf(l2));
      ((HashMap)localObject4).put("warningMemSize", String.valueOf(l3));
      ((HashMap)localObject4).put("time", String.valueOf(l4 / 60000L));
      ((StatisticCollector)localObject3).a("", "MemoryClear", true, 0L, 0L, (HashMap)localObject4, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zgi
 * JD-Core Version:    0.7.0.1
 */