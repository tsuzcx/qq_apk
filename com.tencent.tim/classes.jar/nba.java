import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoViewUIDelegate.4;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoViewUIDelegate.5;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class nba
  implements SeekBar.OnSeekBarChangeListener, msa
{
  private static HashMap<Integer, Drawable> em = new HashMap();
  protected VideoFeedsPlayManager a;
  protected nba.a a;
  private boolean anZ;
  boolean aqa;
  private boolean aqb = true;
  private boolean aqc = true;
  private boolean aqd;
  private boolean aqe;
  private boolean mIsSeeking;
  protected Handler mUIHandler;
  private long xa;
  
  public nba(nba.a parama, VideoFeedsPlayManager paramVideoFeedsPlayManager, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_Nba$a = parama;
    this.jdField_a_of_type_Nba$a.d.setOnSeekBarChangeListener(this);
    this.anZ = paramBoolean;
    this.mUIHandler = new nbb(this, Looper.getMainLooper());
  }
  
  private void K(VideoInfo paramVideoInfo)
  {
    String str;
    if (this.anZ) {
      str = "正在使用免流量播放";
    }
    for (;;)
    {
      paramVideoInfo = this.jdField_a_of_type_Nba$a.rG;
      paramVideoInfo.setText(str);
      muj.H(paramVideoInfo, 0);
      this.aqe = true;
      this.mUIHandler.postAtTime(new MultiVideoViewUIDelegate.5(this, paramVideoInfo), Integer.valueOf(0), SystemClock.uptimeMillis() + 1000L);
      return;
      str = "正在使用流量播放，约" + muj.aw(paramVideoInfo.ry);
      if (paramVideoInfo.ry <= 0L) {
        str = "正在使用流量播放";
      }
    }
  }
  
  private void aA(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsVideoUIDelegate", 2, "innerChangePlayButton() what = " + paramInt);
    }
    this.aqb = false;
    switch (paramInt)
    {
    default: 
    case 1: 
    case 0: 
    case 6: 
    case 5: 
    case 3: 
    case 4: 
      do
      {
        return;
        this.jdField_a_of_type_Nba$a.jO.setBackgroundDrawable(f(this.jdField_a_of_type_Nba$a.jO.getContext(), 2130844047));
        this.jdField_a_of_type_Nba$a.jO.clearAnimation();
        paramString = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
        paramString.setDuration(500L);
        paramString.setRepeatCount(-1);
        paramString.setRepeatMode(1);
        paramString.setStartTime(-1L);
        paramString.setInterpolator(new LinearInterpolator());
        this.jdField_a_of_type_Nba$a.jO.startAnimation(paramString);
        this.jdField_a_of_type_Nba$a.bg.setVisibility(0);
        this.jdField_a_of_type_Nba$a.sz.setText("");
        return;
        this.jdField_a_of_type_Nba$a.jO.clearAnimation();
        this.jdField_a_of_type_Nba$a.jO.setBackgroundDrawable(f(this.jdField_a_of_type_Nba$a.jO.getContext(), 2130844049));
        this.jdField_a_of_type_Nba$a.bg.setVisibility(0);
        this.jdField_a_of_type_Nba$a.sz.setText("");
        return;
        this.jdField_a_of_type_Nba$a.jO.clearAnimation();
        this.jdField_a_of_type_Nba$a.jO.setBackgroundDrawable(f(this.jdField_a_of_type_Nba$a.jO.getContext(), 2130844049));
        this.jdField_a_of_type_Nba$a.bg.setVisibility(8);
        this.jdField_a_of_type_Nba$a.sz.setText("");
        return;
        this.jdField_a_of_type_Nba$a.jO.clearAnimation();
        this.jdField_a_of_type_Nba$a.jO.setBackgroundDrawable(f(this.jdField_a_of_type_Nba$a.jO.getContext(), 2130844049));
        this.jdField_a_of_type_Nba$a.bg.setVisibility(0);
        this.jdField_a_of_type_Nba$a.sz.setText("");
        return;
        this.jdField_a_of_type_Nba$a.jO.clearAnimation();
        this.jdField_a_of_type_Nba$a.jO.setBackgroundDrawable(f(this.jdField_a_of_type_Nba$a.jO.getContext(), 2130844048));
        this.jdField_a_of_type_Nba$a.bg.setVisibility(0);
        this.jdField_a_of_type_Nba$a.sz.setText("");
        return;
        this.jdField_a_of_type_Nba$a.jO.clearAnimation();
        this.jdField_a_of_type_Nba$a.jO.setBackgroundDrawable(f(this.jdField_a_of_type_Nba$a.jO.getContext(), 2130844048));
        this.jdField_a_of_type_Nba$a.bg.setVisibility(8);
        this.jdField_a_of_type_Nba$a.sz.setText("");
      } while ((this.jdField_a_of_type_Nba$a.ps.getVisibility() != 0) || (!aqiw.isMobileNetWork(BaseApplicationImpl.getContext())));
      this.jdField_a_of_type_Nba$a.jO.setVisibility(0);
      this.jdField_a_of_type_Nba$a.ps.setVisibility(8);
      this.jdField_a_of_type_Nba$a.pt.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Nba$a.jO.clearAnimation();
    this.jdField_a_of_type_Nba$a.jO.setBackgroundDrawable(f(this.jdField_a_of_type_Nba$a.jO.getContext(), 2130849491));
    this.jdField_a_of_type_Nba$a.bg.setVisibility(0);
    this.jdField_a_of_type_Nba$a.sz.setVisibility(0);
    this.jdField_a_of_type_Nba$a.sz.setText(paramString);
  }
  
  private void cY(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Nba$a.x == null) {
      return;
    }
    muj.m(this.jdField_a_of_type_Nba$a.x, paramInt1, paramInt2);
  }
  
  private static Drawable f(Context paramContext, int paramInt)
  {
    if (em == null) {}
    do
    {
      return null;
      if (em.containsKey(Integer.valueOf(paramInt))) {
        return (Drawable)em.get(Integer.valueOf(paramInt));
      }
      try
      {
        paramContext = paramContext.getResources().getDrawable(paramInt);
        em.put(Integer.valueOf(paramInt), paramContext);
        return paramContext;
      }
      catch (OutOfMemoryError paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.d("VideoFeedsVideoUIDelegate", 2, "innerGetDrawableFromCache() OutOfMemoryError e=" + paramContext.getMessage());
    return null;
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
    if (this.jdField_a_of_type_Nba$a.lN != null)
    {
      this.jdField_a_of_type_Nba$a.lN.clearAnimation();
      this.jdField_a_of_type_Nba$a.lN.setVisibility(8);
    }
  }
  
  public void a(VideoFeedsPlayManager.b paramb, int paramInt1, int paramInt2, String paramString)
  {
    paramb = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramb = "视频加载失败，请点击重试";
    }
    az(2, paramb);
  }
  
  public void a(VideoFeedsPlayManager.b paramb, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Nba$a.lN != null))
    {
      if (paramInt <= 300) {
        break label123;
      }
      paramInt -= 300;
    }
    for (;;)
    {
      this.jdField_a_of_type_Nba$a.lN.setVisibility(0);
      paramb = new AlphaAnimation(0.0F, 1.0F);
      paramb.setDuration(300L);
      paramb.setStartOffset(paramInt);
      this.jdField_a_of_type_Nba$a.lN.setAnimation(paramb);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setAnimationListener(new nbc(this));
      paramb.setAnimationListener(new nbd(this, localAlphaAnimation));
      paramb.start();
      return;
      label123:
      paramInt = 0;
    }
  }
  
  public void a(VideoFeedsPlayManager.b paramb, long paramLong1, long paramLong2)
  {
    int i = 100;
    if ((paramb != null) && (this.jdField_a_of_type_Nba$a.d != null) && (this.jdField_a_of_type_Nba$a.rD != null) && (this.jdField_a_of_type_Nba$a.rF != null))
    {
      if (paramLong2 != 0L) {
        break label94;
      }
      if (this.aqc)
      {
        this.jdField_a_of_type_Nba$a.d.setProgress(0);
        this.jdField_a_of_type_Nba$a.e.setProgress(0);
      }
    }
    label94:
    while (paramLong1 == 0L)
    {
      if (paramLong2 > 0L) {
        muj.a(this.jdField_a_of_type_Nba$a.rF, paramLong2);
      }
      return;
    }
    int j = (int)((float)paramLong1 * 100.0F / (float)paramLong2 + 0.5D);
    if (j + 1 >= 100) {}
    for (;;)
    {
      if (this.aqc)
      {
        this.jdField_a_of_type_Nba$a.d.setProgress(i);
        this.jdField_a_of_type_Nba$a.e.setProgress(i);
      }
      muj.a(this.jdField_a_of_type_Nba$a.rD, paramLong1);
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
      long l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.cV();
      long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.getVideoDuration();
      j = (int)((float)l1 * 100.0F / (float)l2 + 0.5D);
      if (j + 1 < 100) {
        break label75;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Nba$a.d.setProgress(i);
      this.jdField_a_of_type_Nba$a.e.setProgress(i);
      return;
      label75:
      i = j + 1;
    }
  }
  
  public void az(int paramInt, String paramString)
  {
    this.aqb = false;
    this.mUIHandler.post(new MultiVideoViewUIDelegate.4(this, paramInt, paramString));
  }
  
  public VideoFeedsPlayManager b()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  }
  
  public void b(VideoFeedsPlayManager.b paramb)
  {
    sK(8);
    if ((paramb != null) && (this.jdField_a_of_type_Nba$a.be.getVisibility() == 0))
    {
      sL(3);
      return;
    }
    sL(4);
  }
  
  public void b(VideoFeedsPlayManager.b paramb, boolean paramBoolean)
  {
    this.mUIHandler.removeMessages(-1);
    this.jdField_a_of_type_Nba$a.e.setVisibility(0);
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
    sL(0);
    this.mUIHandler.removeMessages(-1);
    this.jdField_a_of_type_Nba$a.e.setVisibility(8);
    if (this.jdField_a_of_type_Nba$a.lN != null)
    {
      this.jdField_a_of_type_Nba$a.lN.clearAnimation();
      this.jdField_a_of_type_Nba$a.lN.setVisibility(8);
    }
  }
  
  public void c(VideoFeedsPlayManager.b paramb, boolean paramBoolean) {}
  
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
  
  public void g(VideoFeedsPlayManager.b paramb)
  {
    cY(0, 0);
  }
  
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
    if ((paramb != null) && (this.jdField_a_of_type_Nba$a.be.getVisibility() == 0))
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
      l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.getVideoDuration();
    } while (l <= 0L);
    double d = paramInt / 100.0D;
    paramInt = (int)(l * d);
    muj.a(this.jdField_a_of_type_Nba$a.rD, paramInt);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.mIsSeeking = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.mIsSeeking = false;
    int i = paramSeekBar.getProgress();
    long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.getVideoDuration();
    if (l > 0L)
    {
      i = (int)(i / 100.0D * l);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.seekTo(i);
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void sL(int paramInt)
  {
    az(paramInt, null);
  }
  
  public static class a
  {
    public ViewGroup be;
    public ViewGroup bg;
    public SeekBar d;
    public SeekBar e;
    public ImageView jO;
    public View lN;
    public TextView ps;
    public TextView pt;
    public TextView rD;
    public TextView rF;
    public TextView rG;
    public TextView sz;
    public URLImageView x;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nba
 * JD-Core Version:    0.7.0.1
 */