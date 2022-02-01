package com.tencent.qqmail.activity.networkanalyse;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.LogPathManager;
import com.tencent.qqmail.utilities.log.NetworkAnalyseGeneralCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class NetworkAnalyseActivity$2$3
  implements NetworkAnalyseGeneralCallback
{
  NetworkAnalyseActivity$2$3(NetworkAnalyseActivity.2 param2, AtomicInteger paramAtomicInteger) {}
  
  public void onFinish(boolean paramBoolean, List<String> paramList, TextView paramTextView, ImageView paramImageView)
  {
    NetworkAnalyseActivity.access$900(this.this$1.this$0, new NetworkAnalyseActivity.2.3.1(this, paramTextView, paramList, paramImageView, paramBoolean));
    this.val$count.incrementAndGet();
    if (this.val$count.intValue() == this.this$1.this$0.DEBUG_PROXY_SOCKET.length)
    {
      Log.e("NetworkAnalyse", "proxysocket .............end");
      QMLog.log(4, "NetworkAnalyse", "proxysocket end");
      paramList = new File(LogPathManager.getInstance().getQMNetworkAnalyseFilePath());
      paramTextView = new ArrayList();
      paramTextView.add("dns result:");
      paramTextView.add(NetworkAnalyseActivity.access$1000(this.this$1.this$0));
      paramTextView.add("ping result:");
      paramTextView.add(NetworkAnalyseActivity.access$500(this.this$1.this$0));
      paramTextView.add("traceroute result:");
      paramTextView.addAll(NetworkAnalyseActivity.access$1100(this.this$1.this$0));
      paramTextView.add("proxysocket result:");
      paramTextView.add(NetworkAnalyseActivity.access$800(this.this$1.this$0));
      paramTextView.add("request result:");
      paramTextView.add(NetworkAnalyseActivity.access$1200(this.this$1.this$0));
      FileUtil.writeLogFileClear(paramList, paramTextView);
      NetworkAnalyseActivity.access$1400(this.this$1.this$0, new NetworkAnalyseActivity.2.3.2(this, paramList));
      return;
    }
    Log.w("NetworkAnalyse", "go next ping:" + this.this$1.this$0.DEBUG_PROXY_SOCKET[this.val$count.intValue()]);
    paramList = NetworkAnalyseActivity.access$000(this.this$1.this$0, "proxysocket检查", "");
    NetworkAnalyseActivity.access$100(this.this$1.this$0, paramList);
    NetworkAnalyseHelper.debugSocket(this.this$1.this$0.DEBUG_PROXY_SOCKET[this.val$count.intValue()].ip, this.this$1.this$0.DEBUG_PROXY_SOCKET[this.val$count.intValue()].port, this, (TextView)paramList.findViewById(2131365755), (ImageView)paramList.findViewById(2131362704));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.networkanalyse.NetworkAnalyseActivity.2.3
 * JD-Core Version:    0.7.0.1
 */