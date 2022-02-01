package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.TitleBarWebView2;
import com.tencent.qqmail.view.TitleBarWebView2.OnScrollListener;

class ReadVirtualAdsMailFragment$8
  implements TitleBarWebView2.OnScrollListener
{
  ReadVirtualAdsMailFragment$8(ReadVirtualAdsMailFragment paramReadVirtualAdsMailFragment) {}
  
  public void onScrollBegin() {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((!ReadVirtualAdsMailFragment.access$1100(this.this$0)) && (paramInt2 >= (QMUIKit.dpToPx(ReadVirtualAdsMailFragment.access$1200(this.this$0).getContentHeight()) - ReadVirtualAdsMailFragment.access$1300(this.this$0)) * 0.8D))
    {
      ReadVirtualAdsMailFragment.access$1102(this.this$0, true);
      DataCollector.logEvent("Event_AD_Mail_Scroll_More_Than_Eighty");
    }
  }
  
  public void onScrollEnd() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadVirtualAdsMailFragment.8
 * JD-Core Version:    0.7.0.1
 */