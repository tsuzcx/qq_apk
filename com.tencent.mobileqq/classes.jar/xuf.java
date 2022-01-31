import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(18)
public class xuf
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer;
  private String jdField_a_of_type_JavaLangString;
  private xuh jdField_a_of_type_Xuh = new xuh(null);
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private MediaExtractor jdField_b_of_type_AndroidMediaMediaExtractor;
  private String jdField_b_of_type_JavaLangString;
  
  public xuf(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
  }
  
  private int a(MediaExtractor paramMediaExtractor, String paramString)
  {
    if (paramMediaExtractor == null) {
      return -1;
    }
    int i = 0;
    while (i < paramMediaExtractor.getTrackCount())
    {
      String str = paramMediaExtractor.getTrackFormat(i).getString("mime");
      if (QLog.isColorLevel()) {
        QLog.d("HwVideoMerge", 2, "format for track " + i + " is " + str);
      }
      if (str.startsWith(paramString))
      {
        paramMediaExtractor.selectTrack(i);
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final int a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    paramString2 = new xuf(paramString1, paramString2, 0L, 0L);
    int i = paramString2.a(paramString3, paramInt);
    if ((i == -2) || (i == -4) || (i == -6)) {
      if (new File(paramString1).renameTo(new File(paramString3))) {
        paramInt = 0;
      }
    }
    do
    {
      return paramInt;
      return -10;
      paramInt = i;
    } while (i != 0);
    return paramString2.a();
  }
  
  public static final int a(String paramString1, String paramString2, String paramString3, int paramInt, long paramLong1, long paramLong2)
  {
    paramString2 = new xuf(paramString1, paramString2, paramLong1, paramLong2);
    int i = paramString2.a(paramString3, paramInt);
    if ((i == -2) || (i == -4) || (i == -6)) {
      if (new File(paramString1).renameTo(new File(paramString3))) {
        paramInt = 0;
      }
    }
    do
    {
      return paramInt;
      return -10;
      paramInt = i;
    } while (i != 0);
    paramString2.a();
    return i;
  }
  
  private MediaExtractor a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      MediaExtractor localMediaExtractor = new MediaExtractor();
      try
      {
        localMediaExtractor.setDataSource(paramString);
        return localMediaExtractor;
      }
      catch (IOException localIOException)
      {
        a("createExtractor path:" + paramString, localIOException);
        localMediaExtractor.release();
        return null;
      }
    }
    return null;
  }
  
  private void a()
  {
    boolean bool2 = false;
    int i = 0;
    while ((!bool2) || (i == 0))
    {
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool2 = a();
        bool1 = bool2;
        if (!bool2)
        {
          this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.jdField_a_of_type_Xuh.jdField_a_of_type_Int, this.jdField_a_of_type_Xuh.jdField_a_of_type_JavaNioByteBuffer, this.jdField_a_of_type_Xuh.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
          bool1 = bool2;
        }
      }
      bool2 = bool1;
      if (i == 0)
      {
        boolean bool3 = b();
        bool2 = bool1;
        i = bool3;
        if (!bool3)
        {
          this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.jdField_a_of_type_Xuh.jdField_b_of_type_Int, this.jdField_a_of_type_Xuh.jdField_a_of_type_JavaNioByteBuffer, this.jdField_a_of_type_Xuh.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
          bool2 = bool1;
          i = bool3;
        }
      }
    }
  }
  
  private static void a(String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.d("HwVideoMerge", 2, paramString, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.d("HwVideoMerge", 2, paramString);
  }
  
  private boolean a()
  {
    this.jdField_a_of_type_Xuh.jdField_a_of_type_JavaNioByteBuffer.position(0);
    if (this.jdField_a_of_type_AndroidMediaMediaExtractor == null) {}
    int i;
    do
    {
      return true;
      i = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(this.jdField_a_of_type_Xuh.jdField_a_of_type_JavaNioByteBuffer, 0);
    } while (i <= 0);
    this.jdField_a_of_type_Xuh.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
    this.jdField_a_of_type_Xuh.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size = i;
    this.jdField_a_of_type_Xuh.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset = 0;
    this.jdField_a_of_type_Xuh.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleFlags();
    this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
    return false;
  }
  
  private int b()
  {
    int i = 0;
    this.jdField_a_of_type_Xuh.jdField_a_of_type_JavaNioByteBuffer.position(0);
    if (this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(this.jdField_a_of_type_Xuh.jdField_a_of_type_JavaNioByteBuffer, 0) <= 0)
    {
      b();
      i = -5;
    }
    do
    {
      return i;
      this.jdField_a_of_type_Xuh.jdField_a_of_type_JavaNioByteBuffer.position(0);
    } while (this.jdField_b_of_type_AndroidMediaMediaExtractor.readSampleData(this.jdField_a_of_type_Xuh.jdField_a_of_type_JavaNioByteBuffer, 0) > 0);
    b();
    return -6;
  }
  
  private static int b(String paramString, int paramInt)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = null;
      try
      {
        String str = localMediaMetadataRetriever.extractMetadata(24);
        paramString = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("HwVideoMerge", 2, localException, new Object[0]);
        }
      }
      localMediaMetadataRetriever.release();
      if (paramString == null) {
        return paramInt;
      }
      int i;
      return paramInt;
    }
    catch (IllegalArgumentException paramString)
    {
      try
      {
        i = Integer.parseInt(paramString);
        return i;
      }
      catch (NumberFormatException paramString) {}
      paramString = paramString;
      return paramInt;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaExtractor != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      this.jdField_a_of_type_AndroidMediaMediaExtractor = null;
    }
    if (this.jdField_b_of_type_AndroidMediaMediaExtractor != null)
    {
      this.jdField_b_of_type_AndroidMediaMediaExtractor.release();
      this.jdField_b_of_type_AndroidMediaMediaExtractor = null;
    }
  }
  
  private boolean b()
  {
    this.jdField_a_of_type_Xuh.jdField_a_of_type_JavaNioByteBuffer.position(0);
    if (this.jdField_b_of_type_AndroidMediaMediaExtractor == null) {
      return true;
    }
    long l = this.jdField_b_of_type_AndroidMediaMediaExtractor.getSampleTime();
    int i = this.jdField_b_of_type_AndroidMediaMediaExtractor.readSampleData(this.jdField_a_of_type_Xuh.jdField_a_of_type_JavaNioByteBuffer, 0);
    if ((i <= 0) || ((this.jdField_b_of_type_Long != 0L) && (l > this.jdField_b_of_type_Long * 1000L)))
    {
      QLog.d("HwVideoMerge", 2, "getAudioInputBuffer audio end. sampleTime:" + l);
      return true;
    }
    this.jdField_a_of_type_Xuh.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs = l;
    this.jdField_a_of_type_Xuh.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size = i;
    this.jdField_a_of_type_Xuh.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset = 0;
    this.jdField_a_of_type_Xuh.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags = this.jdField_b_of_type_AndroidMediaMediaExtractor.getSampleFlags();
    this.jdField_b_of_type_AndroidMediaMediaExtractor.advance();
    return false;
  }
  
  public int a()
  {
    int i = 0;
    this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
    try
    {
      a();
      this.jdField_a_of_type_AndroidMediaMediaMuxer.stop();
      this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
      this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
      b();
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("HwVideoMerge", 1, "doWork error, ", localException);
        i = -13;
      }
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidMediaMediaExtractor = a(this.jdField_a_of_type_JavaLangString);
    int i = a(this.jdField_a_of_type_AndroidMediaMediaExtractor, "video/");
    if ((this.jdField_a_of_type_AndroidMediaMediaExtractor == null) || (i < 0)) {
      i = -1;
    }
    int j;
    MediaFormat localMediaFormat1;
    MediaFormat localMediaFormat2;
    do
    {
      return i;
      this.jdField_b_of_type_AndroidMediaMediaExtractor = a(this.jdField_b_of_type_JavaLangString);
      j = a(this.jdField_b_of_type_AndroidMediaMediaExtractor, "audio/");
      if ((this.jdField_b_of_type_AndroidMediaMediaExtractor == null) || (j < 0)) {
        return -2;
      }
      if (this.jdField_a_of_type_Long > 0L) {
        this.jdField_b_of_type_AndroidMediaMediaExtractor.seekTo(this.jdField_b_of_type_Long * 1000L, 0);
      }
      localMediaFormat1 = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(i);
      localMediaFormat2 = this.jdField_b_of_type_AndroidMediaMediaExtractor.getTrackFormat(j);
      this.jdField_a_of_type_Int = localMediaFormat1.getInteger("width");
      this.jdField_b_of_type_Int = localMediaFormat1.getInteger("height");
      this.jdField_a_of_type_Xuh.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      j = b();
      i = j;
    } while (j != 0);
    if (TextUtils.isEmpty(paramString))
    {
      b();
      return -9;
    }
    try
    {
      if (new File(paramString).exists())
      {
        b();
        return -8;
      }
      this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(paramString, 0);
      paramInt = b(this.jdField_a_of_type_JavaLangString, paramInt);
      this.jdField_a_of_type_AndroidMediaMediaMuxer.setOrientationHint(paramInt);
      this.jdField_a_of_type_Xuh.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(localMediaFormat1);
      this.jdField_a_of_type_Xuh.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(localMediaFormat2);
      return j;
    }
    catch (IOException paramString)
    {
      this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
      b();
    }
    return -7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xuf
 * JD-Core Version:    0.7.0.1
 */