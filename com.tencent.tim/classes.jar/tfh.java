import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ad.tangram.canvas.download.AdDownloaderAdapter;
import com.tencent.ad.tangram.canvas.download.IAdDownloader;
import com.tencent.ad.tangram.canvas.download.IAdDownloader.Callback;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppBtnData;
import com.tencent.open.downloadnew.DownloadInfo;

public class tfh
  implements AdDownloaderAdapter
{
  public void doDownloadAction(Activity paramActivity, Bundle paramBundle, String paramString, int paramInt)
  {
    arvz.a().d(paramActivity, paramBundle, paramString, null, paramInt);
  }
  
  public int getCurrentPkgDownloadProgress(Context paramContext, String paramString1, String paramString2)
  {
    return tll.getCurrentPkgDownloadProgress(paramContext, paramString1, paramString2);
  }
  
  public Object getDownloadInfoByUrl(String paramString)
  {
    paramString = arvv.a().e(paramString);
    paramString.source = "biz_src_ads";
    return paramString;
  }
  
  public IAdDownloader getDownloader()
  {
    return this;
  }
  
  public int getProgress(Object paramObject)
  {
    if (!(paramObject instanceof DownloadInfo)) {
      return 0;
    }
    paramObject = (DownloadInfo)DownloadInfo.class.cast(paramObject);
    if (paramObject != null) {}
    for (int i = paramObject.progress;; i = 0) {
      return i;
    }
  }
  
  public void installDownload(Object paramObject)
  {
    if ((paramObject instanceof DownloadInfo)) {
      arvv.a().d((DownloadInfo)paramObject);
    }
    while (!(paramObject instanceof Bundle)) {
      return;
    }
    arvz.G((Bundle)paramObject);
  }
  
  public boolean isCurrentPkgTask(Pair<String, String> paramPair, Object paramObject)
  {
    if ((paramPair == null) || (TextUtils.isEmpty((CharSequence)paramPair.first)) || (TextUtils.isEmpty((CharSequence)paramPair.second)) || (!(paramObject instanceof AdAppBtnData))) {}
    do
    {
      do
      {
        return false;
        paramPair = arvv.a().e((String)paramPair.first);
      } while (paramPair == null);
      paramObject = (AdAppBtnData)paramObject;
    } while ((TextUtils.isEmpty(paramPair.packageName)) || (TextUtils.isEmpty(paramPair.appId)) || (TextUtils.isEmpty(paramObject.packageName)) || (TextUtils.isEmpty(paramObject.mGdtAd_appId)));
    return (paramPair.packageName.equals(paramObject.packageName)) && (paramPair.appId.equals(paramObject.mGdtAd_appId));
  }
  
  public int isPkgDownloadPaused(Context paramContext, String paramString1, String paramString2)
  {
    return tll.isPkgDownloadPaused(paramContext, paramString1, paramString2);
  }
  
  public int isPkgDownloading(Context paramContext, String paramString1, String paramString2)
  {
    return tll.isPkgDownloading(paramContext, paramString1, paramString2);
  }
  
  public boolean isPkgExist(Context paramContext, String paramString1, String paramString2)
  {
    return tll.K(paramContext, paramString2);
  }
  
  public void pauseDownload(String paramString1, String paramString2)
  {
    arvv.a().fx(paramString2);
  }
  
  public void registerListener(IAdDownloader.Callback paramCallback)
  {
    if ((paramCallback instanceof aryx)) {
      arvv.a().a((aryx)paramCallback);
    }
  }
  
  public void unregisterListener(IAdDownloader.Callback paramCallback)
  {
    if ((paramCallback instanceof aryx)) {
      arvv.a().b((aryx)paramCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tfh
 * JD-Core Version:    0.7.0.1
 */