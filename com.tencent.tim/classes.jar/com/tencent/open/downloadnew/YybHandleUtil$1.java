package com.tencent.open.downloadnew;

import android.text.TextUtils;
import arwt;
import asaa;
import asac;
import java.io.File;

public final class YybHandleUtil$1
  implements Runnable
{
  public void run()
  {
    Object localObject = asac.a().f("com.tencent.android.qqdownloader");
    String str = "";
    if (localObject != null) {
      str = ((DownloadInfo)localObject).filePath;
    }
    if (!TextUtils.isEmpty(str))
    {
      localObject = new File(str);
      arwt.d(asaa.TAG, "---localFilePath = " + str);
      if ((localObject != null) && (((File)localObject).exists()))
      {
        arwt.d(asaa.TAG, "---delete apk ");
        ((File)localObject).delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.YybHandleUtil.1
 * JD-Core Version:    0.7.0.1
 */