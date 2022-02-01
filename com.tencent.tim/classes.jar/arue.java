import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appcommon.AppClient.1;
import com.tencent.open.appcommon.AppClient.2;
import com.tencent.open.appcommon.AppClient.3;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistantbase.common.DownloadSDKConfigManager;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class arue
{
  public static void K(Context paramContext, String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("process_id", 2);
    localBundle.putString("schemaUrl", paramString);
    localBundle.putBoolean("is_can_open_yyb_native", paramBoolean);
    if ((paramContext instanceof Activity))
    {
      openAppDetail((Activity)paramContext, localBundle);
      return;
    }
    openAppDetail(null, localBundle);
  }
  
  public static void R(Activity paramActivity, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("schemaUrl", paramString);
    openAppDetail(paramActivity, localBundle);
  }
  
  protected static void V(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("huin", paramString1);
    localBundle.putString("keytype", "256");
    localBundle.putString("keystr", paramString2);
    localBundle.putString("appid", paramString3);
    localBundle.putString("platform", aroi.a().getPlatform());
    localBundle.putString("requestkeys", paramString4);
    localBundle.putString("mode", "1");
    localBundle.putString("v", aroi.a().getAgentVersion());
    new arxh("https://appic.qq.com/cgi-bin/appstage/mapp_setrequest.cgi", "GET", null).execute(new Bundle[] { localBundle });
  }
  
  protected static void W(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ("2457".equals(paramString1)) {
      if (!TextUtils.isEmpty(paramString4)) {
        break label64;
      }
    }
    for (String str = "ANDROIDQQ.PCPUSH.AIOMSG";; str = paramString4)
    {
      arxt.br("200", str, paramString3);
      if ("2460".equals(paramString1)) {}
      label64:
      try
      {
        paramString2 = arxt.gu(Integer.parseInt(paramString2));
        paramString1 = paramString4;
        if (TextUtils.isEmpty(paramString4)) {
          paramString1 = paramString2;
        }
        arxt.br("200", paramString1, paramString3);
        return;
      }
      catch (NumberFormatException paramString1) {}
    }
  }
  
  protected static String a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    arwt.d("AppClient", "getFeedsChannelId >>> qzoneAppid = " + paramInt1 + "| " + paramInt2 + " | " + paramInt3);
    if (paramInt1 == 352) {}
    switch (paramInt2)
    {
    case 4: 
    case 5: 
    case 6: 
    default: 
      return "";
    case 1: 
    case 3: 
      return "100_1";
    case 7: 
    case 8: 
      if ((paramInt3 == 0) || (paramInt3 == 2)) {
        return "200_1";
      }
      if (paramInt3 == 1) {
        return "200_2";
      }
      break;
    }
    return "";
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt, Bundle paramBundle)
  {
    String str1 = arug.Dj() + File.separator + "qapp_center_detail.htm";
    arug.elJ();
    Object localObject = new File(str1);
    if (!((File)localObject).exists())
    {
      arwt.w("AppClient", "file" + str1 + " not exist copyassets.");
      arwq.iH("Page/system", arug.Dk());
    }
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    String str2;
    if (((File)localObject).exists())
    {
      str2 = "file:///" + str1;
      localIntent.setClass(aroi.a().getContext(), QZoneAppListActivity.class);
      str1 = "&from=-10&id=" + paramString + "&channelId=" + paramInt;
      paramString = null;
      if (paramBundle != null) {
        paramString = paramBundle.getString("via");
      }
      if (!DownloadSDKConfigManager.canGotoNewDetailPage(paramString)) {
        break label535;
      }
      localBundle.putInt("goto_type", 7);
      label210:
      if (!TextUtils.isEmpty(paramString)) {
        break label546;
      }
    }
    for (;;)
    {
      int i = 0;
      paramString = str1;
      if (paramBundle != null)
      {
        boolean bool = paramBundle.getBoolean("autoDownload");
        paramString = paramBundle.getString("packageName");
        localObject = str1;
        if (!TextUtils.isEmpty(paramString)) {
          localObject = str1 + "&packageName=" + paramString;
        }
        str1 = paramBundle.getString("subpagetype");
        paramString = (String)localObject;
        i = bool;
        if (!TextUtils.isEmpty(str1))
        {
          paramString = (String)localObject + "&subpagetype=" + str1;
          i = bool;
        }
      }
      str1 = paramString;
      if (i != 0) {
        str1 = paramString + "&msgType=56";
      }
      localBundle.putString("APP_PARAMS", str1);
      if (paramBundle != null)
      {
        localBundle.putString("uin", paramBundle.getString("uin"));
        localBundle.putString("sid", paramBundle.getString("vkey"));
      }
      localBundle.putString("APP_URL", str2);
      localBundle.putBoolean("FROM_FEED", true);
      arwt.i("Jie", "APP_URL:" + str2 + " |  PARAMS >>> " + localBundle.getString("APP_PARAMS"));
      localIntent.putExtras(localBundle);
      localIntent.putExtra("adapter_action", "action_app_detail");
      localIntent.addFlags(603979776);
      paramActivity.startActivityForResult(localIntent, 200);
      return;
      str2 = arug.Dp() + File.separator + "qapp_center_detail.htm";
      break;
      label535:
      localBundle.putInt("goto_type", 3);
      break label210;
      label546:
      str1 = str1 + "&via=" + paramString;
    }
  }
  
  protected static void a(Activity paramActivity, String paramString1, String paramString2, Bundle paramBundle, String paramString3, String paramString4)
  {
    arug.elJ();
    int i = 1;
    Object localObject;
    if (!paramString3.equals("online"))
    {
      paramString4 = arug.Dj() + File.separator + paramString4;
      localObject = new File(paramString4);
      if (!((File)localObject).exists())
      {
        arwt.w("AppClient", "file" + paramString4 + " not exist copyassets.");
        arwq.iH("Page/system", arug.Dk());
      }
      if (((File)localObject).exists()) {
        paramString4 = "file:///" + paramString4;
      }
    }
    Intent localIntent;
    Bundle localBundle;
    String str1;
    for (;;)
    {
      localIntent = new Intent();
      localBundle = new Bundle();
      Class localClass = d(paramString3);
      localIntent.setClass(paramActivity, localClass);
      String str5 = paramBundle.getString("installedVersion");
      String str6 = paramBundle.getString("localVersion");
      String str7 = paramBundle.getString("typeid");
      String str8 = paramBundle.getString("serverApkVersion");
      String str9 = paramBundle.getString("msgType");
      String str10 = paramBundle.getString("sendTime");
      str1 = paramBundle.getString("via");
      String str3 = paramBundle.getString("splitvia");
      String str4 = paramBundle.getString("subPageType");
      String str2 = paramBundle.getString("appCustom");
      localObject = paramString2;
      if (paramString2 == "2460") {
        localObject = paramString2 + "_" + str9;
      }
      paramString2 = "&from=-10&id=" + paramString1 + "&channelId=" + (String)localObject + "&installedVersion=" + str5 + "&localVersion=" + str6 + "&serverApkVersion=" + str8 + "&typeId=" + str7 + "&msgType=" + str9 + "&sendTime=" + str10;
      str5 = paramBundle.getString("schemaUrl");
      if (TextUtils.isEmpty(str4))
      {
        label404:
        if (!TextUtils.isEmpty(str1)) {
          break label957;
        }
        label412:
        if (!TextUtils.isEmpty(str3)) {
          break label986;
        }
        label420:
        if (!TextUtils.isEmpty(str2)) {
          break label1015;
        }
        label428:
        if (!TextUtils.isEmpty(str5)) {
          break label1044;
        }
        label436:
        localBundle.putString("APP_PARAMS", paramString2);
        localBundle.putString("uin", paramBundle.getString("uin"));
        localBundle.putString("sid", paramBundle.getString("vkey"));
        localBundle.putString("APP_URL", paramString4);
        localBundle.putBoolean("FROM_FEED", true);
        localBundle.putString(aryv.PARAM_VIA, str1);
        if (!"detail".equals(paramString3)) {
          break label1073;
        }
        localBundle.putInt("goto_type", 2);
        label520:
        if ((!paramString3.equals("custom")) || (i == 0)) {}
      }
      try
      {
        paramString2 = paramBundle.getString("pageTitles");
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString2 = new ArrayList(Arrays.asList(paramString2.split("&")));
          localBundle.putStringArrayList("titleName", paramString2);
          if (paramString2.size() > 0)
          {
            bool = true;
            localBundle.putBoolean("showTitle", bool);
            arwt.i("AppClient", "titles = " + paramString2);
          }
        }
        else
        {
          arwt.i("TAG", "APP_URL:" + paramString4 + " |  PARAMS >>> " + localBundle.getString("APP_PARAMS"));
          localIntent.putExtras(localBundle);
          localIntent.putExtra("adapter_action", "action_app_detail");
          localIntent.addFlags(603979776);
        }
      }
      catch (Exception paramString2)
      {
        try
        {
          for (;;)
          {
            paramString2 = Class.forName("com.tencent.open.appcenter.QZoneAppWebViewActivity");
            if ((paramString2 == null) || (!localClass.getName().equals(paramString2.getName()))) {
              break label1158;
            }
            if (!((String)localObject).equals("2457")) {
              break label1134;
            }
            paramString1 = aryy.a().c(paramString1);
            if ((!arzk.a().aHy()) || (paramString1 == null) || (paramString1.downloadType != 1)) {
              break label1124;
            }
            arwt.w("AppClient", ">>>appid=" + paramString1.appId + " myAppid=" + paramString1.cDG);
            localBundle.putString(aryv.PARAM_SNG_APPID, paramString1.appId);
            localBundle.putString(aryv.PARAM_TASK_APPID, paramString1.cDG);
            localBundle.putString(aryv.PARAM_TASK_APK_ID, paramString1.cCL);
            localBundle.putString(aryv.PARAM_VIA, str1);
            localBundle.putString(aryv.PARAM_TASK_PACKNAME, paramString1.packageName);
            localBundle.putInt(aryv.PARAM_TASK_VERSION, paramString1.versionCode);
            arzk.a().a(paramActivity, localBundle, ((String)localObject).equals("2457"), true);
            return;
            i = 0;
            paramString4 = arug.Dp() + File.separator + "qapp_center_detail.htm";
            break;
            break;
            paramString2 = paramString2 + "&subPageType=" + str4;
            break label404;
            label957:
            paramString2 = paramString2 + "&via=" + str1;
            break label412;
            label986:
            paramString2 = paramString2 + "&splitVia=" + str3;
            break label420;
            label1015:
            paramString2 = paramString2 + "&appCustom=" + str2;
            break label428;
            label1044:
            paramString2 = paramString2 + "&" + str5;
            break label436;
            label1073:
            if (!"index".equals(paramString3)) {
              break label520;
            }
            localBundle.putInt("goto_type", 1);
            break label520;
            boolean bool = false;
          }
          paramString2 = paramString2;
          arwt.e("AppClient", "get push title error>>>", paramString2);
        }
        catch (Exception paramString2)
        {
          for (;;)
          {
            paramString2.printStackTrace();
            paramString2 = null;
          }
          label1124:
          paramActivity.startActivityForResult(localIntent, 200);
          return;
        }
      }
    }
    label1134:
    ThreadManager.getSubThreadHandler().post(new AppClient.1(paramString1, localBundle, str1, paramActivity, localIntent, paramBundle));
    return;
    label1158:
    paramActivity.startActivityForResult(localIntent, 200);
  }
  
  public static void c(Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("schemaUrl", paramString);
    localBundle.putInt("qzoneAppid", paramInt1);
    localBundle.putInt("qzoneSubId", paramInt2);
    localBundle.putInt("from", paramInt3);
    openAppDetail(paramActivity, localBundle);
  }
  
  public static Class d(String paramString)
  {
    try
    {
      Class.forName("com.tencent.open.appcenter.QZoneAppWebViewActivity");
      if (paramString.equals("detail")) {
        return QZoneAppListActivity.class;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      if (paramString.equals("index")) {
        return QZoneAppListActivity.class;
      }
      if (!paramString.equals("online")) {}
    }
    return QZoneAppListActivity.class;
  }
  
  protected static void d(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    arwt.i("AppClient", "shcemaUrlAnd:" + paramString1);
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    for (;;)
    {
      return;
      Object localObject2 = arug.y(paramString1);
      String str8 = (String)((HashMap)localObject2).get("appid");
      String str10 = (String)((HashMap)localObject2).get("sendtime");
      String str9 = (String)((HashMap)localObject2).get("packname");
      String str13 = (String)((HashMap)localObject2).get("packetversion");
      String str11 = (String)((HashMap)localObject2).get("msgtype");
      String str14 = (String)((HashMap)localObject2).get("type");
      Object localObject1 = (String)((HashMap)localObject2).get("downurl");
      String str12 = (String)((HashMap)localObject2).get("via");
      String str15 = qy(str12);
      String str7 = (String)((HashMap)localObject2).get("appCustom");
      String str2 = (String)((HashMap)localObject2).get("nativepage");
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = (String)((HashMap)localObject2).get("np");
      }
      str2 = (String)((HashMap)localObject2).get("htmlpage");
      label237:
      label372:
      String str16;
      label270:
      label304:
      label338:
      int i;
      if (TextUtils.isEmpty(str2))
      {
        str2 = (String)((HashMap)localObject2).get("hp");
        String str3 = (String)((HashMap)localObject2).get("subpagetype");
        if (!TextUtils.isEmpty(str3)) {
          break label866;
        }
        str3 = (String)((HashMap)localObject2).get("sp");
        String str4 = (String)((HashMap)localObject2).get("pagetitles");
        if (!TextUtils.isEmpty(str4)) {
          break label869;
        }
        str4 = (String)((HashMap)localObject2).get("pt");
        String str5 = (String)((HashMap)localObject2).get(aryv.PARAM_TASK_APPID);
        if (!TextUtils.isEmpty(str5)) {
          break label872;
        }
        str5 = (String)((HashMap)localObject2).get("ta");
        String str6 = (String)((HashMap)localObject2).get(aryv.PARAM_TASK_APK_ID);
        if (!TextUtils.isEmpty(str6)) {
          break label875;
        }
        str6 = (String)((HashMap)localObject2).get("tk");
        str16 = (String)((HashMap)localObject2).get("minvercode");
        localObject2 = (String)((HashMap)localObject2).get("backurl");
        arwt.i("AppClient", "appid=" + str8 + " ,sendtime=" + str10 + " ,packname=" + str9 + " ,packetversion=" + str13 + " ,msgtype=" + str11 + " ,type=" + str14 + " ,downUrl=" + (String)localObject1 + " ,nativePage=" + str1 + " ,htmlPage=" + str2 + " ,subPageType=" + str3 + " ,pageTitles=" + str4 + " ,minvercode=" + str16 + " ,backUrl=" + (String)localObject2);
        i = arxn.fA(str9);
        int j = arxn.fB(aryy.a().qz(str8));
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("installedVersion", String.valueOf(i));
        ((Bundle)localObject1).putString("localVersion", String.valueOf(j));
        ((Bundle)localObject1).putString("serverApkVersion", str13);
        ((Bundle)localObject1).putString("typeid", str14);
        ((Bundle)localObject1).putString("msgType", str11);
        ((Bundle)localObject1).putString("sendTime", str10);
        ((Bundle)localObject1).putString("subPageType", str3);
        ((Bundle)localObject1).putString("pageTitles", str4);
        ((Bundle)localObject1).putString("appCustom", str7);
        ((Bundle)localObject1).putString("schemaUrl", paramString1);
        if (!TextUtils.isEmpty(str12))
        {
          ((Bundle)localObject1).putString("via", str12);
          ((Bundle)localObject1).putString("splitvia", str15);
        }
        ((Bundle)localObject1).putString("uin", paramString2);
        ((Bundle)localObject1).putString("vkey", paramString3);
        ((Bundle)localObject1).putString(aryv.PARAM_SNG_APPID, str8);
        ((Bundle)localObject1).putString(aryv.PARAM_TASK_APPID, str5);
        ((Bundle)localObject1).putString(aryv.PARAM_TASK_APK_ID, str6);
        if (!TextUtils.isEmpty(str9)) {
          ((Bundle)localObject1).putString(aryv.PARAM_TASK_PACKNAME, str9);
        }
        ((Bundle)localObject1).putString(aryv.PARAM_TASK_VERSION, str13);
      }
      try
      {
        aroi.a().setUin(Integer.parseInt(paramString2));
        label802:
        aroi.a().WH(paramString3);
        W(paramString4, str11, str8, str12);
        if ("2460".equals(paramString4))
        {
          V(paramString2, paramString3, str8, str10);
          if (i <= 0) {}
        }
        try
        {
          paramString1 = URLDecoder.decode(str7, "UTF-8");
          arxn.v(paramActivity, str8, str9, paramString1);
          return;
          break label237;
          label866:
          break label270;
          label869:
          break label304;
          label872:
          break label338;
          label875:
          break label372;
          if (TextUtils.isEmpty(str1))
          {
            a(paramActivity, str8, paramString4, (Bundle)localObject1, "detail", "qapp_center_detail.htm");
            return;
          }
          if (str1.equals("tmast"))
          {
            if (TextUtils.isEmpty(str2)) {
              continue;
            }
            i = arxn.fA("com.tencent.android.qqdownloader");
            if ((!TextUtils.isEmpty(str16)) && (i > 0) && (i >= Integer.valueOf(str16).intValue()))
            {
              paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(str2));
              paramString1.setFlags(268435456);
              paramActivity.startActivity(paramString1);
              return;
            }
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              continue;
            }
            a(paramActivity, str8, paramString4, (Bundle)localObject1, "online", (String)localObject2);
            return;
          }
          if (str1.equals("detail"))
          {
            a(paramActivity, str8, paramString4, (Bundle)localObject1, "detail", "qapp_center_detail.htm");
            return;
          }
          a(paramActivity, str8, paramString4, (Bundle)localObject1, str1, str2);
          return;
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramString1 = str7;
          }
        }
      }
      catch (NumberFormatException paramString1)
      {
        break label802;
      }
    }
  }
  
  public static void j(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    d(paramActivity, paramString1, paramString2, paramString3, "2457");
  }
  
  public static void k(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    d(paramActivity, paramString1, paramString2, paramString3, "2460");
  }
  
  public static void openAppDetail(Activity paramActivity, Bundle paramBundle)
  {
    arug.elJ();
    int i = paramBundle.getInt("qzoneAppid");
    int j = paramBundle.getInt("qzoneSubId");
    int k = paramBundle.getInt("op_type");
    int m = paramBundle.getInt("from");
    boolean bool = paramBundle.getBoolean("is_can_open_yyb_native", true);
    paramActivity = paramBundle.getString("schemaUrl");
    Object localObject6;
    Object localObject2;
    if ((!TextUtils.isEmpty(paramActivity)) && (paramActivity.contains("&")))
    {
      localObject6 = new Bundle();
      if (paramActivity.startsWith("http://")) {}
      String str2;
      for (;;)
      {
        try
        {
          String str1 = new URL(paramActivity).getQuery();
          HashMap localHashMap = arug.y(str1);
          localObject2 = (String)localHashMap.get("appid");
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject2 = (String)localHashMap.get(aryv.PARAM_SNG_APPID);
            localObject4 = (String)localHashMap.get(aryv.PARAM_TASK_APPID);
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              break label431;
            }
            localObject4 = (String)localHashMap.get("ta");
            localObject5 = (String)localHashMap.get(aryv.PARAM_TASK_APK_ID);
            if (!TextUtils.isEmpty((CharSequence)localObject5)) {
              break label434;
            }
            localObject5 = (String)localHashMap.get("tk");
            str2 = (String)localHashMap.get(aryv.PARAM_TASK_VERSION);
            localObject7 = (String)localHashMap.get("via");
            localObject3 = (String)localHashMap.get("packName");
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              break label437;
            }
            localObject3 = (String)localHashMap.get(aryv.PARAM_TASK_PACKNAME);
            paramActivity = (String)localHashMap.get(aryv.cDC);
            arwt.w("AppClient", " feedChannel:" + paramActivity + "   schemaUrl:" + str1);
            if ((!TextUtils.isEmpty(paramActivity)) && (!paramActivity.startsWith("0;"))) {
              break label440;
            }
            paramActivity = "";
            arwt.w("AppClient", " finalFeedChannel:" + paramActivity);
            if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!arxn.appIsExists((String)localObject3))) {
              break;
            }
            paramActivity = (String)localHashMap.get("appCustom");
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localMalformedURLException.printStackTrace();
        }
        try
        {
          paramBundle = URLDecoder.decode(paramActivity, "UTF-8");
          paramActivity = paramBundle;
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            Object localObject1;
            CharSequence localCharSequence;
            break;
          }
        }
        arxn.v(aroi.a().getContext(), (String)localObject2, (String)localObject3, paramActivity);
        return;
        localObject1 = paramActivity;
        continue;
        continue;
        label431:
        continue;
        label434:
        continue;
        label437:
        continue;
        label440:
        paramActivity = paramActivity.split(";");
        if (paramActivity == null)
        {
          paramActivity = "";
        }
        else if (paramActivity.length <= 0)
        {
          paramActivity = "";
        }
        else
        {
          localCharSequence = paramActivity[0];
          if (!TextUtils.isEmpty(localCharSequence))
          {
            paramActivity = localCharSequence;
            if (!localCharSequence.equals("0")) {}
          }
          else
          {
            paramActivity = "";
          }
        }
      }
      ((Bundle)localObject6).putString(aryv.PARAM_SNG_APPID, (String)localObject2);
      ((Bundle)localObject6).putString(aryv.PARAM_TASK_APPID, (String)localObject4);
      ((Bundle)localObject6).putString(aryv.PARAM_TASK_APK_ID, (String)localObject5);
      ((Bundle)localObject6).putString(aryv.PARAM_TASK_VERSION, str2);
      ((Bundle)localObject6).putString(aryv.PARAM_TASK_PACKNAME, (String)localObject3);
      ((Bundle)localObject6).putString(aryv.PARAM_VIA, (String)localObject7);
      ((Bundle)localObject6).putString(aryv.cDC, paramActivity);
      ((Bundle)localObject6).putString("schemaUrl", (String)localObject1);
      paramActivity = (Activity)localObject2;
      localObject5 = str2;
      localObject4 = localObject3;
      localObject2 = localObject1;
      localObject3 = localObject6;
      localObject1 = paramActivity;
      paramActivity = (Activity)localObject7;
      if (k != 7) {
        break label762;
      }
      localObject7 = a(i, j, m, (String)localObject1);
      if (!TextUtils.isEmpty(paramActivity)) {
        break label1270;
      }
      paramActivity = arxt.m(i, j, m);
      aryb.a().d(String.valueOf(aroi.a().getUin()), (String)localObject1, paramActivity, "200", false);
      localObject6 = paramActivity;
    }
    for (paramActivity = (Activity)localObject7;; paramActivity = (Activity)localObject7)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject5)) || (TextUtils.isEmpty((CharSequence)localObject4)) || ("0".equals(localObject5)) || (localObject3 == null) || (!arzk.a().aHy()) || (!bool)) {
        break label776;
      }
      ThreadManager.getSubThreadHandler().post(new AppClient.2(paramBundle, (Bundle)localObject3, (String)localObject1, (String)localObject2, paramActivity, (String)localObject6));
      return;
      localObject3 = null;
      localObject4 = null;
      localObject5 = "0";
      localObject1 = paramActivity;
      localObject6 = null;
      localObject2 = paramActivity;
      paramActivity = (Activity)localObject6;
      break;
      label762:
      localObject7 = "2410";
      localObject6 = paramActivity;
    }
    label776:
    Object localObject3 = arug.Dj() + File.separator + "qapp_center_detail.htm";
    Object localObject4 = new File((String)localObject3);
    if (!((File)localObject4).exists())
    {
      arwt.w("AppClient", "file" + (String)localObject3 + " not exist copyassets.");
      arwq.iH("Page/system", arug.Dk());
    }
    Object localObject5 = new Intent();
    Object localObject7 = new Bundle();
    if (((File)localObject4).exists())
    {
      localObject3 = "file:///" + (String)localObject3;
      localObject4 = "&from=-10&id=" + (String)localObject1 + "&channelId=" + paramActivity;
      paramActivity = (Activity)localObject4;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (!((String)localObject2).equals(localObject1)) {
          break label1220;
        }
        paramActivity = (Activity)localObject4;
      }
      label965:
      if (arug.y(paramBundle.getString("schemaUrl")).get("auto_download") == null) {
        break label1250;
      }
      i = 1;
      label985:
      localObject1 = paramActivity;
      if (i != 0)
      {
        localObject1 = paramActivity;
        if (!paramActivity.contains("auto_download")) {
          localObject1 = paramActivity + "&auto_download=1";
        }
      }
      ((Intent)localObject5).setClass(aroi.a().getContext(), QZoneAppListActivity.class);
      ((Bundle)localObject7).putString("APP_URL", (String)localObject3);
      ((Bundle)localObject7).putBoolean("FROM_FEED", true);
      ((Bundle)localObject7).putString("APP_PARAMS", (String)localObject1);
      if (!DownloadSDKConfigManager.canGotoNewDetailPage((String)localObject6)) {
        break label1255;
      }
      ((Bundle)localObject7).putInt("goto_type", 7);
    }
    for (;;)
    {
      if (paramBundle.getInt("process_id") == 2) {
        ((Bundle)localObject7).putInt("process_id", 2);
      }
      arwt.i("Jie", "APP_URL:" + (String)localObject3 + " |  PARAMS >>> " + ((Bundle)localObject7).getString("APP_PARAMS"));
      ((Intent)localObject5).putExtras((Bundle)localObject7);
      ((Intent)localObject5).putExtra("adapter_action", "action_app_detail");
      ((Intent)localObject5).addFlags(872415232);
      aroi.a().getContext().startActivity((Intent)localObject5);
      return;
      localObject3 = arug.Dp() + File.separator + "qapp_center_detail.htm";
      break;
      label1220:
      paramActivity = (String)localObject4 + "&" + (String)localObject2;
      break label965;
      label1250:
      i = 0;
      break label985;
      label1255:
      ((Bundle)localObject7).putInt("goto_type", 2);
    }
  }
  
  public static String qy(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.split("\\.");
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 2;
    if ((paramString != null) && (paramString.length > 2))
    {
      if (i < paramString.length)
      {
        if (i == paramString.length - 1) {
          localStringBuilder.append(paramString[i]);
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuilder.append(paramString[i] + ".");
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static void s(Activity paramActivity, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("packageName");
    String str2 = paramBundle.getString("appId");
    boolean bool = paramBundle.getBoolean("autoDownload");
    paramBundle = paramBundle.getString("big_brother_source_key");
    arxt.br("200", "ANDROIDQQ.SHARESOURCE", str2);
    ThreadManager.executeOnSubThread(new AppClient.3(str2, str1, paramBundle, paramActivity, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arue
 * JD-Core Version:    0.7.0.1
 */