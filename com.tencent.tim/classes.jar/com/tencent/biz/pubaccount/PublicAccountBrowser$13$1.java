package com.tencent.biz.pubaccount;

import aqgz;
import ayxa;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import com.tencent.widget.FadeIconImageView;
import jzx;
import riw;

public class PublicAccountBrowser$13$1
  implements Runnable
{
  public PublicAccountBrowser$13$1(jzx paramjzx, String paramString) {}
  
  public void run()
  {
    int i = (int)(aqgz.getWidth() - PublicAccountBrowser.b(this.a.this$0).getWidth() - riw.dip2px(this.a.this$0, 10.0F));
    int j = PublicAccountBrowser.a(this.a.this$0).getHeight();
    int k = riw.dip2px(this.a.this$0, 15.0F);
    int m = ayxa.getStatusBarHeight(this.a.this$0);
    PublicAccountBrowser.a(this.a.this$0, PublicAccountBrowser.b(this.a.this$0), i, j + k + m, false, false, this.Vv, RIJRedPacketManager.a().oW());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser.13.1
 * JD-Core Version:    0.7.0.1
 */