package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.cursor.QMConvMailCursor;
import java.util.concurrent.Callable;

class ConvMailListFragment$13
  implements Callable<QMMailListCursor>
{
  ConvMailListFragment$13(ConvMailListFragment paramConvMailListFragment) {}
  
  public QMMailListCursor call()
  {
    QMConvMailCursor localQMConvMailCursor = QMMailManager.sharedInstance().getConvMailListCursor(ConvMailListFragment.access$800(this.this$0), ConvMailListFragment.access$1900(this.this$0));
    localQMConvMailCursor.setOnRefresh(new ConvMailListFragment.13.1(this));
    localQMConvMailCursor.setThreadWrapper(new ConvMailListFragment.13.2(this));
    return localQMConvMailCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.13
 * JD-Core Version:    0.7.0.1
 */