package com.tencent.mobileqq.apollo.utils;

import abhc;
import abhe;
import abhh;
import able;
import ablf;
import ablg;
import abll;
import ablp;
import abmm;
import abmt;
import abow;
import abox;
import abrd;
import abvn;
import abxh;
import abxi;
import abxk;
import abya;
import abye;
import abyf;
import abyg;
import abyh;
import abyj;
import acfp;
import acfs;
import aczw;
import anbi;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.webkit.URLUtil;
import anpc;
import aqft;
import aqho;
import aqhq;
import aqiw;
import aqoo;
import aqoq;
import aqrb;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.data.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.game.ApolloFragment;
import com.tencent.mobileqq.apollo.game.ApolloWebViewFragment;
import com.tencent.mobileqq.apollo.game.WebGameFakeView;
import com.tencent.mobileqq.apollo.game.WebGameFakeView.Director;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloPanel.b;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ApolloGameRankData;
import com.tencent.mobileqq.data.ApolloGameRoamData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import ton;
import tzg;
import tzk;
import wja;
import wki;
import xxh;

public class ApolloGameUtil
{
  public static CmStartTask a;
  private static boolean bGk;
  private static boolean bGl;
  private static boolean bGm;
  public static SparseArray<SparseArray<ApolloGameRedDot>> ce;
  private static SparseArray<Integer> cf;
  public static int ctD = -1;
  public static int ctE;
  public static int ctF = 1;
  public static int ctG;
  
  public static int Ab()
  {
    SharedPreferences localSharedPreferences;
    if (ctD == -1)
    {
      localSharedPreferences = p();
      if (localSharedPreferences != null) {
        break label27;
      }
    }
    label27:
    for (int i = ablg.cpE;; i = localSharedPreferences.getInt("sp.score.num", ablg.cpE))
    {
      ctD = i;
      return ctD;
    }
  }
  
  public static void Ip(int paramInt)
  {
    ThreadManager.getUIHandler().post(new ApolloGameUtil.20(paramInt));
  }
  
  public static void L(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ApolloGameUtil", 1, "[updateRankInfo] app is null");
      return;
    }
    ThreadManager.post(new ApolloGameUtil.7(paramQQAppInterface, paramString), 5, null, false);
  }
  
  public static boolean Z(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    if (!abhh.aV(paramQQAppInterface.getApplication())) {
      return false;
    }
    paramQQAppInterface = ((abhh)paramQQAppInterface.getManager(153)).a(paramQQAppInterface.getCurrentUin());
    return (paramQQAppInterface == null) || (paramQQAppInterface.isApolloStatusOpen());
  }
  
  public static int a(AppInterface paramAppInterface, int paramInt, String paramString)
  {
    int i;
    if (paramInt == 0) {
      i = 1;
    }
    do
    {
      return i;
      if (1 == paramInt)
      {
        if ((paramAppInterface != null) && (!TextUtils.isEmpty(paramString)))
        {
          paramAppInterface = (HotChatManager)paramAppInterface.getManager(60);
          if ((paramAppInterface != null) && (paramAppInterface.kj(paramString))) {
            return 6;
          }
        }
        return 4;
      }
      if (3000 == paramInt) {
        return 5;
      }
      i = paramInt;
    } while (1036 != paramInt);
    return 7;
  }
  
  public static int a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    paramChatMessage = (MessageForApollo)paramChatMessage;
    paramQQAppInterface = (abxk)paramQQAppInterface.getManager(155);
    if (ib(paramChatMessage.msgType))
    {
      paramQQAppInterface = paramQQAppInterface.b(paramChatMessage.gameId);
      if ((abhh.ce("gameSwitch") != 1) || ((paramQQAppInterface != null) && (!abxh.l("3.4.4", paramQQAppInterface.minVer, paramQQAppInterface.maxVer))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameUtil", 2, "play apollo game msg but switch is 0 or version is incorrect");
        }
        return ctE;
      }
      if ((paramChatMessage.gameId == 1) || (paramChatMessage.gameId == 2)) {
        return ctE;
      }
      return ctF;
    }
    return ctE;
  }
  
  public static SparseArray<SparseArray<ApolloGameRedDot>> a(EntityManager paramEntityManager)
  {
    int i;
    Object localObject2;
    if (ce != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, "[getGameReddotMap] from cache");
      }
      paramEntityManager = new SparseArray();
      try
      {
        int k = ce.size();
        if (k > 0)
        {
          i = 0;
          while (i < k)
          {
            int m = ce.keyAt(i);
            SparseArray localSparseArray1 = (SparseArray)ce.get(m);
            if ((localSparseArray1 != null) && (localSparseArray1.size() > 0))
            {
              localObject2 = new SparseArray();
              int n = localSparseArray1.size();
              int j = 0;
              while (j < n)
              {
                int i1 = localSparseArray1.keyAt(j);
                ((SparseArray)localObject2).put(i1, (ApolloGameRedDot)localSparseArray1.get(i1));
                j += 1;
              }
              paramEntityManager.put(m, localObject2);
            }
            i += 1;
          }
        }
        return paramEntityManager;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ApolloGameUtil", 1, localThrowable, new Object[] { "[getGameReddotMap]" });
      }
    }
    if (paramEntityManager == null) {
      return null;
    }
    Object localObject1 = paramEntityManager.query(ApolloGameRedDot.class);
    SparseArray localSparseArray2 = new SparseArray();
    Iterator localIterator;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("apolloGameReddot getGameReddotMap, redDots.size:");
      if (localObject1 == null)
      {
        i = 0;
        QLog.d("ApolloGameUtil", 2, i);
      }
    }
    else
    {
      if (localObject1 == null) {
        break label368;
      }
      localIterator = ((List)localObject1).iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label368;
      }
      ApolloGameRedDot localApolloGameRedDot = (ApolloGameRedDot)localIterator.next();
      if (localApolloGameRedDot != null)
      {
        if (localApolloGameRedDot.isTimeValid())
        {
          localObject2 = (SparseArray)localSparseArray2.get(localApolloGameRedDot.mGameId);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new SparseArray();
            localSparseArray2.put(localApolloGameRedDot.mGameId, localObject1);
          }
          ((SparseArray)localObject1).put(localApolloGameRedDot.mDotId, localApolloGameRedDot);
          continue;
          i = ((List)localObject1).size();
          break;
        }
        paramEntityManager.remove(localApolloGameRedDot);
      }
    }
    label368:
    ce = localSparseArray2;
    return localSparseArray2;
  }
  
  public static ApolloGameRedDot a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (paramInt <= 0)) {
      return null;
    }
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    if (paramQQAppInterface == null) {
      return null;
    }
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (SparseArray)paramQQAppInterface.get(paramInt);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
      {
        ArrayList localArrayList = new ArrayList(paramQQAppInterface.size());
        int i = paramQQAppInterface.size();
        paramInt = 0;
        while (paramInt < i)
        {
          int j = paramQQAppInterface.keyAt(paramInt);
          if (paramQQAppInterface.get(j) != null) {
            localArrayList.add(paramQQAppInterface.get(j));
          }
          paramInt += 1;
        }
        if (localArrayList.size() > 0)
        {
          Collections.sort(localArrayList);
          return (ApolloGameRedDot)localArrayList.get(0);
        }
        return null;
      }
      return null;
    }
    return null;
  }
  
  public static ApolloGameRedDot a(SparseArray<ApolloGameRedDot> paramSparseArray)
  {
    if ((paramSparseArray == null) || (paramSparseArray.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return null;
      localArrayList = new ArrayList(paramSparseArray.size());
      int j = paramSparseArray.size();
      int i = 0;
      while (i < j)
      {
        int k = paramSparseArray.keyAt(i);
        if (paramSparseArray.get(k) != null) {
          localArrayList.add(paramSparseArray.get(k));
        }
        i += 1;
      }
    } while (localArrayList.size() <= 0);
    Collections.sort(localArrayList);
    return (ApolloGameRedDot)localArrayList.get(0);
  }
  
  private static final ApolloGameRedDot a(AppInterface paramAppInterface, List<ApolloGameRedDot> paramList)
  {
    if (paramAppInterface == null)
    {
      paramAppInterface = null;
      return paramAppInterface;
    }
    paramAppInterface = paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getCurrentAccountUin() + "apollo_game_reddot_sp", 0);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      for (;;)
      {
        if (i >= paramList.size()) {
          break label159;
        }
        ApolloGameRedDot localApolloGameRedDot = (ApolloGameRedDot)paramList.get(i);
        String str = a(localApolloGameRedDot);
        if ((localApolloGameRedDot != null) && (!TextUtils.isEmpty(localApolloGameRedDot.mTipsWording)) && (!TextUtils.isEmpty(str)) && (!paramAppInterface.getBoolean(str, false)))
        {
          paramAppInterface = localApolloGameRedDot;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloGameUtil", 2, "[initReddotBubbleTips] find apolloGameReddot:" + localApolloGameRedDot);
          return localApolloGameRedDot;
        }
        i += 1;
      }
    }
    label159:
    return null;
  }
  
  private static String a(ApolloGameRedDot paramApolloGameRedDot)
  {
    if (paramApolloGameRedDot == null) {
      return null;
    }
    return "apollo_game_reddot_hasshow_" + String.valueOf(paramApolloGameRedDot.mGameId) + "_" + String.valueOf(paramApolloGameRedDot.mDotId);
  }
  
  public static List<MessageForApollo> a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    List localList = paramQQAppInterface.a(paramInt).l(paramString, paramInt);
    if ((localList != null) && (localList.size() > 0))
    {
      paramQQAppInterface = localList;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, "in aio, cache size:" + localList.size());
      }
    }
    for (paramQQAppInterface = localList;; paramQQAppInterface = paramQQAppInterface.b().b(paramString, paramInt, new int[] { -2039 }))
    {
      return b(paramQQAppInterface, paramLong);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, "NOT in aio.");
      }
    }
  }
  
  public static List<MessageForApollo> a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, new Object[] { "[getNeedPullMsg], friendUin:", paramString, ",curType:", Integer.valueOf(paramInt1), ",createTime:", Long.valueOf(paramLong), ",from:", Integer.valueOf(paramInt2) });
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString = paramQQAppInterface.b().a(paramString, paramInt1, null, 10);
      if ((paramString == null) || (paramString.size() <= 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameUtil", 2, "[getNeedPullMsg] no message,return.");
        }
        return localArrayList;
      }
      paramInt1 = paramString.size() - 1;
      while (paramInt1 >= 0)
      {
        Object localObject = (MessageRecord)paramString.get(paramInt1);
        if ((localObject instanceof MessageForApollo))
        {
          localObject = (MessageForApollo)localObject;
          if (a(paramQQAppInterface, (MessageForApollo)localObject, paramLong)) {
            localArrayList.add(localObject);
          }
        }
        paramInt1 -= 1;
      }
      return localArrayList;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("ApolloGameUtil", 1, paramQQAppInterface, new Object[0]);
      return localArrayList;
    }
    finally
    {
      paramLong = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, new Object[] { "[getNeedPullMsg] by last 10 messages, costT:", Long.valueOf(paramLong - l), ",pull size:", Integer.valueOf(localArrayList.size()) });
      }
    }
  }
  
  public static List<MessageForApollo> a(QQAppInterface paramQQAppInterface, WeakReference<XListView> paramWeakReference, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    long l = System.currentTimeMillis();
    if (paramWeakReference == null)
    {
      paramLong = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, new Object[] { "[getNeedPullMsg] on stop scroll, costT:", Long.valueOf(paramLong - l), ",pull size:", Integer.valueOf(localArrayList.size()) });
      }
      return localArrayList;
    }
    for (;;)
    {
      int j;
      int i;
      try
      {
        paramWeakReference = (AbsListView)paramWeakReference.get();
        if (paramWeakReference == null) {
          return localArrayList;
        }
        j = paramWeakReference.getFirstVisiblePosition();
        k = paramWeakReference.getLastVisiblePosition();
        if (!QLog.isColorLevel()) {
          break label505;
        }
        QLog.d("ApolloGameUtil", 2, new Object[] { "firstVPos:", Integer.valueOf(j), ",lastVPos:", Integer.valueOf(k) });
      }
      catch (Throwable paramQQAppInterface)
      {
        int k;
        Object localObject;
        paramQQAppInterface.printStackTrace();
        QLog.e("ApolloGameUtil", 1, "[getNeedPullMsg],errInfo->" + paramQQAppInterface.getMessage());
        return localArrayList;
        paramLong = System.currentTimeMillis();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloGameUtil", 2, new Object[] { "[getNeedPullMsg] on stop scroll, costT:", Long.valueOf(paramLong - l), ",pull size:", Integer.valueOf(localArrayList.size()) });
        continue;
      }
      finally
      {
        paramLong = System.currentTimeMillis();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloGameUtil", 2, new Object[] { "[getNeedPullMsg] on stop scroll, costT:", Long.valueOf(paramLong - l), ",pull size:", Integer.valueOf(localArrayList.size()) });
      }
      if (i <= k)
      {
        localObject = paramWeakReference.getChildAt(i - j);
        if (localObject != null)
        {
          localObject = ((View)localObject).getTag();
          if ((localObject instanceof BaseBubbleBuilder.e))
          {
            localObject = (BaseBubbleBuilder.e)localObject;
            if ((((BaseBubbleBuilder.e)localObject).mMessage instanceof MessageForApollo))
            {
              localObject = (MessageForApollo)((BaseBubbleBuilder.e)localObject).mMessage;
              if (a(paramQQAppInterface, (MessageForApollo)localObject, paramLong)) {
                localArrayList.add(localObject);
              }
            }
          }
        }
      }
      else
      {
        label505:
        i = j;
        continue;
      }
      i += 1;
    }
  }
  
  public static JSONObject a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = new JSONObject(paramString);
        long l = paramString.optLong("taskId");
        paramQQAppInterface = abrd.a(paramQQAppInterface, paramString);
        if (paramQQAppInterface != null)
        {
          paramString = new JSONObject();
          paramString.put("ret", 0);
          paramString.put("actionInfo", paramQQAppInterface);
          paramString.put("taskId", l);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGameUtil", 2, new Object[] { "ReqAction,", paramString.toString() });
          }
          return paramString;
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("ApolloGameUtil", 1, paramQQAppInterface, new Object[0]);
      }
    }
    return null;
  }
  
  @TargetApi(26)
  public static void a(int paramInt, String paramString, c paramc)
  {
    ThreadManager.post(new ApolloGameUtil.13(paramInt, paramString, paramc), 5, null, true);
  }
  
  public static void a(abvn paramabvn, long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, "[handleResultForGameEdit], ret:" + paramLong + ",cmd:" + paramString + ",lis:" + paramabvn);
    }
    if (paramabvn == null) {
      return;
    }
    String str = "";
    if ("apollo_aio_game.add_games_to_user_gamepanel".equals(paramString)) {
      if (0L == paramLong) {
        str = acfp.m(2131702495);
      }
    }
    for (;;)
    {
      paramabvn.ac(paramLong, str);
      return;
      str = acfp.m(2131702522);
      continue;
      if ("apollo_aio_game.del_games_from_user_gamepanel".equals(paramString)) {
        if (0L == paramLong) {
          str = acfp.m(2131702502);
        } else {
          str = acfp.m(2131702501);
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, new Object[] { "[startGameFromQRCode], url:", paramString });
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramActivity = paramString.split("\\?");
    } while ((paramActivity == null) || (paramActivity.length < 2));
    paramActivity = paramActivity[1];
    try
    {
      paramActivity = new JSONObject(URLDecoder.decode(paramActivity.substring(paramActivity.indexOf('=') + 1), "UTF-8"));
      int i = paramActivity.optInt("gameId");
      long l = paramActivity.optLong("roomId");
      paramString = paramActivity.optString("gameName");
      a(paramQQAppInterface, i, l, paramActivity.optInt("gameMode"), paramActivity.optString("extendInfo"), 220, paramString);
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
      QLog.w("ApolloGameUtil", 1, "[startGameFromQRCode], errInfo->" + paramActivity.getMessage());
    }
  }
  
  public static void a(Context paramContext, int paramInt, Intent paramIntent, String paramString, Bitmap paramBitmap, c paramc)
  {
    if ((paramContext == null) || (!(paramContext instanceof ApolloGameActivity)))
    {
      VipUtils.a(null, "cmshow", "Apollo", "pressSendToDesktopButton", 0, 1, new String[] { String.valueOf(paramInt) });
      a(paramIntent, paramString, paramBitmap, new abyf(paramc));
      return;
    }
    if (paramBitmap == null) {}
    try
    {
      paramBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130840732);
      int i = wja.dp2px(192.0F, paramContext.getResources());
      Bitmap localBitmap = paramBitmap;
      if (i != paramBitmap.getWidth()) {
        localBitmap = Bitmap.createScaledBitmap(paramBitmap, i, i, false);
      }
      ThreadManager.getUIHandler().post(new ApolloGameUtil.15(paramContext, paramInt, paramIntent, paramString, localBitmap, paramc));
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        QLog.e("ApolloGameUtil", 1, paramContext, new Object[0]);
        return;
      }
    }
    catch (OutOfMemoryError paramContext)
    {
      QLog.e("ApolloGameUtil", 1, paramContext, new Object[0]);
    }
  }
  
  public static void a(Context paramContext, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, new Object[] { " [startLightGame] context=", paramContext, ", StartCheckParam=", paramStartCheckParam });
    }
    if (l() == null) {
      if (!bGm)
      {
        b(paramContext, paramStartCheckParam);
        bGm = true;
        QLog.e("ApolloGameUtil", 1, "[startLightGame] sTopActivity is null");
      }
    }
    label388:
    label395:
    label396:
    for (;;)
    {
      return;
      QLog.e("ApolloGameUtil", 1, "[startLightGame] sTopActivity is still null");
      return;
      int i;
      if ((paramContext != null) && ((paramContext instanceof JumpActivity)))
      {
        i = 1;
        if (l() == null) {
          break label395;
        }
        paramContext = l();
      }
      for (;;)
      {
        if ((paramContext == null) || (paramStartCheckParam == null) || (!(paramContext instanceof Activity))) {
          break label396;
        }
        if ((i != 0) && (!(paramContext instanceof JumpActivity))) {
          finishJumpActivity(paramContext);
        }
        if (yl())
        {
          QLog.e("ApolloGameUtil", 1, "[startLightGame] x86 not support");
          return;
          i = 0;
          break;
        }
        paramStartCheckParam.startT = System.currentTimeMillis();
        AppInterface localAppInterface = abmt.getAppInterface();
        if (!(localAppInterface instanceof QQAppInterface))
        {
          QLog.e("ApolloGameUtil", 1, "not QQAppInterface");
          return;
        }
        QLog.d("CmGameStat", 1, new Object[] { "startLightGame, time=", Long.valueOf(SystemClock.uptimeMillis()) });
        Object localObject;
        if (!abhh.bCA)
        {
          QLog.i("ApolloGameUtil", 1, "startLightGame but apollo init first now");
          localObject = (abhh)localAppInterface.getManager(153);
          if (localObject == null)
          {
            QLog.e("ApolloGameUtil", 1, "apolloManager is null");
            return;
          }
          ((abhh)localObject).a(new abye(paramContext, localAppInterface, paramStartCheckParam, SystemClock.uptimeMillis()));
          localObject = new HashMap();
          ((HashMap)localObject).put("param_gameId", String.valueOf(paramStartCheckParam.gameId));
          ((HashMap)localObject).put("param_src", String.valueOf(paramStartCheckParam.src));
          if (!abhh.bCA) {
            break label388;
          }
        }
        for (paramStartCheckParam = "1";; paramStartCheckParam = "0")
        {
          ((HashMap)localObject).put("param_init", paramStartCheckParam);
          anpc.a(paramContext).collectPerformance(localAppInterface.getCurrentAccountUin(), "cmgame_data_init_check", true, 0L, 0L, (HashMap)localObject, "", false);
          QLog.d("CmGameStat", 1, new Object[] { "sInitedDone=", Boolean.valueOf(abhh.bCA) });
          return;
          a(paramContext, (QQAppInterface)localAppInterface, paramStartCheckParam);
          break;
        }
      }
    }
  }
  
  private static void a(Context paramContext, QQAppInterface paramQQAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((abxh.sP != null) && (abxh.sP.contains(Integer.valueOf(paramStartCheckParam.gameId)))) {
      paramStartCheckParam.enableMenu = false;
    }
    abow localabow = abmm.a().a(paramStartCheckParam.gameId);
    if (localabow != null) {
      localabow.a((Activity)paramContext, paramStartCheckParam);
    }
    if (a == null) {
      a = new CmStartTask(paramQQAppInterface, paramStartCheckParam);
    }
    for (;;)
    {
      ThreadManager.removeJobFromThreadPool(a, 16);
      ThreadManager.excute(a, 16, null, true);
      ctG = paramStartCheckParam.gameId;
      return;
      a.c(paramQQAppInterface, paramStartCheckParam);
    }
  }
  
  private static void a(Intent paramIntent, String paramString, Bitmap paramBitmap)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (paramBitmap == null) {}
    for (;;)
    {
      try
      {
        paramBitmap = BitmapFactory.decodeResource(localBaseApplication.getResources(), 2130840732);
        paramBitmap.setDensity(localBaseApplication.getResources().getDisplayMetrics().densityDpi);
        int i = aqho.O(localBaseApplication);
        if (i != paramBitmap.getWidth())
        {
          if (!aqoq.cVg)
          {
            paramBitmap = aqoo.a().createScaledBitmapByConfig(paramBitmap, i);
            paramIntent.setAction("com.tencent.apollo.SHORT_CUT");
            if (Build.VERSION.SDK_INT >= 26)
            {
              localObject = (ShortcutManager)localBaseApplication.getSystemService("shortcut");
              if ((localObject != null) && (((ShortcutManager)localObject).isRequestPinShortcutSupported())) {
                ((ShortcutManager)localObject).requestPinShortcut(new ShortcutInfo.Builder(localBaseApplication, "QQ" + paramString).setIcon(Icon.createWithBitmap(paramBitmap)).setShortLabel(paramString).setIntent(paramIntent).build(), PendingIntent.getBroadcast(localBaseApplication, 0, new Intent(localBaseApplication, WebProcessReceiver.class), 134217728).getIntentSender());
              }
            }
          }
          else
          {
            paramBitmap = Bitmap.createScaledBitmap(paramBitmap, i, i, false);
            continue;
          }
          Object localObject = new Intent();
          ((Intent)localObject).putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
          ((Intent)localObject).putExtra("android.intent.extra.shortcut.NAME", paramString);
          ((Intent)localObject).putExtra("android.intent.extra.shortcut.ICON", paramBitmap);
          ((Intent)localObject).putExtra("duplicate", false);
          ((Intent)localObject).setAction("com.android.launcher.action.INSTALL_SHORTCUT");
          localBaseApplication.sendOrderedBroadcast((Intent)localObject, null);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e("ApolloGameUtil", 1, paramIntent, new Object[0]);
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        QLog.e("ApolloGameUtil", 1, paramIntent, new Object[0]);
        return;
      }
    }
  }
  
  @TargetApi(26)
  public static void a(Intent paramIntent, String paramString, Bitmap paramBitmap, d paramd)
  {
    ThreadManager.excute(new ApolloGameUtil.17(BaseApplicationImpl.getApplication(), paramString, paramd, paramIntent, paramBitmap), 32, null, false);
  }
  
  private static void a(AppInterface paramAppInterface, Bundle paramBundle)
  {
    if ((paramAppInterface == null) || (paramBundle == null)) {
      return;
    }
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      EntityManager localEntityManager;
      int j;
      Object localObject3;
      Object localObject4;
      try
      {
        paramBundle = paramBundle.getByteArray("extra_data");
        localObject1 = new WebSSOAgent.UniSsoServerRsp();
        ((WebSSOAgent.UniSsoServerRsp)localObject1).mergeFrom(paramBundle);
        if (((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get() != 0L) {
          break;
        }
        paramBundle = ((WebSSOAgent.UniSsoServerRsp)localObject1).rspdata.get();
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameUtil", 2, "apolloGameReddot parseGameReddot, mRespStr:" + paramBundle);
        }
        paramBundle = new JSONObject(paramBundle).optJSONObject("data");
        if (paramBundle == null) {
          break;
        }
        localObject1 = paramBundle.optJSONArray("dotInfoList");
        localObject2 = paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getCurrentAccountUin() + "apollo_game_reddot_sp", 0).edit();
        localEntityManager = paramAppInterface.getEntityManagerFactory().createEntityManager();
        paramBundle = new ArrayList();
        i = 0;
        j = 0;
        if ((localObject1 == null) || (j >= ((JSONArray)localObject1).length())) {
          break label907;
        }
        localObject3 = ((JSONArray)localObject1).optJSONObject(j);
        k = i;
        if (localObject3 == null) {
          break label1125;
        }
        int n = ((JSONObject)localObject3).optInt("busId");
        localEntityManager.delete(ApolloGameRedDot.class.getSimpleName(), "mGameId=? ", new String[] { String.valueOf(n) });
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameUtil", 2, "apolloGameReddot parseGameReddot, em.delete，mGameId=" + n);
        }
        localObject4 = ((JSONObject)localObject3).getJSONArray("dotList");
        localObject3 = new ArrayList();
        k = 0;
        if ((localObject4 != null) && (k < ((JSONArray)localObject4).length()))
        {
          Object localObject5 = ((JSONArray)localObject4).optJSONObject(k);
          if (localObject5 == null) {
            break label1116;
          }
          int m = ((JSONObject)localObject5).optInt("dotId");
          Object localObject6;
          if (m == 1003)
          {
            localObject6 = new AioPushData();
            ((AioPushData)localObject6).begTs = ((JSONObject)localObject5).optInt("begTs");
            ((AioPushData)localObject6).busId = n;
            ((AioPushData)localObject6).busType = ((JSONObject)localObject5).optInt("busType");
            ((AioPushData)localObject6).dotId = ((JSONObject)localObject5).optInt("dotId");
            ((AioPushData)localObject6).endTs = ((JSONObject)localObject5).optInt("endTs");
            ((AioPushData)localObject6).priority = ((JSONObject)localObject5).optInt("priority");
            ((AioPushData)localObject6).them = ((JSONObject)localObject5).optString("theme");
            ((AioPushData)localObject6).wording = ((JSONObject)localObject5).optString("wording");
            ((AioPushData)localObject6).url = ((JSONObject)localObject5).optString("url");
            ((AioPushData)localObject6).actId = ((JSONObject)localObject5).optString("actId");
            ((AioPushData)localObject6).folderIconUrl = ((JSONObject)localObject5).optString("folderIconUrl");
            ((AioPushData)localObject6).spRegion = ((JSONObject)localObject5).optInt("spRegion");
            ((List)localObject3).add(localObject6);
          }
          else
          {
            localObject6 = new ApolloGameRedDot();
            ((ApolloGameRedDot)localObject6).mDotId = m;
            ((ApolloGameRedDot)localObject6).mStartTime = ((JSONObject)localObject5).optInt("begTs");
            ((ApolloGameRedDot)localObject6).mEndTime = ((JSONObject)localObject5).optInt("endTs");
            ((ApolloGameRedDot)localObject6).mTipsWording = ((JSONObject)localObject5).optString("wording");
            ((ApolloGameRedDot)localObject6).mGameId = n;
            ((ApolloGameRedDot)localObject6).mUrl = ((JSONObject)localObject5).optString("url");
            ((ApolloGameRedDot)localObject6).mActId = ((JSONObject)localObject5).optString("actId");
            ((ApolloGameRedDot)localObject6).mPriority = ((JSONObject)localObject5).optInt("priority");
            ((ApolloGameRedDot)localObject6).mSpRegion = ((JSONObject)localObject5).optInt("spRegion");
            localObject5 = (acfs)paramAppInterface.getManager(255);
            ((abxk)paramAppInterface.getManager(155)).a(((ApolloGameRedDot)localObject6).mGameId);
            VipUtils.a(null, "cmshow", "Apollo", "get_notice", m, 0, new String[] { String.valueOf(n), "", ((ApolloGameRedDot)localObject6).mActId });
            if (ApolloGameRedDot.isValidReddotId(m)) {
              if (!((ApolloGameRedDot)localObject6).isTimeValid())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloGameUtil", 2, "apolloGameReddot parseGameReddot, apolloGameRedDot.isTimeValid():false," + localObject6);
                }
              }
              else
              {
                paramBundle.add(localObject6);
                localEntityManager.persistOrReplace((Entity)localObject6);
                ((SharedPreferences.Editor)localObject2).putBoolean(a((ApolloGameRedDot)localObject6), false);
                m = 1;
                i = m;
                if (QLog.isColorLevel())
                {
                  QLog.d("ApolloGameUtil", 2, "apolloGameReddot parseGameReddot, saveApolloGameRedDot:" + localObject6);
                  i = m;
                }
              }
            }
          }
        }
      }
      catch (Throwable paramAppInterface)
      {
        QLog.e("ApolloGameUtil", 1, "apolloGameReddot checkApolloGameRedDot failed ", paramAppInterface);
        return;
      }
      c(localEntityManager);
      int k = i;
      if (((List)localObject3).size() > 0)
      {
        localObject4 = (abxk)paramAppInterface.getManager(155);
        if (localObject4 != null)
        {
          ((abxk)localObject4).O((List)localObject3, 1);
          k = i;
        }
        else
        {
          QLog.e("ApolloGameUtil", 1, "[parseGameReddot] do manager is null");
          k = i;
          break label1125;
          label907:
          if (i != 0)
          {
            ((SharedPreferences.Editor)localObject2).commit();
            localObject1 = a(paramAppInterface, paramBundle);
            if (localObject1 != null)
            {
              localObject2 = new DrawerPushItem();
              ((DrawerPushItem)localObject2).msg_type = 4;
              ((DrawerPushItem)localObject2).is_reddot = 1;
              ((DrawerPushItem)localObject2).msg_id = a((ApolloGameRedDot)localObject1);
              ((DrawerPushItem)localObject2).priority = 1000;
              ((DrawerPushItem)localObject2).sub_priority = 1000;
              ((DrawerPushItem)localObject2).start_ts = ((ApolloGameRedDot)localObject1).mStartTime;
              ((DrawerPushItem)localObject2).end_ts = ((ApolloGameRedDot)localObject1).mEndTime;
              ((DrawerPushItem)localObject2).send_time = ((int)(System.currentTimeMillis() / 1000L));
              ((DrawerPushItem)localObject2).content = ((ApolloGameRedDot)localObject1).mTipsWording;
              ((DrawerPushItem)localObject2).show_counts = 1;
              ((DrawerPushItem)localObject2).reddotGameId = ((ApolloGameRedDot)localObject1).mGameId;
              ((DrawerPushItem)localObject2).reddotRedId = ((ApolloGameRedDot)localObject1).mDotId;
              ((abhh)paramAppInterface.getManager(153)).a((DrawerPushItem)localObject2, false);
              if (QLog.isColorLevel()) {
                QLog.d("ApolloGameUtil", 2, "apolloGameReddot parseGameReddot, apolloManager.addPushItem");
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloGameUtil", 2, "apolloGameReddot parseGameReddot, redDotsList.size:" + paramBundle.size());
          return;
          label1116:
          k += 1;
          continue;
        }
      }
      label1125:
      j += 1;
      int i = k;
    }
  }
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (paramAppInterface != null) {
      if (!paramBoolean) {
        break label30;
      }
    }
    label30:
    for (int i = 0;; i = 1)
    {
      VipUtils.a(paramAppInterface, "cmshow", "Apollo", "clk_shortcut", 0, i, new String[0]);
      return;
    }
  }
  
  public static void a(BaseChatPie paramBaseChatPie, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.getApp() == null) || (paramBaseChatPie.a() == null) || (paramBaseChatPie.a() == null))
    {
      QLog.e("ApolloGameUtil", 1, new Object[] { "aio startLightGame failed gameId:", Integer.valueOf(paramInt1), ",from:", paramString });
      return;
    }
    paramString = new CmGameStartChecker.StartCheckParam(paramInt1, true, paramString, 0L, paramInt3, 0, paramBaseChatPie.sessionInfo.cZ, a(paramBaseChatPie.getApp(), paramBaseChatPie.sessionInfo.cZ, paramBaseChatPie.sessionInfo.aTl), paramBaseChatPie.sessionInfo.aTl, paramInt2, null);
    a(paramBaseChatPie.a(), paramString);
  }
  
  public static void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, FragmentActivity paramFragmentActivity, int paramInt1, ApolloFragment paramApolloFragment, int paramInt2, WebGameFakeView paramWebGameFakeView, String paramString)
  {
    if (paramStartCheckParam == null) {}
    Object localObject1;
    Object localObject2;
    Object localObject3;
    do
    {
      for (;;)
      {
        return;
        try
        {
          localObject1 = abxi.bim + "/game/" + String.valueOf(paramInt1) + "/" + jdMethod_do(paramStartCheckParam.mGameType);
          localObject2 = new File((String)localObject1);
          if (((File)localObject2).exists()) {
            if (abya.c(paramStartCheckParam.isWhiteUsr, paramInt1))
            {
              localObject3 = new abya(paramInt1);
              paramStartCheckParam = jdMethod_do(paramStartCheckParam.mGameType);
              ((abya)localObject3).Zq();
              if ((!((abya)localObject3).jH(paramStartCheckParam)) || (!((abya)localObject3).as((String)localObject1, paramStartCheckParam)))
              {
                QLog.e("ApolloGameUtil", 1, "[launchWebGame] failed for invalid config");
                abmt.Hw(paramInt1);
                abmt.x(new Object[] { "[launchWebGame], failed for invalid config" });
                return;
              }
            }
          }
        }
        catch (Throwable paramStartCheckParam)
        {
          QLog.e("ApolloGameUtil", 1, paramStartCheckParam, new Object[0]);
          return;
        }
      }
      paramStartCheckParam = aqhq.readFileContent((File)localObject2);
    } while (TextUtils.isEmpty(paramStartCheckParam));
    JSONObject localJSONObject = new JSONObject(paramStartCheckParam);
    paramStartCheckParam = localJSONObject.optString("enterPath");
    if (!TextUtils.isEmpty(paramStartCheckParam))
    {
      localObject2 = abxi.bim + "/game/" + String.valueOf(paramInt1) + "/" + paramStartCheckParam;
      paramStartCheckParam = "file://" + (String)localObject2;
    }
    for (;;)
    {
      localObject3 = localJSONObject.optString("enterUrl");
      localObject1 = paramStartCheckParam;
      if (TextUtils.isEmpty(paramStartCheckParam)) {
        localObject1 = localObject3;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      if (URLUtil.isNetworkUrl((String)localObject1)) {}
      do
      {
        paramStartCheckParam = "&";
        if (!((String)localObject1).contains("?")) {
          paramStartCheckParam = "?";
        }
        localObject1 = (String)localObject1 + paramStartCheckParam + "apollo_bk" + "=1";
        paramString = ablp.iz(paramString);
        paramStartCheckParam = (CmGameStartChecker.StartCheckParam)localObject1;
        if (!TextUtils.isEmpty(paramString)) {
          paramStartCheckParam = (String)localObject1 + "&" + paramString;
        }
        able.a().a(paramFragmentActivity, 2131367885);
        paramString = new Intent();
        paramString.putExtra("url", paramStartCheckParam);
        if ((paramApolloFragment == null) || (!paramApolloFragment.isAdded()) || (!(paramApolloFragment instanceof ApolloWebViewFragment))) {
          break label572;
        }
        WebAccelerateHelper.getInstance().preCheckOffline(paramStartCheckParam);
        WebAccelerateHelper.getInstance().preFetchResource(paramStartCheckParam);
        if (paramFragmentActivity.isFinishing()) {
          break;
        }
        abll.a().destroy();
        paramFragmentActivity.runOnUiThread(new ApolloGameUtil.9(paramApolloFragment, paramStartCheckParam));
        return;
        if (!URLUtil.isFileUrl((String)localObject1)) {
          break;
        }
        paramStartCheckParam = new File((String)localObject2);
      } while ((paramStartCheckParam.exists()) && (paramStartCheckParam.getAbsolutePath().startsWith(abxi.bim + "/game/" + String.valueOf(paramInt1))));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloGameUtil", 2, (String)localObject2);
      return;
      label572:
      paramApolloFragment = new WebGameFakeView.Director();
      localObject1 = localJSONObject.optJSONObject("ui");
      if (localObject1 != null)
      {
        localObject2 = ((JSONObject)localObject1).optString(WebGameFakeView.Director.TITLE);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramApolloFragment.title = ((String)localObject2);
        }
        localObject2 = ((JSONObject)localObject1).optString(WebGameFakeView.Director.FOREGROUND_COLOR);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramApolloFragment.frontColor = ((String)localObject2);
        }
        localObject1 = ((JSONObject)localObject1).optString(WebGameFakeView.Director.BACKGROUND_COLOR);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramApolloFragment.bgColor = ((String)localObject1);
        }
      }
      if (paramWebGameFakeView != null)
      {
        paramWebGameFakeView.a = paramApolloFragment;
        paramWebGameFakeView.cCX();
      }
      paramString.putExtra("Director", paramApolloFragment);
      paramString.putExtra("game_busid", String.valueOf(paramInt1));
      able.a(paramFragmentActivity, paramString);
      WebAccelerateHelper.getInstance().preGetKey(paramStartCheckParam, paramString, null);
      WebAccelerateHelper.getInstance().preCheckOffline(paramStartCheckParam);
      WebAccelerateHelper.getInstance().preFetchResource(paramStartCheckParam);
      return;
      localObject2 = "";
    }
  }
  
  public static void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, boolean paramBoolean)
  {
    if (paramStartCheckParam == null) {
      return;
    }
    BaseApplicationImpl.getApplication().getSharedPreferences("start_cm_game", 4).edit().putBoolean(String.valueOf(paramStartCheckParam.mCreateTs) + "_start_flag", paramBoolean).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      return;
      QLog.i("ApolloGameUtil", 1, "[launchGameFromOtherWay], src:" + paramInt3 + ",gameId:" + paramInt1 + ",gameMode:" + paramInt2);
      paramQQAppInterface = "";
      boolean bool = false;
      int i = -1;
      if (paramInt3 == 204)
      {
        paramQQAppInterface = "wechat";
        bool = false;
        i = 2;
      }
      while (BaseActivity.sTopActivity != null)
      {
        paramQQAppInterface = new CmGameStartChecker.StartCheckParam(paramInt1, bool, paramQQAppInterface, paramLong, i, paramInt2, 0, 0, "", paramInt3, paramString2);
        paramQQAppInterface.extendJson = paramString1;
        a(l(), paramQQAppInterface);
        return;
        if (paramInt3 == 220)
        {
          paramQQAppInterface = "qrcode";
          bool = true;
          i = 8;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    ThreadManagerV2.excute(new ApolloGameUtil.5(paramQQAppInterface, paramInt, paramBoolean), 32, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (paramStartCheckParam == null) {}
    do
    {
      return;
      if (!abmt.hP(paramStartCheckParam.gameId)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloGameUtil", 2, "the game is IsLand");
    return;
    Object localObject = abmm.a().a();
    if (localObject != null)
    {
      localObject = ((abox)localObject).a(paramStartCheckParam.gameId);
      if (localObject != null) {
        ((abow)localObject).o(paramStartCheckParam);
      }
    }
    ThreadManager.excute(new ApolloGameUtil.22(paramQQAppInterface, paramStartCheckParam), 32, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, a parama)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null))
    {
      parama.xz(false);
      return;
    }
    if (!abhh.bCA)
    {
      ((abhh)paramQQAppInterface.getManager(153)).a(new abyg(parama, paramQQAppInterface));
      return;
    }
    parama.xz(ab(paramQQAppInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, b paramb)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null))
    {
      paramb.xy(false);
      return;
    }
    if (!abhh.bCA)
    {
      ((abhh)paramQQAppInterface.getManager(153)).a(new abyh(paramb));
      return;
    }
    paramb.xy(true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ApolloPanel.b paramb, SessionInfo paramSessionInfo)
  {
    if ((paramb == null) || (paramQQAppInterface == null) || (paramSessionInfo == null))
    {
      QLog.e("cmgame.sendmsg", 1, "[sendGameMsg], errInfo->param is null.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame.sendmsg", 2, new Object[] { "[sendGameMsg], gameId:", Integer.valueOf(paramb.gameId), ",roomId:", Long.valueOf(paramb.roomId), ",extendInfo:", paramb.gameExtendJson });
    }
    ApolloMessage localApolloMessage = new ApolloMessage();
    if (!TextUtils.isEmpty(paramb.actionName)) {
      localApolloMessage.name = paramb.actionName.getBytes();
    }
    if (0 == 0) {}
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("gameId", paramb.gameId);
        ((JSONObject)localObject).put("gameMode", paramb.gameMode);
        ((JSONObject)localObject).put("roomid", paramb.roomId);
        if (paramb.gameId == 1)
        {
          ((JSONObject)localObject).put("msgTyep", 2);
          ((JSONObject)localObject).put("gameName", paramb.gameName);
          if (!TextUtils.isEmpty(paramb.gameExtendJson)) {
            ((JSONObject)localObject).put("gameExtendJson", paramb.gameExtendJson);
          }
          if (localObject != null) {
            localApolloMessage.extStr = ((JSONObject)localObject).toString();
          }
          localObject = ((abhh)paramQQAppInterface.getManager(153)).b(paramQQAppInterface.getCurrentAccountUin());
          localApolloMessage.sender_ts = aqft.ag(((ApolloBaseInfo)localObject).apolloServerTS);
          localApolloMessage.sender_status = ((ApolloBaseInfo)localObject).apolloStatus;
          localObject = ((abxk)paramQQAppInterface.getManager(155)).a(paramb.gameId);
          if ((localObject == null) || (1 != ((ApolloGameData)localObject).hasOwnArk)) {
            break label462;
          }
          i = 297;
          localApolloMessage.flag = (i | 0x200);
          paramSessionInfo = anbi.a(paramQQAppInterface, paramSessionInfo.aTl, paramSessionInfo.troopUin, paramSessionInfo.cZ, localApolloMessage);
          if (paramb.gameId == 1)
          {
            paramSessionInfo.msgType = 2;
            paramSessionInfo.gameId = paramb.gameId;
            paramSessionInfo.mGameMode = paramb.gameMode;
            paramSessionInfo.roomId = paramb.roomId;
            paramSessionInfo.mApolloMessage.id = paramb.actionId;
            paramSessionInfo.gameName = paramb.gameName;
            paramSessionInfo.gameExtendJson = paramb.gameExtendJson;
            paramQQAppInterface.b().a(paramSessionInfo, null);
          }
        }
        else
        {
          ((JSONObject)localObject).put("msgTyep", paramb.msgType);
          continue;
        }
        paramSessionInfo.msgType = paramb.msgType;
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.d("cmgame.sendmsg", 2, paramQQAppInterface, new Object[0]);
        return;
      }
      continue;
      label462:
      int i = 41;
      continue;
      Object localObject = null;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ApolloGameRankData paramApolloGameRankData)
  {
    if ((paramQQAppInterface != null) && (paramApolloGameRankData != null)) {
      ThreadManager.post(new ApolloGameUtil.8(paramQQAppInterface, paramApolloGameRankData), 8, null, false);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo)
  {
    if (paramMessageForApollo == null) {
      return;
    }
    Object localObject = paramMessageForApollo.mApolloMessage;
    JSONObject localJSONObject;
    JSONArray localJSONArray;
    Iterator localIterator;
    try
    {
      localJSONObject = new JSONObject(((ApolloMessage)localObject).extStr);
      localJSONObject.put("gameStatus", paramMessageForApollo.gameStatus);
      localJSONObject.put("roomVol", paramMessageForApollo.roomVol);
      localJSONObject.put("gmUpdateStamp", paramMessageForApollo.gameStatusStamp);
      localJSONObject.put("gameMode", paramMessageForApollo.mGameMode);
      localJSONObject.put("arkInfo", paramMessageForApollo.gameArkInfo);
      localJSONObject.put("commInfo", paramMessageForApollo.commInfo);
      localJSONArray = new JSONArray();
      localIterator = paramMessageForApollo.playerList.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put((Long)localIterator.next());
      }
      localJSONObject.put("playerList", localJSONArray);
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      QLog.e("ApolloGameUtil", 1, "fail to update game in db, errInfo->" + paramQQAppInterface.getMessage());
      return;
    }
    switch (paramMessageForApollo.gameStatus)
    {
    }
    for (;;)
    {
      ((ApolloMessage)localObject).extStr = localJSONObject.toString();
      localObject = aczw.b((Serializable)localObject);
      paramQQAppInterface.b().c(paramMessageForApollo.frienduin, paramMessageForApollo.istroop, paramMessageForApollo.uniseq, (byte[])localObject);
      return;
      localJSONObject.put("winUin", paramMessageForApollo.winnerUin);
      localJSONObject.put("winRecord", paramMessageForApollo.winRecord);
      localJSONObject.put("gameOverType", paramMessageForApollo.overType);
      localJSONArray = new JSONArray();
      localIterator = paramMessageForApollo.winnerList.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put((Long)localIterator.next());
      }
      localJSONObject.put("winnerList", localJSONArray);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, "winnerArray:" + localJSONArray);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo, WeakReference<XListView> paramWeakReference, WeakReference<wki> paramWeakReference1, Bundle paramBundle)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramWeakReference1 = ((abhe)paramQQAppInterface.getManager(211)).a();
    if (paramWeakReference1 != null) {
      paramWeakReference1.e(paramMessageForApollo);
    }
    ThreadManager.getUIHandler().post(new ApolloGameUtil.1(paramWeakReference, paramMessageForApollo, paramBundle, paramQQAppInterface));
  }
  
  public static void a(EntityManager paramEntityManager, int paramInt1, int paramInt2)
  {
    if (paramEntityManager == null) {
      return;
    }
    int i = paramEntityManager.delete(ApolloGameRedDot.class.getSimpleName(), "mGameId=? and mDotId=? ", new String[] { String.valueOf(paramInt1), String.valueOf(paramInt2) });
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, "apolloGameReddot deleteGameReddot, gameId:" + paramInt1 + ",reddotId:" + paramInt2 + ",ret:" + i);
    }
    c(paramEntityManager);
  }
  
  public static void a(EntityManager paramEntityManager, boolean paramBoolean)
  {
    if (paramEntityManager == null) {
      return;
    }
    paramBoolean = paramEntityManager.update("update ApolloGameRedDot set mIsShowForFolder = 1");
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, new Object[] { "update ApolloGameRedDot set mIsShowForFolder=true", Boolean.valueOf(paramBoolean) });
    }
    c(paramEntityManager);
  }
  
  public static void a(String paramString, int paramInt, Context paramContext)
  {
    ThreadManager.getUIHandler().post(new ApolloGameUtil.21(paramContext, paramInt, paramString));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo, long paramLong)
  {
    if ((paramMessageForApollo == null) || (paramQQAppInterface == null)) {
      return false;
    }
    if (!ib(paramMessageForApollo.msgType)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, new Object[] { "[isMsgNeedPull], msg:", Long.valueOf(paramMessageForApollo.msgseq), ",roomId:", Long.valueOf(paramMessageForApollo.roomId), ",msg.msgType:", Integer.valueOf(paramMessageForApollo.msgType) });
    }
    if (paramMessageForApollo.msgType == 4) {
      return false;
    }
    if (paramMessageForApollo.roomId == 0L) {
      return false;
    }
    if (paramMessageForApollo.istroop == 1036) {
      return false;
    }
    paramQQAppInterface = ((abxk)paramQQAppInterface.getManager(155)).a(paramMessageForApollo.gameId);
    if (paramQQAppInterface == null) {
      return false;
    }
    if (!abxh.l("3.4.4", paramQQAppInterface.minVer, paramQQAppInterface.maxVer)) {
      return false;
    }
    boolean bool1;
    boolean bool2;
    label203:
    boolean bool3;
    if (paramMessageForApollo.gameStatusStamp < paramLong)
    {
      bool1 = true;
      if ((paramMessageForApollo.gameStatus != 4) && (paramMessageForApollo.gameStatus != 7) && (paramMessageForApollo.gameStatus != 8)) {
        break label398;
      }
      bool2 = true;
      if (paramMessageForApollo.gameStatus != 5) {
        break label404;
      }
      bool3 = true;
      label214:
      if (paramMessageForApollo.gameStatus != 6) {
        break label410;
      }
    }
    label398:
    label404:
    label410:
    for (boolean bool4 = true;; bool4 = false)
    {
      if ((!bool1) || (bool2) || (bool3) || (bool4)) {
        break label416;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, new Object[] { "RoomId ", Long.valueOf(paramMessageForApollo.roomId), " needs pulling from srv,isTimeOverdue:", Boolean.valueOf(bool1), ",isOver:", Boolean.valueOf(bool2), ",isCancel:", Boolean.valueOf(bool4), ",isInValidStatus:", Boolean.valueOf(bool3), ",msg.gameStatusStamp:", Long.valueOf(paramMessageForApollo.gameStatusStamp), ",mCreateTime:", Long.valueOf(paramLong), ",msg.gameStatus:", Integer.valueOf(paramMessageForApollo.gameStatus) });
      }
      return true;
      bool1 = false;
      break;
      bool2 = false;
      break label203;
      bool3 = false;
      break label214;
    }
    label416:
    if ((paramMessageForApollo.gameStatus == 1) || (paramMessageForApollo.gameStatus == 3) || (paramMessageForApollo.gameStatus == 2))
    {
      paramLong = NetConnInfoCenter.getServerTimeMillis() - paramMessageForApollo.gameStatusStamp;
      if (paramLong >= 180000L)
      {
        QLog.i("ApolloGameUtil", 1, "handle process-killing case, querySlice:" + 180000L + ",delta:" + paramLong + ",roomId:" + paramMessageForApollo.roomId);
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo, WeakReference<XListView> paramWeakReference, WeakReference<wki> paramWeakReference1)
  {
    if ((paramQQAppInterface == null) || (paramMessageForApollo == null))
    {
      QLog.e("ApolloGameUtil", 1, "[updateMsgInCacheAndDB], errInfo->param error");
      return false;
    }
    Object localObject = a(paramQQAppInterface, paramMessageForApollo.roomId, paramMessageForApollo.frienduin, paramMessageForApollo.istroop);
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      QLog.i("ApolloGameUtil", 1, "no msg with the same roomid");
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MessageForApollo localMessageForApollo = (MessageForApollo)((Iterator)localObject).next();
      if ((localMessageForApollo != null) && (a(paramMessageForApollo, localMessageForApollo)))
      {
        localMessageForApollo.updateGameStatus(paramMessageForApollo);
        a(paramQQAppInterface, localMessageForApollo, paramWeakReference, paramWeakReference1, null);
        a(paramQQAppInterface, localMessageForApollo);
      }
    }
    return true;
  }
  
  public static boolean a(MessageForApollo paramMessageForApollo1, MessageForApollo paramMessageForApollo2)
  {
    if ((paramMessageForApollo1 == null) || (paramMessageForApollo2 == null)) {
      return false;
    }
    if (paramMessageForApollo1.gameStatusStamp < paramMessageForApollo2.gameStatusStamp)
    {
      QLog.i("ApolloGameUtil", 1, "[Invalid status], new status is actually older than old status, new.stamp:" + paramMessageForApollo1.gameStatusStamp + ",old.stamp:" + paramMessageForApollo2.gameStatusStamp + ",roomId:" + paramMessageForApollo2.roomId);
      return false;
    }
    if (((paramMessageForApollo2.gameStatus == 4) && (!TextUtils.isEmpty(paramMessageForApollo2.winRecord))) || (paramMessageForApollo2.gameStatus == 5) || (paramMessageForApollo2.gameStatus == 6) || (paramMessageForApollo2.gameStatus == 7) || (paramMessageForApollo2.gameStatus == 8))
    {
      QLog.i("ApolloGameUtil", 1, "[Invalid status], game was over, roomId:" + paramMessageForApollo2.roomId);
      return false;
    }
    if ((paramMessageForApollo2.gameStatus == 3) && ((paramMessageForApollo1.gameStatus == 1) || (paramMessageForApollo1.gameStatus == 2)))
    {
      QLog.i("ApolloGameUtil", 1, "[Invalid status], game has started, roomId:" + paramMessageForApollo2.roomId);
      return false;
    }
    return true;
  }
  
  public static boolean aa(QQAppInterface paramQQAppInterface)
  {
    return x(paramQQAppInterface) == 2;
  }
  
  public static boolean ab(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    abhh localabhh = (abhh)paramQQAppInterface.getManager(153);
    if ((Z(paramQQAppInterface)) && (localabhh.bCD)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, new Object[] { "isGameCityUser read in cache status:", Boolean.valueOf(bool), ", newStoreUser:", Boolean.valueOf(localabhh.bCD) });
      }
      return bool;
    }
  }
  
  public static int as(int paramInt1, int paramInt2)
  {
    if (cf == null) {
      cf = new SparseArray();
    }
    for (int i = -2;; i = ((Integer)cf.get(paramInt1, Integer.valueOf(-2))).intValue())
    {
      int j = i;
      Object localObject;
      if (i == -2)
      {
        localObject = new File(abxi.bim + "/game/" + String.valueOf(paramInt1) + "/" + jdMethod_do(paramInt2));
        if (!((File)localObject).exists()) {}
      }
      else
      {
        try
        {
          localObject = new JSONObject(aqhq.readFileContent((File)localObject));
          if (!((JSONObject)localObject).has("viewMode")) {
            break label177;
          }
          j = ((JSONObject)localObject).optInt("viewMode") - 1;
          cf.put(paramInt1, Integer.valueOf(j));
          return j;
        }
        catch (Throwable localThrowable)
        {
          QLog.e("ApolloGameUtil", 1, localThrowable, new Object[] { "[getGameViewMode]" });
        }
      }
    }
    label177:
    return -1;
  }
  
  public static ArrayList<MessageForApollo> b(List<MessageRecord> paramList, long paramLong)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.i("ApolloGameUtil", 2, "msgRcd size is 0.");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      Object localObject = (MessageRecord)paramList.get(i);
      if (!(localObject instanceof MessageForApollo)) {}
      for (;;)
      {
        i -= 1;
        break;
        localObject = (MessageForApollo)localObject;
        if (((MessageForApollo)localObject).roomId == paramLong) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public static void b(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, new Object[] { "[getOpenIdAndAccessToken], url:", paramString });
    }
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {}
    for (;;)
    {
      return;
      TicketManager localTicketManager = (TicketManager)paramQQAppInterface.getManager(2);
      if (localTicketManager != null)
      {
        paramActivity = paramQQAppInterface.getAccount();
        paramQQAppInterface = localTicketManager.getSkey(paramQQAppInterface.getAccount());
        if ((paramActivity != null) && (paramQQAppInterface != null) && (paramQQAppInterface.length() != 0))
        {
          paramString = paramString.split("\\?");
          if ((paramString != null) && (paramString.length >= 2))
          {
            paramString = paramString[1];
            try
            {
              paramString = new JSONObject(URLDecoder.decode(paramString.substring(paramString.indexOf('=') + 1), "UTF-8"));
              int i = paramString.optInt("token");
              int j = paramString.optInt("gameId");
              long l = paramString.optLong("appId");
              if (SplashActivity.dO != null)
              {
                paramString = (Activity)SplashActivity.dO.get();
                tzk.prepare();
                paramString = tzk.a(paramString, 5, String.valueOf(l));
                if (paramString == null) {
                  continue;
                }
                paramString.a("login", null, new abyj(i, j, paramActivity, paramQQAppInterface));
              }
            }
            catch (Exception paramActivity)
            {
              QLog.e("ApolloGameUtil", 2, " get openip and accesstoken exeption");
              return;
            }
          }
        }
      }
    }
    QLog.e("ApolloGameUtil", 2, "get openId and accessToken login failed");
  }
  
  public static void b(Context paramContext, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (paramContext == null)
    {
      QLog.e("ApolloGameUtil", 1, "startSplashActivity context is null");
      return;
    }
    Intent localIntent = new Intent(BaseApplication.getContext(), SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("tab_index", MainFragment.bIk);
    localIntent.addFlags(134283264);
    paramContext.startActivity(localIntent);
    ((Activity)paramContext).overridePendingTransition(0, 0);
    ThreadManagerV2.getUIHandlerV2().postDelayed(new ApolloGameUtil.11(paramContext, paramStartCheckParam), 2000L);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt)
  {
    if ((paramQQAppInterface != null) && (paramSessionInfo != null) && (ablf.b("aio.city.game", paramQQAppInterface) == ablg.cpH)) {
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "more_game_enter_exposure", ApolloUtil.a(paramSessionInfo, paramQQAppInterface), 0, new String[] { String.valueOf(paramInt) });
    }
    if ((paramQQAppInterface != null) && (paramSessionInfo != null)) {
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "game_show", ApolloUtil.gi(paramSessionInfo.cZ), 0, new String[] { "0" });
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramQQAppInterface == null) || (paramStartCheckParam == null)) {
      return;
    }
    ThreadManager.post(new ApolloGameUtil.23(paramQQAppInterface, paramStartCheckParam), 5, null, true);
  }
  
  @TargetApi(26)
  public static void bW(int paramInt, String paramString)
  {
    a(paramInt, paramString, null);
  }
  
  public static void bX(int paramInt, String paramString)
  {
    ThreadManager.excute(new ApolloGameUtil.16(paramString, paramInt), 64, null, true);
  }
  
  public static void c(AppInterface paramAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, new Object[] { "[saveGameCoinCount] app=", paramAppInterface, ", gameCoinCount=", Integer.valueOf(paramInt) });
    }
    if (paramAppInterface == null) {
      return;
    }
    BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 4).edit().putInt("sp_key_apollo_game_life" + paramAppInterface.getCurrentAccountUin(), paramInt).commit();
  }
  
  public static void c(EntityManager paramEntityManager)
  {
    if (paramEntityManager != null)
    {
      ThreadManager.post(new ApolloGameUtil.3(paramEntityManager), 5, null, true);
      return;
    }
    QLog.e("ApolloGameUtil", 1, "[loadCache] em is null out ");
  }
  
  public static void cGk()
  {
    try
    {
      Object localObject = BaseActivity.sTopActivity;
      if ((localObject != null) && (!((Activity)localObject).isFinishing()) && ((localObject instanceof FragmentActivity)))
      {
        localObject = ((FragmentActivity)localObject).getChatFragment();
        if ((localObject != null) && (((ChatFragment)localObject).isAdded()))
        {
          localObject = ((ChatFragment)localObject).a();
          if ((localObject != null) && (!(localObject instanceof xxh)))
          {
            localObject = ((BaseChatPie)localObject).a;
            if (localObject != null) {
              ((ApolloPanel)localObject).cGk();
            }
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameUtil", 1, localThrowable, new Object[0]);
    }
  }
  
  public static void cGl()
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("start_cm_game", 4).edit().clear().commit();
  }
  
  public static void cGm()
  {
    if ((a != null) && (a.fV != null) && (a.fV.get() != null) && (((CmGameStartChecker.StartCheckParam)a.fV.get()).gameId == ctG))
    {
      QLog.i("ApolloGameUtil", 1, "get game data and restartGameTask, gameId:" + ctG);
      ThreadManager.removeJobFromThreadPool(a, 16);
      ThreadManager.excute(a, 16, null, true);
      ctG = 0;
    }
  }
  
  public static int d(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return 0;
    }
    return BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getInt("sp_key_apollo_game_life" + paramAppInterface.getCurrentAccountUin(), 0);
  }
  
  public static void d(long paramLong, QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    ThreadManager.post(new ApolloGameUtil.4(paramString, paramQQAppInterface, paramLong), 5, null, true);
  }
  
  public static boolean d(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (paramStartCheckParam == null) {
      return false;
    }
    long l = System.currentTimeMillis();
    boolean bool = BaseApplicationImpl.getApplication().getSharedPreferences("start_cm_game", 4).getBoolean(String.valueOf(paramStartCheckParam.mCreateTs) + "_start_flag", false);
    if ((QLog.isColorLevel()) || (bool)) {
      QLog.e("ApolloGameUtil", 1, new Object[] { "cmgame_isStartGameCancel:", Boolean.valueOf(bool), " use:", Long.valueOf(System.currentTimeMillis() - l) });
    }
    return bool;
  }
  
  public static String jdMethod_do(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "gameConfig.json";
    }
    return "appConfig.json";
  }
  
  public static void e(EntityManager paramEntityManager, List<ApolloGameRedDot> paramList)
  {
    if ((paramEntityManager != null) && (paramList != null) && (paramList.size() > 0))
    {
      Collections.sort(paramList);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ApolloGameRedDot localApolloGameRedDot = (ApolloGameRedDot)paramList.next();
        if (localApolloGameRedDot != null)
        {
          localApolloGameRedDot.mIsShow = true;
          paramEntityManager.update(localApolloGameRedDot);
        }
      }
      c(paramEntityManager);
    }
  }
  
  public static void finishJumpActivity(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, "send broadcast to finish jump activity");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("BroadcastReceiverFinishActivity");
    paramContext.sendBroadcast(localIntent);
  }
  
  public static long g(QQAppInterface paramQQAppInterface)
  {
    long l1 = 0L;
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      return l1;
      try
      {
        SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
        if (localSharedPreferences == null) {
          continue;
        }
        long l2 = localSharedPreferences.getLong("apollo_game_roam_ts_v2_" + paramQQAppInterface.getCurrentAccountUin(), 0L);
        l1 = l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloGameUtil", 2, "[getGameRoamTS], ts:" + l2);
        l1 = l2;
      }
      finally {}
    }
  }
  
  public static int gg(int paramInt)
  {
    int i = 1;
    Object localObject = new File(abxi.bim + "/game/" + String.valueOf(paramInt) + "/gameConfig.json");
    File localFile = new File(abxi.bim + "/game/" + String.valueOf(paramInt) + "/appConfig.json");
    if (((File)localObject).exists())
    {
      localObject = aqhq.readFileContent((File)localObject);
      paramInt = i;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = new JSONObject((String)localObject).optString("enterUrl");
          paramInt = i;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            return paramInt;
          }
          if (((String)localObject).contains("urlshare.cn")) {
            return 4;
          }
          boolean bool = ((String)localObject).contains("_bkfv=5");
          if (bool) {
            return 5;
          }
          return 2;
        }
        catch (Throwable localThrowable)
        {
          QLog.e("ApolloGameUtil", 1, localThrowable, new Object[0]);
          return 1;
        }
      }
    }
    else
    {
      paramInt = i;
      if (localFile.exists()) {
        paramInt = 3;
      }
    }
    return paramInt;
  }
  
  public static boolean h(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = ((abxk)paramQQAppInterface.getManager(155)).dN();
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = paramQQAppInterface.iterator();
    while (paramQQAppInterface.hasNext())
    {
      ApolloGameRoamData localApolloGameRoamData = (ApolloGameRoamData)paramQQAppInterface.next();
      if ((localApolloGameRoamData != null) && (localApolloGameRoamData.gameId == paramInt)) {
        return true;
      }
    }
    return false;
  }
  
  public static void i(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      return;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameUtil", 2, "[saveGameRoamTS], ts:" + paramLong);
        }
        SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
        if (localSharedPreferences == null) {
          continue;
        }
        localSharedPreferences.edit().putLong("apollo_game_roam_ts_v2_" + paramQQAppInterface.getCurrentAccountUin(), paramLong).commit();
      }
      finally {}
    }
  }
  
  public static boolean i(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = ((abxk)paramQQAppInterface.getManager(155)).dN();
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = paramQQAppInterface.iterator();
    while (paramQQAppInterface.hasNext())
    {
      ApolloGameRoamData localApolloGameRoamData = (ApolloGameRoamData)paramQQAppInterface.next();
      if ((localApolloGameRoamData != null) && (localApolloGameRoamData.gameId == paramInt) && (localApolloGameRoamData.type == 2)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean ib(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3) || (paramInt == 4);
  }
  
  public static Activity l()
  {
    Activity localActivity = null;
    if (SplashActivity.dO != null) {
      localActivity = (Activity)SplashActivity.dO.get();
    }
    Object localObject = localActivity;
    if (localActivity == null) {
      localObject = BaseActivity.sTopActivity;
    }
    return localObject;
  }
  
  public static SharedPreferences p()
  {
    String str2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "noLogin";
    }
    return BaseApplicationImpl.getApplication().getSharedPreferences("sp.game" + str1, 0);
  }
  
  public static void r(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (paramStartCheckParam == null) {
      return;
    }
    QLog.i("ApolloGameUtil", 2, "startGameAgain");
    if (abmt.aY(BaseApplicationImpl.getContext())) {
      abmm.a().h(paramStartCheckParam);
    }
    a(paramStartCheckParam, false);
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.webprocess.launch_cmgame");
    localIntent.putExtra("extra_startcheckparam", paramStartCheckParam);
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    try
    {
      QLog.i("ApolloGameUtil", 2, "startGameAgain Send action launch_cmgame.");
      BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.tim.msg.permission.pushnotify");
      return;
    }
    catch (Throwable paramStartCheckParam)
    {
      QLog.e("ApolloGameUtil", 1, paramStartCheckParam, new Object[0]);
    }
  }
  
  public static void releaseCache()
  {
    try
    {
      if (ce != null)
      {
        ce.clear();
        ce = null;
      }
      if (cf != null)
      {
        cf.clear();
        cf = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameUtil", 1, "[releaseCache] clear err");
    }
  }
  
  public static int x(QQAppInterface paramQQAppInterface)
  {
    return abhh.x(paramQQAppInterface);
  }
  
  public static boolean yl()
  {
    if (!bGk)
    {
      bGl = FlatBuffersParser.yl();
      bGk = true;
    }
    return bGl;
  }
  
  public static class CmStartTask
    implements Runnable
  {
    public WeakReference<CmGameStartChecker.StartCheckParam> fV;
    public WeakReference<QQAppInterface> mAppRef;
    
    public CmStartTask(QQAppInterface paramQQAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam)
    {
      this.mAppRef = new WeakReference(paramQQAppInterface);
      this.fV = new WeakReference(paramStartCheckParam);
    }
    
    public void c(QQAppInterface paramQQAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam)
    {
      this.mAppRef = new WeakReference(paramQQAppInterface);
      this.fV = new WeakReference(paramStartCheckParam);
    }
    
    public void run()
    {
      QQAppInterface localQQAppInterface;
      CmGameStartChecker.StartCheckParam localStartCheckParam;
      if ((this.mAppRef != null) && (this.mAppRef.get() != null) && (this.fV != null) && (this.fV.get() != null))
      {
        localQQAppInterface = (QQAppInterface)this.mAppRef.get();
        localStartCheckParam = (CmGameStartChecker.StartCheckParam)this.fV.get();
        if ((localQQAppInterface != null) && (localStartCheckParam != null) && (abmt.a(localQQAppInterface, localStartCheckParam))) {}
      }
      else
      {
        return;
      }
      localStartCheckParam.notFullScreen = ApolloUtil.ZA();
      boolean bool2 = abmt.aY(localQQAppInterface.getApp());
      boolean bool1;
      label114:
      Object localObject2;
      if ((localStartCheckParam.game == null) && (!localStartCheckParam.isRequestConf))
      {
        bool1 = true;
        QLog.d("ApolloGameUtil", 1, new Object[] { "[CmStartTask] isGameProcessOn=", Boolean.valueOf(bool2), ", reqConf=", Boolean.valueOf(bool1) });
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("param_gameId", String.valueOf(localStartCheckParam.gameId));
        ((HashMap)localObject2).put("param_src", String.valueOf(localStartCheckParam.src));
        if (!bool1) {
          break label351;
        }
      }
      label351:
      for (Object localObject1 = "1";; localObject1 = "0")
      {
        ((HashMap)localObject2).put("param_reqConf", localObject1);
        anpc.a(localQQAppInterface.getApp()).collectPerformance(localQQAppInterface.getCurrentAccountUin(), "cmgame_data_req_conf", true, 0L, 0L, (HashMap)localObject2, "", false);
        if (!bool1) {
          break label371;
        }
        if (!aqiw.isNetSupport(localQQAppInterface.getApp())) {
          break label358;
        }
        localObject1 = (aqrb)localQQAppInterface.getBusinessHandler(71);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("key_get_game_detail_from", 3);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(localStartCheckParam.gameId));
        ((aqrb)localObject1).e(localArrayList, (Bundle)localObject2);
        localStartCheckParam.isRequestConf = true;
        if (bool2) {
          break;
        }
        localObject1 = (WebProcessManager)localQQAppInterface.getManager(13);
        if (localObject1 == null) {
          break;
        }
        ((WebProcessManager)localObject1).Yc(100);
        return;
        bool1 = false;
        break label114;
      }
      label358:
      ApolloGameUtil.a(acfp.m(2131702527), 1, BaseApplicationImpl.getContext());
      return;
      label371:
      if (localStartCheckParam.statMap == null) {
        localStartCheckParam.statMap = new ConcurrentHashMap();
      }
      localStartCheckParam.statMap.clear();
      long l2 = SystemClock.uptimeMillis();
      localStartCheckParam.statMap.put("click_time", Long.valueOf(l2));
      localObject1 = localStartCheckParam.statMap;
      long l1;
      if (bool2) {
        l1 = 1L;
      }
      for (;;)
      {
        ((ConcurrentHashMap)localObject1).put("game_process_on", Long.valueOf(l1));
        QLog.d("CmGameStat", 1, new Object[] { "cmgame, click time=", Long.valueOf(l2) });
        localStartCheckParam.mCreateTs = System.currentTimeMillis();
        if (bool2)
        {
          localStartCheckParam.mLoadingOnMainProcess = false;
          abmm.a().h(localStartCheckParam);
          localObject1 = new Intent();
          ((Intent)localObject1).setAction("com.tencent.mobileqq.webprocess.launch_cmgame");
          ((Intent)localObject1).putExtra("extra_startcheckparam", localStartCheckParam);
          ((Intent)localObject1).setPackage(MobileQQ.getContext().getPackageName());
          ((Intent)localObject1).setComponent(new ComponentName(MobileQQ.getContext(), "com.tencent.mobileqq.webprocess.WebProcessReceiver"));
        }
        try
        {
          QLog.i("ApolloGameUtil", 2, "Send action launch_cmgame.");
          BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject1, "com.tencent.tim.msg.permission.pushnotify");
          QLog.d("CmGameStat", 1, "cmgame_ipc_start");
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("param_gameId", String.valueOf(localStartCheckParam.gameId));
          ((HashMap)localObject2).put("param_src", String.valueOf(localStartCheckParam.src));
          if (bool2)
          {
            localObject1 = "1";
            ((HashMap)localObject2).put("param_processOn", localObject1);
            anpc.a(localQQAppInterface.getApp()).collectPerformance(localQQAppInterface.getCurrentAccountUin(), "cmgame_ipc_start", true, 0L, 0L, (HashMap)localObject2, "", false);
            return;
            l1 = 0L;
            continue;
            localStartCheckParam.mLoadingOnMainProcess = true;
            abmt.k(localStartCheckParam);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.e("ApolloGameUtil", 1, localThrowable, new Object[0]);
            continue;
            String str = "0";
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void xz(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void xy(boolean paramBoolean);
  }
  
  public static abstract interface c
  {
    public abstract void HB(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void bX(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil
 * JD-Core Version:    0.7.0.1
 */