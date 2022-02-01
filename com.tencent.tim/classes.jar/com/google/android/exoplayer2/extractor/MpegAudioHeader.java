package com.google.android.exoplayer2.extractor;

public final class MpegAudioHeader
{
  private static final int[] BITRATE_V1_L1;
  private static final int[] BITRATE_V1_L2 = { 32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384 };
  private static final int[] BITRATE_V1_L3 = { 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320 };
  private static final int[] BITRATE_V2 = { 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160 };
  private static final int[] BITRATE_V2_L1;
  public static final int MAX_FRAME_SIZE_BYTES = 4096;
  private static final String[] MIME_TYPE_BY_LAYER = { "audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg" };
  private static final int[] SAMPLING_RATE_V1 = { 44100, 48000, 32000 };
  public int bitrate;
  public int channels;
  public int frameSize;
  public String mimeType;
  public int sampleRate;
  public int samplesPerFrame;
  public int version;
  
  static
  {
    BITRATE_V1_L1 = new int[] { 32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 352, 384, 416, 448 };
    BITRATE_V2_L1 = new int[] { 32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, 192, 224, 256 };
  }
  
  public static int getFrameSize(int paramInt)
  {
    if ((paramInt & 0xFFE00000) != -2097152) {}
    int j;
    int k;
    int n;
    do
    {
      do
      {
        do
        {
          do
          {
            return -1;
            j = paramInt >>> 19 & 0x3;
          } while (j == 1);
          k = paramInt >>> 17 & 0x3;
        } while (k == 0);
        n = paramInt >>> 12 & 0xF;
      } while ((n == 0) || (n == 15));
      i = paramInt >>> 10 & 0x3;
    } while (i == 3);
    int i = SAMPLING_RATE_V1[i];
    if (j == 2) {
      i /= 2;
    }
    label226:
    for (;;)
    {
      int m = paramInt >>> 9 & 0x1;
      if (k == 3)
      {
        if (j == 3) {}
        for (paramInt = BITRATE_V1_L1[(n - 1)];; paramInt = BITRATE_V2_L1[(n - 1)])
        {
          return (paramInt * 12000 / i + m) * 4;
          if (j != 0) {
            break label226;
          }
          i /= 4;
          break;
        }
      }
      if (j == 3) {
        if (k == 2) {
          paramInt = BITRATE_V1_L2[(n - 1)];
        }
      }
      while (j == 3)
      {
        return 144000 * paramInt / i + m;
        paramInt = BITRATE_V1_L3[(n - 1)];
        continue;
        paramInt = BITRATE_V2[(n - 1)];
      }
      if (k == 1) {}
      for (j = 72000;; j = 144000) {
        return j * paramInt / i + m;
      }
    }
  }
  
  public static boolean populateHeader(int paramInt, MpegAudioHeader paramMpegAudioHeader)
  {
    int n = 2;
    if ((paramInt & 0xFFE00000) != -2097152) {
      return false;
    }
    int i2 = paramInt >>> 19 & 0x3;
    if (i2 == 1) {
      return false;
    }
    int i3 = paramInt >>> 17 & 0x3;
    if (i3 == 0) {
      return false;
    }
    int k = paramInt >>> 12 & 0xF;
    if ((k == 0) || (k == 15)) {
      return false;
    }
    int i = paramInt >>> 10 & 0x3;
    if (i == 3) {
      return false;
    }
    int j = SAMPLING_RATE_V1[i];
    int i1;
    if (i2 == 2)
    {
      i = j / 2;
      i1 = paramInt >>> 9 & 0x1;
      if (i3 != 3) {
        break label219;
      }
      if (i2 != 3) {
        break label206;
      }
    }
    label206:
    for (k = BITRATE_V1_L1[(k - 1)];; k = BITRATE_V2_L1[(k - 1)])
    {
      m = (k * 12000 / i + i1) * 4;
      j = 384;
      String str = MIME_TYPE_BY_LAYER[(3 - i3)];
      if ((paramInt >> 6 & 0x3) == 3) {
        n = 1;
      }
      paramMpegAudioHeader.setValues(i2, str, m, i, n, k * 1000, j);
      return true;
      i = j;
      if (i2 != 0) {
        break;
      }
      i = j / 4;
      break;
    }
    label219:
    if (i2 == 3)
    {
      if (i3 == 2) {}
      for (k = BITRATE_V1_L2[(k - 1)];; k = BITRATE_V1_L3[(k - 1)])
      {
        j = 1152;
        m = i1 + 144000 * k / i;
        break;
      }
    }
    int m = BITRATE_V2[(k - 1)];
    if (i3 == 1)
    {
      j = 576;
      label293:
      if (i3 != 1) {
        break label333;
      }
    }
    label333:
    for (k = 72000;; k = 144000)
    {
      i1 += k * m / i;
      k = m;
      m = i1;
      break;
      j = 1152;
      break label293;
    }
  }
  
  private void setValues(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.version = paramInt1;
    this.mimeType = paramString;
    this.frameSize = paramInt2;
    this.sampleRate = paramInt3;
    this.channels = paramInt4;
    this.bitrate = paramInt5;
    this.samplesPerFrame = paramInt6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.MpegAudioHeader
 * JD-Core Version:    0.7.0.1
 */