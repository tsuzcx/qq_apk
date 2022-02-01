package com.tencent.moai.nativepages.component;

import android.graphics.BitmapFactory;
import com.tencent.moai.nativepages.download.AdLandingPagesDownloadResourceHelper.Callback;

class AdLandingPageImageCircle$1
  implements AdLandingPagesDownloadResourceHelper.Callback
{
  AdLandingPageImageCircle$1(AdLandingPageImageCircle paramAdLandingPageImageCircle) {}
  
  public void onDownloadError() {}
  
  public void onDownloaded(String paramString)
  {
    paramString = BitmapFactory.decodeFile(paramString);
    if (paramString == null) {
      return;
    }
    this.this$0.setImageView(paramString);
  }
  
  public void onStartDownload() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageImageCircle.1
 * JD-Core Version:    0.7.0.1
 */