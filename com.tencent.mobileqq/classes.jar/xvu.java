import com.tencent.mobileqq.activity.richmedia.subtitles.NoiseDetector;
import com.tencent.mobileqq.activity.richmedia.subtitles.RDDataPipe;
import com.tencent.mobileqq.activity.richmedia.subtitles.resample.Resampler;
import com.tencent.mobileqq.ptt.processor.IPttProcessor.ProcessData;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class xvu
  implements Runnable
{
  private double jdField_a_of_type_Double = 1.0D;
  public final int a;
  private long jdField_a_of_type_Long = -1L;
  NoiseDetector jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesNoiseDetector = new NoiseDetector();
  private RDDataPipe jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesRDDataPipe;
  public final String a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  public volatile boolean a;
  public final int b;
  private boolean b;
  public final int c = 1;
  private int d;
  private int e;
  private int f;
  private int g = 44100;
  private int h = 3000;
  
  public xvu(xvv paramxvv, int paramInt)
  {
    this.jdField_a_of_type_Int = 16000;
    this.jdField_b_of_type_Int = 16000;
    this.jdField_a_of_type_JavaLangString = "EncodeRunnable";
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("EncodeRunnable", 2, "create EncodeRunable:" + paramInt);
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramxvv);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesRDDataPipe = new RDDataPipe(paramInt * 11 * 2);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesRDDataPipe == null) {
        return;
      }
    }
    catch (OutOfMemoryError paramxvv)
    {
      for (;;)
      {
        QLog.e("EncodeRunnable", 2, "create DataPipe OOM!!");
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesRDDataPipe = null;
      }
    }
    catch (Exception paramxvv)
    {
      for (;;)
      {
        paramxvv.printStackTrace();
        QLog.e("EncodeRunnable", 2, "DataPipe exception!!" + paramxvv);
      }
      if (paramInt != 0)
      {
        this.jdField_a_of_type_Double = (16000.0D / paramInt);
        this.g = paramInt;
        return;
      }
      this.jdField_a_of_type_Double = 0.36281179138322D;
    }
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[(paramInt + 0)] & 0xFF) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8);
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesRDDataPipe != null)
      {
        paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesRDDataPipe.b(paramArrayOfByte, paramInt1, paramInt2);
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
  
  private void a(SilkCodecWrapper paramSilkCodecWrapper, NoiseDetector paramNoiseDetector)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EncodeRunnable", 2, "encodethread start runfast, stop:" + this.jdField_a_of_type_Boolean + " sessionid:" + this.jdField_a_of_type_Long + " combinenum:" + this.d + "factor:" + this.jdField_a_of_type_Double + " bufsize:" + 8820);
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
        xvp localxvp = new xvp(this.g / 10 * 15);
        l2 = 0L;
        j = 0;
        if (!this.jdField_a_of_type_Boolean)
        {
          k = 0;
          if (!this.jdField_a_of_type_Boolean)
          {
            int m = a(arrayOfByte, k, 8820 - k);
            i = m;
            if (m >= 0)
            {
              i = m;
              if (m < 8820 - k)
              {
                k += m;
                i = m;
                continue;
                if (paramNoiseDetector.a(arrayOfShort1, 0, 4410))
                {
                  l2 = System.currentTimeMillis();
                  l1 = l2;
                  if (j != 0) {
                    break label916;
                  }
                  short[] arrayOfShort2 = localxvp.a();
                  localxvp.a();
                  if ((arrayOfShort2 == null) || (arrayOfShort2.length <= 0)) {
                    break label902;
                  }
                  j = localByteBuffer.position();
                  Resampler.a(arrayOfShort2, 0, arrayOfShort2.length);
                  k = arrayOfShort2.length * 16000 / this.g;
                  if (k > localByteBuffer.remaining())
                  {
                    if (QLog.isColorLevel()) {
                      QLog.e("EncodeRunnable", 2, "Buffer Overflow , Drop data, remaining2:" + localByteBuffer.remaining() + " taget:" + k);
                    }
                    localByteBuffer.clear();
                    j = 0;
                  }
                  Resampler.a(this.g, arrayOfShort2, arrayOfShort2.length, localByteBuffer);
                  if ((QLog.isColorLevel()) && ((localByteBuffer.position() - j) % 160 != 0)) {
                    QLog.e("EncodeRunnable", 2, "Resampler lost precision 1 !!!!!" + localByteBuffer.position() + " - " + j);
                  }
                  if ((this.jdField_a_of_type_Long <= 0L) || (this.d <= 0)) {
                    break label902;
                  }
                  a(paramSilkCodecWrapper, localByteBuffer, false);
                  break label902;
                  label442:
                  if (System.currentTimeMillis() - l1 >= this.h) {
                    break label919;
                  }
                  k = 1;
                  j = localByteBuffer.position();
                  Resampler.a(arrayOfShort1, 0, 4410);
                  m = 70560000 / this.g;
                  if (m > localByteBuffer.remaining())
                  {
                    if (QLog.isColorLevel()) {
                      QLog.e("EncodeRunnable", 2, "Buffer Overflow , Drop data, remaining:" + localByteBuffer.remaining() + " taget:" + m);
                    }
                    localByteBuffer.clear();
                    j = 0;
                  }
                  Resampler.a(this.g, arrayOfShort1, 4410, localByteBuffer);
                  if ((QLog.isColorLevel()) && (localByteBuffer.position() - j != 3200)) {
                    QLog.e("EncodeRunnable", 2, "Resampler lost precision 2 !!!!! " + localByteBuffer.position() + " - " + j);
                  }
                  j = k;
                  if (this.jdField_a_of_type_Long <= 0L) {
                    break label909;
                  }
                  j = k;
                  if (this.d <= 0) {
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
                localxvp.a(arrayOfShort1, 0, 4410);
                l1 = l2;
                break label916;
                j = k / 2;
                i = 0;
                break label925;
                if (j > 0)
                {
                  Resampler.a(arrayOfShort1, 0, j);
                  Resampler.a(this.g, arrayOfShort1, j, localByteBuffer);
                }
                if ((this.jdField_a_of_type_Long > 0L) && (this.d > 0)) {
                  a(paramSilkCodecWrapper, localByteBuffer, true);
                }
                this.jdField_a_of_type_Boolean = true;
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
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (OutOfMemoryError paramSilkCodecWrapper)
      {
        paramSilkCodecWrapper.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("EncodeRunnable", 2, "encodethread run excepiton 2:" + paramSilkCodecWrapper);
        }
        this.jdField_a_of_type_Boolean = true;
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
        if (this.jdField_a_of_type_JavaNioByteBuffer == null) {
          this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(this.d * 100);
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
          if (paramInt1 < paramSilkCodecWrapper.jdField_a_of_type_Int)
          {
            paramInt2 = a(paramSilkCodecWrapper.jdField_a_of_type_ArrayOfByte, paramSilkCodecWrapper.jdField_b_of_type_Int + paramInt1);
            if (paramInt2 > 0)
            {
              paramArrayOfByte = a(paramInt2, this.jdField_a_of_type_Long, this.f);
              if (paramArrayOfByte != null)
              {
                this.f += 1;
                this.jdField_a_of_type_JavaNioByteBuffer.put(paramArrayOfByte);
                this.jdField_a_of_type_JavaNioByteBuffer.put(paramSilkCodecWrapper.jdField_a_of_type_ArrayOfByte, paramSilkCodecWrapper.jdField_b_of_type_Int + paramInt1 + 2, paramInt2);
                this.e += 1;
              }
            }
            else
            {
              if (this.e < this.d) {
                break label268;
              }
              this.jdField_a_of_type_JavaNioByteBuffer.flip();
              if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
              {
                paramArrayOfByte = (xvv)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                if (paramArrayOfByte != null) {
                  paramArrayOfByte.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaNioByteBuffer);
                }
              }
              this.jdField_a_of_type_JavaNioByteBuffer.clear();
              this.e = 0;
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
    //   0: new 287	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 288	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 6
    //   9: new 290	java/io/DataOutputStream
    //   12: dup
    //   13: aload 6
    //   15: invokespecial 293	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore 5
    //   20: aload 5
    //   22: bipush 91
    //   24: invokevirtual 296	java/io/DataOutputStream:writeByte	(I)V
    //   27: aload 5
    //   29: bipush 17
    //   31: iload_0
    //   32: iadd
    //   33: invokevirtual 299	java/io/DataOutputStream:writeShort	(I)V
    //   36: aload 5
    //   38: iconst_1
    //   39: invokevirtual 296	java/io/DataOutputStream:writeByte	(I)V
    //   42: aload 5
    //   44: iconst_0
    //   45: invokevirtual 296	java/io/DataOutputStream:writeByte	(I)V
    //   48: aload 5
    //   50: lload_3
    //   51: ldc2_w 300
    //   54: land
    //   55: l2i
    //   56: invokevirtual 304	java/io/DataOutputStream:writeInt	(I)V
    //   59: aload 5
    //   61: lload_1
    //   62: ldc2_w 300
    //   65: land
    //   66: l2i
    //   67: invokevirtual 304	java/io/DataOutputStream:writeInt	(I)V
    //   70: aload 5
    //   72: invokestatic 167	java/lang/System:currentTimeMillis	()J
    //   75: ldc2_w 300
    //   78: land
    //   79: l2i
    //   80: invokevirtual 304	java/io/DataOutputStream:writeInt	(I)V
    //   83: aload 6
    //   85: invokevirtual 307	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   88: astore 6
    //   90: aload 5
    //   92: invokevirtual 310	java/io/DataOutputStream:close	()V
    //   95: aload 6
    //   97: areturn
    //   98: astore 6
    //   100: aload 6
    //   102: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   105: aload 5
    //   107: invokevirtual 310	java/io/DataOutputStream:close	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore 5
    //   114: aconst_null
    //   115: areturn
    //   116: astore 6
    //   118: aload 5
    //   120: invokevirtual 310	java/io/DataOutputStream:close	()V
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
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesRDDataPipe != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesRDDataPipe.a();
      label19:
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesRDDataPipe = null;
      return;
    }
    catch (Exception localException)
    {
      break label19;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    a(null, 0, 0);
  }
  
  public void a(long paramLong, int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("EncodeRunnable", 2, "setEncodeParam old param, sessionid:" + this.jdField_a_of_type_Long + " combinenum:" + this.d + "; new param, sessionid:" + paramLong + " combinenum:" + paramInt);
      }
      this.jdField_a_of_type_Long = paramLong;
      this.d = paramInt;
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesNoiseDetector.a(paramBoolean);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesRDDataPipe == null) {
        return;
      }
      if (paramArrayOfByte != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesRDDataPipe.b() >= paramInt2)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesRDDataPipe.c(paramArrayOfByte, paramInt1, paramInt2);
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesRDDataPipe.b();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.e("EncodeRunnable", 2, "WritePipe buffer limit!!!, drop data");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesRDDataPipe.b();
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      QLog.e("EncodeRunnable", 2, "writepipe exception:" + paramArrayOfByte);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesRDDataPipe = null;
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesRDDataPipe.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesRDDataPipe = null;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 99	xvu:jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesRDDataPipe	Lcom/tencent/mobileqq/activity/richmedia/subtitles/RDDataPipe;
    //   4: ifnonnull +23 -> 27
    //   7: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +12 -> 22
    //   13: ldc 40
    //   15: iconst_2
    //   16: ldc_w 336
    //   19: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aload_0
    //   23: invokespecial 337	xvu:b	()V
    //   26: return
    //   27: new 244	com/tencent/mobileqq/utils/SilkCodecWrapper
    //   30: dup
    //   31: invokestatic 343	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   34: invokespecial 346	com/tencent/mobileqq/utils/SilkCodecWrapper:<init>	(Landroid/content/Context;)V
    //   37: astore_1
    //   38: aload_1
    //   39: sipush 16000
    //   42: sipush 16000
    //   45: iconst_1
    //   46: invokevirtual 349	com/tencent/mobileqq/utils/SilkCodecWrapper:a	(III)V
    //   49: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq +12 -> 64
    //   55: ldc 40
    //   57: iconst_2
    //   58: ldc_w 351
    //   61: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_0
    //   65: getfield 60	xvu:jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesNoiseDetector	Lcom/tencent/mobileqq/activity/richmedia/subtitles/NoiseDetector;
    //   68: aload_0
    //   69: getfield 53	xvu:g	I
    //   72: invokevirtual 353	com/tencent/mobileqq/activity/richmedia/subtitles/NoiseDetector:a	(I)V
    //   75: bipush 237
    //   77: invokestatic 358	android/os/Process:setThreadPriority	(I)V
    //   80: aload_0
    //   81: getfield 50	xvu:jdField_b_of_type_Boolean	Z
    //   84: ifne +67 -> 151
    //   87: aload_1
    //   88: ifnull +7 -> 95
    //   91: aload_1
    //   92: invokevirtual 359	com/tencent/mobileqq/utils/SilkCodecWrapper:a	()V
    //   95: aload_0
    //   96: invokespecial 337	xvu:b	()V
    //   99: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq -76 -> 26
    //   105: ldc 40
    //   107: iconst_2
    //   108: ldc_w 361
    //   111: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: return
    //   115: astore_1
    //   116: aload_1
    //   117: invokevirtual 106	java/lang/Exception:printStackTrace	()V
    //   120: ldc 40
    //   122: iconst_2
    //   123: new 68	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   130: ldc_w 363
    //   133: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_1
    //   137: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   146: aload_0
    //   147: invokespecial 337	xvu:b	()V
    //   150: return
    //   151: aload_0
    //   152: aload_1
    //   153: aload_0
    //   154: getfield 60	xvu:jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesNoiseDetector	Lcom/tencent/mobileqq/activity/richmedia/subtitles/NoiseDetector;
    //   157: invokespecial 365	xvu:a	(Lcom/tencent/mobileqq/utils/SilkCodecWrapper;Lcom/tencent/mobileqq/activity/richmedia/subtitles/NoiseDetector;)V
    //   160: goto -73 -> 87
    //   163: astore_1
    //   164: aload_1
    //   165: invokevirtual 106	java/lang/Exception:printStackTrace	()V
    //   168: goto -73 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	xvu
    //   37	55	1	localSilkCodecWrapper	SilkCodecWrapper
    //   115	38	1	localException1	Exception
    //   163	2	1	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   38	49	115	java/lang/Exception
    //   91	95	163	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xvu
 * JD-Core Version:    0.7.0.1
 */