package com.tencent.gdtad.api.interstitial;

import android.content.Context;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import java.lang.ref.WeakReference;
import tho;
import thr;

public class GdtInterstitialPreDownloader$1
  implements Runnable
{
  public GdtInterstitialPreDownloader$1(thr paramthr, WeakReference paramWeakReference) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject = AdSettingsUtil.INSTANCE;
    if (this.val$weakContext != null)
    {
      localContext = (Context)this.val$weakContext.get();
      ((AdSettingsUtil)localObject).update(localContext);
      localObject = tho.a();
      if (this.val$weakContext == null) {
        break label121;
      }
    }
    label121:
    for (Context localContext = (Context)this.val$weakContext.get();; localContext = null)
    {
      boolean bool = ((tho)localObject).aF(localContext);
      if (bool) {
        thr.a().bCX();
      }
      AdLog.i("GdtInterstitialPreDownloader", "preDownloadAfterToolProcessStartup enabled:" + bool + " durationMillis:" + (System.currentTimeMillis() - l));
      return;
      localContext = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialPreDownloader.1
 * JD-Core Version:    0.7.0.1
 */