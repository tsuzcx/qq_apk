package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import alzd;
import alzg;
import alzj;
import alzk;
import alzl;
import alzm;
import alzp;
import alzu;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.os.Trace;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Surface;
import annt;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import ram;
import rar;

@TargetApi(18)
public class VideoFlowDecodeTask
  implements Runnable
{
  private List<a> Fx;
  private alzd jdField_a_of_type_Alzd;
  private final alzj jdField_a_of_type_Alzj;
  private alzk jdField_a_of_type_Alzk;
  private alzp jdField_a_of_type_Alzp;
  private long ail;
  private final alzj b;
  public volatile boolean cuB = false;
  private int dAV;
  private int dAW;
  private int dAX = 1;
  int dAY;
  int dAZ;
  private MediaCodec decoder;
  private MediaExtractor extractor;
  private final String filePath;
  private ByteBuffer[] inputBuffers;
  private boolean inputDone;
  private boolean interruptedFlag;
  private ByteBuffer[] outputBuffers;
  private boolean outputDone;
  public final Object pauseLock = new Object();
  private final AtomicLong seekToTaskUs = new AtomicLong(-1L);
  private final long videoDurationMs;
  
  public VideoFlowDecodeTask(String paramString, alzd paramalzd, alzk paramalzk)
  {
    this.jdField_a_of_type_Alzd = paramalzd;
    this.filePath = paramString;
    this.videoDurationMs = alzu.getDuration(paramString);
    this.jdField_a_of_type_Alzk = paramalzk;
    this.jdField_a_of_type_Alzj = new alzj(paramString, 0, true, false, 0L, this.videoDurationMs);
    this.b = new alzj(paramString, 0, true, false, 0L, this.videoDurationMs);
  }
  
  private void OI(boolean paramBoolean)
  {
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    int i = this.decoder.dequeueOutputBuffer(localBufferInfo, 10000L);
    switch (i)
    {
    default: 
      if ((localBufferInfo.flags & 0x4) != 0) {
        this.outputDone = true;
      }
      break;
    }
    for (;;)
    {
      dLQ();
      return;
      this.outputBuffers = this.decoder.getOutputBuffers();
      return;
      SystemClock.uptimeMillis();
      a(localBufferInfo, i, paramBoolean);
    }
  }
  
  private a a(long paramLong, List<a> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      if ((paramLong >= locala.startTimeUs) && (paramLong < locala.endTimeUs)) {
        return locala;
      }
    }
    return null;
  }
  
  private void a(MediaCodec.BufferInfo paramBufferInfo, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramBufferInfo.size != 0)) {
      paramBoolean = true;
    }
    for (;;)
    {
      this.decoder.releaseOutputBuffer(paramInt, paramBoolean);
      a locala = a(paramBufferInfo.presentationTimeUs, this.Fx);
      if ((paramBoolean) && (locala != null))
      {
        alzg localalzg = alzg.a();
        label71:
        float f;
        if (localalzg != null)
        {
          if (a.c(locala) % this.dAX != 1) {
            break label259;
          }
          paramInt = 1;
          if ((!this.b.noSleep) && (paramInt != 0)) {
            break label283;
          }
          a.a(locala).add(localalzg);
          Trace.beginSection("AVEditor:doRender");
          SystemClock.uptimeMillis();
          this.jdField_a_of_type_Alzp.awaitNewImage();
          SystemClock.uptimeMillis();
          this.jdField_a_of_type_Alzp.a(localalzg, false);
          Trace.endSection();
          if (this.b.speedType != 3) {
            break label264;
          }
          localalzg.k(this.dAW, -paramBufferInfo.presentationTimeUs, SystemClock.uptimeMillis());
          label163:
          if (a.a(locala).size() % 7 == 6)
          {
            f = 1.0F;
            if (this.b.speedType != 1) {
              break label304;
            }
            f = 2.0F;
            label198:
            this.dAX = locala.v(f);
            ram.b("FlowEdit_VideoFlowDecodeTask", "update dropFrameRate = %d", Integer.valueOf(this.dAX));
          }
          if (this.jdField_a_of_type_Alzd == null) {}
        }
        try
        {
          this.jdField_a_of_type_Alzd.fp(paramBufferInfo.presentationTimeUs * 1000L);
          a.d(locala);
          return;
          paramBoolean = false;
          continue;
          label259:
          paramInt = 0;
          break label71;
          label264:
          localalzg.k(this.dAW, paramBufferInfo.presentationTimeUs, SystemClock.uptimeMillis());
          break label163;
          label283:
          SystemClock.uptimeMillis();
          this.jdField_a_of_type_Alzp.awaitNewImage();
          localalzg.recycle();
          break label163;
          label304:
          if (this.b.speedType != 2) {
            break label198;
          }
          f = 0.5F;
        }
        catch (InterruptedException paramBufferInfo)
        {
          for (;;)
          {
            ram.e("FlowEdit_VideoFlowDecodeTask", "doRender.", paramBufferInfo);
            this.interruptedFlag = true;
          }
        }
      }
    }
    ram.e("FlowEdit_VideoFlowDecodeTask", "doRender. doRender is false");
  }
  
  private static List<a> aL(String paramString)
  {
    paramString = alzu.aK(paramString);
    if ((paramString == null) || (paramString.size() < 2)) {
      return null;
    }
    ram.i("FlowEdit_VideoFlowDecodeTask", "iFrameTimeStampList = " + new JSONArray(paramString));
    ArrayList localArrayList = new ArrayList(paramString.size() - 2);
    int i = 0;
    while (i < paramString.size() - 1)
    {
      localArrayList.add(new a(i, ((Long)paramString.get(i)).longValue(), ((Long)paramString.get(i + 1)).longValue()));
      i += 1;
    }
    return localArrayList;
  }
  
  private boolean avb()
  {
    if (this.decoder == null)
    {
      ram.e("FlowEdit_VideoFlowDecodeTask", "Can't find video info!");
      return false;
    }
    if (this.jdField_a_of_type_Alzd != null) {
      this.jdField_a_of_type_Alzd.onDecodeStart();
    }
    try
    {
      this.decoder.start();
      this.inputBuffers = this.decoder.getInputBuffers();
      this.outputBuffers = this.decoder.getOutputBuffers();
      return true;
    }
    catch (Throwable localThrowable)
    {
      if (Thread.interrupted())
      {
        ram.e("FlowEdit_VideoFlowDecodeTask", "Thread is interrupted.", localThrowable);
        return false;
      }
      RuntimeException localRuntimeException = new RuntimeException(localThrowable);
      if (this.jdField_a_of_type_Alzd != null)
      {
        this.jdField_a_of_type_Alzd.onDecodeError(2, localRuntimeException);
        ram.e("FlowEdit_VideoFlowDecodeTask", "decode start error", localThrowable);
        return false;
      }
      throw localRuntimeException;
    }
  }
  
  private void dLP()
  {
    int i = this.decoder.dequeueInputBuffer(10000L);
    if (i < 0)
    {
      ram.w("FlowEdit_VideoFlowDecodeTask", "queueSamplesToCodec. inIndex = " + i);
      return;
    }
    a locala = (a)this.Fx.get(this.dAV);
    ByteBuffer localByteBuffer = this.inputBuffers[i];
    localByteBuffer.clear();
    int j = this.extractor.readSampleData(localByteBuffer, 0);
    long l = this.extractor.getSampleTime();
    if ((j < 0) || (l >= locala.endTimeUs))
    {
      this.decoder.queueInputBuffer(i, 0, 0, 0L, 4);
      this.inputDone = true;
      return;
    }
    a.a(locala);
    this.decoder.queueInputBuffer(i, 0, j, l, 0);
    this.extractor.advance();
  }
  
  private void dLQ()
  {
    a locala = (a)this.Fx.get(this.dAV);
    int k = a.a(locala).size();
    int i;
    int j;
    if ((this.outputDone) && (k > 0))
    {
      i = 1;
      if ((this.b.speedType != 0) && (this.b.speedType != 2))
      {
        j = i;
        if (this.b.speedType != 1) {}
      }
      else
      {
        if ((i == 0) && (k < 12)) {
          break label268;
        }
        j = 1;
      }
    }
    label268:
    for (;;)
    {
      label88:
      if (j != 0)
      {
        if ((this.outputDone) && (a.b(locala) != 0)) {
          ram.w("FlowEdit_VideoFlowDecodeTask", "sendDecodedFrameSetIfNeeded. output done but decoding frame count (%d) is not 0", new Object[] { Integer.valueOf(a.b(locala)) });
        }
        ram.i("FlowEdit_VideoFlowDecodeTask", "sendDecodedFrameSetIfNeeded. render segment " + this.dAV + ", frame count = " + a.a(locala).size() + " to next");
        this.jdField_a_of_type_Alzk.y(Collections.unmodifiableList(a.a(locala)));
        a.a(locala).clear();
        long l1 = SystemClock.uptimeMillis();
        for (;;)
        {
          if (this.jdField_a_of_type_Alzk.getFrameCount() >= 50)
          {
            try
            {
              Thread.sleep(100L);
            }
            catch (InterruptedException localInterruptedException)
            {
              ram.d("FlowEdit_VideoFlowDecodeTask", localInterruptedException, "sleep interrupt", new Object[0]);
              this.interruptedFlag = true;
            }
            continue;
            i = 0;
            break;
            j = 0;
            break label88;
          }
        }
        long l2 = this.ail;
        this.ail = (SystemClock.uptimeMillis() - l1 + l2);
      }
    }
  }
  
  private void kU(long paramLong)
  {
    this.decoder.flush();
    this.extractor.seekTo(paramLong, 2);
    paramLong = this.extractor.getSampleTime();
    this.jdField_a_of_type_Alzd.onDecodeSeekTo(paramLong / 1000L);
    this.inputDone = false;
    this.outputDone = false;
  }
  
  public void OH(boolean paramBoolean)
  {
    this.jdField_a_of_type_Alzj.cBx = paramBoolean;
  }
  
  public void a(@NonNull alzj paramalzj)
  {
    if (!TextUtils.equals(this.filePath, paramalzj.inputFilePath)) {
      ram.e("FlowEdit_VideoFlowDecodeTask", "DecodeRunnable does not support changing the file");
    }
    this.jdField_a_of_type_Alzj.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = paramalzj.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
    this.jdField_a_of_type_Alzj.jdField_a_of_type_AndroidOpenglEGLContext = paramalzj.jdField_a_of_type_AndroidOpenglEGLContext;
    this.jdField_a_of_type_Alzj.decodeType = paramalzj.decodeType;
    OH(paramalzj.cBx);
    setSpeedType(paramalzj.speedType);
    setPlayRange(paramalzj.startTimeMillSecond, paramalzj.endTimeMillSecond);
    setRepeat(paramalzj.repeat);
    setNoSleep(paramalzj.noSleep);
  }
  
  protected boolean avc()
  {
    this.Fx = aL(this.b.inputFilePath);
    if (this.Fx == null)
    {
      ram.e("FlowEdit_VideoFlowDecodeTask", "this video can not be played, check video");
      rar.b("video_edit", "split_video_fail", 0, 0, new String[] { Build.MANUFACTURER, Build.MODEL, String.valueOf(Build.VERSION.SDK_INT) });
      if (this.jdField_a_of_type_Alzd != null) {
        this.jdField_a_of_type_Alzd.onDecodeError(1, new IllegalStateException("this video can not be played reservedly, check video"));
      }
      return false;
    }
    for (;;)
    {
      try
      {
        i = alzu.dQ(this.filePath);
        Object localObject1;
        ram.e("FlowEdit_VideoFlowDecodeTask", "initDecoder failed", localException1);
      }
      catch (Exception localException1)
      {
        try
        {
          j = alzu.dR(this.filePath);
          if ((i > 0) && (j > 0)) {
            break;
          }
          localObject1 = "";
          if (this.filePath != null)
          {
            localObject1 = new File(this.filePath);
            if (!((File)localObject1).exists()) {
              break label218;
            }
            if (((File)localObject1).length() < 0L) {
              break label211;
            }
            localObject1 = "illegal file";
          }
          rar.b("video_edit", "getVideoWH_fail", 0, 0, new String[] { Build.MANUFACTURER, Build.MODEL, localObject1 });
          return false;
        }
        catch (Exception localException2)
        {
          int i;
          int j;
          Object localObject2;
          break label197;
        }
        localException1 = localException1;
        i = 0;
      }
      label197:
      j = 0;
      continue;
      label211:
      localObject2 = "file length is 0";
      continue;
      label218:
      localObject2 = "file does not exist";
    }
    if (this.b.decodeType == 2)
    {
      this.jdField_a_of_type_Alzp = new alzl(this.b.jdField_a_of_type_AndroidOpenglEGLContext, i, j);
      this.extractor = new MediaExtractor();
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          this.extractor.setDataSource(this.filePath);
          i = 0;
          if (i >= this.extractor.getTrackCount()) {
            break;
          }
          localObject2 = this.extractor.getTrackFormat(i);
          localObject3 = ((MediaFormat)localObject2).getString("mime");
          if (!((String)localObject3).startsWith("video/")) {
            break label600;
          }
          this.extractor.selectTrack(i);
          if (!this.b.cBx) {
            ((MediaFormat)localObject2).setInteger("rotation-degrees", 0);
          }
          try
          {
            this.decoder = MediaCodec.createDecoderByType((String)localObject3);
            if (this.jdField_a_of_type_Alzp.getSurface().isValid()) {
              break label536;
            }
            throw new RuntimeException("surface is not valid.");
          }
          catch (Throwable localThrowable)
          {
            if (!Thread.interrupted()) {
              break label557;
            }
          }
          ram.e("FlowEdit_VideoFlowDecodeTask", "Thread is interrupted.", localThrowable);
          return false;
        }
        catch (IOException localIOException)
        {
          ram.d("FlowEdit_VideoFlowDecodeTask", localIOException, "setDataSource failed", new Object[0]);
        }
        if (this.b.decodeType == 1) {
          try
          {
            this.jdField_a_of_type_Alzp = new alzm(this.b.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext, i, j);
          }
          catch (FlowDecodeScreenSurfaceBase.FlowDecodeException localFlowDecodeException)
          {
            ram.d("FlowEdit_VideoFlowDecodeTask", localFlowDecodeException, "create FlowDecodeScreenSurface failed", new Object[0]);
            if (this.jdField_a_of_type_Alzd != null) {
              this.jdField_a_of_type_Alzd.onDecodeError(2, localFlowDecodeException);
            }
            annt.e(localFlowDecodeException);
            return false;
          }
        }
      }
      throw new IllegalStateException("Illegal decodeType in decodeConfig " + this.b);
      if (this.jdField_a_of_type_Alzd == null) {
        break;
      }
      this.jdField_a_of_type_Alzd.onDecodeError(2, localIOException);
      return false;
      label536:
      this.decoder.configure(localIOException, this.jdField_a_of_type_Alzp.getSurface(), null, 0);
      return true;
      label557:
      Object localObject3 = new RuntimeException(localIOException);
      if (this.jdField_a_of_type_Alzd != null)
      {
        this.jdField_a_of_type_Alzd.onDecodeError(1, (Throwable)localObject3);
        ram.e("FlowEdit_VideoFlowDecodeTask", "decode configure error", localIOException);
        return false;
      }
      throw ((Throwable)localObject3);
      label600:
      i += 1;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 90	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:b	Lalzj;
    //   4: aload_0
    //   5: getfield 88	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_Alzj	Lalzj;
    //   8: invokevirtual 647	alzj:a	(Lalza;)Z
    //   11: pop
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield 215	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAW	I
    //   17: aload_0
    //   18: invokevirtual 649	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:avc	()Z
    //   21: ifne +4 -> 25
    //   24: return
    //   25: aload_0
    //   26: invokespecial 651	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:avb	()Z
    //   29: ifeq -5 -> 24
    //   32: iconst_0
    //   33: istore_1
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield 653	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAY	I
    //   39: aload_0
    //   40: aload_0
    //   41: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:Fx	Ljava/util/List;
    //   44: invokeinterface 222 1 0
    //   49: iconst_1
    //   50: isub
    //   51: putfield 655	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAZ	I
    //   54: iconst_1
    //   55: istore 6
    //   57: invokestatic 335	java/lang/Thread:interrupted	()Z
    //   60: ifne +1135 -> 1195
    //   63: aload_0
    //   64: getfield 263	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:interruptedFlag	Z
    //   67: ifne +1128 -> 1195
    //   70: aload_0
    //   71: getfield 90	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:b	Lalzj;
    //   74: getfield 213	alzj:speedType	I
    //   77: istore 4
    //   79: aload_0
    //   80: getfield 90	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:b	Lalzj;
    //   83: getfield 478	alzj:startTimeMillSecond	J
    //   86: aload_0
    //   87: getfield 88	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_Alzj	Lalzj;
    //   90: getfield 478	alzj:startTimeMillSecond	J
    //   93: lcmp
    //   94: ifne +21 -> 115
    //   97: aload_0
    //   98: getfield 90	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:b	Lalzj;
    //   101: getfield 481	alzj:endTimeMillSecond	J
    //   104: aload_0
    //   105: getfield 88	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_Alzj	Lalzj;
    //   108: getfield 481	alzj:endTimeMillSecond	J
    //   111: lcmp
    //   112: ifeq +407 -> 519
    //   115: iconst_1
    //   116: istore_2
    //   117: aload_0
    //   118: getfield 90	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:b	Lalzj;
    //   121: aload_0
    //   122: getfield 88	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_Alzj	Lalzj;
    //   125: invokevirtual 647	alzj:a	(Lalza;)Z
    //   128: istore 7
    //   130: aload_0
    //   131: getfield 90	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:b	Lalzj;
    //   134: getfield 213	alzj:speedType	I
    //   137: istore 5
    //   139: iload 6
    //   141: ifne +7 -> 148
    //   144: iload_2
    //   145: ifeq +1241 -> 1386
    //   148: ldc 228
    //   150: ldc_w 657
    //   153: iload 6
    //   155: invokestatic 662	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   158: iload 7
    //   160: invokestatic 662	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   163: aload_0
    //   164: getfield 90	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:b	Lalzj;
    //   167: invokestatic 665	ram:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   170: aload_0
    //   171: getfield 90	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:b	Lalzj;
    //   174: getfield 478	alzj:startTimeMillSecond	J
    //   177: lconst_0
    //   178: lcmp
    //   179: ifne +345 -> 524
    //   182: aload_0
    //   183: getfield 90	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:b	Lalzj;
    //   186: getfield 481	alzj:endTimeMillSecond	J
    //   189: lconst_0
    //   190: lcmp
    //   191: ifne +333 -> 524
    //   194: aload_0
    //   195: iconst_0
    //   196: putfield 653	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAY	I
    //   199: aload_0
    //   200: aload_0
    //   201: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:Fx	Ljava/util/List;
    //   204: invokeinterface 222 1 0
    //   209: iconst_1
    //   210: isub
    //   211: putfield 655	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAZ	I
    //   214: ldc 228
    //   216: ldc_w 667
    //   219: aload_0
    //   220: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:Fx	Ljava/util/List;
    //   223: aload_0
    //   224: getfield 653	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAY	I
    //   227: invokeinterface 306 2 0
    //   232: checkcast 8	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a
    //   235: getfield 149	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a:startTimeUs	J
    //   238: invokestatic 670	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   241: aload_0
    //   242: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:Fx	Ljava/util/List;
    //   245: aload_0
    //   246: getfield 655	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAZ	I
    //   249: invokeinterface 306 2 0
    //   254: checkcast 8	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a
    //   257: getfield 152	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a:endTimeUs	J
    //   260: invokestatic 670	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   263: aload_0
    //   264: getfield 653	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAY	I
    //   267: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   270: aload_0
    //   271: getfield 655	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAZ	I
    //   274: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: invokestatic 673	ram:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   280: ldc 228
    //   282: ldc_w 675
    //   285: invokestatic 297	ram:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload_0
    //   289: getfield 81	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_Alzk	Lalzk;
    //   292: invokeinterface 678 1 0
    //   297: iconst_1
    //   298: istore_1
    //   299: iload 4
    //   301: iconst_3
    //   302: if_icmpne +9 -> 311
    //   305: iload 5
    //   307: iconst_3
    //   308: if_icmpne +15 -> 323
    //   311: iload 4
    //   313: iconst_3
    //   314: if_icmpeq +505 -> 819
    //   317: iload 5
    //   319: iconst_3
    //   320: if_icmpne +499 -> 819
    //   323: iconst_1
    //   324: istore_3
    //   325: iload 6
    //   327: ifne +9 -> 336
    //   330: iload_1
    //   331: istore_2
    //   332: iload_3
    //   333: ifeq +22 -> 355
    //   336: ldc 228
    //   338: ldc_w 680
    //   341: invokestatic 297	ram:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: aload_0
    //   345: getfield 81	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_Alzk	Lalzk;
    //   348: invokeinterface 683 1 0
    //   353: iconst_1
    //   354: istore_2
    //   355: iload 6
    //   357: ifne +9 -> 366
    //   360: iload_2
    //   361: istore_1
    //   362: iload_2
    //   363: ifeq +474 -> 837
    //   366: aload_0
    //   367: aload_0
    //   368: getfield 215	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAW	I
    //   371: iconst_1
    //   372: iadd
    //   373: putfield 215	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAW	I
    //   376: aload_0
    //   377: getfield 90	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:b	Lalzj;
    //   380: getfield 213	alzj:speedType	I
    //   383: iconst_3
    //   384: if_icmpne +440 -> 824
    //   387: aload_0
    //   388: aload_0
    //   389: getfield 655	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAZ	I
    //   392: putfield 363	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAV	I
    //   395: aload_0
    //   396: aload_0
    //   397: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:Fx	Ljava/util/List;
    //   400: aload_0
    //   401: getfield 363	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAV	I
    //   404: invokeinterface 306 2 0
    //   409: checkcast 8	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a
    //   412: getfield 149	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a:startTimeUs	J
    //   415: invokespecial 685	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:kU	(J)V
    //   418: iconst_0
    //   419: istore_1
    //   420: iload_1
    //   421: aload_0
    //   422: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:Fx	Ljava/util/List;
    //   425: invokeinterface 222 1 0
    //   430: if_icmpge +405 -> 835
    //   433: aload_0
    //   434: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:Fx	Ljava/util/List;
    //   437: iload_1
    //   438: invokeinterface 306 2 0
    //   443: checkcast 8	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a
    //   446: invokestatic 185	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a;)Ljava/util/List;
    //   449: invokeinterface 222 1 0
    //   454: ifle +42 -> 496
    //   457: ldc 228
    //   459: ldc_w 687
    //   462: iconst_1
    //   463: anewarray 4	java/lang/Object
    //   466: dup
    //   467: iconst_0
    //   468: aload_0
    //   469: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:Fx	Ljava/util/List;
    //   472: iload_1
    //   473: invokeinterface 306 2 0
    //   478: checkcast 8	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a
    //   481: invokestatic 185	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a;)Ljava/util/List;
    //   484: invokeinterface 222 1 0
    //   489: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   492: aastore
    //   493: invokestatic 398	ram:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   496: aload_0
    //   497: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:Fx	Ljava/util/List;
    //   500: iload_1
    //   501: invokeinterface 306 2 0
    //   506: checkcast 8	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a
    //   509: invokestatic 690	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a;)V
    //   512: iload_1
    //   513: iconst_1
    //   514: iadd
    //   515: istore_1
    //   516: goto -96 -> 420
    //   519: iconst_0
    //   520: istore_2
    //   521: goto -404 -> 117
    //   524: aload_0
    //   525: getfield 90	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:b	Lalzj;
    //   528: getfield 478	alzj:startTimeMillSecond	J
    //   531: lstore 8
    //   533: aload_0
    //   534: getfield 90	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:b	Lalzj;
    //   537: getfield 481	alzj:endTimeMillSecond	J
    //   540: lstore 10
    //   542: aload_0
    //   543: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:Fx	Ljava/util/List;
    //   546: invokeinterface 222 1 0
    //   551: istore_1
    //   552: iconst_0
    //   553: istore_3
    //   554: iload_1
    //   555: iconst_1
    //   556: isub
    //   557: istore_2
    //   558: iconst_0
    //   559: istore_1
    //   560: iload_1
    //   561: aload_0
    //   562: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:Fx	Ljava/util/List;
    //   565: invokeinterface 222 1 0
    //   570: if_icmpge +80 -> 650
    //   573: lload 8
    //   575: ldc2_w 242
    //   578: lmul
    //   579: aload_0
    //   580: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:Fx	Ljava/util/List;
    //   583: iload_1
    //   584: invokeinterface 306 2 0
    //   589: checkcast 8	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a
    //   592: getfield 149	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a:startTimeUs	J
    //   595: lsub
    //   596: invokestatic 696	java/lang/Math:abs	(J)J
    //   599: ldc2_w 99
    //   602: lcmp
    //   603: ifge +5 -> 608
    //   606: iload_1
    //   607: istore_3
    //   608: lload 10
    //   610: ldc2_w 242
    //   613: lmul
    //   614: aload_0
    //   615: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:Fx	Ljava/util/List;
    //   618: iload_1
    //   619: invokeinterface 306 2 0
    //   624: checkcast 8	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a
    //   627: getfield 152	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a:endTimeUs	J
    //   630: lsub
    //   631: invokestatic 696	java/lang/Math:abs	(J)J
    //   634: ldc2_w 99
    //   637: lcmp
    //   638: ifge +5 -> 643
    //   641: iload_1
    //   642: istore_2
    //   643: iload_1
    //   644: iconst_1
    //   645: iadd
    //   646: istore_1
    //   647: goto -87 -> 560
    //   650: aload_0
    //   651: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:Fx	Ljava/util/List;
    //   654: iload_3
    //   655: invokeinterface 306 2 0
    //   660: checkcast 8	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a
    //   663: getfield 149	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a:startTimeUs	J
    //   666: lstore 8
    //   668: aload_0
    //   669: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:Fx	Ljava/util/List;
    //   672: iload_2
    //   673: invokeinterface 306 2 0
    //   678: checkcast 8	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a
    //   681: getfield 152	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a:endTimeUs	J
    //   684: lstore 10
    //   686: ldc 228
    //   688: ldc_w 698
    //   691: bipush 6
    //   693: anewarray 4	java/lang/Object
    //   696: dup
    //   697: iconst_0
    //   698: aload_0
    //   699: getfield 90	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:b	Lalzj;
    //   702: getfield 478	alzj:startTimeMillSecond	J
    //   705: invokestatic 670	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   708: aastore
    //   709: dup
    //   710: iconst_1
    //   711: aload_0
    //   712: getfield 90	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:b	Lalzj;
    //   715: getfield 481	alzj:endTimeMillSecond	J
    //   718: invokestatic 670	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   721: aastore
    //   722: dup
    //   723: iconst_2
    //   724: lload 8
    //   726: invokestatic 670	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   729: aastore
    //   730: dup
    //   731: iconst_3
    //   732: lload 10
    //   734: invokestatic 670	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   737: aastore
    //   738: dup
    //   739: iconst_4
    //   740: iload_3
    //   741: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   744: aastore
    //   745: dup
    //   746: iconst_5
    //   747: iload_2
    //   748: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   751: aastore
    //   752: invokestatic 700	ram:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   755: iload_2
    //   756: iload_3
    //   757: if_icmple +33 -> 790
    //   760: iload_3
    //   761: iflt +29 -> 790
    //   764: iload_2
    //   765: aload_0
    //   766: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:Fx	Ljava/util/List;
    //   769: invokeinterface 222 1 0
    //   774: if_icmpge +16 -> 790
    //   777: aload_0
    //   778: iload_3
    //   779: putfield 653	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAY	I
    //   782: aload_0
    //   783: iload_2
    //   784: putfield 655	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAZ	I
    //   787: goto -507 -> 280
    //   790: ldc 228
    //   792: ldc_w 702
    //   795: iconst_2
    //   796: anewarray 4	java/lang/Object
    //   799: dup
    //   800: iconst_0
    //   801: iload_3
    //   802: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   805: aastore
    //   806: dup
    //   807: iconst_1
    //   808: iload_2
    //   809: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   812: aastore
    //   813: invokestatic 398	ram:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   816: goto -536 -> 280
    //   819: iconst_0
    //   820: istore_3
    //   821: goto -496 -> 325
    //   824: aload_0
    //   825: aload_0
    //   826: getfield 653	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAY	I
    //   829: putfield 363	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAV	I
    //   832: goto -437 -> 395
    //   835: iconst_0
    //   836: istore_1
    //   837: aload_0
    //   838: getfield 386	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:inputDone	Z
    //   841: ifne +11 -> 852
    //   844: invokestatic 126	android/os/SystemClock:uptimeMillis	()J
    //   847: pop2
    //   848: aload_0
    //   849: invokespecial 704	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dLP	()V
    //   852: aload_0
    //   853: getfield 111	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:outputDone	Z
    //   856: ifne +12 -> 868
    //   859: invokestatic 126	android/os/SystemClock:uptimeMillis	()J
    //   862: pop2
    //   863: aload_0
    //   864: iconst_1
    //   865: invokespecial 706	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:OI	(Z)V
    //   868: aload_0
    //   869: getfield 111	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:outputDone	Z
    //   872: ifeq +273 -> 1145
    //   875: aload_0
    //   876: getfield 90	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:b	Lalzj;
    //   879: getfield 213	alzj:speedType	I
    //   882: iconst_3
    //   883: if_icmpne +205 -> 1088
    //   886: aload_0
    //   887: aload_0
    //   888: getfield 363	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAV	I
    //   891: iconst_1
    //   892: isub
    //   893: putfield 363	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAV	I
    //   896: aload_0
    //   897: getfield 363	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAV	I
    //   900: aload_0
    //   901: getfield 653	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAY	I
    //   904: if_icmplt +197 -> 1101
    //   907: aload_0
    //   908: getfield 363	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAV	I
    //   911: aload_0
    //   912: getfield 655	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAZ	I
    //   915: if_icmpgt +186 -> 1101
    //   918: aload_0
    //   919: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:Fx	Ljava/util/List;
    //   922: aload_0
    //   923: getfield 363	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAV	I
    //   926: invokeinterface 306 2 0
    //   931: checkcast 8	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a
    //   934: getfield 149	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a:startTimeUs	J
    //   937: lstore 8
    //   939: aload_0
    //   940: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:Fx	Ljava/util/List;
    //   943: aload_0
    //   944: getfield 363	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAV	I
    //   947: invokeinterface 306 2 0
    //   952: checkcast 8	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a
    //   955: getfield 152	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a:endTimeUs	J
    //   958: lstore 10
    //   960: ldc 228
    //   962: ldc_w 708
    //   965: aload_0
    //   966: getfield 363	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAV	I
    //   969: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   972: lload 8
    //   974: invokestatic 670	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   977: lload 10
    //   979: invokestatic 670	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   982: invokestatic 710	ram:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   985: aload_0
    //   986: lload 8
    //   988: invokespecial 685	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:kU	(J)V
    //   991: aload_0
    //   992: getfield 63	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:cuB	Z
    //   995: ifeq +22 -> 1017
    //   998: aload_0
    //   999: getfield 65	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:pauseLock	Ljava/lang/Object;
    //   1002: astore 12
    //   1004: aload 12
    //   1006: monitorenter
    //   1007: aload_0
    //   1008: getfield 65	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:pauseLock	Ljava/lang/Object;
    //   1011: invokevirtual 713	java/lang/Object:wait	()V
    //   1014: aload 12
    //   1016: monitorexit
    //   1017: iconst_0
    //   1018: istore 6
    //   1020: goto -963 -> 57
    //   1023: astore 12
    //   1025: invokestatic 335	java/lang/Thread:interrupted	()Z
    //   1028: ifeq +16 -> 1044
    //   1031: ldc 228
    //   1033: ldc_w 337
    //   1036: aload 12
    //   1038: invokestatic 261	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1041: goto -173 -> 868
    //   1044: new 339	java/lang/RuntimeException
    //   1047: dup
    //   1048: aload 12
    //   1050: invokespecial 342	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   1053: astore 13
    //   1055: aload_0
    //   1056: getfield 69	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_Alzd	Lalzd;
    //   1059: iconst_3
    //   1060: aload 13
    //   1062: invokeinterface 346 3 0
    //   1067: ldc 228
    //   1069: ldc_w 643
    //   1072: aload 12
    //   1074: invokestatic 261	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1077: aload_0
    //   1078: iconst_1
    //   1079: putfield 263	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:interruptedFlag	Z
    //   1082: iconst_0
    //   1083: istore 6
    //   1085: goto -1028 -> 57
    //   1088: aload_0
    //   1089: aload_0
    //   1090: getfield 363	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAV	I
    //   1093: iconst_1
    //   1094: iadd
    //   1095: putfield 363	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:dAV	I
    //   1098: goto -202 -> 896
    //   1101: aload_0
    //   1102: getfield 90	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:b	Lalzj;
    //   1105: getfield 488	alzj:repeat	Z
    //   1108: ifeq +24 -> 1132
    //   1111: aload_0
    //   1112: getfield 69	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_Alzd	Lalzd;
    //   1115: ifnull +12 -> 1127
    //   1118: aload_0
    //   1119: getfield 69	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_Alzd	Lalzd;
    //   1122: invokeinterface 716 1 0
    //   1127: iconst_1
    //   1128: istore_1
    //   1129: goto -138 -> 991
    //   1132: ldc 228
    //   1134: ldc_w 718
    //   1137: invokestatic 297	ram:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1140: aload_0
    //   1141: iconst_1
    //   1142: putfield 263	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:interruptedFlag	Z
    //   1145: goto -154 -> 991
    //   1148: astore 13
    //   1150: aload 12
    //   1152: monitorexit
    //   1153: aload 13
    //   1155: athrow
    //   1156: astore 12
    //   1158: ldc 228
    //   1160: new 275	java/lang/StringBuilder
    //   1163: dup
    //   1164: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   1167: ldc_w 720
    //   1170: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: aload 12
    //   1175: invokevirtual 721	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   1178: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1181: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1184: invokestatic 268	ram:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1187: aload_0
    //   1188: iconst_1
    //   1189: putfield 263	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:interruptedFlag	Z
    //   1192: goto -175 -> 1017
    //   1195: ldc 228
    //   1197: ldc_w 723
    //   1200: invokestatic 297	ram:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1203: iconst_0
    //   1204: istore_1
    //   1205: iload_1
    //   1206: aload_0
    //   1207: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:Fx	Ljava/util/List;
    //   1210: invokeinterface 222 1 0
    //   1215: if_icmpge +89 -> 1304
    //   1218: aload_0
    //   1219: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:Fx	Ljava/util/List;
    //   1222: iload_1
    //   1223: invokeinterface 306 2 0
    //   1228: checkcast 8	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a
    //   1231: invokestatic 185	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a;)Ljava/util/List;
    //   1234: invokeinterface 222 1 0
    //   1239: ifle +42 -> 1281
    //   1242: ldc 228
    //   1244: ldc_w 725
    //   1247: iconst_1
    //   1248: anewarray 4	java/lang/Object
    //   1251: dup
    //   1252: iconst_0
    //   1253: aload_0
    //   1254: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:Fx	Ljava/util/List;
    //   1257: iload_1
    //   1258: invokeinterface 306 2 0
    //   1263: checkcast 8	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a
    //   1266: invokestatic 185	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a;)Ljava/util/List;
    //   1269: invokeinterface 222 1 0
    //   1274: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1277: aastore
    //   1278: invokestatic 398	ram:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1281: aload_0
    //   1282: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:Fx	Ljava/util/List;
    //   1285: iload_1
    //   1286: invokeinterface 306 2 0
    //   1291: checkcast 8	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a
    //   1294: invokestatic 727	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a:b	(Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask$a;)V
    //   1297: iload_1
    //   1298: iconst_1
    //   1299: iadd
    //   1300: istore_1
    //   1301: goto -96 -> 1205
    //   1304: invokestatic 730	alzg:releaseAll	()V
    //   1307: aload_0
    //   1308: getfield 98	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:decoder	Landroid/media/MediaCodec;
    //   1311: invokevirtual 733	android/media/MediaCodec:stop	()V
    //   1314: aload_0
    //   1315: getfield 98	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:decoder	Landroid/media/MediaCodec;
    //   1318: invokevirtual 736	android/media/MediaCodec:release	()V
    //   1321: aload_0
    //   1322: getfield 371	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:extractor	Landroid/media/MediaExtractor;
    //   1325: invokevirtual 737	android/media/MediaExtractor:release	()V
    //   1328: aload_0
    //   1329: getfield 199	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_Alzp	Lalzp;
    //   1332: invokeinterface 738 1 0
    //   1337: aload_0
    //   1338: getfield 69	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_Alzd	Lalzd;
    //   1341: ifnull -1317 -> 24
    //   1344: aload_0
    //   1345: getfield 111	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:outputDone	Z
    //   1348: ifeq +28 -> 1376
    //   1351: aload_0
    //   1352: getfield 69	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_Alzd	Lalzd;
    //   1355: invokeinterface 741 1 0
    //   1360: return
    //   1361: astore 12
    //   1363: ldc 228
    //   1365: aload 12
    //   1367: invokevirtual 742	java/lang/Exception:toString	()Ljava/lang/String;
    //   1370: invokestatic 268	ram:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1373: goto -36 -> 1337
    //   1376: aload_0
    //   1377: getfield 69	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_Alzd	Lalzd;
    //   1380: invokeinterface 745 1 0
    //   1385: return
    //   1386: goto -1087 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1389	0	this	VideoFlowDecodeTask
    //   33	1268	1	i	int
    //   116	693	2	j	int
    //   324	497	3	k	int
    //   77	238	4	m	int
    //   137	184	5	n	int
    //   55	1029	6	bool1	boolean
    //   128	31	7	bool2	boolean
    //   531	456	8	l1	long
    //   540	438	10	l2	long
    //   1023	128	12	localThrowable	Throwable
    //   1156	18	12	localInterruptedException	InterruptedException
    //   1361	5	12	localException	Exception
    //   1053	8	13	localRuntimeException	RuntimeException
    //   1148	6	13	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   837	852	1023	java/lang/Throwable
    //   852	868	1023	java/lang/Throwable
    //   1007	1017	1148	finally
    //   1150	1153	1148	finally
    //   998	1007	1156	java/lang/InterruptedException
    //   1153	1156	1156	java/lang/InterruptedException
    //   1205	1281	1361	java/lang/Exception
    //   1281	1297	1361	java/lang/Exception
    //   1304	1337	1361	java/lang/Exception
  }
  
  public void setNoSleep(boolean paramBoolean)
  {
    this.jdField_a_of_type_Alzj.noSleep = paramBoolean;
  }
  
  public void setPlayRange(long paramLong1, long paramLong2)
  {
    if ((paramLong1 < 0L) || (paramLong2 < 0L)) {
      throw new IllegalArgumentException("both start time and end time should not less than 0");
    }
    if (paramLong2 < paramLong1) {
      throw new IllegalArgumentException("end time should not less than start time");
    }
    if (paramLong1 >= this.videoDurationMs) {
      return;
    }
    if (paramLong2 > this.videoDurationMs) {
      paramLong2 = this.videoDurationMs;
    }
    for (;;)
    {
      long l = paramLong2;
      if (paramLong2 == 0L) {
        l = this.videoDurationMs;
      }
      this.jdField_a_of_type_Alzj.startTimeMillSecond = paramLong1;
      this.jdField_a_of_type_Alzj.endTimeMillSecond = l;
      return;
    }
  }
  
  public void setRepeat(boolean paramBoolean)
  {
    this.jdField_a_of_type_Alzj.repeat = paramBoolean;
  }
  
  public void setSpeedType(int paramInt)
  {
    this.jdField_a_of_type_Alzj.speedType = paramInt;
  }
  
  static class a
  {
    private List<alzg> Fy = new ArrayList();
    private int dBa;
    private int dBb;
    public final long endTimeUs;
    public final int segmentIndex;
    public final long startTimeUs;
    
    public a(int paramInt, long paramLong1, long paramLong2)
    {
      this.segmentIndex = paramInt;
      this.startTimeUs = paramLong1;
      this.endTimeUs = paramLong2;
    }
    
    private void dLR()
    {
      Iterator localIterator = this.Fy.iterator();
      while (localIterator.hasNext()) {
        ((alzg)localIterator.next()).recycle();
      }
      this.Fy.clear();
      this.dBa = 0;
    }
    
    private void dLS()
    {
      Iterator localIterator = this.Fy.iterator();
      while (localIterator.hasNext()) {
        ((alzg)localIterator.next()).release();
      }
      this.Fy.clear();
      this.dBa = 0;
    }
    
    public String toString()
    {
      return "DecodeSegmentInfo{Index=" + this.segmentIndex + ", StartUs=" + this.startTimeUs + ", EndUs=" + this.endTimeUs + ", Size=" + this.Fy.size() + ", Decoding=" + this.dBa + '}';
    }
    
    public int v(float paramFloat)
    {
      int i = this.Fy.size();
      if (i >= 6)
      {
        alzg localalzg1 = (alzg)this.Fy.get(0);
        alzg localalzg2 = (alzg)this.Fy.get(i - 1);
        float f = (float)(localalzg2.gI() - localalzg1.gI()) * 1000.0F / (i - 1);
        paramFloat = (float)(Math.abs(localalzg2.gH()) - Math.abs(localalzg1.gH())) / ((i - 1) * paramFloat);
        f = 1.1F * f;
        if (f < paramFloat) {
          return 1;
        }
        i = (int)Math.floor(f / (f - paramFloat));
        ram.a("FlowEdit_VideoFlowDecodeTask", "averageDecodeTime = %.1f us, averagePlayTime = %.1f us, dropRate = %d", Float.valueOf(f), Float.valueOf(paramFloat), Integer.valueOf(i));
        return Math.min(8, i);
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.VideoFlowDecodeTask
 * JD-Core Version:    0.7.0.1
 */