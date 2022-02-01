package com.tencent.moai.nativepages;

import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.moai.nativepages.download.AdLandingPagesDownloadResourceHelper.Callback;

class AdLandingPagesUI$16
  implements AdLandingPagesDownloadResourceHelper.Callback
{
  AdLandingPagesUI$16(AdLandingPagesUI paramAdLandingPagesUI, AdLandingPagesUI.ViewHolder paramViewHolder, AlphaAnimation paramAlphaAnimation) {}
  
  public void onDownloadError()
  {
    this.val$holder.nextBtn.startAnimation(this.val$alphaAnimation);
  }
  
  public void onDownloaded(String paramString)
  {
    AdLandingPagesUI.access$1700(this.this$0, paramString, this.val$holder.nextBtn);
    this.val$holder.nextBtn.startAnimation(this.val$alphaAnimation);
  }
  
  public void onStartDownload() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.AdLandingPagesUI.16
 * JD-Core Version:    0.7.0.1
 */