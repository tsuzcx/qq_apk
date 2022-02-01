import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ConfigurationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloManager.11;
import com.tencent.mobileqq.apollo.ApolloManager.13;
import com.tencent.mobileqq.apollo.ApolloManager.14;
import com.tencent.mobileqq.apollo.ApolloManager.15;
import com.tencent.mobileqq.apollo.ApolloManager.16;
import com.tencent.mobileqq.apollo.ApolloManager.17;
import com.tencent.mobileqq.apollo.ApolloManager.18;
import com.tencent.mobileqq.apollo.ApolloManager.2;
import com.tencent.mobileqq.apollo.ApolloManager.21;
import com.tencent.mobileqq.apollo.ApolloManager.3;
import com.tencent.mobileqq.apollo.ApolloManager.4;
import com.tencent.mobileqq.apollo.ApolloManager.5;
import com.tencent.mobileqq.apollo.ApolloManager.8;
import com.tencent.mobileqq.apollo.ApolloManager.9;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.data.ApolloPreDownloadData;
import com.tencent.mobileqq.apollo.data.ApolloWhiteFaceID;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.data.ApolloActionPackageData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloKapuEntranceTips;
import com.tencent.mobileqq.data.ApolloPandora;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xdc.submsgtype0xdc.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xdc.submsgtype0xdc.MsgContent;

public class abhh
  implements Manager
{
  public static HashSet<Integer> aM;
  public static boolean bCA;
  public static boolean bCQ;
  public static boolean bCR;
  public static boolean bCS;
  private static boolean bCt;
  private static boolean bCu;
  private static boolean bCv;
  private static boolean bCw = true;
  private static boolean bCx = true;
  private static boolean bCy = true;
  public static boolean bCz;
  private static String bfP;
  public static String bfQ;
  public static String bfR;
  public static String bfS;
  public static String bfT;
  public static String bfU;
  public static String bfV;
  public static String bfW;
  public static String bfX;
  public static String bfY;
  public static AtomicBoolean ch;
  private static AtomicBoolean cj;
  private static int coG = -1;
  private static int coH = -1;
  private static int coI = -1;
  public static int coJ = 4096;
  public static int coK = 4097;
  public static ArrayList<Long> sI;
  public static Vector<String> u;
  public static Vector<String> v;
  Comparator<DrawerPushItem> H = new abhl(this);
  public long Nq = -1L;
  private abhf jdField_a_of_type_Abhf;
  private abhh.b jdField_a_of_type_Abhh$b;
  private abhh.e jdField_a_of_type_Abhh$e;
  abhs jdField_a_of_type_Abhs;
  private abjy jdField_a_of_type_Abjy = new abjy();
  private ablz jdField_a_of_type_Ablz;
  private abmb jdField_a_of_type_Abmb;
  private abmi jdField_a_of_type_Abmi;
  abto.b jdField_a_of_type_Abto$b;
  abyt jdField_a_of_type_Abyt;
  awms jdField_a_of_type_Awms = new abho(this);
  private ApolloBaseInfo jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo;
  private HashSet<Long> aN = new HashSet();
  public boolean bCB = true;
  private volatile boolean bCC;
  public boolean bCD = true;
  public volatile boolean bCE;
  public boolean bCF;
  public boolean bCG;
  public boolean bCH;
  public boolean bCI;
  public boolean bCJ;
  public boolean bCK;
  public boolean bCL;
  public boolean bCM;
  public boolean bCN;
  public boolean bCO;
  private volatile boolean bCP;
  public JSONObject be = new JSONObject();
  public String bfZ;
  public String bga;
  private final Object jdField_ci_of_type_JavaLangObject = new Object();
  private AtomicBoolean jdField_ci_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  Handler cr = new abhk(this, ThreadManager.getSubThreadLooper());
  private QQLruCache<String, ApolloBaseInfo> d = new abhi(this, 2009, 1024, ApolloBaseInfo.calcSelfMemorySize());
  private ConcurrentHashMap<String, ApolloPandora> dr = new ConcurrentHashMap();
  private EntityManager em;
  private WeakReference<BaseChatPie> fd;
  private Runnable ft = new ApolloManager.2(this);
  private Runnable fu = new ApolloManager.4(this);
  private Runnable fv = new ApolloManager.5(this);
  aquy i = new abhp(this);
  private Map<String, Long> iR = new HashMap();
  public HashMap<Integer, Bundle> ii;
  public aquy j = new abhq(this);
  private aquy k = new abhm(this);
  public QQAppInterface mApp;
  private WeakReference<QQAppInterface> mAppRef;
  private List<DrawerPushItem> wa = new ArrayList();
  private List<abhh.a> wb;
  private List<WeakReference<abhh.c>> wc = new ArrayList();
  public Timer z;
  
  static
  {
    aM = new HashSet(16);
    sI = new ArrayList(16);
    bCz = true;
    ch = new AtomicBoolean(false);
    cj = new AtomicBoolean(false);
    u = new Vector();
    v = new Vector();
  }
  
  public abhh(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    coG = -1;
    coH = -1;
    u.clear();
    v.clear();
    this.em = paramQQAppInterface.a().createEntityManager();
    if (aW(paramQQAppInterface.getApp()))
    {
      this.jdField_a_of_type_Abyt = new abyt();
      cBI();
      abmm.registerModule();
      ThreadManager.getSubThreadHandler().post(this.ft);
      ThreadManager.getFileThreadHandler().post(this.fu);
    }
    this.jdField_a_of_type_Abhs = new abhs(paramQQAppInterface);
    this.mAppRef = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Abhf = new abhf(paramQQAppInterface);
    cBF();
  }
  
  public static void DB(boolean paramBoolean)
  {
    boolean bool = Yf();
    Yg();
    if (!bool)
    {
      if (!TextUtils.isEmpty(abxi.bjH)) {
        break label25;
      }
      aeis.cXh();
    }
    label25:
    while ((paramBoolean) || (!aV(BaseApplicationImpl.getContext()))) {
      return;
    }
    aczo.cC((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  private void He(int paramInt)
  {
    String str = "action_red_tab_update_" + paramInt;
    this.mApp.getApp().getSharedPreferences("apollo_sp" + this.mApp.getCurrentUin(), 0).edit().putLong(str, NetConnInfoCenter.getServerTimeMillis()).commit();
  }
  
  public static void Hh(int paramInt)
  {
    QLog.i("ApolloManager", 1, "setsGameOidbStatus:" + paramInt);
    coI = paramInt >> 3 & 0x1;
  }
  
  private void N(int paramInt, List<submsgtype0xdc.MsgContent> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (this.em == null)) {
      QLog.e("ApolloManager", 1, "[saveBubblePushData], null param");
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "[saveBubblePushData] msgType:", Integer.valueOf(paramInt) });
      }
      EntityTransaction localEntityTransaction = this.em.getTransaction();
      try
      {
        localEntityTransaction.begin();
        synchronized (this.jdField_ci_of_type_JavaLangObject)
        {
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            submsgtype0xdc.MsgContent localMsgContent = (submsgtype0xdc.MsgContent)paramList.next();
            localDrawerPushItem = new DrawerPushItem();
            localDrawerPushItem.msg_type = paramInt;
            localDrawerPushItem.msg_id = String.valueOf(localMsgContent.uint64_msg_id.get());
            localDrawerPushItem.priority = ((int)localMsgContent.uint64_master_pri.get());
            localDrawerPushItem.sub_priority = ((int)localMsgContent.uint64_sub_pri.get());
            localDrawerPushItem.start_ts = ((int)localMsgContent.uint64_show_beg_ts.get());
            localDrawerPushItem.end_ts = ((int)localMsgContent.uint64_exp_ts.get());
            localDrawerPushItem.send_time = ((int)localMsgContent.uint64_msg_sent_ts.get());
            localDrawerPushItem.action_id = ((int)localMsgContent.uint64_action_id.get());
            localDrawerPushItem.color = ((int)localMsgContent.uint64_wording_color.get());
            localDrawerPushItem.content = localMsgContent.str_wording.get();
            localDrawerPushItem.scheme = localMsgContent.str_scheme.get();
            localDrawerPushItem.ext_url = localMsgContent.str_region_url.get();
            localDrawerPushItem.bubble_res_id = ((int)localMsgContent.uint64_bubble_id.get());
            localDrawerPushItem.is_reddot = 0;
            localDrawerPushItem.tips_str = localMsgContent.str_tips.get();
            localDrawerPushItem.show_counts = ((int)localMsgContent.uint64_show_times.get());
            localDrawerPushItem.reddotGameId = ((int)localMsgContent.uint64_game_id.get());
            if ((localDrawerPushItem.reddotGameId > 0) && (!ApolloGameUtil.h(this.mApp, localDrawerPushItem.reddotGameId))) {
              QLog.i("ApolloManager", 1, "saveBubblePushData push game not exit,gameId:" + localDrawerPushItem.reddotGameId);
            }
          }
        }
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          DrawerPushItem localDrawerPushItem;
          QLog.e("ApolloManager", 1, "[saveBubblePushData], Apollo Push Bubble Error:" + paramList.getMessage());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, new Object[] { "saveBubblePushData receive item:", localDrawerPushItem.toString() });
          }
          if ((this.wa != null) && (!a(localDrawerPushItem))) {
            this.wa.add(localDrawerPushItem);
          }
          this.em.persist(localDrawerPushItem);
        }
        localEntityTransaction.commit();
        return;
      }
      finally
      {
        if (localEntityTransaction != null) {
          localEntityTransaction.end();
        }
      }
    }
  }
  
  public static boolean R(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    if (!aW(BaseApplicationImpl.getContext()))
    {
      QLog.w("ApolloManager", 1, "[is3dAvailable] isHardwareSupport false");
      return false;
    }
    cBH();
    if (!bCy)
    {
      QLog.w("ApolloManager", 1, "[is3dAvailable] dpc switch off");
      return false;
    }
    ApolloBaseInfo localApolloBaseInfo = ((abhh)paramQQAppInterface.getManager(153)).a(paramQQAppInterface.getCurrentUin());
    if (localApolloBaseInfo == null)
    {
      QLog.w("ApolloManager", 1, "[is3dAvailable] no baseInfo");
      return false;
    }
    if ((localApolloBaseInfo.apolloStatus == 1) && (b(paramQQAppInterface) == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "[is3dAvailable] is3dAvailable=", Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public static boolean Ya()
  {
    boolean bool1 = false;
    l1 = System.currentTimeMillis();
    aqhq.cn(new File(abxi.bio, "/def/basic").getAbsolutePath());
    do
    {
      try
      {
        long l2 = System.currentTimeMillis();
        v(BaseApplicationImpl.getApplication().getApplicationContext(), "apollo_def_rsc", abxi.bim + "/apollo_def_rsc");
        long l3 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "copy file to sdcard cost:" + (l3 - l2));
        }
        new File(abxi.bio, "def").mkdirs();
        int m = LzmaUtils.m(BaseApplicationImpl.getApplication().getApplicationContext(), abxi.bim + "/apollo_def_rsc", abxi.bio + "/def/");
        aqhq.deleteFile(abxi.bim + "/apollo_def_rsc");
        if (m != 0) {
          continue;
        }
        boolean bool2 = true;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("ApolloManager", 2, "unzip cost: " + (System.currentTimeMillis() - l1) + " ms");
          bool1 = bool2;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloManager", 2, "errorInfo->" + localException.getMessage());
        return false;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          break label432;
        }
        QLog.d("ApolloManager", 2, "unzip cost: " + (System.currentTimeMillis() - l1) + " ms");
      }
      return bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloManager", 2, "unzip cost: " + (System.currentTimeMillis() - l1) + " ms");
    return false;
  }
  
  public static boolean Yc()
  {
    return avqy.a().aLr();
  }
  
  public static boolean Yd()
  {
    if (abxh.bl == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "queryApolloSwitchSet sSwitchSet = null");
      }
    }
    do
    {
      do
      {
        return false;
        if (!abxh.bl.has("autoOpenBox")) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, new Object[] { "openBoxByH5 autoOpenBox:", Integer.valueOf(abxh.bl.optInt("autoOpenBox")) });
        }
      } while (abxh.bl.optInt("autoOpenBox") != 0);
      return true;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloManager", 2, "openBoxByH5 not autoOpenBox");
    return false;
  }
  
  public static boolean Ye()
  {
    return ce("eggSwitch") == 1;
  }
  
  public static boolean Yf()
  {
    boolean bool2 = false;
    try
    {
      String str = abxi.bjI + "cmshow_script_engine.js";
      localFile = new File(str);
      bool1 = bool2;
      if (localFile.exists())
      {
        if (new abzb(str + ".sig", str).il(1)) {
          break label181;
        }
        QLog.w("ApolloManager", 1, "verify fails, path:" + str);
        bool1 = bool2;
      }
    }
    catch (Exception localException)
    {
      File localFile;
      QLog.e("ApolloManager", 1, "initEngineScript:", localException);
      return true;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.e("ApolloManager", 1, "initEngineScript:", localOutOfMemoryError);
        continue;
        boolean bool1 = true;
      }
    }
    if (bool1)
    {
      bfT = aqhq.readFileToString(localFile);
      return bool1;
    }
    QLog.w("ApolloManager", 1, "Fail to initEngineScript " + localFile.getAbsolutePath());
    return bool1;
  }
  
  public static boolean Yg()
  {
    boolean bool2 = false;
    try
    {
      String str = abxi.bjI + "cmshow_script_0.js";
      localFile = new File(str);
      bool1 = bool2;
      if (localFile.exists())
      {
        if (new abzb(str + ".sig", str).il(1)) {
          break label181;
        }
        QLog.w("ApolloManager", 1, "verify fails, path:" + str);
        bool1 = bool2;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      File localFile;
      QLog.e("ApolloManager", 1, "[loadScript],OOM:", localOutOfMemoryError);
      return true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("ApolloManager", 1, "[loadScript],", localThrowable);
        continue;
        boolean bool1 = true;
      }
    }
    if (bool1)
    {
      bfU = aqhq.readFileToString(localFile);
      return bool1;
    }
    QLog.w("ApolloManager", 1, "Fail to read script file. " + localFile.getAbsolutePath());
    return bool1;
  }
  
  public static int a(AppInterface paramAppInterface)
  {
    for (;;)
    {
      try
      {
        if (coG == -1)
        {
          coG = 0;
          if (paramAppInterface != null)
          {
            m = aqmj.bb(paramAppInterface.getApplication());
            if (m != 0) {
              continue;
            }
            coG = paramAppInterface.getApplication().getSharedPreferences("apollo_sp", 0).getInt(paramAppInterface.getCurrentAccountUin() + "_whiteList", 0);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "white list global: " + m + ", mWhiteUserStatus: " + coG);
            }
          }
        }
      }
      catch (Throwable paramAppInterface)
      {
        int m;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloManager", 2, "getWhiteListStatus error = " + paramAppInterface.toString());
        continue;
      }
      return coG;
      if (1 == m) {
        coG = 1;
      }
    }
  }
  
  public static void a(int paramInt, String paramString, Activity paramActivity)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("CMShow.GameId", String.valueOf(paramInt));
      localJSONObject2.put("extraInfo", paramString);
      localJSONObject1.put("CMShow.Game", localJSONObject2);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "[launchGameDetailView] mate:" + localJSONObject1.toString());
      }
      ArkFullScreenAppActivity.c(paramActivity, "com.tencent.cmgame.intent", "GameCard", localJSONObject1.toString());
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("ApolloManager", 1, "[launchGameDetailView] error:", paramString);
      }
    }
  }
  
  private void a(ApolloActionPackage paramApolloActionPackage, List<ApolloActionData> paramList)
  {
    if ((paramApolloActionPackage == null) || (this.mApp == null)) {
      break label11;
    }
    label11:
    String str;
    for (;;)
    {
      return;
      if (paramList != null) {
        try
        {
          if (paramList.size() != 0)
          {
            str = this.mApp.getApp().getSharedPreferences("apollo_sp" + this.mApp.getCurrentUin(), 0).getString(String.format("key_new_action_info_%s", new Object[] { String.valueOf(paramApolloActionPackage.packageId) }), "");
            if (TextUtils.isEmpty(str))
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("ApolloManager", 2, "checkPackageRedDots, no new action info");
            }
          }
        }
        catch (Exception paramApolloActionPackage)
        {
          QLog.e("ApolloManager", 1, "checkPackageRedDots Exception:", paramApolloActionPackage);
          return;
        }
      }
    }
    Object localObject = new JSONObject(str);
    int n = ((JSONObject)localObject).getInt("actionId");
    paramList = paramList.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
    } while (((ApolloActionData)paramList.next()).actionId != n);
    for (int m = 1;; m = 0)
    {
      if (m == 0)
      {
        QLog.d("ApolloManager", 1, new Object[] { "checkPackageRedDots, new action, pkdId=", Integer.valueOf(paramApolloActionPackage.packageId), ", actionId=", Integer.valueOf(n) });
        return;
      }
      long l1 = ((JSONObject)localObject).getLong("startTime");
      long l2 = ((JSONObject)localObject).getLong("interval");
      paramList = ((abxk)this.mApp.getManager(155)).a(paramApolloActionPackage.packageId);
      if ((paramList != null) && (l1 == paramList.redStartTime))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, new Object[] { "checkPackageRedDots", " have not new red push" });
        }
        paramApolloActionPackage.isUpdate = paramList.isUpdate;
        paramApolloActionPackage.redFlowId = paramList.redFlowId;
        paramApolloActionPackage.redStartTime = paramList.redStartTime;
        paramApolloActionPackage.redInterval = paramList.redInterval;
        return;
      }
      paramApolloActionPackage.isUpdate = true;
      paramApolloActionPackage.redFlowId = n;
      paramApolloActionPackage.redStartTime = l1;
      paramApolloActionPackage.redInterval = l2;
      He(paramApolloActionPackage.packageId);
      paramList = new ArrayList();
      localObject = new ApolloActionData();
      ((ApolloActionData)localObject).actionId = n;
      paramList.add(localObject);
      w(paramList, "apollo_key");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloManager", 2, new Object[] { "checkPackageRedDots", " push red:", Integer.valueOf(paramApolloActionPackage.packageId), " newActionInfoStr:", str });
      return;
    }
  }
  
  private void a(TianShuAccess.RspEntry paramRspEntry)
  {
    QLog.d("ApolloManager", 1, "handleAioKapuEntranceTipsAdv");
    if ((paramRspEntry == null) || (paramRspEntry.value == null) || (paramRspEntry.value.lst == null) || (paramRspEntry.value.lst.size() == 0))
    {
      QLog.e("ApolloManager", 1, "handleAioKapuEntranceTipsAdv, data empty");
      return;
    }
    int n = paramRspEntry.value.lst.size();
    QLog.d("ApolloManager", 1, new Object[] { "handleAioKapuEntranceTipsAdv, size=", Integer.valueOf(n) });
    ArrayList localArrayList = new ArrayList();
    int m = 0;
    if (m < n)
    {
      Object localObject1 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(m)).argList.get();
      int i1 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(m)).iAdId.get();
      String str = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(m)).traceinfo.get();
      QLog.d("ApolloManager", 1, new Object[] { "handleAioKapuEntranceTipsAdv, adId=", Integer.valueOf(i1), ", i=", Integer.valueOf(m) });
      ApolloKapuEntranceTips localApolloKapuEntranceTips = new ApolloKapuEntranceTips();
      localApolloKapuEntranceTips.adId = i1;
      localApolloKapuEntranceTips.traceInfo = str;
      Object localObject2;
      label366:
      label373:
      do
      {
        for (;;)
        {
          try
          {
            localObject1 = ((List)localObject1).iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break label547;
            }
            localObject2 = (TianShuAccess.MapEntry)((Iterator)localObject1).next();
            str = ((TianShuAccess.MapEntry)localObject2).key.get();
            localObject2 = ((TianShuAccess.MapEntry)localObject2).value.get();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, new Object[] { "handleAioKapuEntranceTipsAdv keyStr:", str, ", valueStr=", localObject2 });
            }
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              continue;
            }
            if (!"bubbleText".equals(str)) {
              break label373;
            }
            localApolloKapuEntranceTips.text = ((String)localObject2);
            continue;
            m += 1;
          }
          catch (Throwable localThrowable)
          {
            QLog.e("ApolloManager", 1, "handleAioKapuEntranceTipsAdv, parse exception=", localThrowable);
          }
          break;
          if ("startTime".equals(str))
          {
            localThrowable.startTime = Long.parseLong((String)localObject2);
          }
          else if ("endTime".equals(str))
          {
            localThrowable.endTime = Long.parseLong((String)localObject2);
          }
          else if ("showCount".equals(str))
          {
            localThrowable.showCount = Integer.parseInt((String)localObject2);
          }
          else if ("duration".equals(str))
          {
            localThrowable.duration = Long.parseLong((String)localObject2);
          }
          else if ("jumpUrl".equals(str))
          {
            localThrowable.activityUrl = ((String)localObject2);
          }
          else
          {
            if (!"priority".equals(str)) {
              break label514;
            }
            localThrowable.priority = Integer.parseInt((String)localObject2);
          }
        }
      } while (!"isInstall".equals(str));
      label514:
      if (Integer.parseInt((String)localObject2) != 1) {
        break label579;
      }
    }
    label547:
    label579:
    for (boolean bool = true;; bool = false)
    {
      localThrowable.isInstall = bool;
      break;
      localArrayList.add(localThrowable);
      break label366;
      ((abxk)this.mApp.getManager(155)).iu(localArrayList);
      return;
    }
  }
  
  private void a(List<ApolloActionData> paramList, List<ApolloActionPackage> paramList1, List<ApolloActionPackageData> paramList2, JSONObject paramJSONObject)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      int m;
      Object localObject4;
      int n;
      try
      {
        localObject1 = new ArrayList();
        Object localObject6;
        Object localObject5;
        if ((paramJSONObject != null) && (paramJSONObject.has("data")))
        {
          localObject2 = paramJSONObject.getJSONArray("data");
          if (localObject2 != null)
          {
            int i1 = ((JSONArray)localObject2).length();
            m = 0;
            if (m < i1)
            {
              localObject4 = ((JSONArray)localObject2).getJSONObject(m);
              if (localObject4 == null) {
                break label1725;
              }
              localObject3 = new ApolloActionData();
              ((ApolloActionData)localObject3).actionId = ((JSONObject)localObject4).getInt("id");
              ((ApolloActionData)localObject3).sessionType = ((JSONObject)localObject4).optInt("use");
              ((ApolloActionData)localObject3).actionName = ((JSONObject)localObject4).getString("name");
              ((ApolloActionData)localObject3).vipLevel = ((JSONObject)localObject4).optInt("vipLevel");
              ((ApolloActionData)localObject3).feeType = ((JSONObject)localObject4).optInt("feeType", 1);
              if (((JSONObject)localObject4).has("icon")) {
                ((ApolloActionData)localObject3).icon = ((JSONObject)localObject4).getInt("icon");
              }
              ((ApolloActionData)localObject3).iconUrl = ((JSONObject)localObject4).optString("iconUrl");
              ((ApolloActionData)localObject3).personNum = ((JSONObject)localObject4).getInt("type");
              ((ApolloActionData)localObject3).anmiName = ((JSONObject)localObject4).optString("animationName");
              ((ApolloActionData)localObject3).isShow = ((JSONObject)localObject4).optInt("isShow");
              ((ApolloActionData)localObject3).textImg = ((JSONObject)localObject4).optString("textImg");
              if (((JSONObject)localObject4).has("limitFree"))
              {
                ((ApolloActionData)localObject3).limitFree = ((JSONObject)localObject4).getInt("limitFree");
                ((ApolloActionData)localObject3).limitStart = ((JSONObject)localObject4).getLong("begin");
                ((ApolloActionData)localObject3).limitEnd = ((JSONObject)localObject4).getLong("end");
              }
              ((ApolloActionData)localObject3).startTime = ((JSONObject)localObject4).optLong("startTime");
              ((ApolloActionData)localObject3).endTime = ((JSONObject)localObject4).optLong("endTime");
              ((ApolloActionData)localObject3).url = ((JSONObject)localObject4).optString("activeUrl");
              ((ApolloActionData)localObject3).version = ((JSONObject)localObject4).getLong("version");
              ((ApolloActionData)localObject3).actionMoveDis = ((float)((JSONObject)localObject4).optDouble("actionDis", 0.0D));
              ((ApolloActionData)localObject3).peerMoveDis = ((float)((JSONObject)localObject4).optDouble("actionPeerDis", 0.0D));
              ((ApolloActionData)localObject3).compoundType = ((JSONObject)localObject4).optInt("actionSubType");
              ((ApolloActionData)localObject3).playArea = ((JSONObject)localObject4).optInt("posType");
              ((ApolloActionData)localObject3).actionType = ((JSONObject)localObject4).optInt("actionType");
              ((ApolloActionData)localObject3).slaveActionId = ((JSONObject)localObject4).optInt("slaveActionId");
              ((ApolloActionData)localObject3).currencyType = ((JSONObject)localObject4).optInt("currencyType");
              ((ApolloActionData)localObject3).currencyNum = ((JSONObject)localObject4).optInt("currencyNum");
              ((ApolloActionData)localObject3).description = ((JSONObject)localObject4).optString("description");
              ((ApolloActionData)localObject3).extraWording = ((JSONObject)localObject4).optString("extraWording");
              ((ApolloActionData)localObject3).minVer = ((JSONObject)localObject4).optString("minVer");
              ((ApolloActionData)localObject3).maxVer = ((JSONObject)localObject4).optString("maxVer");
              ((ApolloActionData)localObject3).gameId = ((JSONObject)localObject4).optInt("gameId");
              ((ApolloActionData)localObject3).gameName = ((JSONObject)localObject4).optString("gameName");
              ((ApolloActionData)localObject3).activeValue = ((JSONObject)localObject4).optInt("activeValue");
              ((ApolloActionData)localObject3).soundURL = ((JSONObject)localObject4).optString("soundURL");
              ((ApolloActionData)localObject3).soundType = ((JSONObject)localObject4).optInt("soundType");
              localObject6 = ((JSONObject)localObject4).optJSONArray("pkIds");
              localObject5 = ((JSONObject)localObject4).optJSONArray("pk3DIds");
              int i2;
              if (localObject6 != null)
              {
                i2 = ((JSONArray)localObject6).length();
                StringBuilder localStringBuilder = new StringBuilder();
                n = 0;
                label606:
                if (n < i2)
                {
                  localStringBuilder.append(String.valueOf(((JSONArray)localObject6).get(n)));
                  if (n == i2 - 1) {
                    break label1698;
                  }
                  localStringBuilder.append(",");
                  break label1698;
                }
                ((ApolloActionData)localObject3).pkIds = localStringBuilder.toString();
              }
              if (localObject5 != null)
              {
                i2 = ((JSONArray)localObject5).length();
                localObject6 = new StringBuilder();
                n = 0;
                label684:
                if (n < i2)
                {
                  ((StringBuilder)localObject6).append(String.valueOf(((JSONArray)localObject5).get(n)));
                  if (n == i2 - 1) {
                    break label1707;
                  }
                  ((StringBuilder)localObject6).append(",");
                  break label1707;
                }
                ((ApolloActionData)localObject3).pk3DIds = ((StringBuilder)localObject6).toString();
              }
              localObject4 = ((JSONObject)localObject4).optJSONArray("keywords");
              if (localObject4 != null)
              {
                i2 = ((JSONArray)localObject4).length();
                localObject5 = new StringBuilder();
                n = 0;
                label772:
                if (n < i2)
                {
                  ((StringBuilder)localObject5).append(String.valueOf(((JSONArray)localObject4).get(n)));
                  if (n == i2 - 1) {
                    break label1716;
                  }
                  ((StringBuilder)localObject5).append(",");
                  break label1716;
                }
                ((ApolloActionData)localObject3).keywords = ((StringBuilder)localObject5).toString();
              }
              if ((this.ii != null) && (this.ii.containsKey(Integer.valueOf(((ApolloActionData)localObject3).actionId))))
              {
                if (((ApolloActionData)localObject3).isShow == 0) {
                  ((ApolloActionData)localObject3).isShow = 1;
                }
                a((ApolloActionData)localObject3, (Bundle)this.ii.get(Integer.valueOf(((ApolloActionData)localObject3).actionId)));
              }
              b((ApolloActionData)localObject3);
              paramList.add(localObject3);
              if (((ApolloActionData)localObject3).feeType != 6) {
                break label1725;
              }
              ((List)localObject1).add(localObject3);
              break label1725;
            }
          }
        }
        if (this.mApp == null) {
          return;
        }
        localObject1 = (abxk)this.mApp.getManager(155);
        localObject1 = new ArrayList();
        if ((paramJSONObject == null) || (!paramJSONObject.has("packageInfo"))) {
          break label1583;
        }
        paramJSONObject = paramJSONObject.getJSONArray("packageInfo");
        if (paramJSONObject == null) {
          break label1583;
        }
        m = 0;
        if (m >= paramJSONObject.length()) {
          break label1583;
        }
        Object localObject3 = paramJSONObject.getJSONObject(m);
        if (localObject3 == null) {
          break label1735;
        }
        localObject2 = new ApolloActionPackage();
        ((ApolloActionPackage)localObject2).packageId = ((JSONObject)localObject3).getInt("packageId");
        ((ApolloActionPackage)localObject2).version = ((JSONObject)localObject3).optInt("version");
        ((ApolloActionPackage)localObject2).startVersion = ((JSONObject)localObject3).optString("startVersion");
        ((ApolloActionPackage)localObject2).endVersion = ((JSONObject)localObject3).optString("endVersion");
        ((ApolloActionPackage)localObject2).type = ((JSONObject)localObject3).optInt("type");
        ((ApolloActionPackage)localObject2).sessionType = ((JSONObject)localObject3).optInt("use");
        ((ApolloActionPackage)localObject2).name = ((JSONObject)localObject3).optString("name");
        ((ApolloActionPackage)localObject2).mIconUnselectedUrl = ((JSONObject)localObject3).optString("apImg");
        ((ApolloActionPackage)localObject2).mIconSelectedUrl = ((JSONObject)localObject3).optString("apcImg");
        a((ApolloActionPackage)localObject2, paramList);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "ActionPackage pid = " + ((ApolloActionPackage)localObject2).packageId + " actionPackage.isUpdate = " + ((ApolloActionPackage)localObject2).isUpdate);
        }
        paramList1.add(localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "add actionPackage pid=" + ((ApolloActionPackage)localObject2).packageId);
        }
        localObject3 = ((JSONObject)localObject3).optJSONArray("actionSet");
        if ((localObject3 == null) || (((JSONArray)localObject3).length() <= 0)) {
          break label1562;
        }
        localObject4 = new StringBuilder();
        n = 0;
        if (n < ((JSONArray)localObject3).length())
        {
          localObject5 = ((JSONArray)localObject3).getJSONObject(n);
          localObject6 = new ApolloActionPackageData();
          ((ApolloActionPackageData)localObject6).packageId = ((ApolloActionPackage)localObject2).packageId;
          ((ApolloActionPackageData)localObject6).acitonId = ((JSONObject)localObject5).optInt("actionId");
          ((ApolloActionPackageData)localObject6).text = ((JSONObject)localObject5).optString("text");
          ((ApolloActionPackageData)localObject6).textType = ((JSONObject)localObject5).optInt("textType");
          if (a(((ApolloActionPackageData)localObject6).acitonId, paramList))
          {
            paramList2.add(localObject6);
            if (((ApolloActionPackageData)localObject6).packageId == 5) {
              ((List)localObject1).add(Integer.valueOf(((ApolloActionPackageData)localObject6).acitonId));
            }
            ((StringBuilder)localObject4).append(((ApolloActionPackageData)localObject6).acitonId).append(" ");
            n += 1;
            continue;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ApolloManager", 2, "action list has not packageAction id=" + ((ApolloActionPackageData)localObject6).acitonId);
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label1735;
        }
      }
      catch (Exception paramList)
      {
        QLog.e("ApolloManager", 1, "parse ActionInfo error:" + paramList);
        return;
      }
      QLog.d("ApolloManager", 2, new Object[] { "addActionPackageData packageId=", Integer.valueOf(((ApolloActionPackage)localObject2).packageId), " actionId=[", ((StringBuilder)localObject4).toString(), "]" });
      break label1735;
      label1562:
      if (((ApolloActionPackage)localObject2).type != 2)
      {
        paramList1.remove(localObject2);
        break label1735;
        label1583:
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, new Object[] { "[parseActionInfo] world action list=", localObject1 });
        }
        if ((localObject1 != null) && (((List)localObject1).size() > 0) && (paramList != null) && (paramList.size() > 0))
        {
          paramList = paramList.iterator();
          for (;;)
          {
            if (paramList.hasNext())
            {
              paramList1 = (ApolloActionData)paramList.next();
              if (((List)localObject1).contains(Integer.valueOf(paramList1.actionId)))
              {
                paramList1.hasExtraAction = true;
              }
              else
              {
                paramList1.hasExtraAction = false;
                continue;
                label1698:
                n += 1;
                break label606;
                label1707:
                n += 1;
                break label684;
                label1716:
                n += 1;
                break label772;
                label1725:
                m += 1;
                break;
              }
            }
          }
        }
        return;
      }
      label1735:
      m += 1;
    }
  }
  
  private void a(JSONObject paramJSONObject, List<ApolloWhiteFaceID> paramList)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      try
      {
        paramJSONObject = paramJSONObject.optJSONArray("IDMap");
        if (paramJSONObject == null) {
          continue;
        }
        int m = 0;
        while (m < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.optJSONObject(m);
          if (localJSONObject != null)
          {
            ApolloWhiteFaceID localApolloWhiteFaceID = new ApolloWhiteFaceID();
            localApolloWhiteFaceID.terminalId = localJSONObject.optInt("terminalID");
            localApolloWhiteFaceID.action2d = localJSONObject.optInt("action2D");
            localApolloWhiteFaceID.action3d = localJSONObject.optInt("action3D");
            paramList.add(localApolloWhiteFaceID);
          }
          m += 1;
        }
        return;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("ApolloManager", 1, "parseWhiteFaceIdMapping:", paramJSONObject);
      }
    }
  }
  
  public static boolean a(Context paramContext, Boolean paramBoolean)
  {
    boolean bool2 = true;
    if (!aW(paramContext)) {}
    do
    {
      return false;
      cBH();
    } while ((!bCw) && (!bCy));
    boolean bool1;
    if (paramBoolean.booleanValue())
    {
      if (!bCw) {
        break label90;
      }
      if (a(abmt.getAppInterface()) == 1) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((!bool1) && (bCy)) {
        if (b(abmt.getAppInterface()) == 1) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        return bool1;
        bool1 = false;
        break;
        bool1 = false;
        continue;
        return true;
      }
      label90:
      bool1 = false;
    }
  }
  
  public static boolean a(ApolloBaseInfo paramApolloBaseInfo)
  {
    boolean bool = true;
    if (paramApolloBaseInfo == null) {
      return false;
    }
    if (paramApolloBaseInfo.apolloStatus == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static void aI(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    int n = Build.VERSION.SDK_INT;
    if (paramJSONObject != null)
    {
      if (paramJSONObject.optInt("all") == 1) {
        bCQ = true;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ApolloManager", 2, "initTextureViewConfig jsonObject:" + paramJSONObject);
        }
        if (Build.MODEL.contains("MI 4")) {
          bCQ = false;
        }
        QLog.i("ApolloManager", 2, "initTextureViewConfig sUseTextureViewConfig:" + bCQ);
        return;
        JSONArray localJSONArray = paramJSONObject.optJSONArray("sdkIntArray");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          int i1 = localJSONArray.length();
          int m = 0;
          for (;;)
          {
            if (m >= i1) {
              break label166;
            }
            if (localJSONArray.optInt(m) == n)
            {
              bCQ = true;
              break;
            }
            bCQ = false;
            m += 1;
          }
        }
        else
        {
          label166:
          bCQ = false;
        }
      }
    }
    boolean bool1 = bool2;
    if (n != 19) {
      if (n != 23) {
        break label203;
      }
    }
    label203:
    for (bool1 = bool2;; bool1 = false)
    {
      bCQ = bool1;
      break;
    }
  }
  
  public static boolean aV(Context paramContext)
  {
    return a(paramContext, Boolean.valueOf(true));
  }
  
  public static boolean aW(Context paramContext)
  {
    boolean bool = false;
    if (ApolloGameUtil.yl()) {
      return false;
    }
    if (bCt) {
      return bCu;
    }
    if (Build.VERSION.SDK_INT >= 14) {
      bool = true;
    }
    bCu = bool;
    if (!bCu)
    {
      bCt = true;
      return bCu;
    }
    if (paramContext != null)
    {
      bCu = aX(paramContext);
      bCt = true;
    }
    return bCu;
  }
  
  private static boolean aX(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo();
        if (paramContext != null)
        {
          QLog.i("ApolloManager", 1, "isOpenglSupport reqGlEsVersion:" + paramContext.reqGlEsVersion);
          if (paramContext.reqGlEsVersion >= 196608)
          {
            bool = true;
            bCv = bool;
            int m = paramContext.reqGlEsVersion;
            if (m < 131072) {
              break label91;
            }
          }
          label91:
          for (boolean bool = true;; bool = false)
          {
            return bool;
            bool = false;
            break;
          }
          if (!QLog.isColorLevel()) {}
        }
      }
      catch (Throwable paramContext) {}
    }
    QLog.e("ApolloManager", 2, "isOpenglSupport:" + paramContext.getMessage());
    return false;
  }
  
  public static boolean an(String paramString1, String paramString2)
  {
    String str = abxi.biF + paramString1 + ".zip";
    localObject1 = abxi.biF + paramString1 + ".patch";
    localObject2 = abxi.biF + paramString1 + ".patched";
    paramString1 = new File(str);
    localObject1 = new File((String)localObject1);
    localObject2 = new File((String)localObject2);
    label250:
    do
    {
      try
      {
        if (((File)localObject2).exists()) {
          ((File)localObject2).delete();
        }
        ((File)localObject2).createNewFile();
        if ((!paramString1.exists()) || (!paramString1.isFile()) || (!((File)localObject1).exists()) || (!((File)localObject1).isFile()) || (!BspatchUtil.D(paramString1.getAbsolutePath(), ((File)localObject1).getAbsolutePath(), ((File)localObject2).getAbsolutePath()))) {
          break label286;
        }
        ((File)localObject1).delete();
        paramString1.delete();
        ((File)localObject2).renameTo(paramString1);
        str = aszr.getFileMD5String(paramString1);
        if ((str == null) || (str.equals(paramString2))) {
          break label250;
        }
        QLog.e("ApolloManager", 1, "md5 not match!");
        paramString1.delete();
      }
      catch (Exception paramString2)
      {
        QLog.e("ApolloManager", 1, "[patchGameRes] Exception:", paramString2);
        if (!paramString1.exists()) {
          break;
        }
        paramString1.delete();
        return false;
      }
      finally
      {
        if (!((File)localObject2).exists()) {
          break label397;
        }
        ((File)localObject2).delete();
        if (!((File)localObject1).exists()) {
          break label409;
        }
        ((File)localObject1).delete();
      }
      return false;
      QLog.i("ApolloManager", 1, "patch files succeed.");
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      if (((File)localObject1).exists()) {
        ((File)localObject1).delete();
      }
      return true;
      QLog.e("ApolloManager", 1, "patch game res error.");
      if (paramString1.exists()) {
        paramString1.delete();
      }
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
    } while (!((File)localObject1).exists());
    label286:
    ((File)localObject1).delete();
    return false;
  }
  
  public static int b(AppInterface paramAppInterface)
  {
    for (;;)
    {
      try
      {
        if (coH == -1)
        {
          coH = 0;
          if (paramAppInterface != null)
          {
            m = aqmj.bc(paramAppInterface.getApplication());
            QLog.d("ApolloManager", 1, new Object[] { "[get3dWhiteListStatus] global=", Integer.valueOf(m) });
            if (m != 0) {
              continue;
            }
            coH = paramAppInterface.getApplication().getSharedPreferences("apollo_sp", 0).getInt(paramAppInterface.getCurrentAccountUin() + "_3dwhiteList", 0);
            QLog.d("ApolloManager", 1, new Object[] { "[get3dWhiteListStatus] global=", Integer.valueOf(m), ", s3dWhiteUserStatus=", Integer.valueOf(coH) });
          }
        }
      }
      catch (Throwable paramAppInterface)
      {
        int m;
        QLog.e("ApolloManager", 1, "[get3dWhiteListStatus] exception=", paramAppInterface);
        continue;
      }
      return coH;
      if (1 == m) {
        coH = 1;
      }
    }
  }
  
  public static int b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (!aW(paramQQAppInterface.getApplication())) || (TextUtils.isEmpty(paramString1)) || (abxh.bk == null)) {
      return -1;
    }
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      str = paramString2;
      if (!TextUtils.isEmpty(paramQQAppInterface.getCurrentAccountUin()))
      {
        paramString2 = (abhh)paramQQAppInterface.getManager(153);
        if (paramString2.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo == null) {
          break label197;
        }
        m = paramString2.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloStatus;
        int n = a(paramQQAppInterface);
        str = n + "x" + m;
      }
    }
    if ((abxh.bk != null) && (str != null))
    {
      paramQQAppInterface = abxh.bk.optJSONObject(str);
      if (paramQQAppInterface == null) {}
    }
    for (int m = paramQQAppInterface.optInt(paramString1);; m = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "queryStatusInConfig ruleKey: " + str + ", entry = " + paramString1 + ", value=" + m);
      }
      return m;
      label197:
      ThreadManager.getSubThreadHandler().post(new ApolloManager.14(paramString2, paramQQAppInterface));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloManager", 2, "queryStatusInConfig but apollomanager dont init done");
      return -1;
    }
  }
  
  private void b(TianShuAccess.RspEntry paramRspEntry)
  {
    QLog.d("ApolloManager", 1, "handleAio3dBubbleAdv");
    if ((paramRspEntry == null) || (paramRspEntry.value == null) || (paramRspEntry.value.lst == null) || (paramRspEntry.value.lst.size() == 0))
    {
      QLog.e("ApolloManager", 1, "handleAio3dBubbleAdv, data empty");
      return;
    }
    int m = 0;
    String str1 = "";
    int i3 = paramRspEntry.value.lst.size();
    QLog.d("ApolloManager", 1, new Object[] { "handleAio3dBubbleAdv, size=", Integer.valueOf(i3) });
    HashMap localHashMap = new HashMap();
    int n = 0;
    Object localObject1;
    int i1;
    if (n < i3)
    {
      localObject1 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(n)).argList.get();
      int i2 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(n)).iAdId.get();
      QLog.d("ApolloManager", 1, new Object[] { "handleAio3dBubbleAdv, adId=", Integer.valueOf(i2), ", i=", Integer.valueOf(n) });
      if (n == i3 - 1)
      {
        i1 = 1;
        if (i1 == 0) {
          break label407;
        }
        str1 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(n)).traceinfo.get();
        m = i2;
      }
    }
    label407:
    for (;;)
    {
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (TianShuAccess.MapEntry)((Iterator)localObject1).next();
          String str2 = ((TianShuAccess.MapEntry)localObject2).key.get();
          localObject2 = ((TianShuAccess.MapEntry)localObject2).value.get();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, new Object[] { "handleAio3dBubbleAdv keyStr:", str2, ", valueStr=", localObject2 });
          }
          if ((i1 != 0) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
          {
            localHashMap.put(str2, localObject2);
            continue;
            i1 = 0;
            break;
          }
        }
      }
      n += 1;
      break;
      if (localHashMap == null)
      {
        QLog.e("ApolloManager", 1, "handleAio3dBubbleAdv map null");
        return;
      }
      abhh.e.a(a(), localHashMap, m, str1);
      return;
    }
  }
  
  public static int c(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "[getCmShowStatus] withStrictCheck=", Boolean.valueOf(paramBoolean) });
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        do
        {
          return 0;
          paramQQAppInterface = ((abhh)paramQQAppInterface.getManager(153)).a(paramString);
        } while (paramQQAppInterface == null);
        if (!paramBoolean) {
          break;
        }
      } while (!aW(BaseApplicationImpl.getContext()));
      cBH();
    } while (((!bCw) && (!bCy)) || (paramQQAppInterface.apolloStatus != 1));
    int m;
    if ((bCy) && ((paramQQAppInterface.cmshow3dFlag & 0x2) == 2) && ((paramQQAppInterface.cmshow3dFlag & 0x1) == 1)) {
      m = 2;
    }
    for (;;)
    {
      return m;
      if ((bCw) && ((paramQQAppInterface.cmshow3dFlag & 0x1) == 0))
      {
        m = 1;
      }
      else
      {
        m = 0;
        continue;
        if (((paramQQAppInterface.cmshow3dFlag & 0x2) == 2) && ((paramQQAppInterface.cmshow3dFlag & 0x1) == 1)) {
          m = 2;
        } else {
          m = 1;
        }
      }
    }
  }
  
  private void c(TianShuAccess.RspEntry paramRspEntry)
  {
    QLog.d("ApolloManager", 1, "handleKapuDownloadAdv");
    if ((paramRspEntry == null) || (paramRspEntry.value == null) || (paramRspEntry.value.lst == null) || (paramRspEntry.value.lst.size() == 0))
    {
      QLog.e("ApolloManager", 1, "handleKapuDownloadAdv, data empty");
      return;
    }
    int i3 = paramRspEntry.value.lst.size();
    QLog.d("ApolloManager", 1, new Object[] { "handleKapuDownloadAdv, size=", Integer.valueOf(i3) });
    int m = -1;
    String str1 = "";
    HashMap localHashMap = new HashMap();
    int n = 0;
    Object localObject1;
    int i1;
    if (n < i3)
    {
      localObject1 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(n)).argList.get();
      int i2 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(n)).iAdId.get();
      QLog.d("ApolloManager", 1, new Object[] { "handleKapuDownloadAdv, adId=", Integer.valueOf(i2), ", i=", Integer.valueOf(n) });
      if (n == i3 - 1)
      {
        i1 = 1;
        if (i1 == 0) {
          break label403;
        }
        str1 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(n)).traceinfo.get();
        m = i2;
      }
    }
    label403:
    for (;;)
    {
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (TianShuAccess.MapEntry)((Iterator)localObject1).next();
          String str2 = ((TianShuAccess.MapEntry)localObject2).key.get();
          localObject2 = ((TianShuAccess.MapEntry)localObject2).value.get();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, new Object[] { "handleKapuDownloadAdv keyStr:", str2, ", valueStr=", localObject2 });
          }
          if ((i1 != 0) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
          {
            localHashMap.put(str2, localObject2);
            continue;
            i1 = 0;
            break;
          }
        }
      }
      n += 1;
      break;
      if (localHashMap == null)
      {
        QLog.e("ApolloManager", 1, "handleKapuDownloadAdv map null");
        return;
      }
      abhh.d.b(localHashMap, m, str1);
      return;
    }
  }
  
  private void cBF()
  {
    this.jdField_a_of_type_Abhh$b = new abhh.b();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_APOLLO_STORE_CRASH_EVENT");
    try
    {
      BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_Abhh$b, localIntentFilter, "com.tencent.tim.msg.permission.pushnotify", null);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloManager", 1, "registerReceiver failed. ", localException);
    }
  }
  
  private static void cBH()
  {
    String str = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.apollo_info.name(), "");
    if ((!TextUtils.isEmpty(str)) && (!str.equals(bfP)))
    {
      bfP = str;
      String[] arrayOfString = str.split("\\|");
      if (arrayOfString.length > 0) {
        bCw = "1".equals(arrayOfString[0]);
      }
      if (arrayOfString.length > 1) {
        bCx = "1".equals(arrayOfString[1]);
      }
      if (arrayOfString.length > 2) {
        bCy = "1".equals(arrayOfString[2]);
      }
      QLog.d("ApolloManager", 1, new Object[] { "checkDpcSwitch, apolloInfo=", str, ", sApolloSwitch=", Boolean.valueOf(bCw), ", sCmGameDPCSwitch=", Boolean.valueOf(bCx), ", sCmShow3dDPCSwitch=", Boolean.valueOf(bCy) });
    }
  }
  
  private static void cBI()
  {
    ApolloManager.3 local3 = new ApolloManager.3();
    if (!cj.getAndSet(true)) {
      ThreadManager.post(local3, 8, null, false);
    }
  }
  
  public static void cBJ()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof ToolAppRuntime))
      {
        localObject = ((AppRuntime)localObject).getAppRuntime("modular_web");
        if ((localObject instanceof AppInterface))
        {
          localObject = ((AppInterface)localObject).getHandler(ApolloStoreActivity.class);
          if (localObject != null)
          {
            ((MqqHandler)localObject).sendEmptyMessage(258);
            QLog.i("ApolloStoreActivity", 1, "send refresh apollo view msg");
          }
        }
      }
    }
  }
  
  /* Error */
  private void cBO()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +13 -> 18
    //   8: ldc_w 482
    //   11: iconst_2
    //   12: ldc_w 1764
    //   15: invokestatic 770	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: aload_0
    //   19: getfield 1766	abhh:bCC	Z
    //   22: ifne +550 -> 572
    //   25: aload_0
    //   26: getfield 1766	abhh:bCC	Z
    //   29: ifeq +4 -> 33
    //   32: return
    //   33: aload_0
    //   34: getfield 314	abhh:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: ifnull +293 -> 330
    //   40: aload_0
    //   41: getfield 314	abhh:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   44: invokevirtual 1606	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   47: astore 5
    //   49: invokestatic 1769	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   52: lstore_3
    //   53: aload_0
    //   54: getfield 330	abhh:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   57: ldc 220
    //   59: invokevirtual 1773	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   62: checkcast 175	java/util/ArrayList
    //   65: astore 6
    //   67: aload 6
    //   69: ifnull +498 -> 567
    //   72: aload 6
    //   74: invokevirtual 1774	java/util/ArrayList:size	()I
    //   77: istore_1
    //   78: aload 6
    //   80: invokevirtual 1775	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   83: astore 7
    //   85: aload 7
    //   87: invokeinterface 536 1 0
    //   92: ifeq +254 -> 346
    //   95: aload 7
    //   97: invokeinterface 540 1 0
    //   102: checkcast 1777	com/tencent/mobileqq/persistence/Entity
    //   105: checkcast 220	com/tencent/mobileqq/data/ApolloBaseInfo
    //   108: astore 8
    //   110: aload 8
    //   112: ifnull -27 -> 85
    //   115: aload 8
    //   117: getfield 1780	com/tencent/mobileqq/data/ApolloBaseInfo:uin	Ljava/lang/String;
    //   120: invokestatic 404	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: ifne -38 -> 85
    //   126: lload_3
    //   127: aload 8
    //   129: getfield 1783	com/tencent/mobileqq/data/ApolloBaseInfo:apolloSignValidTS	J
    //   132: lcmp
    //   133: ifle +19 -> 152
    //   136: aload 8
    //   138: aload 8
    //   140: getfield 1783	com/tencent/mobileqq/data/ApolloBaseInfo:apolloSignValidTS	J
    //   143: putfield 1786	com/tencent/mobileqq/data/ApolloBaseInfo:apolloLocalSignTs	J
    //   146: aload 8
    //   148: aconst_null
    //   149: putfield 1789	com/tencent/mobileqq/data/ApolloBaseInfo:apolloSignStr	Ljava/lang/String;
    //   152: aload_0
    //   153: getfield 229	abhh:d	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   156: astore 6
    //   158: aload 6
    //   160: monitorenter
    //   161: aload_0
    //   162: getfield 229	abhh:d	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   165: aload 8
    //   167: getfield 1780	com/tencent/mobileqq/data/ApolloBaseInfo:uin	Ljava/lang/String;
    //   170: aload 8
    //   172: invokevirtual 1792	com/tencent/commonsdk/cache/QQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: pop
    //   176: aload 6
    //   178: monitorexit
    //   179: aload 8
    //   181: getfield 1780	com/tencent/mobileqq/data/ApolloBaseInfo:uin	Ljava/lang/String;
    //   184: aload 5
    //   186: invokevirtual 1099	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   189: ifeq -104 -> 85
    //   192: aload_0
    //   193: aload 8
    //   195: putfield 910	abhh:jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo	Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   198: aload_0
    //   199: aload_0
    //   200: getfield 910	abhh:jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo	Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   203: getfield 1795	com/tencent/mobileqq/data/ApolloBaseInfo:apolloAISwitch	I
    //   206: iconst_0
    //   207: invokevirtual 1799	abhh:gB	(II)V
    //   210: goto -125 -> 85
    //   213: astore 5
    //   215: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq +15 -> 233
    //   221: ldc_w 482
    //   224: iconst_2
    //   225: ldc_w 1801
    //   228: aload 5
    //   230: invokestatic 865	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   233: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   236: ifeq -204 -> 32
    //   239: aload_0
    //   240: getfield 314	abhh:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   243: ifnull -211 -> 32
    //   246: aload_0
    //   247: getfield 229	abhh:d	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   250: aload_0
    //   251: getfield 314	abhh:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   254: invokevirtual 1606	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   257: invokevirtual 1802	com/tencent/commonsdk/cache/QQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   260: checkcast 220	com/tencent/mobileqq/data/ApolloBaseInfo
    //   263: astore 5
    //   265: aload 5
    //   267: ifnull +9 -> 276
    //   270: aload 5
    //   272: getfield 714	com/tencent/mobileqq/data/ApolloBaseInfo:apolloStatus	I
    //   275: istore_2
    //   276: ldc_w 482
    //   279: iconst_2
    //   280: new 433	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 434	java/lang/StringBuilder:<init>	()V
    //   287: ldc_w 1804
    //   290: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_0
    //   294: getfield 229	abhh:d	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   297: invokevirtual 1805	com/tencent/commonsdk/cache/QQLruCache:size	()I
    //   300: invokevirtual 443	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   303: ldc_w 1807
    //   306: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: iload_1
    //   310: invokevirtual 443	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: ldc_w 1809
    //   316: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: iload_2
    //   320: invokevirtual 443	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   323: invokevirtual 447	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 770	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: return
    //   330: ldc_w 964
    //   333: astore 5
    //   335: goto -286 -> 49
    //   338: astore 5
    //   340: aload 6
    //   342: monitorexit
    //   343: aload 5
    //   345: athrow
    //   346: aload_0
    //   347: getfield 330	abhh:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   350: ldc_w 544
    //   353: invokevirtual 1773	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   356: checkcast 175	java/util/ArrayList
    //   359: astore 6
    //   361: aload 6
    //   363: ifnull +124 -> 487
    //   366: aload_0
    //   367: getfield 206	abhh:jdField_ci_of_type_JavaLangObject	Ljava/lang/Object;
    //   370: astore 5
    //   372: aload 5
    //   374: monitorenter
    //   375: aload_0
    //   376: getfield 209	abhh:wa	Ljava/util/List;
    //   379: invokeinterface 1810 1 0
    //   384: invokestatic 730	java/lang/System:currentTimeMillis	()J
    //   387: ldc2_w 1811
    //   390: ldiv
    //   391: lstore_3
    //   392: aload 6
    //   394: invokeinterface 531 1 0
    //   399: astore 6
    //   401: aload 6
    //   403: invokeinterface 536 1 0
    //   408: ifeq +76 -> 484
    //   411: aload 6
    //   413: invokeinterface 540 1 0
    //   418: checkcast 544	com/tencent/mobileqq/DrawerPushItem
    //   421: astore 7
    //   423: aload 7
    //   425: getfield 589	com/tencent/mobileqq/DrawerPushItem:end_ts	I
    //   428: i2l
    //   429: lload_3
    //   430: lcmp
    //   431: ifle +40 -> 471
    //   434: aload_0
    //   435: aload 7
    //   437: invokevirtual 678	abhh:a	(Lcom/tencent/mobileqq/DrawerPushItem;)Z
    //   440: ifne +31 -> 471
    //   443: aload_0
    //   444: getfield 209	abhh:wa	Ljava/util/List;
    //   447: aload 7
    //   449: invokeinterface 682 2 0
    //   454: pop
    //   455: goto -54 -> 401
    //   458: astore 6
    //   460: aload 5
    //   462: monitorexit
    //   463: aload 6
    //   465: athrow
    //   466: astore 5
    //   468: goto -253 -> 215
    //   471: aload_0
    //   472: getfield 330	abhh:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   475: aload 7
    //   477: invokevirtual 1815	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   480: pop
    //   481: goto -80 -> 401
    //   484: aload 5
    //   486: monitorexit
    //   487: aload_0
    //   488: getfield 314	abhh:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   491: ifnull +61 -> 552
    //   494: aload_0
    //   495: getfield 314	abhh:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   498: invokevirtual 1606	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   501: astore 5
    //   503: aload_0
    //   504: invokestatic 421	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   507: ldc_w 1817
    //   510: iconst_4
    //   511: invokevirtual 1818	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   514: new 433	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 434	java/lang/StringBuilder:<init>	()V
    //   521: aload 5
    //   523: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: ldc_w 1820
    //   529: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: ldc_w 1822
    //   535: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: invokevirtual 447	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: ldc_w 964
    //   544: invokeinterface 968 3 0
    //   549: putfield 1824	abhh:bga	Ljava/lang/String;
    //   552: aload_0
    //   553: iconst_1
    //   554: putfield 1766	abhh:bCC	Z
    //   557: goto -324 -> 233
    //   560: astore 5
    //   562: iconst_0
    //   563: istore_1
    //   564: goto -349 -> 215
    //   567: iconst_0
    //   568: istore_1
    //   569: goto -223 -> 346
    //   572: iconst_0
    //   573: istore_1
    //   574: goto -341 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	577	0	this	abhh
    //   77	497	1	m	int
    //   1	319	2	n	int
    //   52	378	3	l	long
    //   47	138	5	str1	String
    //   213	16	5	localOutOfMemoryError1	OutOfMemoryError
    //   263	71	5	localObject1	Object
    //   338	6	5	localObject2	Object
    //   466	19	5	localOutOfMemoryError2	OutOfMemoryError
    //   501	21	5	str2	String
    //   560	1	5	localOutOfMemoryError3	OutOfMemoryError
    //   458	6	6	localObject5	Object
    //   83	393	7	localObject6	Object
    //   108	86	8	localApolloBaseInfo	ApolloBaseInfo
    // Exception table:
    //   from	to	target	type
    //   78	85	213	java/lang/OutOfMemoryError
    //   85	110	213	java/lang/OutOfMemoryError
    //   115	152	213	java/lang/OutOfMemoryError
    //   152	161	213	java/lang/OutOfMemoryError
    //   179	210	213	java/lang/OutOfMemoryError
    //   343	346	213	java/lang/OutOfMemoryError
    //   161	179	338	finally
    //   340	343	338	finally
    //   375	401	458	finally
    //   401	455	458	finally
    //   460	463	458	finally
    //   471	481	458	finally
    //   484	487	458	finally
    //   346	361	466	java/lang/OutOfMemoryError
    //   366	375	466	java/lang/OutOfMemoryError
    //   463	466	466	java/lang/OutOfMemoryError
    //   487	552	466	java/lang/OutOfMemoryError
    //   552	557	466	java/lang/OutOfMemoryError
    //   49	67	560	java/lang/OutOfMemoryError
    //   72	78	560	java/lang/OutOfMemoryError
  }
  
  private void cBR()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "initApolloPandoraCache begin...");
    }
    try
    {
      ??? = (ArrayList)this.em.query(ApolloPandora.class);
      if (??? != null)
      {
        Iterator localIterator = ((ArrayList)???).iterator();
        while (localIterator.hasNext())
        {
          ApolloPandora localApolloPandora = (ApolloPandora)localIterator.next();
          if ((localApolloPandora != null) && (localApolloPandora.uin != null)) {
            synchronized (this.dr)
            {
              this.dr.put(localApolloPandora.uin, localApolloPandora);
            }
          }
        }
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ApolloManager", 2, "initApolloPandoraCache oom", localOutOfMemoryError);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "initApolloPandoraCache end size:" + this.dr.size());
      }
    }
  }
  
  public static int ce(String paramString)
  {
    int n = 0;
    int m;
    if (abxh.bl == null)
    {
      m = n;
      if (QLog.isColorLevel())
      {
        QLog.d("ApolloManager", 2, "queryApolloSwitchSet key:" + paramString + " sSwitchSet = null");
        m = n;
      }
    }
    do
    {
      do
      {
        return m;
        if (!"gameSwitch".equals(paramString)) {
          break;
        }
        m = n;
      } while (!bCx);
      n = abxh.bl.optInt(paramString);
      m = n;
    } while (n != 2);
    return coI;
    return abxh.bl.optInt(paramString);
  }
  
  public static int d(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "[getCmShowStatus] withStrictCheck=", Boolean.valueOf(paramBoolean) });
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return 0;
            localObject = (abhh)paramQQAppInterface.getManager(153);
            paramString = ((abhh)localObject).a(paramString);
          } while (paramString == null);
          if (!paramBoolean) {
            break;
          }
        } while (!aW(BaseApplicationImpl.getContext()));
        cBH();
      } while ((!bCw) && (!bCy));
      localObject = ((abhh)localObject).a(paramQQAppInterface.getCurrentUin());
    } while ((localObject == null) || (((ApolloBaseInfo)localObject).apolloStatus != 1) || (paramString.apolloStatus != 1));
    int m;
    if ((bCy) && (b(paramQQAppInterface) == 1) && ((paramString.cmshow3dFlag & 0x2) == 2) && ((paramString.cmshow3dFlag & 0x1) == 1)) {
      m = 2;
    }
    for (;;)
    {
      return m;
      if ((bCw) && (a(paramQQAppInterface) == 1) && ((paramString.cmshow3dFlag & 0x1) == 0))
      {
        m = 1;
      }
      else
      {
        m = 0;
        continue;
        if (((paramString.cmshow3dFlag & 0x2) == 2) && ((paramString.cmshow3dFlag & 0x1) == 1)) {
          m = 2;
        } else {
          m = 1;
        }
      }
    }
  }
  
  private void d(TianShuAccess.RspEntry paramRspEntry)
  {
    QLog.d("ApolloManager", 1, "handleAio3dNewActionTipsAdv");
    if ((paramRspEntry == null) || (paramRspEntry.value == null) || (paramRspEntry.value.lst == null) || (paramRspEntry.value.lst.size() == 0)) {
      QLog.e("ApolloManager", 1, "handleAio3dNewActionTipsAdv, data empty");
    }
    int i3;
    int m;
    String str;
    Object localObject4;
    for (;;)
    {
      return;
      i3 = paramRspEntry.value.lst.size();
      QLog.d("ApolloManager", 1, new Object[] { "handleAio3dNewActionTipsAdv, size=", Integer.valueOf(i3) });
      localObject1 = new HashMap();
      m = -1;
      str = "";
      n = 0;
      while (n < i3)
      {
        localObject2 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(n)).argList.get();
        i2 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(n)).iAdId.get();
        QLog.d("ApolloManager", 1, new Object[] { "handleAio3dNewActionTipsAdv, adId=", Integer.valueOf(i2), ", i=", Integer.valueOf(n) });
        if (n == i3 - 1) {}
        for (i1 = 1;; i1 = 0)
        {
          if (i1 == 0) {
            break label953;
          }
          str = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(n)).traceinfo.get();
          m = i2;
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (TianShuAccess.MapEntry)((Iterator)localObject2).next();
            localObject3 = ((TianShuAccess.MapEntry)localObject4).key.get();
            localObject4 = ((TianShuAccess.MapEntry)localObject4).value.get();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, new Object[] { "handleAio3dNewActionTipsAdv keyStr:", localObject3, ", valueStr=", localObject4 });
            }
            if ((i1 != 0) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject4))) {
              ((Map)localObject1).put(localObject3, localObject4);
            }
          }
        }
        n += 1;
      }
      try
      {
        paramRspEntry = this.mApp.getApp().getSharedPreferences("apollo_sp" + this.mApp.getCurrentUin(), 0);
        n = paramRspEntry.getInt("key_new_3d_action_adid", 0);
        QLog.d("ApolloManager", 1, new Object[] { "handleAio3dNewActionTipsAdv, oldAdId=", Integer.valueOf(n), ", newAdId=", Integer.valueOf(m) });
        if (n != m)
        {
          localObject2 = (String)((Map)localObject1).get("packageIdList");
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            QLog.e("ApolloManager", 1, "handleAio3dNewActionTipsAdv, packageIdListStr null");
            return;
          }
        }
      }
      catch (Throwable paramRspEntry)
      {
        QLog.e("ApolloManager", 1, "handleAio3dNewActionTipsAdv Exception:", paramRspEntry);
        return;
      }
    }
    int i1 = Integer.parseInt((String)((Map)localObject1).get("actionId"));
    long l1 = Long.parseLong((String)((Map)localObject1).get("startTime"));
    long l2 = Long.parseLong((String)((Map)localObject1).get("endTime")) - l1;
    Object localObject1 = ((String)localObject2).split(";");
    if ((localObject1 == null) || (localObject1.length == 0))
    {
      QLog.e("ApolloManager", 1, "handleAio3dNewActionTipsAdv, pkgIdList null");
      return;
    }
    Object localObject2 = (abxk)this.mApp.getManager(155);
    Object localObject3 = ((abxk)localObject2).a(i1);
    if ((localObject3 != null) && (((ApolloActionData)localObject3).feeType == 10) && (!ApolloUtil.c(this.mApp, BaseApplicationImpl.getContext())))
    {
      QLog.w("ApolloManager", 1, "handleAio3dNewActionTipsAdv, should not show this action");
      return;
    }
    int i2 = localObject1.length;
    int n = 0;
    for (;;)
    {
      if (n < i2)
      {
        localObject4 = localObject1[n];
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          i3 = Integer.parseInt((String)localObject4);
          QLog.d("ApolloManager", 1, new Object[] { "handleAio3dNewActionTipsAdv, pkgId=", Integer.valueOf(i3) });
          if (localObject3 != null)
          {
            localObject5 = ((abxk)localObject2).a(i3);
            if (localObject5 != null)
            {
              ((ApolloActionPackage)localObject5).isUpdate = true;
              ((ApolloActionPackage)localObject5).redFlowId = i1;
              ((ApolloActionPackage)localObject5).redStartTime = l1;
              ((ApolloActionPackage)localObject5).redInterval = l2;
              ((abxk)localObject2).a((ApolloActionPackage)localObject5);
              He(i3);
              QLog.d("ApolloManager", 1, new Object[] { "handleAio3dNewActionTipsAdv, update red info to db, pkgId=", Integer.valueOf(i3), ", actionId=", Integer.valueOf(i1) });
            }
          }
          Object localObject5 = new JSONObject();
          ((JSONObject)localObject5).put("actionId", i1);
          ((JSONObject)localObject5).put("startTime", l1);
          ((JSONObject)localObject5).put("interval", l2);
          ((JSONObject)localObject5).put("adId", m);
          ((JSONObject)localObject5).put("traceInfo", str);
          paramRspEntry.edit().putString(String.format("key_new_action_info_%s", new Object[] { localObject4 }), ((JSONObject)localObject5).toString()).commit();
        }
      }
      else
      {
        paramRspEntry.edit().putInt("key_new_3d_action_adid", m).commit();
        return;
        label953:
        break;
      }
      n += 1;
    }
  }
  
  private void e(TianShuAccess.RspEntry paramRspEntry)
  {
    QLog.d("ApolloManager", 1, "handleAio2dNewActionTipsAdv");
    if ((paramRspEntry == null) || (paramRspEntry.value == null) || (paramRspEntry.value.lst == null) || (paramRspEntry.value.lst.size() == 0)) {
      QLog.e("ApolloManager", 1, "handleAio2dNewActionTipsAdv, data empty");
    }
    int i3;
    int m;
    String str;
    Object localObject4;
    for (;;)
    {
      return;
      i3 = paramRspEntry.value.lst.size();
      QLog.d("ApolloManager", 1, new Object[] { "handleAio2dNewActionTipsAdv, size=", Integer.valueOf(i3) });
      localObject1 = new HashMap();
      m = -1;
      str = "";
      n = 0;
      while (n < i3)
      {
        localObject2 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(n)).argList.get();
        i2 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(n)).iAdId.get();
        QLog.d("ApolloManager", 1, new Object[] { "handleAio2dNewActionTipsAdv, adId=", Integer.valueOf(i2), ", i=", Integer.valueOf(n) });
        if (n == i3 - 1) {}
        for (i1 = 1;; i1 = 0)
        {
          if (i1 == 0) {
            break label914;
          }
          str = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(n)).traceinfo.get();
          m = i2;
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (TianShuAccess.MapEntry)((Iterator)localObject2).next();
            localObject3 = ((TianShuAccess.MapEntry)localObject4).key.get();
            localObject4 = ((TianShuAccess.MapEntry)localObject4).value.get();
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, new Object[] { "handleAio2dNewActionTipsAdv keyStr:", localObject3, ", valueStr=", localObject4 });
            }
            if ((i1 != 0) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject4))) {
              ((Map)localObject1).put(localObject3, localObject4);
            }
          }
        }
        n += 1;
      }
      try
      {
        paramRspEntry = this.mApp.getApp().getSharedPreferences("apollo_sp" + this.mApp.getCurrentUin(), 0);
        n = paramRspEntry.getInt("key_new_2d_action_adid", 0);
        QLog.d("ApolloManager", 1, new Object[] { "handleAio2dNewActionTipsAdv, oldAdId=", Integer.valueOf(n), ", newAdId=", Integer.valueOf(m) });
        if (n != m)
        {
          localObject2 = (String)((Map)localObject1).get("packageIdList");
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            QLog.e("ApolloManager", 1, "handleAio2dNewActionTipsAdv, packageIdListStr null");
            return;
          }
        }
      }
      catch (Throwable paramRspEntry)
      {
        QLog.e("ApolloManager", 1, "handleAio2dNewActionTipsAdv Exception:", paramRspEntry);
        return;
      }
    }
    int i1 = Integer.parseInt((String)((Map)localObject1).get("actionId"));
    long l1 = Long.parseLong((String)((Map)localObject1).get("startTime"));
    long l2 = Long.parseLong((String)((Map)localObject1).get("endTime")) - l1;
    Object localObject1 = ((String)localObject2).split(";");
    if ((localObject1 == null) || (localObject1.length == 0))
    {
      QLog.e("ApolloManager", 1, "handleAio2dNewActionTipsAdv, pkgIdList null");
      return;
    }
    Object localObject2 = (abxk)this.mApp.getManager(155);
    Object localObject3 = ((abxk)localObject2).a(i1);
    int i2 = localObject1.length;
    int n = 0;
    for (;;)
    {
      if (n < i2)
      {
        localObject4 = localObject1[n];
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          i3 = Integer.parseInt((String)localObject4);
          QLog.d("ApolloManager", 1, new Object[] { "handleAio2dNewActionTipsAdv, pkgId=", Integer.valueOf(i3) });
          if (localObject3 != null)
          {
            localObject5 = ((abxk)localObject2).a(i3);
            if (localObject5 != null)
            {
              ((ApolloActionPackage)localObject5).isUpdate = true;
              ((ApolloActionPackage)localObject5).redFlowId = i1;
              ((ApolloActionPackage)localObject5).redStartTime = l1;
              ((ApolloActionPackage)localObject5).redInterval = l2;
              ((abxk)localObject2).a((ApolloActionPackage)localObject5);
              He(i3);
              QLog.d("ApolloManager", 1, new Object[] { "handleAio2dNewActionTipsAdv, update red info to db, pkgId=", Integer.valueOf(i3), ", actionId=", Integer.valueOf(i1) });
            }
          }
          Object localObject5 = new JSONObject();
          ((JSONObject)localObject5).put("actionId", i1);
          ((JSONObject)localObject5).put("startTime", l1);
          ((JSONObject)localObject5).put("interval", l2);
          ((JSONObject)localObject5).put("adId", m);
          ((JSONObject)localObject5).put("traceInfo", str);
          paramRspEntry.edit().putString(String.format("key_new_action_info_%s", new Object[] { localObject4 }), ((JSONObject)localObject5).toString()).commit();
        }
      }
      else
      {
        paramRspEntry.edit().putInt("key_new_2d_action_adid", m).commit();
        return;
        label914:
        break;
      }
      n += 1;
    }
  }
  
  private void f(TianShuAccess.RspEntry paramRspEntry)
  {
    QLog.d("ApolloManager", 1, "handleAio2dBubbleAdv");
    if ((paramRspEntry == null) || (paramRspEntry.value == null) || (paramRspEntry.value.lst == null) || (paramRspEntry.value.lst.size() == 0))
    {
      QLog.e("ApolloManager", 1, "handleAio2dBubbleAdv, data empty");
      return;
    }
    int i3 = paramRspEntry.value.lst.size();
    QLog.d("ApolloManager", 1, new Object[] { "handleAio2dBubbleAdv, size=", Integer.valueOf(i3) });
    HashMap localHashMap = new HashMap();
    int m = 0;
    Object localObject1 = "";
    int n = 0;
    label110:
    Object localObject2;
    int i1;
    if (n < i3)
    {
      localObject2 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(n)).argList.get();
      int i2 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(n)).iAdId.get();
      QLog.d("ApolloManager", 1, new Object[] { "handleAio2dBubbleAdv, adId=", Integer.valueOf(i2), ", i=", Integer.valueOf(n) });
      if (n == i3 - 1)
      {
        i1 = 1;
        if (i1 == 0) {
          break label798;
        }
        localObject1 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(n)).traceinfo.get();
        m = i2;
      }
    }
    label798:
    for (;;)
    {
      localObject2 = ((List)localObject2).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (TianShuAccess.MapEntry)((Iterator)localObject2).next();
          String str = ((TianShuAccess.MapEntry)localObject3).key.get();
          localObject3 = ((TianShuAccess.MapEntry)localObject3).value.get();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, new Object[] { "handleAio2dBubbleAdv keyStr:", str, ", valueStr=", localObject3 });
          }
          if ((i1 != 0) && (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
          {
            localHashMap.put(str, localObject3);
            continue;
            i1 = 0;
            break;
          }
        }
      }
      n += 1;
      break label110;
      for (;;)
      {
        try
        {
          localObject2 = this.mApp.getApp().getSharedPreferences("apollo_sp" + this.mApp.getCurrentUin(), 0);
          n = ((SharedPreferences)localObject2).getInt("key_2d_bubble_ad_id", 0);
          QLog.d("ApolloManager", 1, new Object[] { "handleAio2dBubbleAdv oldAdId:", Integer.valueOf(n), ", newAdId=", Integer.valueOf(m) });
          if (n == m) {
            break;
          }
          paramRspEntry = new DrawerPushItem();
          paramRspEntry.is_reddot = 0;
          paramRspEntry.msg_id = "aio_panel_bubble_push";
          paramRspEntry.msg_type = 7;
          paramRspEntry.priority = 1000;
          i1 = (int)Long.parseLong((String)localHashMap.get("startTime")) / 1000;
          paramRspEntry.start_ts = i1;
          n = (int)NetConnInfoCenter.getServerTime();
          paramRspEntry.end_ts = ((int)Long.parseLong((String)localHashMap.get("endTime")) / 1000 - i1 + n);
          paramRspEntry.send_time = i1;
          paramRspEntry.content = ((String)localHashMap.get("bubbleText"));
          paramRspEntry.show_counts = Integer.parseInt((String)localHashMap.get("showCount"));
          paramRspEntry.tianshuAdId = m;
          paramRspEntry.tianshuTraceInfo = ((String)localObject1);
          if (paramRspEntry.show_counts == 0) {
            paramRspEntry.show_counts = 1;
          }
          localObject1 = (String)localHashMap.get("packageId");
          m = 0;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            m = Integer.parseInt((String)localObject1);
          }
          if (ApolloActionPackage.is3DPackage(m))
          {
            n = 3;
            paramRspEntry.target_model = n;
            c(paramRspEntry);
            localObject1 = ((SharedPreferences)localObject2).edit();
            ((SharedPreferences.Editor)localObject1).putInt("key_2d_bubble_ad_id", i1);
            if (m >= 0) {
              ((SharedPreferences.Editor)localObject1).putInt("key_panel_bubble_tab", m);
            }
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, new Object[] { "handleAio2dBubbleAdv", " push bubble:", paramRspEntry.toString(), " ,packageId:", Integer.valueOf(m) });
            }
            ((SharedPreferences.Editor)localObject1).commit();
            return;
          }
        }
        catch (Throwable paramRspEntry)
        {
          QLog.e("ApolloManager", 1, "handleAio2dBubbleAdv Exception:", paramRspEntry);
          return;
        }
        n = 2;
      }
    }
  }
  
  public static void g(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    QLog.d("ApolloManager", 1, new Object[] { "tianshuReport action:", Integer.valueOf(paramInt), ", itemId=", paramString1, ",traceInfo=", paramString2, ", bizInfo=", paramString3 });
    awmu localawmu = new awmu();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localawmu.mTraceId = (str + "_" + l);
    localawmu.eBX = 1;
    localawmu.mAppId = "tianshu.75";
    localawmu.cNQ = "tianshu.75";
    localawmu.cNR = paramString1;
    localawmu.cRG = "";
    localawmu.aBn = l;
    localawmu.mActionId = paramInt;
    localawmu.eBB = 1;
    localawmu.eBZ = 1;
    localawmu.cRJ = paramString2;
    if (!TextUtils.isEmpty(paramString3)) {
      localawmu.cRK = paramString3;
    }
    awmt.a().a(localawmu);
  }
  
  public static void g(AppInterface paramAppInterface)
  {
    ThreadManager.getFileThreadHandler().post(new ApolloManager.13(paramAppInterface));
  }
  
  public static void g(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Object localObject = (abhh)paramQQAppInterface.getManager(153);
    aqrb localaqrb = (aqrb)paramQQAppInterface.getBusinessHandler(71);
    ApolloBaseInfo localApolloBaseInfo = ((abhh)localObject).b(paramString1 + "");
    if ((localApolloBaseInfo == null) || (localApolloBaseInfo.apolloUpdateTime == 0L))
    {
      localaqrb.Vx(paramString1 + "");
      if (QLog.isColorLevel()) {
        if (paramString1.length() < 4) {
          break label447;
        }
      }
    }
    label447:
    for (paramQQAppInterface = paramString1.substring(0, 4);; paramQQAppInterface = paramString1)
    {
      QLog.d("ApolloManager", 2, "checkUserDress---> getApolloBaseInfo uin: " + paramQQAppInterface);
      do
      {
        do
        {
          if ((QLog.isColorLevel()) && (localApolloBaseInfo != null) && (!localApolloBaseInfo.isApolloStatusOpen())) {
            QLog.d("ApolloManager", 2, "checkUserDress---> user apollo status is not open uin: " + paramString1 + ", status: " + localApolloBaseInfo.apolloStatus);
          }
          if ((localApolloBaseInfo == null) || (!localApolloBaseInfo.isApolloStatusOpen()) || (0L == localApolloBaseInfo.apolloSignValidTS) || (NetConnInfoCenter.getServerTime() >= localApolloBaseInfo.apolloSignValidTS) || (localApolloBaseInfo.apolloSignValidTS == localApolloBaseInfo.apolloLocalSignTs)) {
            break;
          }
          localaqrb.ir(paramString1, "AIO");
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloManager", 2, "getUserSignStr...");
          return;
        } while ((!localApolloBaseInfo.isApolloStatusOpen()) || (localApolloBaseInfo.apolloServerTS == localApolloBaseInfo.apolloLocalTS));
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(Long.valueOf(Long.parseLong(paramString1)));
        localObject = ((abhh)localObject).b(paramQQAppInterface.getCurrentUin());
        if ((localObject != null) && (((ApolloBaseInfo)localObject).apolloLocalTS != ((ApolloBaseInfo)localObject).apolloServerTS)) {
          localArrayList.add(Long.valueOf(paramQQAppInterface.getLongAccountUin()));
        }
        localaqrb.m(localArrayList, paramString2);
      } while (!QLog.isColorLevel());
      if (paramString1.length() >= 4) {}
      for (paramQQAppInterface = paramString1.substring(0, 4);; paramQQAppInterface = paramString1)
      {
        QLog.d("ApolloManager", 2, "checkUserDress---> getGetUserApolloDress uin: " + paramQQAppInterface + ", old dress: " + localApolloBaseInfo.getApolloDress());
        break;
      }
    }
  }
  
  public static int h(QQAppInterface paramQQAppInterface, String paramString)
  {
    return d(paramQQAppInterface, paramString, true);
  }
  
  public static int lf()
  {
    if ((bCv) && (abxh.bGg)) {
      return 3;
    }
    return 2;
  }
  
  public static SharedPreferences o()
  {
    String str2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "noLogin";
    }
    return BaseApplicationImpl.getApplication().getSharedPreferences("apollo_stand_up" + str1, 4);
  }
  
  public static String s(String paramString, boolean paramBoolean)
  {
    String str1 = "";
    String str2;
    if ("mall".equals(paramString))
    {
      str1 = abxi.bju;
      str2 = str1;
      if (paramBoolean)
      {
        if (!"game_city".equals(paramString)) {
          break label111;
        }
        str2 = abxi.bjz;
      }
    }
    label111:
    do
    {
      return str2;
      if (("interact".equals(paramString)) || ("interactive".equals(paramString)))
      {
        str1 = abxi.bjv;
        break;
      }
      if ("3d_mall".equals(paramString))
      {
        str1 = abxi.bjA;
        break;
      }
      if ((!"3d_interact".equals(paramString)) && (!"3d_interactive".equals(paramString))) {
        break;
      }
      str1 = abxi.bjB;
      break;
      str2 = str1;
    } while (!"3d_game_city".equals(paramString));
    return abxi.bjC;
  }
  
  public static void t(int paramInt, String paramString1, String paramString2)
  {
    g(paramInt, paramString1, paramString2, null);
  }
  
  /* Error */
  public static void v(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +40 -> 49
    //   12: ldc_w 482
    //   15: iconst_2
    //   16: new 433	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 434	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 2152
    //   26: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc_w 2154
    //   36: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_2
    //   40: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 447	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 770	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: new 732	java/io/File
    //   52: dup
    //   53: getstatic 758	abxi:bim	Ljava/lang/String;
    //   56: invokespecial 838	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: invokevirtual 775	java/io/File:mkdirs	()Z
    //   62: pop
    //   63: aload_0
    //   64: invokevirtual 2158	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   67: aload_1
    //   68: invokevirtual 2164	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   71: astore_0
    //   72: new 2166	java/io/FileOutputStream
    //   75: dup
    //   76: new 732	java/io/File
    //   79: dup
    //   80: aload_2
    //   81: invokespecial 838	java/io/File:<init>	(Ljava/lang/String;)V
    //   84: invokespecial 2169	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   87: astore_1
    //   88: sipush 4096
    //   91: newarray byte
    //   93: astore_2
    //   94: aload_0
    //   95: aload_2
    //   96: invokevirtual 2175	java/io/InputStream:read	([B)I
    //   99: istore_3
    //   100: iload_3
    //   101: iconst_m1
    //   102: if_icmpeq +77 -> 179
    //   105: aload_1
    //   106: aload_2
    //   107: iconst_0
    //   108: iload_3
    //   109: invokevirtual 2179	java/io/FileOutputStream:write	([BII)V
    //   112: goto -18 -> 94
    //   115: astore 4
    //   117: aload_0
    //   118: astore_2
    //   119: aload 4
    //   121: astore_0
    //   122: aload_0
    //   123: invokevirtual 2182	java/lang/Exception:printStackTrace	()V
    //   126: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +33 -> 162
    //   132: ldc_w 482
    //   135: iconst_2
    //   136: new 433	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 434	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 793
    //   146: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_0
    //   150: invokevirtual 669	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   153: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 447	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 770	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_2
    //   163: ifnull +7 -> 170
    //   166: aload_2
    //   167: invokevirtual 2185	java/io/InputStream:close	()V
    //   170: aload_1
    //   171: ifnull +7 -> 178
    //   174: aload_1
    //   175: invokevirtual 2186	java/io/FileOutputStream:close	()V
    //   178: return
    //   179: aload_1
    //   180: invokevirtual 2189	java/io/FileOutputStream:flush	()V
    //   183: aload_0
    //   184: ifnull +7 -> 191
    //   187: aload_0
    //   188: invokevirtual 2185	java/io/InputStream:close	()V
    //   191: aload_1
    //   192: ifnull -14 -> 178
    //   195: aload_1
    //   196: invokevirtual 2186	java/io/FileOutputStream:close	()V
    //   199: return
    //   200: astore_0
    //   201: return
    //   202: astore_0
    //   203: aconst_null
    //   204: astore_1
    //   205: aload 5
    //   207: astore_2
    //   208: aload_2
    //   209: ifnull +7 -> 216
    //   212: aload_2
    //   213: invokevirtual 2185	java/io/InputStream:close	()V
    //   216: aload_1
    //   217: ifnull +7 -> 224
    //   220: aload_1
    //   221: invokevirtual 2186	java/io/FileOutputStream:close	()V
    //   224: aload_0
    //   225: athrow
    //   226: astore_1
    //   227: goto -3 -> 224
    //   230: astore 4
    //   232: aconst_null
    //   233: astore_1
    //   234: aload_0
    //   235: astore_2
    //   236: aload 4
    //   238: astore_0
    //   239: goto -31 -> 208
    //   242: astore 4
    //   244: aload_0
    //   245: astore_2
    //   246: aload 4
    //   248: astore_0
    //   249: goto -41 -> 208
    //   252: astore_0
    //   253: goto -45 -> 208
    //   256: astore_0
    //   257: return
    //   258: astore_0
    //   259: aconst_null
    //   260: astore_1
    //   261: aload 4
    //   263: astore_2
    //   264: goto -142 -> 122
    //   267: astore 4
    //   269: aconst_null
    //   270: astore_1
    //   271: aload_0
    //   272: astore_2
    //   273: aload 4
    //   275: astore_0
    //   276: goto -154 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	paramContext	Context
    //   0	279	1	paramString1	String
    //   0	279	2	paramString2	String
    //   99	10	3	m	int
    //   4	1	4	localObject1	Object
    //   115	5	4	localException1	Exception
    //   230	7	4	localObject2	Object
    //   242	20	4	localObject3	Object
    //   267	7	4	localException2	Exception
    //   1	205	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   88	94	115	java/lang/Exception
    //   94	100	115	java/lang/Exception
    //   105	112	115	java/lang/Exception
    //   179	183	115	java/lang/Exception
    //   187	191	200	java/lang/Exception
    //   195	199	200	java/lang/Exception
    //   49	72	202	finally
    //   212	216	226	java/lang/Exception
    //   220	224	226	java/lang/Exception
    //   72	88	230	finally
    //   88	94	242	finally
    //   94	100	242	finally
    //   105	112	242	finally
    //   179	183	242	finally
    //   122	162	252	finally
    //   166	170	256	java/lang/Exception
    //   174	178	256	java/lang/Exception
    //   49	72	258	java/lang/Exception
    //   72	88	267	java/lang/Exception
  }
  
  public static int x(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        return 0;
      } while (!aW(BaseApplicationImpl.getContext()));
      cBH();
    } while ((!bCw) && (!bCy));
    ApolloBaseInfo localApolloBaseInfo = ((abhh)paramQQAppInterface.getManager(153)).a(paramQQAppInterface.getCurrentUin());
    int m;
    if ((localApolloBaseInfo != null) && (localApolloBaseInfo.apolloStatus == 1)) {
      if ((bCy) && (b(paramQQAppInterface) == 1))
      {
        m = 1;
        if ((m == 0) || ((localApolloBaseInfo.cmshow3dFlag & 0x1) != 1)) {
          break label99;
        }
        m = 2;
      }
    }
    for (;;)
    {
      return m;
      m = 0;
      break;
      label99:
      if ((bCw) && (a(paramQQAppInterface) == 1)) {}
      for (m = 1;; m = 0)
      {
        if (m == 0) {
          break label129;
        }
        m = 1;
        break;
      }
      label129:
      m = 0;
    }
  }
  
  public void BD(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.executeOnSubThread(new ApolloManager.18(this, paramString));
  }
  
  public void BE(String paramString)
  {
    synchronized (this.jdField_ci_of_type_JavaLangObject)
    {
      if ((this.wa == null) || (this.wa.isEmpty())) {
        return;
      }
      Iterator localIterator = this.wa.iterator();
      while (localIterator.hasNext())
      {
        DrawerPushItem localDrawerPushItem = (DrawerPushItem)localIterator.next();
        if ((localDrawerPushItem.msg_id != null) && (localDrawerPushItem.msg_id.equals(paramString)))
        {
          localDrawerPushItem.show_sum = localDrawerPushItem.show_counts;
          this.wa.remove(localDrawerPushItem);
          this.em.remove(localDrawerPushItem);
          if (QLog.isColorLevel()) {
            QLog.i("ApolloManager", 2, "remove bubble:" + localDrawerPushItem.msg_id);
          }
          return;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("ApolloManager", 2, "remove bubble failed:" + paramString);
    }
  }
  
  public void BF(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "[updateLastShopTabInfo] tab=", paramString });
    }
    if (this.mApp == null) {
      return;
    }
    this.bga = paramString;
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0).edit();
    String str = this.mApp.getCurrentAccountUin() + "_" + "sp_key_last_shop_tab";
    if (!TextUtils.isEmpty(paramString)) {
      localEditor.putString(str, this.bga);
    }
    for (;;)
    {
      localEditor.commit();
      return;
      localEditor.remove(str);
    }
  }
  
  public void BG(String paramString)
  {
    QLog.d("ApolloManager", 1, new Object[] { "[predownloadForGameCenter] predownloadStr=", paramString });
    if (this.mApp == null) {
      QLog.e("ApolloManager", 1, "[predownloadForGameCenter] mApp null");
    }
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      int m;
      int i2;
      int i3;
      long l1;
      long l2;
      int i1;
      long l3;
      int n;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("predownloadList");
        if ((paramString == null) || (paramString.length() <= 0)) {
          break;
        }
        m = 0;
        if (m >= paramString.length()) {
          break;
        }
        localObject1 = paramString.getJSONObject(m);
        i2 = ((JSONObject)localObject1).optInt("platform");
        i3 = ((JSONObject)localObject1).optInt("netType");
        l1 = ((JSONObject)localObject1).optLong("beginTime");
        l2 = ((JSONObject)localObject1).optLong("endTime");
        str1 = ((JSONObject)localObject1).optString("minQQVer");
        localObject2 = ((JSONObject)localObject1).optString("maxQQVer");
        i1 = jqc.getNetWorkType();
        l3 = NetConnInfoCenter.getServerTime();
        n = i1;
        if (i1 != 1) {
          break label514;
        }
        n = 10;
      }
      catch (Exception paramString)
      {
        Object localObject1;
        String str1;
        Object localObject2;
        String str2;
        QLog.e("ApolloManager", 1, "[predownloadForGameCenter] exception=", paramString);
        return;
      }
      if (abxh.l("3.4.4", str1, (String)localObject2))
      {
        n = ((JSONObject)localObject1).optInt("type");
        str1 = ((JSONObject)localObject1).optString("downloadInfo");
        if (!TextUtils.isEmpty(str1))
        {
          localObject2 = this.mApp.getApplication().getSharedPreferences("apollo_sp", 0);
          str2 = "sp_key_game_center_predownload_res_" + str1;
          i1 = ((SharedPreferences)localObject2).getInt(str2, -1);
          i2 = ((JSONObject)localObject1).optInt("configVer");
          boolean bool1;
          boolean bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloManager", 1, new Object[] { "[predownloadForGameCenter] downloadInfo=", str1, ", downloadedVersion=", Integer.valueOf(i1), ", configVersion=", Integer.valueOf(i2) });
            break label551;
            QLog.d("ApolloManager", 1, new Object[] { "[predownloadForGameCenter] shouldDownload=", Boolean.valueOf(bool1), ", bid=", str1 });
            if (!bool1) {
              break label571;
            }
            ThreadManager.executeOnFileThread(new ApolloManager.21(this, str1, (SharedPreferences)localObject2, str2, i2));
            break label571;
            localObject1 = jpe.dO(str1);
            bool1 = bool2;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              continue;
            }
            localObject1 = new File((String)localObject1 + str1 + "/b.zip");
            bool1 = bool2;
            if (localObject1 == null) {
              continue;
            }
            bool1 = bool2;
            if (((File)localObject1).exists()) {
              continue;
            }
            QLog.d("ApolloManager", 1, new Object[] { "[predownloadForGameCenter] no zip file for bid:", str1 });
            bool1 = true;
            continue;
            label514:
            if ((n < i3) || (l3 < l1) || (l1 > l2)) {
              break label571;
            }
            if (i2 == 0) {
              continue;
            }
            if (i2 != 109) {
              break label571;
            }
            continue;
          }
          label551:
          if (n == 0)
          {
            bool2 = false;
            if (i2 <= i1) {
              continue;
            }
            bool1 = true;
            continue;
          }
        }
      }
      label571:
      m += 1;
    }
  }
  
  void DA(boolean paramBoolean)
  {
    int m = ce("gameBoxGrayStatus");
    if (m == 1) {
      this.bCE = paramBoolean;
    }
    for (;;)
    {
      QLog.d("ApolloManager", 1, "upDateGameBoxUserStatus switch: " + m + ", oidb Status: " + paramBoolean);
      return;
      if (m == 2) {
        this.bCE = true;
      } else {
        this.bCE = false;
      }
    }
  }
  
  public void Hd(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "[downloadJson], task:" + paramInt);
    }
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Bundle localBundle = new Bundle();
    if ((paramInt & 0x1) == 1)
    {
      ((List)localObject).add("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipList_apollo_data/tab_list_android_v730.json");
      localArrayList.add(ApolloUtil.bkb);
      localHashMap.put("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipList_apollo_data/tab_list_android_v730.json", new File(ApolloUtil.bkb));
      localBundle.putInt("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipList_apollo_data/tab_list_android_v730.json", 1);
    }
    if (a() != null)
    {
      localObject = new aquz((List)localObject, localHashMap, "apollo_json_task" + System.currentTimeMillis());
      ((aquz)localObject).cWy = true;
      ((aquz)localObject).cWs = false;
      ((aquz)localObject).cWw = true;
      ((aquz)localObject).cWB = false;
      ((aquz)localObject).cxX = "apollo_res";
      ((aquz)localObject).cWA = true;
      ((aquz)localObject).cWz = true;
      a().a((aquz)localObject, this.i, localBundle);
      if ((paramInt & 0x1) == 1) {
        VipUtils.a(this.mApp, "cmshow", "Apollo", "json_download_begin", 0, 0, new String[0]);
      }
      if ((paramInt & 0x2) == 2) {
        VipUtils.a(this.mApp, "cmshow", "Apollo", "json_download_begin", 1, 0, new String[0]);
      }
    }
  }
  
  public void Hf(int paramInt)
  {
    int m;
    if (this.mApp != null)
    {
      this.mApp.getApplication().getSharedPreferences("apollo_sp", 0).edit().putInt(this.mApp.getCurrentAccountUin() + "_whiteList", paramInt).commit();
      m = aqmj.bb(this.mApp.getApplication());
      if (m != 0) {
        break label139;
      }
      coG = paramInt;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "update white list " + m + ", mWhiteUserStatus: " + coG + ", status: " + paramInt);
      }
      return;
      label139:
      if (1 == m) {
        coG = 1;
      } else {
        coG = 0;
      }
    }
  }
  
  public void Hg(int paramInt)
  {
    int m;
    if (this.mApp != null)
    {
      this.mApp.getApplication().getSharedPreferences("apollo_sp", 0).edit().putInt(this.mApp.getCurrentAccountUin() + "_3dwhiteList", paramInt).commit();
      m = aqmj.bc(this.mApp.getApplication());
      if (m != 0) {
        break label137;
      }
      coH = paramInt;
    }
    for (;;)
    {
      QLog.d("ApolloManager", 1, new Object[] { "[update3dWhiteList] global=", Integer.valueOf(m), ", s3dWhiteUserStatus=", Integer.valueOf(coH), ", status=", Integer.valueOf(paramInt) });
      return;
      label137:
      if (1 == m) {
        coH = 1;
      } else {
        coH = 0;
      }
    }
  }
  
  public void Hi(int paramInt)
  {
    boolean bool = true;
    if (1 == (paramInt >> 10 & 0x1)) {}
    for (;;)
    {
      DA(bool);
      return;
      bool = false;
    }
  }
  
  public void Hj(int paramInt)
  {
    if (this.mApp == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "pushApolloPanelGame gameId:", Integer.valueOf(paramInt) });
    }
    abxk localabxk = (abxk)this.mApp.getManager(155);
    ApolloActionPackage localApolloActionPackage = localabxk.a(100);
    if ((localApolloActionPackage != null) && (!localApolloActionPackage.isUpdate))
    {
      localApolloActionPackage.isUpdate = true;
      localabxk.a(localApolloActionPackage);
    }
    ApolloGameUtil.a(this.mApp, paramInt, false);
  }
  
  public boolean Yb()
  {
    if (this.jdField_ci_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() == true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "apollo json is parsing,return.");
      }
      return true;
    }
    this.jdField_ci_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    Object localObject3 = null;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    Object localObject1;
    int m;
    label218:
    long l;
    try
    {
      localObject1 = aqhq.readFileToString(new File(ApolloUtil.bkb));
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("parseActionPanelJSon start file size:");
        if (localObject1 == null)
        {
          m = 0;
          QLog.d("ApolloManager", 2, m + " byte");
        }
      }
      else
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label218;
        }
        this.jdField_ci_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.e("ApolloManager", 2, "read json fail e =" + localThrowable.toString());
          localObject1 = localObject3;
          continue;
          m = ((String)localObject1).length();
        }
      }
      l = System.currentTimeMillis();
    }
    for (;;)
    {
      int n;
      try
      {
        if ((this.ii == null) || (this.ii.size() <= 0)) {
          break label1209;
        }
        m = 1;
        localObject1 = new JSONObject((String)localObject1);
        localObject3 = ((JSONObject)localObject1).getJSONArray("tabList");
        n = 0;
        if (n < ((JSONArray)localObject3).length())
        {
          String str = ((JSONArray)localObject3).getString(n);
          JSONObject localJSONObject = ((JSONObject)localObject1).optJSONObject(str);
          if ("actionInfo".equals(str))
          {
            a(localArrayList1, localArrayList2, localArrayList3, localJSONObject);
            if (!QLog.isColorLevel()) {
              break label1202;
            }
            QLog.d("ApolloManager", 2, "apollo json tablist :" + str);
            break label1202;
          }
          if (!"gameInfo".equals(str)) {
            continue;
          }
          continue;
        }
        ((JSONObject)localObject1).optJSONObject("bubbleInfo");
        if (((JSONObject)localObject1).has("Info3D"))
        {
          QLog.d("ApolloManager", 1, "parseActionPanelJSon parse info3d");
          localObject3 = ((JSONObject)localObject1).optJSONObject("Info3D");
          if (((JSONObject)localObject3).has("actionInfo")) {
            a(localArrayList1, localArrayList2, localArrayList3, ((JSONObject)localObject3).optJSONObject("actionInfo"));
          }
          if ((!((JSONObject)localObject3).has("appConfig")) || (((JSONObject)localObject3).has("bubbleInfo"))) {
            ((JSONObject)localObject3).optJSONObject("bubbleInfo");
          }
        }
        if (((JSONObject)localObject1).has("whiteFace")) {
          a(((JSONObject)localObject1).optJSONObject("whiteFace"), localArrayList4);
        }
        if (this.mApp != null)
        {
          localObject3 = (abxk)this.mApp.getManager(155);
          ((abxk)localObject3).I(false, localArrayList4);
          ((abxk)localObject3).cGa();
          ((abxk)localObject3).il(localArrayList1);
          ((abxk)localObject3).Io(1);
          ((abxk)localObject3).io(localArrayList2);
          ((abxk)localObject3).cGc();
          ((abxk)localObject3).ip(localArrayList3);
          if ((m == 0) && (!bCz))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ApolloManager", 1, "parseActionPanelJSon request getUserApolloInfo~");
            }
            ((aqrb)this.mApp.getBusinessHandler(71)).ag(this.mApp.getCurrentUin(), 128, "refreshAction");
          }
          this.jdField_a_of_type_Abyt.m(Boolean.valueOf(true));
          cBV();
        }
        if (this.mApp != null)
        {
          this.mApp.getApplication().getSharedPreferences(this.mApp.getCurrentAccountUin(), 0).edit().putBoolean("chat_tool_apollo_" + this.mApp.getCurrentAccountUin(), true).commit();
          localObject3 = this.mApp.getApplication().getSharedPreferences("apollo_sp", 0);
          if (!((SharedPreferences)localObject3).getBoolean("3.4.4" + this.mApp.getCurrentAccountUin(), false)) {
            ((SharedPreferences)localObject3).edit().putBoolean("3.4.4" + this.mApp.getCurrentAccountUin(), true).commit();
          }
          if (localObject1 != null)
          {
            m = (int)(((JSONObject)localObject1).optLong("timeStamp") / 1000L);
            ((SharedPreferences)localObject3).edit().putInt("apollo_json_version" + this.mApp.getCurrentAccountUin(), m).commit();
            ((SharedPreferences)localObject3).edit().putInt("apollo_json_version", m).commit();
          }
        }
        localObject1 = ((JSONObject)localObject1).optJSONArray("petConfig");
        if ((localObject1 != null) && (this.mApp != null))
        {
          this.mApp.getApplication().getSharedPreferences("apollo_pet_sp", 0).edit().putString("pet_config", ((JSONArray)localObject1).toString()).commit();
          this.bfZ = ((JSONArray)localObject1).toString();
          n = ((JSONArray)localObject1).length();
          m = 0;
          if (m < n)
          {
            localObject3 = ((JSONArray)localObject1).getJSONObject(m);
            int i1 = ((JSONObject)localObject3).optInt("standUpAction", 0);
            int i2 = ((JSONObject)localObject3).optInt("getDownAction", 0);
            gC(i1, 0);
            gC(i2, 0);
            m += 1;
            continue;
          }
        }
        if (this.mApp != null) {
          ((abhh)this.mApp.getManager(153)).cBU();
        }
      }
      catch (Exception localException)
      {
        QLog.e("ApolloManager", 1, "parseActionPanelJSon failed", localException);
        this.jdField_ci_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        QLog.d("ApolloManager", 1, "parseActionPanelJSon end cost: " + (System.currentTimeMillis() - l) + "ms");
        continue;
      }
      finally
      {
        this.jdField_ci_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        QLog.d("ApolloManager", 1, "parseActionPanelJSon end cost: " + (System.currentTimeMillis() - l) + "ms");
      }
      this.jdField_ci_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return true;
      label1202:
      n += 1;
      continue;
      label1209:
      m = 0;
    }
  }
  
  public boolean Yh()
  {
    boolean bool = false;
    if ((BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getBoolean("is_new_user_bar_showed" + abmt.getAppInterface().getCurrentAccountUin(), false)) || (this.bCI)) {
      bool = true;
    }
    return bool;
  }
  
  public boolean Yi()
  {
    boolean bool = false;
    if ((BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getBoolean("is_780_guide_showed" + abmt.getAppInterface().getCurrentAccountUin(), false)) || (this.bCM)) {
      bool = true;
    }
    return bool;
  }
  
  public boolean Yj()
  {
    if (this.mApp == null) {}
    do
    {
      return false;
      if ((BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getBoolean("is_white" + this.mApp.getCurrentAccountUin(), false)) || (this.bCG)) {
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloManager", 2, "isPlusWhiteList false");
    return false;
  }
  
  public boolean Yk()
  {
    return this.jdField_a_of_type_Ablz != null;
  }
  
  public abhf a()
  {
    return this.jdField_a_of_type_Abhf;
  }
  
  public abhh.e a()
  {
    if (this.jdField_a_of_type_Abhh$e == null) {}
    try
    {
      if (this.jdField_a_of_type_Abhh$e == null) {
        this.jdField_a_of_type_Abhh$e = new abhh.e(null);
      }
      return this.jdField_a_of_type_Abhh$e;
    }
    finally {}
  }
  
  public abhs a()
  {
    return this.jdField_a_of_type_Abhs;
  }
  
  public abjy a()
  {
    return this.jdField_a_of_type_Abjy;
  }
  
  public ablz a()
  {
    try
    {
      if (this.jdField_a_of_type_Ablz == null) {
        this.jdField_a_of_type_Ablz = new ablz(this.mApp);
      }
      ablz localablz = this.jdField_a_of_type_Ablz;
      return localablz;
    }
    finally {}
  }
  
  public abmb a()
  {
    try
    {
      if (this.jdField_a_of_type_Abmb == null) {
        this.jdField_a_of_type_Abmb = new abmb(this.mApp);
      }
      abmb localabmb = this.jdField_a_of_type_Abmb;
      return localabmb;
    }
    finally {}
  }
  
  public abmi a()
  {
    if (this.jdField_a_of_type_Abmi == null) {
      this.jdField_a_of_type_Abmi = new abmi(this.mApp);
    }
    return this.jdField_a_of_type_Abmi;
  }
  
  public abto.b a()
  {
    if (this.jdField_a_of_type_Abto$b == null) {
      this.jdField_a_of_type_Abto$b = new abhj(this);
    }
    return this.jdField_a_of_type_Abto$b;
  }
  
  public aqvc a()
  {
    if (this.mApp == null) {
      return null;
    }
    return ((aqva)this.mApp.getManager(47)).a(3);
  }
  
  public DrawerPushItem a(int paramInt)
  {
    int m;
    switch (ApolloGameUtil.x(this.mApp))
    {
    default: 
      m = 0;
    }
    for (;;)
    {
      return a(paramInt, m);
      m = 2;
      continue;
      m = 3;
    }
  }
  
  public DrawerPushItem a(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      DrawerPushItem localDrawerPushItem;
      synchronized (this.jdField_ci_of_type_JavaLangObject)
      {
        if ((this.wa == null) || (this.wa.isEmpty())) {
          return null;
        }
        Collections.sort(this.wa, this.H);
        long l = System.currentTimeMillis() / 1000L;
        Iterator localIterator = this.wa.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localDrawerPushItem = (DrawerPushItem)localIterator.next();
        if ((localDrawerPushItem.msg_type != paramInt1) || (localDrawerPushItem.start_ts >= l) || (localDrawerPushItem.end_ts <= l) || (localDrawerPushItem.show_sum >= localDrawerPushItem.show_counts)) {
          continue;
        }
        if (((paramInt2 == 0) || (paramInt2 == 2)) && ((localDrawerPushItem.target_model == 0) || (localDrawerPushItem.target_model == 2))) {
          return localDrawerPushItem;
        }
      }
      if (localDrawerPushItem.target_model == paramInt2) {
        return localDrawerPushItem;
      }
    }
    return null;
  }
  
  public DrawerPushItem a(String paramString)
  {
    synchronized (this.jdField_ci_of_type_JavaLangObject)
    {
      if ((this.wa == null) || (this.wa.isEmpty())) {
        return null;
      }
      Collections.sort(this.wa, this.H);
      long l = System.currentTimeMillis() / 1000L;
      Iterator localIterator = this.wa.iterator();
      while (localIterator.hasNext())
      {
        DrawerPushItem localDrawerPushItem = (DrawerPushItem)localIterator.next();
        if ((localDrawerPushItem.msg_id.equals(paramString)) && (localDrawerPushItem.start_ts < l) && (localDrawerPushItem.end_ts > l)) {
          return localDrawerPushItem;
        }
      }
    }
    return null;
  }
  
  public DrawerPushItem a(String paramString1, String paramString2, JSONObject paramJSONObject, boolean paramBoolean, int paramInt)
  {
    if ((paramJSONObject == null) || (this.mApp == null))
    {
      paramString1 = null;
      return paramString1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "parseShopRedTouchManager:", paramJSONObject, ", isNewRed：", Boolean.valueOf(paramBoolean), ",msgType：", Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      DrawerPushItem localDrawerPushItem;
      try
      {
        int m = paramJSONObject.optInt("time");
        SharedPreferences localSharedPreferences = this.mApp.getApp().getSharedPreferences("apollo_sp" + this.mApp.getCurrentUin(), 0);
        if (m == localSharedPreferences.getInt(paramString1, 0))
        {
          paramJSONObject = a(paramString2);
          paramString1 = paramJSONObject;
          if (paramBoolean) {
            break;
          }
          if (paramJSONObject == null) {
            break label534;
          }
          BE(paramString2);
          break label534;
        }
        paramJSONObject = paramJSONObject.optString("content");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          paramJSONObject = new JSONObject(paramJSONObject);
          localDrawerPushItem = new DrawerPushItem();
          localDrawerPushItem.is_reddot = 1;
          localDrawerPushItem.msg_id = paramString2;
          localDrawerPushItem.msg_type = paramInt;
          if (!paramJSONObject.has("mainPriority")) {
            return null;
          }
          localDrawerPushItem.priority = paramJSONObject.optInt("mainPriority");
          localDrawerPushItem.sub_priority = paramJSONObject.optInt("subPriority");
          localDrawerPushItem.start_ts = paramJSONObject.optInt("showTime");
          localDrawerPushItem.end_ts = paramJSONObject.optInt("expireTime");
          localDrawerPushItem.send_time = m;
          localDrawerPushItem.action_id = paramJSONObject.optInt("actionId");
          localDrawerPushItem.color = paramJSONObject.optInt("fontColor");
          localDrawerPushItem.content = paramJSONObject.optString("bubbleText");
          localDrawerPushItem.bubble_res_id = paramJSONObject.optInt("bubbleID");
          localDrawerPushItem.icon_url = paramJSONObject.optString("iconUrl");
          localDrawerPushItem.life_Time = paramJSONObject.optInt("tipsDuration");
          paramInt = paramJSONObject.optInt("type");
          if (paramInt != 0) {
            break label496;
          }
          localDrawerPushItem.scheme = paramJSONObject.optString("scheme");
          localDrawerPushItem.show_counts = paramJSONObject.optInt("showCounts");
          long l = NetConnInfoCenter.getServerTime();
          if ((paramBoolean) && (localDrawerPushItem.start_ts < l) && (localDrawerPushItem.end_ts > l))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, new Object[] { "parseShopRedTouchManager addPushItem:", localDrawerPushItem.toString() });
            }
            c(localDrawerPushItem);
            localSharedPreferences.edit().putInt(paramString1, m).commit();
            return localDrawerPushItem;
          }
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("ApolloManager", 2, "parseApolloRedTouchContent Exception:", paramString1);
      }
      return null;
      label496:
      if (paramInt == 1) {
        localDrawerPushItem.ext_url = abxi.bjg;
      } else if (paramInt == 2) {
        localDrawerPushItem.ext_url = paramJSONObject.optString("url");
      }
    }
    label534:
    return null;
  }
  
  public ApolloActionData a(QQAppInterface paramQQAppInterface, String paramString, int... paramVarArgs)
  {
    if ((paramQQAppInterface == null) || (paramString == null) || (paramVarArgs == null)) {
      return null;
    }
    Object localObject = b(paramString);
    if (localObject == null) {
      return null;
    }
    HashSet localHashSet = new HashSet();
    int n = paramVarArgs.length;
    int m = 0;
    if (m < n)
    {
      int i1 = paramVarArgs[m];
      if ((i1 == 4) && (!((ApolloBaseInfo)localObject).hasPet)) {}
      for (;;)
      {
        m += 1;
        break;
        localHashSet.add(Integer.valueOf(i1));
      }
    }
    for (;;)
    {
      try
      {
        paramString = g(paramQQAppInterface, paramString);
        if (paramString == null) {
          return null;
        }
        paramString = new JSONArray(paramString);
        n = paramString.length();
        paramVarArgs = new ArrayList();
        m = 0;
        if (m < n)
        {
          localObject = paramString.getJSONObject(m);
          if ((localObject == null) || (!localHashSet.contains(Integer.valueOf(((JSONObject)localObject).getInt("type"))))) {
            break label439;
          }
          paramVarArgs.add(localObject);
          break label439;
        }
        if (paramVarArgs.size() != 0)
        {
          paramString = (JSONObject)paramVarArgs.get(ApolloUtil.gl(paramVarArgs.size()));
          if (paramString != null)
          {
            n = paramString.getInt("id");
            m = paramString.getInt("type");
            if (n <= 0) {
              break label437;
            }
            if (ApolloUtil.aF(n, 0))
            {
              paramQQAppInterface = new ApolloActionData();
              paramQQAppInterface.actionId = n;
              if (m == 4) {
                paramQQAppInterface.actionType = 7;
              }
              if (QLog.isColorLevel()) {
                QLog.d("ApolloManager", 2, new Object[] { "getRandomAppearAction actionId:", Integer.valueOf(n), ",type:", Integer.valueOf(m) });
              }
              return paramQQAppInterface;
            }
          }
          else
          {
            QLog.e("ApolloManager", 1, "[getRandomAppearAction] found empty json obj");
            break label448;
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label448;
          }
          QLog.d("ApolloManager", 2, "[getRandomAppearAction]found empty json arr ");
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("ApolloManager", 1, "[getRandomAppearAction]:" + paramQQAppInterface);
        return null;
      }
      paramString = new ApolloActionData();
      paramString.actionId = n;
      paramVarArgs = ApolloUtil.a(paramString, 5);
      abto.b(paramQQAppInterface, ApolloUtil.a(paramString, 4), paramVarArgs);
      QLog.w("ApolloManager", 2, "getRandomAppearAction action resource not ready,actionId:" + n);
      label437:
      return null;
      label439:
      m += 1;
      continue;
      label448:
      m = 0;
      n = 0;
    }
  }
  
  public ApolloBaseInfo a(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return null;
    }
    if ((paramString.equals(this.mApp.getCurrentAccountUin())) && (this.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo;
    }
    if (this.d.containsKey(paramString)) {
      return (ApolloBaseInfo)this.d.get(paramString);
    }
    ThreadManager.getSubThreadHandler().post(new ApolloManager.15(this, paramString));
    return null;
  }
  
  public ApolloPandora a(String paramString, boolean paramBoolean)
  {
    ??? = null;
    if (TextUtils.isEmpty(paramString)) {}
    ApolloPandora localApolloPandora;
    do
    {
      do
      {
        return ???;
        if (this.dr.contains(paramString)) {
          return (ApolloPandora)this.dr.get(paramString);
        }
      } while (!paramBoolean);
      localApolloPandora = (ApolloPandora)this.em.find(ApolloPandora.class, paramString);
      ??? = localApolloPandora;
    } while (localApolloPandora == null);
    synchronized (this.dr)
    {
      this.dr.put(paramString, localApolloPandora);
      return localApolloPandora;
    }
  }
  
  public File a(ApolloActionData paramApolloActionData, int paramInt)
  {
    if (paramApolloActionData == null) {
      return null;
    }
    String str = "";
    if ((paramInt & 0x1) == 1) {
      str = ApolloUtil.a(paramApolloActionData, 0);
    }
    for (;;)
    {
      return new File(str);
      if ((paramInt & 0x2) == 2) {
        str = ApolloUtil.a(paramApolloActionData, 2);
      }
    }
  }
  
  public File a(ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage == null) {
      return null;
    }
    return new File(ApolloUtil.a(paramApolloActionPackage));
  }
  
  /* Error */
  public void a(abhh.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 2649	abhh:wb	Ljava/util/List;
    //   6: ifnonnull +17 -> 23
    //   9: aload_0
    //   10: new 175	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 207	java/util/ArrayList:<init>	()V
    //   17: invokestatic 2653	java/util/Collections:synchronizedList	(Ljava/util/List;)Ljava/util/List;
    //   20: putfield 2649	abhh:wb	Ljava/util/List;
    //   23: aload_0
    //   24: getfield 2649	abhh:wb	Ljava/util/List;
    //   27: astore_2
    //   28: aload_2
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 2649	abhh:wb	Ljava/util/List;
    //   34: aload_1
    //   35: invokeinterface 682 2 0
    //   40: pop
    //   41: aload_2
    //   42: monitorexit
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_1
    //   47: aload_2
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	abhh
    //   0	56	1	parama	abhh.a
    // Exception table:
    //   from	to	target	type
    //   30	43	46	finally
    //   47	49	46	finally
    //   2	23	51	finally
    //   23	30	51	finally
    //   49	51	51	finally
  }
  
  public void a(abhh.c paramc)
  {
    if (paramc == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "[setApolloStatusUpdateListener] listener=", paramc });
    }
    this.wc.add(new WeakReference(paramc));
  }
  
  public void a(abyz paramabyz)
  {
    if (paramabyz != null) {}
    try
    {
      if (this.jdField_a_of_type_Abyt != null) {
        this.jdField_a_of_type_Abyt.c(paramabyz);
      }
      return;
    }
    finally
    {
      paramabyz = finally;
      throw paramabyz;
    }
  }
  
  public void a(DrawerPushItem paramDrawerPushItem)
  {
    ThreadManager.post(new ApolloManager.16(this, paramDrawerPushItem), 5, null, true);
  }
  
  public void a(DrawerPushItem paramDrawerPushItem, QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if ((paramDrawerPushItem == null) || (paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    b(paramQQAppInterface, paramContext, paramDrawerPushItem.scheme, paramDrawerPushItem.ext_url, paramString);
  }
  
  public void a(DrawerPushItem paramDrawerPushItem, boolean paramBoolean)
  {
    synchronized (this.jdField_ci_of_type_JavaLangObject)
    {
      if ((this.wa != null) && (!a(paramDrawerPushItem)))
      {
        this.wa.add(paramDrawerPushItem);
        if ((this.em != null) && (paramBoolean)) {
          this.em.persist(paramDrawerPushItem);
        }
        if (QLog.isColorLevel()) {
          QLog.i("ApolloPushBubble", 2, "add red push item:" + paramDrawerPushItem);
        }
      }
      return;
    }
  }
  
  public void a(SessionInfo paramSessionInfo, Context paramContext)
  {
    if ((paramSessionInfo.cZ != 0) && (paramSessionInfo.cZ != 1) && (this.mApp != null) && (aqiw.isNetworkAvailable(this.mApp.getApp()))) {}
    do
    {
      do
      {
        return;
        sI.clear();
      } while ((paramSessionInfo.cZ == 1) && (this.mApp != null) && (((HotChatManager)this.mApp.getManager(60)).a(paramSessionInfo.aTl) != null));
      if ((this.mApp == null) || (1 == cd(this.mApp.getCurrentUin()))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloManager", 2, "doAfterOpenAIO: apollo function is not opened status: " + cd(this.mApp.getCurrentUin()));
    return;
    ThreadManager.getSubThreadHandler().post(new ApolloManager.9(this, paramSessionInfo));
  }
  
  public void a(ApolloPreDownloadData paramApolloPreDownloadData, String paramString1, String paramString2)
  {
    if ((paramApolloPreDownloadData == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      QLog.e("ApolloManager", 1, "preDownloadListener err param");
    }
    File localFile;
    for (;;)
    {
      return;
      try
      {
        localFile = new File(paramString1);
        if (localFile.exists())
        {
          String str = aszr.getFileMD5String(localFile);
          if ((str != null) && (!str.equalsIgnoreCase(paramApolloPreDownloadData.md5)))
          {
            QLog.e("ApolloManager", 1, "preDownloadListener md5 not match!");
            localFile.delete();
            return;
          }
        }
      }
      catch (Exception paramApolloPreDownloadData)
      {
        QLog.e("ApolloManager", 1, "preDownloadListener fail zip file: " + paramString1, paramApolloPreDownloadData);
        return;
      }
    }
    aqhq.W(paramString1, paramString2, false);
    if (TextUtils.isEmpty(paramApolloPreDownloadData.zipDir)) {
      localFile.delete();
    }
    paramString2 = (abxk)this.mApp.getManager(155);
    paramApolloPreDownloadData.status = 1;
    paramString2.a(paramApolloPreDownloadData);
    VipUtils.a(this.mApp, "cmshow", "Apollo", "pre_download_res", 0, 0, new String[] { paramApolloPreDownloadData.reportId });
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    if ((paramApolloActionData == null) && (!aqhq.fileExists(ApolloUtil.a(paramApolloActionData, 7)))) {}
    while ((!a(aqhq.readFileContent(new File(ApolloUtil.a(paramApolloActionData, 7))), paramApolloActionData)) || (this.mApp == null)) {
      return;
    }
    ((abxk)this.mApp.getManager(155)).d(paramApolloActionData);
  }
  
  public void a(ApolloActionData paramApolloActionData, Bundle paramBundle)
  {
    int m = paramBundle.getInt("way");
    if (m == 1) {
      paramApolloActionData.feeType = 6;
    }
    while (m == 6)
    {
      paramApolloActionData.limitFree = 1;
      paramApolloActionData.limitStart = paramBundle.getLong("beginTs");
      paramApolloActionData.limitEnd = paramBundle.getLong("endts");
      return;
      if (m == 2) {
        paramApolloActionData.feeType = 7;
      } else if (m == 4) {
        paramApolloActionData.feeType = 2;
      }
    }
    paramApolloActionData.limitFree = 0;
    paramApolloActionData.obtainedTime = paramBundle.getLong("beginTs");
  }
  
  public void a(ApolloBaseInfo paramApolloBaseInfo)
  {
    if ((paramApolloBaseInfo == null) || (TextUtils.isEmpty(paramApolloBaseInfo.uin))) {}
    for (;;)
    {
      return;
      int m;
      if (paramApolloBaseInfo.uin.equals(this.mApp.getCurrentAccountUin()))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo = paramApolloBaseInfo;
        if ((paramApolloBaseInfo.cmshow3dFlag & 0x2) != 2) {
          break label214;
        }
        m = 1;
        Hg(m);
      }
      synchronized (this.d)
      {
        this.d.put(paramApolloBaseInfo.uin, paramApolloBaseInfo);
        a(paramApolloBaseInfo);
        if ((!QLog.isColorLevel()) || (!paramApolloBaseInfo.uin.equals(this.mApp.getCurrentUin()))) {
          continue;
        }
        QLog.d("ApolloManager", 2, "save apollo info vip status: " + paramApolloBaseInfo.apolloVipFlag + ", vip lev: " + paramApolloBaseInfo.apolloVipFlag + ", apollo status: " + paramApolloBaseInfo.apolloStatus + ", apollo local TS: " + paramApolloBaseInfo.apolloLocalTS + ", apollo svr TS:" + paramApolloBaseInfo.apolloServerTS + ", apollo upt TS:" + paramApolloBaseInfo.apolloUpdateTime + ", apollo AISwitch: " + paramApolloBaseInfo.apolloAISwitch);
        return;
        label214:
        m = 0;
      }
    }
  }
  
  public void a(ApolloPandora paramApolloPandora)
  {
    if ((paramApolloPandora == null) || (TextUtils.isEmpty(paramApolloPandora.uin))) {
      return;
    }
    synchronized (this.dr)
    {
      this.dr.put(paramApolloPandora.uin, paramApolloPandora);
      a(paramApolloPandora);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, abhh.g paramg)
  {
    if ((this.mApp == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    aqvc localaqvc;
    do
    {
      return;
      localaqvc = a();
    } while ((localaqvc == null) || (localaqvc.a(paramString1) != null));
    File localFile = new File(paramString2);
    paramString2 = new aquz(paramString1, localFile);
    if (localFile.exists())
    {
      SharedPreferences localSharedPreferences = this.mApp.getApplication().getSharedPreferences("apollo_sp", 0);
      paramString2.lastModifiedTime = localSharedPreferences.getLong(paramString1 + "_lastModifiedTime", 0L);
      long l = localSharedPreferences.getLong(paramString1, 0L);
      if (localFile.lastModified() != l) {
        paramString2.cWv = true;
      }
    }
    paramString2.cWy = true;
    paramString2.cWs = true;
    paramString2.cWw = true;
    paramString2.cWB = false;
    paramString2.cxX = "apollo_res";
    paramString2.cWA = true;
    paramString2.cWz = true;
    paramString1 = new Bundle();
    localaqvc.a(paramString2, new abhh.h(this.mApp, paramg), paramString1);
  }
  
  public void a(List<String> paramList, Map<String, File> paramMap, List<ApolloActionData> paramList1, Bundle paramBundle)
  {
    if ((paramList1 == null) || (paramList1.size() <= 0) || (paramList == null) || (paramMap == null)) {
      return;
    }
    int m = 0;
    label25:
    ApolloActionData localApolloActionData;
    String str1;
    Object localObject;
    String str2;
    String str3;
    if (m < paramList1.size())
    {
      localApolloActionData = (ApolloActionData)paramList1.get(m);
      str1 = ApolloUtil.a(localApolloActionData, 1);
      localObject = ApolloUtil.a(localApolloActionData, 0);
      str2 = ApolloUtil.a(localApolloActionData, 5);
      str3 = ApolloUtil.a(localApolloActionData, 4);
      if (!ahbj.isFileExists((String)localObject)) {
        break label216;
      }
      localObject = new aquz(str1, new File((String)localObject));
      Bundle localBundle = new Bundle();
      localBundle.putSerializable(str1, localApolloActionData);
      ((aquz)localObject).currUrl = str1;
      ((aquz)localObject).dy(localBundle);
      this.j.onDoneFile((aquz)localObject);
    }
    for (;;)
    {
      if (!ApolloUtil.aF(localApolloActionData.actionId, localApolloActionData.personNum))
      {
        paramList.add(str2);
        paramMap.put(str2, new File(str3));
        if (paramBundle != null) {
          paramBundle.putSerializable(str2, localApolloActionData);
        }
      }
      m += 1;
      break label25;
      break;
      label216:
      paramList.add(str1);
      paramMap.put(str1, new File((String)localObject));
      if (paramBundle != null) {
        paramBundle.putSerializable(str1, localApolloActionData);
      }
    }
  }
  
  public boolean a(int paramInt, List<ApolloActionData> paramList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int m;
    if (paramList != null) {
      m = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (m < paramList.size())
      {
        if (((ApolloActionData)paramList.get(m)).actionId == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      m += 1;
    }
  }
  
  boolean a(DrawerPushItem paramDrawerPushItem)
  {
    if ((this.wa == null) || (this.wa.isEmpty())) {
      return false;
    }
    Iterator localIterator = this.wa.iterator();
    while (localIterator.hasNext())
    {
      DrawerPushItem localDrawerPushItem = (DrawerPushItem)localIterator.next();
      if ((localDrawerPushItem.msg_id != null) && (localDrawerPushItem.msg_id.equals(paramDrawerPushItem.msg_id))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(ApolloActionData paramApolloActionData, int paramInt)
  {
    return a(paramApolloActionData, paramInt, null);
  }
  
  public boolean a(ApolloActionData paramApolloActionData, int paramInt, abyz paramabyz)
  {
    if (paramApolloActionData == null) {}
    for (;;)
    {
      return false;
      if (aqft.cC())
      {
        if (aqft.hE() < 1048576L)
        {
          QLog.e("ApolloManager", 1, "1sdcardcheck,sdcard full .return. aid=" + paramApolloActionData.actionId);
          return false;
        }
      }
      else
      {
        QLog.e("ApolloManager", 1, "1sdcardcheck,has sdcard FALSE .return. aid=" + paramApolloActionData.actionId);
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "start download action res aid=" + paramApolloActionData.actionId);
      }
      Object localObject1;
      Object localObject2;
      int m;
      if ((paramInt & 0x1) == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "start download action panelpic aid=" + paramApolloActionData.actionId);
        }
        localObject1 = ApolloUtil.a(paramApolloActionData, 1);
        localObject2 = ApolloUtil.a(paramApolloActionData, 0);
        if (!aqhq.fileExists((String)localObject2))
        {
          localObject1 = new aquz((String)localObject1, new File((String)localObject2));
          ((aquz)localObject1).cxX = "apollo_res";
          ((aquz)localObject1).retryCount = 1;
          ((aquz)localObject1).cWw = true;
          ((aquz)localObject1).cWz = true;
          ((aquz)localObject1).cWA = true;
          m = aqva.a((aquz)localObject1, getApp());
          if (m != 0) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, "ret:" + m);
          }
        }
      }
      if ((paramInt & 0x2) == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "start download action gif aid=" + paramApolloActionData.actionId);
        }
        localObject1 = ApolloUtil.a(paramApolloActionData, 3);
        localObject2 = ApolloUtil.a(paramApolloActionData, 2);
        if (!aqhq.fileExists((String)localObject2))
        {
          localObject1 = new aquz((String)localObject1, new File((String)localObject2));
          ((aquz)localObject1).cxX = "apollo_res";
          ((aquz)localObject1).cWw = true;
          m = aqva.a((aquz)localObject1, getApp());
          if (m != 0) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, "ret:" + m);
          }
        }
      }
      if ((paramInt & 0x4) == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "start download action zip aid=" + paramApolloActionData.actionId);
        }
        localObject2 = ApolloUtil.a(paramApolloActionData, 5);
        localObject1 = ApolloUtil.a(paramApolloActionData, 4);
        if (!ApolloUtil.aF(paramApolloActionData.actionId, paramApolloActionData.personNum))
        {
          localObject2 = new aquz((String)localObject2, new File((String)localObject1));
          ((aquz)localObject2).cxX = "apollo_res";
          ((aquz)localObject2).retryCount = 1;
          ((aquz)localObject2).cWw = true;
          ((aquz)localObject2).cWz = true;
          ((aquz)localObject2).cWA = true;
          paramInt = aqva.a((aquz)localObject2, getApp());
          if (paramInt != 0) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, "ret:" + paramInt);
          }
        }
      }
      try
      {
        aqhq.W((String)localObject1, ApolloUtil.a(paramApolloActionData, 6), false);
        aqhq.deleteFile((String)localObject1);
        a(paramApolloActionData);
        if (paramabyz != null) {
          if (!ApolloUtil.aF(paramApolloActionData.actionId, paramApolloActionData.personNum))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("ApolloManager", 2, "download finished, but rsc NOT complete.");
            return false;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ApolloManager", 2, "uncompresszip error" + localException.toString());
          }
        }
        paramabyz.i(paramApolloActionData);
      }
    }
    return true;
  }
  
  public boolean a(ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage == null) {}
    label98:
    int m;
    do
    {
      do
      {
        do
        {
          return false;
          if (!aqft.cC()) {
            break;
          }
          if (aqft.hE() >= 1048576L) {
            break label98;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ApolloManager", 2, "2sdcardcheck,sdcard full .return. aid=" + paramApolloActionPackage.packageId);
        return false;
      } while (!QLog.isColorLevel());
      QLog.e("ApolloManager", 2, "2sdcardcheck,has sdcard FALSE .return. aid=" + paramApolloActionPackage.packageId);
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "start download actionPackage tab pid=" + paramApolloActionPackage.packageId);
      }
      paramApolloActionPackage = new aquz(ApolloUtil.b(paramApolloActionPackage), new File(ApolloUtil.a(paramApolloActionPackage)));
      paramApolloActionPackage.cWw = true;
      paramApolloActionPackage.cxX = "apollo_res";
      paramApolloActionPackage.retryCount = 1;
      paramApolloActionPackage.cWz = true;
      paramApolloActionPackage.cWA = true;
      m = aqva.a(paramApolloActionPackage, getApp());
    } while (m != 0);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "ret:" + m);
    }
    return true;
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (this.em.isOpen()) {
      if (paramEntity.getStatus() == 1000)
      {
        this.em.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.em.update(paramEntity);
      }
    }
    QLog.e("ApolloManager", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public boolean a(String paramString, ApolloActionData paramApolloActionData)
  {
    int n = 0;
    if ((paramString == null) || (paramApolloActionData == null)) {
      bool2 = false;
    }
    do
    {
      for (;;)
      {
        return bool2;
        for (;;)
        {
          try
          {
            paramString = new JSONObject(paramString);
            bool1 = paramString.has("audio");
            if (!bool1) {
              continue;
            }
          }
          catch (Exception paramString)
          {
            Object localObject;
            int m;
            boolean bool3;
            boolean bool1 = false;
            continue;
            bool2 = false;
            continue;
            m += 1;
            continue;
            m += 1;
            continue;
          }
          try
          {
            paramApolloActionData.hasSound = paramString.optJSONObject("audio").optBoolean("hasSound");
            bool2 = true;
            bool1 = bool2;
          }
          catch (Exception paramString)
          {
            bool1 = true;
            continue;
          }
          try
          {
            if (paramString.has("vibrate")) {
              bool1 = true;
            }
            bool2 = bool1;
            localObject = paramString.optJSONArray("vibrate");
            if (localObject != null)
            {
              bool2 = bool1;
              StringBuilder localStringBuilder = new StringBuilder(50);
              m = 0;
              bool2 = bool1;
              if (m < ((JSONArray)localObject).length())
              {
                bool2 = bool1;
                JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(m);
                if (localJSONObject == null) {
                  continue;
                }
                bool2 = bool1;
                int i1 = localJSONObject.optInt("time");
                bool2 = bool1;
                int i2 = localJSONObject.optInt("duration");
                bool2 = bool1;
                localStringBuilder.append(i1).append(",").append(i2);
                bool2 = bool1;
                if (m >= ((JSONArray)localObject).length() - 1) {
                  continue;
                }
                bool2 = bool1;
                localStringBuilder.append(",");
                continue;
              }
              bool2 = bool1;
              paramApolloActionData.vibrate = localStringBuilder.toString();
            }
            bool2 = bool1;
            bool3 = paramString.has("bubbleText");
            if (!bool3) {
              continue;
            }
            bool1 = true;
          }
          catch (Exception paramString)
          {
            bool1 = bool2;
            continue;
            continue;
          }
          try
          {
            paramString = paramString.optJSONArray("bubbleText");
            if (paramString != null)
            {
              localObject = new StringBuilder(50);
              m = n;
              if (m < paramString.length())
              {
                ((StringBuilder)localObject).append(paramString.getString(m));
                if (m >= paramString.length() - 1) {
                  continue;
                }
                ((StringBuilder)localObject).append("@$");
                continue;
              }
              paramApolloActionData.bubbleText = ((StringBuilder)localObject).toString();
            }
            bool2 = bool1;
            if (!QLog.isColorLevel()) {
              break;
            }
            if ((!paramApolloActionData.hasSound) && (TextUtils.isEmpty(paramApolloActionData.vibrate)))
            {
              bool2 = bool1;
              if (TextUtils.isEmpty(paramApolloActionData.bubbleText)) {
                break;
              }
            }
            QLog.d("ApolloManager", 2, "action id " + paramApolloActionData.actionId + ", name: " + paramApolloActionData.actionName + ", hasSound: " + paramApolloActionData.hasSound + ", vibrate=" + paramApolloActionData.vibrate + ", bubbleText =" + paramApolloActionData.bubbleText);
            return bool1;
          }
          catch (Exception paramString)
          {
            bool2 = bool1;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("ApolloManager", 2, "parse action config.json error", paramString);
    return bool1;
  }
  
  public void ad(Map<String, ApolloPreDownloadData> paramMap)
  {
    if ((this.mApp == null) || (paramMap == null) || (paramMap.size() == 0)) {}
    Bundle localBundle;
    do
    {
      ArrayList localArrayList;
      HashMap localHashMap;
      do
      {
        return;
        StringBuilder localStringBuilder1;
        StringBuilder localStringBuilder2;
        abxk localabxk;
        for (;;)
        {
          ApolloPreDownloadData localApolloPreDownloadData;
          try
          {
            localArrayList = new ArrayList();
            localHashMap = new HashMap();
            localBundle = new Bundle();
            localStringBuilder1 = new StringBuilder();
            localStringBuilder2 = new StringBuilder();
            localabxk = (abxk)this.mApp.getManager(155);
            Map localMap = localabxk.ac();
            Iterator localIterator = paramMap.values().iterator();
            if (!localIterator.hasNext()) {
              break;
            }
            localApolloPreDownloadData = (ApolloPreDownloadData)localIterator.next();
            if ((TextUtils.isEmpty(localApolloPreDownloadData.resId)) || (TextUtils.isEmpty(localApolloPreDownloadData.dir)) || (TextUtils.isEmpty(localApolloPreDownloadData.md5)) || ((localApolloPreDownloadData.endTime > 0L) && (localApolloPreDownloadData.endTime < NetConnInfoCenter.getServerTime())))
            {
              localStringBuilder1.append(localApolloPreDownloadData.reportId).append(",");
              continue;
            }
            localObject = (ApolloPreDownloadData)localMap.get(localApolloPreDownloadData.resId);
          }
          catch (Exception paramMap)
          {
            QLog.e("ApolloManager", 1, "updateAndDownloadPreRes e:", paramMap);
            return;
          }
          Object localObject;
          if ((localObject == null) || (((ApolloPreDownloadData)localObject).status == 0) || (localApolloPreDownloadData.version > ((ApolloPreDownloadData)localObject).version))
          {
            localStringBuilder2.append(localApolloPreDownloadData.reportId).append(",ver:").append(localApolloPreDownloadData.version).append(" | ");
            localArrayList.add(localApolloPreDownloadData.url);
            if (!TextUtils.isEmpty(localApolloPreDownloadData.zipDir)) {}
            for (localObject = ApolloUtil.dt(localApolloPreDownloadData.dirType) + localApolloPreDownloadData.zipDir;; localObject = abxi.biG + localApolloPreDownloadData.resId + ".zip")
            {
              localHashMap.put(localApolloPreDownloadData.url, new File((String)localObject));
              localBundle.putSerializable(localApolloPreDownloadData.url, localApolloPreDownloadData);
              break;
            }
          }
          localApolloPreDownloadData.status = 1;
        }
        localabxk.e(paramMap, true);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, new Object[] { "updateAndDownloadPreRes valid download:", localStringBuilder2.toString(), "\ninvalid config:", localStringBuilder1.toString() });
        }
      } while (localArrayList.size() <= 0);
      paramMap = new aquz(localArrayList, localHashMap, "apollo_preDownload");
      paramMap.cWw = true;
      paramMap.cxX = "apollo_res";
      paramMap.cWy = true;
      paramMap.cWB = false;
      paramMap.cWA = true;
      paramMap.cWz = true;
      paramMap.retryCount = 0;
    } while (a() == null);
    a().a(paramMap, this.k, localBundle);
  }
  
  public void at(byte[] paramArrayOfByte)
  {
    submsgtype0xdc.MsgBody localMsgBody = new submsgtype0xdc.MsgBody();
    for (;;)
    {
      int m;
      try
      {
        localMsgBody.mergeFrom(paramArrayOfByte);
        if (!localMsgBody.uint32_msg_type.has()) {
          break label329;
        }
        m = localMsgBody.uint32_msg_type.get();
        if (!localMsgBody.minQqVer.has()) {
          break label334;
        }
        paramArrayOfByte = localMsgBody.minQqVer.get();
        if ((TextUtils.isEmpty(paramArrayOfByte)) || (abxh.q("3.4.4", paramArrayOfByte) >= 0)) {
          break label334;
        }
        QLog.i("ApolloManager", 1, "decodeApolloBubblePushData push but cur version not support:" + paramArrayOfByte);
        return;
      }
      catch (Throwable paramArrayOfByte)
      {
        label95:
        paramArrayOfByte.printStackTrace();
        label132:
        QLog.e("ApolloManager", 1, new Object[] { "[decodeApolloBubblePushData], errInfo->", paramArrayOfByte.getMessage() });
        return;
      }
      if (localMsgBody.rpt_msg_list.has())
      {
        paramArrayOfByte = localMsgBody.rpt_msg_list.get();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0)) {
          N(m, paramArrayOfByte);
        }
        QLog.i("ApolloManager", 1, "[decodeApolloBubblePushData], decode complete msgType:" + m);
        return;
      }
      label329:
      label334:
      do
      {
        if ((m == 2) && (localMsgBody.rpt_msg_list_0x02.has()))
        {
          paramArrayOfByte = localMsgBody.rpt_msg_list_0x02.get();
          if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
            break label132;
          }
          N(m, paramArrayOfByte);
          break label132;
        }
        if ((m == 3) && (localMsgBody.rpt_msg_list.has()))
        {
          paramArrayOfByte = localMsgBody.rpt_msg_list.get();
          if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
            break label132;
          }
          N(8, paramArrayOfByte);
          break label132;
        }
        if ((m != 201) || (!localMsgBody.rpt_msg_list_0x02.has())) {
          break label132;
        }
        paramArrayOfByte = localMsgBody.rpt_msg_list_0x02.get();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
          break label132;
        }
        N(9, paramArrayOfByte);
        break label132;
        m = 0;
        break;
        if (m == 0) {
          break label95;
        }
      } while (m != 1);
    }
  }
  
  public ApolloBaseInfo b(String paramString)
  {
    ??? = null;
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return ???;
      boolean bool = paramString.equals(this.mApp.getCurrentAccountUin());
      if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo != null)) {
        return this.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo;
      }
      synchronized (this.d)
      {
        if (this.d.containsKey(paramString))
        {
          paramString = (ApolloBaseInfo)this.d.get(paramString);
          return paramString;
        }
      }
      if ((0 == 0) && (!this.bCC))
      {
        ??? = (ApolloBaseInfo)this.em.find(ApolloBaseInfo.class, paramString);
        if (bool) {
          this.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo = ((ApolloBaseInfo)???);
        }
        if (??? != null) {
          synchronized (this.d)
          {
            this.d.put(paramString, ???);
            ??? = ???;
            if (QLog.isColorLevel())
            {
              QLog.d("ApolloManager", 2, "unInit mApolloBaseInfoCache, find from db uin: " + ApolloUtil.iY(paramString) + ", apollo status: " + ((ApolloBaseInfo)???).apolloStatus);
              return ???;
            }
          }
        }
      }
    }
    for (;;)
    {
      synchronized (this.d)
      {
        if (this.d.containsKey(paramString))
        {
          ??? = (ApolloBaseInfo)this.d.get(paramString);
          ??? = ???;
          if (??? == null)
          {
            ??? = new ApolloBaseInfo();
            ((ApolloBaseInfo)???).uin = paramString;
          }
          return ???;
        }
      }
      ??? = ???;
      try
      {
        if (!this.aN.contains(Long.valueOf(Long.parseLong(paramString)))) {
          break label406;
        }
        ??? = (ApolloBaseInfo)this.em.find(ApolloBaseInfo.class, paramString);
        ??? = ???;
        if (??? == null) {
          continue;
        }
        try
        {
          this.d.put(paramString, ???);
          ??? = ???;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ApolloManager", 2, "mApolloBaseInfoCache unCache, mUnCacheUinSets contains, find from db uin: " + ApolloUtil.iY(paramString) + ", apollo status: " + ((ApolloBaseInfo)???).apolloStatus);
          ??? = ???;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          ??? = ???;
          ??? = localNumberFormatException2;
        }
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        label390:
        break label390;
      }
      QLog.e("ApolloManager", 1, (Throwable)???, new Object[0]);
      ??? = ???;
      label406:
      ??? = ???;
      continue;
      ??? = null;
    }
  }
  
  public void b(abyz paramabyz)
  {
    if ((paramabyz != null) && (this.jdField_a_of_type_Abyt != null)) {
      this.jdField_a_of_type_Abyt.d(paramabyz);
    }
  }
  
  public void b(DrawerPushItem paramDrawerPushItem)
  {
    ((ProxyManager)this.mApp.getManager(18)).addMsgQueue(this.mApp.getAccount(), 0, paramDrawerPushItem.getTableName(), paramDrawerPushItem, 4, null);
  }
  
  public void b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramQQAppInterface == null) || (paramContext == null))
    {
      QLog.e("ApolloManager", 1, "openStoreByTabScheme context is null");
      return;
    }
    String str = s(paramString1, true);
    if (!TextUtils.isEmpty(str))
    {
      paramString2 = new Intent();
      if ("interact".equals(paramString1)) {
        paramString2.putExtra("extra_key_url_append", "&tab=interactive&suin=" + paramQQAppInterface.getCurrentAccountUin());
      }
      ApolloUtil.a(paramContext, paramString2, paramString3, str, null);
      return;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
      paramQQAppInterface.putExtra("url", paramString2);
      paramQQAppInterface.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramContext.startActivity(paramQQAppInterface);
      return;
    }
    QLog.w("ApolloManager", 1, "openStoreByTabScheme params is error");
  }
  
  public void b(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData != null)
    {
      Object localObject = new File(ApolloUtil.a(paramApolloActionData, 7));
      if (((File)localObject).exists()) {
        try
        {
          localObject = aqhq.readFileContent((File)localObject);
          if (new JSONObject((String)localObject).optLong("version") < paramApolloActionData.version)
          {
            boolean bool = ahbj.deleteFile(ApolloUtil.a(paramApolloActionData, 6));
            URLDrawable.removeMemoryCacheByUrl(new URL("apollo_pic", null, paramApolloActionData.actionId + "_" + paramApolloActionData.actionName).toString());
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "del old action res id:" + paramApolloActionData.actionId + ", ret: " + bool);
            }
          }
          else
          {
            a((String)localObject, paramApolloActionData);
            return;
          }
        }
        catch (Exception paramApolloActionData)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ApolloManager", 2, "checkActionVersion failed " + paramApolloActionData.toString());
          }
        }
      }
    }
  }
  
  public boolean b(ApolloActionData paramApolloActionData, int paramInt)
  {
    if (paramApolloActionData == null) {
      return false;
    }
    String str = "";
    if ((paramInt & 0x1) == 1) {
      str = ApolloUtil.a(paramApolloActionData, 0);
    }
    for (;;)
    {
      return ahbj.isFileExists(str);
      if ((paramInt & 0x2) == 2) {
        str = ApolloUtil.a(paramApolloActionData, 2);
      }
    }
  }
  
  public boolean b(ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage == null) {
      return false;
    }
    return ahbj.isFileExists(ApolloUtil.a(paramApolloActionPackage));
  }
  
  public void bG(int paramInt, String paramString)
  {
    if (this.mApp == null) {
      return;
    }
    abxk localabxk = (abxk)this.mApp.getManager(155);
    if (localabxk.dE != null) {
      localabxk.dE.put(Integer.valueOf(paramInt), paramString);
    }
    this.mApp.getApplication().getSharedPreferences("apollo_sp", 0).edit().putString("apollo_game_ver_" + paramInt, paramString).commit();
  }
  
  public void bi(int paramInt, boolean paramBoolean)
  {
    ThreadManager.post(new ApolloManager.8(this, paramBoolean, paramInt), 5, null, false);
  }
  
  public void c(int paramInt1, int paramInt2, long paramLong)
  {
    long l2 = 0L;
    if (this.be == null) {
      this.be = new JSONObject();
    }
    String str;
    JSONObject localJSONObject1;
    if (paramInt1 == 3)
    {
      str = "action_version";
      if (str != null)
      {
        ??? = this.be.optJSONObject(str);
        localJSONObject1 = ???;
        if (??? == null) {
          localJSONObject1 = new JSONObject();
        }
      }
    }
    for (;;)
    {
      synchronized (this.be)
      {
        try
        {
          l1 = localJSONObject1.optLong(String.valueOf(paramInt2), 0L);
          l2 = l1;
          if (l1 == paramLong) {
            break label285;
          }
          l2 = l1;
          localJSONObject1.put(String.valueOf(paramInt2), paramLong);
          l2 = l1;
          this.be.put(str, localJSONObject1);
          m = 1;
          if (m != 0)
          {
            ThreadManager.getFileThreadHandler().removeCallbacks(this.fv);
            ThreadManager.getFileThreadHandler().postDelayed(this.fv, 6000L);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "saveLocalTS id: " + paramInt2 + ", old TS: " + l1 + ", new TS: " + paramLong + ", type: " + paramInt1);
            }
          }
          return;
        }
        catch (Exception localException)
        {
          QLog.d("ApolloManager", 2, localException.getMessage());
        }
        if (paramInt1 == 2)
        {
          str = "dress_version";
          break;
        }
        if (paramInt1 == 1) {
          str = "role_version";
        }
      }
      Object localObject2 = null;
      break;
      label285:
      int m = 0;
      long l1 = l2;
    }
  }
  
  public void c(DrawerPushItem paramDrawerPushItem)
  {
    a(paramDrawerPushItem, true);
  }
  
  public void cBG()
  {
    if (this.bCP) {
      return;
    }
    this.bCP = true;
    aeis.initConfig();
  }
  
  public void cBK()
  {
    if ((this.mApp == null) || (this.mApp.getApp() == null)) {}
    long l;
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      l = NetConnInfoCenter.getServerTime();
      localSharedPreferences = this.mApp.getApp().getSharedPreferences("apollo_sp" + this.mApp.getCurrentUin(), 0);
    } while (l - localSharedPreferences.getLong("sp_key_apollo_check_action_time", 0L) <= 300L);
    aczo.r(this.mApp, 1);
    localSharedPreferences.edit().putLong("sp_key_apollo_check_action_time", l).commit();
  }
  
  public void cBL()
  {
    if (this.jdField_a_of_type_Abyt != null) {
      this.jdField_a_of_type_Abyt.m(Boolean.valueOf(true));
    }
  }
  
  public void cBM()
  {
    if (this.jdField_a_of_type_Abyt != null) {
      this.jdField_a_of_type_Abyt.m(Boolean.valueOf(true));
    }
  }
  
  public void cBN()
  {
    this.cr.removeMessages(coJ);
    this.cr.sendEmptyMessage(coJ);
  }
  
  public void cBP()
  {
    if (this.mApp == null) {}
    aczo localaczo;
    do
    {
      return;
      localaczo = (aczo)this.mApp.getBusinessHandler(115);
    } while ((localaczo == null) || (!localaczo.cM.get()));
    QLog.w("ApolloManager", 1, "config is done, then request update");
    ArrayList localArrayList = new ArrayList();
    localaczo.dR(localArrayList);
    localaczo.bQ(localArrayList);
    localaczo.cM.set(false);
  }
  
  public void cBQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "[removeAllS2CPushItem]");
    }
    ThreadManager.post(new ApolloManager.17(this), 5, null, true);
  }
  
  public void cBS()
  {
    if ((this.wb == null) || (this.wb.size() == 0)) {
      return;
    }
    this.wb.clear();
    this.wb = null;
  }
  
  public void cBT()
  {
    if ((this.wb == null) || (this.wb.size() == 0)) {
      return;
    }
    synchronized (this.wb)
    {
      Iterator localIterator = this.wb.iterator();
      if (localIterator.hasNext()) {
        ((abhh.a)localIterator.next()).cBX();
      }
    }
  }
  
  public void cBU()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "[checkCompat2DActionRsc]");
    }
    if (this.mApp != null)
    {
      Object localObject = (abxk)this.mApp.getManager(155);
      ApolloActionData localApolloActionData = ((abxk)localObject).a(1450);
      if (localApolloActionData != null) {
        gC(localApolloActionData.actionId, localApolloActionData.personNum);
      }
      localObject = ((abxk)localObject).a(1454);
      if (localObject != null) {
        gC(((ApolloActionData)localObject).actionId, ((ApolloActionData)localObject).personNum);
      }
    }
  }
  
  public void cBV()
  {
    Object localObject1;
    if (this.mApp != null)
    {
      Object localObject2 = (abxk)this.mApp.getManager(155);
      localObject1 = ((abxk)localObject2).N(400);
      if (((abxk)localObject2).c(3000059) == null) {
        break label99;
      }
      if (localObject1 != null) {
        break label96;
      }
      localObject1 = new ArrayList();
      localObject2 = new ApolloActionData();
      ((ApolloActionData)localObject2).actionId = 3000059;
      ((List)localObject1).add(localObject2);
    }
    label96:
    label99:
    for (;;)
    {
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        w((List)localObject1, "apollo_key");
      }
      return;
      break;
    }
  }
  
  public void cBW()
  {
    ArrayList localArrayList = new ArrayList();
    awmr localawmr = new awmr();
    localawmr.eBV = 364;
    localawmr.eBW = 1;
    localArrayList.add(localawmr);
    localawmr = new awmr();
    localawmr.eBV = 365;
    localawmr.eBW = 1;
    localArrayList.add(localawmr);
    localawmr = new awmr();
    localawmr.eBV = 366;
    localawmr.eBW = 1;
    localArrayList.add(localawmr);
    localawmr = new awmr();
    localawmr.eBV = 367;
    localawmr.eBW = 1;
    localArrayList.add(localawmr);
    localawmr = new awmr();
    localawmr.eBV = 393;
    localawmr.eBW = 1;
    localArrayList.add(localawmr);
    localawmr = new awmr();
    localawmr.eBV = 433;
    localawmr.eBW = 20;
    localArrayList.add(localawmr);
    awmt.a().a(localArrayList, this.jdField_a_of_type_Awms);
  }
  
  public int cc(String paramString)
  {
    paramString = b(paramString);
    if ((paramString == null) || (paramString.apolloVipLevel < 1)) {
      return 1;
    }
    return paramString.apolloVipLevel;
  }
  
  public int cd(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      return paramString.apolloStatus;
    }
    return 0;
  }
  
  public String d(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (!paramString1.contains("3d_interact"))) {}
    do
    {
      do
      {
        return paramString1;
        String str = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          str = paramQQAppInterface.getCurrentAccountUin();
        }
        paramQQAppInterface = a(str);
      } while (paramQQAppInterface == null);
      paramString2 = paramQQAppInterface.getApolloDress3D();
    } while (paramString2 == null);
    paramQQAppInterface = paramString1;
    if (paramString2.bgH != null) {
      paramQQAppInterface = aurr.addParameter(paramString1, "facedata", paramString2.bgH);
    }
    paramString1 = paramQQAppInterface;
    if (paramString2.M() != null) {
      paramString1 = aurr.addParameter(paramQQAppInterface, "dressids", Arrays.toString(paramString2.M()).replaceAll(" ", ""));
    }
    return aurr.addParameter(paramString1, "roleid", String.valueOf(paramString2.roleId));
  }
  
  public void da(String paramString, int paramInt)
  {
    Message localMessage = this.cr.obtainMessage();
    localMessage.what = coK;
    localMessage.arg1 = paramInt;
    localMessage.obj = paramString;
    this.cr.sendMessage(localMessage);
  }
  
  public String db(int paramInt)
  {
    Object localObject2;
    if (!new File(ApolloUtil.dp(paramInt)).exists())
    {
      QLog.i("ApolloManager", 1, "[getApolloGameLocalVersion], errInfo->game main.lua file not exists, gameId:" + paramInt);
      localObject2 = "0.0";
      return localObject2;
    }
    if (this.mApp == null) {
      return "0.0";
    }
    Object localObject1 = (abxk)this.mApp.getManager(155);
    if (((abxk)localObject1).dE.size() == 0) {
      ((abxk)localObject1).cFZ();
    }
    for (;;)
    {
      localObject2 = (String)((abxk)localObject1).dE.get(Integer.valueOf(paramInt));
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = this.mApp.getApplication().getSharedPreferences("apollo_sp", 0).getString("apollo_game_ver_" + paramInt, "0.0");
        QLog.i("ApolloManager", 1, "read game ver from sp");
      }
      localObject2 = localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloManager", 2, "gameVer:" + (String)localObject1 + ",id:" + paramInt);
      return localObject1;
      if (TextUtils.isEmpty((CharSequence)((abxk)localObject1).dE.get(Integer.valueOf(paramInt)))) {
        ((abxk)localObject1).In(paramInt);
      }
    }
  }
  
  public long f(int paramInt1, int paramInt2)
  {
    if (this.be == null) {}
    for (;;)
    {
      return 0L;
      JSONObject localJSONObject = null;
      if (paramInt1 == 3) {
        localJSONObject = this.be.optJSONObject("action_version");
      }
      while (localJSONObject != null)
      {
        return localJSONObject.optLong(String.valueOf(paramInt2));
        if (paramInt1 == 2) {
          localJSONObject = this.be.optJSONObject("dress_version");
        } else if (paramInt1 == 1) {
          localJSONObject = this.be.optJSONObject("role_version");
        }
      }
    }
  }
  
  public int fV(int paramInt)
  {
    int m = 0;
    for (;;)
    {
      try
      {
        if (this.bfZ == null) {
          return -1;
        }
        JSONArray localJSONArray = new JSONArray(this.bfZ);
        int n = localJSONArray.length();
        if (m >= n) {
          continue;
        }
        JSONObject localJSONObject = localJSONArray.getJSONObject(m);
        if (localJSONObject.getInt("roleId") != paramInt) {
          continue;
        }
        localJSONArray = localJSONObject.getJSONArray("petStateMapping").getJSONObject(0).getJSONArray("actionSet");
        paramInt = localJSONArray.length();
        paramInt = ((Integer)localJSONArray.get(new Random().nextInt(paramInt))).intValue();
      }
      catch (Exception localException)
      {
        QLog.e("ApolloPet", 1, "getPetRandomAction error:", localException);
        paramInt = -1;
        continue;
      }
      return paramInt;
      m += 1;
    }
  }
  
  public String g(QQAppInterface paramQQAppInterface, String paramString)
  {
    ApolloBaseInfo localApolloBaseInfo = b(paramString);
    if (localApolloBaseInfo == null) {
      return null;
    }
    try
    {
      if (this.iR.get(paramString) == null) {}
      for (long l = 0L; (localApolloBaseInfo.appearAction == null) && (NetConnInfoCenter.getServerTime() - l > 180L); l = ((Long)this.iR.get(paramString)).longValue())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, new Object[] { "getApolloAppearAction request appear action uin:", paramString.substring(0, 4) });
        }
        ((aqrb)paramQQAppInterface.getBusinessHandler(71)).d(new long[] { Long.parseLong(paramString) });
        this.iR.put(paramString, Long.valueOf(NetConnInfoCenter.getServerTime()));
        return null;
      }
      if (localApolloBaseInfo.appearAction == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "getApolloAppearAction request appear action is null and last request is near");
        }
      }
      else
      {
        paramQQAppInterface = new JSONObject(localApolloBaseInfo.appearAction).optJSONArray("action").toString();
        return paramQQAppInterface;
      }
    }
    catch (JSONException paramQQAppInterface)
    {
      QLog.e("ApolloManager", 1, "getApolloAppearAction e:", paramQQAppInterface);
      return null;
    }
    return null;
  }
  
  public WeakReference<BaseChatPie> g()
  {
    return this.fd;
  }
  
  public void gB(int paramInt1, int paramInt2)
  {
    Hh(paramInt1);
    Hi(paramInt1);
  }
  
  void gC(int paramInt1, int paramInt2)
  {
    if ((!ApolloUtil.aF(paramInt1, paramInt2)) && (this.mApp != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ApolloPet", 2, "start download action:" + paramInt1);
      }
      Object localObject = new ApolloActionData();
      ((ApolloActionData)localObject).actionId = paramInt1;
      String str = ApolloUtil.a((ApolloActionData)localObject, 5);
      localObject = ApolloUtil.a((ApolloActionData)localObject, 4);
      abto.b(this.mApp, (String)localObject, str);
    }
  }
  
  public void gD(int paramInt1, int paramInt2)
  {
    QLog.d("ApolloManager", 1, new Object[] { "[notify3dFlagUpdate] previous3dFlag=", Integer.valueOf(paramInt1), ", new3dFlag=", Integer.valueOf(paramInt2) });
    if (((paramInt1 & 0x1) != (paramInt2 & 0x1)) || ((paramInt1 & 0x2) != (paramInt2 & 0x2)))
    {
      paramInt1 = ApolloGameUtil.x(this.mApp);
      boolean bool = R(this.mApp);
      QLog.d("ApolloManager", 1, new Object[] { "[notify3dFlagUpdate] currentStatus=", Integer.valueOf(paramInt1), ", is3dAvailable=", Boolean.valueOf(bool) });
      if (this.wc != null)
      {
        Iterator localIterator = this.wc.iterator();
        while (localIterator.hasNext())
        {
          abhh.c localc = (abhh.c)((WeakReference)localIterator.next()).get();
          if (localc != null) {
            localc.bj(paramInt1, bool);
          }
        }
      }
    }
  }
  
  public QQAppInterface getApp()
  {
    if (this.mAppRef == null) {
      return null;
    }
    return (QQAppInterface)this.mAppRef.get();
  }
  
  public void hV(List<ApolloBaseInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (this.mApp == null)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ApolloManager.11(this, paramList));
  }
  
  public void hW(List<ApolloBaseInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      if (paramList.size() == 1)
      {
        a((ApolloBaseInfo)paramList.get(0));
        return;
      }
      Iterator localIterator = paramList.iterator();
      ApolloBaseInfo localApolloBaseInfo;
      while (localIterator.hasNext())
      {
        localApolloBaseInfo = (ApolloBaseInfo)localIterator.next();
        if (!TextUtils.isEmpty(localApolloBaseInfo.uin))
        {
          if (localApolloBaseInfo.uin.equals(this.mApp.getCurrentAccountUin())) {
            this.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo = localApolloBaseInfo;
          }
          synchronized (this.d)
          {
            this.d.put(localApolloBaseInfo.uin, localApolloBaseInfo);
          }
        }
      }
      ??? = this.em.getTransaction();
      ((EntityTransaction)???).begin();
      try
      {
        localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          localApolloBaseInfo = (ApolloBaseInfo)localIterator.next();
          if (!TextUtils.isEmpty(localApolloBaseInfo.uin)) {
            a(localApolloBaseInfo);
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "bulk insert exception: " + localException.getMessage());
        }
        ((EntityTransaction)???).end();
        while ((QLog.isColorLevel()) && (paramList.contains(this.mApp.getCurrentUin())))
        {
          paramList = (ApolloBaseInfo)this.d.get(this.mApp.getCurrentUin());
          QLog.d("ApolloManager", 2, "save apollo info vip flag: " + paramList.apolloVipFlag + ", level: " + paramList.apolloVipFlag + ", apollo status: " + paramList.apolloStatus + ", apollo local TS: " + paramList.apolloLocalTS + ", apollo svr TS:" + paramList.apolloServerTS + ", apollo upt TS:" + paramList.apolloUpdateTime);
          return;
          ((EntityTransaction)???).commit();
          ((EntityTransaction)???).end();
        }
      }
      finally
      {
        ((EntityTransaction)???).end();
      }
    }
  }
  
  public String is(String paramString)
  {
    try
    {
      paramString = b(paramString);
      if (paramString == null) {
        return "";
      }
      paramString = paramString.getApolloPetDress();
      if (paramString == null) {
        return "";
      }
      int m = paramString.roleId;
      return String.valueOf(m);
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public boolean jl(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      return paramString.apolloVipFlag == 1;
    }
    return false;
  }
  
  public boolean jm(String paramString)
  {
    boolean bool = true;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals(this.mApp.getCurrentAccountUin())) {
        bool = avqy.a().aLr();
      }
      do
      {
        return bool;
        paramString = b(paramString);
      } while ((paramString != null) && (paramString.superYellowDiamondFlag == 1));
      return false;
    }
    return false;
  }
  
  public boolean jn(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      return paramString.isApolloGameWhiteUser();
    }
    return false;
  }
  
  public void n(WeakReference<BaseChatPie> paramWeakReference)
  {
    this.fd = paramWeakReference;
    abhh.e locale = a();
    if (paramWeakReference != null) {}
    for (boolean bool = true;; bool = false)
    {
      abhh.e.a(locale, bool);
      return;
    }
  }
  
  public void o(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "checkApolloPanelJsonCfg begin..." + paramString + ",task:" + paramInt);
    }
    if ((paramBoolean) || (((paramInt & 0x1) == 1) && (!ahbj.isFileExists(ApolloUtil.bkb))))
    {
      Hd(paramInt);
      QLog.d("ApolloManager", 1, "checkApolloPanelJsonCfg download json  forceDownload is: " + paramBoolean);
      return;
    }
    g(this.mApp);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "onDestroy.");
    }
    if (this.jdField_a_of_type_Abhh$b != null) {}
    try
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_Abhh$b);
      this.jdField_a_of_type_Abhh$b = null;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "onDestroy. unregisterReceiver mBroadcastReceiver success");
      }
      this.bCP = false;
      ApolloUtil.aEf();
      coG = -1;
      coH = -1;
      this.em.close();
      abto.dx.clear();
      aM.clear();
      this.cr.removeCallbacksAndMessages(null);
      bCA = false;
      com.tencent.mobileqq.apollo.view.ApolloPanel.cuh = 0;
      if (this.dr != null) {
        this.dr.clear();
      }
      if (this.d == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.d.evictAll();
        label133:
        cj.set(false);
        ch.set(false);
        ApolloCmdChannel.checkNeedDestroy();
        if (this.jdField_a_of_type_Abhs != null)
        {
          this.jdField_a_of_type_Abhs.onDestroy();
          this.jdField_a_of_type_Abhs = null;
        }
        ApolloGameStateMachine.cCM();
        ApolloGameUtil.releaseCache();
        this.jdField_a_of_type_Abhf.onDestroy();
        ablp.cCO();
        abxe.clear();
        if (this.jdField_a_of_type_Abmi != null) {
          this.jdField_a_of_type_Abmi.onDestroy();
        }
        if (this.jdField_a_of_type_Abmb != null)
        {
          this.jdField_a_of_type_Abmb.onDestroy();
          this.jdField_a_of_type_Abmb = null;
        }
        if (this.jdField_a_of_type_Ablz != null)
        {
          this.jdField_a_of_type_Ablz.onDestory();
          this.jdField_a_of_type_Ablz = null;
        }
        cBS();
        abmm.a().cDo();
        abox localabox = abmm.a().a();
        if (localabox != null) {
          localabox.onDestroy();
        }
        abwk.a().onDestroy();
        bfU = null;
        if (this.z != null)
        {
          this.z.cancel();
          this.z.purge();
          this.z = null;
        }
        return;
        localException1 = localException1;
        QLog.e("ApolloManager", 1, localException1, new Object[0]);
      }
      catch (Exception localException2)
      {
        break label133;
      }
    }
  }
  
  public String qS()
  {
    if ((!this.bCF) && (!this.bCL)) {
      return acfp.m(2131702609);
    }
    return acfp.m(2131702606);
  }
  
  public String r(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return abxi.bjv;
    }
    return d(this.mApp, abxi.bjB, paramString);
  }
  
  public void removeAllListener()
  {
    if (this.jdField_a_of_type_Abyt != null) {
      this.jdField_a_of_type_Abyt.clear();
    }
  }
  
  public String s(int paramInt, String paramString)
  {
    int n = x(getApp());
    boolean bool = R(getApp());
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("3d"))) {}
    for (paramInt = 2;; paramInt = 1)
    {
      Object localObject1 = "";
      int m;
      if ((!bool) && (n == paramInt))
      {
        localObject1 = s(paramString, true);
        m = 1;
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (m == 0))
        {
          if (n != 2) {
            break label393;
          }
          localObject1 = abxi.bjB;
        }
      }
      for (;;)
      {
        Object localObject2 = localObject1;
        if (bool)
        {
          localObject2 = localObject1;
          if (n == 1)
          {
            localObject2 = localObject1;
            if (getApp() != null)
            {
              SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0);
              localObject3 = getApp().getCurrentAccountUin() + "_" + "sp_key_first_3d_tab";
              localObject2 = localObject1;
              if (!localSharedPreferences.getBoolean((String)localObject3, false))
              {
                localObject2 = localObject1;
                if (!TextUtils.isEmpty(abxi.bjB))
                {
                  localObject2 = abxi.bjB;
                  localObject1 = localSharedPreferences.edit();
                  ((SharedPreferences.Editor)localObject1).putBoolean((String)localObject3, true);
                  ((SharedPreferences.Editor)localObject1).commit();
                }
              }
            }
          }
        }
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getLastTabUrl userStatus:").append(n).append(",tabStatus:").append(paramInt).append(",tabScheme:").append(paramString).append(",is3DAvailable:").append(bool).append(",url:").append((String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, ((StringBuilder)localObject3).toString());
        }
        paramString = (String)localObject2;
        if (!TextUtils.isEmpty(abxi.bjB))
        {
          paramString = (String)localObject2;
          if (abxi.bjB.equals(localObject2)) {
            paramString = d(this.mApp, (String)localObject2, null);
          }
        }
        localObject1 = paramString;
        if (TextUtils.isEmpty(paramString))
        {
          localObject1 = abxi.bjv;
          QLog.d("ApolloManager", 1, new Object[] { "url is empty", ((StringBuilder)localObject3).toString() });
        }
        return localObject1;
        m = 0;
        break;
        label393:
        if (bool) {
          localObject1 = abxi.bjD;
        } else {
          localObject1 = abxi.bjv;
        }
      }
    }
  }
  
  public void w(List<ApolloActionData> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Bundle localBundle;
    ArrayList localArrayList;
    do
    {
      HashMap localHashMap;
      do
      {
        return;
        localBundle = new Bundle();
        localArrayList = new ArrayList();
        localHashMap = new HashMap();
        a(localArrayList, localHashMap, paramList, localBundle);
      } while (localBundle.size() == 0);
      paramList = new aquz(localArrayList, localHashMap, paramString);
      paramList.cWw = true;
      paramList.cxX = "apollo_res";
      paramList.cWy = true;
      paramList.cWB = false;
      paramList.cWA = true;
      paramList.cWz = true;
    } while ((localArrayList.size() == 0) || (a() == null));
    VipUtils.a(this.mApp, "cmshow", "Apollo", "action_download_begin", 0, 0, new String[0]);
    a().a(paramList, this.j, localBundle);
  }
  
  public int zy()
  {
    int i1 = 0;
    int m = -1;
    int n;
    if (this.mApp == null) {
      n = m;
    }
    int i2;
    do
    {
      boolean bool;
      do
      {
        return n;
        if (aV(this.mApp.getApplication())) {
          m = 0;
        }
        bool = ApolloEngine.BJ();
        i2 = x(this.mApp);
        if (i2 > 0) {
          i1 = 1;
        }
        n = m;
      } while (!bool);
      n = m;
    } while (i1 == 0);
    if (i2 == 1) {
      return 1;
    }
    return 6;
  }
  
  public static abstract interface a
  {
    public abstract void cBX();
  }
  
  class b
    extends BroadcastReceiver
  {
    b() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent == null) {
        QLog.e("ApolloManager", 1, "[onReceive] intent null");
      }
      do
      {
        return;
        paramContext = paramIntent.getAction();
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, new Object[] { "[onReceive] action=", paramContext });
        }
      } while (!"com.tencent.mobileqq.action.ACTION_APOLLO_STORE_CRASH_EVENT".equals(paramContext));
      paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0).getString("apollo_store_watch_current_url", "");
      ((aqrb)abhh.this.mApp.getBusinessHandler(71)).o(null, paramContext, -1003, 0);
    }
  }
  
  public static abstract interface c
  {
    public abstract void bj(int paramInt, boolean paramBoolean);
  }
  
  public static class d
  {
    public static String WX;
    public static boolean bCU;
    public static String bgc;
    public static String bgd;
    public static String bge;
    public static String bgf;
    public static int coN;
    public static String sAppId;
    public static String sAppName;
    public static String sIconUrl;
    public static String sMd5;
    public static String sTraceInfo;
    public static int sVersionCode;
    
    static {}
    
    private static void a(Map<String, String> paramMap, int paramInt, String paramString)
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_app3d_config", 0);
      try
      {
        boolean bool;
        if (Integer.parseInt((String)paramMap.get("show")) == 1)
        {
          bool = true;
          bCU = bool;
          WX = (String)paramMap.get("packageName");
          bgc = (String)paramMap.get("downloadUrl");
          sIconUrl = (String)paramMap.get("iconUrl");
          bgd = (String)paramMap.get("progressUrl");
          sMd5 = (String)paramMap.get("md5");
          bge = (String)paramMap.get("apkSize");
          sVersionCode = Integer.parseInt((String)paramMap.get("versionCode"));
          bgf = (String)paramMap.get("apkSign");
          sAppName = (String)paramMap.get("appName");
          sAppId = (String)paramMap.get("appId");
          coN = paramInt;
          sTraceInfo = paramString;
          if ((TextUtils.isEmpty(WX)) || (TextUtils.isEmpty(bgc)) || (TextUtils.isEmpty(sIconUrl)) || (TextUtils.isEmpty(sAppId)))
          {
            bCU = false;
            QLog.w("ApolloManager", 1, "App3DConfig parse invalid param");
          }
          paramMap = localSharedPreferences.edit();
          if (!bCU) {
            break label391;
          }
        }
        label391:
        for (paramInt = 1;; paramInt = 0)
        {
          paramMap.putInt("show", paramInt).putString("packageName", WX).putString("downloadUrl", bgc).putString("md5", sMd5).putString("iconUrl", sIconUrl).putString("progressUrl", bgd).putString("apkSize", bge).putInt("versionCode", sVersionCode).putString("apkSign", bgf).putString("appName", sAppName).putString("appId", sAppId).putInt("adId", coN).putString("traceInfo", sTraceInfo).commit();
          return;
          bool = false;
          break;
        }
        return;
      }
      catch (Throwable paramMap)
      {
        QLog.e("ApolloManager", 1, "App3DConfig parse error:", paramMap);
      }
    }
    
    private static void init()
    {
      boolean bool = true;
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_app3d_config", 0);
      if (localSharedPreferences.getInt("show", 0) == 1) {}
      for (;;)
      {
        bCU = bool;
        WX = localSharedPreferences.getString("packageName", null);
        bgc = localSharedPreferences.getString("downloadUrl", "");
        sIconUrl = localSharedPreferences.getString("iconUrl", "");
        bgd = localSharedPreferences.getString("progressUrl", "");
        sMd5 = localSharedPreferences.getString("md5", "");
        bge = localSharedPreferences.getString("apkSize", "");
        sVersionCode = localSharedPreferences.getInt("versionCode", 0);
        bgf = localSharedPreferences.getString("apkSign", "");
        sAppName = localSharedPreferences.getString("appName", "");
        sAppId = localSharedPreferences.getString("appId", "");
        coN = localSharedPreferences.getInt("adId", 0);
        sTraceInfo = localSharedPreferences.getString("traceInfo", "");
        return;
        bool = false;
      }
    }
  }
  
  public class e
    implements abhh.c
  {
    private DrawerPushItem b;
    public boolean bCV;
    public boolean bCW;
    private boolean bCX;
    private boolean bCY;
    private boolean bCZ;
    private int mApolloStatus;
    
    private e()
    {
      resetStatus();
      SharedPreferences localSharedPreferences = abhh.this.mApp.getApp().getSharedPreferences("apollo_sp" + abhh.this.mApp.getCurrentUin(), 0);
      if (localSharedPreferences.getInt("key_panel_meet_3d_action", 0) == 1)
      {
        bool1 = true;
        this.bCV = bool1;
        if (localSharedPreferences.getInt("key_panel_shown_guide_for_action", 0) != 1) {
          break label134;
        }
        bool1 = true;
        label90:
        this.bCX = bool1;
        if (localSharedPreferences.getInt("key_panel_shown_guide_for_json", 0) != 1) {
          break label139;
        }
      }
      label134:
      label139:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.bCY = bool1;
        abhh.this.a(this);
        abvk.ci(abhh.this.mApp);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label90;
      }
    }
    
    /* Error */
    private void DE(boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iload_1
      //   4: putfield 99	abhh$e:bCZ	Z
      //   7: iload_1
      //   8: ifeq +10 -> 18
      //   11: aload_0
      //   12: invokespecial 31	abhh$e:resetStatus	()V
      //   15: aload_0
      //   16: monitorexit
      //   17: return
      //   18: aload_0
      //   19: getfield 101	abhh$e:b	Lcom/tencent/mobileqq/DrawerPushItem;
      //   22: ifnull -7 -> 15
      //   25: aload_0
      //   26: getfield 25	abhh$e:this$0	Labhh;
      //   29: aload_0
      //   30: getfield 101	abhh$e:b	Lcom/tencent/mobileqq/DrawerPushItem;
      //   33: invokevirtual 104	abhh:a	(Lcom/tencent/mobileqq/DrawerPushItem;)V
      //   36: aload_0
      //   37: aconst_null
      //   38: putfield 101	abhh$e:b	Lcom/tencent/mobileqq/DrawerPushItem;
      //   41: goto -26 -> 15
      //   44: astore_2
      //   45: aload_0
      //   46: monitorexit
      //   47: aload_2
      //   48: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	49	0	this	e
      //   0	49	1	paramBoolean	boolean
      //   44	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	44	finally
      //   11	15	44	finally
      //   18	41	44	finally
    }
    
    /* Error */
    private void c(Map<String, String> paramMap, int paramInt, String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: getstatic 119	abhh$d:bCU	Z
      //   5: ifne +30 -> 35
      //   8: ldc 121
      //   10: iconst_1
      //   11: iconst_2
      //   12: anewarray 4	java/lang/Object
      //   15: dup
      //   16: iconst_0
      //   17: ldc 123
      //   19: aastore
      //   20: dup
      //   21: iconst_1
      //   22: getstatic 119	abhh$d:bCU	Z
      //   25: invokestatic 129	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   28: aastore
      //   29: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
      //   32: aload_0
      //   33: monitorexit
      //   34: return
      //   35: aload_0
      //   36: getfield 25	abhh$e:this$0	Labhh;
      //   39: getfield 35	abhh:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
      //   42: invokevirtual 41	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
      //   45: new 43	java/lang/StringBuilder
      //   48: dup
      //   49: invokespecial 44	java/lang/StringBuilder:<init>	()V
      //   52: ldc 46
      //   54: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   57: aload_0
      //   58: getfield 25	abhh$e:this$0	Labhh;
      //   61: getfield 35	abhh:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
      //   64: invokevirtual 54	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
      //   67: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   70: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   73: iconst_0
      //   74: invokevirtual 63	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
      //   77: astore 6
      //   79: aload 6
      //   81: ldc 137
      //   83: iconst_0
      //   84: invokeinterface 71 3 0
      //   89: istore 4
      //   91: ldc 121
      //   93: iconst_1
      //   94: iconst_4
      //   95: anewarray 4	java/lang/Object
      //   98: dup
      //   99: iconst_0
      //   100: ldc 139
      //   102: aastore
      //   103: dup
      //   104: iconst_1
      //   105: iload 4
      //   107: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   110: aastore
      //   111: dup
      //   112: iconst_2
      //   113: ldc 146
      //   115: aastore
      //   116: dup
      //   117: iconst_3
      //   118: iload_2
      //   119: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   122: aastore
      //   123: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
      //   126: iload_2
      //   127: iload 4
      //   129: if_icmpeq -97 -> 32
      //   132: new 148	com/tencent/mobileqq/DrawerPushItem
      //   135: dup
      //   136: invokespecial 149	com/tencent/mobileqq/DrawerPushItem:<init>	()V
      //   139: astore 7
      //   141: aload 7
      //   143: iconst_0
      //   144: putfield 152	com/tencent/mobileqq/DrawerPushItem:is_reddot	I
      //   147: aload 7
      //   149: ldc 154
      //   151: putfield 158	com/tencent/mobileqq/DrawerPushItem:msg_id	Ljava/lang/String;
      //   154: aload 7
      //   156: bipush 10
      //   158: putfield 161	com/tencent/mobileqq/DrawerPushItem:msg_type	I
      //   161: aload 7
      //   163: sipush 900
      //   166: putfield 164	com/tencent/mobileqq/DrawerPushItem:priority	I
      //   169: aload_1
      //   170: ldc 166
      //   172: invokeinterface 172 2 0
      //   177: checkcast 174	java/lang/String
      //   180: invokestatic 180	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   183: l2i
      //   184: sipush 1000
      //   187: idiv
      //   188: istore 4
      //   190: aload 7
      //   192: iload 4
      //   194: putfield 183	com/tencent/mobileqq/DrawerPushItem:start_ts	I
      //   197: invokestatic 189	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
      //   200: l2i
      //   201: istore 5
      //   203: aload 7
      //   205: aload_1
      //   206: ldc 191
      //   208: invokeinterface 172 2 0
      //   213: checkcast 174	java/lang/String
      //   216: invokestatic 180	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   219: l2i
      //   220: sipush 1000
      //   223: idiv
      //   224: iload 4
      //   226: isub
      //   227: iload 5
      //   229: iadd
      //   230: putfield 194	com/tencent/mobileqq/DrawerPushItem:end_ts	I
      //   233: aload 7
      //   235: iload 4
      //   237: putfield 197	com/tencent/mobileqq/DrawerPushItem:send_time	I
      //   240: aload 7
      //   242: aload_1
      //   243: ldc 199
      //   245: invokeinterface 172 2 0
      //   250: checkcast 174	java/lang/String
      //   253: putfield 202	com/tencent/mobileqq/DrawerPushItem:content	Ljava/lang/String;
      //   256: aload 7
      //   258: iload_2
      //   259: putfield 205	com/tencent/mobileqq/DrawerPushItem:tianshuAdId	I
      //   262: aload 7
      //   264: aload_3
      //   265: putfield 208	com/tencent/mobileqq/DrawerPushItem:tianshuTraceInfo	Ljava/lang/String;
      //   268: aload 7
      //   270: aload_1
      //   271: ldc 210
      //   273: invokeinterface 172 2 0
      //   278: checkcast 174	java/lang/String
      //   281: invokestatic 214	java/lang/Integer:parseInt	(Ljava/lang/String;)I
      //   284: putfield 217	com/tencent/mobileqq/DrawerPushItem:show_counts	I
      //   287: aload 7
      //   289: getfield 217	com/tencent/mobileqq/DrawerPushItem:show_counts	I
      //   292: ifne +9 -> 301
      //   295: aload 7
      //   297: iconst_1
      //   298: putfield 217	com/tencent/mobileqq/DrawerPushItem:show_counts	I
      //   301: aload_1
      //   302: ldc 219
      //   304: invokeinterface 172 2 0
      //   309: checkcast 174	java/lang/String
      //   312: invokestatic 214	java/lang/Integer:parseInt	(Ljava/lang/String;)I
      //   315: istore 4
      //   317: aload_0
      //   318: getfield 25	abhh$e:this$0	Labhh;
      //   321: aload 7
      //   323: invokevirtual 221	abhh:c	(Lcom/tencent/mobileqq/DrawerPushItem;)V
      //   326: aload 6
      //   328: invokeinterface 225 1 0
      //   333: ldc 137
      //   335: iload_2
      //   336: invokeinterface 231 3 0
      //   341: invokeinterface 235 1 0
      //   346: pop
      //   347: aload_0
      //   348: iconst_1
      //   349: invokevirtual 238	abhh$e:DD	(Z)V
      //   352: aload_0
      //   353: getfield 99	abhh$e:bCZ	Z
      //   356: ifeq +32 -> 388
      //   359: aload_0
      //   360: getfield 25	abhh$e:this$0	Labhh;
      //   363: getfield 35	abhh:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
      //   366: sipush 211
      //   369: invokevirtual 242	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
      //   372: checkcast 244	abhe
      //   375: getfield 247	abhe:a	Labvi;
      //   378: aload_0
      //   379: getfield 25	abhh$e:this$0	Labhh;
      //   382: getfield 35	abhh:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
      //   385: invokevirtual 252	abvi:cf	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
      //   388: ldc 121
      //   390: iconst_1
      //   391: iconst_4
      //   392: anewarray 4	java/lang/Object
      //   395: dup
      //   396: iconst_0
      //   397: ldc 254
      //   399: aastore
      //   400: dup
      //   401: iconst_1
      //   402: aload 7
      //   404: invokevirtual 255	com/tencent/mobileqq/DrawerPushItem:toString	()Ljava/lang/String;
      //   407: aastore
      //   408: dup
      //   409: iconst_2
      //   410: ldc_w 257
      //   413: aastore
      //   414: dup
      //   415: iconst_3
      //   416: iload 4
      //   418: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   421: aastore
      //   422: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
      //   425: goto -393 -> 32
      //   428: astore_1
      //   429: ldc 121
      //   431: iconst_1
      //   432: ldc_w 259
      //   435: aload_1
      //   436: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   439: goto -407 -> 32
      //   442: astore_1
      //   443: aload_0
      //   444: monitorexit
      //   445: aload_1
      //   446: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	447	0	this	e
      //   0	447	1	paramMap	Map<String, String>
      //   0	447	2	paramInt	int
      //   0	447	3	paramString	String
      //   89	328	4	i	int
      //   201	29	5	j	int
      //   77	250	6	localSharedPreferences	SharedPreferences
      //   139	264	7	localDrawerPushItem	DrawerPushItem
      // Exception table:
      //   from	to	target	type
      //   35	126	428	java/lang/Exception
      //   132	301	428	java/lang/Exception
      //   301	388	428	java/lang/Exception
      //   388	425	428	java/lang/Exception
      //   2	32	442	finally
      //   35	126	442	finally
      //   132	301	442	finally
      //   301	388	442	finally
      //   388	425	442	finally
      //   429	439	442	finally
    }
    
    private void cBY()
    {
      this.b = new DrawerPushItem();
      this.b.is_reddot = 0;
      this.b.msg_type = 10;
      this.b.msg_id = "aio_panel_bubble_guide3d_action";
      this.b.priority = 1000;
      this.b.start_ts = ((int)NetConnInfoCenter.getServerTime() - 1000);
      this.b.end_ts = (this.b.start_ts + 172800000);
      this.b.send_time = this.b.start_ts;
      this.b.content = acfp.m(2131702607);
      this.b.show_counts = 1;
      abhh.this.c(this.b);
      DC(true);
    }
    
    private void resetStatus()
    {
      this.bCW = abhh.R(abhh.this.mApp);
      this.mApolloStatus = abhh.x(abhh.this.mApp);
    }
    
    public void DC(boolean paramBoolean)
    {
      int i = 0;
      try
      {
        this.bCX = paramBoolean;
        SharedPreferences.Editor localEditor = abhh.this.mApp.getApp().getSharedPreferences("apollo_sp" + abhh.this.mApp.getCurrentUin(), 0).edit();
        if (paramBoolean) {
          i = 1;
        }
        localEditor.putInt("key_panel_shown_guide_for_action", i).commit();
        return;
      }
      finally {}
    }
    
    public void DD(boolean paramBoolean)
    {
      int i = 0;
      try
      {
        this.bCY = paramBoolean;
        SharedPreferences.Editor localEditor = abhh.this.mApp.getApp().getSharedPreferences("apollo_sp" + abhh.this.mApp.getCurrentUin(), 0).edit();
        if (paramBoolean) {
          i = 1;
        }
        localEditor.putInt("key_panel_shown_guide_for_json", i).commit();
        return;
      }
      finally {}
    }
    
    public boolean Yl()
    {
      try
      {
        boolean bool = this.bCX;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    /* Error */
    public boolean Ym()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 81	abhh$e:bCY	Z
      //   6: ifeq +17 -> 23
      //   9: getstatic 295	abvk:bFW	Z
      //   12: istore_1
      //   13: iload_1
      //   14: ifne +9 -> 23
      //   17: iconst_1
      //   18: istore_1
      //   19: aload_0
      //   20: monitorexit
      //   21: iload_1
      //   22: ireturn
      //   23: iconst_0
      //   24: istore_1
      //   25: goto -6 -> 19
      //   28: astore_2
      //   29: aload_0
      //   30: monitorexit
      //   31: aload_2
      //   32: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	33	0	this	e
      //   12	13	1	bool	boolean
      //   28	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	13	28	finally
    }
    
    public void bj(int paramInt, boolean paramBoolean)
    {
      try
      {
        resetStatus();
        return;
      }
      finally {}
    }
    
    public boolean c(MessageForApollo paramMessageForApollo)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      try
      {
        if (abhh.d.bCU)
        {
          bool1 = bool2;
          if (!this.bCV)
          {
            bool1 = bool2;
            if (this.bCW)
            {
              bool1 = bool2;
              if (this.mApolloStatus == 1)
              {
                bool1 = bool2;
                if (!abvk.bFW)
                {
                  bool1 = bool2;
                  if (!paramMessageForApollo.isSend())
                  {
                    bool1 = bool2;
                    if (paramMessageForApollo.is3dAction())
                    {
                      this.bCV = true;
                      abhh.this.mApp.getApp().getSharedPreferences("apollo_sp" + abhh.this.mApp.getCurrentUin(), 0).edit().putInt("key_panel_meet_3d_action", 1).commit();
                      cBY();
                      ((abhe)abhh.this.mApp.getManager(211)).a.cf(abhh.this.mApp);
                      QLog.d("ApolloManager", 2, "accept bubble for first 3D action");
                      bool1 = true;
                    }
                  }
                }
              }
            }
          }
        }
        return bool1;
      }
      finally {}
    }
  }
  
  public static class f
  {
    public boolean bDa;
    public int coO;
    public int coP;
    public int coQ;
    public int coR;
    public int[] dressIds;
    public int[] jN;
    public int roleId;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("userStatus:").append(this.coQ).append(",roleId:").append(this.roleId).append(",dressIds:").append(Arrays.toString(this.dressIds)).append(",threeRoleId:").append(this.coO).append(",threeDressIds:").append(Arrays.toString(this.jN));
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface g
  {
    public abstract void gE(int paramInt1, int paramInt2);
  }
  
  public static class h
    extends aquy
  {
    WeakReference<abhh.g> fe;
    WeakReference<QQAppInterface> mAppRef;
    
    public h(QQAppInterface paramQQAppInterface, abhh.g paramg)
    {
      this.mAppRef = new WeakReference(paramQQAppInterface);
      this.fe = new WeakReference(paramg);
    }
    
    public void onDone(aquz paramaquz)
    {
      Object localObject = (QQAppInterface)this.mAppRef.get();
      abhh.g localg = (abhh.g)this.fe.get();
      if ((localObject == null) || (localg == null) || (paramaquz == null) || (paramaquz.getParams() == null) || (paramaquz.ov == null)) {
        return;
      }
      super.onDone(paramaquz);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] httpCode: ", Integer.valueOf(paramaquz.httpCode), ", status: ", Integer.valueOf(paramaquz.getStatus()), ",task.currUrl:", paramaquz.currUrl });
      }
      if (paramaquz.errCode == 0)
      {
        localObject = ((QQAppInterface)localObject).getApplication().getSharedPreferences("apollo_sp", 0).edit();
        ((SharedPreferences.Editor)localObject).putLong(paramaquz.currUrl + "_lastModifiedTime", paramaquz.lastModifiedTime);
        long l2 = 0L;
        File localFile = (File)paramaquz.ov.get(paramaquz.currUrl);
        long l1 = l2;
        if (localFile != null)
        {
          l1 = l2;
          if (localFile.exists())
          {
            l1 = localFile.lastModified();
            ((SharedPreferences.Editor)localObject).putLong(paramaquz.currUrl, l1);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] lastModifiedTime:", Long.valueOf(paramaquz.lastModifiedTime), ",file sd lastModifiedTime:", Long.valueOf(l1) });
        }
        ((SharedPreferences.Editor)localObject).commit();
      }
      localg.gE(paramaquz.errCode, paramaquz.httpCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abhh
 * JD-Core Version:    0.7.0.1
 */