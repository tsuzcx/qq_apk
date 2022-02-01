package com.tencent.qqmail.calendar.fragment;

import android.widget.ImageView;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.thread.Threads;

class ReadScheduleFragment$6
  implements QMCallback.ISuccessCallback
{
  ReadScheduleFragment$6(ReadScheduleFragment paramReadScheduleFragment, ImageView paramImageView) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(4, "ReadScheduleFragment", "onSuccess" + paramQMNetworkResponse);
    Threads.runOnMainThread(new ReadScheduleFragment.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ReadScheduleFragment.6
 * JD-Core Version:    0.7.0.1
 */