package com.tencent.biz.subscribe.widget.relativevideo;

import acfp;
import android.widget.LinearLayout;
import android.widget.TextView;

class ServiceFolderFollowPBHeadView$2
  implements Runnable
{
  ServiceFolderFollowPBHeadView$2(ServiceFolderFollowPBHeadView paramServiceFolderFollowPBHeadView, int paramInt) {}
  
  public void run()
  {
    if (this.bxo > 0)
    {
      ServiceFolderFollowPBHeadView.a(this.this$0).setVisibility(0);
      String str = this.bxo + acfp.m(2131709402);
      ServiceFolderFollowPBHeadView.a(this.this$0).setText(str);
      return;
    }
    ServiceFolderFollowPBHeadView.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView.2
 * JD-Core Version:    0.7.0.1
 */