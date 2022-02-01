package oicq.wlogin_sdk.pow;

import android.util.Log;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import oicq.wlogin_sdk.report.event.b;
import oicq.wlogin_sdk.report.event.c;
import oicq.wlogin_sdk.tools.util;

public class ClientPow
{
  boolean a = false;
  
  public ClientPow()
  {
    try
    {
      System.loadLibrary("pow");
      this.a = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      util.LOGI(localUnsatisfiedLinkError.toString(), "");
    }
  }
  
  private int a(a parama)
  {
    byte[] arrayOfByte1 = new byte[32];
    byte[] arrayOfByte2 = new byte[parama.h.length];
    System.arraycopy(parama.h, 0, arrayOfByte2, 0, parama.h.length);
    Object localObject = new BigInteger(arrayOfByte2);
    long l2 = 0L;
    long l3;
    for (long l1 = 0L;; l1 += System.currentTimeMillis() - l3)
    {
      l3 = System.currentTimeMillis();
      if (parama.c != 1) {
        break;
      }
      a(arrayOfByte2, arrayOfByte1);
      l2 += System.currentTimeMillis() - l3;
      if (Arrays.equals(arrayOfByte1, parama.j))
      {
        localObject = Arrays.copyOf(arrayOfByte2, arrayOfByte2.length);
        parama.n = ((byte[])localObject);
        parama.m = localObject.length;
        localObject = new StringBuilder("sha_cost:");
        ((StringBuilder)localObject).append(l2);
        ((StringBuilder)localObject).append(" bignum_cost:");
        ((StringBuilder)localObject).append(l1);
        util.LOGI(((StringBuilder)localObject).toString(), "");
        return parama.p;
      }
      parama.p += 1;
      l3 = System.currentTimeMillis();
      localObject = ((BigInteger)localObject).add(BigInteger.ONE);
      byte[] arrayOfByte3 = ((BigInteger)localObject).toByteArray();
      if (arrayOfByte3.length > arrayOfByte2.length)
      {
        parama = new StringBuilder("big number too large len:");
        parama.append(arrayOfByte3.length);
        util.LOGI(parama.toString(), "");
        return -1;
      }
      System.arraycopy(arrayOfByte3, 0, arrayOfByte2, 0, arrayOfByte3.length);
    }
    if (parama.c == 2)
    {
      c(arrayOfByte2);
      util.LOGI("hash func not support sm3", "");
      return -1;
    }
    util.LOGI("error hash func", "");
    return -1;
  }
  
  private int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length != 0)) {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
        localMessageDigest.update(paramArrayOfByte1);
        paramArrayOfByte1 = localMessageDigest.digest();
        System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte1.length);
        return 0;
      }
      catch (NoSuchAlgorithmException paramArrayOfByte1)
      {
        util.LOGI(paramArrayOfByte1.toString(), "");
        return 2;
      }
    }
    return 1;
  }
  
  private int b(a parama)
  {
    byte[] arrayOfByte1 = new byte[32];
    byte[] arrayOfByte2 = new byte[parama.h.length];
    System.arraycopy(parama.h, 0, arrayOfByte2, 0, parama.h.length);
    Object localObject = new BigInteger(arrayOfByte2);
    while (parama.c == 1)
    {
      a(arrayOfByte2, arrayOfByte1);
      if (a(arrayOfByte1, parama.e) == 0)
      {
        localObject = Arrays.copyOf(arrayOfByte2, arrayOfByte2.length);
        parama.n = ((byte[])localObject);
        parama.m = localObject.length;
        return parama.p;
      }
      parama.p += 1;
      localObject = ((BigInteger)localObject).add(BigInteger.ONE);
      byte[] arrayOfByte3 = ((BigInteger)localObject).toByteArray();
      if (arrayOfByte3.length > arrayOfByte2.length)
      {
        parama = new StringBuilder("big number too large len:");
        parama.append(arrayOfByte3.length);
        util.LOGI(parama.toString(), "");
        return -1;
      }
      System.arraycopy(arrayOfByte3, 0, arrayOfByte2, 0, arrayOfByte3.length);
    }
    if (parama.c == 2)
    {
      c(arrayOfByte2);
      util.LOGI("hash func not support sm3", "");
      return -1;
    }
    util.LOGI("error hash func", "");
    return -1;
  }
  
  private byte[] c(byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
  
  int a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt > 32) {
      return 1;
    }
    int j = 255;
    int i = 0;
    while ((j >= 0) && (i < paramInt))
    {
      if ((paramArrayOfByte[(j / 8)] & 1 << j % 8) != 0) {
        return 2;
      }
      j -= 1;
      i += 1;
    }
    return 0;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject3 = new byte[0];
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(util.LOG_TAG_POW);
      ((StringBuilder)localObject1).append("_calPow");
      StringBuffer localStringBuffer = new StringBuffer(((StringBuilder)localObject1).toString());
      localStringBuffer.append(",inBuf=");
      localStringBuffer.append(util.getByteLength(paramArrayOfByte));
      localObject1 = localObject3;
      Object localObject2;
      if (this.a)
      {
        try
        {
          localObject1 = nativeGetPow(paramArrayOfByte);
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(util.LOG_TAG_POW);
          localStringBuilder.append("nativeGetPow");
          util.printThrowable(localException, localStringBuilder.toString());
          c.a(new b("wtlogin_pow_error", "c_error", Log.getStackTraceString(localException)));
          localObject2 = localObject3;
        }
        localStringBuffer.append(",native=");
        localStringBuffer.append(util.getByteLength((byte[])localObject2));
      }
      if (localObject2 != null)
      {
        localObject3 = localObject2;
        if (localObject2.length != 0) {}
      }
      else
      {
        try
        {
          paramArrayOfByte = b(paramArrayOfByte);
          localObject2 = paramArrayOfByte;
        }
        catch (Exception paramArrayOfByte)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(util.LOG_TAG_POW);
          ((StringBuilder)localObject3).append("calPowJavaImpl");
          util.printThrowable(paramArrayOfByte, ((StringBuilder)localObject3).toString());
          c.a(new b("wtlogin_pow_error", "java_error", Log.getStackTraceString(paramArrayOfByte)));
        }
        localStringBuffer.append(",java=");
        localStringBuffer.append(util.getByteLength((byte[])localObject2));
        localObject3 = localObject2;
      }
      util.LOGI(localStringBuffer.toString(), "");
      return localObject3;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append(util.LOG_TAG_POW);
    paramArrayOfByte.append(" calPow inBuf is empty");
    util.LOGI(paramArrayOfByte.toString(), "");
    return localObject3;
  }
  
  public byte[] b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[0];
    a locala = new a();
    int i = locala.a(paramArrayOfByte);
    if (i != 0)
    {
      util.LOGI("pow buf to st failed.ret=".concat(String.valueOf(i)), "");
      return arrayOfByte;
    }
    long l = System.currentTimeMillis();
    locala.p = 0;
    locala.o = 0;
    switch (locala.b)
    {
    default: 
      paramArrayOfByte = new StringBuilder("not support algorithm=");
      paramArrayOfByte.append(locala.b);
      util.LOGI(paramArrayOfByte.toString(), "");
      return arrayOfByte;
    case 2: 
      i = a(locala);
      break;
    case 1: 
      i = b(locala);
    }
    if (i < 0) {
      return arrayOfByte;
    }
    locala.o = ((int)(System.currentTimeMillis() - l));
    locala.d = 1;
    locala.p = i;
    paramArrayOfByte = new StringBuilder("cnt=");
    paramArrayOfByte.append(locala.p);
    paramArrayOfByte.append(" cost=");
    paramArrayOfByte.append(locala.o);
    util.LOGI(paramArrayOfByte.toString(), "");
    paramArrayOfByte = locala.a();
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      return paramArrayOfByte;
    }
    util.LOGI("pow st to buf failed.", "");
    return paramArrayOfByte;
  }
  
  public native byte[] nativeGetPow(byte[] paramArrayOfByte);
  
  public native byte[] nativeGetTestData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.pow.ClientPow
 * JD-Core Version:    0.7.0.1
 */