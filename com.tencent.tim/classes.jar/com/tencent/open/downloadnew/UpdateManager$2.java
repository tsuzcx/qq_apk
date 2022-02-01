package com.tencent.open.downloadnew;

import arwt;
import aryy;
import arzx;
import java.io.File;

public class UpdateManager$2
  implements Runnable
{
  public UpdateManager$2(arzx paramarzx, String paramString, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      File localFile = new File(this.cDO);
      if (localFile.exists())
      {
        long l = localFile.length();
        this.f.awN = l;
        aryy.a().A(this.f);
        return;
      }
      arwt.d(arzx.TAG, "patchNewApk file not exists");
      return;
    }
    catch (Exception localException)
    {
      arwt.e(arzx.TAG, "patchNewApk>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.UpdateManager.2
 * JD-Core Version:    0.7.0.1
 */