package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import moai.fragment.app.FragmentManager.OnBackStackChangedListener;

class MailListFragment$MailListItemClick$2
  implements FragmentManager.OnBackStackChangedListener
{
  MailListFragment$MailListItemClick$2(MailListFragment.MailListItemClick paramMailListItemClick) {}
  
  public void onBackStackChanged()
  {
    MailListFragment.access$000(this.this$1.this$0).setOnItemClickListener(this.this$1);
    this.this$1.this$0.removeBackStackChangedListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.MailListItemClick.2
 * JD-Core Version:    0.7.0.1
 */