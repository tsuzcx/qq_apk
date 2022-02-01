package com.tencent.token.core.protocolcenter;

import android.content.ContentValues;
import android.os.Handler;
import android.os.Looper;
import com.tencent.token.bz;
import com.tencent.token.cb;
import com.tencent.token.core.protocolcenter.protocol.ProtoModSeed;
import com.tencent.token.core.protocolcenter.protocol.ProtoQueryCaptcha;
import com.tencent.token.cq;
import com.tencent.token.dn;
import com.tencent.token.global.e;
import com.tmsdk.common.util.TmsLog;
import java.util.concurrent.Callable;

public class g
{
  static e a()
  {
    Object localObject = b.a("mbtoken3_query_captcha");
    dn localdn = new dn("mbtoken3_query_captcha", 2, new Handler(Looper.getMainLooper()), -1);
    ProtoQueryCaptcha.a(localdn, 0L, 3);
    localObject = ((d)localObject).c(localdn);
    if (!((e)localObject).b())
    {
      TmsLog.i("session_test", "@doRefreshSession CMD_QUERY_CAPTCHA err: " + ((e)localObject).a);
      return localObject;
    }
    TmsLog.i("session_test", "@doRefreshSession CMD_QUERY_CAPTCHA success.");
    return b.a("mbtoken3_activate_token").c(localdn);
  }
  
  public static e a(dn paramdn, String paramString)
  {
    boolean bool = true;
    com.tencent.token.global.g.c(paramString);
    if (paramdn.m == 1) {
      paramdn.m = 0;
    }
    for (;;)
    {
      TmsLog.i("session_test", "@doRefreshSession call exchangeKey.");
      e locale = b.a("mbtoken3_exchange_key_v3").c(paramdn);
      if (!locale.b()) {
        return locale;
      }
      if (ProtoModSeed.e()) {
        locale = a();
      }
      if (!locale.b())
      {
        TmsLog.i("session_test", "@doRefreshSession CMD_DO_ACTIVETOKEN err: " + locale.a);
        return locale;
      }
      if (cb.c().t())
      {
        TmsLog.i("session_test", "@doRefreshSession seed is expired, start mod_seed.");
        locale = b.a("mbtoken3_mod_seed").c(paramdn);
        if (!locale.b())
        {
          TmsLog.i("session_test", "@doRefreshSession mod_seed err: " + locale.a);
          return locale;
        }
        TmsLog.i("session_test", "@doRefreshSession mod_seed success.");
        return a(paramdn, paramString, bool);
      }
      TmsLog.i("session_test", "@doRefreshSession seed is valid.");
      return a(paramdn, paramString, bool);
      bool = false;
    }
  }
  
  static e a(dn paramdn, String paramString, boolean paramBoolean)
  {
    Object localObject = b.a("mbtoken3_get_uin_list_v2").c(paramdn);
    if (!((e)localObject).b()) {}
    do
    {
      e locale;
      do
      {
        return localObject;
        if (paramString == "mbtoken3_get_uin_list_v2") {
          return localObject;
        }
        if (paramString != "mbtoken3_face_reg_v2") {
          break;
        }
        com.tencent.token.global.g.a("CMD_FACERECOGNITION");
        long l = ((Long)paramdn.n.get("uin")).longValue();
        com.tencent.token.global.g.a("uinhash" + l);
        if (cq.a().c(l) != null) {
          break;
        }
        com.tencent.token.global.g.a("CMD_QRY_BIND_NOTIFY_MSG");
        localObject = b.a("mbtoken3_qry_bind_notify_msg");
        paramdn.e = true;
        locale = ((d)localObject).c(paramdn);
        paramdn.e = false;
        localObject = locale;
      } while (!locale.b());
      localObject = locale;
      if (locale.c != null)
      {
        localObject = locale;
        if (!locale.c.isEmpty())
        {
          locale.a(222, null, locale.c);
          return locale;
        }
      }
      paramString = b.a(paramString);
      if (paramString == null) {
        break;
      }
      if (paramBoolean)
      {
        paramdn.m = 1;
        paramdn.k = true;
      }
      paramdn = paramString.c(paramdn);
      localObject = paramdn;
    } while (!paramdn.b());
    bz.a().c();
    return paramdn;
    ((e)localObject).b(10000);
    return localObject;
  }
  
  public static Callable<e> a(dn paramdn)
  {
    new Callable()
    {
      public e a()
      {
        e locale = g.b(this.a, this.a.a);
        this.a.l.a(this.a, locale);
        return locale;
      }
    };
  }
  
  public static e b(dn paramdn, String paramString)
  {
    e locale = new e();
    try
    {
      if (bz.a().b() == null)
      {
        paramdn = a(paramdn, paramString);
        return paramdn;
      }
      d locald = b.a(paramString);
      if (locald != null)
      {
        locale = locald.c(paramdn);
        if (!locale.b()) {
          break label82;
        }
        bz.a().c();
        return locale;
      }
    }
    finally {}
    locale.b(10000);
    return locale;
    label82:
    if (locale.a == 104)
    {
      paramdn = a(paramdn, paramString);
      return paramdn;
    }
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.g
 * JD-Core Version:    0.7.0.1
 */