package com.tencent.tav.core;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IDecoder;
import java.util.List;

public class EmptyReaderOutput
  extends AssetReaderOutput
{
  public void markConfigurationAsFinal() {}
  
  @NonNull
  public CMSampleBuffer nextSampleBuffer()
  {
    return new CMSampleBuffer(IDecoder.SAMPLE_TIME_FINISH);
  }
  
  void release() {}
  
  public void resetForReadingTimeRanges(List<CMTimeRange> paramList) {}
  
  void start(@Nullable IContextCreate paramIContextCreate, AssetReader paramAssetReader) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.tav.core.EmptyReaderOutput
 * JD-Core Version:    0.7.0.1
 */