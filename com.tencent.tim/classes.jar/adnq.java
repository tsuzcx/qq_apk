import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkViewModelBase.TimeRecord;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.Container;
import com.tencent.ark.ark.ModuleCallbackWrapper;
import com.tencent.ark.ark.ModuleRegister;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppInfo.TimeRecord;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.security.ArkAppUrlChecker;
import com.tencent.ark.open.security.ArkBaseUrlChecker;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatFragment;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.QQHeadDownloadHandler;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.1;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.10;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.11;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.12;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.13;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.14;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.15;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.16;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.17;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.18;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.19;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.21;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.22;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.5;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.6;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.8;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.9;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.ArkReportData;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class adnq
{
  public static void RegisterModules(ark.ModuleRegister paramModuleRegister, ark.Application paramApplication)
  {
    Object localObject1 = paramApplication.GetSpecific("appName");
    paramApplication.GetSpecific("appPath");
    if ((localObject1 != null) && (((String)localObject1).indexOf("com.tencent.", 0) == -1)) {}
    for (long l = 1L;; l = 0L)
    {
      Object localObject2 = getAppInterface();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (localObject2 != null))
      {
        localObject1 = (ArkAppCenter)((QQAppInterface)localObject2).getManager(121);
        if (localObject1 == null) {}
      }
      for (localObject1 = ((ArkAppCenter)localObject1).a();; localObject1 = null)
      {
        localObject2 = new ArrayList();
        ((List)localObject2).add(new adnq.c(paramApplication, l));
        ((List)localObject2).add(new admn(paramApplication, l));
        if (1 == BaseApplicationImpl.sProcessId)
        {
          ((List)localObject2).add(new adnc(paramApplication, l));
          ((List)localObject2).add(new adon(paramApplication, l));
        }
        if (l == 0L) {
          ((List)localObject2).add(new adoh(paramApplication, l));
        }
        paramApplication = ((List)localObject2).iterator();
        while (paramApplication.hasNext())
        {
          localObject2 = (adnq.b)paramApplication.next();
          if (localObject1 != null) {
            ((adnq.b)localObject2).jB((List)adph.jJ.get(((adnq.b)localObject2).GetTypeName()));
          }
          paramModuleRegister.RegCallbackWrapper((ark.ModuleCallbackWrapper)localObject2);
        }
        return;
      }
    }
  }
  
  private static int a(ark.VariantWrapper[] paramArrayOfVariantWrapper, long paramLong)
  {
    int i = 2;
    int k = 0;
    if (paramLong >= 2L)
    {
      paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[1];
      String[] arrayOfString;
      int j;
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.GetType() == 5) && (paramArrayOfVariantWrapper.GetString() != null))
      {
        paramArrayOfVariantWrapper = paramArrayOfVariantWrapper.GetString().toLowerCase();
        arrayOfString = new String[8];
        arrayOfString[0] = "d";
        arrayOfString[1] = "debug";
        arrayOfString[2] = "i";
        arrayOfString[3] = "info";
        arrayOfString[4] = "e";
        arrayOfString[5] = "error";
        arrayOfString[6] = "w";
        arrayOfString[7] = "warning";
        if (!arrayOfString[0].equals(paramArrayOfVariantWrapper))
        {
          j = i;
          if (!arrayOfString[1].equals(paramArrayOfVariantWrapper)) {}
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label204;
          }
          j = 0;
          k = 1;
        }
      }
      for (;;)
      {
        int m = i;
        if (k == 0)
        {
          m = i;
          if (j == 0) {
            m = 1;
          }
        }
        return m;
        do
        {
          j += 1;
          if (j >= arrayOfString.length) {
            break;
          }
        } while (!arrayOfString[j].equals(paramArrayOfVariantWrapper));
        j = 1;
        i = 1;
        continue;
        return 1;
        i = 4;
        j = 0;
        continue;
        label204:
        i = 4;
        j = 0;
        k = 1;
      }
    }
    return 4;
  }
  
  protected static Intent a(Context paramContext, String paramString1, boolean paramBoolean, long paramLong, MessageForArkApp paramMessageForArkApp, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName("com.tencent.tim", "com.tencent.mobileqq.activity.QQBrowserDelegationActivity");
    localIntent.putExtra("param_force_internal_browser", paramBoolean);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("injectrecommend", false);
    localIntent.putExtra("browserType", paramInt);
    ArkAppCenter.r(localIntent, paramString2);
    if (!TextUtils.isEmpty(paramString4)) {
      localIntent.putExtra("big_brother_ref_source_key", paramString4);
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      if ((paramMessageForArkApp == null) || (paramMessageForArkApp.ark_app_message == null)) {
        break label846;
      }
      paramString1 = paramMessageForArkApp.ark_app_message.appView;
      paramString1 = ArkAppMgr.getInstance().getAppPathByNameFromLocal(paramString3, paramString1, null, false);
      if (!TextUtils.isEmpty(paramString1))
      {
        localIntent.putExtra("h5_ark_app_path", paramString1);
        paramString1 = ArkAppCacheMgr.getApplicationDesc(paramString3);
        if (!TextUtils.isEmpty(paramString1)) {
          localIntent.putExtra("h5_ark_app_des", paramString1);
        }
      }
      if ((paramMessageForArkApp != null) && (paramMessageForArkApp.ark_app_message != null) && (paramMessageForArkApp.buildTypeAndTitle().isSdkShare)) {
        localIntent.putExtra("h5_ark_is_from_share", true);
      }
      localIntent.putExtra("h5_ark_app_name", paramString3);
      paramString1 = ArkAppConfigMgr.getInstance().getUrlChecker(paramString3);
      if (paramString1 != null)
      {
        paramString1 = paramString1.getAppNavigationChecker();
        if (paramString1 != null)
        {
          localIntent.putExtra("h5_ark_url_web_checker", paramString1);
          boolean bool1 = ArkAppConfigMgr.getInstance().isUrlCheckEnable(paramString3);
          boolean bool2 = adqr.afw();
          if ((!bool1) || (bool2)) {
            break label853;
          }
          paramBoolean = true;
          label263:
          localIntent.putExtra("h5_ark_url_web_checker_enable", paramBoolean);
          localIntent.putExtra("h5_ark_url_web_sender_uin", wyw.aUB);
          if (bool2) {
            localIntent.putExtra("puin", wyw.aUB);
          }
          QLog.d("ArkApp", 1, new Object[] { "ArkSafe.UrlCheck.launchQQBrowser,appname=", paramString3, ", enableCheck=", Boolean.valueOf(paramBoolean), ", appEnableCheck=", Boolean.valueOf(bool1), ", isPublicAccount=", Boolean.valueOf(bool2), ", senderUin=", wyw.aUB, ", mUrlChecker=", paramString1.toString() });
          adst.a().a(new adns());
        }
      }
    }
    paramString1 = aeiy.b(186).getContent();
    if (!TextUtils.isEmpty(paramString1)) {
      localIntent.putExtra("h5_ark_check_config", paramString1);
    }
    paramString1 = sH();
    paramString2 = q(true);
    if (!TextUtils.isEmpty(paramString1)) {
      localIntent.putExtra("h5_ark_nation_code", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("h5_ark_phone_number", paramString2);
    }
    if (paramMessageForArkApp != null)
    {
      paramString1 = paramMessageForArkApp.ark_app_message;
      label494:
      if (paramString1 != null)
      {
        localIntent.putExtra("forward_ark_app_direct", false);
        localIntent.putExtra("forward_ark_app_name", paramString1.appName);
        localIntent.putExtra("forward_ark_app_view", paramString1.appView);
        paramString3 = paramString1.metaList;
        paramString2 = paramString3;
        if (TextUtils.isEmpty(paramString3)) {
          paramString2 = "{}";
        }
        localIntent.putExtra("forward_ark_app_meta", paramString2);
        localIntent.putExtra("forward_ark_app_config", paramString1.config);
        localIntent.putExtra("forward_ark_from_h5", true);
        if (TextUtils.isEmpty(paramString1.appId)) {
          break label863;
        }
        localIntent.putExtra("forward_appId_ark_from_sdk", paramString1.appId);
        localIntent.putExtra("struct_share_key_source_name", paramString1.mSourceName);
        localIntent.putExtra("struct_share_key_source_action_data", paramString1.mSourceActionData);
        localIntent.putExtra("struct_share_key_source_a_action_data", paramString1.mSource_A_ActionData);
        localIntent.putExtra("struct_share_key_source_url", paramString1.mSourceUrl);
        adqu.a(getAppInterface(), paramString1.appName, "AIOArkSdkCardClick", 1, 0, 0L, 0L, 0L, paramString1.appView, "");
      }
    }
    for (;;)
    {
      if (paramMessageForArkApp.istroop == 0) {
        localIntent.putExtra("friend_uin", paramMessageForArkApp.frienduin);
      }
      if (paramMessageForArkApp.istroop == 1) {
        localIntent.putExtra("groupUin", paramMessageForArkApp.frienduin);
      }
      if (paramMessageForArkApp.istroop == 3000) {
        localIntent.putExtra("dicussgroup_uin", paramMessageForArkApp.frienduin);
      }
      localIntent.putExtra("friendUin", paramMessageForArkApp.senderuin);
      localIntent.putExtra("uinType", paramMessageForArkApp.istroop);
      localIntent.putExtra("is_send", paramMessageForArkApp.isSend());
      localIntent.putExtra("fromAio", true);
      localIntent.putExtra("appShareID", paramLong);
      localIntent.putExtra("forward_ark_app_direct", true);
      if (paramContext != null) {
        paramContext.startActivity(localIntent);
      }
      return localIntent;
      label846:
      paramString1 = "";
      break;
      label853:
      paramBoolean = false;
      break label263;
      paramString1 = null;
      break label494;
      label863:
      if (paramString1.from == 1) {
        adqu.a(getAppInterface(), paramString1.appName, "AIOArkMapCardClick ", 1, 0, 0L, 0L, 0L, paramString1.appView, "");
      }
    }
  }
  
  public static String a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("sessionInfo=[");
      localStringBuilder.append("curType:").append(paramSessionInfo.cZ);
      localStringBuilder.append(", curFriendUin:").append(paramSessionInfo.aTl);
      localStringBuilder.append(", troopUin:").append(paramSessionInfo.troopUin);
      localStringBuilder.append(", curFriendNick").append(paramSessionInfo.aTn);
      return localStringBuilder.toString();
    }
    return "sessionInfo=null";
  }
  
  private static String a(ark.VariantWrapper[] paramArrayOfVariantWrapper)
  {
    if (paramArrayOfVariantWrapper.length >= 3)
    {
      if ((paramArrayOfVariantWrapper[2].IsArray()) || (paramArrayOfVariantWrapper[2].IsTable())) {
        return paramArrayOfVariantWrapper[2].GetTableAsJsonString();
      }
      return "";
    }
    return "";
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, adnq.a parama)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (getAppInterface() != null)) {
      ArkAppMgr.getInstance().getAppPathByNameTimeout(3000L, paramString1, paramString2, "0.0.0.1", null, new adnr(paramString1, paramString3, parama));
    }
  }
  
  public static boolean a(String paramString1, long paramLong, ark.Application paramApplication, String paramString2)
  {
    boolean bool;
    if (paramLong == 0L) {
      bool = true;
    }
    for (;;)
    {
      if (!bool) {
        QLog.i("ArkApp", 1, String.format("ModuleCheckPermission.denied:Name:%s,Permission:%s.", new Object[] { paramString1, paramString2 }));
      }
      return bool;
      if ((paramApplication != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
        bool = paramApplication.CheckPermissions(paramString2);
      } else {
        bool = false;
      }
    }
  }
  
  public static long ai(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramString.indexOf("com.tencent.", 0) == -1) {
      return 1L;
    }
    return 0L;
  }
  
  public static SessionInfo b()
  {
    SessionInfo localSessionInfo = null;
    Object localObject1 = localSessionInfo;
    Object localObject2;
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      localObject2 = (FragmentActivity)BaseActivity.sTopActivity;
      localObject1 = (ChatFragment)((FragmentActivity)localObject2).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject1 == null) {
        break label94;
      }
      localObject1 = ((ChatFragment)localObject1).a();
      if (localObject1 == null) {
        break label162;
      }
      localSessionInfo = ((BaseChatPie)localObject1).a();
      localObject1 = localSessionInfo;
      if (QLog.isColorLevel())
      {
        QLog.d("ArkApp", 2, new Object[] { "multiAio.getTopChatSessionInfo form baseChatPie=", a(localSessionInfo) });
        localObject1 = localSessionInfo;
      }
    }
    for (;;)
    {
      return localObject1;
      label94:
      localObject1 = localSessionInfo;
      if ((localObject2 instanceof MiniChatActivity))
      {
        localObject2 = ((MiniChatActivity)localObject2).b();
        localObject1 = localSessionInfo;
        if ((localObject2 instanceof MiniChatFragment))
        {
          localSessionInfo = ((MiniChatFragment)localObject2).a();
          localObject1 = localSessionInfo;
          if (QLog.isColorLevel())
          {
            QLog.d("ArkApp", 2, new Object[] { "multiAio.getTopChatSessionInfo form miniChatPie=", a(localSessionInfo) });
            return localSessionInfo;
            label162:
            localObject1 = null;
          }
        }
      }
    }
  }
  
  protected static void bt(Context paramContext, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("file_send_path", paramString);
    localBundle.putInt("video_play_caller", 1);
    localBundle.putBoolean("video_title_bar_hide", true);
    paramString = new Intent(paramContext, ShortVideoPlayActivity.class);
    paramString.putExtras(localBundle);
    if (paramContext != null) {
      paramContext.startActivity(paramString);
    }
  }
  
  public static QQAppInterface getAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static boolean h(String paramString1, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    Object localObject2 = BaseActivity.sTopActivity;
    Object localObject1;
    Object localObject3;
    if (((localObject2 instanceof FragmentActivity)) && (!TextUtils.isEmpty(paramString1)))
    {
      localObject1 = (FragmentActivity)localObject2;
      if (((FragmentActivity)localObject1).getChatFragment() == null) {
        break label860;
      }
      localObject3 = ((FragmentActivity)localObject1).getChatFragment().a();
      if ((!(localObject3 instanceof ycd)) || (!"biz_src_ads".equals("biz_src_jc_ark"))) {
        break label860;
      }
      localObject1 = ocp.fq(((BaseChatPie)localObject3).sessionInfo.aTl);
      QLog.d("ArkApp", 1, "ArkSafe.OpenUrl set hsSourceID for " + ((BaseChatPie)localObject3).sessionInfo.aTl + ", input " + "biz_src_jc_ark" + ", output " + (String)localObject1);
    }
    label257:
    label647:
    for (;;)
    {
      if (adoj.a(paramString1, null, null, paramInt, paramString2))
      {
        adqu.a(null, paramString2, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
        Log.d("ark.OpenUrl ", paramString1);
        adqu.a(null, paramString2, "FullScreenOrH5Show", 0, 0, 0L, 0L, 0L, "", "");
        return true;
      }
      int j;
      int i;
      boolean bool2;
      boolean bool3;
      boolean bool1;
      if ((paramString1.startsWith("http://")) || (paramString1.startsWith("https://")))
      {
        localObject3 = ArkAppConfigMgr.getInstance().getUrlChecker(paramString2);
        paramInt = 1;
        if (localObject3 != null)
        {
          j = ((ArkAppUrlChecker)localObject3).checkUrlIsValidByAppNavigationList(paramString1);
          i = 0;
          if (j != 0) {
            break label470;
          }
          paramInt = 1;
          bool2 = ArkAppConfigMgr.getInstance().isUrlCheckEnable(paramString2);
          bool3 = adqr.afw();
          if ((!bool2) || (bool3)) {
            break label475;
          }
          bool1 = true;
          label284:
          if (QLog.isColorLevel()) {
            QLog.e("ArkApp", 2, new Object[] { "ArkSafe.UrlCheck.OpenUrl.http.appname=", paramString2, ", enableCheck=", Boolean.valueOf(bool1), ", appEnableCheck=", Boolean.valueOf(bool2), ", isPublicAccount=", Boolean.valueOf(bool3) });
          }
          if (paramInt != 0) {
            break label857;
          }
          i = 1;
          if (bool1) {
            break label857;
          }
          QLog.e("ArkApp", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.OpenUrl.http appName=", paramString2, ",url=", jqo.filterKeyForLog(paramString1, new String[0]), ", isValid set=true" });
          paramInt = 1;
          i = 2;
        }
      }
      label470:
      label854:
      label857:
      for (;;)
      {
        adtn.e(paramString2, paramString1, j, i, wyw.aUB);
        if (paramInt == 0)
        {
          QLog.d("ArkApp", 1, new Object[] { "ArkSafe.OpenUrl check url invalid!, url=", jqo.filterKeyForLog(paramString1, new String[0]), ", app=", paramString2 });
          return false;
          paramInt = 0;
          break label257;
          label475:
          bool1 = false;
          break label284;
        }
        localObject3 = (FragmentActivity)localObject2;
        if (((FragmentActivity)localObject3).getChatFragment() != null)
        {
          localObject3 = ((FragmentActivity)localObject3).getChatFragment().a();
          if (!(localObject3 instanceof ycd)) {
            break label545;
          }
          ((ycd)localObject3).b.dqV();
        }
        for (;;)
        {
          a((Context)localObject2, paramString1, true, 0L, null, "biz_src_jc_ark", 0, paramString2, (String)localObject1);
          break;
          adqu.a(null, paramString2, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
        }
        if (paramInt != 0) {
          break;
        }
        localObject1 = aqik.c(getAppInterface(), (Context)localObject2, paramString1);
        if (localObject1 == null) {
          break;
        }
        localObject2 = ArkAppConfigMgr.getInstance().getUrlChecker(paramString2);
        paramInt = 1;
        if (localObject2 != null)
        {
          j = ((ArkAppUrlChecker)localObject2).checkUrlIsValidByAppNavigationList(paramString1);
          i = 0;
          if (j != 0) {
            break label802;
          }
          paramInt = 1;
          label620:
          bool2 = ArkAppConfigMgr.getInstance().isUrlCheckEnable(paramString2);
          bool3 = adqr.afw();
          if ((!bool2) || (bool3)) {
            break label807;
          }
          bool1 = true;
          if (QLog.isColorLevel()) {
            QLog.e("ArkApp", 2, new Object[] { "ArkSafe.UrlCheck.OpenUrl.http.JumpAction=", paramString2, ", enableCheck=", Boolean.valueOf(bool1), ", appEnableCheck=", Boolean.valueOf(bool2), ", isPublicAccount=", Boolean.valueOf(bool3) });
          }
          if (paramInt != 0) {
            break label854;
          }
          i = 1;
          if (bool1) {
            break label854;
          }
          QLog.e("ArkApp", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.OpenUrl.jump appName=", paramString2, ",url=", jqo.filterKeyForLog(paramString1, new String[0]), ", isValid set=true" });
          paramInt = 1;
          i = 2;
        }
        for (;;)
        {
          adtn.e(paramString2, paramString1, j, i, wyw.aUB);
          if (paramInt != 0)
          {
            ((aqhv)localObject1).ace();
            break;
            paramInt = 0;
            break label620;
            bool1 = false;
            break label647;
          }
          QLog.e("ArkApp", 1, new Object[] { "ArkSafe.OpenUrl check url invalid, url=", jqo.filterKeyForLog(paramString1, new String[0]), ", app=", paramString2 });
          break;
        }
      }
      label545:
      label802:
      label807:
      label860:
      localObject1 = null;
    }
  }
  
  public static String q(boolean paramBoolean)
  {
    Object localObject = getAppInterface();
    if (localObject != null)
    {
      localObject = ((ajdo)((QQAppInterface)localObject).getManager(11)).a();
      String str = ((RespondQueryQQBindingStat)localObject).mobileNo;
      if (paramBoolean) {
        return str;
      }
      return ((RespondQueryQQBindingStat)localObject).nationCode + " " + str;
    }
    return "";
  }
  
  public static String sH()
  {
    QQAppInterface localQQAppInterface = getAppInterface();
    if (localQQAppInterface != null) {
      return ((ajdo)localQQAppInterface.getManager(11)).a().nationCode;
    }
    return "";
  }
  
  public static abstract interface a
  {
    public abstract void GC(boolean paramBoolean);
  }
  
  public static abstract class b
    implements ark.ModuleCallbackWrapper
  {
    public static boolean bPX = true;
    protected long Vj = 0L;
    protected long Vk = 1L;
    protected Map<String, Set<adnq.b.a>> jG = new HashMap();
    public String mAppID;
    public String mAppName;
    public String mAppPath;
    protected ark.Application mApplication;
    HashMap<Long, ark.VariantWrapper> mCallbackMap = new HashMap();
    
    protected b(ark.Application paramApplication, long paramLong)
    {
      this.mApplication = paramApplication;
      this.mAppName = paramApplication.GetSpecific("appName");
      this.mAppPath = paramApplication.GetSpecific("appPath");
      this.mAppID = paramApplication.GetID();
      this.Vj = paramLong;
    }
    
    public void Destruct()
    {
      Iterator localIterator = this.mCallbackMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((ark.VariantWrapper)((Map.Entry)localIterator.next()).getValue()).Reset();
      }
      this.mCallbackMap.clear();
    }
    
    long a(ark.VariantWrapper paramVariantWrapper)
    {
      if ((paramVariantWrapper == null) || (!paramVariantWrapper.IsFunction())) {
        return 0L;
      }
      this.Vk += 1L;
      if (this.Vk == 0L) {
        this.Vk = 1L;
      }
      this.mCallbackMap.put(Long.valueOf(this.Vk), paramVariantWrapper);
      return this.Vk;
    }
    
    public ark.VariantWrapper a(long paramLong)
    {
      ark.VariantWrapper localVariantWrapper = (ark.VariantWrapper)this.mCallbackMap.get(Long.valueOf(paramLong));
      this.mCallbackMap.remove(Long.valueOf(paramLong));
      return localVariantWrapper;
    }
    
    public ark.VariantWrapper b(long paramLong)
    {
      return (ark.VariantWrapper)this.mCallbackMap.get(Long.valueOf(paramLong));
    }
    
    protected void j(String paramString, long paramLong1, long paramLong2)
    {
      Object localObject;
      if ((!TextUtils.isEmpty(paramString)) && (paramLong2 > 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ArkApp", 2, String.format("ModuleBase.addTokenBucket.api:%s,times:%d,period:%d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
        }
        localObject = (Set)this.jG.get(paramString);
        if (localObject != null) {
          break label118;
        }
        localObject = new HashSet();
        this.jG.put(paramString, localObject);
      }
      label118:
      for (paramString = (String)localObject;; paramString = (String)localObject)
      {
        paramString.add(new adnq.b.a(paramLong1, paramLong2));
        return;
      }
    }
    
    public void jB(List<adph.a> paramList)
    {
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          adph.a locala = (adph.a)paramList.next();
          j(locala.buU, locala.Vl, locala.mPeriod);
        }
      }
    }
    
    protected boolean la(String paramString)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject = (Set)this.jG.get(paramString);
        if (localObject == null) {
          return true;
        }
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          adnq.b.a locala = (adnq.b.a)((Iterator)localObject).next();
          if (!locala.afm())
          {
            QLog.i("ArkApp", 2, String.format("ModuleBase.checkFrequency.Refuse:%s,%s ", new Object[] { paramString, locala.toString() }));
            return false;
          }
        }
        return true;
      }
      return false;
    }
    
    public class a
    {
      private long Vl;
      private double cp;
      private long mLastTimestamp;
      private long mPeriod;
      
      public a(long paramLong1, long paramLong2)
      {
        this.mPeriod = paramLong2;
        this.Vl = paramLong1;
        this.cp = paramLong1;
        this.mLastTimestamp = System.currentTimeMillis();
      }
      
      public boolean afm()
      {
        if (this.Vl == -1L) {
          return true;
        }
        if (this.mPeriod > 0L)
        {
          long l = System.currentTimeMillis();
          this.cp = Math.min(this.cp + (l - this.mLastTimestamp) * this.Vl / this.mPeriod, this.Vl);
          this.mLastTimestamp = l;
          if (this.cp >= 1.0D)
          {
            this.cp -= 1.0D;
            return true;
          }
        }
        return false;
      }
      
      public boolean equals(Object paramObject)
      {
        if (this == paramObject) {}
        do
        {
          return true;
          if ((paramObject == null) || (getClass() != paramObject.getClass())) {
            return false;
          }
          paramObject = (a)paramObject;
          if (this.Vl != paramObject.Vl) {
            return false;
          }
        } while (this.mPeriod == paramObject.mPeriod);
        return false;
      }
      
      public int hashCode()
      {
        return (int)(this.Vl ^ this.Vl >>> 32) * 31 + (int)(this.mPeriod ^ this.mPeriod >>> 32);
      }
      
      public String toString()
      {
        return String.format("TokenBucket:mTimes:%d,mPeriod:%d,mTokenCount:%f,mLastTimestamp:%d", new Object[] { Long.valueOf(this.Vl), Long.valueOf(this.mPeriod), Double.valueOf(this.cp), Long.valueOf(this.mLastTimestamp) });
      }
    }
  }
  
  public static class c
    extends adnq.b
  {
    private static long Vm;
    private static long Vn;
    private WtloginObserver b;
    protected wzl b;
    private WeakReference<aqju> gs;
    private HashMap<String, String> jC = new HashMap();
    private HashMap<String, String> jD = new HashMap();
    private HashMap<String, String> jz = new HashMap();
    
    public c(ark.Application paramApplication, long paramLong)
    {
      super(paramLong);
      this.jdField_b_of_type_Wzl = new wzl(this.mAppName, 30000L);
    }
    
    public static ArrayList<String> F(String paramString)
    {
      int i = 0;
      ArrayList localArrayList = new ArrayList();
      paramString = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0).getString("key_ark_authority_app_list_" + paramString, "");
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.split(";");
        if ((paramString != null) && (paramString.length > 0))
        {
          int j = paramString.length;
          while (i < j)
          {
            CharSequence localCharSequence = paramString[i];
            if (!TextUtils.isEmpty(localCharSequence)) {
              localArrayList.add(localCharSequence);
            }
            i += 1;
          }
        }
      }
      return localArrayList;
    }
    
    private void a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt)
    {
      Object localObject2 = adnq.getAppInterface();
      if ((localObject2 != null) && (1 == paramInt))
      {
        localObject1 = this.mAppName + "_" + paramLong3 + "_" + paramString;
        if ((this.jC.containsKey(localObject1)) && (!TextUtils.isEmpty((CharSequence)this.jC.get(localObject1))) && (this.jD.containsKey(localObject1)) && (!TextUtils.isEmpty((CharSequence)this.jD.get(localObject1))))
        {
          paramString = String.valueOf(paramLong3);
          if ((!this.jz.containsKey(this.mAppName)) || (!this.jz.containsValue(paramString))) {
            this.jz.put(this.mAppName, paramString);
          }
          paramString = a(paramLong1);
          if (paramString != null) {}
        }
      }
      do
      {
        return;
        localObject2 = paramString.Create();
        ((ark.VariantWrapper)localObject2).SetTableAsJsonString(String.format(Locale.CHINA, "{\"openid\":\"%s\",\"token\":\"%s\"}", new Object[] { this.jC.get(localObject1), this.jD.get(localObject1) }));
        localObject1 = paramString.Create();
        paramString.InvokeDefault(new ark.VariantWrapper[] { localObject2 }, (ark.VariantWrapper)localObject1);
        ((ark.VariantWrapper)localObject1).Reset();
        ((ark.VariantWrapper)localObject2).Reset();
        paramString.Reset();
        return;
        if (this.jdField_b_of_type_MqqObserverWtloginObserver == null) {
          this.jdField_b_of_type_MqqObserverWtloginObserver = new adnx(this, paramLong1);
        }
        ((WtloginManager)((QQAppInterface)localObject2).getManager(1)).GetOpenKeyWithoutPasswd(paramString, paramLong2, paramLong3, this.jdField_b_of_type_MqqObserverWtloginObserver);
        return;
        paramString = a(paramLong1);
      } while (paramString == null);
      Object localObject1 = paramString.Create();
      ((ark.VariantWrapper)localObject1).SetNull();
      localObject2 = paramString.Create();
      paramString.InvokeDefault(new ark.VariantWrapper[] { localObject1 }, (ark.VariantWrapper)localObject2);
      ((ark.VariantWrapper)localObject2).Reset();
      ((ark.VariantWrapper)localObject1).Reset();
      paramString.Reset();
    }
    
    private void d(long paramLong, boolean paramBoolean, String paramString)
    {
      ark.VariantWrapper localVariantWrapper1 = a(paramLong);
      if (localVariantWrapper1 == null)
      {
        QLog.e("ArkApp", 1, "Callback is null");
        return;
      }
      ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
      if (paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp", 2, "doCallbackForGetPskeyAsync : SetString");
        }
        localVariantWrapper2.SetString(paramString);
      }
      for (;;)
      {
        paramString = localVariantWrapper1.Create();
        localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, paramString);
        paramString.Reset();
        localVariantWrapper2.Reset();
        localVariantWrapper1.Reset();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp", 2, "doCallbackForGetPskeyAsync : SetNull");
        }
        localVariantWrapper2.SetNull();
      }
    }
    
    public static void fq(String paramString1, String paramString2)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      ArrayList localArrayList = F(paramString2);
      StringBuilder localStringBuilder = new StringBuilder("");
      int j = 0;
      int n = 0;
      int m;
      for (int i = 0; j < localArrayList.size(); i = m)
      {
        String str = (String)localArrayList.get(j);
        int k = n;
        m = i;
        if (!TextUtils.isEmpty(str))
        {
          if (n > 0) {
            localStringBuilder.append(";");
          }
          localStringBuilder.append(str);
          n += 1;
          k = n;
          m = i;
          if (str.equals(paramString1))
          {
            m = 1;
            k = n;
          }
        }
        j += 1;
        n = k;
      }
      if (i == 0)
      {
        if (n > 0) {
          localStringBuilder.append(";");
        }
        localStringBuilder.append(paramString1);
      }
      BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0).edit().putString("key_ark_authority_app_list_" + paramString2, localStringBuilder.toString()).commit();
    }
    
    public static int i(String paramString1, String paramString2, String paramString3)
    {
      return BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0).getInt("key_ark_authority_info" + "_" + paramString1 + "_" + paramString2 + "_" + paramString3, 0);
    }
    
    private void l(long paramLong, String paramString, int paramInt)
    {
      ark.VariantWrapper localVariantWrapper1 = a(paramLong);
      if (localVariantWrapper1 == null)
      {
        QLog.e("ArkApp", 1, "GetUserInformation.arkGetUserInformation call back is null");
        return;
      }
      ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
      QQAppInterface localQQAppInterface = adnq.getAppInterface();
      Object localObject;
      String str2;
      String str1;
      if ((localQQAppInterface != null) && (1 == paramInt))
      {
        localObject = ((acff)localQQAppInterface.getManager(51)).b(paramString);
        if (localObject != null)
        {
          str2 = ((Card)localObject).strNick;
          if (((Card)localObject).shGender == 0) {
            str1 = BaseActivity.sTopActivity.getString(2131695654);
          }
        }
      }
      for (;;)
      {
        String str3 = ((Card)localObject).strCity;
        String str4 = ((Card)localObject).strProvince;
        String str5 = ((Card)localObject).strCountry;
        localObject = "";
        paramString = localQQAppInterface.b(paramString);
        if ((paramString != null) && (!TextUtils.isEmpty(paramString.url))) {
          paramString = MsfSdkUtils.insertMtype("QQHeadIcon", ((FriendListHandler)localQQAppInterface.getBusinessHandler(1)).a().a(paramString.url, paramString.bFaceFlags, paramString.bUsrType, 0));
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArkApp", 2, "GetUserInformation nickname=" + str2 + ", avatarUrl=" + paramString + ", gender=" + str1 + ", city=" + str3 + ", province=" + str4 + ", country=" + str5);
          }
          localVariantWrapper2.SetTableAsJsonString(String.format(Locale.CHINA, "{\"nickname\":\"%s\",\"avatar\":\"%s\",\"gender\":\"%s\",\"city\":\"%s\",\"province\":\"%s\",\"country\":\"%s\"}", new Object[] { str2, paramString, str1, str3, str4, str5 }));
          paramInt = 0;
          if (paramInt != 0) {
            localVariantWrapper2.SetNull();
          }
          paramString = localVariantWrapper1.Create();
          localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, paramString);
          paramString.Reset();
          localVariantWrapper2.Reset();
          localVariantWrapper1.Reset();
          return;
          if (((Card)localObject).shGender != 1) {
            break label455;
          }
          str1 = BaseActivity.sTopActivity.getString(2131693477);
          break;
          paramString = (String)localObject;
          if (QLog.isColorLevel())
          {
            QLog.d("ArkApp", 2, "GetUserInformation QQHeadSetting is empty");
            paramString = (String)localObject;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp", 2, "GetUserInformation FriendCard is null");
        }
        for (;;)
        {
          paramInt = 1;
          break;
          QLog.i("ArkApp", 1, "GetUserInformation get value null for appInterface null, authState = " + paramInt);
        }
        label455:
        str1 = "";
      }
    }
    
    public static void p(String paramString1, String paramString2, String paramString3, int paramInt)
    {
      BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0).edit().putInt("key_ark_authority_info" + "_" + paramString1 + "_" + paramString2 + "_" + paramString3, paramInt).commit();
    }
    
    public void Destruct()
    {
      if (this.jdField_b_of_type_Wzl != null) {
        this.jdField_b_of_type_Wzl.Destruct();
      }
      if (this.jdField_b_of_type_MqqObserverWtloginObserver != null) {
        this.jdField_b_of_type_MqqObserverWtloginObserver = null;
      }
      super.Destruct();
    }
    
    public String GetTypeName()
    {
      return "QQ";
    }
    
    public boolean HasMenthod(String paramString)
    {
      if (paramString.equals("OpenUrl")) {}
      do
      {
        do
        {
          do
          {
            return true;
          } while ((paramString.equals("NavigateTo")) || (paramString.equals("OpenVideo")) || (paramString.equals("GetVersion")) || (paramString.equals("GetPerformance")) || (paramString.equals("Login")) || (paramString.equals("GetUserInformation")) || (paramString.equals("OpenView")) || (paramString.equals("CloseView")) || (paramString.equals("ShareView")) || (paramString.equals("ShowStatusBar")) || (paramString.equals("HideStatusBar")) || (paramString.equals("SetNavigationBarTitle")) || (paramString.equals("ShowShareMenu")) || (paramString.equals("HideShareMenu")) || (paramString.equals("PreviewImage")) || (paramString.equals("SetTalkBackText")) || (paramString.equals("ChooseImage")) || (paramString.equals("GetAppInfo")));
          if (this.Vj != 0L) {
            break;
          }
        } while ((paramString.equals("GetSkey")) || (paramString.equals("GetPskey")) || (paramString.equals("GetPskeyAsync")) || (paramString.equals("GetUIN")) || (paramString.equals("GetNickName")) || (paramString.equals("Report")) || (paramString.equals("ReportEx")) || (paramString.equals("Log")) || (paramString.equals("GetContainerInfo")) || (paramString.equals("DataRequest")) || (paramString.equals("GetCurrentPosition")) || (paramString.equals("WatchPosition")) || (paramString.equals("ClearWatch")) || (paramString.equals("GetCurrentAddress")) || (paramString.equals("SendMessage")));
        if (paramString.equals("TestGetJson")) {
          return false;
        }
      } while ((paramString.equals("Notify")) || (paramString.equals("GetAppID")) || (paramString.equals("GetAudioOutputMode")) || (paramString.equals("IsMute")) || (paramString.equals("GetNickNameByView")) || (paramString.equals("SubscribePublicAccount")));
      return false;
    }
    
    public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
    {
      if (!la(paramString)) {
        return false;
      }
      if (paramString.equals("GetSkey"))
      {
        paramString = adnq.getAppInterface();
        if (paramString != null)
        {
          paramString = ((TicketManager)paramString.getManager(2)).getSkey(paramString.getCurrentAccountUin());
          paramVariantWrapper.SetString(paramString);
          if ((paramString != null) && (QLog.isColorLevel())) {
            QLog.d("ark.GetSkey ", 2, paramString);
          }
          return true;
        }
        paramVariantWrapper.SetString(adot.getSKey());
        return true;
      }
      if (paramString.equals("GetPskey"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length == 1))
        {
          paramString = paramArrayOfVariantWrapper[0].GetString();
          paramArrayOfVariantWrapper = adnq.getAppInterface();
          if (paramArrayOfVariantWrapper != null)
          {
            paramVariantWrapper.SetString(((TicketManager)paramArrayOfVariantWrapper.getManager(2)).getPskey(paramArrayOfVariantWrapper.getCurrentAccountUin(), paramString));
            if (QLog.isColorLevel()) {
              QLog.d("ark.GetSkey ", 2, paramString);
            }
            return true;
          }
          paramVariantWrapper.SetString(adot.getPSKey(paramString));
          return true;
        }
        return true;
      }
      if (paramString.equals("NavigateTo"))
      {
        paramString = BaseActivity.sTopActivity;
        if ((paramString != null) && (paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1)) {
          adnq.a(paramString, paramArrayOfVariantWrapper[0].GetString(), true, 0L, null, null, 3, this.mAppName, null);
        }
        return true;
      }
      BaseActivity localBaseActivity;
      long l1;
      Object localObject1;
      Object localObject2;
      if (paramString.equals("OpenUrl"))
      {
        paramVariantWrapper.SetBool(false);
        localBaseActivity = BaseActivity.sTopActivity;
        if (((localBaseActivity instanceof FragmentActivity)) && (paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1))
        {
          paramString = paramArrayOfVariantWrapper[0].GetString();
          if (!TextUtils.isEmpty(paramString))
          {
            if (paramArrayOfVariantWrapper.length <= 1) {
              break label8317;
            }
            if (paramArrayOfVariantWrapper[1].IsView())
            {
              l1 = paramArrayOfVariantWrapper[1].GetView();
              localObject1 = null;
              localObject2 = null;
            }
          }
        }
      }
      for (;;)
      {
        int i;
        try
        {
          if (paramArrayOfVariantWrapper.length <= 2) {
            break label8312;
          }
          paramArrayOfVariantWrapper = new JSONObject(paramArrayOfVariantWrapper[2].GetTableAsJsonString());
          if (paramArrayOfVariantWrapper != null)
          {
            localObject2 = paramArrayOfVariantWrapper.optString("businessId", "biz_src_jc_ark");
            localObject3 = (FragmentActivity)localBaseActivity;
            if (((FragmentActivity)localObject3).getChatFragment() == null) {
              break label8306;
            }
            localObject4 = ((FragmentActivity)localObject3).getChatFragment().a();
            if ((!(localObject4 instanceof ycd)) || (!"biz_src_ads".equals(localObject2))) {
              break label8306;
            }
            localObject3 = ocp.fq(((BaseChatPie)localObject4).sessionInfo.aTl);
            QLog.d("ArkApp", 1, "ArkSafe.OpenUrl set hsSourceID for " + ((BaseChatPie)localObject4).sessionInfo.aTl + ", input " + (String)localObject2 + ", output " + (String)localObject3);
            if (l1 == 0L) {
              break label8300;
            }
            localObject4 = ark.arkGetContainer(l1);
            if (localObject4 == null) {
              break label8300;
            }
            localObject4 = (wyw)wyw.a((ark.Container)localObject4).get();
            if ((localObject4 == null) || (!(localObject4 instanceof wyv))) {
              break label8300;
            }
            localObject4 = (MessageForArkApp)((wyv)localObject4).dX.get();
            if (!"com.tencent.avgame".equalsIgnoreCase(this.mAppName)) {
              continue;
            }
            ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.1(this));
            return true;
            localObject1 = paramArrayOfVariantWrapper[1].GetTableAsJsonString();
            l1 = 0L;
            break;
          }
          localObject2 = "biz_src_jc_ark";
          continue;
          if (adoj.a(paramString, (String)localObject1, paramArrayOfVariantWrapper, this.Vj, this.mAppName))
          {
            adqu.a(null, this.mAppName, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
            paramVariantWrapper.SetBool(true);
            if (!MiniAppLauncher.isMiniAppUrl(paramString))
            {
              paramArrayOfVariantWrapper = paramString;
              if (!TextUtils.isEmpty(paramString))
              {
                paramArrayOfVariantWrapper = paramString;
                if (!paramString.startsWith("miniapp")) {}
              }
            }
            else
            {
              paramArrayOfVariantWrapper = paramString;
              if (localObject4 != null)
              {
                l1 = jzp.d(((MessageForArkApp)localObject4).ark_app_message.getAppIdFromMeta(), 0L);
                if (l1 != 0L) {
                  continue;
                }
                paramArrayOfVariantWrapper = "";
                anot.a(null, "dc00898", "", "", "0X800A86C", "0X800A86C", 0, 0, paramArrayOfVariantWrapper, "", "", "");
                paramArrayOfVariantWrapper = paramString;
              }
            }
            Log.d("ark.OpenUrl ", paramArrayOfVariantWrapper);
            adqu.a(null, this.mAppName, "FullScreenOrH5Show", 0, 0, 0L, 0L, 0L, "", "");
            return true;
            paramArrayOfVariantWrapper = String.valueOf(l1);
            continue;
          }
          int k;
          int j;
          boolean bool2;
          boolean bool3;
          if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
          {
            if (!adnq.a(this.mAppName, this.Vj, this.mApplication, "permission.BROWSER"))
            {
              QLog.d("ArkApp", 1, "ArkSafe.OpenUrl ModuleCheckPermission invalid!");
              return false;
            }
            paramArrayOfVariantWrapper = ArkAppConfigMgr.getInstance().getUrlChecker(this.mAppName);
            i = 1;
            if (paramArrayOfVariantWrapper != null)
            {
              k = paramArrayOfVariantWrapper.checkUrlIsValidByAppNavigationList(paramString);
              j = 0;
              if (k == 0)
              {
                i = 1;
                bool2 = ArkAppConfigMgr.getInstance().isUrlCheckEnable(this.mAppName);
                bool3 = adqr.afw();
                if ((!bool2) || (bool3)) {
                  continue;
                }
                bool1 = true;
                if (QLog.isColorLevel()) {
                  QLog.e("ArkApp", 2, new Object[] { "ArkSafe.UrlCheck.OpenUrl.http.appname=", this.mAppName, ", enableCheck=", Boolean.valueOf(bool1), ", appEnableCheck=", Boolean.valueOf(bool2), ", isPublicAccount=", Boolean.valueOf(bool3) });
                }
                if (i != 0) {
                  break label8297;
                }
                j = 1;
                if (bool1) {
                  break label8297;
                }
                QLog.e("ArkApp", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.OpenUrl.http appName=", this.mAppName, ",url=", jqo.filterKeyForLog(paramString, new String[0]), ", isValid set=true" });
                i = 1;
                j = 2;
                adtn.e(this.mAppName, paramString, k, j, wyw.aUB);
                adqu.h(adnq.getAppInterface(), this.mAppName, paramString, 2);
              }
            }
            else
            {
              if (i != 0) {
                continue;
              }
              QLog.d("ArkApp", 1, new Object[] { "ArkSafe.OpenUrl check url invalid!, url=", jqo.filterKeyForLog(paramString, new String[0]), ", app=", this.mAppName });
              return false;
            }
            i = 0;
            continue;
            bool1 = false;
            continue;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label8294;
            }
            try
            {
              JSONObject localJSONObject = new JSONObject((String)localObject1);
              Iterator localIterator = localJSONObject.keys();
              paramArrayOfVariantWrapper = new String();
              i = 0;
              if (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                paramVariantWrapper = null;
                if ((localJSONObject.get(str) instanceof String))
                {
                  paramVariantWrapper = localJSONObject.getString(str);
                  if (TextUtils.isEmpty(paramVariantWrapper)) {
                    break label8291;
                  }
                  localObject1 = paramArrayOfVariantWrapper;
                  if (i != 0) {
                    localObject1 = paramArrayOfVariantWrapper + "&";
                  }
                  paramArrayOfVariantWrapper = (String)localObject1 + str + "=" + paramVariantWrapper;
                  i = 1;
                  break label8326;
                }
                if (!(localJSONObject.get(str) instanceof Number)) {
                  continue;
                }
                paramVariantWrapper = ((Number)localJSONObject.get(str)).toString();
                continue;
              }
              paramVariantWrapper = paramString;
              if (!TextUtils.isEmpty(paramArrayOfVariantWrapper))
              {
                if (paramString.indexOf("?", 0) != -1) {
                  continue;
                }
                paramVariantWrapper = paramString + paramArrayOfVariantWrapper;
              }
              paramString = paramVariantWrapper;
            }
            catch (JSONException paramArrayOfVariantWrapper)
            {
              continue;
              adqu.a(null, this.mAppName, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
              continue;
              paramArrayOfVariantWrapper = String.valueOf(l1);
              continue;
              adnq.a(localBaseActivity, paramString, true, 0L, null, (String)localObject2, 0, this.mAppName, (String)localObject3);
              continue;
            }
            paramArrayOfVariantWrapper = (FragmentActivity)localBaseActivity;
            if (paramArrayOfVariantWrapper.getChatFragment() != null)
            {
              paramArrayOfVariantWrapper = paramArrayOfVariantWrapper.getChatFragment().a();
              if ((paramArrayOfVariantWrapper instanceof ycd)) {
                ((ycd)paramArrayOfVariantWrapper).b.dqV();
              }
            }
            else
            {
              if ((localObject4 == null) || (((MessageForArkApp)localObject4).ark_app_message == null)) {
                continue;
              }
              l1 = jzp.d(((MessageForArkApp)localObject4).ark_app_message.getAppIdFromMeta(), 0L);
              adnq.a(localBaseActivity, paramString, true, l1, (MessageForArkApp)localObject4, (String)localObject2, 0, this.mAppName, (String)localObject3);
              ((MessageForArkApp)localObject4).reportClick();
              if (((MessageForArkApp)localObject4).buildTypeAndTitle().isSdkShare)
              {
                if (l1 != 0L) {
                  continue;
                }
                paramArrayOfVariantWrapper = "";
                anot.a(null, "dc00898", "", "", "0X800A869", "0X800A869", 0, 0, paramArrayOfVariantWrapper, "", "", "");
              }
              paramArrayOfVariantWrapper = paramString;
              continue;
              paramVariantWrapper = paramString + "&" + paramArrayOfVariantWrapper;
              continue;
            }
          }
          paramArrayOfVariantWrapper = paramString;
          if (this.Vj != 0L) {
            continue;
          }
          paramVariantWrapper = aqik.c(adnq.getAppInterface(), localBaseActivity, paramString);
          paramArrayOfVariantWrapper = paramString;
          if (paramVariantWrapper == null) {
            continue;
          }
          paramArrayOfVariantWrapper = ArkAppConfigMgr.getInstance().getUrlChecker(this.mAppName);
          i = 1;
          if (paramArrayOfVariantWrapper != null)
          {
            k = paramArrayOfVariantWrapper.checkUrlIsValidByAppNavigationList(paramString);
            j = 0;
            if (k == 0)
            {
              i = 1;
              bool2 = ArkAppConfigMgr.getInstance().isUrlCheckEnable(this.mAppName);
              bool3 = adqr.afw();
              if ((!bool2) || (bool3)) {
                continue;
              }
              bool1 = true;
              if (QLog.isColorLevel()) {
                QLog.e("ArkApp", 2, new Object[] { "ArkSafe.UrlCheck.OpenUrl.http.JumpAction=", this.mAppName, ", enableCheck=", Boolean.valueOf(bool1), ", appEnableCheck=", Boolean.valueOf(bool2), ", isPublicAccount=", Boolean.valueOf(bool3) });
              }
              if (i != 0) {
                continue;
              }
              j = 1;
              if (bool1) {
                continue;
              }
              QLog.e("ArkApp", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.OpenUrl.jump appName=", this.mAppName, ",url=", jqo.filterKeyForLog(paramString, new String[0]), ", isValid set=true" });
              i = 1;
              j = 2;
              adtn.e(this.mAppName, paramString, k, j, wyw.aUB);
            }
          }
          else
          {
            if (i == 0) {
              continue;
            }
            paramVariantWrapper.ace();
            paramArrayOfVariantWrapper = paramString;
            continue;
          }
          i = 0;
          continue;
          bool1 = false;
          continue;
          QLog.e("ArkApp", 1, new Object[] { "ArkSafe.OpenUrl check url invalid, url=", jqo.filterKeyForLog(paramString, new String[0]), ", app=", this.mAppName });
          paramArrayOfVariantWrapper = paramString;
          continue;
          if (paramString.equals("OpenVideo"))
          {
            l1 = System.currentTimeMillis();
            if ((l1 - Vm < 1000L) && (l1 > Vm))
            {
              if (QLog.isColorLevel()) {
                QLog.e("ArkApp", 2, "click too offen,please try again later ");
              }
              return true;
            }
            Vm = l1;
            paramVariantWrapper.SetBool(false);
            paramString = BaseActivity.sTopActivity;
            if (((paramString instanceof FragmentActivity)) && (paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1))
            {
              paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[0].GetString();
              if (TextUtils.isEmpty(paramArrayOfVariantWrapper)) {}
            }
            try
            {
              localObject1 = new URL(paramArrayOfVariantWrapper).getProtocol();
              if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((((String)localObject1).equalsIgnoreCase("http")) || (((String)localObject1).equalsIgnoreCase("https"))))
              {
                localObject1 = adnq.getAppInterface();
                if ((this.mApplication != null) && (!this.mApplication.CheckUrlLegality(paramArrayOfVariantWrapper))) {
                  return false;
                }
                paramVariantWrapper.SetBool(true);
                adnq.bt(paramString, paramArrayOfVariantWrapper);
                adqu.a((QQAppInterface)localObject1, this.mAppName, "AIOArkOpenVideo", 1, 0, 0L, 0L, 0L, paramArrayOfVariantWrapper, "");
              }
              return true;
            }
            catch (MalformedURLException paramString)
            {
              ArkAppCenter.r("ArkApp", "url parse error and msg= " + paramString.getMessage());
              return false;
            }
          }
          if (paramString.equals("GetUIN"))
          {
            paramString = adnq.getAppInterface();
            if (paramString != null)
            {
              paramString = paramString.getCurrentAccountUin();
              paramVariantWrapper.SetString(paramString);
              if (paramString != null) {
                Log.d("ark.GetUIN ", paramString);
              }
              return true;
            }
            paramVariantWrapper.SetString(adot.sI());
            return true;
          }
          if (paramString.equals("Report"))
          {
            paramString = adnq.getAppInterface();
            if (paramString == null) {
              return false;
            }
            if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length == 3))
            {
              paramVariantWrapper = paramArrayOfVariantWrapper[0].GetString();
              i = (int)Math.round(paramArrayOfVariantWrapper[1].GetDouble());
              paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[2].GetString();
              if (!TextUtils.isEmpty(paramArrayOfVariantWrapper))
              {
                localObject1 = paramString.getCurrentAccountUin();
                l1 = NetConnInfoCenter.getServerTime();
                if (TextUtils.isEmpty(paramVariantWrapper)) {
                  continue;
                }
              }
            }
            try
            {
              Long.parseLong(paramVariantWrapper);
              anot.a(paramString, "CliOper", "", (String)localObject1, "0X8005FFE", "0X8005FFE", i, 0, Long.toString(l1), paramVariantWrapper, paramArrayOfVariantWrapper, "");
              adqu.g(paramString, this.mAppName, paramArrayOfVariantWrapper, i);
              return true;
            }
            catch (Exception paramVariantWrapper)
            {
              anot.a(paramString, "CliOper", "", (String)localObject1, "0X8005FFE", "0X8005FFE", i, 0, Long.toString(l1), "0", paramArrayOfVariantWrapper, "");
              continue;
            }
            anot.a(paramString, "CliOper", "", (String)localObject1, "0X8005FFE", "0X8005FFE", i, 0, Long.toString(l1), "0", paramArrayOfVariantWrapper, "");
            continue;
          }
          if (paramString.equals("ReportEx"))
          {
            if (paramArrayOfVariantWrapper.length > 0)
            {
              paramVariantWrapper = paramArrayOfVariantWrapper[0].GetString();
              if (paramArrayOfVariantWrapper.length > 1)
              {
                paramString = paramArrayOfVariantWrapper[1].GetTableAsJsonString();
                if ((!TextUtils.isEmpty(paramVariantWrapper)) && (!TextUtils.isEmpty(paramString))) {
                  continue;
                }
                ArkAppCenter.r("ArkApp", "QQ.ReportEx, invalid arguments");
                return false;
              }
            }
            else
            {
              paramVariantWrapper = null;
              continue;
            }
            paramString = null;
            continue;
            if (paramVariantWrapper.equals("898")) {
              try
              {
                localObject3 = new JSONObject(paramString);
                paramArrayOfVariantWrapper = ((JSONObject)localObject3).getString("type");
                paramVariantWrapper = ((JSONObject)localObject3).getString("name");
                localObject1 = ((JSONObject)localObject3).optString("targetUin", "");
                i = ((JSONObject)localObject3).optInt("entry", 0);
                j = ((JSONObject)localObject3).optInt("count", 1);
                k = ((JSONObject)localObject3).optInt("result", 0);
                int m = ((JSONObject)localObject3).optInt("r1", 0);
                int n = ((JSONObject)localObject3).optInt("r2", 0);
                localObject2 = ((JSONObject)localObject3).optString("r3", "");
                localObject3 = ((JSONObject)localObject3).optString("r4", "");
                anot.b(null, "dc00898", "", (String)localObject1, paramArrayOfVariantWrapper, paramVariantWrapper, i, j, k, Integer.toString(m), Integer.toString(n), (String)localObject2, (String)localObject3);
                return true;
              }
              catch (JSONException paramArrayOfVariantWrapper)
              {
                ArkAppCenter.r("ArkApp", "QQ.ReportEx, invalid report data, data=" + paramString);
                return false;
              }
            }
            return false;
          }
          if (paramString.equals("GetVersion"))
          {
            paramArrayOfVariantWrapper = aqgz.getQQVersion();
            paramString = paramArrayOfVariantWrapper;
            if (TextUtils.isEmpty(paramArrayOfVariantWrapper)) {
              paramString = "3.4.4";
            }
            paramVariantWrapper.SetString(paramString);
            return true;
          }
          if (paramString.equals("Log"))
          {
            if (paramArrayOfVariantWrapper != null)
            {
              l1 = paramArrayOfVariantWrapper.length;
              if (l1 <= 0L) {
                return true;
              }
            }
            else
            {
              l1 = 0L;
              continue;
            }
            paramString = paramArrayOfVariantWrapper[0];
            i = paramString.GetType();
            j = adnq.b(paramArrayOfVariantWrapper, l1);
            if (i == 0)
            {
              QLog.i("ArkApp.QQLog", j, "none");
              return true;
            }
            if (i == 1)
            {
              QLog.i("ArkApp.QQLog", j, "null");
              continue;
            }
            if (i == 2)
            {
              if (paramString.GetBool())
              {
                paramString = "true";
                QLog.i("ArkApp.QQLog", j, paramString);
                continue;
              }
              paramString = "false";
              continue;
            }
            if (i == 3)
            {
              QLog.i("ArkApp.QQLog", j, Integer.toString(paramString.GetInt()));
              continue;
            }
            if (i == 4)
            {
              QLog.i("ArkApp.QQLog", j, Double.toString(paramString.GetDouble()));
              continue;
            }
            if (i == 5)
            {
              QLog.i("ArkApp.QQLog", j, paramString.GetString());
              continue;
            }
            if (paramString.IsFunction())
            {
              QLog.i("ArkApp.QQLog", j, "Function Object");
              continue;
            }
            if (paramString.IsUserObject())
            {
              QLog.i("ArkApp.QQLog", j, "User Object");
              continue;
            }
            if ((paramString.IsArray()) || (paramString.IsTable()))
            {
              QLog.i("ArkApp.QQLog", j, paramString.GetTableAsJsonString());
              continue;
            }
            QLog.i("ArkApp.QQLog", j, "Unknown Object");
            continue;
          }
          if (paramString.equals("GetNickName"))
          {
            localObject2 = adnq.getAppInterface();
            if (paramArrayOfVariantWrapper != null)
            {
              l1 = paramArrayOfVariantWrapper.length;
              if (l1 == 1L)
              {
                paramString = paramArrayOfVariantWrapper[0].GetString();
                if (localObject2 == null) {
                  continue;
                }
                if (!TextUtils.isEmpty(paramString))
                {
                  localObject1 = null;
                  if (!TextUtils.isEmpty(wyw.mTroopUin)) {
                    localObject1 = aqgv.h((QQAppInterface)localObject2, wyw.mTroopUin, paramString);
                  }
                  if (localObject1 != null)
                  {
                    paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
                    if (!TextUtils.equals((CharSequence)localObject1, paramString)) {}
                  }
                  else
                  {
                    localObject1 = aqgv.G((QQAppInterface)localObject2, paramString);
                    paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
                    if (TextUtils.isEmpty((CharSequence)localObject1)) {
                      paramArrayOfVariantWrapper = aqgv.d((QQAppInterface)localObject2, paramString, 0);
                    }
                  }
                  paramVariantWrapper.SetString(paramArrayOfVariantWrapper);
                  if (paramArrayOfVariantWrapper != null) {
                    Log.d("ark.GetNickName ", paramArrayOfVariantWrapper);
                  }
                }
                return true;
              }
            }
            else
            {
              l1 = 0L;
              continue;
            }
            if ((l1 == 0L) && (localObject2 != null))
            {
              paramString = ((QQAppInterface)localObject2).getCurrentAccountUin();
              continue;
              paramString = adot.getNickname(paramString);
              QLog.i("ArkApp", 1, "QQ.GetNickname, ipc call, nickname=" + paramString);
              paramVariantWrapper.SetString(paramString);
              return true;
            }
          }
          else if (paramString.equals("GetContainerInfo"))
          {
            localObject1 = new HashMap();
            if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
            {
              l1 = paramArrayOfVariantWrapper[0].GetView();
              if (l1 == 0L) {
                continue;
              }
              paramString = ark.arkGetContainer(l1);
              if (paramString == null) {
                continue;
              }
              paramString = (wyw)wyw.a(paramString).get();
              if ((paramString == null) || (!(paramString instanceof wyv))) {
                continue;
              }
              paramArrayOfVariantWrapper = ((wyv)paramString).a();
              paramString = paramArrayOfVariantWrapper;
              if (paramArrayOfVariantWrapper == null) {
                paramString = adnq.b();
              }
              if (QLog.isColorLevel()) {
                QLog.d("ArkApp", 2, new Object[] { "multiAio.ArkAppModuleReg GetContainerInfo Extra ViewID viewHandle=", Long.valueOf(l1), adnq.a(paramString) });
              }
              if (paramString != null)
              {
                ((HashMap)localObject1).put("ChatUIN", paramString.aTl);
                paramArrayOfVariantWrapper = String.format("%d", new Object[] { Integer.valueOf(-1) });
              }
            }
            switch (paramString.cZ)
            {
            default: 
              paramString = paramArrayOfVariantWrapper;
              ((HashMap)localObject1).put("ChatType", paramString);
              paramVariantWrapper.SetMap((Map)localObject1);
              return true;
              paramString = adnq.b();
              if (QLog.isColorLevel()) {
                QLog.d("ArkApp", 2, new Object[] { "multiAio.ArkAppModuleReg GetContainerInfo old activity=", BaseActivity.sTopActivity, adnq.a(paramString) });
              }
              break;
            case 1008: 
              paramString = String.format("%d", new Object[] { Integer.valueOf(1) });
              break;
            case 0: 
              paramString = String.format("%d", new Object[] { Integer.valueOf(2) });
              break;
            case 1: 
              paramString = String.format("%d", new Object[] { Integer.valueOf(3) });
              break;
            case 3000: 
              paramString = String.format("%d", new Object[] { Integer.valueOf(4) });
              break;
            case 2: 
              paramString = String.format("%d", new Object[] { Integer.valueOf(5) });
              break;
            case 1004: 
              paramString = String.format("%d", new Object[] { Integer.valueOf(6) });
              break;
            }
          }
          else
          {
            if (paramString.equals("DataRequest"))
            {
              paramVariantWrapper.CreateObject("DataRequest", new wzv(adnq.getAppInterface(), this.mAppName));
              return true;
            }
            if (paramString.equals("GetPerformance"))
            {
              if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1))
              {
                paramVariantWrapper.SetNull();
                return true;
              }
              paramString = paramArrayOfVariantWrapper[0].GetString();
              if (TextUtils.isEmpty(paramString)) {
                continue;
              }
              paramArrayOfVariantWrapper = wyv.a(paramString);
              if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.arkContainer == null))
              {
                ArkAppCenter.r("ArkApp", String.format("QQ.GetPerformance, arkAppMsg is null, viewID=%s", new Object[] { paramString }));
                continue;
              }
              paramArrayOfVariantWrapper = paramArrayOfVariantWrapper.arkContainer.mExtraTimerRecord;
              if (paramArrayOfVariantWrapper == null)
              {
                ArkAppCenter.r("ArkApp", String.format("QQ.GetPerformance, timeRecord is null, viewID=%s", new Object[] { paramString }));
                continue;
              }
              paramString = null;
              try
              {
                localObject1 = new JSONObject();
                localObject2 = new JSONObject();
                ((JSONObject)localObject1).put("Timing", localObject2);
                ((JSONObject)localObject2).put("GetApplicationStart", 0.01D + paramArrayOfVariantWrapper.beginOfGetApp);
                ((JSONObject)localObject2).put("GetApplicationEnd", 0.01D + paramArrayOfVariantWrapper.endOfGetApp);
                ((JSONObject)localObject2).put("FetchApplicationStart", 0.01D + paramArrayOfVariantWrapper.beginOfGetApp);
                ((JSONObject)localObject2).put("FetchApplicationEnd", 0.01D + paramArrayOfVariantWrapper.endOfGetApp);
                ((JSONObject)localObject2).put("CreateViewStart", 0.01D + paramArrayOfVariantWrapper.mRecord.beginOfCreateView);
                ((JSONObject)localObject2).put("CreateViewEnd", 0.01D + paramArrayOfVariantWrapper.mRecord.endOfCreateView);
                ((JSONObject)localObject2).put("DisplayViewStart", 0.01D + paramArrayOfVariantWrapper.mRecord.beginOfDisplyView);
                ((JSONObject)localObject2).put("DisplayViewEnd", 0.01D + paramArrayOfVariantWrapper.mRecord.endOfDisplyView);
                localObject2 = new JSONObject();
                ((JSONObject)localObject1).put("Navigation", localObject2);
                if (!paramArrayOfVariantWrapper.getAppFromLocal) {
                  continue;
                }
                i = 1;
                ((JSONObject)localObject2).put("FetchApplicationFromCache", i);
                paramArrayOfVariantWrapper = ((JSONObject)localObject1).toString();
                paramString = paramArrayOfVariantWrapper;
              }
              catch (Exception paramArrayOfVariantWrapper)
              {
                ArkAppCenter.r("ArkApp", String.format("QQ.GetPerformance, json exception, msg=%s", new Object[] { paramArrayOfVariantWrapper.getMessage() }));
                continue;
              }
              if (TextUtils.isEmpty(paramString)) {
                continue;
              }
              paramVariantWrapper.SetTableAsJsonString(paramString);
              return true;
              i = 0;
              continue;
            }
            if (paramString.equals("GetCurrentPosition"))
            {
              if ((this.jdField_b_of_type_Wzl == null) || (paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (paramArrayOfVariantWrapper[0] == null) || (!paramArrayOfVariantWrapper[0].IsFunction())) {
                return false;
              }
              if (QLog.isColorLevel()) {
                QLog.i("ArkApp", 2, String.format("GetCurrentPosition.app.%s", new Object[] { this.mAppName }));
              }
              l1 = a(paramArrayOfVariantWrapper[0].Copy());
              this.jdField_b_of_type_Wzl.b(new adnt(this, l1));
              return true;
            }
            if (paramString.equals("WatchPosition"))
            {
              if ((this.jdField_b_of_type_Wzl == null) || (paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (paramArrayOfVariantWrapper[0] == null) || (!paramArrayOfVariantWrapper[0].IsFunction())) {
                return false;
              }
              if (QLog.isColorLevel()) {
                QLog.i("ArkApp", 2, String.format("WatchPosition.app.%s", new Object[] { this.mAppName }));
              }
              l1 = a(paramArrayOfVariantWrapper[0].Copy());
              this.jdField_b_of_type_Wzl.a(new adny(this, l1));
              return true;
            }
            if (paramString.equals("ClearWatch"))
            {
              if (this.jdField_b_of_type_Wzl == null) {
                return false;
              }
              this.jdField_b_of_type_Wzl.cdy();
              return true;
            }
            if (paramString.equals("GetCurrentAddress"))
            {
              if ((this.jdField_b_of_type_Wzl == null) || (paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (paramArrayOfVariantWrapper[0] == null) || (!paramArrayOfVariantWrapper[0].IsFunction())) {
                return false;
              }
              l1 = a(paramArrayOfVariantWrapper[0].Copy());
              this.jdField_b_of_type_Wzl.a(new adnz(this, l1), true);
              return true;
            }
            if (paramString.equals("SendMessage"))
            {
              if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || ((!paramArrayOfVariantWrapper[0].IsArray()) && (!paramArrayOfVariantWrapper[0].IsTable()))) {
                return false;
              }
              localObject1 = paramArrayOfVariantWrapper[0].GetTableAsJsonString();
              try
              {
                paramVariantWrapper = new JSONObject((String)localObject1);
                if ((paramArrayOfVariantWrapper.length <= 1) || (paramArrayOfVariantWrapper[1].GetType() != 2)) {
                  continue;
                }
                bool1 = paramArrayOfVariantWrapper[1].GetBool();
                if ((paramArrayOfVariantWrapper.length >= 3) && (paramArrayOfVariantWrapper[2].IsView()))
                {
                  l1 = paramArrayOfVariantWrapper[2].GetView();
                  if (l1 == 0L) {
                    continue;
                  }
                  paramString = ark.arkGetContainer(l1);
                  if (paramString == null) {
                    continue;
                  }
                  paramString = (wyw)wyw.a(paramString).get();
                  if ((paramString == null) || (!(paramString instanceof wyv))) {
                    continue;
                  }
                  paramArrayOfVariantWrapper = ((wyv)paramString).a();
                  paramString = paramArrayOfVariantWrapper;
                  if (paramArrayOfVariantWrapper == null) {
                    paramString = adnq.b();
                  }
                  if (!QLog.isColorLevel()) {
                    break label8329;
                  }
                  QLog.d("ArkApp", 2, new Object[] { "multiAio.ArkAppModuleReg SendMessage Extra viewid viewHandle=", Long.valueOf(l1), adnq.a(paramString) });
                  break label8329;
                  if (!paramVariantWrapper.has("light")) {
                    continue;
                  }
                  localObject2 = new ArkAppMessage();
                  ((ArkAppMessage)localObject2).appMinVersion = "0.0.0.1";
                  paramArrayOfVariantWrapper = paramVariantWrapper.getJSONObject("light");
                  ((ArkAppMessage)localObject2).appName = paramArrayOfVariantWrapper.getString("Application");
                  if (TextUtils.isEmpty(((ArkAppMessage)localObject2).appName)) {
                    return false;
                  }
                }
                else
                {
                  paramString = adnq.b();
                  if (!QLog.isColorLevel()) {
                    break label8332;
                  }
                  QLog.d("ArkApp", 2, new Object[] { "multiAio.ArkAppModuleReg SendMessage old,sessionInfo=", adnq.a(paramString) });
                  break label8332;
                }
                ((ArkAppMessage)localObject2).appView = paramArrayOfVariantWrapper.getString("View");
                if (TextUtils.isEmpty(((ArkAppMessage)localObject2).appView)) {
                  return false;
                }
                paramVariantWrapper = ArkAppCacheMgr.getApplicationFromManifest(((ArkAppMessage)localObject2).appName, ((ArkAppMessage)localObject2).appMinVersion);
                if (paramVariantWrapper != null)
                {
                  ((ArkAppMessage)localObject2).appDesc = ((String)paramVariantWrapper.get("desc"));
                  ((ArkAppMessage)localObject2).appMinVersion = ((String)paramVariantWrapper.get("version"));
                }
                if (TextUtils.isEmpty(((ArkAppMessage)localObject2).appDesc)) {
                  ((ArkAppMessage)localObject2).appDesc = ((ArkAppMessage)localObject2).appName;
                }
                ((ArkAppMessage)localObject2).promptText = paramArrayOfVariantWrapper.optString("Prompt");
                if (TextUtils.isEmpty(((ArkAppMessage)localObject2).promptText)) {
                  ((ArkAppMessage)localObject2).promptText = String.format(acfp.m(2131702775), new Object[] { ((ArkAppMessage)localObject2).appDesc });
                }
                ((ArkAppMessage)localObject2).metaList = paramArrayOfVariantWrapper.getJSONObject("MetaData").toString();
                paramVariantWrapper = paramArrayOfVariantWrapper.optJSONObject("Config");
                paramArrayOfVariantWrapper = paramVariantWrapper;
                if (paramVariantWrapper == null) {
                  paramArrayOfVariantWrapper = new JSONObject();
                }
                paramArrayOfVariantWrapper.put("forward", 1);
                ((ArkAppMessage)localObject2).config = paramArrayOfVariantWrapper.toString();
                if (bool1)
                {
                  if (paramString != null)
                  {
                    ujt.b(adnq.getAppInterface(), paramString, (ArkAppMessage)localObject2);
                    if (QLog.isColorLevel()) {
                      QLog.i("ArkApp", 1, "multiAio.QQ.SendMessage light currentChat success");
                    }
                  }
                }
                else {
                  ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.5(this, (ArkAppMessage)localObject2));
                }
              }
              catch (JSONException paramString)
              {
                if (QLog.isColorLevel()) {
                  QLog.i("ArkApp", 1, "multiAio.QQ.SendMessage parameter error: " + paramString.getMessage());
                }
                if (QLog.isColorLevel()) {
                  QLog.i("ArkApp", 1, String.format("multiAio.QQ.SendMessage fail, packet:%s", new Object[] { localObject1 }));
                }
                return false;
              }
              if (!paramVariantWrapper.has("text")) {
                continue;
              }
              paramVariantWrapper = paramVariantWrapper.getString("text");
              if (bool1)
              {
                paramArrayOfVariantWrapper = adnq.getAppInterface();
                if ((paramString == null) || (paramArrayOfVariantWrapper == null)) {
                  break label8337;
                }
                paramString = anbi.a(adnq.getAppInterface(), adnq.getAppInterface().getCurrentUin(), paramString.aTl, paramString.troopUin, paramString.cZ, (byte)1, (byte)0, (short)0, paramVariantWrapper);
                paramArrayOfVariantWrapper.b().a(paramString, null);
                if (!QLog.isColorLevel()) {
                  break label8337;
                }
                QLog.i("ArkApp", 1, "multiAio.QQ.SendMessage text currentChat success");
                break label8337;
              }
              ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.6(this, paramVariantWrapper));
              break label8337;
            }
            else
            {
              if (paramString.equals("GetPskeyAsync"))
              {
                if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 2) || (!paramArrayOfVariantWrapper[0].IsString()) || (!paramArrayOfVariantWrapper[1].IsFunction()))
                {
                  QLog.e("ArkApp", 1, "GetPskeyAsync.param error");
                  return false;
                }
                paramString = paramArrayOfVariantWrapper[0].GetString();
                paramVariantWrapper = adnq.getAppInterface();
                if (paramVariantWrapper != null)
                {
                  l1 = a(paramArrayOfVariantWrapper[1].Copy());
                  paramArrayOfVariantWrapper = (TicketManager)paramVariantWrapper.getManager(2);
                  localObject1 = paramArrayOfVariantWrapper.getPskey(paramVariantWrapper.getCurrentAccountUin(), paramString);
                  if (TextUtils.isEmpty((CharSequence)localObject1))
                  {
                    localObject1 = paramVariantWrapper.getCurrentAccountUin();
                    paramVariantWrapper = new adoa(this, paramArrayOfVariantWrapper, paramVariantWrapper, paramString, l1);
                    paramArrayOfVariantWrapper.GetPskey((String)localObject1, 16L, new String[] { paramString }, paramVariantWrapper);
                    if (QLog.isColorLevel()) {
                      QLog.d("ark.GetSkeyAsync ", 2, paramString);
                    }
                    return true;
                  }
                  d(l1, true, (String)localObject1);
                  continue;
                }
                QLog.e("ArkApp", 1, "GetPskeyAsync error, QQAppInterface is null");
                return false;
              }
              if (paramString.equals("Login"))
              {
                if (!adnq.a(this.mAppName, this.Vj, this.mApplication, "permission.LOGIN"))
                {
                  QLog.e("ArkApp", 1, "Login.permission not allow");
                  return false;
                }
                if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 2) || (!paramArrayOfVariantWrapper[0].IsString()) || (!paramArrayOfVariantWrapper[1].IsFunction()))
                {
                  QLog.e("ArkApp", 1, "Login.param error");
                  return false;
                }
                try
                {
                  l1 = Long.parseLong(paramArrayOfVariantWrapper[0].GetString());
                  paramString = null;
                  paramVariantWrapper = adnq.getAppInterface();
                  if (paramVariantWrapper != null) {
                    paramString = paramVariantWrapper.getCurrentAccountUin();
                  }
                  if ((paramVariantWrapper == null) || (TextUtils.isEmpty(paramString))) {
                    return false;
                  }
                }
                catch (NumberFormatException paramString)
                {
                  QLog.e("ArkApp", 1, "Login.Exception:" + paramString.getMessage());
                  return false;
                }
                l2 = a(paramArrayOfVariantWrapper[1].Copy());
                paramArrayOfVariantWrapper = this.mAppPath;
                paramVariantWrapper = ArkAppCacheMgr.getApplicationDesc(this.mAppName);
                paramArrayOfVariantWrapper = paramVariantWrapper;
                if (TextUtils.isEmpty(paramVariantWrapper)) {
                  paramArrayOfVariantWrapper = String.valueOf(l1);
                }
                paramVariantWrapper = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0);
                localObject1 = "key_ark_authority_show_dialog" + "_" + paramArrayOfVariantWrapper + "_" + "ark_authority_api_login" + "_" + paramString;
                if ((!paramVariantWrapper.getBoolean((String)localObject1, false)) && (bPX))
                {
                  ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.8(this, paramArrayOfVariantWrapper, l2, paramString, l1));
                  paramVariantWrapper.edit().putBoolean((String)localObject1, true).commit();
                  fq(paramArrayOfVariantWrapper, paramString);
                  return true;
                }
                a(l2, paramString, 16L, l1, i(paramArrayOfVariantWrapper, "ark_authority_api_login", paramString));
                continue;
              }
              if (paramString.equals("GetUserInformation"))
              {
                if (!adnq.a(this.mAppName, this.Vj, this.mApplication, "permission.USER_INFORMATION"))
                {
                  QLog.e("ArkApp", 1, "GetUserInformation.permission not allow");
                  return false;
                }
                if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (!paramArrayOfVariantWrapper[0].IsFunction()))
                {
                  QLog.e("ArkApp", 1, "GetUserInformation.param error");
                  return false;
                }
                paramString = null;
                paramVariantWrapper = adnq.getAppInterface();
                if (paramVariantWrapper != null) {
                  paramString = paramVariantWrapper.getCurrentAccountUin();
                }
                if ((paramVariantWrapper == null) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(this.mAppName)))
                {
                  QLog.e("ArkApp", 1, "GetUserInformation.error app is null for cureUin:" + paramString + ", app=" + this.mAppName);
                  return false;
                }
                l1 = a(paramArrayOfVariantWrapper[0].Copy());
                paramVariantWrapper = (String)this.jz.get(this.mAppName);
                localObject1 = ArkAppCacheMgr.getApplicationDesc(this.mAppName);
                paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  paramArrayOfVariantWrapper = paramVariantWrapper;
                }
                paramVariantWrapper = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0);
                localObject1 = "key_ark_authority_show_dialog" + "_" + paramArrayOfVariantWrapper + "_" + "ark_authority_api_user_info" + "_" + paramString;
                if ((!paramVariantWrapper.getBoolean((String)localObject1, false)) && (bPX))
                {
                  ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.9(this, paramArrayOfVariantWrapper, l1, paramString));
                  paramVariantWrapper.edit().putBoolean((String)localObject1, true).commit();
                  fq(paramArrayOfVariantWrapper, paramString);
                  return true;
                }
                l(l1, paramString, i(paramArrayOfVariantWrapper, "ark_authority_api_user_info", paramString));
                continue;
              }
              if (paramString.equals("TestGetJson")) {
                return paramVariantWrapper.SetTableAsJsonString("{ \"ret\":0, \"msg\":\"ok\", \"data\":{ \"param_array\": [ 3.1400000000000001, true, \"hello\", { \"param10\": 10, \"param11\": 10.1, \"param12\": true, \"param13\": \"hello 10\" }, { }, 1 ], \"param_bool_false\": false, \"param_bool_true\": true, \"param_double\": 3.1400000000000001, \"param_int\": 0, \"param_int2\": -1, \"param_int3\": 1001, \"param_str_empty\": \"\", \"param_str_hello\": \"hello\", \"param_table\": { \"param1\": 0, \"param2\": 3.1400000000000001, \"param3\": true, \"param4\": \"hello\", \"param5\": { }, \"param6\": { \"param10\": 10, \"param11\": 10.1, \"param12\": true, \"param13\": \"hello 10\" }, \"param7\": \"\" } }}");
              }
              if (paramString.equals("OpenView"))
              {
                if (!adnq.a(this.mAppName, this.Vj, this.mApplication, "permission.OPENVIEW")) {
                  return false;
                }
                if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 4) && (paramArrayOfVariantWrapper[0].IsView()) && (paramArrayOfVariantWrapper[1].IsString()) && (paramArrayOfVariantWrapper[2].IsString()) && ((paramArrayOfVariantWrapper[3].IsArray()) || (paramArrayOfVariantWrapper[3].IsTable())))
                {
                  l1 = paramArrayOfVariantWrapper[0].GetView();
                  paramString = paramArrayOfVariantWrapper[1].GetString();
                  paramVariantWrapper = paramArrayOfVariantWrapper[2].GetString();
                  paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[3].GetTableAsJsonString();
                  QLog.d("ArkOpenView", 1, "OpenView holder=" + l1 + ", type=" + paramString + ", view=" + paramVariantWrapper + ", meta=" + paramArrayOfVariantWrapper);
                  ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.10(this, paramString, paramVariantWrapper, paramArrayOfVariantWrapper, l1));
                }
                return true;
              }
              if (paramString.equals("CloseView"))
              {
                if (!adnq.a(this.mAppName, this.Vj, this.mApplication, "permission.OPENVIEW")) {
                  return false;
                }
                if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
                {
                  l1 = paramArrayOfVariantWrapper[0].GetView();
                  ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.11(this, l1));
                }
                return true;
              }
              if (paramString.equals("ShareView"))
              {
                if (!adnq.a(this.mAppName, this.Vj, this.mApplication, "permission.SHARE")) {
                  return false;
                }
                if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()) && ((paramArrayOfVariantWrapper[1].IsArray()) || (paramArrayOfVariantWrapper[1].IsTable())))
                {
                  paramString = paramArrayOfVariantWrapper[0].GetString();
                  paramVariantWrapper = paramArrayOfVariantWrapper[1].GetTableAsJsonString();
                  paramArrayOfVariantWrapper = adnq.b(paramArrayOfVariantWrapper);
                  ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.12(this, paramString, paramVariantWrapper, paramArrayOfVariantWrapper));
                }
                return true;
              }
              if (paramString.equals("ShowStatusBar"))
              {
                if (!adnq.a(this.mAppName, this.Vj, this.mApplication, "permission.STATUSBAR")) {
                  return false;
                }
                if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsView()) && (paramArrayOfVariantWrapper[1].IsString()))
                {
                  l1 = paramArrayOfVariantWrapper[0].GetView();
                  paramString = paramArrayOfVariantWrapper[1].GetString();
                  ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.13(this, l1, paramString));
                }
                return true;
              }
              if (paramString.equals("HideStatusBar"))
              {
                if (!adnq.a(this.mAppName, this.Vj, this.mApplication, "permission.STATUSBAR")) {
                  return false;
                }
                if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
                {
                  l1 = paramArrayOfVariantWrapper[0].GetView();
                  ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.14(this, l1));
                }
                return true;
              }
              if (paramString.equals("SetNavigationBarTitle"))
              {
                if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsView()) && (paramArrayOfVariantWrapper[1].IsString()))
                {
                  l1 = paramArrayOfVariantWrapper[0].GetView();
                  paramString = paramArrayOfVariantWrapper[1].GetString();
                  ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.15(this, l1, paramString));
                }
                return true;
              }
              if (paramString.equals("ShowShareMenu"))
              {
                if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
                {
                  l1 = paramArrayOfVariantWrapper[0].GetView();
                  ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.16(this, l1));
                }
                return true;
              }
              if (paramString.equals("HideShareMenu"))
              {
                if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
                {
                  l1 = paramArrayOfVariantWrapper[0].GetView();
                  ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.17(this, l1));
                }
                return true;
              }
              if (paramString.equals("PreviewImage"))
              {
                if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && ((paramArrayOfVariantWrapper[0].IsArray()) || (paramArrayOfVariantWrapper[0].IsTable())) && (paramArrayOfVariantWrapper[1].GetType() == 4))
                {
                  paramString = paramArrayOfVariantWrapper[0].GetTableAsJsonString();
                  localObject1 = new ArrayList();
                  try
                  {
                    localObject2 = new JSONArray(paramString);
                    i = 0;
                    if (i < ((JSONArray)localObject2).length())
                    {
                      paramVariantWrapper = ((JSONArray)localObject2).optString(i);
                      if (TextUtils.isEmpty(paramVariantWrapper)) {
                        break label8339;
                      }
                      paramString = paramVariantWrapper;
                      if (!paramVariantWrapper.startsWith("http://"))
                      {
                        paramString = paramVariantWrapper;
                        if (!paramVariantWrapper.startsWith("https://"))
                        {
                          paramString = this.mApplication.GetSystemPathFromLocal(paramVariantWrapper);
                          if (TextUtils.isEmpty(paramString)) {
                            break label8339;
                          }
                        }
                      }
                      ((ArrayList)localObject1).add(paramString);
                    }
                  }
                  catch (JSONException paramString)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.i("ArkApp", 1, "QQ.PreviewImage parameter error: " + paramString.getMessage());
                    }
                    return true;
                  }
                  i = (int)Math.round(paramArrayOfVariantWrapper[1].GetDouble());
                  ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.18(this, i, (ArrayList)localObject1));
                }
                return true;
              }
              if (paramString.equals("Notify"))
              {
                if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 3)) {
                  paramVariantWrapper.SetBool(ArkAppNotifyCenter.notify(paramArrayOfVariantWrapper[0].GetString(), paramArrayOfVariantWrapper[1].GetString(), paramArrayOfVariantWrapper[2].GetTableAsJsonString()));
                }
                return true;
              }
              if (paramString.equals("SetTalkBackText"))
              {
                if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()) && (paramArrayOfVariantWrapper[1].IsView()))
                {
                  paramString = paramArrayOfVariantWrapper[0].GetString();
                  l1 = paramArrayOfVariantWrapper[1].GetView();
                  ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.19(this, l1, paramString));
                }
                return true;
              }
              if (paramString.equals("ChooseImage"))
              {
                if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 3))
                {
                  l1 = a(paramArrayOfVariantWrapper[2].Copy());
                  paramVariantWrapper = paramArrayOfVariantWrapper[1].GetTableAsJsonString();
                  QLog.i("ArkApp", 1, "QQ.ChooseImage :num=" + paramArrayOfVariantWrapper[0].GetDouble() + " extraInfo=" + paramVariantWrapper);
                  paramString = "";
                  if (this.mApplication != null) {
                    paramString = this.mApplication.GetEngineResPath();
                  }
                  j = (int)paramArrayOfVariantWrapper[0].GetDouble();
                  i = j;
                  if (j <= 1) {
                    i = 1;
                  }
                  j = i;
                  if (i > 9) {
                    j = 9;
                  }
                  bool1 = false;
                }
                try
                {
                  if (!TextUtils.isEmpty(paramVariantWrapper)) {
                    bool1 = new JSONObject(paramVariantWrapper).optBoolean("compress");
                  }
                  adst.a().a(new adnu(this, l1));
                  ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.21(this, j, bool1, paramString));
                  return true;
                }
                catch (JSONException paramString)
                {
                  QLog.e("ArkApp", 1, "Error:", paramString);
                  return false;
                }
              }
              if (paramString.equals("GetAppID"))
              {
                paramVariantWrapper.SetString(String.valueOf(AppSetting.getAppId()));
                return true;
              }
              if (paramString.equals("GetAudioOutputMode"))
              {
                if (ija.Y(BaseApplicationImpl.getContext()))
                {
                  i = 1;
                  QLog.i("ArkApp", 1, "current audio status:" + i);
                  paramVariantWrapper.SetInt(i);
                  return true;
                }
                if (AudioHelper.bL(BaseApplicationImpl.getContext()))
                {
                  i = 2;
                  continue;
                }
                paramString = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
                if (paramString != null)
                {
                  if (paramString.getLoudSpeakerState())
                  {
                    i = 4;
                    continue;
                  }
                  i = 3;
                  continue;
                }
              }
              else if (paramString.equals("IsMute"))
              {
                if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length == 1))
                {
                  bool1 = paramArrayOfVariantWrapper[0].GetBool();
                  paramString = (AudioManager)BaseApplicationImpl.sApplication.getSystemService("audio");
                  if (paramString != null)
                  {
                    try
                    {
                      i = paramString.getStreamVolume(3);
                      if (i <= 0)
                      {
                        bool2 = true;
                        if ((bool2) && (bool1))
                        {
                          l1 = System.currentTimeMillis();
                          if ((Math.abs(l1 - Vn) >= 120000L) || (l1 <= Vn)) {
                            continue;
                          }
                          if (QLog.isColorLevel()) {
                            QLog.e("ArkApp", 2, "IsMute() do not show toast so frequently in 2 min");
                          }
                        }
                        paramVariantWrapper.SetBool(bool2);
                        return true;
                      }
                    }
                    catch (Exception paramString)
                    {
                      QLog.e("ArkApp", 1, "IsMute() error:", paramString);
                      return false;
                    }
                    bool2 = false;
                    continue;
                    if (QLog.isColorLevel()) {
                      QLog.e("ArkApp", 2, "IsMute() show toast");
                    }
                    Vn = l1;
                    localObject1 = aeiy.b(380).a();
                    paramArrayOfVariantWrapper = "";
                    paramString = paramArrayOfVariantWrapper;
                    if (localObject1 != null)
                    {
                      paramString = paramArrayOfVariantWrapper;
                      if (((aeix.e)localObject1).a() != null) {
                        paramString = ((aeix.e)localObject1).a().bxS;
                      }
                    }
                    paramArrayOfVariantWrapper = paramString;
                    if (TextUtils.isEmpty(paramString))
                    {
                      paramArrayOfVariantWrapper = paramString;
                      if (BaseActivity.sTopActivity != null) {
                        paramArrayOfVariantWrapper = BaseActivity.sTopActivity.getString(2131690521);
                      }
                    }
                    ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.22(this, paramArrayOfVariantWrapper));
                    continue;
                  }
                  return false;
                }
              }
              else if (paramString.equals("GetNickNameByView"))
              {
                if (paramArrayOfVariantWrapper != null)
                {
                  l1 = paramArrayOfVariantWrapper.length;
                  if (l1 <= 0L)
                  {
                    QLog.d("ArkApp", 1, "ark.GetNickNameByView invalid param args == 0 ");
                    return false;
                  }
                }
                else
                {
                  l1 = 0L;
                  continue;
                }
                localObject1 = null;
                if ((l1 < 1L) || (!paramArrayOfVariantWrapper[0].IsView())) {
                  continue;
                }
                l2 = paramArrayOfVariantWrapper[0].GetView();
                paramString = (String)localObject1;
                if (l1 >= 2L)
                {
                  paramString = (String)localObject1;
                  if (paramArrayOfVariantWrapper[1].IsString()) {
                    paramString = paramArrayOfVariantWrapper[1].GetString();
                  }
                }
                localObject2 = adnq.getAppInterface();
                if (localObject2 != null)
                {
                  if (!TextUtils.isEmpty(paramString)) {
                    continue;
                  }
                  localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
                  if (l2 != 0L)
                  {
                    paramString = ark.arkGetContainer(l2);
                    if (paramString == null) {
                      continue;
                    }
                    paramString = (wyw)wyw.a(paramString).get();
                    if (!(paramString instanceof wyv)) {
                      continue;
                    }
                    paramArrayOfVariantWrapper = ((wyv)paramString).a();
                    paramString = paramArrayOfVariantWrapper;
                    if (paramArrayOfVariantWrapper == null) {
                      paramString = adnq.b();
                    }
                    paramArrayOfVariantWrapper = paramString;
                    if (QLog.isColorLevel())
                    {
                      QLog.d("ArkApp", 2, new Object[] { "ark.GetNickNameByView Extra ViewID viewHandle=", Long.valueOf(l2), adnq.a(paramString) });
                      paramArrayOfVariantWrapper = paramString;
                    }
                    if (!TextUtils.isEmpty((CharSequence)localObject1))
                    {
                      if (paramArrayOfVariantWrapper == null) {
                        continue;
                      }
                      paramArrayOfVariantWrapper = aqgv.a((QQAppInterface)localObject2, paramArrayOfVariantWrapper, ((String)localObject1).equals(((QQAppInterface)localObject2).getCurrentUin()), (String)localObject1);
                      if (paramArrayOfVariantWrapper != null)
                      {
                        paramString = paramArrayOfVariantWrapper;
                        if (!TextUtils.equals(paramArrayOfVariantWrapper, (CharSequence)localObject1)) {}
                      }
                      else
                      {
                        paramArrayOfVariantWrapper = aqgv.G((QQAppInterface)localObject2, (String)localObject1);
                        paramString = paramArrayOfVariantWrapper;
                        if (TextUtils.isEmpty(paramArrayOfVariantWrapper)) {
                          paramString = aqgv.d((QQAppInterface)localObject2, (String)localObject1, 0);
                        }
                      }
                      paramVariantWrapper.SetString(paramString);
                      if ((paramString != null) && (QLog.isColorLevel())) {
                        QLog.d("ArkApp", 2, new Object[] { "ark.GetNickNameByView ", paramString });
                      }
                      return true;
                    }
                  }
                  else
                  {
                    paramString = adnq.b();
                    paramArrayOfVariantWrapper = paramString;
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.d("ArkApp", 2, new Object[] { "ark.GetNickNameByView old activity=", BaseActivity.sTopActivity, adnq.a(paramString) });
                    paramArrayOfVariantWrapper = paramString;
                    continue;
                  }
                  return false;
                }
                else
                {
                  QLog.d("ArkApp", 1, "ark.GetNickNameByView invalid param appInterface == null ");
                  paramVariantWrapper.SetString(adot.u(paramString, l2));
                  return true;
                }
              }
              else
              {
                if (paramString.equals("GetAppInfo"))
                {
                  localObject1 = new JSONObject();
                  try
                  {
                    ((JSONObject)localObject1).put("package", BaseApplicationImpl.getApplication().getPackageName());
                    ((JSONObject)localObject1).put("name", BaseApplicationImpl.getApplication().getString(2131721057));
                    paramArrayOfVariantWrapper = aqgz.getQQVersion();
                    paramString = paramArrayOfVariantWrapper;
                    if (TextUtils.isEmpty(paramArrayOfVariantWrapper)) {
                      paramString = "3.4.4";
                    }
                    ((JSONObject)localObject1).put("version", paramString);
                  }
                  catch (Exception paramString)
                  {
                    QLog.e("ArkApp", 1, "ark.GetAppInfo: ", paramString);
                    continue;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("ArkApp", 2, new Object[] { "ark.GetAppInfo: ", ((JSONObject)localObject1).toString() });
                  }
                  paramVariantWrapper.SetTableAsJsonString(((JSONObject)localObject1).toString());
                  return true;
                }
                if (paramString.equals("SubscribePublicAccount"))
                {
                  if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 3) || (!paramArrayOfVariantWrapper[0].IsString()) || (!paramArrayOfVariantWrapper[2].IsFunction())) {
                    return false;
                  }
                  l1 = a(paramArrayOfVariantWrapper[2].Copy());
                  paramString = null;
                  try
                  {
                    if (paramArrayOfVariantWrapper[0].IsString()) {
                      paramString = paramArrayOfVariantWrapper[0].GetString();
                    }
                    if ((int)paramArrayOfVariantWrapper[1].GetDouble() == 0) {
                      shk.a(BaseApplicationImpl.getContext(), paramString, new adnv(this, l1));
                    } else {
                      shk.c(BaseApplicationImpl.getContext(), paramString, new adnw(this, l1));
                    }
                  }
                  catch (Exception paramString)
                  {
                    paramString.printStackTrace();
                  }
                }
                return false;
              }
            }
          }
        }
        catch (JSONException paramArrayOfVariantWrapper)
        {
          paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject2;
          continue;
          paramArrayOfVariantWrapper = null;
          continue;
          paramArrayOfVariantWrapper = null;
          continue;
          localObject1 = paramString;
          continue;
          long l2 = 0L;
          continue;
          boolean bool1 = false;
          continue;
          i = -1;
          continue;
          paramString = null;
          continue;
          bool1 = true;
          continue;
          paramArrayOfVariantWrapper = null;
          continue;
          paramString = null;
          continue;
          paramString = null;
          continue;
          continue;
        }
        label8291:
        break label8326;
        label8294:
        continue;
        label8297:
        continue;
        label8300:
        Object localObject4 = null;
        continue;
        label8306:
        Object localObject3 = null;
        continue;
        label8312:
        paramArrayOfVariantWrapper = null;
        continue;
        label8317:
        l1 = 0L;
        localObject1 = null;
        break;
        label8326:
        continue;
        label8329:
        continue;
        label8332:
        continue;
        return true;
        label8337:
        return true;
        label8339:
        i += 1;
      }
      return true;
    }
    
    protected void a(long paramLong, boolean paramBoolean, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
    {
      ark.VariantWrapper localVariantWrapper1 = a(paramLong);
      if (localVariantWrapper1 == null) {
        return;
      }
      ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
      Object localObject;
      if (paramSosoLbsInfo != null)
      {
        localObject = ArkAppCenter.sM();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramSosoLbsInfo.a.city = ((String)localObject);
        }
        localObject = ArkAppCenter.c();
        if ((localObject != null) && (localObject.length == 2))
        {
          paramSosoLbsInfo.a.cf = localObject[0];
          paramSosoLbsInfo.a.cg = localObject[1];
        }
        localObject = "{}";
      }
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("prov", paramSosoLbsInfo.a.province);
        localJSONObject.put("city", paramSosoLbsInfo.a.city);
        localJSONObject.put("dist", paramSosoLbsInfo.a.district);
        localJSONObject.put("road", paramSosoLbsInfo.a.street);
        localJSONObject.put("town", paramSosoLbsInfo.a.town);
        localJSONObject.put("lat", paramSosoLbsInfo.a.cf);
        localJSONObject.put("lng", paramSosoLbsInfo.a.cg);
        paramSosoLbsInfo = localJSONObject.toString();
        localVariantWrapper2.SetTableAsJsonString(paramSosoLbsInfo);
        paramSosoLbsInfo = localVariantWrapper1.Create();
        paramSosoLbsInfo.SetBool(paramBoolean);
        localObject = localVariantWrapper1.Create();
        localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2, paramSosoLbsInfo }, (ark.VariantWrapper)localObject);
        ((ark.VariantWrapper)localObject).Reset();
        paramSosoLbsInfo.Reset();
        localVariantWrapper2.Reset();
        localVariantWrapper1.Reset();
        return;
      }
      catch (JSONException paramSosoLbsInfo)
      {
        for (;;)
        {
          ArkAppCenter.r("ArkApp", paramSosoLbsInfo.getMessage());
          paramSosoLbsInfo = (SosoInterface.SosoLbsInfo)localObject;
        }
      }
    }
    
    protected void a(long paramLong, boolean paramBoolean, String paramString, int paramInt)
    {
      ark.VariantWrapper localVariantWrapper1 = a(paramLong);
      if (localVariantWrapper1 == null) {
        return;
      }
      ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("uin", paramString);
        ((JSONObject)localObject).put("followState", paramInt);
        localVariantWrapper2.SetTableAsJsonString(((JSONObject)localObject).toString());
        paramString = localVariantWrapper1.Create();
        paramString.SetBool(paramBoolean);
        localObject = localVariantWrapper1.Create();
        localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2, paramString }, (ark.VariantWrapper)localObject);
        ((ark.VariantWrapper)localObject).Reset();
        paramString.Reset();
        localVariantWrapper2.Reset();
        localVariantWrapper1.Reset();
        return;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    
    protected void b(long paramLong, boolean paramBoolean, double paramDouble1, double paramDouble2)
    {
      ark.VariantWrapper localVariantWrapper1 = b(paramLong);
      if (localVariantWrapper1 == null) {
        return;
      }
      ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
      localVariantWrapper2.SetDouble(paramDouble1);
      ark.VariantWrapper localVariantWrapper3 = localVariantWrapper1.Create();
      localVariantWrapper3.SetDouble(paramDouble2);
      ark.VariantWrapper localVariantWrapper4 = localVariantWrapper1.Create();
      localVariantWrapper4.SetBool(paramBoolean);
      ark.VariantWrapper localVariantWrapper5 = localVariantWrapper1.Create();
      localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2, localVariantWrapper3, localVariantWrapper4 }, localVariantWrapper5);
      localVariantWrapper5.Reset();
      localVariantWrapper4.Reset();
      localVariantWrapper2.Reset();
      localVariantWrapper3.Reset();
    }
    
    public void jB(List<adph.a> paramList)
    {
      super.jB(paramList);
      j("OpenUrl", 1L, 500L);
      j("SendMessage", 1L, 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adnq
 * JD-Core Version:    0.7.0.1
 */