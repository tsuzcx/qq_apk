package com.tencent.token;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public final class zh
{
  private static String a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = ((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(paramArrayOfByte))).getPublicKey().toString();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return zl.a;
  }
  
  public static JSONArray a(Context paramContext)
  {
    Object localObject = (ArrayList)b(paramContext);
    paramContext = new JSONArray();
    if (((ArrayList)localObject).size() == 0) {
      return paramContext;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramContext.put(((zg)((Iterator)localObject).next()).a());
    }
    return paramContext;
  }
  
  private static List<zg> b(Context paramContext)
  {
    localArrayList = new ArrayList();
    try
    {
      paramContext = paramContext.getPackageManager();
      Object localObject = paramContext.getInstalledPackages(64);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          PackageInfo localPackageInfo = (PackageInfo)((Iterator)localObject).next();
          if ((localPackageInfo.applicationInfo.flags & 0x1) == 0)
          {
            zg localzg = new zg();
            localzg.a = localPackageInfo.applicationInfo.loadLabel(paramContext).toString();
            localzg.d = localPackageInfo.packageName;
            localzg.b = localPackageInfo.versionName;
            if ((localPackageInfo.signatures != null) && (localPackageInfo.signatures.length != 0)) {
              localzg.c = a(localPackageInfo.signatures[0].toByteArray());
            }
            localArrayList.add(localzg);
          }
        }
      }
      return localArrayList;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zh
 * JD-Core Version:    0.7.0.1
 */