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
public class zgu
  extends Handler
{
  public zgu(zgt paramzgt, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(zgv paramzgv)
  {
    int i = 0;
    zgy localzgy = new zgy();
    localzgy.jdField_a_of_type_Zgv = paramzgv;
    localzgy.jdField_b_of_type_Long = (bbnj.a(paramzgv.jdField_a_of_type_JavaLangString) * 1000L);
    for (;;)
    {
      MediaExtractor localMediaExtractor;
      int k;
      try
      {
        localObject1 = new File(paramzgv.jdField_a_of_type_JavaLangString);
        if (!((File)localObject1).canRead()) {
          throw new FileNotFoundException("Unable to read " + localObject1);
        }
      }
      catch (Exception paramzgv)
      {
        paramzgv = paramzgv;
        Log.e("MediaCodecThumbnailGen", "startCaptureThumbnails Error!", paramzgv);
        if (!(paramzgv instanceof IllegalArgumentException)) {
          break label548;
        }
        localzgy.jdField_a_of_type_Int = 100;
        yuk.c("MediaCodecThumbnailGen", "Error when generate thumbnail", paramzgv);
        obtainMessage(4, localzgy).sendToTarget();
        return;
        localMediaExtractor = new MediaExtractor();
        localMediaExtractor.setDataSource(((File)localObject1).toString());
        k = zgs.a(localMediaExtractor);
        if (k < 0) {
          throw new RuntimeException("No video track found in " + localObject1);
        }
      }
      finally {}
      localMediaExtractor.selectTrack(k);
      int j = paramzgv.jdField_b_of_type_Int;
      Object localObject1 = new long[paramzgv.d];
      long[] arrayOfLong = new long[paramzgv.d];
      while (i < paramzgv.d)
      {
        localMediaExtractor.seekTo(j * 1000L, 0);
        arrayOfLong[i] = (j * 1000L);
        localObject1[i] = localMediaExtractor.getSampleTime();
        j += paramzgv.c;
        i += 1;
      }
      localMediaExtractor.seekTo(localObject1[0], 0);
      MediaFormat localMediaFormat = localMediaExtractor.getTrackFormat(k);
      boolean bool = localMediaFormat.containsKey("rotation-degrees");
      if (bool) {}
      try
      {
        localzgy.jdField_b_of_type_Int = localMediaFormat.getInteger("rotation-degrees");
        label318:
        i = localMediaFormat.getInteger("height");
        j = localMediaFormat.getInteger("width");
        Log.d("MediaCodecThumbnailGen", "Video size is " + j + "x" + i);
        float f = paramzgv.jdField_a_of_type_Int * 1.0F / Math.max(i, j);
        paramzgv = new zgz((int)(j * f), (int)(i * f));
        Object localObject2 = MediaCodec.createDecoderByType(localMediaFormat.getString("mime"));
        ((MediaCodec)localObject2).configure(localMediaFormat, paramzgv.a(), null, 0);
        ((MediaCodec)localObject2).start();
        localzgy.jdField_a_of_type_AndroidMediaMediaExtractor = localMediaExtractor;
        localzgy.jdField_a_of_type_Zgz = paramzgv;
        localzgy.jdField_a_of_type_AndroidMediaMediaCodec = ((MediaCodec)localObject2);
        localzgy.c = k;
        localzgy.jdField_a_of_type_Int = 0;
        localzgy.d = 0;
        localzgy.jdField_a_of_type_ArrayOfLong = ((long[])localObject1);
        localzgy.jdField_b_of_type_ArrayOfLong = arrayOfLong;
        obtainMessage(2, localzgy).sendToTarget();
        return;
        localObject2 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject2).setDataSource(localzgy.jdField_a_of_type_Zgv.jdField_a_of_type_JavaLangString);
        String str = ((MediaMetadataRetriever)localObject2).extractMetadata(24);
        try
        {
          localzgy.jdField_b_of_type_Int = Integer.parseInt(str);
          label540:
          ((MediaMetadataRetriever)localObject2).release();
          break label318;
          label548:
          if ((paramzgv instanceof RuntimeException))
          {
            localzgy.jdField_a_of_type_Int = 101;
            continue;
          }
          localzgy.jdField_a_of_type_Int = -1;
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
  
  private void a(zgy paramzgy)
  {
    Log.e("MediaCodecThumbnailGen", "finishCapture");
    boolean bool = true;
    if (paramzgy.jdField_a_of_type_Int != 0) {
      bool = false;
    }
    if (paramzgy.jdField_a_of_type_Zgz != null)
    {
      paramzgy.jdField_a_of_type_Zgz.a();
      paramzgy.jdField_a_of_type_Zgz = null;
    }
    if (paramzgy.jdField_a_of_type_AndroidMediaMediaCodec != null)
    {
      paramzgy.jdField_a_of_type_AndroidMediaMediaCodec.stop();
      paramzgy.jdField_a_of_type_AndroidMediaMediaCodec.release();
      paramzgy.jdField_a_of_type_AndroidMediaMediaCodec = null;
    }
    if (paramzgy.jdField_a_of_type_AndroidMediaMediaExtractor != null)
    {
      paramzgy.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      paramzgy.jdField_a_of_type_AndroidMediaMediaExtractor = null;
    }
    zgx localzgx = new zgx();
    localzgx.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(paramzgy.jdField_a_of_type_JavaUtilArrayList);
    localzgx.b = Collections.unmodifiableList(paramzgy.jdField_b_of_type_JavaUtilArrayList);
    localzgx.jdField_a_of_type_Int = paramzgy.jdField_a_of_type_Int;
    this.a.a.post(new MediaCodecThumbnailGenerator.CodecHandler.1(this, paramzgy, bool, localzgx));
  }
  
  private void a(zgy paramzgy, boolean paramBoolean)
  {
    Object localObject1 = paramzgy.jdField_a_of_type_Zgz;
    zgv localzgv = paramzgy.jdField_a_of_type_Zgv;
    int k = paramzgy.d;
    ArrayList localArrayList1 = paramzgy.jdField_a_of_type_JavaUtilArrayList;
    ArrayList localArrayList2 = paramzgy.jdField_b_of_type_JavaUtilArrayList;
    label576:
    label579:
    for (;;)
    {
      try
      {
        ((zgz)localObject1).c();
        ((zgz)localObject1).d();
        ((zgz)localObject1).a(false);
        zgw localzgw = new zgw();
        localObject1 = ((zgz)localObject1).a();
        if (localObject1 == null) {
          break label576;
        }
        int j = paramzgy.jdField_b_of_type_Int;
        int i;
        if ((paramzgy.jdField_b_of_type_Int % 180 <= 0) || (((Bitmap)localObject1).getWidth() >= ((Bitmap)localObject1).getHeight()))
        {
          i = j;
          if (paramzgy.jdField_b_of_type_Int % 180 == 0)
          {
            i = j;
            if (((Bitmap)localObject1).getWidth() <= ((Bitmap)localObject1).getHeight()) {}
          }
        }
        else
        {
          i = j;
          if (localzgv.jdField_a_of_type_Boolean) {
            i = j + 90;
          }
        }
        if (i > 0)
        {
          Object localObject2 = zps.a((Bitmap)localObject1, i);
          ((Bitmap)localObject1).recycle();
          localObject1 = localObject2;
          if (!paramBoolean) {
            break label579;
          }
          localObject2 = new File(localzgv.jdField_b_of_type_JavaLangString, String.format(Locale.getDefault(), a(k), new Object[0]));
          try
          {
            BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream((File)localObject2));
            float f2;
            float f1;
            localObject1 = paramzgy.jdField_b_of_type_ArrayOfLong;
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
              localzgw.jdField_a_of_type_JavaLangString = ((File)localObject2).getAbsolutePath();
              yuk.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() add: " + ((File)localObject2).getPath());
              localzgw.jdField_a_of_type_Int = paramzgy.d;
              localzgw.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
              f2 = 0.0F;
              f1 = f2;
              if (localzgv.jdField_b_of_type_Boolean)
              {
                f1 = f2;
                if (paramzgy.d == 0)
                {
                  f1 = zgt.a(this.a, (Bitmap)localObject1);
                  yuk.c("MediaCodecThumbnailGen", "blackRegionPrecent = " + f1);
                  localzgw.jdField_a_of_type_Long = paramzgy.jdField_b_of_type_ArrayOfLong[paramzgy.d];
                }
              }
              if ((f1 >= 0.9F) && (localzgw.jdField_a_of_type_Long <= 500000L) && (localzgw.jdField_a_of_type_Long + 100000L <= paramzgy.jdField_b_of_type_Long)) {
                continue;
              }
              localArrayList1.add(localzgw.jdField_a_of_type_JavaLangString);
              localArrayList2.add(localObject1);
              this.a.a.post(new MediaCodecThumbnailGenerator.CodecHandler.2(this, paramzgy, localzgw));
              paramzgy.d += 1;
              obtainMessage(2, paramzgy).sendToTarget();
              return;
            }
            catch (IOException localIOException)
            {
              yuk.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() error ", localIOException);
            }
            localObject3 = finally;
            localBufferedOutputStream = null;
            if (localBufferedOutputStream != null) {
              localBufferedOutputStream.close();
            }
          }
          i = paramzgy.d;
          localObject1[i] += 50000L;
          obtainMessage(2, paramzgy).sendToTarget();
          return;
        }
      }
      catch (TimeoutException localTimeoutException)
      {
        sendMessageDelayed(obtainMessage(3, paramzgy), 100L);
        Log.e("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() timeout delay 100ms");
        return;
      }
      continue;
    }
  }
  
  private void b(zgy paramzgy)
  {
    MediaExtractor localMediaExtractor = paramzgy.jdField_a_of_type_AndroidMediaMediaExtractor;
    MediaCodec localMediaCodec = paramzgy.jdField_a_of_type_AndroidMediaMediaCodec;
    zgv localzgv = paramzgy.jdField_a_of_type_Zgv;
    long[] arrayOfLong1 = paramzgy.jdField_a_of_type_ArrayOfLong;
    long[] arrayOfLong2 = paramzgy.jdField_b_of_type_ArrayOfLong;
    int i1 = paramzgy.c;
    int i2 = paramzgy.d;
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
      if ((i == 0) && (i2 < localzgv.d))
      {
        if ((paramzgy.jdField_a_of_type_Long != arrayOfLong1[i2]) && (l1 < arrayOfLong1[i2]))
        {
          Log.e("MediaCodecThumbnailGen", "SeekTo: " + arrayOfLong1[i2]);
          localMediaExtractor.seekTo(arrayOfLong1[i2], 0);
          paramzgy.jdField_a_of_type_Long = arrayOfLong1[i2];
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
          blgo.a("unexpected result from decoder.dequeueOutputBuffer: " + j);
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
        obtainMessage(4, paramzgy).sendToTarget();
        return;
        bool = false;
        break label681;
      }
      obtainMessage(3, paramzgy).sendToTarget();
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
      a((zgv)paramMessage.obj);
      continue;
      b((zgy)paramMessage.obj);
      continue;
      a((zgy)paramMessage.obj, true);
      continue;
      a((zgy)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zgu
 * JD-Core Version:    0.7.0.1
 */