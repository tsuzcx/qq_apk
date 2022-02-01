package com.huawei.hms.push.c;

import android.content.Context;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.push.a.a;
import com.huawei.hms.support.api.push.c.a.a.c;
import com.huawei.hms.support.log.HMSLog;

public class g
{
  public static a a(Context paramContext)
  {
    if (!b(paramContext))
    {
      if (AutoInitHelper.isAutoInitEnabled(paramContext))
      {
        HMSLog.e("TokenUtil", "Token not exist, try auto init");
        AutoInitHelper.doAutoInit(paramContext);
        return a.ai;
      }
      HMSLog.e("TokenUtil", "Token not exist");
      return a.b;
    }
    return a.a;
  }
  
  private static boolean b(Context paramContext)
  {
    return new c(paramContext, "push_client_self_info").b("token_info_v2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.push.c.g
 * JD-Core Version:    0.7.0.1
 */