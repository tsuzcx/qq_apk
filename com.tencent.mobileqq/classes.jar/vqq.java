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
public class vqq
  extends Handler
{
  public vqq(vqp paramvqp, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(vqr paramvqr)
  {
    int i = 0;
    vqu localvqu = new vqu();
    localvqu.jdField_a_of_type_Vqr = paramvqr;
    localvqu.jdField_b_of_type_Long = (awaf.a(paramvqr.jdField_a_of_type_JavaLangString) * 1000L);
    for (;;)
    {
      MediaExtractor localMediaExtractor;
      int k;
      try
      {
        localObject1 = new File(paramvqr.jdField_a_of_type_JavaLangString);
        if (!((File)localObject1).canRead()) {
          throw new FileNotFoundException("Unable to read " + localObject1);
        }
      }
      catch (Exception paramvqr)
      {
        paramvqr = paramvqr;
        Log.e("MediaCodecThumbnailGen", "startCaptureThumbnails Error!", paramvqr);
        if (!(paramvqr instanceof IllegalArgumentException)) {
          break label548;
        }
        localvqu.jdField_a_of_type_Int = 100;
        veg.c("MediaCodecThumbnailGen", "Error when generate thumbnail", paramvqr);
        obtainMessage(4, localvqu).sendToTarget();
        return;
        localMediaExtractor = new MediaExtractor();
        localMediaExtractor.setDataSource(((File)localObject1).toString());
        k = vqo.a(localMediaExtractor);
        if (k < 0) {
          throw new RuntimeException("No video track found in " + localObject1);
        }
      }
      finally {}
      localMediaExtractor.selectTrack(k);
      int j = paramvqr.jdField_b_of_type_Int;
      Object localObject1 = new long[paramvqr.d];
      long[] arrayOfLong = new long[paramvqr.d];
      while (i < paramvqr.d)
      {
        localMediaExtractor.seekTo(j * 1000L, 0);
        arrayOfLong[i] = (j * 1000L);
        localObject1[i] = localMediaExtractor.getSampleTime();
        j += paramvqr.c;
        i += 1;
      }
      localMediaExtractor.seekTo(localObject1[0], 0);
      MediaFormat localMediaFormat = localMediaExtractor.getTrackFormat(k);
      boolean bool = localMediaFormat.containsKey("rotation-degrees");
      if (bool) {}
      try
      {
        localvqu.jdField_b_of_type_Int = localMediaFormat.getInteger("rotation-degrees");
        label318:
        i = localMediaFormat.getInteger("height");
        j = localMediaFormat.getInteger("width");
        Log.d("MediaCodecThumbnailGen", "Video size is " + j + "x" + i);
        float f = paramvqr.jdField_a_of_type_Int * 1.0F / Math.max(i, j);
        paramvqr = new vqv((int)(j * f), (int)(i * f));
        Object localObject2 = MediaCodec.createDecoderByType(localMediaFormat.getString("mime"));
        ((MediaCodec)localObject2).configure(localMediaFormat, paramvqr.a(), null, 0);
        ((MediaCodec)localObject2).start();
        localvqu.jdField_a_of_type_AndroidMediaMediaExtractor = localMediaExtractor;
        localvqu.jdField_a_of_type_Vqv = paramvqr;
        localvqu.jdField_a_of_type_AndroidMediaMediaCodec = ((MediaCodec)localObject2);
        localvqu.c = k;
        localvqu.jdField_a_of_type_Int = 0;
        localvqu.d = 0;
        localvqu.jdField_a_of_type_ArrayOfLong = ((long[])localObject1);
        localvqu.jdField_b_of_type_ArrayOfLong = arrayOfLong;
        obtainMessage(2, localvqu).sendToTarget();
        return;
        localObject2 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject2).setDataSource(localvqu.jdField_a_of_type_Vqr.jdField_a_of_type_JavaLangString);
        String str = ((MediaMetadataRetriever)localObject2).extractMetadata(24);
        try
        {
          localvqu.jdField_b_of_type_Int = Integer.parseInt(str);
          label540:
          ((MediaMetadataRetriever)localObject2).release();
          break label318;
          label548:
          if ((paramvqr instanceof RuntimeException))
          {
            localvqu.jdField_a_of_type_Int = 101;
            continue;
          }
          localvqu.jdField_a_of_type_Int = -1;
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
  
  private void a(vqu paramvqu)
  {
    Log.e("MediaCodecThumbnailGen", "finishCapture");
    boolean bool = true;
    if (paramvqu.jdField_a_of_type_Int != 0) {
      bool = false;
    }
    if (paramvqu.jdField_a_of_type_Vqv != null)
    {
      paramvqu.jdField_a_of_type_Vqv.a();
      paramvqu.jdField_a_of_type_Vqv = null;
    }
    if (paramvqu.jdField_a_of_type_AndroidMediaMediaCodec != null)
    {
      paramvqu.jdField_a_of_type_AndroidMediaMediaCodec.stop();
      paramvqu.jdField_a_of_type_AndroidMediaMediaCodec.release();
      paramvqu.jdField_a_of_type_AndroidMediaMediaCodec = null;
    }
    if (paramvqu.jdField_a_of_type_AndroidMediaMediaExtractor != null)
    {
      paramvqu.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      paramvqu.jdField_a_of_type_AndroidMediaMediaExtractor = null;
    }
    vqt localvqt = new vqt();
    localvqt.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(paramvqu.jdField_a_of_type_JavaUtilArrayList);
    localvqt.b = Collections.unmodifiableList(paramvqu.jdField_b_of_type_JavaUtilArrayList);
    localvqt.jdField_a_of_type_Int = paramvqu.jdField_a_of_type_Int;
    this.a.a.post(new MediaCodecThumbnailGenerator.CodecHandler.1(this, paramvqu, bool, localvqt));
  }
  
  private void a(vqu paramvqu, boolean paramBoolean)
  {
    Object localObject1 = paramvqu.jdField_a_of_type_Vqv;
    vqr localvqr = paramvqu.jdField_a_of_type_Vqr;
    int k = paramvqu.d;
    ArrayList localArrayList1 = paramvqu.jdField_a_of_type_JavaUtilArrayList;
    ArrayList localArrayList2 = paramvqu.jdField_b_of_type_JavaUtilArrayList;
    label576:
    label579:
    for (;;)
    {
      try
      {
        ((vqv)localObject1).c();
        ((vqv)localObject1).d();
        ((vqv)localObject1).a(false);
        vqs localvqs = new vqs();
        localObject1 = ((vqv)localObject1).a();
        if (localObject1 == null) {
          break label576;
        }
        int j = paramvqu.jdField_b_of_type_Int;
        int i;
        if ((paramvqu.jdField_b_of_type_Int % 180 <= 0) || (((Bitmap)localObject1).getWidth() >= ((Bitmap)localObject1).getHeight()))
        {
          i = j;
          if (paramvqu.jdField_b_of_type_Int % 180 == 0)
          {
            i = j;
            if (((Bitmap)localObject1).getWidth() <= ((Bitmap)localObject1).getHeight()) {}
          }
        }
        else
        {
          i = j;
          if (localvqr.jdField_a_of_type_Boolean) {
            i = j + 90;
          }
        }
        if (i > 0)
        {
          Object localObject2 = vzo.a((Bitmap)localObject1, i);
          ((Bitmap)localObject1).recycle();
          localObject1 = localObject2;
          if (!paramBoolean) {
            break label579;
          }
          localObject2 = new File(localvqr.jdField_b_of_type_JavaLangString, String.format(Locale.getDefault(), a(k), new Object[0]));
          try
          {
            BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream((File)localObject2));
            float f2;
            float f1;
            localObject1 = paramvqu.jdField_b_of_type_ArrayOfLong;
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
              localvqs.jdField_a_of_type_JavaLangString = ((File)localObject2).getAbsolutePath();
              veg.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() add: " + ((File)localObject2).getPath());
              localvqs.jdField_a_of_type_Int = paramvqu.d;
              localvqs.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
              f2 = 0.0F;
              f1 = f2;
              if (localvqr.jdField_b_of_type_Boolean)
              {
                f1 = f2;
                if (paramvqu.d == 0)
                {
                  f1 = vqp.a(this.a, (Bitmap)localObject1);
                  veg.c("MediaCodecThumbnailGen", "blackRegionPrecent = " + f1);
                  localvqs.jdField_a_of_type_Long = paramvqu.jdField_b_of_type_ArrayOfLong[paramvqu.d];
                }
              }
              if ((f1 >= 0.9F) && (localvqs.jdField_a_of_type_Long <= 500000L) && (localvqs.jdField_a_of_type_Long + 100000L <= paramvqu.jdField_b_of_type_Long)) {
                continue;
              }
              localArrayList1.add(localvqs.jdField_a_of_type_JavaLangString);
              localArrayList2.add(localObject1);
              this.a.a.post(new MediaCodecThumbnailGenerator.CodecHandler.2(this, paramvqu, localvqs));
              paramvqu.d += 1;
              obtainMessage(2, paramvqu).sendToTarget();
              return;
            }
            catch (IOException localIOException)
            {
              veg.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() error ", localIOException);
            }
            localObject3 = finally;
            localBufferedOutputStream = null;
            if (localBufferedOutputStream != null) {
              localBufferedOutputStream.close();
            }
          }
          i = paramvqu.d;
          localObject1[i] += 50000L;
          obtainMessage(2, paramvqu).sendToTarget();
          return;
        }
      }
      catch (TimeoutException localTimeoutException)
      {
        sendMessageDelayed(obtainMessage(3, paramvqu), 100L);
        Log.e("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() timeout delay 100ms");
        return;
      }
      continue;
    }
  }
  
  private void b(vqu paramvqu)
  {
    MediaExtractor localMediaExtractor = paramvqu.jdField_a_of_type_AndroidMediaMediaExtractor;
    MediaCodec localMediaCodec = paramvqu.jdField_a_of_type_AndroidMediaMediaCodec;
    vqr localvqr = paramvqu.jdField_a_of_type_Vqr;
    long[] arrayOfLong1 = paramvqu.jdField_a_of_type_ArrayOfLong;
    long[] arrayOfLong2 = paramvqu.jdField_b_of_type_ArrayOfLong;
    int i1 = paramvqu.c;
    int i2 = paramvqu.d;
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
      if ((i == 0) && (i2 < localvqr.d))
      {
        if ((paramvqu.jdField_a_of_type_Long != arrayOfLong1[i2]) && (l1 < arrayOfLong1[i2]))
        {
          Log.e("MediaCodecThumbnailGen", "SeekTo: " + arrayOfLong1[i2]);
          localMediaExtractor.seekTo(arrayOfLong1[i2], 0);
          paramvqu.jdField_a_of_type_Long = arrayOfLong1[i2];
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
          bfmi.a("unexpected result from decoder.dequeueOutputBuffer: " + j);
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
        obtainMessage(4, paramvqu).sendToTarget();
        return;
        bool = false;
        break label681;
      }
      obtainMessage(3, paramvqu).sendToTarget();
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
      a((vqr)paramMessage.obj);
      continue;
      b((vqu)paramMessage.obj);
      continue;
      a((vqu)paramMessage.obj, true);
      continue;
      a((vqu)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vqq
 * JD-Core Version:    0.7.0.1
 */