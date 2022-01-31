package com.tencent.mqp.app.intchk;

import android.content.Context;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.QPTxLoader;
import java.io.File;

public class IntChkUtil
{
  public static int a = 1;
  private static final String a = "IntChkUtil";
  private static final String b = "mqpintchk";
  
  static
  {
    Context localContext = BaseApplication.getContext();
    File localFile2 = new File(localContext.getFilesDir().getParent() + "/txlib/lib" + "mqpintchk" + ".so");
    File localFile1 = localFile2;
    if (!localFile2.exists()) {
      localFile1 = new File(localContext.getFilesDir().getParent() + "/lib/lib" + "mqpintchk" + ".so");
    }
    if (localFile1.exists()) {}
    for (;;)
    {
      try
      {
        boolean bool = QPTxLoader.a(localFile1.getAbsolutePath());
        if (!bool) {}
        bool = false;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
      {
        try
        {
          System.loadLibrary("mqpintchk");
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
        {
          QLog.d("IntChkUtil", 2, "cannot load library mqpintchk");
        }
        localUnsatisfiedLinkError2 = localUnsatisfiedLinkError2;
        QLog.d("IntChkUtil", 2, "cannot load library " + localFile1.getAbsolutePath());
      }
    }
  }
  
  public static native boolean memchk(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public static native byte[] memreport(String paramString, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mqp.app.intchk.IntChkUtil
 * JD-Core Version:    0.7.0.1
 */