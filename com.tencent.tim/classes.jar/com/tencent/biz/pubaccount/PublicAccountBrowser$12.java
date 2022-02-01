package com.tencent.biz.pubaccount;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

class PublicAccountBrowser$12
  implements Runnable
{
  PublicAccountBrowser$12(PublicAccountBrowser paramPublicAccountBrowser, String paramString) {}
  
  public void run()
  {
    if (PublicAccountBrowser.a(this.this$0) <= RIJRedPacketManager.a().oV())
    {
      PublicAccountBrowser.b(this.this$0, PublicAccountBrowser.a(this.this$0) + FastWebActivity.aZL);
      PublicAccountBrowser.a(this.this$0).post(new PublicAccountBrowser.12.1(this));
    }
    for (;;)
    {
      PublicAccountBrowser.a(this.this$0).postDelayed(PublicAccountBrowser.a(this.this$0), FastWebActivity.aZL);
      return;
      PublicAccountBrowser.a(this.this$0).stopTiming();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser.12
 * JD-Core Version:    0.7.0.1
 */