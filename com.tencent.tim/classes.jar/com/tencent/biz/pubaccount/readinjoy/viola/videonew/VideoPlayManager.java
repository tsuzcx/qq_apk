package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kxm;
import kxv;
import mqq.app.AppRuntime;
import msc;
import myi;
import myj;
import myj.a;
import mzz;
import nbr;
import nwq;
import nwr;
import nws;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoPlayManager
  implements myj.a
{
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$a = new a(null);
  private b jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$b = new b(this);
  private c jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c;
  private myj jdField_a_of_type_Myj;
  private int aXf = 1000;
  private boolean anW = true;
  private boolean apk;
  private boolean apr;
  private boolean aps;
  private boolean apt;
  private boolean apu;
  private Set<myi> at = new ArraySet();
  private List<d> jL;
  private Context mContext;
  
  public VideoPlayManager(Context paramContext)
  {
    this.mContext = paramContext;
    this.jdField_a_of_type_Myj = new myj();
    this.jdField_a_of_type_Myj.a(this);
    this.jL = new ArrayList();
  }
  
  private myi a(c paramc)
  {
    Object localObject;
    if (this.mContext == null) {
      localObject = null;
    }
    myi localmyi;
    do
    {
      do
      {
        return localObject;
        localmyi = new myi(this.mContext.getApplicationContext());
        localmyi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$a);
        localObject = localmyi;
      } while (paramc == null);
      localObject = localmyi;
    } while (!paramc.avf);
    localmyi.oP(true);
    return localmyi;
  }
  
  private void c(myi parammyi)
  {
    if (parammyi == null) {}
    do
    {
      return;
      parammyi.setTag(null);
      parammyi.aTU();
    } while (parammyi.isReusable());
    parammyi.stopDownload();
    ThreadManager.excute(new VideoPlayManager.2(this, parammyi), 64, null, false);
  }
  
  private void d(c paramc)
  {
    if (c.b(paramc) == null)
    {
      ThreadManager.post(new VideoPlayManager.1(this, paramc), 5, null, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo hit cache");
    }
    c.b(paramc).setTag(paramc.b);
    e(paramc);
  }
  
  private void e(c paramc)
  {
    if ((paramc == null) || (c.b(paramc) == null)) {
      return;
    }
    paramc.videoLayout.setKeepScreenOn(true);
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
    }
    if (paramc.a == null)
    {
      c.b(paramc).t(paramc.videoLayout);
      Object localObject = c.b(paramc).b();
      if ((localObject == null) || (((nbr)localObject).am() == null))
      {
        localObject = this.jL.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((d)((Iterator)localObject).next()).a(paramc, 123, 99, null);
        }
        c.a(paramc, null);
        return;
      }
      paramc.a = ((nbr)localObject);
      ((nbr)localObject).am().setId(2131376720);
      localObject = this.jL.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((d)((Iterator)localObject).next()).g(paramc);
      }
    }
    c.b(paramc).setXYaxis(paramc.aVm);
    c.b(paramc).setLoopback(this.apu);
    c.b(paramc).setMute(paramc.muted);
    paramc.a.am().setVisibility(0);
    ThreadManager.excute(new PlayStartVideoRunnable(paramc), 64, null, true);
  }
  
  public boolean Gl()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c != null) && (c.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c) != null);
  }
  
  public c a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c;
  }
  
  public void a(d paramd)
  {
    this.jL.add(paramd);
  }
  
  public void b(c paramc)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c = paramc;
    paramc = this.jL.iterator();
    while (paramc.hasNext()) {
      ((d)paramc.next()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c, false);
    }
  }
  
  public void c(c paramc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager playVideo");
    }
    Iterator localIterator;
    if ((paramc != null) && (paramc.b != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo() vid=" + paramc.b.vid);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo: playerParam=" + paramc);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c = paramc;
      localIterator = this.jL.iterator();
    }
    while (localIterator.hasNext())
    {
      ((d)localIterator.next()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c, true);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo() error, playerParam or videoInfo is null");
      }
      return;
    }
    if ((this.jdField_a_of_type_Myj != null) && (!this.jdField_a_of_type_Myj.EU()))
    {
      this.jdField_a_of_type_Myj.installPlugin();
      return;
    }
    d(paramc);
  }
  
  public void f(c paramc)
  {
    if (paramc != null) {
      c(c.b(paramc));
    }
  }
  
  public long getCurrentPosition()
  {
    if (Gl()) {
      return c.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c).dc();
    }
    return 0L;
  }
  
  public int getCurrentState()
  {
    if (Gl()) {
      return c.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c).qe();
    }
    return -1;
  }
  
  public long getDuration()
  {
    if (Gl()) {
      return c.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c).getDuration();
    }
    return 0L;
  }
  
  public boolean isPause()
  {
    return (Gl()) && (c.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c).isPause());
  }
  
  public boolean isPlaying()
  {
    return (Gl()) && (c.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c).isPlaying());
  }
  
  public boolean isReady()
  {
    return (Gl()) && (c.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c).isReady());
  }
  
  public void ns(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c != null) {
        d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c);
      }
      return;
    }
    Iterator localIterator = this.jL.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c, 123, 99, null);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c = null;
  }
  
  public void onDestroy()
  {
    this.apk = true;
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "doOnDestory: ");
    }
    this.apk = true;
    stop();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c != null)
    {
      if (c.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c) != null)
      {
        c.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c).destory();
        c.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c, null);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c = null;
    }
    if (this.at != null)
    {
      Iterator localIterator = this.at.iterator();
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$b.removeCallbacksAndMessages(null);
    this.jL.clear();
    this.mContext = null;
  }
  
  public void onPause()
  {
    this.anW = false;
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "doOnPause() isPlaying()=" + isPlaying());
    }
    if (isPlaying())
    {
      this.apr = true;
      this.aps = false;
      pause();
    }
  }
  
  public void onResume()
  {
    this.anW = true;
    if ((this.apt) && (isReady())) {
      start();
    }
    label84:
    for (;;)
    {
      this.apr = false;
      this.apt = false;
      return;
      if (this.apr)
      {
        AppRuntime localAppRuntime = kxm.getAppRuntime();
        if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {}
        for (boolean bool = ((QQAppInterface)localAppRuntime).bF();; bool = false)
        {
          if (bool) {
            break label84;
          }
          this.aps = true;
          restart(2);
          break;
        }
      }
    }
  }
  
  public void pause()
  {
    pause(2);
  }
  
  public void pause(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c != null) && (c.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c) != null) && (isPlaying()))
    {
      c.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c).pause();
      Iterator localIterator = this.jL.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c, paramInt);
      }
    }
  }
  
  public void restart(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c != null) && (c.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c) != null) && ((isPause()) || (isReady())))
    {
      c.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c).restart();
      Iterator localIterator = this.jL.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c, paramInt);
      }
    }
  }
  
  public void seekTo(int paramInt)
  {
    if (Gl()) {
      c.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c).seekTo(paramInt);
    }
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    this.apu = paramBoolean;
    if (Gl()) {
      c.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c).setLoopback(paramBoolean);
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    if (Gl()) {
      c.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c).setMute(paramBoolean);
    }
  }
  
  public void setXYaxis(int paramInt)
  {
    if (Gl()) {
      c.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c).setXYaxis(paramInt);
    }
  }
  
  public void start()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c != null) && (c.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c) != null))
    {
      c.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c).start();
      Iterator localIterator = this.jL.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
      }
    }
  }
  
  public void stop()
  {
    if (Gl())
    {
      c(c.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c));
      Iterator localIterator = this.jL.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).j(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c.videoLayout.setKeepScreenOn(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$c = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$b.removeMessages(0);
  }
  
  public void ti(int paramInt)
  {
    this.aXf = paramInt;
  }
  
  public class PlayStartVideoRunnable
    implements Runnable
  {
    private VideoPlayManager.c c;
    private myi i;
    private int startPosition;
    
    public PlayStartVideoRunnable(VideoPlayManager.c paramc)
    {
      this.c = paramc;
      this.i = VideoPlayManager.c.b(paramc);
      this.startPosition = paramc.startPosition;
    }
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo post thread");
      }
      if ((this.c == null) || (this.i == null) || (VideoPlayManager.c(VideoPlayManager.this))) {}
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              VideoPlayManager.a(VideoPlayManager.this, true);
              if (this.c.b.busiType != 0) {
                break;
              }
            } while (TextUtils.isEmpty(this.c.b.videoUrl));
            this.i.a("", this.c.b.videoUrl, 101, this.startPosition, 0L, this.c.b.duration);
            return;
            if ((this.c.b.busiType == 1) || (this.c.b.busiType == 3) || (this.c.b.busiType == 7))
            {
              this.i.e(this.c.b.vid, 1, this.startPosition);
              return;
            }
            if ((this.c.b.busiType != 2) && ((this.c.b.busiType != 6) || (TextUtils.isEmpty(this.c.b.vid)))) {
              break;
            }
          } while (this.c.b.vid == null);
          kxv.a().a(this.c.b.vid, "PubAccountArticleCenter.GetUrlByVid", new nwr(this));
          return;
          if (this.c.b.busiType != 5) {
            break;
          }
        } while (this.c.b.vid == null);
        this.i.a("", this.c.b.vid, 101, this.startPosition, 0L, this.c.b.duration, false);
        return;
      } while ((this.c.b.busiType != 6) || (TextUtils.isEmpty(this.c.b.videoUrl)));
      this.i.a("", this.c.b.videoUrl, 101, this.startPosition, 0L, this.c.b.duration);
    }
  }
  
  public class a
    extends msc
  {
    private a() {}
    
    public void a(myi parammyi)
    {
      VideoPlayManager.c localc = VideoPlayManager.a(VideoPlayManager.this);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("播放状态回调 onCompletion() vid=");
        if (localc == null) {
          break label93;
        }
      }
      label93:
      for (parammyi = localc.b.vid;; parammyi = "param null")
      {
        QLog.d("Viola.VideoPlayManager", 2, parammyi);
        parammyi = VideoPlayManager.a(VideoPlayManager.this).iterator();
        while (parammyi.hasNext()) {
          ((VideoPlayManager.d)parammyi.next()).m(localc);
        }
      }
    }
    
    public void a(myi parammyi, Object paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
      }
      parammyi = VideoPlayManager.a(VideoPlayManager.this);
      if ((parammyi != null) && (QLog.isColorLevel())) {
        QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onVideoPrepared() vid=" + parammyi.b.vid + ", mIsOpenedVideo = " + VideoPlayManager.a(VideoPlayManager.this));
      }
      if (!VideoPlayManager.a(VideoPlayManager.this))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Viola.VideoPlayManager", 2, "onVideoPrepared  return isOpenedVideo false");
        }
        return;
      }
      VideoPlayManager.a(VideoPlayManager.this, false);
      VideoPlayManager.a(VideoPlayManager.this).removeMessages(0);
      VideoPlayManager.a(VideoPlayManager.this).sendEmptyMessage(0);
      paramObject = VideoPlayManager.a(VideoPlayManager.this).iterator();
      while (paramObject.hasNext()) {
        ((VideoPlayManager.d)paramObject.next()).h(parammyi);
      }
      if (VideoPlayManager.b(VideoPlayManager.this))
      {
        VideoPlayManager.this.start();
        return;
      }
      VideoPlayManager.b(VideoPlayManager.this, true);
    }
    
    public void a(myi parammyi, String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "onConnectQualityCallback json= " + paramString);
      }
      if (VideoPlayManager.a(VideoPlayManager.this) != null) {
        mzz.a().a(parammyi, VideoPlayManager.a(VideoPlayManager.this).b.duration, parammyi.getFileSize());
      }
    }
    
    /* Error */
    public boolean a(myi parammyi, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
    {
      // Byte code:
      //   0: new 32	java/lang/StringBuilder
      //   3: dup
      //   4: invokespecial 33	java/lang/StringBuilder:<init>	()V
      //   7: ldc 152
      //   9: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   12: iload_2
      //   13: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   16: ldc 157
      //   18: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   21: iload_3
      //   22: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   25: ldc 159
      //   27: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   30: iload 4
      //   32: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   35: ldc 161
      //   37: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   40: aload 5
      //   42: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   45: ldc 163
      //   47: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   50: astore 5
      //   52: aload 6
      //   54: ifnull +145 -> 199
      //   57: aload 6
      //   59: invokevirtual 166	java/lang/Object:toString	()Ljava/lang/String;
      //   62: astore_1
      //   63: aload 5
      //   65: aload_1
      //   66: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   69: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   72: astore 5
      //   74: aload_0
      //   75: getfield 13	com/tencent/biz/pubaccount/readinjoy/viola/videonew/VideoPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/VideoPlayManager;
      //   78: invokestatic 24	com/tencent/biz/pubaccount/readinjoy/viola/videonew/VideoPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/VideoPlayManager;)Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/VideoPlayManager$c;
      //   81: astore_1
      //   82: aload_1
      //   83: ifnull +57 -> 140
      //   86: aload_1
      //   87: getfield 45	com/tencent/biz/pubaccount/readinjoy/viola/videonew/VideoPlayManager$c:b	Lnwq;
      //   90: ifnull +50 -> 140
      //   93: invokestatic 30	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   96: ifeq +44 -> 140
      //   99: ldc 53
      //   101: iconst_2
      //   102: new 32	java/lang/StringBuilder
      //   105: dup
      //   106: invokespecial 33	java/lang/StringBuilder:<init>	()V
      //   109: ldc 168
      //   111: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   114: aload 5
      //   116: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   119: ldc 170
      //   121: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   124: aload_1
      //   125: getfield 45	com/tencent/biz/pubaccount/readinjoy/viola/videonew/VideoPlayManager$c:b	Lnwq;
      //   128: getfield 51	nwq:vid	Ljava/lang/String;
      //   131: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   134: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   137: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   140: iload_2
      //   141: bipush 123
      //   143: if_icmpne +62 -> 205
      //   146: iload_3
      //   147: bipush 103
      //   149: if_icmpne +3 -> 152
      //   152: aload_0
      //   153: getfield 13	com/tencent/biz/pubaccount/readinjoy/viola/videonew/VideoPlayManager$a:this$0	Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/VideoPlayManager;
      //   156: invokestatic 64	com/tencent/biz/pubaccount/readinjoy/viola/videonew/VideoPlayManager:a	(Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/VideoPlayManager;)Ljava/util/List;
      //   159: invokeinterface 70 1 0
      //   164: astore 5
      //   166: aload 5
      //   168: invokeinterface 75 1 0
      //   173: ifeq +70 -> 243
      //   176: aload 5
      //   178: invokeinterface 79 1 0
      //   183: checkcast 81	com/tencent/biz/pubaccount/readinjoy/viola/videonew/VideoPlayManager$d
      //   186: aload_1
      //   187: iload_2
      //   188: iload_3
      //   189: ldc 172
      //   191: invokeinterface 175 5 0
      //   196: goto -30 -> 166
      //   199: ldc 172
      //   201: astore_1
      //   202: goto -139 -> 63
      //   205: iload_2
      //   206: bipush 122
      //   208: if_icmpne +20 -> 228
      //   211: iload_3
      //   212: sipush 204
      //   215: if_icmpeq -63 -> 152
      //   218: iload_3
      //   219: sipush 202
      //   222: if_icmpne -70 -> 152
      //   225: goto -73 -> 152
      //   228: iload_2
      //   229: bipush 101
      //   231: if_icmpne -79 -> 152
      //   234: iload_3
      //   235: bipush 80
      //   237: if_icmpne -85 -> 152
      //   240: goto -88 -> 152
      //   243: iconst_0
      //   244: ireturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	245	0	this	a
      //   0	245	1	parammyi	myi
      //   0	245	2	paramInt1	int
      //   0	245	3	paramInt2	int
      //   0	245	4	paramInt3	int
      //   0	245	5	paramString	String
      //   0	245	6	paramObject	Object
    }
    
    public boolean a(myi parammyi, int paramInt, Object paramObject)
    {
      parammyi = VideoPlayManager.a(VideoPlayManager.this);
      switch (paramInt)
      {
      }
      for (;;)
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
        }
        paramObject = VideoPlayManager.a(VideoPlayManager.this).iterator();
        while (paramObject.hasNext()) {
          ((VideoPlayManager.d)paramObject.next()).k(parammyi);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
        }
        paramObject = VideoPlayManager.a(VideoPlayManager.this).iterator();
        while (paramObject.hasNext()) {
          ((VideoPlayManager.d)paramObject.next()).l(parammyi);
        }
      }
    }
  }
  
  static class b
    extends Handler
  {
    private WeakReference<VideoPlayManager> weakReference;
    
    public b(VideoPlayManager paramVideoPlayManager)
    {
      this.weakReference = new WeakReference(paramVideoPlayManager);
    }
    
    public void handleMessage(Message paramMessage)
    {
      VideoPlayManager localVideoPlayManager;
      if (this.weakReference != null)
      {
        localVideoPlayManager = (VideoPlayManager)this.weakReference.get();
        if (localVideoPlayManager != null) {
          switch (paramMessage.what)
          {
          }
        }
      }
      do
      {
        return;
        localVideoPlayManager = null;
        break;
      } while ((VideoPlayManager.a(localVideoPlayManager) == null) || (VideoPlayManager.c.b(VideoPlayManager.a(localVideoPlayManager)) == null));
      Object localObject = VideoPlayManager.c.b(VideoPlayManager.a(localVideoPlayManager));
      paramMessage = VideoPlayManager.a(localVideoPlayManager);
      if ((localObject != null) && (((myi)localObject).isPlaying()))
      {
        long l = ((myi)localObject).dc();
        localObject = VideoPlayManager.a(localVideoPlayManager).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((VideoPlayManager.d)((Iterator)localObject).next()).a(paramMessage, nws.D(l) * 1000);
        }
      }
      VideoPlayManager.a(localVideoPlayManager).sendEmptyMessageDelayed(0, VideoPlayManager.a(localVideoPlayManager));
    }
  }
  
  public static class c
  {
    public nbr a;
    public int aVm = 0;
    public boolean autoPlay;
    public boolean avc = true;
    public boolean avd;
    public boolean ave;
    public boolean avf;
    public nwq b;
    public int bcN = 1000;
    public int bcO = -1;
    private myi e;
    public int height;
    public boolean muted;
    public int startPosition;
    public ViewGroup videoLayout;
    public int width;
    
    public c(ViewGroup paramViewGroup, JSONObject paramJSONObject)
      throws JSONException
    {
      this.videoLayout = paramViewGroup;
      this.autoPlay = true;
      this.muted = false;
      this.startPosition = 0;
      this.width = -1;
      this.height = -1;
      this.b = new nwq(paramJSONObject.getJSONObject("video_info"));
      if (paramJSONObject.has("autoplay")) {
        this.autoPlay = paramJSONObject.getBoolean("autoplay");
      }
      if (paramJSONObject.has("muted")) {
        this.muted = paramJSONObject.getBoolean("muted");
      }
      if (paramJSONObject.has("start_position")) {
        this.startPosition = paramJSONObject.getInt("start_position");
      }
      if (paramJSONObject.has("width")) {
        this.width = paramJSONObject.getInt("width");
      }
      if (paramJSONObject.has("height")) {
        this.height = paramJSONObject.getInt("height");
      }
      if (paramJSONObject.has("controls")) {
        this.avc = paramJSONObject.getBoolean("controls");
      }
      if (paramJSONObject.has("resize")) {
        oF(paramJSONObject.getString("resize"));
      }
      if (paramJSONObject.has("timeupdateRate")) {
        this.bcN = paramJSONObject.getInt("timeupdateRate");
      }
      if (paramJSONObject.has("barBottomMargin")) {
        this.bcO = paramJSONObject.getInt("barBottomMargin");
      }
      if (paramJSONObject.has("disableFullScreen")) {
        this.avd = paramJSONObject.getBoolean("disableFullScreen");
      }
      if (paramJSONObject.has("disableSeek")) {
        this.ave = paramJSONObject.getBoolean("disableSeek");
      }
      if (paramJSONObject.has("endWithLastFrame")) {
        this.avf = paramJSONObject.getBoolean("endWithLastFrame");
      }
    }
    
    public void oF(String paramString)
    {
      if (paramString.equals("contain")) {
        this.aVm = 0;
      }
      while (!paramString.equals("cover")) {
        return;
      }
      this.aVm = 2;
    }
    
    public String toString()
    {
      return "VideoPlayParam{videoInfo=" + this.b + ", startPosition=" + this.startPosition + ", muted=" + this.muted + ", autoPlay=" + this.autoPlay + ", width=" + this.width + ", height=" + this.height + ", controls=" + this.avc + ", timeupdateRate=" + this.bcN + ", barBottomMargin=" + this.bcO + ", disableFullScreen=" + this.avd + ", disableSeek=" + this.ave + '}';
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(VideoPlayManager.c paramc, int paramInt);
    
    public abstract void a(VideoPlayManager.c paramc, int paramInt1, int paramInt2, String paramString);
    
    public abstract void a(VideoPlayManager.c paramc, long paramLong);
    
    public abstract void a(VideoPlayManager.c paramc, boolean paramBoolean);
    
    public abstract void b(VideoPlayManager.c paramc, int paramInt);
    
    public abstract void g(VideoPlayManager.c paramc);
    
    public abstract void h(VideoPlayManager.c paramc);
    
    public abstract void i(VideoPlayManager.c paramc);
    
    public abstract void j(VideoPlayManager.c paramc);
    
    public abstract void k(VideoPlayManager.c paramc);
    
    public abstract void l(VideoPlayManager.c paramc);
    
    public abstract void m(VideoPlayManager.c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager
 * JD-Core Version:    0.7.0.1
 */