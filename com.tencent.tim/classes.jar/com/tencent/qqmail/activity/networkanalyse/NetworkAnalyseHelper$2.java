package com.tencent.qqmail.activity.networkanalyse;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqmail.utilities.log.NetworkAnalyseGeneralCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ICompleteCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

final class NetworkAnalyseHelper$2
  implements QMCallback.ICompleteCallback
{
  NetworkAnalyseHelper$2(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, NetworkAnalyseGeneralCallback paramNetworkAnalyseGeneralCallback, TextView paramTextView, ImageView paramImageView) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    StringBuilder localStringBuilder1 = this.val$sb;
    StringBuilder localStringBuilder2 = new StringBuilder().append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).append("\n").append("requesturl:").append("http://i.mail.qq.com").append("\n").append("response:");
    if (paramQMNetworkResponse == null)
    {
      paramQMNetworkRequest = "response is null";
      localStringBuilder2 = localStringBuilder2.append(paramQMNetworkRequest).append(paramQMNetworkResponse).append(". ");
      if (paramQMNetworkError != null) {
        break label239;
      }
    }
    label239:
    for (paramQMNetworkRequest = "error is null";; paramQMNetworkRequest = paramQMNetworkError.toString())
    {
      localStringBuilder1.append(paramQMNetworkRequest + "\n");
      SharedPreferenceUtil.setDebuglogSendRequestStatus("http");
      if ((paramQMNetworkError == null) && (paramQMNetworkResponse != null)) {
        this.val$okBuilder.append("ok");
      }
      if (SharedPreferenceUtil.isDebuglogSendRequestEnd())
      {
        SharedPreferenceUtil.clearDebuglogStatus();
        if (this.val$onEndCallback != null)
        {
          paramQMNetworkRequest = new ArrayList();
          paramQMNetworkRequest.add(this.val$sb.toString());
          if (!this.val$okBuilder.toString().contains("ok")) {
            break label247;
          }
          this.val$onEndCallback.onFinish(true, paramQMNetworkRequest, this.val$textView, this.val$imageView);
        }
      }
      return;
      paramQMNetworkRequest = "header:" + paramQMNetworkResponse.getResponseHeaders() + paramQMNetworkResponse;
      break;
    }
    label247:
    this.val$onEndCallback.onFinish(false, paramQMNetworkRequest, this.val$textView, this.val$imageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.networkanalyse.NetworkAnalyseHelper.2
 * JD-Core Version:    0.7.0.1
 */