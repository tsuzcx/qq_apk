package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIActionCounter;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceAttr.Builder;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.PTSegAttr;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class VideoFilterListSnapshot
{
  private Set<Integer> mCameraTriggerSets;
  private PTFaceAttr mFaceAttr;
  private Frame mFreezeFrame;
  private Frame mFreezeMaskFrame;
  private int mGestuereTrigger = -1;
  private Map<Integer, Integer> mHandActionCounter = new HashMap();
  private PTSegAttr mSegAttr;
  
  public VideoFilterListSnapshot(int paramInt1, int paramInt2)
  {
    this.mFreezeFrame = FrameBufferCache.getInstance().get(paramInt1, paramInt2);
    this.mFreezeFrame.setCanUnlock(false);
  }
  
  public void addAllFreezeTrigger()
  {
    if (this.mFaceAttr != null)
    {
      Set localSet = this.mFaceAttr.getTriggeredExpression();
      if (localSet != null) {
        localSet.add(Integer.valueOf(PTFaceAttr.PTExpression.ALL_VIEWER_ITEM_FRAME_FROZEN.value));
      }
    }
  }
  
  public void clear()
  {
    if (this.mFreezeFrame != null)
    {
      this.mFreezeFrame.setCanUnlock(true);
      this.mFreezeFrame.unlock();
      this.mFreezeFrame.clear();
      this.mFreezeFrame = null;
    }
    if (this.mFreezeMaskFrame != null)
    {
      this.mFreezeMaskFrame.setCanUnlock(true);
      this.mFreezeMaskFrame.unlock();
      this.mFreezeMaskFrame.clear();
      this.mFreezeMaskFrame = null;
    }
    if (this.mFaceAttr != null) {
      this.mFaceAttr.setData(null);
    }
    if (this.mSegAttr != null) {
      this.mSegAttr.setMaskFrame(null);
    }
    if (this.mHandActionCounter != null) {
      this.mHandActionCounter.clear();
    }
  }
  
  public Set<Integer> getCameraTriggerSets()
  {
    return this.mCameraTriggerSets;
  }
  
  public int getGestureTrigger()
  {
    return this.mGestuereTrigger;
  }
  
  public Map<Integer, Integer> getHandActionCounter()
  {
    return this.mHandActionCounter;
  }
  
  public Frame getInputFrameSnapshot()
  {
    return this.mFreezeFrame;
  }
  
  public PTFaceAttr getPTFaceSnapshot()
  {
    return this.mFaceAttr;
  }
  
  public PTSegAttr getPTSegSnapshot()
  {
    return this.mSegAttr;
  }
  
  public Frame getSegMaskSnapshot()
  {
    return this.mFreezeMaskFrame;
  }
  
  public void removeAllFreezeTrigger()
  {
    if (this.mFaceAttr != null)
    {
      Set localSet = this.mFaceAttr.getTriggeredExpression();
      if (localSet != null) {
        localSet.remove(Integer.valueOf(PTFaceAttr.PTExpression.ALL_VIEWER_ITEM_FRAME_FROZEN.value));
      }
    }
  }
  
  public void setFaceAttrAndSegAttr(PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, AIAttr paramAIAttr)
  {
    if (paramPTFaceAttr != null)
    {
      byte[] arrayOfByte = new byte[paramPTFaceAttr.getData().length];
      System.arraycopy(paramPTFaceAttr.getData(), 0, arrayOfByte, 0, arrayOfByte.length);
      this.mFaceAttr = new PTFaceAttr(new PTFaceAttr.Builder().facePoints(paramPTFaceAttr.getAllFacePoints()).faceDetectScale(paramPTFaceAttr.getFaceDetectScale()).timeStamp(paramPTFaceAttr.getTimeStamp()).faceAngles(paramPTFaceAttr.getAllFaceAngles()).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).rotation(paramPTFaceAttr.getRotation()).faceStatusList(paramPTFaceAttr.getFaceStatusList()).data(arrayOfByte).bodyPoints(paramPTFaceAttr.getBodyPoints()).face3DVerticesArray(paramPTFaceAttr.getFace3DVerticesArray()).face3DRotationArray(paramPTFaceAttr.getFace3DRotationArray()).facePiont2DCenter(paramPTFaceAttr.getFacePiont2DCenter()).pointsVis(paramPTFaceAttr.getPointsVis()).recordFaceInfo(paramPTFaceAttr.getRecordFaceInfo()).faceDetector(paramPTFaceAttr.getFaceDetector()));
    }
    if (paramPTSegAttr != null)
    {
      this.mSegAttr = new PTSegAttr();
      paramPTFaceAttr = paramPTSegAttr.getMaskFrame();
      if (paramPTFaceAttr != null)
      {
        this.mFreezeMaskFrame = FrameBufferCache.getInstance().get(paramPTFaceAttr.width, paramPTFaceAttr.height);
        this.mSegAttr.setMaskFrame(this.mFreezeMaskFrame);
        this.mFreezeMaskFrame.setCanUnlock(false);
      }
    }
    if (paramAIAttr != null)
    {
      paramPTFaceAttr = (PTHandAttr)paramAIAttr.getAvailableData(AEDetectorType.HAND.value);
      if (paramPTFaceAttr != null)
      {
        setHandActionCounter(AIActionCounter.getActions(AEDetectorType.HAND));
        this.mGestuereTrigger = paramPTFaceAttr.getHandType();
      }
    }
  }
  
  public void setHandActionCounter(Map<Integer, Integer> paramMap)
  {
    if (this.mHandActionCounter != null) {
      this.mHandActionCounter.clear();
    }
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      Integer localInteger = (Integer)paramMap.get(Integer.valueOf(i));
      if (localInteger != null) {
        this.mHandActionCounter.put(Integer.valueOf(i), localInteger);
      }
    }
  }
  
  public void updateCameraTriggerAction(Set<Integer> paramSet)
  {
    this.mCameraTriggerSets = paramSet;
  }
  
  public void updateTimeStamp(long paramLong)
  {
    this.mFaceAttr.setTimeStamp(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.VideoFilterListSnapshot
 * JD-Core Version:    0.7.0.1
 */