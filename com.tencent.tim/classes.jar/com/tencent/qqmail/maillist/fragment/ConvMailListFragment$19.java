package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.utilities.ui.QMTips;

class ConvMailListFragment$19
  implements View.OnClickListener
{
  ConvMailListFragment$19(ConvMailListFragment paramConvMailListFragment) {}
  
  public void onClick(View paramView)
  {
    if (ConvMailListFragment.access$900(this.this$0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ConvMailListFragment.access$2700(this.this$0).length == 0) {
        this.this$0.getTips().showSuccess(2131695646, 700L);
      } else {
        ConvMailListFragment.access$3100(this.this$0).deleteMail(ConvMailListFragment.access$3000(this.this$0), ConvMailListFragment.access$2700(this.this$0), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.19
 * JD-Core Version:    0.7.0.1
 */