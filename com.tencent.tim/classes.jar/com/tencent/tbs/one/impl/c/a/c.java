package com.tencent.tbs.one.impl.c.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.n;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;

public final class c
{
  private static Boolean a;
  
  static File a(String paramString1, String paramString2)
  {
    return new File(paramString1, paramString2 + ".opt");
  }
  
  public static ClassLoader a(Context paramContext, File paramFile, String paramString1, String paramString2, ClassLoader paramClassLoader, boolean paramBoolean1, String[] paramArrayOfString, boolean paramBoolean2)
  {
    int i = 0;
    f.a("Creating class loader from %s, optimizedDirectory: %s, librarySearchPath: %s, parent: %s, unsealedPackages: %s, isAsyncDexOptimizationEnabled: %b", new Object[] { paramFile.getAbsolutePath(), paramString1, paramString2, paramClassLoader, paramArrayOfString, Boolean.valueOf(paramBoolean2) });
    if (paramBoolean2)
    {
      int j;
      String str1;
      if (a == null)
      {
        j = Build.VERSION.SDK_INT;
        if ((j < 21) || (j > 25))
        {
          f.a("API level %d does not support dex optimization", new Object[] { Integer.valueOf(j) });
          paramBoolean2 = false;
          a = Boolean.valueOf(paramBoolean2);
        }
      }
      else
      {
        if (!a.booleanValue()) {
          break label320;
        }
        String str2 = paramFile.getName();
        paramBoolean2 = a(paramString1, str2).exists();
        if (!paramBoolean2) {
          break label285;
        }
        str1 = "has";
        label139:
        f.a("The dex %s %s optimized", new Object[] { str2, str1 });
        if ((!paramBoolean2) || (!b(paramString1, str2))) {
          break label292;
        }
        label172:
        if (i == 0) {
          break label320;
        }
        if (!paramBoolean1) {
          break label298;
        }
      }
      label285:
      label292:
      label298:
      for (paramClassLoader = new PathClassLoader(paramFile.getAbsolutePath(), paramString2, paramClassLoader);; paramClassLoader = new e(paramFile.getAbsolutePath(), null, paramString2, paramClassLoader, paramArrayOfString))
      {
        n.c(new c.1(paramFile, paramContext, paramString1, paramString2));
        return paramClassLoader;
        str1 = System.getProperty("java.vm.version");
        if ((str1 == null) || (!str1.startsWith("2")))
        {
          f.a("VM version %s does not support dex optimization", new Object[] { str1 });
          paramBoolean2 = false;
          break;
        }
        f.a("API level %d and VM version %s supports dex optimization", new Object[] { Integer.valueOf(j), str1 });
        paramBoolean2 = true;
        break;
        str1 = "has not";
        break label139;
        i = 1;
        break label172;
      }
    }
    label320:
    if (paramBoolean1) {
      return new DexClassLoader(paramFile.getAbsolutePath(), paramString1, paramString2, paramClassLoader);
    }
    return new e(paramFile.getAbsolutePath(), paramString1, paramString2, paramClassLoader, paramArrayOfString);
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    String str = new File(paramString2).getName();
    if (!TextUtils.isEmpty(str))
    {
      int i = str.lastIndexOf('.');
      if (i > 0)
      {
        paramString2 = new String[2];
        paramString2[0] = str.substring(0, i);
        paramString2[1] = str.substring(i + 1);
      }
    }
    for (;;)
    {
      paramString1 = new File(paramString1, paramString2[0] + ".dex");
      if (paramString1.exists()) {
        break;
      }
      f.a("The odex file %s does not exist", new Object[] { paramString1.getAbsolutePath() });
      return true;
      paramString2 = new String[2];
      paramString2[0] = str;
      paramString2[1] = null;
    }
    if (d.a(paramString1)) {
      try
      {
        new d(paramString1);
        f.a("The odex file %s is well-kept", new Object[] { paramString1.getAbsolutePath() });
        return true;
      }
      catch (IOException paramString2)
      {
        f.a("The odex file %s has broken", new Object[] { paramString1.getAbsolutePath() });
        return false;
      }
    }
    f.a("The odex file %s is not a elf file", new Object[] { paramString1.getAbsolutePath() });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.a.c
 * JD-Core Version:    0.7.0.1
 */