package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import awit;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import jzk;
import kct;
import kku.a;
import knd;
import kxv;
import mht;
import mhu;
import mqq.os.MqqHandler;
import msa;
import msc;
import mst;
import msv;
import mvw;
import mvx;
import mwc;
import myi;
import myj;
import myj.a;
import mzj;
import mzs;
import mzz;
import nbe;
import nbr;
import nbs;
import nbs.a;
import org.json.JSONObject;

public class VideoFeedsPlayManager
  implements myj.a
{
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$a = new a(null);
  private c jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$c;
  private mst jdField_a_of_type_Mst;
  private mwc jdField_a_of_type_Mwc;
  private myj jdField_a_of_type_Myj;
  private Object aQ = new Object();
  private int aVk;
  private int aVl = -1;
  private Set<String> af = new HashSet();
  private String akv;
  private boolean anW = true;
  private boolean apj;
  private boolean apk;
  private boolean apl;
  private boolean apm;
  private boolean apn;
  private boolean apo;
  private boolean app;
  private boolean apq;
  private boolean apr;
  private boolean aps;
  private boolean apt;
  private boolean apu;
  private b b;
  private ConcurrentHashMap<String, myi> bu = new ConcurrentHashMap();
  private b c;
  private ArrayList<d> ls;
  private QQAppInterface mApp;
  private Context mContext;
  private boolean mIsCompleted;
  private int mSceneType;
  private Handler mUIHandler = new mvw(this, Looper.getMainLooper());
  private VideoPreDownloadMgr mVideoPreDownloadMgr;
  private long wV;
  
  public VideoFeedsPlayManager(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this(paramContext, paramQQAppInterface, 0);
  }
  
  public VideoFeedsPlayManager(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.mSceneType = paramInt;
    this.jdField_a_of_type_Myj = new myj();
    this.jdField_a_of_type_Myj.a(this);
    this.ls = new ArrayList();
    mzj.a().a(this);
    this.jdField_a_of_type_Mst = mst.a();
    if (mst.as(this.mContext)) {
      oD(true);
    }
    for (;;)
    {
      this.apo = awit.v(paramQQAppInterface);
      return;
      oD(false);
    }
  }
  
  private boolean EG()
  {
    return (this.b != null) && (this.b.d != null) && (this.b.jdField_a_of_type_Mht != null) && (this.b.d.isAD) && (this.b.d.b != null);
  }
  
  private b a(b paramb)
  {
    if (paramb == this.b) {
      return paramb;
    }
    return null;
  }
  
  private myi a(b paramb)
  {
    if (this.mContext == null) {
      return null;
    }
    paramb = new myi(this.mContext.getApplicationContext());
    paramb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$a);
    return paramb;
  }
  
  private myi a(myi parammyi)
  {
    if (parammyi == b()) {
      return parammyi;
    }
    return null;
  }
  
  private void a(boolean paramBoolean, b paramb)
  {
    Object localObject;
    if (paramb.c != null)
    {
      localObject = b();
      paramb.c.playDuration = ((myi)localObject).c(this.mIsCompleted);
      paramb.c.secondBufferCount = ((myi)localObject).qf();
      paramb.c.vD = ((myi)localObject).dd();
      paramb.c.videoFormat = ((myi)localObject).qg();
      paramb.c.amD = ((myi)localObject).aqr;
      paramb.c.mFileSize = ((myi)localObject).mFileSize;
      paramb.c.vF = ((myi)localObject).vF;
      paramb.c.vG = ((myi)localObject).df();
      paramb.c.vH = ((myi)localObject).qh();
      paramb.c.ahx = ((myi)localObject).ky();
      paramb.c.vJ = ((myi)localObject).dh();
      paramb.c.vK = ((myi)localObject).dg();
      if ((paramb.c.playDuration == 0L) && (paramb.c.vt == 0L))
      {
        paramb.c.vt = (SystemClock.uptimeMillis() - paramb.c.vs);
        paramb.c.vv = paramb.c.vt;
      }
      paramb.c.bandwidth = mzs.a().getCurrentPrediction();
      paramb.c.ahD = mzz.a().kC();
      paramb.c.loopCount = this.aVk;
      b(paramb.c);
    }
    label347:
    AdvertisementInfo localAdvertisementInfo;
    int n;
    int i1;
    int i;
    label440:
    int j;
    label451:
    int k;
    if ((EG()) && (paramBoolean) && (!paramb.jdField_a_of_type_Mht.amB))
    {
      if (b().de() != 0L) {
        break label559;
      }
      paramb.jdField_a_of_type_Mht.aSl = paramb.jdField_a_of_type_Mht.endPosition;
      paramb.jdField_a_of_type_Mht.endPosition = ((int)b().d(this.mIsCompleted));
      localObject = paramb.jdField_a_of_type_Mht;
      if (paramb.jdField_a_of_type_Mht.aSl != 0) {
        break label577;
      }
      paramBoolean = true;
      ((mht)localObject).amz = paramBoolean;
      paramb.jdField_a_of_type_Mht.amA = this.mIsCompleted;
      localObject = paramb.jdField_a_of_type_Mht;
      kct.a(((mht)localObject).autoPlay, ((mht)localObject).aSl, ((mht)localObject).endPosition, ((mht)localObject).amz, ((mht)localObject).amA, ((mht)localObject).aSm);
      localAdvertisementInfo = jzk.a(paramb.d.b);
      n = ((mht)localObject).aSl;
      i1 = ((mht)localObject).endPosition;
      if (!((mht)localObject).amz) {
        break label582;
      }
      i = 1;
      if (!((mht)localObject).amA) {
        break label587;
      }
      j = 1;
      if (!knd.a(this.b)) {
        break label593;
      }
      k = 20;
      label465:
      if (!((mht)localObject).autoPlay) {
        break label599;
      }
    }
    label559:
    label577:
    label582:
    label587:
    label593:
    label599:
    for (int m = 1;; m = 2)
    {
      JSONObject localJSONObject = jzk.a(n, i1, i, j, k, m, 0, jzk.aGr, 0);
      jzk.a(new kku.a().a(this.mContext).a(jzk.aEO).b(((mht)localObject).aSn).a(localAdvertisementInfo).a(paramb.d.b).a(localJSONObject).a());
      knd.e(this.b);
      return;
      paramb.jdField_a_of_type_Mht.aSl = ((int)b().de());
      break;
      paramBoolean = false;
      break label347;
      i = 0;
      break label440;
      j = 0;
      break label451;
      k = 0;
      break label465;
    }
  }
  
  private boolean a(myi parammyi)
  {
    return a(parammyi) != null;
  }
  
  private myi b()
  {
    return b(this.b);
  }
  
  private myi b(b paramb)
  {
    if (paramb != null) {
      return paramb.e;
    }
    return null;
  }
  
  private void b(mhu parammhu)
  {
    ThreadManager.excute(new VideoFeedsPlayManager.7(this, parammhu), 16, null, true);
  }
  
  private void c(myi parammyi)
  {
    if (parammyi == null) {}
    do
    {
      return;
      parammyi.aTU();
    } while (parammyi.isReusable());
    parammyi.stopDownload();
    ThreadManager.excute(new VideoFeedsPlayManager.6(this, parammyi), 16, null, true);
  }
  
  private void e(b paramb, boolean paramBoolean)
  {
    myi localmyi = b(paramb);
    if (localmyi != null) {}
    for (Object localObject = localmyi.getTag(); (localmyi != null) && (localObject == null) && (localmyi.isReusable()); localObject = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo hit cache");
      }
      paramb.e.setTag(paramb.d);
      f(paramb, paramBoolean);
      return;
    }
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "createVideoPlayerAndPlay: videoPlayer.tag isn't null!");
      }
      localmyi.oO(false);
      paramb.videoView = null;
    }
    ThreadManager.post(new VideoFeedsPlayManager.2(this, paramb, paramBoolean), 5, null, true);
  }
  
  private boolean e(b paramb)
  {
    return a(paramb) != null;
  }
  
  private void f(b paramb, boolean paramBoolean)
  {
    boolean bool2 = false;
    if ((paramb == null) || (b(paramb) == null)) {
      return;
    }
    paramb.videoLayout.setKeepScreenOn(true);
    Object localObject;
    if (paramb.videoView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
      }
      b(paramb).t(paramb.videoLayout);
      localObject = b(paramb).getVideoView();
      if (localObject == null)
      {
        if (paramb.jdField_a_of_type_Msa != null) {
          paramb.jdField_a_of_type_Msa.a(paramb, 999, 999, null);
        }
        paramb.e = null;
        return;
      }
      paramb.videoView = ((View)localObject);
      ((View)localObject).setId(2131376720);
      if (paramb.jdField_a_of_type_Msa != null) {
        paramb.jdField_a_of_type_Msa.h(paramb);
      }
      if ((paramb.d != null) && (paramb.d.width > 0) && (paramb.d.height > 0) && (paramb.d.height < 10000) && (paramb.d.width < 10000)) {
        b(paramb).b().setFixedSize(paramb.d.width, paramb.d.height);
      }
    }
    int i;
    if (this.apj)
    {
      i = 2;
      b(paramb).setXYaxis(i);
      localObject = b(paramb);
      if ((!this.apu) && (!this.apn)) {
        break label503;
      }
      bool1 = true;
      label257:
      ((myi)localObject).setLoopback(bool1);
      localObject = b(paramb);
      if ((!this.apo) || (paramb.d.isAD)) {
        break label509;
      }
    }
    label503:
    label509:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((myi)localObject).oN(bool1);
      b(paramb).oP(paramb.apx);
      b(paramb).setMute(this.app);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "innerPlayVideo: isMuted=" + b(paramb).isMuted());
      }
      paramb.videoView.setVisibility(0);
      if (!paramBoolean) {
        paramb.c.vs = SystemClock.uptimeMillis();
      }
      if (paramb.c != null)
      {
        paramb.c.aSt = 0;
        paramb.c.skipFramesTotalCount = 0;
        paramb.c.aSu = 0;
        paramb.c.amF = false;
        paramb.c.amG = false;
        localObject = paramb.c;
        bool1 = bool2;
        if (this.apo)
        {
          bool1 = bool2;
          if (!paramb.d.isAD) {
            bool1 = true;
          }
        }
        ((mhu)localObject).amH = bool1;
      }
      ThreadManager.excute(new PlayStartVideoRunnable(paramb, b(paramb), paramBoolean), 16, null, true);
      return;
      i = paramb.aVm;
      break;
      bool1 = false;
      break label257;
    }
  }
  
  private void n(b paramb)
  {
    mhu localmhu;
    if (paramb != null)
    {
      paramb.c = new mhu();
      paramb.c.busiType = paramb.d.busiType;
      paramb.c.vid = paramb.d.vid;
      paramb.c.rowkey = paramb.d.Wz;
      localmhu = paramb.c;
      if (this.mSceneType != 1) {
        break label275;
      }
    }
    label275:
    for (int i = 5;; i = 2)
    {
      localmhu.IH = i;
      paramb.c.videoWidth = paramb.d.width;
      paramb.c.videoHeight = paramb.d.height;
      paramb.c.vI = paramb.d.duration;
      paramb.c.success = true;
      paramb.c.aSt = 0;
      paramb.c.skipFramesTotalCount = 0;
      paramb.c.aSu = 0;
      paramb.c.amE = false;
      paramb.c.ahy = "";
      paramb.c.amF = false;
      paramb.c.amG = false;
      paramb.c.aSp = paramb.extraData.getInt("jump_from_scene");
      paramb.c.index = paramb.extraData.getInt("video_feeds_index");
      if ((paramb != null) && (paramb.d != null) && (paramb.d.isAD))
      {
        paramb.jdField_a_of_type_Mht = new mht();
        i = paramb.extraData.getInt("ad_origin", jzk.aFA);
        paramb.jdField_a_of_type_Mht.aSn = i;
      }
      return;
    }
  }
  
  public boolean EE()
  {
    return this.apr;
  }
  
  public boolean EF()
  {
    return pX() == 3;
  }
  
  public void Z(int paramInt, boolean paramBoolean)
  {
    if ((this.b != null) && (b() != null))
    {
      this.apq = true;
      b().seekTo(paramInt);
      if ((paramBoolean) && (this.b != null) && (this.b.jdField_a_of_type_Msa != null))
      {
        long l = b().getDuration();
        this.b.jdField_a_of_type_Msa.a(this.b, (int)(paramInt * 100.0F / (float)l + 0.5D), l);
      }
      this.mUIHandler.removeMessages(-2);
    }
  }
  
  public b a()
  {
    return this.b;
  }
  
  public myi a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (myi)this.bu.get(paramString);
  }
  
  public void a(c paramc)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$c = paramc;
  }
  
  public void a(d paramd)
  {
    this.ls.add(paramd);
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.mVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(mwc parammwc)
  {
    this.jdField_a_of_type_Mwc = parammwc;
  }
  
  public void aST()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "checkPlayStateAfterPhoneCall mIsActivityOnResume = " + this.anW);
    }
    if (!this.anW) {}
    while ((!isPause()) || (!EE())) {
      return;
    }
    oB(false);
    restart();
  }
  
  public long cV()
  {
    if ((this.b != null) && (b() != null)) {
      return b().dc();
    }
    return 0L;
  }
  
  public void d(b paramb, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playVideo");
    }
    Object localObject;
    if ((paramb != null) && (paramb.d != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "playVideo() vid=" + paramb.d.vid);
      }
      this.mIsCompleted = false;
      this.aVk = 0;
      this.apl = false;
      this.apm = false;
      this.apq = false;
      this.b = paramb;
      if (this.ls != null) {
        localObject = this.ls.iterator();
      }
    }
    else
    {
      while (((Iterator)localObject).hasNext())
      {
        ((d)((Iterator)localObject).next()).q(this.b);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "playVideo() error, playerParam or videoInfo is null");
        }
        return;
      }
    }
    if (this.b.jdField_a_of_type_Msa != null) {
      this.b.jdField_a_of_type_Msa.b(this.b, paramBoolean);
    }
    this.mUIHandler.removeMessages(-3);
    myi localmyi = b(paramb);
    int i;
    if ((localmyi != null) && ((localmyi.isReady()) || (localmyi.isPause()) || (localmyi.isBuffering())))
    {
      i = 1;
      if ((localmyi != null) && (localmyi.getTag() != paramb.d)) {
        break label361;
      }
    }
    label361:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label367;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playVideo hasPrePlay, just go onVideoPrepared");
      }
      paramb.apw = false;
      this.c = null;
      paramb.c.vs = SystemClock.uptimeMillis();
      paramb.c.aSs = 2;
      paramb.e.resumeDownload();
      if (!TextUtils.isEmpty(this.akv)) {
        paramb.c.ahz = this.akv;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$a.p(paramb);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$a.d(paramb.e);
      return;
      i = 0;
      break;
    }
    label367:
    if ((paramb.apw) && (j != 0))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("VideoFeedsPlayManager playVideo prePlaying, just do nothing ");
        if (localmyi == null) {
          break label479;
        }
      }
      for (localObject = Integer.valueOf(localmyi.qe());; localObject = null)
      {
        QLog.d("VideoFeedsPlayManager.preplay", 2, localObject);
        if (localmyi != null) {
          localmyi.resumeDownload();
        }
        paramb.c.vs = SystemClock.uptimeMillis();
        paramb.c.aSs = 1;
        this.aps = true;
        this.mUIHandler.sendEmptyMessageDelayed(-3, 10000L);
        return;
      }
    }
    label479:
    this.c = null;
    n(this.b);
    if ((this.jdField_a_of_type_Myj != null) && (!this.jdField_a_of_type_Myj.EU()))
    {
      this.jdField_a_of_type_Myj.installPlugin();
      return;
    }
    if (paramb != null) {
      paramb.c.aSs = 0;
    }
    e(paramb, false);
  }
  
  public void doOnDestory()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "doOnDestory: ");
    }
    this.apk = true;
    if (this.mVideoPreDownloadMgr != null)
    {
      this.mVideoPreDownloadMgr.destroy();
      this.mVideoPreDownloadMgr = null;
    }
    stop();
    this.mUIHandler.removeCallbacksAndMessages(this.b);
    this.mUIHandler.removeCallbacksAndMessages(this.c);
    if (this.b != null)
    {
      if (b() != null)
      {
        b().destory();
        this.b.e = null;
      }
      this.b = null;
    }
    if (this.c != null)
    {
      if (b(this.c) != null)
      {
        b(this.c).destory();
        this.c.e = null;
      }
      this.c = null;
    }
    if (this.bu != null)
    {
      Iterator localIterator = this.bu.values().iterator();
      while (localIterator.hasNext())
      {
        myi localmyi = (myi)localIterator.next();
        if ((localmyi != null) && (!localmyi.isDestroyed())) {
          localmyi.destory();
        }
      }
    }
    if (this.jdField_a_of_type_Myj != null)
    {
      this.jdField_a_of_type_Myj.destroy();
      this.jdField_a_of_type_Myj = null;
    }
    this.mUIHandler.removeCallbacksAndMessages(null);
    if (this.ls != null)
    {
      this.ls.clear();
      this.ls = null;
    }
    mzj.a().b(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$c = null;
    this.jdField_a_of_type_Mwc = null;
    this.mApp = null;
    this.mContext = null;
  }
  
  public void doOnPause()
  {
    this.anW = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "doOnPause() isPlaying()=" + isPlaying());
    }
    if (isPlaying())
    {
      this.apr = true;
      this.aps = false;
      pause();
    }
    mzs.a().stop(this.mContext);
  }
  
  public void doOnResume()
  {
    boolean bool2 = true;
    this.anW = true;
    if ((this.apt) && (b() != null) && (b().isReady())) {
      start();
    }
    label60:
    label119:
    label122:
    for (;;)
    {
      this.apr = false;
      this.apt = false;
      msv localmsv = msv.a();
      if (!mst.a().Eg())
      {
        bool1 = bool2;
        localmsv.setAutoPlay(bool1);
        mzs.a().start(this.mContext);
        return;
        if (!this.apr) {
          continue;
        }
        if (this.mApp == null) {
          break label119;
        }
      }
      for (boolean bool1 = this.mApp.bF();; bool1 = false)
      {
        if (bool1) {
          break label122;
        }
        this.aps = true;
        restart();
        break;
        bool1 = false;
        break label60;
      }
    }
  }
  
  public VideoInfo e()
  {
    if ((this.b == null) || (this.b.d == null)) {
      return null;
    }
    return this.b.d;
  }
  
  public long getVideoDuration()
  {
    if (b() != null) {
      return b().getDuration();
    }
    return 0L;
  }
  
  public boolean isMute()
  {
    return (b() != null) && (b().isMuted());
  }
  
  public boolean isPause()
  {
    return (b() != null) && (b().isPause());
  }
  
  public boolean isPlaying()
  {
    return (b() != null) && (b().isPlaying());
  }
  
  public void l(b paramb)
  {
    this.mIsCompleted = false;
    this.b = paramb;
    if (this.b.jdField_a_of_type_Msa != null) {
      this.b.jdField_a_of_type_Msa.f(this.b);
    }
  }
  
  public void m(b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager prePlayVideo");
    }
    if ((paramb == null) || (paramb == this.b)) {}
    do
    {
      myi localmyi;
      do
      {
        return;
        localmyi = b(paramb);
      } while ((localmyi != null) && (paramb.apw) && (localmyi.getTag() == paramb.d));
      this.akv = null;
    } while ((this.jdField_a_of_type_Myj == null) || (!this.jdField_a_of_type_Myj.EU()));
    paramb.apw = true;
    this.c = paramb;
    n(this.c);
    if (this.c.jdField_a_of_type_Msa != null) {
      this.c.jdField_a_of_type_Msa.g(this.c);
    }
    e(paramb, true);
  }
  
  public void ns(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.b != null) {
        d(this.b, true);
      }
      return;
    }
    if ((this.b != null) && (this.b.jdField_a_of_type_Msa != null)) {
      this.b.jdField_a_of_type_Msa.a(this.b, 999, 998, null);
    }
    this.b = null;
  }
  
  @Deprecated
  public void o(b paramb)
  {
    if (paramb != null) {
      c(paramb.e);
    }
  }
  
  public void oB(boolean paramBoolean)
  {
    this.apr = paramBoolean;
  }
  
  public void oC(boolean paramBoolean)
  {
    if (this.apj != paramBoolean)
    {
      this.apj = paramBoolean;
      if ((b() != null) && (this.b != null)) {
        if (!this.apj) {
          break label45;
        }
      }
    }
    label45:
    for (int i = 2;; i = this.b.aVm)
    {
      b().setXYaxis(i);
      return;
    }
  }
  
  public void oD(boolean paramBoolean)
  {
    this.jdField_a_of_type_Mst.od(paramBoolean);
  }
  
  public void oE(boolean paramBoolean)
  {
    this.apn = paramBoolean;
    if (b() != null) {
      b().setLoopback(paramBoolean);
    }
    if (b(this.c) != null) {
      b(this.c).setLoopback(paramBoolean);
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
    Object localObject;
    if ((this.b != null) && (b() != null) && (b().isPlaying()))
    {
      b().pause();
      if (this.b.jdField_a_of_type_Msa != null) {
        this.b.jdField_a_of_type_Msa.d(this.b);
      }
      if (this.ls != null)
      {
        localObject = this.ls.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((d)((Iterator)localObject).next()).d(this.b);
        }
      }
    }
    boolean bool;
    label198:
    AdvertisementInfo localAdvertisementInfo;
    int n;
    int i1;
    int i;
    label301:
    int j;
    label311:
    int k;
    if ((EG()) && (b() != null))
    {
      if (b().de() != 0L) {
        break label419;
      }
      this.b.jdField_a_of_type_Mht.aSl = this.b.jdField_a_of_type_Mht.endPosition;
      this.b.jdField_a_of_type_Mht.endPosition = ((int)b().d(this.mIsCompleted));
      localObject = this.b.jdField_a_of_type_Mht;
      if (this.b.jdField_a_of_type_Mht.aSl != 0) {
        break label440;
      }
      bool = true;
      ((mht)localObject).amz = bool;
      this.b.jdField_a_of_type_Mht.amA = this.mIsCompleted;
      localObject = this.b.jdField_a_of_type_Mht;
      kct.a(((mht)localObject).autoPlay, ((mht)localObject).aSl, ((mht)localObject).endPosition, ((mht)localObject).amz, ((mht)localObject).amA, ((mht)localObject).aSm);
      localAdvertisementInfo = jzk.a(this.b.d.b);
      n = ((mht)localObject).aSl;
      i1 = ((mht)localObject).endPosition;
      if (!((mht)localObject).amz) {
        break label446;
      }
      i = 1;
      if (!((mht)localObject).amA) {
        break label451;
      }
      j = 1;
      if (!knd.a(this.b)) {
        break label456;
      }
      k = 20;
      label324:
      if (!((mht)localObject).autoPlay) {
        break label461;
      }
    }
    label419:
    label440:
    label446:
    label451:
    label456:
    label461:
    for (int m = 1;; m = 2)
    {
      JSONObject localJSONObject = jzk.a(n, i1, i, j, k, m, 0, jzk.aGr, 0);
      jzk.a(new kku.a().a(this.mContext).a(jzk.aEO).b(((mht)localObject).aSn).a(localAdvertisementInfo).a(this.b.d.b).a(localJSONObject).a());
      knd.e(this.b);
      return;
      this.b.jdField_a_of_type_Mht.aSl = ((int)b().de());
      break;
      bool = false;
      break label198;
      i = 0;
      break label301;
      j = 0;
      break label311;
      k = 0;
      break label324;
    }
  }
  
  public void restart()
  {
    this.mUIHandler.post(new VideoFeedsPlayManager.5(this));
  }
  
  public void seekTo(int paramInt)
  {
    Z(paramInt, false);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    boolean bool2 = false;
    this.apu = paramBoolean;
    myi localmyi;
    if (b() != null)
    {
      localmyi = b();
      if ((!paramBoolean) && (!this.apn)) {
        break label82;
      }
    }
    label82:
    for (boolean bool1 = true;; bool1 = false)
    {
      localmyi.setLoopback(bool1);
      if (b(this.c) != null)
      {
        localmyi = b(this.c);
        if (!paramBoolean)
        {
          paramBoolean = bool2;
          if (!this.apn) {}
        }
        else
        {
          paramBoolean = true;
        }
        localmyi.setLoopback(paramBoolean);
      }
      return;
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.app = paramBoolean;
    if (b() != null) {
      b().setMute(paramBoolean);
    }
    if (b(this.c) != null) {
      b(this.c).setMute(paramBoolean);
    }
  }
  
  public void setSpeedRatio(float paramFloat)
  {
    if (b() != null) {
      b().setSpeedRatio(paramFloat);
    }
  }
  
  public void start()
  {
    if (b() != null)
    {
      if (Looper.myLooper() == Looper.getMainLooper()) {
        ThreadManager.getSubThreadHandler().postAtFrontOfQueue(new VideoFeedsPlayManager.3(this));
      }
    }
    else
    {
      this.mUIHandler.removeMessages(-2);
      this.mUIHandler.sendEmptyMessage(-2);
      this.mUIHandler.post(new VideoFeedsPlayManager.4(this));
      if (EG())
      {
        String str = this.b.d.b.We;
        if (this.af.contains(str)) {
          break label191;
        }
        this.af.add(str);
      }
    }
    label191:
    for (this.b.jdField_a_of_type_Mht.aSm = mht.aSi;; this.b.jdField_a_of_type_Mht.aSm = mht.aSk)
    {
      this.b.c.aSr = this.b.e.getVideoHeight();
      this.b.c.aSq = this.b.e.getVideoWidth();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
      }
      b().start();
      break;
    }
  }
  
  public void stop()
  {
    stop(true);
  }
  
  public void stop(boolean paramBoolean)
  {
    if ((this.b != null) && (this.b.jdField_a_of_type_Msa != null)) {
      this.b.jdField_a_of_type_Msa.c(this.b);
    }
    if ((this.b != null) && (this.jdField_a_of_type_Mwc != null) && (this.b.e != null)) {
      this.jdField_a_of_type_Mwc.a(1, this.b.d, this.b.e.c(this.mIsCompleted));
    }
    if ((this.b != null) && (b() != null))
    {
      a(paramBoolean, this.b);
      this.b.apw = false;
      if (this.ls != null)
      {
        Iterator localIterator = this.ls.iterator();
        while (localIterator.hasNext()) {
          ((d)localIterator.next()).g(this.b, this.mIsCompleted);
        }
      }
      o(this.b);
    }
    if (this.b != null) {
      this.b = null;
    }
    this.aVk = 0;
    this.apl = false;
    this.mUIHandler.removeMessages(-2);
  }
  
  public class PlayStartVideoRunnable
    implements Runnable
  {
    private WeakReference<VideoFeedsPlayManager.b> cp;
    private WeakReference<myi> cq;
    private boolean isPrePlay;
    
    public PlayStartVideoRunnable(VideoFeedsPlayManager.b paramb, myi parammyi, boolean paramBoolean)
    {
      this.cp = new WeakReference(paramb);
      this.cq = new WeakReference(parammyi);
      this.isPrePlay = paramBoolean;
    }
    
    private void F(String paramString, long paramLong)
    {
      kxv localkxv = kxv.a();
      localkxv.a(paramString, "PubAccountArticleCenter.GetUrlByVid", new mvx(this, paramLong, localkxv));
    }
    
    private void a(VideoFeedsPlayManager.b paramb, myi parammyi, long paramLong)
    {
      if (VideoFeedsPlayManager.a(VideoFeedsPlayManager.this) != null)
      {
        VideoPreDownloadMgr localVideoPreDownloadMgr = VideoFeedsPlayManager.a(VideoFeedsPlayManager.this);
        parammyi.aqr = localVideoPreDownloadMgr.I(null, paramb.d.vid);
        localVideoPreDownloadMgr.ak(paramb.d.vid, parammyi.aqr);
      }
      parammyi.a(paramb.d.vid, 1, paramLong, paramb.apw);
    }
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo post thread");
      }
      VideoFeedsPlayManager.b localb = (VideoFeedsPlayManager.b)this.cp.get();
      myi localmyi = (myi)this.cq.get();
      if ((!this.isPrePlay) && (!VideoFeedsPlayManager.a(VideoFeedsPlayManager.this, localmyi))) {}
      label56:
      long l;
      do
      {
        do
        {
          do
          {
            do
            {
              break label56;
              break label56;
              do
              {
                return;
              } while ((localb == null) || (localmyi == null) || (VideoFeedsPlayManager.e(VideoFeedsPlayManager.this)));
              if (!this.isPrePlay) {
                VideoFeedsPlayManager.a(VideoFeedsPlayManager.this, true);
              }
              l = localb.startPosition;
              if (l > 0L) {
                VideoFeedsPlayManager.f(VideoFeedsPlayManager.this, true);
              }
              if (localb.d.busiType != 0) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.e("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "PlayStartVideoRunnable Error : busiType = 0, msg = null, vid=" + localb.d.vid);
              }
            } while (VideoFeedsPlayManager.a(VideoFeedsPlayManager.this) == null);
            VideoFeedsPlayManager.a(VideoFeedsPlayManager.this).a(localmyi, 101, 60, 0, "video info busiType error", null);
            return;
            if (nbe.dZ(localb.d.busiType))
            {
              a(localb, localmyi, l);
              return;
            }
            if ((localb.d.busiType != 2) && ((localb.d.busiType != 6) || (TextUtils.isEmpty(localb.d.vid)))) {
              break;
            }
            if (localb.d.vid != null)
            {
              F(localb.d.vid, l);
              return;
            }
          } while (VideoFeedsPlayManager.a(VideoFeedsPlayManager.this) == null);
          VideoFeedsPlayManager.a(VideoFeedsPlayManager.this).a(localmyi, 101, 61, 0, "vid null", null);
          return;
          if (localb.d.busiType != 5) {
            break;
          }
        } while (localb.d.vid == null);
        VideoPreDownloadMgr localVideoPreDownloadMgr = VideoFeedsPlayManager.a(VideoFeedsPlayManager.this);
        if (localVideoPreDownloadMgr != null)
        {
          localmyi.aqr = localVideoPreDownloadMgr.I(localb.d.vid, localb.d.vid);
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "广告视频预下载: url:" + localb.d.vid + " ;isPreDownloadHit: " + localmyi.aqr);
          }
          localVideoPreDownloadMgr.ak(localb.d.vid, localmyi.aqr);
        }
        localmyi.a("", localb.d.vid, 101, l, 0L, localb.d.duration, true, false, localb.apw);
        return;
      } while ((localb.d.busiType != 6) || (TextUtils.isEmpty(localb.d.videoUrl)));
      localmyi.a("", localb.d.videoUrl, 101, l, 0L, localb.d.duration, true, true, localb.apw);
    }
  }
  
  public class a
    extends msc
  {
    private a() {}
    
    private void aSU()
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "预播放任务 onDownloadFinish title = " + VideoFeedsPlayManager.a(VideoFeedsPlayManager.this).d.title);
      }
      if (VideoFeedsPlayManager.a(VideoFeedsPlayManager.this) != null)
      {
        VideoFeedsPlayManager.a(VideoFeedsPlayManager.this).sN(VideoFeedsPlayManager.a(VideoFeedsPlayManager.this).aVn);
        VideoFeedsPlayManager.a(VideoFeedsPlayManager.this, VideoFeedsPlayManager.a(VideoFeedsPlayManager.this).aVn);
      }
    }
    
    private void aSV()
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "onPrePlayFinished() vid=" + VideoFeedsPlayManager.a(VideoFeedsPlayManager.this).d.vid);
      }
      VideoFeedsPlayManager.a(VideoFeedsPlayManager.this, VideoFeedsPlayManager.a(VideoFeedsPlayManager.this)).stopDownload();
      if (VideoFeedsPlayManager.a(VideoFeedsPlayManager.this) != null) {
        VideoFeedsPlayManager.a(VideoFeedsPlayManager.this).jdField_a_of_type_Msa.c(VideoFeedsPlayManager.a(VideoFeedsPlayManager.this), VideoFeedsPlayManager.b(VideoFeedsPlayManager.this));
      }
      if (nbs.a.Fg()) {
        aSU();
      }
    }
    
    public void a(myi parammyi)
    {
      if (!VideoFeedsPlayManager.a(VideoFeedsPlayManager.this, parammyi)) {
        return;
      }
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("播放状态回调 onCompletion() vid=");
        if (VideoFeedsPlayManager.b(VideoFeedsPlayManager.this) == null) {
          break label133;
        }
      }
      label133:
      for (parammyi = VideoFeedsPlayManager.b(VideoFeedsPlayManager.this).d.vid;; parammyi = "param null")
      {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, parammyi);
        VideoFeedsPlayManager.a(VideoFeedsPlayManager.this).post(new VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.4(this));
        parammyi = VideoFeedsPlayManager.b(VideoFeedsPlayManager.this);
        if ((parammyi != null) && (parammyi.c != null))
        {
          parammyi.c.success = true;
          parammyi.c.isCompleted = true;
        }
        VideoFeedsPlayManager.c(VideoFeedsPlayManager.this, true);
        return;
      }
    }
    
    public void a(myi parammyi, Object paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
      }
      if (!VideoFeedsPlayManager.a(VideoFeedsPlayManager.this, parammyi))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared checkIsPlayerPlaying false");
        }
        if ((VideoFeedsPlayManager.a(VideoFeedsPlayManager.this, VideoFeedsPlayManager.a(VideoFeedsPlayManager.this)) == parammyi) && (VideoFeedsPlayManager.a(VideoFeedsPlayManager.this).apw)) {
          aSV();
        }
      }
      do
      {
        return;
        paramObject = VideoFeedsPlayManager.b(VideoFeedsPlayManager.this);
        if ((paramObject != null) && (QLog.isColorLevel())) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onVideoPrepared() vid=" + paramObject.d.vid + ", mIsOpenedVideo = " + VideoFeedsPlayManager.a(VideoFeedsPlayManager.this));
        }
        if (VideoFeedsPlayManager.a(VideoFeedsPlayManager.this)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared  return isOpenedVideo false");
      return;
      VideoFeedsPlayManager.a(VideoFeedsPlayManager.this, false);
      p(paramObject);
      d(parammyi);
    }
    
    public void a(myi parammyi, String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "onConnectQualityCallback json= " + paramString);
      }
      if (!VideoFeedsPlayManager.a(VideoFeedsPlayManager.this, parammyi)) {
        if (parammyi == VideoFeedsPlayManager.a(VideoFeedsPlayManager.this, VideoFeedsPlayManager.a(VideoFeedsPlayManager.this)))
        {
          VideoFeedsPlayManager.a(VideoFeedsPlayManager.this, paramString);
          mzz.a().a(parammyi, VideoFeedsPlayManager.a(VideoFeedsPlayManager.this).d.duration, parammyi.getFileSize());
        }
      }
      do
      {
        return;
        mzz.a().a(parammyi, VideoFeedsPlayManager.b(VideoFeedsPlayManager.this).d.duration, parammyi.getFileSize());
      } while ((VideoFeedsPlayManager.b(VideoFeedsPlayManager.this) == null) || (VideoFeedsPlayManager.b(VideoFeedsPlayManager.this).c == null));
      VideoFeedsPlayManager.b(VideoFeedsPlayManager.this).c.ahz = paramString;
    }
    
    /* Error */
    public boolean a(myi parammyi, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
    {
      // Byte code:
      //   0: new 31	java/lang/StringBuilder
      //   3: dup
      //   4: invokespecial 32	java/lang/StringBuilder:<init>	()V
      //   7: ldc 212
      //   9: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   12: iload_2
      //   13: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   16: ldc 217
      //   18: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   21: iload_3
      //   22: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   25: ldc 219
      //   27: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   30: iload 4
      //   32: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   35: ldc 221
      //   37: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   40: aload 5
      //   42: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   45: ldc 223
      //   47: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   50: astore 7
      //   52: aload 6
      //   54: ifnull +72 -> 126
      //   57: aload 6
      //   59: invokevirtual 226	java/lang/Object:toString	()Ljava/lang/String;
      //   62: astore 6
      //   64: aload 7
      //   66: aload 6
      //   68: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   71: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   74: astore 6
      //   76: aload_0
      //   77: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   80: aload_1
      //   81: invokestatic 119	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;Lmyi;)Z
      //   84: ifne +49 -> 133
      //   87: aload_0
      //   88: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   91: aload_0
      //   92: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   95: invokestatic 41	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   98: invokestatic 85	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;)Lmyi;
      //   101: aload_1
      //   102: if_acmpne +22 -> 124
      //   105: aload_1
      //   106: ifnull +18 -> 124
      //   109: aload_1
      //   110: invokevirtual 90	myi:stopDownload	()V
      //   113: aload_0
      //   114: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   117: invokestatic 41	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   120: iconst_0
      //   121: putfield 164	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:apw	Z
      //   124: iconst_0
      //   125: ireturn
      //   126: ldc 228
      //   128: astore 6
      //   130: goto -66 -> 64
      //   133: aload_0
      //   134: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   137: invokestatic 123	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   140: astore_1
      //   141: aload_1
      //   142: ifnull +57 -> 199
      //   145: aload_1
      //   146: getfield 47	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:d	Lcom/tencent/biz/pubaccount/VideoInfo;
      //   149: ifnull +50 -> 199
      //   152: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   155: ifeq +44 -> 199
      //   158: ldc 125
      //   160: iconst_2
      //   161: new 31	java/lang/StringBuilder
      //   164: dup
      //   165: invokespecial 32	java/lang/StringBuilder:<init>	()V
      //   168: ldc 230
      //   170: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   173: aload 6
      //   175: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   178: ldc 232
      //   180: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   183: aload_1
      //   184: getfield 47	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:d	Lcom/tencent/biz/pubaccount/VideoInfo;
      //   187: getfield 82	com/tencent/biz/pubaccount/VideoInfo:vid	Ljava/lang/String;
      //   190: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   193: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   196: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   199: iload_2
      //   200: bipush 123
      //   202: if_icmpne +98 -> 300
      //   205: iload_3
      //   206: bipush 103
      //   208: if_icmpne +83 -> 291
      //   211: aload_1
      //   212: ifnull +24 -> 236
      //   215: aload_1
      //   216: getfield 93	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:jdField_a_of_type_Msa	Lmsa;
      //   219: ifnull +17 -> 236
      //   222: aload_1
      //   223: getfield 93	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:jdField_a_of_type_Msa	Lmsa;
      //   226: aload_1
      //   227: iload_2
      //   228: iload_3
      //   229: ldc 228
      //   231: invokeinterface 235 5 0
      //   236: aload_0
      //   237: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   240: invokestatic 238	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Ljava/util/ArrayList;
      //   243: ifnull +95 -> 338
      //   246: aload_0
      //   247: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   250: invokestatic 238	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Ljava/util/ArrayList;
      //   253: invokevirtual 244	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   256: astore 6
      //   258: aload 6
      //   260: invokeinterface 249 1 0
      //   265: ifeq +73 -> 338
      //   268: aload 6
      //   270: invokeinterface 253 1 0
      //   275: checkcast 255	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$d
      //   278: aload_1
      //   279: iload_2
      //   280: iload_3
      //   281: ldc 228
      //   283: invokeinterface 256 5 0
      //   288: goto -30 -> 258
      //   291: iload_3
      //   292: bipush 108
      //   294: if_icmpne -83 -> 211
      //   297: goto -86 -> 211
      //   300: iload_2
      //   301: bipush 122
      //   303: if_icmpne +20 -> 323
      //   306: iload_3
      //   307: sipush 204
      //   310: if_icmpeq -99 -> 211
      //   313: iload_3
      //   314: sipush 202
      //   317: if_icmpne -106 -> 211
      //   320: goto -109 -> 211
      //   323: iload_2
      //   324: bipush 101
      //   326: if_icmpne -115 -> 211
      //   329: iload_3
      //   330: bipush 80
      //   332: if_icmpne -121 -> 211
      //   335: goto -124 -> 211
      //   338: aload_1
      //   339: ifnull +29 -> 368
      //   342: aload_1
      //   343: getfield 47	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:d	Lcom/tencent/biz/pubaccount/VideoInfo;
      //   346: ifnull +22 -> 368
      //   349: aload_1
      //   350: getfield 47	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:d	Lcom/tencent/biz/pubaccount/VideoInfo;
      //   353: getfield 259	com/tencent/biz/pubaccount/VideoInfo:Wz	Ljava/lang/String;
      //   356: aload_1
      //   357: getfield 47	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:d	Lcom/tencent/biz/pubaccount/VideoInfo;
      //   360: getfield 82	com/tencent/biz/pubaccount/VideoInfo:vid	Ljava/lang/String;
      //   363: iconst_1
      //   364: iload_3
      //   365: invokestatic 265	ocp:e	(Ljava/lang/String;Ljava/lang/String;II)V
      //   368: aload_1
      //   369: ifnull +58 -> 427
      //   372: aload_1
      //   373: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   376: ifnull +51 -> 427
      //   379: aload_1
      //   380: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   383: iconst_0
      //   384: putfield 148	mhu:success	Z
      //   387: aload_1
      //   388: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   391: new 31	java/lang/StringBuilder
      //   394: dup
      //   395: invokespecial 32	java/lang/StringBuilder:<init>	()V
      //   398: iload_2
      //   399: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   402: ldc_w 267
      //   405: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   408: iload_3
      //   409: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   412: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   415: putfield 270	mhu:errCode	Ljava/lang/String;
      //   418: aload_1
      //   419: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   422: aload 5
      //   424: putfield 273	mhu:errDetailInfo	Ljava/lang/String;
      //   427: aload_0
      //   428: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   431: invokestatic 275	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:d	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Z
      //   434: ifeq +138 -> 572
      //   437: aload_0
      //   438: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   441: invokestatic 278	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lmyi;
      //   444: ifnull +128 -> 572
      //   447: aload_0
      //   448: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   451: invokestatic 123	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   454: getfield 47	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:d	Lcom/tencent/biz/pubaccount/VideoInfo;
      //   457: getfield 281	com/tencent/biz/pubaccount/VideoInfo:b	Lcom/tencent/biz/pubaccount/VideoAdInfo;
      //   460: invokestatic 286	jzk:a	(Lcom/tencent/biz/pubaccount/VideoAdInfo;)Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
      //   463: astore 5
      //   465: aload_0
      //   466: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   469: invokestatic 123	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   472: invokestatic 291	knd:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;)Z
      //   475: ifeq +99 -> 574
      //   478: bipush 20
      //   480: istore_2
      //   481: iconst_0
      //   482: iconst_0
      //   483: iconst_0
      //   484: iconst_0
      //   485: iload_2
      //   486: iconst_0
      //   487: iconst_0
      //   488: getstatic 294	jzk:aGr	I
      //   491: iconst_2
      //   492: invokestatic 297	jzk:a	(IIIIIIIII)Lorg/json/JSONObject;
      //   495: astore 6
      //   497: new 299	kku$a
      //   500: dup
      //   501: invokespecial 300	kku$a:<init>	()V
      //   504: aload_0
      //   505: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   508: invokestatic 303	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Landroid/content/Context;
      //   511: invokevirtual 306	kku$a:a	(Landroid/content/Context;)Lkku$a;
      //   514: getstatic 309	jzk:aEO	I
      //   517: invokevirtual 312	kku$a:a	(I)Lkku$a;
      //   520: aload_1
      //   521: getfield 315	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:jdField_a_of_type_Mht	Lmht;
      //   524: getfield 320	mht:aSn	I
      //   527: invokevirtual 322	kku$a:b	(I)Lkku$a;
      //   530: aload 5
      //   532: invokevirtual 325	kku$a:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Lkku$a;
      //   535: aload_0
      //   536: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   539: invokestatic 123	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   542: getfield 47	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:d	Lcom/tencent/biz/pubaccount/VideoInfo;
      //   545: getfield 281	com/tencent/biz/pubaccount/VideoInfo:b	Lcom/tencent/biz/pubaccount/VideoAdInfo;
      //   548: invokevirtual 328	kku$a:a	(Lcom/tencent/biz/pubaccount/VideoAdInfo;)Lkku$a;
      //   551: aload 6
      //   553: invokevirtual 331	kku$a:a	(Lorg/json/JSONObject;)Lkku$a;
      //   556: invokevirtual 334	kku$a:a	()Lkku;
      //   559: invokestatic 337	jzk:a	(Lkku;)V
      //   562: aload_0
      //   563: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   566: invokestatic 123	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   569: invokestatic 339	knd:e	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;)V
      //   572: iconst_0
      //   573: ireturn
      //   574: iconst_0
      //   575: istore_2
      //   576: goto -95 -> 481
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	579	0	this	a
      //   0	579	1	parammyi	myi
      //   0	579	2	paramInt1	int
      //   0	579	3	paramInt2	int
      //   0	579	4	paramInt3	int
      //   0	579	5	paramString	String
      //   0	579	6	paramObject	Object
      //   50	15	7	localStringBuilder	StringBuilder
    }
    
    /* Error */
    public boolean a(myi parammyi, int paramInt, Object paramObject)
    {
      // Byte code:
      //   0: iload_2
      //   1: bipush 42
      //   3: if_icmpeq +16 -> 19
      //   6: aload_0
      //   7: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   10: aload_1
      //   11: invokestatic 119	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;Lmyi;)Z
      //   14: ifne +5 -> 19
      //   17: iconst_0
      //   18: ireturn
      //   19: aload_0
      //   20: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   23: invokestatic 123	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   26: astore 5
      //   28: iload_2
      //   29: lookupswitch	default:+75->104, 28:+77->106, 39:+707->736, 40:+536->565, 41:+765->794, 42:+804->833, 112:+123->152, 113:+310->339, 208:+987->1016
      //   105: ireturn
      //   106: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   109: ifeq +12 -> 121
      //   112: ldc 125
      //   114: iconst_2
      //   115: ldc_w 344
      //   118: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   121: aload 5
      //   123: ifnull -106 -> 17
      //   126: aload 5
      //   128: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   131: ifnull -114 -> 17
      //   134: aload 5
      //   136: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   139: astore_1
      //   140: aload_1
      //   141: aload_1
      //   142: getfield 347	mhu:aSt	I
      //   145: iconst_1
      //   146: iadd
      //   147: putfield 347	mhu:aSt	I
      //   150: iconst_0
      //   151: ireturn
      //   152: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   155: ifeq +12 -> 167
      //   158: ldc 125
      //   160: iconst_2
      //   161: ldc_w 349
      //   164: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   167: aload 5
      //   169: ifnull +23 -> 192
      //   172: aload 5
      //   174: getfield 93	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:jdField_a_of_type_Msa	Lmsa;
      //   177: ifnull +15 -> 192
      //   180: aload 5
      //   182: getfield 93	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:jdField_a_of_type_Msa	Lmsa;
      //   185: aload 5
      //   187: invokeinterface 352 2 0
      //   192: aload 5
      //   194: ifnull +57 -> 251
      //   197: aload_0
      //   198: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   201: invokestatic 238	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Ljava/util/ArrayList;
      //   204: ifnull +47 -> 251
      //   207: aload_0
      //   208: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   211: invokestatic 238	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Ljava/util/ArrayList;
      //   214: invokevirtual 244	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   217: astore_1
      //   218: aload_1
      //   219: invokeinterface 249 1 0
      //   224: ifeq +27 -> 251
      //   227: aload_1
      //   228: invokeinterface 253 1 0
      //   233: checkcast 255	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$d
      //   236: aload_0
      //   237: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   240: invokestatic 123	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   243: invokeinterface 353 2 0
      //   248: goto -30 -> 218
      //   251: aload 5
      //   253: ifnull +22 -> 275
      //   256: aload 5
      //   258: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   261: ifnull +14 -> 275
      //   264: aload 5
      //   266: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   269: invokestatic 358	android/os/SystemClock:uptimeMillis	()J
      //   272: putfield 362	mhu:vu	J
      //   275: aload_0
      //   276: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   279: invokestatic 41	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   282: ifnull -265 -> 17
      //   285: aload_0
      //   286: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   289: invokestatic 41	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   292: getfield 164	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:apw	Z
      //   295: ifeq -278 -> 17
      //   298: aload_0
      //   299: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   302: aload_0
      //   303: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   306: invokestatic 41	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   309: invokestatic 85	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;)Lmyi;
      //   312: astore_1
      //   313: aload_1
      //   314: ifnull -297 -> 17
      //   317: aload_1
      //   318: invokevirtual 365	myi:isReady	()Z
      //   321: ifne -304 -> 17
      //   324: aload_0
      //   325: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   328: invokestatic 41	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   331: getfield 368	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:e	Lmyi;
      //   334: invokevirtual 90	myi:stopDownload	()V
      //   337: iconst_0
      //   338: ireturn
      //   339: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   342: ifeq +12 -> 354
      //   345: ldc 125
      //   347: iconst_2
      //   348: ldc_w 370
      //   351: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   354: aload 5
      //   356: ifnull +23 -> 379
      //   359: aload 5
      //   361: getfield 93	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:jdField_a_of_type_Msa	Lmsa;
      //   364: ifnull +15 -> 379
      //   367: aload 5
      //   369: getfield 93	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:jdField_a_of_type_Msa	Lmsa;
      //   372: aload 5
      //   374: invokeinterface 373 2 0
      //   379: aload 5
      //   381: ifnull +64 -> 445
      //   384: aload_0
      //   385: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   388: invokestatic 238	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Ljava/util/ArrayList;
      //   391: ifnull +54 -> 445
      //   394: aload_0
      //   395: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   398: invokestatic 238	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Ljava/util/ArrayList;
      //   401: invokevirtual 244	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   404: astore_1
      //   405: aload_1
      //   406: invokeinterface 249 1 0
      //   411: ifeq +34 -> 445
      //   414: aload_1
      //   415: invokeinterface 253 1 0
      //   420: checkcast 255	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$d
      //   423: aload_0
      //   424: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   427: invokestatic 123	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   430: aload_0
      //   431: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   434: invokevirtual 376	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:EF	()Z
      //   437: invokeinterface 379 3 0
      //   442: goto -37 -> 405
      //   445: aload 5
      //   447: ifnull +54 -> 501
      //   450: aload 5
      //   452: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   455: ifnull +46 -> 501
      //   458: aload 5
      //   460: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   463: astore_1
      //   464: aload_1
      //   465: aload_1
      //   466: getfield 382	mhu:vv	J
      //   469: invokestatic 358	android/os/SystemClock:uptimeMillis	()J
      //   472: aload 5
      //   474: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   477: getfield 362	mhu:vu	J
      //   480: lsub
      //   481: ladd
      //   482: putfield 382	mhu:vv	J
      //   485: aload 5
      //   487: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   490: astore_1
      //   491: aload_1
      //   492: aload_1
      //   493: getfield 385	mhu:bufferCount	I
      //   496: iconst_1
      //   497: iadd
      //   498: putfield 385	mhu:bufferCount	I
      //   501: aload_0
      //   502: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   505: invokestatic 41	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   508: ifnull -491 -> 17
      //   511: aload_0
      //   512: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   515: invokestatic 41	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   518: getfield 164	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:apw	Z
      //   521: ifeq -504 -> 17
      //   524: aload_0
      //   525: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   528: aload_0
      //   529: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   532: invokestatic 41	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   535: invokestatic 85	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;)Lmyi;
      //   538: astore_1
      //   539: aload_1
      //   540: ifnull -523 -> 17
      //   543: aload_1
      //   544: invokevirtual 365	myi:isReady	()Z
      //   547: ifne -530 -> 17
      //   550: aload_0
      //   551: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   554: invokestatic 41	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   557: getfield 368	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:e	Lmyi;
      //   560: invokevirtual 388	myi:resumeDownload	()V
      //   563: iconst_0
      //   564: ireturn
      //   565: new 390	org/json/JSONObject
      //   568: dup
      //   569: aload_3
      //   570: checkcast 392	java/lang/String
      //   573: invokespecial 395	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   576: astore_1
      //   577: aload_1
      //   578: ldc_w 397
      //   581: iconst_0
      //   582: invokevirtual 401	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
      //   585: istore_2
      //   586: aload_1
      //   587: ldc_w 403
      //   590: iconst_1
      //   591: invokevirtual 401	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
      //   594: istore 4
      //   596: aload 5
      //   598: ifnull -581 -> 17
      //   601: aload 5
      //   603: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   606: ifnull -589 -> 17
      //   609: iload 4
      //   611: ifle +20 -> 631
      //   614: aload 5
      //   616: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   619: astore_1
      //   620: aload_1
      //   621: aload_1
      //   622: getfield 406	mhu:skipFramesTotalCount	I
      //   625: iload 4
      //   627: iadd
      //   628: putfield 406	mhu:skipFramesTotalCount	I
      //   631: aload 5
      //   633: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   636: astore_1
      //   637: aload_1
      //   638: aload_1
      //   639: getfield 409	mhu:aSu	I
      //   642: iload 4
      //   644: iadd
      //   645: putfield 409	mhu:aSu	I
      //   648: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   651: ifeq -634 -> 17
      //   654: ldc 125
      //   656: iconst_2
      //   657: new 31	java/lang/StringBuilder
      //   660: dup
      //   661: invokespecial 32	java/lang/StringBuilder:<init>	()V
      //   664: ldc_w 411
      //   667: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   670: iload_2
      //   671: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   674: ldc_w 413
      //   677: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   680: iload 4
      //   682: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   685: ldc_w 415
      //   688: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   691: aload 5
      //   693: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   696: getfield 406	mhu:skipFramesTotalCount	I
      //   699: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   702: ldc_w 417
      //   705: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   708: aload 5
      //   710: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   713: getfield 409	mhu:aSu	I
      //   716: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   719: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   722: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   725: iconst_0
      //   726: ireturn
      //   727: astore_1
      //   728: iconst_0
      //   729: istore_2
      //   730: iconst_0
      //   731: istore 4
      //   733: goto -137 -> 596
      //   736: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   739: ifeq +12 -> 751
      //   742: ldc 125
      //   744: iconst_2
      //   745: ldc_w 419
      //   748: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   751: aload 5
      //   753: ifnull -736 -> 17
      //   756: aload 5
      //   758: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   761: ifnull -744 -> 17
      //   764: aload 5
      //   766: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   769: iconst_1
      //   770: putfield 422	mhu:amE	Z
      //   773: aload_3
      //   774: instanceof 392
      //   777: ifeq -760 -> 17
      //   780: aload 5
      //   782: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   785: aload_3
      //   786: checkcast 392	java/lang/String
      //   789: putfield 425	mhu:ahy	Ljava/lang/String;
      //   792: iconst_0
      //   793: ireturn
      //   794: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   797: ifeq +12 -> 809
      //   800: ldc 125
      //   802: iconst_2
      //   803: ldc_w 427
      //   806: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   809: aload 5
      //   811: ifnull -794 -> 17
      //   814: aload 5
      //   816: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   819: ifnull -802 -> 17
      //   822: aload 5
      //   824: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   827: iconst_1
      //   828: putfield 430	mhu:amF	Z
      //   831: iconst_0
      //   832: ireturn
      //   833: aload_1
      //   834: ifnull -817 -> 17
      //   837: aload_0
      //   838: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   841: invokestatic 123	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   844: ifnull +132 -> 976
      //   847: aload_1
      //   848: aload_0
      //   849: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   852: invokestatic 123	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   855: getfield 368	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:e	Lmyi;
      //   858: if_acmpne +118 -> 976
      //   861: aload_0
      //   862: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   865: invokestatic 123	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   868: astore_1
      //   869: aload_3
      //   870: ifnull -853 -> 17
      //   873: aload_3
      //   874: checkcast 392	java/lang/String
      //   877: ldc_w 267
      //   880: iconst_2
      //   881: invokevirtual 434	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
      //   884: astore_3
      //   885: aload_3
      //   886: ifnull -869 -> 17
      //   889: aload_3
      //   890: arraylength
      //   891: iconst_2
      //   892: if_icmpne -875 -> 17
      //   895: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   898: ifeq +43 -> 941
      //   901: ldc 125
      //   903: iconst_2
      //   904: new 31	java/lang/StringBuilder
      //   907: dup
      //   908: invokespecial 32	java/lang/StringBuilder:<init>	()V
      //   911: ldc_w 436
      //   914: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   917: aload_3
      //   918: iconst_0
      //   919: aaload
      //   920: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   923: ldc_w 438
      //   926: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   929: aload_3
      //   930: iconst_1
      //   931: aaload
      //   932: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   935: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   938: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   941: ldc_w 440
      //   944: aload_3
      //   945: iconst_0
      //   946: aaload
      //   947: invokevirtual 444	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   950: ifeq -933 -> 17
      //   953: aload_1
      //   954: ifnull -937 -> 17
      //   957: aload_1
      //   958: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   961: ifnull -944 -> 17
      //   964: aload_1
      //   965: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   968: aload_3
      //   969: iconst_1
      //   970: aaload
      //   971: putfield 447	mhu:ahC	Ljava/lang/String;
      //   974: iconst_0
      //   975: ireturn
      //   976: aload_0
      //   977: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   980: invokestatic 41	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   983: ifnull +28 -> 1011
      //   986: aload_1
      //   987: aload_0
      //   988: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   991: invokestatic 41	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   994: getfield 368	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:e	Lmyi;
      //   997: if_acmpne +14 -> 1011
      //   1000: aload_0
      //   1001: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   1004: invokestatic 41	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   1007: astore_1
      //   1008: goto -139 -> 869
      //   1011: aconst_null
      //   1012: astore_1
      //   1013: goto -144 -> 869
      //   1016: aload_0
      //   1017: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   1020: invokestatic 123	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   1023: ifnull -1006 -> 17
      //   1026: aload_0
      //   1027: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   1030: invokestatic 123	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   1033: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   1036: ifnull -1019 -> 17
      //   1039: getstatic 452	mrs:a	Lmrs$a;
      //   1042: aload_3
      //   1043: aload_0
      //   1044: getfield 13	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;
      //   1047: invokestatic 123	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   1050: getfield 142	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:c	Lmhu;
      //   1053: invokevirtual 457	mrs$a:a	(Ljava/lang/Object;Lmhu;)V
      //   1056: iconst_0
      //   1057: ireturn
      //   1058: astore_1
      //   1059: goto -329 -> 730
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1062	0	this	a
      //   0	1062	1	parammyi	myi
      //   0	1062	2	paramInt	int
      //   0	1062	3	paramObject	Object
      //   594	138	4	i	int
      //   26	797	5	localb	VideoFeedsPlayManager.b
      // Exception table:
      //   from	to	target	type
      //   565	586	727	java/lang/Exception
      //   586	596	1058	java/lang/Exception
    }
    
    public void b(myi parammyi)
    {
      VideoFeedsPlayManager.a(VideoFeedsPlayManager.this).sendEmptyMessageDelayed(-2, 500L);
    }
    
    public void d(myi parammyi)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "startVideoAfterPrepared(VideoPlayerWrapper player) mIsActivityOnResume=" + VideoFeedsPlayManager.c(VideoFeedsPlayManager.this));
      }
      VideoFeedsPlayManager.a(VideoFeedsPlayManager.this).removeMessages(-3);
      if (VideoFeedsPlayManager.c(VideoFeedsPlayManager.this))
      {
        VideoFeedsPlayManager.this.start();
        return;
      }
      VideoFeedsPlayManager.b(VideoFeedsPlayManager.this, true);
    }
    
    public void p(VideoFeedsPlayManager.b paramb)
    {
      if ((paramb == null) || (paramb.c == null) || (paramb.c.vt != 0L)) {
        return;
      }
      paramb.c.vt = (SystemClock.uptimeMillis() - paramb.c.vs);
      Object localObject = paramb.c;
      ((mhu)localObject).vv += paramb.c.vt;
      localObject = paramb.c;
      ((mhu)localObject).bufferCount += 1;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doReportOnVideoPrepared: vid=").append(paramb.d.vid).append(", 预加载状态：").append(paramb.c.aSs).append(", 预下载命中：").append(VideoFeedsPlayManager.a(VideoFeedsPlayManager.this, paramb).aqr).append(", 首帧耗时：").append(paramb.c.vt);
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, ((StringBuilder)localObject).toString());
      }
      ThreadManager.excute(new VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.3(this, paramb), 16, null, true);
    }
  }
  
  public static class b
  {
    public mht a;
    public msa a;
    public int aVm = 0;
    public int aVn;
    public boolean apw;
    public boolean apx;
    public mhu c;
    public VideoInfo d;
    public myi e;
    public Bundle extraData = new Bundle();
    public long startPosition;
    public ViewGroup videoLayout;
    public View videoView;
    
    public void aj(String paramString, boolean paramBoolean)
    {
      try
      {
        this.extraData.putBoolean(paramString, paramBoolean);
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    
    public boolean o(String paramString, boolean paramBoolean)
    {
      try
      {
        paramBoolean = this.extraData.getBoolean(paramString, paramBoolean);
        return paramBoolean;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void onProgressChanged(long paramLong);
  }
  
  public static abstract interface d
  {
    public abstract void a(VideoFeedsPlayManager.b paramb);
    
    public abstract void a(VideoFeedsPlayManager.b paramb, int paramInt);
    
    public abstract void a(VideoFeedsPlayManager.b paramb, int paramInt1, int paramInt2, String paramString);
    
    public abstract void b(VideoFeedsPlayManager.b paramb);
    
    public abstract void d(VideoFeedsPlayManager.b paramb);
    
    public abstract void g(VideoFeedsPlayManager.b paramb, boolean paramBoolean);
    
    public abstract void h(VideoFeedsPlayManager.b paramb, boolean paramBoolean);
    
    public abstract void i(VideoFeedsPlayManager.b paramb);
    
    public abstract void q(VideoFeedsPlayManager.b paramb);
    
    public abstract void r(VideoFeedsPlayManager.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager
 * JD-Core Version:    0.7.0.1
 */