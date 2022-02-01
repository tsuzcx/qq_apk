package com.tencent.qqmail.activity.networkanalyse;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqmail.utilities.log.NetworkAnalyseGeneralCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class NetworkAnalyseActivity$2$4
  implements NetworkAnalyseGeneralCallback
{
  NetworkAnalyseActivity$2$4(NetworkAnalyseActivity.2 param2, AtomicInteger paramAtomicInteger, String[] paramArrayOfString) {}
  
  public void onFinish(boolean paramBoolean, List<String> paramList, TextView paramTextView, ImageView paramImageView)
  {
    NetworkAnalyseActivity.access$1500(this.this$1.this$0, new NetworkAnalyseActivity.2.4.1(this, paramList, paramTextView, paramImageView));
    this.val$count.incrementAndGet();
    NetworkAnalyseActivity.access$1100(this.this$1.this$0).addAll(paramList);
    if (this.val$count.intValue() == this.val$addrs.length)
    {
      Log.e("mason", "trace .............end");
      QMLog.log(4, "NetworkAnalyse", "traceroute end. begin sendrequest");
      NetworkAnalyseActivity.2.access$1600(this.this$1);
      return;
    }
    paramList = NetworkAnalyseActivity.access$000(this.this$1.this$0, "traceroute检查", "");
    NetworkAnalyseActivity.access$100(this.this$1.this$0, paramList);
    NetworkAnalyseActivity.2.access$1700(this.this$1, this.val$addrs[this.val$count.intValue()], this, (TextView)paramList.findViewById(2131365755), (ImageView)paramList.findViewById(2131362704));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.networkanalyse.NetworkAnalyseActivity.2.4
 * JD-Core Version:    0.7.0.1
 */