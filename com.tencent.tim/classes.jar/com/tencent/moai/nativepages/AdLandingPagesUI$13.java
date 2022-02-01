package com.tencent.moai.nativepages;

import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.moai.nativepages.download.AdLandingPagesDownloadResourceHelper.Callback;

class AdLandingPagesUI$13
  implements AdLandingPagesDownloadResourceHelper.Callback
{
  AdLandingPagesUI$13(AdLandingPagesUI paramAdLandingPagesUI, AlphaAnimation paramAlphaAnimation) {}
  
  public void onDownloadError()
  {
    AdLandingPagesUI.access$1300(this.this$0).startAnimation(this.val$alphaAnimation);
  }
  
  public void onDownloaded(String paramString)
  {
    AdLandingPagesUI.access$1700(this.this$0, paramString, AdLandingPagesUI.access$1300(this.this$0));
    AdLandingPagesUI.access$1300(this.this$0).startAnimation(this.val$alphaAnimation);
  }
  
  public void onStartDownload() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.AdLandingPagesUI.13
 * JD-Core Version:    0.7.0.1
 */