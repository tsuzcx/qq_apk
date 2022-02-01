package com.tencent.moai.nativepages.component;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.moai.nativepages.download.AdLandingPagesDownloadResourceHelper.StreamVideoDownloadCallback;

class AdLandingPageStreamVideo$1
  implements AdLandingPagesDownloadResourceHelper.StreamVideoDownloadCallback
{
  AdLandingPageStreamVideo$1(AdLandingPageStreamVideo paramAdLandingPageStreamVideo) {}
  
  public void onFail(String paramString)
  {
    AdLandingPageStreamVideo.access$000(this.this$0).setVisibility(8);
    AdLandingPageStreamVideo.access$100(this.this$0).setVisibility(0);
  }
  
  public void onFinish(String paramString)
  {
    AdLandingPageStreamVideo.access$000(this.this$0).setVisibility(8);
    AdLandingPageStreamVideo.access$100(this.this$0).setVisibility(8);
    this.this$0.viewAppeared(AdLandingPageStreamVideo.access$200(this.this$0), AdLandingPageStreamVideo.access$300(this.this$0), AdLandingPageStreamVideo.access$300(this.this$0));
  }
  
  public void onProgress(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageStreamVideo.1
 * JD-Core Version:    0.7.0.1
 */