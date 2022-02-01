package com.tencent.qqmail.activity.networkanalyse;

import android.view.View;
import com.tencent.qqmail.view.QMTopBar;
import java.io.File;

class NetworkAnalyseActivity$2$3$2
  implements Runnable
{
  NetworkAnalyseActivity$2$3$2(NetworkAnalyseActivity.2.3 param3, File paramFile) {}
  
  public void run()
  {
    NetworkAnalyseActivity.access$1300(this.this$2.this$1.this$0).setButtonRightBlue("查看检测结果");
    NetworkAnalyseActivity.access$1300(this.this$2.this$1.this$0).getButtonRight().setEnabled(true);
    NetworkAnalyseActivity.access$1300(this.this$2.this$1.this$0).getButtonRight().setOnClickListener(new NetworkAnalyseActivity.2.3.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.networkanalyse.NetworkAnalyseActivity.2.3.2
 * JD-Core Version:    0.7.0.1
 */