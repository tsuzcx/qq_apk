package com.huawei.hms.aaid.b;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.a;
import com.huawei.hms.aaid.entity.DeleteTokenResp;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

public class b
  extends TaskApiCall<d, Void>
{
  public b(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, paramString3);
  }
  
  protected void doExecute(d paramd, ResponseErrorCode paramResponseErrorCode, String paramString, TaskCompletionSource<Void> paramTaskCompletionSource)
  {
    if (paramResponseErrorCode.getErrorCode() != 0)
    {
      HMSLog.e(HmsInstanceId.TAG, "DeleteTokenTask failed, ErrorCode: " + paramResponseErrorCode.getErrorCode());
      paramd = a.a(paramResponseErrorCode.getErrorCode());
      if (paramd != a.g)
      {
        paramTaskCompletionSource.setException(a.a(paramd));
        return;
      }
      paramTaskCompletionSource.setException(new ApiException(new Status(paramResponseErrorCode.getErrorCode(), paramResponseErrorCode.getErrorReason())));
      return;
    }
    paramString = a.a(((DeleteTokenResp)JsonUtil.jsonToEntity(paramString, new DeleteTokenResp())).getRetCode());
    if (paramString != a.a)
    {
      paramTaskCompletionSource.setException(a.a(paramString));
      return;
    }
    paramTaskCompletionSource.setResult(null);
    com.huawei.hms.aaid.c.b.a(paramd.getContext(), getUri(), paramResponseErrorCode);
  }
  
  public int getMinApkVersion()
  {
    return 30000000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.aaid.b.b
 * JD-Core Version:    0.7.0.1
 */