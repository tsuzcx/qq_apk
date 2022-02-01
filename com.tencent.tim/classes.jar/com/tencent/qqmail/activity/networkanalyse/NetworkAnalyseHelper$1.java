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

final class NetworkAnalyseHelper$1
  implements QMCallback.ICompleteCallback
{
  NetworkAnalyseHelper$1(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, NetworkAnalyseGeneralCallback paramNetworkAnalyseGeneralCallback, TextView paramTextView, ImageView paramImageView) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    StringBuilder localStringBuilder1 = this.val$sb;
    StringBuilder localStringBuilder2 = new StringBuilder().append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).append("\n").append("requesturl:").append("https://i.mail.qq.com").append("\n").append("response:");
    if (paramQMNetworkResponse == null)
    {
      paramQMNetworkRequest = "response is null";
      paramQMNetworkResponse = localStringBuilder2.append(paramQMNetworkRequest).append(". ");
      if (paramQMNetworkError != null) {
        break label243;
      }
    }
    label243:
    for (paramQMNetworkRequest = "error is null";; paramQMNetworkRequest = paramQMNetworkError.toString())
    {
      localStringBuilder1.append(paramQMNetworkRequest + "\n");
      SharedPreferenceUtil.setDebuglogSendRequestStatus("https");
      if (((paramQMNetworkError != null) && (paramQMNetworkError.code == 302)) || (paramQMNetworkError == null)) {
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
            break label251;
          }
          this.val$onEndCallback.onFinish(true, paramQMNetworkRequest, this.val$textView, this.val$imageView);
        }
      }
      return;
      paramQMNetworkRequest = "header:" + paramQMNetworkResponse.getResponseHeaders() + paramQMNetworkResponse;
      break;
    }
    label251:
    this.val$onEndCallback.onFinish(false, paramQMNetworkRequest, this.val$textView, this.val$imageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.networkanalyse.NetworkAnalyseHelper.1
 * JD-Core Version:    0.7.0.1
 */