package com.google.android.exoplayer2.source.chunk;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput.CryptoData;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

public final class ChunkExtractorWrapper
  implements ExtractorOutput
{
  private final SparseArray<BindingTrackOutput> bindingTrackOutputs;
  public final Extractor extractor;
  private boolean extractorInitialized;
  private final Format primaryTrackManifestFormat;
  private final int primaryTrackType;
  private Format[] sampleFormats;
  private SeekMap seekMap;
  private TrackOutputProvider trackOutputProvider;
  
  public ChunkExtractorWrapper(Extractor paramExtractor, int paramInt, Format paramFormat)
  {
    this.extractor = paramExtractor;
    this.primaryTrackType = paramInt;
    this.primaryTrackManifestFormat = paramFormat;
    this.bindingTrackOutputs = new SparseArray();
  }
  
  public void endTracks()
  {
    Format[] arrayOfFormat = new Format[this.bindingTrackOutputs.size()];
    int i = 0;
    while (i < this.bindingTrackOutputs.size())
    {
      arrayOfFormat[i] = ((BindingTrackOutput)this.bindingTrackOutputs.valueAt(i)).sampleFormat;
      i += 1;
    }
    this.sampleFormats = arrayOfFormat;
  }
  
  public Format[] getSampleFormats()
  {
    return this.sampleFormats;
  }
  
  public SeekMap getSeekMap()
  {
    return this.seekMap;
  }
  
  public void init(TrackOutputProvider paramTrackOutputProvider)
  {
    this.trackOutputProvider = paramTrackOutputProvider;
    if (!this.extractorInitialized)
    {
      this.extractor.init(this);
      this.extractorInitialized = true;
    }
    for (;;)
    {
      return;
      this.extractor.seek(0L, 0L);
      int i = 0;
      while (i < this.bindingTrackOutputs.size())
      {
        ((BindingTrackOutput)this.bindingTrackOutputs.valueAt(i)).bind(paramTrackOutputProvider);
        i += 1;
      }
    }
  }
  
  public void seekMap(SeekMap paramSeekMap)
  {
    this.seekMap = paramSeekMap;
  }
  
  public TrackOutput track(int paramInt1, int paramInt2)
  {
    BindingTrackOutput localBindingTrackOutput = (BindingTrackOutput)this.bindingTrackOutputs.get(paramInt1);
    Object localObject = localBindingTrackOutput;
    boolean bool;
    if (localBindingTrackOutput == null)
    {
      if (this.sampleFormats != null) {
        break label84;
      }
      bool = true;
      Assertions.checkState(bool);
      if (paramInt2 != this.primaryTrackType) {
        break label89;
      }
    }
    label84:
    label89:
    for (localObject = this.primaryTrackManifestFormat;; localObject = null)
    {
      localObject = new BindingTrackOutput(paramInt1, paramInt2, (Format)localObject);
      ((BindingTrackOutput)localObject).bind(this.trackOutputProvider);
      this.bindingTrackOutputs.put(paramInt1, localObject);
      return localObject;
      bool = false;
      break;
    }
  }
  
  static final class BindingTrackOutput
    implements TrackOutput
  {
    private final int id;
    private final Format manifestFormat;
    public Format sampleFormat;
    private TrackOutput trackOutput;
    private final int type;
    
    public BindingTrackOutput(int paramInt1, int paramInt2, Format paramFormat)
    {
      this.id = paramInt1;
      this.type = paramInt2;
      this.manifestFormat = paramFormat;
    }
    
    public void bind(ChunkExtractorWrapper.TrackOutputProvider paramTrackOutputProvider)
    {
      if (paramTrackOutputProvider == null) {
        this.trackOutput = new DummyTrackOutput();
      }
      do
      {
        return;
        this.trackOutput = paramTrackOutputProvider.track(this.id, this.type);
      } while (this.sampleFormat == null);
      this.trackOutput.format(this.sampleFormat);
    }
    
    public void format(Format paramFormat)
    {
      Format localFormat = paramFormat;
      if (this.manifestFormat != null) {
        localFormat = paramFormat.copyWithManifestFormatInfo(this.manifestFormat);
      }
      this.sampleFormat = localFormat;
      this.trackOutput.format(this.sampleFormat);
    }
    
    public int sampleData(ExtractorInput paramExtractorInput, int paramInt, boolean paramBoolean)
      throws IOException, InterruptedException
    {
      return this.trackOutput.sampleData(paramExtractorInput, paramInt, paramBoolean);
    }
    
    public void sampleData(ParsableByteArray paramParsableByteArray, int paramInt)
    {
      this.trackOutput.sampleData(paramParsableByteArray, paramInt);
    }
    
    public void sampleMetadata(long paramLong, int paramInt1, int paramInt2, int paramInt3, TrackOutput.CryptoData paramCryptoData)
    {
      this.trackOutput.sampleMetadata(paramLong, paramInt1, paramInt2, paramInt3, paramCryptoData);
    }
  }
  
  public static abstract interface TrackOutputProvider
  {
    public abstract TrackOutput track(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper
 * JD-Core Version:    0.7.0.1
 */