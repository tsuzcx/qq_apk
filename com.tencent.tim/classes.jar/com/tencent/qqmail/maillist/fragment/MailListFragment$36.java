package com.tencent.qqmail.maillist.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.movemail.MoveMailActivity;
import com.tencent.qqmail.utilities.ui.QMTips;
import java.util.HashMap;

class MailListFragment$36
  implements View.OnClickListener
{
  MailListFragment$36(MailListFragment paramMailListFragment) {}
  
  public void onClick(View paramView)
  {
    if ((MailListFragment.access$9000(this.this$0)) || (!MailListFragment.access$300(this.this$0)) || (MailListFragment.access$2100(this.this$0))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((MailListFragment.access$400(this.this$0) == null) || (MailListFragment.access$400(this.this$0).isEmpty()))
      {
        this.this$0.getTips().showInfo(2131695646);
      }
      else
      {
        Intent localIntent = MoveMailActivity.createIntent(MailListFragment.access$2200(this.this$0), MailListFragment.access$2400(this.this$0), MailListFragment.access$9100(this.this$0));
        this.this$0.startActivityForResult(localIntent, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.36
 * JD-Core Version:    0.7.0.1
 */