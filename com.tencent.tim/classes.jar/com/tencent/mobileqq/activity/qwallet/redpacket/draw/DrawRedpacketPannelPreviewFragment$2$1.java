package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import aaet;
import acfp;
import android.support.v4.app.FragmentActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DrawRedpacketPannelPreviewFragment$2$1
  implements Runnable
{
  public DrawRedpacketPannelPreviewFragment$2$1(aaet paramaaet, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.a.this$0.getActivity() == null) || (this.a.this$0.getActivity().isFinishing())) {
      return;
    }
    if (this.vf)
    {
      DrawRedpacketPannelPreviewFragment.a(this.a.this$0).setVisibility(4);
      DrawRedpacketPannelPreviewFragment.a(this.a.this$0).setText(acfp.m(2131705323));
      DrawRedpacketPannelPreviewFragment.b(this.a.this$0).setVisibility(0);
      DrawRedpacketPannelPreviewFragment.c(this.a.this$0).setVisibility(0);
      DrawRedpacketPannelPreviewFragment.b(this.a.this$0).setVisibility(0);
      DrawRedpacketPannelPreviewFragment.b(this.a.this$0).setText(this.a.val$title);
      return;
    }
    DrawRedpacketPannelPreviewFragment.a(this.a.this$0).setVisibility(4);
    DrawRedpacketPannelPreviewFragment.a(this.a.this$0).setText(acfp.m(2131705325));
    DrawRedpacketPannelPreviewFragment.b(this.a.this$0).setVisibility(8);
    DrawRedpacketPannelPreviewFragment.c(this.a.this$0).setVisibility(8);
    DrawRedpacketPannelPreviewFragment.a(this.a.this$0).setVisibility(0);
    DrawRedpacketPannelPreviewFragment.b(this.a.this$0).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment.2.1
 * JD-Core Version:    0.7.0.1
 */