import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.localmedia.demos.MediaCodecThumbnailGenerator.CodecHandler.1;
import dov.com.tencent.biz.qqstory.takevideo.localmedia.demos.MediaCodecThumbnailGenerator.CodecHandler.2;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeoutException;

public class aypl
{
  public aypl.a a;
  private long aCY;
  public Handler mMainThreadHandler;
  public HandlerThread mThread = new HandlerThread("MediaCodecThumbnailGenerator");
  
  public static float a(Bitmap paramBitmap)
  {
    int i1 = paramBitmap.getHeight() / 16;
    int i2 = paramBitmap.getWidth() / 9;
    int k = 0;
    int i = 0;
    int j = 0;
    while (k < paramBitmap.getHeight())
    {
      int m = 0;
      if (m < paramBitmap.getWidth())
      {
        int n = paramBitmap.getPixel(m, k);
        if (((n >> 16 & 0xFF) < 10) && ((n >> 8 & 0xFF) < 10) && ((n & 0xFF) < 10))
        {
          n = j + 1;
          j = i;
        }
        for (i = n;; i = n)
        {
          n = m + i2;
          m = i;
          i = j;
          j = m;
          m = n;
          break;
          n = j;
          j = i + 1;
        }
      }
      k += i1;
    }
    float f = j / (i + j);
    ram.i("MediaCodecThumbnailGen", "whitePixelCount = " + i + " blackPixelCount = " + j);
    return f;
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2, aypj.a<Boolean, aypl.d> parama, aypj.a<Boolean, aypl.c> parama1)
  {
    aypl.b localb = new aypl.b();
    localb.path = paramString1;
    localb.aAK = paramString2;
    localb.aGM = paramBoolean1;
    localb.maxSize = paramInt1;
    localb.startTime = paramInt2;
    localb.interval = paramInt3;
    localb.count = paramInt4;
    localb.aIs = paramBoolean2;
    localb.b = parama;
    localb.a = parama1;
    this.aCY = System.currentTimeMillis();
    Message.obtain(this.a, 1, localb).sendToTarget();
  }
  
  public void b(Looper paramLooper)
  {
    this.mThread.start();
    this.a = new aypl.a(this.mThread.getLooper());
    Looper localLooper = paramLooper;
    if (paramLooper == null) {
      localLooper = Looper.myLooper();
    }
    this.mMainThreadHandler = new Handler(localLooper);
  }
  
  public void unInit()
  {
    this.mThread.quit();
  }
  
  @TargetApi(16)
  public class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    private void a(aypl.b paramb)
    {
      int i = 0;
      aypl.e locale = new aypl.e();
      locale.jdField_a_of_type_Aypl$b = paramb;
      locale.videoDuration = (ayzc.at(paramb.path) * 1000L);
      for (;;)
      {
        MediaExtractor localMediaExtractor;
        int k;
        try
        {
          localObject1 = new File(paramb.path);
          if (!((File)localObject1).canRead()) {
            throw new FileNotFoundException("Unable to read " + localObject1);
          }
        }
        catch (Exception paramb)
        {
          paramb = paramb;
          Log.e("MediaCodecThumbnailGen", "startCaptureThumbnails Error!", paramb);
          if (!(paramb instanceof IllegalArgumentException)) {
            break label548;
          }
          locale.errorCode = 100;
          ram.e("MediaCodecThumbnailGen", "Error when generate thumbnail", paramb);
          obtainMessage(4, locale).sendToTarget();
          return;
          localMediaExtractor = new MediaExtractor();
          localMediaExtractor.setDataSource(((File)localObject1).toString());
          k = aypk.a(localMediaExtractor);
          if (k < 0) {
            throw new RuntimeException("No video track found in " + localObject1);
          }
        }
        finally {}
        localMediaExtractor.selectTrack(k);
        int j = paramb.startTime;
        Object localObject1 = new long[paramb.count];
        long[] arrayOfLong = new long[paramb.count];
        while (i < paramb.count)
        {
          localMediaExtractor.seekTo(j * 1000L, 0);
          arrayOfLong[i] = (j * 1000L);
          localObject1[i] = localMediaExtractor.getSampleTime();
          j += paramb.interval;
          i += 1;
        }
        localMediaExtractor.seekTo(localObject1[0], 0);
        MediaFormat localMediaFormat = localMediaExtractor.getTrackFormat(k);
        boolean bool = localMediaFormat.containsKey("rotation-degrees");
        if (bool) {}
        try
        {
          locale.rotation = localMediaFormat.getInteger("rotation-degrees");
          label318:
          i = localMediaFormat.getInteger("height");
          j = localMediaFormat.getInteger("width");
          Log.d("MediaCodecThumbnailGen", "Video size is " + j + "x" + i);
          float f = paramb.maxSize * 1.0F / Math.max(i, j);
          paramb = new aypm((int)(j * f), (int)(i * f));
          Object localObject2 = MediaCodec.createDecoderByType(localMediaFormat.getString("mime"));
          ((MediaCodec)localObject2).configure(localMediaFormat, paramb.getSurface(), null, 0);
          ((MediaCodec)localObject2).start();
          locale.extractor = localMediaExtractor;
          locale.jdField_a_of_type_Aypm = paramb;
          locale.decoder = ((MediaCodec)localObject2);
          locale.trackIndex = k;
          locale.errorCode = 0;
          locale.bst = 0;
          locale.Q = ((long[])localObject1);
          locale.R = arrayOfLong;
          obtainMessage(2, locale).sendToTarget();
          return;
          localObject2 = new MediaMetadataRetriever();
          ((MediaMetadataRetriever)localObject2).setDataSource(locale.jdField_a_of_type_Aypl$b.path);
          String str = ((MediaMetadataRetriever)localObject2).extractMetadata(24);
          try
          {
            locale.rotation = Integer.parseInt(str);
            label540:
            ((MediaMetadataRetriever)localObject2).release();
            break label318;
            label548:
            if ((paramb instanceof RuntimeException))
            {
              locale.errorCode = 101;
              continue;
            }
            locale.errorCode = -1;
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
    
    private void a(aypl.e parame)
    {
      boolean bool2 = true;
      Log.e("MediaCodecThumbnailGen", "finishCapture");
      if (parame.errorCode != 0) {}
      for (boolean bool1 = false;; bool1 = true)
      {
        if (parame.jdField_a_of_type_Aypm != null)
        {
          parame.jdField_a_of_type_Aypm.release();
          parame.jdField_a_of_type_Aypm = null;
        }
        if (parame.decoder != null)
        {
          parame.decoder.stop();
          parame.decoder.release();
          parame.decoder = null;
        }
        if (parame.extractor != null)
        {
          parame.extractor.release();
          parame.extractor = null;
        }
        aypl.d locald = new aypl.d();
        locald.oV = Collections.unmodifiableList(parame.nz);
        locald.bitmaps = Collections.unmodifiableList(parame.nA);
        locald.errorCode = parame.errorCode;
        if (bool1) {
          if (parame.dAl) {
            break label222;
          }
        }
        for (;;)
        {
          locald.dAk = bool2;
          ram.i("MediaCodecThumbnailGen", "hasBlackThumbnail = " + locald.dAk);
          rar.a("actBlackThumbnailVideo", locald.dAk, System.currentTimeMillis() - aypl.a(aypl.this), new String[0]);
          aypl.this.mMainThreadHandler.post(new MediaCodecThumbnailGenerator.CodecHandler.1(this, parame, bool1, locald));
          return;
          label222:
          bool2 = false;
        }
      }
    }
    
    private void a(aypl.e parame, boolean paramBoolean)
    {
      Object localObject1 = parame.jdField_a_of_type_Aypm;
      aypl.b localb = parame.jdField_a_of_type_Aypl$b;
      int k = parame.bst;
      ArrayList localArrayList1 = parame.nz;
      ArrayList localArrayList2 = parame.nA;
      for (;;)
      {
        int j;
        try
        {
          ((aypm)localObject1).awaitNewImage();
          ((aypm)localObject1).XT();
          ((aypm)localObject1).tQ(false);
          aypl.c localc = new aypl.c();
          localObject1 = ((aypm)localObject1).K();
          if (localObject1 == null) {
            break label590;
          }
          j = parame.rotation;
          if ((parame.rotation % 180 > 0) && (((Bitmap)localObject1).getWidth() < ((Bitmap)localObject1).getHeight())) {
            break label593;
          }
          i = j;
          if (parame.rotation % 180 == 0)
          {
            i = j;
            if (((Bitmap)localObject1).getWidth() > ((Bitmap)localObject1).getHeight()) {
              break label593;
            }
          }
          if (i > 0)
          {
            Object localObject2 = rpq.rotateBitmap((Bitmap)localObject1, i);
            ((Bitmap)localObject1).recycle();
            localObject1 = localObject2;
            localArrayList2.add(localObject1);
            if (!paramBoolean) {
              break label603;
            }
            localObject2 = new File(localb.aAK, String.format(Locale.getDefault(), cd(k), new Object[0]));
            try
            {
              BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream((File)localObject2));
              float f2;
              float f1;
              localObject1 = parame.R;
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
                localArrayList1.add(((File)localObject2).getAbsolutePath());
                localc.thumbnailPath = ((File)localObject2).getAbsolutePath();
                ram.i("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() add: " + ((File)localObject2).getPath());
                localc.index = parame.bst;
                localc.thumbnail = ((Bitmap)localObject1);
                f2 = 0.0F;
                f1 = f2;
                if (localb.aIs)
                {
                  f1 = f2;
                  if (parame.bst == 0)
                  {
                    f1 = aypl.a((Bitmap)localObject1);
                    ram.i("MediaCodecThumbnailGen", "blackRegionPrecent = " + f1);
                    localc.Ce = parame.R[parame.bst];
                  }
                }
                if ((f1 >= 0.9F) && (localc.Ce <= 500000L) && (localc.Ce + 100000L <= parame.videoDuration)) {
                  continue;
                }
                localArrayList1.add(localc.thumbnailPath);
                localArrayList2.add(localObject1);
                if (f1 >= 0.9F) {
                  break label606;
                }
                paramBoolean = true;
                parame.dAl = paramBoolean;
                aypl.this.mMainThreadHandler.post(new MediaCodecThumbnailGenerator.CodecHandler.2(this, parame, localc));
                parame.bst += 1;
                obtainMessage(2, parame).sendToTarget();
                return;
              }
              catch (IOException localIOException)
              {
                ram.e("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() error ", localIOException);
              }
              localObject3 = finally;
              localBufferedOutputStream = null;
              if (localBufferedOutputStream != null) {
                localBufferedOutputStream.close();
              }
            }
            i = parame.bst;
            localObject1[i] += 50000L;
            obtainMessage(2, parame).sendToTarget();
            return;
          }
        }
        catch (TimeoutException localTimeoutException)
        {
          sendMessageDelayed(obtainMessage(3, parame), 100L);
          Log.e("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() timeout delay 100ms");
          return;
        }
        continue;
        label590:
        continue;
        label593:
        int i = j + 90;
        continue;
        label603:
        continue;
        label606:
        paramBoolean = false;
      }
    }
    
    private void b(aypl.e parame)
    {
      MediaCodec localMediaCodec;
      long[] arrayOfLong2;
      int i2;
      long l1;
      MediaCodec.BufferInfo localBufferInfo;
      int j;
      int i;
      int k;
      int m;
      int n;
      long l2;
      try
      {
        MediaExtractor localMediaExtractor = parame.extractor;
        localMediaCodec = parame.decoder;
        aypl.b localb = parame.jdField_a_of_type_Aypl$b;
        long[] arrayOfLong1 = parame.Q;
        arrayOfLong2 = parame.R;
        int i1 = parame.trackIndex;
        i2 = parame.bst;
        l1 = localMediaExtractor.getSampleTime();
        ByteBuffer[] arrayOfByteBuffer = localMediaCodec.getInputBuffers();
        localBufferInfo = new MediaCodec.BufferInfo();
        j = 0;
        i = 0;
        k = 0;
        if ((i != 0) || (i2 >= localb.count)) {
          break label724;
        }
        if ((parame.Cf != arrayOfLong1[i2]) && (l1 < arrayOfLong1[i2]))
        {
          Log.e("MediaCodecThumbnailGen", "SeekTo: " + arrayOfLong1[i2]);
          localMediaExtractor.seekTo(arrayOfLong1[i2], 0);
          parame.Cf = arrayOfLong1[i2];
          localMediaCodec.flush();
        }
        m = k;
        n = j;
        l2 = l1;
        if (k == 0)
        {
          m = localMediaCodec.dequeueInputBuffer(-1L);
          if (m < 0) {
            break label448;
          }
          n = localMediaExtractor.readSampleData(arrayOfByteBuffer[m], 0);
          if (n >= 0) {
            break label289;
          }
          localMediaCodec.queueInputBuffer(m, 0, 0, 0L, 4);
          m = 1;
          Log.d("MediaCodecThumbnailGen", "sent input EOS");
          k = j;
          j = m;
          break label729;
        }
        for (;;)
        {
          label246:
          k = m;
          j = n;
          l1 = l2;
          if (i != 0) {
            break;
          }
          j = localMediaCodec.dequeueOutputBuffer(localBufferInfo, 10000L);
          if (j != -1) {
            break label494;
          }
          Log.d("MediaCodecThumbnailGen", "no output from decoder available");
          break label743;
          label289:
          if (localMediaExtractor.getSampleTrackIndex() != i1) {
            Log.w("MediaCodecThumbnailGen", "WEIRD: got sample from track " + localMediaExtractor.getSampleTrackIndex() + ", expected " + i1);
          }
          localMediaCodec.queueInputBuffer(m, 0, n, localMediaExtractor.getSampleTime(), 0);
          Log.d("MediaCodecThumbnailGen", "submitted frame " + j + " to dec, size=" + n);
          l1 = localMediaExtractor.getSampleTime();
          Log.d("MediaCodecThumbnailGen", "extractor sample time = " + l1);
          localMediaExtractor.advance();
          m = j + 1;
          j = k;
          k = m;
          break label729;
          label448:
          Log.d("MediaCodecThumbnailGen", "input buffer not available");
          m = k;
          n = j;
          l2 = l1;
        }
        if (j != -3) {
          break label512;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        QLog.e("MediaCodecThumbnailGen", 1, "decodeThumbnails fail", localIllegalStateException);
        obtainMessage(4, parame).sendToTarget();
        return;
      }
      label494:
      Log.d("MediaCodecThumbnailGen", "decoder output buffers changed");
      break label743;
      label512:
      if (j == -2)
      {
        MediaFormat localMediaFormat = localMediaCodec.getOutputFormat();
        Log.d("MediaCodecThumbnailGen", "decoder output format changed: " + localMediaFormat);
      }
      else if (j < 0)
      {
        auqu.fail("unexpected result from decoder.dequeueOutputBuffer: " + j);
      }
      else
      {
        Log.d("MediaCodecThumbnailGen", "surface decoder given buffer " + j + " (size=" + localBufferInfo.size + ")");
        if ((localBufferInfo.flags & 0x4) != 0)
        {
          Log.d("MediaCodecThumbnailGen", "output EOS");
          i = 1;
          break label757;
        }
      }
      for (;;)
      {
        boolean bool;
        localMediaCodec.releaseOutputBuffer(j, bool);
        if (bool)
        {
          Log.d("MediaCodecThumbnailGen", "awaiting decode of time: " + l2);
          label724:
          for (i = 1;; i = 0)
          {
            if (i == 0)
            {
              obtainMessage(4, parame).sendToTarget();
              return;
            }
            obtainMessage(3, parame).sendToTarget();
            return;
            break;
          }
          label729:
          m = j;
          n = k;
          l2 = l1;
          break label246;
        }
        label743:
        k = m;
        j = n;
        l1 = l2;
        break;
        label757:
        if (l2 > arrayOfLong2[i2]) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
    
    public String cd(int paramInt)
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
        Object localObject = (aypl.b)paramMessage.obj;
        ram.i("MediaCodecThumbnailGen", "startCaptureThumbnails");
        a((aypl.b)localObject);
        continue;
        localObject = (aypl.e)paramMessage.obj;
        ram.i("MediaCodecThumbnailGen", "decodeThumbnails");
        b((aypl.e)localObject);
        continue;
        localObject = (aypl.e)paramMessage.obj;
        ram.i("MediaCodecThumbnailGen", "dumpThumbnailSurfaces");
        a((aypl.e)localObject, false);
        continue;
        localObject = (aypl.e)paramMessage.obj;
        ram.i("MediaCodecThumbnailGen", "finishCapture");
        a((aypl.e)localObject);
      }
    }
  }
  
  public static class b
  {
    public aypj.a<Boolean, aypl.c> a;
    public String aAK;
    public boolean aGM;
    public boolean aIs;
    public aypj.a<Boolean, aypl.d> b;
    public int count;
    public int interval;
    public int maxSize;
    public String path;
    public int startTime;
  }
  
  public static class c
  {
    public long Ce = -1L;
    public int index;
    public Bitmap thumbnail;
    public String thumbnailPath;
  }
  
  public static class d
  {
    public List<Bitmap> bitmaps;
    public boolean dAk;
    public int errorCode;
    public List<String> oV;
  }
  
  public static class e
  {
    public long Cf;
    public long[] Q;
    public long[] R;
    public aypl.b a;
    public aypm a;
    public int bst;
    public boolean dAl;
    public MediaCodec decoder;
    public int errorCode;
    public MediaExtractor extractor;
    public ArrayList<Bitmap> nA = new ArrayList();
    public ArrayList<String> nz = new ArrayList();
    public int rotation;
    public int trackIndex;
    public long videoDuration;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aypl
 * JD-Core Version:    0.7.0.1
 */