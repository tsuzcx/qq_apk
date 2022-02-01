package com.tencent.mobileqq.richmedia.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder.a;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import ram;

@TargetApi(16)
public class AudioDecoder
{
  private AudioPlayRunnable jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable;
  private a jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$a;
  private Thread u;
  
  public void a(a parama)
  {
    QLog.d("AudioDecoder", 4, "startPlay " + parama.toString());
    stopAudio();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$a == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$a = new a();
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$a.b(parama);
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$a.endTimeMs == 0L) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$a.endTimeMs = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$a.videoDurationMs;
    }
    float f2 = (float)this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$a.startTimeMs / (float)this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$a.videoDurationMs;
    float f3 = (float)this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$a.endTimeMs / (float)this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$a.videoDurationMs;
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = 0.0F;
    }
    if (f3 != 0.0F)
    {
      f2 = f3;
      if (f3 <= 1.0F) {}
    }
    else
    {
      f2 = 1.0F;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable = new AudioPlayRunnable(f1, f2);
    this.u = ThreadManager.newFreeThread(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable, "AudioPlay", 8);
    if (!this.u.isAlive()) {
      this.u.start();
    }
  }
  
  public void dLH()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable.dLH();
      QLog.d("AudioDecoder", 4, "repeat");
    }
  }
  
  public void pausePlay()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable.pausePlay();
      QLog.d("AudioDecoder", 4, "pausePlay");
    }
  }
  
  public void resumePlay()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable.resumePlay();
      QLog.d("AudioDecoder", 4, "resumePlay");
    }
  }
  
  public void seekTo(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable.aH(paramLong, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$a.videoDurationMs);
      QLog.d("AudioDecoder", 1, "seekTo: " + paramLong);
      return;
    }
    QLog.d("AudioDecoder", 4, "seekTo failed: " + paramLong);
  }
  
  public void setMuteAudio(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$a == null) {
      return;
    }
    QLog.d("AudioDecoder", 1, "setMuteAudio: " + paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$a.mMuteAudio = paramBoolean;
  }
  
  public void setPlayRange(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$a == null)
    {
      QLog.w("AudioDecoder", 4, "you must start play first");
      return;
    }
    if ((paramLong1 == this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$a.startTimeMs) && (paramLong2 == this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$a.endTimeMs))
    {
      ram.w("AudioDecoder", "segment not changed, setPlayRange ignore, startTimeMs=%d, endTimeMs=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      return;
    }
    QLog.d("AudioDecoder", 4, "setPlayRange begin startTimeMs=" + paramLong1 + " endTimeMs=" + paramLong2);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$a.startTimeMs = paramLong1;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$a.endTimeMs = paramLong2;
    a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$a);
  }
  
  public void setSpeedType(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder$a.speedType = paramInt;
      QLog.d("AudioDecoder", 4, "setSpeedType:" + paramInt);
    }
  }
  
  public void stopAudio()
  {
    if (this.u != null)
    {
      this.u.interrupt();
      this.u = null;
      QLog.d("AudioDecoder", 4, "stopAudio");
    }
  }
  
  class AudioPlayRunnable
    implements Runnable
  {
    private volatile boolean cBw;
    private volatile boolean cuB;
    private volatile int dAM;
    private int dAN;
    private int endPosition;
    private Object pauseLock = new Object();
    private int startPosition;
    private long videoDuration;
    private float zi;
    private float zj;
    private float zk;
    
    public AudioPlayRunnable(float paramFloat1, float paramFloat2)
    {
      this.zi = paramFloat1;
      this.zj = paramFloat2;
    }
    
    private byte[] G(String paramString)
    {
      QLog.d("AudioDecoder", 4, "getAudioDataFromMp4 begin");
      long l3 = System.currentTimeMillis();
      MediaCodec localMediaCodec = null;
      MediaExtractor localMediaExtractor = new MediaExtractor();
      for (;;)
      {
        ByteArrayOutputStream localByteArrayOutputStream;
        long l1;
        int i;
        Object localObject1;
        Object localObject2;
        long l2;
        try
        {
          localMediaExtractor.setDataSource(paramString);
          localByteArrayOutputStream = new ByteArrayOutputStream();
          ByteBuffer.allocate(512);
          l1 = 0L;
          i = 0;
          if (i >= localMediaExtractor.getTrackCount()) {
            break label713;
          }
          localObject1 = localMediaExtractor.getTrackFormat(i);
          localObject2 = ((MediaFormat)localObject1).getString("mime");
          this.videoDuration = ((MediaFormat)localObject1).getLong("durationUs");
          long l4 = (this.zi * (float)this.videoDuration);
          l2 = (this.zj * (float)this.videoDuration);
          l1 = l2;
          if (l2 == 0L) {
            l1 = this.videoDuration;
          }
          if (!((String)localObject2).startsWith("audio/")) {
            break label221;
          }
          localMediaExtractor.selectTrack(i);
          if (l4 > 0L) {
            localMediaExtractor.seekTo(l4, 0);
          }
          paramString = localMediaCodec;
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace();
          return null;
        }
        String str;
        try
        {
          localMediaCodec = MediaCodec.createDecoderByType((String)localObject2);
          paramString = localMediaCodec;
          localMediaCodec.configure((MediaFormat)localObject1, null, null, 0);
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          str = paramString;
          continue;
        }
        if (localMediaCodec == null)
        {
          QLog.e("AudioDecoder", 2, "Can't find video info!");
          return null;
          label221:
          i += 1;
        }
        else
        {
          label581:
          label710:
          for (;;)
          {
            int k;
            int m;
            try
            {
              str.start();
              localObject1 = str.getInputBuffers();
              paramString = str.getOutputBuffers();
              localObject2 = new MediaCodec.BufferInfo();
              i = 0;
              int j = 0;
              if (j != 0) {
                break label500;
              }
              k = str.dequeueInputBuffer(10000L);
              if (k < 0) {
                break label500;
              }
              m = localMediaExtractor.readSampleData(localObject1[k], 0);
              l2 = localMediaExtractor.getSampleTime();
              if ((m < 0) || ((l1 > 0L) && (l2 >= l1)))
              {
                str.queueInputBuffer(k, 0, 0, 0L, 4);
                j = 1;
                if (i != 0) {
                  break label710;
                }
                k = str.dequeueOutputBuffer((MediaCodec.BufferInfo)localObject2, 10000L);
                switch (k)
                {
                default: 
                  if ((((MediaCodec.BufferInfo)localObject2).flags & 0x4) == 0) {
                    break label581;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("AudioDecoder", 2, "output EOS");
                  }
                  i = 1;
                  str.releaseOutputBuffer(k, false);
                  if (i == 0) {
                    break label707;
                  }
                  str.stop();
                  str.release();
                  localMediaExtractor.release();
                  QLog.d("AudioDecoder", 1, "getAudioDataFromMp4 time cost=" + (System.currentTimeMillis() - l3));
                  return localByteArrayOutputStream.toByteArray();
                }
              }
            }
            catch (Throwable paramString)
            {
              paramString.printStackTrace();
              QLog.e("AudioDecoder", 2, "decode start error", paramString);
              return null;
            }
            str.queueInputBuffer(k, 0, m, l2, 0);
            localMediaExtractor.advance();
            label500:
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("AudioDecoder", 2, "INFO_OUTPUT_BUFFERS_CHANGED");
            }
            paramString = str.getOutputBuffers();
            continue;
            if (QLog.isColorLevel())
            {
              QLog.d("AudioDecoder", 2, "New format " + str.getOutputFormat());
              continue;
              if (QLog.isColorLevel())
              {
                QLog.d("AudioDecoder", 2, "dequeueOutputBuffer timed out!");
                continue;
                Object localObject3 = paramString[k];
                if (localObject3 == null) {}
                try
                {
                  QLog.e("AudioDecoder", 1, "find no data");
                  return null;
                }
                catch (Exception paramString)
                {
                  byte[] arrayOfByte;
                  QLog.e("AudioDecoder", 1, "" + paramString.toString());
                  return null;
                }
                if (((MediaCodec.BufferInfo)localObject2).size != 0)
                {
                  localObject3.position(((MediaCodec.BufferInfo)localObject2).offset);
                  localObject3.limit(((MediaCodec.BufferInfo)localObject2).offset + ((MediaCodec.BufferInfo)localObject2).size);
                }
                m = localObject3.remaining();
                arrayOfByte = new byte[m];
                localObject3.get(arrayOfByte, 0, m);
                localByteArrayOutputStream.write(arrayOfByte, 0, m);
                continue;
              }
            }
          }
          label707:
          label713:
          str = null;
        }
      }
    }
    
    /* Error */
    private byte[] ak()
    {
      // Byte code:
      //   0: invokestatic 65	java/lang/System:currentTimeMillis	()J
      //   3: lstore_3
      //   4: new 267	java/io/File
      //   7: dup
      //   8: aload_0
      //   9: getfield 31	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   12: invokestatic 271	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   15: getfield 277	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:audioFilePath	Ljava/lang/String;
      //   18: invokespecial 279	java/io/File:<init>	(Ljava/lang/String;)V
      //   21: astore 5
      //   23: aload_0
      //   24: aload 5
      //   26: invokevirtual 282	java/io/File:length	()J
      //   29: l2i
      //   30: putfield 284	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:dAN	I
      //   33: aload_0
      //   34: aload_0
      //   35: getfield 284	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:dAN	I
      //   38: i2f
      //   39: aload_0
      //   40: getfield 38	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:zi	F
      //   43: fmul
      //   44: f2i
      //   45: putfield 286	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:startPosition	I
      //   48: aload_0
      //   49: getfield 286	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:startPosition	I
      //   52: aload_0
      //   53: getfield 31	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   56: invokestatic 271	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   59: getfield 289	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   62: getfield 294	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:dIH	I
      //   65: irem
      //   66: istore_1
      //   67: iload_1
      //   68: ifeq +29 -> 97
      //   71: aload_0
      //   72: getfield 286	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:startPosition	I
      //   75: istore_2
      //   76: aload_0
      //   77: aload_0
      //   78: getfield 31	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   81: invokestatic 271	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   84: getfield 289	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   87: getfield 294	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:dIH	I
      //   90: iload_1
      //   91: isub
      //   92: iload_2
      //   93: iadd
      //   94: putfield 286	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:startPosition	I
      //   97: aload_0
      //   98: getfield 40	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:zj	F
      //   101: fconst_0
      //   102: fcmpl
      //   103: ifne +163 -> 266
      //   106: aload_0
      //   107: aload_0
      //   108: getfield 284	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:dAN	I
      //   111: putfield 296	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:endPosition	I
      //   114: ldc 51
      //   116: iconst_4
      //   117: new 196	java/lang/StringBuilder
      //   120: dup
      //   121: invokespecial 197	java/lang/StringBuilder:<init>	()V
      //   124: ldc_w 298
      //   127: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   130: aload_0
      //   131: getfield 286	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:startPosition	I
      //   134: invokevirtual 301	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   137: ldc_w 303
      //   140: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   143: aload_0
      //   144: getfield 296	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:endPosition	I
      //   147: invokevirtual 301	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   150: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   153: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   156: aload_0
      //   157: getfield 296	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:endPosition	I
      //   160: aload_0
      //   161: getfield 286	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:startPosition	I
      //   164: isub
      //   165: newarray byte
      //   167: astore 7
      //   169: new 305	java/io/FileInputStream
      //   172: dup
      //   173: aload 5
      //   175: invokespecial 308	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   178: astore 6
      //   180: aload 6
      //   182: ifnull +41 -> 223
      //   185: aload 6
      //   187: astore 5
      //   189: aload_0
      //   190: getfield 286	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:startPosition	I
      //   193: ifeq +18 -> 211
      //   196: aload 6
      //   198: astore 5
      //   200: aload 6
      //   202: aload_0
      //   203: getfield 286	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:startPosition	I
      //   206: i2l
      //   207: invokevirtual 312	java/io/FileInputStream:skip	(J)J
      //   210: pop2
      //   211: aload 6
      //   213: astore 5
      //   215: aload 6
      //   217: aload 7
      //   219: invokevirtual 316	java/io/FileInputStream:read	([B)I
      //   222: pop
      //   223: aload 6
      //   225: ifnull +8 -> 233
      //   228: aload 6
      //   230: invokevirtual 319	java/io/FileInputStream:close	()V
      //   233: ldc 51
      //   235: iconst_4
      //   236: new 196	java/lang/StringBuilder
      //   239: dup
      //   240: invokespecial 197	java/lang/StringBuilder:<init>	()V
      //   243: ldc_w 321
      //   246: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   249: invokestatic 65	java/lang/System:currentTimeMillis	()J
      //   252: lload_3
      //   253: lsub
      //   254: invokevirtual 206	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   257: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   260: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   263: aload 7
      //   265: areturn
      //   266: aload_0
      //   267: aload_0
      //   268: getfield 284	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:dAN	I
      //   271: i2f
      //   272: aload_0
      //   273: getfield 40	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:zj	F
      //   276: fmul
      //   277: f2i
      //   278: putfield 296	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:endPosition	I
      //   281: aload_0
      //   282: getfield 296	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:endPosition	I
      //   285: aload_0
      //   286: getfield 31	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   289: invokestatic 271	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   292: getfield 289	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   295: getfield 294	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:dIH	I
      //   298: irem
      //   299: istore_1
      //   300: iload_1
      //   301: ifeq -187 -> 114
      //   304: aload_0
      //   305: getfield 296	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:endPosition	I
      //   308: istore_2
      //   309: aload_0
      //   310: aload_0
      //   311: getfield 31	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   314: invokestatic 271	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   317: getfield 289	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   320: getfield 294	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:dIH	I
      //   323: iload_1
      //   324: isub
      //   325: iload_2
      //   326: iadd
      //   327: putfield 296	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:endPosition	I
      //   330: goto -216 -> 114
      //   333: astore 5
      //   335: aload 5
      //   337: invokevirtual 139	java/io/IOException:printStackTrace	()V
      //   340: goto -107 -> 233
      //   343: astore 7
      //   345: aconst_null
      //   346: astore 6
      //   348: aload 6
      //   350: astore 5
      //   352: ldc 51
      //   354: iconst_4
      //   355: ldc_w 323
      //   358: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   361: aload 6
      //   363: astore 5
      //   365: aload 7
      //   367: invokevirtual 140	java/lang/Throwable:printStackTrace	()V
      //   370: aload 6
      //   372: ifnull +8 -> 380
      //   375: aload 6
      //   377: invokevirtual 319	java/io/FileInputStream:close	()V
      //   380: aconst_null
      //   381: areturn
      //   382: astore 5
      //   384: aload 5
      //   386: invokevirtual 139	java/io/IOException:printStackTrace	()V
      //   389: goto -9 -> 380
      //   392: astore 6
      //   394: aconst_null
      //   395: astore 5
      //   397: aload 5
      //   399: ifnull +8 -> 407
      //   402: aload 5
      //   404: invokevirtual 319	java/io/FileInputStream:close	()V
      //   407: aload 6
      //   409: athrow
      //   410: astore 5
      //   412: aload 5
      //   414: invokevirtual 139	java/io/IOException:printStackTrace	()V
      //   417: goto -10 -> 407
      //   420: astore 6
      //   422: goto -25 -> 397
      //   425: astore 7
      //   427: goto -79 -> 348
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	430	0	this	AudioPlayRunnable
      //   66	259	1	i	int
      //   75	252	2	j	int
      //   3	250	3	l	long
      //   21	193	5	localObject1	Object
      //   333	3	5	localIOException1	IOException
      //   350	14	5	localObject2	Object
      //   382	3	5	localIOException2	IOException
      //   395	8	5	localObject3	Object
      //   410	3	5	localIOException3	IOException
      //   178	198	6	localFileInputStream	java.io.FileInputStream
      //   392	16	6	localObject4	Object
      //   420	1	6	localObject5	Object
      //   167	97	7	arrayOfByte	byte[]
      //   343	23	7	localThrowable1	Throwable
      //   425	1	7	localThrowable2	Throwable
      // Exception table:
      //   from	to	target	type
      //   228	233	333	java/io/IOException
      //   169	180	343	java/lang/Throwable
      //   375	380	382	java/io/IOException
      //   169	180	392	finally
      //   402	407	410	java/io/IOException
      //   189	196	420	finally
      //   200	211	420	finally
      //   215	223	420	finally
      //   352	361	420	finally
      //   365	370	420	finally
      //   189	196	425	java/lang/Throwable
      //   200	211	425	java/lang/Throwable
      //   215	223	425	java/lang/Throwable
    }
    
    /* Error */
    private void bs(byte[] paramArrayOfByte)
    {
      // Byte code:
      //   0: iconst_4
      //   1: istore_2
      //   2: ldc 51
      //   4: iconst_4
      //   5: ldc_w 329
      //   8: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   11: aconst_null
      //   12: astore 9
      //   14: aload_0
      //   15: getfield 31	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   18: invokestatic 271	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   21: getfield 289	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   24: getfield 332	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:dII	I
      //   27: iconst_1
      //   28: if_icmpne +550 -> 578
      //   31: aload_0
      //   32: getfield 31	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   35: invokestatic 271	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   38: getfield 289	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   41: getfield 294	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:dIH	I
      //   44: bipush 16
      //   46: if_icmpne +538 -> 584
      //   49: iconst_2
      //   50: istore_3
      //   51: aload_0
      //   52: getfield 31	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   55: invokestatic 271	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   58: getfield 289	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   61: getfield 335	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:sample_rate	I
      //   64: iload_2
      //   65: iload_3
      //   66: invokestatic 341	android/media/AudioTrack:getMinBufferSize	(III)I
      //   69: istore 5
      //   71: iload 5
      //   73: iconst_2
      //   74: imul
      //   75: newarray byte
      //   77: astore 10
      //   79: new 337	android/media/AudioTrack
      //   82: dup
      //   83: iconst_3
      //   84: aload_0
      //   85: getfield 31	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   88: invokestatic 271	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   91: getfield 289	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   94: getfield 335	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:sample_rate	I
      //   97: iload_2
      //   98: iload_3
      //   99: iload 5
      //   101: iconst_1
      //   102: invokespecial 344	android/media/AudioTrack:<init>	(IIIIII)V
      //   105: astore 8
      //   107: aload 8
      //   109: invokevirtual 347	android/media/AudioTrack:play	()V
      //   112: iconst_0
      //   113: istore_3
      //   114: aload_0
      //   115: getfield 349	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:dAM	I
      //   118: aload_1
      //   119: arraylength
      //   120: if_icmpge +400 -> 520
      //   123: invokestatic 354	java/lang/Thread:interrupted	()Z
      //   126: ifne +394 -> 520
      //   129: iload_3
      //   130: ifne +390 -> 520
      //   133: aload_0
      //   134: getfield 356	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:zk	F
      //   137: fconst_0
      //   138: fcmpl
      //   139: ifeq +87 -> 226
      //   142: aload_0
      //   143: getfield 356	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:zk	F
      //   146: aload_0
      //   147: getfield 284	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:dAN	I
      //   150: i2f
      //   151: fmul
      //   152: aload_0
      //   153: getfield 40	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:zj	F
      //   156: fdiv
      //   157: f2i
      //   158: istore 4
      //   160: iload 4
      //   162: aload_0
      //   163: getfield 31	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   166: invokestatic 271	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   169: getfield 289	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   172: getfield 294	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:dIH	I
      //   175: irem
      //   176: istore 6
      //   178: iload 4
      //   180: istore_2
      //   181: iload 6
      //   183: ifeq +23 -> 206
      //   186: iload 4
      //   188: aload_0
      //   189: getfield 31	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   192: invokestatic 271	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   195: getfield 289	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   198: getfield 294	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:dIH	I
      //   201: iload 6
      //   203: isub
      //   204: iadd
      //   205: istore_2
      //   206: aload_0
      //   207: iload_2
      //   208: aload_0
      //   209: getfield 286	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:startPosition	I
      //   212: isub
      //   213: putfield 349	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:dAM	I
      //   216: aload 8
      //   218: invokevirtual 359	android/media/AudioTrack:flush	()V
      //   221: aload_0
      //   222: fconst_0
      //   223: putfield 356	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:zk	F
      //   226: aload_0
      //   227: getfield 31	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   230: invokestatic 271	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   233: getfield 362	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:speedType	I
      //   236: tableswitch	default:+339 -> 575, 1:+193->429, 2:+211->447, 3:+229->465
      //   265: aload_0
      //   266: getfield 349	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:dAM	I
      //   269: aload 10
      //   271: iload 5
      //   273: iconst_2
      //   274: imul
      //   275: invokestatic 367	ambc:a	([BI[BI)I
      //   278: istore_2
      //   279: aload_0
      //   280: getfield 31	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   283: invokestatic 271	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   286: getfield 370	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:mMuteAudio	Z
      //   289: ifne +16 -> 305
      //   292: aload 8
      //   294: aload 10
      //   296: iconst_0
      //   297: iload 5
      //   299: iconst_2
      //   300: imul
      //   301: invokevirtual 373	android/media/AudioTrack:write	([BII)I
      //   304: pop
      //   305: aload_0
      //   306: iload_2
      //   307: aload_0
      //   308: getfield 349	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:dAM	I
      //   311: iadd
      //   312: putfield 349	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:dAM	I
      //   315: aload_0
      //   316: getfield 349	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:dAM	I
      //   319: aload_1
      //   320: arraylength
      //   321: if_icmplt +55 -> 376
      //   324: aload_0
      //   325: getfield 31	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   328: invokestatic 271	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   331: getfield 376	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:repeat	Z
      //   334: ifeq +42 -> 376
      //   337: aload_0
      //   338: getfield 31	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   341: invokestatic 271	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   344: getfield 362	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:speedType	I
      //   347: iconst_3
      //   348: if_icmpeq +23 -> 371
      //   351: aload_0
      //   352: monitorenter
      //   353: aload_0
      //   354: getfield 378	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:cBw	Z
      //   357: ifne +12 -> 369
      //   360: aload_0
      //   361: invokevirtual 381	java/lang/Object:wait	()V
      //   364: aload_0
      //   365: iconst_0
      //   366: putfield 378	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:cBw	Z
      //   369: aload_0
      //   370: monitorexit
      //   371: aload_0
      //   372: iconst_0
      //   373: putfield 349	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:dAM	I
      //   376: aload_0
      //   377: getfield 383	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:cuB	Z
      //   380: istore 7
      //   382: iload 7
      //   384: ifeq -270 -> 114
      //   387: aload_0
      //   388: getfield 36	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:pauseLock	Ljava/lang/Object;
      //   391: astore 9
      //   393: aload 9
      //   395: monitorenter
      //   396: aload_0
      //   397: getfield 36	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:pauseLock	Ljava/lang/Object;
      //   400: invokevirtual 381	java/lang/Object:wait	()V
      //   403: aload 9
      //   405: monitorexit
      //   406: goto -292 -> 114
      //   409: astore 11
      //   411: aload 9
      //   413: monitorexit
      //   414: aload 11
      //   416: athrow
      //   417: astore 9
      //   419: aload 9
      //   421: invokevirtual 384	java/lang/InterruptedException:printStackTrace	()V
      //   424: iconst_1
      //   425: istore_3
      //   426: goto -312 -> 114
      //   429: aload_1
      //   430: aload_0
      //   431: getfield 349	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:dAM	I
      //   434: aload 10
      //   436: iload 5
      //   438: iconst_2
      //   439: imul
      //   440: invokestatic 387	ambc:b	([BI[BI)I
      //   443: istore_2
      //   444: goto -165 -> 279
      //   447: aload_1
      //   448: aload_0
      //   449: getfield 349	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:dAM	I
      //   452: aload 10
      //   454: iload 5
      //   456: iconst_2
      //   457: imul
      //   458: invokestatic 390	ambc:c	([BI[BI)I
      //   461: istore_2
      //   462: goto -183 -> 279
      //   465: aload_1
      //   466: aload_0
      //   467: getfield 349	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:dAM	I
      //   470: aload 10
      //   472: iload 5
      //   474: iconst_2
      //   475: imul
      //   476: invokestatic 392	ambc:d	([BI[BI)I
      //   479: istore_2
      //   480: goto -201 -> 279
      //   483: astore_1
      //   484: aload_0
      //   485: monitorexit
      //   486: aload_1
      //   487: athrow
      //   488: astore 9
      //   490: aload 8
      //   492: astore_1
      //   493: aload 9
      //   495: astore 8
      //   497: ldc 51
      //   499: iconst_4
      //   500: ldc_w 323
      //   503: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   506: aload 8
      //   508: invokevirtual 140	java/lang/Throwable:printStackTrace	()V
      //   511: aload_1
      //   512: ifnull +7 -> 519
      //   515: aload_1
      //   516: invokevirtual 393	android/media/AudioTrack:release	()V
      //   519: return
      //   520: aload 8
      //   522: invokevirtual 394	android/media/AudioTrack:stop	()V
      //   525: aload 8
      //   527: ifnull -8 -> 519
      //   530: aload 8
      //   532: invokevirtual 393	android/media/AudioTrack:release	()V
      //   535: return
      //   536: astore_1
      //   537: aload 9
      //   539: astore 8
      //   541: aload 8
      //   543: ifnull +8 -> 551
      //   546: aload 8
      //   548: invokevirtual 393	android/media/AudioTrack:release	()V
      //   551: aload_1
      //   552: athrow
      //   553: astore_1
      //   554: goto -13 -> 541
      //   557: astore 9
      //   559: aload_1
      //   560: astore 8
      //   562: aload 9
      //   564: astore_1
      //   565: goto -24 -> 541
      //   568: astore 8
      //   570: aconst_null
      //   571: astore_1
      //   572: goto -75 -> 497
      //   575: goto -311 -> 264
      //   578: bipush 12
      //   580: istore_2
      //   581: goto -550 -> 31
      //   584: iconst_3
      //   585: istore_3
      //   586: goto -535 -> 51
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	589	0	this	AudioPlayRunnable
      //   0	589	1	paramArrayOfByte	byte[]
      //   1	580	2	i	int
      //   50	536	3	j	int
      //   158	47	4	k	int
      //   69	407	5	m	int
      //   176	28	6	n	int
      //   380	3	7	bool	boolean
      //   105	456	8	localObject1	Object
      //   568	1	8	localThrowable1	Throwable
      //   12	400	9	localObject2	Object
      //   417	3	9	localInterruptedException	InterruptedException
      //   488	50	9	localThrowable2	Throwable
      //   557	6	9	localObject3	Object
      //   77	394	10	arrayOfByte	byte[]
      //   409	6	11	localObject4	Object
      // Exception table:
      //   from	to	target	type
      //   396	406	409	finally
      //   411	414	409	finally
      //   387	396	417	java/lang/InterruptedException
      //   414	417	417	java/lang/InterruptedException
      //   353	369	483	finally
      //   369	371	483	finally
      //   484	486	483	finally
      //   107	112	488	java/lang/Throwable
      //   114	129	488	java/lang/Throwable
      //   133	178	488	java/lang/Throwable
      //   186	206	488	java/lang/Throwable
      //   206	226	488	java/lang/Throwable
      //   226	264	488	java/lang/Throwable
      //   264	279	488	java/lang/Throwable
      //   279	305	488	java/lang/Throwable
      //   305	353	488	java/lang/Throwable
      //   371	376	488	java/lang/Throwable
      //   376	382	488	java/lang/Throwable
      //   387	396	488	java/lang/Throwable
      //   414	417	488	java/lang/Throwable
      //   419	424	488	java/lang/Throwable
      //   429	444	488	java/lang/Throwable
      //   447	462	488	java/lang/Throwable
      //   465	480	488	java/lang/Throwable
      //   486	488	488	java/lang/Throwable
      //   520	525	488	java/lang/Throwable
      //   14	31	536	finally
      //   31	49	536	finally
      //   51	107	536	finally
      //   107	112	553	finally
      //   114	129	553	finally
      //   133	178	553	finally
      //   186	206	553	finally
      //   206	226	553	finally
      //   226	264	553	finally
      //   264	279	553	finally
      //   279	305	553	finally
      //   305	353	553	finally
      //   371	376	553	finally
      //   376	382	553	finally
      //   387	396	553	finally
      //   414	417	553	finally
      //   419	424	553	finally
      //   429	444	553	finally
      //   447	462	553	finally
      //   465	480	553	finally
      //   486	488	553	finally
      //   520	525	553	finally
      //   497	511	557	finally
      //   14	31	568	java/lang/Throwable
      //   31	49	568	java/lang/Throwable
      //   51	107	568	java/lang/Throwable
    }
    
    public void aH(long paramLong1, long paramLong2)
    {
      float f = (float)paramLong1 / (float)paramLong2;
      if ((f >= this.zi) && (f <= this.zj))
      {
        this.zk = f;
        return;
      }
      QLog.w("AudioDecoder", 1, "seek error, timePercent=" + f);
    }
    
    public void dLH()
    {
      if (AudioDecoder.a(AudioDecoder.this).speedType != 3) {}
      try
      {
        Thread.sleep(500L);
      }
      catch (InterruptedException localInterruptedException)
      {
        try
        {
          for (;;)
          {
            this.cBw = true;
            notifyAll();
            this.dAM = 0;
            return;
            localInterruptedException = localInterruptedException;
            localInterruptedException.printStackTrace();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        finally {}
      }
    }
    
    public void pausePlay()
    {
      this.cuB = true;
    }
    
    public void resumePlay()
    {
      this.cuB = false;
      synchronized (this.pauseLock)
      {
        this.pauseLock.notifyAll();
        return;
      }
    }
    
    public void run()
    {
      if (AudioDecoder.a(AudioDecoder.this).audioFilePath.endsWith(".mp4")) {}
      for (byte[] arrayOfByte = G(AudioDecoder.a(AudioDecoder.this).audioFilePath); arrayOfByte == null; arrayOfByte = ak()) {
        return;
      }
      bs(arrayOfByte);
    }
  }
  
  public static class a
  {
    public AudioEncoder.a a;
    public String audioFilePath;
    public long endTimeMs;
    public boolean mMuteAudio;
    public boolean repeat = true;
    public int speedType = 0;
    public long startTimeMs;
    public long videoDurationMs;
    
    public void b(a parama)
    {
      if (parama == null) {
        throw new NullPointerException();
      }
      this.audioFilePath = parama.audioFilePath;
      this.a = parama.a;
      this.repeat = parama.repeat;
      this.speedType = parama.speedType;
      this.mMuteAudio = parama.mMuteAudio;
      this.startTimeMs = parama.startTimeMs;
      this.endTimeMs = parama.endTimeMs;
      this.videoDurationMs = parama.videoDurationMs;
    }
    
    public String toString()
    {
      return "AudioDecodeConfig=[audioFilePath:" + this.audioFilePath + " repeat:" + this.repeat + " speedType:" + this.speedType + " mMuteAudio:" + this.mMuteAudio + " startTimeMs:" + this.startTimeMs + " endTimeMs:" + this.endTimeMs + " videoDuration:" + this.videoDurationMs + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder
 * JD-Core Version:    0.7.0.1
 */