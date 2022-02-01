package com.tencent.mobileqq.shortvideo.ptvfilter.gesture;

import android.graphics.PointF;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GestureFilterManager
  extends VideoFilterBase
{
  public static int GestureFilterManager_Layout_AV = 1;
  public static int GestureFilterManager_Layout_None = 0;
  public static int GestureFilterManager_Layout_ShortVideo = 0;
  public static final int MAX_GESTURE_NUMS = 3;
  public static final String TAG = "GestureFilterManager";
  public static volatile String sGestureTips;
  public static volatile String sGestureType = "";
  public static volatile int sLayoutType = GestureFilterManager_Layout_ShortVideo;
  private ArrayList<AnimationWrapper> deadQueue = new ArrayList();
  private long lastConsumerTime = 0L;
  private volatile boolean mAllowedInsertAction = false;
  private int mCurrentAnimationNums = 0;
  public int mGestureAnimGapTime = -1;
  public int mGestureAnimType = -1;
  public int mGesturePointIndex = -1;
  private boolean mHasAdd = false;
  public StickerItem mItem;
  private GestureKeyInfo mLastGestureInfo = null;
  private AnimationWrapper mLastRecongnizeAnimation = null;
  private ArrayList<AnimationWrapper> runQueue = new ArrayList();
  public long startTimes;
  private int[] tex = new int[1];
  
  static
  {
    sGestureTips = "";
    GestureFilterManager_Layout_None = 0;
    GestureFilterManager_Layout_ShortVideo = 0;
  }
  
  public GestureFilterManager(StickerItem paramStickerItem, String paramString)
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.STICKER_NORMAL));
    this.mItem = paramStickerItem;
    this.mAllowedInsertAction = true;
    this.dataPath = paramString;
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    this.startTimes = System.currentTimeMillis();
  }
  
  public void OnDrawFrameGLSL()
  {
    super.OnDrawFrameGLSL();
  }
  
  public void addAnimationToList(StickerItem paramStickerItem, GestureKeyInfo paramGestureKeyInfo, PointF paramPointF)
  {
    paramStickerItem = new AnimationWrapper(paramStickerItem, this.dataPath, paramGestureKeyInfo, paramPointF, false);
    if ((this.mCurrentAnimationNums <= 3) && (this.mAllowedInsertAction))
    {
      paramStickerItem.updateVideoSize(this.width, this.height, this.mFaceDetScale);
      this.runQueue.add(paramStickerItem);
      this.mLastRecongnizeAnimation = paramStickerItem;
      this.mCurrentAnimationNums += 1;
      if (SLog.isEnable()) {
        SLog.d("GestureFilterManager", "have add complete ok here");
      }
    }
  }
  
  public boolean canUseBlendMode()
  {
    return true;
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    Iterator localIterator = this.runQueue.iterator();
    while (localIterator.hasNext()) {
      ((AnimationWrapper)localIterator.next()).clearGLSLSelf();
    }
    localIterator = this.deadQueue.iterator();
    while (localIterator.hasNext()) {
      ((AnimationWrapper)localIterator.next()).clearGLSLSelf();
    }
    this.runQueue.clear();
    this.deadQueue.clear();
    this.mCurrentAnimationNums = 0;
    this.mAllowedInsertAction = false;
  }
  
  public void destroyAudio()
  {
    Iterator localIterator = this.runQueue.iterator();
    while (localIterator.hasNext()) {
      ((AnimationWrapper)localIterator.next()).destroyAudio();
    }
    localIterator = this.deadQueue.iterator();
    while (localIterator.hasNext()) {
      ((AnimationWrapper)localIterator.next()).destroyAudio();
    }
  }
  
  public void initParams()
  {
    addParam(new UniformParam.IntParam("texNeedTransform", -1));
    addParam(new UniformParam.IntParam("blendMode", 1));
    addParam(new UniformParam.Float2fParam("displacement", 0.0F, 0.0F));
    addParam(new UniformParam.IntParam("displacementEnableLut", 0));
  }
  
  public String printControllerInfo()
  {
    return "mGestureAnimType:=" + this.mGestureAnimType + ";" + this.mGestureAnimGapTime + ";" + this.mGesturePointIndex;
  }
  
  public void removeAnimationFromList()
  {
    Iterator localIterator = this.runQueue.iterator();
    while (localIterator.hasNext())
    {
      ((AnimationWrapper)localIterator.next()).clearGLSLSelf();
      this.mCurrentAnimationNums -= 1;
    }
    this.runQueue.clear();
  }
  
  public void removeAnimationFromRunQueue(AnimationWrapper paramAnimationWrapper)
  {
    if ((paramAnimationWrapper != null) && (this.runQueue.contains(paramAnimationWrapper)))
    {
      this.runQueue.remove(paramAnimationWrapper);
      this.mCurrentAnimationNums -= 1;
      if (SLog.isEnable()) {
        SLog.d("GestureFilterManager", "have remove animation here");
      }
    }
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.runQueue.iterator();
    while (localIterator.hasNext()) {
      ((AnimationWrapper)localIterator.next()).renderTexture(paramInt1, paramInt2, paramInt3);
    }
    localIterator = this.deadQueue.iterator();
    while (localIterator.hasNext()) {
      ((AnimationWrapper)localIterator.next()).renderTexture(paramInt1, paramInt2, paramInt3);
    }
    return true;
  }
  
  public void setControllerInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mGestureAnimType = paramInt1;
    this.mGestureAnimGapTime = paramInt2;
    this.mGesturePointIndex = paramInt3;
  }
  
  public boolean setRenderMode(int paramInt)
  {
    return super.setRenderMode(paramInt);
  }
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat) {}
  
  public void updatePreview(Object paramObject)
  {
    int j = 1;
    if ((paramObject instanceof PTDetectInfo)) {}
    for (paramObject = (PTDetectInfo)paramObject; paramObject == null; paramObject = null) {
      return;
    }
    this.lastConsumerTime = System.currentTimeMillis();
    Object localObject1 = GestureMgrRecognize.getInstance().getGestureInfo();
    if ((this.mLastGestureInfo != null) && (((GestureKeyInfo)localObject1).timeStamp == this.mLastGestureInfo.timeStamp)) {}
    for (int i = 0;; i = 1)
    {
      this.mLastGestureInfo = ((GestureKeyInfo)localObject1);
      if ((localObject1 != null) && (((GestureKeyInfo)localObject1).vaild) && (((GestureKeyInfo)localObject1).type.equalsIgnoreCase(sGestureType)) && (i != 0))
      {
        if (SLog.isEnable()) {
          SLog.d("GestureFilterManager", "gesture info is x" + localObject1.hotPoints[0].x + ":y =" + localObject1.hotPoints[0].y + "lastAnimation is " + this.mLastRecongnizeAnimation);
        }
        if (this.mGestureAnimType == 1)
        {
          i = 0;
          if (i != 0) {
            break label588;
          }
          if (this.mLastRecongnizeAnimation == null) {
            break label568;
          }
          if (!AnimationWrapper.compareGestureInfo(this.mLastRecongnizeAnimation.mGestureInfo, (GestureKeyInfo)localObject1, this.width * 0.08F)) {
            break label472;
          }
          if (this.mLastRecongnizeAnimation.getAnimationStatus(paramObject.timestamp) != 2) {
            break label408;
          }
          this.mLastRecongnizeAnimation.resetAnimationEndStatus();
          this.mLastRecongnizeAnimation.updateFilterPostion((GestureKeyInfo)localObject1, localObject1.hotPoints[0]);
          if (SLog.isEnable()) {
            SLog.d("GestureFilterManager", "update old point position");
          }
        }
      }
      label270:
      label918:
      for (;;)
      {
        localObject1 = this.runQueue.iterator();
        Object localObject2;
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (AnimationWrapper)((Iterator)localObject1).next();
            if (((AnimationWrapper)localObject2).getAnimationStatus(paramObject.timestamp) == 2)
            {
              if (SLog.isEnable()) {
                SLog.d("GestureFilterManager", "runQueue remove this item " + localObject2 + " animation status is" + ((AnimationWrapper)localObject2).getAnimationStatus(paramObject.timestamp));
              }
              if (localObject2 == this.mLastRecongnizeAnimation) {
                this.mLastRecongnizeAnimation = null;
              }
              ((AnimationWrapper)localObject2).clearGLSLSelf();
              ((Iterator)localObject1).remove();
              this.mCurrentAnimationNums -= 1;
              continue;
              i = 1;
              break;
              label408:
              if (!SLog.isEnable()) {
                break label270;
              }
              SLog.d("GestureFilterManager", "old animation is play now " + this.runQueue.contains(this.mLastRecongnizeAnimation) + " animation status is" + this.mLastRecongnizeAnimation.getAnimationStatus(paramObject.timestamp));
              break label270;
              label472:
              if (this.mLastRecongnizeAnimation.getAnimationStatus(paramObject.timestamp) == 2)
              {
                this.mLastRecongnizeAnimation.clearGLSLSelf();
                removeAnimationFromRunQueue(this.mLastRecongnizeAnimation);
              }
              for (;;)
              {
                addAnimationToList(this.mItem, (GestureKeyInfo)localObject1, localObject1.hotPoints[0]);
                if (!SLog.isEnable()) {
                  break;
                }
                SLog.d("GestureFilterManager", "stop old point position");
                break;
                this.mLastRecongnizeAnimation.updateDeadLineTimeStamp(paramObject.timestamp + this.mGestureAnimGapTime);
                this.deadQueue.add(this.mLastRecongnizeAnimation);
              }
              label568:
              addAnimationToList(this.mItem, (GestureKeyInfo)localObject1, localObject1.hotPoints[0]);
              break label270;
              label588:
              localObject2 = this.runQueue.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                AnimationWrapper localAnimationWrapper = (AnimationWrapper)((Iterator)localObject2).next();
                if (AnimationWrapper.compareGestureInfo(localAnimationWrapper.mGestureInfo, (GestureKeyInfo)localObject1, this.width * 0.08F))
                {
                  if (localAnimationWrapper.getAnimationStatus(paramObject.timestamp) == 2) {
                    localAnimationWrapper.resetAnimationEndStatus();
                  }
                  localAnimationWrapper.updateFilterPostion((GestureKeyInfo)localObject1, localObject1.hotPoints[0]);
                  this.mLastRecongnizeAnimation = localAnimationWrapper;
                }
              }
            }
          }
        }
        for (i = j;; i = 0)
        {
          if (i != 0) {
            break label918;
          }
          addAnimationToList(this.mItem, (GestureKeyInfo)localObject1, localObject1.hotPoints[0]);
          break label270;
          if ((((GestureKeyInfo)localObject1).vaild) && (((GestureKeyInfo)localObject1).type.equalsIgnoreCase(sGestureType))) {
            break label270;
          }
          removeAnimationFromList();
          this.mLastRecongnizeAnimation = null;
          break label270;
          localObject1 = this.deadQueue.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (AnimationWrapper)((Iterator)localObject1).next();
            if ((((AnimationWrapper)localObject2).getAnimationStatus(paramObject.timestamp) == 2) || (((AnimationWrapper)localObject2).getDeadLineTimeStamp() >= paramObject.timestamp))
            {
              if (SLog.isEnable()) {
                SLog.d("GestureFilterManager", "deadQueue remove this item " + localObject2);
              }
              ((AnimationWrapper)localObject2).clearGLSLSelf();
              ((Iterator)localObject1).remove();
            }
          }
          localObject1 = this.runQueue.iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((AnimationWrapper)((Iterator)localObject1).next()).updatePreview(paramObject);
          }
          localObject1 = this.deadQueue.iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((AnimationWrapper)((Iterator)localObject1).next()).updatePreview(paramObject);
          }
          break;
        }
      }
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    Iterator localIterator = this.runQueue.iterator();
    while (localIterator.hasNext()) {
      ((AnimationWrapper)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
  }
  
  public static class AnimationWrapper
  {
    public static final int ANIMATION_PLAY = 1;
    public static final int ANIMATION_STOP = 2;
    private long deadlineTimeStamp = 0L;
    public NonFit2DFilter mFilter;
    public GestureKeyInfo mGestureInfo;
    private boolean mHasCallApplyGLSLFilter = false;
    
    public AnimationWrapper(StickerItem paramStickerItem, String paramString, GestureKeyInfo paramGestureKeyInfo, PointF paramPointF, boolean paramBoolean)
    {
      this.mFilter = new NonFit2DFilter(paramStickerItem, paramString);
      this.mGestureInfo = paramGestureKeyInfo;
      this.mFilter.updateFilterPosition(paramPointF);
    }
    
    public static boolean compareGestureInfo(GestureKeyInfo paramGestureKeyInfo1, GestureKeyInfo paramGestureKeyInfo2, float paramFloat)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (Math.abs(paramGestureKeyInfo1.hotPoints[0].x - paramGestureKeyInfo2.hotPoints[0].x) <= paramFloat)
      {
        bool1 = bool2;
        if (Math.abs(paramGestureKeyInfo1.hotPoints[0].y - paramGestureKeyInfo2.hotPoints[0].y) <= paramFloat) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public void clearGLSLSelf()
    {
      if (SLog.isEnable()) {
        SLog.d("TimGestureLog", "mFilter.clearGLSLSelf");
      }
      this.mFilter.clearGLSLSelf();
    }
    
    public void destroyAudio()
    {
      this.mFilter.destroyAudio();
    }
    
    public int getAnimationStatus(long paramLong)
    {
      if (this.mFilter.isAnimationPlay(paramLong)) {
        return 1;
      }
      return 2;
    }
    
    public long getDeadLineTimeStamp()
    {
      return this.deadlineTimeStamp;
    }
    
    public void renderTexture(int paramInt1, int paramInt2, int paramInt3)
    {
      if (!this.mFilter.isHasCleared())
      {
        this.mFilter.OnDrawFrameGLSL();
        this.mFilter.renderTexture(paramInt1, paramInt2, paramInt3);
      }
    }
    
    public void resetAnimationEndStatus()
    {
      this.mFilter.resetAnimationEndStatus();
    }
    
    public void setRenderMode(int paramInt)
    {
      this.mFilter.setRenderMode(paramInt);
    }
    
    public void updateDeadLineTimeStamp(long paramLong)
    {
      this.deadlineTimeStamp = paramLong;
    }
    
    public void updateFilterPostion(GestureKeyInfo paramGestureKeyInfo, PointF paramPointF)
    {
      this.mGestureInfo = paramGestureKeyInfo;
      this.mFilter.updateFilterPosition(paramPointF);
    }
    
    public void updatePreview(PTDetectInfo paramPTDetectInfo)
    {
      this.mFilter.updatePreview(paramPTDetectInfo);
    }
    
    public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
    {
      if (!this.mHasCallApplyGLSLFilter)
      {
        this.mFilter.ApplyGLSLFilter();
        this.mFilter.setRenderMode(1);
        this.mHasCallApplyGLSLFilter = true;
      }
      this.mFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager
 * JD-Core Version:    0.7.0.1
 */