package com.tencent.moai.nativepages.component;

import android.graphics.BitmapFactory;
import com.tencent.moai.nativepages.download.AdLandingPagesDownloadResourceHelper.Callback;

class AdLandingPageBtn$1
  implements AdLandingPagesDownloadResourceHelper.Callback
{
  AdLandingPageBtn$1(AdLandingPageBtn paramAdLandingPageBtn) {}
  
  public void onDownloadError() {}
  
  public void onDownloaded(String paramString)
  {
    paramString = BitmapFactory.decodeFile(paramString);
    if (paramString == null) {
      return;
    }
    AdLandingPageBtn.access$000(this.this$0, paramString);
  }
  
  public void onStartDownload() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageBtn.1
 * JD-Core Version:    0.7.0.1
 */