import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.biz.qqstory.takevideo.localmedia.demos.MediaCodecThumbnailGenerator.CodecHandler.1;
import com.tencent.biz.qqstory.takevideo.localmedia.demos.MediaCodecThumbnailGenerator.CodecHandler.2;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.concurrent.TimeoutException;

@TargetApi(16)
public class xjo
  extends Handler
{
  public xjo(xjn paramxjn, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(xjp paramxjp)
  {
    int i = 0;
    xjs localxjs = new xjs();
    localxjs.jdField_a_of_type_Xjp = paramxjp;
    localxjs.jdField_b_of_type_Long = (axwp.a(paramxjp.jdField_a_of_type_JavaLangString) * 1000L);
    for (;;)
    {
      MediaExtractor localMediaExtractor;
      int k;
      try
      {
        localObject1 = new File(paramxjp.jdField_a_of_type_JavaLangString);
        if (!((File)localObject1).canRead()) {
          throw new FileNotFoundException("Unable to read " + localObject1);
        }
      }
      catch (Exception paramxjp)
      {
        paramxjp = paramxjp;
        Log.e("MediaCodecThumbnailGen", "startCaptureThumbnails Error!", paramxjp);
        if (!(paramxjp instanceof IllegalArgumentException)) {
          break label548;
        }
        localxjs.jdField_a_of_type_Int = 100;
        wxe.c("MediaCodecThumbnailGen", "Error when generate thumbnail", paramxjp);
        obtainMessage(4, localxjs).sendToTarget();
        return;
        localMediaExtractor = new MediaExtractor();
        localMediaExtractor.setDataSource(((File)localObject1).toString());
        k = xjm.a(localMediaExtractor);
        if (k < 0) {
          throw new RuntimeException("No video track found in " + localObject1);
        }
      }
      finally {}
      localMediaExtractor.selectTrack(k);
      int j = paramxjp.jdField_b_of_type_Int;
      Object localObject1 = new long[paramxjp.d];
      long[] arrayOfLong = new long[paramxjp.d];
      while (i < paramxjp.d)
      {
        localMediaExtractor.seekTo(j * 1000L, 0);
        arrayOfLong[i] = (j * 1000L);
        localObject1[i] = localMediaExtractor.getSampleTime();
        j += paramxjp.c;
        i += 1;
      }
      localMediaExtractor.seekTo(localObject1[0], 0);
      MediaFormat localMediaFormat = localMediaExtractor.getTrackFormat(k);
      boolean bool = localMediaFormat.containsKey("rotation-degrees");
      if (bool) {}
      try
      {
        localxjs.jdField_b_of_type_Int = localMediaFormat.getInteger("rotation-degrees");
        label318:
        i = localMediaFormat.getInteger("height");
        j = localMediaFormat.getInteger("width");
        Log.d("MediaCodecThumbnailGen", "Video size is " + j + "x" + i);
        float f = paramxjp.jdField_a_of_type_Int * 1.0F / Math.max(i, j);
        paramxjp = new xjt((int)(j * f), (int)(i * f));
        Object localObject2 = MediaCodec.createDecoderByType(localMediaFormat.getString("mime"));
        ((MediaCodec)localObject2).configure(localMediaFormat, paramxjp.a(), null, 0);
        ((MediaCodec)localObject2).start();
        localxjs.jdField_a_of_type_AndroidMediaMediaExtractor = localMediaExtractor;
        localxjs.jdField_a_of_type_Xjt = paramxjp;
        localxjs.jdField_a_of_type_AndroidMediaMediaCodec = ((MediaCodec)localObject2);
        localxjs.c = k;
        localxjs.jdField_a_of_type_Int = 0;
        localxjs.d = 0;
        localxjs.jdField_a_of_type_ArrayOfLong = ((long[])localObject1);
        localxjs.jdField_b_of_type_ArrayOfLong = arrayOfLong;
        obtainMessage(2, localxjs).sendToTarget();
        return;
        localObject2 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject2).setDataSource(localxjs.jdField_a_of_type_Xjp.jdField_a_of_type_JavaLangString);
        String str = ((MediaMetadataRetriever)localObject2).extractMetadata(24);
        try
        {
          localxjs.jdField_b_of_type_Int = Integer.parseInt(str);
          label540:
          ((MediaMetadataRetriever)localObject2).release();
          break label318;
          label548:
          if ((paramxjp instanceof RuntimeException))
          {
            localxjs.jdField_a_of_type_Int = 101;
            continue;
          }
          localxjs.jdField_a_of_type_Int = -1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          break label540;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        break label318;
      }
    }
  }
  
  private void a(xjs paramxjs)
  {
    Log.e("MediaCodecThumbnailGen", "finishCapture");
    boolean bool = true;
    if (paramxjs.jdField_a_of_type_Int != 0) {
      bool = false;
    }
    if (paramxjs.jdField_a_of_type_Xjt != null)
    {
      paramxjs.jdField_a_of_type_Xjt.a();
      paramxjs.jdField_a_of_type_Xjt = null;
    }
    if (paramxjs.jdField_a_of_type_AndroidMediaMediaCodec != null)
    {
      paramxjs.jdField_a_of_type_AndroidMediaMediaCodec.stop();
      paramxjs.jdField_a_of_type_AndroidMediaMediaCodec.release();
      paramxjs.jdField_a_of_type_AndroidMediaMediaCodec = null;
    }
    if (paramxjs.jdField_a_of_type_AndroidMediaMediaExtractor != null)
    {
      paramxjs.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      paramxjs.jdField_a_of_type_AndroidMediaMediaExtractor = null;
    }
    xjr localxjr = new xjr();
    localxjr.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(paramxjs.jdField_a_of_type_JavaUtilArrayList);
    localxjr.b = Collections.unmodifiableList(paramxjs.jdField_b_of_type_JavaUtilArrayList);
    localxjr.jdField_a_of_type_Int = paramxjs.jdField_a_of_type_Int;
    this.a.a.post(new MediaCodecThumbnailGenerator.CodecHandler.1(this, paramxjs, bool, localxjr));
  }
  
  private void a(xjs paramxjs, boolean paramBoolean)
  {
    Object localObject1 = paramxjs.jdField_a_of_type_Xjt;
    xjp localxjp = paramxjs.jdField_a_of_type_Xjp;
    int k = paramxjs.d;
    ArrayList localArrayList1 = paramxjs.jdField_a_of_type_JavaUtilArrayList;
    ArrayList localArrayList2 = paramxjs.jdField_b_of_type_JavaUtilArrayList;
    label576:
    label579:
    for (;;)
    {
      try
      {
        ((xjt)localObject1).c();
        ((xjt)localObject1).d();
        ((xjt)localObject1).a(false);
        xjq localxjq = new xjq();
        localObject1 = ((xjt)localObject1).a();
        if (localObject1 == null) {
          break label576;
        }
        int j = paramxjs.jdField_b_of_type_Int;
        int i;
        if ((paramxjs.jdField_b_of_type_Int % 180 <= 0) || (((Bitmap)localObject1).getWidth() >= ((Bitmap)localObject1).getHeight()))
        {
          i = j;
          if (paramxjs.jdField_b_of_type_Int % 180 == 0)
          {
            i = j;
            if (((Bitmap)localObject1).getWidth() <= ((Bitmap)localObject1).getHeight()) {}
          }
        }
        else
        {
          i = j;
          if (localxjp.jdField_a_of_type_Boolean) {
            i = j + 90;
          }
        }
        if (i > 0)
        {
          Object localObject2 = xsm.a((Bitmap)localObject1, i);
          ((Bitmap)localObject1).recycle();
          localObject1 = localObject2;
          if (!paramBoolean) {
            break label579;
          }
          localObject2 = new File(localxjp.jdField_b_of_type_JavaLangString, String.format(Locale.getDefault(), a(k), new Object[0]));
          try
          {
            BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream((File)localObject2));
            float f2;
            float f1;
            localObject1 = paramxjs.jdField_b_of_type_ArrayOfLong;
          }
          finally
          {
            try
            {
              ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 80, localBufferedOutputStream);
              if (localBufferedOutputStream == null) {}
            }
            finally
            {
              continue;
            }
            try
            {
              localBufferedOutputStream.close();
              localxjq.jdField_a_of_type_JavaLangString = ((File)localObject2).getAbsolutePath();
              wxe.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() add: " + ((File)localObject2).getPath());
              localxjq.jdField_a_of_type_Int = paramxjs.d;
              localxjq.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
              f2 = 0.0F;
              f1 = f2;
              if (localxjp.jdField_b_of_type_Boolean)
              {
                f1 = f2;
                if (paramxjs.d == 0)
                {
                  f1 = xjn.a(this.a, (Bitmap)localObject1);
                  wxe.c("MediaCodecThumbnailGen", "blackRegionPrecent = " + f1);
                  localxjq.jdField_a_of_type_Long = paramxjs.jdField_b_of_type_ArrayOfLong[paramxjs.d];
                }
              }
              if ((f1 >= 0.9F) && (localxjq.jdField_a_of_type_Long <= 500000L) && (localxjq.jdField_a_of_type_Long + 100000L <= paramxjs.jdField_b_of_type_Long)) {
                continue;
              }
              localArrayList1.add(localxjq.jdField_a_of_type_JavaLangString);
              localArrayList2.add(localObject1);
              this.a.a.post(new MediaCodecThumbnailGenerator.CodecHandler.2(this, paramxjs, localxjq));
              paramxjs.d += 1;
              obtainMessage(2, paramxjs).sendToTarget();
              return;
            }
            catch (IOException localIOException)
            {
              wxe.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() error ", localIOException);
            }
            localObject3 = finally;
            localBufferedOutputStream = null;
            if (localBufferedOutputStream != null) {
              localBufferedOutputStream.close();
            }
          }
          i = paramxjs.d;
          localObject1[i] += 50000L;
          obtainMessage(2, paramxjs).sendToTarget();
          return;
        }
      }
      catch (TimeoutException localTimeoutException)
      {
        sendMessageDelayed(obtainMessage(3, paramxjs), 100L);
        Log.e("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() timeout delay 100ms");
        return;
      }
      continue;
    }
  }
  
  private void b(xjs paramxjs)
  {
    MediaExtractor localMediaExtractor = paramxjs.jdField_a_of_type_AndroidMediaMediaExtractor;
    MediaCodec localMediaCodec = paramxjs.jdField_a_of_type_AndroidMediaMediaCodec;
    xjp localxjp = paramxjs.jdField_a_of_type_Xjp;
    long[] arrayOfLong1 = paramxjs.jdField_a_of_type_ArrayOfLong;
    long[] arrayOfLong2 = paramxjs.jdField_b_of_type_ArrayOfLong;
    int i1 = paramxjs.c;
    int i2 = paramxjs.d;
    long l1 = localMediaExtractor.getSampleTime();
    ByteBuffer[] arrayOfByteBuffer = localMediaCodec.getInputBuffers();
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    int j = 0;
    int i = 0;
    int k = 0;
    int n;
    int m;
    long l2;
    label237:
    boolean bool;
    for (;;)
    {
      label667:
      label681:
      if ((i == 0) && (i2 < localxjp.d))
      {
        if ((paramxjs.jdField_a_of_type_Long != arrayOfLong1[i2]) && (l1 < arrayOfLong1[i2]))
        {
          Log.e("MediaCodecThumbnailGen", "SeekTo: " + arrayOfLong1[i2]);
          localMediaExtractor.seekTo(arrayOfLong1[i2], 0);
          paramxjs.jdField_a_of_type_Long = arrayOfLong1[i2];
          localMediaCodec.flush();
        }
        n = k;
        m = j;
        l2 = l1;
        if (k == 0)
        {
          m = localMediaCodec.dequeueInputBuffer(-1L);
          if (m < 0) {
            break label453;
          }
          n = localMediaExtractor.readSampleData(arrayOfByteBuffer[m], 0);
          if (n >= 0) {
            break label302;
          }
          localMediaCodec.queueInputBuffer(m, 0, 0, 0L, 4);
          k = 1;
          Log.d("MediaCodecThumbnailGen", "sent input EOS");
          l2 = l1;
          m = j;
          n = k;
        }
        for (;;)
        {
          k = n;
          j = m;
          l1 = l2;
          if (i != 0) {
            break;
          }
          j = localMediaCodec.dequeueOutputBuffer(localBufferInfo, 10000L);
          if (j != -1) {
            break label476;
          }
          Log.d("MediaCodecThumbnailGen", "no output from decoder available");
          k = n;
          j = m;
          l1 = l2;
          break;
          label302:
          if (localMediaExtractor.getSampleTrackIndex() != i1) {
            Log.w("MediaCodecThumbnailGen", "WEIRD: got sample from track " + localMediaExtractor.getSampleTrackIndex() + ", expected " + i1);
          }
          localMediaCodec.queueInputBuffer(m, 0, n, localMediaExtractor.getSampleTime(), 0);
          Log.d("MediaCodecThumbnailGen", "submitted frame " + j + " to dec, size=" + n);
          l1 = localMediaExtractor.getSampleTime();
          Log.d("MediaCodecThumbnailGen", "extractor sample time = " + l1);
          localMediaExtractor.advance();
          j += 1;
          break label237;
          label453:
          Log.d("MediaCodecThumbnailGen", "input buffer not available");
          n = k;
          m = j;
          l2 = l1;
        }
        label476:
        if (j == -3)
        {
          Log.d("MediaCodecThumbnailGen", "decoder output buffers changed");
          k = n;
          j = m;
          l1 = l2;
        }
        else if (j == -2)
        {
          MediaFormat localMediaFormat = localMediaCodec.getOutputFormat();
          Log.d("MediaCodecThumbnailGen", "decoder output format changed: " + localMediaFormat);
          k = n;
          j = m;
          l1 = l2;
        }
        else if (j < 0)
        {
          bhsa.a("unexpected result from decoder.dequeueOutputBuffer: " + j);
          k = n;
          j = m;
          l1 = l2;
        }
        else
        {
          Log.d("MediaCodecThumbnailGen", "surface decoder given buffer " + j + " (size=" + localBufferInfo.size + ")");
          if ((localBufferInfo.flags & 0x4) != 0)
          {
            Log.d("MediaCodecThumbnailGen", "output EOS");
            i = 1;
            if (l2 > arrayOfLong2[i2])
            {
              bool = true;
              localMediaCodec.releaseOutputBuffer(j, bool);
              if (!bool) {
                break label753;
              }
              Log.d("MediaCodecThumbnailGen", "awaiting decode of time: " + l2);
            }
          }
        }
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        obtainMessage(4, paramxjs).sendToTarget();
        return;
        bool = false;
        break label681;
      }
      obtainMessage(3, paramxjs).sendToTarget();
      return;
      label753:
      k = n;
      j = m;
      l1 = l2;
      break;
      break label667;
    }
  }
  
  public String a(int paramInt)
  {
    return String.format(Locale.getDefault(), "thumbnail-%d.jpg", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      a((xjp)paramMessage.obj);
      continue;
      b((xjs)paramMessage.obj);
      continue;
      a((xjs)paramMessage.obj, true);
      continue;
      a((xjs)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xjo
 * JD-Core Version:    0.7.0.1
 */