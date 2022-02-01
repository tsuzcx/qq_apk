package dov.com.tencent.mobileqq.shortvideo.util.videoconverter;

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
import azay;
import azcg;
import azch;
import azck.a;
import azck.b;
import azck.c;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import ioc.a;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@TargetApi(18)
public class JBMR2VideoConverterImpl
  implements azck.c
{
  boolean running = false;
  boolean stopping = false;
  
  public boolean a(File paramFile, azck.a parama, boolean paramBoolean)
  {
    if (!this.running)
    {
      this.running = true;
      paramFile = new Converter(paramFile, parama);
      if (!paramBoolean)
      {
        ThreadManagerV2.excute(paramFile, 16, null, false);
        return true;
      }
      paramFile.run();
      return true;
    }
    return false;
  }
  
  class Converter
    implements Runnable
  {
    azay jdField_a_of_type_Azay = null;
    azcg jdField_a_of_type_Azcg = null;
    azch jdField_a_of_type_Azch = null;
    azck.a jdField_a_of_type_Azck$a = null;
    boolean aAY = false;
    File aN = null;
    long amc = -1L;
    long amd = -1L;
    long ame = -1L;
    MediaExtractor jdField_b_of_type_AndroidMediaMediaExtractor = null;
    MediaMuxer jdField_b_of_type_AndroidMediaMediaMuxer = null;
    azay jdField_b_of_type_Azay = null;
    MediaExtractor c = null;
    boolean cHT = true;
    boolean cHU = true;
    boolean cHV;
    
    public Converter(File paramFile, azck.a parama)
    {
      this.aN = paramFile;
      this.jdField_a_of_type_Azck$a = parama;
    }
    
    azay a(MediaFormat paramMediaFormat, Surface paramSurface)
    {
      Object localObject = azay.j(paramMediaFormat.getString("mime"), false);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = (MediaCodecInfo)((List)localObject).get(0);
        azay localazay = new azay();
        localazay.a(paramMediaFormat, ((MediaCodecInfo)localObject).getName(), paramSurface, null);
        localazay.start();
        return localazay;
      }
      return null;
    }
    
    azay a(MediaFormat paramMediaFormat, AtomicReference<Surface> paramAtomicReference)
    {
      azay localazay = new azay();
      localazay.a(paramMediaFormat, azay.ENC_CODEC, null);
      paramAtomicReference.set(localazay.a().createInputSurface());
      localazay.start();
      return localazay;
    }
    
    void a(MediaExtractor paramMediaExtractor1, MediaExtractor paramMediaExtractor2, azay paramazay1, azay paramazay2, MediaMuxer paramMediaMuxer, azcg paramazcg, azch paramazch)
      throws IOException
    {
      int i2 = 0;
      ByteBuffer localByteBuffer = ByteBuffer.allocate(262144);
      int i = 0;
      int j = 0;
      MediaFormat localMediaFormat1 = null;
      int i1 = -1;
      int k = 0;
      int m = -1;
      long l1 = 0L;
      long l2 = 0L;
      int n = 0;
      MediaFormat localMediaFormat2 = null;
      long l3 = -1L;
      if (((this.cHU) && (i == 0)) || ((this.cHT) && (k == 0)))
      {
        this.cHV = Thread.interrupted();
        if (!this.cHV) {}
      }
      else
      {
        return;
      }
      Object localObject;
      label153:
      int i4;
      label186:
      label233:
      long l5;
      if ((this.cHT) && (k == 0) && ((localMediaFormat2 == null) || (i2 != 0))) {
        if ((localMediaFormat2 != null) && (i2 != 0))
        {
          localObject = new MediaCodec.BufferInfo();
          ((MediaCodec.BufferInfo)localObject).size = paramMediaExtractor2.readSampleData(localByteBuffer, 0);
          if (((MediaCodec.BufferInfo)localObject).size < 0)
          {
            k = 1;
            if (k != 0) {}
            if ((l2 < l1) && (l1 - l2 > 0L) && (k == 0) && (this.cHT)) {
              break label553;
            }
            i4 = 1;
            if ((!this.cHU) || (n != 0) || ((localMediaFormat1 != null) && (i2 == 0)) || (i4 == 0)) {
              break label1121;
            }
            localObject = paramazay1.a();
            if (localObject == null) {
              break label1121;
            }
            if (((ioc.a)localObject).index != -1) {
              break label559;
            }
            l5 = l3;
            if (!this.cHU) {
              break label1108;
            }
            l5 = l3;
            if (j != 0) {
              break label1108;
            }
            if (localMediaFormat1 != null)
            {
              l5 = l3;
              if (i2 == 0) {
                break label1108;
              }
            }
            l5 = l3;
            if (i4 == 0) {
              break label1108;
            }
            localObject = paramazay1.b();
            if (localObject != null) {
              break label698;
            }
            label287:
            if ((!this.cHU) || (i != 0) || ((localMediaFormat1 != null) && (i2 == 0)) || (i4 == 0)) {
              break label1105;
            }
            localObject = paramazay2.b();
            if (localObject != null) {
              break label925;
            }
            label326:
            if ((i2 != 0) || ((this.cHT) && (localMediaFormat2 == null)) || ((this.cHU) && (localMediaFormat1 == null))) {
              break label1130;
            }
            if (this.cHU)
            {
              if (QLog.isColorLevel()) {
                QLog.d("JBMR2VideoConverterImpl", 2, "muxer: adding video track.");
              }
              m = paramMediaMuxer.addTrack(localMediaFormat1);
            }
            if (!this.cHT) {
              break label1127;
            }
            if (QLog.isColorLevel()) {
              QLog.d("JBMR2VideoConverterImpl", 2, "muxer: adding audio track.");
            }
            i1 = paramMediaMuxer.addTrack(localMediaFormat2);
            label415:
            if (QLog.isColorLevel()) {
              QLog.d("JBMR2VideoConverterImpl", 2, "muxer: starting");
            }
            paramMediaMuxer.start();
            i2 = 1;
          }
        }
      }
      label553:
      label559:
      label599:
      label1121:
      label1127:
      label1130:
      for (;;)
      {
        break;
        ((MediaCodec.BufferInfo)localObject).presentationTimeUs = paramMediaExtractor2.getSampleTime();
        ((MediaCodec.BufferInfo)localObject).flags = paramMediaExtractor2.getSampleFlags();
        paramMediaMuxer.writeSampleData(i1, localByteBuffer, (MediaCodec.BufferInfo)localObject);
        if (!paramMediaExtractor2.advance()) {}
        for (int i3 = 1;; i3 = 0)
        {
          l4 = ((MediaCodec.BufferInfo)localObject).presentationTimeUs;
          k = i3;
          l2 = l4;
          if (this.ame <= 0L) {
            break;
          }
          k = i3;
          l2 = l4;
          if (((MediaCodec.BufferInfo)localObject).presentationTimeUs < this.ame) {
            break;
          }
          k = 1;
          l2 = l4;
          break;
        }
        localMediaFormat2 = paramMediaExtractor2.getTrackFormat(paramMediaExtractor2.getSampleTrackIndex());
        break label153;
        i4 = 0;
        break label186;
        int i5 = paramMediaExtractor1.readSampleData(((ioc.a)localObject).buffer, 0);
        long l4 = paramMediaExtractor1.getSampleTime();
        if (this.ame > 0L) {
          if (l4 >= this.ame) {
            n = 1;
          }
        }
        for (;;)
        {
          if (i5 >= 0)
          {
            int i6 = ((ioc.a)localObject).index;
            if (n != 0)
            {
              i3 = 4;
              label619:
              paramazay1.queueInputBuffer(i6, i5, l4, i3);
            }
          }
          else
          {
            if (paramMediaExtractor1.advance()) {
              break label692;
            }
          }
          for (i3 = 1;; i3 = 0)
          {
            if (n != 0) {
              i3 = 1;
            }
            n = i3;
            if (i3 == 0) {
              break;
            }
            paramazay1.queueInputBuffer(((ioc.a)localObject).index, 0, 0L, 4);
            n = i3;
            break;
            n = 0;
            break label599;
            i3 = paramMediaExtractor1.getSampleFlags();
            break label619;
          }
          MediaCodec.BufferInfo localBufferInfo = ((ioc.a)localObject).info;
          i5 = ((ioc.a)localObject).index;
          if ((i5 == -1) || (i5 == -3)) {
            break label287;
          }
          if (i5 == -2)
          {
            paramazay1.a().getOutputFormat();
            break label287;
          }
          if ((localBufferInfo.flags & 0x2) != 0)
          {
            paramazay1.releaseOutputBuffer(((ioc.a)localObject).index);
            break label287;
          }
          i3 = 0;
          if (this.aAY)
          {
            if (localBufferInfo.presentationTimeUs < this.amd) {
              i3 = 1;
            }
          }
          else {
            if ((localBufferInfo.size == 0) || (i3 != 0)) {
              break label919;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            paramazay1.a().releaseOutputBuffer(i5, bool);
            l4 = l3;
            if (bool)
            {
              paramazch.awaitNewImage();
              paramazch.drawImage();
              paramazcg.setPresentationTime(localBufferInfo.presentationTimeUs * 1000L);
              paramazcg.swapBuffers();
              l4 = l3;
              if (l3 < 0L) {
                l4 = localBufferInfo.presentationTimeUs;
              }
            }
            l5 = l4;
            if ((localBufferInfo.flags & 0x4) == 0) {
              break label1108;
            }
            paramazay2.a().signalEndOfInputStream();
            j = 1;
            l3 = l4;
            break;
            i3 = 0;
            break label797;
          }
          localBufferInfo = ((ioc.a)localObject).info;
          i3 = ((ioc.a)localObject).index;
          if ((i3 == -1) || (i3 == -3)) {
            break label326;
          }
          if (i3 == -2)
          {
            if (m >= 0) {
              throw new IOException("video encoder changed its output format again?");
            }
            localMediaFormat1 = paramazay2.a().getOutputFormat();
            break label326;
          }
          if ((localBufferInfo.flags & 0x2) != 0)
          {
            paramazay2.releaseOutputBuffer(((ioc.a)localObject).index);
            break label326;
          }
          if (localBufferInfo.size != 0)
          {
            paramMediaMuxer.writeSampleData(m, ((ioc.a)localObject).buffer, localBufferInfo);
            l1 = localBufferInfo.presentationTimeUs;
            float f = (float)(localBufferInfo.presentationTimeUs - l3) / (float)this.amc;
            this.jdField_a_of_type_Azck$a.onProgress((int)(f * 10000.0F));
          }
          if ((localBufferInfo.flags & 0x4) != 0) {
            i = 1;
          }
          paramazay2.releaseOutputBuffer(((ioc.a)localObject).index);
          break label326;
          break label326;
          l3 = l5;
          break label287;
          n = 0;
        }
        break label233;
        break label153;
        break label415;
      }
    }
    
    protected void a(File paramFile, azck.a parama)
      throws IOException
    {
      Object localObject1 = paramFile.getAbsolutePath();
      Object localObject2 = selectCodec("video/avc");
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("JBMR2VideoConverterImpl", 2, "Unable to find an appropriate codec for video/avc");
        }
        throw new IOException("Unable to find an appropriate codec for video/avc");
      }
      if (QLog.isColorLevel()) {
        QLog.d("JBMR2VideoConverterImpl", 2, "video found codec: " + ((MediaCodecInfo)localObject2).getName());
      }
      MediaExtractor localMediaExtractor1 = new MediaExtractor();
      MediaExtractor localMediaExtractor2 = new MediaExtractor();
      try
      {
        localMediaExtractor1.setDataSource((String)localObject1);
        localMediaExtractor2.setDataSource((String)localObject1);
        if (b(localMediaExtractor1) < 0) {
          this.cHT = false;
        }
        i = getAndSelectVideoTrackIndex(localMediaExtractor2);
        if (i < 0)
        {
          localMediaExtractor2.release();
          localMediaExtractor1.release();
          throw new IOException("No video track found in " + paramFile);
        }
      }
      catch (IOException paramFile)
      {
        paramFile.printStackTrace();
        localMediaExtractor2.release();
        localMediaExtractor1.release();
        return;
      }
      Object localObject3 = localMediaExtractor2.getTrackFormat(i);
      paramFile = a((MediaFormat)localObject3, (String)localObject1);
      int n = (int)paramFile[2];
      int j = (int)paramFile[0];
      int i = (int)paramFile[1];
      this.amc = paramFile[3];
      azck.b localb = parama.a(j, i);
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
      int k;
      int m;
      if ((!localb.cHX) && ((n == 90) || (n == 270)))
      {
        localObject1 = null;
        parama = null;
        paramFile = null;
        if (!this.cHU) {
          break label817;
        }
        if ((localb.bjE > 0) && (localb.bjF > 0)) {
          break label780;
        }
        k = Math.round(i * localb.scaleRate / 16.0F) * 16;
        m = Math.round(j * localb.scaleRate / 16.0F) * 16;
        label462:
        parama = MediaFormat.createVideoFormat("video/avc", k, m);
        parama.setInteger("color-format", 2130708361);
        parama.setInteger("bitrate", localb.videoBitRate);
        parama.setFloat("frame-rate", localb.videoFrameRate);
        parama.setInteger("i-frame-interval", localb.agP);
        if (localb.cHW)
        {
          parama.setInteger("profile", localb.profile);
          parama.setInteger("level", localb.level);
        }
        if (QLog.isColorLevel()) {
          QLog.d("JBMR2VideoConverterImpl", 2, "video format: " + parama);
        }
        paramFile = new AtomicReference();
        localObject2 = a(parama, paramFile);
        parama = new azcg((Surface)paramFile.get());
        parama.makeCurrent();
        paramFile = new azch();
        if ((localb.bjE > 0) && (localb.bjF > 0)) {
          paramFile.c(k, m, i, j, localb.bjC, localb.bjD, localb.bjE, localb.bjF);
        }
        localObject1 = a((MediaFormat)localObject3, paramFile.mSurface);
      }
      for (;;)
      {
        localObject3 = new MediaMuxer(localb.as.getAbsolutePath(), 0);
        if ((this.cHU) && (localb.cHX)) {
          ((MediaMuxer)localObject3).setOrientationHint(n);
        }
        this.jdField_b_of_type_AndroidMediaMediaExtractor = localMediaExtractor2;
        this.c = localMediaExtractor1;
        this.jdField_a_of_type_Azay = ((azay)localObject1);
        this.jdField_b_of_type_Azay = ((azay)localObject2);
        this.jdField_b_of_type_AndroidMediaMediaMuxer = ((MediaMuxer)localObject3);
        this.jdField_a_of_type_Azcg = parama;
        this.jdField_a_of_type_Azch = paramFile;
        return;
        k = i;
        i = j;
        j = k;
        break;
        label780:
        k = Math.round(localb.bjE / 16) * 16;
        m = Math.round(localb.bjF / 16) * 16;
        break label462;
        label817:
        localObject2 = null;
      }
    }
    
    long[] a(MediaFormat paramMediaFormat, String paramString)
    {
      int j = paramMediaFormat.getInteger("width");
      int k = paramMediaFormat.getInteger("height");
      long l = paramMediaFormat.getLong("durationUs");
      paramMediaFormat = new MediaMetadataRetriever();
      paramMediaFormat.setDataSource(paramString);
      paramString = paramMediaFormat.extractMetadata(24);
      int i;
      if (paramString == null) {
        i = 0;
      }
      for (;;)
      {
        paramMediaFormat.release();
        if (QLog.isColorLevel()) {
          QLog.d("JBMR2VideoConverterImpl", 2, "Video size is " + j + "x" + k + ". rotation: " + paramString);
        }
        return new long[] { j, k, i, l };
        try
        {
          i = Integer.parseInt(paramString);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          i = 0;
        }
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
      if (this.jdField_a_of_type_Azch != null) {
        this.jdField_a_of_type_Azch.release();
      }
      if (this.jdField_a_of_type_Azcg != null) {
        this.jdField_a_of_type_Azcg.release();
      }
      if (this.jdField_b_of_type_Azay != null)
      {
        this.jdField_b_of_type_Azay.stop();
        this.jdField_b_of_type_Azay.release();
      }
      if (this.jdField_a_of_type_Azay != null)
      {
        this.jdField_a_of_type_Azay.stop();
        this.jdField_a_of_type_Azay.release();
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
        this.jdField_a_of_type_Azck$a.onProgress(0);
        a(this.aN, this.jdField_a_of_type_Azck$a);
        a(this.jdField_b_of_type_AndroidMediaMediaExtractor, this.c, this.jdField_a_of_type_Azay, this.jdField_b_of_type_Azay, this.jdField_b_of_type_AndroidMediaMediaMuxer, this.jdField_a_of_type_Azcg, this.jdField_a_of_type_Azch);
        if (this.cHV)
        {
          this.cHV = false;
          this.jdField_a_of_type_Azck$a.onCanceled();
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
            this.jdField_a_of_type_Azck$a.onProgress(10000);
            this.jdField_a_of_type_Azck$a.ahK();
            break;
            localException1 = localException1;
            if (QLog.isColorLevel()) {
              QLog.e("JBMR2VideoConverterImpl", 1, localException1.getMessage(), localException1);
            }
            this.jdField_a_of_type_Azck$a.f(localException1);
            try
            {
              release();
              return;
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
              this.jdField_a_of_type_Azck$a.f(localException2);
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
            this.jdField_a_of_type_Azck$a.f(localException3);
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
          this.jdField_a_of_type_Azck$a.f(localException4);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.videoconverter.JBMR2VideoConverterImpl
 * JD-Core Version:    0.7.0.1
 */