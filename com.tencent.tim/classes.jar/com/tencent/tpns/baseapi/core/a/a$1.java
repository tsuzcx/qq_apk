package com.tencent.tpns.baseapi.core.a;

import android.content.Context;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.base.util.NetworkUtil;
import com.tencent.tpns.baseapi.base.util.StatHelper;
import com.tencent.tpns.baseapi.core.net.HttpRequestCallback;

final class a$1
  implements HttpRequestCallback
{
  a$1(Context paramContext, long paramLong) {}
  
  public void onFailure(int paramInt, String paramString)
  {
    if (a.a()) {}
    do
    {
      return;
      CloudManager.getInstance(this.a).clearGuid();
      if (!NetworkUtil.isNetworkConnected(this.a)) {
        break;
      }
      if (!a.b())
      {
        StatHelper.reportErrCode(this.a, paramInt, paramString, this.b, "");
        a.a(true);
        return;
      }
    } while (paramInt == -506);
    StatHelper.reportErrCode(this.a, paramInt, paramString, this.b, "");
    a.a(true);
    return;
    Logger.w("GuidInfoManagerImpl", "GUID HttpRequest Throw Error: network unavailable");
  }
  
  public void onSuccess(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.core.a.a.1
 * JD-Core Version:    0.7.0.1
 */