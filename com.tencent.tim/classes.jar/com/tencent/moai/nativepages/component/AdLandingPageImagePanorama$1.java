package com.tencent.moai.nativepages.component;

import android.graphics.BitmapFactory;
import com.tencent.moai.nativepages.download.AdLandingPagesDownloadResourceHelper.Callback;

class AdLandingPageImagePanorama$1
  implements AdLandingPagesDownloadResourceHelper.Callback
{
  AdLandingPageImagePanorama$1(AdLandingPageImagePanorama paramAdLandingPageImagePanorama) {}
  
  public void onDownloadError()
  {
    this.this$0.stopLoading();
  }
  
  public void onDownloaded(String paramString)
  {
    paramString = BitmapFactory.decodeFile(paramString);
    if (paramString == null) {
      return;
    }
    this.this$0.setImage(paramString);
  }
  
  public void onStartDownload()
  {
    this.this$0.startLoading();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageImagePanorama.1
 * JD-Core Version:    0.7.0.1
 */