package com.tencent.mobileqq.activity.richmedia.subtitles;

import aato;
import aatt;
import aatz;
import aaui;
import aaup;
import aliv.a;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class EncodeRunnable
  implements Runnable
{
  private long Mx = -1L;
  public final String TAG = "EncodeRunnable";
  aatz jdField_a_of_type_Aatz = new aatz();
  private aaui jdField_a_of_type_Aaui;
  private double bf = 1.0D;
  private boolean bzt = true;
  public final int cka = 16000;
  public final int ckb = 16000;
  public final int ckc = 1;
  private int ckd;
  private int cke;
  private int ckf = 3000;
  private ByteBuffer m;
  private WeakReference<aatt> mListenerRef;
  private int mSampleRate = 44100;
  private int mSeq;
  public volatile boolean mStop;
  
  public EncodeRunnable(aatt paramaatt, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EncodeRunnable", 2, "create EncodeRunable:" + paramInt);
    }
    this.mListenerRef = new WeakReference(paramaatt);
    try
    {
      this.jdField_a_of_type_Aaui = new aaui(paramInt * 11 * 2);
      if (this.jdField_a_of_type_Aaui == null) {
        return;
      }
    }
    catch (OutOfMemoryError paramaatt)
    {
      for (;;)
      {
        QLog.e("EncodeRunnable", 2, "create DataPipe OOM!!");
        this.jdField_a_of_type_Aaui = null;
      }
    }
    catch (Exception paramaatt)
    {
      for (;;)
      {
        paramaatt.printStackTrace();
        QLog.e("EncodeRunnable", 2, "DataPipe exception!!" + paramaatt);
      }
      if (paramInt != 0)
      {
        this.bf = (16000.0D / paramInt);
        this.mSampleRate = paramInt;
        return;
      }
      this.bf = 0.36281179138322D;
    }
  }
  
  private void a(SilkCodecWrapper paramSilkCodecWrapper, aatz paramaatz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EncodeRunnable", 2, "encodethread start runfast, stop:" + this.mStop + " sessionid:" + this.Mx + " combinenum:" + this.ckd + "factor:" + this.bf + " bufsize:" + 8820);
    }
    for (;;)
    {
      byte[] arrayOfByte;
      short[] arrayOfShort1;
      int i;
      long l2;
      int j;
      int k;
      long l1;
      try
      {
        ByteBuffer localByteBuffer = ByteBuffer.allocate(320000);
        arrayOfByte = new byte[8820];
        arrayOfShort1 = new short[4410];
        i = 0;
        aato localaato = new aato(this.mSampleRate / 10 * 15);
        l2 = 0L;
        j = 0;
        if (!this.mStop)
        {
          k = 0;
          if (!this.mStop)
          {
            int n = f(arrayOfByte, k, 8820 - k);
            i = n;
            if (n >= 0)
            {
              i = n;
              if (n < 8820 - k)
              {
                k += n;
                i = n;
                continue;
                if (paramaatz.a(arrayOfShort1, 0, 4410))
                {
                  l2 = System.currentTimeMillis();
                  l1 = l2;
                  if (j != 0) {
                    break label916;
                  }
                  short[] arrayOfShort2 = localaato.a();
                  localaato.reset();
                  if ((arrayOfShort2 == null) || (arrayOfShort2.length <= 0)) {
                    break label902;
                  }
                  j = localByteBuffer.position();
                  aaup.b(arrayOfShort2, 0, arrayOfShort2.length);
                  k = arrayOfShort2.length * 16000 / this.mSampleRate;
                  if (k > localByteBuffer.remaining())
                  {
                    if (QLog.isColorLevel()) {
                      QLog.e("EncodeRunnable", 2, "Buffer Overflow , Drop data, remaining2:" + localByteBuffer.remaining() + " taget:" + k);
                    }
                    localByteBuffer.clear();
                    j = 0;
                  }
                  aaup.a(this.mSampleRate, arrayOfShort2, arrayOfShort2.length, localByteBuffer);
                  if ((QLog.isColorLevel()) && ((localByteBuffer.position() - j) % 160 != 0)) {
                    QLog.e("EncodeRunnable", 2, "Resampler lost precision 1 !!!!!" + localByteBuffer.position() + " - " + j);
                  }
                  if ((this.Mx <= 0L) || (this.ckd <= 0)) {
                    break label902;
                  }
                  a(paramSilkCodecWrapper, localByteBuffer, false);
                  break label902;
                  label442:
                  if (System.currentTimeMillis() - l1 >= this.ckf) {
                    break label919;
                  }
                  k = 1;
                  j = localByteBuffer.position();
                  aaup.b(arrayOfShort1, 0, 4410);
                  n = 70560000 / this.mSampleRate;
                  if (n > localByteBuffer.remaining())
                  {
                    if (QLog.isColorLevel()) {
                      QLog.e("EncodeRunnable", 2, "Buffer Overflow , Drop data, remaining:" + localByteBuffer.remaining() + " taget:" + n);
                    }
                    localByteBuffer.clear();
                    j = 0;
                  }
                  aaup.a(this.mSampleRate, arrayOfShort1, 4410, localByteBuffer);
                  if ((QLog.isColorLevel()) && (localByteBuffer.position() - j != 3200)) {
                    QLog.e("EncodeRunnable", 2, "Resampler lost precision 2 !!!!! " + localByteBuffer.position() + " - " + j);
                  }
                  j = k;
                  if (this.Mx <= 0L) {
                    break label909;
                  }
                  j = k;
                  if (this.ckd <= 0) {
                    break label909;
                  }
                  a(paramSilkCodecWrapper, localByteBuffer, false);
                  j = k;
                  break label909;
                }
                l1 = l2;
                if (j != 0) {
                  break label916;
                }
                localaato.a(arrayOfShort1, 0, 4410);
                l1 = l2;
                break label916;
                j = k / 2;
                i = 0;
                break label925;
                if (j > 0)
                {
                  aaup.b(arrayOfShort1, 0, j);
                  aaup.a(this.mSampleRate, arrayOfShort1, j, localByteBuffer);
                }
                if ((this.Mx > 0L) && (this.ckd > 0)) {
                  a(paramSilkCodecWrapper, localByteBuffer, true);
                }
                this.mStop = true;
              }
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramSilkCodecWrapper)
      {
        paramSilkCodecWrapper.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("EncodeRunnable", 2, "encodethread run excepiton:" + paramSilkCodecWrapper);
        }
        this.mStop = true;
        return;
      }
      catch (OutOfMemoryError paramSilkCodecWrapper)
      {
        paramSilkCodecWrapper.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("EncodeRunnable", 2, "encodethread run excepiton 2:" + paramSilkCodecWrapper);
        }
        this.mStop = true;
        return;
      }
      if (k + i == 8820)
      {
        k = 0;
        while (k < 4410)
        {
          arrayOfShort1[k] = ((short)(arrayOfByte[(k * 2)] & 0xFF | arrayOfByte[(k * 2 + 1)] << 8 & 0xFF00));
          k += 1;
        }
        continue;
        label902:
        l1 = l2;
        continue;
        for (;;)
        {
          label909:
          l2 = l1;
          break;
          label916:
          break label442;
          label919:
          j = 0;
        }
        label925:
        while (i < j)
        {
          arrayOfShort1[i] = ((short)(arrayOfByte[(i * 2)] & 0xFF | arrayOfByte[(i * 2 + 1)] << 8 & 0xFF00));
          i += 1;
        }
      }
    }
  }
  
  private void a(SilkCodecWrapper paramSilkCodecWrapper, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    if ((paramByteBuffer == null) || (paramSilkCodecWrapper == null)) {}
    while (paramByteBuffer.position() == 0) {
      return;
    }
    paramByteBuffer.flip();
    for (;;)
    {
      try
      {
        if (this.m == null) {
          this.m = ByteBuffer.allocate(this.ckd * 100);
        }
        if (paramByteBuffer.remaining() <= 0) {
          break label169;
        }
        if (paramByteBuffer.remaining() < 640) {
          break;
        }
        if (a(paramSilkCodecWrapper, paramByteBuffer.array(), paramByteBuffer.position(), 640)) {
          paramByteBuffer.position(paramByteBuffer.position() + 640);
        } else {
          QLog.e("EncodeRunnable", 2, "silkdata exception resilk");
        }
      }
      catch (Exception paramSilkCodecWrapper)
      {
        paramSilkCodecWrapper.printStackTrace();
        QLog.e("EncodeRunnable", 2, "silkdata exception 1:" + paramSilkCodecWrapper);
        return;
      }
    }
    if (paramBoolean)
    {
      if (!a(paramSilkCodecWrapper, paramByteBuffer.array(), paramByteBuffer.position(), paramByteBuffer.limit())) {
        break label175;
      }
      paramByteBuffer.position(paramByteBuffer.limit());
    }
    for (;;)
    {
      label169:
      paramByteBuffer.compact();
      return;
      label175:
      QLog.e("EncodeRunnable", 2, "silkdata exception resilk 2");
    }
  }
  
  private boolean a(SilkCodecWrapper paramSilkCodecWrapper, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramSilkCodecWrapper == null) || (paramArrayOfByte == null) || (paramInt2 <= 0) || (paramArrayOfByte.length < paramInt1 + paramInt2)) {
      return false;
    }
    for (;;)
    {
      try
      {
        paramSilkCodecWrapper = paramSilkCodecWrapper.a(paramArrayOfByte, paramInt1, paramInt2);
        if (paramSilkCodecWrapper != null)
        {
          if (!QLog.isColorLevel()) {
            break label263;
          }
          break label263;
          if (paramInt1 < paramSilkCodecWrapper.size)
          {
            paramInt2 = e(paramSilkCodecWrapper.data, paramSilkCodecWrapper.offset + paramInt1);
            if (paramInt2 > 0)
            {
              paramArrayOfByte = a(paramInt2, this.Mx, this.mSeq);
              if (paramArrayOfByte != null)
              {
                this.mSeq += 1;
                this.m.put(paramArrayOfByte);
                this.m.put(paramSilkCodecWrapper.data, paramSilkCodecWrapper.offset + paramInt1 + 2, paramInt2);
                this.cke += 1;
              }
            }
            else
            {
              if (this.cke < this.ckd) {
                break label268;
              }
              this.m.flip();
              if (this.mListenerRef != null)
              {
                paramArrayOfByte = (aatt)this.mListenerRef.get();
                if (paramArrayOfByte != null) {
                  paramArrayOfByte.a(this.Mx, this.m);
                }
              }
              this.m.clear();
              this.cke = 0;
              break label268;
            }
            QLog.e("EncodeRunnable", 2, "getPkgHead is null!");
            continue;
          }
        }
        return true;
      }
      catch (Exception paramSilkCodecWrapper)
      {
        paramSilkCodecWrapper.printStackTrace();
        QLog.e("EncodeRunnable", 2, "silkPieceData exception:" + paramSilkCodecWrapper);
        return false;
      }
      label263:
      paramInt1 = 0;
      continue;
      label268:
      paramInt1 = paramInt2 + 2 + paramInt1;
    }
  }
  
  /* Error */
  private static byte[] a(int paramInt, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: new 303	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 304	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 6
    //   9: new 306	java/io/DataOutputStream
    //   12: dup
    //   13: aload 6
    //   15: invokespecial 309	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore 5
    //   20: aload 5
    //   22: bipush 91
    //   24: invokevirtual 312	java/io/DataOutputStream:writeByte	(I)V
    //   27: aload 5
    //   29: bipush 17
    //   31: iload_0
    //   32: iadd
    //   33: invokevirtual 315	java/io/DataOutputStream:writeShort	(I)V
    //   36: aload 5
    //   38: iconst_1
    //   39: invokevirtual 312	java/io/DataOutputStream:writeByte	(I)V
    //   42: aload 5
    //   44: iconst_0
    //   45: invokevirtual 312	java/io/DataOutputStream:writeByte	(I)V
    //   48: aload 5
    //   50: lload_3
    //   51: ldc2_w 316
    //   54: land
    //   55: l2i
    //   56: invokevirtual 320	java/io/DataOutputStream:writeInt	(I)V
    //   59: aload 5
    //   61: lload_1
    //   62: ldc2_w 316
    //   65: land
    //   66: l2i
    //   67: invokevirtual 320	java/io/DataOutputStream:writeInt	(I)V
    //   70: aload 5
    //   72: invokestatic 174	java/lang/System:currentTimeMillis	()J
    //   75: ldc2_w 316
    //   78: land
    //   79: l2i
    //   80: invokevirtual 320	java/io/DataOutputStream:writeInt	(I)V
    //   83: aload 6
    //   85: invokevirtual 323	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   88: astore 6
    //   90: aload 5
    //   92: invokevirtual 326	java/io/DataOutputStream:close	()V
    //   95: aload 6
    //   97: areturn
    //   98: astore 6
    //   100: aload 6
    //   102: invokevirtual 327	java/io/IOException:printStackTrace	()V
    //   105: aload 5
    //   107: invokevirtual 326	java/io/DataOutputStream:close	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore 5
    //   114: aconst_null
    //   115: areturn
    //   116: astore 6
    //   118: aload 5
    //   120: invokevirtual 326	java/io/DataOutputStream:close	()V
    //   123: aload 6
    //   125: athrow
    //   126: astore 5
    //   128: aload 6
    //   130: areturn
    //   131: astore 5
    //   133: goto -10 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramInt	int
    //   0	136	1	paramLong1	long
    //   0	136	3	paramLong2	long
    //   18	88	5	localDataOutputStream	java.io.DataOutputStream
    //   112	7	5	localException1	Exception
    //   126	1	5	localException2	Exception
    //   131	1	5	localException3	Exception
    //   7	89	6	localObject	Object
    //   98	3	6	localIOException	java.io.IOException
    //   116	13	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   20	90	98	java/io/IOException
    //   105	110	112	java/lang/Exception
    //   20	90	116	finally
    //   100	105	116	finally
    //   90	95	126	java/lang/Exception
    //   118	123	131	java/lang/Exception
  }
  
  private int e(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[(paramInt + 0)] & 0xFF) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8);
  }
  
  private int f(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      if (this.jdField_a_of_type_Aaui != null)
      {
        paramInt1 = this.jdField_a_of_type_Aaui.read(paramArrayOfByte, paramInt1, paramInt2);
        return paramInt1;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      QLog.e("EncodeRunnable", 2, "readpipe exception:" + paramArrayOfByte);
    }
    return -1;
  }
  
  private void unInit()
  {
    this.mStop = true;
    if (this.jdField_a_of_type_Aaui != null) {}
    try
    {
      this.jdField_a_of_type_Aaui.close();
      label19:
      this.jdField_a_of_type_Aaui = null;
      return;
    }
    catch (Exception localException)
    {
      break label19;
    }
  }
  
  public void De(boolean paramBoolean)
  {
    this.jdField_a_of_type_Aatz.De(paramBoolean);
  }
  
  public void ap(long paramLong, int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("EncodeRunnable", 2, "setEncodeParam old param, sessionid:" + this.Mx + " combinenum:" + this.ckd + "; new param, sessionid:" + paramLong + " combinenum:" + paramInt);
      }
      this.Mx = paramLong;
      this.ckd = paramInt;
      return;
    }
    finally {}
  }
  
  public boolean isStop()
  {
    return this.mStop;
  }
  
  public void l(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      if (this.jdField_a_of_type_Aaui == null) {
        return;
      }
      if (paramArrayOfByte != null)
      {
        if (this.jdField_a_of_type_Aaui.zg() >= paramInt2)
        {
          this.jdField_a_of_type_Aaui.write(paramArrayOfByte, paramInt1, paramInt2);
          this.jdField_a_of_type_Aaui.flush();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.e("EncodeRunnable", 2, "WritePipe buffer limit!!!, drop data");
        }
        this.jdField_a_of_type_Aaui.flush();
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      QLog.e("EncodeRunnable", 2, "writepipe exception:" + paramArrayOfByte);
      this.jdField_a_of_type_Aaui = null;
      this.mStop = true;
      return;
    }
    this.jdField_a_of_type_Aaui.close();
    this.jdField_a_of_type_Aaui = null;
    this.mStop = true;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 109	com/tencent/mobileqq/activity/richmedia/subtitles/EncodeRunnable:jdField_a_of_type_Aaui	Laaui;
    //   4: ifnonnull +23 -> 27
    //   7: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +12 -> 22
    //   13: ldc 49
    //   15: iconst_2
    //   16: ldc_w 363
    //   19: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aload_0
    //   23: invokespecial 365	com/tencent/mobileqq/activity/richmedia/subtitles/EncodeRunnable:unInit	()V
    //   26: return
    //   27: new 254	com/tencent/mobileqq/utils/SilkCodecWrapper
    //   30: dup
    //   31: invokestatic 371	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   34: invokespecial 374	com/tencent/mobileqq/utils/SilkCodecWrapper:<init>	(Landroid/content/Context;)V
    //   37: astore_1
    //   38: aload_1
    //   39: sipush 16000
    //   42: sipush 16000
    //   45: iconst_1
    //   46: invokevirtual 378	com/tencent/mobileqq/utils/SilkCodecWrapper:init	(III)V
    //   49: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq +12 -> 64
    //   55: ldc 49
    //   57: iconst_2
    //   58: ldc_w 380
    //   61: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_0
    //   65: getfield 69	com/tencent/mobileqq/activity/richmedia/subtitles/EncodeRunnable:jdField_a_of_type_Aatz	Laatz;
    //   68: aload_0
    //   69: getfield 62	com/tencent/mobileqq/activity/richmedia/subtitles/EncodeRunnable:mSampleRate	I
    //   72: invokevirtual 382	aatz:init	(I)V
    //   75: bipush 237
    //   77: invokestatic 387	android/os/Process:setThreadPriority	(I)V
    //   80: aload_0
    //   81: getfield 59	com/tencent/mobileqq/activity/richmedia/subtitles/EncodeRunnable:bzt	Z
    //   84: ifne +67 -> 151
    //   87: aload_1
    //   88: ifnull +7 -> 95
    //   91: aload_1
    //   92: invokevirtual 390	com/tencent/mobileqq/utils/SilkCodecWrapper:release	()V
    //   95: aload_0
    //   96: invokespecial 365	com/tencent/mobileqq/activity/richmedia/subtitles/EncodeRunnable:unInit	()V
    //   99: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq -76 -> 26
    //   105: ldc 49
    //   107: iconst_2
    //   108: ldc_w 392
    //   111: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: return
    //   115: astore_1
    //   116: aload_1
    //   117: invokevirtual 117	java/lang/Exception:printStackTrace	()V
    //   120: ldc 49
    //   122: iconst_2
    //   123: new 77	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   130: ldc_w 394
    //   133: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_1
    //   137: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   146: aload_0
    //   147: invokespecial 365	com/tencent/mobileqq/activity/richmedia/subtitles/EncodeRunnable:unInit	()V
    //   150: return
    //   151: aload_0
    //   152: aload_1
    //   153: aload_0
    //   154: getfield 69	com/tencent/mobileqq/activity/richmedia/subtitles/EncodeRunnable:jdField_a_of_type_Aatz	Laatz;
    //   157: invokespecial 396	com/tencent/mobileqq/activity/richmedia/subtitles/EncodeRunnable:a	(Lcom/tencent/mobileqq/utils/SilkCodecWrapper;Laatz;)V
    //   160: goto -73 -> 87
    //   163: astore_1
    //   164: aload_1
    //   165: invokevirtual 117	java/lang/Exception:printStackTrace	()V
    //   168: goto -73 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	EncodeRunnable
    //   37	55	1	localSilkCodecWrapper	SilkCodecWrapper
    //   115	38	1	localException1	Exception
    //   163	2	1	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   38	49	115	java/lang/Exception
    //   91	95	163	java/lang/Exception
  }
  
  public void stop()
  {
    this.mStop = true;
    l(null, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.subtitles.EncodeRunnable
 * JD-Core Version:    0.7.0.1
 */