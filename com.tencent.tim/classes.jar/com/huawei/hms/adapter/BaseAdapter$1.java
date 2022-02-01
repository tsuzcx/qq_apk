package com.huawei.hms.adapter;

import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.adapter.a.c;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

class BaseAdapter$1
  implements c
{
  BaseAdapter$1(BaseAdapter paramBaseAdapter) {}
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(Intent paramIntent, String paramString)
  {
    long l2 = 0L;
    boolean bool = false;
    if (TextUtils.isEmpty(paramString))
    {
      HMSLog.e("BaseAdapter", "onSolutionResult but id is null");
      paramIntent = BaseAdapter.a(this.a);
      if (paramIntent == null)
      {
        HMSLog.e("BaseAdapter", "onSolutionResult baseCallBack null");
        BaseAdapter.b(this.a);
        bool = true;
      }
    }
    while (!paramString.equals(BaseAdapter.f(this.a)))
    {
      return bool;
      paramIntent.onError(BaseAdapter.a(this.a, -6));
      BaseAdapter.b(this.a);
      return true;
    }
    HMSLog.i("BaseAdapter", "onSolutionResult + id is :" + paramString);
    paramString = BaseAdapter.a(this.a);
    if (paramString == null)
    {
      HMSLog.e("BaseAdapter", "onResult baseCallBack null");
      BaseAdapter.b(this.a);
      return true;
    }
    if (paramIntent == null)
    {
      HMSLog.e("BaseAdapter", "onSolutionResult but data is null");
      paramIntent = BaseAdapter.a(this.a, -7);
      BaseAdapter.a(this.a, BaseAdapter.d(this.a), BaseAdapter.c(this.a), 0L);
      paramString.onError(paramIntent);
      BaseAdapter.b(this.a);
      return true;
    }
    if (paramIntent.getIntExtra("kit_update_result", 0) == 1)
    {
      HMSLog.e("BaseAdapter", "kit update success,replay request");
      BaseAdapter.g(this.a);
      return true;
    }
    HMSLog.e("BaseAdapter", "onComplete for on activity result");
    String str1 = paramIntent.getStringExtra("json_header");
    String str2 = paramIntent.getStringExtra("json_body");
    Object localObject1 = JsonUtil.getInfoFromJsonobject(str1, "status_code");
    Object localObject2 = JsonUtil.getInfoFromJsonobject(str1, "error_code");
    long l1 = l2;
    if (paramIntent.hasExtra("HMS_FOREGROUND_RES_UI"))
    {
      paramIntent = JsonUtil.getInfoFromJsonobject(paramIntent.getStringExtra("HMS_FOREGROUND_RES_UI"), "uiDuration");
      l1 = l2;
      if (paramIntent != null)
      {
        l1 = l2;
        if ((paramIntent instanceof Long)) {
          l1 = ((Long)paramIntent).longValue();
        }
      }
    }
    if ((localObject1 != null) && ((localObject1 instanceof Integer)) && (localObject2 != null) && ((localObject2 instanceof Integer)))
    {
      int i = ((Integer)localObject1).intValue();
      int j = ((Integer)localObject2).intValue();
      BaseAdapter.a(this.a, j);
      BaseAdapter.c(this.a).setStatusCode(i);
      BaseAdapter.a(this.a, BaseAdapter.d(this.a), BaseAdapter.c(this.a), l1);
    }
    for (;;)
    {
      paramString.onComplete(str1, str2, null);
      return true;
      BaseAdapter.a(this.a, -8);
      BaseAdapter.a(this.a, BaseAdapter.d(this.a), BaseAdapter.c(this.a), l1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.adapter.BaseAdapter.1
 * JD-Core Version:    0.7.0.1
 */