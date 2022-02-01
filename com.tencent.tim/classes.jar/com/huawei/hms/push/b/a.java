package com.huawei.hms.push.b;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.push.c.d;
import com.huawei.hms.push.c.e;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;

public class a
  extends TaskApiCall<e, Void>
{
  public a(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, paramString3);
  }
  
  protected void doExecute(e parame, ResponseErrorCode paramResponseErrorCode, String paramString, TaskCompletionSource<Void> paramTaskCompletionSource)
  {
    if (paramResponseErrorCode.getErrorCode() == 0)
    {
      HMSLog.i("BaseVoidTask", "Operate succeed");
      paramTaskCompletionSource.setResult(null);
    }
    for (;;)
    {
      d.a(parame.getContext(), getUri(), paramResponseErrorCode);
      return;
      HMSLog.e("BaseVoidTask", "Operate failed with ret=" + paramResponseErrorCode.getErrorCode());
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
    return 30000000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.push.b.a
 * JD-Core Version:    0.7.0.1
 */