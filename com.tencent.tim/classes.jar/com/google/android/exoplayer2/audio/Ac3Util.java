package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;

public final class Ac3Util
{
  private static final int AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT = 1536;
  private static final int AUDIO_SAMPLES_PER_AUDIO_BLOCK = 256;
  private static final int[] BITRATE_BY_HALF_FRMSIZECOD = { 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640 };
  private static final int[] BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD = { 1, 2, 3, 6 };
  private static final int[] CHANNEL_COUNT_BY_ACMOD;
  private static final int[] SAMPLE_RATE_BY_FSCOD = { 48000, 44100, 32000 };
  private static final int[] SAMPLE_RATE_BY_FSCOD2 = { 24000, 22050, 16000 };
  private static final int[] SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1 = { 69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393 };
  public static final int TRUEHD_RECHUNK_SAMPLE_COUNT = 8;
  public static final int TRUEHD_SYNCFRAME_PREFIX_LENGTH = 12;
  
  static
  {
    CHANNEL_COUNT_BY_ACMOD = new int[] { 2, 1, 2, 3, 3, 4, 4, 5 };
  }
  
  public static int getAc3SyncframeAudioSampleCount()
  {
    return 1536;
  }
  
  private static int getAc3SyncframeSize(int paramInt1, int paramInt2)
  {
    int i = paramInt2 / 2;
    if ((paramInt1 < 0) || (paramInt1 >= SAMPLE_RATE_BY_FSCOD.length) || (paramInt2 < 0) || (i >= SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1.length)) {
      return -1;
    }
    paramInt1 = SAMPLE_RATE_BY_FSCOD[paramInt1];
    if (paramInt1 == 44100) {
      return (SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1[i] + paramInt2 % 2) * 2;
    }
    paramInt2 = BITRATE_BY_HALF_FRMSIZECOD[i];
    if (paramInt1 == 32000) {
      return paramInt2 * 6;
    }
    return paramInt2 * 4;
  }
  
  public static Format parseAc3AnnexFFormat(ParsableByteArray paramParsableByteArray, String paramString1, String paramString2, DrmInitData paramDrmInitData)
  {
    int i = paramParsableByteArray.readUnsignedByte();
    int k = SAMPLE_RATE_BY_FSCOD[((i & 0xC0) >> 6)];
    int m = paramParsableByteArray.readUnsignedByte();
    int j = CHANNEL_COUNT_BY_ACMOD[((m & 0x38) >> 3)];
    i = j;
    if ((m & 0x4) != 0) {
      i = j + 1;
    }
    return Format.createAudioSampleFormat(paramString1, "audio/ac3", null, -1, -1, i, k, null, paramDrmInitData, 0, paramString2);
  }
  
  public static Ac3SyncFrameInfo parseAc3SyncframeInfo(ParsableBitArray paramParsableBitArray)
  {
    int j = paramParsableBitArray.getPosition();
    paramParsableBitArray.skipBits(40);
    int i4;
    label92:
    int i2;
    int i5;
    int i3;
    if (paramParsableBitArray.readBits(5) == 16)
    {
      i = 1;
      paramParsableBitArray.setPosition(j);
      j = -1;
      if (i == 0) {
        break label852;
      }
      paramParsableBitArray.skipBits(16);
      n = paramParsableBitArray.readBits(2);
      paramParsableBitArray.skipBits(3);
      i1 = (paramParsableBitArray.readBits(11) + 1) * 2;
      i4 = paramParsableBitArray.readBits(2);
      if (i4 != 3) {
        break label583;
      }
      j = 3;
      i = SAMPLE_RATE_BY_FSCOD2[paramParsableBitArray.readBits(2)];
      k = 6;
      i2 = k * 256;
      i5 = paramParsableBitArray.readBits(3);
      bool = paramParsableBitArray.readBit();
      i3 = CHANNEL_COUNT_BY_ACMOD[i5];
      if (!bool) {
        break label605;
      }
      m = 1;
      label128:
      i3 = m + i3;
      paramParsableBitArray.skipBits(10);
      if (paramParsableBitArray.readBit()) {
        paramParsableBitArray.skipBits(8);
      }
      if (i5 == 0)
      {
        paramParsableBitArray.skipBits(5);
        if (paramParsableBitArray.readBit()) {
          paramParsableBitArray.skipBits(8);
        }
      }
      if ((n == 1) && (paramParsableBitArray.readBit())) {
        paramParsableBitArray.skipBits(16);
      }
      if (paramParsableBitArray.readBit())
      {
        if (i5 > 2) {
          paramParsableBitArray.skipBits(2);
        }
        if (((i5 & 0x1) != 0) && (i5 > 2)) {
          paramParsableBitArray.skipBits(6);
        }
        if ((i5 & 0x4) != 0) {
          paramParsableBitArray.skipBits(6);
        }
        if ((bool) && (paramParsableBitArray.readBit())) {
          paramParsableBitArray.skipBits(5);
        }
        if (n == 0)
        {
          if (paramParsableBitArray.readBit()) {
            paramParsableBitArray.skipBits(6);
          }
          if ((i5 == 0) && (paramParsableBitArray.readBit())) {
            paramParsableBitArray.skipBits(6);
          }
          if (paramParsableBitArray.readBit()) {
            paramParsableBitArray.skipBits(6);
          }
          m = paramParsableBitArray.readBits(2);
          if (m != 1) {
            break label611;
          }
          paramParsableBitArray.skipBits(5);
          label330:
          if (i5 < 2)
          {
            if (paramParsableBitArray.readBit()) {
              paramParsableBitArray.skipBits(14);
            }
            if ((i5 == 0) && (paramParsableBitArray.readBit())) {
              paramParsableBitArray.skipBits(14);
            }
          }
          if (paramParsableBitArray.readBit())
          {
            if (j != 0) {
              break label822;
            }
            paramParsableBitArray.skipBits(5);
          }
        }
      }
    }
    for (;;)
    {
      if (paramParsableBitArray.readBit())
      {
        paramParsableBitArray.skipBits(5);
        if (i5 == 2) {
          paramParsableBitArray.skipBits(4);
        }
        if (i5 >= 6) {
          paramParsableBitArray.skipBits(2);
        }
        if (paramParsableBitArray.readBit()) {
          paramParsableBitArray.skipBits(8);
        }
        if ((i5 == 0) && (paramParsableBitArray.readBit())) {
          paramParsableBitArray.skipBits(8);
        }
        if (i4 < 3) {
          paramParsableBitArray.skipBit();
        }
      }
      if ((n == 0) && (j != 3)) {
        paramParsableBitArray.skipBit();
      }
      if ((n == 2) && ((j == 3) || (paramParsableBitArray.readBit()))) {
        paramParsableBitArray.skipBits(6);
      }
      String str2 = "audio/eac3";
      str1 = str2;
      if (paramParsableBitArray.readBit())
      {
        str1 = str2;
        if (paramParsableBitArray.readBits(6) == 1)
        {
          str1 = str2;
          if (paramParsableBitArray.readBits(8) == 1) {
            str1 = "audio/eac3-joc";
          }
        }
      }
      k = i;
      i = n;
      n = i2;
      m = i1;
      j = i3;
      return new Ac3SyncFrameInfo(str1, i, j, k, m, n, null);
      i = 0;
      break;
      label583:
      j = paramParsableBitArray.readBits(2);
      k = BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[j];
      i = SAMPLE_RATE_BY_FSCOD[i4];
      break label92;
      label605:
      m = 0;
      break label128;
      label611:
      if (m == 2)
      {
        paramParsableBitArray.skipBits(12);
        break label330;
      }
      if (m != 3) {
        break label330;
      }
      m = paramParsableBitArray.readBits(5);
      if (paramParsableBitArray.readBit())
      {
        paramParsableBitArray.skipBits(5);
        if (paramParsableBitArray.readBit()) {
          paramParsableBitArray.skipBits(4);
        }
        if (paramParsableBitArray.readBit()) {
          paramParsableBitArray.skipBits(4);
        }
        if (paramParsableBitArray.readBit()) {
          paramParsableBitArray.skipBits(4);
        }
        if (paramParsableBitArray.readBit()) {
          paramParsableBitArray.skipBits(4);
        }
        if (paramParsableBitArray.readBit()) {
          paramParsableBitArray.skipBits(4);
        }
        if (paramParsableBitArray.readBit()) {
          paramParsableBitArray.skipBits(4);
        }
        if (paramParsableBitArray.readBit()) {
          paramParsableBitArray.skipBits(4);
        }
        if (paramParsableBitArray.readBit())
        {
          if (paramParsableBitArray.readBit()) {
            paramParsableBitArray.skipBits(4);
          }
          if (paramParsableBitArray.readBit()) {
            paramParsableBitArray.skipBits(4);
          }
        }
      }
      if (paramParsableBitArray.readBit())
      {
        paramParsableBitArray.skipBits(5);
        if (paramParsableBitArray.readBit())
        {
          paramParsableBitArray.skipBits(7);
          if (paramParsableBitArray.readBit()) {
            paramParsableBitArray.skipBits(8);
          }
        }
      }
      paramParsableBitArray.skipBits((m + 2) * 8);
      paramParsableBitArray.byteAlign();
      break label330;
      label822:
      m = 0;
      while (m < k)
      {
        if (paramParsableBitArray.readBit()) {
          paramParsableBitArray.skipBits(5);
        }
        m += 1;
      }
    }
    label852:
    String str1 = "audio/ac3";
    paramParsableBitArray.skipBits(32);
    int k = paramParsableBitArray.readBits(2);
    int m = getAc3SyncframeSize(k, paramParsableBitArray.readBits(6));
    paramParsableBitArray.skipBits(8);
    int i = paramParsableBitArray.readBits(3);
    if (((i & 0x1) != 0) && (i != 1)) {
      paramParsableBitArray.skipBits(2);
    }
    if ((i & 0x4) != 0) {
      paramParsableBitArray.skipBits(2);
    }
    if (i == 2) {
      paramParsableBitArray.skipBits(2);
    }
    k = SAMPLE_RATE_BY_FSCOD[k];
    int n = 1536;
    boolean bool = paramParsableBitArray.readBit();
    int i1 = CHANNEL_COUNT_BY_ACMOD[i];
    if (bool) {}
    for (i = 1;; i = 0)
    {
      i1 += i;
      i = j;
      j = i1;
      break;
    }
  }
  
  public static int parseAc3SyncframeSize(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 5) {
      return -1;
    }
    return getAc3SyncframeSize((paramArrayOfByte[4] & 0xC0) >> 6, paramArrayOfByte[4] & 0x3F);
  }
  
  public static Format parseEAc3AnnexFFormat(ParsableByteArray paramParsableByteArray, String paramString1, String paramString2, DrmInitData paramDrmInitData)
  {
    paramParsableByteArray.skipBytes(2);
    int i = paramParsableByteArray.readUnsignedByte();
    int k = SAMPLE_RATE_BY_FSCOD[((i & 0xC0) >> 6)];
    int m = paramParsableByteArray.readUnsignedByte();
    int j = CHANNEL_COUNT_BY_ACMOD[((m & 0xE) >> 1)];
    i = j;
    if ((m & 0x1) != 0) {
      i = j + 1;
    }
    if (((paramParsableByteArray.readUnsignedByte() & 0x1E) >> 1 > 0) && ((paramParsableByteArray.readUnsignedByte() & 0x2) != 0)) {
      i += 2;
    }
    for (;;)
    {
      String str2 = "audio/eac3";
      String str1 = str2;
      if (paramParsableByteArray.bytesLeft() > 0)
      {
        str1 = str2;
        if ((paramParsableByteArray.readUnsignedByte() & 0x1) != 0) {
          str1 = "audio/eac3-joc";
        }
      }
      return Format.createAudioSampleFormat(paramString1, str1, null, -1, -1, i, k, null, paramDrmInitData, 0, paramString2);
    }
  }
  
  public static int parseEAc3SyncframeAudioSampleCount(ByteBuffer paramByteBuffer)
  {
    if ((paramByteBuffer.get(paramByteBuffer.position() + 4) & 0xC0) >> 6 == 3) {}
    for (int i = 6;; i = BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[((paramByteBuffer.get(paramByteBuffer.position() + 4) & 0x30) >> 4)]) {
      return i * 256;
    }
  }
  
  public static int parseTrueHdSyncframeAudioSampleCount(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.getInt(paramByteBuffer.position() + 4) != -1167101192) {
      return 0;
    }
    return 40 << (paramByteBuffer.get(paramByteBuffer.position() + 8) & 0x7);
  }
  
  public static int parseTrueHdSyncframeAudioSampleCount(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte[4] != -8) || (paramArrayOfByte[5] != 114) || (paramArrayOfByte[6] != 111) || (paramArrayOfByte[7] != -70)) {
      return 0;
    }
    return 40 << (paramArrayOfByte[8] & 0x7);
  }
  
  public static final class Ac3SyncFrameInfo
  {
    public static final int STREAM_TYPE_TYPE0 = 0;
    public static final int STREAM_TYPE_TYPE1 = 1;
    public static final int STREAM_TYPE_TYPE2 = 2;
    public static final int STREAM_TYPE_UNDEFINED = -1;
    public final int channelCount;
    public final int frameSize;
    public final String mimeType;
    public final int sampleCount;
    public final int sampleRate;
    public final int streamType;
    
    private Ac3SyncFrameInfo(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.mimeType = paramString;
      this.streamType = paramInt1;
      this.channelCount = paramInt2;
      this.sampleRate = paramInt3;
      this.frameSize = paramInt4;
      this.sampleCount = paramInt5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.Ac3Util
 * JD-Core Version:    0.7.0.1
 */