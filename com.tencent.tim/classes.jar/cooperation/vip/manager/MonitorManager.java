package cooperation.vip.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import awmk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.mobile_monitor_report.ExceptionReport;
import cooperation.vip.pb.mobile_monitor_report.TraceReport;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class MonitorManager
  extends BroadcastReceiver
{
  private static MonitorManager a;
  private long aBl;
  private int eBO;
  private List<mobile_monitor_report.ExceptionReport> fX = new ArrayList();
  private long ib;
  
  MonitorManager()
  {
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.plugin.state.change");
    BaseApplicationImpl.getApplication().registerReceiver(this, (IntentFilter)localObject);
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences("monitor_manager", 4);
    this.eBO = ((SharedPreferences)localObject).getInt("max_size_out", 20);
    this.aBl = (((SharedPreferences)localObject).getLong("max_time_out", 30L) * 60L * 1000L);
  }
  
  private void Xm(boolean paramBoolean)
  {
    if (bQ(paramBoolean))
    {
      this.ib = System.currentTimeMillis();
      eEt();
    }
  }
  
  public static MonitorManager a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new MonitorManager();
      }
      return a;
    }
    finally {}
  }
  
  private boolean bQ(boolean paramBoolean)
  {
    boolean bool = false;
    if (paramBoolean) {
      return true;
    }
    int i;
    if (this.fX.size() > this.eBO)
    {
      i = 1;
      if (System.currentTimeMillis() - this.ib <= this.aBl) {
        break label65;
      }
    }
    label65:
    for (int j = 1;; j = 0)
    {
      if (i == 0)
      {
        paramBoolean = bool;
        if (j == 0) {}
      }
      else
      {
        paramBoolean = true;
      }
      return paramBoolean;
      i = 0;
      break;
    }
  }
  
  private void e(int paramInt1, int paramInt2, String arg3, boolean paramBoolean)
  {
    mobile_monitor_report.ExceptionReport localExceptionReport = new mobile_monitor_report.ExceptionReport();
    localExceptionReport.busi_id.set(paramInt1);
    localExceptionReport.errcode.set(paramInt2);
    String str = ???;
    if (TextUtils.isEmpty(???)) {
      str = "";
    }
    localExceptionReport.msg.set(str);
    synchronized (this.fX)
    {
      this.fX.add(localExceptionReport);
      Xm(paramBoolean);
      return;
    }
  }
  
  private void eEs()
  {
    ThreadManager.getSubThreadHandler().post(new MonitorManager.2(this));
  }
  
  private void eEt()
  {
    if (this.fX.size() <= 0) {
      return;
    }
    ArrayList localArrayList = new ArrayList(this.fX);
    synchronized (this.fX)
    {
      this.fX.clear();
      awmk.ox(localArrayList);
      return;
    }
  }
  
  private void k(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    mobile_monitor_report.TraceReport localTraceReport = new mobile_monitor_report.TraceReport();
    localTraceReport.trace_id.set(String.valueOf(paramInt1));
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "";
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "";
    }
    localTraceReport.msg.set(paramString1);
    localTraceReport.trace_num.set(paramInt2);
    localTraceReport.page_id.set(str);
    paramString1 = new ArrayList();
    paramString1.add(localTraceReport);
    awmk.oy(paramString1);
  }
  
  public void d(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new MonitorManager.1(this, paramInt1, paramInt2, paramString, paramBoolean));
  }
  
  public void j(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MonitorManager", 1, new Object[] { "report trace " + paramInt1, " trace Num " + paramInt2 + " page desc " + paramString1 + " trace Msg " + paramString2 });
    }
    ThreadManager.getSubThreadHandler().post(new MonitorManager.3(this, paramInt1, paramInt2, paramString1, paramString2));
  }
  
  public void lo(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.aBl = paramInt1;
      this.aBl = (paramInt2 * 60 * 60);
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("monitor_manager", 4).edit();
      localEditor.putInt("max_size_out", paramInt1);
      localEditor.putInt("max_time_out", paramInt2);
      localEditor.apply();
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (TextUtils.isEmpty(paramContext)) {}
    while ((!"com.tencent.plugin.state.change".equals(paramContext)) || (paramIntent.getIntExtra("key_plugin_state", 0) != 0)) {
      return;
    }
    QLog.i("MonitorManager", 1, "[onReceive] bg action");
    eEs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.manager.MonitorManager
 * JD-Core Version:    0.7.0.1
 */