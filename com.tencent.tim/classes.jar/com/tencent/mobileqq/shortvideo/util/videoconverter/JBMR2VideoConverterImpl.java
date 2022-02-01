package com.tencent.mobileqq.shortvideo.util.videoconverter;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import android.view.Surface;
import anig;
import anlf;
import anlg;
import anli.a;
import anli.b;
import anli.c;
import com.tencent.qphone.base.util.QLog;
import ioc.a;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@TargetApi(18)
public class JBMR2VideoConverterImpl
  implements anli.c
{
  private WeakReference<Thread> hT;
  boolean running = false;
  boolean stopping = false;
  
  public boolean a(File paramFile, anli.a parama, boolean paramBoolean)
  {
    if (!this.running)
    {
      this.running = true;
      paramFile = new Thread(new Converter(paramFile, parama), "VideoConvert");
      this.hT = new WeakReference(paramFile);
      paramFile.start();
      if (paramBoolean) {}
      try
      {
        paramFile.join();
        return true;
      }
      catch (InterruptedException paramFile)
      {
        paramFile.printStackTrace();
        return true;
      }
    }
    return false;
  }
  
  public boolean cancel()
  {
    if (this.hT != null)
    {
      Thread localThread = (Thread)this.hT.get();
      if (localThread != null) {
        localThread.interrupt();
      }
    }
    return true;
  }
  
  public boolean stop()
  {
    if ((this.running) && (!this.stopping))
    {
      this.stopping = true;
      return true;
    }
    return false;
  }
  
  class Converter
    implements Runnable
  {
    anig jdField_a_of_type_Anig = null;
    anlf jdField_a_of_type_Anlf = null;
    anlg jdField_a_of_type_Anlg = null;
    anli.a jdField_a_of_type_Anli$a = null;
    boolean aAY = false;
    File aN = null;
    long amc = -1L;
    long amd = -1L;
    long ame = -1L;
    MediaExtractor jdField_b_of_type_AndroidMediaMediaExtractor = null;
    MediaMuxer jdField_b_of_type_AndroidMediaMediaMuxer = null;
    anig jdField_b_of_type_Anig = null;
    MediaExtractor c = null;
    boolean cHT = true;
    boolean cHU = true;
    boolean cHV;
    
    public Converter(File paramFile, anli.a parama)
    {
      this.aN = paramFile;
      this.jdField_a_of_type_Anli$a = parama;
    }
    
    anig a(MediaFormat paramMediaFormat, Surface paramSurface)
    {
      Object localObject = anig.j(paramMediaFormat.getString("mime"), false);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = (MediaCodecInfo)((List)localObject).get(0);
        anig localanig = new anig();
        localanig.a(paramMediaFormat, ((MediaCodecInfo)localObject).getName(), paramSurface, null);
        localanig.start();
        return localanig;
      }
      return null;
    }
    
    anig a(MediaFormat paramMediaFormat, AtomicReference<Surface> paramAtomicReference)
    {
      anig localanig = new anig();
      localanig.a(paramMediaFormat, anig.ENC_CODEC, null);
      paramAtomicReference.set(localanig.a().createInputSurface());
      localanig.start();
      return localanig;
    }
    
    void a(MediaExtractor paramMediaExtractor1, MediaExtractor paramMediaExtractor2, anig paramanig1, anig paramanig2, MediaMuxer paramMediaMuxer, anlf paramanlf, anlg paramanlg)
      throws Exception
    {
      int m = 0;
      int i4 = 0;
      ByteBuffer localByteBuffer = ByteBuffer.allocate(262144);
      long l3 = 0L;
      int i = 0;
      int j = 0;
      MediaFormat localMediaFormat1 = null;
      int k = 0;
      int n = -1;
      long l1 = 0L;
      int i1 = 0;
      MediaFormat localMediaFormat2 = null;
      long l2 = -1L;
      int i3 = -1;
      if (((this.cHU) && (i == 0)) || ((this.cHT) && (m == 0)))
      {
        this.cHV = Thread.interrupted();
        if (this.cHV) {
          QLog.e("JBMR2VideoConverterImpl", 1, "doExtractDecodeEditEncodeMux(): isInterrupted");
        }
      }
      else
      {
        return;
      }
      Object localObject;
      label164:
      int i5;
      label197:
      label244:
      long l5;
      if ((this.cHT) && (m == 0) && ((localMediaFormat2 == null) || (i4 != 0))) {
        if ((localMediaFormat2 != null) && (i4 != 0))
        {
          localObject = new MediaCodec.BufferInfo();
          ((MediaCodec.BufferInfo)localObject).size = paramMediaExtractor2.readSampleData(localByteBuffer, 0);
          if (((MediaCodec.BufferInfo)localObject).size < 0)
          {
            m = 1;
            if (m != 0) {}
            if ((l3 < l1) && (l1 - l3 > 0L) && (m == 0) && (this.cHT)) {
              break label616;
            }
            i5 = 1;
            if ((!this.cHU) || (i1 != 0) || ((localMediaFormat1 != null) && (i4 == 0)) || (i5 == 0)) {
              break label1447;
            }
            localObject = paramanig1.a();
            if (localObject == null) {
              break label1447;
            }
            if (((ioc.a)localObject).index != -1) {
              break label622;
            }
            i2 = k;
            l5 = l2;
            if (!this.cHU) {
              break label1426;
            }
            i2 = k;
            l5 = l2;
            if (j != 0) {
              break label1426;
            }
            if (localMediaFormat1 != null)
            {
              i2 = k;
              l5 = l2;
              if (i4 == 0) {
                break label1426;
              }
            }
            i2 = k;
            l5 = l2;
            if (i5 == 0) {
              break label1426;
            }
            localObject = paramanig1.b();
            if (localObject != null) {
              break label901;
            }
            i2 = k;
            k = j;
            j = i2;
            label326:
            if ((!this.cHU) || (i != 0) || ((localMediaFormat1 != null) && (i4 == 0)) || (i5 == 0)) {
              break label1423;
            }
            localObject = paramanig2.b();
            if (localObject != null) {
              break label1243;
            }
            label365:
            if ((i4 != 0) || ((this.cHT) && (localMediaFormat2 == null)) || ((this.cHU) && (localMediaFormat1 == null))) {
              break label1460;
            }
            if (this.cHU)
            {
              if (QLog.isColorLevel()) {
                QLog.d("JBMR2VideoConverterImpl", 2, "muxer: adding video track.");
              }
              n = paramMediaMuxer.addTrack(localMediaFormat1);
            }
            if (!this.cHT) {
              break label1453;
            }
            if (QLog.isColorLevel()) {
              QLog.d("JBMR2VideoConverterImpl", 2, "muxer: adding audio track.");
            }
            i2 = paramMediaMuxer.addTrack(localMediaFormat2);
            label454:
            if (QLog.isColorLevel()) {
              QLog.d("JBMR2VideoConverterImpl", 2, "muxer: starting");
            }
            paramMediaMuxer.start();
            i4 = 1;
            i3 = i2;
          }
        }
      }
      label662:
      label682:
      label819:
      label1460:
      for (int i2 = i4;; i2 = i4)
      {
        i4 = i2;
        i2 = k;
        k = j;
        j = i2;
        break;
        ((MediaCodec.BufferInfo)localObject).presentationTimeUs = paramMediaExtractor2.getSampleTime();
        ((MediaCodec.BufferInfo)localObject).flags = paramMediaExtractor2.getSampleFlags();
        paramMediaMuxer.writeSampleData(i3, localByteBuffer, (MediaCodec.BufferInfo)localObject);
        if (!paramMediaExtractor2.advance()) {}
        for (i2 = 1;; i2 = 0)
        {
          l4 = ((MediaCodec.BufferInfo)localObject).presentationTimeUs;
          m = i2;
          l3 = l4;
          if (this.ame <= 0L) {
            break;
          }
          m = i2;
          l3 = l4;
          if (((MediaCodec.BufferInfo)localObject).presentationTimeUs < this.ame) {
            break;
          }
          m = 1;
          l3 = l4;
          break;
        }
        localMediaFormat2 = paramMediaExtractor2.getTrackFormat(paramMediaExtractor2.getSampleTrackIndex());
        break label164;
        label616:
        i5 = 0;
        break label197;
        label622:
        int i6 = paramMediaExtractor1.readSampleData(((ioc.a)localObject).buffer, 0);
        long l4 = paramMediaExtractor1.getSampleTime();
        if (this.ame > 0L) {
          if (l4 >= this.ame) {
            i1 = 1;
          }
        }
        for (;;)
        {
          if (i6 >= 0)
          {
            int i7 = ((ioc.a)localObject).index;
            if (i1 != 0)
            {
              i2 = 4;
              paramanig1.queueInputBuffer(i7, i6, l4, i2);
            }
          }
          else
          {
            if (paramMediaExtractor1.advance()) {
              break label819;
            }
          }
          for (i2 = 1;; i2 = 0)
          {
            if (i1 != 0) {
              i2 = 1;
            }
            i1 = i2;
            if (i2 == 0) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("JBMR2VideoConverterImpl", 2, "video extractor: EOS, size = " + i6);
            }
            if (i6 < 0) {
              break label863;
            }
            localObject = paramanig1.a();
            if ((localObject != null) && (((ioc.a)localObject).index != -1)) {
              break label825;
            }
            i1 = i2;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("JBMR2VideoConverterImpl", 2, "no video decoder input buffer 1");
            i1 = i2;
            break;
            i1 = 0;
            break label662;
            i2 = paramMediaExtractor1.getSampleFlags();
            break label682;
          }
          label825:
          paramanig1.queueInputBuffer(((ioc.a)localObject).index, 0, 0L, 4);
          i1 = i2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("JBMR2VideoConverterImpl", 2, "videoDecoder.queueInputBuffer, MediaCodec.BUFFER_FLAG_END_OF_STREAM 1 ");
          i1 = i2;
          break;
          label863:
          paramanig1.queueInputBuffer(((ioc.a)localObject).index, 0, 0L, 4);
          i1 = i2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("JBMR2VideoConverterImpl", 2, "videoDecoder.queueInputBuffer, MediaCodec.BUFFER_FLAG_END_OF_STREAM ");
          i1 = i2;
          break;
          MediaCodec.BufferInfo localBufferInfo = ((ioc.a)localObject).info;
          i6 = ((ioc.a)localObject).index;
          if (i6 != -1) {
            k = 0;
          }
          if (i6 == -1)
          {
            k += 1;
            i2 = k;
            l5 = l2;
            if (k > 20) {
              throw new Exception("TooManyDecodeTimeOut");
            }
          }
          else
          {
            if (i6 == -3)
            {
              i2 = j;
              j = k;
              k = i2;
              break label326;
            }
            if (i6 == -2)
            {
              paramanig1.a().getOutputFormat();
              i2 = j;
              j = k;
              k = i2;
              break label326;
            }
            if ((localBufferInfo.flags & 0x2) != 0)
            {
              paramanig1.releaseOutputBuffer(((ioc.a)localObject).index);
              i2 = j;
              j = k;
              k = i2;
              break label326;
            }
            i2 = 0;
            if (this.aAY)
            {
              if (localBufferInfo.presentationTimeUs < this.amd) {
                i2 = 1;
              }
            }
            else {
              if ((localBufferInfo.size == 0) || (i2 != 0)) {
                break label1237;
              }
            }
            float f;
            label1237:
            for (boolean bool = true;; bool = false)
            {
              paramanig1.a().releaseOutputBuffer(i6, bool);
              l4 = l2;
              if (bool)
              {
                paramanlg.awaitNewImage();
                paramanlg.drawImage();
                paramanlf.setPresentationTime(localBufferInfo.presentationTimeUs * 1000L);
                paramanlf.swapBuffers();
                l4 = l2;
                if (l2 < 0L) {
                  l4 = localBufferInfo.presentationTimeUs;
                }
                f = (float)(localBufferInfo.presentationTimeUs - l4) / (float)this.amc;
                this.jdField_a_of_type_Anli$a.onProgress((int)(f * 10000.0F));
              }
              i2 = k;
              l5 = l4;
              if ((localBufferInfo.flags & 0x4) == 0) {
                break label1426;
              }
              paramanig2.a().signalEndOfInputStream();
              j = k;
              k = 1;
              l2 = l4;
              break;
              i2 = 0;
              break label1074;
            }
            label1243:
            localBufferInfo = ((ioc.a)localObject).info;
            i2 = ((ioc.a)localObject).index;
            if ((i2 == -1) || (i2 == -3)) {
              break label365;
            }
            if (i2 == -2)
            {
              if (n >= 0) {
                throw new IOException("video encoder changed its output format again?");
              }
              localMediaFormat1 = paramanig2.a().getOutputFormat();
              break label365;
            }
            if ((localBufferInfo.flags & 0x2) != 0)
            {
              paramanig2.releaseOutputBuffer(((ioc.a)localObject).index);
              break label365;
            }
            if (localBufferInfo.size != 0)
            {
              paramMediaMuxer.writeSampleData(n, ((ioc.a)localObject).buffer, localBufferInfo);
              l1 = localBufferInfo.presentationTimeUs;
              f = (float)(localBufferInfo.presentationTimeUs - l2) / (float)this.amc;
              this.jdField_a_of_type_Anli$a.onProgress((int)(f * 10000.0F));
            }
            if ((localBufferInfo.flags & 0x4) != 0) {
              i = 1;
            }
            paramanig2.releaseOutputBuffer(((ioc.a)localObject).index);
            break label365;
            break label365;
          }
          k = j;
          j = i2;
          l2 = l5;
          break label326;
          i1 = 0;
        }
        break label244;
        break label164;
        i2 = i3;
        break label454;
      }
    }
    
    protected void a(File paramFile, anli.a parama)
      throws IOException
    {
      Object localObject2 = paramFile.getAbsolutePath();
      Object localObject1 = selectCodec("video/avc");
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("JBMR2VideoConverterImpl", 2, "Unable to find an appropriate codec for video/avc");
        }
        throw new IOException("Unable to find an appropriate codec for video/avc");
      }
      if (QLog.isColorLevel()) {
        QLog.d("JBMR2VideoConverterImpl", 2, "video found codec: " + ((MediaCodecInfo)localObject1).getName());
      }
      MediaExtractor localMediaExtractor1 = new MediaExtractor();
      localMediaExtractor1.setDataSource((String)localObject2);
      if (b(localMediaExtractor1) < 0) {
        this.cHT = false;
      }
      MediaExtractor localMediaExtractor2 = new MediaExtractor();
      localMediaExtractor2.setDataSource((String)localObject2);
      int i = getAndSelectVideoTrackIndex(localMediaExtractor2);
      if (i < 0) {
        throw new IOException("No video track found in " + paramFile);
      }
      localObject1 = localMediaExtractor2.getTrackFormat(i);
      paramFile = a((MediaFormat)localObject1, (String)localObject2);
      int n = (int)paramFile[2];
      int k = (int)paramFile[0];
      i = (int)paramFile[1];
      this.amc = paramFile[3];
      anli.b localb = parama.a(k, i);
      if ((localb.beginTime >= 0L) && (localb.endTime > 0L) && (localb.endTime - localb.beginTime >= 1000L))
      {
        this.ame = (localb.endTime * 1000L);
        this.amd = (localb.beginTime * 1000L);
        this.amc = (this.ame - this.amd);
        localMediaExtractor2.seekTo(this.amd, 2);
        localMediaExtractor1.seekTo(this.amd, 2);
      }
      if (localb.isMute) {
        this.cHT = false;
      }
      if (localb.cHY) {
        this.aAY = true;
      }
      int j;
      int m;
      if (!localb.cHX)
      {
        j = k;
        m = i;
        if (n != 90)
        {
          if (n == 270)
          {
            m = i;
            j = k;
          }
        }
        else
        {
          if (!this.cHU) {
            break label709;
          }
          parama = MediaFormat.createVideoFormat("video/avc", Math.round(m * localb.scaleRate / 16.0F) * 16, Math.round(j * localb.scaleRate / 16.0F) * 16);
          parama.setInteger("color-format", 2130708361);
          parama.setInteger("bitrate", localb.videoBitRate);
          parama.setFloat("frame-rate", localb.videoFrameRate);
          parama.setInteger("i-frame-interval", localb.agP);
          if (localb.cHW)
          {
            parama.setInteger("profile", localb.profile);
            parama.setInteger("level", localb.level);
          }
          if (localb.dzA != -1) {
            parama.setInteger("bitrate-mode", localb.dzA);
          }
          if (QLog.isColorLevel()) {
            QLog.d("JBMR2VideoConverterImpl", 2, "video format: " + parama);
          }
          paramFile = new AtomicReference();
          localObject2 = a(parama, paramFile);
          parama = new anlf((Surface)paramFile.get());
          parama.makeCurrent();
          paramFile = new anlg();
          localObject1 = a((MediaFormat)localObject1, paramFile.mSurface);
        }
      }
      for (;;)
      {
        MediaMuxer localMediaMuxer = new MediaMuxer(localb.as.getAbsolutePath(), 0);
        if ((this.cHU) && (localb.cHX)) {
          localMediaMuxer.setOrientationHint(n);
        }
        this.jdField_b_of_type_AndroidMediaMediaExtractor = localMediaExtractor2;
        this.c = localMediaExtractor1;
        this.jdField_a_of_type_Anig = ((anig)localObject1);
        this.jdField_b_of_type_Anig = ((anig)localObject2);
        this.jdField_b_of_type_AndroidMediaMediaMuxer = localMediaMuxer;
        this.jdField_a_of_type_Anlf = parama;
        this.jdField_a_of_type_Anlg = paramFile;
        return;
        j = i;
        m = k;
        break;
        label709:
        paramFile = null;
        parama = null;
        localObject1 = null;
        localObject2 = null;
      }
    }
    
    long[] a(MediaFormat paramMediaFormat, String paramString)
    {
      j = paramMediaFormat.getInteger("width");
      k = paramMediaFormat.getInteger("height");
      long l = paramMediaFormat.getLong("durationUs");
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      paramMediaFormat = null;
      try
      {
        localMediaMetadataRetriever.setDataSource(paramString);
        paramString = localMediaMetadataRetriever.extractMetadata(24);
        paramMediaFormat = paramString;
      }
      catch (IllegalArgumentException paramString)
      {
        for (;;)
        {
          int i;
          paramString.printStackTrace();
          continue;
          try
          {
            i = Integer.parseInt(paramMediaFormat);
          }
          catch (NumberFormatException paramString)
          {
            QLog.d("JBMR2VideoConverterImpl", 2, "Video size is " + j + "x" + k + ". rotation: " + paramMediaFormat, paramString);
            i = 0;
          }
        }
      }
      if (paramMediaFormat == null)
      {
        i = 0;
        localMediaMetadataRetriever.release();
        if (QLog.isColorLevel()) {
          QLog.d("JBMR2VideoConverterImpl", 2, "Video size is " + j + "x" + k + ". rotation: " + paramMediaFormat);
        }
        return new long[] { j, k, i, l };
      }
    }
    
    int b(MediaExtractor paramMediaExtractor)
    {
      int i = 0;
      try
      {
        while (i < paramMediaExtractor.getTrackCount())
        {
          if (QLog.isColorLevel()) {
            QLog.d("JBMR2VideoConverterImpl", 2, "format for track " + i + " is " + paramMediaExtractor.getTrackFormat(i).getString("mime"));
          }
          if (paramMediaExtractor.getTrackFormat(i).getString("mime").startsWith("audio/"))
          {
            paramMediaExtractor.selectTrack(i);
            return i;
          }
          i += 1;
        }
        return -1;
      }
      catch (Exception paramMediaExtractor) {}
    }
    
    int getAndSelectVideoTrackIndex(MediaExtractor paramMediaExtractor)
    {
      int i = 0;
      try
      {
        while (i < paramMediaExtractor.getTrackCount())
        {
          if (QLog.isColorLevel()) {
            QLog.d("JBMR2VideoConverterImpl", 2, "format for track " + i + " is " + paramMediaExtractor.getTrackFormat(i).getString("mime"));
          }
          if (paramMediaExtractor.getTrackFormat(i).getString("mime").startsWith("video/"))
          {
            paramMediaExtractor.selectTrack(i);
            return i;
          }
          i += 1;
        }
        return -1;
      }
      catch (Exception paramMediaExtractor) {}
    }
    
    protected void release()
    {
      if (QLog.isColorLevel()) {
        QLog.d("JBMR2VideoConverterImpl", 2, "shutting down encoder, decoder");
      }
      if (this.jdField_a_of_type_Anlg != null) {
        this.jdField_a_of_type_Anlg.release();
      }
      if (this.jdField_a_of_type_Anlf != null) {
        this.jdField_a_of_type_Anlf.release();
      }
      if (this.jdField_b_of_type_Anig != null)
      {
        this.jdField_b_of_type_Anig.stop();
        this.jdField_b_of_type_Anig.release();
      }
      if (this.jdField_a_of_type_Anig != null)
      {
        this.jdField_a_of_type_Anig.stop();
        this.jdField_a_of_type_Anig.release();
      }
      if (this.jdField_b_of_type_AndroidMediaMediaMuxer != null)
      {
        this.jdField_b_of_type_AndroidMediaMediaMuxer.release();
        this.jdField_b_of_type_AndroidMediaMediaMuxer = null;
      }
      if (this.jdField_b_of_type_AndroidMediaMediaExtractor != null)
      {
        this.jdField_b_of_type_AndroidMediaMediaExtractor.release();
        this.jdField_b_of_type_AndroidMediaMediaExtractor = null;
      }
      if (this.c != null)
      {
        this.c.release();
        this.c = null;
      }
    }
    
    public void run()
    {
      try
      {
        this.jdField_a_of_type_Anli$a.onProgress(0);
        a(this.aN, this.jdField_a_of_type_Anli$a);
        a(this.jdField_b_of_type_AndroidMediaMediaExtractor, this.c, this.jdField_a_of_type_Anig, this.jdField_b_of_type_Anig, this.jdField_b_of_type_AndroidMediaMediaMuxer, this.jdField_a_of_type_Anlf, this.jdField_a_of_type_Anlg);
        if (this.cHV)
        {
          this.cHV = false;
          this.jdField_a_of_type_Anli$a.onCanceled();
        }
      }
      catch (Exception localException1)
      {
        try
        {
          release();
          do
          {
            return;
            this.jdField_a_of_type_Anli$a.onProgress(10000);
            this.jdField_a_of_type_Anli$a.ahK();
            break;
            localException1 = localException1;
            QLog.e("JBMR2VideoConverterImpl", 1, localException1.getMessage(), localException1);
            this.jdField_a_of_type_Anli$a.f(localException1);
            try
            {
              release();
              return;
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
              this.jdField_a_of_type_Anli$a.f(localException2);
            }
          } while (!QLog.isColorLevel());
          QLog.d("JBMR2VideoConverterImpl", 2, "release Hw Resource error...");
          QLog.d("JBMR2VideoConverterImpl", 2, localException2.getMessage(), localException2);
          return;
        }
        catch (Exception localException3)
        {
          do
          {
            localException3.printStackTrace();
            this.jdField_a_of_type_Anli$a.f(localException3);
          } while (!QLog.isColorLevel());
          QLog.d("JBMR2VideoConverterImpl", 2, "release Hw Resource error...");
          QLog.d("JBMR2VideoConverterImpl", 2, localException3.getMessage(), localException3);
          return;
        }
      }
      finally {}
      try
      {
        release();
        throw localObject;
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          localException4.printStackTrace();
          this.jdField_a_of_type_Anli$a.f(localException4);
          if (QLog.isColorLevel())
          {
            QLog.d("JBMR2VideoConverterImpl", 2, "release Hw Resource error...");
            QLog.d("JBMR2VideoConverterImpl", 2, localException4.getMessage(), localException4);
          }
        }
      }
    }
    
    MediaCodecInfo selectCodec(String paramString)
    {
      int k = MediaCodecList.getCodecCount();
      int i = 0;
      if (i < k)
      {
        MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
        if (!localMediaCodecInfo.isEncoder()) {}
        for (;;)
        {
          i += 1;
          break;
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int j = 0;
          while (j < arrayOfString.length)
          {
            if (arrayOfString[j].equalsIgnoreCase(paramString)) {
              return localMediaCodecInfo;
            }
            j += 1;
          }
        }
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.videoconverter.JBMR2VideoConverterImpl
 * JD-Core Version:    0.7.0.1
 */