package com.tencent.qqmail.activity.networkanalyse;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqmail.view.imageview.MathUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class NetworkAnalyseActivity$2$2$1
  implements Runnable
{
  NetworkAnalyseActivity$2$2$1(NetworkAnalyseActivity.2.2 param2, List paramList, int paramInt, TextView paramTextView, ImageView paramImageView) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1;
    if ((this.val$results != null) && (this.val$results.size() > 0))
    {
      localObject1 = new ArrayList();
      Object localObject2 = Pattern.compile("time=.*?ms").matcher((CharSequence)this.val$results.get(0));
      Pattern localPattern = Pattern.compile("\\d+(\\.\\d+)?");
      while (((Matcher)localObject2).find())
      {
        Matcher localMatcher = localPattern.matcher(((Matcher)localObject2).group(0));
        if (localMatcher.find()) {
          ((List)localObject1).add(Double.valueOf(localMatcher.group(0)));
        }
      }
      double d1 = MathUtils.findMax((List)localObject1);
      double d2 = MathUtils.findMin((List)localObject1);
      double d3 = MathUtils.avg((List)localObject1);
      localObject2 = localStringBuilder.append("ping地址:");
      if (this.val$curIndex < this.this$2.this$1.this$0.DEBUG_TEST_ADDRESS.length)
      {
        localObject1 = this.this$2.this$1.this$0.DEBUG_TEST_ADDRESS[this.val$curIndex];
        ((StringBuilder)localObject2).append((String)localObject1).append("\n").append("最大耗时:").append(d1).append("(ms).").append("\n").append("最小耗时:").append(d2).append("(ms).").append("\n").append("平均耗时:").append(String.format("%.2f", new Object[] { Double.valueOf(d3) })).append("(ms).");
        NetworkAnalyseActivity.access$200(this.this$2.this$1.this$0, this.val$textView, localStringBuilder.toString(), this.val$imageView, true);
      }
    }
    for (;;)
    {
      NetworkAnalyseActivity.access$502(this.this$2.this$1.this$0, NetworkAnalyseActivity.access$500(this.this$2.this$1.this$0) + localStringBuilder.toString());
      return;
      localObject1 = "";
      break;
      localStringBuilder.append("ping出现异常");
      NetworkAnalyseActivity.access$200(this.this$2.this$1.this$0, this.val$textView, localStringBuilder.toString(), this.val$imageView, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.networkanalyse.NetworkAnalyseActivity.2.2.1
 * JD-Core Version:    0.7.0.1
 */