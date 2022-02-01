package com.tencent.biz.richframework.widget;

import allf;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import aqmr;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.NetworkManager.NetStatusListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.videoplatform.VideoPlaySDKManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import mqq.util.WeakReference;
import oug;
import pcr;
import pcy;
import pem;
import rwv;
import rwx;
import ryv;
import ryw;
import sow;
import spp;

public abstract class BaseVideoView
  extends BaseWidgetView
  implements Handler.Callback, SeekBar.OnSeekBarChangeListener, NetworkManager.NetStatusListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnVideoSizeChangedListener, rwx
{
  private long CF;
  private long CG;
  private long CH;
  private long CI;
  private long CJ;
  public boolean FD;
  protected URLImageView Z;
  private SuperPlayerVideoInfo a;
  public pem a;
  protected boolean aKA;
  private boolean aKB = true;
  private boolean aKC;
  private boolean aKD;
  private boolean aKE;
  protected boolean aKz;
  private int aVX;
  private ISPlayerVideoView b;
  private final int bvT = 1;
  private Handler mHandler;
  private boolean mHasAddVideoView;
  private boolean mIsSeeking;
  private ISuperPlayer mPlayer;
  private Timer mTimer;
  private List<Pair<Long, Long>> pp = new LinkedList();
  private long xe;
  private long xf;
  
  public BaseVideoView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void N(long paramLong1, long paramLong2)
  {
    if (Mo()) {
      return;
    }
    Iterator localIterator = this.pp.iterator();
    Pair localPair;
    while (localIterator.hasNext())
    {
      localPair = (Pair)localIterator.next();
      if ((((Long)localPair.first).longValue() <= paramLong1) && (((Long)localPair.second).longValue() >= paramLong2))
      {
        QLog.d("BaseVideoView", 1, "addToVideoSoloPlayTimeRangeList: already contained [start=" + paramLong1 + ", end=" + paramLong2 + "]");
        return;
      }
    }
    localIterator = this.pp.iterator();
    while (localIterator.hasNext())
    {
      localPair = (Pair)localIterator.next();
      if ((paramLong1 <= ((Long)localPair.first).longValue()) && (paramLong2 >= ((Long)localPair.second).longValue()))
      {
        QLog.d("BaseVideoView", 1, "addToVideoSoloPlayTimeRangeList: remove [start=" + localPair.first + ", end=" + localPair.second + "]");
        localIterator.remove();
      }
    }
    localIterator = this.pp.iterator();
    while (localIterator.hasNext())
    {
      localPair = (Pair)localIterator.next();
      long l = paramLong1;
      if (paramLong1 >= ((Long)localPair.first).longValue())
      {
        l = paramLong1;
        if (paramLong1 <= ((Long)localPair.second).longValue()) {
          l = ((Long)localPair.second).longValue();
        }
      }
      paramLong1 = l;
      if (paramLong2 >= ((Long)localPair.first).longValue())
      {
        paramLong1 = l;
        if (paramLong2 <= ((Long)localPair.second).longValue())
        {
          paramLong2 = ((Long)localPair.first).longValue();
          paramLong1 = l;
        }
      }
    }
    if ((paramLong1 < 0L) || (paramLong1 > paramLong2))
    {
      QLog.d("BaseVideoView", 1, "addToVideoSoloPlayTimeRangeList: already contained after adjustment [start=" + paramLong1 + ", end=" + paramLong2 + "]");
      return;
    }
    QLog.d("BaseVideoView", 1, "addToVideoSoloPlayTimeRangeList: already contained after adjustment [start=" + paramLong1 + ", end=" + paramLong2 + "]");
    this.pp.add(new Pair(Long.valueOf(paramLong1), Long.valueOf(paramLong2)));
  }
  
  private void aAz()
  {
    if (a() != null) {
      a().setOnSeekBarChangeListener(this);
    }
  }
  
  private void addVideoView()
  {
    if ((a() != null) && (!this.mHasAddVideoView))
    {
      addView((View)this.b, 0, new FrameLayout.LayoutParams(-1, -1));
      if (!this.aKC) {
        addView(this.Z);
      }
      this.mHasAddVideoView = true;
    }
  }
  
  private void bxs()
  {
    this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo = null;
    this.mIsSeeking = false;
    this.xe = 0L;
    this.aVX = 0;
    this.xf = 0L;
    if (this.mTimer != null) {
      this.mTimer.cancel();
    }
    if (this.Z != null) {
      this.Z.setVisibility(0);
    }
    getMainHandler().removeCallbacksAndMessages(null);
  }
  
  private void bxw()
  {
    if (this.CG > 0L)
    {
      long l = System.currentTimeMillis() - this.CG;
      N(this.CI, a().getCurrentPositionMs());
      d(0, 0, l, dZ());
      this.CG = 0L;
      this.CI = 0L;
      if (a() != null)
      {
        double d = a().getDurationMs();
        d = Math.min(100.0D, l / d * 100.0D);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(pcr.a("ret_code", "0"));
        localArrayList.add(pcr.a("time_cost", String.valueOf((float)l / 1000.0F)));
        pcy.a("video_play_ret", getData(), localArrayList);
        pcy.a("video_play_time_duration", getData(), Collections.singletonList(pcr.a("time_cost", String.valueOf((float)l / 1000.0F))));
        pcy.a("video_play_complete_rate", getData(), Collections.singletonList(pcr.a("rate", String.format("%.2f", new Object[] { Double.valueOf(d) }))));
      }
      if (this.aVX > 0)
      {
        pcy.a("video_play_occur_buffer_times", getData(), Collections.singletonList(pcr.a("buffer_count", String.valueOf(this.aVX))));
        pcy.a("video_buffer_time_consuming", getData(), Collections.singletonList(pcr.a("time_cost", String.valueOf((float)this.xf / 1000.0F))));
      }
    }
    else
    {
      return;
    }
    pcy.a("video_play_occur_buffer_times", getData(), Collections.singletonList(pcr.a("buffer_count", "0")));
  }
  
  private long dZ()
  {
    Iterator localIterator = this.pp.iterator();
    Pair localPair;
    for (long l = 0L; localIterator.hasNext(); l = ((Long)localPair.second).longValue() - ((Long)localPair.first).longValue() + l) {
      localPair = (Pair)localIterator.next();
    }
    return l;
  }
  
  private boolean fS(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    try
    {
      String[] arrayOfString = ((String)spp.a().getValue("KEY_HIT_FOR_VID_URLS", "http://qzvv.video.qq.com/qzone|https://qzvv.video.qq.com/qzone")).split("\\|");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        boolean bool = paramString.startsWith(arrayOfString[i]);
        if (bool) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  private String gt(String paramString)
  {
    return new File(oug.arx + paramString).getAbsolutePath();
  }
  
  private void resetParams()
  {
    a().reset();
    a().setLoopback(this.aKD);
    a().updatePlayerVideoView(this.b);
    a().setOutputMute(this.aKE);
  }
  
  public boolean HK()
  {
    return false;
  }
  
  protected abstract void J(long paramLong1, long paramLong2);
  
  protected abstract void K(long paramLong1, long paramLong2);
  
  public boolean Ml()
  {
    return this.FD;
  }
  
  public boolean Mm()
  {
    if (a() != null) {
      return a().isOutputMute();
    }
    return false;
  }
  
  public boolean Mn()
  {
    return this.aKz;
  }
  
  protected boolean Mo()
  {
    QLog.w("BaseVideoView", 1, "biz has cancel perf report");
    return false;
  }
  
  public void S(Context paramContext, int paramInt)
  {
    super.S(paramContext, paramInt);
    this.mHasAddVideoView = false;
    initSDK();
    this.Z = new URLImageView(getContext());
    this.Z.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.Z.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    addVideoView();
    NetworkManager.registNetStatusListener(this);
  }
  
  public void W(Context paramContext, int paramInt)
  {
    aAz();
  }
  
  public abstract SeekBar a();
  
  public URLImageView a()
  {
    return this.Z;
  }
  
  public ISuperPlayer a()
  {
    if (this.mPlayer == null)
    {
      if (!VideoPlaySDKManager.getInstance().isSDKReady()) {
        break label107;
      }
      this.b = SuperPlayerFactory.createPlayerVideoView(BaseApplicationImpl.getContext());
      this.mPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 102, this.b);
      this.mPlayer.setOnVideoPreparedListener(this);
      this.mPlayer.setOnErrorListener(this);
      this.mPlayer.setOnInfoListener(this);
      this.mPlayer.setOnCompletionListener(this);
      this.mPlayer.setOnSeekCompleteListener(this);
      this.mPlayer.setOnInfoListener(this);
    }
    for (;;)
    {
      return this.mPlayer;
      label107:
      QLog.w("BaseVideoView", 1, "SuperPlayer is not installed");
    }
  }
  
  protected SuperPlayerVideoInfo a(String paramString1, String paramString2)
  {
    if ((!aqmr.isEmpty(paramString1)) && ((paramString2 == null) || (fS(paramString2)))) {
      this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForTVideo(30301, paramString1);
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo;
      if (!aqmr.isEmpty(paramString2)) {
        this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForUrl(paramString2, 104, paramString1, gt(paramString1));
      }
    }
  }
  
  public ISPlayerVideoView a()
  {
    return this.b;
  }
  
  protected void bjH()
  {
    if (this.Z != null) {
      this.Z.setVisibility(8);
    }
  }
  
  protected abstract void bjp();
  
  protected void bxt()
  {
    if (!Mo()) {
      pcy.a("video_download_ret", getData(), Collections.singletonList(pcr.a("ret_code", "0")));
    }
  }
  
  public void bxu()
  {
    if (this.mTimer != null) {
      this.mTimer.cancel();
    }
    this.mTimer = new Timer();
    this.mTimer.schedule(new TimeUpdateTimerTask(this), 0L, 33L);
  }
  
  @CallSuper
  protected void bxv()
  {
    if (a() != null)
    {
      double d1 = a().getCurrentPositionMs();
      float f = (float)a().getDurationMs();
      if ((f == 0.0F) && (a() != null)) {
        a().setProgress(0);
      }
      if ((!this.aKA) && (d1 != 0.0D))
      {
        Object localObject = Message.obtain();
        ((Message)localObject).what = -1001;
        ((Message)localObject).arg1 = ((int)d1);
        ((Message)localObject).arg2 = ((int)f);
        ((Message)localObject).obj = Boolean.valueOf(true);
        getMainHandler().sendMessage((Message)localObject);
        if (a() != null)
        {
          localObject = a();
          double d2 = a().getMax();
          ((SeekBar)localObject).setProgress((int)(d1 / f * d2));
        }
      }
    }
  }
  
  protected abstract void d(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
  
  public long ea()
  {
    return this.xe;
  }
  
  public ArrayList<Class> getEventClass()
  {
    return null;
  }
  
  public Handler getMainHandler()
  {
    if (this.mHandler == null) {
      this.mHandler = new Handler(Looper.getMainLooper(), this);
    }
    return this.mHandler;
  }
  
  public void initSDK()
  {
    if (!allf.isSDKReady())
    {
      allf.a(BaseApplicationImpl.getApplication(), new ryv(this));
      return;
    }
    a();
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer) {}
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramISuperPlayer = String.format("module:%d, errorType:%d, errorCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    QLog.e("BaseVideoView", 1, paramISuperPlayer);
    if ((String.valueOf(paramInt3).startsWith("140")) || (String.valueOf(paramInt3).startsWith("160"))) {
      yg(paramInt3);
    }
    d(paramInt3, paramInt1, 0L, 0L);
    if (!Mo())
    {
      paramString = new ArrayList();
      paramString.add(pcr.a("ret_code", String.valueOf(paramInt3)));
      paramString.add(pcr.a("attach_info", paramISuperPlayer));
      pcy.a("video_play_ret", getData(), paramString);
    }
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    QLog.i("BaseVideoView", 1, "what:" + paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      getMainHandler().post(new BaseVideoView.3(this));
      continue;
      this.xe = System.currentTimeMillis();
      continue;
      if (!this.mIsSeeking)
      {
        this.aVX += 1;
        this.xf += System.currentTimeMillis() - this.xe;
        continue;
        bxt();
      }
    }
  }
  
  public void onNetworkChanged(String paramString1, String paramString2) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (this.aKA) {
      sow.a("setSeekBar", 100L, new ryw(this, paramSeekBar));
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    this.mIsSeeking = false;
    if (this.CH > 0L)
    {
      this.CG += System.currentTimeMillis() - this.CH;
      this.CH = 0L;
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.aKA = true;
    this.CH = System.currentTimeMillis();
    long l1 = System.currentTimeMillis();
    long l2 = this.CG;
    if (a() != null)
    {
      N(this.CI, a().getCurrentPositionMs());
      J(l1 - l2, dZ());
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (a() != null)
    {
      int i = (int)(paramSeekBar.getProgress() / (paramSeekBar.getMax() * 1.0F) * (float)a().getDurationMs());
      this.CI = i;
      QLog.d("BaseVideoView", 1, String.format("seek onStopTrackingTouch seekBar progress:%d, position:%d", new Object[] { Integer.valueOf(paramSeekBar.getProgress()), Integer.valueOf(i) }));
      seek(i);
    }
    this.aKA = false;
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    if (this.b != null) {
      this.b.setXYaxis(0);
    }
    if (a() != null) {
      a().setMax((int)a().getDurationMs());
    }
    if (!Mo())
    {
      paramISuperPlayer = new ArrayList();
      paramISuperPlayer.add(pcr.a("time_cost", String.valueOf((float)(System.currentTimeMillis() - this.CF) / 1000.0F)));
      pcy.a("video_first_buffer_time_consuming", getData(), paramISuperPlayer);
    }
  }
  
  public void onVideoSizeChanged(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2) {}
  
  public void pause()
  {
    if ((a() != null) && (a().isPlaying()))
    {
      a().pause();
      this.FD = true;
      N(this.CI, a().getCurrentPositionMs());
      K(System.currentTimeMillis() - this.CG, dZ());
      this.CJ = System.currentTimeMillis();
    }
  }
  
  public int qf()
  {
    return this.aVX;
  }
  
  public void release()
  {
    this.aKB = true;
    if (!Mo()) {
      bxw();
    }
    if (a() != null)
    {
      a().stop();
      a().release();
    }
    this.FD = false;
    rwv.a().b(this);
    NetworkManager.unregistNetStatusListener(this);
    if (a() != null)
    {
      a().setProgress(0);
      a().setOnSeekBarChangeListener(null);
    }
    if (this.mTimer != null) {
      this.mTimer.cancel();
    }
    this.Z = null;
    getMainHandler().removeCallbacksAndMessages(null);
  }
  
  public void replay()
  {
    if (a() != null)
    {
      a().stop();
      this.FD = false;
      if (this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo != null) {
        setVideoPath(this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo.getVid(), this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo.getPlayUrl(), 0);
      }
    }
  }
  
  public void seek(long paramLong)
  {
    long l1 = 0L;
    if (a() != null)
    {
      long l2 = a().getDurationMs();
      if ((paramLong <= l2) || (l2 == 0L)) {
        break label191;
      }
      QLog.d("BaseVideoView", 1, "seek over position=" + paramLong + "duration=" + l2);
      paramLong = l2;
    }
    label191:
    for (;;)
    {
      if (paramLong < 0L)
      {
        QLog.d("BaseVideoView", 1, "seek invalid position=" + paramLong + "duration=" + a().getDurationMs());
        paramLong = l1;
      }
      for (;;)
      {
        a().seekTo((int)paramLong, 3);
        QLog.d("BaseVideoView", 1, "seek position=" + paramLong + "duration=" + a().getDurationMs());
        this.mIsSeeking = true;
        return;
      }
    }
  }
  
  public void setBaseVideoViewListenerSets(pem parampem)
  {
    this.jdField_a_of_type_Pem = parampem;
  }
  
  public void setInterrupt(boolean paramBoolean)
  {
    this.aKz = paramBoolean;
  }
  
  public void setLoopBack(boolean paramBoolean)
  {
    this.aKD = paramBoolean;
    if (a() != null) {
      a().setLoopback(paramBoolean);
    }
  }
  
  public void setOutPutMute(boolean paramBoolean)
  {
    this.aKE = paramBoolean;
    if (a() != null) {
      a().setOutputMute(paramBoolean);
    }
  }
  
  public void setVideoCover(URLImageView paramURLImageView)
  {
    if (paramURLImageView != null)
    {
      if (this.Z != null) {
        removeView(this.Z);
      }
      this.aKC = true;
      this.Z = paramURLImageView;
    }
  }
  
  public void setVideoPath(String paramString1, String paramString2, int paramInt)
  {
    bxs();
    pcy.bjt();
    this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo = a(paramString1, paramString2);
    if (a() != null)
    {
      resetParams();
      a().openMediaPlayer(getContext(), this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo, paramInt);
      this.CF = System.currentTimeMillis();
      if (!Mo()) {
        pcy.a("video_start_play", getData(), null);
      }
    }
  }
  
  public void showCover()
  {
    if (this.Z != null) {
      this.Z.setVisibility(0);
    }
  }
  
  public void start()
  {
    if ((a() != null) && (!a().isPlaying()))
    {
      setInterrupt(false);
      if ((!this.FD) || (this.CJ <= 0L)) {
        break label124;
      }
      this.CG += System.currentTimeMillis() - this.CJ;
      this.CJ = 0L;
    }
    for (;;)
    {
      if ((!this.FD) && (this.aKB))
      {
        this.CG = System.currentTimeMillis();
        this.CI = a().getCurrentPositionMs();
      }
      a().start();
      this.FD = false;
      this.aKB = false;
      bxu();
      bjp();
      return;
      label124:
      if (!this.aKB) {
        N(this.CI, a().getDurationMs());
      }
    }
  }
  
  public void stop()
  {
    this.aKB = true;
    if (!Mo()) {
      bxw();
    }
    if (a() != null) {
      a().stop();
    }
    this.FD = false;
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
  }
  
  protected void yg(int paramInt)
  {
    if (!Mo()) {
      pcy.a("video_download_ret", getData(), Collections.singletonList(pcr.a("ret_code", String.valueOf(paramInt))));
    }
  }
  
  static class TimeUpdateTimerTask
    extends TimerTask
  {
    private WeakReference<BaseVideoView> L;
    
    TimeUpdateTimerTask(BaseVideoView paramBaseVideoView)
    {
      this.L = new WeakReference(paramBaseVideoView);
    }
    
    public void run()
    {
      if (this.L != null)
      {
        BaseVideoView localBaseVideoView = (BaseVideoView)this.L.get();
        if (localBaseVideoView != null) {
          localBaseVideoView.bxv();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.widget.BaseVideoView
 * JD-Core Version:    0.7.0.1
 */