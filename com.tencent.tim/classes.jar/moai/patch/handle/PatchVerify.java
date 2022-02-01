package moai.patch.handle;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import moai.patch.log.PatchLog;

public class PatchVerify
{
  private static boolean checkSignatures(Signature[] paramArrayOfSignature1, Signature[] paramArrayOfSignature2)
  {
    if ((paramArrayOfSignature1 == null) || (paramArrayOfSignature2 == null)) {
      return false;
    }
    HashSet localHashSet = new HashSet();
    Collections.addAll(localHashSet, paramArrayOfSignature1);
    paramArrayOfSignature1 = new HashSet();
    Collections.addAll(paramArrayOfSignature1, paramArrayOfSignature2);
    return localHashSet.equals(paramArrayOfSignature1);
  }
  
  public static boolean isAuthorized(Context paramContext, String paramString)
  {
    return checkSignatures(loadOldApkSignature(paramContext), loadNewApkSignature(paramString));
  }
  
  private static Certificate[] loadCertificates(JarFile paramJarFile, JarEntry paramJarEntry, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramJarFile.getInputStream(paramJarEntry));
      while (localBufferedInputStream.read(paramArrayOfByte, 0, paramArrayOfByte.length) != -1) {}
      localBufferedInputStream.close();
      paramArrayOfByte = localObject;
      if (paramJarEntry != null) {
        paramArrayOfByte = paramJarEntry.getCertificates();
      }
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      PatchLog.w(8003, "Exception loadCertificates:" + paramJarEntry.getName() + " in " + paramJarFile.getName(), paramArrayOfByte);
    }
    return null;
  }
  
  private static Signature[] loadNewApkSignature(String paramString)
  {
    byte[] arrayOfByte = new byte[8192];
    for (;;)
    {
      Object localObject3;
      int i;
      try
      {
        JarFile localJarFile = new JarFile(paramString);
        Enumeration localEnumeration = localJarFile.entries();
        Object localObject1 = null;
        if (localEnumeration.hasMoreElements())
        {
          JarEntry localJarEntry = (JarEntry)localEnumeration.nextElement();
          if ((localJarEntry.isDirectory()) || (localJarEntry.getName().startsWith("META-INF/"))) {
            continue;
          }
          localObject3 = loadCertificates(localJarFile, localJarEntry, arrayOfByte);
          if (localObject3 != null) {
            break label336;
          }
          PatchLog.e(8000, "has no certificates at entry " + localJarEntry.getName());
          localJarFile.close();
          return null;
          int k = localObject1.length;
          i = 0;
          if (i >= k) {
            break label330;
          }
          Object localObject4 = localObject1[i];
          int m = localObject3.length;
          j = 0;
          if (j < m)
          {
            Object localObject5 = localObject3[j];
            if ((localObject4 == null) || (!localObject4.equals(localObject5))) {
              break label348;
            }
            j = 1;
            if ((j != 0) && (localObject1.length == localObject3.length)) {
              break label355;
            }
            PatchLog.e(8004, "has mismatched certificates at entry " + localJarEntry.getName());
            localJarFile.close();
            return null;
          }
        }
        else
        {
          localJarFile.close();
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            j = localObject1.length;
            localObject3 = new Signature[localObject1.length];
            i = 0;
            if (i >= j) {
              break label333;
            }
            localObject3[i] = new Signature(localObject1[i].getEncoded());
            i += 1;
            continue;
          }
          PatchLog.e(8001, "has no certificates");
          return null;
        }
      }
      catch (Exception localException)
      {
        PatchLog.e(8002, "loadNewApkSignature fail:" + paramString, localException);
        return null;
      }
      int j = 0;
      continue;
      label330:
      break label345;
      label333:
      return localObject3;
      label336:
      if (localException == null)
      {
        Object localObject2 = localObject3;
        label345:
        continue;
        label348:
        j += 1;
        continue;
        label355:
        i += 1;
      }
    }
  }
  
  private static Signature[] loadOldApkSignature(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.handle.PatchVerify
 * JD-Core Version:    0.7.0.1
 */