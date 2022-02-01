package com.tencent.mobileqq.listentogether;

import acfd;
import acff;
import acfp;
import acnd;
import aing;
import aink;
import ainl;
import ainm;
import ainn;
import aino;
import ainp;
import ainq;
import ainr;
import ains;
import aint;
import ainu;
import aiob;
import aioc;
import aiod;
import aioe;
import aiov;
import aipd;
import aipp;
import aipq;
import aipr;
import aips;
import aipt;
import aipu;
import aipy;
import aipz;
import alep;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import anot;
import anpc;
import aohy;
import aoig;
import aqha;
import aqju;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ify;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class ListenTogetherManager
  implements Manager
{
  private acnd jdField_a_of_type_Acnd = new ainr(this);
  aioe jdField_a_of_type_Aioe;
  private aipd jdField_a_of_type_Aipd;
  private aipq jdField_a_of_type_Aipq = new ainq(this);
  private aipr jdField_a_of_type_Aipr = new ainp(this);
  private aips jdField_a_of_type_Aips;
  private aipt jdField_a_of_type_Aipt = new aino(this);
  private aipy jdField_a_of_type_Aipy;
  private alep jdField_a_of_type_Alep;
  private RunnableShowForKey jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager$RunnableShowForKey = new RunnableShowForKey(false);
  private a jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager$a = new a(null);
  private WeakReference<aioe> aJ;
  private WeakReference<aiod> aK;
  private long abO;
  private QQAppInterface app;
  private RunnableShowForKey b = new RunnableShowForKey(true);
  private volatile String bPg = "";
  private volatile String bPh = "";
  private volatile String bPi = "";
  private BroadcastReceiver bt = new aint(this);
  private acfd c = new ains(this);
  private volatile boolean ckH;
  private volatile boolean ckI = true;
  private boolean ckJ;
  private boolean ckK;
  int def = -1;
  private Runnable gJ = new ListenTogetherManager.1(this);
  private Runnable gK = new ListenTogetherManager.2(this);
  private Handler.Callback h = new ainu(this);
  private volatile boolean isDestroy;
  private Map<String, ListenTogetherSession> ly;
  private Handler subHandler;
  private LruCache<String, MusicInfo> t;
  private LruCache<String, String> u;
  private LruCache<String, Long> v;
  private LruCache<String, String> w;
  
  public ListenTogetherManager(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.subHandler = new Handler(ThreadManager.getSubThreadLooper(), this.h);
    this.ly = new ConcurrentHashMap();
    this.u = new LruCache(5);
    this.t = new LruCache(100);
    this.v = new LruCache(100);
    this.w = new LruCache(100);
    this.jdField_a_of_type_Aipd = new aipd(paramQQAppInterface);
    this.jdField_a_of_type_Alep = new alep(paramQQAppInterface);
    this.jdField_a_of_type_Aipy = new aipz(paramQQAppInterface);
    this.jdField_a_of_type_Aips = new aipu(BaseApplicationImpl.context, paramQQAppInterface);
    this.jdField_a_of_type_Aips.a(this.jdField_a_of_type_Aipt);
    this.jdField_a_of_type_Aips.a(this.jdField_a_of_type_Aipr);
    this.jdField_a_of_type_Aips.a(this.jdField_a_of_type_Aipq);
    this.jdField_a_of_type_Aips.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager$a);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Acnd);
    paramQQAppInterface.addObserver(this.c);
    BaseApplicationImpl.getContext().registerReceiver(this.bt, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.tim.msg.permission.pushnotify", null);
  }
  
  private int FG()
  {
    if (this.ckH) {
      return 800;
    }
    return 100;
  }
  
  private void LN(String paramString)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(new aioc(paramString, false, true));
    paramString = (aink)this.app.getBusinessHandler(156);
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.ly.get(this.bPh);
    if (localListenTogetherSession == null) {
      return;
    }
    paramString.a(localListenTogetherSession.type, localListenTogetherSession.uin, localArrayList, true);
  }
  
  private void Li(boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.bPg)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (ListenTogetherSession)this.ly.get(this.bPg);
      } while (localObject == null);
      localObject = ((ListenTogetherSession)localObject).b();
    } while (localObject == null);
    String str = (String)this.u.get(((MusicInfo)localObject).id);
    ((aink)this.app.getBusinessHandler(156)).notifyUI(10, true, new Object[] { ((MusicInfo)localObject).id, str, Boolean.valueOf(paramBoolean) });
    StringBuilder localStringBuilder = new StringBuilder().append("notifyMusicModuleLyric lyric: ");
    if (str == null) {}
    for (int i = 0;; i = str.length())
    {
      QLog.i("ListenTogether.Manager", 1, i + " serverError: " + paramBoolean + " songid: " + ((MusicInfo)localObject).id);
      return;
    }
  }
  
  private void P(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogether.Manager", 1, "updateSessionStatus type:" + paramInt1 + " uin:" + paramString + " status:" + paramInt2);
    }
    paramString = aiob.H(paramInt1, paramString);
    if ((this.ly.containsKey(paramString)) && (this.ly.get(paramString) != null))
    {
      ((ListenTogetherSession)this.ly.get(paramString)).status = paramInt2;
      if (QLog.isColorLevel()) {
        QLog.i("ListenTogether.Manager", 1, "updateSessionStatus in ");
      }
    }
  }
  
  private void PX(int paramInt)
  {
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.ly.get(this.bPg);
    if (localListenTogetherSession != null) {
      R(localListenTogetherSession.type, localListenTogetherSession.uin, paramInt);
    }
  }
  
  private void Q(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogether.Manager", 1, "updateSessionPlayMode type:" + paramInt1 + " uin:" + paramString + " playMode:" + paramInt2);
    }
    if ((paramInt2 <= 3) && (paramInt2 >= 1))
    {
      paramString = aiob.H(paramInt1, paramString);
      paramString = (ListenTogetherSession)this.ly.get(paramString);
      if ((paramString != null) && (paramString.playMode != paramInt2))
      {
        paramString.playMode = paramInt2;
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogether.Manager", 1, "updateSessionPlayMode in ");
        }
        b(paramString);
      }
    }
  }
  
  private void R(int paramInt1, String paramString, int paramInt2)
  {
    QLog.i("ListenTogether.Manager", 1, "refreshListenTogetherStatus, type: " + paramInt1 + " uin: " + paramString + " by:" + et(paramInt2));
    String str = aiob.H(paramInt1, paramString);
    if ((!str.equals(this.bPg)) && (!str.equals(this.bPi)))
    {
      QLog.i("ListenTogether.Manager", 1, "refreshListenTogetherStatus, currentSessionKey: " + this.bPg + " currentAio: " + this.bPi + " not equal return.");
      return;
    }
    ((aoig)this.app.getBusinessHandler(165)).e(1, paramInt1, paramString, paramInt2);
  }
  
  private void R(int paramInt, String paramString1, String paramString2)
  {
    ((aink)this.app.getBusinessHandler(156)).notifyUI(18, true, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
  }
  
  private void R(boolean paramBoolean, List<MusicInfo> paramList)
  {
    QLog.i("ListenTogether.Manager", 1, "onGetMusicUrlFromServer success: " + paramBoolean + " musicList: " + paramList);
    if (!paramBoolean) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
      } while ((paramList == null) || (paramList.isEmpty()));
      localArrayList = new ArrayList();
      int j = paramList.size();
      int i = 0;
      if (i < j)
      {
        MusicInfo localMusicInfo = (MusicInfo)paramList.get(i);
        if (localMusicInfo == null) {}
        for (;;)
        {
          i += 1;
          break;
          if (localMusicInfo.api())
          {
            this.t.put(localMusicInfo.id, localMusicInfo);
            localArrayList.add(localMusicInfo);
          }
        }
      }
    } while (localArrayList.isEmpty());
    this.jdField_a_of_type_Aipy.lh(localArrayList);
  }
  
  private void S(boolean paramBoolean, List<MusicInfo> paramList)
  {
    QLog.i("ListenTogether.Manager", 1, "onGetLyricFromServer success: " + paramBoolean + " musicList: " + paramList);
    if (!paramBoolean) {
      Li(true);
    }
    MusicInfo localMusicInfo;
    do
    {
      return;
      if ((paramList == null) || (paramList.isEmpty()))
      {
        Li(true);
        return;
      }
      localMusicInfo = (MusicInfo)paramList.get(0);
    } while (localMusicInfo == null);
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(localMusicInfo.lyric))
    {
      this.u.put(((MusicInfo)paramList.get(0)).id, localMusicInfo.lyric);
      localHashMap.put("has_lyric", "1");
    }
    for (;;)
    {
      Li(false);
      anpc.a(BaseApplication.getContext()).collectPerformance("", "listen_together_lyric", true, 0L, 0L, localHashMap, "");
      return;
      localHashMap.put("has_lyric", "0");
    }
  }
  
  public static ListenTogetherManager a(QQAppInterface paramQQAppInterface)
  {
    return (ListenTogetherManager)paramQQAppInterface.getManager(331);
  }
  
  private void a(ListenTogetherSession paramListenTogetherSession)
  {
    if ((paramListenTogetherSession == null) || (paramListenTogetherSession.CA == null) || (paramListenTogetherSession.CA.isEmpty())) {}
    ArrayList localArrayList;
    label185:
    do
    {
      do
      {
        return;
      } while ((paramListenTogetherSession.status != 1) || (paramListenTogetherSession.deR != 2));
      int j = paramListenTogetherSession.CA.size();
      localArrayList = new ArrayList(j);
      int i = 0;
      if (i < j)
      {
        MusicInfo localMusicInfo = (MusicInfo)paramListenTogetherSession.CA.get(i);
        if (localMusicInfo == null) {}
        for (;;)
        {
          i += 1;
          break;
          if (localMusicInfo.api()) {
            this.t.put(localMusicInfo.id, localMusicInfo);
          }
          if ((!a((MusicInfo)this.t.get(localMusicInfo.id))) || (!localMusicInfo.api())) {}
          for (boolean bool = true;; bool = false)
          {
            if (!bool) {
              break label185;
            }
            localArrayList.add(new aioc(localMusicInfo.id, bool, false));
            break;
          }
        }
      }
    } while (localArrayList.isEmpty());
    ((aink)this.app.getBusinessHandler(156)).a(paramListenTogetherSession.type, paramListenTogetherSession.uin, localArrayList, false);
  }
  
  private void a(ListenTogetherSession paramListenTogetherSession, int paramInt)
  {
    QLog.i("ListenTogether.Manager", 1, "notifyMusicModuleToRefresh session: " + paramListenTogetherSession + " manager destroy: " + this.isDestroy + " playFocused: " + this.ckI);
    if (paramListenTogetherSession == null) {}
    do
    {
      for (;;)
      {
        return;
        this.subHandler.removeMessages(1001);
        if (paramListenTogetherSession.deR != 2) {
          break label427;
        }
        if (paramListenTogetherSession.status != 1) {
          break;
        }
        MusicInfo localMusicInfo = paramListenTogetherSession.b();
        if (localMusicInfo == null)
        {
          QLog.i("ListenTogether.Manager", 1, "notifyMusicModuleToRefresh startPlay musicInfo is null. return.");
          return;
        }
        if ((!this.isDestroy) && (this.ckI) && (!this.app.bF()) && (!this.app.abz()) && (apg()))
        {
          long l = localMusicInfo.abP;
          QLog.i("ListenTogether.Seek", 1, "sendRefreshPlayMsg seek: " + l + " currentTime: " + System.currentTimeMillis());
          if (l < 0L) {
            this.subHandler.sendEmptyMessageDelayed(1001, -l);
          }
          while ((paramInt == 1009) || (paramInt == 1001) || (paramInt == 1015) || (paramInt == 1014) || (paramInt == 1010))
          {
            h(paramListenTogetherSession.type, paramListenTogetherSession.uin, localMusicInfo.id, localMusicInfo.name);
            return;
            this.subHandler.sendEmptyMessage(1001);
          }
        }
      }
      if (paramListenTogetherSession.status == 2)
      {
        bool = this.jdField_a_of_type_Aips.apr();
        QLog.i("ListenTogether.Manager", 1, "notifyMusicModuleToRefresh pausePlay result: " + bool);
        return;
      }
      if (paramListenTogetherSession.status == 3)
      {
        bool = this.jdField_a_of_type_Aips.stopPlay();
        QLog.i("ListenTogether.Manager", 1, "notifyMusicModuleToRefresh stopPlay result: " + bool);
        return;
      }
    } while (paramListenTogetherSession.status != 4);
    boolean bool = this.jdField_a_of_type_Aips.stopPlay();
    QLog.i("ListenTogether.Manager", 1, "notifyMusicModuleToRefresh stopPlay result: " + bool);
    return;
    label427:
    bool = this.jdField_a_of_type_Aips.stopPlay();
    QLog.i("ListenTogether.Manager", 1, "notifyMusicModuleToRefresh stopPlay result: " + bool);
  }
  
  private void a(ListenTogetherSession paramListenTogetherSession, boolean paramBoolean)
  {
    QLog.i("ListenTogether.Manager", 1, "notifyUIModuleJoinListenTogetherFail session: " + paramListenTogetherSession + " listenTogetherClosed:" + paramBoolean);
    ((aink)this.app.getBusinessHandler(156)).notifyUI(5, true, new Object[] { Integer.valueOf(paramListenTogetherSession.type), paramListenTogetherSession.uin, Boolean.valueOf(paramBoolean) });
  }
  
  private void a(ISong paramISong)
  {
    ((aink)this.app.getBusinessHandler(156)).notifyUI(13, true, new Object[] { paramISong });
  }
  
  private boolean a(MusicInfo paramMusicInfo)
  {
    if (paramMusicInfo == null) {}
    while (SystemClock.elapsedRealtime() - paramMusicInfo.timeStamp >= 180000L) {
      return false;
    }
    return true;
  }
  
  private boolean apg()
  {
    long l;
    if (!this.jdField_a_of_type_Aips.isConnected()) {
      l = SystemClock.uptimeMillis();
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager$a.lock)
    {
      boolean bool = this.jdField_a_of_type_Aips.isConnected();
      if (!bool) {}
      try
      {
        this.jdField_a_of_type_Aips.init();
        this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager$a.lock.wait(1500L);
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogether.Manager", 2, String.format("doConnIfNeed %b cos=%d", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Aips.isConnected()), Long.valueOf(SystemClock.uptimeMillis() - l) }));
        }
        return this.jdField_a_of_type_Aips.isConnected();
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ListenTogether.Manager", 2, "doConnIfNeed InterruptedException==>", localInterruptedException);
          }
        }
      }
    }
  }
  
  private void aq(String paramString, int paramInt1, int paramInt2)
  {
    ((aink)this.app.getBusinessHandler(156)).notifyUI(9, true, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  private void b(ListenTogetherSession paramListenTogetherSession)
  {
    QLog.i("ListenTogether.Manager", 1, "notifyUIModuleToInitOrUpdate session: " + paramListenTogetherSession);
    if (paramListenTogetherSession == null) {
      return;
    }
    ((aink)this.app.getBusinessHandler(156)).notifyUI(4, true, new Object[] { paramListenTogetherSession });
  }
  
  private void c(BaseActivity paramBaseActivity, String paramString)
  {
    QQToast.a(paramBaseActivity, 1, paramString, 0).show(paramBaseActivity.getTitleBarHeight());
  }
  
  public static void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if ((paramQQAppInterface != null) && (paramSessionInfo != null) && (paramSessionInfo.cZ == 1)) {
      paramQQAppInterface.L(1, paramSessionInfo.aTl, paramInt);
    }
    while ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramSessionInfo.cZ != 0)) {
      return;
    }
    paramQQAppInterface.L(2, paramSessionInfo.aTl, paramInt);
  }
  
  private void c(ListenTogetherSession paramListenTogetherSession)
  {
    ((aink)this.app.getBusinessHandler(156)).notifyUI(19, true, new Object[] { Integer.valueOf(paramListenTogetherSession.type), paramListenTogetherSession.uin });
  }
  
  private void cP(int paramInt, String paramString)
  {
    QLog.i("ListenTogether.Manager", 1, "notifyUIModulePauseListenTogetherFail type: " + paramInt + " uin:" + paramString);
    ((aink)this.app.getBusinessHandler(156)).notifyUI(6, true, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  private void cQ(int paramInt, String paramString)
  {
    QLog.i("ListenTogether.Manager", 1, "notifyUIModuleResumeListenTogetherFail type: " + paramInt + " uin:" + paramString);
    ((aink)this.app.getBusinessHandler(156)).notifyUI(7, true, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  private void cR(int paramInt, String paramString)
  {
    QLog.i("ListenTogether.Manager", 1, "notifyUIModuleCutListenTogetherFail type: " + paramInt + " uin:" + paramString);
    ((aink)this.app.getBusinessHandler(156)).notifyUI(20, true, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  private void cS(int paramInt, String paramString)
  {
    QLog.i("ListenTogether.Manager", 1, "notifyUIModuleChangePlayModeListenTogetherFail type: " + paramInt + " uin:" + paramString);
    ((aink)this.app.getBusinessHandler(156)).notifyUI(21, true, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  private void cT(int paramInt, String paramString)
  {
    ((aink)this.app.getBusinessHandler(156)).notifyUI(22, true, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  private void cr(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((aink)this.app.getBusinessHandler(156)).notifyUI(15, true, new Object[] { Boolean.valueOf(paramBoolean), this.ly.get(paramString) });
  }
  
  private void d(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.i("ListenTogether.Manager", 1, "notifyLyricModuleSwitchChange, type: " + paramInt + " uin: " + paramString + " open:" + paramBoolean1 + " userAction: " + paramBoolean2);
    ((aink)this.app.getBusinessHandler(156)).notifyUI(11, true, new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
  }
  
  private void dtd()
  {
    this.subHandler.postDelayed(this.gJ, 8000L);
  }
  
  private void dte()
  {
    if (TextUtils.isEmpty(this.bPg)) {}
    ListenTogetherSession localListenTogetherSession;
    do
    {
      return;
      localListenTogetherSession = (ListenTogetherSession)this.ly.get(this.bPg);
    } while (localListenTogetherSession == null);
    R(localListenTogetherSession.type, localListenTogetherSession.uin, 1008);
  }
  
  private void dtf()
  {
    ((aink)this.app.getBusinessHandler(156)).notifyUI(16, true, null);
  }
  
  private void eR(String paramString, int paramInt)
  {
    ((aink)this.app.getBusinessHandler(156)).notifyUI(12, true, new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  private String es(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1001: 
      return "JOIN_SESSION_BY_WEB";
    case 1000: 
      return "JOIN_SESSION_BY_MUSIC_PANEL";
    }
    return "JOIN_SESSION_BY_JOIN_AND_ENTER";
  }
  
  private String et(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1000: 
      return "enter_aio";
    case 1001: 
      return "join";
    case 1021: 
      return "join_enter";
    case 1002: 
      return "js_api";
    case 1003: 
      return "push";
    case 1004: 
      return "audio_release";
    case 1005: 
      return "pause";
    case 1006: 
      return "resume";
    case 1007: 
      return "finish";
    case 1008: 
      return "net_connected";
    case 1009: 
      return "js_api_open";
    case 1010: 
      return "js_api_cute";
    case 1011: 
      return "js_api_close";
    case 1012: 
      return "push_close";
    case 1013: 
      return "js_api_end_try_song";
    case 1014: 
      return "push_cute";
    case 1015: 
      return "push_auto_cute";
    case 1016: 
      return "exit";
    case 1017: 
      return "relation_finish";
    case 1018: 
      return "musicbox_resume";
    case 1019: 
      return "cut_song";
    }
    return "change_playmode";
  }
  
  private String eu(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 13: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    default: 
      return "";
    case 1: 
      return "start";
    case 2: 
      return "stop";
    case 3: 
      return "auto_start";
    case 4: 
      return "auto_stop";
    case 11: 
      return "play";
    case 12: 
      return "cut";
    case 14: 
      return "auto_cut";
    case 15: 
      return "pause";
    case 21: 
      return "add";
    case 22: 
      return "delete";
    case 23: 
      return "sort";
    case 24: 
      return "clear";
    case 31: 
      return "join";
    case 32: 
      return "quit";
    }
    return "change_playmode";
  }
  
  private void gA(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    ((aink)this.app.getBusinessHandler(156)).notifyUI(10, true, new Object[] { paramString1, paramString2, Boolean.valueOf(false) });
    paramString1 = new StringBuilder().append("notifyMusicModuleLyric use cache lyric: ");
    if (paramString2 == null) {}
    for (int i = 0;; i = paramString2.length())
    {
      QLog.i("ListenTogether.Manager", 1, i + " serverError");
      return;
    }
  }
  
  private void h(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (paramInt == 2)
    {
      anot.a(null, "dc00899", "c2c_AIO", "", "music_tab", "song_play", 0, 0, "", "", paramString3, paramString2);
      return;
    }
    TroopInfo localTroopInfo = ((TroopManager)this.app.getManager(52)).b(paramString1);
    int i = 2;
    paramInt = i;
    if (localTroopInfo != null)
    {
      paramInt = i;
      if ((localTroopInfo.dwAdditionalFlag & 1L) == 1L) {
        paramInt = 0;
      }
      if ((localTroopInfo.dwCmdUinUinFlag & 1L) == 1L) {
        paramInt = 1;
      }
    }
    for (;;)
    {
      anot.a(null, "dc00899", "Grp_AIO", "", "music_tab", "song_play", 0, 0, paramString1, String.valueOf(paramInt), paramString3, paramString2);
      return;
    }
  }
  
  public boolean D(int paramInt, String paramString)
  {
    boolean bool2 = false;
    Object localObject;
    boolean bool1;
    if (paramInt == 1)
    {
      localObject = ((TroopManager)this.app.getManager(52)).a(paramString);
      if (localObject != null) {
        bool1 = ((TroopInfo)localObject).isListenTogetherOpen();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.switch", 2, "isListenTogetherOpen, type:" + paramInt + " uin:" + paramString + " res:" + bool1);
      }
      return bool1;
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.switch", 2, "isListenTogetherOpen troopinfo is null");
      }
      bool1 = false;
      continue;
      bool1 = bool2;
      if (paramInt == 2)
      {
        localObject = ((acff)this.app.getManager(51)).a(paramString, false);
        if (localObject != null)
        {
          bool1 = ((ExtensionInfo)localObject).isListenTogetherOpen;
        }
        else
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("ListenTogether.switch", 2, "isListenTogetherOpen extensionInfo is null");
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  public boolean E(int paramInt, String paramString)
  {
    return this.bPg.equals(aiob.H(paramInt, paramString));
  }
  
  public boolean F(int paramInt, String paramString)
  {
    return this.jdField_a_of_type_Aipd.F(paramInt, paramString);
  }
  
  public int FH()
  {
    return this.jdField_a_of_type_Aips.FH();
  }
  
  public void J(int paramInt1, String paramString, int paramInt2)
  {
    this.ckH = true;
    this.bPi = aiob.H(paramInt1, paramString);
    boolean bool = D(paramInt1, paramString);
    QLog.i("ListenTogether.Manager", 1, "onEnterAio type: " + paramInt1 + " ,uin: " + paramString + " open: " + bool + " mLastEnterAIOId:" + this.def + " aioId:" + paramInt2);
    this.def = paramInt2;
    if (this.jdField_a_of_type_Aipd != null) {
      this.jdField_a_of_type_Aipd.dg(paramInt1, paramString);
    }
    if (!bool) {}
    while ((paramInt1 == 2) && (!((acff)this.app.getManager(51)).isFriend(paramString))) {
      return;
    }
    String str = aiob.H(paramInt1, paramString);
    b((ListenTogetherSession)this.ly.get(str));
    R(paramInt1, paramString, 1000);
  }
  
  public void K(int paramInt1, String paramString, int paramInt2)
  {
    QLog.i("ListenTogether.Manager", 1, "onExitAio. mLastEnterAIOId:" + this.def + " aioId:" + paramInt2);
    if (this.def != paramInt2) {}
    do
    {
      return;
      this.ckH = false;
    } while (this.jdField_a_of_type_Aipd == null);
    this.jdField_a_of_type_Aipd.t(paramInt1, paramString, false);
  }
  
  public void L(int paramInt1, String paramString, int paramInt2)
  {
    QLog.i("ListenTogether.Manager", 1, "onBackFromAIO. mLastEnterAIOId:" + this.def + " aioId:" + paramInt2);
    if (this.def != paramInt2) {}
    while ((this.jdField_a_of_type_Aipd == null) || (!this.jdField_a_of_type_Aipd.app())) {
      return;
    }
    this.ckH = false;
    this.jdField_a_of_type_Aipd.t(paramInt1, paramString, true);
  }
  
  public void LO(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AioShareMusicListenTogether.Manager", 2, "notifyPlayChangeToAioShareMusic() newSong = " + paramString);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("current_song_id", paramString);
      ify.c(localJSONObject, "updateSongIdToAioShareMusic");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void Lh(boolean paramBoolean)
  {
    if (this.aK == null) {}
    for (aiod localaiod = null;; localaiod = (aiod)this.aK.get())
    {
      if (localaiod != null) {
        localaiod.Lk(paramBoolean);
      }
      this.aK = null;
      return;
    }
  }
  
  public void M(int paramInt1, String paramString, int paramInt2)
  {
    QLog.i("ListenTogether.Manager", 1, "onDestroyAIO. type: " + paramInt1 + " uin:" + paramString + " mLastEnterAIOId:" + this.def + " aioId:" + paramInt2);
    if (this.def != paramInt2) {}
    do
    {
      return;
      if (aiob.H(paramInt1, paramString).equals(this.bPi)) {
        this.bPi = "";
      }
    } while (this.jdField_a_of_type_Aipd == null);
    this.jdField_a_of_type_Aipd.dh(paramInt1, paramString);
  }
  
  public void N(int paramInt1, String paramString, int paramInt2)
  {
    QLog.i("ListenTogether.Manager", 1, "onCutSong type: " + paramInt1 + " ,uin: " + paramString + ",cutType: " + paramInt2);
    this.subHandler.removeMessages(1001);
    paramString = (ListenTogetherSession)this.ly.get(aiob.H(paramInt1, paramString));
    if (paramString != null) {
      ((aink)this.app.getBusinessHandler(156)).H(paramString.type, paramString.uin, paramInt2);
    }
  }
  
  public void O(int paramInt1, String paramString, int paramInt2)
  {
    QLog.i("ListenTogether.Manager", 1, "onChangePlayMode type: " + paramInt1 + " ,uin: " + paramString + " ,dstPlayMode: " + paramInt2);
    paramString = (ListenTogetherSession)this.ly.get(aiob.H(paramInt1, paramString));
    if (paramString != null) {
      ((aink)this.app.getBusinessHandler(156)).G(paramString.type, paramString.uin, paramInt2);
    }
  }
  
  public void P(String paramString1, String paramString2, int paramInt)
  {
    paramString2 = paramInt + "_" + paramString2;
    this.w.put(paramString1, paramString2);
  }
  
  public void PY(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogether.Manager", 1, "notifyWebCheckJoinResult retCode:" + paramInt);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", "joinListen");
      localJSONObject.put("retCode", paramInt);
      if (localJSONObject != null) {
        aiov.bq(localJSONObject);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("ListenTogether.Manager", 1, "notifyWebJoinListenResult error : " + localJSONException.getMessage());
        Object localObject = null;
      }
    }
  }
  
  public long a(int paramInt, String paramString)
  {
    paramString = paramInt + "_" + paramString;
    paramString = (Long)this.v.get(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.longValue();
  }
  
  public aipd a()
  {
    return this.jdField_a_of_type_Aipd;
  }
  
  public alep a()
  {
    return this.jdField_a_of_type_Alep;
  }
  
  public ListenTogetherSession a()
  {
    return (ListenTogetherSession)this.ly.get(this.bPh);
  }
  
  public ListenTogetherSession a(int paramInt, String paramString)
  {
    return (ListenTogetherSession)this.ly.get(aiob.H(paramInt, paramString));
  }
  
  public MusicInfo a()
  {
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.ly.get(this.bPh);
    if (localListenTogetherSession == null) {
      return null;
    }
    if ((localListenTogetherSession.CA == null) || (localListenTogetherSession.CA.isEmpty())) {
      return null;
    }
    return (MusicInfo)localListenTogetherSession.CA.get(0);
  }
  
  public void a(int paramInt, String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    QLog.i("ListenTogether.Manager", 1, "onGetListenTogetherJoinedCountChangePush type: " + paramInt + " uin: " + paramString1 + " sep: " + paramLong1 + " timeStamp: " + paramLong2 + " msg: " + paramString2);
    R(paramInt, paramString1, paramString2);
    paramString1 = (ListenTogetherSession)this.ly.get(aiob.H(paramInt, paramString1));
    if (paramString1 == null) {
      return;
    }
    paramString1.bPm = paramString2;
  }
  
  public void a(int paramInt1, String paramString1, long paramLong1, String paramString2, int paramInt2, long paramLong2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogether.Manager", 2, String.format("onGetListenTogetherPush type=%d seq=%d actionUin=%s pushType=%s data=%s ts=%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), paramString2, eu(paramInt2), paramObject, Long.valueOf(paramLong2) }));
    }
    if ((this.app.getCurrentAccountUin().equals(paramString2)) && (paramInt2 != 3) && (paramInt2 != 4) && (paramInt2 != 14)) {
      if (paramInt2 == 1) {
        if (paramInt1 == 2)
        {
          aing.k(this.app, paramString1, true);
          QLog.i("ListenTogether.Manager", 1, "onGetListenTogetherPush action uin == current uin return.");
        }
      }
    }
    for (;;)
    {
      return;
      if (paramInt1 != 1) {
        break;
      }
      aing.j(this.app, paramString1, true);
      break;
      if (paramInt2 != 2) {
        break;
      }
      if (paramInt1 == 2) {
        aing.k(this.app, paramString1, false);
      }
      for (;;)
      {
        P(paramInt1, paramString1, 3);
        break;
        if (paramInt1 == 1) {
          aing.j(this.app, paramString1, false);
        }
      }
      g(paramInt1, paramString1, paramLong2);
      int j = 1;
      int i;
      if (paramInt2 == 14)
      {
        this.subHandler.removeCallbacks(this.gJ);
        i = 1;
      }
      label435:
      label599:
      while (i != 0)
      {
        i = 1003;
        if (paramInt2 == 2) {
          i = 1012;
        }
        for (;;)
        {
          R(paramInt1, paramString1, i);
          return;
          if ((paramInt2 == 1) || (paramInt2 == 3))
          {
            if (paramInt1 == 2) {
              aing.k(this.app, paramString1, true);
            }
            for (;;)
            {
              k(paramInt1, paramString1, "openListen", 0);
              i = 1;
              break;
              if (paramInt1 == 1) {
                aing.j(this.app, paramString1, true);
              }
            }
          }
          if ((paramInt2 == 2) || (paramInt2 == 4))
          {
            if (paramInt1 == 2) {
              aing.k(this.app, paramString1, false);
            }
            for (;;)
            {
              P(paramInt1, paramString1, 3);
              k(paramInt1, paramString1, "closeListen", 0);
              i = 1;
              break;
              if (paramInt1 == 1) {
                aing.j(this.app, paramString1, false);
              }
            }
          }
          i = j;
          if (paramInt2 != 16) {
            break label599;
          }
          if ((paramObject instanceof Integer)) {}
          for (i = ((Integer)paramObject).intValue();; i = 0)
          {
            Q(paramInt1, paramString1, i);
            if (paramInt1 != 2) {
              break label435;
            }
            i = 1;
            break;
          }
          i = j;
          if (paramInt1 != 1) {
            break label599;
          }
          j = 0;
          paramString2 = aiob.H(paramInt1, paramString1);
          paramString2 = (ListenTogetherSession)this.ly.get(paramString2);
          i = j;
          if (paramString2 == null) {
            break label599;
          }
          if (!TextUtils.equals(paramString2.ckN, this.app.getCurrentUin()))
          {
            paramString2 = ((TroopManager)this.app.getManager(52)).c(this.app.getCurrentUin());
            i = j;
            if (paramString2 == null) {
              break label599;
            }
            i = j;
            if (!paramString2.isAdmin()) {
              break label599;
            }
            i = 1;
            break;
          }
          i = 1;
          break;
          if (paramInt2 == 12) {
            i = 1014;
          } else if (paramInt2 == 14) {
            i = 1015;
          } else if (paramInt2 == 16) {
            i = 1020;
          }
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString, aiod paramaiod)
  {
    this.aK = new WeakReference(paramaiod);
    paramaiod = aiob.H(paramInt, paramString);
    QLog.i("ListenTogether.Manager", 1, "checkAndExitListenTogether type: " + paramInt + " ,uin: " + paramString + " key:" + paramaiod + "  currentSessionKey:" + this.bPg);
    paramaiod = (ListenTogetherSession)this.ly.get(paramaiod);
    if (paramaiod == null)
    {
      dtc();
      return;
    }
    boolean bool = TextUtils.equals(paramaiod.ckN, this.app.getCurrentUin());
    if (paramaiod.type == 2) {
      paramInt = 1;
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        paramString = new Intent();
        paramString.putExtra("type", 3);
        paramString.putExtra("uinType", paramaiod.type);
        paramString.putExtra("public_fragment_window_feature", 1);
        paramString.setFlags(268435456);
        PublicFragmentActivity.b.start(BaseApplicationImpl.getContext(), paramString, PublicTransFragmentActivity.class, ListenTogetherOverlayFragment.class);
        return;
        if (paramaiod.type == 1)
        {
          if (bool)
          {
            paramInt = 1;
            continue;
          }
          paramString = ((TroopManager)this.app.getManager(52)).c(paramString);
          if ((paramString != null) && (paramString.isAdmin())) {
            paramInt = 1;
          }
        }
      }
      else
      {
        Lh(false);
        return;
      }
      paramInt = 0;
    }
  }
  
  public void a(BaseActivity paramBaseActivity, int paramInt, String paramString, long paramLong)
  {
    String str = aiob.H(paramInt, paramString);
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.ly.get(str);
    if (localListenTogetherSession != null)
    {
      str = localListenTogetherSession.toString();
      QLog.d("ListenTogether.Manager", 1, new Object[] { "joinTogetherAndEnter", " type=", Integer.valueOf(paramInt), " uin=", paramString, " id=", Long.valueOf(paramLong), " session=", str });
      if ((localListenTogetherSession == null) || (localListenTogetherSession.status == 3) || (paramLong != localListenTogetherSession.apd) || (paramLong == 0L)) {
        break label233;
      }
      if (localListenTogetherSession.deR == 2) {
        break label224;
      }
      this.jdField_a_of_type_Aioe = new ainl(this, paramBaseActivity, paramInt, paramString);
      a(this.app).a(paramBaseActivity, paramInt, paramString, this.jdField_a_of_type_Aioe);
      label177:
      if (paramInt != 2) {
        break label247;
      }
    }
    label224:
    label233:
    label247:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label252;
      }
      anot.a(null, "dc00899", "c2c_AIO", "", "music_tab", "clk_musicark", 0, 0, paramString, "", "", "");
      return;
      str = "null";
      break;
      cT(paramInt, paramString);
      break label177;
      c(paramBaseActivity, acfp.m(2131695338));
      break label177;
    }
    label252:
    anot.a(null, "dc00899", "Grp_AIO", "", "music_tab", "clk_musicark", 0, 0, paramString, "", "" + aiob.M(this.app.getCurrentAccountUin(), paramString), "");
  }
  
  public void a(BaseActivity paramBaseActivity, int paramInt, String paramString, aioe paramaioe)
  {
    this.aJ = new WeakReference(paramaioe);
    QLog.i("ListenTogether.Manager", 1, "checkAndJoinListenTogether type: " + paramInt + " ,uin: " + paramString);
    if ((this.app.bF()) || (this.app.abz()))
    {
      c(paramBaseActivity, acfp.m(2131707805));
      b((ListenTogetherSession)this.ly.get(aiob.H(paramInt, paramString)));
      dtb();
      return;
    }
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.ly.get(aiob.H(paramInt, paramString));
    if ((localListenTogetherSession == null) || (TextUtils.isEmpty(localListenTogetherSession.bPn)) || ("0".equals(localListenTogetherSession.bPn)))
    {
      dta();
      a(paramBaseActivity, paramInt, paramString);
      return;
    }
    String str = acfp.m(2131707815);
    paramaioe = acfp.m(2131707813);
    if (localListenTogetherSession.deh == 1)
    {
      if (!localListenTogetherSession.ckL) {
        break label393;
      }
      paramaioe = acfp.m(2131707814);
    }
    label393:
    for (;;)
    {
      paramBaseActivity = aqha.a(paramBaseActivity, 230);
      paramString = new ainm(this, paramInt, paramString);
      paramBaseActivity.setTitle(str);
      paramBaseActivity.setMessage(paramaioe);
      paramBaseActivity.setOnDismissListener(new ainn(this));
      paramBaseActivity.setNegativeButton(acfp.m(2131707810), paramString);
      paramBaseActivity.setPositiveButton(acfp.m(2131707808), paramString);
      paramBaseActivity.setCanceledOnTouchOutside(false);
      paramBaseActivity.show();
      if ((paramInt == 1) && (!this.ckJ))
      {
        this.ckJ = true;
        aiob.a(this.app, "is_not_first_join_listen_together_" + paramInt, true, false);
        return;
        paramaioe = acfp.m(2131707806);
      }
      else
      {
        if ((paramInt != 2) || (this.ckK)) {
          break;
        }
        this.ckK = true;
        aiob.a(this.app, "is_not_first_join_listen_together_" + paramInt, true, false);
        return;
      }
    }
  }
  
  public void a(MusicInfo paramMusicInfo)
  {
    if (paramMusicInfo == null) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = lD(paramMusicInfo.id);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split("_");
          int i = Integer.parseInt(localObject[0]);
          localObject = localObject[1];
          ((aink)this.app.getBusinessHandler(156)).a(i, (String)localObject, paramMusicInfo.id, paramMusicInfo.name, (String)paramMusicInfo.CC.get(0), paramMusicInfo.CB);
          return;
        }
      }
      catch (Exception paramMusicInfo)
      {
        paramMusicInfo.printStackTrace();
      }
    }
  }
  
  public void a(boolean paramBoolean, ListenTogetherSession paramListenTogetherSession, int paramInt)
  {
    QLog.i("ListenTogether.Manager", 1, "onGetListenTogetherSessionFromServer, success: " + paramBoolean + " ,session: " + paramListenTogetherSession + " ,by: " + et(paramInt));
    if (paramListenTogetherSession == null) {
      return;
    }
    if (paramBoolean) {}
    label535:
    label579:
    for (;;)
    {
      Object localObject;
      int i;
      synchronized (this.ly)
      {
        String str = paramListenTogetherSession.getKey();
        localObject = (ListenTogetherSession)this.ly.get(str);
        if (localObject == null)
        {
          this.ly.put(str, paramListenTogetherSession);
          localObject = paramListenTogetherSession;
          if ((((ListenTogetherSession)localObject).status != 3) && (((ListenTogetherSession)localObject).deR != 3)) {
            break label579;
          }
          ((ListenTogetherSession)localObject).cbN = false;
          break label579;
          ((ListenTogetherSession)localObject).cbN = false;
          if (((ListenTogetherSession)localObject).deR != 2) {
            break label508;
          }
          this.bPg = ((ListenTogetherSession)localObject).getKey();
          this.bPh = this.bPg;
          i = 0;
          localObject = (ListenTogetherSession)this.ly.get(paramListenTogetherSession.getKey());
          b((ListenTogetherSession)localObject);
          R(((ListenTogetherSession)localObject).type, ((ListenTogetherSession)localObject).uin, ((ListenTogetherSession)localObject).bPm);
          if ((this.bPg.equals(paramListenTogetherSession.getKey())) || (i != 0))
          {
            if ((paramInt == 1000) || (paramInt == 1001) || (paramInt == 1009) || (paramInt == 1013) || (paramInt == 1018)) {
              this.ckI = true;
            }
            a((ListenTogetherSession)localObject, paramInt);
            a((ListenTogetherSession)localObject);
          }
          if (this.bPg.equals(paramListenTogetherSession.getKey()))
          {
            if ((paramInt == 1001) || (paramInt == 1009)) {
              this.jdField_a_of_type_Aipd.dtv();
            }
            if ((paramInt == 1014) || (paramInt == 1015) || (paramInt == 1012) || (paramInt == 1003)) {
              k(paramListenTogetherSession.type, paramListenTogetherSession.uin, "switchSong", 0);
            }
            if (paramInt == 1020) {
              k(paramListenTogetherSession.type, paramListenTogetherSession.uin, "playModeChange", paramListenTogetherSession.playMode);
            }
            if (paramInt == 1021) {
              cT(paramListenTogetherSession.type, paramListenTogetherSession.uin);
            }
          }
          if (i == 0) {
            break;
          }
          i = paramListenTogetherSession.type;
          localObject = paramListenTogetherSession.uin;
          ThreadManager.getUIHandler().post(new ListenTogetherManager.13(this, i, (String)localObject));
          if (paramInt != 1012) {
            break label535;
          }
          k(paramListenTogetherSession.type, paramListenTogetherSession.uin, "closeListen", 0);
          return;
        }
        if (paramListenTogetherSession.timeStamp < ((ListenTogetherSession)localObject).timeStamp) {
          return;
        }
      }
      ((ListenTogetherSession)localObject).e(paramListenTogetherSession);
      continue;
      label508:
      if (this.bPg.equals(((ListenTogetherSession)localObject).getKey()))
      {
        this.bPg = "";
        i = 1;
        continue;
        k(paramListenTogetherSession.type, paramListenTogetherSession.uin, "comeoutSong", 0);
        return;
        b((ListenTogetherSession)this.ly.get(paramListenTogetherSession.getKey()));
      }
      else
      {
        i = 0;
        continue;
        if (paramInt != 1001) {
          if (paramInt != 1009) {}
        }
      }
    }
  }
  
  public boolean a(Context paramContext, int paramInt, String paramString)
  {
    boolean bool;
    if (paramInt == 1)
    {
      if (!this.ckJ) {
        this.ckJ = aiob.a(this.app, "is_not_first_join_listen_together_" + paramInt, false, false);
      }
      bool = this.ckJ;
      if (bool) {
        break label218;
      }
      this.jdField_a_of_type_Aipd.cli = true;
      paramContext = new Intent();
      paramContext.putExtra("type", 4);
      paramContext.putExtra("uinType", paramInt);
      paramContext.putExtra("public_fragment_window_feature", 1);
      paramContext.setFlags(268435456);
      PublicFragmentActivity.b.start(BaseApplicationImpl.getContext(), paramContext, PublicTransFragmentActivity.class, ListenTogetherOverlayFragment.class);
      if (paramInt != 1) {
        break label210;
      }
      this.ckJ = true;
    }
    for (;;)
    {
      aiob.a(this.app, "is_not_first_join_listen_together_" + paramInt, true, false);
      return true;
      if (!this.ckK) {
        this.ckK = aiob.a(this.app, "is_not_first_join_listen_together_" + paramInt, false, false);
      }
      bool = this.ckK;
      break;
      label210:
      this.ckK = true;
    }
    label218:
    return false;
  }
  
  public boolean a(BaseActivity paramBaseActivity, int paramInt1, String paramString, int paramInt2)
  {
    QLog.d("ListenTogether.Manager", 1, "joinListenTogether type: " + paramInt1 + " ,uin: " + paramString + " ,by:" + es(paramInt2));
    if ((this.app.bF()) || (this.app.abz()))
    {
      c(paramBaseActivity, acfp.m(2131707807));
      b((ListenTogetherSession)this.ly.get(aiob.H(paramInt1, paramString)));
      return false;
    }
    if (aohy.a(this.app).a(paramBaseActivity, 1, paramString, paramInt1)) {
      return false;
    }
    ((aink)this.app.getBusinessHandler(156)).I(paramInt1, paramString, paramInt2);
    return true;
  }
  
  public boolean apf()
  {
    return !TextUtils.isEmpty(this.bPg);
  }
  
  public void b(boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
  {
    QLog.i("ListenTogether.Manager", 1, "onChangePlayModeRespFromServer, success: " + paramBoolean + " ,type: " + paramInt1 + " ,uin: " + paramString + ", playMode: " + paramInt2);
    if (!paramBoolean)
    {
      cS(paramInt1, paramString);
      return;
    }
    Q(paramInt1, paramString, paramInt2);
  }
  
  public void b(boolean paramBoolean, ListenTogetherSession paramListenTogetherSession, int paramInt)
  {
    QLog.i("ListenTogether.Manager", 1, "onGetJoinListenTogetherResponse isSuccess: " + paramBoolean + " by: " + es(paramInt));
    if (paramListenTogetherSession == null) {}
    int i;
    do
    {
      return;
      ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.ly.get(paramListenTogetherSession.getKey());
      if (!paramBoolean)
      {
        b(localListenTogetherSession);
        if (paramInt != 1001)
        {
          a(localListenTogetherSession, false);
          return;
        }
        PY(1);
        return;
      }
      i = -1;
      switch (paramInt)
      {
      default: 
        R(paramListenTogetherSession.type, paramListenTogetherSession.uin, i);
        PY(0);
      }
    } while (paramInt != 1002);
    if (paramListenTogetherSession.type == 2) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label224;
      }
      anot.a(null, "dc00899", "c2c_AIO", "", "music_tab", "clk_musicark_suc", 0, 0, paramListenTogetherSession.uin, "", "", "");
      return;
      i = 1001;
      break;
      i = 1009;
      break;
      i = 1021;
      break;
    }
    label224:
    anot.a(null, "dc00899", "Grp_AIO", "", "music_tab", "clk_musicark_suc", 0, 0, paramListenTogetherSession.uin, "", "" + aiob.M(this.app.getCurrentAccountUin(), paramListenTogetherSession.uin), "");
  }
  
  public void bm(JSONObject paramJSONObject)
  {
    ((aink)this.app.getBusinessHandler(156)).bm(paramJSONObject);
  }
  
  public void bn(JSONObject paramJSONObject)
  {
    ((aink)this.app.getBusinessHandler(156)).bn(paramJSONObject);
  }
  
  public void bo(JSONObject paramJSONObject)
  {
    int j = 0;
    if (paramJSONObject == null) {
      return;
    }
    String str1 = paramJSONObject.optString("type");
    String str2 = paramJSONObject.optString("uin");
    int i = paramJSONObject.optInt("uinType");
    QLog.i("ListenTogether.Manager", 1, "onMusicStateChangeJsApiCalled type: " + i + " uin: " + str2 + " apiType: " + str1);
    if ("switchSong".equals(str1))
    {
      R(i, str2, 1010);
      return;
    }
    if ("openListen".equals(str1))
    {
      if (i == 2) {
        aing.k(this.app, str2, true);
      }
      for (;;)
      {
        R(i, str2, 1009);
        return;
        if (i == 1) {
          aing.j(this.app, str2, true);
        }
      }
    }
    if ("closeListen".equals(str1))
    {
      if (i == 2) {
        aing.k(this.app, str2, false);
      }
      for (;;)
      {
        R(i, str2, 1011);
        return;
        if (i == 1) {
          aing.j(this.app, str2, false);
        }
      }
    }
    if ("addSong".equals(str1))
    {
      R(i, str2, 1002);
      return;
    }
    if ("deleteSong".equals(str1))
    {
      R(i, str2, 1002);
      return;
    }
    if ("sortSong".equals(str1))
    {
      R(i, str2, 1002);
      return;
    }
    if ("closeListenSelf".equals(str1))
    {
      r(i, str2, false);
      return;
    }
    if ("showLyrics".equals(str1))
    {
      d(i, str2, true, true);
      return;
    }
    if ("hideLyrics".equals(str1))
    {
      d(i, str2, false, true);
      return;
    }
    boolean bool;
    if ("checkJoin".equals(str1))
    {
      if (!apf()) {
        break label517;
      }
      paramJSONObject = (ListenTogetherSession)this.ly.get(this.bPg);
      if (paramJSONObject == null) {
        break label509;
      }
      bool = TextUtils.equals(paramJSONObject.ckN, this.app.getCurrentUin());
      i = paramJSONObject.type;
    }
    for (;;)
    {
      h(j, bool, i);
      return;
      if ("endTrySong".equals(str1))
      {
        if (SystemClock.elapsedRealtime() - this.abO <= 180000L)
        {
          PX(1013);
          return;
        }
        QLog.i("ListenTogether.Manager", 1, "endTrySong, > 3 min");
        return;
      }
      if ("joinListen".equals(str1))
      {
        ((aink)this.app.getBusinessHandler(156)).I(i, str2, 1001);
        return;
      }
      if (!"musicboxResume".equals(str1)) {
        break;
      }
      PX(1018);
      return;
      label509:
      i = 1;
      bool = false;
      continue;
      label517:
      i = 1;
      j = 1;
      bool = false;
    }
  }
  
  public void bq(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AioShareMusicListenTogether.Manager", 2, "handleCheckAndShowAioShareMusic() isSuccess = " + paramBoolean);
    }
    if (paramBoolean) {}
    try
    {
      ify.c((JSONObject)paramObject, "checkAioShareMusic");
      return;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  public void br(boolean paramBoolean, Object paramObject)
  {
    String str;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("isSuccess", paramBoolean);
      int i;
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        i = ((Integer)paramObject[0]).intValue();
        str = (String)paramObject[1];
        paramObject = (String)paramObject[2];
        R(i, str, 1022);
        P(paramObject, str, i);
        if (i == 2) {
          paramObject = "c2c_AIO";
        }
      }
      else
      {
        while (i != 2)
        {
          anot.a(null, "dc00899", paramObject, "", "music_tab", "clk_share_suc", 0, 0, str, "", "", "");
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AioShareMusicListenTogether.Manager", 2, "handleStartAioShareMusic() jsonObject = " + localJSONObject.toString());
            }
            ify.c(localJSONObject, "startListenAioShareMusic");
            return;
            paramObject = (Object[])paramObject;
            i = ((Integer)paramObject[0]).intValue();
            paramObject = (String)paramObject[1];
            localJSONObject.put("uint32_result", i);
            localJSONObject.put("bytes_errmsg", paramObject);
          }
        }
      }
    }
    catch (JSONException paramObject)
    {
      paramObject.printStackTrace();
      return;
    }
    for (;;)
    {
      str = "";
      break;
      paramObject = "Grp_AIO";
    }
  }
  
  public void c(boolean paramBoolean, ListenTogetherSession paramListenTogetherSession, int paramInt)
  {
    QLog.i("ListenTogether.Manager", 1, "onGetExitListenTogetherResponse isSuceess: " + paramBoolean);
    if (paramListenTogetherSession == null) {
      return;
    }
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.ly.get(paramListenTogetherSession.getKey());
    if (!paramBoolean)
    {
      b(localListenTogetherSession);
      c(localListenTogetherSession);
      return;
    }
    if (paramListenTogetherSession.type == 2) {
      if (paramInt == 3) {
        aing.k(this.app, paramListenTogetherSession.uin, false);
      }
    }
    for (;;)
    {
      R(paramListenTogetherSession.type, paramListenTogetherSession.uin, 1016);
      return;
      if (paramInt == 3) {
        aing.j(this.app, paramListenTogetherSession.uin, false);
      }
    }
  }
  
  public void cN(int paramInt, String paramString)
  {
    QLog.i("ListenTogether.Manager", 1, "onPauseMusicPlay type: " + paramInt + " ,uin: " + paramString);
    this.subHandler.removeMessages(1001);
    boolean bool = this.jdField_a_of_type_Aips.apr();
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.ly.get(aiob.H(paramInt, paramString));
    if (bool)
    {
      if (localListenTogetherSession != null) {
        ((aink)this.app.getBusinessHandler(156)).cK(localListenTogetherSession.type, localListenTogetherSession.uin);
      }
      return;
    }
    cP(paramInt, paramString);
  }
  
  public void cO(int paramInt, String paramString)
  {
    QLog.i("ListenTogether.Manager", 1, "onResumeMusicPlay type: " + paramInt + " ,uin: " + paramString);
    this.subHandler.removeMessages(1001);
    boolean bool = this.jdField_a_of_type_Aips.aps();
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.ly.get(aiob.H(paramInt, paramString));
    if (bool)
    {
      if (localListenTogetherSession != null) {
        ((aink)this.app.getBusinessHandler(156)).cJ(localListenTogetherSession.type, localListenTogetherSession.uin);
      }
      return;
    }
    cQ(paramInt, paramString);
  }
  
  public void d(boolean paramBoolean1, List<MusicInfo> paramList, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      S(paramBoolean1, paramList);
      return;
    }
    R(paramBoolean1, paramList);
  }
  
  public void dta()
  {
    if (this.aJ == null) {}
    for (aioe localaioe = null;; localaioe = (aioe)this.aJ.get())
    {
      if (localaioe != null) {
        localaioe.dth();
      }
      this.aJ = null;
      return;
    }
  }
  
  public void dtb()
  {
    if (this.aJ == null) {}
    for (aioe localaioe = null;; localaioe = (aioe)this.aJ.get())
    {
      if (localaioe != null) {
        localaioe.onCancel();
      }
      this.aJ = null;
      return;
    }
  }
  
  public void dtc()
  {
    if (this.aK == null) {}
    for (aiod localaiod = null;; localaiod = (aiod)this.aK.get())
    {
      if (localaiod != null) {
        localaiod.onCancel();
      }
      this.aK = null;
      return;
    }
  }
  
  public void dtg()
  {
    this.abO = 0L;
  }
  
  public void g(int paramInt, String paramString, long paramLong)
  {
    paramString = paramInt + "_" + paramString;
    this.v.put(paramString, Long.valueOf(paramLong));
  }
  
  public int getPlayState()
  {
    return this.jdField_a_of_type_Aips.getPlayState();
  }
  
  public void h(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogether.Manager", 1, "notifyWebCheckJoinResult uinTypeForOpener:" + paramInt2 + " isOpener:" + paramBoolean + " canJoin:" + paramInt1);
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("type", "checkJoin");
        localJSONObject.put("canJoin", paramInt1);
        if (!paramBoolean) {
          continue;
        }
        paramInt1 = 1;
        localJSONObject.put("isOpener", paramInt1);
        localJSONObject.put("uinType", paramInt2);
      }
      catch (JSONException localJSONException)
      {
        JSONObject localJSONObject;
        QLog.e("ListenTogether.Manager", 1, "notifyWebCheckJoinResult error : " + localJSONException.getMessage());
        Object localObject = null;
        continue;
      }
      if (localJSONObject != null) {
        aiov.bq(localJSONObject);
      }
      return;
      paramInt1 = 0;
    }
  }
  
  public boolean isPlaying()
  {
    int i = getPlayState();
    return (i == 2) || (i == 1);
  }
  
  public void k(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogether.Manager", 1, "musicSongStateChange uinType:" + paramInt1 + " uin:" + paramString1 + " changeType:" + paramString2 + " opValue:" + paramInt2);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", paramString2);
      localJSONObject.put("uin", paramString1);
      localJSONObject.put("uinType", paramInt1);
      localJSONObject.put("value", paramInt2);
      paramString1 = localJSONObject;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        QLog.e("ListenTogether.Manager", 1, "musicSongStateChange error : " + paramString1.getMessage());
        paramString1 = null;
      }
    }
    if (paramString1 != null) {
      aiov.bq(paramString1);
    }
  }
  
  public String lC(String paramString)
  {
    return (String)this.u.get(paramString);
  }
  
  public String lD(String paramString)
  {
    return (String)this.w.get(paramString);
  }
  
  public void n(boolean paramBoolean, int paramInt, String paramString)
  {
    paramString = (ListenTogetherSession)this.ly.get(aiob.H(paramInt, paramString));
    if (paramString != null) {
      paramString.cbN = paramBoolean;
    }
  }
  
  public void o(boolean paramBoolean, int paramInt, String paramString)
  {
    QLog.i("ListenTogether.Manager", 1, "onPauseRespFromServer, success: " + paramBoolean + " ,type: " + paramInt + " ,uin: " + paramString);
    if (!paramBoolean) {
      cP(paramInt, paramString);
    }
    k(paramInt, paramString, "pauseSong", 0);
    R(paramInt, paramString, 1005);
  }
  
  public void onDestroy()
  {
    QLog.i("ListenTogether.Manager", 1, "onDestroy");
    this.isDestroy = true;
    this.subHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Aips.stopPlay();
    this.jdField_a_of_type_Aipy.destroy();
    this.jdField_a_of_type_Aipd.destroy();
    this.jdField_a_of_type_Alep.destroy();
    this.app.removeObserver(this.jdField_a_of_type_Acnd);
    this.app.removeObserver(this.c);
    BaseApplicationImpl.getContext().unregisterReceiver(this.bt);
  }
  
  public void p(boolean paramBoolean, int paramInt, String paramString)
  {
    QLog.i("ListenTogether.Manager", 1, "onResumeRespFromServer, success: " + paramBoolean + " ,type: " + paramInt + " ,uin: " + paramString);
    if (!paramBoolean) {
      cQ(paramInt, paramString);
    }
    k(paramInt, paramString, "resumeSong", 0);
    R(paramInt, paramString, 1006);
  }
  
  public void q(boolean paramBoolean, int paramInt, String paramString)
  {
    QLog.i("ListenTogether.Manager", 1, "onCutOperRespFromServer, success: " + paramBoolean + " ,type: " + paramInt + " ,uin: " + paramString);
    if (!paramBoolean)
    {
      cR(paramInt, paramString);
      return;
    }
    R(paramInt, paramString, 1019);
  }
  
  public void r(int paramInt, String paramString, boolean paramBoolean)
  {
    QLog.i("ListenTogether.Manager", 1, "onExitListenTogether type: " + paramInt + " ,uin: " + paramString + "bForceStop" + paramBoolean);
    if ((paramInt != 1) && (paramInt != 2)) {}
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    aink localaink = (aink)this.app.getBusinessHandler(156);
    if (paramBoolean)
    {
      localaink.cM(paramInt, paramString);
      return;
    }
    localaink.cL(paramInt, paramString);
  }
  
  public void s(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AioShareMusicListenTogether.Manager", 2, "handleReportDownloadFailedAioShareMusic()  isSuccess = " + paramBoolean);
    }
  }
  
  public class RunnableShowForKey
    implements Runnable
  {
    String key;
    boolean show;
    
    RunnableShowForKey(boolean paramBoolean)
    {
      this.show = paramBoolean;
    }
    
    public void run()
    {
      ListenTogetherManager.a(ListenTogetherManager.this, this.key, this.show);
    }
    
    public void setKey(String paramString)
    {
      this.key = paramString;
    }
  }
  
  class a
    implements aipp
  {
    public Object lock = new Object();
    
    private a() {}
    
    public void PZ(int paramInt)
    {
      if (this.lock == null) {}
      while (paramInt == 0) {
        return;
      }
      synchronized (this.lock)
      {
        this.lock.notifyAll();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager
 * JD-Core Version:    0.7.0.1
 */