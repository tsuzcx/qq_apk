import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.QuickLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.debug.DebugActivity;
import com.tencent.mobileqq.debug.DebugMemoryMgr;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class frz
  implements AdapterView.OnItemClickListener
{
  public frz(DebugActivity paramDebugActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool1 = true;
    switch (paramInt)
    {
    case 10: 
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 4: 
    case 9: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
      do
      {
        return;
        DebugActivity.a(this.a);
        return;
        DebugActivity.b(this.a);
        return;
        paramAdapterView = BaseApplicationImpl.a().getSharedPreferences("mobileQQi", 0);
        DebugMemoryMgr.jdField_a_of_type_Boolean = paramAdapterView.getBoolean("monitoringMemory", true);
        if (DebugMemoryMgr.jdField_a_of_type_Boolean)
        {
          DebugMemoryMgr.jdField_a_of_type_Boolean = false;
          DebugActivity.jdField_a_of_type_ArrayOfJavaLangString[2] = "监控内存[OFF]";
        }
        for (;;)
        {
          paramAdapterView.edit().putBoolean("monitoringMemory", DebugMemoryMgr.jdField_a_of_type_Boolean).commit();
          ((BaseAdapter)DebugActivity.a(this.a).getAdapter()).notifyDataSetInvalidated();
          return;
          DebugMemoryMgr.jdField_a_of_type_Boolean = true;
          DebugActivity.jdField_a_of_type_ArrayOfJavaLangString[2] = "监控内存[ON]";
        }
        this.a.b();
        return;
        for (;;)
        {
          try
          {
            if (!DebugActivity.jdField_a_of_type_Boolean)
            {
              this.a.c();
              ((BaseAdapter)DebugActivity.a(this.a).getAdapter()).notifyDataSetInvalidated();
              return;
            }
          }
          catch (Exception paramAdapterView)
          {
            paramAdapterView.printStackTrace();
            return;
          }
          this.a.d();
        }
        paramAdapterView = this.a.getAppRuntime().getApplication().getSharedPreferences("mobileQQi", 0);
        if (paramAdapterView.getBoolean("writeLogFile", true))
        {
          DebugActivity.jdField_a_of_type_ArrayOfJavaLangString[6] = "写日志文件[OFF]";
          QLog.setLogToFile(false);
          paramAdapterView.edit().putBoolean("writeLogFile", false).commit();
        }
        for (;;)
        {
          ((BaseAdapter)DebugActivity.a(this.a).getAdapter()).notifyDataSetInvalidated();
          return;
          DebugActivity.jdField_a_of_type_ArrayOfJavaLangString[6] = "写日志文件[ON]";
          QLog.setLogToFile(true);
          paramAdapterView.edit().putBoolean("writeLogFile", true).commit();
        }
        if (!AppSetting.m)
        {
          AppSetting.m = bool1;
          paramView = DebugActivity.jdField_a_of_type_ArrayOfJavaLangString;
          if (!AppSetting.m) {
            break label473;
          }
        }
        for (paramAdapterView = "C2C删除消息可用";; paramAdapterView = "C2C删除消息不可用")
        {
          paramView[7] = paramAdapterView;
          this.a.getAppRuntime().getApplication().getSharedPreferences("mobileQQi", 0).edit().putBoolean("c2c_del_msg_oper_enable", AppSetting.m).commit();
          ((BaseAdapter)DebugActivity.a(this.a).getAdapter()).notifyDataSetChanged();
          return;
          bool1 = false;
          break;
        }
        if (!SQLiteDatabase.jdField_a_of_type_Boolean)
        {
          bool1 = bool2;
          SQLiteDatabase.a(bool1);
          if (!SQLiteDatabase.jdField_a_of_type_Boolean) {
            break label531;
          }
          DebugActivity.jdField_a_of_type_ArrayOfJavaLangString[8] = "打印数据库操作日志[ON]";
        }
        for (;;)
        {
          ((BaseAdapter)DebugActivity.a(this.a).getAdapter()).notifyDataSetChanged();
          return;
          bool1 = false;
          break;
          DebugActivity.jdField_a_of_type_ArrayOfJavaLangString[8] = "打印数据库操作日志[OFF]";
        }
        Toast.makeText(this.a, "线程监控开关未开启", 1).show();
        return;
        paramAdapterView = BaseApplicationImpl.a().getSharedPreferences("mobileQQi", 0);
        if (AppSetting.n)
        {
          AppSetting.n = false;
          ThreadPriorityManager.a(false);
          paramAdapterView.edit().putBoolean("d_priority", AppSetting.n).commit();
          if (!AppSetting.n) {
            break label640;
          }
          DebugActivity.jdField_a_of_type_ArrayOfJavaLangString[9] = "后台线程优先级控制优化[ON]";
        }
        for (;;)
        {
          ((BaseAdapter)DebugActivity.a(this.a).getAdapter()).notifyDataSetChanged();
          return;
          AppSetting.n = true;
          break;
          DebugActivity.jdField_a_of_type_ArrayOfJavaLangString[9] = "后台线程优先级控制优化[OFF]";
        }
        this.a.a();
        return;
        Toast.makeText(this.a, "请将手Q切后台，5s后自杀轻启动", 0).show();
        BaseApplicationImpl.jdField_a_of_type_AndroidOsHandler.postDelayed(new fsa(this), 5000L);
        return;
        paramAdapterView = BaseApplicationImpl.a().getSharedPreferences("mobileQQi", 0);
        AppSetting.j = paramAdapterView.getBoolean("releaseLargeMemory", false);
        if (AppSetting.j)
        {
          AppSetting.j = false;
          DebugActivity.jdField_a_of_type_ArrayOfJavaLangString[13] = "大内存及时释放[OFF]";
        }
        for (;;)
        {
          BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.setLargeSize(-1);
          paramAdapterView.edit().putBoolean("releaseLargeMemory", AppSetting.j).commit();
          ((BaseAdapter)DebugActivity.a(this.a).getAdapter()).notifyDataSetInvalidated();
          return;
          AppSetting.j = true;
          DebugActivity.jdField_a_of_type_ArrayOfJavaLangString[13] = "大内存及时释放[ON]";
        }
        paramAdapterView = this.a;
        if (!DebugActivity.a(this.a))
        {
          bool1 = bool3;
          DebugActivity.a(paramAdapterView, bool1);
          BaseApplicationImpl.a().getSharedPreferences("mobileQQi", 0).edit().putBoolean("isActionLoginBTraceView", DebugActivity.a(this.a)).commit();
          paramView = DebugActivity.jdField_a_of_type_ArrayOfJavaLangString;
          if (!DebugActivity.a(this.a)) {
            break label897;
          }
        }
        for (paramAdapterView = "旗鱼TraceView[ON]";; paramAdapterView = "旗鱼TraceView[OFF]")
        {
          paramView[14] = paramAdapterView;
          ((BaseAdapter)DebugActivity.a(this.a).getAdapter()).notifyDataSetChanged();
          return;
          bool1 = false;
          break;
        }
      } while (!(this.a.getAppRuntime() instanceof QQAppInterface));
      if (!DownloaderFactory.jdField_a_of_type_Boolean)
      {
        bool1 = bool4;
        DownloaderFactory.jdField_a_of_type_Boolean = bool1;
        paramView = DebugActivity.jdField_a_of_type_ArrayOfJavaLangString;
        if (!DownloaderFactory.jdField_a_of_type_Boolean) {
          break label972;
        }
      }
      for (paramAdapterView = "imgcache ip直连[ON]";; paramAdapterView = "imgcache ip直连[OFF]")
      {
        paramView[15] = paramAdapterView;
        ((BaseAdapter)DebugActivity.a(this.a).getAdapter()).notifyDataSetChanged();
        return;
        bool1 = false;
        break;
      }
    case 16: 
      paramAdapterView = this.a;
      if (!DebugActivity.b(this.a))
      {
        bool1 = bool5;
        DebugActivity.b(paramAdapterView, bool1);
        BaseApplicationImpl.a().getSharedPreferences("mobileQQi", 0).edit().putBoolean("isOpenAIOTraceView", DebugActivity.b(this.a)).commit();
        paramView = DebugActivity.jdField_a_of_type_ArrayOfJavaLangString;
        if (!DebugActivity.b(this.a)) {
          break label1083;
        }
      }
      for (paramAdapterView = "AIOTraceView[ON]";; paramAdapterView = "AIOTraceView[OFF]")
      {
        paramView[16] = paramAdapterView;
        ((BaseAdapter)DebugActivity.a(this.a).getAdapter()).notifyDataSetChanged();
        return;
        bool1 = false;
        break;
      }
    case 17: 
      label473:
      paramAdapterView = new Intent(this.a.getApplication(), QuickLoginActivity.class);
      label531:
      label972:
      this.a.startActivity(paramAdapterView);
      label640:
      label897:
      label1083:
      return;
    }
    if (QQSettingMe.a == 0)
    {
      QQSettingMe.a = 1;
      DebugActivity.jdField_a_of_type_ArrayOfJavaLangString[18] = "抽屉返回模式--返回tab界面";
    }
    for (;;)
    {
      ((BaseAdapter)DebugActivity.a(this.a).getAdapter()).notifyDataSetChanged();
      return;
      QQSettingMe.a = 0;
      DebugActivity.jdField_a_of_type_ArrayOfJavaLangString[18] = "抽屉返回模式--返回抽屉";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     frz
 * JD-Core Version:    0.7.0.1
 */