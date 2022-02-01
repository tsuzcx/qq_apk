package com.tencent.qqmini.sdk.core.tissue;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.manager.EngineVersion;
import java.io.File;

public class TissueGlobal
{
  public static final String BUNDLE_KEY_TISSUE_NATIVE_LIB_DIR = "tissuenativelibdir";
  public static final String LOG_TAG = "Tissue";
  public static String sTissueRequiredVersion = "1.7.1";
  public static TissueEnv tissueEnv;
  
  public static boolean checkEngineAvailable(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    label120:
    label125:
    for (;;)
    {
      return false;
      Object localObject = new File(paramString1);
      if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
      {
        localObject = EngineVersion.fromFolderName(((File)localObject).getName());
        if ((localObject != null) && (EngineVersion.compareVersion(((EngineVersion)localObject).mMinor, paramString2) >= 0)) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label125;
          }
          int j = paramArrayOfString.length;
          i = 0;
          for (;;)
          {
            if (i >= j) {
              break label120;
            }
            paramString2 = new File(paramString1, paramArrayOfString[i]);
            if ((!paramString2.exists()) || (!paramString2.isFile()) || (!paramString2.canRead())) {
              break;
            }
            i += 1;
          }
          return true;
        }
      }
    }
  }
  
  public static boolean verifyTissueEngine(String paramString)
  {
    String str = sTissueRequiredVersion;
    return checkEngineAvailable(paramString, new String[] { "libtv8rt.so", "libflutter.so", "libapp.so" }, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.tissue.TissueGlobal
 * JD-Core Version:    0.7.0.1
 */