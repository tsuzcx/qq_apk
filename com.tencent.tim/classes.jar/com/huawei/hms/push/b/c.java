package com.huawei.hms.push.b;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.push.c.d;
import com.huawei.hms.push.c.e;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;

public class c
  extends TaskApiCall<e, a>
{
  private String a;
  private String b;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super(paramString1, paramString2, paramString3);
    this.a = paramString4;
    this.b = paramString5;
  }
  
  private void a(e parame, ResponseErrorCode paramResponseErrorCode)
  {
    HMSLog.i("SendUpStreamTask", "receive upstream, msgId :" + this.b + " , packageName = " + this.a + " , errorCode = " + paramResponseErrorCode.getErrorCode());
    Intent localIntent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
    localIntent.setPackage(this.a);
    Bundle localBundle = new Bundle();
    localBundle.putString("message_id", this.b);
    localBundle.putInt("error", paramResponseErrorCode.getErrorCode());
    if (com.huawei.hms.push.a.a.a.a() == paramResponseErrorCode.getErrorCode()) {
      localBundle.putString("message_type", "sent_message");
    }
    while (new com.huawei.hms.support.api.push.a.a().a(parame.getContext(), localBundle, localIntent))
    {
      HMSLog.i("SendUpStreamTask", "receive upstream, start service success");
      d.a(parame.getContext(), getUri(), paramResponseErrorCode);
      return;
      localBundle.putString("message_type", "send_error");
    }
    HMSLog.w("SendUpStreamTask", "receive upstream, start service failed");
    d.a(parame.getContext(), getUri(), paramResponseErrorCode.getTransactionId(), com.huawei.hms.push.a.a.ag);
  }
  
  protected void doExecute(e parame, ResponseErrorCode paramResponseErrorCode, String paramString, TaskCompletionSource<a> paramTaskCompletionSource)
  {
    if (paramResponseErrorCode.getErrorCode() == 0)
    {
      HMSLog.i("SendUpStreamTask", "send up stream task,Operate succeed");
      paramTaskCompletionSource.setResult(null);
    }
    for (;;)
    {
      a(parame, paramResponseErrorCode);
      return;
      HMSLog.e("SendUpStreamTask", "send up stream task,Operate failed with ret=" + paramResponseErrorCode.getErrorCode());
      paramString = com.huawei.hms.push.a.a.a(paramResponseErrorCode.getErrorCode());
      if (paramString != com.huawei.hms.push.a.a.g) {
        paramTaskCompletionSource.setException(com.huawei.hms.push.a.a.a(paramString));
      } else {
        paramTaskCompletionSource.setException(new ApiException(new Status(paramResponseErrorCode.getErrorCode(), paramResponseErrorCode.getErrorReason())));
      }
    }
  }
  
  public int getMinApkVersion()
  {
    return 40003000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.push.b.c
 * JD-Core Version:    0.7.0.1
 */