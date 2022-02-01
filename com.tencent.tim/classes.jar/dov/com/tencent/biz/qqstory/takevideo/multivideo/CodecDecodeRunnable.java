package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import aypo;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class CodecDecodeRunnable
  extends DecodeRunnable
{
  private ArrayList<Long> GB = new ArrayList();
  private aypo a;
  private long aCZ;
  private long aDa = 200000L;
  private boolean deq;
  private boolean der;
  MediaCodec.BufferInfo e;
  private MediaCodec mDecoder;
  private MediaExtractor mExtractor = new MediaExtractor();
  ByteBuffer[] mInputBuffers;
  ByteBuffer[] mOutputBuffers;
  private long mSeekTarget = -1L;
  
  public CodecDecodeRunnable(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, DecodeRunnable.a parama)
  {
    super(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2, parama);
  }
  
  private boolean G(long paramLong1, long paramLong2)
  {
    if (paramLong2 > this.mEndTime - this.aDa) {
      if (paramLong1 <= paramLong2 - this.aDa) {}
    }
    while (paramLong1 > paramLong2)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private int Sa()
  {
    int j = 0;
    if (this.mExtractor == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VFLDecodeRunnable", 2, "mExtractor is null");
      }
      return 0;
    }
    Object localObject1 = new ArrayList();
    long l = 1000L;
    ((ArrayList)localObject1).add(Long.valueOf(0L));
    while (l >= 0L)
    {
      this.mExtractor.seekTo(l, 1);
      l = this.mExtractor.getSampleTime();
      if (l < 0L) {
        break label237;
      }
      if (l > 0L)
      {
        ((ArrayList)localObject1).add(Long.valueOf(l));
        l += 1000L;
        if (((ArrayList)localObject1).size() >= this.mFrameCount)
        {
          this.GB.clear();
          if (QLog.isColorLevel()) {
            QLog.d("VFLDecodeRunnable", 2, "IFrame is enough");
          }
          return 2;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("VFLDecodeRunnable", 2, "seektime = 0, error pos, break");
      }
    }
    int i;
    for (;;)
    {
      oR((List)localObject1);
      this.GB.add(Long.valueOf(0L));
      this.mFrameIndex = 0;
      i = 0;
      if (this.mFrameIndex >= this.mFrameCount - 1) {
        break label430;
      }
      l = jb();
      for (;;)
      {
        if (i >= ((ArrayList)localObject1).size()) {
          break label305;
        }
        if (i + 1 >= ((ArrayList)localObject1).size()) {
          break label342;
        }
        if (l <= ((Long)((ArrayList)localObject1).get(i + 1)).longValue()) {
          break;
        }
        i += 1;
      }
      label237:
      if (QLog.isColorLevel()) {
        QLog.d("VFLDecodeRunnable", 2, "keytime = -1, end seek");
      }
    }
    if (l >= ((Long)((ArrayList)localObject1).get(i)).longValue()) {
      if (ja() < ((Long)((ArrayList)localObject1).get(i)).longValue()) {
        this.GB.add(((ArrayList)localObject1).get(i));
      }
    }
    for (;;)
    {
      label305:
      break;
      this.GB.add(Long.valueOf(-1L));
      continue;
      QLog.e("VFLDecodeRunnable", 2, "init seektimelist error!!");
      this.GB.clear();
      return 0;
      label342:
      if (l < ((Long)((ArrayList)localObject1).get(i)).longValue()) {
        break label413;
      }
      if (ja() < ((Long)((ArrayList)localObject1).get(i)).longValue()) {
        this.GB.add(((ArrayList)localObject1).get(i));
      } else {
        this.GB.add(Long.valueOf(-1L));
      }
    }
    label413:
    QLog.e("VFLDecodeRunnable", 2, "init seektimelist error!!!");
    this.GB.clear();
    return 0;
    label430:
    if (QLog.isColorLevel())
    {
      QLog.d("VFLDecodeRunnable", 2, new Object[] { "mSeekTimeList size:" + this.GB.size(), " framecount:" + this.mFrameCount });
      localObject1 = "SeekTimeList:";
      Object localObject2 = localObject1;
      if (this.GB.size() > 0)
      {
        i = j;
        for (;;)
        {
          localObject2 = localObject1;
          if (i >= this.GB.size()) {
            break;
          }
          localObject1 = (String)localObject1 + this.GB.get(i);
          localObject1 = (String)localObject1 + ";";
          i += 1;
        }
      }
      QLog.d("VFLDecodeRunnable", 2, localObject2);
    }
    return 1;
  }
  
  private boolean aQV()
  {
    int i = this.mDecoder.dequeueOutputBuffer(this.e, 10000L);
    switch (i)
    {
    default: 
      if ((this.e.flags & 0x4) != 0)
      {
        QLog.d("VFLDecodeRunnable", 2, "output EOS");
        this.der = true;
      }
      if ((!G(this.e.presentationTimeUs, this.mSeekTarget)) && (!this.der)) {
        this.mDecoder.releaseOutputBuffer(i, false);
      }
      break;
    }
    do
    {
      return false;
      QLog.d("VFLDecodeRunnable", 2, "INFO_OUTPUT_BUFFERS_CHANGED");
      this.mOutputBuffers = this.mDecoder.getOutputBuffers();
      return false;
      QLog.d("VFLDecodeRunnable", 2, "New format " + this.mDecoder.getOutputFormat());
      return false;
      QLog.d("VFLDecodeRunnable", 2, "dequeueOutputBuffer timed out!");
      return false;
      this.mSeekTarget = -1L;
      this.mDecoder.releaseOutputBuffer(i, true);
    } while (this.der);
    return true;
  }
  
  private boolean init()
  {
    label134:
    label151:
    for (;;)
    {
      try
      {
        this.mExtractor.setDataSource(this.mVideoPath);
        int i = 0;
        MediaFormat localMediaFormat;
        String str;
        if (i < this.mExtractor.getTrackCount())
        {
          localMediaFormat = this.mExtractor.getTrackFormat(i);
          str = localMediaFormat.getString("mime");
          if (!str.startsWith("video/")) {
            break label151;
          }
          this.mExtractor.selectTrack(i);
        }
        i += 1;
      }
      catch (IOException localIOException)
      {
        try
        {
          this.mDecoder = MediaCodec.createDecoderByType(str);
          this.a = new aypo(this.mFrameWidth, this.mFrameHeight);
          this.mDecoder.configure(localMediaFormat, this.a.getSurface(), null, 0);
          return true;
        }
        catch (Throwable localThrowable)
        {
          if (!Thread.interrupted()) {
            break label134;
          }
          QLog.e("VFLDecodeRunnable", 2, "Thread is interrupted.", localThrowable);
          return false;
          QLog.e("VFLDecodeRunnable", 2, "decode configure error", localThrowable);
          afs(2);
          return false;
        }
        localIOException = localIOException;
        localIOException.printStackTrace();
        afs(2);
        return false;
      }
    }
  }
  
  private long ja()
  {
    int i = this.GB.size() - 1;
    long l = 0L;
    for (;;)
    {
      if (i >= 0)
      {
        l = ((Long)this.GB.get(i)).longValue();
        if (l < 0L) {}
      }
      else
      {
        return l;
      }
      i -= 1;
    }
  }
  
  private boolean queueSampleToCodec()
  {
    int i = this.mDecoder.dequeueInputBuffer(10000L);
    if (i >= 0)
    {
      ByteBuffer localByteBuffer = this.mInputBuffers[i];
      int j = this.mExtractor.readSampleData(localByteBuffer, 0);
      this.aCZ = this.mExtractor.getSampleTime();
      if ((j < 0) || ((this.mEndTime > 0L) && (this.aCZ >= this.mEndTime)))
      {
        this.mDecoder.queueInputBuffer(i, 0, 0, 0L, 4);
        this.deq = true;
      }
      for (;;)
      {
        return true;
        this.mDecoder.queueInputBuffer(i, 0, j, this.aCZ, 0);
        this.mExtractor.advance();
      }
    }
    QLog.w("VFLDecodeRunnable", 2, "queueSampleToCodec inIndex = " + i);
    return false;
  }
  
  private boolean start()
  {
    if (this.mDecoder == null)
    {
      QLog.e("VFLDecodeRunnable", 2, "Can't find video info!");
      afs(3);
      return false;
    }
    try
    {
      this.mDecoder.start();
      return false;
    }
    catch (Throwable localThrowable)
    {
      try
      {
        this.mInputBuffers = this.mDecoder.getInputBuffers();
        this.mOutputBuffers = this.mDecoder.getOutputBuffers();
        this.e = new MediaCodec.BufferInfo();
        return true;
      }
      catch (Exception localException)
      {
        QLog.e("VFLDecodeRunnable", 2, "decode start error2", localException);
        afs(3);
      }
      localThrowable = localThrowable;
      if (Thread.interrupted())
      {
        QLog.e("VFLDecodeRunnable", 2, "Thread is interrupted.", localThrowable);
        return false;
      }
      QLog.e("VFLDecodeRunnable", 2, "decode start error", localThrowable);
      afs(3);
      return false;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 65
    //   8: iconst_2
    //   9: ldc_w 338
    //   12: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: invokevirtual 341	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:onDecodeStart	()V
    //   19: aload_0
    //   20: invokespecial 343	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:init	()Z
    //   23: ifne +19 -> 42
    //   26: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +12 -> 41
    //   32: ldc 65
    //   34: iconst_2
    //   35: ldc_w 345
    //   38: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: return
    //   42: aload_0
    //   43: invokespecial 347	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:start	()Z
    //   46: ifne +19 -> 65
    //   49: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq -11 -> 41
    //   55: ldc 65
    //   57: iconst_2
    //   58: ldc_w 349
    //   61: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: return
    //   65: aload_0
    //   66: invokespecial 351	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:Sa	()I
    //   69: istore_2
    //   70: aload_0
    //   71: iconst_m1
    //   72: putfield 112	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:mFrameIndex	I
    //   75: aload_0
    //   76: getfield 36	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:mExtractor	Landroid/media/MediaExtractor;
    //   79: lconst_0
    //   80: iconst_0
    //   81: invokevirtual 87	android/media/MediaExtractor:seekTo	(JI)V
    //   84: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +29 -> 116
    //   90: ldc 65
    //   92: iconst_2
    //   93: new 137	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   100: ldc_w 353
    //   103: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: iload_2
    //   107: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: invokestatic 286	java/lang/Thread:interrupted	()Z
    //   119: ifne +121 -> 240
    //   122: aload_0
    //   123: invokevirtual 356	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:isStop	()Z
    //   126: ifne +114 -> 240
    //   129: aload_0
    //   130: getfield 40	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:mSeekTarget	J
    //   133: lconst_0
    //   134: lcmp
    //   135: ifge +15 -> 150
    //   138: aload_0
    //   139: aload_0
    //   140: invokevirtual 115	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jb	()J
    //   143: putfield 40	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:mSeekTarget	J
    //   146: iload_2
    //   147: ifne +160 -> 307
    //   150: aload_0
    //   151: getfield 312	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:deq	Z
    //   154: ifne +8 -> 162
    //   157: aload_0
    //   158: invokespecial 358	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:queueSampleToCodec	()Z
    //   161: pop
    //   162: aload_0
    //   163: getfield 185	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:der	Z
    //   166: ifne +67 -> 233
    //   169: aload_0
    //   170: invokespecial 360	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:aQV	()Z
    //   173: istore_3
    //   174: iload_3
    //   175: ifeq +58 -> 233
    //   178: iconst_2
    //   179: istore_1
    //   180: iload_1
    //   181: ifle +10 -> 191
    //   184: aload_0
    //   185: getfield 267	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:a	Laypo;
    //   188: invokevirtual 363	aypo:awaitNewImage	()V
    //   191: aload_0
    //   192: getfield 267	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:a	Laypo;
    //   195: iconst_0
    //   196: invokevirtual 367	aypo:tQ	(Z)V
    //   199: aload_0
    //   200: aload_0
    //   201: getfield 267	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:a	Laypo;
    //   204: invokevirtual 371	aypo:K	()Landroid/graphics/Bitmap;
    //   207: invokevirtual 375	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:ad	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   210: astore 4
    //   212: aload_0
    //   213: aload_0
    //   214: getfield 112	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:mFrameIndex	I
    //   217: aload_0
    //   218: getfield 168	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:e	Landroid/media/MediaCodec$BufferInfo;
    //   221: getfield 188	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   224: ldc2_w 72
    //   227: ldiv
    //   228: aload 4
    //   230: invokevirtual 378	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:a	(IJLandroid/graphics/Bitmap;)V
    //   233: aload_0
    //   234: getfield 185	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:der	Z
    //   237: ifeq -121 -> 116
    //   240: aload_0
    //   241: getfield 166	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:mDecoder	Landroid/media/MediaCodec;
    //   244: invokevirtual 381	android/media/MediaCodec:stop	()V
    //   247: aload_0
    //   248: getfield 166	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:mDecoder	Landroid/media/MediaCodec;
    //   251: invokevirtual 384	android/media/MediaCodec:release	()V
    //   254: aload_0
    //   255: getfield 36	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:mExtractor	Landroid/media/MediaExtractor;
    //   258: invokevirtual 385	android/media/MediaExtractor:release	()V
    //   261: aload_0
    //   262: getfield 267	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:a	Laypo;
    //   265: invokevirtual 386	aypo:release	()V
    //   268: aload_0
    //   269: aconst_null
    //   270: putfield 168	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:e	Landroid/media/MediaCodec$BufferInfo;
    //   273: aload_0
    //   274: aconst_null
    //   275: putfield 300	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:mInputBuffers	[Ljava/nio/ByteBuffer;
    //   278: aload_0
    //   279: aconst_null
    //   280: putfield 202	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:mOutputBuffers	[Ljava/nio/ByteBuffer;
    //   283: aload_0
    //   284: aload_0
    //   285: getfield 185	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:der	Z
    //   288: invokevirtual 389	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:ZJ	(Z)V
    //   291: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq -253 -> 41
    //   297: ldc 65
    //   299: iconst_2
    //   300: ldc_w 391
    //   303: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: return
    //   307: iload_2
    //   308: iconst_1
    //   309: if_icmpne +151 -> 460
    //   312: aload_0
    //   313: getfield 112	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:mFrameIndex	I
    //   316: iflt -166 -> 150
    //   319: aload_0
    //   320: getfield 112	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:mFrameIndex	I
    //   323: aload_0
    //   324: getfield 49	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:GB	Ljava/util/ArrayList;
    //   327: invokevirtual 94	java/util/ArrayList:size	()I
    //   330: if_icmpge -180 -> 150
    //   333: aload_0
    //   334: getfield 49	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:GB	Ljava/util/ArrayList;
    //   337: aload_0
    //   338: getfield 112	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:mFrameIndex	I
    //   341: invokevirtual 119	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   344: checkcast 75	java/lang/Long
    //   347: invokevirtual 122	java/lang/Long:longValue	()J
    //   350: lconst_0
    //   351: lcmp
    //   352: iflt -202 -> 150
    //   355: aload_0
    //   356: aload_0
    //   357: getfield 49	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:GB	Ljava/util/ArrayList;
    //   360: aload_0
    //   361: getfield 112	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:mFrameIndex	I
    //   364: invokevirtual 119	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   367: checkcast 75	java/lang/Long
    //   370: invokevirtual 122	java/lang/Long:longValue	()J
    //   373: putfield 40	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:mSeekTarget	J
    //   376: aload_0
    //   377: getfield 36	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:mExtractor	Landroid/media/MediaExtractor;
    //   380: aload_0
    //   381: getfield 40	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:mSeekTarget	J
    //   384: iconst_0
    //   385: invokevirtual 87	android/media/MediaExtractor:seekTo	(JI)V
    //   388: aload_0
    //   389: aload_0
    //   390: getfield 36	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:mExtractor	Landroid/media/MediaExtractor;
    //   393: invokevirtual 91	android/media/MediaExtractor:getSampleTime	()J
    //   396: putfield 306	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:aCZ	J
    //   399: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   402: ifeq +45 -> 447
    //   405: ldc 65
    //   407: iconst_2
    //   408: new 137	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   415: ldc_w 393
    //   418: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aload_0
    //   422: getfield 40	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:mSeekTarget	J
    //   425: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   428: ldc_w 398
    //   431: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload_0
    //   435: getfield 306	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:aCZ	J
    //   438: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   441: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: aload_0
    //   448: iconst_0
    //   449: putfield 312	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:deq	Z
    //   452: aload_0
    //   453: iconst_0
    //   454: putfield 185	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:der	Z
    //   457: goto -307 -> 150
    //   460: aload_0
    //   461: getfield 36	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:mExtractor	Landroid/media/MediaExtractor;
    //   464: aload_0
    //   465: getfield 40	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:mSeekTarget	J
    //   468: iconst_0
    //   469: invokevirtual 87	android/media/MediaExtractor:seekTo	(JI)V
    //   472: aload_0
    //   473: aload_0
    //   474: getfield 36	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:mExtractor	Landroid/media/MediaExtractor;
    //   477: invokevirtual 91	android/media/MediaExtractor:getSampleTime	()J
    //   480: putfield 306	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:aCZ	J
    //   483: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   486: ifeq +45 -> 531
    //   489: ldc 65
    //   491: iconst_2
    //   492: new 137	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   499: ldc_w 393
    //   502: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: aload_0
    //   506: getfield 40	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:mSeekTarget	J
    //   509: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   512: ldc_w 398
    //   515: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: aload_0
    //   519: getfield 306	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:aCZ	J
    //   522: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   525: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   528: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   531: aload_0
    //   532: iconst_0
    //   533: putfield 312	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:deq	Z
    //   536: aload_0
    //   537: iconst_0
    //   538: putfield 185	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:der	Z
    //   541: goto -391 -> 150
    //   544: astore 4
    //   546: aload 4
    //   548: invokevirtual 399	java/lang/Exception:printStackTrace	()V
    //   551: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   554: ifeq +30 -> 584
    //   557: ldc 65
    //   559: iconst_2
    //   560: new 137	java/lang/StringBuilder
    //   563: dup
    //   564: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   567: ldc_w 401
    //   570: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: aload 4
    //   575: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   578: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   584: iload_1
    //   585: iconst_1
    //   586: isub
    //   587: istore_1
    //   588: goto -408 -> 180
    //   591: astore 4
    //   593: invokestatic 286	java/lang/Thread:interrupted	()Z
    //   596: ifeq +17 -> 613
    //   599: ldc 65
    //   601: iconst_2
    //   602: ldc_w 288
    //   605: aload 4
    //   607: invokestatic 291	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   610: goto -377 -> 233
    //   613: aload_0
    //   614: iconst_4
    //   615: invokevirtual 281	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:afs	(I)V
    //   618: ldc 65
    //   620: iconst_2
    //   621: ldc_w 403
    //   624: aload 4
    //   626: invokestatic 291	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   629: goto -389 -> 240
    //   632: astore 4
    //   634: ldc 65
    //   636: iconst_2
    //   637: new 137	java/lang/StringBuilder
    //   640: dup
    //   641: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   644: ldc_w 405
    //   647: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: aload 4
    //   652: invokevirtual 406	java/lang/Exception:toString	()Ljava/lang/String;
    //   655: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   661: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   664: goto -381 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	667	0	this	CodecDecodeRunnable
    //   179	409	1	i	int
    //   69	241	2	j	int
    //   173	2	3	bool	boolean
    //   210	19	4	localBitmap	android.graphics.Bitmap
    //   544	30	4	localException1	Exception
    //   591	34	4	localThrowable	Throwable
    //   632	19	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   184	191	544	java/lang/Exception
    //   150	162	591	java/lang/Throwable
    //   162	174	591	java/lang/Throwable
    //   184	191	591	java/lang/Throwable
    //   191	233	591	java/lang/Throwable
    //   546	584	591	java/lang/Throwable
    //   240	283	632	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.CodecDecodeRunnable
 * JD-Core Version:    0.7.0.1
 */