package com.tencent.gamecenter.appointment;

import ahty;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import anec;
import aqiw;
import asbt;
import asbw;
import awok;
import awol;
import awot;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tgpa.vendorpd.GameHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tax;
import taz;
import tbb;

public class GameCenterCheck
  extends AsyncStep
{
  public final long DY = 30L;
  
  public static void A(String[] paramArrayOfString)
  {
    asbt.i("GameCenterCheck", "checkIfNeedToDownloadAppointApp:" + paramArrayOfString);
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1)) {
      return;
    }
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      tbb.a(null, "558", "203701", paramArrayOfString[i], "55801", "4", "430");
      i += 1;
    }
    j = 0;
    Object localObject2 = "";
    Object localObject1 = "";
    i = 0;
    for (;;)
    {
      Object localObject3;
      if (i < paramArrayOfString.length) {
        localObject3 = tbb.gQ("APPOINT_APPID_DETAIL_" + paramArrayOfString[i]);
      }
      try
      {
        localObject3 = new JSONObject((String)localObject3);
        long l1 = ((JSONObject)localObject3).optLong("downloadStartTime", 0L);
        long l2 = ((JSONObject)localObject3).optLong("downloadEndTime", 0L);
        long l3 = NetConnInfoCenter.getServerTime();
        if ((l1 <= l3) && (l3 <= l2))
        {
          localObject3 = (String)localObject1 + paramArrayOfString[i] + "|";
          j = 1;
          localObject1 = localObject3;
        }
        else
        {
          localObject3 = (String)localObject2 + paramArrayOfString[i] + "|";
          localObject2 = localObject3;
        }
      }
      catch (Exception localException2)
      {
        i += 1;
      }
      paramArrayOfString = ((String)localObject1).split("\\|");
      if (paramArrayOfString.length == 0) {
        break;
      }
      if (j != 0) {
        tbb.V("APPOINTMENT_LIST", (String)localObject2);
      }
      i = 0;
      while (i < paramArrayOfString.length)
      {
        if (TextUtils.isEmpty(paramArrayOfString[i])) {}
        i += 1;
      }
      localObject1 = a(paramArrayOfString, "APPOINT_APPID_DETAIL_", true);
      if (((List)localObject1).size() < 1)
      {
        asbt.i("GameCenterCheck", "checkIfNeedToDownloadAppointApp params.size=0:");
        return;
      }
      paramArrayOfString = new JSONArray();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DownloadInfo)((Iterator)localObject1).next();
        localObject3 = tbb.gQ("APPOINT_APPID_DETAIL_" + ((DownloadInfo)localObject2).appId);
        try
        {
          String str = tbb.N(((DownloadInfo)localObject2).appId, ((DownloadInfo)localObject2).versionCode);
          if (TextUtils.isEmpty(str)) {
            break label473;
          }
          QLog.e("GameCenterCheck", 1, "startDownload from YY but apk is exists appId=" + ((DownloadInfo)localObject2).appId + ",localApkPath=" + str);
          tbb.a(null, "558", "205754", ((DownloadInfo)localObject2).appId, "55801", "4", "430");
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
        continue;
        label473:
        tbb.startDownload((String)localObject3, true, 1);
        tbb.X(localException1.appId, "APPOINTMENT_HAS_DOWNLOAD_LIST");
        paramArrayOfString.put(localException1.appId);
      }
      if (paramArrayOfString.length() <= 0) {
        break;
      }
      awot.a().b(paramArrayOfString, null);
      return;
    }
  }
  
  public static boolean ND()
  {
    if ((!TextUtils.isEmpty(tbb.gQ("APPOINTMENT_LIST"))) || (!TextUtils.isEmpty(tbb.gQ("APPOINTMENT_UPDATE_LIST"))) || (!TextUtils.isEmpty(tbb.gQ("DELAY_LIST"))) || (!TextUtils.isEmpty(tbb.gQ("APPOINTMENT_RES_LIST"))) || (!TextUtils.isEmpty(tbb.gQ("APPOINTMENT_TGPA_LIST"))) || (!TextUtils.isEmpty(tbb.gQ("UNPACK_APK_LIST")))) {}
    for (boolean bool = true;; bool = false)
    {
      asbt.i("GameCenterCheck", "hasAppointTask hasTask=" + bool);
      return bool;
    }
  }
  
  public static boolean NE()
  {
    if (aqiw.isWifiConnected(BaseApplicationImpl.getContext()))
    {
      PowerManager localPowerManager = (PowerManager)BaseApplicationImpl.getContext().getSystemService("power");
      if ((localPowerManager != null) && (!localPowerManager.isScreenOn()) && ((tax.bAT >= 20) || (tax.aOu))) {
        return true;
      }
    }
    tbb.a(null, "426", "205572", "", "42601", "1", "116");
    return false;
  }
  
  public static List<DownloadInfo> a(String[] paramArrayOfString, String paramString, boolean paramBoolean)
  {
    int j = paramArrayOfString.length;
    ArrayList localArrayList = new ArrayList();
    PackageManager localPackageManager = BaseApplicationImpl.getContext().getPackageManager();
    int i = 0;
    if (i < j)
    {
      if (TextUtils.isEmpty(paramArrayOfString[i])) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject = tbb.gQ(paramString + paramArrayOfString[i]);
        DownloadInfo localDownloadInfo = new DownloadInfo();
        try
        {
          localObject = new JSONObject((String)localObject);
          localDownloadInfo.appId = ((JSONObject)localObject).optString("appid");
          localDownloadInfo.cDG = ((JSONObject)localObject).optString("myAppId");
          localDownloadInfo.cCL = ((JSONObject)localObject).optString("apkId");
          localDownloadInfo.packageName = ((JSONObject)localObject).optString("packageName");
          localDownloadInfo.versionCode = ((JSONObject)localObject).optInt("versionCode");
          if (paramBoolean) {
            break label218;
          }
          localArrayList.add(localDownloadInfo);
        }
        catch (Exception localException)
        {
          localArrayList.add(localDownloadInfo);
          asbt.e("GameCenterCheck", localDownloadInfo.appId + "exception and no installed", localException);
        }
        continue;
        label218:
        if (localPackageManager.getPackageInfo(localDownloadInfo.packageName.trim(), 0) == null)
        {
          localArrayList.add(localDownloadInfo);
          if (QLog.isColorLevel()) {
            QLog.i("GameCenterCheck", 2, localDownloadInfo.appId + "no installed");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("GameCenterCheck", 2, localDownloadInfo.appId + "installed");
          }
          tbb.a(null, "426", "202142", localDownloadInfo.appId, "42601", "1", "116");
        }
      }
    }
    return localArrayList;
  }
  
  public static void bCp()
  {
    boolean bool = NE();
    asbt.i("GameCenterCheck", "checkGameCenter canAppointStart=" + bool);
    if (!bool) {
      return;
    }
    ThreadManager.excute(new GameCenterCheck.1(), 192, null, false);
  }
  
  public static void bCq()
  {
    Object localObject = tbb.gQ("APPOINTMENT_RES_LIST");
    asbt.i("GameCenterCheck", "checkGameRes resList =" + (String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      ArrayList localArrayList = new ArrayList();
      JSONObject localJSONObject = new JSONObject();
      int i = 0;
      for (;;)
      {
        if (i < localObject.length)
        {
          String str = tbb.gQ("APPID_PKGNAME_" + localObject[i]);
          try
          {
            localJSONObject.put(str, localObject[i]);
            localArrayList.add(str);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              asbt.e("GameCenterCheck", "checkGameRes read appid_pkg fail e=" + localJSONException.toString());
            }
          }
        }
      }
      GameHelper.getGameVersionUpdateInfo(BaseApplicationImpl.getContext(), "qq", localArrayList, new taz(localJSONObject));
    }
  }
  
  public static void k(JSONArray paramJSONArray)
  {
    asbt.i("GameCenterCheck", "checkIfNeedToDownloadUpdateApp jsonArray=" + paramJSONArray);
    if ((paramJSONArray == null) || (paramJSONArray.length() < 1)) {}
    for (;;)
    {
      return;
      tbb.g(new String[] { "APPOINTMENT_UPDATE_LIST" });
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject;
        try
        {
          localObject = paramJSONArray.optJSONObject(i);
          String str1 = ((JSONObject)localObject).optString("appid");
          int j = ((JSONObject)localObject).optInt("version_code");
          String str2 = ((JSONObject)localObject).optString("pkg_name");
          String str3 = ((JSONObject)localObject).optString("app_name");
          String str4 = ((JSONObject)localObject).optString("apk_channel", "10000144");
          String str5 = ((JSONObject)localObject).optString("apk_url");
          int k = ((JSONObject)localObject).optInt("min_version");
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str5)))
          {
            tbb.a(null, "558", "206679", str1, "72702", "4", "430", new String[] { "", "1", "5" });
            boolean bool = tbb.e(str2, j, k);
            localObject = tbb.N(str1, j);
            if ((!bool) || (!TextUtils.isEmpty((CharSequence)localObject)))
            {
              asbt.i("GameCenterCheck", "checkIfNeedToDownloadUpdateApp cancel, appId=" + str1 + ",checkVersion=" + bool + ",localApkPath=" + (String)localObject);
            }
            else
            {
              localObject = new Bundle();
              ((Bundle)localObject).putString("pkgName", str2);
              ((Bundle)localObject).putString("apkChannel", str4);
              ((Bundle)localObject).putString("appName", str3);
              ((Bundle)localObject).putString("apkUrl", str5);
              ((Bundle)localObject).putInt("versionCode", j);
              ((Bundle)localObject).putString("via", "auto_update");
              ((Bundle)localObject).putInt("from", 3);
              ((Bundle)localObject).putInt("flags", 62);
              ahty.a((Bundle)localObject, str1, false, 0);
            }
          }
        }
        catch (Exception localException)
        {
          QLog.e("GameCenterCheck", 2, "checkIfNeedToDownloadUpdateApp exception", localException);
        }
        asbt.i("GameCenterCheck", "checkIfNeedToDownloadUpdateApp params check fail，jsonTmp=" + ((JSONObject)localObject).toString());
        i += 1;
      }
    }
  }
  
  public static void l(JSONArray paramJSONArray)
  {
    Object localObject1 = new StringBuilder().append("checkIfNeedToDownloadTGPA jsonArray=");
    String str1;
    if (paramJSONArray != null)
    {
      str1 = paramJSONArray.toString();
      asbt.i("GameCenterCheck", str1);
      if ((paramJSONArray != null) && (paramJSONArray.length() >= 1)) {
        break label61;
      }
    }
    for (;;)
    {
      return;
      str1 = "empty";
      break;
      label61:
      tbb.g(new String[] { "APPOINTMENT_TGPA_LIST" });
      int i = 0;
      while (i < paramJSONArray.length())
      {
        int j;
        int k;
        String str2;
        String str3;
        int m;
        String str4;
        String str5;
        try
        {
          localObject2 = paramJSONArray.optJSONObject(i);
          str1 = ((JSONObject)localObject2).optString("appid");
          j = ((JSONObject)localObject2).optInt("version_code");
          localObject1 = ((JSONObject)localObject2).optString("app_name");
          k = ((JSONObject)localObject2).optInt("package_type");
          str2 = ((JSONObject)localObject2).optString("package_name");
          str3 = ((JSONObject)localObject2).optString("package_src_url");
          m = ((JSONObject)localObject2).optInt("package_index");
          str4 = ((JSONObject)localObject2).optString("package_id");
          str5 = ((JSONObject)localObject2).optString("package_md5");
          if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3))) {
            break label535;
          }
          asbt.i("GameCenterCheck", "checkIfNeedToDownloadTGPA packageName=" + (String)localObject1 + ",resType=" + k + ",appId=" + str1 + ",resName=" + str2 + ",srcUrl=" + str3 + ",versionCode=" + j + ",versionName=" + str4 + ",resMD5=" + str5);
          if (((k == 0) && (!tbb.aOB)) || ((k == 1) && (!tbb.aOA))) {
            break label564;
          }
          if (k == 1)
          {
            boolean bool = tbb.r((String)localObject1, j);
            localObject2 = tbb.N(str1, j);
            if ((!bool) || (!TextUtils.isEmpty((CharSequence)localObject2))) {
              asbt.i("GameCenterCheck", "checkIfNeedToDownloadTGPA cancel, checkVersion=" + bool + ",localApkPath=" + (String)localObject2);
            }
          }
        }
        catch (Exception localException)
        {
          QLog.e("GameCenterCheck", 2, "checkIfNeedToDownloadTGPA exception", localException);
        }
        Object localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("from", 3);
        ((Bundle)localObject2).putString("pkgName", (String)localObject1);
        ((Bundle)localObject2).putString("apkUrl", str3);
        ((Bundle)localObject2).putString("resName", str2);
        ((Bundle)localObject2).putInt("resIndex", m);
        ((Bundle)localObject2).putString("resVersionName", str4);
        ((Bundle)localObject2).putInt("versionCode", j);
        ((Bundle)localObject2).putString("resMD5", str5);
        ((Bundle)localObject2).putString("via", "auto_tgpa");
        ahty.a((Bundle)localObject2, localException, true, k);
        break label564;
        label535:
        asbt.i("GameCenterCheck", "checkIfNeedToDownloadTGPA params check fail，jsonTmp=" + ((JSONObject)localObject2).toString());
        label564:
        i += 1;
      }
    }
  }
  
  public static void m(JSONArray paramJSONArray)
  {
    Object localObject2 = new StringBuilder().append("checkIfNeedToUnpackTGPAApp jsonArray=");
    Object localObject1;
    if (paramJSONArray != null)
    {
      localObject1 = paramJSONArray.toString();
      asbt.i("GameCenterCheck", (String)localObject1);
      if ((paramJSONArray != null) && (paramJSONArray.length() >= 1)) {
        break label58;
      }
    }
    for (;;)
    {
      return;
      localObject1 = "empty";
      break;
      label58:
      tbb.g(new String[] { "UNPACK_APK_LIST" });
      int i = 0;
      while (i < paramJSONArray.length())
      {
        try
        {
          localObject1 = paramJSONArray.optJSONObject(i);
          localObject2 = ((JSONObject)localObject1).optString("appid");
          int j = ((JSONObject)localObject1).optInt("version", 0);
          String str1 = ((JSONObject)localObject1).optString("url");
          String str2 = ((JSONObject)localObject1).optString("md5", "");
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(str1)))
          {
            asbt.i("GameCenterCheck", "checkIfNeedToUnpackTGPAApp appId=" + (String)localObject2 + ",version=" + j + ",md5=" + str2 + ",url=" + str1);
            awok.eEF();
            awok.a().m((String)localObject2, j, str1, str2);
          }
          else
          {
            asbt.i("GameCenterCheck", "checkIfNeedToUnpackTGPAApp params check fail，jsonTmp=" + ((JSONObject)localObject1).toString());
          }
        }
        catch (Exception localException)
        {
          QLog.e("GameCenterCheck", 2, "checkIfNeedToUnpackTGPAApp exception", localException);
        }
        i += 1;
      }
    }
  }
  
  public static void z(String[] paramArrayOfString)
  {
    asbt.i("GameCenterCheck", "checkIfNeedToDownloadDelayApp:" + paramArrayOfString);
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1)) {}
    for (;;)
    {
      return;
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        tbb.a(null, "558", "203713", paramArrayOfString[i], "55801", "4", "430");
        i += 1;
      }
      tbb.V("DELAY_LIST", "");
      paramArrayOfString = a(paramArrayOfString, "DELAY_APPID_DETAIL_", true);
      if (paramArrayOfString.size() == 0)
      {
        asbt.i("GameCenterCheck", "checkIfNeedToDownloadDelayApp params.size=0:");
        return;
      }
      paramArrayOfString = paramArrayOfString.iterator();
      while (paramArrayOfString.hasNext())
      {
        Object localObject = (DownloadInfo)paramArrayOfString.next();
        localObject = tbb.gQ("DELAY_APPID_DETAIL_" + ((DownloadInfo)localObject).appId);
        try
        {
          tbb.startDownload((String)localObject, true, 2);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public int od()
  {
    asbt.i("GameCenterCheck", "GameCenterCheck doStep");
    tbb.bCr();
    if ((!tbb.aOy) && (!tbb.aOx) && (!tbb.aOz) && (!tbb.aOA) && (!tbb.aOB))
    {
      asbt.w("GameCenterCheck", "GameCenterCheck switch is off");
      return super.od();
    }
    Long localLong3 = Long.valueOf(tbb.P("APPOINTMENT_LASTGET_TIME"));
    Long localLong2 = Long.valueOf(tbb.P("APPOINTMENT_LOAD_GAP"));
    Long localLong1 = localLong2;
    if (0L == localLong2.longValue()) {
      localLong1 = Long.valueOf(30L);
    }
    long l = NetConnInfoCenter.getServerTime();
    asbt.i("GameCenterCheck", "GameCenterCheck loadGap=" + localLong1 + ", lastTime:" + localLong3 + ",isAppointDownload=" + tbb.aOy + ",isDelayDownload=" + tbb.aOx + ",isUpdateDownload=" + tbb.aOz + ",isResApkDownload=" + tbb.aOA + ",isResDefDownload=" + tbb.aOB);
    int i;
    if (l - localLong3.longValue() < localLong1.longValue())
    {
      i = 1;
      if (i == 0) {
        break label257;
      }
      bCp();
    }
    for (;;)
    {
      if (ND()) {
        tax.registerReceiver();
      }
      asbw.a();
      awot.a().S(false, -1L);
      return super.od();
      i = 0;
      break;
      label257:
      asbt.i("GameCenterCheck", "GameCenterCheck getPreDownloadList loadGap=" + localLong1);
      ((anec)this.a.app.getManager(12)).dOZ();
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterCheck
 * JD-Core Version:    0.7.0.1
 */