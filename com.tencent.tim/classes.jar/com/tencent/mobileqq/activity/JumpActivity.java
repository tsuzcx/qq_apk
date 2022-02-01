package com.tencent.mobileqq.activity;

import abhh;
import acfp;
import acgq;
import acjz;
import acms;
import aczy;
import aeay;
import afrz;
import afsf;
import ahau;
import ahav;
import ahgq;
import ahhq;
import ahwm;
import ahwp;
import ahxe;
import ajtk;
import alji;
import aljk;
import aljm;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import anpc;
import apre;
import aqgo;
import aqhs;
import aqhv;
import aqij;
import aqik;
import aqim;
import aqiw;
import aqmr;
import arxa;
import aurf;
import avhc;
import avjj;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil.a;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil.b;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DataMigrationService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.mobileqq.troop.data.InviteToGroupInfo;
import com.tencent.mobileqq.troop.data.JoinGroupInfo;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import cooperation.buscard.BuscardHelper;
import cooperation.comic.VipComicJumpActivity;
import cooperation.qqreader.QRBridgeActivity;
import cooperation.qwallet.plugin.PatternLockUtils;
import cooperation.troop.NearbyVideoChatProxyActivity;
import ina;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import jjq;
import lbz;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import nuk;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import org.json.JSONException;
import org.json.JSONObject;
import rnq;
import skd;
import syw;
import tas;
import vef;
import veg;
import veh;
import vei;
import vek;
import vel;
import wja;

public class JumpActivity
  extends BaseActivity
  implements ahxe, DialogInterface.OnDismissListener, Handler.Callback
{
  public static boolean aXG;
  public static boolean aXH;
  private static volatile boolean aXI;
  private static int bHO = -1;
  private static String[] cr = { "mqq", "mqqapi", "mqqmdpass", "mqqwpa", "mqqopensdkapi", "mqqflyticket", "wtloginmqq", "imto", "mqqtribe", "mqqvoipivr", "mqqverifycode", "mqqdevlock", "qapp", "qqwifi", "mqqconnect", "qqstory", "mqqconferenceflyticket", "mqqavshare" };
  private static HashMap<String, Integer> gy;
  private Intent F;
  private Intent G;
  private acjz jdField_a_of_type_Acjz;
  private aqim jdField_a_of_type_Aqim;
  private BroadcastReceiver aC;
  private String aNM;
  private String aNN;
  private String aNO;
  private boolean aXC;
  private boolean aXD;
  private boolean aXE;
  private boolean aXF;
  private BroadcastReceiver az;
  private WtloginObserver b = new vef(this);
  private String mPackageName = "";
  private MqqHandler r;
  private ViewGroup rootView;
  private HandlerThread s;
  protected final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  
  private boolean J(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    Object localObject3 = null;
    Object localObject2 = null;
    localObject1 = localObject3;
    for (;;)
    {
      try
      {
        paramIntent = paramIntent.getExtras();
        localObject1 = localObject3;
        StringBuilder localStringBuilder = new StringBuilder("system share.doShareCheckNeedSDPermission():");
        localObject1 = localObject3;
        localStringBuilder.append("phone info [mod:").append(Build.MODEL).append(",ver:").append(Build.VERSION.SDK).append(",maf:").append(Build.MANUFACTURER).append("]");
        localObject1 = localObject3;
        localObject4 = paramIntent.get("android.intent.extra.STREAM");
        paramIntent = localObject2;
        if (localObject4 != null)
        {
          localObject1 = localObject3;
          if (!(localObject4 instanceof Uri)) {
            continue;
          }
          localObject1 = localObject3;
          paramIntent = (Uri)localObject4;
        }
        localObject1 = paramIntent;
        localStringBuilder.append(",intent.extra=").append(paramIntent);
        localObject1 = paramIntent;
        QLog.i("JumpAction", 1, localStringBuilder.toString());
      }
      catch (Exception paramIntent)
      {
        Object localObject4;
        QLog.e("JumpAction", 1, "system share.doShareCheckNeedSDPermission() e=", paramIntent);
        paramIntent = (Intent)localObject1;
        continue;
        boolean bool = false;
        continue;
      }
      if (paramIntent == null) {
        break;
      }
      bool = ahwp.b(paramIntent, this);
      QLog.d("JumpAction", 1, new Object[] { "system share.doShareCheckNeedSDPermission() canReadFromUri=", Boolean.valueOf(bool) });
      if (bool) {
        continue;
      }
      bool = true;
      return bool;
      paramIntent = localObject2;
      localObject1 = localObject3;
      if ((localObject4 instanceof String))
      {
        localObject1 = localObject3;
        paramIntent = Uri.parse((String)localObject4);
      }
    }
  }
  
  private void a(boolean paramBoolean, Intent paramIntent)
  {
    Object localObject = getIntent();
    if (localObject == null) {
      return;
    }
    try
    {
      i = ((Intent)localObject).getIntExtra("busi_type", -1);
      j = ((Intent)localObject).getIntExtra("verify_type", -1);
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("ticket");
        if (QLog.isColorLevel()) {
          QLog.d("Q.security_verify", 2, String.format("onWebSecVerifyResult, isSuc: %s, busiType: %s, verifyType: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j) }));
        }
        localObject = ((Intent)localObject).getParcelableExtra("extra_data");
        switch (i)
        {
        default: 
          finish();
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("JumpAction", 1, "onWebSecVerifyResult", localException);
        int j = -1;
        int i = -1;
        continue;
        if ((localObject instanceof InviteToGroupInfo))
        {
          localObject = (InviteToGroupInfo)localObject;
          acms localacms = (acms)this.app.getBusinessHandler(20);
          if ((paramBoolean) && (localObject != null) && (!TextUtils.isEmpty(paramIntent)))
          {
            ((InviteToGroupInfo)localObject).verifyType = j;
            ((InviteToGroupInfo)localObject).cnA = paramIntent;
            localacms.a((InviteToGroupInfo)localObject);
          }
          else
          {
            localacms.notifyUI(6, false, new Object[] { Integer.valueOf(8), Integer.valueOf(-1) });
            continue;
            if ((localObject instanceof JoinGroupInfo))
            {
              localObject = (JoinGroupInfo)localObject;
              localacms = (acms)this.app.getBusinessHandler(20);
              if ((paramBoolean) && (localObject != null) && (!TextUtils.isEmpty(paramIntent)))
              {
                ((JoinGroupInfo)localObject).verifyType = j;
                ((JoinGroupInfo)localObject).cnA = paramIntent;
                localacms.a((JoinGroupInfo)localObject);
              }
              else
              {
                localacms.notifyUI(6, false, new Object[] { Integer.valueOf(1), Integer.valueOf(-1) });
                continue;
                paramIntent = null;
              }
            }
          }
        }
      }
    }
  }
  
  public static void aC(Intent paramIntent)
  {
    String str = paramIntent.getDataString();
    if ((paramIntent.getComponent() == null) && (!TextUtils.isEmpty(str)))
    {
      Object localObject = Uri.parse(str).getScheme();
      boolean bool2 = hk((String)localObject);
      boolean bool1 = false;
      if (bool2) {
        bool1 = hl((String)localObject);
      }
      if (QLog.isDevelopLevel()) {
        QLog.w("JumpAction", 1, "processIntent, scheme[" + (String)localObject + "], isLegalScheme[" + bool2 + "], needForceSetComponent[" + bool1 + "]");
      }
      if ((bool2) && (bool1))
      {
        localObject = anpc.a(BaseApplication.getContext());
        HashMap localHashMap = new HashMap();
        localHashMap.put("URL", str);
        ((anpc)localObject).collectPerformance("", "JA_ILLEGAL", true, 0L, 0L, localHashMap, "");
        paramIntent.setComponent(new ComponentName("com.tencent.tim", "com.tencent.mobileqq.activity.JumpActivity"));
      }
    }
  }
  
  public static void aR(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "initJASwitch with " + paramString + " inited=" + aXI);
        }
        boolean bool = aXI;
        if (bool) {
          return;
        }
      }
      finally {}
      try
      {
        bHO = (int)Long.parseLong(paramString, 16);
        if (paramBoolean) {
          BaseApplicationImpl.sApplication.getSharedPreferences("Jump_Action", 0).edit().putString("JASwitch", paramString).commit();
        }
      }
      catch (NumberFormatException paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("JumpAction", 2, "initJASwitch error", paramString);
        continue;
      }
      aXI = true;
    }
  }
  
  private static String as(Context paramContext)
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if ((paramContext instanceof FragmentActivity))
    {
      paramContext = ((FragmentActivity)paramContext).getSupportFragmentManager().getFragments();
      localObject1 = localObject2;
      if (paramContext != null)
      {
        if (paramContext.size() > 0) {
          break label42;
        }
        localObject1 = localObject2;
      }
    }
    return localObject1;
    label42:
    paramContext = paramContext.iterator();
    Fragment localFragment;
    do
    {
      localObject1 = localObject2;
      if (!paramContext.hasNext()) {
        break;
      }
      localFragment = (Fragment)paramContext.next();
    } while (!localFragment.isVisible());
    paramContext = localFragment.getClass().getName();
    if ((localFragment instanceof MainFragment))
    {
      localObject1 = (MainFragment)localFragment;
      paramContext = paramContext + "$" + ((MainFragment)localObject1).oU();
    }
    for (;;)
    {
      localObject1 = paramContext;
      if (!(localFragment instanceof ChatFragment)) {
        break;
      }
      localObject2 = (ChatFragment)localFragment;
      localObject1 = paramContext;
      if (((ChatFragment)localObject2).b == null) {
        break;
      }
      return paramContext + "$" + ((ChatFragment)localObject2).b.getCurType();
    }
  }
  
  private Uri b(Uri paramUri)
  {
    Object localObject1 = paramUri;
    Object localObject2;
    if (paramUri != null)
    {
      localObject1 = paramUri;
      if ("file".equals(paramUri.getScheme()))
      {
        localObject2 = paramUri.getPath();
        localObject1 = paramUri;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = new File((String)localObject2);
          localObject1 = paramUri;
          if (!((File)localObject2).exists()) {}
        }
      }
    }
    try
    {
      localObject1 = ((File)localObject2).getCanonicalPath();
      if (!((String)localObject1).startsWith(File.separator + "data" + File.separator + "data" + File.separator + BaseApplicationImpl.getContext().getPackageName())) {}
      for (int i = 1; i != 0; i = 0)
      {
        localObject1 = Uri.parse("file://" + (String)localObject1);
        return localObject1;
      }
      return null;
    }
    catch (Exception localException) {}
    return paramUri;
  }
  
  private void b(Intent paramIntent, Bundle paramBundle)
  {
    new JumpActivity.4(this, paramIntent, paramBundle).run();
  }
  
  private void bF()
  {
    if (this.rootView != null) {
      this.rootView.setVisibility(8);
    }
  }
  
  private void bPV()
  {
    ahav.en(this);
    ahau.JH("0X8005533");
    finish();
  }
  
  private void bPW()
  {
    String str1 = getPackageName();
    String str2 = InstallActivity.class.getName();
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.addFlags(268435456);
    localIntent.setComponent(new ComponentName(str1, str2));
    startActivity(localIntent);
    finish();
  }
  
  private void bPX()
  {
    try
    {
      if (this.jdField_a_of_type_Acjz == null) {
        this.jdField_a_of_type_Acjz = new acjz(this.app.getAccount());
      }
      startActivityForResult(new Intent(this, QQMapActivity.class).putExtra("uin", this.app.getAccount()), 18);
      return;
    }
    catch (Exception localException)
    {
      if (this.aXE) {
        vN("Google Map not exist");
      }
      finish();
    }
  }
  
  private static void bQk()
  {
    aR(BaseApplicationImpl.sApplication.getSharedPreferences("Jump_Action", 0).getString("JASwitch", "FFFFFFFF"), false);
  }
  
  private void bR(Intent paramIntent)
  {
    Intent localIntent;
    if (!this.app.isLogin())
    {
      localIntent = new Intent();
      localIntent.setClass(this, LoginActivity.class);
      localIntent.addFlags(67371008);
      localIntent.putExtra("QREADER_SHORTCUT_JUMP_KEY", paramIntent);
      localIntent.putExtras(paramIntent.getExtras());
      startActivity(localIntent);
      finish();
      return;
    }
    if ((GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(this)))
    {
      localIntent = new Intent(getActivity(), GesturePWDUnlockActivity.class);
      localIntent.putExtra("key_gesture_from_jumpactivity", true);
      this.F = new Intent();
      this.F.putExtras(paramIntent);
      startActivityForResult(localIntent, 571);
      return;
    }
    bS(paramIntent);
  }
  
  private void bS(Intent paramIntent)
  {
    Intent localIntent = new Intent(this, QRBridgeActivity.class);
    localIntent.putExtras(paramIntent);
    startActivity(localIntent);
    finish();
  }
  
  private void bT(Intent paramIntent)
  {
    Intent localIntent;
    if (!this.app.isLogin())
    {
      localIntent = new Intent();
      localIntent.setClass(this, LoginActivity.class);
      localIntent.addFlags(67371008);
      localIntent.putExtra("QQCOMIC_SHORTCUT_JUMP_KEY", paramIntent);
      localIntent.putExtras(paramIntent.getExtras());
      startActivity(localIntent);
      finish();
      return;
    }
    if ((GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(this)))
    {
      localIntent = new Intent(getActivity(), GesturePWDUnlockActivity.class);
      localIntent.putExtra("key_gesture_from_jumpactivity", true);
      this.G = new Intent();
      this.G.putExtras(paramIntent);
      startActivityForResult(localIntent, 572);
      return;
    }
    bU(paramIntent);
  }
  
  private void bU(Intent paramIntent)
  {
    Object localObject;
    if (paramIntent != null)
    {
      localObject = paramIntent.getStringExtra("comicID");
      if ((!((String)localObject).equalsIgnoreCase("0")) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        break label57;
      }
      localObject = new Intent(this, VipComicJumpActivity.class);
    }
    for (;;)
    {
      ((Intent)localObject).putExtras(paramIntent);
      startActivity((Intent)localObject);
      finish();
      return;
      label57:
      localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).setFlags(1073741824);
    }
  }
  
  private void bV(Intent paramIntent)
  {
    Intent localIntent;
    if (!this.app.isLogin())
    {
      localIntent = new Intent();
      localIntent.setClass(this, LoginActivity.class);
      localIntent.addFlags(67371008);
      localIntent.putExtra("QFILE_SHORTCUT_JUMP_KEY", paramIntent);
      localIntent.putExtras(paramIntent.getExtras());
      startActivity(localIntent);
      finish();
      return;
    }
    if ((GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(this)))
    {
      localIntent = new Intent(getActivity(), GesturePWDUnlockActivity.class);
      localIntent.putExtra("key_gesture_from_jumpactivity", true);
      localIntent.putExtras(paramIntent.getExtras());
      startActivityForResult(localIntent, 570);
      return;
    }
    bPV();
  }
  
  private void bW(Intent paramIntent)
  {
    if (!this.app.isLogin())
    {
      paramIntent = new Intent();
      paramIntent.setClass(this, LoginActivity.class);
      paramIntent.addFlags(67371008);
      startActivity(paramIntent);
      finish();
      return;
    }
    if ((GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(this)))
    {
      Intent localIntent = new Intent(getActivity(), GesturePWDUnlockActivity.class);
      localIntent.putExtra("key_gesture_from_jumpactivity", true);
      localIntent.putExtras(paramIntent.getExtras());
      startActivityForResult(localIntent, 573);
      return;
    }
    br(paramIntent.getExtras());
  }
  
  private void bX(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ("com.tencent.mobileqq.action.buscard".equals(str)) {
      BuscardHelper.a(this.mRuntime, paramIntent, str);
    }
    for (;;)
    {
      finish();
      return;
      if ("android.nfc.action.TECH_DISCOVERED".equals(str)) {
        BuscardHelper.a(this.app.getCurrentAccountUin(), getActivity(), paramIntent);
      }
    }
  }
  
  private void bY(Intent paramIntent)
  {
    int i = 0;
    try
    {
      boolean bool = paramIntent.getBooleanExtra("IS_LOGIN_SUC_CALL", false);
      i = bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      Intent localIntent = new Intent();
      localIntent.setClass(this, LoginActivity.class);
      localIntent.addFlags(67371008);
      localIntent.putExtra("QLINK_SHORTCUT_JUMP_KEY", paramIntent);
      startActivity(localIntent);
      finish();
      return;
    }
    if (!this.app.isLogin()) {
      if (i != 0)
      {
        finish();
        return;
      }
    }
    avhc.c(this, 7, null);
    finish();
  }
  
  private static void bZ(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    paramIntent = paramIntent.getDataString();
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "reportJumpArguments action=" + str + "; data=" + paramIntent);
    }
    anpc localanpc = anpc.a(BaseApplication.getContext());
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", str);
    localHashMap.put("data", paramIntent);
    localanpc.collectPerformance("", "JA_ARGUMENTS", true, 0L, 0L, localHashMap, "");
  }
  
  private void br(Bundle paramBundle)
  {
    Object localObject;
    if (paramBundle != null)
    {
      localObject = paramBundle.getString("din");
      paramBundle = paramBundle.getString("qrurl");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (!"9971".equals(localObject)) {
          break label55;
        }
        tas.a(this.app, this, null, "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html?from=2", null);
      }
    }
    for (;;)
    {
      finish();
      return;
      label55:
      syw localsyw = (syw)this.app.getBusinessHandler(51);
      DeviceInfo localDeviceInfo = localsyw.a(Long.parseLong((String)localObject));
      if ((localDeviceInfo != null) && (((String)localObject).equals(String.valueOf(localDeviceInfo.din))))
      {
        localsyw.a(this, localDeviceInfo, false, null);
      }
      else if (!TextUtils.isEmpty(paramBundle))
      {
        localObject = new Intent();
        ((Intent)localObject).setClass(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramBundle);
        ((Intent)localObject).putExtra("title", acfp.m(2131707541));
        ((Intent)localObject).putExtra("webStyle", "noBottomBar");
        ((Intent)localObject).putExtra("hide_more_button", true);
        ((Intent)localObject).putExtra("selfSet_leftViewText", acfp.m(2131707549));
        ((Intent)localObject).putExtra("leftViewText", acfp.m(2131707547));
        startActivity((Intent)localObject);
      }
      else
      {
        arxa.a().showToast(acfp.m(2131707546));
      }
    }
  }
  
  private void bs(Bundle paramBundle)
  {
    new JumpActivity.5(this, paramBundle).run();
  }
  
  private void ca(Intent paramIntent)
  {
    Object localObject2 = paramIntent.getData();
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = new String(aqgo.decode(((Uri)localObject2).getQueryParameter("param"), 0));
      paramIntent = ((Uri)localObject2).getQueryParameter("appname");
      ((Uri)localObject2).getQueryParameter("src_type");
      ((Uri)localObject2).getQueryParameter("version");
      localObject2 = ((Uri)localObject2).getQueryParameter("share_id");
    }
    try
    {
      l = Long.parseLong((String)localObject2);
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (l == 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "app id is null,can not share");
        }
        return;
      }
    }
    catch (Exception localException)
    {
      long l;
      do
      {
        do
        {
          for (;;)
          {
            l = 0L;
          }
          if ("wangzhe".equals(paramIntent)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("JumpAction", 2, "app name is not wangzhe");
        return;
        paramIntent = null;
        try
        {
          localObject1 = new JSONObject((String)localObject1).getString("url");
          paramIntent = (Intent)localObject1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
          Intent localIntent = new Intent(this, ReadInJoyDeliverVideoActivity.class);
          localIntent.putExtra("arg_is_from_wang_zhe", true);
          localIntent.putExtra("arg_wang_zhe_app_id", l);
          startActivity(localIntent);
        }
        if ((!this.app.isLogin()) && (!TextUtils.isEmpty(paramIntent)))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).setClass(this, LoginActivity.class);
          ((Intent)localObject1).putExtra("is_from_king_moment", true);
          ((Intent)localObject1).putExtra("king_moment_cover_url", paramIntent);
          ((Intent)localObject1).putExtra("arg_wang_zhe_app_id", l);
          startActivity((Intent)localObject1);
          return;
        }
      } while (TextUtils.isEmpty(paramIntent));
      lbz.a().bB(paramIntent, this.app.getCurrentUin());
    }
  }
  
  private void cb(Intent paramIntent)
  {
    try
    {
      Object localObject = paramIntent.getParcelableExtra("extra_data");
      if ((!TextUtils.isEmpty(paramIntent.getStringExtra("url"))) && (((localObject instanceof InviteToGroupInfo)) || ((localObject instanceof JoinGroupInfo))))
      {
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtras(paramIntent);
        startActivityForResult((Intent)localObject, 25);
        return;
      }
      QLog.d("Q.security_verify", 1, "goToWebSecVerify, error param!");
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        QLog.d("Q.security_verify", 1, "goToWebSecVerify", paramIntent);
      }
    }
    finish();
  }
  
  private boolean e(aqhv paramaqhv)
  {
    if ((paramaqhv == null) || (paramaqhv.attrs == null)) {}
    while ((!MiniProgramOpenSdkUtil.isSharingMiniProgram(paramaqhv.attrs)) || (paramaqhv.ctj.equals("to_qzone"))) {
      return false;
    }
    return true;
  }
  
  private boolean f(aqhv paramaqhv)
  {
    if (paramaqhv == null) {}
    String str2;
    String str1;
    do
    {
      do
      {
        return false;
      } while (TextUtils.isEmpty(paramaqhv.getAttribute("share_id")));
      str2 = paramaqhv.getAttribute("req_type");
      str1 = paramaqhv.getAttribute("cflag");
    } while (TextUtils.isEmpty(str2));
    for (;;)
    {
      for (;;)
      {
        try
        {
          str2 = toBase64Decode(str2);
          if (TextUtils.isEmpty(str2)) {
            break label203;
          }
          i = Integer.valueOf(str2).intValue();
          if (((i == 3) || (i == 4)) && ("qzone".equals(paramaqhv.cti)) && ("publish".equals(paramaqhv.ctj)))
          {
            QLog.i("JumpAction", 1, "ShareShuoshuoOrVideoToQZone and the JumpActivity has not finish.");
            return true;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.d("JumpAction", 1, "needToStartQZoneProcess catch NumberFormatException. ", localNumberFormatException);
          i = 1;
          continue;
        }
        if (TextUtils.isEmpty(str1)) {
          break;
        }
        try
        {
          paramaqhv = toBase64Decode(str1);
          if (!TextUtils.isEmpty(paramaqhv))
          {
            j = Integer.valueOf(paramaqhv).intValue();
            if ((i != 5) || ((j & 0x1) == 0)) {
              break;
            }
            QLog.i("JumpAction", 1, "SharePictureToQZone and the JumpActivity has not finish.");
            return true;
          }
        }
        catch (NumberFormatException paramaqhv)
        {
          for (;;)
          {
            QLog.d("JumpAction", 1, "needToStartQZoneProcess catch NumberFormatException. ", paramaqhv);
            int j = 0;
          }
        }
      }
      label203:
      int i = 1;
    }
  }
  
  private String g(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    localByteArrayOutputStream.close();
    return new String(localByteArrayOutputStream.toByteArray(), "UTF-8");
  }
  
  private void h(Intent paramIntent, int paramInt)
  {
    try
    {
      if (this.s == null)
      {
        this.s = ThreadManager.newFreeHandlerThread("jump_action_thread", 0);
        this.s.start();
        this.r = new MqqHandler(this.s.getLooper());
      }
      ahwm localahwm = new ahwm(this, this);
      showDialog();
      this.r.post(new JumpActivity.10(this, localahwm, paramIntent, paramInt));
      return;
    }
    finally {}
  }
  
  public static void handleIntentForQQBrowser(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (paramIntent.getComponent() != null)
      {
        Object localObject = paramIntent.getComponent().getClassName();
        if ((localObject != null) && ((((String)localObject).contains("QQBrowserActivity")) || (((String)localObject).contains("QQBrowserDelegationActivity"))) && (!paramIntent.hasExtra("StartClickTime")))
        {
          paramIntent.putExtra("StartClickTime", SystemClock.elapsedRealtime());
          String str = as(paramContext);
          localObject = new StringBuilder().append(paramContext.getClass().getName());
          if (TextUtils.isEmpty(str)) {}
          for (paramContext = "";; paramContext = "$" + str)
          {
            paramIntent.putExtra("SourceActivityName", paramContext);
            return;
          }
        }
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private static boolean hk(String paramString)
  {
    if (gy == null) {}
    try
    {
      if (gy == null)
      {
        gy = new HashMap();
        int i = 0;
        while (i < cr.length)
        {
          String str = cr[i];
          gy.put(str, Integer.valueOf(i));
          i += 1;
        }
        if (!aXI) {
          bQk();
        }
      }
      return gy.containsKey(paramString);
    }
    finally {}
  }
  
  private static boolean hl(String paramString)
  {
    if (gy != null) {
      return (1 << ((Integer)gy.get(paramString)).intValue() & bHO) != 0;
    }
    return false;
  }
  
  private void i(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    Object localObject = getIntent();
    if ((paramBoolean1) && (!this.app.isLogin()))
    {
      aXH = true;
      paramString = new Intent(this, LoginActivity.class);
      paramString.putExtra("isActionSend", true);
      paramString.putExtras(paramString);
      paramString.setFlags(16777216);
      startActivityForResult(paramString, 26);
    }
    do
    {
      return;
      if ((paramBoolean2) && (GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())))
      {
        startActivityForResult(new Intent(getActivity(), GesturePWDUnlockActivity.class), 27);
        return;
      }
      aXH = false;
      localObject = ((Intent)localObject).getDataString();
      localObject = aqik.c(this.app, this, (String)localObject);
      ((aqhv)localObject).setFrom(paramString);
      ((aqhv)localObject).setPkgName(this.mPackageName);
    } while (!((aqhv)localObject).ace());
    finish();
  }
  
  private void j(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    Object localObject = getIntent();
    if ((paramBoolean1) && (!this.app.isLogin()))
    {
      aXG = true;
      paramString = new Intent(this, LoginActivity.class);
      paramString.putExtra("isActionSend", true);
      paramString.putExtras(paramString);
      paramString.setFlags(16777216);
      startActivityForResult(paramString, 21);
      return;
    }
    if ((paramBoolean2) && (GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())))
    {
      startActivityForResult(new Intent(getActivity(), GesturePWDUnlockActivity.class), 22);
      return;
    }
    aXG = false;
    localObject = ((Intent)localObject).getDataString();
    localObject = aqik.c(this.app, this, (String)localObject);
    ((aqhv)localObject).setFrom(paramString);
    ((aqhv)localObject).ace();
    finish();
  }
  
  private void showDialog()
  {
    try
    {
      setContentView(2131561386);
      this.rootView = ((RelativeLayout)findViewById(2131370003));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("JumpAction", 1, localThrowable, new Object[0]);
    }
  }
  
  private String toBase64Decode(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      paramString = new String(aqgo.decode(paramString, 0));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private void ts()
  {
    if (this.az == null)
    {
      this.az = new veg(this);
      IntentFilter localIntentFilter = new IntentFilter("ShareToQZoneAndFinishTheLastActivity");
      registerReceiver(this.az, localIntentFilter);
    }
  }
  
  private void vN(String paramString)
  {
    if ((paramString == null) || (this.aNO == null) || (this.aNN == null) || (this.aNM == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ("app".equals(this.aNM));
        if (!"web".equals(this.aNM)) {
          break;
        }
      } while (!"javascript".equals(this.aNN));
      paramString = "javascript:" + this.aNO + "('" + paramString + "')";
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.getCurrentAccountUin());
      localIntent.setData(Uri.parse(paramString));
      startActivity(localIntent);
      return;
    } while (!"internal".equals(this.aNM));
  }
  
  private void xu(boolean paramBoolean)
  {
    Object localObject3 = getIntent();
    Object localObject2 = ((Intent)localObject3).getExtras();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    if ((paramBoolean) && (!this.app.isLogin()))
    {
      localObject2 = new Intent(this, LoginActivity.class);
      ((Intent)localObject2).putExtra("isActionSend", true);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtras((Intent)localObject3);
      startActivityForResult((Intent)localObject2, 24);
      return;
    }
    localObject2 = ((Intent)localObject3).getStringExtra("CONFIG_APPID");
    localObject1 = ((Intent)localObject3).getStringExtra("CONFIG_APPNAME");
    String str1 = ((Intent)localObject3).getStringExtra("CONFIG_APPICON");
    String str2 = ((Intent)localObject3).getStringExtra("MINI_CONFIG_DEV_DESC");
    int m = ((Intent)localObject3).getIntExtra("CONFIG_VER_TYPE", 3);
    int j = ((Intent)localObject3).getIntExtra("CONFIG_REPORTTYPE", 0);
    int k = ((Intent)localObject3).getIntExtra("CONFIG_ENGINETYPE", 0);
    int i = ((Intent)localObject3).getIntExtra("CONFIG_APPTYPE", -1);
    if (i != -1) {
      j = i;
    }
    for (;;)
    {
      k = ((Intent)localObject3).getIntExtra("MINI_CONFIG_SCENE", 10086);
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str1)))
      {
        localObject3 = new MiniAppInfo();
        ((MiniAppInfo)localObject3).appId = ((String)localObject2);
        ((MiniAppInfo)localObject3).name = ((String)localObject1);
        ((MiniAppInfo)localObject3).iconUrl = str1;
        ((MiniAppInfo)localObject3).setEngineType(i);
        ((MiniAppInfo)localObject3).setReportType(j);
        ((MiniAppInfo)localObject3).developerDesc = str2;
        ((MiniAppInfo)localObject3).verType = m;
        localObject1 = new MiniAppConfig((MiniAppInfo)localObject3);
        ((MiniAppConfig)localObject1).launchParam = new LaunchParam();
        ((MiniAppConfig)localObject1).launchParam.miniAppId = ((String)localObject2);
        ((MiniAppConfig)localObject1).launchParam.scene = k;
      }
      for (;;)
      {
        if ((localObject1 != null) && (k == 1023) && (((MiniAppConfig)localObject1).config.isEngineTypeMiniGame())) {
          aeay.be(false, 0);
        }
        if (localObject1 != null) {
          MiniAppController.startApp(this, (MiniAppConfig)localObject1, null);
        }
        moveTaskToBack(true);
        finish();
        return;
        localObject1 = null;
      }
      i = k;
    }
  }
  
  private void xv(boolean paramBoolean)
  {
    Intent localIntent = getIntent();
    Object localObject2 = localIntent.getExtras();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    if ((paramBoolean) && (!this.app.isLogin()))
    {
      localObject2 = new Intent(this, LoginActivity.class);
      ((Intent)localObject2).putExtra("isActionSend", true);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtras(localIntent);
      startActivityForResult((Intent)localObject2, 20);
      return;
    }
    h(localIntent, 1);
  }
  
  private void xw(boolean paramBoolean)
  {
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      QLog.i("JumpAction", 1, "system share.doShare error intent is null");
      finish();
      return;
    }
    if (localIntent.getExtras() == null)
    {
      QLog.i("JumpAction", 1, "system share.doShare error extra is null");
      finish();
      return;
    }
    if (ForwardUtils.aL(this))
    {
      xx(paramBoolean);
      return;
    }
    HashMap localHashMap = new HashMap();
    anpc.a(BaseApplication.getContext()).collectPerformance("", "noSDPermissionShare", true, 0L, 0L, localHashMap, "");
    boolean bool = J(localIntent);
    QLog.d("JumpAction", 1, new Object[] { "system share.doShare needGrantSDPermission=", Boolean.valueOf(bool) });
    if ((bool) && (Build.VERSION.SDK_INT >= 23))
    {
      aczy.a(this, 3, new vei(this, paramBoolean));
      return;
    }
    xx(paramBoolean);
  }
  
  private void xx(boolean paramBoolean)
  {
    Intent localIntent = getIntent();
    Bundle localBundle = localIntent.getExtras();
    if (localBundle == null)
    {
      QLog.i("JumpAction", 1, "system share.doShare error extra is null");
      finish();
      return;
    }
    if ((paramBoolean) && (!this.app.isLogin()))
    {
      localIntent = new Intent(this, LoginActivity.class);
      localIntent.putExtra("isActionSend", true);
      localIntent.putExtras(localBundle);
      localIntent.putExtras(localIntent);
      startActivityForResult(localIntent, 19);
      return;
    }
    if (localBundle.getBoolean("qqfav_extra_from_system_share", false))
    {
      int i = q(localBundle);
      if (i == 4) {
        avjj.z(this, 2131700278, 1);
      }
      for (;;)
      {
        finish();
        return;
        if (i != 0) {
          avjj.z(this, 2131700274, 1);
        }
      }
    }
    h(localIntent, 0);
  }
  
  public boolean PL()
  {
    try
    {
      if (!aqij.a(this, true))
      {
        super.finish();
        return true;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public int a(Bundle paramBundle, HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("req_type", aqgo.encodeToString("5".getBytes(), 0));
    if (getIntent().getAction().equals("android.intent.action.SEND"))
    {
      paramBundle = paramBundle.get("android.intent.extra.STREAM");
      if (paramBundle == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send extra_stream null");
        }
        return 1;
      }
      if ((paramBundle instanceof Uri)) {
        paramBundle = (Uri)paramBundle;
      }
    }
    for (;;)
    {
      if (paramBundle == null)
      {
        return 1;
        if ((paramBundle instanceof String)) {
          paramBundle = Uri.parse((String)paramBundle);
        }
      }
      else
      {
        paramBundle = ahhq.b(this, paramBundle);
        if ((TextUtils.isEmpty(paramBundle)) || (!new File(paramBundle).exists()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send file path invalid. path=" + paramBundle);
          }
          return 1;
        }
        for (;;)
        {
          String str1;
          try
          {
            str1 = URLEncoder.encode(paramBundle, "UTF-8");
            paramHashMap.put("file_data", aqgo.encodeToString(str1.getBytes(), 0));
            return b(paramHashMap);
          }
          catch (UnsupportedEncodingException paramHashMap)
          {
            if (QLog.isColorLevel()) {
              QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|encode fail. path=" + paramBundle + ",exp:" + paramHashMap.getMessage());
            }
            return 1;
          }
          try
          {
            paramBundle = (ArrayList)paramBundle.get("android.intent.extra.STREAM");
            if (paramBundle == null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send_muti extra_stream null");
              }
              return 1;
            }
          }
          catch (Exception paramBundle)
          {
            for (;;)
            {
              paramBundle.printStackTrace();
              paramBundle = null;
            }
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            for (;;)
            {
              if (i < paramBundle.size())
              {
                str1 = ahhq.b(this, (Uri)paramBundle.get(i));
                if ((!TextUtils.isEmpty(str1)) && (new File(str1).exists())) {}
                try
                {
                  localArrayList.add(URLEncoder.encode(str1, "UTF-8"));
                  i += 1;
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                  for (;;)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send_muti path encode fail: %s" + localUnsupportedEncodingException.getMessage());
                    }
                  }
                }
              }
            }
            if (localArrayList.isEmpty())
            {
              if (QLog.isColorLevel()) {
                QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send_muti pathlist empty");
              }
              return 1;
            }
            paramBundle = "";
            i = 0;
            while (i < localArrayList.size())
            {
              String str2 = paramBundle + (String)localArrayList.get(i);
              paramBundle = str2;
              if (i != localArrayList.size() - 1) {
                paramBundle = str2 + ";";
              }
              i += 1;
            }
            paramHashMap.put("file_data", aqgo.encodeToString(paramBundle.getBytes(), 0));
          }
        }
      }
      paramBundle = null;
    }
  }
  
  /* Error */
  public int a(Bundle paramBundle, HashMap<String, String> paramHashMap, Uri paramUri, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_1
    //   4: istore 6
    //   6: aload_1
    //   7: ldc 217
    //   9: invokevirtual 1397	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   12: ifne +64 -> 76
    //   15: aload_2
    //   16: ldc_w 980
    //   19: ldc_w 1399
    //   22: invokevirtual 1338	java/lang/String:getBytes	()[B
    //   25: iconst_0
    //   26: invokestatic 1342	aqgo:encodeToString	([BI)Ljava/lang/String;
    //   29: invokevirtual 433	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   32: pop
    //   33: aload 4
    //   35: invokestatic 356	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifeq +25 -> 63
    //   41: ldc 151
    //   43: astore_1
    //   44: aload_2
    //   45: ldc_w 1401
    //   48: aload_1
    //   49: invokevirtual 433	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: aload_0
    //   54: aload_2
    //   55: invokevirtual 1365	com/tencent/mobileqq/activity/JumpActivity:b	(Ljava/util/HashMap;)I
    //   58: istore 5
    //   60: iload 5
    //   62: ireturn
    //   63: aload 4
    //   65: invokevirtual 1338	java/lang/String:getBytes	()[B
    //   68: iconst_0
    //   69: invokestatic 1342	aqgo:encodeToString	([BI)Ljava/lang/String;
    //   72: astore_1
    //   73: goto -29 -> 44
    //   76: aload_3
    //   77: ifnull -24 -> 53
    //   80: aload_0
    //   81: invokespecial 1405	com/tencent/mobileqq/app/BaseActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   84: aload_3
    //   85: invokevirtual 1411	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   88: astore_1
    //   89: aload_0
    //   90: aload_1
    //   91: invokespecial 1413	com/tencent/mobileqq/activity/JumpActivity:g	(Ljava/io/InputStream;)Ljava/lang/String;
    //   94: astore_3
    //   95: aload_1
    //   96: invokevirtual 1414	java/io/InputStream:close	()V
    //   99: aload_3
    //   100: invokestatic 356	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifeq +80 -> 183
    //   106: iload 6
    //   108: istore 5
    //   110: invokestatic 308	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   113: ifeq -53 -> 60
    //   116: ldc_w 1346
    //   119: iconst_2
    //   120: ldc_w 1416
    //   123: invokestatic 323	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: iconst_1
    //   127: ireturn
    //   128: astore_1
    //   129: aload 7
    //   131: astore_2
    //   132: ldc_w 1346
    //   135: iconst_1
    //   136: new 185	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 1418
    //   146: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_1
    //   150: invokevirtual 1419	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   153: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 323	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: iload 6
    //   164: istore 5
    //   166: aload_2
    //   167: ifnull -107 -> 60
    //   170: aload_2
    //   171: invokevirtual 1414	java/io/InputStream:close	()V
    //   174: iconst_1
    //   175: ireturn
    //   176: astore_1
    //   177: aload_1
    //   178: invokevirtual 1420	java/io/IOException:printStackTrace	()V
    //   181: iconst_1
    //   182: ireturn
    //   183: aload_2
    //   184: ldc_w 980
    //   187: ldc_w 1399
    //   190: invokevirtual 1338	java/lang/String:getBytes	()[B
    //   193: iconst_0
    //   194: invokestatic 1342	aqgo:encodeToString	([BI)Ljava/lang/String;
    //   197: invokevirtual 433	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   200: pop
    //   201: aload_3
    //   202: invokestatic 356	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   205: ifeq +18 -> 223
    //   208: ldc 151
    //   210: astore_1
    //   211: aload_2
    //   212: ldc_w 1401
    //   215: aload_1
    //   216: invokevirtual 433	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   219: pop
    //   220: goto -167 -> 53
    //   223: aload_3
    //   224: invokevirtual 1338	java/lang/String:getBytes	()[B
    //   227: iconst_0
    //   228: invokestatic 1342	aqgo:encodeToString	([BI)Ljava/lang/String;
    //   231: astore_1
    //   232: goto -21 -> 211
    //   235: astore_3
    //   236: aload_1
    //   237: astore_2
    //   238: aload_3
    //   239: astore_1
    //   240: goto -108 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	JumpActivity
    //   0	243	1	paramBundle	Bundle
    //   0	243	2	paramHashMap	HashMap<String, String>
    //   0	243	3	paramUri	Uri
    //   0	243	4	paramString	String
    //   58	107	5	i	int
    //   4	159	6	j	int
    //   1	129	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   80	89	128	java/lang/Exception
    //   99	106	128	java/lang/Exception
    //   110	126	128	java/lang/Exception
    //   183	208	128	java/lang/Exception
    //   211	220	128	java/lang/Exception
    //   223	232	128	java/lang/Exception
    //   170	174	176	java/io/IOException
    //   89	99	235	java/lang/Exception
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      this.uiHandler.sendEmptyMessage(1);
      if ((paramBoolean) && (paramInt1 == 0) && (paramInt2 == 1))
      {
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString2 = new Intent(this, QQBrowserActivity.class);
          paramString2.putExtra("url", paramString1);
          paramString2.putExtra("hide_more_button", true);
          startActivity(paramString2);
        }
        finish();
        return;
      }
      if (("android.intent.action.SEND".equals(paramString2)) || ("android.intent.action.SEND_MULTIPLE".equals(paramString2)))
      {
        bs(getIntent().getExtras());
        return;
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("JumpAction", 1, paramString1, new Object[0]);
      return;
    }
    if ("android.intent.action.VIEW".equals(paramString2))
    {
      Intent localIntent = getIntent();
      paramString2 = localIntent.getExtras();
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = new Bundle();
      }
      b(localIntent, paramString1);
    }
  }
  
  public int b(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null)
    {
      QLog.e("qqfav|QfavJumpActivity", 1, "qqFavDoAction error: params are null");
      return 1;
    }
    StringBuilder localStringBuilder = new StringBuilder("mqqapi://share/to_qqfav?");
    Set localSet = paramHashMap.keySet();
    Iterator localIterator = localSet.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(str);
      localStringBuilder.append("=");
      localStringBuilder.append((String)paramHashMap.get(str));
      if (i != localSet.size() - 1) {
        localStringBuilder.append("&");
      }
      i += 1;
    }
    paramHashMap = aqik.c(this.app, this, localStringBuilder.toString());
    if (paramHashMap == null)
    {
      QLog.d("qqfav|QfavJumpActivity", 1, "startSystemShareToQQFav|jump parse fail");
      return 1;
    }
    paramHashMap.ace();
    QLog.d("qqfav|QfavJumpActivity", 1, "startSystemShareToQQFav|end");
    return 0;
  }
  
  public void bPU()
  {
    if (this.aC == null)
    {
      this.aC = new veh(this);
      IntentFilter localIntentFilter = new IntentFilter("BroadcastReceiverFinishActivity");
      registerReceiver(this.aC, localIntentFilter);
    }
  }
  
  public void bPY()
  {
    if (this.aXE) {
      vN("HexUtil.bytes2HexStr(fileKey)");
    }
    finish();
  }
  
  public void bPZ()
  {
    xw(false);
  }
  
  public void bQa()
  {
    xv(false);
  }
  
  public void bQb()
  {
    j(false, null, true);
  }
  
  public void bQc()
  {
    j(true, null, false);
  }
  
  public void bQd()
  {
    i(false, null, true);
  }
  
  public void bQe()
  {
    i(true, null, false);
  }
  
  public void bQf()
  {
    xu(false);
  }
  
  public void bQg()
  {
    finish();
  }
  
  public void bQh()
  {
    if (this.F != null) {
      bS(this.F);
    }
    finish();
  }
  
  public void bQi()
  {
    if (this.G != null) {
      bU(this.G);
    }
    finish();
  }
  
  public void bQj()
  {
    new MqqHandler(Looper.getMainLooper()).postDelayed(new JumpActivity.8(this), 10L);
  }
  
  public void c(DevlockInfo paramDevlockInfo)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    afrz localafrz = afrz.a();
    if ((localafrz != null) && (localafrz.Dx() == afrz.cTE))
    {
      localIntent = new Intent();
      localIntent.setAction("mqq.intent.action.DEVLOCK_ROAM");
      if (paramDevlockInfo != null) {
        if (paramDevlockInfo.DevSetup == 1)
        {
          localIntent.putExtra("auth_dev_open", bool1);
          localIntent.putExtra("guardphone_state", localafrz.Dx());
          if (paramDevlockInfo == null) {
            break label122;
          }
        }
      }
      label122:
      for (paramDevlockInfo = paramDevlockInfo.Mobile;; paramDevlockInfo = "")
      {
        localIntent.putExtra("guardphone_mask", paramDevlockInfo);
        sendBroadcast(localIntent, "com.tencent.tim.msg.permission.pushnotify");
        finish();
        return;
        bool1 = false;
        break;
        bool1 = false;
        break;
      }
    }
    Intent localIntent = new Intent(getIntent());
    localIntent.putExtra("devlock_need_broadcast", true);
    if ((localIntent.getBooleanExtra("enable_open_allowset_dev", false)) && (paramDevlockInfo != null) && (paramDevlockInfo.DevSetup == 0) && (paramDevlockInfo.AllowSet == 1))
    {
      localIntent.setClass(this, AuthDevActivity.class);
      localIntent.putExtra("phone_num", paramDevlockInfo.Mobile);
      localIntent.putExtra("country_code", paramDevlockInfo.CountryCode);
      localIntent.putExtra("auth_dev_open", false);
      localIntent.putExtra("allow_set", true);
    }
    for (;;)
    {
      startActivity(localIntent);
      if (!localIntent.getBooleanExtra("open_devlock_from_roam", false)) {
        break;
      }
      overridePendingTransition(2130771991, 2130771989);
      break;
      if ((paramDevlockInfo != null) && (paramDevlockInfo.DevSetup == 1))
      {
        localIntent.setClass(this, AuthDevActivity.class);
        localIntent.putExtra("phone_num", paramDevlockInfo.Mobile);
        localIntent.putExtra("country_code", paramDevlockInfo.CountryCode);
        if (paramDevlockInfo.DevSetup == 1)
        {
          bool1 = true;
          label327:
          localIntent.putExtra("auth_dev_open", bool1);
          if (paramDevlockInfo.AllowSet != 1) {
            break label365;
          }
        }
        label365:
        for (bool1 = bool2;; bool1 = false)
        {
          localIntent.putExtra("allow_set", bool1);
          break;
          bool1 = false;
          break label327;
        }
      }
      localIntent.setClass(this, AuthDevOpenUgActivity.class);
      localIntent.putExtra("DevlockInfo", paramDevlockInfo);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("JumpActivity onActivityResult,requestCode=").append(paramInt1).append(",resultCode=").append(paramInt2).append(",data=");
    Object localObject;
    if (paramIntent != null)
    {
      localObject = paramIntent.toString();
      QLog.d("JumpAction", 1, (String)localObject);
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      if (paramInt2 != -1) {
        break label146;
      }
    }
    label146:
    do
    {
      try
      {
        localObject = acgq.a().a(paramInt1, this);
        if (localObject == null)
        {
          QLog.e("JumpAction", 1, "doOnActivityResult: result plugin not exist");
          return;
          localObject = "null";
          break;
        }
        ((a)localObject).q(paramInt1, paramInt2, paramIntent);
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.e("JumpAction", 1, "doOnActivityResult error: " + paramIntent.getMessage());
        return;
      }
      if (paramInt1 == 25)
      {
        a(false, paramIntent);
        return;
      }
    } while (paramInt1 == 23);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = false;
    getWindow().addFlags(67108864);
    Intent localIntent;
    try
    {
      super.doOnCreate(paramBundle);
      QLog.d("JumpAction", 1, "JumpActivity doOnCreate()");
      localIntent = getIntent();
      bZ(localIntent);
      this.jdField_a_of_type_Aqim = new aqim();
      this.jdField_a_of_type_Aqim.a(this.app, this, localIntent);
      if ((localIntent != null) && (("com.tencent.apollo.SHORT_CUT".equals(localIntent.getAction())) || (localIntent.getBooleanExtra("jump_cm_game", false))))
      {
        if (!this.app.isLogin())
        {
          paramBundle = new Intent();
          paramBundle.setClass(this, LoginActivity.class);
          paramBundle.addFlags(67371008);
          startActivity(paramBundle);
          finish();
          return false;
        }
        if (localIntent.getBooleanExtra("jump_game_city", false))
        {
          ApolloGameUtil.a(this.app, new b(this, 0, null));
          return false;
        }
        if (localIntent.getBooleanExtra("jump_cm_game", false))
        {
          i = localIntent.getIntExtra("jump_cm_game_id", -1);
          paramBundle = localIntent.getStringExtra("jump_cm_extendinfo");
          ApolloGameUtil.a(this.app, new b(this, i, paramBundle));
          return false;
        }
      }
      if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("android.intent.action.VIEW")) && (localIntent.getIntExtra("MINI_CONFIG_SCENE", -1) > 0) && (!TextUtils.isEmpty(localIntent.getStringExtra("CONFIG_APPID"))))
      {
        xu(true);
        return false;
      }
      if (localIntent != null)
      {
        bool = "from_nearby_pb".equals(localIntent.getStringExtra("from"));
        if (bool)
        {
          try
          {
            paramBundle = localIntent.getDataString();
            if (!TextUtils.isEmpty(paramBundle))
            {
              paramBundle = aqik.c(this.app, this, paramBundle);
              if (paramBundle != null) {
                paramBundle.aCP();
              }
            }
          }
          catch (Exception paramBundle)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.nearby", 2, "nearby_pb|exception:" + paramBundle.toString());
              }
            }
          }
          finish();
          return false;
        }
      }
    }
    catch (Exception paramBundle)
    {
      QLog.e("JumpAction", 1, "doOnCreate|exp:" + paramBundle.getMessage());
      finish();
      return false;
    }
    if ((localIntent != null) && ("from_gesturemgr_download".equals(localIntent.getAction())))
    {
      finish();
      return false;
    }
    if ((localIntent != null) && ("from_qavgpsomgr_download".equals(localIntent.getAction())))
    {
      ina.aop();
      finish();
      return false;
    }
    if ((localIntent != null) && ("from_webtool_launchshortvideo".equals(localIntent.getAction())))
    {
      paramBundle = localIntent.getExtras();
      rnq.a().h(this, paramBundle);
      finish();
      return false;
    }
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && ((localIntent.getAction().equals("android.intent.action.SEND")) || (localIntent.getAction().equals("android.intent.action.SEND_MULTIPLE"))))
    {
      xw(true);
      return false;
    }
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("android.intent.action.VIEW")) && (!TextUtils.isEmpty(localIntent.getScheme())) && ((localIntent.getScheme().equals("file")) || (localIntent.getScheme().equals("content"))))
    {
      xv(true);
      return false;
    }
    if (PL()) {
      return false;
    }
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("android.intent.action.SENDTO")) && (!TextUtils.isEmpty(localIntent.getScheme())) && (localIntent.getScheme().equals("imto")))
    {
      bPW();
      return false;
    }
    if ((localIntent != null) && ("thridapp".equals(localIntent.getStringExtra("share_from"))))
    {
      if (!skd.a().fX(String.valueOf(Long.valueOf(localIntent.getLongExtra("req_share_id", 0L)))))
      {
        super.finish();
        return false;
      }
      paramBundle = new Intent(this, SplashActivity.class);
      paramBundle.putExtras(localIntent.getExtras());
      startActivity(wja.a(paramBundle, null));
      return false;
    }
    if ((localIntent != null) && (((!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("android.intent.action.MAIN")) && (localIntent.getBooleanExtra("_is_from_qlink_shortcut", false))) || (localIntent.getBooleanExtra("_goto_qlink_when_login_suc_", false))))
    {
      bY(localIntent);
      return false;
    }
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("com.tencent.qreader.SHORT_CUT")) && (localIntent.getBooleanExtra("is_from_qreader_shortcut", false)))
    {
      bR(localIntent);
      return false;
    }
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("com.tencent.qqcomic.SHORT_CUT")))
    {
      bT(localIntent);
      return false;
    }
    if ((localIntent != null) && (((!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("android.intent.action.MAIN")) && (localIntent.getBooleanExtra("_is_from_qfile_shortcut", false))) || (localIntent.getBooleanExtra("_goto_qfile_when_login_suc_", false))))
    {
      bV(localIntent);
      return false;
    }
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("com.tencent.smartdevice.SHORT_CUT")))
    {
      bW(localIntent);
      return false;
    }
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getScheme())) && (localIntent.getScheme().equals("kandianugc")))
    {
      ca(localIntent);
      finish();
      return false;
    }
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("android.intent.action.MAIN")) && (localIntent.getBooleanExtra("_is_from_kandian_shortcut", false)))
    {
      localIntent.addFlags(524288);
      localIntent.addFlags(134217728);
      localIntent.putExtra("url", "https://sqimg.qq.com/qq_product_operations/kan/violaLibs/bundle_feeds.js");
      localIntent.putExtra(nuk.anO, "QQ看点");
      PublicFragmentActivity.start(getActivity(), localIntent, ViolaFragment.class);
      getActivity().overridePendingTransition(2130772009, 0);
      finish();
      return false;
    }
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getScheme())) && (localIntent.getScheme().equals("mqqdatamigration")))
    {
      paramBundle = new Intent(this, DataMigrationService.class);
      paramBundle.setAction("com.tencent.mobileqq.action.MIGRATION_DATA");
      paramBundle.putExtras(localIntent);
      try
      {
        startService(paramBundle);
        finish();
        return false;
      }
      catch (Throwable paramBundle)
      {
        for (;;)
        {
          QLog.e("JumpAction", 1, "mqqdatamigration", paramBundle);
        }
      }
    }
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getScheme())) && (localIntent.getScheme().equals("mqqaudioassistant")))
    {
      QLog.d("JumpAction", 1, "get mqqaudioassistant Jump");
      paramBundle = localIntent.getData();
      if (paramBundle != null)
      {
        localObject2 = paramBundle.getQueryParameter("jumpaction");
        QLog.d("JumpAction", 1, String.format("mqqaudioassistant Jump args host = %s, \nPath = %s, \ntype = %s \nEXTRA_TEXT = %s", new Object[] { paramBundle.getHost(), paramBundle.getPath(), paramBundle.getQueryParameter("type"), localIntent.getStringExtra("android.intent.extra.TEXT") }));
        localObject1 = (aljm)this.app.getManager(352);
        paramBundle = paramBundle.getHost();
        if (((aljm)localObject1).oa(paramBundle))
        {
          localObject1 = ((aljm)localObject1).b((String)localObject2);
          if (localObject1 != null)
          {
            if (((alji)localObject1).attributes.size() > 0)
            {
              localObject2 = ((alji)localObject1).attributes.keySet().iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (String)((Iterator)localObject2).next();
                if (localIntent.hasExtra((String)localObject3))
                {
                  localObject4 = localIntent.getStringExtra((String)localObject3);
                  if (!aqmr.isEmpty((String)localObject4)) {
                    ((alji)localObject1).attributes.put(localObject3, localObject4);
                  }
                }
              }
            }
            ((alji)localObject1).host = paramBundle;
            ((alji)localObject1).d(this);
          }
        }
      }
      for (;;)
      {
        finish();
        return false;
        aljk.R(paramBundle, (String)localObject2, 2);
        QLog.d("JumpAction", 1, "mqqaudioassistant Jump item = null");
        continue;
        aljk.R(paramBundle, "", 1);
        continue;
        aljk.R("", "", 101);
      }
    }
    if ((Build.VERSION.SDK_INT >= 10) && (localIntent != null))
    {
      paramBundle = localIntent.getAction();
      if (("android.nfc.action.TECH_DISCOVERED".equals(paramBundle)) || ("com.tencent.mobileqq.action.buscard".equals(paramBundle)))
      {
        bX(localIntent);
        return false;
      }
    }
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("com.tencent.security.VERIFY_WEB")))
    {
      cb(localIntent);
      return false;
    }
    String str2 = getIntent().getDataString();
    String str3 = getIntent().getStringExtra("from");
    Object localObject5 = null;
    Object localObject6 = null;
    paramBundle = null;
    int i = 0;
    for (;;)
    {
      localObject2 = localObject6;
      localObject4 = paramBundle;
      if (i < 3) {
        localObject3 = localObject5;
      }
      for (;;)
      {
        try
        {
          localObject2 = super.getCallingPackage();
          localObject1 = localObject2;
          localObject3 = localObject5;
          paramBundle = (Bundle)localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject3 = localObject5;
            paramBundle = (Bundle)localObject2;
            QLog.i("JumpAction", 1, "-->onCreate getCallingPackage returns null!");
            localObject3 = localObject5;
            paramBundle = (Bundle)localObject2;
            localObject1 = super.getCallingActivity();
            if (localObject1 == null) {
              continue;
            }
            localObject3 = localObject5;
            paramBundle = (Bundle)localObject2;
            localObject2 = ((ComponentName)localObject1).getPackageName();
            localObject1 = localObject2;
            localObject3 = localObject5;
            paramBundle = (Bundle)localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject3 = localObject5;
              paramBundle = (Bundle)localObject2;
              QLog.i("JumpAction", 1, "-->onCreate get package from activity returns null!");
              localObject1 = localObject2;
            }
          }
          localObject3 = localObject5;
          paramBundle = (Bundle)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            continue;
          }
          localObject3 = localObject5;
          paramBundle = (Bundle)localObject1;
          Object localObject7 = getPackageManager().getPackageInfo((String)localObject1, 64);
          localObject2 = localObject6;
          localObject4 = localObject1;
          if (localObject7 != null)
          {
            localObject3 = localObject5;
            paramBundle = (Bundle)localObject1;
            localObject7 = ((PackageInfo)localObject7).signatures;
            localObject2 = localObject6;
            localObject4 = localObject1;
            if (localObject7 != null)
            {
              localObject2 = localObject6;
              localObject4 = localObject1;
              localObject3 = localObject5;
              paramBundle = (Bundle)localObject1;
              if (localObject7.length > 0)
              {
                localObject3 = localObject5;
                paramBundle = (Bundle)localObject1;
                localObject2 = MessageDigest.getInstance("MD5");
                localObject3 = localObject5;
                paramBundle = (Bundle)localObject1;
                ((MessageDigest)localObject2).update(localObject7[0].toByteArray());
                localObject3 = localObject5;
                paramBundle = (Bundle)localObject1;
                localObject2 = aqhs.bytes2HexStr(((MessageDigest)localObject2).digest());
                if (localObject2 != null) {
                  continue;
                }
                localObject2 = "";
                localObject4 = localObject1;
              }
            }
          }
          paramBundle = (Bundle)localObject4;
        }
        catch (Exception localException)
        {
          localObject2 = localObject3;
          continue;
          i = 0;
          continue;
        }
        localObject1 = paramBundle;
        if (paramBundle == null)
        {
          localObject1 = getIntent().getStringExtra("pkg_name");
          paramBundle = anpc.a(BaseApplication.getContext());
          localObject3 = new HashMap();
          ((HashMap)localObject3).put("osVersion", Build.VERSION.RELEASE);
          ((HashMap)localObject3).put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
          paramBundle.collectPerformance("", "GetCallingPackageEmpty", true, 0L, 0L, (HashMap)localObject3, "");
        }
        if (str2 == null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "jump url:" + str2);
        }
        localObject3 = aqik.c(this.app, this, str2);
        if (("webview".equals(str3)) && (localObject3 != null)) {
          ((aqhv)localObject3).setFrom(str3);
        }
        if (localObject3 == null) {
          continue;
        }
        ((aqhv)localObject3).cUa = true;
        if ((!((aqhv)localObject3).cti.equals("qqidentifier")) || (localObject1 != null)) {
          continue;
        }
        QLog.e("JumpAction", 1, "can not get caller");
        finish();
        return false;
        localObject3 = localObject5;
        paramBundle = (Bundle)localObject2;
        QLog.i("JumpAction", 1, "-->onCreate getCallingActivity returns null!");
        localObject1 = localObject2;
        continue;
        localObject3 = localObject2;
        paramBundle = (Bundle)localObject1;
        localObject2 = ((String)localObject2).toLowerCase();
        localObject4 = localObject1;
      }
      i += 1;
      paramBundle = (Bundle)localObject1;
    }
    if ((((aqhv)localObject3).cti != null) && (((aqhv)localObject3).cti.equals("puzzle_verify_code")) && (((aqhv)localObject3).ctj != null))
    {
      paramBundle = new Intent(getIntent());
      if (((aqhv)localObject3).ctj.equals("PUZZLEVERIFYCODE"))
      {
        paramBundle.setClass(this, QQBrowserActivity.class);
        super.startActivity(paramBundle);
      }
      for (;;)
      {
        super.finish();
        return false;
        if (((aqhv)localObject3).ctj.equals("VERIFYCODE"))
        {
          paramBundle.setClass(this, VerifyCodeActivity.class);
          super.startActivity(paramBundle);
        }
        else if (((aqhv)localObject3).ctj.equals("DEVLOCK_CODE"))
        {
          paramBundle.setClass(this, AuthDevUgActivity.class);
          super.startActivity(paramBundle);
        }
        else if (((aqhv)localObject3).ctj.equals("GATEVERIFY"))
        {
          PublicFragmentActivity.start(this, paramBundle, NewAuthDevUgFragment.class);
        }
      }
    }
    boolean bool = true;
    if (((((aqhv)localObject3).cti == null) || (!((aqhv)localObject3).cti.equals("ptlogin")) || (((aqhv)localObject3).ctj == null) || (!((aqhv)localObject3).ctj.equals("qlogin"))) && ((((aqhv)localObject3).cti == null) || (!((aqhv)localObject3).cti.equals("qqreg")))) {
      if ((((aqhv)localObject3).cti != null) && ("invite_register".equals(((aqhv)localObject3).ctj)))
      {
        break label3733;
        if ((str2.startsWith("mqqwpa://im")) || (str2.startsWith("mqqwpaopenid://im")))
        {
          j(true, str3, true);
          return false;
        }
        if ((str2.startsWith("mqqapi:")) && ((localObject1 == null) || ("com.tencent.mobileqq".equals(localObject1))))
        {
          paramBundle = getIntent().getStringExtra("pkg_name");
          label2599:
          if ((str2.startsWith("mqqapi://im")) || (str2.startsWith("mqqapi://connect_miniapp")))
          {
            this.mPackageName = paramBundle;
            i(true, str3, true);
            return false;
          }
          if ((!this.app.isLogin()) && (i != 0))
          {
            localObject2 = new StringBuilder().append(str2);
            if (str2.indexOf("?") <= -1) {
              break label3740;
            }
          }
        }
      }
    }
    label3733:
    label3738:
    label3740:
    String str1;
    for (Object localObject1 = "&";; str1 = "?")
    {
      localObject1 = (String)localObject1;
      localObject1 = (String)localObject1 + "jfrom=login";
      localObject2 = new Intent(this, LoginActivity.class);
      ((Intent)localObject2).putExtra("scheme_content", (String)localObject1);
      ((Intent)localObject2).putExtra("pkg_name", paramBundle);
      ((Intent)localObject2).putExtras((Intent)localObject2);
      ((Intent)localObject2).setFlags(268435456);
      if (VersionUtils.isHoneycomb()) {
        ((Intent)localObject2).addFlags(32768);
      }
      startActivity((Intent)localObject2);
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "JumpActivity is finish");
        }
        if ((((aqhv)localObject3).cti != null) && (((aqhv)localObject3).ctj != null)) {
          break;
        }
        finish();
        break label3738;
        if ((GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(this)) && (!PatternLockUtils.isOpenQWalletLockWhenJumpToQWallet(this, this.app, str2)))
        {
          QLog.d("JumpAction", 1, new Object[] { "to GesturePWDUnlockActivity pkgName=", paramBundle });
          localObject1 = new Intent(getActivity(), GesturePWDUnlockActivity.class);
          ((Intent)localObject1).putExtra("key_gesture_from_jumpactivity", true);
          ((Intent)localObject1).putExtra("scheme_content", str2);
          ((Intent)localObject1).putExtra("pkg_name", paramBundle);
          startActivity((Intent)localObject1);
        }
        else
        {
          if ((((aqhv)localObject3).cti != null) && (((aqhv)localObject3).cti.equals("devlock")) && (((aqhv)localObject3).ctj != null) && (((aqhv)localObject3).ctj.equals("open")))
          {
            if (!aqiw.isNetSupport(this))
            {
              QQToast.a(this, getString(2131693404), 0).show(getTitleBarHeight());
              break label3748;
            }
            afsf.a().a(this.app, this.app.getCurrentAccountUin(), this.b);
            break label3748;
          }
          if ((((aqhv)localObject3).cti != null) && (((aqhv)localObject3).cti.equals("gvideo")) && (((aqhv)localObject3).ctj != null) && (((aqhv)localObject3).ctj.equals("open_plugin")))
          {
            jjq.a(this.app, this, localIntent, 1);
            finish();
            return false;
          }
          if ((((aqhv)localObject3).cti != null) && (((aqhv)localObject3).cti.equals("nearby_videochat")) && (((aqhv)localObject3).ctj != null) && (((aqhv)localObject3).ctj.equals("open_plugin")))
          {
            paramBundle = (apre)this.app.getManager(224);
            NearbyVideoChatProxyActivity.a(this.app, this, localIntent, paramBundle.By(), null, 123987);
            return false;
          }
          if ((((aqhv)localObject3).cti != null) && (((aqhv)localObject3).cti.equals("qwerewolf")) && (((aqhv)localObject3).ctj != null) && (((aqhv)localObject3).ctj.equals("enterHomePage")))
          {
            ajtk.ar(this, 16);
            finish();
            return false;
          }
          if (str2.startsWith("mqqapi://tenpay/pay?"))
          {
            localObject1 = null;
            if (localIntent != null) {
              localObject1 = localIntent.getStringExtra("url_app_info");
            }
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              ((aqhv)localObject3).fj("url_app_info", (String)localObject1);
            }
          }
          ((aqhv)localObject3).setPkgName(paramBundle);
          ((aqhv)localObject3).UH((String)localObject2);
          if ((((aqhv)localObject3).cti != null) && (((aqhv)localObject3).ctj != null)) {
            ((aqhv)localObject3).cs(this);
          }
          bool = ((aqhv)localObject3).ace();
        }
      }
      if ((((aqhv)localObject3).cti.equals("gav")) && (((aqhv)localObject3).ctj.equals("request")))
      {
        if ((!"0".equals(((aqhv)localObject3).getAttribute("relation_id"))) && (bool)) {
          finish();
        }
      }
      else if ((("videochat".equals(((aqhv)localObject3).cti)) && ("request".equals(((aqhv)localObject3).ctj))) || (("randomavchat".equals(((aqhv)localObject3).cti)) && ("request".equals(((aqhv)localObject3).ctj))))
      {
        if (bool) {
          finish();
        }
      }
      else if ((((aqhv)localObject3).cti.equals("wallet")) && (((aqhv)localObject3).ctj.equals("modify_pass")))
      {
        if (bool) {
          finish();
        }
      }
      else if (((aqhv)localObject3).aDO())
      {
        if (bool) {
          finish();
        }
      }
      else if (e((aqhv)localObject3))
      {
        QLog.d("JumpAction", 1, "asynShareJumpAction wait for finishing");
      }
      else if (!f((aqhv)localObject3))
      {
        if (((aqhv)localObject3).cUe)
        {
          finish();
          overridePendingTransition(0, 0);
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("JumpAction", 2, "wait for finishing");
        }
      }
      else
      {
        ts();
        break label3738;
        paramBundle = getIntent().getStringExtra("action");
        if (paramBundle == null)
        {
          finish();
          return false;
        }
        this.aXE = getIntent().getBooleanExtra("doCallBack", false);
        this.aNM = getIntent().getStringExtra("src_type");
        this.aNN = getIntent().getStringExtra("callback_type");
        this.aNO = getIntent().getStringExtra("callback_name");
        if ("photo".equals(paramBundle)) {
          this.aXC = true;
        }
        while (this.aXC)
        {
          break label3750;
          if ("select_location".equals(paramBundle)) {
            this.aXD = true;
          }
        }
        if (!this.aXD) {
          break label3750;
        }
        bPX();
        break label3750;
        paramBundle = (Bundle)localObject1;
        break label2599;
        i = 1;
        break;
      }
      return false;
    }
    label3748:
    return false;
    label3750:
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    aXG = false;
    aXH = false;
    if (this.az != null) {
      unregisterReceiver(this.az);
    }
    if (this.aC != null) {
      unregisterReceiver(this.aC);
    }
    this.uiHandler.removeMessages(2);
    this.uiHandler.removeMessages(1);
    bF();
    if (this.r != null)
    {
      this.r.removeCallbacksAndMessages(null);
      this.s.quit();
      this.s = null;
    }
    if (this.jdField_a_of_type_Aqim != null)
    {
      this.jdField_a_of_type_Aqim.dP(null);
      this.jdField_a_of_type_Aqim = null;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.aXF) {
      finish();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      bF();
      continue;
      this.uiHandler.removeMessages(2);
      if ((paramMessage.obj instanceof Intent))
      {
        int i = paramMessage.arg1;
        Intent localIntent = (Intent)paramMessage.obj;
        bF();
        if (i == 0)
        {
          if (!PL()) {
            bs(localIntent.getExtras());
          }
        }
        else if (!PL())
        {
          Bundle localBundle = localIntent.getExtras();
          paramMessage = localBundle;
          if (localBundle == null) {
            paramMessage = new Bundle();
          }
          b(localIntent, paramMessage);
        }
      }
    }
  }
  
  public void m(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_Acjz != null) {
      this.jdField_a_of_type_Acjz = null;
    }
    if (paramIntent != null) {
      localObject = paramIntent.getExtras();
    }
    if (localObject != null)
    {
      paramIntent = ((Bundle)localObject).getString("latitude");
      localObject = ((Bundle)localObject).getString("longitude");
      if (this.aXE) {
        vN("ret=0&lon=" + (String)localObject + "&lat=" + paramIntent);
      }
      finish();
    }
  }
  
  public void n(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("roomId");
      if (paramIntent != null)
      {
        vek localvek = new vek(this);
        if (ChatActivityUtils.a(this.app, this, 3000, paramIntent, true, true, localvek, null)) {
          finish();
        }
      }
      return;
    }
    finish();
  }
  
  public void o(int paramInt1, int paramInt2, Intent paramIntent)
  {
    a(true, paramIntent);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    finish();
  }
  
  public void p(int paramInt1, int paramInt2, Intent paramIntent)
  {
    new MqqHandler(Looper.getMainLooper()).postDelayed(new JumpActivity.9(this, paramIntent), 10L);
  }
  
  protected int q(Bundle paramBundle)
  {
    try
    {
      QLog.d("qqfav|QfavJumpActivity", 1, "startSystemShareToQQFav|beg");
      Uri localUri = (Uri)paramBundle.getParcelable("android.intent.extra.STREAM");
      if ((localUri != null) && ("file".equals(localUri.getScheme())) && (localUri.getPath().startsWith("/storage"))) {
        return 4;
      }
      String str1 = paramBundle.getString("android.intent.extra.TITLE");
      String str2 = paramBundle.getString("android.intent.extra.TEXT");
      String str3 = getIntent().getType();
      if (TextUtils.isEmpty(str3))
      {
        QLog.d("qqfav|QfavJumpActivity", 1, "startSystemShareToQQFav|type null");
        return 1;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("src_type", "app");
      localHashMap.put("version", "1");
      localHashMap.put("cflag", aqgo.encodeToString("1".getBytes(), 0));
      if (TextUtils.isEmpty(str1)) {}
      for (str1 = "";; str1 = aqgo.encodeToString(str1.getBytes(), 0))
      {
        localHashMap.put("title", str1);
        if (!str3.startsWith("text")) {
          break;
        }
        return a(paramBundle, localHashMap, localUri, str2);
      }
      if (str3.startsWith("image")) {
        return a(paramBundle, localHashMap);
      }
      QLog.d("qqfav|QfavJumpActivity", 1, "startSystemShareToQQFav|unknown type. type=" + str3);
      return 1;
    }
    catch (OutOfMemoryError paramBundle)
    {
      QLog.d("qqfav|QfavJumpActivity", 1, "startSystemShareToQQFav|outofmemoryerror");
    }
    return 1;
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public boolean showPreview()
  {
    Intent localIntent = getIntent();
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getScheme())) && (localIntent.getScheme().equals("mqqdatamigration"))) {}
    for (;;)
    {
      return true;
      try
      {
        boolean bool = aqij.w(this);
        if (bool) {}
      }
      catch (Throwable localThrowable)
      {
        label43:
        break label43;
      }
    }
    return super.showPreview();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    if (this.jdField_a_of_type_Aqim != null)
    {
      this.jdField_a_of_type_Aqim.dP(paramIntent);
      this.jdField_a_of_type_Aqim = null;
    }
  }
  
  public abstract class a
  {
    public abstract void q(int paramInt1, int paramInt2, Intent paramIntent);
  }
  
  public static class b
    implements ApolloGameUtil.a, ApolloGameUtil.b
  {
    private WeakReference<JumpActivity> dK;
    private String mExtendInfo;
    private int mGameId;
    
    public b(JumpActivity paramJumpActivity, int paramInt, String paramString)
    {
      this.dK = new WeakReference(paramJumpActivity);
      this.mExtendInfo = paramString;
      this.mGameId = paramInt;
    }
    
    public void xy(boolean paramBoolean)
    {
      JumpActivity localJumpActivity = (JumpActivity)this.dK.get();
      if ((localJumpActivity == null) || (localJumpActivity.app == null)) {
        return;
      }
      if (paramBoolean)
      {
        abhh localabhh = (abhh)localJumpActivity.app.getManager(153);
        CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(this.mGameId, true, "launch", 0L, 10, 0, 0, 0, "", 222, null);
        localStartCheckParam.extendJson = this.mExtendInfo;
        localStartCheckParam.version = localabhh.db(this.mGameId);
        ApolloGameUtil.a(localJumpActivity, localStartCheckParam);
        JumpActivity.a(localJumpActivity, true);
        localJumpActivity.bPU();
        return;
      }
      QQToast.a(BaseApplicationImpl.getApplication(), acfp.m(2131707557), 0).show();
      localJumpActivity.finish();
    }
    
    public void xz(boolean paramBoolean)
    {
      JumpActivity localJumpActivity = (JumpActivity)this.dK.get();
      if ((localJumpActivity == null) || (localJumpActivity.app == null)) {}
      WebProcessManager localWebProcessManager;
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
        ApolloGameUtil.a(localJumpActivity.app, true);
        localWebProcessManager = (WebProcessManager)localJumpActivity.app.getManager(13);
      } while (localWebProcessManager == null);
      localWebProcessManager.a(100, new vel(this, localJumpActivity));
      return;
      QQToast.a(BaseApplicationImpl.getApplication(), acfp.m(2131707556), 0).show();
      ApolloGameUtil.a(localJumpActivity.app, false);
      localJumpActivity.finish();
    }
  }
  
  public class c
    extends JumpActivity.a
  {
    public void q(int paramInt1, int paramInt2, Intent paramIntent)
    {
      this.this$0.m(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public class d
    extends JumpActivity.a
  {
    public void q(int paramInt1, int paramInt2, Intent paramIntent)
    {
      this.this$0.bQf();
    }
  }
  
  public class e
    extends JumpActivity.a
  {
    public void q(int paramInt1, int paramInt2, Intent paramIntent)
    {
      this.this$0.n(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public class f
    extends JumpActivity.a
  {
    public void q(int paramInt1, int paramInt2, Intent paramIntent)
    {
      this.this$0.bPY();
    }
  }
  
  public class g
    extends JumpActivity.a
  {
    public void q(int paramInt1, int paramInt2, Intent paramIntent)
    {
      this.this$0.bPZ();
    }
  }
  
  class h
    extends AsyncTask<Object, Void, Uri>
  {
    private Intent mIntent;
    
    public h(Intent paramIntent)
    {
      this.mIntent = paramIntent;
    }
    
    /* Error */
    protected Uri a(Object... paramVarArgs)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 6
      //   3: aconst_null
      //   4: astore 11
      //   6: aconst_null
      //   7: astore 9
      //   9: aconst_null
      //   10: astore 10
      //   12: aconst_null
      //   13: astore 7
      //   15: aload_1
      //   16: iconst_0
      //   17: aaload
      //   18: checkcast 30	android/content/Context
      //   21: astore 13
      //   23: aload_1
      //   24: iconst_1
      //   25: aaload
      //   26: checkcast 32	android/net/Uri
      //   29: astore 14
      //   31: getstatic 38	acbn:bml	Ljava/lang/String;
      //   34: astore 12
      //   36: aload 13
      //   38: invokevirtual 42	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
      //   41: aload 14
      //   43: iconst_1
      //   44: anewarray 44	java/lang/String
      //   47: dup
      //   48: iconst_0
      //   49: ldc 46
      //   51: aastore
      //   52: aconst_null
      //   53: aconst_null
      //   54: aconst_null
      //   55: invokestatic 52	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   58: astore_3
      //   59: aload_3
      //   60: ifnull +606 -> 666
      //   63: aload_3
      //   64: invokeinterface 58 1 0
      //   69: ifeq +597 -> 666
      //   72: aload_3
      //   73: iconst_0
      //   74: invokeinterface 62 2 0
      //   79: astore_1
      //   80: aload_1
      //   81: astore 5
      //   83: aload_1
      //   84: astore 4
      //   86: aload_3
      //   87: invokeinterface 65 1 0
      //   92: aload_1
      //   93: astore 5
      //   95: aload_1
      //   96: astore 4
      //   98: aload 12
      //   100: invokestatic 71	aqhq:fileExists	(Ljava/lang/String;)Z
      //   103: ifne +22 -> 125
      //   106: aload_1
      //   107: astore 5
      //   109: aload_1
      //   110: astore 4
      //   112: new 73	java/io/File
      //   115: dup
      //   116: aload 12
      //   118: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
      //   121: invokevirtual 79	java/io/File:mkdirs	()Z
      //   124: pop
      //   125: aload_1
      //   126: astore 5
      //   128: aload_1
      //   129: astore 4
      //   131: new 81	java/io/FileOutputStream
      //   134: dup
      //   135: new 73	java/io/File
      //   138: dup
      //   139: new 83	java/lang/StringBuilder
      //   142: dup
      //   143: invokespecial 84	java/lang/StringBuilder:<init>	()V
      //   146: aload 12
      //   148: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   151: aload_1
      //   152: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   155: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   158: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
      //   161: invokespecial 95	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   164: astore 8
      //   166: aload 7
      //   168: astore 4
      //   170: aload 10
      //   172: astore 5
      //   174: aload 13
      //   176: invokevirtual 42	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
      //   179: aload 14
      //   181: ldc 97
      //   183: invokevirtual 103	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
      //   186: astore 9
      //   188: aload 11
      //   190: astore 6
      //   192: aload 9
      //   194: ifnull +172 -> 366
      //   197: aload 7
      //   199: astore 4
      //   201: aload 10
      //   203: astore 5
      //   205: aload 9
      //   207: invokevirtual 109	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
      //   210: astore 6
      //   212: aload 6
      //   214: astore 4
      //   216: aload 6
      //   218: astore 5
      //   220: sipush 1024
      //   223: newarray byte
      //   225: astore 7
      //   227: aload 6
      //   229: astore 4
      //   231: aload 6
      //   233: astore 5
      //   235: aload 6
      //   237: aload 7
      //   239: invokevirtual 115	java/io/InputStream:read	([B)I
      //   242: istore_2
      //   243: iload_2
      //   244: iconst_m1
      //   245: if_icmpeq +108 -> 353
      //   248: aload 6
      //   250: astore 4
      //   252: aload 6
      //   254: astore 5
      //   256: aload 8
      //   258: aload 7
      //   260: iconst_0
      //   261: iload_2
      //   262: invokevirtual 119	java/io/FileOutputStream:write	([BII)V
      //   265: goto -38 -> 227
      //   268: astore 7
      //   270: aload_3
      //   271: astore 5
      //   273: aload 4
      //   275: astore 6
      //   277: aload 8
      //   279: astore 4
      //   281: aload_1
      //   282: astore_3
      //   283: aload 5
      //   285: astore_1
      //   286: aload 7
      //   288: astore 5
      //   290: aload 5
      //   292: invokevirtual 122	java/lang/Exception:printStackTrace	()V
      //   295: aload_1
      //   296: ifnull +9 -> 305
      //   299: aload_1
      //   300: invokeinterface 65 1 0
      //   305: aload 6
      //   307: ifnull +8 -> 315
      //   310: aload 6
      //   312: invokevirtual 123	java/io/InputStream:close	()V
      //   315: aload 4
      //   317: ifnull +8 -> 325
      //   320: aload 4
      //   322: invokevirtual 124	java/io/FileOutputStream:close	()V
      //   325: new 83	java/lang/StringBuilder
      //   328: dup
      //   329: invokespecial 84	java/lang/StringBuilder:<init>	()V
      //   332: ldc 126
      //   334: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   337: aload 12
      //   339: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   342: aload_3
      //   343: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   346: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   349: invokestatic 130	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
      //   352: areturn
      //   353: aload 6
      //   355: astore 4
      //   357: aload 6
      //   359: astore 5
      //   361: aload 8
      //   363: invokevirtual 133	java/io/FileOutputStream:flush	()V
      //   366: aload_3
      //   367: ifnull +9 -> 376
      //   370: aload_3
      //   371: invokeinterface 65 1 0
      //   376: aload 6
      //   378: ifnull +8 -> 386
      //   381: aload 6
      //   383: invokevirtual 123	java/io/InputStream:close	()V
      //   386: aload 8
      //   388: ifnull +8 -> 396
      //   391: aload 8
      //   393: invokevirtual 124	java/io/FileOutputStream:close	()V
      //   396: new 83	java/lang/StringBuilder
      //   399: dup
      //   400: invokespecial 84	java/lang/StringBuilder:<init>	()V
      //   403: ldc 126
      //   405: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   408: aload 12
      //   410: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   413: aload_1
      //   414: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   417: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   420: invokestatic 130	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
      //   423: areturn
      //   424: astore_3
      //   425: aload_3
      //   426: invokevirtual 134	java/io/IOException:printStackTrace	()V
      //   429: goto -43 -> 386
      //   432: astore_3
      //   433: aload_3
      //   434: invokevirtual 134	java/io/IOException:printStackTrace	()V
      //   437: goto -41 -> 396
      //   440: astore_1
      //   441: aload_1
      //   442: invokevirtual 134	java/io/IOException:printStackTrace	()V
      //   445: goto -130 -> 315
      //   448: astore_1
      //   449: aload_1
      //   450: invokevirtual 134	java/io/IOException:printStackTrace	()V
      //   453: goto -128 -> 325
      //   456: astore 4
      //   458: aconst_null
      //   459: astore 7
      //   461: ldc 136
      //   463: astore_1
      //   464: aconst_null
      //   465: astore_3
      //   466: aload 9
      //   468: astore 5
      //   470: aload 7
      //   472: ifnull +10 -> 482
      //   475: aload 7
      //   477: invokeinterface 65 1 0
      //   482: aload 5
      //   484: ifnull +8 -> 492
      //   487: aload 5
      //   489: invokevirtual 123	java/io/InputStream:close	()V
      //   492: aload_3
      //   493: ifnull +7 -> 500
      //   496: aload_3
      //   497: invokevirtual 124	java/io/FileOutputStream:close	()V
      //   500: new 83	java/lang/StringBuilder
      //   503: dup
      //   504: invokespecial 84	java/lang/StringBuilder:<init>	()V
      //   507: ldc 126
      //   509: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   512: aload 12
      //   514: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   517: aload_1
      //   518: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   521: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   524: invokestatic 130	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
      //   527: pop
      //   528: aload 4
      //   530: athrow
      //   531: astore 5
      //   533: aload 5
      //   535: invokevirtual 134	java/io/IOException:printStackTrace	()V
      //   538: goto -46 -> 492
      //   541: astore_3
      //   542: aload_3
      //   543: invokevirtual 134	java/io/IOException:printStackTrace	()V
      //   546: goto -46 -> 500
      //   549: astore 4
      //   551: ldc 136
      //   553: astore_1
      //   554: aconst_null
      //   555: astore 5
      //   557: aload_3
      //   558: astore 7
      //   560: aload 5
      //   562: astore_3
      //   563: aload 9
      //   565: astore 5
      //   567: goto -97 -> 470
      //   570: astore 4
      //   572: aconst_null
      //   573: astore 6
      //   575: aload_3
      //   576: astore 7
      //   578: aload 5
      //   580: astore_1
      //   581: aload 6
      //   583: astore_3
      //   584: aload 9
      //   586: astore 5
      //   588: goto -118 -> 470
      //   591: astore 4
      //   593: aload_3
      //   594: astore 7
      //   596: aload 8
      //   598: astore_3
      //   599: goto -129 -> 470
      //   602: astore 7
      //   604: aload 4
      //   606: astore 5
      //   608: aload 7
      //   610: astore 4
      //   612: aload_1
      //   613: astore 7
      //   615: aload_3
      //   616: astore_1
      //   617: aload 5
      //   619: astore_3
      //   620: aload 6
      //   622: astore 5
      //   624: goto -154 -> 470
      //   627: astore 5
      //   629: aconst_null
      //   630: astore_1
      //   631: ldc 136
      //   633: astore_3
      //   634: aconst_null
      //   635: astore 4
      //   637: goto -347 -> 290
      //   640: astore 5
      //   642: aload_3
      //   643: astore_1
      //   644: aconst_null
      //   645: astore 4
      //   647: ldc 136
      //   649: astore_3
      //   650: goto -360 -> 290
      //   653: astore 5
      //   655: aload_3
      //   656: astore_1
      //   657: aload 4
      //   659: astore_3
      //   660: aconst_null
      //   661: astore 4
      //   663: goto -373 -> 290
      //   666: ldc 136
      //   668: astore_1
      //   669: goto -577 -> 92
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	672	0	this	h
      //   0	672	1	paramVarArgs	Object[]
      //   242	20	2	i	int
      //   58	313	3	localObject1	Object
      //   424	2	3	localIOException1	IOException
      //   432	2	3	localIOException2	IOException
      //   465	32	3	localObject2	Object
      //   541	17	3	localIOException3	IOException
      //   562	98	3	localObject3	Object
      //   84	272	4	localObject4	Object
      //   456	73	4	localObject5	Object
      //   549	1	4	localObject6	Object
      //   570	1	4	localObject7	Object
      //   591	14	4	localObject8	Object
      //   610	52	4	localObject9	Object
      //   81	407	5	localObject10	Object
      //   531	3	5	localIOException4	IOException
      //   555	68	5	localObject11	Object
      //   627	1	5	localException1	Exception
      //   640	1	5	localException2	Exception
      //   653	1	5	localException3	Exception
      //   1	620	6	localObject12	Object
      //   13	246	7	arrayOfByte	byte[]
      //   268	19	7	localException4	Exception
      //   459	136	7	localObject13	Object
      //   602	7	7	localObject14	Object
      //   613	1	7	arrayOfObject	Object[]
      //   164	433	8	localFileOutputStream	java.io.FileOutputStream
      //   7	578	9	localAssetFileDescriptor	android.content.res.AssetFileDescriptor
      //   10	192	10	localObject15	Object
      //   4	185	11	localObject16	Object
      //   34	479	12	str	String
      //   21	154	13	localContext	Context
      //   29	151	14	localUri	Uri
      // Exception table:
      //   from	to	target	type
      //   174	188	268	java/lang/Exception
      //   205	212	268	java/lang/Exception
      //   220	227	268	java/lang/Exception
      //   235	243	268	java/lang/Exception
      //   256	265	268	java/lang/Exception
      //   361	366	268	java/lang/Exception
      //   381	386	424	java/io/IOException
      //   391	396	432	java/io/IOException
      //   310	315	440	java/io/IOException
      //   320	325	448	java/io/IOException
      //   36	59	456	finally
      //   487	492	531	java/io/IOException
      //   496	500	541	java/io/IOException
      //   63	80	549	finally
      //   86	92	570	finally
      //   98	106	570	finally
      //   112	125	570	finally
      //   131	166	570	finally
      //   174	188	591	finally
      //   205	212	591	finally
      //   220	227	591	finally
      //   235	243	591	finally
      //   256	265	591	finally
      //   361	366	591	finally
      //   290	295	602	finally
      //   36	59	627	java/lang/Exception
      //   63	80	640	java/lang/Exception
      //   86	92	653	java/lang/Exception
      //   98	106	653	java/lang/Exception
      //   112	125	653	java/lang/Exception
      //   131	166	653	java/lang/Exception
    }
    
    protected void b(Uri paramUri)
    {
      this.mIntent.setData(paramUri);
      ahgq.P(JumpActivity.this, this.mIntent);
      JumpActivity.this.finish();
    }
  }
  
  public class i
    extends JumpActivity.a
  {
    public void q(int paramInt1, int paramInt2, Intent paramIntent)
    {
      this.this$0.bQg();
    }
  }
  
  public class j
    extends JumpActivity.a
  {
    public void q(int paramInt1, int paramInt2, Intent paramIntent)
    {
      this.this$0.bQe();
    }
  }
  
  public class k
    extends JumpActivity.a
  {
    public void q(int paramInt1, int paramInt2, Intent paramIntent)
    {
      this.this$0.bQd();
    }
  }
  
  public class l
    extends JumpActivity.a
  {
    public void q(int paramInt1, int paramInt2, Intent paramIntent)
    {
      this.this$0.bQa();
    }
  }
  
  public class m
    extends JumpActivity.a
  {
    public void q(int paramInt1, int paramInt2, Intent paramIntent)
    {
      this.this$0.bQc();
    }
  }
  
  public class n
    extends JumpActivity.a
  {
    public void q(int paramInt1, int paramInt2, Intent paramIntent)
    {
      this.this$0.bQb();
    }
  }
  
  public class o
    extends JumpActivity.a
  {
    public void q(int paramInt1, int paramInt2, Intent paramIntent)
    {
      this.this$0.bQj();
    }
  }
  
  public class p
    extends JumpActivity.a
  {
    public void q(int paramInt1, int paramInt2, Intent paramIntent)
    {
      this.this$0.bQi();
    }
  }
  
  public class q
    extends JumpActivity.a
  {
    public void q(int paramInt1, int paramInt2, Intent paramIntent)
    {
      this.this$0.bQh();
    }
  }
  
  public class r
    extends JumpActivity.a
  {
    public void q(int paramInt1, int paramInt2, Intent paramIntent)
    {
      this.this$0.p(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public class s
    extends JumpActivity.a
  {
    public void q(int paramInt1, int paramInt2, Intent paramIntent)
    {
      this.this$0.o(paramInt1, paramInt2, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JumpActivity
 * JD-Core Version:    0.7.0.1
 */