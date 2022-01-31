package com.tencent.token.utils.encrypt.random;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class PRNGFixes
{
  private static final byte[] a = ;
  
  public static void a() {}
  
  private static void c()
  {
    if ((Build.VERSION.SDK_INT < 16) || (Build.VERSION.SDK_INT > 18)) {}
    for (;;)
    {
      return;
      try
      {
        Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_seed", new Class[] { [B.class }).invoke(null, new Object[] { d() });
        int i = ((Integer)Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_load_file", new Class[] { String.class, Long.TYPE }).invoke(null, new Object[] { "/dev/urandom", Integer.valueOf(1024) })).intValue();
        if (i == 1024) {
          continue;
        }
        throw new IOException("Unexpected number of bytes read from Linux PRNG: " + i);
      }
      catch (Exception localException)
      {
        throw new SecurityException("Failed to seed OpenSSL PRNG", localException);
      }
    }
  }
  
  private static byte[] d()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeLong(System.currentTimeMillis());
      localDataOutputStream.writeLong(System.nanoTime());
      localDataOutputStream.writeInt(Process.myPid());
      localDataOutputStream.writeInt(Process.myUid());
      localDataOutputStream.write(a);
      localDataOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new SecurityException("Failed to generate seed", localIOException);
    }
  }
  
  private static String e()
  {
    try
    {
      String str = (String)Build.class.getField("SERIAL").get(null);
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static byte[] f()
  {
    Object localObject = new StringBuilder();
    String str = Build.FINGERPRINT;
    if (str != null) {
      ((StringBuilder)localObject).append(str);
    }
    str = e();
    if (str != null) {
      ((StringBuilder)localObject).append(str);
    }
    try
    {
      localObject = ((StringBuilder)localObject).toString().getBytes("UTF-8");
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 encoding not supported");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.encrypt.random.PRNGFixes
 * JD-Core Version:    0.7.0.1
 */