import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.gamecenter.activities.SingleTaskQQBrowser;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.ai.ApolloAIActivity;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine.a;
import com.tencent.mobileqq.apollo.lightGame.CmGameFragment;
import com.tencent.mobileqq.apollo.lightGame.CmGameLoadingFragment;
import com.tencent.mobileqq.apollo.process.CmGameUtil.2;
import com.tencent.mobileqq.apollo.process.data.CmGameAppInterface;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel.b;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import cooperation.qzone.util.NetworkState;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class abmt
{
  private static long NY;
  public static long NZ;
  public static long Oa;
  private static volatile long Ob;
  public static long Oc;
  public static boolean bEa = true;
  static int cqb = -1;
  private static LRULinkedHashMap<String, String> m = new LRULinkedHashMap(3);
  static float sz = -1.0F;
  static long totalMemory = -1L;
  public static long yQ;
  
  public static boolean B(Object paramObject)
  {
    return false;
  }
  
  public static void Cj(String paramString)
  {
    QLog.d("cmgame_process.CmGameUtil", 1, new Object[] { "[clearMainJsCache] mainJsPath=", paramString });
    if (!TextUtils.isEmpty(paramString)) {
      m.remove(paramString);
    }
  }
  
  public static void Hw(int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject == null) {
      QLog.w("cmgame_process.CmGameUtil", 1, "fail to close game, gameId:" + paramInt);
    }
    do
    {
      return;
      localObject = ((abos)localObject).q();
    } while (localObject == null);
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameUtil", 2, "success to close game, gameId:" + paramInt);
    }
    ((Activity)localObject).finish();
  }
  
  public static void Hx(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", paramInt);
      ((aqrb)getAppInterface().getBusinessHandler(71)).l("apollo_router_game.game_extend_linkcmd_set_plus_flag", localJSONObject.toString(), -1L, 0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void Hy(int paramInt)
  {
    QLog.d("cmgame_process.CmGameUtil", 1, new Object[] { "[clearMainJsCache] gameId=", Integer.valueOf(paramInt) });
    Cj(ApolloUtil.dp(paramInt));
  }
  
  public static int O(long paramLong)
  {
    abos localabos = b(paramLong);
    if (localabos == null) {
      return -1;
    }
    return localabos.getGameId();
  }
  
  public static boolean YH()
  {
    AppInterface localAppInterface = getAppInterface();
    return (localAppInterface != null) && ((localAppInterface instanceof CmGameAppInterface));
  }
  
  public static boolean YI()
  {
    try
    {
      AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
      if (localAudioManager != null)
      {
        int i = localAudioManager.getRingerMode();
        if (i == 1) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("cmgame_process.CmGameUtil", 1, "isRingerVibrate error: " + localThrowable.getMessage());
    }
    return false;
  }
  
  public static boolean YJ()
  {
    try
    {
      AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
      if (localAudioManager != null)
      {
        int i = localAudioManager.getStreamVolume(2);
        if (i == 0) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("cmgame_process.CmGameUtil", 1, "isRingEqualsZero error: " + localThrowable.getMessage());
    }
    return false;
  }
  
  public static boolean YK()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)BaseApplicationImpl.getApplication().getSystemService("phone");
    return (localTelephonyManager != null) && (localTelephonyManager.getCallState() == 0);
  }
  
  public static abkj a()
  {
    aboz localaboz = a();
    if (localaboz != null) {
      return localaboz.a();
    }
    return null;
  }
  
  public static abos a(int paramInt)
  {
    aboz localaboz = a();
    if (localaboz == null) {
      return null;
    }
    return localaboz.b(paramInt);
  }
  
  public static abos a(int paramInt1, int paramInt2)
  {
    aboz localaboz = a();
    if (localaboz == null) {
      return null;
    }
    return localaboz.a(paramInt1, paramInt2);
  }
  
  public static abos a(long paramLong)
  {
    ApolloRender localApolloRender = ApolloRender.getRenderByThreadId();
    if ((localApolloRender == null) || (localApolloRender.getSavaWrapper() == null))
    {
      QLog.w("cmgame_process.CmGameUtil", 1, "render is null.");
      return null;
    }
    return b(localApolloRender.getSavaWrapper().getLuaState());
  }
  
  public static aboy a()
  {
    int i = zE();
    if (-1 == i) {}
    abow localabow;
    do
    {
      return null;
      localabow = abmm.a().a(i);
    } while (localabow == null);
    return localabow.b();
  }
  
  public static aboz a()
  {
    AppInterface localAppInterface = getAppInterface();
    if ((localAppInterface instanceof CmGameAppInterface)) {
      return (aboz)((CmGameAppInterface)localAppInterface).getManager(255);
    }
    return null;
  }
  
  public static abpc a(int paramInt)
  {
    abos localabos = a(paramInt);
    if (localabos != null) {
      return localabos.a();
    }
    QLog.w("cmgame_process.CmGameUtil", 1, "CmGameOpenIdFinder is nulllll.");
    return null;
  }
  
  public static abpc a(long paramLong)
  {
    abos localabos = b(paramLong);
    if (localabos != null) {
      return localabos.a();
    }
    QLog.w("cmgame_process.CmGameUtil", 1, "CmGameOpenIdFinder is nulllll.");
    return null;
  }
  
  public static abpu a()
  {
    try
    {
      Object localObject = getAppInterface();
      if ((localObject != null) && ((localObject instanceof CmGameAppInterface)))
      {
        localObject = (abpu)((AppInterface)localObject).getBusinessHandler(0);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, localThrowable, new Object[0]);
      return null;
    }
    return null;
  }
  
  public static ApolloSurfaceView a()
  {
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      return null;
      localObject = ((aboz)localObject).c();
    } while (localObject == null);
    return ((abos)localObject).b();
  }
  
  public static ApolloCmdChannel a()
  {
    aboz localaboz = a();
    if (localaboz != null) {
      return localaboz.a();
    }
    return null;
  }
  
  public static String a(CmGameInitParams paramCmGameInitParams)
  {
    return b(paramCmGameInitParams);
  }
  
  public static void a(int paramInt1, int paramInt2, CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt3)
  {
    QLog.i("cmgame_process.CmGameUtil", 1, "[sendActLifeCycleIpc], gameId:" + paramInt2 + ",status:" + paramInt1);
    Bundle localBundle = new Bundle();
    localBundle.putInt("status", paramInt1);
    localBundle.putInt("gameId", paramInt2);
    localBundle.putInt("activityId", paramInt3);
    localBundle.putSerializable("para", paramStartCheckParam);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "game_activity_lifecycle", localBundle, null);
  }
  
  public static void a(int paramInt, Context paramContext)
  {
    try
    {
      localObject = a(paramInt);
      if (localObject == null) {
        return;
      }
      localObject = ((abos)localObject).a();
      if (localObject == null)
      {
        QLog.w("cmgame_process.CmGameUtil", 1, "CmGameInitParams is null.");
        return;
      }
    }
    catch (Throwable paramContext)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, paramContext, new Object[0]);
      return;
    }
    if ((paramContext instanceof ApolloGameActivity))
    {
      ((ApolloGameActivity)paramContext).moveTaskToBack(true);
      return;
    }
    paramInt = ((CmGameStartChecker.StartCheckParam)localObject).enter;
    Object localObject = new Intent(paramContext, SplashActivity.class);
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 7))
    {
      ((Intent)localObject).putExtra("fragment_id", 2);
      for (;;)
      {
        ((Intent)localObject).putExtra("fromApollo", 1);
        ((Intent)localObject).setFlags(67174400);
        paramContext.startActivity((Intent)localObject);
        return;
        label123:
        ((Intent)localObject).putExtra("fragment_id", 1);
        ((Intent)localObject).putExtra("tab_index", MainFragment.bIk);
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("fragment_id", 1);
      ((Intent)localObject).putExtra("tab_index", MainFragment.bIk);
      break;
      if ((paramInt == 2) || (paramInt == 8)) {
        break label123;
      }
      if (paramInt != 5) {
        if (paramInt != 4) {
          break;
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, Conversation paramConversation)
  {
    if (getAppInterface() == null) {}
    abhh localabhh;
    do
    {
      return;
      localabhh = (abhh)getAppInterface().getManager(153);
      if (B(null)) {
        localabhh.bCK = true;
      }
    } while ((localabhh == null) || (!localabhh.bCJ) || (paramActivity == null) || (!(paramActivity instanceof SplashActivity)) || (paramActivity.isFinishing()) || (!((SplashActivity)paramActivity).isResume()) || (paramConversation == null));
    if (FrameHelperActivity.ZW())
    {
      FrameHelperActivity.EO(true);
      FrameHelperActivity.cuA();
    }
    o(paramConversation.gw, localabhh.qS());
    localabhh.bCJ = false;
    paramConversation.aUP = true;
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, int paramInt3, long paramLong, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameUtil", 2, new Object[] { "[reportGameEvent] gameId=", Integer.valueOf(paramInt3), ", eventId=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", failCode=", Long.valueOf(paramLong), ", extInfo=", paramJSONObject });
    }
    if (paramAppInterface == null)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, "[reportGameEvent] app null");
      return;
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("platform", 109);
      ((JSONObject)localObject).put("osVersion", Build.VERSION.RELEASE);
      ((JSONObject)localObject).put("brand", Build.BRAND);
      ((JSONObject)localObject).put("model", Build.MODEL);
      ((JSONObject)localObject).put("sqVersion", "3.4.4.3058");
      ((JSONObject)localObject).put("ts", NetConnInfoCenter.getServerTime());
      ((JSONObject)localObject).put("mid", paramInt1);
      ((JSONObject)localObject).put("value", paramInt2);
      ((JSONObject)localObject).put("gameId", paramInt3);
      ((JSONObject)localObject).put("failCode", paramLong);
      if (paramJSONObject != null) {
        ((JSONObject)localObject).put("extInfo", paramJSONObject);
      }
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramJSONObject = new NewIntent(paramAppInterface.getApp(), abka.class);
      paramJSONObject.putExtra("cmd", "apollo_monit_report.game_report_single");
      paramJSONObject.putExtra("data", localUniSsoServerReq.toByteArray());
      paramJSONObject.setObserver(new abmu());
      paramAppInterface.startServlet(paramJSONObject);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, "[reportGameEvent] failed, exception=", paramAppInterface);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam == null) || (paramQQAppInterface == null)) {
      return false;
    }
    Object localObject = (abxk)paramQQAppInterface.getManager(155);
    ApolloGameData localApolloGameData = ((abxk)localObject).a(paramStartCheckParam.gameId);
    abhh localabhh = (abhh)paramQQAppInterface.getManager(153);
    if (localabhh != null)
    {
      paramStartCheckParam.game = localApolloGameData;
      if ((localApolloGameData != null) && ((((abxk)localObject).hX(paramStartCheckParam.gameId)) || (paramStartCheckParam.isRequestConf))) {
        break label244;
      }
    }
    label244:
    for (boolean bool = true;; bool = false)
    {
      paramStartCheckParam.isNeedConfInfo = bool;
      paramStartCheckParam.version = localabhh.db(paramStartCheckParam.gameId);
      localObject = paramQQAppInterface.getCurrentAccountUin();
      paramStartCheckParam.isWhiteUsr = localabhh.jn((String)localObject);
      paramStartCheckParam.apolloStatus = localabhh.cd((String)localObject);
      paramStartCheckParam.pushItem = localabhh.a().a();
      paramStartCheckParam.mGameType = ApolloGameUtil.gg(paramStartCheckParam.gameId);
      paramStartCheckParam.isGameRscExist = ApolloUtil.ie(paramStartCheckParam.gameId);
      if (localApolloGameData != null) {
        paramStartCheckParam.viewMode = localApolloGameData.viewMode;
      }
      int i = ApolloGameUtil.as(paramStartCheckParam.gameId, paramStartCheckParam.mGameType);
      if (i != -1) {
        paramStartCheckParam.viewMode = i;
      }
      paramStartCheckParam.gender = ((ajpj)paramQQAppInterface.getManager(106)).GA();
      paramStartCheckParam.isEnableMSAA = hR(paramStartCheckParam.gameId);
      paramStartCheckParam.mIsTransGame = abxh.sQ.contains(Integer.valueOf(paramStartCheckParam.gameId));
      return true;
    }
  }
  
  public static Class[] a(String paramString)
  {
    int i2 = 0;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (TextUtils.isEmpty(paramString.trim())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i3 = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder();
    int k = 0;
    int j = 0;
    int n;
    if (k < i3)
    {
      n = paramString.charAt(k);
      if (41 != n) {}
    }
    else
    {
      if ((localStringBuilder.length() > 0) && (QLog.isColorLevel())) {
        QLog.d("cmgame_process.CmGameUtil", 2, new Object[] { "paramList clsList:", localStringBuilder.toString() });
      }
      if (localArrayList.size() != 0) {
        break label760;
      }
      return null;
    }
    int i1 = k;
    int i = j;
    switch (n)
    {
    default: 
      i = j;
      i1 = k;
    }
    for (;;)
    {
      k = i1 + 1;
      j = i;
      break;
      localArrayList.add(Void.TYPE);
      i1 = k;
      i = j;
      continue;
      i = 1;
      i1 = k;
      continue;
      if (j != 0)
      {
        localArrayList.add([Z.class);
        i = 0;
        i1 = k;
      }
      else
      {
        localArrayList.add(Boolean.TYPE);
        i1 = k;
        i = j;
        continue;
        if (j != 0)
        {
          localArrayList.add([B.class);
          i = 0;
          i1 = k;
        }
        else
        {
          localArrayList.add(Byte.TYPE);
          i1 = k;
          i = j;
          continue;
          if (j != 0)
          {
            localArrayList.add([C.class);
            i = 0;
            i1 = k;
          }
          else
          {
            localArrayList.add(Character.TYPE);
            i1 = k;
            i = j;
            continue;
            if (j != 0)
            {
              localArrayList.add([S.class);
              i = 0;
              i1 = k;
            }
            else
            {
              localArrayList.add(Short.TYPE);
              i1 = k;
              i = j;
              continue;
              if (j != 0)
              {
                localArrayList.add([I.class);
                i = 0;
                i1 = k;
              }
              else
              {
                localArrayList.add(Integer.TYPE);
                i1 = k;
                i = j;
                continue;
                if (j != 0)
                {
                  localArrayList.add([J.class);
                  i = 0;
                  i1 = k;
                }
                else
                {
                  localArrayList.add(Long.TYPE);
                  i1 = k;
                  i = j;
                  continue;
                  if (j != 0)
                  {
                    localArrayList.add([F.class);
                    i = 0;
                    i1 = k;
                  }
                  else
                  {
                    localArrayList.add(Float.TYPE);
                    i1 = k;
                    i = j;
                    continue;
                    if (j != 0)
                    {
                      localArrayList.add([D.class);
                      i = 0;
                      i1 = k;
                    }
                    else
                    {
                      localArrayList.add(Double.TYPE);
                      i1 = k;
                      i = j;
                      continue;
                      i1 = k + 1;
                      k = i1;
                      for (i = n; (k < i3) && (i != 59); i = paramString.charAt(k)) {
                        k += 1;
                      }
                      n = j;
                      try
                      {
                        Object localObject = paramString.substring(i1, k);
                        n = j;
                        localStringBuilder.append("clsName:").append((String)localObject).append(",");
                        n = j;
                        String str = ((String)localObject).replace('/', '.');
                        i = j;
                        localObject = str;
                        if (j != 0)
                        {
                          n = j;
                          localObject = "[L" + str + ";";
                          i = 0;
                        }
                        n = i;
                        localArrayList.add(Class.forName((String)localObject));
                        i1 = k;
                      }
                      catch (Throwable localThrowable)
                      {
                        QLog.e("cmgame_process.CmGameUtil", 1, localThrowable, new Object[0]);
                        i1 = k;
                        i = n;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label760:
    paramString = new Class[localArrayList.size()];
    Iterator localIterator = localArrayList.iterator();
    i = i2;
    while (localIterator.hasNext())
    {
      paramString[i] = ((Class)localIterator.next());
      i += 1;
    }
    return paramString;
  }
  
  public static void aB(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.i("cmgame_process.CmGameUtil", 1, "[sendActLifeCycleIpc], gameId:" + paramInt2 + ",status:" + paramInt1);
    Bundle localBundle = new Bundle();
    localBundle.putInt("status", paramInt1);
    localBundle.putInt("gameId", paramInt2);
    localBundle.putInt("activityId", paramInt3);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "game_activity_lifecycle", localBundle, null);
  }
  
  public static boolean aY(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.mobileqq:tool".equals(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName)) {
        return true;
      }
    }
    return false;
  }
  
  public static abos b()
  {
    aboz localaboz = a();
    if (localaboz == null) {
      return null;
    }
    return localaboz.c();
  }
  
  public static abos b(int paramInt1, int paramInt2)
  {
    aboz localaboz = a();
    if (localaboz == null) {
      return null;
    }
    return localaboz.b(paramInt1, paramInt2);
  }
  
  public static abos b(long paramLong)
  {
    aboz localaboz = a();
    if (localaboz == null) {
      return null;
    }
    return localaboz.b(paramLong);
  }
  
  public static String b(CmGameInitParams paramCmGameInitParams)
  {
    if (paramCmGameInitParams == null) {
      return "";
    }
    for (;;)
    {
      try
      {
        localJSONObject1 = abxt.a(0, abto.jS);
        if (localJSONObject1 == null)
        {
          QLog.e("cmgame_process.CmGameUtil", 1, "json is null");
          return "{}";
        }
        localJSONObject1.put("roomId", String.valueOf(paramCmGameInitParams.mRoomId));
        localJSONObject1.put("svrIp", paramCmGameInitParams.mServerIp);
        localJSONObject1.put("port", paramCmGameInitParams.mPort);
        localJSONObject1.put("spriteDesignHeight", 368);
        if (("1".equals(paramCmGameInitParams.mGameName)) || ("2".equals(paramCmGameInitParams.mGameName)))
        {
          localJSONObject1.put("gameId", paramCmGameInitParams.mGameName);
          if ((!ApolloGameStateMachine.cm.getAndSet(false)) || (ApolloGameStateMachine.a == null)) {
            break label999;
          }
          localJSONObject1.put("freeMemory", ApolloGameStateMachine.a.NP);
          localJSONObject1.put("totalMemory", ApolloGameStateMachine.a.NQ);
          localJSONObject1.put("osVersion", ApolloGameStateMachine.a.mOsVersion);
          localJSONObject1.put("model", ApolloGameStateMachine.a.bgR);
          localJSONObject1.put("cpuType", ApolloGameStateMachine.a.bgS);
          localJSONObject1.put("cpuNumber", ApolloGameStateMachine.a.cpJ);
          localJSONObject1.put("cpuFrequency", ApolloGameStateMachine.a.NO);
          localJSONObject1.put("gameVersion", paramCmGameInitParams.mVersion);
          localJSONObject1.put("QQVer", "3.4.4.3058");
          localJSONObject1.put("platform", "android");
          localJSONObject1.put("gameMode", paramCmGameInitParams.mGameMode);
          if (!TextUtils.isEmpty(paramCmGameInitParams.openId)) {
            localJSONObject1.put("openId", paramCmGameInitParams.openId);
          }
          if (!TextUtils.isEmpty(paramCmGameInitParams.mRobotOpenId)) {
            localJSONObject1.put("robotOpenId", paramCmGameInitParams.mRobotOpenId);
          }
          str2 = paramCmGameInitParams.mGameParam;
          if (!TextUtils.isEmpty(str2))
          {
            bool1 = str2.contains("extendInfo");
            localObject = str2;
            if (!bool1) {}
          }
        }
      }
      catch (Exception paramCmGameInitParams)
      {
        Object localObject;
        JSONObject localJSONObject2;
        QLog.e("cmgame_process.CmGameUtil", 2, paramCmGameInitParams.getMessage());
        return "{}";
      }
      try
      {
        localJSONObject2 = new JSONObject(str2);
        localObject = str2;
        if (localJSONObject2.has("extendInfo")) {
          localObject = localJSONObject2.optString("extendInfo");
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmgame_process.CmGameUtil", 1, localThrowable, new Object[0]);
        String str1 = str2;
        continue;
        localJSONObject1.put("aioType", paramCmGameInitParams.mSessionType);
        if (!paramCmGameInitParams.mIsMaster) {
          break label1145;
        }
        for (i = 1;; i = 0)
        {
          localJSONObject1.put("isMaster", i);
          break;
        }
        bool2 = false;
        bool1 = true;
        if (!bool1) {
          break label1171;
        }
        i = 0;
        continue;
        i = 0;
        continue;
        i = 1;
        continue;
        i = 0;
        continue;
      }
      localJSONObject1.put("gameParam", localObject);
      if (!paramCmGameInitParams.isWhiteUsr) {
        break label1166;
      }
      i = 1;
      localJSONObject1.put("isWhiteUser", i);
      localJSONObject1.put("src", paramCmGameInitParams.mSrc);
      localJSONObject1.put("networkType", 0);
      localJSONObject1.put("connType", aqiw.getSystemNetwork(BaseApplicationImpl.getContext()));
      localJSONObject1.put("accessTokenCode", paramCmGameInitParams.accessTokenRet);
      localJSONObject1.put("accessToken", paramCmGameInitParams.accessToken);
      localJSONObject1.put("commFlagBits", paramCmGameInitParams.commFlag);
      localObject = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 4);
      if (localObject == null) {
        break label1150;
      }
      bool1 = ((SharedPreferences)localObject).getBoolean("is_ever_play_cmgame" + paramCmGameInitParams.mGameName + paramCmGameInitParams.mSelfUin, false);
      bool2 = ((SharedPreferences)localObject).getBoolean("is_first_install_cmgame" + paramCmGameInitParams.mGameName + paramCmGameInitParams.mSelfUin, true);
      if (!bool2) {
        break label1157;
      }
      ((SharedPreferences)localObject).edit().putBoolean("is_first_install_cmgame" + paramCmGameInitParams.mGameName + paramCmGameInitParams.mSelfUin, false).commit();
      break label1157;
      localJSONObject1.put("isFirstPlay", i);
      if (!bool2) {
        break label1176;
      }
      i = 1;
      localJSONObject1.put("isFirstInstall", i);
      localJSONObject1.put("sessionId", String.valueOf(new Random(System.currentTimeMillis()).nextInt(100000)));
      if ((paramCmGameInitParams.mGameMode != 1) && (paramCmGameInitParams.mGameMode != 2)) {
        break;
      }
      localJSONObject1.put("aioType", 1);
      localJSONObject1.put("isMaster", 1);
      if ((!TextUtils.isEmpty(paramCmGameInitParams.mExtraStr)) && (("1".equals(paramCmGameInitParams.mGameName)) || ("2".equals(paramCmGameInitParams.mGameName)))) {
        localJSONObject1.put("extraStr", paramCmGameInitParams.mExtraStr);
      }
      localJSONObject1.put("sex", paramCmGameInitParams.gender);
      localJSONObject1.put("apolloStatus", paramCmGameInitParams.apolloStatus);
      localJSONObject1.put("gameType", paramCmGameInitParams.gameType);
      localJSONObject1.put("redUrl", paramCmGameInitParams.redUrl);
      if (paramCmGameInitParams.adForbidPosId != null) {
        localJSONObject1.put("adForbitPosId", paramCmGameInitParams.adForbidPosId);
      }
      localJSONObject1.put("transInfo", paramCmGameInitParams.transInfo);
      QLog.i("cmgame_process.CmGameUtil", 1, "gameId:" + paramCmGameInitParams.mGameName + ",gameMode:" + paramCmGameInitParams.mGameMode + ",src:" + paramCmGameInitParams.mSrc + ",roomId:" + paramCmGameInitParams.mRoomId);
      paramCmGameInitParams = localJSONObject1.toString();
      return paramCmGameInitParams;
      try
      {
        localJSONObject1.put("gameId", Integer.parseInt(paramCmGameInitParams.mGameName));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      continue;
      label999:
      localJSONObject1.put("freeMemory", aqgz.L(Process.myPid()));
      localJSONObject1.put("totalMemory", aqgz.hH());
      localJSONObject1.put("osVersion", aqgz.getDeviceOSVersion());
      localJSONObject1.put("model", aqgz.getModel());
      localJSONObject1.put("cpuType", aqgz.getCpuType());
      localJSONObject1.put("cpuNumber", aqgz.getCpuNumber());
      localJSONObject1.put("cpuFrequency", aqgz.getCpuFrequency());
    }
  }
  
  public static void b(AppInterface paramAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameUtil", 2, new Object[] { "[reportGameData]", paramString });
    }
    if (paramAppInterface == null)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, "[reportGameData] app null");
      return;
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("id", -1);
      ((JSONObject)localObject).put("from", "android");
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(paramString);
      ((JSONObject)localObject).put("reportData", localJSONArray);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramString = new NewIntent(paramAppInterface.getApp(), abka.class);
      paramString.putExtra("cmd", "ltgame_redpkg_report.terminal_report");
      paramString.putExtra("data", localUniSsoServerReq.toByteArray());
      paramString.setObserver(new abmv());
      paramAppInterface.startServlet(paramString);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, "[reportGameData] failed, exception=", paramAppInterface);
    }
  }
  
  public static boolean b(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    return (paramStartCheckParam != null) && (paramStartCheckParam.mGameType == 3);
  }
  
  public static void bK(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      Intent localIntent = new Intent(paramActivity, SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("tab_index", MainFragment.bIk);
      localIntent.putExtra("fromApolloNewUser", 1);
      localIntent.setFlags(67174400);
      paramActivity.startActivity(localIntent);
    }
  }
  
  public static void bo(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("cmgame_process.CmGameUtil", 1, "[openCmGameWebView] context and url must not be null");
      return;
    }
    QLog.d("cmgame_process.CmGameUtil", 1, new Object[] { "[openCmGameWebView] url=", paramString });
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("fragment_class", CmGameFragment.class.getCanonicalName());
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }
  
  public static void bp(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
    VasWebviewUtil.openQQBrowserActivity(paramContext, paramString, -1L, localIntent, false, -1);
  }
  
  public static Class c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        int i = paramString.indexOf(')');
        if (-1 != i)
        {
          paramString = a(paramString.substring(i + 1));
          if ((paramString != null) && (paramString.length != 0))
          {
            paramString = paramString[0];
            return paramString;
          }
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("cmgame_process.CmGameUtil", 1, paramString, new Object[0]);
      }
    }
    return null;
  }
  
  public static boolean c(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    return (paramStartCheckParam != null) && (paramStartCheckParam.gameId == 4698);
  }
  
  public static byte[] c(byte[] paramArrayOfByte, String paramString)
    throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException
  {
    if (paramArrayOfByte == null) {
      return paramArrayOfByte;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("cmgame_process.CmGameUtil", 1, "encrypt, no key");
      return paramArrayOfByte;
    }
    paramString = new SecretKeySpec(paramString.getBytes("UTF-8"), "AES");
    Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    localCipher.init(1, paramString);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static void cDo()
  {
    abmm.a().cDo();
  }
  
  public static void cDp()
  {
    if (aY(BaseApplicationImpl.getContext())) {}
    Object localObject;
    do
    {
      int i;
      do
      {
        return;
        QLog.d("cmgame_process.CmGameUtil", 1, "onGameCrashed");
        localObject = (abhh)getAppInterface().getManager(153);
        if ((localObject != null) && (((abhh)localObject).Yk())) {
          ((abhh)localObject).a().cCY();
        }
        i = zE();
      } while (-1 == i);
      localObject = abmm.a().a(i);
    } while (localObject == null);
    ((abow)localObject).cDK();
  }
  
  public static void cc(QQAppInterface paramQQAppInterface)
  {
    long l = System.currentTimeMillis();
    if (l - Ob < 1800000L) {}
    while ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null)) {
      return;
    }
    boolean bool = aY(paramQQAppInterface.getApp());
    QLog.d("cmgame_process.CmGameUtil", 1, new Object[] { "[preloadGameProcess] isProcessOn=", Boolean.valueOf(bool) });
    if (!bool)
    {
      paramQQAppInterface = (WebProcessManager)paramQQAppInterface.getManager(13);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.Yc(100);
      }
    }
    Ob = l;
  }
  
  public static byte[] d(byte[] paramArrayOfByte, String paramString)
    throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException
  {
    if (paramArrayOfByte == null) {
      return paramArrayOfByte;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("cmgame_process.CmGameUtil", 1, "decrypt, no key");
      return paramArrayOfByte;
    }
    paramString = new SecretKeySpec(paramString.getBytes("UTF-8"), "AES");
    Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    localCipher.init(2, paramString);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static void eu(String paramString1, String paramString2)
  {
    if (!YH()) {}
    abpu localabpu;
    do
    {
      do
      {
        return;
      } while (!"apollo_aio_game.cancel_game_room".equals(paramString1));
      localabpu = a();
    } while (localabpu == null);
    localabpu.a(paramString1, paramString2, -1L, 4, false, null);
  }
  
  public static void ev(String paramString1, String paramString2)
  {
    QLog.d("cmgame_process.CmGameUtil", 1, new Object[] { "[putMainJsToCache] sEnableMainJsCache=", Boolean.valueOf(bEa), ", mainJsPath=", paramString1 });
    if ((bEa) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      m.put(paramString1, paramString2);
    }
  }
  
  public static int ga(int paramInt)
  {
    if (paramInt == 1) {}
    do
    {
      return 1;
      if (paramInt == 2) {
        return 8;
      }
    } while (paramInt != 3);
    return 0;
  }
  
  public static int gb(int paramInt)
  {
    try
    {
      Object localObject = new StringBuilder(100);
      ((StringBuilder)localObject).append(abxi.biF).append(paramInt).append(File.separator).append("gameConfig.json");
      localObject = new File(((StringBuilder)localObject).toString());
      if (!((File)localObject).exists())
      {
        QLog.w("cmgame_process.CmGameUtil", 1, "[getGameRscType], gameConfig.json NOT exist.");
        return 0;
      }
      localObject = new JSONObject(aqhq.readFileToString((File)localObject)).optJSONArray("subpackages");
      if (localObject != null)
      {
        paramInt = ((JSONArray)localObject).length();
        if (paramInt > 0) {
          return 1;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, localThrowable, new Object[0]);
    }
    return 0;
  }
  
  public static AppInterface getAppInterface()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof ToolAppRuntime))
      {
        localObject = ((AppRuntime)localObject).getAppRuntime("cmshowgame_module");
        if (!(localObject instanceof AppInterface)) {
          break label54;
        }
        return (AppInterface)localObject;
      }
      if ((localObject instanceof QQAppInterface)) {
        return (QQAppInterface)localObject;
      }
    }
    return null;
    label54:
    return null;
  }
  
  public static final int getNetType()
  {
    int i;
    if (NetworkState.isWifiConn()) {
      i = 4;
    }
    String str;
    do
    {
      int j;
      do
      {
        return i;
        j = 0;
        str = auri.ru("7411ce");
        i = j;
      } while (TextUtils.isEmpty(str));
      if ((str.startsWith("46000")) || (str.startsWith("46002"))) {
        return 1;
      }
      if (str.startsWith("46001")) {
        return 2;
      }
      i = j;
    } while (!str.startsWith("46003"));
    return 3;
  }
  
  public static boolean hP(int paramInt)
  {
    return paramInt == 1000;
  }
  
  public static boolean hQ(int paramInt)
  {
    return paramInt == 3112;
  }
  
  public static boolean hR(int paramInt)
  {
    boolean bool = true;
    try
    {
      Object localObject = new StringBuilder(100);
      ((StringBuilder)localObject).append(abxi.biF).append(paramInt).append(File.separator).append("gameConfig.json");
      localObject = new File(((StringBuilder)localObject).toString());
      if (!((File)localObject).exists())
      {
        QLog.w("cmgame_process.CmGameUtil", 1, "[isMSAAEnabled], gameConfig.json NOT exist.");
        return false;
      }
      int i = new JSONObject(aqhq.readFileToString((File)localObject)).optInt("enableMSAA");
      QLog.i("cmgame_process.CmGameUtil", 1, "[mobile_performance],enableMSAA:" + i + ",gameId:" + paramInt);
      if (i == 1) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, localThrowable, new Object[0]);
    }
  }
  
  public static String iA(String paramString)
  {
    QLog.d("cmgame_process.CmGameUtil", 1, new Object[] { "[getMainJsFromCache] sEnableMainJsCache=", Boolean.valueOf(bEa), ", mainJsPath=", paramString });
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (bEa)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString)) {
        localObject1 = (String)m.get(paramString);
      }
    }
    return localObject1;
  }
  
  public static boolean isFastDoubleClick()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - yQ;
    if ((0L < l2) && (l2 < 1000L)) {
      return true;
    }
    yQ = l1;
    return false;
  }
  
  public static void j(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameUtil", 2, "[launchGame]");
    }
    if (paramStartCheckParam == null) {
      QLog.e("cmgame_process.CmGameUtil", 1, "[launchGame], null params.");
    }
    aboz localaboz;
    do
    {
      return;
      localaboz = a();
    } while (localaboz == null);
    long l = System.currentTimeMillis();
    if (l - NY < 1000L)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, "[launchGame] current - sLastLaunchGameTime < 1000");
      return;
    }
    NY = l;
    if (paramStartCheckParam.mCreateTs == NZ)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, new Object[] { "launchGame had launch game sLastStartGameCreateTs:", Long.valueOf(NZ) });
      return;
    }
    NZ = paramStartCheckParam.mCreateTs;
    Oa = SystemClock.uptimeMillis();
    if ((paramStartCheckParam != null) && (paramStartCheckParam.statMap != null)) {
      paramStartCheckParam.statMap.put("game_launch_time", Long.valueOf(Oa));
    }
    QLog.d("CmGameStat", 1, new Object[] { "sLaunchGameTs=", Long.valueOf(Oa) });
    Object localObject1 = null;
    Object localObject2 = null;
    localaboz.cDS();
    List localList;
    int i;
    Object localObject3;
    Object localObject4;
    if (paramStartCheckParam.gameId == 3112)
    {
      localObject2 = ApolloAIActivity.class;
      if ((BaseActivity.sTopActivity != null) && (BaseActivity.sTopActivity.getClass() != localObject2) && (BaseActivity.sTopActivity.getClass() != SingleTaskQQBrowser.class))
      {
        localObject1 = new Intent(BaseActivity.sTopActivity, (Class)localObject2);
        ((Intent)localObject1).putExtra("extra_startcheckparam", paramStartCheckParam);
        ((Intent)localObject1).addFlags(268435456);
        BaseActivity.sTopActivity.startActivity((Intent)localObject1);
      }
    }
    else
    {
      localList = localaboz.dG();
      if ((paramStartCheckParam.mStartType == 2) || (paramStartCheckParam.mStartType == 1) || (paramStartCheckParam.mStartType == 3))
      {
        QLog.i("cmgame_process.CmGameUtil", 1, "[launchGame], params.mStartType:" + paramStartCheckParam.mStartType);
        localObject1 = localObject2;
        if (localList != null)
        {
          i = 0;
          localObject1 = localObject2;
          if (i < localList.size())
          {
            localObject3 = (aboz.b)localList.get(i);
            if ((localObject3 == null) || (((aboz.b)localObject3).b == null)) {
              break label713;
            }
            localObject1 = localaboz.b(((aboz.b)localObject3).b.gameId);
            if (localObject1 == null) {
              break label713;
            }
            localObject4 = ((abos)localObject1).a();
            if ((((abos)localObject1).getGameId() != paramStartCheckParam.gameId) || ((paramStartCheckParam.roomId != 0L) && (paramStartCheckParam.roomId != ((ApolloPanel.b)localObject4).roomId))) {
              break label713;
            }
            if (((abos)localObject1).q() == null) {
              break label1490;
            }
          }
        }
      }
    }
    label713:
    label849:
    label1490:
    for (localObject1 = ((abos)localObject1).q().getClass();; localObject1 = null)
    {
      QLog.i("cmgame_process.CmGameUtil", 1, " launchGame found old task.mStartCheckParam:" + ((aboz.b)localObject3).b);
      if (localObject1 == null)
      {
        if ((localList != null) && (localList.size() >= aboz.e.length))
        {
          localObject2 = (aboz.b)localList.get(0);
          if ((localObject2 != null) && (((aboz.b)localObject2).mActivityRef != null))
          {
            localObject3 = (Activity)((aboz.b)localObject2).mActivityRef.get();
            if (localObject3 != null)
            {
              ((Activity)localObject3).finish();
              if (((aboz.b)localObject2).b != null)
              {
                aboi.a("cs.close_room.local", "{}", false, null, ((aboz.b)localObject2).b.gameId);
                QLog.i("cmgame_process.CmGameUtil", 1, " launchGame close old  task.mStartCheckParam.gameId:" + ((aboz.b)localObject2).b.gameId);
              }
            }
          }
          localaboz.wt.remove(0);
        }
        localObject2 = new HashMap();
        i = 0;
        for (;;)
        {
          if (i < localaboz.wt.size())
          {
            localObject3 = (aboz.b)localaboz.wt.get(i);
            if ((localObject3 != null) && (((aboz.b)localObject3).bhk != null)) {
              ((HashMap)localObject2).put(((aboz.b)localObject3).bhk, ((aboz.b)localObject3).bhk);
            }
            i += 1;
            continue;
            i += 1;
            break;
          }
        }
        i = 0;
        if (i >= aboz.e.length) {
          break label1483;
        }
        if (TextUtils.isEmpty((String)((HashMap)localObject2).get(aboz.e[i].getSimpleName())))
        {
          localObject2 = aboz.e[i];
          QLog.i("cmgame_process.CmGameUtil", 1, " launchGame startInGame found activityClass:" + localObject2);
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = aboz.e[0];
          QLog.e("cmgame_process.CmGameUtil", 1, "can not find activityClass, use first class");
        }
        localObject2 = new aboz.b();
        ((aboz.b)localObject2).b = paramStartCheckParam;
        ((aboz.b)localObject2).bhk = ((Class)localObject1).getSimpleName();
        localaboz.wt.add(localObject2);
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            localObject2 = localaboz.wt.iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = (aboz.b)((Iterator)localObject2).next();
                QLog.d("cmgame_process.CmGameUtil", 2, "launchGame task:" + ((aboz.b)localObject3).b.gameId);
                continue;
                i += 1;
                break;
                QLog.i("cmgame_process.CmGameUtil", 1, " launchGame startInGame start old Activity activityClass:" + localObject1);
                break label849;
                if (localList == null) {
                  break label1477;
                }
                localObject4 = new ArrayList();
                i = 0;
                while (i < localList.size())
                {
                  aboz.b localb = (aboz.b)localList.get(i);
                  boolean bool2 = false;
                  localObject3 = localObject1;
                  if (localb != null)
                  {
                    localObject3 = localObject1;
                    if (localb.b != null)
                    {
                      localObject3 = localaboz.b(localb.b.gameId);
                      boolean bool1 = bool2;
                      localObject2 = localObject1;
                      if (localObject3 != null)
                      {
                        ApolloPanel.b localb1 = ((abos)localObject3).a();
                        bool1 = bool2;
                        localObject2 = localObject1;
                        if (((abos)localObject3).getGameId() == paramStartCheckParam.gameId) {
                          if (paramStartCheckParam.roomId != 0L)
                          {
                            bool1 = bool2;
                            localObject2 = localObject1;
                            if (paramStartCheckParam.roomId != localb1.roomId) {}
                          }
                          else
                          {
                            bool2 = true;
                            bool1 = bool2;
                            localObject2 = localObject1;
                            if (((abos)localObject3).q() != null)
                            {
                              localObject2 = ((abos)localObject3).q().getClass();
                              bool1 = bool2;
                            }
                          }
                        }
                      }
                      QLog.i("cmgame_process.CmGameUtil", 1, " launchGame check sameGame:" + bool1);
                      localObject3 = localObject2;
                      if (!bool1)
                      {
                        if (localb.mActivityRef != null)
                        {
                          localObject1 = (Activity)localb.mActivityRef.get();
                          if (localObject1 != null)
                          {
                            ((Activity)localObject1).finish();
                            if (localb.b != null) {
                              aboi.a("cs.close_room.local", "{}", false, null, localb.b.gameId);
                            }
                            QLog.i("cmgame_process.CmGameUtil", 1, " launchGame close old  task.mStartCheckParam.gameId:" + localb.b.gameId);
                          }
                        }
                        ((List)localObject4).add(localb);
                        localObject3 = localObject2;
                      }
                    }
                  }
                  i += 1;
                  localObject1 = localObject3;
                }
                localList.removeAll((Collection)localObject4);
              }
            }
          }
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            localObject1 = aboz.e[0];
            localObject2 = new aboz.b();
            ((aboz.b)localObject2).b = paramStartCheckParam;
            ((aboz.b)localObject2).bhk = ((Class)localObject1).getSimpleName();
            localaboz.wt.add(localObject2);
            break label849;
          }
          QLog.i("cmgame_process.CmGameUtil", 1, " launchGame start old Activity activityClass:" + localObject1);
          break label849;
          QLog.d("cmgame_process.CmGameUtil", 2, "launchGame current ActivityClass:" + localObject1);
          localObject2 = localObject1;
          if (localObject1 != null) {
            break;
          }
          localObject2 = aboz.e[0];
          break;
          localObject1 = new Intent(BaseApplicationImpl.getApplication(), (Class)localObject2);
          ((Intent)localObject1).putExtra("extra_startcheckparam", paramStartCheckParam);
          ((Intent)localObject1).addFlags(268435456);
          BaseApplicationImpl.getApplication().startActivity((Intent)localObject1);
          return;
          localObject1 = null;
        }
        localObject2 = localObject1;
      }
    }
  }
  
  public static void k(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    QLog.d("cmgame_process.CmGameUtil", 1, "[openLoadingInMainProc]");
    if (paramStartCheckParam == null) {
      return;
    }
    Intent localIntent;
    try
    {
      Oc = SystemClock.uptimeMillis();
      localIntent = new Intent(BaseApplicationImpl.getApplication(), CmGameLoadingFragment.class);
      localIntent.putExtra("extra_startcheckparam", paramStartCheckParam);
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.addFlags(268435456);
      if (paramStartCheckParam.notFullScreen)
      {
        PublicFragmentActivity.start(BaseApplicationImpl.getApplication(), localIntent, CmGameLoadingFragment.class);
        return;
      }
    }
    catch (Exception paramStartCheckParam)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, "[openLoadingInMainProc] exception=", paramStartCheckParam);
      return;
    }
    PublicTransFragmentActivity.start(BaseApplicationImpl.getApplication(), localIntent, CmGameLoadingFragment.class);
  }
  
  public static void o(View paramView, String paramString)
  {
    if (paramView != null) {}
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Rect localRect = new Rect();
        paramView.getGlobalVisibleRect(localRect);
        TextView localTextView = new TextView(paramView.getContext());
        localTextView.setText(paramString);
        localTextView.setGravity(17);
        localTextView.setTextSize(16.0F);
        localTextView.setTextColor(-1);
        localTextView.setBackgroundResource(2130838688);
        localTextView.setPadding((int)(aqgz.density * 7.0F), (int)(aqgz.density * 7.0F), (int)(aqgz.density * 7.0F), 0);
        paramString = new PopupWindow(localTextView, -2, -2);
        paramString.setOutsideTouchable(true);
        paramString.setBackgroundDrawable(new ColorDrawable(0));
        localTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int i = (int)((float)aqgz.getWidth() - aqgz.density * 7.0F - localTextView.getMeasuredWidth());
        int j = (int)(localRect.bottom - 6.0F * aqgz.density);
        paramString.showAtLocation(paramView.getRootView(), 0, i, j);
        Hx(1);
        ThreadManager.getUIHandler().postDelayed(new CmGameUtil.2(paramString), 10000L);
        QLog.d("cmgame_process.CmGameUtil", 1, "showNewPlusGuidePop");
        VipUtils.a(getAppInterface(), "cmshow", "Apollo", "plusbubbleexposure", 0, 0, new String[] { "" + zG() });
      }
      return;
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public static void x(Object... paramVarArgs)
  {
    abkj localabkj = a();
    if (localabkj != null) {
      localabkj.b("cmg_launch", 4, paramVarArgs);
    }
  }
  
  public static int zE()
  {
    return abmm.a().zE();
  }
  
  public static int zF()
  {
    if (getAppInterface() == null) {
      return 0;
    }
    abhh localabhh = (abhh)getAppInterface().getManager(153);
    if ((localabhh != null) && (localabhh.Yj())) {
      return 1;
    }
    return 0;
  }
  
  public static int zG()
  {
    if (getAppInterface() == null) {
      return 0;
    }
    abhh localabhh = (abhh)getAppInterface().getManager(153);
    if ((localabhh != null) && (localabhh.bCF)) {
      return 1;
    }
    return 0;
  }
  
  public static int zH()
  {
    int i = 2;
    if (cqb < 0) {
      cqb = aqgz.getCpuNumber();
    }
    if (sz < 0.0F) {
      sz = (float)aqgz.getCpuFrequency() / 1.0F / 1024.0F;
    }
    if (totalMemory < 0L) {
      totalMemory = Math.ceil(aqgz.getSystemTotalMemory() / 1073741824.0D);
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameUtil", 2, new Object[] { "[mobile_performance],cpuCoreNumber:", Integer.valueOf(cqb), ",cpuFrequency:", Float.valueOf(sz), ",totalMemory:", Long.valueOf(totalMemory) });
    }
    if ((totalMemory >= 4.0D) && (cqb >= 4) && (sz > 1.5D)) {
      i = 1;
    }
    for (;;)
    {
      QLog.i("cmgame_process.CmGameUtil", 1, "[mobile_performance],level:" + i);
      return i;
      if ((totalMemory >= 3.0D) && (totalMemory <= 4.0D) && (cqb >= 4))
      {
        if (totalMemory < 4.0D)
        {
          if (sz <= 1.5D) {
            i = 3;
          }
        }
        else if (totalMemory != 4.0D) {
          i = 3;
        }
      }
      else {
        i = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abmt
 * JD-Core Version:    0.7.0.1
 */