package com.tencent.android.tpush;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.common.AppInfos;
import com.tencent.android.tpush.common.ReturnCode;
import com.tencent.android.tpush.common.f;
import com.tencent.android.tpush.common.h;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.android.tpush.service.util.g;
import com.tencent.android.tpush.stat.ServiceStat;

final class XGPushManager$17
  implements Runnable
{
  XGPushManager$17(Context paramContext, XGIOperateCallback paramXGIOperateCallback, long paramLong, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void run()
  {
    int k;
    long l1;
    label153:
    String str2;
    for (;;)
    {
      try
      {
        k = i.a(this.a);
        if (k != 0)
        {
          if (this.b == null) {
            return;
          }
          this.b.onFail("", k, ReturnCode.errCodeToMsg(k));
          return;
        }
        if (this.c > 0L)
        {
          l1 = this.c;
          if (!i.b(this.d)) {
            break label153;
          }
          String str1 = XGPushConfig.getAccessKey(this.a);
          if ((l1 > 0L) && (!i.b(str1))) {
            break;
          }
          this.b.onFail("", ReturnCode.CODE_LOGIC_ILLEGAL_ARGUMENT.getType(), "The accessId or accessKey is(are) invalid!@accessId:" + l1 + ", @accessKey:" + str1);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        TLogger.e("XGPushManager", "register", localThrowable);
        return;
      }
      l1 = XGPushConfig.getAccessId(this.a);
      continue;
      str2 = this.d;
    }
    TLogger.ii("XGPushManager", "start other push channel register !");
    String str3 = XGPushManager.b(this.a);
    Object localObject = str3;
    if (str3 == null)
    {
      localObject = str3;
      if (XGPushConfig.isUsedOtherPush(this.a))
      {
        localObject = str3;
        if (!XGPushConfig.isNotTryFcm(this.a))
        {
          d.a(null, null);
          TLogger.i("XGPushManager", "tryAgain other channel !");
          localObject = XGPushManager.b(this.a);
        }
      }
    }
    if ((g.a((String)localObject)) && (XGPushConfig.isUsedOtherPush(this.a))) {
      ServiceStat.reportTokenFailed(this.a);
    }
    localObject = new Intent(this.a.getPackageName() + "com.tencent.android.xg.vip.action.REGISTER.V4");
    ((Intent)localObject).putExtra("accId", Rijndael.encrypt("" + l1));
    ((Intent)localObject).putExtra("accChannel", XGPushConfig.getChannelId(this.a));
    ((Intent)localObject).putExtra("accKey", Rijndael.encrypt(str2));
    if (this.e >> 4 != 1)
    {
      ((Intent)localObject).putExtra("appVer", AppInfos.getCurAppVersion(this.a));
      ((Intent)localObject).putExtra("packName", Rijndael.encrypt(this.a.getPackageName()));
      if (f.a(this.a) != null) {
        ((Intent)localObject).putExtra("reserved", Rijndael.encrypt(f.a(this.a).a()));
      }
      if (this.f != null) {
        ((Intent)localObject).putExtra("ticket", Rijndael.encrypt(this.f));
      }
      if (this.g != null) {
        ((Intent)localObject).putExtra("qua", Rijndael.encrypt(this.g));
      }
      ((Intent)localObject).putExtra("operation", 100);
      ((Intent)localObject).putExtra("aidl", i.b(this.a));
    }
    if ((XGPushConfig.isUsedOtherPush(this.a)) && (d.a(this.a).j()))
    {
      str2 = d.a(this.a).i();
      str3 = d.a(this.a).f();
      TLogger.ii("XGPushManager", "other push token is : " + str3 + "  other push type: " + str2);
      if ((!i.b(str2)) && (!i.b(str3)))
      {
        ((Intent)localObject).putExtra("channelToken", str3);
        ((Intent)localObject).putExtra("channelType", str2);
      }
    }
    ((Intent)localObject).putExtra("ticketType", this.e);
    ((Intent)localObject).putExtra("currentTimeMillis", System.currentTimeMillis());
    ((Intent)localObject).putExtra("opType", 0);
    if (!i.b(this.h)) {
      ((Intent)localObject).putExtra("url", this.h);
    }
    for (long l2 = 4L;; l2 = 0L)
    {
      if (!i.b(this.i))
      {
        ((Intent)localObject).putExtra("otherToken", this.i);
        if (!SharePrefsUtil.getString(this.a, this.i, "").equals(CacheManager.getToken(this.a))) {
          l1 = 2L;
        }
      }
      boolean bool1;
      for (;;)
      {
        if (!i.b(this.j)) {
          ((Intent)localObject).putExtra("payload", this.j);
        }
        ((Intent)localObject).putExtra("otherPushTokenOpType", l1);
        ((Intent)localObject).putExtra("otherPushType", l2);
        TLogger.d("XGPushManager", "url = " + this.h + " payload = " + this.j + " otherPushType " + l2 + " otherPushTokenOpType " + l1);
        bool1 = h.a(this.a).a();
        k = i.c(this.a);
        boolean bool2 = b.a();
        TLogger.d("XGPushManager", "serviceStatus:" + k + ", isHasBinded: " + bool2);
        if ((k != 1) || (!bool2)) {
          break;
        }
        TLogger.d("XGPushManager", "send boardcast to register");
        XGPushManager.b(this.a, (Intent)localObject, this.b);
        return;
        l1 = 3L;
        continue;
        l1 = 1L;
      }
      TLogger.d("XGPushManager", "startServiceAndRegisterOrUnregister:");
      XGPushManager.a(this.a, (Intent)localObject, this.b, bool1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.17
 * JD-Core Version:    0.7.0.1
 */