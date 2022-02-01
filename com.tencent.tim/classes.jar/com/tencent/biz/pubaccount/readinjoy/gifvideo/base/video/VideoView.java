package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import aqiw;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import kbp;
import kwz;
import lfg;
import lfh.a;
import lfj;
import lfk;
import lfl;
import lfm;
import lfp;
import lfp.a;
import lfr;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoView
  extends FrameLayout
  implements Runnable
{
  public static int aOA = 3;
  public static int aOB;
  public static int aOC = 1;
  public static int aOx;
  public static int aOy = 1;
  public static int aOz = 2;
  private static Drawable mLoadingDrawable;
  private int BT;
  private AtomicInteger Q = new AtomicInteger(0);
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView$a;
  private b jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView$b;
  private lfg jdField_a_of_type_Lfg;
  private lfh.a jdField_a_of_type_Lfh$a = new lfj(this);
  private lfp jdField_a_of_type_Lfp;
  private ObjectAnimator aC;
  private ObjectAnimator aD;
  protected Handler aH = new Handler(Looper.getMainLooper());
  private int aOD = aOB;
  private int aOw;
  private String aeI;
  private String aeJ;
  private String aeK = "";
  private String aeL = "";
  private boolean ajS;
  private boolean ajT = true;
  public boolean ajU;
  private ViewTreeObserver.OnGlobalLayoutListener c = new lfk(this);
  private Runnable cF = new VideoView.3(this);
  private KandianUrlImageView f;
  private long fileSize;
  private KandianUrlImageView g;
  private boolean isLoop = true;
  private boolean isMute = true;
  public int[] lastLocation = new int[2];
  private int mBusiType;
  private Context mContext;
  private String mCoverUrl;
  private AtomicInteger mState = new AtomicInteger(0);
  private String mVid;
  private String mVideoUrl;
  private int playMode = aOx;
  private List<String> reportList = new ArrayList();
  private long startTime;
  
  public VideoView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private boolean Ca()
  {
    QLog.d("gifvideo.VideoView", 1, "auto play mode: " + this.aOD);
    return (this.aOD != aOC) || (aqiw.getNetworkType(BaseApplication.getContext()) == 1);
  }
  
  private void YG()
  {
    if ((this.f != null) && (!TextUtils.isEmpty(this.mCoverUrl))) {}
    try
    {
      kwz.a(this.f, new URL(this.mCoverUrl), this.mContext);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void aLJ()
  {
    switch (this.Q.get())
    {
    default: 
      return;
    }
    doInit();
  }
  
  private void aLK()
  {
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    if ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive())) {
      localViewTreeObserver.removeGlobalOnLayoutListener(this.c);
    }
  }
  
  private void aLL() {}
  
  private void aLM()
  {
    if ((this.g != null) && (!TextUtils.isEmpty(this.aeI))) {}
    try
    {
      this.g.setImagePlaceHolder(am()).setImage(new URL(this.aeI));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void aLN()
  {
    if (this.f != null)
    {
      QLog.d("gifvideo.VideoView", 1, getTag() + " hidecover alpha: " + this.f.getAlpha());
      if (this.aC == null)
      {
        this.aC = ObjectAnimator.ofFloat(this.f, "alpha", new float[] { 1.0F, 0.0F });
        this.aC.setDuration(300L);
        this.aC.addListener(new lfl(this));
      }
      if (this.aD == null)
      {
        this.aD = this.aC.clone();
        this.aD.setTarget(this.g);
      }
      this.aC.start();
      this.aD.start();
    }
  }
  
  private void aLO()
  {
    try
    {
      QLog.d("gifvideo.VideoView", 1, getTag() + " stopPlay");
      this.aeK = "";
      this.aeL = "";
      aLF();
      doStop();
      aLP();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void aLP()
  {
    long l1;
    long l2;
    if (!TextUtils.isEmpty(this.aeJ))
    {
      l1 = System.currentTimeMillis();
      l2 = this.startTime;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(this.aeJ);
      localJSONObject.put("playduration", l1 - l2);
      kbp.a(null, "", "0X8007408", "0X8007408", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("gifvideo.VideoView", 1, localJSONException.getMessage());
    }
  }
  
  private void aLQ()
  {
    if ((this.mBusiType == 2) || (this.mBusiType == 6)) {
      a(lfr.a(), new lfm(this));
    }
    while (!this.ajT) {
      return;
    }
    ne(this.mVid);
  }
  
  private static Drawable am()
  {
    if (mLoadingDrawable == null) {
      mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130851773);
    }
    return mLoadingDrawable;
  }
  
  private void changeState(int paramInt)
  {
    QLog.d("gifvideo.VideoView", 2, getTag() + " change state from " + this.mState.get() + " to " + paramInt);
    this.mState.set(paramInt);
  }
  
  private void doDestroy()
  {
    try
    {
      ThreadManager.getUIHandler().removeCallbacks(this.cF);
      aLK();
      this.Q.set(6);
      changeState(0);
      this.aeL = "";
      this.aeK = "";
      this.mVideoUrl = "";
      this.mCoverUrl = "";
      this.jdField_a_of_type_Lfg = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void doInit() {}
  
  private void doStart()
  {
    nt(true);
  }
  
  private void doStop() {}
  
  private void init()
  {
    setTag(Integer.valueOf(new Random().nextInt()));
    this.mContext = getContext();
    doInit();
  }
  
  private void nt(boolean paramBoolean) {}
  
  public void a(lfp paramlfp, lfp.a parama)
  {
    this.jdField_a_of_type_Lfp = paramlfp;
    if (this.jdField_a_of_type_Lfp != null) {
      this.jdField_a_of_type_Lfp.a(this.mVid, parama);
    }
  }
  
  public void aLF()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.cF);
    ThreadManager.getUIHandler().post(new VideoView.9(this));
  }
  
  public long cD()
  {
    return 0L;
  }
  
  public void destroy()
  {
    QLog.d("gifvideo.VideoView", 1, "destroy");
    doDestroy();
  }
  
  public int getAction()
  {
    return this.Q.get();
  }
  
  public int getCurrentState()
  {
    return this.mState.get();
  }
  
  public int getPlayMode()
  {
    return this.playMode;
  }
  
  public String getVideoVid()
  {
    return this.mVid;
  }
  
  public boolean isInited()
  {
    return getCurrentState() >= 4;
  }
  
  public boolean isMute()
  {
    return this.isMute;
  }
  
  public boolean isPlaying()
  {
    return getCurrentState() == 7;
  }
  
  public boolean isShown()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView$a != null) {
      return (super.isShown()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView$a.isShown());
    }
    return super.isShown();
  }
  
  public boolean kH()
  {
    QLog.d("gifvideo.VideoView", 2, "receive startPlay");
    if (!Ca())
    {
      QLog.d("gifvideo.VideoView", 1, "should not play");
      return false;
    }
    if (!isInited())
    {
      QLog.d("gifvideo.VideoView", 2, "has not inited, init");
      this.Q.set(3);
      init();
      return true;
    }
    if ((getCurrentState() == 7) || (this.Q.get() == 3))
    {
      QLog.d("gifvideo.VideoView", 2, "isPlaying or has started " + getCurrentState() + " " + this.Q.get());
      return true;
    }
    if (((!TextUtils.isEmpty(this.aeK)) && (!this.aeK.equals(this.mVideoUrl))) || (getVisibility() != 0))
    {
      QLog.d("gifvideo.VideoView", 2, "preparedUrl != mVideoUrl, " + this.aeK + " " + this.mVideoUrl + " " + getVisibility());
      return false;
    }
    this.Q.set(3);
    ThreadManager.post(new VideoView.5(this), 10, null, false);
    return true;
  }
  
  public void ne(String paramString) {}
  
  public void nf(String paramString) {}
  
  public void nu(boolean paramBoolean)
  {
    if (this.playMode == aOy)
    {
      if ((paramBoolean) && (this.Q.get() != 3)) {
        kH();
      }
      if ((!paramBoolean) && (this.Q.get() != 5)) {
        stop();
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    QLog.d("gifvideo.VideoView", 1, "detachedFromWindow");
    destroy();
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    YG();
    aLM();
  }
  
  public void pause()
  {
    QLog.d("gifvideo.VideoView", 2, "pause");
  }
  
  public void pc()
  {
    ThreadManager.post(new VideoView.7(this), 10, null, false);
  }
  
  public void resume() {}
  
  public void run() {}
  
  public void setAutoPlayMode(int paramInt)
  {
    this.aOD = paramInt;
  }
  
  public void setCoverUrl(String paramString)
  {
    this.mCoverUrl = paramString;
    YG();
  }
  
  public void setFileSize(long paramLong)
  {
    this.fileSize = paramLong;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.isLoop = paramBoolean;
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.isMute = paramBoolean;
  }
  
  public void setOnCheckShownListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView$a = parama;
  }
  
  public void setOnProgressChangedListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView$b = paramb;
  }
  
  public void setPlayIconSize(int paramInt1, int paramInt2)
  {
    this.aOw = Utils.dp2px(paramInt1);
    this.BT = Utils.dp2px(paramInt2);
    if (this.g != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.g.getLayoutParams();
      localLayoutParams.width = this.aOw;
      localLayoutParams.height = this.BT;
      this.g.setLayoutParams(localLayoutParams);
    }
  }
  
  public void setPlayIconUrl(String paramString)
  {
    this.aeI = paramString;
    aLM();
  }
  
  public void setPlayIconVisible(boolean paramBoolean)
  {
    this.ajS = paramBoolean;
    KandianUrlImageView localKandianUrlImageView;
    if (this.g != null)
    {
      localKandianUrlImageView = this.g;
      if (!this.ajS) {
        break label32;
      }
    }
    label32:
    for (int i = 0;; i = 4)
    {
      localKandianUrlImageView.setVisibility(i);
      return;
    }
  }
  
  public void setPlayMode(int paramInt)
  {
    this.playMode = paramInt;
  }
  
  public void setReportR5(String paramString)
  {
    this.aeJ = paramString;
  }
  
  public void setScaleType(int paramInt) {}
  
  public void setUseVid(boolean paramBoolean)
  {
    this.ajT = paramBoolean;
  }
  
  public void setVideoBusiType(int paramInt)
  {
    this.mBusiType = paramInt;
  }
  
  public void setVideoPlayListener(lfg paramlfg)
  {
    this.jdField_a_of_type_Lfg = paramlfg;
  }
  
  public void setVideoUrl(String paramString)
  {
    this.mVideoUrl = paramString;
  }
  
  public void setVideoVid(String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (!paramString.equals(this.mVid)) {
        stop();
      }
      this.mVid = paramString;
      return;
    }
    finally {}
  }
  
  public void stop()
  {
    QLog.d("gifvideo.VideoView", 2, "receive stop");
    if (!isInited()) {
      QLog.d("gifvideo.VideoView", 2, "has not inited, return");
    }
    while (this.Q.get() == 5) {
      return;
    }
    this.Q.set(5);
    ThreadManager.post(new VideoView.6(this), 10, null, false);
    this.aH.removeCallbacksAndMessages(null);
  }
  
  public static abstract interface a
  {
    public abstract boolean isShown();
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView
 * JD-Core Version:    0.7.0.1
 */