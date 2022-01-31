package com.tencent.token.core.protocolcenter;

import android.content.ContentValues;
import com.tencent.token.cv;
import com.tencent.token.do;
import com.tencent.token.ev;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import java.util.concurrent.Callable;

public class o
{
  public static f a(ev paramev, String paramString)
  {
    h.c(paramString);
    if (paramev.m == 1) {
      paramev.m = 0;
    }
    for (int i = 1;; i = 0)
    {
      Object localObject = b.a("mbtoken3_exchange_key_v3").c(paramev);
      if (!((f)localObject).b()) {}
      do
      {
        f localf;
        do
        {
          return localObject;
          localObject = b.a("mbtoken3_get_uin_list_v2").c(paramev);
          if (!((f)localObject).b()) {
            return localObject;
          }
          if (paramString == "mbtoken3_get_uin_list_v2") {
            return localObject;
          }
          if (paramString != "mbtoken3_face_reg_v2") {
            break;
          }
          h.a("CMD_FACERECOGNITION");
          long l = ((Long)paramev.n.get("uin")).longValue();
          h.a("uinhash" + l);
          if (do.a().c(l) != null) {
            break;
          }
          h.a("CMD_QRY_BIND_NOTIFY_MSG");
          localObject = b.a("mbtoken3_qry_bind_notify_msg");
          paramev.e = true;
          localf = ((e)localObject).c(paramev);
          paramev.e = false;
          localObject = localf;
        } while (!localf.b());
        localObject = localf;
        if (localf.c != null)
        {
          localObject = localf;
          if (!localf.c.isEmpty())
          {
            localf.a(222, null, localf.c);
            return localf;
          }
        }
        paramString = b.a(paramString);
        if (paramString == null) {
          break;
        }
        if (i != 0)
        {
          paramev.m = 1;
          paramev.k = true;
        }
        paramev = paramString.c(paramev);
        localObject = paramev;
      } while (!paramev.b());
      cv.a().c();
      return paramev;
      ((f)localObject).b(10000);
      return localObject;
    }
  }
  
  public static Callable a(ev paramev)
  {
    return new p(paramev);
  }
  
  public static f b(ev paramev, String paramString)
  {
    f localf = new f();
    try
    {
      if (cv.a().b() == null)
      {
        paramev = a(paramev, paramString);
        return paramev;
      }
      e locale = b.a(paramString);
      if (locale != null)
      {
        localf = locale.c(paramev);
        if (!localf.b()) {
          break label82;
        }
        cv.a().c();
        return localf;
      }
    }
    finally {}
    localf.b(10000);
    return localf;
    label82:
    if (localf.a == 104)
    {
      paramev = a(paramev, paramString);
      return paramev;
    }
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.o
 * JD-Core Version:    0.7.0.1
 */