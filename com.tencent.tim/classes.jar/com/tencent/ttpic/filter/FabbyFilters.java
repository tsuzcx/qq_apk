package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.audio.PlayerUtil;
import com.tencent.ttpic.baseutils.audio.PlayerUtil.Player;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.model.FabbyFaceActionCounter;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.filter.FabbyMvPart;
import com.tencent.ttpic.openapi.filter.MaskStickerFilter.BrushMaskFilter;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.util.FrameUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FabbyFilters
  implements AEFilterI
{
  private final int ACTION_TRIGGER_TIMESTAMP_MS = 1000;
  private final String audioFile;
  private final String dataPath;
  private List<FabbyMvFilter> fabbyMvFilters = new ArrayList();
  private PTHandAttr handAttr = null;
  private boolean isCurrentTriggered = false;
  private boolean mAudioPause;
  private List<Long> mBaseOffsetTimeList = new ArrayList();
  private BrushMaskFilter mBrushMaskFilter;
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private int mCurMvPartTriggerDelay = 1;
  private Frame mDoodlerMaskFrame = new Frame();
  private int mDoodlerMaskRenderId = 0;
  private int mLastRenderPartIndex;
  private long mLastTriggerTime;
  private int mMvPartIndex;
  private long mOffsetTimeFromTrigger;
  private PlayerUtil.Player mPlayer;
  private long mStartTime;
  private List<PointF> mTouchPoints = new ArrayList();
  private long mTransitionDeadLine;
  private Frame mTransitionFrame = new Frame();
  private int mergeType = 1;
  private TransitionFilter transitionFilter = new TransitionFilter();
  
  public FabbyFilters(List<FabbyMvFilter> paramList, String paramString1, String paramString2)
  {
    this.fabbyMvFilters = paramList;
    this.dataPath = paramString1;
    this.audioFile = paramString2;
    initBaseOffsetTime();
  }
  
  private void createAudioPlayer()
  {
    if ((!TextUtils.isEmpty(this.audioFile)) && (this.mPlayer == null) && (!VideoPrefsUtil.getMaterialMute())) {
      this.mPlayer = PlayerUtil.createPlayer(AEModule.getContext(), this.dataPath + File.separator + this.audioFile, true);
    }
  }
  
  private void initBaseOffsetTime()
  {
    long l = 0L;
    int i = 0;
    while (i < this.fabbyMvFilters.size())
    {
      l += ((FabbyMvFilter)this.fabbyMvFilters.get(i)).mvPart.duration;
      this.mBaseOffsetTimeList.add(Long.valueOf(l));
      i += 1;
    }
  }
  
  private boolean isCurrentPartActionTrigger()
  {
    FabbyMvFilter localFabbyMvFilter = (FabbyMvFilter)this.fabbyMvFilters.get(this.mMvPartIndex);
    return (localFabbyMvFilter.mvPart.transitionItem != null) && (Integer.valueOf(localFabbyMvFilter.mvPart.transitionItem.getTriggerTypeInt()).intValue() > 1);
  }
  
  private boolean isRightTimeInActionTrigger(long paramLong)
  {
    return paramLong - this.mLastTriggerTime > this.mCurMvPartTriggerDelay * 1000;
  }
  
  private void reset(long paramLong)
  {
    this.mStartTime = paramLong;
    this.mMvPartIndex = 0;
    this.mLastRenderPartIndex = 0;
    this.mOffsetTimeFromTrigger = 0L;
    createAudioPlayer();
    PlayerUtil.startPlayer(this.mPlayer, true);
    Iterator localIterator = this.fabbyMvFilters.iterator();
    while (localIterator.hasNext()) {
      ((FabbyMvFilter)localIterator.next()).reset();
    }
  }
  
  private void updateAndRenderDoodlerMaskFrame(Frame paramFrame)
  {
    if ((this.mBrushMaskFilter != null) && (this.mTouchPoints != null) && (this.mTouchPoints.size() > 0))
    {
      this.mBrushMaskFilter.setTouchPoints(this.mTouchPoints, paramFrame.width, paramFrame.height);
      this.mDoodlerMaskFrame = this.mBrushMaskFilter.render(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
    }
  }
  
  private void updateCurrentPartIndex(Set<Integer> paramSet, long paramLong, AIAttr paramAIAttr)
  {
    int k = 1;
    int j = 0;
    boolean bool;
    int i;
    if (isCurrentPartActionTrigger())
    {
      paramSet = (FabbyMvFilter)this.fabbyMvFilters.get(this.mMvPartIndex);
      bool = this.isCurrentTriggered;
      i = paramSet.mvPart.transitionItem.getTriggerTypeInt();
      this.mCurMvPartTriggerDelay = paramSet.mvPart.triggerDelay;
      if (i == PTFaceAttr.PTExpression.ALL_VIEWER_ITEM_FRAME_FROZEN.value) {
        break label354;
      }
      if ((!bool) || (!isRightTimeInActionTrigger(paramLong))) {}
    }
    for (;;)
    {
      if (k != 0)
      {
        this.mLastTriggerTime = paramLong;
        this.mOffsetTimeFromTrigger = (paramLong - (((Long)this.mBaseOffsetTimeList.get(this.mMvPartIndex)).longValue() + this.mStartTime));
        updateTransitionParam(paramSet.mvPart.transitionDuration + paramLong);
        this.mMvPartIndex = ((this.mMvPartIndex + 1) % this.fabbyMvFilters.size());
        if (this.mMvPartIndex == 0) {
          reset(paramLong);
        }
      }
      this.mLastRenderPartIndex = this.mMvPartIndex;
      return;
      k = 0;
      continue;
      long l1 = this.mStartTime;
      long l2 = this.mOffsetTimeFromTrigger;
      i = 0;
      label198:
      if (i < this.fabbyMvFilters.size()) {
        if (((Long)this.mBaseOffsetTimeList.get(i)).longValue() >= paramLong - l1 - l2) {
          this.mMvPartIndex = i;
        }
      }
      for (i = j;; i = 1)
      {
        if (i != 0)
        {
          reset(paramLong);
          break;
          i += 1;
          break label198;
        }
        if (this.mMvPartIndex == this.mLastRenderPartIndex) {
          break;
        }
        paramLong = this.mStartTime;
        l1 = ((Long)this.mBaseOffsetTimeList.get(this.mLastRenderPartIndex)).longValue();
        updateTransitionParam(((FabbyMvFilter)this.fabbyMvFilters.get(this.mLastRenderPartIndex)).mvPart.transitionDuration + (paramLong + l1) + this.mOffsetTimeFromTrigger);
        break;
      }
      label354:
      k = bool;
    }
  }
  
  private void updateTransitionParam(long paramLong)
  {
    FabbyMvFilter localFabbyMvFilter = (FabbyMvFilter)this.fabbyMvFilters.get(this.mLastRenderPartIndex);
    if ((localFabbyMvFilter != null) && (localFabbyMvFilter.mvPart != null) && (localFabbyMvFilter.getLastRenderFrame() != null))
    {
      BenchUtil.benchStart("[showPreview][FABBY] setTransitionParam");
      this.transitionFilter.setMvPart(((FabbyMvFilter)this.fabbyMvFilters.get(this.mLastRenderPartIndex)).mvPart);
      this.transitionFilter.setLastTex(((FabbyMvFilter)this.fabbyMvFilters.get(this.mLastRenderPartIndex)).getLastRenderFrame().getTextureId());
      BenchUtil.benchEnd("[showPreview][FABBY] setTransitionParam");
      this.mTransitionDeadLine = paramLong;
      return;
    }
    this.mTransitionDeadLine = 0L;
  }
  
  public void ApplyGLSLFilter(String paramString)
  {
    Iterator localIterator = this.fabbyMvFilters.iterator();
    while (localIterator.hasNext()) {
      ((FabbyMvFilter)localIterator.next()).ApplyGLSLFilter();
    }
    this.transitionFilter.ApplyGLSLFilter(paramString);
    this.mCopyFilter.apply();
    if (this.mBrushMaskFilter != null) {
      this.mBrushMaskFilter.ApplyGLSLFilter();
    }
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    return paramFrame;
  }
  
  public void clear()
  {
    Iterator localIterator = this.fabbyMvFilters.iterator();
    while (localIterator.hasNext())
    {
      FabbyMvFilter localFabbyMvFilter = (FabbyMvFilter)localIterator.next();
      if (localFabbyMvFilter != null) {
        localFabbyMvFilter.clear();
      }
    }
    if (this.mTransitionFrame != null) {
      this.mTransitionFrame.clear();
    }
    if (this.transitionFilter != null) {
      this.transitionFilter.ClearGLSL();
    }
    if (this.mCopyFilter != null) {
      this.mCopyFilter.clearGLSLSelf();
    }
    if (this.mDoodlerMaskFrame != null) {
      this.mDoodlerMaskFrame.clear();
    }
  }
  
  public void destroyAudio()
  {
    PlayerUtil.destroyPlayer(this.mPlayer);
    this.mPlayer = null;
  }
  
  public int getCurPartIndex()
  {
    return this.mMvPartIndex;
  }
  
  public void reset()
  {
    this.mStartTime = 0L;
    if (this.mBrushMaskFilter != null)
    {
      this.mBrushMaskFilter.reset();
      if (this.mDoodlerMaskFrame != null) {
        FrameUtil.clearFrame(this.mDoodlerMaskFrame, 0.0F, 0.0F, 0.0F, 0.0F, this.mDoodlerMaskFrame.width, this.mDoodlerMaskFrame.height);
      }
    }
  }
  
  public void setAudioPause(boolean paramBoolean)
  {
    this.mAudioPause = paramBoolean;
  }
  
  public void setDoodlerMaskFilter(BrushMaskFilter paramBrushMaskFilter)
  {
    this.mBrushMaskFilter = paramBrushMaskFilter;
  }
  
  public void setDoodlerMaskFrame()
  {
    if (this.fabbyMvFilters != null)
    {
      int i = 0;
      while (i < this.fabbyMvFilters.size())
      {
        ((FabbyMvFilter)this.fabbyMvFilters.get(i)).setDoodlerMaskFrame(this.mDoodlerMaskFrame);
        i += 1;
      }
    }
  }
  
  public void setDoodlerMaskRenderId(int paramInt)
  {
    this.mDoodlerMaskRenderId = paramInt;
    if (this.fabbyMvFilters != null)
    {
      paramInt = 0;
      while (paramInt < this.fabbyMvFilters.size())
      {
        ((FabbyMvFilter)this.fabbyMvFilters.get(paramInt)).setDoodlerMaskRenderId(this.mDoodlerMaskRenderId);
        paramInt += 1;
      }
    }
  }
  
  public void setDoodlerMaskType()
  {
    if (this.mBrushMaskFilter != null)
    {
      this.mergeType = this.mBrushMaskFilter.getMaskType();
      if (this.fabbyMvFilters != null)
      {
        int i = 0;
        while (i < this.fabbyMvFilters.size())
        {
          ((FabbyMvFilter)this.fabbyMvFilters.get(i)).setDoodlerMaskMergeType(this.mergeType);
          i += 1;
        }
      }
    }
  }
  
  public void setRenderMode(int paramInt)
  {
    Iterator localIterator = this.fabbyMvFilters.iterator();
    while (localIterator.hasNext()) {
      ((FabbyMvFilter)localIterator.next()).setRenderMode(paramInt);
    }
    this.transitionFilter.setRenderMode(paramInt);
  }
  
  public void setTouchPoints(List<PointF> paramList)
  {
    this.mTouchPoints = paramList;
  }
  
  public void setTriggered(boolean paramBoolean)
  {
    this.isCurrentTriggered = paramBoolean;
  }
  
  public Frame updateAndRender(Frame paramFrame, Map<Integer, Frame> paramMap, Map<Integer, FaceActionCounter> paramMap1, Set<Integer> paramSet, long paramLong)
  {
    paramMap1 = (FabbyMvFilter)this.fabbyMvFilters.get(this.mMvPartIndex);
    if ((VideoPrefsUtil.getMaterialMute()) || (this.mAudioPause)) {
      destroyAudio();
    }
    for (;;)
    {
      updateAndRenderDoodlerMaskFrame(paramFrame);
      setDoodlerMaskFrame();
      setDoodlerMaskType();
      paramFrame = paramMap1.updateAndRender(paramFrame, paramMap, paramLong);
      if ((paramLong > this.mTransitionDeadLine) || (!this.transitionFilter.needRender())) {
        break;
      }
      BenchUtil.benchStart("[showPreview][FABBY] transition");
      this.transitionFilter.updatePreview(paramLong);
      this.transitionFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mTransitionFrame);
      paramFrame = this.mTransitionFrame;
      BenchUtil.benchEnd("[showPreview][FABBY] transition");
      return paramFrame;
      if (this.mPlayer == null)
      {
        createAudioPlayer();
        PlayerUtil.seekPlayer(this.mPlayer, (int)((paramLong - this.mStartTime) % 16843160L));
      }
    }
    this.transitionFilter.reset();
    this.mTransitionDeadLine = 0L;
    return paramFrame;
  }
  
  public void updateHandAttr(PTHandAttr paramPTHandAttr)
  {
    this.handAttr = paramPTHandAttr;
  }
  
  public void updatePreview(Object paramObject) {}
  
  public void updateTextureParam(Map<Integer, FaceActionCounter> paramMap, Set<Integer> paramSet, long paramLong, AIAttr paramAIAttr)
  {
    if (this.mStartTime <= 0L) {
      reset(paramLong);
    }
    updateCurrentPartIndex(paramSet, paramLong, paramAIAttr);
    ((FabbyMvFilter)this.fabbyMvFilters.get(this.mMvPartIndex)).updateTextureParam(paramLong);
    paramSet = (FaceActionCounter)paramMap.get(Integer.valueOf(PTFaceAttr.PTExpression.MV_PART_INDEX.value));
    if (paramSet == null)
    {
      paramSet = new FabbyFaceActionCounter(this.mMvPartIndex, paramLong);
      paramSet.scaleMap = ((FabbyMvFilter)this.fabbyMvFilters.get(this.mMvPartIndex)).getGridScaleMap();
      paramMap.put(Integer.valueOf(PTFaceAttr.PTExpression.MV_PART_INDEX.value), paramSet);
    }
    while (!(paramSet instanceof FabbyFaceActionCounter)) {
      return;
    }
    paramMap = (FabbyFaceActionCounter)paramSet;
    paramMap.count = this.mMvPartIndex;
    paramMap.updateTime = paramLong;
    paramMap.scaleMap = ((FabbyMvFilter)this.fabbyMvFilters.get(this.mMvPartIndex)).getGridScaleMap();
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    Iterator localIterator = this.fabbyMvFilters.iterator();
    while (localIterator.hasNext()) {
      ((FabbyMvFilter)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.FabbyFilters
 * JD-Core Version:    0.7.0.1
 */