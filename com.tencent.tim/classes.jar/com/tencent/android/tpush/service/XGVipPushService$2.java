package com.tencent.android.tpush.service;

import android.content.Context;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;

class XGVipPushService$2
  implements Runnable
{
  XGVipPushService$2(XGVipPushService paramXGVipPushService, Context paramContext) {}
  
  public void run()
  {
    TpnsSecurity.getEncryptAPKSignature(this.a);
    c.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.XGVipPushService.2
 * JD-Core Version:    0.7.0.1
 */