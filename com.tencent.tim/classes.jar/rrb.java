import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
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
public class rrb
{
  private long Ct;
  private long Cu;
  private MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer;
  private rrb.a jdField_a_of_type_Rrb$a = new rrb.a(null);
  private String aAu;
  private MediaExtractor b;
  private MediaExtractor c;
  private String mAudioFilePath;
  private int mHeight;
  private int mWidth;
  
  public rrb(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    this.aAu = paramString1;
    this.mAudioFilePath = paramString2;
    this.Ct = paramLong1;
    this.Cu = paramLong2;
  }
  
  private boolean LV()
  {
    this.jdField_a_of_type_Rrb$a.inputBuffer.position(0);
    if (this.b == null) {}
    int i;
    do
    {
      return true;
      i = this.b.readSampleData(this.jdField_a_of_type_Rrb$a.inputBuffer, 0);
    } while (i <= 0);
    this.jdField_a_of_type_Rrb$a.bufferInfo.presentationTimeUs = this.b.getSampleTime();
    this.jdField_a_of_type_Rrb$a.bufferInfo.size = i;
    this.jdField_a_of_type_Rrb$a.bufferInfo.offset = 0;
    this.jdField_a_of_type_Rrb$a.bufferInfo.flags = this.b.getSampleFlags();
    this.b.advance();
    return false;
  }
  
  private boolean LW()
  {
    this.jdField_a_of_type_Rrb$a.inputBuffer.position(0);
    if (this.c == null) {
      return true;
    }
    long l = this.c.getSampleTime();
    int i = this.c.readSampleData(this.jdField_a_of_type_Rrb$a.inputBuffer, 0);
    if ((i <= 0) || ((this.Cu != 0L) && (l > this.Cu * 1000L)))
    {
      QLog.d("HwVideoMerge", 2, "getAudioInputBuffer audio end. sampleTime:" + l);
      return true;
    }
    this.jdField_a_of_type_Rrb$a.bufferInfo.presentationTimeUs = l;
    this.jdField_a_of_type_Rrb$a.bufferInfo.size = i;
    this.jdField_a_of_type_Rrb$a.bufferInfo.offset = 0;
    this.jdField_a_of_type_Rrb$a.bufferInfo.flags = this.c.getSampleFlags();
    this.c.advance();
    return false;
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
    paramString2 = new rrb(paramString1, paramString2, 0L, 0L);
    int i = paramString2.w(paramString3, paramInt);
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
    return paramString2.tR();
  }
  
  public static final int a(String paramString1, String paramString2, String paramString3, int paramInt, long paramLong1, long paramLong2)
  {
    paramString2 = new rrb(paramString1, paramString2, paramLong1, paramLong2);
    int i = paramString2.w(paramString3, paramInt);
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
    paramString2.tR();
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
        k("createExtractor path:" + paramString, localIOException);
        localMediaExtractor.release();
        return null;
      }
    }
    return null;
  }
  
  private void bvV()
  {
    boolean bool2 = false;
    int i = 0;
    while ((!bool2) || (i == 0))
    {
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool2 = LV();
        bool1 = bool2;
        if (!bool2)
        {
          this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.jdField_a_of_type_Rrb$a.videoTrack, this.jdField_a_of_type_Rrb$a.inputBuffer, this.jdField_a_of_type_Rrb$a.bufferInfo);
          bool1 = bool2;
        }
      }
      bool2 = bool1;
      if (i == 0)
      {
        boolean bool3 = LW();
        bool2 = bool1;
        i = bool3;
        if (!bool3)
        {
          this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.jdField_a_of_type_Rrb$a.buj, this.jdField_a_of_type_Rrb$a.inputBuffer, this.jdField_a_of_type_Rrb$a.bufferInfo);
          bool2 = bool1;
          i = bool3;
        }
      }
    }
  }
  
  private static void k(String paramString, Throwable paramThrowable)
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
  
  private void releaseExtractor()
  {
    if (this.b != null)
    {
      this.b.release();
      this.b = null;
    }
    if (this.c != null)
    {
      this.c.release();
      this.c = null;
    }
  }
  
  private int tQ()
  {
    int i = 0;
    this.jdField_a_of_type_Rrb$a.inputBuffer.position(0);
    if (this.b.readSampleData(this.jdField_a_of_type_Rrb$a.inputBuffer, 0) <= 0)
    {
      releaseExtractor();
      i = -5;
    }
    do
    {
      return i;
      this.jdField_a_of_type_Rrb$a.inputBuffer.position(0);
    } while (this.c.readSampleData(this.jdField_a_of_type_Rrb$a.inputBuffer, 0) > 0);
    releaseExtractor();
    return -6;
  }
  
  private static int x(String paramString, int paramInt)
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
  
  public int tR()
  {
    int i = 0;
    this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
    try
    {
      bvV();
      this.jdField_a_of_type_AndroidMediaMediaMuxer.stop();
      this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
      this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
      releaseExtractor();
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
  
  public int w(String paramString, int paramInt)
  {
    this.b = a(this.aAu);
    int i = a(this.b, "video/");
    if ((this.b == null) || (i < 0)) {
      i = -1;
    }
    int j;
    MediaFormat localMediaFormat1;
    MediaFormat localMediaFormat2;
    do
    {
      return i;
      this.c = a(this.mAudioFilePath);
      j = a(this.c, "audio/");
      if ((this.c == null) || (j < 0)) {
        return -2;
      }
      if (this.Ct > 0L) {
        this.c.seekTo(this.Cu * 1000L, 0);
      }
      localMediaFormat1 = this.b.getTrackFormat(i);
      localMediaFormat2 = this.c.getTrackFormat(j);
      this.mWidth = localMediaFormat1.getInteger("width");
      this.mHeight = localMediaFormat1.getInteger("height");
      this.jdField_a_of_type_Rrb$a.init(this.mWidth, this.mHeight);
      j = tQ();
      i = j;
    } while (j != 0);
    if (TextUtils.isEmpty(paramString))
    {
      releaseExtractor();
      return -9;
    }
    try
    {
      if (new File(paramString).exists())
      {
        releaseExtractor();
        return -8;
      }
      this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(paramString, 0);
      paramInt = x(this.aAu, paramInt);
      this.jdField_a_of_type_AndroidMediaMediaMuxer.setOrientationHint(paramInt);
      this.jdField_a_of_type_Rrb$a.videoTrack = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(localMediaFormat1);
      this.jdField_a_of_type_Rrb$a.buj = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(localMediaFormat2);
      return j;
    }
    catch (IOException paramString)
    {
      this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
      releaseExtractor();
    }
    return -7;
  }
  
  static class a
  {
    public MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
    public int buj;
    public ByteBuffer inputBuffer;
    public int videoTrack;
    
    public void init(int paramInt1, int paramInt2)
    {
      this.inputBuffer = ByteBuffer.allocate(paramInt1 * paramInt2 * 3 / 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rrb
 * JD-Core Version:    0.7.0.1
 */