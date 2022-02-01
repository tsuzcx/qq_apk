package com.tencent.qqmail.activity.networkanalyse;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.attachment.util.IntentUtil;
import java.io.File;

class NetworkAnalyseActivity$2$3$2$1
  implements View.OnClickListener
{
  NetworkAnalyseActivity$2$3$2$1(NetworkAnalyseActivity.2.3.2 param2) {}
  
  public void onClick(View paramView)
  {
    IntentUtil.openFileLocation(this.this$3.this$2.this$1.this$0, this.this$3.val$logfile.getAbsolutePath());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.networkanalyse.NetworkAnalyseActivity.2.3.2.1
 * JD-Core Version:    0.7.0.1
 */