import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.debug.DebugMemoryMgr;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

public class fnp
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean;
  
  public fnp(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    if (DebugMemoryMgr.a() == null)
    {
      DebugMemoryMgr.a(new ArrayList());
      DebugMemoryMgr.a().add("com.android.browser");
      DebugMemoryMgr.a().add("com.android.email");
      DebugMemoryMgr.a().add("com.sec.android.app.readershub");
    }
    if (DebugMemoryMgr.b() == null)
    {
      DebugMemoryMgr.b(new ArrayList());
      paramQQAppInterface = Pattern.compile("^com.*.android.*");
      DebugMemoryMgr.b().add(paramQQAppInterface);
    }
    if (DebugMemoryMgr.c() == null)
    {
      DebugMemoryMgr.c(new ArrayList());
      DebugMemoryMgr.c().add("system");
      DebugMemoryMgr.c().add("com.android.");
      DebugMemoryMgr.c().add("com.google.process.");
      DebugMemoryMgr.c().add("android.process.");
    }
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramString.startsWith("com.tencent.mobileqqi"))
    {
      bool1 = true;
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      if (i >= DebugMemoryMgr.a().size()) {
        break label56;
      }
      bool1 = bool2;
      if (paramString.equals(DebugMemoryMgr.a().get(i))) {
        break;
      }
      i += 1;
    }
    label56:
    i = 0;
    while (i < DebugMemoryMgr.b().size())
    {
      if (((Pattern)DebugMemoryMgr.b().get(i)).matcher(paramString).find()) {
        return true;
      }
      i += 1;
    }
    i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= DebugMemoryMgr.c().size()) {
        break;
      }
      if (paramString.startsWith((String)DebugMemoryMgr.c().get(i))) {
        return true;
      }
      i += 1;
    }
  }
  
  @SuppressLint({"NewApi"})
  public void run()
  {
    boolean bool1;
    int i;
    long l1;
    Object localObject4;
    label484:
    Object localObject1;
    label507:
    boolean bool2;
    label745:
    long l2;
    for (;;)
    {
      try
      {
        bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.h;
        if (bool1) {
          return;
        }
        i = this.jdField_a_of_type_Int;
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
        QLog.e("Q.Memory.DebugMemoryMgr", 2, "AlertMemoryRunner exception, actionType=" + this.jdField_a_of_type_Int, localThrowable);
        localThrowable.printStackTrace();
        return;
        l1 = DeviceInfoUtil.d();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.Memory.DebugMemoryMgr", 2, "clear memory, availMemSize=" + l1 / 1048576L + "M");
        if (l1 < 41943040L) {
          continue;
        }
        return;
        ArrayList localArrayList1 = new ArrayList();
        ??? = ((ActivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("activity")).getRunningAppProcesses().iterator();
        if (!((Iterator)???).hasNext()) {
          break label484;
        }
        localObject4 = (ActivityManager.RunningAppProcessInfo)((Iterator)???).next();
        String str2 = ((ActivityManager.RunningAppProcessInfo)localObject4).processName;
        if ((((ActivityManager.RunningAppProcessInfo)localObject4).importance == 100) || ((((ActivityManager.RunningAppProcessInfo)localObject4).importance == 200) && ((((ActivityManager.RunningAppProcessInfo)localObject4).importance != 200) || (((ActivityManager.RunningAppProcessInfo)localObject4).importanceReasonCode == 0))) || (a(str2))) {
          continue;
        }
        localArrayList1.add(Pair.create(str2, Long.valueOf(DeviceInfoUtil.a(((ActivityManager.RunningAppProcessInfo)localObject4).pid))));
        continue;
      }
      finally
      {
        DebugMemoryMgr.a(false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
        this.jdField_a_of_type_AndroidContentContext = null;
      }
      l1 = DeviceInfoUtil.d();
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.DebugMemoryMgr", 2, "check memory, availMemSize=" + l1 / 1048576L + "M");
      }
      if (l1 > 41943040L)
      {
        DebugMemoryMgr.a(false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
        this.jdField_a_of_type_AndroidContentContext = null;
        return;
      }
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, NotificationActivity.class);
      localIntent.putExtra("type", 10);
      localIntent.setFlags(872415232);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      continue;
      localObject1 = Utils.a(localArrayList2);
      ??? = (ActivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("activity");
      i = 0;
      if ((i < ((ArrayList)localObject1).size()) && (i < 5))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.Memory.DebugMemoryMgr", 2, "kill Processes, name=" + (String)((Pair)((ArrayList)localObject1).get(i)).first + ", memSize=" + ((Long)((Pair)((ArrayList)localObject1).get(i)).second).longValue() / 1048576L + "M");
        }
        localObject4 = (String)((Pair)((ArrayList)localObject1).get(i)).first;
        if (Build.VERSION.SDK_INT <= 7)
        {
          ((ActivityManager)???).restartPackage((String)localObject4);
          break label2042;
        }
        ((ActivityManager)???).killBackgroundProcesses((String)localObject4);
        break label2042;
        l1 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("Q.Memory.DebugMemoryMgr", 2, "check memory leak begin...,  isReleased=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.h + ", topActivity=" + BaseActivity.a.getClass().getSimpleName());
        }
        if (DebugMemoryMgr.b() == null) {
          DebugMemoryMgr.a(new ArrayList());
        }
        i = 0;
        bool2 = false;
        localObject4 = new StringBuilder();
        localObject1 = AppRuntime.getAccountList();
        ??? = localObject1;
        if (i < 100)
        {
          ??? = localObject1;
          if (localObject1 != null)
          {
            ??? = localObject1;
            if (((ArrayList)localObject1).size() > 1)
            {
              ??? = localObject1;
              if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.h)
              {
                System.gc();
                Thread.sleep(500L);
                System.gc();
                localObject1 = AppRuntime.getAccountList();
                ??? = localObject1;
                if (localObject1 != null)
                {
                  if (!DebugMemoryMgr.b().contains(((ArrayList)localObject1).toString())) {
                    break;
                  }
                  ??? = localObject1;
                }
              }
            }
          }
        }
        bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.h;
        if (bool1)
        {
          DebugMemoryMgr.a(false);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
          this.jdField_a_of_type_AndroidContentContext = null;
          return;
        }
        bool1 = bool2;
        if (??? != null)
        {
          bool1 = bool2;
          if (((ArrayList)???).size() > 1)
          {
            localObject1 = ((ArrayList)???).toString();
            bool1 = bool2;
            if (!DebugMemoryMgr.b().contains(localObject1))
            {
              bool1 = true;
              ((StringBuilder)localObject4).append("帐号泄露(内测)：").append((String)localObject1);
              DebugMemoryMgr.b().add(localObject1);
            }
          }
        }
        bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.h;
        if (bool2)
        {
          DebugMemoryMgr.a(false);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
          this.jdField_a_of_type_AndroidContentContext = null;
          return;
        }
        if ((bool1) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.h))
        {
          localObject1 = new Intent(BaseActivity.a, NotificationActivity.class);
          ((Intent)localObject1).putExtra("type", 11);
          ((Intent)localObject1).putExtra("title", "内存泄露告警(内测)");
          ((Intent)localObject1).putExtra("msg", ((StringBuilder)localObject4).toString() + "\n存在内存泄露，请及时反馈。");
          localObject4 = new Bundle();
          ((Bundle)localObject4).putString("lButton", "取消");
          ((Bundle)localObject4).putString("rButton", "导出内存");
          ((Bundle)localObject4).putString("checkMsg", "选中:发送文件; 不选:保存本地");
          ((Bundle)localObject4).putString("fileMsg", "文件路径:/sdcard/Tencent/MobileQQ/log/");
          ((Intent)localObject1).putExtras((Bundle)localObject4);
          ((Intent)localObject1).setFlags(872415232);
          BaseActivity.a.startActivity((Intent)localObject1);
        }
        l2 = System.currentTimeMillis();
        localObject1 = "check memory leak, isMemoryLeak=" + bool1 + ", isReleased=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.h + ", leakedActivity=" + DebugMemoryMgr.b().toString() + ", topActivity=" + BaseActivity.a.getClass().getSimpleName() + ", accountList=" + ((ArrayList)???).toString() + ", costTime=" + (l2 - l1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.Memory.DebugMemoryMgr", 2, (String)localObject1);
        }
        if ((bool1) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.h)) {
          ReportLog.a("Q.Memory.DebugMemoryMgr", (String)localObject1, true);
        }
      }
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.h) && ((BaseActivity.a instanceof NotificationActivity)) && (i < 20))
      {
        Thread.sleep(100L);
        i += 1;
      }
      else
      {
        bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.h;
        if (bool1)
        {
          DebugMemoryMgr.a(false);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
          this.jdField_a_of_type_AndroidContentContext = null;
          return;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          ReportLog.a(BaseActivity.a, "mobileqq_leak_send");
          break;
        }
        ReportLog.a(BaseActivity.a, "mobileqq_leak");
        break;
        l1 = System.currentTimeMillis();
        if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (BaseActivity.a != null)) {
          QLog.d("Q.Memory.DebugMemoryMgr", 2, "new check memory leak begin...,  isReleased=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.h + ", topActivity=" + BaseActivity.a.getClass().getSimpleName());
        }
        localObject1 = new ArrayList();
        bool1 = false;
        if (DebugMemoryMgr.a.size() > 0) {}
        for (;;)
        {
          int j;
          synchronized (DebugMemoryMgr.a)
          {
            localObject4 = (Pair)DebugMemoryMgr.a.remove(0);
            l2 = System.currentTimeMillis();
            if (localObject4 == null) {
              break label2018;
            }
            ??? = (WeakReference)((Pair)localObject4).first;
            localObject4 = (String)((Pair)localObject4).second;
            i = 0;
            if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.h)) {
              break label2029;
            }
            j = i + 1;
            if (i >= 30) {
              break label2021;
            }
            if (((WeakReference)???).get() == null)
            {
              DebugMemoryMgr.a((String)localObject4);
              bool2 = false;
              i = j;
              long l3 = System.currentTimeMillis();
              if (QLog.isColorLevel()) {
                QLog.d("Q.Memory.DebugMemoryMgr", 2, "new check memory leak ,  count=" + i + ", leakFlag=" + bool2 + ", app.isReleased=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.h + ",activityName=" + (String)localObject4 + ", costTime=" + (l3 - l2));
              }
              if (!bool2) {
                break label2018;
              }
              ((List)localObject1).add(localObject4);
              bool1 = true;
            }
          }
          System.gc();
          Thread.sleep(500L);
          System.gc();
          i = j;
          continue;
          DebugMemoryMgr.a(false);
          if ((!bool1) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.h) || (BaseActivity.a == null)) {
            break;
          }
          ??? = new Intent(BaseActivity.a, NotificationActivity.class);
          ((Intent)???).putExtra("type", 11);
          ((Intent)???).putExtra("title", "内存泄露告警(内测)");
          ((Intent)???).putExtra("msg", localObject2.toString() + "\n存在内存泄露，请及时反馈。");
          localObject4 = new Bundle();
          ((Bundle)localObject4).putString("lButton", "取消");
          ((Bundle)localObject4).putString("rButton", "导出内存");
          ((Bundle)localObject4).putString("checkMsg", "选中:发送文件; 不选:保存本地");
          ((Bundle)localObject4).putString("fileMsg", "文件路径:/sdcard/Tencent/MobileQQ/log/");
          ((Intent)???).putExtras((Bundle)localObject4);
          localObject4 = localObject2.iterator();
          while (((Iterator)localObject4).hasNext()) {
            DebugMemoryMgr.a((String)((Iterator)localObject4).next());
          }
          ((Intent)???).setFlags(872415232);
          BaseActivity.a.startActivity((Intent)???);
          l2 = System.currentTimeMillis();
          String str1 = "new check memory leak, isMemoryLeak=" + bool1 + ", isReleased=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.h + ", leakedActivity=" + localObject2.toString() + ", topActivity=" + BaseActivity.a.getClass().getSimpleName() + ", costTime=" + (l2 - l1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.Memory.DebugMemoryMgr", 2, str1);
          }
          ReportLog.a("Q.Memory.DebugMemoryMgr", str1, true);
          break;
          label2018:
          continue;
          label2021:
          i = j;
          bool2 = true;
          continue;
          label2029:
          bool2 = true;
        }
        i += 1;
        break label745;
        label2042:
        i += 1;
        break label507;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fnp
 * JD-Core Version:    0.7.0.1
 */