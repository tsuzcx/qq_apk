package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;

class MailListFragment$27
  implements View.OnClickListener
{
  MailListFragment$27(MailListFragment paramMailListFragment) {}
  
  public void onClick(View paramView)
  {
    MailListFragment.access$7700(this.this$0).setVisibility(8);
    QMSharedPreferenceManager.getInstance().setGmailErrorMsgShow(false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.27
 * JD-Core Version:    0.7.0.1
 */