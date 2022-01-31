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
public class vqn
  extends Handler
{
  public vqn(vqm paramvqm, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(vqo paramvqo)
  {
    int i = 0;
    vqr localvqr = new vqr();
    localvqr.jdField_a_of_type_Vqo = paramvqo;
    localvqr.jdField_b_of_type_Long = (awah.a(paramvqo.jdField_a_of_type_JavaLangString) * 1000L);
    for (;;)
    {
      MediaExtractor localMediaExtractor;
      int k;
      try
      {
        localObject1 = new File(paramvqo.jdField_a_of_type_JavaLangString);
        if (!((File)localObject1).canRead()) {
          throw new FileNotFoundException("Unable to read " + localObject1);
        }
      }
      catch (Exception paramvqo)
      {
        paramvqo = paramvqo;
        Log.e("MediaCodecThumbnailGen", "startCaptureThumbnails Error!", paramvqo);
        if (!(paramvqo instanceof IllegalArgumentException)) {
          break label548;
        }
        localvqr.jdField_a_of_type_Int = 100;
        ved.c("MediaCodecThumbnailGen", "Error when generate thumbnail", paramvqo);
        obtainMessage(4, localvqr).sendToTarget();
        return;
        localMediaExtractor = new MediaExtractor();
        localMediaExtractor.setDataSource(((File)localObject1).toString());
        k = vql.a(localMediaExtractor);
        if (k < 0) {
          throw new RuntimeException("No video track found in " + localObject1);
        }
      }
      finally {}
      localMediaExtractor.selectTrack(k);
      int j = paramvqo.jdField_b_of_type_Int;
      Object localObject1 = new long[paramvqo.d];
      long[] arrayOfLong = new long[paramvqo.d];
      while (i < paramvqo.d)
      {
        localMediaExtractor.seekTo(j * 1000L, 0);
        arrayOfLong[i] = (j * 1000L);
        localObject1[i] = localMediaExtractor.getSampleTime();
        j += paramvqo.c;
        i += 1;
      }
      localMediaExtractor.seekTo(localObject1[0], 0);
      MediaFormat localMediaFormat = localMediaExtractor.getTrackFormat(k);
      boolean bool = localMediaFormat.containsKey("rotation-degrees");
      if (bool) {}
      try
      {
        localvqr.jdField_b_of_type_Int = localMediaFormat.getInteger("rotation-degrees");
        label318:
        i = localMediaFormat.getInteger("height");
        j = localMediaFormat.getInteger("width");
        Log.d("MediaCodecThumbnailGen", "Video size is " + j + "x" + i);
        float f = paramvqo.jdField_a_of_type_Int * 1.0F / Math.max(i, j);
        paramvqo = new vqs((int)(j * f), (int)(i * f));
        Object localObject2 = MediaCodec.createDecoderByType(localMediaFormat.getString("mime"));
        ((MediaCodec)localObject2).configure(localMediaFormat, paramvqo.a(), null, 0);
        ((MediaCodec)localObject2).start();
        localvqr.jdField_a_of_type_AndroidMediaMediaExtractor = localMediaExtractor;
        localvqr.jdField_a_of_type_Vqs = paramvqo;
        localvqr.jdField_a_of_type_AndroidMediaMediaCodec = ((MediaCodec)localObject2);
        localvqr.c = k;
        localvqr.jdField_a_of_type_Int = 0;
        localvqr.d = 0;
        localvqr.jdField_a_of_type_ArrayOfLong = ((long[])localObject1);
        localvqr.jdField_b_of_type_ArrayOfLong = arrayOfLong;
        obtainMessage(2, localvqr).sendToTarget();
        return;
        localObject2 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject2).setDataSource(localvqr.jdField_a_of_type_Vqo.jdField_a_of_type_JavaLangString);
        String str = ((MediaMetadataRetriever)localObject2).extractMetadata(24);
        try
        {
          localvqr.jdField_b_of_type_Int = Integer.parseInt(str);
          label540:
          ((MediaMetadataRetriever)localObject2).release();
          break label318;
          label548:
          if ((paramvqo instanceof RuntimeException))
          {
            localvqr.jdField_a_of_type_Int = 101;
            continue;
          }
          localvqr.jdField_a_of_type_Int = -1;
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
  
  private void a(vqr paramvqr)
  {
    Log.e("MediaCodecThumbnailGen", "finishCapture");
    boolean bool = true;
    if (paramvqr.jdField_a_of_type_Int != 0) {
      bool = false;
    }
    if (paramvqr.jdField_a_of_type_Vqs != null)
    {
      paramvqr.jdField_a_of_type_Vqs.a();
      paramvqr.jdField_a_of_type_Vqs = null;
    }
    if (paramvqr.jdField_a_of_type_AndroidMediaMediaCodec != null)
    {
      paramvqr.jdField_a_of_type_AndroidMediaMediaCodec.stop();
      paramvqr.jdField_a_of_type_AndroidMediaMediaCodec.release();
      paramvqr.jdField_a_of_type_AndroidMediaMediaCodec = null;
    }
    if (paramvqr.jdField_a_of_type_AndroidMediaMediaExtractor != null)
    {
      paramvqr.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      paramvqr.jdField_a_of_type_AndroidMediaMediaExtractor = null;
    }
    vqq localvqq = new vqq();
    localvqq.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(paramvqr.jdField_a_of_type_JavaUtilArrayList);
    localvqq.b = Collections.unmodifiableList(paramvqr.jdField_b_of_type_JavaUtilArrayList);
    localvqq.jdField_a_of_type_Int = paramvqr.jdField_a_of_type_Int;
    this.a.a.post(new MediaCodecThumbnailGenerator.CodecHandler.1(this, paramvqr, bool, localvqq));
  }
  
  private void a(vqr paramvqr, boolean paramBoolean)
  {
    Object localObject1 = paramvqr.jdField_a_of_type_Vqs;
    vqo localvqo = paramvqr.jdField_a_of_type_Vqo;
    int k = paramvqr.d;
    ArrayList localArrayList1 = paramvqr.jdField_a_of_type_JavaUtilArrayList;
    ArrayList localArrayList2 = paramvqr.jdField_b_of_type_JavaUtilArrayList;
    label576:
    label579:
    for (;;)
    {
      try
      {
        ((vqs)localObject1).c();
        ((vqs)localObject1).d();
        ((vqs)localObject1).a(false);
        vqp localvqp = new vqp();
        localObject1 = ((vqs)localObject1).a();
        if (localObject1 == null) {
          break label576;
        }
        int j = paramvqr.jdField_b_of_type_Int;
        int i;
        if ((paramvqr.jdField_b_of_type_Int % 180 <= 0) || (((Bitmap)localObject1).getWidth() >= ((Bitmap)localObject1).getHeight()))
        {
          i = j;
          if (paramvqr.jdField_b_of_type_Int % 180 == 0)
          {
            i = j;
            if (((Bitmap)localObject1).getWidth() <= ((Bitmap)localObject1).getHeight()) {}
          }
        }
        else
        {
          i = j;
          if (localvqo.jdField_a_of_type_Boolean) {
            i = j + 90;
          }
        }
        if (i > 0)
        {
          Object localObject2 = vzl.a((Bitmap)localObject1, i);
          ((Bitmap)localObject1).recycle();
          localObject1 = localObject2;
          if (!paramBoolean) {
            break label579;
          }
          localObject2 = new File(localvqo.jdField_b_of_type_JavaLangString, String.format(Locale.getDefault(), a(k), new Object[0]));
          try
          {
            BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream((File)localObject2));
            float f2;
            float f1;
            localObject1 = paramvqr.jdField_b_of_type_ArrayOfLong;
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
              localvqp.jdField_a_of_type_JavaLangString = ((File)localObject2).getAbsolutePath();
              ved.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() add: " + ((File)localObject2).getPath());
              localvqp.jdField_a_of_type_Int = paramvqr.d;
              localvqp.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
              f2 = 0.0F;
              f1 = f2;
              if (localvqo.jdField_b_of_type_Boolean)
              {
                f1 = f2;
                if (paramvqr.d == 0)
                {
                  f1 = vqm.a(this.a, (Bitmap)localObject1);
                  ved.c("MediaCodecThumbnailGen", "blackRegionPrecent = " + f1);
                  localvqp.jdField_a_of_type_Long = paramvqr.jdField_b_of_type_ArrayOfLong[paramvqr.d];
                }
              }
              if ((f1 >= 0.9F) && (localvqp.jdField_a_of_type_Long <= 500000L) && (localvqp.jdField_a_of_type_Long + 100000L <= paramvqr.jdField_b_of_type_Long)) {
                continue;
              }
              localArrayList1.add(localvqp.jdField_a_of_type_JavaLangString);
              localArrayList2.add(localObject1);
              this.a.a.post(new MediaCodecThumbnailGenerator.CodecHandler.2(this, paramvqr, localvqp));
              paramvqr.d += 1;
              obtainMessage(2, paramvqr).sendToTarget();
              return;
            }
            catch (IOException localIOException)
            {
              ved.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() error ", localIOException);
            }
            localObject3 = finally;
            localBufferedOutputStream = null;
            if (localBufferedOutputStream != null) {
              localBufferedOutputStream.close();
            }
          }
          i = paramvqr.d;
          localObject1[i] += 50000L;
          obtainMessage(2, paramvqr).sendToTarget();
          return;
        }
      }
      catch (TimeoutException localTimeoutException)
      {
        sendMessageDelayed(obtainMessage(3, paramvqr), 100L);
        Log.e("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() timeout delay 100ms");
        return;
      }
      continue;
    }
  }
  
  private void b(vqr paramvqr)
  {
    MediaExtractor localMediaExtractor = paramvqr.jdField_a_of_type_AndroidMediaMediaExtractor;
    MediaCodec localMediaCodec = paramvqr.jdField_a_of_type_AndroidMediaMediaCodec;
    vqo localvqo = paramvqr.jdField_a_of_type_Vqo;
    long[] arrayOfLong1 = paramvqr.jdField_a_of_type_ArrayOfLong;
    long[] arrayOfLong2 = paramvqr.jdField_b_of_type_ArrayOfLong;
    int i1 = paramvqr.c;
    int i2 = paramvqr.d;
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
      if ((i == 0) && (i2 < localvqo.d))
      {
        if ((paramvqr.jdField_a_of_type_Long != arrayOfLong1[i2]) && (l1 < arrayOfLong1[i2]))
        {
          Log.e("MediaCodecThumbnailGen", "SeekTo: " + arrayOfLong1[i2]);
          localMediaExtractor.seekTo(arrayOfLong1[i2], 0);
          paramvqr.jdField_a_of_type_Long = arrayOfLong1[i2];
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
          bfmz.a("unexpected result from decoder.dequeueOutputBuffer: " + j);
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
        obtainMessage(4, paramvqr).sendToTarget();
        return;
        bool = false;
        break label681;
      }
      obtainMessage(3, paramvqr).sendToTarget();
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
      a((vqo)paramMessage.obj);
      continue;
      b((vqr)paramMessage.obj);
      continue;
      a((vqr)paramMessage.obj, true);
      continue;
      a((vqr)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vqn
 * JD-Core Version:    0.7.0.1
 */