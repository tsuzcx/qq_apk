package com.tencent.mfsdk.reporter;

import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.SparseArray;
import aomi;
import aqul;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.config.Config;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import txc;
import txc.a;
import txe;
import tyt;
import tyv;
import tyw;
import tyx;
import tza;

public class ReporterMachine
{
  private static Queue<String> B = new ConcurrentLinkedQueue();
  private static ReporterMachine jdField_a_of_type_ComTencentMfsdkReporterReporterMachine;
  private static tyv jdField_a_of_type_Tyv;
  private static MqqHandler b;
  private static boolean isStarted;
  private static List<ResultObject> qb = Collections.synchronizedList(new ArrayList());
  private static String uuid = "";
  
  private ReporterMachine()
  {
    if (b == null)
    {
      HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("ReporterMachine", 0);
      localHandlerThread.start();
      b = new MqqHandler(localHandlerThread.getLooper());
      jdField_a_of_type_Tyv = new tyw(localHandlerThread);
    }
    uuid = oG();
  }
  
  public static ReporterMachine a()
  {
    if (jdField_a_of_type_ComTencentMfsdkReporterReporterMachine == null) {}
    try
    {
      jdField_a_of_type_ComTencentMfsdkReporterReporterMachine = new ReporterMachine();
      return jdField_a_of_type_ComTencentMfsdkReporterReporterMachine;
    }
    finally {}
  }
  
  private static void a(ResultObject paramResultObject)
    throws JSONException
  {
    if (txc.bCZ > Config.MAX_REPORT_NUM) {
      return;
    }
    JSONObject localJSONObject = paramResultObject.params.getJSONObject("clientinfo");
    localJSONObject.put("versionname", MagnifierSDK.version);
    localJSONObject.put("uin", String.valueOf(paramResultObject.uin));
    localJSONObject.put("manu", Build.MANUFACTURER);
    localJSONObject.put("model", Build.MODEL);
    localJSONObject.put("os", Build.VERSION.RELEASE);
    localJSONObject.put("rdmuuid", uuid);
    localJSONObject.put("deviceid", tza.a(BaseApplicationImpl.sApplication));
    if (BaseApplicationImpl.sProcessId == 1) {}
    try
    {
      String.valueOf(paramResultObject.params.get("newplugin"));
      jdField_a_of_type_Tyv.a(paramResultObject, new tyx());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("Magnifier_ReporterMachine", 1, "reportAtOnce", localException);
      }
    }
  }
  
  public static void b(ResultObject paramResultObject)
  {
    txe.au(paramResultObject.params);
    if ((true == paramResultObject.isRealTime) && (1 == aomi.a().getNetType())) {
      try
      {
        a(paramResultObject);
        return;
      }
      catch (Exception paramResultObject)
      {
        paramResultObject.printStackTrace();
        return;
      }
    }
    if (b != null)
    {
      paramResultObject = new InsertRunnable(paramResultObject);
      b.post(paramResultObject);
      return;
    }
    qb.add(paramResultObject);
  }
  
  public void bEZ()
  {
    if (!isStarted)
    {
      ReportRunnable localReportRunnable = new ReportRunnable(null);
      getFileRunnable localgetFileRunnable = new getFileRunnable();
      b.postDelayed(localgetFileRunnable, 120000L);
      b.postDelayed(localReportRunnable, 300000L);
      isStarted = true;
    }
  }
  
  public String oG()
  {
    if (!TextUtils.isEmpty(uuid)) {
      return uuid;
    }
    try
    {
      uuid = BaseApplicationImpl.sApplication.getPackageManager().getApplicationInfo(BaseApplicationImpl.sApplication.getPackageName(), 128).metaData.get("com.tencent.qapm.uuid").toString();
      if ("1234567890".equals(uuid)) {
        uuid = "0";
      }
      label64:
      return uuid;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label64;
    }
  }
  
  static class InsertRunnable
    implements Runnable
  {
    private ResultObject a;
    
    public InsertRunnable(ResultObject paramResultObject)
    {
      this.a = paramResultObject;
    }
    
    public void run()
    {
      if (MagnifierSDK.a != null) {
        MagnifierSDK.a.a(this.a);
      }
    }
  }
  
  class ReportRunnable
    implements Runnable
  {
    private int listIndex;
    private List<ResultObject> qc;
    
    private ReportRunnable() {}
    
    public void run()
    {
      int i = 0;
      if (txc.bCZ > Config.MAX_REPORT_NUM)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Magnifier_ReporterMachine", 2, "[YunYingReport]:End, reported " + txc.bCZ + " max_report_num " + Config.MAX_REPORT_NUM);
        }
        if (MagnifierSDK.a != null) {
          MagnifierSDK.a.vi();
        }
        if (MagnifierSDK.editor != null) {
          MagnifierSDK.editor.putInt("count_today_reported", txc.bCZ).apply();
        }
      }
      int j;
      do
      {
        return;
        if ((MagnifierSDK.a == null) || (1 != aomi.a().getNetType()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("Magnifier_ReporterMachine", 2, "[YunYingReport]:Next try, because MagnifierSDK.dbHandler == null || NetType.WIFI != NetworkCenter.getInstance().getNetType()");
          }
          ReporterMachine.b.postDelayed(this, 1800000L);
          return;
        }
        if ((this.qc == null) || (this.qc.isEmpty())) {
          break;
        }
        try
        {
          ReporterMachine.c((ResultObject)this.qc.get(this.listIndex));
          this.listIndex += 1;
          if (this.listIndex < this.qc.size())
          {
            ReporterMachine.b.postDelayed(this, 500L);
            return;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Magnifier_ReporterMachine", 2, localException1, new Object[0]);
            }
          }
          MagnifierSDK.a.g("result_objects", true);
          if ((this.qc != null) && (this.qc.size() > 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Magnifier_ReporterMachine", 2, "clear all data from roList");
            }
            this.qc.clear();
          }
          if (QLog.isColorLevel()) {
            QLog.d("Magnifier_ReporterMachine", 2, "clear and set listIndex's value to 0");
          }
          this.listIndex = 0;
          ReporterMachine.b.postDelayed(this, 1800000L);
          j = txc.bm.size();
        }
      } while (MagnifierSDK.editor == null);
      Object localObject1;
      if (i < j)
      {
        int k = txc.bm.keyAt(i);
        if (k > 100)
        {
          localObject1 = (txc.a)txc.bm.get(k);
          if (localObject1 != null) {
            break label372;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label372:
          MagnifierSDK.editor.putInt("count_plugin_" + String.valueOf(k), ((txc.a)localObject1).bDa);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Magnifier_ReporterMachine", 2, "MagnifierSDKApply 22 ");
      }
      MagnifierSDK.editor.apply();
      return;
      this.qc = MagnifierSDK.a.m(true);
      if ((ReporterMachine.qb != null) && (!ReporterMachine.qb.isEmpty())) {}
      try
      {
        this.qc.addAll(ReporterMachine.qb);
        ReporterMachine.qb.clear();
        if (QLog.isColorLevel()) {
          QLog.d("Magnifier_ReporterMachine", 2, "getAllResultObjects and set listIndex = 0");
        }
        this.listIndex = 0;
        if ((this.qc != null) && (!this.qc.isEmpty())) {
          break label625;
        }
        localObject1 = ReporterMachine.a().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject3 = (String)((Iterator)localObject1).next();
          try
          {
            localObject3 = new File((String)localObject3);
            if ((localObject3 != null) && (((File)localObject3).isFile())) {
              ((File)localObject3).delete();
            }
          }
          catch (Exception localException2) {}
        }
        ReporterMachine.a().clear();
      }
      finally {}
      ReporterMachine.b.postDelayed(this, 1800000L);
      return;
      label625:
      ReporterMachine.b.postDelayed(this, 500L);
    }
  }
  
  static class getFileRunnable
    implements Runnable
  {
    String aKc = Environment.getExternalStorageDirectory().getPath();
    String aKd = "/Tencent";
    String aKe = "/tencent";
    String aKf = "/MobileQQ/log/";
    String aKg = "/Magnifier/dumpfile/";
    String aKh = "/SNGAPM/battery/";
    ArrayList<String> oI = new ArrayList(6);
    
    public getFileRunnable()
    {
      if (!TextUtils.isEmpty(this.aKc))
      {
        if (!this.aKc.endsWith("/")) {
          this.aKc += "/";
        }
        this.oI.add(aqul.getSDKPrivatePath(this.aKc + this.aKd + this.aKf));
        this.oI.add(aqul.getSDKPrivatePath(this.aKc + this.aKd + this.aKg));
        this.oI.add(aqul.getSDKPrivatePath(this.aKc + this.aKd + this.aKh));
        this.oI.add(aqul.getSDKPrivatePath(this.aKc + this.aKe + this.aKf));
        this.oI.add(aqul.getSDKPrivatePath(this.aKc + this.aKe + this.aKg));
        this.oI.add(aqul.getSDKPrivatePath(this.aKc + this.aKe + this.aKh));
      }
    }
    
    public void run()
    {
      Iterator localIterator = this.oI.iterator();
      Object localObject;
      int i;
      while (localIterator.hasNext())
      {
        localObject = new File((String)localIterator.next());
        if ((localObject != null) && (((File)localObject).exists()) && (((File)localObject).isDirectory()))
        {
          localObject = ((File)localObject).listFiles();
          if (localObject != null) {
            i = 0;
          }
        }
      }
      while (i < localObject.length)
      {
        String str = localObject[i].getPath();
        if ((str.contains(".txt")) || (str.contains(".zip"))) {}
        try
        {
          ReporterMachine.a().add(str);
          label108:
          i += 1;
          continue;
          return;
        }
        catch (Exception localException)
        {
          break label108;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.reporter.ReporterMachine
 * JD-Core Version:    0.7.0.1
 */