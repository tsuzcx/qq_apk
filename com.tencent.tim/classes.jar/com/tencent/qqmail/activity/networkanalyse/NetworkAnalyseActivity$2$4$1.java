package com.tencent.qqmail.activity.networkanalyse;

import android.widget.ImageView;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class NetworkAnalyseActivity$2$4$1
  implements Runnable
{
  NetworkAnalyseActivity$2$4$1(NetworkAnalyseActivity.2.4 param4, List paramList, TextView paramTextView, ImageView paramImageView) {}
  
  public void run()
  {
    int i = this.this$2.val$count.intValue();
    if (this.val$results.size() > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = this.val$results.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localStringBuilder.append("\n");
        localStringBuilder.append((String)localObject2);
      }
      Object localObject2 = new StringBuilder().append("traceroute地址:");
      if (i < this.this$2.val$addrs.length) {}
      for (localObject1 = this.this$2.val$addrs[i];; localObject1 = "")
      {
        localObject1 = (String)localObject1 + localStringBuilder.toString();
        NetworkAnalyseActivity.access$200(this.this$2.this$1.this$0, this.val$textView, (String)localObject1, this.val$imageView, true);
        return;
      }
    }
    NetworkAnalyseActivity.access$200(this.this$2.this$1.this$0, this.val$textView, "traceroute出现问题", this.val$imageView, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.networkanalyse.NetworkAnalyseActivity.2.4.1
 * JD-Core Version:    0.7.0.1
 */