package com.tencent.token;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.DisplayMetrics;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public final class d
  extends i
{
  Context a = null;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private int j = 0;
  private int k = 0;
  
  public d(Context paramContext)
  {
    this.a = paramContext;
    this.k = new c(paramContext).f();
    this.b = "android.content.pm.PackageParser";
    this.c = "parsePackage";
    this.d = "collectCertificates";
    this.e = "mSignatures";
    this.f = "generatePackageInfo";
    this.g = "META-INF/";
    this.h = "X.509";
    this.i = ".RSA";
    this.j = 8192;
  }
  
  private PublicKey a(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = ((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(paramInputStream)).getPublicKey();
      return paramInputStream;
    }
    catch (Throwable paramInputStream)
    {
      a(paramInputStream);
    }
    return null;
  }
  
  private PublicKey b(InputStream paramInputStream)
  {
    for (;;)
    {
      try
      {
        paramInputStream = CertificateFactory.getInstance(this.h).generateCertificates(paramInputStream).iterator();
        if (paramInputStream.hasNext())
        {
          paramInputStream = (X509Certificate)paramInputStream.next();
          paramInputStream = paramInputStream.getPublicKey();
          return paramInputStream;
        }
      }
      catch (Throwable paramInputStream)
      {
        a(paramInputStream);
        return null;
      }
      paramInputStream = null;
    }
  }
  
  private PackageInfo f(String paramString)
  {
    try
    {
      Class localClass = Class.forName(this.b);
      Object localObject1 = localClass.getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString });
      Object localObject2 = new DisplayMetrics();
      ((DisplayMetrics)localObject2).setToDefaults();
      Object localObject3 = Integer.TYPE;
      localObject2 = localClass.getDeclaredMethod(this.c, new Class[] { File.class, String.class, DisplayMetrics.class, localObject3 }).invoke(localObject1, new Object[] { new File(paramString), paramString, localObject2, Integer.valueOf(64) });
      paramString = localObject2.getClass();
      localObject3 = Integer.TYPE;
      localObject3 = localClass.getDeclaredMethod(this.d, new Class[] { paramString, localObject3 });
      ((Method)localObject3).invoke(localObject1, new Object[] { localObject2, Integer.valueOf(64) });
      if (this.k > 8)
      {
        paramString = new Class[5];
        paramString[3] = Long.TYPE;
        paramString[4] = Long.TYPE;
      }
      for (;;)
      {
        paramString[0] = localObject2.getClass();
        paramString[1] = [I.class;
        paramString[2] = Integer.TYPE;
        paramString = localClass.getDeclaredMethod(this.f, paramString);
        if (localObject2 == null) {
          break label362;
        }
        ((Method)localObject3).invoke(localObject1, new Object[] { localObject2, Integer.valueOf(0) });
        if (this.k <= 8) {
          break;
        }
        return (PackageInfo)paramString.invoke(localObject1, new Object[] { localObject2, null, Integer.valueOf(65), Integer.valueOf(0), Integer.valueOf(0) });
        paramString = new Class[3];
      }
      paramString = (PackageInfo)paramString.invoke(localObject1, new Object[] { localObject2, null, Integer.valueOf(65) });
      return paramString;
    }
    catch (Throwable paramString)
    {
      a(paramString);
    }
    label362:
    return null;
  }
  
  public final PublicKey a()
  {
    PublicKey localPublicKey = null;
    try
    {
      Signature[] arrayOfSignature = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 64).signatures;
      if (arrayOfSignature != null) {
        localPublicKey = a(new ByteArrayInputStream(arrayOfSignature[0].toByteArray()));
      }
      return localPublicKey;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return null;
  }
  
  public final PublicKey a(String paramString)
  {
    try
    {
      if (this.k > 13) {}
      for (paramString = this.a.getPackageManager().getPackageArchiveInfo(paramString, 65);; paramString = f(paramString))
      {
        paramString = paramString.signatures;
        if (paramString == null) {
          break;
        }
        return a(new ByteArrayInputStream(paramString[0].toByteArray()));
      }
      return null;
    }
    catch (Throwable paramString)
    {
      a(paramString);
    }
  }
  
  public final PublicKey b(String paramString)
  {
    try
    {
      Class localClass1 = Class.forName(this.b);
      Object localObject1 = localClass1.getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString });
      Object localObject2 = new DisplayMetrics();
      ((DisplayMetrics)localObject2).setToDefaults();
      Class localClass2 = Integer.TYPE;
      paramString = localClass1.getDeclaredMethod(this.c, new Class[] { File.class, String.class, DisplayMetrics.class, localClass2 }).invoke(localObject1, new Object[] { new File(paramString), paramString, localObject2, Integer.valueOf(64) });
      localObject2 = paramString.getClass();
      localClass2 = Integer.TYPE;
      localClass1.getDeclaredMethod(this.d, new Class[] { localObject2, localClass2 }).invoke(localObject1, new Object[] { paramString, Integer.valueOf(64) });
      paramString = a(new ByteArrayInputStream(((Signature[])paramString.getClass().getDeclaredField(this.e).get(paramString))[0].toByteArray()));
      return paramString;
    }
    catch (Throwable paramString)
    {
      a(paramString);
    }
    return null;
  }
  
  /* Error */
  public final PublicKey c(String paramString)
  {
    // Byte code:
    //   0: new 228	java/util/jar/JarFile
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 229	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aload_3
    //   10: invokevirtual 233	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
    //   13: astore_1
    //   14: aload_1
    //   15: invokeinterface 238 1 0
    //   20: istore_2
    //   21: iload_2
    //   22: ifne +11 -> 33
    //   25: aconst_null
    //   26: astore_1
    //   27: aload_3
    //   28: invokevirtual 241	java/util/jar/JarFile:close	()V
    //   31: aload_1
    //   32: areturn
    //   33: aload_1
    //   34: invokeinterface 244 1 0
    //   39: checkcast 246	java/util/jar/JarEntry
    //   42: astore 4
    //   44: aload 4
    //   46: invokevirtual 249	java/util/jar/JarEntry:isDirectory	()Z
    //   49: ifne -35 -> 14
    //   52: aload 4
    //   54: invokevirtual 252	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   57: aload_0
    //   58: getfield 60	com/tencent/token/d:g	Ljava/lang/String;
    //   61: invokevirtual 256	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   64: ifeq -50 -> 14
    //   67: aload 4
    //   69: invokevirtual 252	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   72: invokevirtual 259	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   75: aload_0
    //   76: getfield 68	com/tencent/token/d:i	Ljava/lang/String;
    //   79: invokevirtual 262	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   82: ifeq -68 -> 14
    //   85: aload_3
    //   86: aload 4
    //   88: invokevirtual 266	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   91: astore 4
    //   93: aload_0
    //   94: aload 4
    //   96: invokespecial 268	com/tencent/token/d:b	(Ljava/io/InputStream;)Ljava/security/PublicKey;
    //   99: astore_1
    //   100: aload 4
    //   102: invokevirtual 271	java/io/InputStream:close	()V
    //   105: goto -78 -> 27
    //   108: astore_3
    //   109: aconst_null
    //   110: astore_1
    //   111: aload_0
    //   112: aload_3
    //   113: invokevirtual 91	com/tencent/token/d:a	(Ljava/lang/Throwable;)V
    //   116: aload_1
    //   117: areturn
    //   118: astore_3
    //   119: goto -8 -> 111
    //   122: astore_3
    //   123: goto -12 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	d
    //   0	126	1	paramString	String
    //   20	2	2	bool	boolean
    //   8	78	3	localJarFile	JarFile
    //   108	5	3	localThrowable1	Throwable
    //   118	1	3	localThrowable2	Throwable
    //   122	1	3	localThrowable3	Throwable
    //   42	59	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	14	108	java/lang/Throwable
    //   14	21	108	java/lang/Throwable
    //   33	100	108	java/lang/Throwable
    //   100	105	118	java/lang/Throwable
    //   27	31	122	java/lang/Throwable
  }
  
  public final PublicKey d(String paramString)
  {
    try
    {
      byte[] arrayOfByte = new byte[this.j];
      JarFile localJarFile = new JarFile(paramString);
      Object localObject = localJarFile.entries();
      if (!((Enumeration)localObject).hasMoreElements()) {}
      for (paramString = null;; paramString = paramString.getCertificates())
      {
        localJarFile.close();
        return paramString[0].getPublicKey();
        paramString = (JarEntry)((Enumeration)localObject).nextElement();
        if ((paramString.isDirectory()) || (paramString.getName().startsWith(this.g))) {
          break;
        }
        localObject = localJarFile.getInputStream(paramString);
        while (((InputStream)localObject).read(arrayOfByte, 0, arrayOfByte.length) != -1) {}
        ((InputStream)localObject).close();
      }
      return null;
    }
    catch (Throwable paramString)
    {
      a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.d
 * JD-Core Version:    0.7.0.1
 */