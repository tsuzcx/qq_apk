package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.d;
import com.tencent.token.global.e;

public class bw
{
  public static d a(fs paramfs, String paramString)
  {
    int i = 0;
    Object localObject = null;
    d locald = new d((byte)0);
    try
    {
      ae.a();
      if (ax.a().p())
      {
        ax.a();
        localObject = ax.c;
      }
      if (localObject == null)
      {
        paramfs = b(paramfs, paramString);
        return paramfs;
      }
      localObject = bi.a(paramString);
      if (localObject != null)
      {
        localObject = ((bm)localObject).c(paramfs);
        if (((d)localObject).a == 0) {
          i = 1;
        }
        if (i == 0) {
          break label118;
        }
        ae.a();
        ax.a().m();
        return localObject;
      }
    }
    finally {}
    locald.a(10000, null, null);
    return locald;
    label118:
    if (((d)localObject).a == 104)
    {
      paramfs = b(paramfs, paramString);
      return paramfs;
    }
    return localObject;
  }
  
  private static d b(fs paramfs, String paramString)
  {
    int m = 1;
    int k = 1;
    new d((byte)0);
    e.c(paramString);
    if (paramfs.m == 1) {
      paramfs.m = 0;
    }
    for (int i = 1;; i = 0)
    {
      d locald = bi.a("mbtoken3_exchange_key_v3").c(paramfs);
      if (locald.a == 0) {}
      for (int j = 1; j == 0; j = 0)
      {
        paramfs = locald;
        return paramfs;
      }
      locald = bi.a("mbtoken3_get_uin_list_v2").c(paramfs);
      if (locald.a == 0) {}
      for (j = 1; j == 0; j = 0) {
        return locald;
      }
      if (paramString == "mbtoken3_get_uin_list_v2") {
        return locald;
      }
      long l = ((Long)paramfs.n.get("uin")).longValue();
      if (ax.a().c(l) == null)
      {
        paramString = bi.a("mbtoken3_qry_bind_notify_msg");
        paramfs.e = true;
        paramString = paramString.c(paramfs);
        paramfs.e = false;
        if (paramString.a == 0) {}
        for (i = k;; i = 0)
        {
          paramfs = paramString;
          if (i == 0) {
            break;
          }
          if ((paramString.c == null) || (paramString.c.isEmpty())) {
            break label213;
          }
          paramString.a(222, null, paramString.c);
          return paramString;
        }
        label213:
        paramString.a(222, null, RqdApplication.i().getString(2131362822));
        return paramString;
      }
      paramString = bi.a(paramString);
      if (paramString != null)
      {
        if (i != 0)
        {
          paramfs.m = 1;
          paramfs.k = true;
        }
        paramString = paramString.c(paramfs);
        if (paramString.a != 0) {
          break label301;
        }
      }
      label301:
      for (i = m;; i = 0)
      {
        paramfs = paramString;
        if (i == 0) {
          break;
        }
        ae.a();
        ax.a().m();
        return paramString;
        locald.a(10000, null, null);
        return locald;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bw
 * JD-Core Version:    0.7.0.1
 */