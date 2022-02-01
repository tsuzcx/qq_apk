package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GLRecognizeRegionView
{
  public static final int GOOD = 1;
  public static final int GREAT = 2;
  public static final int INVALID_STATUS = -1;
  public static final int MISS = 0;
  public static final int PERFECT = 3;
  private GLViewContext context;
  private boolean mAnimationHasStarted = false;
  private ArrayList<MatchStatusShow> mCacheMessageShow = new ArrayList();
  private MatchStatusShow mCurrentMessage;
  private RectF mExpandRegionSize = new RectF();
  private RectF mGoodTypefaceRegion = new RectF();
  private RectF mGreatTypefaceRegion = new RectF();
  private GLImageView mLeftBottom;
  private GLImageView mLeftTop;
  private LinkedList<MatchStatusShow> mMessageShowMgr = new LinkedList();
  private RectF mPerfectTypefaceRegion = new RectF();
  private RectF mRegionSize = new RectF();
  private GLImageView mRightBottom;
  private GLImageView mRightTop;
  private GLFrameImage mScoreStatus;
  private GLFrameImage mScoreStatusBackground;
  private GLFrameImage mScoreStatusMongolian;
  private StatusListener mStatusListener;
  private TranslateAnimation mTransformLeftBottom;
  private TranslateAnimation mTransformLeftTop;
  private TranslateAnimation mTransformRightBottom;
  private TranslateAnimation mTransformRightTop;
  private List<Animation> mVibrateAnimGreat;
  private List<Animation> mVibrateAnimPerfect;
  private List<GLImageView> mVibrateLayout;
  
  public GLRecognizeRegionView(GLViewContext paramGLViewContext, String paramString)
  {
    this.context = paramGLViewContext;
    this.mLeftTop = new GLImageView(paramGLViewContext, paramString);
    this.mLeftBottom = new GLImageView(paramGLViewContext, paramString);
    this.mRightTop = new GLImageView(paramGLViewContext, paramString);
    this.mRightBottom = new GLImageView(paramGLViewContext, paramString);
    this.mScoreStatus = new GLFrameImage(paramGLViewContext, paramString);
    this.mScoreStatusMongolian = new GLFrameImage(paramGLViewContext, paramString);
    this.mScoreStatusBackground = new GLFrameImage(paramGLViewContext, paramString);
    clearStatus();
  }
  
  private void changeScoreStatus(int paramInt)
  {
    this.mScoreStatusMongolian.setCurrentImage(paramInt);
    this.mScoreStatusMongolian.setVisibility(true);
    this.mScoreStatusMongolian.clearAnimation();
    this.mScoreStatusBackground.setCurrentImage(paramInt);
    this.mScoreStatusBackground.setVisibility(true);
    this.mScoreStatusBackground.clearAnimation();
    if (paramInt == 0)
    {
      this.mScoreStatus.setVisibility(false);
      this.mScoreStatus.clearAnimation();
    }
    for (;;)
    {
      setScoreStatusTypefaceBarRegion(paramInt);
      return;
      this.mScoreStatus.setCurrentImage(paramInt);
      this.mScoreStatus.setVisibility(true);
      this.mScoreStatus.clearAnimation();
    }
  }
  
  private void initAnimation()
  {
    float f1 = this.mRegionSize.centerX();
    float f2 = this.mRegionSize.centerY();
    LinearInterpolator localLinearInterpolator = new LinearInterpolator();
    RectF localRectF = this.mLeftTop.getImageClipDrawRegion();
    this.mTransformLeftTop = new TranslateAnimation(f1, localRectF.left, f2, localRectF.top);
    this.mTransformLeftTop.setDuration(200L);
    this.mTransformLeftTop.setInterpolator(localLinearInterpolator);
    localRectF = this.mLeftBottom.getImageClipDrawRegion();
    this.mTransformLeftBottom = new TranslateAnimation(f1, localRectF.left, f2, localRectF.top);
    this.mTransformLeftBottom.setDuration(200L);
    this.mTransformLeftBottom.setInterpolator(localLinearInterpolator);
    localRectF = this.mRightTop.getImageClipDrawRegion();
    this.mTransformRightTop = new TranslateAnimation(f1, localRectF.left, f2, localRectF.top);
    this.mTransformRightTop.setDuration(200L);
    this.mTransformRightTop.setInterpolator(localLinearInterpolator);
    localRectF = this.mRightBottom.getImageClipDrawRegion();
    this.mTransformRightBottom = new TranslateAnimation(f1, localRectF.left, f2, localRectF.top);
    this.mTransformRightBottom.setDuration(200L);
    this.mTransformRightBottom.setInterpolator(localLinearInterpolator);
    setupVibrateAnimation();
  }
  
  private void newGreatVibrateAnimation()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.mVibrateLayout.size())
    {
      localArrayList.add(setupSingleVibrateAnimation((GlView)this.mVibrateLayout.get(i), 75, 1));
      i += 1;
    }
    this.mVibrateAnimGreat = localArrayList;
  }
  
  private void newPerfectVibrateAnimation()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.mVibrateLayout.size())
    {
      localArrayList.add(setupSingleVibrateAnimation((GlView)this.mVibrateLayout.get(i), 75, 2));
      i += 1;
    }
    this.mVibrateAnimPerfect = localArrayList;
  }
  
  private void setScoreStatusInvisible()
  {
    this.mScoreStatus.setVisibility(false);
    this.mScoreStatusBackground.setVisibility(false);
    this.mScoreStatusMongolian.setVisibility(false);
  }
  
  private void setScoreStatusTypefaceBarRegion(int paramInt)
  {
    RectF localRectF = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (localRectF != null)
      {
        this.mScoreStatus.setImageRegion(localRectF);
        this.mScoreStatus.setImageClipDrawRegion(localRectF);
      }
      return;
      localRectF = this.mGoodTypefaceRegion;
      continue;
      localRectF = this.mGreatTypefaceRegion;
      continue;
      localRectF = this.mPerfectTypefaceRegion;
    }
  }
  
  private void setupVibrateAnimation()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.mLeftTop);
    localArrayList.add(this.mLeftBottom);
    localArrayList.add(this.mRightTop);
    localArrayList.add(this.mRightBottom);
    this.mVibrateLayout = localArrayList;
  }
  
  public void addMatchStatusShowToCache(MatchStatusShow paramMatchStatusShow)
  {
    this.mCacheMessageShow.add(paramMatchStatusShow);
  }
  
  public void addQueueScoreStatus(int paramInt)
  {
    if (paramInt > -1)
    {
      MatchStatusShow localMatchStatusShow = getNewMatchStatusShow();
      localMatchStatusShow.status = paramInt;
      this.mMessageShowMgr.add(localMatchStatusShow);
    }
  }
  
  public void clearStatus()
  {
    this.mMessageShowMgr.clear();
    this.mCurrentMessage = null;
    this.mAnimationHasStarted = false;
  }
  
  public void draw()
  {
    int i = 1;
    startAnimation();
    this.mLeftTop.draw();
    this.mLeftBottom.draw();
    this.mRightTop.draw();
    this.mRightBottom.draw();
    if ((this.mCurrentMessage != null) && (this.mCurrentMessage.checkHaveStopped()))
    {
      addMatchStatusShowToCache(this.mCurrentMessage);
      this.mCurrentMessage = null;
      setScoreStatusInvisible();
    }
    if (this.mMessageShowMgr.isEmpty())
    {
      if (this.mCurrentMessage == null) {
        setScoreStatusInvisible();
      }
      this.mScoreStatusMongolian.draw();
      this.mScoreStatusBackground.draw();
      this.mScoreStatus.draw();
      return;
    }
    Object localObject = (MatchStatusShow)this.mMessageShowMgr.removeLast();
    if (this.mCurrentMessage != null)
    {
      if (((MatchStatusShow)localObject).status <= this.mCurrentMessage.status) {
        break label390;
      }
      this.mCurrentMessage.setHaveStopped();
      addMatchStatusShowToCache(this.mCurrentMessage);
      this.mCurrentMessage = ((MatchStatusShow)localObject);
    }
    for (;;)
    {
      this.mMessageShowMgr.clear();
      if (i != 0)
      {
        changeScoreStatus(this.mCurrentMessage.status);
        if (this.mStatusListener != null) {
          this.mStatusListener.onStatusChanged(this.mCurrentMessage.status);
        }
        localObject = this.mCurrentMessage.getMongolianAnimation();
        this.mScoreStatusMongolian.startAnimation((Animation)localObject);
        localObject = this.mCurrentMessage.getBackGroundAnimation();
        if (localObject != null) {
          this.mScoreStatusBackground.startAnimation((Animation)localObject);
        }
        localObject = this.mCurrentMessage.getTypefaceAnimation();
        if (localObject != null) {
          this.mScoreStatus.startAnimation((Animation)localObject);
        }
        if (this.mCurrentMessage.status == 2)
        {
          newGreatVibrateAnimation();
          startVibrateAnimation(this.mVibrateAnimGreat);
        }
        if (this.mCurrentMessage.status == 3)
        {
          newPerfectVibrateAnimation();
          startVibrateAnimation(this.mVibrateAnimPerfect);
        }
        playAudioTips(this.mCurrentMessage.status);
        break;
        this.mCurrentMessage = ((MatchStatusShow)localObject);
        continue;
      }
      DanceLog.print("GLRecognizeRegionView", "newMessageItem=false  mCurrentMessage=" + this.mCurrentMessage.getMessageStatus() + " topMessage=" + ((MatchStatusShow)localObject).getMessageStatus() + this.mCurrentMessage.getAnimationLog());
      break;
      label390:
      i = 0;
    }
  }
  
  public MatchStatusShow getNewMatchStatusShow()
  {
    if (this.mCacheMessageShow.size() > 0) {}
    for (MatchStatusShow localMatchStatusShow = (MatchStatusShow)this.mCacheMessageShow.remove(0);; localMatchStatusShow = new MatchStatusShow())
    {
      localMatchStatusShow.resetStatus();
      return localMatchStatusShow;
    }
  }
  
  public void playAudioTips(int paramInt)
  {
    ResourceManager.GamingResource localGamingResource = ResourceManager.getInstance().mGamingResource;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.context.playSound(localGamingResource.missSound);
      return;
    case 1: 
      this.context.playSound(localGamingResource.goodSound);
      return;
    case 2: 
      this.context.playSound(localGamingResource.greatSound);
      return;
    }
    this.context.playSound(localGamingResource.perfectSound);
  }
  
  public void setExpandRecognizeRegion(RectF paramRectF)
  {
    this.mExpandRegionSize.set(paramRectF);
  }
  
  public void setLeftBottomImage(String paramString)
  {
    this.mLeftBottom.setImageRes(paramString);
  }
  
  public void setLeftTopImage(String paramString)
  {
    this.mLeftTop.setImageRes(paramString);
  }
  
  public void setRecognizeRegion(RectF paramRectF)
  {
    if (!this.mRegionSize.equals(paramRectF))
    {
      this.mRegionSize.set(paramRectF);
      float f = DisplayUtils.pixelToRealPixel(82.0F);
      RectF localRectF = new RectF();
      localRectF.left = paramRectF.left;
      localRectF.top = paramRectF.top;
      localRectF.right = (localRectF.left + f);
      localRectF.bottom = (localRectF.top + f);
      this.mLeftTop.setImageRegion(localRectF);
      this.mLeftTop.setImageClipDrawRegion(localRectF);
      localRectF.left = paramRectF.left;
      localRectF.top = (paramRectF.bottom - f);
      localRectF.right = (paramRectF.left + f);
      localRectF.bottom = paramRectF.bottom;
      this.mLeftBottom.setImageRegion(localRectF);
      this.mLeftBottom.setImageClipDrawRegion(localRectF);
      localRectF.left = (paramRectF.right - f);
      localRectF.top = paramRectF.top;
      localRectF.right = paramRectF.right;
      localRectF.bottom = (paramRectF.top + f);
      this.mRightTop.setImageRegion(localRectF);
      this.mRightTop.setImageClipDrawRegion(localRectF);
      localRectF.left = (paramRectF.right - f);
      localRectF.top = (paramRectF.bottom - f);
      localRectF.right = paramRectF.right;
      localRectF.bottom = paramRectF.bottom;
      this.mRightBottom.setImageRegion(localRectF);
      this.mRightBottom.setImageClipDrawRegion(localRectF);
      this.context.mapNormalRegion(this.mRegionSize);
      initAnimation();
    }
  }
  
  public void setRightBottomImage(String paramString)
  {
    this.mRightBottom.setImageRes(paramString);
  }
  
  public void setRightTopImage(String paramString)
  {
    this.mRightTop.setImageRes(paramString);
  }
  
  public void setScoreStatusBackgroundBarRegion(RectF paramRectF)
  {
    this.mScoreStatusBackground.setImageRegion(paramRectF);
    this.mScoreStatusBackground.setImageClipDrawRegion(paramRectF);
  }
  
  public void setScoreStatusBackgroundImage(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(0, paramString1);
    localArrayList.add(1, paramString2);
    localArrayList.add(2, paramString3);
    localArrayList.add(3, paramString4);
    this.mScoreStatusBackground.setAnimationFrames(localArrayList);
    this.mScoreStatusBackground.setLoadTextureMode(0);
    this.mScoreStatusBackground.initAnimationFrame();
    this.mScoreStatusBackground.setVisibility(false);
  }
  
  public void setScoreStatusMongolianBarRegion(RectF paramRectF)
  {
    this.mScoreStatusMongolian.setImageRegion(paramRectF);
    this.mScoreStatusMongolian.setImageClipDrawRegion(paramRectF);
  }
  
  public void setScoreStatusMongolianImage(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(0, paramString1);
    localArrayList.add(1, paramString2);
    localArrayList.add(2, paramString3);
    localArrayList.add(3, paramString4);
    this.mScoreStatusMongolian.setAnimationFrames(localArrayList);
    this.mScoreStatusMongolian.setLoadTextureMode(0);
    this.mScoreStatusMongolian.initAnimationFrame();
    this.mScoreStatusMongolian.setVisibility(false);
  }
  
  public void setScoreStatusTypefaceImage(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(0, paramString1);
    localArrayList.add(1, paramString2);
    localArrayList.add(2, paramString3);
    localArrayList.add(3, paramString4);
    this.mScoreStatus.setAnimationFrames(localArrayList);
    this.mScoreStatus.setLoadTextureMode(0);
    this.mScoreStatus.initAnimationFrame();
    this.mScoreStatus.setVisibility(false);
  }
  
  public void setStatusListner(StatusListener paramStatusListener)
  {
    this.mStatusListener = paramStatusListener;
  }
  
  public void setVisibility(boolean paramBoolean)
  {
    this.mLeftTop.setVisibility(paramBoolean);
    this.mLeftBottom.setVisibility(paramBoolean);
    this.mRightTop.setVisibility(paramBoolean);
    this.mRightBottom.setVisibility(paramBoolean);
  }
  
  public AnimationSet setupSingleVibrateAnimation(GlView paramGlView, int paramInt1, int paramInt2)
  {
    float f1 = paramGlView.mClipRegion.left;
    float f2 = paramGlView.mClipRegion.top;
    float f3 = paramGlView.context.getRealVideoRatio();
    AnimationSet localAnimationSet = new AnimationSet(true);
    int i = 0;
    if (i < paramInt2)
    {
      if (i == 0) {}
      for (paramGlView = new TranslateAnimation(f1, f1 - 10.0F * f3, f2, f2 - 18.0F * f3);; paramGlView = new TranslateAnimation(0.0F, -10.0F * f3, 0.0F, -18.0F * f3))
      {
        paramGlView.setDuration(paramInt1);
        paramGlView.setStartOffset(i * 4 * paramInt1);
        paramGlView.setFillEnabled(true);
        paramGlView.setFillBefore(false);
        paramGlView.setFillAfter(true);
        localAnimationSet.addAnimation(paramGlView);
        paramGlView = new TranslateAnimation(0.0F, 20.0F * f3, 0.0F, 36.0F * f3);
        paramGlView.setStartOffset(i * 4 * paramInt1 + paramInt1 * 1);
        paramGlView.setDuration(paramInt1);
        paramGlView.setFillEnabled(true);
        paramGlView.setFillBefore(false);
        paramGlView.setFillAfter(true);
        localAnimationSet.addAnimation(paramGlView);
        paramGlView = new TranslateAnimation(0.0F, 0.0F, 0.0F, -23.0F * f3);
        paramGlView.setStartOffset(i * 4 * paramInt1 + paramInt1 * 2);
        paramGlView.setDuration(paramInt1);
        paramGlView.setFillEnabled(true);
        paramGlView.setFillBefore(false);
        paramGlView.setFillAfter(true);
        localAnimationSet.addAnimation(paramGlView);
        paramGlView = new TranslateAnimation(0.0F, -10.0F * f3, 0.0F, 5.0F * f3);
        paramGlView.setStartOffset(i * 4 * paramInt1 + paramInt1 * 3);
        paramGlView.setDuration(paramInt1);
        paramGlView.setFillEnabled(true);
        paramGlView.setFillBefore(false);
        paramGlView.setFillAfter(true);
        localAnimationSet.addAnimation(paramGlView);
        i += 1;
        break;
      }
    }
    return localAnimationSet;
  }
  
  public void startAnimation()
  {
    if (!this.mAnimationHasStarted)
    {
      this.mLeftTop.startAnimation(this.mTransformLeftTop);
      this.mLeftBottom.startAnimation(this.mTransformLeftBottom);
      this.mRightTop.startAnimation(this.mTransformRightTop);
      this.mRightBottom.startAnimation(this.mTransformRightBottom);
      this.mAnimationHasStarted = true;
    }
  }
  
  public void startVibrateAnimation(List<Animation> paramList)
  {
    if (this.mVibrateLayout.size() != paramList.size()) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.mVibrateLayout.size())
      {
        GLImageView localGLImageView = (GLImageView)this.mVibrateLayout.get(i);
        localGLImageView.clearAnimation();
        localGLImageView.startAnimation((Animation)paramList.get(i));
        i += 1;
      }
    }
  }
  
  public void updateScoreStatusTypefaceRegion(int paramInt)
  {
    int i = this.context.getSurfaceViewSize().width();
    GLImage localGLImage = this.mScoreStatus.getImageByIndex(1);
    int j = (i - DisplayUtils.pixelToRealPixel(localGLImage.getWidth())) / 2;
    this.mGoodTypefaceRegion.set(j, paramInt, i - j, DisplayUtils.pixelToRealPixel(localGLImage.getHeight()) + paramInt);
    localGLImage = this.mScoreStatus.getImageByIndex(2);
    j = (i - DisplayUtils.pixelToRealPixel(localGLImage.getWidth())) / 2;
    this.mGreatTypefaceRegion.set(j, paramInt, i - j, DisplayUtils.pixelToRealPixel(localGLImage.getHeight()) + paramInt);
    localGLImage = this.mScoreStatus.getImageByIndex(3);
    j = (i - DisplayUtils.pixelToRealPixel(localGLImage.getWidth())) / 2;
    this.mPerfectTypefaceRegion.set(j, paramInt, i - j, DisplayUtils.pixelToRealPixel(localGLImage.getHeight()) + paramInt);
  }
  
  public static class MatchStatusShow
    implements Animation.AnimationListener
  {
    AnimationSet backgroundAnimation;
    boolean haveBackgroundStop;
    boolean haveMongolianStop;
    boolean haveTypefaceStop;
    AnimationSet mongolianAnimation;
    int status;
    AnimationSet typefaceAnimation;
    
    MatchStatusShow()
    {
      resetStatus();
    }
    
    private AnimationSet getMatchedTypeAnimation()
    {
      AnimationSet localAnimationSet = new AnimationSet(false);
      Object localObject = new AlphaAnimation(0.0F, 1.0F);
      ((AlphaAnimation)localObject).setDuration(100L);
      ((AlphaAnimation)localObject).setFillEnabled(true);
      ((AlphaAnimation)localObject).setFillBefore(true);
      localAnimationSet.addAnimation((Animation)localObject);
      localObject = new ScaleAnimation(3.0F, 1.5F, 3.0F, 1.5F, 1, 0.5F, 1, 0.5F);
      ((ScaleAnimation)localObject).setDuration(100L);
      ((ScaleAnimation)localObject).setFillEnabled(true);
      ((ScaleAnimation)localObject).setFillBefore(true);
      localAnimationSet.addAnimation((Animation)localObject);
      localObject = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject).setDuration(100L);
      ((AlphaAnimation)localObject).setStartOffset(500L);
      ((AlphaAnimation)localObject).setFillEnabled(true);
      ((AlphaAnimation)localObject).setFillBefore(false);
      localAnimationSet.addAnimation((Animation)localObject);
      localObject = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      ((ScaleAnimation)localObject).setDuration(100L);
      ((ScaleAnimation)localObject).setStartOffset(500L);
      ((ScaleAnimation)localObject).setFillEnabled(true);
      ((ScaleAnimation)localObject).setFillBefore(false);
      localAnimationSet.addAnimation((Animation)localObject);
      localAnimationSet.setFillEnabled(true);
      localAnimationSet.setFillAfter(true);
      localAnimationSet.setAnimationListener(this);
      return localAnimationSet;
    }
    
    private AnimationSet getMissTypeAnimation()
    {
      AnimationSet localAnimationSet = new AnimationSet(false);
      Object localObject = new AlphaAnimation(0.0F, 1.0F);
      ((AlphaAnimation)localObject).setDuration(150L);
      ((AlphaAnimation)localObject).setFillEnabled(true);
      ((AlphaAnimation)localObject).setFillBefore(true);
      localAnimationSet.addAnimation((Animation)localObject);
      localObject = new ScaleAnimation(3.0F, 1.0F, 3.0F, 1.0F, 1, 0.5F, 1, 0.5F);
      ((ScaleAnimation)localObject).setDuration(150L);
      ((ScaleAnimation)localObject).setFillEnabled(true);
      ((ScaleAnimation)localObject).setFillBefore(true);
      localAnimationSet.addAnimation((Animation)localObject);
      localObject = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject).setDuration(100L);
      ((AlphaAnimation)localObject).setStartOffset(500L);
      ((AlphaAnimation)localObject).setFillEnabled(true);
      ((AlphaAnimation)localObject).setFillBefore(false);
      localAnimationSet.addAnimation((Animation)localObject);
      localObject = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      ((ScaleAnimation)localObject).setDuration(100L);
      ((ScaleAnimation)localObject).setStartOffset(500L);
      ((ScaleAnimation)localObject).setFillEnabled(true);
      ((ScaleAnimation)localObject).setFillBefore(false);
      localAnimationSet.addAnimation((Animation)localObject);
      localAnimationSet.setFillEnabled(true);
      localAnimationSet.setFillAfter(true);
      localAnimationSet.setAnimationListener(this);
      return localAnimationSet;
    }
    
    private AnimationSet getPerfectTypeAnimation()
    {
      AnimationSet localAnimationSet = new AnimationSet(false);
      Object localObject = new AlphaAnimation(0.0F, 1.0F);
      ((AlphaAnimation)localObject).setDuration(100L);
      ((AlphaAnimation)localObject).setFillEnabled(true);
      ((AlphaAnimation)localObject).setFillBefore(true);
      localAnimationSet.addAnimation((Animation)localObject);
      localObject = new ScaleAnimation(3.0F, 1.5F, 3.0F, 1.5F, 1, 0.5F, 1, 0.5F);
      ((ScaleAnimation)localObject).setDuration(100L);
      ((ScaleAnimation)localObject).setFillEnabled(true);
      ((ScaleAnimation)localObject).setFillBefore(true);
      localAnimationSet.addAnimation((Animation)localObject);
      localObject = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject).setDuration(100L);
      ((AlphaAnimation)localObject).setStartOffset(500L);
      ((AlphaAnimation)localObject).setFillEnabled(true);
      ((AlphaAnimation)localObject).setFillBefore(false);
      localAnimationSet.addAnimation((Animation)localObject);
      localObject = new ScaleAnimation(1.5F, 2.5F, 1.5F, 0.05F, 1, 0.5F, 1, 0.5F);
      ((ScaleAnimation)localObject).setDuration(100L);
      ((ScaleAnimation)localObject).setStartOffset(500L);
      ((ScaleAnimation)localObject).setFillEnabled(true);
      ((ScaleAnimation)localObject).setFillBefore(false);
      localAnimationSet.addAnimation((Animation)localObject);
      localAnimationSet.setFillEnabled(true);
      localAnimationSet.setFillAfter(true);
      localAnimationSet.setAnimationListener(this);
      return localAnimationSet;
    }
    
    private AnimationSet getTypefaceAnimation()
    {
      this.typefaceAnimation = null;
      switch (this.status)
      {
      }
      for (;;)
      {
        if (this.typefaceAnimation == null) {
          this.haveTypefaceStop = true;
        }
        return this.typefaceAnimation;
        this.typefaceAnimation = null;
        continue;
        this.typefaceAnimation = getMatchedTypeAnimation();
        continue;
        this.typefaceAnimation = getPerfectTypeAnimation();
      }
    }
    
    boolean checkHaveStopped()
    {
      return (this.haveMongolianStop) && (this.haveBackgroundStop) && (this.haveTypefaceStop);
    }
    
    String getAnimationLog()
    {
      return " haveMongolianStop=" + this.haveMongolianStop + " haveBackgroundStop=" + this.haveBackgroundStop + " haveTypefaceStop=" + this.haveTypefaceStop;
    }
    
    AnimationSet getBackGroundAnimation()
    {
      this.backgroundAnimation = null;
      switch (this.status)
      {
      }
      for (;;)
      {
        if (this.backgroundAnimation == null) {
          this.haveBackgroundStop = true;
        }
        return this.backgroundAnimation;
        this.backgroundAnimation = getMissTypeAnimation();
        continue;
        this.backgroundAnimation = newMongolianAnimation();
        continue;
        this.backgroundAnimation = newMongolianAnimation();
        continue;
        this.backgroundAnimation = newMongolianAnimation();
      }
    }
    
    String getMessageStatus()
    {
      switch (this.status)
      {
      default: 
        return "unKnown";
      case 0: 
        return "MISS";
      case 1: 
        return "GOOD";
      case 2: 
        return "GREAT";
      }
      return "PERFECT";
    }
    
    AnimationSet getMongolianAnimation()
    {
      this.mongolianAnimation = newMongolianAnimation();
      return this.mongolianAnimation;
    }
    
    AnimationSet newMongolianAnimation()
    {
      AnimationSet localAnimationSet = new AnimationSet(false);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(150L);
      localAlphaAnimation.setFillEnabled(true);
      localAlphaAnimation.setFillBefore(true);
      localAnimationSet.addAnimation(localAlphaAnimation);
      localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(100L);
      localAlphaAnimation.setStartOffset(500L);
      localAlphaAnimation.setFillEnabled(true);
      localAlphaAnimation.setFillBefore(false);
      localAnimationSet.addAnimation(localAlphaAnimation);
      localAnimationSet.setFillEnabled(true);
      localAnimationSet.setFillAfter(true);
      localAnimationSet.setAnimationListener(this);
      return localAnimationSet;
    }
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      if (this.mongolianAnimation == paramAnimation) {
        this.haveMongolianStop = true;
      }
      do
      {
        return;
        if (this.backgroundAnimation == paramAnimation)
        {
          this.haveBackgroundStop = true;
          return;
        }
      } while (this.typefaceAnimation != paramAnimation);
      this.haveTypefaceStop = true;
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
    
    void resetStatus()
    {
      this.mongolianAnimation = null;
      this.backgroundAnimation = null;
      this.typefaceAnimation = null;
      this.haveMongolianStop = false;
      this.haveBackgroundStop = false;
      this.haveTypefaceStop = false;
    }
    
    void setHaveStopped()
    {
      this.haveMongolianStop = true;
      this.haveBackgroundStop = true;
      this.haveTypefaceStop = true;
    }
  }
  
  public static abstract interface StatusListener
  {
    public abstract void onStatusChanged(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLRecognizeRegionView
 * JD-Core Version:    0.7.0.1
 */