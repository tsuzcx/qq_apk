import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.debug.DebugMemoryMgr;
import com.tencent.mobileqq.log.ReportLogHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.DumpMemInfoHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class dej
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean;
  
  public dej(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  @SuppressLint({"NewApi"})
  public void run()
  {
    boolean bool1;
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.i;
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
      for (;;)
      {
        Object localObject1;
        if (QLog.isColorLevel())
        {
          QLog.e("Q.Memory.DebugMemoryMgr", 2, "AlertMemoryRunner exception, actionType=" + this.jdField_a_of_type_Int, localThrowable);
          localThrowable.printStackTrace();
        }
        return;
        localIntent = new Intent(BaseActivity.sTopActivity, NotificationActivity.class);
        localIntent.putExtra("type", 11);
        localIntent.putExtra("title", "内存泄露告警(内测)");
        localIntent.putExtra("msg", ((StringBuilder)???).toString() + "\n存在内存泄露，请及时反馈。");
        ??? = new Bundle();
        ((Bundle)???).putString("lButton", "取消");
        ((Bundle)???).putString("rButton", "导出内存");
        ((Bundle)???).putString("checkMsg", "选中:发送文件; 不选:保存本地");
        ((Bundle)???).putString("fileMsg", "文件路径:/sdcard/Tencent/QQLite/log/");
        localIntent.putExtras((Bundle)???);
        localIntent.setFlags(872415232);
        BaseActivity.sTopActivity.startActivity(localIntent);
      }
    }
    finally
    {
      DebugMemoryMgr.a(false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      this.jdField_a_of_type_AndroidContentContext = null;
    }
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.Memory.DebugMemoryMgr", 2, "check memory leak begin...,  isReleased=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.i + ", topActivity=" + DebugMemoryMgr.a(BaseActivity.sTopActivity));
    }
    if (DebugMemoryMgr.b() == null) {
      DebugMemoryMgr.a(new ArrayList());
    }
    int i = 0;
    boolean bool2 = false;
    ??? = new StringBuilder();
    localObject1 = AppRuntime.getAccountList();
    for (;;)
    {
      Object localObject4 = localObject1;
      if (i < 100)
      {
        localObject4 = localObject1;
        if (localObject1 != null)
        {
          localObject4 = localObject1;
          if (((ArrayList)localObject1).size() > 1)
          {
            localObject4 = localObject1;
            if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.i)
            {
              System.gc();
              Thread.sleep(500L);
              System.gc();
              localObject1 = AppRuntime.getAccountList();
              localObject4 = localObject1;
              if (localObject1 != null)
              {
                if (!DebugMemoryMgr.b().contains(((ArrayList)localObject1).toString())) {
                  break label1653;
                }
                localObject4 = localObject1;
              }
            }
          }
        }
      }
      bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.i;
      if (bool1)
      {
        DebugMemoryMgr.a(false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
        this.jdField_a_of_type_AndroidContentContext = null;
        return;
      }
      bool1 = bool2;
      if (localObject4 != null)
      {
        bool1 = bool2;
        if (((ArrayList)localObject4).size() > 1)
        {
          localObject1 = ((ArrayList)localObject4).toString();
          bool1 = bool2;
          if (!DebugMemoryMgr.b().contains(localObject1))
          {
            bool1 = true;
            ((StringBuilder)???).append("帐号泄露(内测)：").append((String)localObject1);
            DebugMemoryMgr.b().add(localObject1);
          }
        }
      }
      bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.i;
      if (bool2)
      {
        DebugMemoryMgr.a(false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
        this.jdField_a_of_type_AndroidContentContext = null;
        return;
      }
      if ((bool1) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.i))
      {
        if (!AppSetting.k) {
          break label633;
        }
        localObject1 = DumpMemInfoHandler.a("mobileqq_leak");
        if (QLog.isColorLevel()) {
          QLog.d("Q.Memory.DebugMemoryMgr", 2, "memleak app acount dumpPath=" + (String)localObject1);
        }
      }
      long l2 = System.currentTimeMillis();
      localObject1 = "check memory leak, isMemoryLeak=" + bool1 + ", isReleased=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.i + ", leakedActivity=" + DebugMemoryMgr.b().toString() + ", topActivity=" + DebugMemoryMgr.a(BaseActivity.sTopActivity) + ", accountList=" + ((ArrayList)localObject4).toString() + ", costTime=" + (l2 - l1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.DebugMemoryMgr", 2, (String)localObject1);
      }
      if ((!bool1) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.i)) {
        break;
      }
      ReportLogHelper.a("Q.Memory.DebugMemoryMgr", (String)localObject1, true);
      break;
      label633:
      Intent localIntent;
      i = 0;
      while ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.i) && ((BaseActivity.sTopActivity instanceof NotificationActivity)) && (i < 20))
      {
        Thread.sleep(100L);
        i += 1;
      }
      bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.i;
      if (bool1)
      {
        DebugMemoryMgr.a(false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
        this.jdField_a_of_type_AndroidContentContext = null;
        return;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        ReportLogHelper.a(BaseActivity.sTopActivity, "mobileqq_leak_send");
        break;
      }
      ReportLogHelper.a(BaseActivity.sTopActivity, "mobileqq_leak");
      break;
      l1 = System.currentTimeMillis();
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (BaseActivity.sTopActivity != null)) {
        QLog.d("Q.Memory.DebugMemoryMgr", 2, "new check memory leak begin...,  isReleased=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.i + ", topActivity=" + DebugMemoryMgr.a(BaseActivity.sTopActivity));
      }
      ArrayList localArrayList = new ArrayList();
      localObject4 = new ArrayList();
      bool1 = false;
      if (DebugMemoryMgr.a.size() > 0) {}
      for (;;)
      {
        Object localObject6;
        synchronized (DebugMemoryMgr.a)
        {
          localObject6 = (Pair)DebugMemoryMgr.a.remove(0);
          l2 = System.currentTimeMillis();
          if (localObject6 == null) {
            break label1636;
          }
          ??? = (WeakReference)((Pair)localObject6).first;
          localObject6 = (String)((Pair)localObject6).second;
          i = 0;
          if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.i)) {
            break label1645;
          }
          j = i + 1;
          if (i >= 100) {
            break label1639;
          }
          if (((WeakReference)???).get() == null)
          {
            bool2 = false;
            DebugMemoryMgr.a((String)localObject6);
            long l3 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.d("Q.Memory.DebugMemoryMgr", 2, "new check memory leak ,  count=" + j + ", leakFlag=" + bool2 + ", app.isReleased=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.i + ",activityName=" + (String)localObject6 + ", costTime=" + (l3 - l2));
            }
            if (!bool2) {
              break label1636;
            }
            localArrayList.add(localObject6);
            if (((WeakReference)???).get() != null) {
              ((List)localObject4).add(((WeakReference)???).get());
            }
            bool1 = true;
          }
        }
        System.gc();
        Thread.sleep(500L);
        System.gc();
        i = j;
        continue;
        DebugMemoryMgr.a(false);
        if ((bool1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.i) && (BaseActivity.sTopActivity != null))
        {
          if (AppSetting.k)
          {
            ??? = DumpMemInfoHandler.a("mobileqq_leak");
            if (QLog.isColorLevel()) {
              QLog.d("Q.Memory.DebugMemoryMgr", 2, "memleak activity dumpPath=" + (String)???);
            }
          }
          for (;;)
          {
            localObject4 = ((List)localObject4).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              DebugMemoryMgr.a((BaseActivity)((Iterator)localObject4).next());
              System.gc();
            }
            ??? = new Intent(BaseActivity.sTopActivity, NotificationActivity.class);
            ((Intent)???).putExtra("type", 11);
            ((Intent)???).putExtra("title", "内存泄露告警(内测)");
            ((Intent)???).putExtra("msg", localObject3.toString() + "\n存在内存泄露，请及时反馈。");
            localObject6 = new Bundle();
            ((Bundle)localObject6).putString("lButton", "取消");
            ((Bundle)localObject6).putString("rButton", "导出内存");
            ((Bundle)localObject6).putString("checkMsg", "选中:发送文件; 不选:保存本地");
            ((Bundle)localObject6).putString("fileMsg", "文件路径:/sdcard/Tencent/QQLite/log/");
            ((Intent)???).putExtras((Bundle)localObject6);
            ((Intent)???).setFlags(872415232);
            BaseActivity.sTopActivity.startActivity((Intent)???);
          }
          localObject4 = localObject3.iterator();
          while (((Iterator)localObject4).hasNext()) {
            DebugMemoryMgr.a((String)((Iterator)localObject4).next());
          }
        }
        l2 = System.currentTimeMillis();
        String str = "new check memory leak, isMemoryLeak=" + bool1 + ", isReleased=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.i + ", leakedActivity=" + localObject3.toString() + ", topActivity=" + DebugMemoryMgr.a(BaseActivity.sTopActivity) + ", costTime=" + (l2 - l1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.Memory.DebugMemoryMgr", 2, str);
        }
        ReportLogHelper.a("Q.Memory.DebugMemoryMgr", str, true);
        break;
        label1636:
        continue;
        label1639:
        bool2 = true;
        continue;
        label1645:
        bool2 = true;
        int j = i;
      }
      label1653:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dej
 * JD-Core Version:    0.7.0.1
 */