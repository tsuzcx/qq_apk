package com.tencent.tbs.one.impl.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Base64;
import java.io.File;

public final class f
{
  public static File a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return new File(paramContext.getApplicationInfo().nativeLibraryDir);
    }
    if (Build.VERSION.SDK_INT > 4) {
      return new File(paramContext.getApplicationInfo().dataDir, "lib");
    }
    return new File(paramContext.getFilesDir().getParentFile(), "lib");
  }
  
  public static File a(Context paramContext1, Context paramContext2, String paramString1, String paramString2, int paramInt)
  {
    Object localObject = null;
    if (paramContext1 == paramContext2)
    {
      paramContext1 = paramContext1.getExternalFilesDir("tbs");
      if (paramContext1 == null) {
        break label132;
      }
    }
    label132:
    for (paramContext1 = new File(new File(paramContext1, paramString1), paramString2);; paramContext1 = null)
    {
      paramContext2 = localObject;
      if (paramContext1 != null) {
        paramContext2 = new File(paramContext1, String.valueOf(paramInt));
      }
      return paramContext2;
      if (paramContext1.getPackageManager().checkPermission("android.permission.READ_EXTERNAL_STORAGE", paramContext1.getPackageName()) == 0)
      {
        paramContext1 = paramContext2.getPackageName();
        if (Environment.getExternalStorageState().equals("mounted"))
        {
          paramContext1 = new File(Environment.getExternalStorageDirectory(), "Android/data/" + paramContext1 + "/files/tbs");
          break;
        }
      }
      paramContext1 = null;
      break;
    }
  }
  
  public static File a(File paramFile)
  {
    return new File(paramFile, "home");
  }
  
  public static File a(File paramFile, int paramInt)
  {
    return new File(new File(paramFile, "proc"), String.valueOf(paramInt));
  }
  
  public static File a(File paramFile, String paramString)
  {
    return new File(a(paramFile), paramString);
  }
  
  public static File a(File paramFile, String paramString, int paramInt)
  {
    return new File(b(paramFile, paramString), String.valueOf(paramInt));
  }
  
  public static File a(File paramFile, String paramString1, String paramString2)
  {
    paramString1 = Base64.encodeToString((paramString1 + File.separator + paramString2).getBytes(b.b), 2);
    String str1 = "libtbs=" + paramString1 + ".so";
    File localFile = new File(paramFile, str1);
    paramString1 = localFile;
    if (!localFile.exists())
    {
      String str2 = "libtbs" + paramString2 + ".so";
      localFile = new File(paramFile, str2);
      paramString1 = localFile;
      if (!localFile.exists())
      {
        paramFile = new File(paramFile, paramString2);
        paramString1 = paramFile;
        if (!paramFile.exists())
        {
          com.tencent.tbs.one.impl.a.f.b("Failed to find component file %s or %s or %s in native library directory", new Object[] { paramFile.getAbsolutePath(), str2, str1 });
          paramString1 = paramFile;
        }
      }
    }
    return paramString1;
  }
  
  public static File b(Context paramContext)
  {
    return new File(paramContext.getDir("tbs", 0), "proc");
  }
  
  public static File b(File paramFile)
  {
    return new File(paramFile, "DEPS");
  }
  
  public static File b(File paramFile, String paramString)
  {
    return new File(d(paramFile), paramString);
  }
  
  public static File c(File paramFile)
  {
    return new File(paramFile, "DEPS.latest");
  }
  
  public static File c(File paramFile, String paramString)
  {
    String str = "libtbs" + paramString + "DEPS.so";
    File localFile = new File(paramFile, str);
    paramString = localFile;
    if (!localFile.exists())
    {
      paramFile = new File(paramFile, "libtbsDEPS.so");
      paramString = paramFile;
      if (!paramFile.exists())
      {
        com.tencent.tbs.one.impl.a.f.b("Failed to find DEPS file %s or %s in native library directory", new Object[] { paramFile.getAbsolutePath(), str });
        paramString = paramFile;
      }
    }
    return paramString;
  }
  
  public static File d(File paramFile)
  {
    return new File(paramFile, "components");
  }
  
  public static File d(File paramFile, String paramString)
  {
    return new File(paramFile, paramString);
  }
  
  public static File e(File paramFile, String paramString)
  {
    return new File(paramFile.getParent(), paramFile.getName() + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.f
 * JD-Core Version:    0.7.0.1
 */