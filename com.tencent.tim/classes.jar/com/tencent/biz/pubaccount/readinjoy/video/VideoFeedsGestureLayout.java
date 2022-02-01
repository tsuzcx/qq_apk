package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.qphone.base.util.QLog;
import kbp;
import kct;
import msx;
import muh;
import mye;
import mye.b;
import mzj;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoFeedsGestureLayout
  extends RelativeLayout
{
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$a;
  private b jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$b;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private muh jdField_a_of_type_Muh;
  private mye jdField_a_of_type_Mye;
  private int aUC;
  private int aUD = 0;
  private int aUE;
  private int aUF;
  private int aUG = -1;
  private int aUH;
  private int aUI;
  private boolean aox;
  private VideoFeedsPlayManager jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private msx jdField_b_of_type_Msx;
  private SeekBar f;
  private float jO;
  private Activity mActivity;
  private AudioManager mAudioManager;
  private long mChannelID;
  private GestureDetector mDetector;
  private long mDoubleClickSystemTime;
  private boolean mIsFullScreen;
  private boolean mIsInited;
  private boolean mIsScrolling;
  private int mMode;
  private long wQ;
  
  public VideoFeedsGestureLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoFeedsGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public VideoFeedsGestureLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void ot(boolean paramBoolean)
  {
    if (this.mActivity == null) {
      return;
    }
    ViewGroup localViewGroup;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      localViewGroup = (ViewGroup)this.mActivity.getWindow().getDecorView();
      i = 0;
      label31:
      if (i < localViewGroup.getChildCount())
      {
        View localView = localViewGroup.getChildAt(i);
        if ((localView == null) || (!(localView instanceof ViewGroup))) {
          break label103;
        }
        localViewGroup = (ViewGroup)localView;
      }
    }
    label103:
    for (;;)
    {
      if ((localViewGroup instanceof TopGestureLayout))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localViewGroup);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
        return;
      }
      i += 1;
      break label31;
    }
  }
  
  public long cU()
  {
    return this.wQ;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.wQ = System.currentTimeMillis();
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void h(int paramInt, float paramFloat)
  {
    if (!this.mIsFullScreen) {
      return;
    }
    if (paramInt == 0)
    {
      this.mIsScrolling = false;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$a != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$a.G(this, 1);
      }
      if (this.mAudioManager == null)
      {
        this.mAudioManager = ((AudioManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio"));
        this.aUH = this.mAudioManager.getStreamMaxVolume(3);
      }
    }
    label192:
    label203:
    label337:
    long l2;
    label267:
    label273:
    label434:
    label448:
    long l1;
    switch (paramInt)
    {
    default: 
    case 1: 
    case 2: 
      int i;
      do
      {
        this.aUD = paramInt;
        return;
        if (this.mIsScrolling) {
          break;
        }
        this.mIsScrolling = true;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$a == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$a.G(this, 2);
        break;
        if (this.aUD == 0) {
          this.aUE = this.mAudioManager.getStreamVolume(3);
        }
        j = (int)(this.aUH * paramFloat) + this.aUE;
        if (j > this.aUH)
        {
          i = this.aUH;
          if (this.mMode != 2) {
            break label267;
          }
          j = 2;
          if (i != 0) {
            break label273;
          }
          mzj.a().g(true, "user_gesture", j);
        }
        for (;;)
        {
          this.mAudioManager.setStreamVolume(3, i, 0);
          this.jdField_a_of_type_Muh.a(1, i / this.aUH, 0L, 0L);
          break;
          i = j;
          if (j >= 0) {
            break label192;
          }
          i = 0;
          break label192;
          j = 1;
          break label203;
          mzj.a().g(false, "user_gesture", j);
        }
      } while (this.jdField_b_of_type_Msx == null);
      if (this.aUD == 0)
      {
        if (this.jdField_b_of_type_Msx.isAutoBrightness()) {
          this.aox = true;
        }
        if (this.aUG != -1) {
          break label448;
        }
        if (!this.aox) {
          break label434;
        }
        this.aUF = 127;
        if (QLog.isColorLevel()) {
          QLog.i("VideoFeedsItemFrameLayout", 2, "mBeginBrightness = " + this.aUF);
        }
      }
      int j = (int)(255.0F * paramFloat) + this.aUF;
      if (j > 255) {
        i = 255;
      }
      for (;;)
      {
        this.jdField_b_of_type_Msx.setScreenBrightness(i / 255.0F);
        this.jdField_a_of_type_Muh.a(2, i / 255.0F, 0L, 0L);
        this.aUG = i;
        break;
        this.aUF = this.jdField_b_of_type_Msx.pJ();
        break label337;
        this.aUF = this.aUG;
        break label337;
        i = j;
        if (j < 0) {
          i = 0;
        }
      }
    case 3: 
      if ((this.jdField_a_of_type_Mye != null) && (this.jdField_a_of_type_Mye.c() != null))
      {
        l2 = this.jdField_a_of_type_Mye.c().videoDuration * 1000;
        l1 = this.jdField_a_of_type_Mye.cZ();
      }
      break;
    }
    for (;;)
    {
      label517:
      if ((this.aUD == 0) && (l2 != 0L)) {
        this.jO = ((float)l1 / (float)l2);
      }
      float f2 = this.jO + paramFloat;
      float f1;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      for (;;)
      {
        this.aUI = ((int)(f1 * (float)l2));
        this.jdField_a_of_type_Muh.a(3, paramFloat, this.aUI, l2);
        break;
        if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null)
        {
          l2 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.getVideoDuration();
          l1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.cV();
          break label517;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$b == null) {
          break label770;
        }
        l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$b.getVideoDuration();
        l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$b.cV();
        break label517;
        f1 = f2;
        if (f2 < 0.0F) {
          f1 = 0.0F;
        }
      }
      if (this.aUD == 3)
      {
        if (this.jdField_a_of_type_Mye == null) {
          break label725;
        }
        this.jdField_a_of_type_Mye.seekTo(this.aUI);
        if (this.f != null) {
          this.f.setProgress(this.aUI / 1000);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Muh.a(0, 0.0F, 0L, 0L);
        break;
        label725:
        if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.Z(this.aUI, true);
        } else if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$b != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$b.seekTo(this.aUI);
        }
      }
      label770:
      l1 = 0L;
      l2 = 0L;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mDetector == null) {
      this.mDetector = new GestureDetector(getContext(), new c());
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    JSONObject localJSONObject;
    if ((paramMotionEvent.getAction() == 1) && (this.aUC != 0)) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("channel_id", this.mChannelID);
      switch (this.aUC)
      {
      default: 
        this.aUC = 0;
        h(0, 0.0F);
        this.mDetector.onTouchEvent(paramMotionEvent);
        if ((this.mIsFullScreen) || (this.mMode != 1)) {
          bool = true;
        }
        return bool;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        continue;
        kbp.b(null, null, "0X8008A42", "0X8008A42", 0, 0, "", "", "", kct.d(localJSONObject), false);
        continue;
        kbp.b(null, null, "0X8008A43", "0X8008A43", 0, 0, "", "", "", kct.d(localJSONObject), false);
        continue;
        kbp.b(null, null, "0X8008A41", "0X8008A41", 0, 0, "", "", "", kct.d(localJSONObject), false);
      }
    }
  }
  
  public void resetUI()
  {
    if (this.jdField_a_of_type_Muh != null) {
      this.jdField_a_of_type_Muh.resetUI();
    }
    this.aUD = 0;
  }
  
  public void setChannelID(long paramLong)
  {
    this.mChannelID = paramLong;
  }
  
  public void setContext(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public void setIsInFullScreen(boolean paramBoolean)
  {
    this.mIsFullScreen = paramBoolean;
    if ((this.mIsFullScreen) && (!this.mIsInited)) {
      this.jdField_a_of_type_Muh = new muh();
    }
    try
    {
      this.jdField_a_of_type_Muh.a(this.mActivity, this);
      this.mIsInited = true;
      if (this.mIsFullScreen)
      {
        ot(false);
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoFeedsItemFrameLayout", 2, "wgs error =" + localException.getMessage());
          }
        }
        ot(true);
      } while (this.jdField_b_of_type_Msx == null);
      this.jdField_b_of_type_Msx.recoveryScreenBrightness();
      this.aUG = -1;
    }
  }
  
  @Deprecated
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnCustomClickListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$a = parama;
  }
  
  public void setSeekBar(SeekBar paramSeekBar)
  {
    this.f = paramSeekBar;
  }
  
  public void setVideoBrightnessController(msx parammsx)
  {
    this.jdField_b_of_type_Msx = parammsx;
  }
  
  public void setVideoPlayManager(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$b = paramb;
  }
  
  public void setVideoPlayManager(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.mMode = 2;
  }
  
  public void setVideoPlayManager(mye parammye)
  {
    this.jdField_a_of_type_Mye = parammye;
    this.mMode = 1;
  }
  
  public static abstract interface a
  {
    public abstract void G(View paramView, int paramInt);
    
    public abstract void cS(View paramView);
    
    public abstract void cb(View paramView);
    
    public abstract void l(View paramView, int paramInt1, int paramInt2);
  }
  
  public static abstract interface b
  {
    public abstract long cV();
    
    public abstract long getVideoDuration();
    
    public abstract void seekTo(int paramInt);
  }
  
  class c
    extends GestureDetector.SimpleOnGestureListener
  {
    c() {}
    
    public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        return false;
        if (VideoFeedsGestureLayout.a(VideoFeedsGestureLayout.this) != null)
        {
          VideoFeedsGestureLayout.a(VideoFeedsGestureLayout.this, SystemClock.uptimeMillis());
          VideoFeedsGestureLayout.a(VideoFeedsGestureLayout.this).l(VideoFeedsGestureLayout.this, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        }
      }
    }
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      if (VideoFeedsGestureLayout.a(VideoFeedsGestureLayout.this) != null) {
        VideoFeedsGestureLayout.a(VideoFeedsGestureLayout.this).cS(VideoFeedsGestureLayout.this);
      }
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      paramFloat1 = 1.0F;
      int i = muj.c(VideoFeedsGestureLayout.a(VideoFeedsGestureLayout.this))[0];
      i = muj.c(VideoFeedsGestureLayout.a(VideoFeedsGestureLayout.this))[1];
      paramFloat2 = paramMotionEvent1.getY() - paramMotionEvent2.getY();
      float f = paramMotionEvent2.getX() - paramMotionEvent1.getX();
      if (VideoFeedsGestureLayout.a(VideoFeedsGestureLayout.this) == 0)
      {
        if (Math.abs(f) - Math.abs(paramFloat2) >= 0.0F) {
          break label154;
        }
        if (paramMotionEvent1.getX() >= VideoFeedsGestureLayout.this.getWidth() / 2) {
          break label142;
        }
        VideoFeedsGestureLayout.a(VideoFeedsGestureLayout.this, 2);
      }
      switch (VideoFeedsGestureLayout.a(VideoFeedsGestureLayout.this))
      {
      default: 
      case 1: 
      case 2: 
        label142:
        label154:
        do
        {
          return false;
          VideoFeedsGestureLayout.a(VideoFeedsGestureLayout.this, 1);
          break;
          VideoFeedsGestureLayout.a(VideoFeedsGestureLayout.this, 3);
          break;
        } while (VideoFeedsGestureLayout.a(VideoFeedsGestureLayout.this) == null);
        paramFloat2 /= VideoFeedsGestureLayout.this.getHeight() / 2;
        if (Math.abs(paramFloat2) > 1.0F) {
          if (paramFloat2 <= 1.0F) {
            break;
          }
        }
        break;
      }
      for (;;)
      {
        VideoFeedsGestureLayout.this.h(VideoFeedsGestureLayout.a(VideoFeedsGestureLayout.this), paramFloat1);
        return false;
        paramFloat1 = -1.0F;
        continue;
        if (VideoFeedsGestureLayout.a(VideoFeedsGestureLayout.this) == null) {
          break;
        }
        paramFloat2 = f / (VideoFeedsGestureLayout.this.getWidth() / 4 * 3);
        if (Math.abs(paramFloat2) > 1.0F) {
          if (paramFloat2 <= 1.0F) {}
        }
        for (;;)
        {
          VideoFeedsGestureLayout.this.h(VideoFeedsGestureLayout.a(VideoFeedsGestureLayout.this), paramFloat1);
          return false;
          paramFloat1 = -1.0F;
          continue;
          paramFloat1 = paramFloat2;
        }
        paramFloat1 = paramFloat2;
      }
    }
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      if ((VideoFeedsGestureLayout.a(VideoFeedsGestureLayout.this) != null) && (SystemClock.uptimeMillis() - VideoFeedsGestureLayout.a(VideoFeedsGestureLayout.this) > 500L)) {
        VideoFeedsGestureLayout.a(VideoFeedsGestureLayout.this).cb(VideoFeedsGestureLayout.this);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout
 * JD-Core Version:    0.7.0.1
 */