package com.tencent.moai.nativepages.component;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.moai.nativepages.download.AdLandingPagesDownloadResourceHelper.Callback;

class AdLandingPageSightVideo$1
  implements AdLandingPagesDownloadResourceHelper.Callback
{
  AdLandingPageSightVideo$1(AdLandingPageSightVideo paramAdLandingPageSightVideo) {}
  
  public void onDownloadError()
  {
    AdLandingPageSightVideo.access$000(this.this$0).setVisibility(8);
    AdLandingPageSightVideo.access$100(this.this$0).setVisibility(0);
  }
  
  public void onDownloaded(String paramString)
  {
    AdLandingPageSightVideo.access$000(this.this$0).setVisibility(8);
    AdLandingPageSightVideo.access$100(this.this$0).setVisibility(8);
    this.this$0.viewAppeared(AdLandingPageSightVideo.access$200(this.this$0), AdLandingPageSightVideo.access$300(this.this$0), AdLandingPageSightVideo.access$300(this.this$0));
  }
  
  public void onStartDownload() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageSightVideo.1
 * JD-Core Version:    0.7.0.1
 */