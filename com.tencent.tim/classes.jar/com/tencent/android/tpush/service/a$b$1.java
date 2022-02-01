package com.tencent.android.tpush.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger.WriteFileCallback;

class a$b$1
  implements TBaseLogger.WriteFileCallback
{
  a$b$1(a.b paramb) {}
  
  public void onFinished()
  {
    TLogger.ii("PushServiceBroadcastHandler", "xg process log flush finished");
    Object localObject = Rijndael.decrypt(a.b.a(this.a).getStringExtra("packName"));
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(a.b.b(this.a).getPackageName())))
    {
      localObject = new Intent("com.tencent.android.xg.vip.action.FLUSH.RESULT.V4");
      BroadcastAgent.sendBroadcast(b.e(), (Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.a.b.1
 * JD-Core Version:    0.7.0.1
 */