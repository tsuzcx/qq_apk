package com.tencent.qqmail.activity.networkanalyse;

import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

class NetworkAnalyseActivity$2$3$1
  implements Runnable
{
  NetworkAnalyseActivity$2$3$1(NetworkAnalyseActivity.2.3 param3, TextView paramTextView, List paramList, ImageView paramImageView, boolean paramBoolean) {}
  
  public void run()
  {
    NetworkAnalyseActivity localNetworkAnalyseActivity = this.this$2.this$1.this$0;
    TextView localTextView = this.val$textView;
    String str = (String)this.val$results.get(0);
    ImageView localImageView = this.val$imageView;
    if (this.val$isOk) {}
    for (boolean bool = true;; bool = false)
    {
      NetworkAnalyseActivity.access$200(localNetworkAnalyseActivity, localTextView, str, localImageView, bool);
      NetworkAnalyseActivity.access$802(this.this$2.this$1.this$0, NetworkAnalyseActivity.access$800(this.this$2.this$1.this$0) + (String)this.val$results.get(0) + "\n");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.networkanalyse.NetworkAnalyseActivity.2.3.1
 * JD-Core Version:    0.7.0.1
 */