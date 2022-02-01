package com.tencent.mobileqq.shortvideo.util;

import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;

public class AudioResample
{
  static
  {
    boolean bool = ShortVideoUtils.awI();
    QLog.i("SegmentClipUtils", 2, "LoadExtractedShortVideoSo:loaded=" + bool);
    if (!bool)
    {
      VideoEnvironment.a("AVCodec", null, true);
      bool = ShortVideoUtils.awI();
      if (QLog.isColorLevel()) {
        QLog.i("SegmentClipUtils", 2, "LoadExtractedShortVideoSo:loaded=" + bool);
      }
    }
  }
  
  public static native int nativeResample(int paramInt1, int paramInt2, byte[] paramArrayOfByte1, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, int paramInt5);
  
  public static native int parseMp4Info(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.AudioResample
 * JD-Core Version:    0.7.0.1
 */