package com.tencent.tavsticker.model;

import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.List;

public class TAVStickerLayerInfo
{
  private List<TAVStickerImageEffect> mImageEffects = new ArrayList();
  private int mLayerIndex = 0;
  private TAVStickerLayerType mLayerType = TAVStickerLayerType.Unknown;
  private List<TAVStickerTimeEffect> mTimeEffects = new ArrayList();
  private CMTimeRange mTimeRange = CMTimeRange.CMTimeRangeInvalid;
  private List<TAVStickerUserData> mUserDataList = new ArrayList();
  
  public TAVStickerLayerInfo(int paramInt, TAVStickerLayerType paramTAVStickerLayerType, CMTimeRange paramCMTimeRange, List<TAVStickerTimeEffect> paramList, List<TAVStickerImageEffect> paramList1, List<TAVStickerUserData> paramList2)
  {
    this.mLayerIndex = paramInt;
    if (paramTAVStickerLayerType != null) {
      this.mLayerType = paramTAVStickerLayerType;
    }
    if (paramCMTimeRange != null) {
      this.mTimeRange = paramCMTimeRange;
    }
    if (paramList != null)
    {
      this.mTimeEffects.clear();
      this.mTimeEffects.addAll(paramList);
    }
    if (paramList1 != null)
    {
      this.mImageEffects.clear();
      this.mImageEffects.addAll(paramList1);
    }
    if (paramList2 != null)
    {
      this.mUserDataList.clear();
      this.mUserDataList.addAll(paramList2);
    }
  }
  
  public List<TAVStickerImageEffect> getImageEffects()
  {
    return this.mImageEffects;
  }
  
  public int getLayerIndex()
  {
    return this.mLayerIndex;
  }
  
  public TAVStickerLayerType getLayerType()
  {
    return this.mLayerType;
  }
  
  public List<TAVStickerTimeEffect> getTimeEffects()
  {
    return this.mTimeEffects;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.mTimeRange;
  }
  
  public List<TAVStickerUserData> getUserDataList()
  {
    return this.mUserDataList;
  }
  
  public static class TAVStickerImageEffect
  {
    private String mEffectId = "";
    private String mName = "";
    private CMTimeRange mTimeRange = CMTimeRange.CMTimeRangeInvalid;
    
    public TAVStickerImageEffect(CMTimeRange paramCMTimeRange, String paramString1, String paramString2)
    {
      if (paramCMTimeRange != null) {
        this.mTimeRange = paramCMTimeRange;
      }
      if (paramString1 != null) {
        this.mEffectId = paramString1;
      }
      if (paramString2 != null) {
        this.mName = paramString2;
      }
    }
    
    public String getEffectId()
    {
      return this.mEffectId;
    }
    
    public String getName()
    {
      return this.mName;
    }
    
    public CMTimeRange getTimeRange()
    {
      return this.mTimeRange;
    }
  }
  
  public static class TAVStickerTimeEffect
  {
    private CMTimeRange mSourceVideoTimeRange = CMTimeRange.CMTimeRangeInvalid;
    private CMTimeRange mTimeRange = CMTimeRange.CMTimeRangeInvalid;
    private boolean reversed = false;
    
    public TAVStickerTimeEffect(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2, boolean paramBoolean)
    {
      if (paramCMTimeRange1 != null) {
        this.mSourceVideoTimeRange = paramCMTimeRange1;
      }
      if (paramCMTimeRange2 != null) {
        this.mTimeRange = paramCMTimeRange2;
      }
      this.reversed = paramBoolean;
    }
    
    public CMTimeRange getSourceVideoTimeRange()
    {
      return this.mSourceVideoTimeRange;
    }
    
    public CMTimeRange getTimeRange()
    {
      return this.mTimeRange;
    }
    
    public boolean isReversed()
    {
      return this.reversed;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("TAVStickerTimeEffect {mSourceVideoTimeRange : ");
      if (this.mSourceVideoTimeRange != null)
      {
        str = "start : " + this.mSourceVideoTimeRange.getStartUs() + ", duration : " + this.mSourceVideoTimeRange.getDurationUs();
        localStringBuilder = localStringBuilder.append(str).append(", mTimeRange : ");
        if (this.mTimeRange == null) {
          break label152;
        }
      }
      label152:
      for (String str = "start : " + this.mTimeRange.getStartUs() + ", duration : " + this.mTimeRange.getDurationUs();; str = "null")
      {
        return str + ", reversed : " + this.reversed + "}";
        str = "null";
        break;
      }
    }
  }
  
  public static class TAVStickerUserData
  {
    private String mData = "";
    private CMTimeRange mTimeRange = CMTimeRange.CMTimeRangeInvalid;
    
    public TAVStickerUserData(CMTimeRange paramCMTimeRange, String paramString)
    {
      if (paramCMTimeRange != null) {
        this.mTimeRange = paramCMTimeRange;
      }
      if (paramString != null) {
        this.mData = paramString;
      }
    }
    
    public String getData()
    {
      return this.mData;
    }
    
    public CMTimeRange getTimeRange()
    {
      return this.mTimeRange;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerLayerInfo
 * JD-Core Version:    0.7.0.1
 */