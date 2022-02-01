package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.uidomain.MailOperate;

class MailListFragment$41
  implements Runnable
{
  MailListFragment$41(MailListFragment paramMailListFragment, int paramInt, long[] paramArrayOfLong, boolean paramBoolean) {}
  
  public void run()
  {
    MailListFragment.access$2900(this.this$0).deleteMail(this.val$account, this.val$mailIds, this.val$isPurgeDelete);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.41
 * JD-Core Version:    0.7.0.1
 */