package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.androidqqmail.wxapi.WXEntryActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.data.CreditCardBill;

class ReadScheduleFragment$4
  implements View.OnClickListener
{
  ReadScheduleFragment$4(ReadScheduleFragment paramReadScheduleFragment) {}
  
  public void onClick(View paramView)
  {
    WXEntryActivity.openInWechatWebView(this.this$0.getActivity(), ReadScheduleFragment.access$800(this.this$0).url);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ReadScheduleFragment.4
 * JD-Core Version:    0.7.0.1
 */