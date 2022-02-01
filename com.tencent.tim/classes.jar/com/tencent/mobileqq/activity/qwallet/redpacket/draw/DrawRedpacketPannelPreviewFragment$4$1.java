package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import aaev;
import acfp;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import rpq;

public class DrawRedpacketPannelPreviewFragment$4$1
  implements Runnable
{
  public DrawRedpacketPannelPreviewFragment$4$1(aaev paramaaev, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.a.this$0.getActivity() == null) || (this.a.this$0.getActivity().isFinishing())) {}
    for (;;)
    {
      return;
      DrawRedpacketPannelPreviewFragment.a(this.a.this$0, this.vf);
      DrawRedpacketPannelPreviewFragment.a(this.a.this$0);
      if (QLog.isColorLevel()) {
        QLog.d(DrawRedpacketPannelPreviewFragment.TAG, 2, "---onRecog---" + this.vf);
      }
      if (DrawRedpacketPannelPreviewFragment.a(this.a.this$0))
      {
        DrawRedpacketPannelPreviewFragment.c(this.a.this$0).setTextColor(Color.parseColor("#00D9B5"));
        DrawRedpacketPannelPreviewFragment.c(this.a.this$0).setCompoundDrawablesWithIntrinsicBounds(2130848138, 0, 0, 0);
        DrawRedpacketPannelPreviewFragment.c(this.a.this$0).setCompoundDrawablePadding(rpq.dip2px(this.a.this$0.getActivity(), 5.0F));
        DrawRedpacketPannelPreviewFragment.c(this.a.this$0).setText(acfp.m(2131705329));
      }
      while (DrawRedpacketPannelPreviewFragment.b(this.a.this$0))
      {
        DrawRedpacketPannelPreviewFragment.b(this.a.this$0);
        return;
        DrawRedpacketPannelPreviewFragment.c(this.a.this$0).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        if ((DrawRedpacketPannelPreviewFragment.a(this.a.this$0) != null) && (DrawRedpacketPannelPreviewFragment.a(this.a.this$0).e(false, false) == 0)) {
          DrawRedpacketPannelPreviewFragment.c(this.a.this$0).setText("......");
        } else {
          DrawRedpacketPannelPreviewFragment.c(this.a.this$0).setText(acfp.m(2131705319));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment.4.1
 * JD-Core Version:    0.7.0.1
 */