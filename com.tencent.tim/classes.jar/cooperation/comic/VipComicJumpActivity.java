package cooperation.comic;

import acfp;
import acle;
import aevs;
import afil;
import ahyh;
import altq;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.TextView;
import aqqj;
import aurn;
import auru;
import avcm;
import avcm.a;
import avcq;
import avcv;
import avcz;
import avcz.a;
import avda;
import avdb;
import avdi;
import aveb;
import aveb.a;
import aved;
import avej;
import avfw;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import eipc.EIPCClient;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jpa;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import zjq;

public class VipComicJumpActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  public static final String NAME = VipComicJumpActivity.class.getName();
  public auru a;
  public avfw a;
  b a;
  TextView agd;
  TextView age;
  boolean dmx = false;
  volatile boolean dmy = false;
  boolean dmz = false;
  long downloadTime = 0L;
  long installTime = 0L;
  long launchTime = 0L;
  BroadcastReceiver mReceiver = null;
  
  public VipComicJumpActivity()
  {
    this.jdField_a_of_type_CooperationComicVipComicJumpActivity$b = null;
  }
  
  private static String Y(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      if (i != 0) {
        localStringBuilder.append("_");
      }
      localStringBuilder.append((String)paramList.get(i));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static b a(Intent paramIntent)
  {
    boolean bool = true;
    if (paramIntent == null) {
      return null;
    }
    b localb = new b();
    localb.clickTime = paramIntent.getLongExtra("click_start_time", 0L);
    localb.startTime = System.currentTimeMillis();
    if (localb.clickTime <= 0L) {
      localb.clickTime = localb.startTime;
    }
    localb.dmF = paramIntent.getBooleanExtra("has_red_dot", false);
    Object localObject1 = paramIntent.getStringExtra("from_leba");
    Object localObject2 = paramIntent.getStringExtra("from_leba_mgr");
    String str = paramIntent.getStringExtra("cfrom");
    if ((localObject1 != null) && (((String)localObject1).equalsIgnoreCase("fromleba")))
    {
      localb.ewI = 1006002;
      localObject1 = null;
    }
    label256:
    label769:
    label1156:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicJumpActivity", 2, "getFromInfoFromIntent sourceFrom = " + localb.ewI + ", extUrlParam = " + localb.cJE);
      }
      label180:
      int i;
      if (localb.ewI == 1006002)
      {
        localb.cJI = MainFragment.aOg;
        localObject2 = avda.n(null);
        if ((localObject2 == null) || ((localb.ewI != 1006002) && (localb.ewI != 19) && (localb.ewI != 20))) {
          break label741;
        }
        i = 1;
        label223:
        if (i == 0) {
          break label778;
        }
        i = ((Bundle)localObject2).getInt("type", -1);
        if ((i < 100) || (i > 300)) {
          break label746;
        }
        localb.cJF = "com.qqcomic.activity.media.VipComicMediaPlayActivity";
        localb.a = new a();
        localb.a.cJz = ((Bundle)localObject2).getString("comicId");
        localb.a.cJA = ((Bundle)localObject2).getString("sectionId");
        localb.a.cJB = ((Bundle)localObject2).getString("pictureId");
        localb.a.ewG = ((Bundle)localObject2).getInt("offset", -1);
        localb.a.type = ((Bundle)localObject2).getInt("type", -1);
        localb.a.ewH = ((Bundle)localObject2).getInt("player", 2);
        localb.a.cJD = ((Bundle)localObject2).getString("cloudUrl", "");
        if (!"com.qqcomic.activity.media.VipComicMediaPlayActivity".equals(localb.cJF)) {
          break label769;
        }
        localb.dmA = false;
        localb.dmC = ((Bundle)localObject2).getBoolean("isPlayerLocked", false);
        if (((Bundle)localObject2).getBoolean("supportMiniPlayer", false)) {
          break label757;
        }
        bool = true;
        label424:
        localb.cxZ = bool;
        if (!localb.cxZ) {
          break label762;
        }
        localObject1 = "";
        label441:
        localb.a.cJC = c("comicDetailVideo", null, null, "1", "354", null, (String)localObject1 + "ADTAG=comic.plugin.fav&id=" + localb.a.cJz);
      }
      for (;;)
      {
        for (;;)
        {
          if (TextUtils.isEmpty(localb.cJG)) {
            localb.cJG = avcv.FL();
          }
          if ((paramIntent.hasExtra("banner_fromBanner")) && (paramIntent.getBooleanExtra("banner_fromBanner", false)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("VipComicJumpActivity", 2, "come from AIO Banner!");
            }
            if ((localb.a != null) && (!TextUtils.isEmpty(localb.a.cJz))) {
              avdb.a(null, "100007", "2", "40040", localb.a.cJz, new String[0]);
            }
          }
          return localb;
          if ((localObject2 != null) && (((String)localObject2).equalsIgnoreCase("fromlebamgr")))
          {
            localb.ewI = 1006003;
            localObject1 = null;
            break;
          }
          if (!TextUtils.isEmpty(str))
          {
            localb.ewI = Integer.valueOf(str).intValue();
            localObject1 = null;
            break;
          }
          try
          {
            for (;;)
            {
              localObject1 = paramIntent.getStringExtra("options");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label1156;
              }
              localObject1 = new JSONObject((String)localObject1);
              try
              {
                localb.ewI = ((JSONObject)localObject1).optInt("from");
                localb.cJE = ((JSONObject)localObject1).optString("extUrlParam");
              }
              catch (Exception localException1) {}
            }
          }
          catch (Exception localException3)
          {
            label778:
            label1065:
            for (;;)
            {
              label741:
              label746:
              label757:
              label762:
              JSONObject localJSONObject;
              label861:
              localObject1 = null;
            }
            localObject1 = null;
          }
        }
        localException1.printStackTrace();
        break;
        if (localb.ewI != 1006003) {
          break label180;
        }
        localb.cJI = acfp.m(2131716735);
        break label180;
        i = 0;
        break label223;
        localb.cJF = "com.qqcomic.activity.reader.VipComicPortraitReadingActivity";
        break label256;
        bool = false;
        break label424;
        localObject1 = "init_player=1&";
        break label441;
        localb.dmA = true;
        continue;
        if (localObject1 != null)
        {
          localb.cJF = ((JSONObject)localObject1).optString("jumpto", "com.qqcomic.activity.VipComicMainTabActivity");
          localb.ewI = ((JSONObject)localObject1).optInt("from", 0);
          if (!((JSONObject)localObject1).optBoolean("newInstance"))
          {
            localb.dmD = bool;
            if (((JSONObject)localObject1).has("url")) {
              localb.jumpurl = ((JSONObject)localObject1).optString("url");
            }
          }
          try
          {
            localb.jumpurl = URLDecoder.decode(localb.jumpurl);
            if (avcv.d(localb.jumpurl, localb.mIntent)) {
              localb.cJF = "com.qqcomic.activity.media.VipComicMediaPlayActivity";
            }
            if (((JSONObject)localObject1).has("comic")) {}
            try
            {
              localJSONObject = new JSONObject(((JSONObject)localObject1).optString("comic"));
              localb.a = new a();
              localb.a.cJz = localJSONObject.optString("comicID");
              localb.a.cJA = localJSONObject.optString("comicSectionID");
              localb.a.cJB = localJSONObject.optString("comicPageID");
              localb.a.ewG = localJSONObject.optInt("comicPageOffset");
              localb.a.type = localJSONObject.optInt("type");
              localb.dmA = localJSONObject.optBoolean("returnToDetail");
              localb.a.ewH = localJSONObject.optInt("player", 2);
              localb.a.cJD = localJSONObject.optString("cloudUrl", "");
              localb.a.cJC = localJSONObject.optString("url", "");
              if (((JSONObject)localObject1).has("maintab")) {
                localb.cJG = ((JSONObject)localObject1).optString("maintab");
              }
              if (((JSONObject)localObject1).has("subtab")) {
                localb.cJH = ((JSONObject)localObject1).optString("subtab");
              }
              if (((JSONObject)localObject1).has("leftViewText"))
              {
                localb.cJI = ((JSONObject)localObject1).optString("leftViewText");
                continue;
                bool = false;
              }
            }
            catch (JSONException localJSONException)
            {
              break label1065;
            }
          }
          catch (Exception localException2)
          {
            break label861;
          }
        }
      }
    }
  }
  
  static void a(AppRuntime paramAppRuntime, b paramb)
  {
    if ((paramAppRuntime == null) || (paramb == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VipComicJumpActivity", 2, "updateRedAppInfo start");
    }
    boolean bool2 = paramAppRuntime instanceof QQAppInterface;
    Object localObject1;
    Object localObject2;
    if (bool2)
    {
      localObject1 = zjq.a().dp();
      if (localObject1 == null) {
        break label1017;
      }
      localObject1 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (aevs)((Iterator)localObject1).next();
      } while ((localObject2 == null) || (((aevs)localObject2).a == null) || (((aevs)localObject2).a.uiResId != 1113L));
    }
    label119:
    label1017:
    for (int i = ((aevs)localObject2).bo;; i = -1)
    {
      label122:
      String str;
      if (i == 0)
      {
        bool1 = true;
        localObject1 = null;
        if (!bool1) {
          break label546;
        }
        localObject6 = "1113." + 100800;
        localObject5 = "1113." + 100802;
        localObject4 = "1113." + 100803;
        localObject3 = "1113." + 100804;
        localObject2 = "1113." + 100801;
        str = String.valueOf(1113);
        label254:
        if (!bool2) {
          break label699;
        }
        paramAppRuntime = (altq)paramAppRuntime.getManager(36);
        if (paramAppRuntime == null) {
          break;
        }
        localObject1 = paramAppRuntime.getAppInfoByPath(str);
        localObject6 = paramAppRuntime.getAppInfoByPath((String)localObject6);
        localObject5 = paramAppRuntime.getAppInfoByPath((String)localObject5);
        localObject4 = paramAppRuntime.getAppInfoByPath((String)localObject4);
        localObject3 = paramAppRuntime.getAppInfoByPath((String)localObject3);
        paramAppRuntime = paramAppRuntime.getAppInfoByPath((String)localObject2);
        if ((localObject6 == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject6).iNewFlag.get() == 0)) {
          break label674;
        }
        bool1 = true;
        paramb.dL("index", bool1);
        if ((paramAppRuntime == null) || (paramAppRuntime.iNewFlag.get() == 0)) {
          break label679;
        }
        bool1 = true;
        paramb.dL("fav", bool1);
        if ((localObject3 == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject3).iNewFlag.get() == 0)) {
          break label684;
        }
        bool1 = true;
        paramb.dL("category", bool1);
        if ((localObject5 == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject5).iNewFlag.get() == 0)) {
          break label689;
        }
        bool1 = true;
        paramb.dL("more", bool1);
        if ((localObject4 == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject4).iNewFlag.get() == 0)) {
          break label694;
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        paramb.dL("group", bool1);
        if ((localObject1 != null) && (paramb.dmF))
        {
          a(((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get(), ((BusinessInfoCheckUpdate.AppInfo)localObject1).missions.get(), paramb);
          paramb.cJJ = Y(((BusinessInfoCheckUpdate.AppInfo)localObject1).missions.get());
        }
        if (!QLog.isColorLevel()) {
          break label990;
        }
        QLog.d("VipComicJumpActivity", 2, "updateRedAppInfo end");
        return;
        bool1 = false;
        break label119;
        localObject1 = (aved)paramAppRuntime.getManager(213);
        if (localObject1 == null) {
          break;
        }
        bool1 = ((aved)localObject1).nr(1113);
        break label122;
        localObject6 = "100600.100001113." + 100100800;
        localObject5 = "100600.100001113." + 100100802;
        localObject4 = "100600.100001113." + 100100803;
        localObject3 = "100600.100001113." + 100100804;
        localObject2 = "100600.100001113." + 100100801;
        str = "100600.100001113";
        break label254;
        bool1 = false;
        break label338;
        bool1 = false;
        break label362;
        bool1 = false;
        break label388;
        bool1 = false;
        break label414;
      }
      paramAppRuntime = new ArrayList();
      paramAppRuntime.add(str);
      paramAppRuntime.add(localObject6);
      paramAppRuntime.add(localObject2);
      paramAppRuntime.add(localObject3);
      paramAppRuntime.add(localObject5);
      paramAppRuntime.add(localObject4);
      paramAppRuntime = ((aved)localObject1).b(paramAppRuntime);
      if (paramAppRuntime == null) {
        break;
      }
      localObject1 = (RedAppInfo)paramAppRuntime.get(str);
      Object localObject6 = (RedAppInfo)paramAppRuntime.get(localObject6);
      Object localObject5 = (RedAppInfo)paramAppRuntime.get(localObject5);
      Object localObject4 = (RedAppInfo)paramAppRuntime.get(localObject4);
      Object localObject3 = (RedAppInfo)paramAppRuntime.get(localObject3);
      paramAppRuntime = (RedAppInfo)paramAppRuntime.get(localObject2);
      if ((localObject6 != null) && (((RedAppInfo)localObject6).If() != 0))
      {
        bool1 = true;
        paramb.dL("index", bool1);
        if ((paramAppRuntime == null) || (paramAppRuntime.If() == 0)) {
          break label997;
        }
        bool1 = true;
        paramb.dL("fav", bool1);
        if ((localObject3 == null) || (((RedAppInfo)localObject3).If() == 0)) {
          break label1002;
        }
        bool1 = true;
        paramb.dL("category", bool1);
        if ((localObject5 == null) || (((RedAppInfo)localObject5).If() == 0)) {
          break label1007;
        }
        bool1 = true;
        paramb.dL("more", bool1);
        if ((localObject4 == null) || (((RedAppInfo)localObject4).If() == 0)) {
          break label1012;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        paramb.dL("group", bool1);
        if ((localObject1 == null) || (!paramb.dmF)) {
          break label496;
        }
        a(((RedAppInfo)localObject1).yw(), ((RedAppInfo)localObject1).fS(), paramb);
        paramb.cJJ = Y(((RedAppInfo)localObject1).fS());
        break label496;
        break;
        bool1 = false;
        break label852;
        bool1 = false;
        break label873;
        bool1 = false;
        break label896;
        bool1 = false;
        break label919;
      }
    }
  }
  
  public static boolean a(AppInterface paramAppInterface, Activity paramActivity, b paramb)
  {
    if ((paramAppInterface == null) || (paramActivity == null) || (paramb == null)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "handle param start");
    }
    Object localObject3;
    String str;
    Object localObject2;
    Object localObject4;
    if (("com.qqcomic.activity.VipComicMainTabActivity".equals(paramb.cJF)) && (paramb.cJG == null))
    {
      i = 1;
      if ((paramb.ewI != 12) || (i == 0)) {
        break label312;
      }
      localObject3 = paramActivity.getSharedPreferences("vip_comic_file", 4);
      if (!((SharedPreferences)localObject3).getBoolean("restore_flag", false)) {
        break label312;
      }
      str = ((SharedPreferences)localObject3).getString("base_package", "");
      localObject2 = ((SharedPreferences)localObject3).getString("base_activity", "");
      i = ((SharedPreferences)localObject3).getInt("activity_task_id", -1);
      localObject3 = ((ActivityManager)paramActivity.getApplication().getApplicationContext().getSystemService("activity")).getRunningTasks(100);
      if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
        break label312;
      }
      localObject3 = ((List)localObject3).iterator();
      do
      {
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (ActivityManager.RunningTaskInfo)((Iterator)localObject3).next();
      } while ((!((ActivityManager.RunningTaskInfo)localObject4).baseActivity.getClassName().equals(localObject2)) || (i != ((ActivityManager.RunningTaskInfo)localObject4).id));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject3 = new Intent();
        ((Intent)localObject3).setComponent(new ComponentName(str, (String)localObject2));
        ((Intent)localObject3).addFlags(269500416);
        ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_zz_bodong");
        try
        {
          paramActivity.startActivity((Intent)localObject3);
          if (QLog.isColorLevel()) {
            QLog.d("QQComicDebug", 2, "handle param restore stack end");
          }
          return true;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        i = 0;
        break;
      }
      label312:
      Object localObject1;
      if ("com.qqcomic.activity.VipComicMainTabActivity".equals(paramb.cJF))
      {
        a(paramAppInterface, paramb);
        if (QLog.isColorLevel()) {
          QLog.d("QQComicDebug", 2, "handle param parse red touch end");
        }
        if (paramb.dmG)
        {
          paramAppInterface = jpa.r(paramb.cJK, "returnIndex=true");
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("url", paramAppInterface);
          ((Intent)localObject1).putExtra("reportSourceFrom", paramb.ewI);
          ((Intent)localObject1).putExtra("startOpenPageTime", paramb.clickTime);
          avcv.h(paramActivity, (Intent)localObject1, -1);
          if (QLog.isColorLevel()) {
            QLog.d("VipComicJumpActivity", 2, "jump to comic activity page directly, url=" + paramAppInterface);
          }
          return true;
        }
        localObject1 = new ArrayList();
        j = paramActivity.getResources().getDimensionPixelSize(2131299627);
        i = j;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          i = j + ImmersiveUtils.getStatusBarHeight(paramActivity);
        }
        i = (int)((i - 0.5F) / paramActivity.getResources().getDisplayMetrics().density);
        paramAppInterface = avcz.hx();
        if ((paramAppInterface != null) && (!paramAppInterface.isEmpty()))
        {
          localObject2 = paramAppInterface.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (avcz.a)((Iterator)localObject2).next();
            localObject4 = new WebViewTabBarData();
            ((WebViewTabBarData)localObject4).tag = ((avcz.a)localObject3).cJM;
            ((WebViewTabBarData)localObject4).tabName = ((avcz.a)localObject3).tabName;
            if (TextUtils.equals(((avcz.a)localObject3).cJM, "index")) {}
            for (paramAppInterface = "&redDotIds=" + paramb.cJJ;; paramAppInterface = "")
            {
              ((WebViewTabBarData)localObject4).url = jpa.r(((avcz.a)localObject3).cJN, "_cfrom=" + paramb.ewI + "&hasRedDot=" + paramb.th(((avcz.a)localObject3).cJM) + "&_titleBarHeight=" + i + paramAppInterface);
              ((WebViewTabBarData)localObject4).tabIcon = avcz.rB(((avcz.a)localObject3).cJO);
              ((ArrayList)localObject1).add(localObject4);
              break;
            }
          }
        }
        else
        {
          paramAppInterface = new WebViewTabBarData();
          paramAppInterface.tag = "index";
          paramAppInterface.tabName = acfp.m(2131716515);
          paramAppInterface.url = c("comicIndex", null, "64", "5", "", null, "_cfrom=" + paramb.ewI + "&hasRedDot=" + paramb.th("index") + "&_titleBarHeight=" + i + "&redDotIds=" + paramb.cJJ);
          localObject2 = new WebViewTabBarData();
          ((WebViewTabBarData)localObject2).tag = "fav";
          ((WebViewTabBarData)localObject2).tabName = acfp.m(2131716509);
          ((WebViewTabBarData)localObject2).url = c("comicFav", null, "", "1", "354", "%7B%22tabNum%22%3A2%2C%22subTextArray%22%3A%5B%22%E6%94%B6%E8%97%8F%22%2C%22%E4%B8%8B%E8%BD%BD%22%5D%7D", "_cfrom=" + paramb.ewI + "&hasRedDot=" + paramb.th("fav") + "&_titleBarHeight=" + i);
          localObject3 = new WebViewTabBarData();
          ((WebViewTabBarData)localObject3).tag = "category";
          ((WebViewTabBarData)localObject3).tabName = acfp.m(2131716512);
          ((WebViewTabBarData)localObject3).url = c("comicCategory", null, null, "1", "354", null, "_cfrom=" + paramb.ewI + "&hasRedDot=" + paramb.th("category") + "&_titleBarHeight=" + i);
          localObject4 = new WebViewTabBarData();
          ((WebViewTabBarData)localObject4).tag = "more";
          ((WebViewTabBarData)localObject4).tabName = acfp.m(2131716593);
          ((WebViewTabBarData)localObject4).url = c("comicMore", null, null, "1", "354", null, "_cfrom=" + paramb.ewI + "&hasRedDot=" + paramb.th("more") + "&_titleBarHeight=" + i);
          WebViewTabBarData localWebViewTabBarData = new WebViewTabBarData();
          localWebViewTabBarData.tag = "group";
          localWebViewTabBarData.tabName = acfp.m(2131716521);
          localWebViewTabBarData.url = c("comicGroup", null, null, "1", "354", null, "_cfrom=" + paramb.ewI + "&hasRedDot=" + paramb.th("group") + "&_titleBarHeight=" + i);
          ((ArrayList)localObject1).add(paramAppInterface);
          ((ArrayList)localObject1).add(localObject2);
          ((ArrayList)localObject1).add(localObject3);
          ((ArrayList)localObject1).add(localObject4);
          ((ArrayList)localObject1).add(localWebViewTabBarData);
        }
        if (QLog.isColorLevel())
        {
          paramAppInterface = ((ArrayList)localObject1).iterator();
          while (paramAppInterface.hasNext())
          {
            localObject2 = (WebViewTabBarData)paramAppInterface.next();
            QLog.d("VipComicJumpActivity", 2, "tabBar:tabKey=" + ((WebViewTabBarData)localObject2).tag + ", tabName=" + ((WebViewTabBarData)localObject2).tabName + ", tabUrl=" + ((WebViewTabBarData)localObject2).url);
          }
        }
        i = 0;
        if (paramb.cJG == null) {
          break label1920;
        }
      }
      label1920:
      for (int j = b(paramb.cJG, (List)localObject1);; j = 0)
      {
        paramAppInterface = (WebViewTabBarData)((ArrayList)localObject1).get(j);
        paramAppInterface.url = jpa.r(paramAppInterface.url, "isDefaultTab=1");
        if (paramb.cJH != null) {}
        try
        {
          i = Integer.parseInt(paramb.cJH);
          if ((!TextUtils.isEmpty(paramb.cJE)) && (j >= 0) && (j < ((ArrayList)localObject1).size()))
          {
            paramAppInterface = (WebViewTabBarData)((ArrayList)localObject1).get(j);
            paramAppInterface.url = jpa.r(paramAppInterface.url, "extUrlParam=" + URLEncoder.encode(paramb.cJE));
          }
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("tabConfigData", (Serializable)localObject1);
          ((Intent)localObject2).putExtra("reportSourceFrom", paramb.ewI);
          ((Intent)localObject2).putExtra("startOpenPageTime", paramb.clickTime);
          ((Intent)localObject2).putExtra("key_maintab", j);
          ((Intent)localObject2).putExtra("tabDefaultIndex", j);
          ((Intent)localObject2).putExtra("key_subtab", i);
          if (TextUtils.isEmpty(paramb.cJI))
          {
            paramAppInterface = paramActivity.getString(2131691039);
            ((Intent)localObject2).putExtra("selfSet_leftViewText", paramAppInterface);
            if ((paramb.ewI == 1006002) || (paramb.ewI == 1006003))
            {
              if (paramb.ewI != 1006002) {
                break label1732;
              }
              i = 40400;
              ((Intent)localObject2).putExtra("individuation_url_type", i);
            }
            if (paramb.dmD) {
              ((Intent)localObject2).setFlags(((Intent)localObject2).getFlags() | 0x4000000 | 0x10000000);
            }
            avcv.h(paramActivity, (Intent)localObject2, -1);
            VipUtils.a(null, "VIPCOMIC", "0X8005FC8", "0X8005FC8", paramb.ewI, 0, new String[] { String.valueOf(System.currentTimeMillis() - paramb.startTime) });
            if (QLog.isColorLevel()) {
              QLog.d("QQComicDebug", 2, "handle param open main tab end");
            }
            return true;
          }
        }
        catch (Exception paramAppInterface)
        {
          for (;;)
          {
            i = 0;
            continue;
            paramAppInterface = paramb.cJI;
            continue;
            label1732:
            i = 40401;
          }
        }
        if ("com.qqcomic.activity.VipComicTabBrowserActivity".equals(paramb.cJF))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("url", paramb.jumpurl);
          ((Intent)localObject1).putExtra("reportSourceFrom", paramb.ewI);
          ((Intent)localObject1).putExtra("startOpenPageTime", paramb.clickTime);
          if (TextUtils.isEmpty(paramb.cJI)) {}
          for (paramAppInterface = paramActivity.getString(2131691039);; paramAppInterface = paramb.cJI)
          {
            ((Intent)localObject1).putExtra("selfSet_leftViewText", paramAppInterface);
            avcv.h(paramActivity, (Intent)localObject1, -1);
            VipUtils.a(null, "VIPCOMIC", "0X8005FC8", "0X8005FC8", paramb.ewI, 0, new String[] { String.valueOf(System.currentTimeMillis() - paramb.startTime) });
            if (QLog.isColorLevel()) {
              QLog.d("QQComicDebug", 2, "handle param open web end");
            }
            return true;
          }
        }
        paramb.dmE = true;
        if (QLog.isColorLevel()) {
          QLog.d("QQComicDebug", 2, "handle param end");
        }
        return false;
      }
    }
  }
  
  static boolean a(String paramString, List<String> paramList, b paramb)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = null;
      try
      {
        paramString = new JSONObject(paramString).optJSONObject("msg");
        if (paramString != null)
        {
          paramList = paramList.iterator();
          for (;;)
          {
            if (!paramList.hasNext()) {
              break label184;
            }
            localObject = (String)paramList.next();
            try
            {
              localObject = paramString.optJSONObject((String)localObject);
              if (localObject != null)
              {
                localObject = ((JSONObject)localObject).optString("content");
                if (!TextUtils.isEmpty((CharSequence)localObject))
                {
                  localObject = new JSONObject((String)localObject);
                  paramb.dmG = "redirect".equals(((JSONObject)localObject).optString("type"));
                  if (paramb.dmG)
                  {
                    localObject = ((JSONObject)localObject).optString("link");
                    if (!TextUtils.isEmpty((CharSequence)localObject)) {
                      break;
                    }
                    paramb.dmG = false;
                  }
                }
              }
            }
            catch (Exception localException)
            {
              QLog.e("VipComicJumpActivity", 1, "parse red mission failed", localException);
            }
          }
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          QLog.e("VipComicJumpActivity", 1, "parse red failed", paramString);
          paramString = localException;
        }
        paramb.cJK = localException;
        return true;
      }
    }
    label184:
    return false;
  }
  
  public static int b(String paramString, List<WebViewTabBarData> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if (((WebViewTabBarData)paramList.get(i)).tag.equals(paramString)) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  public static String c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    String str2 = (String)aqqj.aB().get(paramString1);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = avej.getUrl(paramString1);
    }
    return d(str1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
  }
  
  public static String d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    StringBuilder localStringBuilder = aurn.d();
    if (!TextUtils.isEmpty(paramString7)) {
      localStringBuilder.append(paramString7);
    }
    if ((!TextUtils.isEmpty(paramString2)) && (!paramString1.contains("_wv=")))
    {
      localStringBuilder.append("&_wv=");
      localStringBuilder.append(paramString2);
    }
    if ((!TextUtils.isEmpty(paramString3)) && (!paramString1.contains("_wwv=")))
    {
      localStringBuilder.append("&_wwv=");
      localStringBuilder.append(paramString3);
    }
    if ((!TextUtils.isEmpty(paramString4)) && (!paramString1.contains("_cwv=")))
    {
      localStringBuilder.append("&_cwv=");
      localStringBuilder.append(paramString4);
    }
    if ((!TextUtils.isEmpty(paramString5)) && (!paramString1.contains("_sonic_id=")) && (!paramString1.contains("_bid=")))
    {
      localStringBuilder.append("&_bid=");
      localStringBuilder.append(paramString5);
    }
    if ((!TextUtils.isEmpty(paramString6)) && (!paramString1.contains("channel=")))
    {
      localStringBuilder.append("&channel=");
      localStringBuilder.append(paramString6);
    }
    if ((localStringBuilder.length() > 0) && (localStringBuilder.charAt(0) == '&')) {
      localStringBuilder.deleteCharAt(0);
    }
    return jpa.r(paramString1, localStringBuilder.toString());
  }
  
  public static void d(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "init plugin before enter start");
    }
    if ((paramAppInterface instanceof QQAppInterface))
    {
      MqqHandler localMqqHandler = paramAppInterface.getHandler(Conversation.class);
      if (localMqqHandler != null)
      {
        Message localMessage1 = localMqqHandler.obtainMessage(1134028);
        Message localMessage2 = localMqqHandler.obtainMessage(1134040);
        localMqqHandler.sendMessageDelayed(localMessage1, 1000L);
        localMqqHandler.sendMessageDelayed(localMessage2, 1000L);
      }
      avda.eN((QQAppInterface)paramAppInterface);
      avdi.eN((QQAppInterface)paramAppInterface);
      if (paramBoolean) {
        ThreadManager.postImmediately(new VipComicJumpActivity.1((QQAppInterface)paramAppInterface), null, true);
      }
      paramAppInterface = (afil)paramAppInterface.getBusinessHandler(80);
      if (paramAppInterface != null) {
        paramAppInterface.cZO();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "init plugin before enter end");
      }
      return;
      paramAppInterface = new Bundle();
      paramAppInterface.putBoolean("doLoadModule", paramBoolean);
      QIPCClientHelper.getInstance().getClient().callServer("QQComicIPCModule", "initPluginBeforeEnter", paramAppInterface);
    }
  }
  
  void a(Activity paramActivity, b paramb)
  {
    if ((paramActivity == null) || (paramb == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "call start plugin activity start.");
    }
    Intent localIntent = paramb.mIntent;
    localIntent.putExtra("begin_to_load_comic_plugin", System.currentTimeMillis());
    localIntent.putExtra("startOpenPageTime", paramb.clickTime);
    localIntent.putExtra("pluginFinished", this.downloadTime);
    if (!TextUtils.isEmpty(paramb.jumpurl)) {
      localIntent.putExtra("url", paramb.jumpurl);
    }
    if (paramb.a != null)
    {
      localIntent.putExtra("key_comic_id", paramb.a.cJz);
      localIntent.putExtra("key_section_id", paramb.a.cJA);
      localIntent.putExtra("key_pic_id", paramb.a.cJB);
      localIntent.putExtra("key_pic_offset_ratio", paramb.a.ewG);
      localIntent.putExtra("key_type", paramb.a.type);
      localIntent.putExtra("key_jump_from_out_plugin", true);
      localIntent.putExtra("key_return_to_detail", paramb.dmA);
      localIntent.putExtra("key_is_player_locked", paramb.dmC);
      localIntent.putExtra("key_return_to_home_from_detail", paramb.dmB);
      localIntent.putExtra("key_is_fullscreen", paramb.cxZ);
      localIntent.putExtra("key_video_player_type", paramb.a.ewH);
      localIntent.putExtra("key_cloud_url", paramb.a.cJD);
      localIntent.putExtra("key_from_out_entry", true);
      if (!TextUtils.isEmpty(paramb.a.cJC)) {
        localIntent.putExtra("url", paramb.a.cJC);
      }
    }
    localIntent.putExtra("key_source_from", paramb.ewI);
    if (TextUtils.isEmpty(paramb.cJI))
    {
      localIntent.putExtra("selfSet_leftViewText", getString(2131691039));
      label351:
      if (paramb.dmD) {
        localIntent.addFlags(67108864);
      }
      localIntent.putExtra("reportSourceFrom", paramb.ewI);
      if (!this.dmx) {
        break label615;
      }
    }
    label615:
    for (int i = 1;; i = 0)
    {
      localIntent.putExtra("reportProcessExistFlag", i);
      localIntent.putExtra("reportLebaClick", paramb.clickTime);
      localIntent.putExtra("reportJumpActivityOnCreate", paramb.startTime);
      if ((paramb.startTime != 0L) && (this.downloadTime != 0L) && (this.downloadTime > paramb.startTime)) {
        localIntent.putExtra("reportDownloadTime", this.downloadTime - paramb.startTime);
      }
      if ((this.installTime != 0L) && (this.downloadTime != 0L) && (this.installTime > this.downloadTime)) {
        localIntent.putExtra("reportInstallTime", this.installTime - this.downloadTime);
      }
      localIntent.putExtra("reportStartPluginTime", System.currentTimeMillis());
      localIntent.putExtra("isFromJumpActivity", true);
      avcm.a locala = avcm.a(2);
      ahyh localahyh = null;
      if (locala != null)
      {
        locala.dqV();
        localahyh = locala.a;
      }
      aveb.a(paramActivity, localIntent, paramb.cJF, localahyh);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQComicDebug", 2, "call start plugin activity end.");
      return;
      localIntent.putExtra("selfSet_leftViewText", paramb.cJI);
      break label351;
    }
  }
  
  public void a(b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "init plugin start");
    }
    d(this.app, false);
    ThreadManager.postImmediately(new VipComicJumpActivity.2(this, this.app, paramb), null, true);
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "init plugin end");
    }
  }
  
  void a(b paramb, int paramInt)
  {
    if (paramb == null) {
      return;
    }
    this.launchTime = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        if (this.app == null) {
          continue;
        }
        localObject1 = (acle)this.app.getBusinessHandler(13);
        if (localObject1 == null) {
          continue;
        }
        i = ((acle)localObject1).AX();
        if (i != 1) {
          continue;
        }
        localObject1 = "2";
      }
      catch (Exception localException)
      {
        Object localObject1;
        int i;
        localException.printStackTrace();
        Object localObject2 = "1";
        continue;
        if ((paramb.startTime == 0L) || (this.downloadTime == 0L) || (this.downloadTime <= paramb.startTime)) {
          continue;
        }
        String str1 = this.downloadTime - paramb.startTime + "";
        continue;
        String str4 = "0";
        continue;
        String str3 = "0";
        continue;
        String str2 = "0";
        continue;
        str1 = "0";
        continue;
        str1 = "1";
        continue;
      }
      localObject2 = localObject1;
      if (!this.dmx) {
        continue;
      }
      localObject1 = "-1";
      if ((this.installTime == 0L) || (this.downloadTime == 0L) || (this.installTime <= this.downloadTime)) {
        continue;
      }
      str2 = this.installTime - this.downloadTime + "";
      if ((this.installTime == 0L) || (this.launchTime == 0L) || (this.launchTime <= this.installTime)) {
        continue;
      }
      str3 = this.launchTime - this.installTime + "";
      if ((paramb.startTime == 0L) || (this.launchTime == 0L) || (this.launchTime <= paramb.startTime)) {
        continue;
      }
      str4 = this.launchTime - paramb.startTime + "";
      if (QLog.isColorLevel()) {
        QLog.d("VipComicJumpActivity", 2, "downloadCost:" + (String)localObject1 + ", installCost:" + str2 + ", launchCost:" + str3 + ", allCost:" + str4 + ",[startTime-launchTime]=[" + paramb.startTime + "-" + this.launchTime + "]");
      }
      VipUtils.a(null, "VIPCOMIC", "0X80052CA", "0X80052CA", paramb.ewI, paramInt, new String[] { localObject2 });
      VipUtils.a(null, "VIPCOMIC", "0X8005359", "0X8005359", paramb.ewI, paramInt, new String[] { localObject1, str2, str3, str4 });
      return;
      if (i != 3) {
        continue;
      }
      localObject1 = "3";
    }
  }
  
  void b(b paramb)
  {
    if (paramb == null) {
      return;
    }
    Object localObject = ((ActivityManager)getApplication().getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!"com.tencent.mobileqq:tool".equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName));
    }
    for (int i = 1;; i = 0)
    {
      if (paramb.dmE) {
        this.jdField_a_of_type_Auru.sendEmptyMessage(1000);
      }
      this.dmx = QIPCServerHelper.getInstance().isModuleRunning("comic_plugin.apk");
      if (!this.dmx)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQComicDebug", 2, "plugin is not running...");
        }
        if (i == 0) {
          SystemClock.sleep(500L);
        }
        aveb.gl(this);
        VipUtils.a(null, "VIPCOMIC", "0X8005FCE", "0X8005FCE", paramb.ewI, 0, new String[] { String.valueOf(System.currentTimeMillis() - paramb.startTime), "1" });
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQComicDebug", 2, "plugin is running...");
      return;
    }
  }
  
  public void c(b paramb)
  {
    if (paramb == null) {
      return;
    }
    if (!paramb.dmE)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "skip launch activity.");
      }
      finish();
      return;
    }
    a(this, paramb);
    VipUtils.a(null, "VIPCOMIC", "0X8005FC8", "0X8005FC8", paramb.ewI, 0, new String[] { String.valueOf(System.currentTimeMillis() - paramb.startTime) });
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    b localb = a(getIntent());
    this.jdField_a_of_type_CooperationComicVipComicJumpActivity$b = localb;
    if (a(this.app, this, localb)) {
      finish();
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED");
    paramBundle.addAction("com.tencent.mobileqq.PreLoadComicProcess");
    this.mReceiver = new d();
    getApplicationContext().registerReceiver(this.mReceiver, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("VipComicJumpActivity", 2, "VipComicJumpActivity.doOnCreate registerReceiver");
    }
    setContentView(2131563319);
    setTitle(2131721802);
    this.agd = ((TextView)findViewById(2131370807));
    this.age = ((TextView)findViewById(2131370811));
    this.jdField_a_of_type_Avfw = ((avfw)this.app.getManager(27));
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("VipComicJumpActivity onCreate mPluginManager = ");
      if (this.jdField_a_of_type_Avfw != null) {
        break label284;
      }
    }
    label284:
    for (paramBundle = "null";; paramBundle = Boolean.valueOf(this.jdField_a_of_type_Avfw.isReady()))
    {
      QLog.d("VipComicJumpActivity", 2, paramBundle);
      this.jdField_a_of_type_Auru = new auru(this);
      VipUtils.a(null, "VIPCOMIC", "0X8005FC7", "0X8005FC7", localb.ewI, 0, new String[] { String.valueOf(System.currentTimeMillis() - localb.startTime) });
      paramBundle = (avcq)this.app.getManager(142);
      if (paramBundle != null)
      {
        paramBundle.nC(System.currentTimeMillis());
        paramBundle.ezu();
      }
      a(localb);
      return true;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = false;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      bool = true;
      do
      {
        return bool;
      } while (this.jdField_a_of_type_CooperationComicVipComicJumpActivity$b == null);
      if (!this.dmy)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQComicDebug", 2, "do handle launch activity.");
        }
        this.dmy = true;
        this.dmz = true;
        c(this.jdField_a_of_type_CooperationComicVipComicJumpActivity$b);
        VipUtils.a(null, "VIPCOMIC", "0X8005FCE", "0X8005FCE", this.jdField_a_of_type_CooperationComicVipComicJumpActivity$b.ewI, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_CooperationComicVipComicJumpActivity$b.startTime), "2" });
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("QQComicDebug", 2, "skip handle launch activity.");
        continue;
        String str = paramMessage.arg1 + "%";
        paramMessage = String.valueOf(paramMessage.obj);
        this.age.setText(str);
        this.agd.setText(paramMessage);
      }
    }
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_Avfw.b("comic_plugin.apk");
    boolean bool = getIntent().getBooleanExtra("has_red_dot", false);
    int i;
    if (this.jdField_a_of_type_CooperationComicVipComicJumpActivity$b != null)
    {
      if (localObject != null) {
        break label167;
      }
      j = this.jdField_a_of_type_CooperationComicVipComicJumpActivity$b.ewI;
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_CooperationComicVipComicJumpActivity$b.startTime;
      if (!this.dmx) {
        break label130;
      }
      i = 0;
      if (!bool) {
        break label159;
      }
    }
    label130:
    label159:
    for (localObject = "1";; localObject = "0")
    {
      VipUtils.a(null, "VIPCOMIC", "0X8005FCD", "0X8005FCD", j, 0, new String[] { String.valueOf(l1 - l2), "-9999", String.valueOf(i), localObject });
      return super.onBackEvent();
      if (this.dmy)
      {
        if (this.dmz)
        {
          i = 2;
          break;
        }
        i = 3;
        break;
      }
      i = 4;
      break;
    }
    label167:
    int j = this.jdField_a_of_type_CooperationComicVipComicJumpActivity$b.ewI;
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_CooperationComicVipComicJumpActivity$b.startTime;
    int k = ((PluginBaseInfo)localObject).mState;
    if (this.dmx)
    {
      i = 0;
      label204:
      if (!bool) {
        break label295;
      }
    }
    label295:
    for (localObject = "1";; localObject = "0")
    {
      VipUtils.a(null, "VIPCOMIC", "0X8005FCD", "0X8005FCD", j, 0, new String[] { String.valueOf(l1 - l2), String.valueOf(k), String.valueOf(i), localObject });
      break;
      if (this.dmy)
      {
        if (this.dmz)
        {
          i = 2;
          break label204;
        }
        i = 3;
        break label204;
      }
      i = 4;
      break label204;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Auru != null)
    {
      this.jdField_a_of_type_Auru.removeMessages(1000);
      this.jdField_a_of_type_Auru.removeMessages(1001);
    }
    if (this.mReceiver != null) {}
    try
    {
      getApplicationContext().unregisterReceiver(this.mReceiver);
      if (QLog.isColorLevel()) {
        QLog.i("VipComicJumpActivity", 2, "VipComicJumpActivity.doOnCreate unregisterReceiver");
      }
      this.mReceiver = null;
      if (QLog.isColorLevel()) {
        QLog.d("VipComicJumpActivity", 2, "VipComicJumpActivity onDestroy");
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
  }
  
  static abstract class PluginCheckJob
    implements Runnable
  {
    final WeakReference<QQAppInterface> mAppRef;
    
    PluginCheckJob(QQAppInterface paramQQAppInterface)
    {
      this.mAppRef = new WeakReference(paramQQAppInterface);
    }
  }
  
  static class a
  {
    String cJA;
    String cJB;
    String cJC = "";
    String cJD;
    String cJz;
    int ewG;
    int ewH;
    int type;
  }
  
  public static class b
  {
    VipComicJumpActivity.a a = null;
    String cJE = null;
    String cJF = "com.qqcomic.activity.VipComicMainTabActivity";
    String cJG = null;
    String cJH = null;
    String cJI = null;
    String cJJ = "";
    String cJK = "";
    public long clickTime;
    boolean cxZ = false;
    boolean dmA = false;
    boolean dmB = false;
    boolean dmC = false;
    boolean dmD = true;
    boolean dmE = false;
    boolean dmF = false;
    boolean dmG = false;
    public int ewI;
    String jumpurl = "";
    Intent mIntent = new Intent();
    HashMap<String, Boolean> qt = new HashMap();
    long startTime = 0L;
    
    void dL(String paramString, boolean paramBoolean)
    {
      this.qt.put(paramString, Boolean.valueOf(paramBoolean));
    }
    
    boolean th(String paramString)
    {
      return (this.qt.get(paramString) != null) && (((Boolean)this.qt.get(paramString)).booleanValue());
    }
  }
  
  static class c
    implements aveb.a
  {
    private WeakReference<Handler> mHandler;
    
    c(Handler paramHandler)
    {
      this.mHandler = new WeakReference(paramHandler);
    }
    
    public void et(int paramInt, String paramString)
    {
      Handler localHandler = (Handler)this.mHandler.get();
      if (localHandler != null) {
        localHandler.obtainMessage(1001, paramInt, 0, paramString).sendToTarget();
      }
    }
  }
  
  class d
    extends BroadcastReceiver
  {
    private String cJL;
    private String mPluginID;
    
    d() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      this.mPluginID = paramIntent.getStringExtra("pluginsdk_pluginLocation");
      paramContext = paramIntent.getStringExtra("pluginsdk_launchReceiver");
      String str = paramIntent.getAction();
      if (((!TextUtils.isEmpty(str)) && ("com.tencent.mobileqq.PreLoadComicProcess".equals(str))) || ((paramContext != null) && (paramContext.equals("com.qqcomic.app.VipPreloadComicProcess")))) {
        if (!VipComicJumpActivity.this.dmy)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQComicDebug", 2, "do handle launch activity in receiver.");
          }
          VipComicJumpActivity.this.jdField_a_of_type_Auru.removeMessages(1000);
          VipComicJumpActivity.this.dmy = true;
          VipComicJumpActivity.this.dmz = false;
          VipComicJumpActivity.this.c(VipComicJumpActivity.this.jdField_a_of_type_CooperationComicVipComicJumpActivity$b);
        }
      }
      while ((this.mPluginID == null) || (!this.mPluginID.equalsIgnoreCase("comic_plugin.apk")))
      {
        do
        {
          return;
        } while (!QLog.isColorLevel());
        QLog.d("QQComicDebug", 2, "skip handle launch activity in receiver.");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipComicJumpActivity", 2, "LaunchCompletedObserver.onReceive: " + this.mPluginID);
      }
      this.cJL = paramIntent.getStringExtra("pluginsdk_extraInfo");
      if ((this.cJL != null) && ("success".equals(this.cJL))) {
        VipComicJumpActivity.this.a(VipComicJumpActivity.this.jdField_a_of_type_CooperationComicVipComicJumpActivity$b, 0);
      }
      for (;;)
      {
        VipComicJumpActivity.this.finish();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQComicDebug", 2, "launch activity finish, leave jump activity.");
        return;
        VipComicJumpActivity.this.a(VipComicJumpActivity.this.jdField_a_of_type_CooperationComicVipComicJumpActivity$b, -2);
        if (QLog.isColorLevel()) {
          QLog.d("VipComicJumpActivity", 2, "LaunchCompletedObserver.onReceive mExtraInfo: " + this.cJL);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.comic.VipComicJumpActivity
 * JD-Core Version:    0.7.0.1
 */