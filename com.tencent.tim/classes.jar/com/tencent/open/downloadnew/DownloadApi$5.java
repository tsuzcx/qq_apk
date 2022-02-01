package com.tencent.open.downloadnew;

import arwt;
import aryr;
import aryy;
import arzf;
import java.util.ArrayList;
import java.util.List;

public final class DownloadApi$5
  implements Runnable
{
  public DownloadApi$5(List paramList, arzf paramarzf) {}
  
  public void run()
  {
    arwt.v(aryr.TAG, "getQueryDownloadAction enter");
    aryy.a().elQ();
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList = new ArrayList();
        int j = this.bD.size();
        i = 0;
        if (i < j)
        {
          DownloadInfo localDownloadInfo = (DownloadInfo)this.bD.get(i);
          if (aryy.a().e(localDownloadInfo))
          {
            arwt.v(aryr.TAG, "refreshDownloadInfo true " + localDownloadInfo);
            localArrayList.add(localDownloadInfo);
          }
        }
        else
        {
          if (this.a != null) {
            this.a.bl(localArrayList);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        arwt.e(aryr.TAG, "Exception>>>", localException);
        if (this.a == null) {
          continue;
        }
        this.a.F(-1, localException.getMessage());
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi.5
 * JD-Core Version:    0.7.0.1
 */