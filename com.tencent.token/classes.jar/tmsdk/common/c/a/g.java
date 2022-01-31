package tmsdk.common.c.a;

import android.content.Context;
import java.io.File;
import tmsdk.common.a;

public class g
{
  public static boolean a(Context paramContext, String paramString)
  {
    String str3 = a.a("pre_lib_path");
    String str1 = str3;
    if (str3 == null) {}
    int i;
    try
    {
      str3 = paramContext.getCacheDir().toString();
      str1 = str3;
      if (str3.endsWith("/") == true) {
        str1 = str3.substring(0, str3.length() - 2);
      }
      i = str1.lastIndexOf('/');
      if (i == -1) {
        break label413;
      }
      str1 = str1.substring(0, i);
      str1 = str1 + "/lib/";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        str2 = "/data/data/" + paramContext.getPackageName() + "/lib/";
        continue;
        i = 0;
        continue;
        i = j;
      }
    }
    if (str1.length() != 0) {
      if (!new File(str1 + paramString).exists()) {}
    }
    for (;;)
    {
      label413:
      try
      {
        System.load(str1 + paramString);
        i = 1;
        if ((i != 0) || (paramString.endsWith(".so"))) {
          break label491;
        }
        str3 = paramString + ".so";
        paramContext = str3;
        j = i;
        if (!new File(str1 + str3).exists()) {}
      }
      catch (UnsatisfiedLinkError paramContext) {}
      try
      {
        System.load(str1 + str3);
        j = 1;
        paramContext = str3;
      }
      catch (UnsatisfiedLinkError paramContext)
      {
        paramContext = str3;
        j = i;
        continue;
        continue;
      }
      if ((j == 0) && (!paramContext.startsWith("lib")))
      {
        str3 = "lib" + paramContext;
        paramContext = new File(str1 + str3);
        if (paramContext.exists()) {
          break label488;
        }
        str1 = str1.replace("/lib/", "/app_p_lib/");
        paramContext = new File(str1 + str3);
        if (paramContext.exists()) {
          try
          {
            System.load(str1 + str3);
            i = 1;
            if (i != 0) {}
          }
          catch (UnsatisfiedLinkError paramContext) {}
        }
      }
      try
      {
        System.loadLibrary(paramString);
        return true;
      }
      catch (UnsatisfiedLinkError paramContext)
      {
        return false;
      }
      str1 = "";
      break;
      try
      {
        String str2;
        System.loadLibrary(paramString);
      }
      catch (UnsatisfiedLinkError paramContext)
      {
        return false;
      }
      label488:
      label491:
      paramContext = paramString;
      int j = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.c.a.g
 * JD-Core Version:    0.7.0.1
 */