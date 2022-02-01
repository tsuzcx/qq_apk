package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.audio.Ac3Util.Ac3SyncFrameInfo;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class Ac3Reader
  implements ElementaryStreamReader
{
  private static final int HEADER_SIZE = 128;
  private static final int STATE_FINDING_SYNC = 0;
  private static final int STATE_READING_HEADER = 1;
  private static final int STATE_READING_SAMPLE = 2;
  private int bytesRead;
  private Format format;
  private final ParsableBitArray headerScratchBits = new ParsableBitArray(new byte['']);
  private final ParsableByteArray headerScratchBytes = new ParsableByteArray(this.headerScratchBits.data);
  private final String language;
  private boolean lastByteWas0B;
  private TrackOutput output;
  private long sampleDurationUs;
  private int sampleSize;
  private int state = 0;
  private long timeUs;
  private String trackFormatId;
  
  public Ac3Reader()
  {
    this(null);
  }
  
  public Ac3Reader(String paramString)
  {
    this.language = paramString;
  }
  
  private boolean continueRead(ParsableByteArray paramParsableByteArray, byte[] paramArrayOfByte, int paramInt)
  {
    int i = Math.min(paramParsableByteArray.bytesLeft(), paramInt - this.bytesRead);
    paramParsableByteArray.readBytes(paramArrayOfByte, this.bytesRead, i);
    this.bytesRead = (i + this.bytesRead);
    return this.bytesRead == paramInt;
  }
  
  private void parseHeader()
  {
    this.headerScratchBits.setPosition(0);
    Ac3Util.Ac3SyncFrameInfo localAc3SyncFrameInfo = Ac3Util.parseAc3SyncframeInfo(this.headerScratchBits);
    if ((this.format == null) || (localAc3SyncFrameInfo.channelCount != this.format.channelCount) || (localAc3SyncFrameInfo.sampleRate != this.format.sampleRate) || (localAc3SyncFrameInfo.mimeType != this.format.sampleMimeType))
    {
      this.format = Format.createAudioSampleFormat(this.trackFormatId, localAc3SyncFrameInfo.mimeType, null, -1, -1, localAc3SyncFrameInfo.channelCount, localAc3SyncFrameInfo.sampleRate, null, null, 0, this.language);
      this.output.format(this.format);
    }
    this.sampleSize = localAc3SyncFrameInfo.frameSize;
    this.sampleDurationUs = (1000000L * localAc3SyncFrameInfo.sampleCount / this.format.sampleRate);
  }
  
  private boolean skipToNextSync(ParsableByteArray paramParsableByteArray)
  {
    if (paramParsableByteArray.bytesLeft() > 0)
    {
      if (!this.lastByteWas0B)
      {
        if (paramParsableByteArray.readUnsignedByte() == 11) {}
        for (bool = true;; bool = false)
        {
          this.lastByteWas0B = bool;
          break;
        }
      }
      int i = paramParsableByteArray.readUnsignedByte();
      if (i == 119)
      {
        this.lastByteWas0B = false;
        return true;
      }
      if (i == 11) {}
      for (boolean bool = true;; bool = false)
      {
        this.lastByteWas0B = bool;
        break;
      }
    }
    return false;
  }
  
  public void consume(ParsableByteArray paramParsableByteArray)
  {
    while (paramParsableByteArray.bytesLeft() > 0)
    {
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        if (!skipToNextSync(paramParsableByteArray)) {
          continue;
        }
        this.state = 1;
        this.headerScratchBytes.data[0] = 11;
        this.headerScratchBytes.data[1] = 119;
        this.bytesRead = 2;
        break;
      case 1: 
        if (!continueRead(paramParsableByteArray, this.headerScratchBytes.data, 128)) {
          continue;
        }
        parseHeader();
        this.headerScratchBytes.setPosition(0);
        this.output.sampleData(this.headerScratchBytes, 128);
        this.state = 2;
        break;
      }
      int i = Math.min(paramParsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
      this.output.sampleData(paramParsableByteArray, i);
      this.bytesRead = (i + this.bytesRead);
      if (this.bytesRead == this.sampleSize)
      {
        this.output.sampleMetadata(this.timeUs, 1, this.sampleSize, 0, null);
        this.timeUs += this.sampleDurationUs;
        this.state = 0;
      }
    }
  }
  
  public void createTracks(ExtractorOutput paramExtractorOutput, TsPayloadReader.TrackIdGenerator paramTrackIdGenerator)
  {
    paramTrackIdGenerator.generateNewId();
    this.trackFormatId = paramTrackIdGenerator.getFormatId();
    this.output = paramExtractorOutput.track(paramTrackIdGenerator.getTrackId(), 1);
  }
  
  public void packetFinished() {}
  
  public void packetStarted(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public void seek()
  {
    this.state = 0;
    this.bytesRead = 0;
    this.lastByteWas0B = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.Ac3Reader
 * JD-Core Version:    0.7.0.1
 */