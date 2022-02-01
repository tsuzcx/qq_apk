package com.tencent.biz.pubaccount.weishi_new.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import ola;
import olb;
import olc;
import ole;
import olf;
import olh;
import oli;
import olj;
import olj.a;
import oll;
import oln;
import ooz;

public class WSPlayerManager
  implements olj.a
{
  private a jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager$a = new a(null);
  private WSVideoPreDownloadManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager;
  private olb jdField_a_of_type_Olb;
  private olj jdField_a_of_type_Olj;
  private Object aQ = new Object();
  private int aVk;
  private boolean anW = true;
  private boolean ape;
  private boolean apl;
  private boolean apm;
  private boolean apn;
  private boolean apo;
  private boolean apq;
  private boolean apr;
  private boolean aps;
  private boolean apt;
  private boolean apu;
  private boolean axD;
  private boolean axE;
  private int bfk;
  private ConcurrentHashMap<olh, Object> bu = new ConcurrentHashMap();
  private ole c;
  private ole d;
  private ArrayList<olf> ls;
  private QQAppInterface mApp;
  private Context mContext = BaseApplicationImpl.getApplication().getApplicationContext();
  private boolean mIsCompleted;
  private Handler mUIHandler = new b(this, Looper.getMainLooper());
  
  public WSPlayerManager(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Olj = new olj();
    this.jdField_a_of_type_Olj.a(this);
    this.ls = new ArrayList();
    this.jdField_a_of_type_Olb = new olb(this);
    AppNetConnInfo.registerConnectionChangeReceiver(this.mContext, this.jdField_a_of_type_Olb);
    this.apo = true;
  }
  
  private void HN()
  {
    ooz.ca("WS_VIDEO_PLAYER", "<------------------------------- [WSPlayerManager.java][onVideoStart] title:" + a(this.c));
    this.mUIHandler.removeMessages(-2);
    this.mUIHandler.sendEmptyMessage(-2);
    this.mUIHandler.post(new WSPlayerManager.4(this));
    if (a(this.c) != null) {
      a(this.c).c(a(this.c));
    }
  }
  
  private String a(ole paramole)
  {
    if (paramole == null) {
      return "WSPlayerParam is null.";
    }
    if (paramole.jdField_a_of_type_Oli == null) {
      return "VideoInfo is null.";
    }
    return paramole.jdField_a_of_type_Oli.mTitle;
  }
  
  private ole a(ole paramole)
  {
    if (paramole == this.c) {
      return paramole;
    }
    return null;
  }
  
  private olh a()
  {
    if (this.mContext == null) {
      return null;
    }
    olh localolh = new olh(this.mContext);
    localolh.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager$a);
    return localolh;
  }
  
  private olh a(ole paramole)
  {
    if (paramole != null) {
      return paramole.c;
    }
    return null;
  }
  
  private olh a(olh paramolh)
  {
    if (paramolh == b()) {
      return paramolh;
    }
    return null;
  }
  
  private oll a(ole paramole)
  {
    if (paramole != null) {
      return paramole.jdField_a_of_type_Oll;
    }
    return null;
  }
  
  private void a(olh paramolh)
  {
    if (paramolh == null) {}
    int i;
    do
    {
      return;
      paramolh.aTU();
      i = paramolh.qe();
    } while ((i == 7) || (i == 8) || (i == 0) || (i == 6));
    paramolh.stopDownload();
    ThreadManager.excute(new WSPlayerManager.6(this, paramolh), 16, null, true);
  }
  
  private boolean a(olh paramolh)
  {
    return a(paramolh) != null;
  }
  
  private olh b()
  {
    return a(this.c);
  }
  
  private boolean b(ole paramole)
  {
    return a(paramole) != null;
  }
  
  private void bfF()
  {
    if (isPause()) {
      restart();
    }
    while ((!isPrepared()) && (!isError()) && (!isCompleted())) {
      return;
    }
    c(this.c, false);
  }
  
  private void d(ole paramole, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (paramole == null) {
      return;
    }
    if ((paramole.mVideoView != null) && (paramole.mVideoView.getParent() != paramole.ci))
    {
      ooz.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][createVideoPlayerAndPlay] playerParam.mVideoView.getParent:" + paramole.mVideoView.getParent() + ", playerParam.mVideoLayout:" + paramole.ci);
      paramole.c = null;
      paramole.mVideoView = null;
    }
    if ((a(paramole) == null) || (a(paramole).getTag() != null))
    {
      boolean bool1 = bool2;
      if (a(paramole) != null)
      {
        bool1 = bool2;
        if (a(paramole).getTag() != null)
        {
          a(paramole).destroy(false);
          ooz.bY("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][createVideoPlayerAndPlay] videoPlayer.tag isn't null!");
          bool1 = true;
        }
      }
      ThreadManager.post(new WSPlayerManager.2(this, paramole, bool1, paramBoolean), 5, null, true);
      return;
    }
    ooz.bY("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][createVideoPlayerAndPlay] hit getVideoPlayerFromParam. goto innerPlayVideo!");
    paramole.c.setTag(paramole.jdField_a_of_type_Oli);
    e(paramole, paramBoolean);
  }
  
  private void e(ole paramole, boolean paramBoolean) {}
  
  private void f(ole paramole, boolean paramBoolean)
  {
    oll localoll;
    if (paramole != null)
    {
      if (paramole.jdField_a_of_type_Oll == null) {
        paramole.jdField_a_of_type_Oll = new oln();
      }
      localoll = paramole.jdField_a_of_type_Oll;
      if (paramole.jdField_a_of_type_Oli == null) {
        break label57;
      }
    }
    label57:
    for (String str = paramole.jdField_a_of_type_Oli.id;; str = "")
    {
      localoll.b(str, paramBoolean, paramole.aqb);
      return;
    }
  }
  
  private void l(ole paramole)
  {
    if (paramole != null) {
      a(paramole.c);
    }
  }
  
  public boolean GY()
  {
    return pX() == 1;
  }
  
  public boolean GZ()
  {
    return pX() == 4;
  }
  
  public boolean Ha()
  {
    return this.apn;
  }
  
  public void Z(int paramInt, boolean paramBoolean)
  {
    if ((this.c != null) && (b() != null))
    {
      this.apq = true;
      b().seekTo(paramInt);
      if ((paramBoolean) && (this.c != null) && (this.c.b != null))
      {
        long l = b().getDuration();
        this.c.b.a(this.c, paramInt, l);
      }
      this.mUIHandler.removeMessages(-2);
    }
  }
  
  public void a(WSVideoPreDownloadManager paramWSVideoPreDownloadManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager = paramWSVideoPreDownloadManager;
  }
  
  public void a(olf paramolf)
  {
    if ((this.ls != null) && (!this.ls.contains(paramolf))) {
      this.ls.add(paramolf);
    }
  }
  
  public ole b()
  {
    return this.c;
  }
  
  public void b(ole paramole, boolean paramBoolean)
  {
    ooz.bY("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout]");
    if (paramole == null)
    {
      ooz.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] playerParam null.");
      return;
    }
    if ((paramole.mVideoView == null) || (paramole.ci == null))
    {
      ooz.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] videoView:" + paramole.mVideoView + ", videoLayout:" + paramole.ci);
      return;
    }
    olh localolh = a(paramole);
    if (localolh == null)
    {
      ooz.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] videoPlayer null.");
      return;
    }
    this.c = paramole;
    View localView = paramole.mVideoView;
    localolh.uL(paramole.bfl);
    localolh.dx(localView);
    paramole.ci.addView(localView, new ViewGroup.LayoutParams(-1, -1));
    localolh.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager$a);
    this.mUIHandler.removeMessages(-2);
    this.mUIHandler.sendEmptyMessage(-2);
    if (paramBoolean) {
      bfF();
    }
    this.bu.put(localolh, this.aQ);
    localolh.bfH();
    this.mUIHandler.post(new WSPlayerManager.1(this, paramole));
  }
  
  public void c(ole paramole, boolean paramBoolean)
  {
    ooz.ca("WS_VIDEO_PLAYER", "-------------------------------> [WSPlayerManager.java][playVideo] title:" + a(paramole));
    Object localObject;
    if ((paramole != null) && (paramole.jdField_a_of_type_Oli != null))
    {
      ooz.bY("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] videoUrl:" + paramole.jdField_a_of_type_Oli.mVideoUrl);
      this.mIsCompleted = false;
      this.aVk = 0;
      this.apl = false;
      this.apm = false;
      this.apq = false;
      this.c = paramole;
      this.bfk = 0;
      if (this.ls != null) {
        localObject = this.ls.iterator();
      }
    }
    else
    {
      while (((Iterator)localObject).hasNext())
      {
        ((olf)((Iterator)localObject).next()).m(this.c);
        continue;
        ooz.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] error, playerParam or videoInfo is null.");
        return;
      }
    }
    if (this.c.b != null) {
      this.c.b.a(this.c, paramBoolean);
    }
    this.mUIHandler.removeMessages(-3);
    this.mUIHandler.removeMessages(-4);
    if ((a(paramole) != null) && (a(paramole).isReady()) && (a(paramole).getTag() == paramole.jdField_a_of_type_Oli))
    {
      paramole.axG = false;
      this.axE = false;
      this.d = null;
      paramole.c.resumeDownload();
      if (a(paramole) != null)
      {
        a(paramole).pg(true);
        a(paramole).b(a(paramole));
      }
      ooz.bY("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] hasPrePlay, just go startVideoAfterPrepared! title:" + a(paramole));
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager$a.bfG();
      return;
    }
    if ((paramole.axG) && ((a(paramole) == null) || (a(paramole).getTag() == paramole.jdField_a_of_type_Oli)))
    {
      if (a(paramole) != null) {
        a(paramole).resumeDownload();
      }
      this.aps = true;
      if (a(paramole) != null) {
        a(paramole).pg(false);
      }
      StringBuilder localStringBuilder = new StringBuilder().append("[WSPlayerManager.java][playVideo] prePlaying, just do nothing! playerStatus:");
      if (a(paramole) != null) {}
      for (localObject = Integer.valueOf(a(paramole).qe());; localObject = " ")
      {
        ooz.e("WS_VIDEO_PRE_PLAY", localObject + ", title:" + a(paramole));
        this.mUIHandler.sendEmptyMessageDelayed(-3, 150L);
        return;
      }
    }
    this.axE = false;
    this.d = null;
    f(this.c, false);
    if ((this.jdField_a_of_type_Olj != null) && (!this.jdField_a_of_type_Olj.EU()))
    {
      this.jdField_a_of_type_Olj.installPlugin();
      return;
    }
    d(paramole, false);
  }
  
  public void doOnPause()
  {
    this.anW = false;
    ooz.bY("WS_VIDEO_PLAYER", "[WSPlayerManager.java][doOnPause] isPlaying:" + isPlaying());
    if (isPlaying())
    {
      this.apr = true;
      this.aps = false;
      pause();
    }
  }
  
  public void doOnResume()
  {
    this.anW = true;
    if ((this.apt) && (b() != null) && (b().isReady())) {
      start();
    }
    label85:
    for (;;)
    {
      this.apr = false;
      this.apt = false;
      return;
      if (this.apr)
      {
        if (this.mApp != null) {}
        for (boolean bool = this.mApp.bF();; bool = false)
        {
          if (bool) {
            break label85;
          }
          this.aps = true;
          restart();
          break;
        }
      }
    }
  }
  
  public boolean isCompleted()
  {
    return pX() == 7;
  }
  
  public boolean isError()
  {
    return pX() == 6;
  }
  
  public boolean isPause()
  {
    return pX() == 5;
  }
  
  public boolean isPlaying()
  {
    return pX() == 3;
  }
  
  public boolean isPrepared()
  {
    return pX() == 2;
  }
  
  public void k(ole paramole)
  {
    ooz.ca("WS_VIDEO_PRE_PLAY", "===============================> [WSPlayerManager.java][prePlayVideo] title:" + a(paramole));
    if (paramole == null) {
      ooz.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][prePlayVideo] playerParam is null.");
    }
    olh localolh;
    do
    {
      do
      {
        return;
        localolh = a(paramole);
      } while ((localolh != null) && (paramole.axG) && (localolh.getTag() == paramole.jdField_a_of_type_Oli));
      if ((this.jdField_a_of_type_Olj != null) && (!this.jdField_a_of_type_Olj.EU()))
      {
        this.jdField_a_of_type_Olj.installPlugin();
        return;
      }
    } while ((localolh != null) && (!localolh.Hb()) && (localolh.qe() != 6) && (localolh.qe() != 7));
    paramole.axG = true;
    this.d = paramole;
    f(paramole, true);
    if (this.d.b != null) {
      this.d.b.b(this.d);
    }
    d(paramole, true);
  }
  
  public void ns(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.c != null) {
        c(this.c, false);
      }
      return;
    }
    this.c = null;
  }
  
  public void oE(boolean paramBoolean)
  {
    this.apn = paramBoolean;
    if (b() != null) {
      b().setLoopback(paramBoolean);
    }
    if (a(this.d) != null) {
      a(this.d).setLoopback(paramBoolean);
    }
  }
  
  public int pX()
  {
    if (b() != null) {
      return b().qe();
    }
    return 0;
  }
  
  public void pause()
  {
    if ((this.c != null) && (b() != null) && ((b().qe() == 3) || (b().qe() == 4)))
    {
      b().pause();
      if (this.c.b != null) {
        this.c.b.e(this.c);
      }
      if (this.ls != null)
      {
        Iterator localIterator = this.ls.iterator();
        while (localIterator.hasNext()) {
          ((olf)localIterator.next()).e(this.c);
        }
      }
    }
  }
  
  public void qQ(boolean paramBoolean)
  {
    if (this.axD != paramBoolean)
    {
      this.axD = paramBoolean;
      if ((b() != null) && (this.c != null)) {
        if (!this.axD) {
          break label45;
        }
      }
    }
    label45:
    for (int i = 2;; i = this.c.bfl)
    {
      b().uL(i);
      return;
    }
  }
  
  public void qR(boolean paramBoolean)
  {
    ooz.bY("WS_VIDEO_PLAYER", "[WSPlayerManager.java][doOnDestroy] isStopVideo:" + paramBoolean);
    this.ape = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager.destroy();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager = null;
    }
    if (paramBoolean) {
      stop();
    }
    this.mUIHandler.removeCallbacksAndMessages(this.c);
    this.mUIHandler.removeCallbacksAndMessages(this.d);
    if ((this.c != null) && (paramBoolean))
    {
      if (b() != null)
      {
        b().destroy();
        this.c.c = null;
      }
      this.c = null;
    }
    if (this.d != null)
    {
      if (a(this.d) != null)
      {
        a(this.d).destroy();
        this.d.c = null;
      }
      this.axE = false;
      this.d = null;
    }
    if (this.bu != null)
    {
      Iterator localIterator = this.bu.keySet().iterator();
      while (localIterator.hasNext())
      {
        olh localolh = (olh)localIterator.next();
        if ((localolh != null) && (localolh.qe() != 8) && ((localolh != b()) || (paramBoolean))) {
          localolh.destroy();
        }
      }
      this.bu.clear();
    }
    if (this.jdField_a_of_type_Olj != null)
    {
      this.jdField_a_of_type_Olj.destroy();
      this.jdField_a_of_type_Olj = null;
    }
    this.mUIHandler.removeCallbacksAndMessages(null);
    if (this.ls != null)
    {
      this.ls.clear();
      this.ls = null;
    }
    if (this.jdField_a_of_type_Olb != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Olb);
      this.jdField_a_of_type_Olb = null;
    }
    this.mApp = null;
    this.mContext = null;
  }
  
  public void restart()
  {
    this.mUIHandler.post(new WSPlayerManager.5(this));
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    boolean bool2 = false;
    this.apu = paramBoolean;
    olh localolh;
    if (b() != null)
    {
      localolh = b();
      if ((!paramBoolean) && (!this.apn)) {
        break label82;
      }
    }
    label82:
    for (boolean bool1 = true;; bool1 = false)
    {
      localolh.setLoopback(bool1);
      if (a(this.d) != null)
      {
        localolh = a(this.d);
        if (!paramBoolean)
        {
          paramBoolean = bool2;
          if (!this.apn) {}
        }
        else
        {
          paramBoolean = true;
        }
        localolh.setLoopback(paramBoolean);
      }
      return;
    }
  }
  
  public void start()
  {
    if (b() != null)
    {
      if (Looper.myLooper() == Looper.getMainLooper()) {
        ThreadManager.getSubThreadHandler().postAtFrontOfQueue(new WSPlayerManager.3(this));
      }
    }
    else {
      return;
    }
    ooz.bY("WS_VIDEO_PLAYER", "[WSPlayerManager.java][start] videoPlayer.start!");
    b().start();
    HN();
  }
  
  public void stop()
  {
    if ((this.c != null) && (b() != null))
    {
      if (a(this.c) != null) {
        a(this.c).a(this.c.c, this.mIsCompleted);
      }
      this.c.axG = false;
      if (this.c.b != null) {
        this.c.b.g(this.c);
      }
      if (this.ls != null)
      {
        Iterator localIterator = this.ls.iterator();
        while (localIterator.hasNext()) {
          ((olf)localIterator.next()).g(this.c, this.mIsCompleted);
        }
      }
      ooz.bY("WS_VIDEO_PLAYER", "[WSPlayerManager.java][stop] title:" + a(this.c));
      l(this.c);
    }
    if (this.c != null) {
      this.c = null;
    }
    this.aVk = 0;
    this.apl = false;
    this.mUIHandler.removeMessages(-2);
  }
  
  class PlayStartVideoRunnable
    implements Runnable
  {
    private olh b;
    private ole h;
    private boolean isPrePlay;
    
    public void run()
    {
      ooz.bY("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] post thread");
      if ((!this.isPrePlay) && (!WSPlayerManager.a(this.this$0, this.b))) {}
      long l;
      do
      {
        do
        {
          return;
        } while ((this.h == null) || (this.b == null) || (WSPlayerManager.b(this.this$0)));
        if (!this.isPrePlay) {
          WSPlayerManager.a(this.this$0, true);
        }
        l = this.h.mStartPosition;
        if (l > 0L) {
          WSPlayerManager.e(this.this$0, true);
        }
      } while (TextUtils.isEmpty(this.h.a.mVideoUrl));
      if ((WSPlayerManager.a(this.this$0) != null) && (WSPlayerManager.a(this.this$0).eG(this.h.a.mVideoUrl))) {}
      for (boolean bool = true;; bool = false)
      {
        ooz.bY("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] goto playerStartByUrl!! isPreDownload:" + bool + ", videoUrl:" + this.h.a.mVideoUrl);
        if (this.b.a("", this.h.a.mVideoUrl, 2, l, 0L, this.h.a.mDuration, true, this.h.axG)) {
          break;
        }
        ooz.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] playerStartByUrl failed, sendMsg retry.");
        WSPlayerManager.a(this.this$0).sendEmptyMessage(-4);
        return;
      }
    }
  }
  
  class a
    extends olc
  {
    private a() {}
    
    void bfG()
    {
      WSPlayerManager.a(WSPlayerManager.this).removeMessages(-3);
      WSPlayerManager.a(WSPlayerManager.this).removeMessages(-4);
      if (WSPlayerManager.a(WSPlayerManager.this))
      {
        WSPlayerManager.this.start();
        return;
      }
      WSPlayerManager.b(WSPlayerManager.this, true);
    }
  }
  
  static class b
    extends Handler
  {
    private final WeakReference<WSPlayerManager> C;
    
    b(WSPlayerManager paramWSPlayerManager, Looper paramLooper)
    {
      super();
      this.C = new WeakReference(paramWSPlayerManager);
    }
    
    public void dispatchMessage(Message paramMessage)
    {
      WSPlayerManager localWSPlayerManager = (WSPlayerManager)this.C.get();
      if ((localWSPlayerManager == null) || (WSPlayerManager.b(localWSPlayerManager))) {}
      do
      {
        return;
        if (!(paramMessage.obj instanceof ole)) {
          break;
        }
      } while (!WSPlayerManager.a(localWSPlayerManager, (ole)paramMessage.obj));
      super.dispatchMessage(paramMessage);
      return;
      super.dispatchMessage(paramMessage);
    }
    
    public void handleMessage(Message paramMessage)
    {
      WSPlayerManager localWSPlayerManager = (WSPlayerManager)this.C.get();
      if (localWSPlayerManager == null) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      case -4: 
        localObject = new StringBuilder().append("[WSPlayerManager.java][handleMessage] MSG_PLAY_BY_URL_FAILED. playerStartByUrl failed, retry again. RetryVideoUrl:");
        if (WSPlayerManager.a(localWSPlayerManager).a == null) {
          break;
        }
      case -3: 
        for (paramMessage = WSPlayerManager.a(localWSPlayerManager).a.mVideoUrl;; paramMessage = "videoInfo is null.")
        {
          ooz.e("WS_VIDEO_PLAYER", paramMessage);
          if (WSPlayerManager.a(localWSPlayerManager) == 1) {
            break;
          }
          WSPlayerManager.a(localWSPlayerManager).axG = false;
          WSPlayerManager.a(localWSPlayerManager, WSPlayerManager.a(localWSPlayerManager));
          WSPlayerManager.a(localWSPlayerManager, WSPlayerManager.a(localWSPlayerManager), false);
          WSPlayerManager.b(localWSPlayerManager);
          return;
          ooz.bY("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][handleMessage] MSG_PRE_PLAY_TIME_OUT. prePlay timeout, try rePlay");
          paramMessage = WSPlayerManager.a(localWSPlayerManager, WSPlayerManager.a(localWSPlayerManager));
          if ((paramMessage != null) && (paramMessage.isReady()) && (paramMessage.getTag() == WSPlayerManager.a(localWSPlayerManager).a))
          {
            ooz.bY("WS_VIDEO_PLAYER", "[WSPlayerManager.java][handleMessage] MSG_PRE_PLAY_TIME_OUT. startVideoAfterPrepared!");
            WSPlayerManager.a(localWSPlayerManager).bfG();
            return;
          }
          WSPlayerManager.a(localWSPlayerManager).axG = false;
          WSPlayerManager.a(localWSPlayerManager, WSPlayerManager.a(localWSPlayerManager));
          WSPlayerManager.a(localWSPlayerManager, WSPlayerManager.a(localWSPlayerManager), false);
          return;
        }
      }
      paramMessage = WSPlayerManager.a(localWSPlayerManager);
      Object localObject = WSPlayerManager.a(localWSPlayerManager);
      long l1;
      boolean bool;
      if ((paramMessage != null) && (paramMessage.isPlaying()) && ((((ole)localObject).b == null) || (!((ole)localObject).b.a((ole)localObject))) && (!paramMessage.isSeeking()))
      {
        l1 = paramMessage.getCurrentPosition();
        long l2 = paramMessage.getDuration();
        if (((ole)localObject).b != null) {
          ((ole)localObject).b.a((ole)localObject, l1, l2);
        }
        if (l1 < l2 - 300L) {
          break label508;
        }
        WSPlayerManager.c(localWSPlayerManager, true);
        int i = (int)(l2 - l1);
        ooz.bY("WS_VIDEO_PLAYER", "[WSPlayerManager.java][handleMessage] MSG_FOR_UPDATE_VIDEO_PLAY_POSITION onVideoEndSoon pos:" + l1 + ", duration:" + l2 + ", remainDuration:" + i + ", mHasCallEndingSoon:" + WSPlayerManager.c(localWSPlayerManager));
        if ((!WSPlayerManager.c(localWSPlayerManager)) && (WSPlayerManager.a(localWSPlayerManager) != null))
        {
          WSPlayerManager.d(localWSPlayerManager, true);
          if ((((ole)localObject).b != null) && (!WSPlayerManager.d(localWSPlayerManager)))
          {
            if ((!WSPlayerManager.e(localWSPlayerManager)) && (!WSPlayerManager.f(localWSPlayerManager))) {
              break label502;
            }
            bool = true;
            ((ole)localObject).b.a(WSPlayerManager.a(localWSPlayerManager), i, bool);
          }
        }
      }
      for (;;)
      {
        WSPlayerManager.a(localWSPlayerManager).sendEmptyMessageDelayed(-2, 100L);
        return;
        label502:
        bool = false;
        break;
        label508:
        if ((l1 <= 500L) && (l1 >= 0L) && (WSPlayerManager.g(localWSPlayerManager)))
        {
          ooz.bY("WS_VIDEO_PLAYER", "[WSPlayerManager.java][handleMessage] MSG_FOR_UPDATE_VIDEO_PLAY_POSITION onVideoReplayOnLoop pos:" + l1);
          WSPlayerManager.e(localWSPlayerManager, false);
          WSPlayerManager.d(localWSPlayerManager, false);
          WSPlayerManager.c(localWSPlayerManager, false);
          WSPlayerManager.c(localWSPlayerManager);
          paramMessage.bfI();
          paramMessage.bfJ();
          if (WSPlayerManager.a(localWSPlayerManager) != null)
          {
            paramMessage = WSPlayerManager.a(localWSPlayerManager).iterator();
            while (paramMessage.hasNext()) {
              ((olf)paramMessage.next()).a(WSPlayerManager.a(localWSPlayerManager), WSPlayerManager.d(localWSPlayerManager));
            }
          }
        }
      }
    }
    
    public boolean sendMessageAtTime(Message paramMessage, long paramLong)
    {
      WSPlayerManager localWSPlayerManager = (WSPlayerManager)this.C.get();
      if ((localWSPlayerManager == null) || (WSPlayerManager.b(localWSPlayerManager))) {
        return false;
      }
      if ((Looper.myLooper() == Looper.getMainLooper()) && (paramLong <= SystemClock.uptimeMillis()))
      {
        if (paramMessage.getCallback() != null) {
          paramMessage.getCallback().run();
        }
        for (;;)
        {
          return true;
          handleMessage(paramMessage);
        }
      }
      if (paramMessage.obj == null) {
        paramMessage.obj = WSPlayerManager.a(localWSPlayerManager);
      }
      return super.sendMessageAtTime(paramMessage, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager
 * JD-Core Version:    0.7.0.1
 */