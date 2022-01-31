package com.tencent.open.agent.report;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.open.business.cgireport.ReportComm;
import com.tencent.open.business.viareport.ReportConfig;
import com.tencent.qphone.base.util.QLog;
import fch;
import fci;
import fcj;
import fck;
import fcl;
import fcm;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReportCenter
{
  protected static final int a = 1000;
  protected static ReportCenter a;
  public static final String a = "http://wspeed.qq.com/w.cgi";
  protected static final int b = 1001;
  public static final String b = "http://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report";
  protected static final int c = 10000;
  public static final String c = "http://c.isdspeed.qq.com/code.cgi";
  protected static final int d = 5;
  public static final String d = "report_cgi";
  public static final String e = "report_via";
  public static final String f = "apn";
  public static final String g = "frequency";
  public static final String h = "commandid";
  public static final String i = "resultCode";
  public static final String j = "timeCost";
  public static final String k = "reqSize";
  public static final String l = "rspSize";
  public static final String m = "uin";
  public static final String n = "deviceInfo";
  public static final String o = "appid";
  public static final String p = "detail";
  protected static final String q = "ReportCenter";
  protected Handler a;
  public ArrayList a;
  protected Random a;
  protected Executor a;
  public Handler b;
  public ArrayList b;
  
  private ReportCenter()
  {
    this.jdField_b_of_type_AndroidOsHandler = new fch(this, Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilRandom = new Random();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManager.a();
    this.jdField_a_of_type_AndroidOsHandler = ThreadManager.b();
  }
  
  public static ReportCenter a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenAgentReportReportCenter == null) {
        jdField_a_of_type_ComTencentOpenAgentReportReportCenter = new ReportCenter();
      }
      ReportCenter localReportCenter = jdField_a_of_type_ComTencentOpenAgentReportReportCenter;
      return localReportCenter;
    }
    finally {}
  }
  
  private void a(Bundle paramBundle, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBundle == null) {}
    for (;;)
    {
      return;
      try
      {
        CommonDataAdapter.a().a(Long.valueOf(paramString2).longValue());
        if (QLog.isColorLevel()) {
          QLog.d("ReportCenter", 2, "-->reportVia, bundle: " + paramBundle.toString());
        }
        if ((!a("report_via", paramString1)) && (!paramBoolean)) {
          continue;
        }
        this.jdField_a_of_type_AndroidOsHandler.post(new fci(this, paramString2, paramBundle, paramBoolean));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          CommonDataAdapter.a().a(0L);
        }
      }
    }
  }
  
  public int a(int paramInt)
  {
    int i1;
    if (paramInt == 0)
    {
      i1 = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_CGIReportFrequencySuccess");
      paramInt = i1;
      if (i1 == 0) {
        paramInt = 10;
      }
    }
    do
    {
      return paramInt;
      i1 = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_CGIReportFrequencyFailed");
      paramInt = i1;
    } while (i1 != 0);
    return 100;
  }
  
  public Bundle a()
  {
    int i1 = 0;
    Object localObject3;
    try
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        return null;
      }
      Object localObject1 = (BaseData)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReportCenter", 2, "-->prepareCgiData, the 0th cgireportitem is null.");
        }
        return null;
      }
      localObject3 = (String)((BaseData)localObject1).attrs.get("appid");
      localObject1 = ReportDatabaseHelper.a().a("report_cgi");
      if (localObject1 != null) {
        this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReportCenter", 2, "-->prepareCgiData, itemList size: " + this.jdField_a_of_type_JavaUtilArrayList.size());
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        return null;
      }
    }
    finally {}
    localBundle = new Bundle();
    try
    {
      localBundle.putString("appid", (String)localObject3);
      localBundle.putString("releaseversion", CommonDataAdapter.a().e() + "_Release");
      localBundle.putString("device", Build.DEVICE);
      localBundle.putString("qua", ReportComm.l);
      localBundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
      while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject3 = (BaseData)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        localBundle.putString(i1 + "_1", (String)((BaseData)localObject3).attrs.get("apn"));
        localBundle.putString(i1 + "_2", (String)((BaseData)localObject3).attrs.get("frequency"));
        localBundle.putString(i1 + "_3", (String)((BaseData)localObject3).attrs.get("commandid"));
        localBundle.putString(i1 + "_4", (String)((BaseData)localObject3).attrs.get("resultCode"));
        localBundle.putString(i1 + "_5", (String)((BaseData)localObject3).attrs.get("timeCost"));
        localBundle.putString(i1 + "_6", (String)((BaseData)localObject3).attrs.get("reqSize"));
        localBundle.putString(i1 + "_7", (String)((BaseData)localObject3).attrs.get("rspSize"));
        localBundle.putString(i1 + "_8", (String)((BaseData)localObject3).attrs.get("detail"));
        localBundle.putString(i1 + "_9", (String)((BaseData)localObject3).attrs.get("uin"));
        localObject3 = MobileInfoUtil.h() + "&" + (String)((BaseData)localObject3).attrs.get("deviceInfo");
        localBundle.putString(i1 + "_10", (String)localObject3);
        i1 += 1;
      }
      return localBundle;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReportCenter", 2, "-->prepareCgiData, exception.", localException);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReportCenter", 2, "-->prepareCgiData, end. params: " + localBundle.toString());
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new fck(this));
  }
  
  public void a(String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportCenter", 2, "-->reportCgi, command: " + paramString1 + " | startTime: " + paramLong1 + " | reqSize:" + paramLong2 + " | rspSize: " + paramLong3 + " | responseCode: " + paramInt + " | uin: " + paramLong4 + " | appid: " + paramString2 + " | detail: " + paramString3);
    }
    if ((!a("report_cgi", "" + paramInt)) && (!paramBoolean)) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new fcj(this, paramLong1, paramString2, paramString1, paramString3, paramInt, paramLong2, paramLong3, paramLong4, paramBoolean));
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new fcm(this, paramBundle, paramString1, paramBoolean));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean)
  {
    try
    {
      a(AuthorityUtil.a(paramString1, paramString2, paramString4, paramString5, paramString3, paramString6, paramString7, "", "", paramString8, paramString9), paramString3, paramString1, paramBoolean);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ReportCenter", 2, "-->reportVia 2 exception", paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    try
    {
      a(AuthorityUtil.a(paramString1, paramString2, paramString4, paramString5, paramString3, paramString6, paramString5, "", "", "", ""), paramString3, paramString1, paramBoolean);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ReportCenter", 2, "-->reportVia 1 exception", paramString1);
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    int i1 = 5;
    boolean bool = false;
    int i2;
    if (paramString.equals("report_cgi"))
    {
      i2 = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_CGIReportMaxcount");
      if (i2 != 0) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReportCenter", 2, "-->availableCount, report: " + paramString + " | dataSize: " + paramInt + " | maxcount: " + i1);
      }
      if (paramInt >= i1) {
        bool = true;
      }
      return bool;
      i1 = i2;
      continue;
      if (paramString.equals("report_via"))
      {
        i2 = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Agent_ReportBatchCount");
        if (i2 != 0) {
          i1 = i2;
        }
      }
      else
      {
        i1 = 0;
      }
    }
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    boolean bool1 = true;
    boolean bool3 = false;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("ReportCenter", 2, "-->availableFrequency, report: " + paramString1 + " | ext: " + paramString2);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return bool2;
    }
    if (paramString1.equals("report_cgi")) {}
    for (;;)
    {
      try
      {
        int i1 = Integer.parseInt(paramString2);
        i1 = a(i1);
        if (this.jdField_a_of_type_JavaUtilRandom.nextInt(100) < i1)
        {
          bool2 = bool1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ReportCenter", 2, "-->availableFrequency, result: " + bool1 + " | frequency: " + i1);
          return bool1;
        }
        bool1 = false;
        continue;
        if (paramString1.equals("report_via"))
        {
          i1 = ReportConfig.a(paramString2);
          if (new Random().nextInt(100) < i1)
          {
            bool1 = true;
            continue;
          }
          bool1 = bool3;
          continue;
        }
        i1 = 100;
      }
      catch (Exception paramString1)
      {
        return false;
      }
      bool1 = bool3;
    }
  }
  
  public Bundle b()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = ReportDatabaseHelper.a().a("report_via");
        if (localObject1 != null) {
          this.jdField_b_of_type_JavaUtilArrayList.addAll((Collection)localObject1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReportCenter", 2, "-->prepareViaData, itemList size: " + this.jdField_b_of_type_JavaUtilArrayList.size());
        }
        int i1 = this.jdField_b_of_type_JavaUtilArrayList.size();
        if (i1 == 0)
        {
          localObject1 = null;
          return localObject1;
        }
        localObject1 = new JSONArray();
        localObject4 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label227;
        }
        Object localObject5 = (Serializable)((Iterator)localObject4).next();
        localJSONObject = new JSONObject();
        localObject5 = (BaseData)localObject5;
        Iterator localIterator = ((BaseData)localObject5).attrs.keySet().iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          try
          {
            localJSONObject.put(str, ((BaseData)localObject5).attrs.get(str));
          }
          catch (JSONException localJSONException2) {}
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ReportCenter", 2, "-->prepareViaData, put bundle to json array exception", localJSONException2);
          continue;
        }
        localObject2.put(localJSONObject);
      }
      finally {}
      continue;
      label227:
      if (QLog.isColorLevel()) {
        QLog.d("ReportCenter", 2, "-->prepareViaData, JSONArray array: " + localObject2.toString());
      }
      Object localObject4 = new Bundle();
      JSONObject localJSONObject = new JSONObject();
      Object localObject3;
      try
      {
        localJSONObject.put("data", localObject2);
        ((Bundle)localObject4).putString("data", localJSONObject.toString());
        localObject3 = localObject4;
      }
      catch (JSONException localJSONException1)
      {
        localObject3 = localObject4;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("ReportCenter", 2, "-->prepareViaData, put bundle to json array exception", localJSONException1);
        localObject3 = localObject4;
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new fcl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.open.agent.report.ReportCenter
 * JD-Core Version:    0.7.0.1
 */