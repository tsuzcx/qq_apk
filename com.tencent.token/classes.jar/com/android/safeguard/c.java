package com.android.safeguard;

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

public class c
  extends h
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
  
  public c(Context paramContext)
  {
    this.a = paramContext;
    this.k = new b(paramContext).g();
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
  
  private PackageInfo b(String paramString, int paramInt)
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
      else
      {
        paramString = new Class[3];
      }
      paramString[0] = localObject2.getClass();
      paramString[1] = [I.class;
      paramString[2] = Integer.TYPE;
      paramString = localClass.getDeclaredMethod(this.f, paramString);
      if (localObject2 != null)
      {
        if ((paramInt & 0x40) != 0) {
          ((Method)localObject3).invoke(localObject1, new Object[] { localObject2, Integer.valueOf(0) });
        }
        if (this.k > 8) {}
        for (paramString = paramString.invoke(localObject1, new Object[] { localObject2, null, Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(0) });; paramString = paramString.invoke(localObject1, new Object[] { localObject2, null, Integer.valueOf(paramInt) })) {
          return (PackageInfo)paramString;
        }
      }
      return null;
    }
    catch (Throwable paramString)
    {
      a(paramString);
    }
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
  
  public String a()
  {
    PublicKey localPublicKey = b();
    if (localPublicKey != null) {
      return localPublicKey.toString();
    }
    return "";
  }
  
  public String a(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      return paramString.toString();
    }
    return "";
  }
  
  public PublicKey b()
  {
    try
    {
      Object localObject = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 64).signatures;
      if (localObject != null)
      {
        localObject = a(new ByteArrayInputStream(localObject[0].toByteArray()));
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return null;
  }
  
  public PublicKey b(String paramString)
  {
    try
    {
      if (this.k > 13) {
        paramString = this.a.getPackageManager().getPackageArchiveInfo(paramString, 65);
      } else {
        paramString = b(paramString, 65);
      }
      paramString = paramString.signatures;
      if (paramString != null)
      {
        paramString = a(new ByteArrayInputStream(paramString[0].toByteArray()));
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      a(paramString);
    }
    return null;
  }
  
  public String c(String paramString)
  {
    paramString = d(paramString);
    if (paramString != null) {
      return paramString.toString();
    }
    return "";
  }
  
  public PublicKey d(String paramString)
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
  
  public String e(String paramString)
  {
    paramString = f(paramString);
    if (paramString != null) {
      return paramString.toString();
    }
    return "";
  }
  
  public PublicKey f(String paramString)
  {
    Object localObject2 = null;
    InputStream localInputStream = null;
    Object localObject1 = localObject2;
    try
    {
      JarFile localJarFile = new JarFile(paramString);
      localObject1 = localObject2;
      paramString = localJarFile.entries();
      JarEntry localJarEntry;
      do
      {
        do
        {
          do
          {
            localObject1 = localObject2;
            if (!paramString.hasMoreElements())
            {
              paramString = localInputStream;
              break;
            }
            localObject1 = localObject2;
            localJarEntry = (JarEntry)paramString.nextElement();
            localObject1 = localObject2;
          } while (localJarEntry.isDirectory());
          localObject1 = localObject2;
        } while (!localJarEntry.getName().startsWith(this.g));
        localObject1 = localObject2;
      } while (!localJarEntry.getName().toUpperCase().endsWith(this.i));
      localObject1 = localObject2;
      localInputStream = localJarFile.getInputStream(localJarEntry);
      localObject1 = localObject2;
      paramString = b(localInputStream);
      localObject1 = paramString;
      localInputStream.close();
      localObject1 = paramString;
      localJarFile.close();
      return paramString;
    }
    catch (Throwable paramString)
    {
      a(paramString);
    }
    return localObject1;
  }
  
  public String g(String paramString)
  {
    paramString = h(paramString);
    if (paramString != null) {
      return paramString.toString();
    }
    return "";
  }
  
  public PublicKey h(String paramString)
  {
    try
    {
      byte[] arrayOfByte = new byte[this.j];
      JarFile localJarFile = new JarFile(paramString);
      Object localObject = localJarFile.entries();
      do
      {
        if (!((Enumeration)localObject).hasMoreElements())
        {
          paramString = null;
          break;
        }
        paramString = (JarEntry)((Enumeration)localObject).nextElement();
      } while ((paramString.isDirectory()) || (paramString.getName().startsWith(this.g)));
      localObject = localJarFile.getInputStream(paramString);
      while (((InputStream)localObject).read(arrayOfByte, 0, arrayOfByte.length) != -1) {}
      ((InputStream)localObject).close();
      paramString = paramString.getCertificates();
      localJarFile.close();
      paramString = paramString[0].getPublicKey();
      return paramString;
    }
    catch (Throwable paramString)
    {
      a(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.android.safeguard.c
 * JD-Core Version:    0.7.0.1
 */