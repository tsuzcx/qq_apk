package com.tencent.mobileqq.onlinestatus;

import akte;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import ankt;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;

public class AutoReplyEditActivity$8
  implements Runnable
{
  AutoReplyEditActivity$8(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public void run()
  {
    AutoReplyEditActivity.a(this.this$0, true);
    ViewGroup.LayoutParams localLayoutParams = AutoReplyEditActivity.a(this.this$0).getLayoutParams();
    AutoReplyEditActivity.a(this.this$0).setImageResource(2130837612);
    AutoReplyEditActivity.a(this.this$0).setContentDescription(this.this$0.getActivity().getString(2131690681));
    AutoReplyEditActivity.a(this.this$0).setOnClickListener(new akte(this));
    AutoReplyEditActivity.a(this.this$0).setVisibility(0);
    localLayoutParams.height = (ankt.cIE / 3 + ankt.dip2px(50.0F));
    AutoReplyEditActivity.a(this.this$0).setMinimumHeight(localLayoutParams.height);
    AutoReplyEditActivity.a(this.this$0).setLayoutParams(localLayoutParams);
    AutoReplyEditActivity.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity.8
 * JD-Core Version:    0.7.0.1
 */