package com.tencent.qqmail.activity.networkanalyse;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqmail.utilities.log.NetworkAnalyseGeneralCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class NetworkAnalyseActivity$2$1
  implements NetworkAnalyseGeneralCallback
{
  NetworkAnalyseActivity$2$1(NetworkAnalyseActivity.2 param2, AtomicInteger paramAtomicInteger) {}
  
  public void onFinish(boolean paramBoolean, List<String> paramList, TextView paramTextView, ImageView paramImageView)
  {
    NetworkAnalyseActivity.access$300(this.this$1.this$0, new NetworkAnalyseActivity.2.1.1(this, paramList, paramTextView, paramImageView));
    this.val$count.incrementAndGet();
    if (this.val$count.intValue() == this.this$1.this$0.DEBUG_TEST_ADDRESS.length)
    {
      QMLog.log(4, "NetworkAnalyse", "dns end. begin ping");
      NetworkAnalyseActivity.2.access$400(this.this$1);
      return;
    }
    paramList = NetworkAnalyseActivity.access$000(this.this$1.this$0, "dns检查", "");
    NetworkAnalyseActivity.access$100(this.this$1.this$0, paramList);
    NetworkAnalyseHelper.debugDNS(this.this$1.this$0.DEBUG_TEST_ADDRESS[this.val$count.intValue()], this, (TextView)paramList.findViewById(2131365755), (ImageView)paramList.findViewById(2131362704));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.networkanalyse.NetworkAnalyseActivity.2.1
 * JD-Core Version:    0.7.0.1
 */