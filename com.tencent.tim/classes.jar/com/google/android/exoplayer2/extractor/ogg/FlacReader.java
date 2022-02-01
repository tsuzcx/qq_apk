package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap.SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.FlacStreamInfo;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

final class FlacReader
  extends StreamReader
{
  private static final byte AUDIO_PACKET_TYPE = -1;
  private static final int FRAME_HEADER_SAMPLE_NUMBER_OFFSET = 4;
  private static final byte SEEKTABLE_PACKET_TYPE = 3;
  private FlacOggSeeker flacOggSeeker;
  private FlacStreamInfo streamInfo;
  
  private int getFlacFrameBlockSize(ParsableByteArray paramParsableByteArray)
  {
    int i = (paramParsableByteArray.data[2] & 0xFF) >> 4;
    switch (i)
    {
    default: 
      return -1;
    case 1: 
      return 192;
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      return 576 << i - 2;
    case 6: 
    case 7: 
      paramParsableByteArray.skipBytes(4);
      paramParsableByteArray.readUtf8EncodedLong();
      if (i == 6) {}
      for (i = paramParsableByteArray.readUnsignedByte();; i = paramParsableByteArray.readUnsignedShort())
      {
        paramParsableByteArray.setPosition(0);
        return i + 1;
      }
    }
    return 256 << i - 8;
  }
  
  private static boolean isAudioPacket(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    if (paramArrayOfByte[0] == -1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean verifyBitstreamType(ParsableByteArray paramParsableByteArray)
  {
    return (paramParsableByteArray.bytesLeft() >= 5) && (paramParsableByteArray.readUnsignedByte() == 127) && (paramParsableByteArray.readUnsignedInt() == 1179402563L);
  }
  
  protected long preparePayload(ParsableByteArray paramParsableByteArray)
  {
    if (!isAudioPacket(paramParsableByteArray.data)) {
      return -1L;
    }
    return getFlacFrameBlockSize(paramParsableByteArray);
  }
  
  protected boolean readHeaders(ParsableByteArray paramParsableByteArray, long paramLong, StreamReader.SetupData paramSetupData)
    throws IOException, InterruptedException
  {
    boolean bool = false;
    byte[] arrayOfByte = paramParsableByteArray.data;
    if (this.streamInfo == null)
    {
      this.streamInfo = new FlacStreamInfo(arrayOfByte, 17);
      paramParsableByteArray = Arrays.copyOfRange(arrayOfByte, 9, paramParsableByteArray.limit());
      paramParsableByteArray[4] = -128;
      paramParsableByteArray = Collections.singletonList(paramParsableByteArray);
      paramSetupData.format = Format.createAudioSampleFormat(null, "audio/flac", null, -1, this.streamInfo.bitRate(), this.streamInfo.channels, this.streamInfo.sampleRate, paramParsableByteArray, null, 0, null);
      bool = true;
    }
    do
    {
      return bool;
      if ((arrayOfByte[0] & 0x7F) == 3)
      {
        this.flacOggSeeker = new FlacOggSeeker();
        this.flacOggSeeker.parseSeekTable(paramParsableByteArray);
        break;
      }
      if (!isAudioPacket(arrayOfByte)) {
        break;
      }
    } while (this.flacOggSeeker == null);
    this.flacOggSeeker.setFirstFrameOffset(paramLong);
    paramSetupData.oggSeeker = this.flacOggSeeker;
    return false;
  }
  
  protected void reset(boolean paramBoolean)
  {
    super.reset(paramBoolean);
    if (paramBoolean)
    {
      this.streamInfo = null;
      this.flacOggSeeker = null;
    }
  }
  
  class FlacOggSeeker
    implements SeekMap, OggSeeker
  {
    private static final int METADATA_LENGTH_OFFSET = 1;
    private static final int SEEK_POINT_SIZE = 18;
    private long firstFrameOffset = -1L;
    private long pendingSeekGranule = -1L;
    private long[] seekPointGranules;
    private long[] seekPointOffsets;
    
    public FlacOggSeeker() {}
    
    public SeekMap createSeekMap()
    {
      return this;
    }
    
    public long getDurationUs()
    {
      return FlacReader.this.streamInfo.durationUs();
    }
    
    public SeekMap.SeekPoints getSeekPoints(long paramLong)
    {
      long l = FlacReader.this.convertTimeToGranule(paramLong);
      int i = Util.binarySearchFloor(this.seekPointGranules, l, true, true);
      l = FlacReader.this.convertGranuleToTime(this.seekPointGranules[i]);
      SeekPoint localSeekPoint = new SeekPoint(l, this.firstFrameOffset + this.seekPointOffsets[i]);
      if ((l >= paramLong) || (i == this.seekPointGranules.length - 1)) {
        return new SeekMap.SeekPoints(localSeekPoint);
      }
      return new SeekMap.SeekPoints(localSeekPoint, new SeekPoint(FlacReader.this.convertGranuleToTime(this.seekPointGranules[(i + 1)]), this.firstFrameOffset + this.seekPointOffsets[(i + 1)]));
    }
    
    public boolean isSeekable()
    {
      return true;
    }
    
    public void parseSeekTable(ParsableByteArray paramParsableByteArray)
    {
      paramParsableByteArray.skipBytes(1);
      int j = paramParsableByteArray.readUnsignedInt24() / 18;
      this.seekPointGranules = new long[j];
      this.seekPointOffsets = new long[j];
      int i = 0;
      while (i < j)
      {
        this.seekPointGranules[i] = paramParsableByteArray.readLong();
        this.seekPointOffsets[i] = paramParsableByteArray.readLong();
        paramParsableByteArray.skipBytes(2);
        i += 1;
      }
    }
    
    public long read(ExtractorInput paramExtractorInput)
      throws IOException, InterruptedException
    {
      if (this.pendingSeekGranule >= 0L)
      {
        long l = -(this.pendingSeekGranule + 2L);
        this.pendingSeekGranule = -1L;
        return l;
      }
      return -1L;
    }
    
    public void setFirstFrameOffset(long paramLong)
    {
      this.firstFrameOffset = paramLong;
    }
    
    public long startSeek(long paramLong)
    {
      paramLong = FlacReader.this.convertTimeToGranule(paramLong);
      int i = Util.binarySearchFloor(this.seekPointGranules, paramLong, true, true);
      this.pendingSeekGranule = this.seekPointGranules[i];
      return paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ogg.FlacReader
 * JD-Core Version:    0.7.0.1
 */