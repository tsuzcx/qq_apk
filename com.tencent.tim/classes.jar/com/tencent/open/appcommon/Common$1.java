package com.tencent.open.appcommon;

import android.text.TextUtils;
import arug;
import arwq;
import arwt;
import java.io.File;

public final class Common$1
  implements Runnable
{
  public void run()
  {
    File localFile1 = new File(arug.Dg());
    if (localFile1.exists())
    {
      File[] arrayOfFile = localFile1.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      if (i < j)
      {
        File localFile2 = arrayOfFile[i];
        if ((localFile2.getName().startsWith("system_old_")) || ((localFile2.isDirectory()) && (!localFile2.getName().equals("tmp")) && (!TextUtils.isEmpty(arug.Ds())) && (!localFile2.getName().equals(arug.Ds()))))
        {
          if (!arwq.H(new File(localFile1 + File.separator + localFile2.getName()))) {
            break label179;
          }
          arwt.i("Common", "<initSystemFolder> delete temp file<" + localFile2.getName() + "> successful");
        }
        for (;;)
        {
          i += 1;
          break;
          label179:
          arwt.d("Common", "<initSystemFolder> delete temp file<" + localFile2.getName() + "> failed");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.Common.1
 * JD-Core Version:    0.7.0.1
 */