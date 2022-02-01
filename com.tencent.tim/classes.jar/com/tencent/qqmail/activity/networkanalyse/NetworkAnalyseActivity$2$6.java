package com.tencent.qqmail.activity.networkanalyse;

import android.view.View;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.view.QMTopBar;

class NetworkAnalyseActivity$2$6
  implements Runnable
{
  NetworkAnalyseActivity$2$6(NetworkAnalyseActivity.2 param2) {}
  
  public void run()
  {
    NetworkAnalyseActivity.access$1300(this.this$1.this$0).getButtonRight().setEnabled(false);
    NetworkAnalyseActivity.access$2000(this.this$1.this$0);
    Threads.runInBackground(new NetworkAnalyseActivity.2.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.networkanalyse.NetworkAnalyseActivity.2.6
 * JD-Core Version:    0.7.0.1
 */