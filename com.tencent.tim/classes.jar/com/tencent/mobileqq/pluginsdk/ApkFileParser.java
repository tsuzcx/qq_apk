package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;

public class ApkFileParser
{
  public static Drawable getAPKIcon(Context paramContext, String paramString)
  {
    try
    {
      Object localObject = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 1);
      if ((localObject == null) || (((PackageInfo)localObject).applicationInfo == null)) {
        break label139;
      }
      localObject = ((PackageInfo)localObject).applicationInfo;
      Class localClass = Class.forName("android.content.res.AssetManager");
      AssetManager localAssetManager = (AssetManager)localClass.getConstructor((Class[])null).newInstance((Object[])null);
      localClass.getDeclaredMethod("addAssetPath", new Class[] { String.class }).invoke(localAssetManager, new Object[] { paramString });
      paramString = new DisplayMetrics();
      paramString.setToDefaults();
      paramContext = new Resources(localAssetManager, paramString, paramContext.getResources().getConfiguration());
      if (((ApplicationInfo)localObject).icon != 0)
      {
        paramContext = paramContext.getDrawable(((ApplicationInfo)localObject).icon);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
    label139:
    return null;
  }
  
  public static PackageInfo getPackageInfo(Context paramContext, String paramString, int paramInt)
    throws Throwable
  {
    return paramContext.getPackageManager().getPackageArchiveInfo(paramString, paramInt);
  }
  
  public static PackageInfo getPackageInfo(String paramString)
    throws Exception
  {
    localPackageInfo = new PackageInfo();
    Object localObject1 = new ApplicationInfo();
    ((ApplicationInfo)localObject1).metaData = new Bundle();
    localPackageInfo.applicationInfo = ((ApplicationInfo)localObject1);
    localObject1 = (AssetManager)AssetManager.class.newInstance();
    localObject2 = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
    ((Method)localObject2).setAccessible(true);
    ((Method)localObject2).invoke(localObject1, new Object[] { paramString });
    localObject2 = ((AssetManager)localObject1).openXmlResourceParser("AndroidManifest.xml");
    if (localObject2 == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        i = ((XmlResourceParser)localObject2).getEventType();
      }
      catch (Exception paramString)
      {
        throw paramString;
      }
      finally
      {
        int i;
        try
        {
          ((XmlResourceParser)localObject2).close();
          throw paramString;
          try
          {
            ((XmlResourceParser)localObject2).close();
            return localPackageInfo;
          }
          catch (Exception paramString)
          {
            continue;
          }
        }
        catch (Exception localException)
        {
          continue;
        }
        if (i == 1) {
          continue;
        }
        switch (i)
        {
        }
        continue;
        i += 1;
        continue;
        i += 1;
        continue;
        i += 1;
        continue;
      }
      i = ((XmlResourceParser)localObject2).nextToken();
      continue;
      paramString = ((XmlResourceParser)localObject2).getName();
      if (!TextUtils.isEmpty(paramString)) {
        if (paramString.equals("manifest"))
        {
          i = 0;
          if (i < ((XmlResourceParser)localObject2).getAttributeCount())
          {
            if (!((XmlResourceParser)localObject2).getAttributeName(i).equals("package")) {
              continue;
            }
            localPackageInfo.packageName = ((XmlResourceParser)localObject2).getAttributeValue(i);
            localPackageInfo.applicationInfo.packageName = localPackageInfo.packageName;
          }
        }
        else if (paramString.equals("application"))
        {
          i = 0;
          if (i < ((XmlResourceParser)localObject2).getAttributeCount())
          {
            if (!((XmlResourceParser)localObject2).getAttributeName(i).equals("name")) {
              continue;
            }
            localPackageInfo.applicationInfo.className = ((XmlResourceParser)localObject2).getAttributeValue(i);
          }
        }
        else if (paramString.equals("meta-data"))
        {
          localObject1 = "";
          paramString = "";
          i = 0;
          if (i < ((XmlResourceParser)localObject2).getAttributeCount())
          {
            if (((XmlResourceParser)localObject2).getAttributeName(i).equals("name")) {
              localObject1 = ((XmlResourceParser)localObject2).getAttributeValue(i);
            }
            if (!((XmlResourceParser)localObject2).getAttributeName(i).equals("value")) {
              continue;
            }
            paramString = ((XmlResourceParser)localObject2).getAttributeValue(i);
            continue;
          }
          localPackageInfo.applicationInfo.metaData.putString((String)localObject1, paramString);
        }
      }
    }
  }
  
  public static PackageInfo getPackageInfoWithException(Context paramContext, String paramString, int paramInt)
    throws Throwable
  {
    PackageInfo localPackageInfo = getPackageInfo(paramString);
    paramString = localPackageInfo;
    if (localPackageInfo == null) {
      paramString = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 128);
    }
    return paramString;
  }
  
  public static Signature[] getSignaure(String paramString)
  {
    try
    {
      Object localObject1 = Class.forName("android.content.pm.PackageParser");
      Object localObject2 = Class.forName("android.content.pm.PackageParser$Package");
      Object localObject3 = ((Class)localObject1).getConstructor(new Class[] { String.class });
      Method localMethod = ((Class)localObject1).getMethod("parsePackage", new Class[] { File.class, String.class, DisplayMetrics.class, Integer.TYPE });
      localObject1 = ((Class)localObject1).getMethod("collectCertificates", new Class[] { localObject2, Integer.TYPE });
      localObject2 = ((Class)localObject2).getField("mSignatures");
      localObject3 = ((Constructor)localObject3).newInstance(new Object[] { paramString });
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      localDisplayMetrics.setToDefaults();
      paramString = localMethod.invoke(localObject3, new Object[] { new File(paramString), paramString, localDisplayMetrics, Integer.valueOf(0) });
      if (paramString == null) {
        return null;
      }
      ((Method)localObject1).invoke(localObject3, new Object[] { paramString, Integer.valueOf(64) });
      paramString = ((Field)localObject2).get(paramString);
      if ((paramString != null) && ((paramString instanceof Signature[])))
      {
        paramString = (Signature[])paramString;
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static boolean isApkFileBroken(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 64);
    return (paramContext == null) || (paramContext.applicationInfo == null);
  }
  
  public static boolean isSignaturesSame(Signature[] paramArrayOfSignature1, Signature[] paramArrayOfSignature2)
  {
    if (paramArrayOfSignature1 == null) {}
    while (paramArrayOfSignature2 == null) {
      return true;
    }
    HashSet localHashSet = new HashSet();
    int j = paramArrayOfSignature1.length;
    int i = 0;
    while (i < j)
    {
      localHashSet.add(paramArrayOfSignature1[i]);
      i += 1;
    }
    paramArrayOfSignature1 = new HashSet();
    j = paramArrayOfSignature2.length;
    i = 0;
    while (i < j)
    {
      paramArrayOfSignature1.add(paramArrayOfSignature2[i]);
      i += 1;
    }
    return localHashSet.equals(paramArrayOfSignature1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ApkFileParser
 * JD-Core Version:    0.7.0.1
 */