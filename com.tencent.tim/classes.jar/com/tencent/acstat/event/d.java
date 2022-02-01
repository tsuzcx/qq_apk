package com.tencent.acstat.event;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.acstat.StatConfig;
import com.tencent.acstat.StatSpecifyReportedInfo;
import com.tencent.acstat.a.a.i;
import com.tencent.acstat.af;
import com.tencent.acstat.common.DeviceInfo;
import com.tencent.acstat.common.StatCommonHelper;
import com.tencent.acstat.common.Util;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d
{
  private static final List<EventType> a = Arrays.asList(new EventType[] { EventType.NETWORK_DETECTOR });
  protected static String j = null;
  protected String b = null;
  protected long c;
  protected int d;
  protected DeviceInfo e = null;
  protected int f;
  protected String g = null;
  protected String h = null;
  protected String i = null;
  protected boolean k = false;
  protected boolean l = false;
  protected int m = 0;
  protected Context n;
  protected StatSpecifyReportedInfo o = null;
  
  d(Context paramContext, int paramInt, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    this.n = paramContext;
    this.c = (System.currentTimeMillis() / 1000L);
    this.d = paramInt;
    this.i = StatCommonHelper.getCurAppVersion(paramContext);
    if (paramStatSpecifyReportedInfo != null)
    {
      this.o = paramStatSpecifyReportedInfo;
      if (StatCommonHelper.isStringValid(paramStatSpecifyReportedInfo.getAppKey())) {
        this.b = paramStatSpecifyReportedInfo.getAppKey();
      }
      if (StatCommonHelper.isStringValid(paramStatSpecifyReportedInfo.getInstallChannel())) {
        this.h = paramStatSpecifyReportedInfo.getInstallChannel();
      }
      if (StatCommonHelper.isStringValid(paramStatSpecifyReportedInfo.getVersion())) {
        this.i = paramStatSpecifyReportedInfo.getVersion();
      }
      this.k = paramStatSpecifyReportedInfo.isImportant();
    }
    if (!StatCommonHelper.isStringValid(this.b)) {
      this.b = StatConfig.getAppKey(paramContext);
    }
    if (!StatCommonHelper.isStringValid(this.h)) {
      this.h = StatConfig.getInstallChannel(paramContext);
    }
    this.g = StatConfig.getCustomUserId(paramContext);
    this.e = af.a(paramContext).b(paramContext);
    paramStatSpecifyReportedInfo = a();
    if (!a.contains(paramStatSpecifyReportedInfo)) {
      this.f = StatCommonHelper.getNextEventIndexNo(paramContext).intValue();
    }
    for (;;)
    {
      if (!i.c(j))
      {
        paramStatSpecifyReportedInfo = StatConfig.getLocalMidOnly(paramContext);
        j = paramStatSpecifyReportedInfo;
        if (!StatCommonHelper.isStringValid(paramStatSpecifyReportedInfo)) {
          j = "0";
        }
      }
      this.m = StatCommonHelper.hasRootAccess(paramContext);
      return;
      this.f = (-a().a());
      if (paramStatSpecifyReportedInfo != EventType.NETWORK_DETECTOR) {
        this.l = true;
      }
    }
  }
  
  public abstract EventType a();
  
  public abstract boolean a(JSONObject paramJSONObject)
    throws JSONException;
  
  public boolean b(JSONObject paramJSONObject)
  {
    try
    {
      Util.jsonPut(paramJSONObject, "ky", this.b);
      paramJSONObject.put("et", a().a());
      if (this.e != null)
      {
        paramJSONObject.put("ui", this.e.getImei());
        Util.jsonPut(paramJSONObject, "mc", this.e.getMac());
        int i1 = this.e.getUserType();
        paramJSONObject.put("ut", i1);
        if ((i1 == 0) && (StatCommonHelper.isTheFirstTimeActivate(this.n) == 1)) {
          paramJSONObject.put("ia", 1);
        }
      }
      Util.jsonPut(paramJSONObject, "cui", this.g);
      Object localObject = StatConfig.getAppVersion();
      if (!StatCommonHelper.isStringValid((String)localObject)) {
        Util.jsonPut(paramJSONObject, "av", this.i);
      }
      for (;;)
      {
        if (this.k) {
          paramJSONObject.put("impt", 1);
        }
        Util.jsonPut(paramJSONObject, "mid", j);
        paramJSONObject.put("idx", this.f);
        paramJSONObject.put("si", this.d);
        paramJSONObject.put("ts", this.c);
        localObject = StatConfig.getCommonAttr(this.n);
        if ((localObject != null) && (((JSONObject)localObject).length() > 0)) {
          paramJSONObject.put("com", ((JSONObject)localObject).toString());
        }
        paramJSONObject.put("dts", StatCommonHelper.getDiffTime(this.n, false));
        paramJSONObject.put("os", 1);
        Util.jsonPut(paramJSONObject, "ov", Integer.toString(Build.VERSION.SDK_INT));
        Util.jsonPut(paramJSONObject, "md", Build.MODEL);
        paramJSONObject.put("jb", this.m);
        Util.jsonPut(paramJSONObject, "mf", Build.MANUFACTURER);
        localObject = StatConfig.getCustomGlobalReportContent();
        if ((localObject != null) && (((JSONObject)localObject).length() > 0)) {
          paramJSONObject.put("cc", ((JSONObject)localObject).toString());
        }
        Util.jsonPut(paramJSONObject, "qq", StatConfig.getQQ());
        return a(paramJSONObject);
        Util.jsonPut(paramJSONObject, "av", (String)localObject);
        Util.jsonPut(paramJSONObject, "appv", this.i);
      }
      return false;
    }
    catch (Throwable paramJSONObject) {}
  }
  
  public long c()
  {
    return this.c;
  }
  
  public StatSpecifyReportedInfo d()
  {
    return this.o;
  }
  
  public Context e()
  {
    return this.n;
  }
  
  public boolean f()
  {
    return this.k;
  }
  
  public String g()
  {
    try
    {
      Object localObject = new JSONObject();
      b((JSONObject)localObject);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.acstat.event.d
 * JD-Core Version:    0.7.0.1
 */