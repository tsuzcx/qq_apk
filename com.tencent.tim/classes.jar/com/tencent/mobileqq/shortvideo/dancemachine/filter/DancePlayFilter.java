package com.tencent.mobileqq.shortvideo.dancemachine.filter;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import com.tencent.mobileqq.shortvideo.dancemachine.DisplayUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.GLAudioWaveN;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoy;
import com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoyManager;
import com.tencent.mobileqq.shortvideo.dancemachine.GLLyricsManager;
import com.tencent.mobileqq.shortvideo.dancemachine.GLProgressBar;
import com.tencent.mobileqq.shortvideo.dancemachine.GLProgressBar.ProgressBarListener;
import com.tencent.mobileqq.shortvideo.dancemachine.GLRecognizeRegionView;
import com.tencent.mobileqq.shortvideo.dancemachine.GLScoreBoard;
import com.tencent.mobileqq.shortvideo.dancemachine.GLViewContext;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.GameNumberResource;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.GamingResource;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.GeneralResource;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.LBGeneralResource;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQDanceEventHandler;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import java.util.List;
import java.util.TreeSet;

public class DancePlayFilter
  extends DanceBaseFilter
  implements Animation.AnimationListener, GLProgressBar.ProgressBarListener
{
  private AnimationSet mAnimGreatPro;
  private AnimationSet mAnimPerfectPro;
  private GLAudioWaveN mAudioWave;
  private GLLittleBoyManager mBoyManager;
  private boolean mHaveBackgoundAudioStarted = false;
  private boolean mHaveStartProgress;
  private GLLyricsManager mLyricsManager;
  private GLProgressBar mProgress;
  private GLRecognizeRegionView mRecognizeRegion;
  private GLImageView mSceneImageBg;
  private GLScoreBoard mScoreBoard;
  private long mStartRecordMis;
  private RectF mTempSize = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
  private TranslateAnimation mTransformProgress;
  
  public DancePlayFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  private void onDrawOtherObject()
  {
    this.mSceneImageBg.draw();
    this.mAudioWave.draw();
    this.mBoyManager.drawFrame();
    int i = this.mBoyManager.getShowStatus();
    this.mRecognizeRegion.addQueueScoreStatus(i);
    this.mRecognizeRegion.draw();
    this.mProgress.draw();
    this.mScoreBoard.setScore(this.mBoyManager.getTotalScore());
    this.mTempSize.set(this.mProgress.getCurrentDrawRegionSize());
    this.mDanceManager.getContext().unmapNormalRegion(this.mTempSize);
    this.mScoreBoard.changeParentSize(this.mTempSize);
    this.mScoreBoard.draw();
    this.mLyricsManager.drawFrame();
  }
  
  public TreeSet<GLLittleBoy> getCurrentVisible()
  {
    if (this.mBoyManager != null) {
      return this.mBoyManager.getItems();
    }
    return null;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.mTransformProgress)
    {
      this.mStartRecordMis = SystemClock.uptimeMillis();
      this.mHaveStartProgress = true;
      this.mBoyManager.updateStartTimestamp(this.mStartRecordMis);
      this.mLyricsManager.updateStartTimestamp(this.mStartRecordMis);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onChangeCamera(int paramInt) {}
  
  public void onCloseClicked()
  {
    progressMax();
  }
  
  public void onDrawFrame()
  {
    if (this.mHaveStartProgress)
    {
      this.mProgress.setProgress(SystemClock.uptimeMillis() - this.mStartRecordMis);
      onDrawOtherObject();
      return;
    }
    this.mSceneImageBg.draw();
    this.mProgress.startAnimation(this.mTransformProgress);
    this.mProgress.draw();
    this.mRecognizeRegion.draw();
  }
  
  public void onPause()
  {
    if (this.mHaveBackgoundAudioStarted)
    {
      this.mDanceManager.getContext().stopAllSound();
      this.mHaveBackgoundAudioStarted = false;
    }
  }
  
  public void onResume() {}
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    Object localObject = this.mDanceManager.getContext().getSurfaceViewSize();
    paramInt1 = ((Rect)localObject).width();
    paramInt2 = ((Rect)localObject).height();
    localObject = ResourceManager.getInstance().mGamingResource;
    RectF localRectF1 = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
    this.mSceneImageBg.setImageRegion(localRectF1);
    this.mSceneImageBg.setImageClipDrawRegion(localRectF1);
    this.mProgress.setBackgroundImageRes(((ResourceManager.GamingResource)localObject).timeBackground);
    localRectF1 = new RectF(DisplayUtils.pixelToRealPixel(37.0F), DisplayUtils.pixelToRealPixel(32.0F), paramInt1 - DisplayUtils.pixelToRealPixel(37.0F), DisplayUtils.pixelToRealPixel(161.0F));
    this.mProgress.setBackgroundRegion(localRectF1);
    this.mProgress.setBackgroundClipRegion(localRectF1);
    RectF localRectF2 = new RectF(DisplayUtils.pixelToRealPixel(2.0F), DisplayUtils.pixelToRealPixel(0.0F), DisplayUtils.pixelToRealPixel(213.0F), DisplayUtils.pixelToRealPixel(119.0F));
    this.mProgress.setProgressImageRes((String)((ResourceManager.GamingResource)localObject).timeFronts.get(0));
    this.mProgress.setProgressRegion(localRectF2);
    this.mProgress.setProgressStretchRelativeRegion(DisplayUtils.pixelToRealPixel(80.0F), DisplayUtils.pixelToRealPixel(131.0F));
    int i = ResourceManager.getInstance().durationTime;
    this.mProgress.setMaxProgress(i);
    localRectF2 = new RectF(DisplayUtils.pixelToRealPixel(2.0F), DisplayUtils.pixelToRealPixel(197.0F), paramInt1 - DisplayUtils.pixelToRealPixel(2.0F), paramInt2 - DisplayUtils.pixelToRealPixel(194.0F));
    this.mRecognizeRegion.setRecognizeRegion(localRectF2);
    this.mBoyManager.updateRecognizeRegion(localRectF2);
    this.mBoyManager.initLittleBoyBeginRegion();
    localRectF2.set(DisplayUtils.pixelToRealPixel(15.0F), DisplayUtils.pixelToRealPixel(185.0F), paramInt1 - DisplayUtils.pixelToRealPixel(15.0F), DisplayUtils.pixelToRealPixel(328.0F));
    this.mRecognizeRegion.setScoreStatusBackgroundBarRegion(localRectF2);
    localRectF2.set(DisplayUtils.pixelToRealPixel(0.0F), DisplayUtils.pixelToRealPixel(0.0F), paramInt1, DisplayUtils.pixelToRealPixel(571.0F));
    this.mRecognizeRegion.setScoreStatusMongolianBarRegion(localRectF2);
    this.mRecognizeRegion.updateScoreStatusTypefaceRegion(DisplayUtils.pixelToRealPixel(180.0F));
    localRectF2.set(DisplayUtils.pixelToRealPixel(194.0F), DisplayUtils.pixelToRealPixel(98.0F), paramInt1 - DisplayUtils.pixelToRealPixel(194.0F), DisplayUtils.pixelToRealPixel(138.0F));
    this.mScoreBoard.setScoreBoardSize(localRectF2, localRectF1);
    this.mScoreBoard.setNumberInterval(DisplayUtils.pixelToRealPixel(-10.0F));
    this.mAudioWave.setImageRes(((ResourceManager.GamingResource)localObject).volumSoundPic);
    float f = DisplayUtils.pixelToRealPixel(1.0F);
    localRectF2.set(f, paramInt2 - DisplayUtils.pixelToRealPixel(180.0F), paramInt1 - f, paramInt2 - f);
    this.mAudioWave.setWaveRegion(localRectF2);
  }
  
  public void onSurfaceCreate()
  {
    Object localObject = ResourceManager.getInstance().mGamingResource;
    this.mSceneImageBg = new GLImageView(this.mDanceManager.getContext(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.mSceneImageBg.setImageRes(ResourceManager.getInstance().mGeneralResource.bgPic);
    this.mProgress = new GLProgressBar(this.mDanceManager.getContext(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.mProgress.setProgressBarListener(this);
    this.mProgress.setBlendMode(2);
    this.mRecognizeRegion = new GLRecognizeRegionView(this.mDanceManager.getContext(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.mRecognizeRegion.setLeftTopImage((String)((ResourceManager.GamingResource)localObject).recogRects.get(1));
    this.mRecognizeRegion.setLeftBottomImage((String)((ResourceManager.GamingResource)localObject).recogRects.get(0));
    this.mRecognizeRegion.setRightTopImage((String)((ResourceManager.GamingResource)localObject).recogRects.get(3));
    this.mRecognizeRegion.setRightBottomImage((String)((ResourceManager.GamingResource)localObject).recogRects.get(2));
    this.mRecognizeRegion.setScoreStatusTypefaceImage("", ((ResourceManager.GamingResource)localObject).good, ((ResourceManager.GamingResource)localObject).great, ((ResourceManager.GamingResource)localObject).perfect);
    this.mRecognizeRegion.setScoreStatusBackgroundImage(((ResourceManager.GamingResource)localObject).miss_background, ((ResourceManager.GamingResource)localObject).good_background, ((ResourceManager.GamingResource)localObject).great_background, ((ResourceManager.GamingResource)localObject).perfect_background);
    this.mRecognizeRegion.setScoreStatusMongolianImage(((ResourceManager.GamingResource)localObject).miss_mongolian, ((ResourceManager.GamingResource)localObject).good_mongolian, ((ResourceManager.GamingResource)localObject).great_mongolian, ((ResourceManager.GamingResource)localObject).perfect_mongolian);
    this.mRecognizeRegion.setStatusListner(new DancePlayFilter.1(this));
    this.mScoreBoard = new GLScoreBoard(this.mDanceManager.getContext(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    localObject = ResourceManager.getInstance().mGameNumberResource;
    this.mScoreBoard.setAnimationFrames(((ResourceManager.GameNumberResource)localObject).gameNums);
    this.mScoreBoard.setLoadTextureMode(0);
    this.mScoreBoard.initAnimationFrame();
    this.mBoyManager = new GLLittleBoyManager(this.mDanceManager.getContext(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.mAudioWave = new GLAudioWaveN(this.mDanceManager.getContext(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.mAudioWave.setBlendMode(2);
    this.mLyricsManager = new GLLyricsManager(this.mDanceManager.getContext(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
  }
  
  public void onSurfaceDestroy() {}
  
  public void progressMax()
  {
    this.mDanceManager.mGamePlayOutData.mScore = this.mScoreBoard.getScore();
    if (this.mHaveBackgoundAudioStarted)
    {
      this.mDanceManager.getContext().stopAllSound();
      this.mHaveBackgoundAudioStarted = false;
    }
    this.mDanceManager.getContext().mReport.mGameDuration = (SystemClock.uptimeMillis() - this.mStartRecordMis);
    this.mDanceManager.getContext().mReport.mGameTotalScore = this.mScoreBoard.getScore();
    this.mDanceManager.selectNextFilter();
    QQDanceEventHandler localQQDanceEventHandler = getQQFilterRenderManager().getBusinessOperation().getDanceEventHandler();
    if (localQQDanceEventHandler != null)
    {
      this.mDanceManager.getContext().mReport.mHasReported = true;
      localQQDanceEventHandler.playSceneEndEvent(this.mDanceManager.getContext().mReport);
    }
  }
  
  public void rollbackStatusCallOnInitFilter()
  {
    Object localObject = this.mProgress.gettBackgroundClipRegion();
    this.mTransformProgress = new TranslateAnimation(((RectF)localObject).left, ((RectF)localObject).left, -20.0F, ((RectF)localObject).top);
    this.mTransformProgress.setDuration(200L);
    this.mTransformProgress.setAnimationListener(this);
    this.mTransformProgress.setInterpolator(new LinearInterpolator());
    this.mStartRecordMis = 0L;
    this.mHaveStartProgress = false;
    int i = ResourceManager.getInstance().durationTime;
    this.mProgress.setMaxProgress(i);
    this.mProgress.clearAnimation();
    this.mProgress.clearStatus();
    this.mRecognizeRegion.clearStatus();
    this.mBoyManager.clearStatus();
    if (!this.mHaveBackgoundAudioStarted)
    {
      localObject = ResourceManager.getInstance().mLBGeneraResource;
      this.mDanceManager.getContext().playBackGroundSound(((ResourceManager.LBGeneralResource)localObject).bgmV);
      this.mHaveBackgoundAudioStarted = true;
    }
    this.mSceneImageBg.setVisibility(true);
    this.mAudioWave.setVisibility(true);
    this.mScoreBoard.setVisibility(true);
    this.mProgress.setVisibility(true);
    this.mRecognizeRegion.setVisibility(true);
    this.mAnimGreatPro = null;
    this.mAnimPerfectPro = null;
    this.mDanceManager.getContext().mReport.clear();
    this.mLyricsManager.clearStatus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.filter.DancePlayFilter
 * JD-Core Version:    0.7.0.1
 */