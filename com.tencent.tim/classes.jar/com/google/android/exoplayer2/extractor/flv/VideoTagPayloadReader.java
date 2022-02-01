package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.video.AvcConfig;

final class VideoTagPayloadReader
  extends TagPayloadReader
{
  private static final int AVC_PACKET_TYPE_AVC_NALU = 1;
  private static final int AVC_PACKET_TYPE_SEQUENCE_HEADER = 0;
  private static final int VIDEO_CODEC_AVC = 7;
  private static final int VIDEO_FRAME_KEYFRAME = 1;
  private static final int VIDEO_FRAME_VIDEO_INFO = 5;
  private int frameType;
  private boolean hasOutputFormat;
  private final ParsableByteArray nalLength = new ParsableByteArray(4);
  private final ParsableByteArray nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
  private int nalUnitLengthFieldLength;
  
  public VideoTagPayloadReader(TrackOutput paramTrackOutput)
  {
    super(paramTrackOutput);
  }
  
  protected boolean parseHeader(ParsableByteArray paramParsableByteArray)
    throws TagPayloadReader.UnsupportedFormatException
  {
    int j = paramParsableByteArray.readUnsignedByte();
    int i = j >> 4 & 0xF;
    j &= 0xF;
    if (j != 7) {
      throw new TagPayloadReader.UnsupportedFormatException("Video format not supported: " + j);
    }
    this.frameType = i;
    return i != 5;
  }
  
  protected void parsePayload(ParsableByteArray paramParsableByteArray, long paramLong)
    throws ParserException
  {
    int i = paramParsableByteArray.readUnsignedByte();
    long l = paramParsableByteArray.readInt24();
    if ((i == 0) && (!this.hasOutputFormat))
    {
      localObject = new ParsableByteArray(new byte[paramParsableByteArray.bytesLeft()]);
      paramParsableByteArray.readBytes(((ParsableByteArray)localObject).data, 0, paramParsableByteArray.bytesLeft());
      paramParsableByteArray = AvcConfig.parse((ParsableByteArray)localObject);
      this.nalUnitLengthFieldLength = paramParsableByteArray.nalUnitLengthFieldLength;
      paramParsableByteArray = Format.createVideoSampleFormat(null, "video/avc", null, -1, -1, paramParsableByteArray.width, paramParsableByteArray.height, -1.0F, paramParsableByteArray.initializationData, -1, paramParsableByteArray.pixelWidthAspectRatio, null);
      this.output.format(paramParsableByteArray);
      this.hasOutputFormat = true;
    }
    while ((i != 1) || (!this.hasOutputFormat)) {
      return;
    }
    Object localObject = this.nalLength.data;
    localObject[0] = 0;
    localObject[1] = 0;
    localObject[2] = 0;
    int j = this.nalUnitLengthFieldLength;
    int k;
    for (i = 0; paramParsableByteArray.bytesLeft() > 0; i = i + 4 + k)
    {
      paramParsableByteArray.readBytes(this.nalLength.data, 4 - j, this.nalUnitLengthFieldLength);
      this.nalLength.setPosition(0);
      k = this.nalLength.readUnsignedIntToInt();
      this.nalStartCode.setPosition(0);
      this.output.sampleData(this.nalStartCode, 4);
      this.output.sampleData(paramParsableByteArray, k);
    }
    paramParsableByteArray = this.output;
    if (this.frameType == 1) {}
    for (j = 1;; j = 0)
    {
      paramParsableByteArray.sampleMetadata(l * 1000L + paramLong, j, i, 0, null);
      return;
    }
  }
  
  public void seek() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.flv.VideoTagPayloadReader
 * JD-Core Version:    0.7.0.1
 */