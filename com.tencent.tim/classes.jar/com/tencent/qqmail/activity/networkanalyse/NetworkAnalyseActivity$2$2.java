package com.tencent.qqmail.activity.networkanalyse;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqmail.utilities.log.NetworkAnalyseGeneralCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class NetworkAnalyseActivity$2$2
  implements NetworkAnalyseGeneralCallback
{
  NetworkAnalyseActivity$2$2(NetworkAnalyseActivity.2 param2, AtomicInteger paramAtomicInteger) {}
  
  public void onFinish(boolean paramBoolean, List<String> paramList, TextView paramTextView, ImageView paramImageView)
  {
    int i = this.val$count.intValue();
    NetworkAnalyseActivity.access$600(this.this$1.this$0, new NetworkAnalyseActivity.2.2.1(this, paramList, i, paramTextView, paramImageView));
    this.val$count.incrementAndGet();
    if (this.val$count.intValue() == this.this$1.this$0.DEBUG_TEST_ADDRESS.length)
    {
      Log.e("mason", "ping .............end");
      QMLog.log(4, "NetworkAnalyse", "ping end. begin trace");
      NetworkAnalyseActivity.2.access$700(this.this$1);
      return;
    }
    Log.w("mason", "go next ping:" + this.this$1.this$0.DEBUG_TEST_ADDRESS[this.val$count.intValue()]);
    paramList = NetworkAnalyseActivity.access$000(this.this$1.this$0, "ping检查", "");
    NetworkAnalyseActivity.access$100(this.this$1.this$0, paramList);
    NetworkAnalyseHelper.debugPing(this.this$1.this$0.DEBUG_TEST_ADDRESS[this.val$count.intValue()], this, (TextView)paramList.findViewById(2131365755), (ImageView)paramList.findViewById(2131362704));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.networkanalyse.NetworkAnalyseActivity.2.2
 * JD-Core Version:    0.7.0.1
 */