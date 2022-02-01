package com.tencent.android.tpush;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.common.ReturnCode;
import com.tencent.android.tpush.common.h;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;

final class XGPushManager$28
  implements Runnable
{
  XGPushManager$28(Context paramContext, XGIOperateCallback paramXGIOperateCallback, long paramLong, String paramString) {}
  
  public void run()
  {
    long l;
    String str3;
    label174:
    String str2;
    for (;;)
    {
      try
      {
        int i = i.a(this.a);
        if (i != 0)
        {
          if (this.b == null) {
            return;
          }
          this.b.onFail("", i, "XINGE SDK config error");
          return;
        }
        if (this.c <= 0L)
        {
          l = XGPushConfig.getAccessId(this.a);
          if (!i.b(this.d)) {
            break label174;
          }
          String str1 = XGPushConfig.getAccessKey(this.a);
          str3 = XGPushConfig.getToken(this.a);
          if (((l > 0L) && (!i.b(str1)) && (!i.b(str3))) || (this.b == null)) {
            break;
          }
          this.b.onFail("", ReturnCode.CODE_LOGIC_ILLEGAL_ARGUMENT.getType(), "The accessId, accessKey or token is invalid! accessId=" + l);
          throw new IllegalArgumentException("accessId, accessKey or token is invalid.");
        }
      }
      catch (Throwable localThrowable)
      {
        TLogger.ee("XGPushManager", "unregisterPush", localThrowable);
        return;
      }
      l = this.c;
      continue;
      str2 = this.d;
    }
    Intent localIntent = new Intent(this.a.getPackageName() + "com.tencent.android.xg.vip.action.UNREGISTER.V4");
    localIntent.putExtra("accId", Rijndael.encrypt("" + l));
    localIntent.putExtra("accKey", Rijndael.encrypt(str2));
    localIntent.putExtra("token", Rijndael.encrypt(str3));
    localIntent.putExtra("packName", Rijndael.encrypt(this.a.getPackageName()));
    localIntent.putExtra("operation", 101);
    localIntent.putExtra("opType", 1);
    boolean bool1 = h.a(this.a).b();
    boolean bool2 = b.a();
    if ((i.c(this.a) == 1) && (bool2))
    {
      XGPushManager.a(this.a, localIntent, this.b);
      return;
    }
    XGPushManager.a(this.a, localIntent, this.b, bool1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.28
 * JD-Core Version:    0.7.0.1
 */