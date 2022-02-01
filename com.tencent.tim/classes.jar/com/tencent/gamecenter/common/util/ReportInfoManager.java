package com.tencent.gamecenter.common.util;

import abmt;
import abpu;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import aqrb;
import aroi;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.http.utils.AsyncHttpConnection;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbk;

public class ReportInfoManager
{
  public static final String ACTION_CANCEL = "cancel";
  public static final String ACTION_DOWNLOAD = "download";
  public static final String ACTION_FINISH = "finish";
  public static final String ACTION_PROFILE = "profile";
  public static final String ACTION_START = "start";
  private static final String REPORT_INFO = "report_info";
  private static final String SHAREDPREFERENCES_NAME = "gamecenter_preferences";
  private static ReportInfoManager instance;
  private ArrayList<b> reportAdInfoList = new ArrayList();
  
  public static ReportInfoManager getInstance()
  {
    if (instance == null) {
      instance = new ReportInfoManager();
    }
    return instance;
  }
  
  private void saveReportInfo(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("gamecenter_preferences", 0).edit();
    paramContext.putString("report_info", changeList2JSONStr());
    paramContext.commit();
  }
  
  public void addReportInfo(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    b localb = new b();
    localb.id = paramString1;
    localb.aIQ = paramString2;
    localb.aIR = paramString3;
    this.reportAdInfoList.add(localb);
    saveReportInfo(paramContext);
  }
  
  public void changeJSONStr2List(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.reportAdInfoList.clear();
      try
      {
        paramString = new JSONArray(paramString);
        int j = paramString.length();
        int i = 0;
        for (;;)
        {
          if (i < j) {
            try
            {
              JSONObject localJSONObject = paramString.getJSONObject(i);
              b localb = new b();
              localb.id = localJSONObject.getString("appid");
              localb.aIQ = localJSONObject.getString("actionname");
              localb.aIR = localJSONObject.getString("timestamp");
              this.reportAdInfoList.add(localb);
              i += 1;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                localJSONException.printStackTrace();
              }
            }
          }
        }
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public String changeList2JSONStr()
  {
    if (this.reportAdInfoList.size() <= 0) {
      return "";
    }
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.reportAdInfoList.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("appid", localb.id);
        localJSONObject2.put("actionname", localb.aIQ);
        localJSONObject2.put("timestamp", localb.aIR);
        localJSONArray.put(localJSONObject2);
        continue;
        return localJSONObject1.toString();
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    for (;;)
    {
      localJSONObject1.put("items", localJSONException);
    }
  }
  
  public void clearReportInfo(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("gamecenter_preferences", 0).edit();
    paramContext.putString("report_info", "");
    paramContext.commit();
    this.reportAdInfoList.clear();
  }
  
  public String convertInfoObjectToJson(c paramc)
  {
    if (paramc == null) {
      return "{}";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramc.uin);
      localJSONObject.put("entrance_status", paramc.status);
      localJSONObject.put("gamecenter_src", paramc.aIS);
      localJSONObject.put("oper_moudle", paramc.bAV);
      localJSONObject.put("module_type", paramc.bAW);
      localJSONObject.put("oper_id", paramc.bAX);
      localJSONObject.put("sq_ver", paramc.aIT);
      localJSONObject.put("gamecenter_ver", paramc.aIU);
      localJSONObject.put("device_type", paramc.aIV);
      localJSONObject.put("net_type", paramc.aIW);
      localJSONObject.put("resolution", paramc.resolution);
      localJSONObject.put("ret_id", paramc.aIX);
      return localJSONObject.toString();
    }
    catch (JSONException paramc)
    {
      for (;;)
      {
        paramc.printStackTrace();
      }
    }
  }
  
  public c genClickReportInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    c localc = new c();
    localc.uin = paramString1;
    localc.status = paramString2;
    localc.aIV = Build.MODEL;
    localc.aIS = "1";
    localc.aIU = paramString3;
    localc.bAW = 108;
    localc.aIW = paramString4;
    localc.bAX = 16001;
    localc.bAV = 1;
    localc.resolution = paramString5;
    localc.aIT = aroi.a().getVersionName();
    return localc;
  }
  
  public void postClickReportInfo(c paramc)
  {
    if (paramc == null) {
      return;
    }
    paramc = convertInfoObjectToJson(paramc);
    long l = paramc.getBytes().length;
    String str = String.format("https://report.gamecenter.qq.com/cgi-bin/gc_pg_act_fcgi?appid=%1$s&tt=1&osv=%2$s", new Object[] { Integer.valueOf(AppSetting.getAppId()), Build.VERSION.RELEASE });
    new AsyncHttpConnection(new tbk(this, l)).db(str, paramc);
  }
  
  public String readReportInfo(Context paramContext)
  {
    return paramContext.getSharedPreferences("gamecenter_preferences", 0).getString("report_info", "");
  }
  
  public void reportGameCenterChannel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, a parama)
  {
    parama = new ReportChannlInfo();
    parama.channel_id = paramString2;
    parama.pos_id = paramString3;
    parama.pos_name = paramString4;
    parama.resource_id = paramString5;
    parama.schedule_id = paramString6;
    parama.appid = paramString7;
    parama.oper_type = paramInt;
    parama.act_id = paramString1;
    paramString1 = abmt.getAppInterface();
    if ((paramString1 instanceof QQAppInterface))
    {
      ((aqrb)paramString1.getBusinessHandler(71)).a(parama);
      return;
    }
    ((abpu)abmt.getAppInterface().getBusinessHandler(0)).a(parama);
  }
  
  public static class ReportChannlInfo
  {
    public String act_id = "";
    public String appid = "";
    public String channel_id = "";
    public String ext1 = "";
    public String ext2 = "";
    public String ext3 = "";
    public long oper_time = System.currentTimeMillis() / 1000L;
    public int oper_type;
    public int platform = 1;
    public String pos_id = "";
    public String pos_name = "";
    public String refer = "";
    public String resource_id = "";
    public String schedule_id = "";
    public String serviceid = "";
    public String source = "native";
  }
  
  public static abstract interface a {}
  
  static class b
  {
    public String aIQ;
    public String aIR;
    public String id;
  }
  
  public static class c
  {
    public String aIS = "";
    public String aIT = "";
    public String aIU = "";
    public String aIV = "";
    public String aIW = "";
    public String aIX = "0";
    public int bAV;
    public int bAW;
    public int bAX;
    public String resolution = "";
    public String status = "-1";
    public String uin = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ReportInfoManager
 * JD-Core Version:    0.7.0.1
 */