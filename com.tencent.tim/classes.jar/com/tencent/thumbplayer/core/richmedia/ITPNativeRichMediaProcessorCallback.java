package com.tencent.thumbplayer.core.richmedia;

public abstract interface ITPNativeRichMediaProcessorCallback
{
  public abstract void onDeselectFeatureSuccess(ITPNativeRichMediaProcessor paramITPNativeRichMediaProcessor, int paramInt);
  
  public abstract void onRichMediaError(ITPNativeRichMediaProcessor paramITPNativeRichMediaProcessor, int paramInt);
  
  public abstract void onRichMediaFeatureData(ITPNativeRichMediaProcessor paramITPNativeRichMediaProcessor, int paramInt, TPNativeRichMediaFeatureData paramTPNativeRichMediaFeatureData);
  
  public abstract void onRichMediaFeatureFailure(ITPNativeRichMediaProcessor paramITPNativeRichMediaProcessor, int paramInt1, int paramInt2);
  
  public abstract void onRichMediaInfo(ITPNativeRichMediaProcessor paramITPNativeRichMediaProcessor, int paramInt, long paramLong1, long paramLong2, long paramLong3, Object paramObject);
  
  public abstract void onRichMediaPrepared(ITPNativeRichMediaProcessor paramITPNativeRichMediaProcessor);
  
  public abstract void onSelectFeatureSuccess(ITPNativeRichMediaProcessor paramITPNativeRichMediaProcessor, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.richmedia.ITPNativeRichMediaProcessorCallback
 * JD-Core Version:    0.7.0.1
 */