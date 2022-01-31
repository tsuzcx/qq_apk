package com.tencent.mobileqq.msf.core.b.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.msf.service.protocol.push.a.b;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.CRC32;

public class a
  implements Runnable
{
  private static final String A = "Set-Cookie:";
  private static final String B = "Content-Length:";
  private static final String C = "md5=";
  private static final String D = "gateway=";
  private static final String E = ";";
  private static final String F = "\r\n";
  private static final String G = "\r\n\r\n";
  private static final String H = "200";
  private static final int I = 10240;
  private static final int J = 2;
  private static final String y = "HTTP/1.";
  private static final String z = "Cookie:";
  private String K = "";
  private int L;
  private int M;
  private boolean N = true;
  a a;
  com.tencent.msf.service.protocol.push.a.c b;
  b c;
  int d;
  int e;
  DatagramSocket f = null;
  Socket g = null;
  OutputStream h = null;
  InetAddress i = null;
  int j;
  d k = new d();
  c l = new c();
  long m = 0L;
  long n = 0L;
  long o = 0L;
  long p = 0L;
  long q = 0L;
  long r = 0L;
  long s = 0L;
  long t = 0L;
  long u = 0L;
  long v = 0L;
  long w = 0L;
  long x = 0L;
  
  public a(com.tencent.msf.service.protocol.push.a.c paramc, b paramb, a parama, int paramInt1, int paramInt2)
  {
    this.b = paramc;
    this.c = paramb;
    this.a = parama;
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public static int a(int paramInt)
  {
    return (0xFF00 & paramInt) >> 8 | (paramInt & 0xFF) << 8;
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: new 162	java/io/BufferedReader
    //   3: dup
    //   4: new 164	java/io/FileReader
    //   7: dup
    //   8: ldc 166
    //   10: invokespecial 169	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   13: sipush 8192
    //   16: invokespecial 172	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   19: astore_1
    //   20: aload_1
    //   21: astore_0
    //   22: aload_1
    //   23: invokevirtual 175	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   26: ldc 177
    //   28: ldc 110
    //   30: invokevirtual 183	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   33: ldc 185
    //   35: invokevirtual 189	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   38: astore_2
    //   39: aload_1
    //   40: astore_0
    //   41: invokestatic 195	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   44: ifeq +32 -> 76
    //   47: aload_1
    //   48: astore_0
    //   49: ldc 197
    //   51: iconst_4
    //   52: new 199	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   59: ldc 202
    //   61: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_2
    //   65: iconst_1
    //   66: aaload
    //   67: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_1
    //   77: invokevirtual 215	java/io/BufferedReader:close	()V
    //   80: aload_2
    //   81: iconst_1
    //   82: aaload
    //   83: areturn
    //   84: astore_0
    //   85: invokestatic 195	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   88: ifeq +11 -> 99
    //   91: ldc 197
    //   93: iconst_4
    //   94: ldc 217
    //   96: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: aload_0
    //   100: invokevirtual 220	java/lang/Exception:printStackTrace	()V
    //   103: goto -23 -> 80
    //   106: astore_2
    //   107: aconst_null
    //   108: astore_1
    //   109: aload_1
    //   110: astore_0
    //   111: invokestatic 195	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   114: ifeq +13 -> 127
    //   117: aload_1
    //   118: astore_0
    //   119: ldc 197
    //   121: iconst_4
    //   122: ldc 222
    //   124: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: aload_1
    //   128: astore_0
    //   129: aload_2
    //   130: invokevirtual 220	java/lang/Exception:printStackTrace	()V
    //   133: aload_1
    //   134: invokevirtual 215	java/io/BufferedReader:close	()V
    //   137: ldc 224
    //   139: areturn
    //   140: astore_0
    //   141: invokestatic 195	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   144: ifeq +11 -> 155
    //   147: ldc 197
    //   149: iconst_4
    //   150: ldc 217
    //   152: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload_0
    //   156: invokevirtual 220	java/lang/Exception:printStackTrace	()V
    //   159: ldc 224
    //   161: areturn
    //   162: astore_1
    //   163: aconst_null
    //   164: astore_0
    //   165: aload_0
    //   166: invokevirtual 215	java/io/BufferedReader:close	()V
    //   169: aload_1
    //   170: athrow
    //   171: astore_0
    //   172: invokestatic 195	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   175: ifeq +11 -> 186
    //   178: ldc 197
    //   180: iconst_4
    //   181: ldc 217
    //   183: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: aload_0
    //   187: invokevirtual 220	java/lang/Exception:printStackTrace	()V
    //   190: goto -21 -> 169
    //   193: astore_1
    //   194: goto -29 -> 165
    //   197: astore_2
    //   198: goto -89 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   21	28	0	localBufferedReader1	java.io.BufferedReader
    //   84	16	0	localException1	Exception
    //   110	19	0	localBufferedReader2	java.io.BufferedReader
    //   140	16	0	localException2	Exception
    //   164	2	0	localObject1	Object
    //   171	16	0	localException3	Exception
    //   19	115	1	localBufferedReader3	java.io.BufferedReader
    //   162	8	1	localObject2	Object
    //   193	1	1	localObject3	Object
    //   38	43	2	arrayOfString	String[]
    //   106	24	2	localException4	Exception
    //   197	1	2	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   76	80	84	java/lang/Exception
    //   0	20	106	java/lang/Exception
    //   133	137	140	java/lang/Exception
    //   0	20	162	finally
    //   165	169	171	java/lang/Exception
    //   22	39	193	finally
    //   41	47	193	finally
    //   49	76	193	finally
    //   111	117	193	finally
    //   119	127	193	finally
    //   129	133	193	finally
    //   22	39	197	java/lang/Exception
    //   41	47	197	java/lang/Exception
    //   49	76	197	java/lang/Exception
  }
  
  public static InetAddress a(long paramLong)
    throws UnknownHostException
  {
    int i1 = (byte)(int)(paramLong >> 24 & 0xFF);
    int i2 = (byte)(int)(paramLong >> 16 & 0xFF);
    int i3 = (byte)(int)(paramLong >> 8 & 0xFF);
    return InetAddress.getByAddress(new byte[] { (byte)(int)(paramLong & 0xFF), i3, i2, i1 });
  }
  
  private void a(a.d.a parama)
  {
    if (this.k.c.containsKey(parama))
    {
      int i1 = ((Integer)this.k.c.get(parama)).intValue();
      this.k.c.put(parama, Integer.valueOf(i1 + 1));
      return;
    }
    this.k.c.put(parama, Integer.valueOf(1));
  }
  
  private void a(a.d.a parama, boolean paramBoolean)
  {
    if (parama == a.d.a.a) {
      this.k.b = parama;
    }
    for (;;)
    {
      label43:
      label71:
      Object localObject;
      if (this.r != 0L)
      {
        this.k.p = ((int)((float)this.s / (float)this.r));
        if (this.v == 0L) {
          break label435;
        }
        this.k.q = ((int)((float)this.w / (float)this.v));
        parama = this.k.toString();
        if (!TextUtils.isEmpty(this.K)) {
          break label446;
        }
        this.K += "(";
        if ((this.b != null) && (this.c == null) && (this.l.a == a.c.a.a) && (this.k.a == a.d.b.a)) {
          this.K += this.l.toString();
        }
        label187:
        this.K += parama;
        if (paramBoolean)
        {
          this.K += ")";
          localObject = new CRC32();
          parama = new ArrayList();
        }
      }
      try
      {
        ((CRC32)localObject).update(this.K.getBytes("UTF-8"));
        this.K += ((CRC32)localObject).getValue();
        parama.add(this.K.getBytes("utf-8"));
        localObject = new HashMap();
        ((HashMap)localObject).put("QualTest", parama);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        try
        {
          c.a(this.N, this.b, this.c, this.M, this.L);
          c.d.configManager.a((HashMap)localObject, "");
          QLog.d("MSF.C.QualityTestManager", 1, "QualityClient finish, succ: " + this.K);
          return;
          this.k.b = a.d.a.b;
          if (parama == a.d.a.b) {
            continue;
          }
          a(parama);
          continue;
          this.k.p = 0;
          break label43;
          label435:
          this.k.q = 0;
          break label71;
          label446:
          if ((this.K.endsWith("#")) || (this.K.endsWith("("))) {
            break label187;
          }
          this.K += "*";
          break label187;
          localUnsupportedEncodingException = localUnsupportedEncodingException;
          localUnsupportedEncodingException.printStackTrace();
        }
        catch (Exception parama)
        {
          for (;;)
          {
            parama.printStackTrace();
          }
        }
      }
    }
  }
  
  private boolean a(com.tencent.msf.service.protocol.push.a.a parama)
  {
    int i2 = 10000;
    int i1;
    if (this.b != null)
    {
      this.k.z = this.b.i;
      i1 = i2;
      if (this.b.i > 0L)
      {
        i1 = i2;
        if (this.b.i < 600L) {
          i1 = (int)this.b.i * 1000;
        }
      }
    }
    for (;;)
    {
      try
      {
        long l1 = parama.a;
        i2 = parama.b;
        this.i = a(l1);
        this.j = a(i2);
        this.k.e = this.i;
        this.k.f = this.j;
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: Start connecting " + this.i + " port:" + this.j + " mTestType:" + this.a);
        }
        i2 = 1.a[this.a.ordinal()];
        switch (i2)
        {
        default: 
          return false;
        }
      }
      catch (Exception parama)
      {
        this.k.B.add(Long.valueOf(-1L));
        parama.printStackTrace();
        return false;
      }
      i1 = i2;
      if (this.c != null)
      {
        this.k.z = this.c.i;
        i1 = i2;
        if (this.c.i > 0L)
        {
          i1 = i2;
          if (this.c.i < 600L)
          {
            i1 = (int)this.c.i * 1000;
            continue;
            this.f = new DatagramSocket();
            this.f.setSoTimeout(i1);
            this.k.B.add(Long.valueOf(-1L));
          }
        }
      }
    }
    for (;;)
    {
      return true;
      try
      {
        parama = new InetSocketAddress(this.i, this.j);
        this.g = new Socket();
        this.g.setSoTimeout(i1);
        this.g.setTcpNoDelay(true);
        this.g.setKeepAlive(true);
        this.m = System.currentTimeMillis();
        this.g.connect(parama, i1);
        this.n = System.currentTimeMillis();
        this.o = (this.n - this.m);
        this.k.B.add(Long.valueOf(this.o));
        this.h = this.g.getOutputStream();
      }
      catch (Throwable parama)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: connecting " + this.i + " port:" + this.j + " mTestType:" + this.a + " failed", parama);
        }
        parama = this.k;
        parama.o += 1;
        this.k.B.add(Long.valueOf(-1L));
        return false;
      }
      try
      {
        parama = new InetSocketAddress(this.i, this.j);
        this.g = new Socket();
        this.g.setSoTimeout(i1);
        this.g.setTcpNoDelay(true);
        this.g.setKeepAlive(true);
        this.m = System.currentTimeMillis();
        this.g.connect(parama, i1);
        this.n = System.currentTimeMillis();
        this.o = (this.n - this.m);
        this.k.B.add(Long.valueOf(this.o));
        this.h = this.g.getOutputStream();
      }
      catch (Throwable parama)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: connecting " + this.i + " port:" + this.j + " mTestType:" + this.a + " failed", parama);
        }
        parama = this.k;
        parama.o += 1;
        this.k.B.add(Long.valueOf(-1L));
      }
    }
    return false;
  }
  
  private boolean a(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      try
      {
        switch (1.a[this.a.ordinal()])
        {
        case 1: 
          DatagramPacket localDatagramPacket = new DatagramPacket(paramArrayOfByte, paramArrayOfByte.length, this.i, this.j);
          try
          {
            this.p = System.currentTimeMillis();
            this.f.send(localDatagramPacket);
            this.q = System.currentTimeMillis();
            this.r += this.q - this.p;
            this.s += paramArrayOfByte.length;
            this.L += paramArrayOfByte.length;
            QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send udp packet length:" + localDatagramPacket.getLength() + " sendEndTime:" + this.q + " sendTime:" + this.p);
            paramArrayOfByte = this.k;
            paramArrayOfByte.l += 1;
            return true;
          }
          catch (Exception paramArrayOfByte)
          {
            a(a.d.a.d);
            QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send udp packet error:", paramArrayOfByte);
            return false;
          }
        case 2: 
          try
          {
            this.p = System.currentTimeMillis();
            c.g.add(this.h.toString());
            this.h.write(paramArrayOfByte);
            this.h.flush();
            c.g.remove(this.h.toString());
            this.q = System.currentTimeMillis();
            this.r += this.q - this.p;
            this.s += paramArrayOfByte.length;
            this.L += paramArrayOfByte.length;
            QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send tcp packet length:" + paramArrayOfByte.length + " sendEndTime:" + this.q + " sendTime:" + this.p);
            paramArrayOfByte = this.k;
            paramArrayOfByte.l += 1;
          }
          catch (Exception paramArrayOfByte)
          {
            if (this.h != null) {
              c.g.remove(this.h.toString());
            }
            a(a.d.a.d);
            QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send tcp error:", paramArrayOfByte);
            return false;
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        return false;
      }
      try
      {
        new String(paramArrayOfByte);
        this.p = System.currentTimeMillis();
        c.g.add(this.h.toString());
        this.h.write(paramArrayOfByte);
        this.h.flush();
        c.g.remove(this.h.toString());
        this.q = System.currentTimeMillis();
        this.r += this.q - this.p;
        this.s += paramArrayOfByte.length;
        this.L += paramArrayOfByte.length;
        QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send http packet length:" + paramArrayOfByte.length + " sendEndTime:" + this.q + " sendTime:" + this.p);
        paramArrayOfByte = this.k;
        paramArrayOfByte.l += 1;
      }
      catch (Exception paramArrayOfByte)
      {
        if (this.h != null) {
          c.g.remove(this.h.toString());
        }
        a(a.d.a.d);
        QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send http error:", paramArrayOfByte);
        return false;
      }
    }
    return false;
  }
  
  private byte[] a(int paramInt, byte[] paramArrayOfByte)
  {
    if (this.b != null)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt);
      byte[] arrayOfByte = new byte[paramInt];
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
        localByteBuffer.put(paramArrayOfByte);
      }
      paramInt = 0;
      while (paramInt < this.b.f)
      {
        localByteBuffer.put(this.b.e);
        paramInt += 1;
      }
      localByteBuffer.flip();
      localByteBuffer.get(arrayOfByte);
      paramInt = arrayOfByte.length;
      if (this.a != a.c)
      {
        int i1 = com.tencent.mobileqq.msf.core.c.a(arrayOfByte, 0);
        if (i1 != paramInt)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "testdata length error stop dataTotalLen:" + i1 + " receBodySize:" + paramInt);
          }
          a(a.d.a.f, true);
          c.a();
          return null;
        }
      }
      return arrayOfByte;
    }
    if (this.c != null) {}
    return null;
  }
  
  /* Error */
  public static String b()
  {
    // Byte code:
    //   0: new 162	java/io/BufferedReader
    //   3: dup
    //   4: new 164	java/io/FileReader
    //   7: dup
    //   8: ldc_w 559
    //   11: invokespecial 169	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   14: sipush 8192
    //   17: invokespecial 172	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   20: astore_2
    //   21: aload_2
    //   22: astore_1
    //   23: aload_2
    //   24: invokevirtual 175	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   27: ldc_w 561
    //   30: invokevirtual 189	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   33: astore 4
    //   35: iconst_2
    //   36: istore_0
    //   37: ldc 110
    //   39: astore_3
    //   40: aload_2
    //   41: astore_1
    //   42: iload_0
    //   43: aload 4
    //   45: arraylength
    //   46: if_icmpge +40 -> 86
    //   49: aload_2
    //   50: astore_1
    //   51: new 199	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   58: aload_3
    //   59: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload 4
    //   64: iload_0
    //   65: aaload
    //   66: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc_w 563
    //   72: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore_3
    //   79: iload_0
    //   80: iconst_1
    //   81: iadd
    //   82: istore_0
    //   83: goto -43 -> 40
    //   86: aload_2
    //   87: invokevirtual 215	java/io/BufferedReader:close	()V
    //   90: invokestatic 195	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   93: ifeq +29 -> 122
    //   96: ldc 197
    //   98: iconst_4
    //   99: new 199	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   106: ldc_w 565
    //   109: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_3
    //   113: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: aload_3
    //   123: areturn
    //   124: astore_1
    //   125: invokestatic 195	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   128: ifeq +11 -> 139
    //   131: ldc 197
    //   133: iconst_4
    //   134: ldc 217
    //   136: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload_1
    //   140: invokevirtual 220	java/lang/Exception:printStackTrace	()V
    //   143: goto -53 -> 90
    //   146: astore_3
    //   147: aconst_null
    //   148: astore_2
    //   149: aload_2
    //   150: astore_1
    //   151: invokestatic 195	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   154: ifeq +14 -> 168
    //   157: aload_2
    //   158: astore_1
    //   159: ldc 197
    //   161: iconst_4
    //   162: ldc_w 567
    //   165: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: aload_2
    //   169: astore_1
    //   170: aload_3
    //   171: invokevirtual 220	java/lang/Exception:printStackTrace	()V
    //   174: aload_2
    //   175: invokevirtual 215	java/io/BufferedReader:close	()V
    //   178: ldc_w 569
    //   181: areturn
    //   182: astore_1
    //   183: invokestatic 195	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   186: ifeq +11 -> 197
    //   189: ldc 197
    //   191: iconst_4
    //   192: ldc 217
    //   194: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aload_1
    //   198: invokevirtual 220	java/lang/Exception:printStackTrace	()V
    //   201: ldc_w 569
    //   204: areturn
    //   205: astore_2
    //   206: aconst_null
    //   207: astore_1
    //   208: aload_1
    //   209: invokevirtual 215	java/io/BufferedReader:close	()V
    //   212: aload_2
    //   213: athrow
    //   214: astore_1
    //   215: invokestatic 195	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   218: ifeq +11 -> 229
    //   221: ldc 197
    //   223: iconst_4
    //   224: ldc 217
    //   226: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload_1
    //   230: invokevirtual 220	java/lang/Exception:printStackTrace	()V
    //   233: goto -21 -> 212
    //   236: astore_2
    //   237: goto -29 -> 208
    //   240: astore_3
    //   241: goto -92 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   36	47	0	i1	int
    //   22	29	1	localBufferedReader1	java.io.BufferedReader
    //   124	16	1	localException1	Exception
    //   150	20	1	localBufferedReader2	java.io.BufferedReader
    //   182	16	1	localException2	Exception
    //   207	2	1	localObject1	Object
    //   214	16	1	localException3	Exception
    //   20	155	2	localBufferedReader3	java.io.BufferedReader
    //   205	8	2	localObject2	Object
    //   236	1	2	localObject3	Object
    //   39	84	3	str	String
    //   146	25	3	localException4	Exception
    //   240	1	3	localException5	Exception
    //   33	30	4	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   86	90	124	java/lang/Exception
    //   0	21	146	java/lang/Exception
    //   174	178	182	java/lang/Exception
    //   0	21	205	finally
    //   208	212	214	java/lang/Exception
    //   23	35	236	finally
    //   42	49	236	finally
    //   51	79	236	finally
    //   151	157	236	finally
    //   159	168	236	finally
    //   170	174	236	finally
    //   23	35	240	java/lang/Exception
    //   42	49	240	java/lang/Exception
    //   51	79	240	java/lang/Exception
  }
  
  private boolean b(int paramInt)
  {
    int i1;
    Object localObject5;
    for (;;)
    {
      try
      {
        if ((this.a != a.c) && (paramInt > 32768))
        {
          this.N = false;
          a(a.d.a.e);
          QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: Recvbodysize too large, stop it");
          return false;
        }
        switch (1.a[this.a.ordinal()])
        {
        case 1: 
          byte[] arrayOfByte = new byte[paramInt];
          localObject3 = new DatagramPacket(arrayOfByte, paramInt);
          try
          {
            this.t = System.currentTimeMillis();
            this.f.receive((DatagramPacket)localObject3);
            this.u = System.currentTimeMillis();
            if (this.u <= this.p) {
              throw new Exception("receiveEndTime < sendTime");
            }
          }
          catch (Exception localException1)
          {
            a(a.d.a.e);
            QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: udp read packet error:", localException1);
            localObject1 = this.k;
            ((d)localObject1).n += 1;
            this.k.C.add(Long.valueOf(-1L));
            return false;
          }
          this.x = (this.u - this.p);
          this.k.C.add(Long.valueOf(this.x));
          this.v += this.u - this.t;
          this.w += ((DatagramPacket)localObject3).getLength();
          i1 = this.M;
          this.M = (((DatagramPacket)localObject3).getLength() + i1);
          localObject3 = this.k;
          ((d)localObject3).k = ((int)(((d)localObject3).k + (this.u - this.p)));
          QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: udp recv packet size " + paramInt);
          paramInt = com.tencent.mobileqq.msf.core.c.a((byte[])localObject1, 0);
          i1 = com.tencent.mobileqq.msf.core.c.a((byte[])localObject1, localObject1.length - 4);
          localObject1 = a(i1);
          QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: udp split respBodySize " + paramInt + " gateWayIp:" + localObject1 + " gateWayIpInt:" + i1);
          localObject3 = this.k;
          ((d)localObject3).m += 1;
          this.k.d = ((InetAddress)localObject1);
          return true;
        }
      }
      catch (Exception localException3)
      {
        Object localObject3;
        Object localObject1;
        Object localObject6;
        locald = this.k;
        locald.n += 1;
        this.k.C.add(Long.valueOf(-1L));
        return false;
      }
      localObject1 = null;
      try
      {
        localObject3 = this.g.getInputStream();
        localObject1 = localObject3;
        c.f.add(localObject3.toString());
        localObject1 = localObject3;
        localObject5 = new byte[paramInt];
        localObject1 = localObject3;
        this.t = System.currentTimeMillis();
        localObject1 = localObject3;
        i1 = ((InputStream)localObject3).read((byte[])localObject5);
        if (i1 != -1) {
          if (i1 < paramInt)
          {
            localObject1 = localObject3;
            i1 += ((InputStream)localObject3).read((byte[])localObject5, i1, paramInt - i1);
            continue;
          }
        }
        localObject1 = localObject3;
        c.f.remove(localObject3.toString());
        localObject1 = localObject3;
        this.u = System.currentTimeMillis();
        localObject1 = localObject3;
        if (this.u <= this.p)
        {
          localObject1 = localObject3;
          throw new Exception("receiveEndTime < sendTime");
        }
      }
      catch (Exception localException5)
      {
        if (localObject1 != null) {
          c.f.remove(localObject1.toString());
        }
        a(a.d.a.e);
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "QualityClient: receive TCP resp failed", localException5);
        }
        localObject1 = this.k;
        ((d)localObject1).n += 1;
        this.k.C.add(Long.valueOf(-1L));
        localException5.printStackTrace();
        return false;
      }
      localObject1 = localException5;
      this.x = (this.u - this.p);
      localObject1 = localException5;
      this.k.C.add(Long.valueOf(this.x));
      localObject1 = localException5;
      this.v += this.u - this.t;
      localObject1 = localException5;
      localObject6 = this.k;
      localObject1 = localException5;
      ((d)localObject6).k = ((int)(((d)localObject6).k + (this.u - this.p)));
      localObject1 = localException5;
      this.w += paramInt;
      localObject1 = localException5;
      this.M += paramInt;
      localObject1 = localException5;
      QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: tcp recv packet size " + paramInt);
      localObject1 = localException5;
      i1 = com.tencent.mobileqq.msf.core.c.a((byte[])localObject5, localObject5.length - 4);
      localObject1 = localException5;
      localObject5 = a(i1);
      localObject1 = localException5;
      QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: tcp split respBodySize " + paramInt + " gateWayIp:" + localObject5 + " gateWayIpInt:" + i1);
      localObject1 = localException5;
      localObject6 = this.k;
      localObject1 = localException5;
      ((d)localObject6).m += 1;
      localObject1 = localException5;
      this.k.d = ((InetAddress)localObject5);
      continue;
      localObject5 = null;
      for (;;)
      {
        try
        {
          localObject4 = this.g.getInputStream();
        }
        catch (Exception localException4)
        {
          int i3;
          int i6;
          int i5;
          int i4;
          Object localObject2;
          d locald;
          Object localObject4 = localObject5;
          continue;
          int i2 = i5;
          i1 = i4;
          continue;
        }
        try
        {
          c.f.add(localObject4.toString());
          localObject5 = new byte[1024];
          localObject1 = new byte[10240];
          this.t = System.currentTimeMillis();
          i3 = 0;
          i1 = 1048576;
          i2 = 0;
          paramInt = 0;
          i6 = ((InputStream)localObject4).read((byte[])localObject5);
          if ((i6 != -1) && (paramInt < i1))
          {
            if (paramInt < 10240)
            {
              i5 = 10240 - paramInt;
              i4 = i5;
              if (i5 > i6) {
                i4 = i6;
              }
              System.arraycopy(localObject5, 0, localObject1, paramInt, i4);
              int i7 = i3 + i4;
              i5 = i2;
              i4 = i1;
              i3 = i7;
              if (i2 == 0)
              {
                localObject6 = b.a(new String((byte[])localObject1, 0, i7));
                i5 = i2;
                i4 = i1;
                i3 = i7;
                if (localObject6 != null)
                {
                  i5 = i2;
                  i4 = i1;
                  i3 = i7;
                  if (((b)localObject6).e() > 0)
                  {
                    i5 = i2;
                    i4 = i1;
                    i3 = i7;
                    if (!TextUtils.isEmpty(((b)localObject6).a()))
                    {
                      i1 = ((b)localObject6).e();
                      i4 = ((b)localObject6).a().getBytes().length + i1;
                      i5 = 1;
                      i3 = i7;
                    }
                  }
                }
              }
              paramInt += i6;
              if (paramInt <= 1048576) {
                continue;
              }
              this.w += paramInt;
              this.M += paramInt;
              this.N = false;
              a(a.d.a.u);
              return false;
            }
            i5 = i2;
            i4 = i1;
            if (i2 != 0) {
              continue;
            }
            a(a.d.a.r);
            return false;
          }
          c.f.remove(localObject4.toString());
          this.u = System.currentTimeMillis();
          if (this.u <= this.p) {
            throw new Exception("receiveEndTime < sendTime");
          }
        }
        catch (Exception localException2)
        {
          if (localObject4 != null) {
            c.f.remove(localObject4.toString());
          }
          a(a.d.a.e);
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "QualityClient: http receive resp failed ", localException2);
          }
          localObject4 = this.k;
          ((d)localObject4).n += 1;
          this.k.C.add(Long.valueOf(-1L));
          localException2.printStackTrace();
          return false;
        }
      }
      this.x = (this.u - this.p);
      this.k.C.add(Long.valueOf(this.x));
      this.v += this.u - this.t;
      localObject5 = this.k;
      ((d)localObject5).k = ((int)(((d)localObject5).k + (this.u - this.p)));
      this.w += paramInt;
      this.M += paramInt;
      localObject2 = b.a(new String(localException2, 0, i3));
      if ((localObject2 == null) || (!((b)localObject2).g()))
      {
        a(a.d.a.r);
        return false;
      }
      if (!b(((b)localObject2).a().getBytes()))
      {
        a(a.d.a.s);
        return false;
      }
      i1 = ((b)localObject2).e();
      localObject5 = ((b)localObject2).a();
      if ((i1 <= 0) || (i1 != paramInt - ((String)localObject5).length()))
      {
        a(a.d.a.t);
        return false;
      }
      localObject5 = ((b)localObject2).c();
      localObject6 = ((b)localObject2).b();
      if (!MD5.toMD5(((b)localObject2).d()).equalsIgnoreCase((String)localObject5))
      {
        this.k.x = true;
        this.k.A = ((b)localObject2).a();
        a(a.d.a.p);
        return false;
      }
      localObject2 = InetAddress.getByName((String)localObject6);
      localObject5 = this.k;
      ((d)localObject5).m += 1;
      QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: http recv packet size " + paramInt);
      this.k.d = ((InetAddress)localObject2);
    }
    return false;
  }
  
  private boolean b(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (new String(paramArrayOfByte).endsWith("\r\n\r\n"));
  }
  
  private void c()
  {
    try
    {
      switch (1.a[this.a.ordinal()])
      {
      case 1: 
        this.f.close();
        if (QLog.isDevelopLevel())
        {
          QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: close Udp socket");
          return;
        }
        break;
      case 2: 
        this.g.close();
        this.h.close();
        if (QLog.isDevelopLevel())
        {
          QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: close Tcp socket");
          return;
        }
        break;
      case 3: 
        this.g.close();
        this.h.close();
        if (QLog.isDevelopLevel())
        {
          QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: close Http socket");
          return;
        }
        break;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void d()
  {
    if (this.b == null)
    {
      a(a.d.a.k, true);
      c.a();
      return;
    }
    try
    {
      byte[] arrayOfByte1 = new byte[this.b.e.length - 4];
      System.arraycopy(this.b.e, 0, arrayOfByte1, 0, arrayOfByte1.length);
      this.l.c = com.tencent.mobileqq.msf.core.c.a(arrayOfByte1, arrayOfByte1.length - 4);
      this.l.d = this.b.j;
      this.l.e = this.b.k;
      this.l.f = this.b.l;
      this.l.g = this.b.m;
      this.l.a = a.c.a.a;
      this.k.a = a.d.b.a;
      this.k.g = NetConnInfoCenterImpl.getSystemNetworkType();
      this.k.r = this.b.a;
      this.k.s = this.b.c;
      this.k.t = this.b.d;
      this.k.u = new ArrayList();
      this.k.u.add(Long.valueOf(this.b.f));
      this.k.w = this.b.h;
      QLog.d("MSF.C.QualityTestManager", 1, "PkgInterval :" + this.b.d + " IpPort.size():" + this.b.b.size() + " PkgNum:" + this.b.c + " HeadData.length" + this.b.g.length + " RepeatTimes" + this.b.f + " PkgData.length " + this.b.e.length + " dwTaskType" + this.b.j + " dwTaskTime" + this.b.k + " dwReserved1 " + this.b.l + " dwReserved2 " + this.b.m + " sPkgData " + Arrays.toString(this.b.e));
      if (this.d > 1)
      {
        if (this.b.b.size() <= 200) {
          break label696;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much for WiFi test, return ");
        }
        this.N = false;
        a(a.d.a.m, true);
        c.a();
        return;
      }
    }
    catch (Exception localException1)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg sPkgData too short, stop test qualityTestMsg.sPkgData.length:" + this.b.e.length);
      }
      a(a.d.a.i, true);
      c.a();
      return;
    }
    if ((this.d == 1) && ((this.b.m & 0xFF) != 1L))
    {
      if (this.b.b.size() > 75)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much, return ");
        }
        this.N = false;
        a(a.d.a.m, true);
        c.a();
      }
    }
    else if ((this.d == 1) && ((this.b.m & 0xFF) == 1L) && (this.b.b.size() > 200))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much for WiFi test, return ");
      }
      this.N = false;
      a(a.d.a.m, true);
      c.a();
      return;
    }
    label696:
    if (this.b.b.size() <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too small, return ");
      }
      a(a.d.a.n, true);
      c.a();
      return;
    }
    if (this.b.f <= 0L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "dwRepeatTimes must > 0");
      }
      a(a.d.a.q, true);
      c.a();
      return;
    }
    if (this.d > 1)
    {
      if (this.b.c > 50L)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much for WiFi test, return ");
        }
        this.N = false;
        a(a.d.a.l, true);
        c.a();
      }
    }
    else if ((this.d == 1) && ((this.b.m & 0xFF) != 1L))
    {
      if (this.b.c > 20L)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much, return ");
        }
        this.N = false;
        a(a.d.a.l, true);
        c.a();
      }
    }
    else if ((this.d == 1) && ((this.b.m & 0xFF) == 1L) && (this.b.c > 50L))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much for WiFi test, return ");
      }
      this.N = false;
      a(a.d.a.l, true);
      c.a();
      return;
    }
    if ((this.b.m >> 8 & 0xFF) > 20L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "dwReserved2>>8 &0xFF too much, return ");
      }
      this.N = false;
      a(a.d.a.l, true);
      c.a();
      return;
    }
    if (this.b.h * 1000L < System.currentTimeMillis())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg expired, stop test qualityTestMsg.dwExpirTime:" + this.b.h + "System.currentTimeMillis():" + System.currentTimeMillis());
      }
      a(a.d.a.j, true);
      c.a();
      return;
    }
    if ((this.a != a.c) && (this.b.e.length < 8))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg sPkgData too short, stop test qualityTestMsg.sPkgData.length:" + this.b.e.length);
      }
      a(a.d.a.i, true);
      c.a();
      return;
    }
    if ((this.a == a.c) && (!b(this.b.g)))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg sPkgData too short, stop test qualityTestMsg.sPkgData.length:" + this.b.e.length);
      }
      a(a.d.a.s, true);
      c.a();
      return;
    }
    int i2 = 0;
    int i1 = i2;
    byte[] arrayOfByte2;
    int i6;
    try
    {
      if (this.b.g != null)
      {
        i1 = i2;
        if (this.b.g.length > 0) {
          i1 = this.b.g.length;
        }
      }
      i7 = (int)(i1 + this.b.e.length * this.b.f);
      QLog.d("MSF.C.QualityTestManager", 1, "allbodylength " + i7);
      if ((i7 > 32768) && (this.a == a.a))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + i7 + " return ");
        }
        this.N = false;
        a(a.d.a.h, true);
        c.a();
        return;
      }
      if ((i7 > 32768) && (this.a == a.b))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + i7 + " return ");
        }
        this.N = false;
        a(a.d.a.h, true);
        c.a();
        return;
      }
      if ((i7 > 1048576) && (this.a == a.c))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + i7 + " return ");
        }
        this.N = false;
        a(a.d.a.h, true);
        c.a();
        return;
      }
      if (this.b.d < 10L)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "dwPkgInterval too small " + this.b.d + " return ");
        }
        a(a.d.a.g, true);
        c.a();
        return;
      }
      if ((this.a == a.c) && (!e()))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "no valid http push");
        }
        this.k.x = true;
        a(a.d.a.p, true);
        c.a();
        return;
      }
      arrayOfByte2 = a(i7, this.b.g);
      i6 = 0;
      i1 = 0;
      i2 = this.b.b.size();
      if (i1 < i2) {
        if (i6 == 0) {
          break label1741;
        }
      }
    }
    catch (Exception localException4)
    {
      for (;;)
      {
        int i7;
        label1741:
        QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: error ", localException4);
        return;
        i3 = i1;
        if ((this.b.m & 0xFF) == 1L)
        {
          i3 = i1;
          if (this.d > 1)
          {
            i3 = i1;
            l1 = this.b.c / this.d;
            break label3402;
          }
          i3 = i1;
          l1 = this.b.m >> 8 & 0xFF;
          break label3402;
        }
        i3 = i1;
        l1 = this.b.c;
        break label3402;
        i3 = i1;
        c.e = "NotWiFi";
        i3 = i1;
        if ((this.b.m & 0xFF) != 1L) {
          break label2473;
        }
        i3 = i1;
        if (this.d <= 1) {
          break label2452;
        }
        i3 = i1;
        if (this.e == 0) {
          break;
        }
        i3 = i1;
        if (QLog.isColorLevel())
        {
          i3 = i1;
          QLog.d("MSF.C.QualityTestManager", 2, "lost wifi connection, give up qualitytest run_thread" + Thread.currentThread().getName());
        }
      }
    }
    finally
    {
      c.a();
    }
    return;
    this.k.y = new ArrayList();
    this.k.k = 0;
    this.k.n = 0;
    this.k.l = 0;
    this.k.m = 0;
    this.k.o = 0;
    this.k.c.clear();
    this.k.x = false;
    this.k.A = null;
    this.k.B.clear();
    this.k.C.clear();
    int i3;
    long l1;
    label2017:
    label2162:
    int i4;
    for (;;)
    {
      try
      {
        for (;;)
        {
          this.k.h = NetConnInfoCenter.getWifiStrength();
          this.k.j = NetConnInfoCenter.getCdmaStrength();
          this.k.i = NetConnInfoCenter.getGsmStrength();
          this.r = 0L;
          this.v = 0L;
          this.s = 0L;
          this.w = 0L;
          i3 = i1;
          try
          {
            if (!NetConnInfoCenterImpl.isWifiConn()) {
              break label2162;
            }
            i3 = i1;
            if (NetConnInfoCenter.getWifiStrength() <= 10) {
              break label2162;
            }
            i3 = i1;
            if (!c.e.equals("NotWiFi")) {
              break label2079;
            }
            i3 = i1;
            if (this.e == 0) {
              break label2079;
            }
            i3 = i1;
            if (!QLog.isColorLevel()) {
              break;
            }
            i3 = i1;
            QLog.d("MSF.C.QualityTestManager", 2, "lost wifi connection, give up qualitytest run_thread" + Thread.currentThread().getName());
          }
          catch (Exception localException2)
          {
            l2 = 1L;
            i2 = i3;
          }
        }
        l1 = l2;
        i1 = i2;
        if (!QLog.isDevelopLevel()) {
          break label3402;
        }
        QLog.d("MSF.C.QualityTestManager", 4, "net change caused quality test error", localException2);
        l1 = l2;
        i1 = i2;
        break label3402;
        this.k.y.add(Integer.valueOf(i7));
        if (i5 != -1) {
          break label3306;
        }
      }
      catch (Exception localException3)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("MSF.C.QualityTestManager", 4, "failed to get network strength");
        continue;
      }
      label2079:
      i2 = -1;
      i3 = i2;
      this.d = 1;
      i3 = i2;
      if (this.b.b.size() > 75)
      {
        i3 = i2;
        if (QLog.isDevelopLevel())
        {
          i3 = i2;
          QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much, return ");
        }
        i3 = i2;
        i1 = this.K.indexOf("#");
        if (i1 != -1)
        {
          i3 = i2;
          this.K = this.K.substring(0, i1 + 1);
        }
        i3 = i2;
        this.k.c.clear();
        i3 = i2;
        this.N = false;
        i3 = i2;
        a(a.d.a.m, true);
        i3 = i2;
        c.a();
        c.a();
        return;
      }
      i3 = i2;
      l1 = this.b.m;
      long l2 = l1 >> 8 & 0xFF;
      try
      {
        i3 = this.K.indexOf("#");
        l1 = l2;
        i1 = i2;
        if (i3 == -1) {
          break label3402;
        }
        this.K = this.K.substring(0, i3 + 1);
        l1 = l2;
        i1 = i2;
      }
      catch (Exception localException5) {}
      continue;
      label2452:
      i3 = i1;
      l1 = this.b.m >> 8 & 0xFF;
      break label3402;
      label2473:
      i3 = i1;
      l1 = this.b.c;
      break label3402;
      label2487:
      i5 = i1;
      try
      {
        if (NetConnInfoCenterImpl.isWifiConn())
        {
          i5 = i1;
          if (NetConnInfoCenter.getWifiStrength() > 10)
          {
            i5 = i1;
            if (c.e.equals("NotWiFi"))
            {
              i5 = i1;
              if (this.e != 0)
              {
                i5 = 1;
                i6 = 1;
                i1 = this.b.b.size();
                i4 = i1;
                i1 = i4;
              }
            }
          }
        }
      }
      catch (Exception localException10)
      {
        for (;;)
        {
          i1 = i4;
          i4 = i2;
          i2 = i5;
        }
      }
      try
      {
        if (QLog.isColorLevel())
        {
          i1 = i4;
          QLog.d("MSF.C.QualityTestManager", 2, "lost wifi connection, give up qualitytest run_thread" + this.e);
        }
        i5 = i4;
      }
      catch (Exception localException11)
      {
        i5 = 1;
        i4 = i2;
        i2 = i5;
        break label3078;
      }
    }
    int i5 = i1;
    if ((this.b.m & 0xFF) == 1L)
    {
      i5 = i1;
      if (this.d > 1)
      {
        i5 = i1;
        l2 = this.b.c / this.d;
        l1 = l2;
        label2652:
        i5 = i1;
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          if (!a((com.tencent.msf.service.protocol.push.a.a)this.b.b.get(i4)))
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("MSF.C.QualityTestManager", 4, "connectToServer error, return ");
            }
            i1 = 0;
          }
        }
        catch (Exception localException8)
        {
          label3078:
          i1 = i3;
          QLog.d("MSF.C.QualityTestManager", 1, "QualityClient:  error:", localException8);
          localException8.printStackTrace();
          c();
          continue;
        }
        finally
        {
          c();
        }
        try
        {
          this.k.C.add(Long.valueOf(-1L));
          a(a.d.a.c);
          c();
          i2 += 1;
          i3 = i1;
          i1 = i5;
        }
        catch (Exception localException9)
        {
          i1 = 0;
          continue;
        }
        i5 = i1;
        l2 = this.b.m >> 8 & 0xFF;
        l1 = l2;
        break label2652;
        i5 = i1;
        l2 = this.b.c;
        l1 = l2;
        break label2652;
        i5 = i1;
        c.e = "NotWiFi";
        i5 = i1;
        if ((this.b.m & 0xFF) != 1L) {
          continue;
        }
        i5 = i1;
        if (this.d <= 1) {
          continue;
        }
        i5 = i1;
        if (this.e != 0)
        {
          i5 = 1;
          i6 = 1;
          i1 = this.b.b.size();
          i4 = i1;
          i1 = i4;
          if (QLog.isColorLevel())
          {
            i1 = i4;
            QLog.d("MSF.C.QualityTestManager", 2, "lost wifi connection, give up qualitytest run_thread" + this.e);
          }
          i5 = i4;
          break;
        }
        i2 = -1;
        i4 = 0;
        try
        {
          for (;;)
          {
            this.d = 1;
            if (this.b.b.size() > 75)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much, return ");
              }
              i2 = this.K.indexOf("#");
              if (i2 != -1) {
                this.K = this.K.substring(0, i2 + 1);
              }
              this.k.c.clear();
              this.N = false;
              a(a.d.a.m, true);
              c.a();
              c.a();
              return;
            }
            l2 = this.b.m;
            l1 = l2 >> 8 & 0xFF;
            try
            {
              int i8 = this.K.indexOf("#");
              i5 = i2;
              i6 = i1;
              if (i8 == -1) {
                break;
              }
              this.K = this.K.substring(0, i8 + 1);
              i5 = i2;
              i6 = i1;
            }
            catch (Exception localException6)
            {
              i5 = -1;
              i2 = i1;
              i1 = i5;
            }
          }
        }
        catch (Exception localException12)
        {
          i5 = -1;
          i2 = i1;
          i1 = i5;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "net change caused quality test error", localException6);
      }
      i5 = i2;
      i2 = i4;
      i4 = i1;
      continue;
      i5 = i1;
      l2 = this.b.m >> 8 & 0xFF;
      l1 = l2;
      break label2652;
      i5 = i1;
      l2 = this.b.c;
      l1 = l2;
      break label2652;
      if (arrayOfByte2 != null)
      {
        bool = a(arrayOfByte2);
        if (!bool)
        {
          i1 = 0;
          this.k.C.add(Long.valueOf(-1L));
          c();
          continue;
        }
        bool = b(arrayOfByte2.length);
        if (!bool)
        {
          i1 = 0;
          c();
          continue;
        }
      }
      c();
      i1 = i3;
      try
      {
        Thread.sleep(this.b.d);
      }
      catch (Exception localException7)
      {
        QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: Thread sleep error " + localException7);
      }
    }
    label3306:
    if (i5 == this.b.b.size() - 1) {}
    for (boolean bool = true;; bool = false)
    {
      if (i3 != 0)
      {
        a(a.d.a.a, bool);
      }
      else
      {
        a(a.d.a.b, bool);
        break label3443;
        label3402:
        i3 = 1;
        i4 = i1;
        i2 = 0;
        i1 = i6;
        i5 = i4;
        i6 = i1;
        if (i2 >= l1) {
          break label2017;
        }
        if (i4 != -1) {
          break label2487;
        }
        i5 = i4;
        i6 = i1;
        break label2017;
      }
      label3443:
      i1 = i5 + 1;
      break;
    }
  }
  
  private boolean e()
  {
    if ((this.b.g == null) && (this.b.g.length <= 0)) {
      return false;
    }
    String[] arrayOfString = new String(this.b.g).split("\r\n");
    Object localObject1 = "";
    Object localObject2 = "";
    int i2 = arrayOfString.length;
    int i1 = 0;
    if (i1 < i2)
    {
      String str = arrayOfString[i1];
      Object localObject4;
      Object localObject3;
      if (((!str.startsWith("Cookie:")) || (!str.contains("md5="))) && ((!str.startsWith("Set-Cookie:")) || (!str.contains("md5="))))
      {
        localObject4 = (String)localObject1 + str + "\r\n";
        localObject3 = localObject2;
      }
      for (;;)
      {
        i1 += 1;
        localObject2 = localObject3;
        localObject1 = localObject4;
        break;
        int i3 = str.indexOf("md5=");
        int i4 = str.indexOf(";", i3);
        localObject3 = localObject2;
        localObject4 = localObject1;
        if (i3 != -1)
        {
          localObject3 = localObject2;
          localObject4 = localObject1;
          if (i4 > "md5=".length() + i3)
          {
            localObject3 = str.substring("md5=".length() + i3, i4);
            localObject4 = localObject1;
          }
        }
      }
    }
    return ((String)localObject2).equals(MD5.toMD5((String)localObject1 + "\r\n"));
  }
  
  private void f()
  {
    if (this.c == null)
    {
      a(a.d.a.o, true);
      c.a();
      return;
    }
    this.k.a = a.d.b.b;
    this.k.g = NetConnInfoCenterImpl.getSystemNetworkType();
    this.k.r = this.c.a;
    this.k.s = this.c.g;
    this.k.t = this.c.f;
    this.k.u = new ArrayList();
    int i1 = 0;
    while (i1 < this.c.d.size())
    {
      this.k.u.add(this.c.d.get(i1));
      i1 += 1;
    }
    this.k.w = this.c.h;
    this.k.v = new ArrayList();
    QLog.d("MSF.C.QualityTestManager", 1, "PkgInterval :" + this.c.f + " IpPort.size():" + this.c.b.size() + " PkgData.length " + this.c.c.size() + " PkgNum:" + this.c.g);
    if (this.c.b.size() > 75)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much, return ");
      }
      this.N = false;
      a(a.d.a.m, true);
      c.a();
      return;
    }
    if (this.c.b.size() <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too small, return ");
      }
      a(a.d.a.n, true);
      c.a();
      return;
    }
    if (this.c.g > 20L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much, return ");
      }
      this.N = false;
      a(a.d.a.l, true);
      c.a();
      return;
    }
    if (this.c.h * 1000L < System.currentTimeMillis())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "mtuTest expired, stop test mtuTest.dwExpirTime:" + this.c.h + "System.currentTimeMillis():" + System.currentTimeMillis());
      }
      a(a.d.a.j, true);
      c.a();
      return;
    }
    if ((this.c.e.size() != this.c.d.size()) || (this.c.c.size() != this.c.d.size()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg sPkgData size error, stop test");
      }
      a(a.d.a.i, true);
      c.a();
      return;
    }
    if (this.c.g <= 0L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "mtuTest dwPkgNum too short, stop test mtuTest.dwPkgNum:" + this.c.g);
      }
      a(a.d.a.i, true);
      c.a();
      return;
    }
    if (this.c.g * this.c.c.size() > 20L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much, return ");
      }
      this.N = false;
      a(a.d.a.l, true);
      c.a();
      return;
    }
    int i3 = 0;
    for (;;)
    {
      int i4;
      int i5;
      try
      {
        if (i3 >= this.c.b.size()) {
          break label1683;
        }
        i1 = 0;
        this.k.y = new ArrayList();
        this.k.k = 0;
        this.k.n = 0;
        this.k.l = 0;
        this.k.m = 0;
        this.k.o = 0;
        this.k.c.clear();
        this.k.v.clear();
        try
        {
          this.k.h = NetConnInfoCenter.getWifiStrength();
          this.k.j = NetConnInfoCenter.getCdmaStrength();
          this.k.i = NetConnInfoCenter.getGsmStrength();
          i4 = 0;
          if (i4 >= this.c.c.size()) {
            break label1638;
          }
          if (((byte[])this.c.c.get(i4)).length < 8)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg sPkgData too short, stop test qualityTestMsg.sPkgData.length");
            }
            a(a.d.a.i);
          }
        }
        catch (Exception localException1)
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.d("MSF.C.QualityTestManager", 4, "failed to get network strength");
          continue;
        }
        int i6;
        ByteBuffer localByteBuffer;
        int i7;
        if (arrayOfByte == null) {
          break label1593;
        }
      }
      catch (Exception localException2)
      {
        QLog.d("MSF.C.QualityTestManager", 1, "QualityClient  error ", localException2);
        return;
        if ((this.c.e.get(i4) == null) || (((byte[])this.c.e.get(i4)).length <= 0)) {
          break label1692;
        }
        i2 = ((byte[])this.c.e.get(i4)).length;
        i6 = (int)(i2 + ((byte[])this.c.c.get(i4)).length * ((Long)this.c.d.get(i4)).longValue());
        QLog.d("MSF.C.QualityTestManager", 1, "mtu allbodylength " + i6);
        if ((i6 > 32768) && (this.a == a.a))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + i6 + " return ");
          }
          a(a.d.a.h);
        }
        else if (i6 > 32768)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + i6 + " return ");
          }
          this.N = false;
          a(a.d.a.h);
        }
        else
        {
          if (this.c.f >= 10L) {
            break label1706;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "dwPkgInterval too small " + this.c.f + " return ");
          }
          a(a.d.a.g);
          break label1697;
          if (i5 < this.c.g)
          {
            i1 = i2;
            if (i2 == 0)
            {
              if (!a((com.tencent.msf.service.protocol.push.a.a)this.c.b.get(i3)))
              {
                if (QLog.isDevelopLevel()) {
                  QLog.d("MSF.C.QualityTestManager", 4, "connectToServer error, return ");
                }
                a(a.d.a.c);
                i1 = i2;
                break label1714;
              }
              this.r = 0L;
              this.v = 0L;
              this.s = 0L;
              this.w = 0L;
              i1 = 1;
            }
            try
            {
              localByteBuffer = ByteBuffer.allocate(i6);
              arrayOfByte = new byte[i6];
              if ((this.c.e.get(i4) == null) || (((byte[])this.c.e.get(i4)).length <= 0)) {
                break label1725;
              }
              localByteBuffer.put((byte[])this.c.e.get(i4));
            }
            catch (Exception localException3)
            {
              byte[] arrayOfByte;
              QLog.d("MSF.C.QualityTestManager", 1, "QualityClient:  error:", localException3);
              localException3.printStackTrace();
              try
              {
                Thread.sleep(this.c.f);
              }
              catch (Exception localException4)
              {
                QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: Thread sleep error " + localException4);
              }
            }
            if (i2 < ((Long)this.c.d.get(i4)).longValue())
            {
              localByteBuffer.put((byte[])this.c.c.get(i4));
              i2 += 1;
              continue;
            }
            localByteBuffer.flip();
            localByteBuffer.get(arrayOfByte);
            i2 = arrayOfByte.length;
            i7 = com.tencent.mobileqq.msf.core.c.a(arrayOfByte, 0);
            if (i7 != i2)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "testdata length error stop dataTotalLen:" + i7 + " receBodySize:" + i2);
              }
              a(a.d.a.f);
              this.k.y.add(Integer.valueOf(i6));
            }
          }
        }
      }
      finally
      {
        c.a();
      }
      if (!a(arrayOfByte))
      {
        i1 = 0;
      }
      else if (!b(arrayOfByte.length))
      {
        this.k.v.add(Integer.valueOf(arrayOfByte.length));
        i1 = 0;
      }
      else
      {
        label1593:
        label1638:
        c();
        if (i3 == this.c.b.size() - 1) {}
        for (boolean bool = true;; bool = false)
        {
          a(a.d.a.a, bool);
          i3 += 1;
          break;
        }
        label1683:
        c.a();
        return;
        i1 = i2;
        continue;
        label1692:
        i2 = 0;
        continue;
        label1697:
        i4 += 1;
        continue;
        label1706:
        i5 = 0;
        i2 = i1;
        continue;
      }
      label1714:
      i5 += 1;
      int i2 = i1;
      continue;
      label1725:
      i2 = 0;
    }
  }
  
  public void run()
  {
    try
    {
      if (this.b != null)
      {
        d();
        return;
      }
      if (this.c != null)
      {
        f();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.QualityTestManager", 1, "QualityClient start failed, Exception :", localException);
    }
  }
  
  public static enum a
  {
    public static a a(String paramString)
    {
      return (a)Enum.valueOf(a.class, paramString);
    }
    
    public static a[] a()
    {
      return (a[])d.clone();
    }
  }
  
  static class b
  {
    public String[] a;
    public String b = "";
    
    public static b a(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      b localb = new b();
      int j = paramString.indexOf("\r\n\r\n");
      int i = j;
      if (j == -1) {
        i = paramString.length();
      }
      localb.a = paramString.substring(0, i).split("\r\n");
      return localb;
    }
    
    public String a()
    {
      if ((this.a == null) || (this.a.length == 0)) {
        return "";
      }
      String str1 = "";
      String[] arrayOfString = this.a;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str2 = arrayOfString[i];
        str1 = str1 + str2 + "\r\n";
        i += 1;
      }
      return str1 + "\r\n";
    }
    
    public String b()
    {
      if ((this.a == null) || (this.a.length == 0)) {}
      for (;;)
      {
        return "";
        String[] arrayOfString = this.a;
        int m = arrayOfString.length;
        int i = 0;
        while (i < m)
        {
          String str = arrayOfString[i];
          if (((str.startsWith("Set-Cookie:")) && (str.contains("gateway="))) || ((str.startsWith("Cookie:")) && (str.contains("gateway="))))
          {
            int n = str.indexOf("gateway=");
            int k = str.indexOf(";", n);
            int j = k;
            if (k == -1) {
              j = str.length();
            }
            if ((n != -1) && (j > n)) {
              return str.substring("gateway=".length() + n, j);
            }
          }
          i += 1;
        }
      }
    }
    
    public String c()
    {
      if ((this.a == null) || (this.a.length == 0)) {}
      for (;;)
      {
        return "";
        String[] arrayOfString = this.a;
        int m = arrayOfString.length;
        int i = 0;
        while (i < m)
        {
          String str = arrayOfString[i];
          if (((str.startsWith("Set-Cookie:")) && (str.contains("md5="))) || ((str.startsWith("Cookie:")) && (str.contains("md5="))))
          {
            int n = str.indexOf("md5=");
            int k = str.indexOf(";", n);
            int j = k;
            if (k == -1) {
              j = str.length();
            }
            if ((n != -1) && (j > n)) {
              return str.substring("md5=".length() + n, j);
            }
          }
          i += 1;
        }
      }
    }
    
    public String d()
    {
      if ((this.a == null) || (this.a.length == 0)) {
        return this.b;
      }
      String[] arrayOfString = this.a;
      int j = arrayOfString.length;
      Object localObject1 = "";
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        Object localObject2;
        if (str.startsWith("Set-Cookie:"))
        {
          localObject2 = localObject1;
          if (str.contains("md5=")) {}
        }
        else if (str.startsWith("Cookie:"))
        {
          localObject2 = localObject1;
          if (str.contains("md5=")) {}
        }
        else
        {
          localObject2 = (String)localObject1 + str + "\r\n";
        }
        i += 1;
        localObject1 = localObject2;
      }
      return (String)localObject1 + "\r\n";
    }
    
    public int e()
    {
      int k = -1;
      int j = k;
      if (this.a != null)
      {
        j = k;
        if (this.a.length <= 0) {}
      }
      try
      {
        String[] arrayOfString = this.a;
        int m = arrayOfString.length;
        int i = 0;
        for (;;)
        {
          j = k;
          if (i < m)
          {
            String str = arrayOfString[i];
            if (str.startsWith("Content-Length:")) {
              j = Integer.parseInt(str.substring("Content-Length:".length(), str.length()).trim());
            }
          }
          else
          {
            return j;
          }
          i += 1;
        }
        return -1;
      }
      catch (Exception localException) {}
    }
    
    public boolean f()
    {
      if ((this.a == null) || (this.a.length <= 0)) {}
      label64:
      for (;;)
      {
        return false;
        String[] arrayOfString = this.a;
        int j = arrayOfString.length;
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label64;
          }
          String str = arrayOfString[i];
          if (str.startsWith("HTTP/1."))
          {
            if (!str.contains("200")) {
              break;
            }
            return true;
          }
          i += 1;
        }
      }
    }
    
    public boolean g()
    {
      return (f()) && (!TextUtils.isEmpty(c()));
    }
  }
  
  static class c
  {
    public a a = a.a;
    public String b;
    public int c;
    public long d;
    public long e;
    public long f;
    public long g;
    
    c()
    {
      String str = Build.VERSION.RELEASE.replaceAll("|", "_").replaceAll("#", "_").replace("*", "_");
      this.b = (a.b() + "," + a.a() + "," + str);
      this.c = 0;
      this.d = 0L;
      this.e = 0L;
      this.f = 0L;
      this.g = 0L;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("");
      localStringBuilder.append(this.a).append(":").append(2).append("|").append(this.d).append("|").append(this.e).append("|").append(this.c).append("|").append(this.b).append("|").append(this.f).append("|").append(this.g).append("#");
      return localStringBuilder.toString();
    }
    
    public static enum a
    {
      public static a a(String paramString)
      {
        return (a)Enum.valueOf(a.class, paramString);
      }
      
      public static a[] a()
      {
        return (a[])b.clone();
      }
    }
  }
  
  static class d
  {
    public String A;
    public ArrayList B = new ArrayList();
    public ArrayList C = new ArrayList();
    public b a = b.a;
    public a b = a.a;
    public Map c = new HashMap();
    public InetAddress d;
    public InetAddress e;
    public int f = 0;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k = 0;
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public int o = 0;
    public int p = 0;
    public int q = 0;
    public int r = 0;
    public long s = 0L;
    public long t = 0L;
    ArrayList u;
    ArrayList v;
    public long w = 0L;
    public boolean x = false;
    ArrayList y;
    public long z;
    
    public String toString()
    {
      Object localObject1;
      label44:
      Object localObject3;
      label72:
      Object localObject4;
      if ((this.b == a.a) && (this.c.isEmpty()))
      {
        localObject1 = this.b;
        localObject1 = a.a.toString();
        if (this.d != null) {
          break label305;
        }
        localObject2 = "0.0.0.0|";
        if (this.e != null) {
          break label334;
        }
        localObject3 = (String)localObject2 + "0.0.0.0|";
        localObject2 = "";
        localObject4 = localObject2;
        if (this.y == null) {
          break label397;
        }
        localObject4 = localObject2;
        if (this.y.size() == 0) {
          break label397;
        }
        i1 = 0;
        label100:
        localObject4 = localObject2;
        if (i1 >= this.y.size()) {
          break label397;
        }
        if (i1 == this.y.size() - 1) {
          break label368;
        }
      }
      label305:
      label334:
      label368:
      for (Object localObject2 = (String)localObject2 + this.y.get(i1) + ",";; localObject2 = (String)localObject2 + this.y.get(i1))
      {
        i1 += 1;
        break label100;
        if ((this.c == null) || (this.c.isEmpty()))
        {
          localObject1 = this.b;
          localObject1 = a.b.toString();
          break;
        }
        localObject3 = this.c.entrySet().iterator();
        for (localObject2 = "";; localObject2 = (String)localObject2 + ((a)localObject4).toString() + ":" + i1 + ";")
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (Map.Entry)((Iterator)localObject3).next();
          localObject4 = (a)((Map.Entry)localObject1).getKey();
          i1 = ((Integer)((Map.Entry)localObject1).getValue()).intValue();
        }
        localObject2 = this.d.getHostAddress() + "|";
        break label44;
        localObject3 = (String)localObject2 + this.e.getHostAddress() + "|";
        break label72;
      }
      label397:
      localObject2 = "";
      Object localObject5 = localObject2;
      if (this.u != null)
      {
        localObject5 = localObject2;
        if (this.u.size() != 0)
        {
          i1 = 0;
          localObject5 = localObject2;
          if (i1 < this.u.size())
          {
            if (i1 != this.u.size() - 1) {}
            for (localObject2 = (String)localObject2 + this.u.get(i1) + ",";; localObject2 = (String)localObject2 + this.u.get(i1))
            {
              i1 += 1;
              break;
            }
          }
        }
      }
      if (this.x) {}
      for (String str1 = this.A; this.a == b.a; str1 = "false") {
        return "" + (String)localObject1 + "|" + (String)localObject3 + this.f + "|" + this.g + "|" + this.l + "|" + this.m + "|" + this.B.toString().replace("[", "").replace("]", "") + "|" + this.C.toString().replace("[", "").replace("]", "") + "|" + this.n + "|" + this.o + "|" + this.p + "|" + this.q + "|" + this.r + "|" + this.s + "|" + this.t + "|" + localObject5 + "|" + this.w + "|" + str1 + "|" + (String)localObject4 + "|" + this.z + "|" + this.h + "," + this.i + "," + this.j;
      }
      int i1 = Math.min(this.l, this.m);
      String str2;
      if (i1 > 0)
      {
        str2 = Integer.toString(this.k / i1);
        String str3 = "";
        localObject2 = str3;
        if (this.v == null) {
          break label1008;
        }
        localObject2 = str3;
        if (this.v.size() == 0) {
          break label1008;
        }
        localObject2 = "";
        i1 = 0;
        label910:
        if (i1 >= this.v.size()) {
          break label1008;
        }
        if (i1 == this.v.size() - 1) {
          break label979;
        }
      }
      label979:
      for (localObject2 = (String)localObject2 + this.v.get(i1) + ",";; localObject2 = (String)localObject2 + this.v.get(i1))
      {
        i1 += 1;
        break label910;
        str2 = "0";
        break;
      }
      label1008:
      return "" + this.a + "|" + (String)localObject1 + "|" + (String)localObject3 + this.f + "|" + this.g + "|" + str2 + "|" + this.l + "|" + this.m + "|" + this.n + "|" + this.o + "|" + (String)localObject2 + "|" + this.p + "|" + this.q + "|" + this.r + "|" + this.s + "|" + this.t + "|" + localObject5 + "|" + this.w + "|" + str1 + "|" + (String)localObject4 + "|" + this.z + "|" + this.h + "," + this.i + "," + this.j;
    }
    
    public static enum a
    {
      public static a a(String paramString)
      {
        return (a)Enum.valueOf(a.class, paramString);
      }
      
      public static a[] a()
      {
        return (a[])v.clone();
      }
    }
    
    public static enum b
    {
      public static b a(String paramString)
      {
        return (b)Enum.valueOf(b.class, paramString);
      }
      
      public static b[] a()
      {
        return (b[])c.clone();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.b.a.a
 * JD-Core Version:    0.7.0.1
 */