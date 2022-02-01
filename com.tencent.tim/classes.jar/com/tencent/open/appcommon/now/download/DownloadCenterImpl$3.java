package com.tencent.open.appcommon.now.download;

import arux;
import arva;
import arwt;
import aryy;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DownloadCenterImpl$3
  implements Runnable
{
  public DownloadCenterImpl$3(arux paramarux, ArrayList paramArrayList) {}
  
  public void run()
  {
    arwt.v("DownloadCenterImpl", "getQueryDownloadAction enter");
    ArrayList localArrayList = new ArrayList();
    int j = this.gf.size();
    int i = 0;
    while (i < j)
    {
      localObject = (DownloadInfo)this.gf.get(i);
      if (aryy.a().e((DownloadInfo)localObject)) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    Object localObject = arux.a(this.this$0).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((arva)((Iterator)localObject).next()).nn(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.DownloadCenterImpl.3
 * JD-Core Version:    0.7.0.1
 */