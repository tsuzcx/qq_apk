package com.tencent.mobileqq.apollo.activity;

import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

class HotChatCenterFragment$5
  implements Runnable
{
  HotChatCenterFragment$5(HotChatCenterFragment paramHotChatCenterFragment, int paramInt, TextView paramTextView) {}
  
  public void run()
  {
    if (this.this$0.isAdded())
    {
      String str1 = "" + this.aIU;
      if (!HotChatCenterFragment.a(this.this$0))
      {
        str1 = this.this$0.getString(2131720735) + "(" + this.aIU + ")";
        if (this.aIU > 99) {
          str1 = this.this$0.getString(2131720735) + "(99+)";
        }
        if (this.aIU <= 0) {
          str1 = this.this$0.getString(2131720735);
        }
      }
      String str2 = str1;
      if (HotChatCenterFragment.a(this.this$0))
      {
        str2 = str1;
        if (this.aIU > 99) {
          str2 = "99+";
        }
      }
      if (this.this$0.isAdded()) {
        this.this$0.getActivity().runOnUiThread(new HotChatCenterFragment.5.1(this, str2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.activity.HotChatCenterFragment.5
 * JD-Core Version:    0.7.0.1
 */