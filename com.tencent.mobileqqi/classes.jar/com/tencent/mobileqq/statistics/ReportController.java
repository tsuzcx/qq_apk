package com.tencent.mobileqq.statistics;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.servlet.ReportServlet;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import gor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import mqq.app.NewIntent;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.observer.BusinessObserver;

public class ReportController
  implements Handler.Callback, BusinessObserver
{
  private static final int jdField_a_of_type_Int = 40;
  private static final long jdField_a_of_type_Long = 86400000L;
  private static ReportController jdField_a_of_type_ComTencentMobileqqStatisticsReportController;
  public static final String a = "P_CliOper";
  private static final int jdField_b_of_type_Int = 20;
  public static final String b = "CliOper";
  private static final int c = 9527;
  @Deprecated
  public static final String c = "on_off";
  private static final int d = 2;
  public static final String d = "CliStatus";
  public static final String e = "Pb_account_lifeservice";
  public static final String f = "Grp_tribe";
  public static final String g = "BizTechReport";
  private static final String h = "ReportController";
  private static final String i = "pre_report_time";
  private static final String j = "${uin_unknown}";
  private static final String k = "${count_unknown}";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ProxyManager jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private long jdField_b_of_type_Long;
  private int e;
  
  public ReportController(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    try
    {
      paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "ActionReportInterval");
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0)) {
        this.b = (Long.parseLong(paramQQAppInterface) * 1000L);
      }
    }
    catch (Exception paramQQAppInterface)
    {
      label68:
      break label68;
    }
    if (this.b <= 1000L) {
      this.b = 86400000L;
    }
  }
  
  private int a()
  {
    for (;;)
    {
      try
      {
        if (this.e <= 0)
        {
          this.e = (new Random().nextInt(1000000) + 100);
          int m = this.e;
          return m;
        }
        if (this.e >= 1000100) {
          this.e = 100;
        } else {
          this.e += 1;
        }
      }
      finally {}
    }
  }
  
  public static ReportController a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_ComTencentMobileqqStatisticsReportController == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqStatisticsReportController == null) {
        jdField_a_of_type_ComTencentMobileqqStatisticsReportController = new ReportController(paramQQAppInterface);
      }
      return jdField_a_of_type_ComTencentMobileqqStatisticsReportController;
    }
    finally {}
  }
  
  private static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      localStringBuilder.append(paramString1).append('|');
    }
    localStringBuilder.append(paramString2).append('|');
    localStringBuilder.append(paramString3).append('|');
    localStringBuilder.append(paramString4).append('|');
    localStringBuilder.append(paramString5).append('|');
    localStringBuilder.append(paramInt1).append('|');
    localStringBuilder.append("${count_unknown}").append('|');
    localStringBuilder.append(paramInt2).append('|');
    localStringBuilder.append(paramString6).append('|');
    localStringBuilder.append(paramString7).append('|');
    localStringBuilder.append(paramString8).append('|');
    localStringBuilder.append(paramString9).append('|');
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(9527);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "stopReportLooper");
    }
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a();
    }
  }
  
  static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    Object localObject = paramString2;
    if (paramString2.contains("${uin_unknown}")) {
      localObject = paramString2.replace("${uin_unknown}", paramQQAppInterface.a());
    }
    paramString2 = ((String)localObject).replace("${count_unknown}", Integer.toString(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "ReportRuntime: " + paramString1 + ", " + paramString2);
    }
    localObject = new NewIntent(paramQQAppInterface.getApplication(), ReportServlet.class);
    ((NewIntent)localObject).putExtra("sendType", 2);
    ((NewIntent)localObject).putExtra("tag", paramString1);
    ((NewIntent)localObject).putExtra("content", paramString2);
    ((NewIntent)localObject).setWithouLogin(true);
    paramQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if ((paramString2 == null) || (paramString4 == null) || (paramString5 == null)) {
      return;
    }
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = a(paramString2, "${uin_unknown}", paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
      paramString2 = new Intent();
      paramString2.setClass(BaseApplicationImpl.a, ReportReceiver.class);
      paramString2.putExtra("reporting_tag", paramString1);
      paramString2.putExtra("reporting_detail", paramQQAppInterface);
      paramString2.putExtra("reporting_count", paramInt3);
      paramString2.putExtra("is_runtime", 1);
      BaseApplicationImpl.a().sendBroadcast(paramString2);
      return;
    }
    a(paramQQAppInterface, paramString1, a(paramString2, paramQQAppInterface.a(), paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9), paramInt3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, 1, paramString6, paramString7, paramString8, paramString9);
  }
  
  public static void a(PluginRuntime paramPluginRuntime)
  {
    paramPluginRuntime.setClickEventReportor(new gor());
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "addReporting:" + paramString2 + ", " + paramInt);
    }
    String str = paramString1 + ":" + paramString2;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      Reporting localReporting = (Reporting)this.jdField_a_of_type_JavaUtilHashMap.get(str);
      if (localReporting == null)
      {
        localReporting = new Reporting();
        localReporting.mTag = paramString1;
        localReporting.mDetail = paramString2;
        localReporting.mCount = paramInt;
        localReporting.mDetailHashCode = localReporting.mDetail.hashCode();
        this.jdField_a_of_type_JavaUtilHashMap.put(str, localReporting);
        if (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a("", 0, "Reporting", localReporting, 3, null);
        }
      }
      do
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.size() >= 40) {
          b();
        }
        return;
        localReporting.mCount += paramInt;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager == null);
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a("", 0, "Reporting", localReporting.clone(), 4, null);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
      long l = System.currentTimeMillis();
      if (Math.abs(l - localSharedPreferences.getLong("pre_report_time", l)) < this.b) {
        return;
      }
    }
    b();
  }
  
  private boolean a()
  {
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "doReportClickEvent");
    }
    label188:
    label446:
    label461:
    label476:
    label499:
    label510:
    for (;;)
    {
      int n;
      int i1;
      int i2;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        n = this.jdField_a_of_type_JavaUtilHashMap.size();
        ArrayList localArrayList = new ArrayList(20);
        localObject3 = new ArrayList(20);
        int m = a();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        i1 = 0;
        if (localIterator.hasNext())
        {
          localObject4 = (String)localIterator.next();
          localObject4 = (Reporting)this.jdField_a_of_type_JavaUtilHashMap.get(localObject4);
          if ((((Reporting)localObject4).mDetailHashCode != 0) && (((Reporting)localObject4).mDetail.hashCode() != ((Reporting)localObject4).mDetailHashCode))
          {
            localIterator.remove();
            this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a("", 0, "Reporting", (Entity)localObject4, 5, null);
            i2 = n - 1;
            n = i1;
            i1 = i2;
            break label461;
            localObject4 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ReportServlet.class);
            ((NewIntent)localObject4).putExtra("sendType", 10);
            ((NewIntent)localObject4).putExtra("seqKey", m);
            ((NewIntent)localObject4).putExtra("tags", localArrayList);
            ((NewIntent)localObject4).putExtra("retryTime", 0);
            ((NewIntent)localObject4).putExtra("contents", (Serializable)localObject3);
            ((NewIntent)localObject4).setObserver(this);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject4);
            localObject3 = new ArrayList(20);
            localArrayList = new ArrayList(20);
            if (n < i1)
            {
              m = a();
              break label476;
            }
          }
          else
          {
            localArrayList.add(((Reporting)localObject4).mTag);
            String str = ((Reporting)localObject4).mDetail.replace("${count_unknown}", String.valueOf(((Reporting)localObject4).mCount));
            ((ArrayList)localObject3).add(str);
            localIterator.remove();
            this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a("", 0, "Reporting", (Entity)localObject4, 5, null);
            if (!QLog.isColorLevel()) {
              break label499;
            }
            QLog.d("ReportController", 2, "Report: " + ((Reporting)localObject4).mTag + ", " + str + ", " + m);
            break label499;
          }
        }
        else
        {
          return true;
        }
      }
      break label476;
      Object localObject4 = localObject1;
      Object localObject2 = localObject3;
      Object localObject3 = localObject4;
      for (;;)
      {
        if (n % 20 == 0) {
          break label510;
        }
        if (n < i1) {
          break label446;
        }
        break label188;
        localObject4 = localObject3;
        i2 = i1;
        localObject3 = localObject2;
        localObject2 = localObject4;
        i1 = n;
        n = i2;
        break;
        i2 = i1 + 1;
        i1 = n;
        n = i2;
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "startReportLooper");
    }
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      if (paramBoolean) {
        break label37;
      }
    }
    label37:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramQQAppInterface.a(paramBoolean);
      return true;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(9527);
    try
    {
      a();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
      long l = System.currentTimeMillis();
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("pre_report_time", l);
      ((SharedPreferences.Editor)localObject).commit();
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(9527, this.b);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("ReportController", 4, "report exception:" + localException);
        }
      }
    }
  }
  
  static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramString2 != null)
    {
      ReportController localReportController = a(paramQQAppInterface);
      if (localReportController != null)
      {
        String str = paramString2;
        if (paramString2.contains("${uin_unknown}")) {
          str = paramString2.replace("${uin_unknown}", paramQQAppInterface.a());
        }
        localReportController.a(paramString1, str, paramInt);
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if ((paramString2 == null) || (paramString4 == null) || (paramString5 == null)) {
      return;
    }
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = a(paramString2, "${uin_unknown}", paramString3, paramString4, paramString5, paramInt1, paramInt3, paramString6, paramString7, paramString8, paramString9);
      paramString2 = new Intent();
      paramString2.setClass(BaseApplicationImpl.a, ReportReceiver.class);
      paramString2.putExtra("reporting_tag", paramString1);
      paramString2.putExtra("reporting_detail", paramQQAppInterface);
      paramString2.putExtra("reporting_count", paramInt2);
      paramString2.putExtra("is_runtime", 0);
      BaseApplicationImpl.a().sendBroadcast(paramString2);
      return;
    }
    b(paramQQAppInterface, paramString1, a(paramString2, paramQQAppInterface.a(), paramString3, paramString4, paramString5, paramInt1, paramInt3, paramString6, paramString7, paramString8, paramString9), paramInt2);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    b(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, 1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  protected void a(QQAppInterface arg1, ProxyManager paramProxyManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ???;
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager = paramProxyManager;
    paramProxyManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(Reporting.class);
    if (paramProxyManager != null) {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        paramProxyManager = paramProxyManager.iterator();
        if (paramProxyManager.hasNext())
        {
          Reporting localReporting1 = (Reporting)paramProxyManager.next();
          String str = localReporting1.mTag + ":" + localReporting1.mDetail;
          Reporting localReporting2 = (Reporting)this.jdField_a_of_type_JavaUtilHashMap.get(str);
          if (localReporting2 != null)
          {
            int m = localReporting1.mCount;
            localReporting2.mCount += m;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(str, localReporting1);
        }
      }
    }
  }
  
  protected void b(QQAppInterface arg1, ProxyManager paramProxyManager)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 9527) {
      b();
    }
    return true;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 10)
    {
      int m = paramBundle.getInt("seqKey");
      paramInt = 0;
      if (QLog.isColorLevel()) {
        QLog.d("ReportController", 2, "OnReceive: isSuccess-" + paramBoolean + ", seqKey = " + m);
      }
      if (!paramBoolean) {
        paramInt = paramBundle.getInt("retryTime");
      }
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if ((!paramBoolean) && (paramInt < 2) && (localQQAppInterface != null))
      {
        NewIntent localNewIntent = new NewIntent(localQQAppInterface.a(), ReportServlet.class);
        localNewIntent.putExtra("sendType", 10);
        localNewIntent.putExtra("seqKey", m);
        localNewIntent.putExtra("tags", paramBundle.getStringArrayList("tags"));
        localNewIntent.putExtra("contents", paramBundle.getStringArrayList("contents"));
        localNewIntent.putExtra("retryTime", paramInt + 1);
        localNewIntent.setObserver(this);
        localQQAppInterface.startServlet(localNewIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ReportController
 * JD-Core Version:    0.7.0.1
 */