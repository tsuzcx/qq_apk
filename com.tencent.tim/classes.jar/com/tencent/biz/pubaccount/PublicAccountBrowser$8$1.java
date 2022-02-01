package com.tencent.biz.pubaccount;

import aqgz;
import ayxa;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import com.tencent.widget.FadeIconImageView;
import riw;

class PublicAccountBrowser$8$1
  implements Runnable
{
  PublicAccountBrowser$8$1(PublicAccountBrowser.8 param8) {}
  
  public void run()
  {
    long l1 = aqgz.getWidth();
    long l2 = PublicAccountBrowser.b(this.a.this$0).getWidth();
    long l3 = riw.dip2px(this.a.this$0, 10.0F);
    int i = PublicAccountBrowser.a(this.a.this$0).getHeight();
    int j = riw.dip2px(this.a.this$0, 15.0F);
    int k = ayxa.getStatusBarHeight(this.a.this$0);
    PublicAccountBrowser.a(this.a.this$0, PublicAccountBrowser.b(this.a.this$0), (int)(l1 - l2 - l3), i + j + k, true, true, RIJRedPacketManager.a().jE(), RIJRedPacketManager.a().pa());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser.8.1
 * JD-Core Version:    0.7.0.1
 */