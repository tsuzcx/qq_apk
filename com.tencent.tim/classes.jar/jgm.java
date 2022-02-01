import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(16)
public class jgm
{
  private boolean Zh;
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private BufferedOutputStream jdField_a_of_type_JavaIoBufferedOutputStream;
  private jgm.a jdField_a_of_type_Jgm$a;
  private int ayW;
  private int ayX;
  private int ayY;
  private int ayZ;
  private int aza;
  private int azb;
  private FileOutputStream f;
  private String mAudioPath;
  private MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();
  private MediaExtractor mMediaExtractor;
  private MediaFormat mMediaFormat;
  private String mPcmPath;
  
  public jgm() {}
  
  public jgm(int paramInt1, int paramInt2, int paramInt3)
  {
    this.ayW = paramInt1;
    this.ayX = paramInt2;
    this.ayY = paramInt3;
  }
  
  private void H(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    while ((this.ayZ == 0) || (this.aza == 0) || (this.azb == 0)) {
      return;
    }
    paramArrayOfByte = jgo.a(paramArrayOfByte, this.ayZ, this.aza, this.azb, this.ayW, this.ayX, this.ayY);
    try
    {
      this.jdField_a_of_type_JavaIoBufferedOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      QLog.e("AudioFileDecoder", 1, "writeFile exception", paramArrayOfByte);
      paramArrayOfByte.printStackTrace();
    }
  }
  
  private void decodeFrame()
  {
    ByteBuffer[] arrayOfByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
    int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
    Object localObject;
    int j;
    if (i >= 0)
    {
      localObject = arrayOfByteBuffer[i];
      ((ByteBuffer)localObject).clear();
      j = this.mMediaExtractor.readSampleData((ByteBuffer)localObject, 0);
      if (j < 0)
      {
        this.Zh = true;
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, 0, 0L, 0);
        label66:
        arrayOfByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
      }
    }
    for (;;)
    {
      i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.mBufferInfo, 10000L);
      if (i >= 0)
      {
        localObject = arrayOfByteBuffer[i];
        byte[] arrayOfByte = new byte[this.mBufferInfo.size];
        ((ByteBuffer)localObject).get(arrayOfByte);
        ((ByteBuffer)localObject).clear();
        this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(i, false);
        H(arrayOfByte);
        continue;
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, j, 0L, 0);
        this.mMediaExtractor.advance();
        break;
        if (i != -1) {
          break;
        }
        break label66;
      }
      if (i != -2) {
        return;
      }
      localObject = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
      if (QLog.isColorLevel()) {
        QLog.d("AudioFileDecoder", 2, "encoder output format changed: " + localObject);
      }
    }
  }
  
  private void release()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
      this.jdField_a_of_type_AndroidMediaMediaCodec.release();
      this.jdField_a_of_type_AndroidMediaMediaCodec = null;
    }
    if (this.mMediaExtractor != null)
    {
      this.mMediaExtractor.release();
      this.mMediaExtractor = null;
    }
    try
    {
      if (this.jdField_a_of_type_JavaIoBufferedOutputStream != null)
      {
        this.jdField_a_of_type_JavaIoBufferedOutputStream.flush();
        this.jdField_a_of_type_JavaIoBufferedOutputStream.close();
      }
      if (QLog.isColorLevel()) {
        QLog.d("AudioFileDecoder", 2, String.format("decode successful, save to %s, size: %sK", new Object[] { this.mPcmPath, Long.valueOf(new File(this.mPcmPath).length() / 1024L) }));
      }
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public void a(jgm.a parama)
  {
    this.jdField_a_of_type_Jgm$a = parama;
  }
  
  public void bh(String paramString1, String paramString2)
  {
    int j = 0;
    this.mAudioPath = paramString1;
    this.mPcmPath = paramString2;
    paramString1 = new File(this.mAudioPath);
    if (!paramString1.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioFileDecoder", 2, String.format("audio file %s is not exist", new Object[] { this.mAudioPath }));
      }
      if (this.jdField_a_of_type_Jgm$a != null) {
        this.jdField_a_of_type_Jgm$a.onError(-2);
      }
      return;
    }
    int i;
    for (;;)
    {
      try
      {
        for (;;)
        {
          this.mMediaExtractor = new MediaExtractor();
          this.mMediaExtractor.setDataSource(this.mAudioPath);
          i = 0;
          if (i < this.mMediaExtractor.getTrackCount())
          {
            paramString2 = this.mMediaExtractor.getTrackFormat(i);
            String str = paramString2.getString("mime");
            if (!str.startsWith("audio")) {
              break label281;
            }
            this.mMediaFormat = paramString2;
            this.mMediaExtractor.selectTrack(i);
            this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createDecoderByType(str);
          }
          try
          {
            this.jdField_a_of_type_AndroidMediaMediaCodec.configure(paramString2, null, null, 0);
            if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {
              break label288;
            }
            QLog.e("AudioFileDecoder", 1, "init audioCodec fail");
            if (this.jdField_a_of_type_Jgm$a == null) {
              break;
            }
            this.jdField_a_of_type_Jgm$a.onError(-1);
            return;
          }
          catch (Throwable paramString2)
          {
            for (;;)
            {
              if (this.jdField_a_of_type_Jgm$a != null) {
                this.jdField_a_of_type_Jgm$a.onError(-5);
              }
              QLog.e("AudioFileDecoder", 1, "decode configure exception:" + paramString2, paramString2);
            }
          }
        }
        if (this.jdField_a_of_type_Jgm$a == null) {
          break;
        }
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
      }
      this.jdField_a_of_type_Jgm$a.onError(-3);
      return;
      label281:
      i += 1;
    }
    label288:
    this.ayZ = this.mMediaFormat.getInteger("sample-rate");
    this.azb = this.mMediaFormat.getInteger("channel-count");
    this.aza = 16;
    if (QLog.isColorLevel()) {
      QLog.d("AudioFileDecoder", 2, String.format("decode audio sampleRate: %s, channelCount: %s, bitDeepth: %s", new Object[] { Integer.valueOf(this.ayZ), Integer.valueOf(this.azb), Integer.valueOf(this.aza) }));
    }
    for (;;)
    {
      try
      {
        this.f = new FileOutputStream(this.mPcmPath);
        this.jdField_a_of_type_JavaIoBufferedOutputStream = new BufferedOutputStream(this.f);
        if (QLog.isColorLevel()) {
          QLog.d("AudioFileDecoder", 2, String.format("start decode file %s, size: %sK", new Object[] { this.mAudioPath, Long.valueOf(paramString1.length() / 1024L) }));
        }
      }
      catch (IOException paramString2)
      {
        try
        {
          this.jdField_a_of_type_AndroidMediaMediaCodec.start();
          if (this.jdField_a_of_type_Jgm$a != null) {
            this.jdField_a_of_type_Jgm$a.onStart(this.mAudioPath);
          }
          this.Zh = false;
          if (this.Zh) {
            break label652;
          }
          try
          {
            decodeFrame();
          }
          catch (Throwable paramString1)
          {
            QLog.e("AudioFileDecoder", 1, "decode frame exception:" + paramString1, paramString1);
            i = j;
            if (this.jdField_a_of_type_Jgm$a != null)
            {
              this.jdField_a_of_type_Jgm$a.onError(-6);
              i = j;
            }
          }
          release();
          if ((i == 0) || (this.jdField_a_of_type_Jgm$a == null)) {
            break;
          }
          this.jdField_a_of_type_Jgm$a.onFinish(this.mPcmPath);
          return;
        }
        catch (Exception paramString1)
        {
          QLog.e("AudioFileDecoder", 1, "decode start exception:" + paramString1, paramString1);
        }
        paramString2 = paramString2;
        QLog.e("AudioFileDecoder", 1, "decode io exception:" + paramString2, paramString2);
        continue;
      }
      if (this.jdField_a_of_type_Jgm$a == null) {
        break;
      }
      this.jdField_a_of_type_Jgm$a.onError(-4);
      return;
      label652:
      i = 1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onError(int paramInt);
    
    public abstract void onFinish(String paramString);
    
    public abstract void onStart(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jgm
 * JD-Core Version:    0.7.0.1
 */