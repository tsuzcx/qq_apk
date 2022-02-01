package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.watcher.RecallMailWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;

class MailRecallListFragment$2
  implements RecallMailWatcher
{
  MailRecallListFragment$2(MailRecallListFragment paramMailRecallListFragment) {}
  
  public void onError(long paramLong, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(4, "MailRecallListFragment", "RecallMailWatcher onError mailId:" + paramLong + " error:" + paramQMNetworkError.desp);
    if (MailRecallListFragment.access$300(this.this$0) == paramLong) {
      MailRecallListFragment.access$1200(this.this$0, new MailRecallListFragment.2.3(this));
    }
  }
  
  public void onProcess(long paramLong)
  {
    QMLog.log(4, "MailRecallListFragment", "RecallMailWatcher onProcess mailId:" + paramLong);
    if (MailRecallListFragment.access$300(this.this$0) == paramLong)
    {
      MailRecallListFragment.access$400(this.this$0);
      MailRecallListFragment.access$600(this.this$0, new MailRecallListFragment.2.1(this));
    }
  }
  
  public void onQueryError(long paramLong, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "MailRecallListFragment", "RecallMailWatcher onQueryError mailId:" + paramLong + " error:" + paramQMNetworkError.desp);
    if (MailRecallListFragment.access$300(this.this$0) == paramLong)
    {
      if (QMNetworkUtils.isNetworkConnected(this.this$0.getActivity())) {
        MailRecallListFragment.access$1000(this.this$0);
      }
    }
    else {
      return;
    }
    MailRecallListFragment.access$1600(this.this$0, new MailRecallListFragment.2.6(this));
  }
  
  public void onQueryProcess(long paramLong)
  {
    QMLog.log(4, "MailRecallListFragment", "RecallMailWatcher onQueryProcess mailId:" + paramLong);
    if (MailRecallListFragment.access$300(this.this$0) == paramLong)
    {
      MailRecallListFragment.access$400(this.this$0);
      MailRecallListFragment.access$1300(this.this$0, new MailRecallListFragment.2.4(this));
    }
  }
  
  public void onQuerySuccess(long paramLong)
  {
    QMLog.log(4, "MailRecallListFragment", "RecallMailWatcher onQuerySuccess mailId:" + paramLong);
    if (MailRecallListFragment.access$300(this.this$0) == paramLong)
    {
      MailRecallListFragment.access$400(this.this$0);
      MailRecallListFragment.access$1400(this.this$0, new MailRecallListFragment.2.5(this));
    }
  }
  
  public void onSuccess(long paramLong1, long paramLong2)
  {
    QMLog.log(4, "MailRecallListFragment", "RecallMailWatcher onSuccess mailId:" + paramLong1 + " taskId:" + paramLong2);
    if (MailRecallListFragment.access$300(this.this$0) == paramLong1)
    {
      MailRecallListFragment.access$400(this.this$0);
      MailRecallListFragment.access$800(this.this$0, new MailRecallListFragment.2.2(this));
      MailRecallListFragment.access$902(this.this$0, paramLong2);
      MailRecallListFragment.access$1000(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailRecallListFragment.2
 * JD-Core Version:    0.7.0.1
 */