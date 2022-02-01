package com.tencent.tav.core.composition;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.Transform;

public abstract interface VideoCompositionLayerInstruction
{
  @NonNull
  public abstract CropRectangleRamp getCropRectangleRampForTime(CMTime paramCMTime);
  
  @NonNull
  public abstract OpacityRamp getOpacityRampForTime(CMTime paramCMTime);
  
  public abstract int getTrackID();
  
  @NonNull
  public abstract TransformRamp getTransformRampForTime(CMTime paramCMTime);
  
  public static class CropRectangleRamp
  {
    @NonNull
    public boolean available = true;
    @Nullable
    public CGRect endCropRectangle;
    @Nullable
    public CGRect startCropRectangle;
    @NonNull
    public CMTimeRange timeRange;
    
    public CropRectangleRamp(@NonNull CMTimeRange paramCMTimeRange)
    {
      this.timeRange = paramCMTimeRange;
    }
  }
  
  public static class OpacityRamp
  {
    @NonNull
    public boolean available = true;
    public float endOpacity = 1.0F;
    public float startOpacity = 1.0F;
    @NonNull
    public CMTimeRange timeRange;
    
    public OpacityRamp(@NonNull CMTimeRange paramCMTimeRange)
    {
      this.timeRange = paramCMTimeRange;
    }
  }
  
  public static class TransformRamp
  {
    @NonNull
    public boolean available = true;
    @Nullable
    public Transform endTransform;
    @Nullable
    public Transform startTransform;
    @NonNull
    public CMTimeRange timeRange;
    
    public TransformRamp(@NonNull CMTimeRange paramCMTimeRange)
    {
      this.timeRange = paramCMTimeRange;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.tav.core.composition.VideoCompositionLayerInstruction
 * JD-Core Version:    0.7.0.1
 */