package com.tencent.mobileqq.activity.qwallet.preload;

import aacc;
import android.os.Bundle;
import aquy;
import aquz;
import aqvc;
import com.tencent.util.Pair;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class PreloadComDownloader$3
  implements Runnable
{
  public PreloadComDownloader$3(aacc paramaacc, DownloadParam paramDownloadParam, aquy paramaquy, Bundle paramBundle) {}
  
  public void run()
  {
    aquz localaquz = new aquz(this.a.url, new File(this.a.filePath));
    localaquz.cxX = "QwalletPreload";
    if (this.a.headers != null)
    {
      Iterator localIterator = this.a.headers.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (localPair != null) {
          localaquz.addHeader((String)localPair.first, (String)localPair.second);
        }
      }
    }
    if (aacc.a(this.this$0) != null) {
      aacc.a(this.this$0).a(localaquz, this.f, this.val$params);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.3
 * JD-Core Version:    0.7.0.1
 */