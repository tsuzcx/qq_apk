package cooperation.qqreader.host;

import ahav;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.text.TextUtils;
import annx;
import anot;
import anre;
import aqhv;
import aqik;
import aqml;
import aqul;
import arlc;
import arts;
import auri;
import auro;
import avls;
import avmc;
import avmw;
import avno;
import avoc;
import avod;
import avpw;
import avpw.d;
import avqq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import cooperation.qqreader.QRBridgeUtil;
import cooperation.qqreader.host.toast.QQToastWrapper;
import cooperation.qqreader.host.toast.Toast;
import cooperation.qqreader.proxy.ReaderInterfacePluginBuilder;
import cooperation.qqreader.proxy.ReaderJsPluginBuilder;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.util.NetworkState;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ReaderHost
{
  public static final String TAG_898 = "dc00898";
  private static String cMg;
  
  public static void setAccount(String paramString)
  {
    avoc.u("ReaderHost", "setAccount: account=" + paramString);
    cMg = paramString;
  }
  
  public String decode(String paramString1, String paramString2)
  {
    return auro.decode(paramString1, paramString2);
  }
  
  public String getAccount()
  {
    if (!TextUtils.isEmpty(cMg)) {
      return cMg;
    }
    str3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str1 = str3;
    if (TextUtils.isEmpty(str3)) {}
    try
    {
      avoc.d("ReaderHost", "[getAccount] runtime getAccount is null!");
      EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("ReaderIPCModule", "action_get_account", new Bundle());
      str1 = str3;
      if (localEIPCResult != null)
      {
        str1 = str3;
        if (localEIPCResult.isSuccess()) {
          str1 = localEIPCResult.data.getString("key_get_account");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        avoc.e("ReaderHost", "[getAccount IPC error ]", localException);
        String str2 = str3;
      }
    }
    cMg = str1;
    return cMg;
  }
  
  public String getIMEI(String paramString)
  {
    return auri.getIMEI(paramString);
  }
  
  public String getIPV4AddressCache()
  {
    return "UnKnow";
  }
  
  public int getMobileInfo()
  {
    return AppNetConnInfo.getMobileInfo();
  }
  
  public String getPSKey(String paramString)
  {
    return QRBridgeUtil.getPSkey(getAccount(), paramString);
  }
  
  public NetworkInfo getRecentNetworkInfo()
  {
    return AppNetConnInfo.getRecentNetworkInfo();
  }
  
  public String getSDKPrivatePath(String paramString)
  {
    return aqul.getSDKPrivatePath(paramString);
  }
  
  public String getSKey(String paramString)
  {
    paramString = QRBridgeUtil.getSKey(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      avoc.e("ReaderHost", "skey is null");
      return paramString;
    }
    avoc.d("ReaderHost", "success get skey");
    return paramString;
  }
  
  public String getSecurityBusinessRootFilePath()
  {
    avls localavls = new avls();
    File localFile = BaseApplicationImpl.getApplication().getRuntime().getSecurityBusinessRootFile(localavls);
    if (localFile != null) {
      return localFile.getAbsolutePath();
    }
    return localavls.oldBusinessDir(getAccount()).getAbsolutePath();
  }
  
  public long getServerTimeMillis()
  {
    return NetConnInfoCenter.getServerTimeMillis();
  }
  
  public Map<String, String> getUrlConfigData()
  {
    return avmw.pZ;
  }
  
  public boolean hasShortCut(Context paramContext, String[] paramArrayOfString)
  {
    return aqml.hasShortCut(paramContext, paramArrayOfString);
  }
  
  public boolean isMobileConn()
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public boolean isNetworkAvailable()
  {
    return AppNetConnInfo.isNetSupport();
  }
  
  public boolean isNowThemeIsNight()
  {
    return ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
  }
  
  public boolean isWXinstalled()
  {
    return WXShareHelper.a().isWXinstalled();
  }
  
  public boolean isWXsupportApi()
  {
    return WXShareHelper.a().isWXsupportApi();
  }
  
  public boolean isWifiConnected()
  {
    return NetworkState.isWifiConn();
  }
  
  public boolean jumpParserAndDoAction(Context paramContext, String paramString)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      paramContext = aqik.c((QQAppInterface)localAppRuntime, paramContext, paramString);
      if (paramContext != null)
      {
        paramContext.ace();
        return true;
      }
    }
    return false;
  }
  
  public void jumpToPlugin(Context paramContext, Intent paramIntent, String paramString)
  {
    if (avod.getActivity(paramContext) == null)
    {
      avoc.e("ReaderHost", "jumpToPlugin: 传入了错误的context，context=" + paramContext);
      return;
    }
    avno.e(paramContext, paramIntent, paramString);
  }
  
  public Toast makeText(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return QQToastWrapper.makeText(paramContext, paramCharSequence, paramInt1, paramInt2);
  }
  
  public void openFileWithOtherApp(Context paramContext, String paramString)
  {
    ahav.F(avod.getActivity(paramContext), paramString);
  }
  
  public boolean recreateTicket(String paramString, Handler.Callback paramCallback)
  {
    return QRBridgeUtil.recreateTicket(paramString, paramCallback);
  }
  
  public void reportCgi(String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    String str = getAccount();
    if (TextUtils.isEmpty(str)) {}
    for (long l = 0L;; l = Long.parseLong(str))
    {
      arts.a().a(paramString1, paramLong1, paramLong2, paramLong3, paramInt, l, paramString2, paramString3, paramBoolean);
      return;
    }
  }
  
  public void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    anot.a(null, "P_CliOper", paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramString5, paramString6, paramString7, paramString8);
  }
  
  public void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    anot.a(null, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void reportDCEvent(String paramString1, String paramString2, boolean paramBoolean)
  {
    annx.b(null, paramString1, paramString2, paramBoolean);
  }
  
  public void sendWindowClosedBroadcast(Context paramContext)
  {
    arlc.aT(paramContext, 11);
  }
  
  public void setBuilderInterfaceImpl(ReaderJsPluginBuilder paramReaderJsPluginBuilder, ReaderInterfacePluginBuilder paramReaderInterfacePluginBuilder)
  {
    avmc.a().a(paramReaderJsPluginBuilder, paramReaderInterfacePluginBuilder);
    avmc.a().WF(true);
  }
  
  public void shareBookToQQ(ContextWrapper paramContextWrapper, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, String paramString7, int paramInt2, String paramString8)
  {
    Activity localActivity = avod.getActivity(paramContextWrapper);
    if (localActivity == null) {
      return;
    }
    if ((!TextUtils.isEmpty(paramString7)) && (paramString7.length() > 5))
    {
      paramContextWrapper = new Intent(localActivity, DirectForwardActivity.class);
      paramContextWrapper.putExtra("toUin", paramString7);
      paramContextWrapper.putExtra("uinType", paramInt2);
      paramContextWrapper.putExtra("nickName", paramString8);
    }
    for (;;)
    {
      paramContextWrapper.putExtra("forward_type", 1001);
      paramContextWrapper.putExtra("req_type", 134);
      if (!TextUtils.isEmpty(paramString3)) {
        paramContextWrapper.putExtra("image_url_remote", paramString3);
      }
      paramContextWrapper.putExtra("title", paramString1);
      paramContextWrapper.putExtra("desc", paramString2);
      paramContextWrapper.putExtra("detail_url", paramString5);
      paramContextWrapper.putExtra("req_share_id", 100492717L);
      paramContextWrapper.putExtra("key_flag_from_plugin", true);
      paramContextWrapper.putExtra("pluginName", "web_share");
      paramContextWrapper.putExtra("k_back", true);
      paramContextWrapper.putExtra("struct_share_key_source_action", "plugin");
      paramContextWrapper.putExtra("struct_share_key_source_action_data", paramString6);
      paramContextWrapper.putExtra("struct_share_key_source_icon", "https://dwz.cn/3UWeuX");
      paramContextWrapper.putExtra("app_name", "手Q阅读");
      paramContextWrapper.putExtra("brief_key", paramString4);
      paramString1 = anre.a(paramContextWrapper.getExtras());
      if (paramString1 != null) {
        paramContextWrapper.putExtra("stuctmsg_bytes", paramString1.getBytes());
      }
      localActivity.startActivityForResult(paramContextWrapper, paramInt1);
      return;
      paramContextWrapper = new Intent(localActivity, ForwardRecentActivity.class);
    }
  }
  
  public void shareImageToWX(String paramString, Bitmap paramBitmap, boolean paramBoolean)
  {
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localWXShareHelper.b(paramString, paramBitmap, i);
      return;
    }
  }
  
  public void shareLocalFileToQQ(ContextWrapper paramContextWrapper, String paramString, int paramInt) {}
  
  public void shareLocalFileToQZone(ContextWrapper paramContextWrapper, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    paramContextWrapper = avod.getActivity(paramContextWrapper);
    if (paramContextWrapper == null) {
      return;
    }
    avpw.d locald = avpw.d.a();
    locald.cMP = getAccount();
    avpw.a(paramContextWrapper, locald, paramString3, paramString1, paramString2, paramInt);
  }
  
  public void shareSummaryPosterToQQ(ContextWrapper paramContextWrapper, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, String paramString4)
  {
    Activity localActivity = avod.getActivity(paramContextWrapper);
    if (localActivity == null) {
      return;
    }
    if ((!TextUtils.isEmpty(paramString3)) && (paramString3.length() > 5))
    {
      paramContextWrapper = new Intent(localActivity, DirectForwardActivity.class);
      paramContextWrapper.putExtra("toUin", paramString3);
      paramContextWrapper.putExtra("uinType", paramInt2);
      paramContextWrapper.putExtra("nickName", paramString4);
    }
    for (;;)
    {
      paramContextWrapper.putExtra("key_flag_from_plugin", true);
      paramContextWrapper.putExtra("image_url", paramString1);
      paramContextWrapper.putExtra("forward_type", -3);
      paramContextWrapper.putExtra("pkg_name", "com.tencent.mobileqq");
      paramContextWrapper.putExtra("req_type", 5);
      paramContextWrapper.putExtra("k_back", true);
      paramContextWrapper.putExtra("brief_key", "[图片]");
      paramContextWrapper.putExtra("struct_share_key_source_action", "plugin");
      paramContextWrapper.putExtra("app_name", "手Q阅读");
      paramContextWrapper.putExtra("struct_share_key_source_icon", "https://dwz.cn/3UWeuX");
      paramContextWrapper.putExtra("struct_share_key_source_action_data", paramString2);
      paramString1 = anre.a(paramContextWrapper.getExtras());
      if (paramString1 != null) {
        paramContextWrapper.putExtra("stuctmsg_bytes", paramString1.getBytes());
      }
      localActivity.startActivityForResult(paramContextWrapper, paramInt1);
      return;
      paramContextWrapper = new Intent(localActivity, ForwardRecentActivity.class);
    }
  }
  
  public void shareToQZone(ContextWrapper paramContextWrapper, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, int paramInt)
  {
    paramContextWrapper = avod.getActivity(paramContextWrapper);
    if (paramContextWrapper == null) {
      return;
    }
    QZoneShareData localQZoneShareData = new QZoneShareData();
    localQZoneShareData.mTitle = paramString1;
    localQZoneShareData.mSummary = paramString2;
    localQZoneShareData.targetUrl = paramString3;
    localQZoneShareData.ER = paramArrayList;
    avqq.a(paramContextWrapper, getAccount(), localQZoneShareData, null, paramInt);
  }
  
  public void startToFMActivity(Context paramContext)
  {
    paramContext = avod.getActivity(paramContext);
    if (paramContext == null)
    {
      avoc.e("ReaderHost", "[startToFMActivity] activity null !");
      return;
    }
    Intent localIntent = new Intent(paramContext, FMActivity.class);
    localIntent.putExtra("category", 6);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("busiType", 7);
    localIntent.putExtra("max_select_count", 1);
    localIntent.putExtra("tab_tab_type", 5);
    localIntent.putExtra("smart_device_switch_tab_flag", 14);
    paramContext.startActivityForResult(localIntent, 10001);
    paramContext.overridePendingTransition(2130771991, 2130771992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.host.ReaderHost
 * JD-Core Version:    0.7.0.1
 */