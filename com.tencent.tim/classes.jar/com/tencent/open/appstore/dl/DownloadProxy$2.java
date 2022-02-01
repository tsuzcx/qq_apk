package com.tencent.open.appstore.dl;

import arvv;
import arvz;
import arwt;
import arzf;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

public class DownloadProxy$2
  implements Runnable
{
  public DownloadProxy$2(arvz paramarvz, List paramList, arzf paramarzf) {}
  
  public void run()
  {
    arwt.i("DownloadResolver", "[queryByDownloadManagerV2] enter");
    arvv.a().elQ();
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
          if (arvv.a().e(localDownloadInfo))
          {
            arwt.i("DownloadResolver", "[queryByDownloadManagerV2] refreshDownloadInfo true " + localDownloadInfo);
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
        arwt.e("DownloadResolver", "[queryByDownloadManagerV2] Exception>>>", localException);
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
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadProxy.2
 * JD-Core Version:    0.7.0.1
 */