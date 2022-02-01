package com.tencent.qqmail.activity.networkanalyse;

import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

class NetworkAnalyseActivity$2$1$1
  implements Runnable
{
  NetworkAnalyseActivity$2$1$1(NetworkAnalyseActivity.2.1 param1, List paramList, TextView paramTextView, ImageView paramImageView) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.val$results != null) && (this.val$results.size() > 0))
    {
      localStringBuilder.append((String)this.val$results.get(0));
      NetworkAnalyseActivity.access$200(this.this$2.this$1.this$0, this.val$textView, localStringBuilder.toString(), this.val$imageView, true);
      return;
    }
    localStringBuilder.append("dns出现异常");
    NetworkAnalyseActivity.access$200(this.this$2.this$1.this$0, this.val$textView, localStringBuilder.toString(), this.val$imageView, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.networkanalyse.NetworkAnalyseActivity.2.1.1
 * JD-Core Version:    0.7.0.1
 */