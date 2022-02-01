import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsVideoUIDelegate.2;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsVideoUIDelegate.3;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsVideoUIDelegate.6;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsVideoUIDelegate.7;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mxy
  implements SeekBar.OnSeekBarChangeListener, msa
{
  VideoFeedsPlayManager a;
  private boolean anZ;
  boolean aqa;
  private boolean aqb = true;
  private boolean aqc = true;
  private boolean aqd;
  private boolean aqe;
  public mtg.g h;
  private boolean mIsSeeking;
  Handler mUIHandler;
  private long xa;
  
  public mxy(mtg.g paramg, VideoFeedsPlayManager paramVideoFeedsPlayManager, boolean paramBoolean)
  {
    this.a = paramVideoFeedsPlayManager;
    this.h = paramg;
    this.h.d.setOnSeekBarChangeListener(this);
    this.anZ = paramBoolean;
    this.mUIHandler = new mxz(this, Looper.getMainLooper());
  }
  
  private void K(VideoInfo paramVideoInfo)
  {
    if (this.anZ) {}
    for (;;)
    {
      paramVideoInfo = this.h.rG;
      muj.H(paramVideoInfo, 0);
      this.aqe = true;
      this.mUIHandler.postAtTime(new VideoFeedsVideoUIDelegate.7(this, paramVideoInfo), Integer.valueOf(0), SystemClock.uptimeMillis() + 1000L);
      return;
      if (paramVideoInfo.ry > 0L) {}
    }
  }
  
  public static void a(TextView paramTextView, VideoInfo paramVideoInfo, myi parammyi)
  {
    muj.a(paramTextView, parammyi, paramVideoInfo.vid, paramVideoInfo.Wz, paramVideoInfo.duration, paramVideoInfo.busiType);
  }
  
  private void aA(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsVideoUIDelegate", 2, "innerChangePlayButton() what = " + paramInt);
    }
    this.aqb = false;
    this.h.jO.clearAnimation();
    this.h.jO.setVisibility(0);
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.h.jO.setBackgroundDrawable(mwl.f(this.h.jO.getContext(), 2130844047));
      this.h.jO.clearAnimation();
      paramString = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      paramString.setDuration(500L);
      paramString.setRepeatCount(-1);
      paramString.setRepeatMode(1);
      paramString.setStartTime(-1L);
      paramString.setInterpolator(new LinearInterpolator());
      this.h.jO.startAnimation(paramString);
      this.h.bg.setVisibility(0);
      return;
      this.h.jO.clearAnimation();
      this.h.jO.setBackgroundDrawable(mwl.f(this.h.jO.getContext(), 2130844049));
      this.h.bg.setVisibility(0);
      return;
      this.h.jO.clearAnimation();
      this.h.jO.setBackgroundDrawable(mwl.f(this.h.jO.getContext(), 2130844049));
      this.h.bg.setVisibility(8);
      return;
      this.h.jO.clearAnimation();
      this.h.jO.setBackgroundDrawable(mwl.f(this.h.jO.getContext(), 2130844049));
      this.h.bg.setVisibility(0);
      return;
      this.h.jO.clearAnimation();
      this.h.jO.setBackgroundDrawable(mwl.f(this.h.jO.getContext(), 2130844048));
      this.h.bg.setVisibility(0);
      return;
      this.h.jO.clearAnimation();
      this.h.jO.setBackgroundDrawable(mwl.f(this.h.jO.getContext(), 2130844048));
      this.h.bg.setVisibility(8);
    } while ((this.h.ps.getVisibility() != 0) || (!aqiw.isMobileNetWork(BaseApplicationImpl.getContext())));
    this.h.jO.setVisibility(0);
    this.h.ps.setVisibility(8);
    this.h.pt.setVisibility(8);
  }
  
  private void aTC()
  {
    mtg.k localk = null;
    if ((this.h instanceof mtg.k)) {
      localk = (mtg.k)this.h;
    }
    if ((localk != null) && (localk.P != null) && ((localk.P.getDrawable() instanceof lae))) {
      ((lae)localk.P.getDrawable()).playAnimation();
    }
  }
  
  private void cY(int paramInt1, int paramInt2)
  {
    if (this.h.x == null) {
      return;
    }
    muj.m(this.h.x, paramInt1, paramInt2);
  }
  
  private boolean f(VideoFeedsPlayManager.b paramb)
  {
    if (!aqiw.isMobileNetWork(BaseApplicationImpl.getContext())) {}
    while ((paramb == null) || (paramb.d == null) || (!this.aqa) || (this.aqe)) {
      return false;
    }
    return true;
  }
  
  private void sK(int paramInt)
  {
    cY(paramInt, 500);
  }
  
  public void a(VideoFeedsPlayManager.b paramb)
  {
    if (f(paramb)) {
      K(paramb.d);
    }
    sL(4);
    sK(8);
    paramb.videoView.setVisibility(0);
    a(this.h.rE, paramb.d, paramb.e);
    aTC();
  }
  
  public void a(VideoFeedsPlayManager.b paramb, int paramInt1, int paramInt2, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    this.mUIHandler.post(new VideoFeedsVideoUIDelegate.2(this, paramString, paramb));
  }
  
  public void a(VideoFeedsPlayManager.b paramb, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramInt <= 300) {
        break label113;
      }
      paramInt -= 300;
    }
    for (;;)
    {
      this.h.lN.setVisibility(0);
      paramb = new AlphaAnimation(0.0F, 1.0F);
      paramb.setDuration(300L);
      paramb.setStartOffset(paramInt);
      this.h.lN.setAnimation(paramb);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setAnimationListener(new mya(this));
      paramb.setAnimationListener(new myb(this, localAlphaAnimation));
      paramb.start();
      return;
      label113:
      paramInt = 0;
    }
  }
  
  public void a(VideoFeedsPlayManager.b paramb, long paramLong1, long paramLong2)
  {
    int i = 100;
    if ((paramb != null) && (this.h.d != null) && (this.h.rD != null) && (this.h.rF != null))
    {
      if (paramLong2 != 0L) {
        break label114;
      }
      if (this.aqc)
      {
        this.h.d.setProgress(0);
        this.h.e.setProgress(0);
      }
    }
    label114:
    while (paramLong1 == 0L)
    {
      if (paramLong2 > 0L) {
        muj.a(this.h.rF, paramLong2);
      }
      muj.a(this.h.rE, this.h.a.e);
      return;
    }
    int j = (int)((float)paramLong1 * 100.0F / (float)paramLong2 + 0.5D);
    if (j + 1 >= 100) {}
    for (;;)
    {
      if (this.aqc)
      {
        this.h.d.setProgress(i);
        this.h.e.setProgress(i);
      }
      muj.a(this.h.rD, paramLong1);
      break;
      i = j + 1;
    }
  }
  
  public void aTD()
  {
    int i = 100;
    int j;
    if (this.aqc)
    {
      long l1 = this.a.cV();
      long l2 = this.a.getVideoDuration();
      j = (int)((float)l1 * 100.0F / (float)l2 + 0.5D);
      if (j + 1 < 100) {
        break label75;
      }
    }
    for (;;)
    {
      this.h.d.setProgress(i);
      this.h.e.setProgress(i);
      return;
      label75:
      i = j + 1;
    }
  }
  
  public void az(int paramInt, String paramString)
  {
    this.aqb = false;
    this.mUIHandler.post(new VideoFeedsVideoUIDelegate.6(this, paramInt, paramString));
  }
  
  public void b(VideoFeedsPlayManager.b paramb)
  {
    sK(8);
    if ((paramb != null) && (this.h.be.getVisibility() == 0))
    {
      sL(3);
      return;
    }
    sL(4);
  }
  
  public void b(VideoFeedsPlayManager.b paramb, boolean paramBoolean)
  {
    this.mUIHandler.removeMessages(-1);
    if (!this.aqd) {
      cY(0, 0);
    }
    this.aqd = false;
    if (paramBoolean)
    {
      sL(1);
      return;
    }
    this.aqb = true;
    this.mUIHandler.sendEmptyMessageDelayed(-1, 1200L);
  }
  
  public void c(VideoFeedsPlayManager.b paramb)
  {
    this.aqd = false;
  }
  
  public void c(VideoFeedsPlayManager.b paramb, boolean paramBoolean)
  {
    this.mUIHandler.post(new VideoFeedsVideoUIDelegate.3(this, paramb, paramBoolean));
  }
  
  public long cY()
  {
    return this.xa;
  }
  
  public void d(VideoFeedsPlayManager.b paramb)
  {
    sL(0);
  }
  
  public boolean d(VideoFeedsPlayManager.b paramb)
  {
    return this.mIsSeeking;
  }
  
  public void f(VideoFeedsPlayManager.b paramb)
  {
    sL(0);
  }
  
  public void g(VideoFeedsPlayManager.b paramb) {}
  
  public void h(VideoFeedsPlayManager.b paramb) {}
  
  public void i(VideoFeedsPlayManager.b paramb)
  {
    sL(1);
  }
  
  public void j(VideoFeedsPlayManager.b paramb)
  {
    if ((paramb != null) && (paramb.e != null) && (paramb.e.isPause()))
    {
      sL(0);
      return;
    }
    if ((paramb != null) && (this.h.be.getVisibility() == 0))
    {
      sL(3);
      return;
    }
    sL(4);
  }
  
  public void k(VideoFeedsPlayManager.b paramb)
  {
    cY(0, 0);
    sL(0);
  }
  
  public void oJ(boolean paramBoolean)
  {
    this.aqc = paramBoolean;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    long l;
    do
    {
      return;
      this.xa = System.currentTimeMillis();
      l = this.a.getVideoDuration();
    } while (l <= 0L);
    double d = paramInt / 100.0D;
    paramInt = (int)(l * d);
    muj.a(this.h.rD, paramInt);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.mIsSeeking = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.mIsSeeking = false;
    int i = paramSeekBar.getProgress();
    long l = this.a.getVideoDuration();
    if (l > 0L)
    {
      i = (int)(i / 100.0D * l);
      this.a.seekTo(i);
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void sL(int paramInt)
  {
    az(paramInt, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mxy
 * JD-Core Version:    0.7.0.1
 */