package com.tencent.qqmail.activity.networkanalyse;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqmail.utilities.log.NetworkAnalyseGeneralCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.List;

class NetworkAnalyseActivity$2$5
  implements NetworkAnalyseGeneralCallback
{
  NetworkAnalyseActivity$2$5(NetworkAnalyseActivity.2 param2) {}
  
  public void onFinish(boolean paramBoolean, List<String> paramList, TextView paramTextView, ImageView paramImageView)
  {
    QMLog.log(4, "NetworkAnalyse", "sendrequest end.");
    if (paramList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        NetworkAnalyseActivity.access$1202(this.this$1.this$0, NetworkAnalyseActivity.access$1200(this.this$1.this$0) + (String)paramList.get(i));
        i += 1;
      }
      NetworkAnalyseActivity.access$1800(this.this$1.this$0, new NetworkAnalyseActivity.2.5.1(this, paramTextView, paramImageView));
    }
    NetworkAnalyseActivity.2.access$1900(this.this$1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.networkanalyse.NetworkAnalyseActivity.2.5
 * JD-Core Version:    0.7.0.1
 */