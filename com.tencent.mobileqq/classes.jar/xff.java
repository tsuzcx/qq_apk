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
public class xff
  extends Handler
{
  public xff(xfe paramxfe, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(xfg paramxfg)
  {
    int i = 0;
    xfj localxfj = new xfj();
    localxfj.jdField_a_of_type_Xfg = paramxfg;
    localxfj.jdField_b_of_type_Long = (axsg.a(paramxfg.jdField_a_of_type_JavaLangString) * 1000L);
    for (;;)
    {
      MediaExtractor localMediaExtractor;
      int k;
      try
      {
        localObject1 = new File(paramxfg.jdField_a_of_type_JavaLangString);
        if (!((File)localObject1).canRead()) {
          throw new FileNotFoundException("Unable to read " + localObject1);
        }
      }
      catch (Exception paramxfg)
      {
        paramxfg = paramxfg;
        Log.e("MediaCodecThumbnailGen", "startCaptureThumbnails Error!", paramxfg);
        if (!(paramxfg instanceof IllegalArgumentException)) {
          break label548;
        }
        localxfj.jdField_a_of_type_Int = 100;
        wsv.c("MediaCodecThumbnailGen", "Error when generate thumbnail", paramxfg);
        obtainMessage(4, localxfj).sendToTarget();
        return;
        localMediaExtractor = new MediaExtractor();
        localMediaExtractor.setDataSource(((File)localObject1).toString());
        k = xfd.a(localMediaExtractor);
        if (k < 0) {
          throw new RuntimeException("No video track found in " + localObject1);
        }
      }
      finally {}
      localMediaExtractor.selectTrack(k);
      int j = paramxfg.jdField_b_of_type_Int;
      Object localObject1 = new long[paramxfg.d];
      long[] arrayOfLong = new long[paramxfg.d];
      while (i < paramxfg.d)
      {
        localMediaExtractor.seekTo(j * 1000L, 0);
        arrayOfLong[i] = (j * 1000L);
        localObject1[i] = localMediaExtractor.getSampleTime();
        j += paramxfg.c;
        i += 1;
      }
      localMediaExtractor.seekTo(localObject1[0], 0);
      MediaFormat localMediaFormat = localMediaExtractor.getTrackFormat(k);
      boolean bool = localMediaFormat.containsKey("rotation-degrees");
      if (bool) {}
      try
      {
        localxfj.jdField_b_of_type_Int = localMediaFormat.getInteger("rotation-degrees");
        label318:
        i = localMediaFormat.getInteger("height");
        j = localMediaFormat.getInteger("width");
        Log.d("MediaCodecThumbnailGen", "Video size is " + j + "x" + i);
        float f = paramxfg.jdField_a_of_type_Int * 1.0F / Math.max(i, j);
        paramxfg = new xfk((int)(j * f), (int)(i * f));
        Object localObject2 = MediaCodec.createDecoderByType(localMediaFormat.getString("mime"));
        ((MediaCodec)localObject2).configure(localMediaFormat, paramxfg.a(), null, 0);
        ((MediaCodec)localObject2).start();
        localxfj.jdField_a_of_type_AndroidMediaMediaExtractor = localMediaExtractor;
        localxfj.jdField_a_of_type_Xfk = paramxfg;
        localxfj.jdField_a_of_type_AndroidMediaMediaCodec = ((MediaCodec)localObject2);
        localxfj.c = k;
        localxfj.jdField_a_of_type_Int = 0;
        localxfj.d = 0;
        localxfj.jdField_a_of_type_ArrayOfLong = ((long[])localObject1);
        localxfj.jdField_b_of_type_ArrayOfLong = arrayOfLong;
        obtainMessage(2, localxfj).sendToTarget();
        return;
        localObject2 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject2).setDataSource(localxfj.jdField_a_of_type_Xfg.jdField_a_of_type_JavaLangString);
        String str = ((MediaMetadataRetriever)localObject2).extractMetadata(24);
        try
        {
          localxfj.jdField_b_of_type_Int = Integer.parseInt(str);
          label540:
          ((MediaMetadataRetriever)localObject2).release();
          break label318;
          label548:
          if ((paramxfg instanceof RuntimeException))
          {
            localxfj.jdField_a_of_type_Int = 101;
            continue;
          }
          localxfj.jdField_a_of_type_Int = -1;
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
  
  private void a(xfj paramxfj)
  {
    Log.e("MediaCodecThumbnailGen", "finishCapture");
    boolean bool = true;
    if (paramxfj.jdField_a_of_type_Int != 0) {
      bool = false;
    }
    if (paramxfj.jdField_a_of_type_Xfk != null)
    {
      paramxfj.jdField_a_of_type_Xfk.a();
      paramxfj.jdField_a_of_type_Xfk = null;
    }
    if (paramxfj.jdField_a_of_type_AndroidMediaMediaCodec != null)
    {
      paramxfj.jdField_a_of_type_AndroidMediaMediaCodec.stop();
      paramxfj.jdField_a_of_type_AndroidMediaMediaCodec.release();
      paramxfj.jdField_a_of_type_AndroidMediaMediaCodec = null;
    }
    if (paramxfj.jdField_a_of_type_AndroidMediaMediaExtractor != null)
    {
      paramxfj.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      paramxfj.jdField_a_of_type_AndroidMediaMediaExtractor = null;
    }
    xfi localxfi = new xfi();
    localxfi.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(paramxfj.jdField_a_of_type_JavaUtilArrayList);
    localxfi.b = Collections.unmodifiableList(paramxfj.jdField_b_of_type_JavaUtilArrayList);
    localxfi.jdField_a_of_type_Int = paramxfj.jdField_a_of_type_Int;
    this.a.a.post(new MediaCodecThumbnailGenerator.CodecHandler.1(this, paramxfj, bool, localxfi));
  }
  
  private void a(xfj paramxfj, boolean paramBoolean)
  {
    Object localObject1 = paramxfj.jdField_a_of_type_Xfk;
    xfg localxfg = paramxfj.jdField_a_of_type_Xfg;
    int k = paramxfj.d;
    ArrayList localArrayList1 = paramxfj.jdField_a_of_type_JavaUtilArrayList;
    ArrayList localArrayList2 = paramxfj.jdField_b_of_type_JavaUtilArrayList;
    label576:
    label579:
    for (;;)
    {
      try
      {
        ((xfk)localObject1).c();
        ((xfk)localObject1).d();
        ((xfk)localObject1).a(false);
        xfh localxfh = new xfh();
        localObject1 = ((xfk)localObject1).a();
        if (localObject1 == null) {
          break label576;
        }
        int j = paramxfj.jdField_b_of_type_Int;
        int i;
        if ((paramxfj.jdField_b_of_type_Int % 180 <= 0) || (((Bitmap)localObject1).getWidth() >= ((Bitmap)localObject1).getHeight()))
        {
          i = j;
          if (paramxfj.jdField_b_of_type_Int % 180 == 0)
          {
            i = j;
            if (((Bitmap)localObject1).getWidth() <= ((Bitmap)localObject1).getHeight()) {}
          }
        }
        else
        {
          i = j;
          if (localxfg.jdField_a_of_type_Boolean) {
            i = j + 90;
          }
        }
        if (i > 0)
        {
          Object localObject2 = xod.a((Bitmap)localObject1, i);
          ((Bitmap)localObject1).recycle();
          localObject1 = localObject2;
          if (!paramBoolean) {
            break label579;
          }
          localObject2 = new File(localxfg.jdField_b_of_type_JavaLangString, String.format(Locale.getDefault(), a(k), new Object[0]));
          try
          {
            BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream((File)localObject2));
            float f2;
            float f1;
            localObject1 = paramxfj.jdField_b_of_type_ArrayOfLong;
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
              localxfh.jdField_a_of_type_JavaLangString = ((File)localObject2).getAbsolutePath();
              wsv.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() add: " + ((File)localObject2).getPath());
              localxfh.jdField_a_of_type_Int = paramxfj.d;
              localxfh.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
              f2 = 0.0F;
              f1 = f2;
              if (localxfg.jdField_b_of_type_Boolean)
              {
                f1 = f2;
                if (paramxfj.d == 0)
                {
                  f1 = xfe.a(this.a, (Bitmap)localObject1);
                  wsv.c("MediaCodecThumbnailGen", "blackRegionPrecent = " + f1);
                  localxfh.jdField_a_of_type_Long = paramxfj.jdField_b_of_type_ArrayOfLong[paramxfj.d];
                }
              }
              if ((f1 >= 0.9F) && (localxfh.jdField_a_of_type_Long <= 500000L) && (localxfh.jdField_a_of_type_Long + 100000L <= paramxfj.jdField_b_of_type_Long)) {
                continue;
              }
              localArrayList1.add(localxfh.jdField_a_of_type_JavaLangString);
              localArrayList2.add(localObject1);
              this.a.a.post(new MediaCodecThumbnailGenerator.CodecHandler.2(this, paramxfj, localxfh));
              paramxfj.d += 1;
              obtainMessage(2, paramxfj).sendToTarget();
              return;
            }
            catch (IOException localIOException)
            {
              wsv.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() error ", localIOException);
            }
            localObject3 = finally;
            localBufferedOutputStream = null;
            if (localBufferedOutputStream != null) {
              localBufferedOutputStream.close();
            }
          }
          i = paramxfj.d;
          localObject1[i] += 50000L;
          obtainMessage(2, paramxfj).sendToTarget();
          return;
        }
      }
      catch (TimeoutException localTimeoutException)
      {
        sendMessageDelayed(obtainMessage(3, paramxfj), 100L);
        Log.e("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() timeout delay 100ms");
        return;
      }
      continue;
    }
  }
  
  private void b(xfj paramxfj)
  {
    MediaExtractor localMediaExtractor = paramxfj.jdField_a_of_type_AndroidMediaMediaExtractor;
    MediaCodec localMediaCodec = paramxfj.jdField_a_of_type_AndroidMediaMediaCodec;
    xfg localxfg = paramxfj.jdField_a_of_type_Xfg;
    long[] arrayOfLong1 = paramxfj.jdField_a_of_type_ArrayOfLong;
    long[] arrayOfLong2 = paramxfj.jdField_b_of_type_ArrayOfLong;
    int i1 = paramxfj.c;
    int i2 = paramxfj.d;
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
      if ((i == 0) && (i2 < localxfg.d))
      {
        if ((paramxfj.jdField_a_of_type_Long != arrayOfLong1[i2]) && (l1 < arrayOfLong1[i2]))
        {
          Log.e("MediaCodecThumbnailGen", "SeekTo: " + arrayOfLong1[i2]);
          localMediaExtractor.seekTo(arrayOfLong1[i2], 0);
          paramxfj.jdField_a_of_type_Long = arrayOfLong1[i2];
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
          bhnt.a("unexpected result from decoder.dequeueOutputBuffer: " + j);
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
        obtainMessage(4, paramxfj).sendToTarget();
        return;
        bool = false;
        break label681;
      }
      obtainMessage(3, paramxfj).sendToTarget();
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
      a((xfg)paramMessage.obj);
      continue;
      b((xfj)paramMessage.obj);
      continue;
      a((xfj)paramMessage.obj, true);
      continue;
      a((xfj)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xff
 * JD-Core Version:    0.7.0.1
 */