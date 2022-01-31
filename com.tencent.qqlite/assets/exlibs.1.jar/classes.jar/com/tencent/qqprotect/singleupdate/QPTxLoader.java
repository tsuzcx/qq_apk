package com.tencent.qqprotect.singleupdate;

import android.content.Context;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class QPTxLoader
{
  static String a = null;
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    int i = paramString.length() - 1;
    boolean bool1;
    Object localObject1;
    label104:
    Object localObject2;
    QPSupportUpdCfg localQPSupportUpdCfg;
    if ((i < 0) || (paramString.charAt(i) == '.') || (paramString.charAt(i) == '\\') || (paramString.charAt(i) == '/'))
    {
      bool1 = bool2;
      if (i != paramString.length() - 1)
      {
        bool1 = bool2;
        if (i != 0)
        {
          bool1 = bool2;
          if (paramString.charAt(i) == '.')
          {
            localObject1 = paramString.substring(i, paramString.length() - 1).toLowerCase();
            if (!((String)localObject1).equalsIgnoreCase(".so")) {
              break label237;
            }
            localObject1 = QPTxLoader.FILETYPE.SOFILE;
            localObject2 = BaseApplication.getContext();
            a = ((Context)localObject2).getFilesDir().getAbsolutePath() + "/TxSingleUpd/";
            localQPSupportUpdCfg = new QPSupportUpdCfg();
            localQPSupportUpdCfg.ReadConfigFile(QPSupportUpdCfg.CFG_FILEPATH);
            if (!QPUpdFileOperation.a(paramString)) {
              break label257;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject1 == QPTxLoader.FILETYPE.SOFILE)
      {
        localObject2 = paramString;
        if (localQPSupportUpdCfg.IsFileInConfigFile(paramString))
        {
          localObject2 = paramString;
          if (new File(localQPSupportUpdCfg.getFileDstPath(paramString)).exists()) {
            localObject2 = localQPSupportUpdCfg.getFileDstPath(paramString);
          }
        }
        System.load((String)localObject2);
      }
      if (localObject1 == QPTxLoader.FILETYPE.JARFILE) {}
      bool1 = true;
      label237:
      do
      {
        return bool1;
        i -= 1;
        break;
        bool1 = bool2;
      } while (!((String)localObject1).equalsIgnoreCase(".jar"));
      localObject1 = QPTxLoader.FILETYPE.JARFILE;
      break label104;
      label257:
      paramString = ((Context)localObject2).getFilesDir().getAbsolutePath() + "/lib/" + paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPTxLoader
 * JD-Core Version:    0.7.0.1
 */