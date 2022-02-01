package com.tencent.biz.pubaccount;

import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;

class PublicAccountBrowser$8
  implements Runnable
{
  PublicAccountBrowser$8(PublicAccountBrowser paramPublicAccountBrowser) {}
  
  public void run()
  {
    if (PublicAccountBrowser.b(this.this$0) == null)
    {
      PublicAccountBrowser.b(this.this$0, new RIJRedPacketPopupView(this.this$0));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout)this.this$0.findViewById(2131363728)).addView(PublicAccountBrowser.b(this.this$0), localLayoutParams);
    }
    PublicAccountBrowser.b(this.this$0).nO(true);
    PublicAccountBrowser.b(this.this$0).nP(true);
    PublicAccountBrowser.b(this.this$0).setText(RIJRedPacketManager.a().jE());
    PublicAccountBrowser.b(this.this$0).setVisibility(4);
    PublicAccountBrowser.b(this.this$0).post(new PublicAccountBrowser.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser.8
 * JD-Core Version:    0.7.0.1
 */