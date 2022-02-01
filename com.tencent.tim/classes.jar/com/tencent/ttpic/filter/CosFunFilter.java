package com.tencent.ttpic.filter;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.filter.CosFunHelper;
import com.tencent.ttpic.openapi.filter.CosFunHelper.CountDownListener;
import com.tencent.ttpic.openapi.filter.CosFunTransitionFilter;
import com.tencent.ttpic.openapi.model.cosfun.CosFun.CosFunItem;
import com.tencent.ttpic.openapi.model.cosfun.CosFun.PagIndexList;
import com.tencent.ttpic.trigger.TriggerManager;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FrameUtil;
import java.io.File;
import java.util.List;

public class CosFunFilter
{
  private static final String TAG = CosFunFilter.class.getSimpleName();
  private final int STATE_AFTER = 5;
  private final int STATE_BEFORE = 0;
  private final int STATE_COS_FUN = 3;
  private final int STATE_FREEZE = 1;
  private final int STATE_REVERSE = 4;
  private final int STATE_TRANS = 2;
  private Frame copyFrame = new Frame();
  private CosFun.CosFunItem cosFunItem;
  private CosFunTransitionFilter cosFunTransitionFilter;
  private CosTransTime cosTransTime;
  private boolean firstPagFrameRenderTriggered = false;
  private FreezeFilter freezeFilter;
  private long initStartTime;
  private boolean isCosTransInit = false;
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private PagFilter pagFilter;
  private TriggerManager triggerManager;
  private long triggerStartTime;
  
  private Frame fillBlackFrame(Frame paramFrame, int paramInt1, int paramInt2)
  {
    float f = Math.max(paramFrame.width / paramInt1, paramFrame.height / paramInt2);
    paramInt1 = (int)(paramInt1 * f);
    paramInt2 = (int)(f * paramInt2);
    int i = (paramInt1 - paramFrame.width) / 2;
    int j = paramFrame.width;
    int k = (paramInt2 - paramFrame.height) / 2;
    int m = paramFrame.height;
    float[] arrayOfFloat = AlgoUtils.calPositions(i, m + k, i + j, k, paramInt1, paramInt2);
    FrameUtil.clearFrame(this.copyFrame, 0.0F, 0.0F, 0.0F, 1.0F, paramInt1, paramInt2);
    this.mCopyFilter.setPositions(arrayOfFloat);
    this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramInt1, paramInt2, -1, 0.0D, this.copyFrame);
    return this.copyFrame;
  }
  
  private TimeSection judgeTimeSection(long paramLong)
  {
    if (paramLong <= this.cosTransTime.freezeStart) {
      return new TimeSection(0, 0.0F);
    }
    if (paramLong < this.cosTransTime.freezeStart + this.cosTransTime.freezeDuration) {
      return new TimeSection(1, (float)(paramLong - this.cosTransTime.freezeStart) * 1.0F / this.cosTransTime.freezeDuration);
    }
    if ((this.cosTransTime.transStart > 0) && (paramLong < this.cosTransTime.transStart + this.cosTransTime.transDuration)) {
      return new TimeSection(2, (float)(paramLong - this.cosTransTime.transStart) * 1.0F / this.cosTransTime.transDuration);
    }
    if ((this.cosTransTime.transStart <= 0) || (this.cosTransTime.transReverseStart <= 0) || (paramLong < this.cosTransTime.transReverseStart)) {
      return new TimeSection(3, 1.0F);
    }
    if (paramLong < this.cosTransTime.transReverseStart + this.cosTransTime.transReverseDuration) {
      return new TimeSection(4, 1.0F - (float)(paramLong - this.cosTransTime.transReverseStart) * 1.0F / this.cosTransTime.transReverseDuration);
    }
    return new TimeSection(5, 0.0F);
  }
  
  private void parseCosTransition(String paramString, CosFun.CosFunItem paramCosFunItem)
  {
    this.cosFunTransitionFilter = new CosFunTransitionFilter(paramString + File.separator + paramCosFunItem.getCrazyFacePath(), 2, paramCosFunItem.getBackgroundMode2());
    this.cosTransTime = new CosTransTime();
    this.cosTransTime.freezeStart = paramCosFunItem.getFreezeStart();
    this.cosTransTime.freezeDuration = paramCosFunItem.getFreezeDuration();
    this.cosTransTime.transStart = paramCosFunItem.getTransStart();
    this.cosTransTime.transDuration = paramCosFunItem.getTransDuration();
    this.cosTransTime.transReverseStart = paramCosFunItem.getTransReverseStart();
    this.cosTransTime.transReverseDuration = paramCosFunItem.getTransReverseDuration();
  }
  
  private void parseFreeze(CosFun.CosFunItem paramCosFunItem)
  {
    this.freezeFilter = new FreezeFilter(paramCosFunItem, this.triggerManager);
    this.freezeFilter.init();
  }
  
  private void parsePagFilter(String paramString, CosFun.CosFunItem paramCosFunItem)
  {
    this.pagFilter = new PagFilter(paramString, paramCosFunItem.getPagPath(), paramCosFunItem.getPagIndexList().getCosFun());
    this.pagFilter.init();
  }
  
  public boolean durationComplete(long paramLong)
  {
    return paramLong - this.triggerStartTime > this.cosFunItem.getDuration();
  }
  
  public long getDuration()
  {
    return this.cosFunItem.getDuration();
  }
  
  public void init(String paramString, CosFun.CosFunItem paramCosFunItem, TriggerManager paramTriggerManager)
  {
    this.cosFunItem = paramCosFunItem;
    this.mCopyFilter.apply();
    this.triggerManager = paramTriggerManager;
    parseFreeze(paramCosFunItem);
    parseCosTransition(paramString, paramCosFunItem);
    parsePagFilter(paramString, paramCosFunItem);
  }
  
  public boolean isTriggered()
  {
    return (this.cosFunItem.getTriggerType() == 1) || (this.freezeFilter.isTriggered());
  }
  
  public void release()
  {
    if (this.freezeFilter != null)
    {
      this.freezeFilter.destroy();
      this.freezeFilter = null;
    }
    if (this.cosFunTransitionFilter != null)
    {
      this.cosFunTransitionFilter.destroy();
      this.cosFunTransitionFilter = null;
    }
    this.copyFrame.clear();
    if (this.cosTransTime != null) {
      this.cosTransTime = null;
    }
    this.isCosTransInit = false;
    if (this.pagFilter != null)
    {
      this.pagFilter.release();
      this.pagFilter = null;
    }
    this.mCopyFilter.ClearGLSL();
  }
  
  public Frame render(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, AIAttr paramAIAttr)
  {
    if ((this.cosFunTransitionFilter == null) || (!this.cosFunTransitionFilter.isInited())) {}
    do
    {
      return paramFrame;
      if (paramPTFaceAttr.getTimeStamp() - this.initStartTime >= this.cosFunItem.getWaitInterval()) {
        break;
      }
    } while ((paramPTFaceAttr.getFaceCount() < 1) || (this.firstPagFrameRenderTriggered));
    BenchUtil.benchStart("[pagFilter.render]");
    paramPTFaceAttr = fillBlackFrame(paramFrame, this.cosFunTransitionFilter.getWidth(), this.cosFunTransitionFilter.getHeight());
    this.pagFilter.render(paramPTFaceAttr, paramFrame.width, paramFrame.height, 0.0D);
    BenchUtil.benchEnd("[pagFilter.render]");
    this.firstPagFrameRenderTriggered = true;
    return paramFrame;
    long l = paramPTFaceAttr.getTimeStamp() - this.triggerStartTime;
    paramPTSegAttr = judgeTimeSection(l);
    switch (paramPTSegAttr.state)
    {
    default: 
      paramPTSegAttr = paramFrame;
    }
    for (;;)
    {
      BenchUtil.benchStart("[CosFunFilter] pagFilter");
      paramPTFaceAttr = paramPTSegAttr;
      if (this.freezeFilter.isTriggered())
      {
        paramPTFaceAttr = fillBlackFrame(paramPTSegAttr, this.cosFunTransitionFilter.getWidth(), this.cosFunTransitionFilter.getHeight());
        GLES20.glFinish();
        paramPTFaceAttr = this.pagFilter.render(paramPTFaceAttr, paramFrame.width, paramFrame.height, l * 1.0D / this.cosFunItem.getDuration());
      }
      BenchUtil.benchEnd("[CosFunFilter] pagFilter");
      return paramPTFaceAttr;
      paramAIAttr = this.freezeFilter.getFreezeFrame(paramFrame);
      this.freezeFilter.setFreezeCount(paramPTFaceAttr);
      paramPTSegAttr = paramAIAttr;
      if (!this.isCosTransInit)
      {
        paramPTSegAttr = paramAIAttr;
        if (paramPTFaceAttr.getFaceCount() > 0)
        {
          this.cosFunTransitionFilter.init(paramAIAttr.getTextureId(), paramAIAttr.width, paramAIAttr.height, (List)paramPTFaceAttr.getAllFacePoints().get(0), paramPTFaceAttr.getFaceDetectScale());
          this.isCosTransInit = true;
          paramPTSegAttr = paramAIAttr;
          continue;
          if ((this.freezeFilter != null) && (this.freezeFilter.hasFreezeFace()))
          {
            paramPTSegAttr = this.cosFunTransitionFilter.getMergedFrame(paramPTSegAttr.fraction);
          }
          else
          {
            paramPTSegAttr = this.freezeFilter.getFreezeFrame(paramFrame);
            continue;
            paramPTSegAttr = this.freezeFilter.getFreezeFrame(paramFrame);
          }
        }
      }
    }
  }
  
  public void reset()
  {
    this.triggerStartTime = 0L;
  }
  
  public void updateParams(PTFaceAttr paramPTFaceAttr)
  {
    if (this.initStartTime <= 0L) {
      this.initStartTime = paramPTFaceAttr.getTimeStamp();
    }
    this.triggerStartTime = paramPTFaceAttr.getTimeStamp();
    if (paramPTFaceAttr.getTimeStamp() - this.initStartTime < this.cosFunItem.getWaitInterval())
    {
      if (paramPTFaceAttr.getFaceCount() < 1)
      {
        if (CosFunHelper.countDownListener != null) {
          CosFunHelper.countDownListener.onCountDownEnd();
        }
        CosFunHelper.isRestart = true;
      }
      return;
    }
    this.triggerStartTime = this.freezeFilter.updateActionTriggered(paramPTFaceAttr);
  }
  
  class CosTransTime
  {
    int freezeDuration;
    int freezeStart;
    int transDuration;
    int transReverseDuration;
    int transReverseStart;
    int transStart;
    
    CosTransTime() {}
  }
  
  class TimeSection
  {
    float fraction;
    int state;
    
    TimeSection(int paramInt, float paramFloat)
    {
      this.state = paramInt;
      this.fraction = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.CosFunFilter
 * JD-Core Version:    0.7.0.1
 */