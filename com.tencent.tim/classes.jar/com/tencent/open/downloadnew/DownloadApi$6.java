package com.tencent.open.downloadnew;

import arwt;
import aryr;
import aryy;
import arzf;
import java.util.ArrayList;
import java.util.List;

public final class DownloadApi$6
  implements Runnable
{
  public DownloadApi$6(String paramString, arzf paramarzf) {}
  
  public void run()
  {
    arwt.v(aryr.TAG, "getQueryDownloadActionByVia enter");
    try
    {
      new ArrayList();
      List localList = aryy.a().bk(this.cCm);
      arwt.v(aryr.TAG, "getQueryDownloadActionByVia result = " + localList);
      if (this.a != null) {
        this.a.bl(localList);
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        arwt.e(aryr.TAG, "getQueryDownloadActionByVia Exception>>>", localException);
      } while (this.a == null);
      this.a.F(-1, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi.6
 * JD-Core Version:    0.7.0.1
 */