package com.tencent.token;

import btmsdkobf.bx;
import com.qq.taf.jce.JceStruct;
import com.tmsdk.TMSDKContext;
import com.tmsdk.base.ISharkCallBackOut;
import java.util.ArrayList;

public final class aad
{
  public static void a(final String paramString, final a parama)
  {
    l locall = new l();
    locall.a = new ArrayList();
    t localt = new t();
    localt.a = paramString;
    localt.h = 2110015L;
    locall.a.add(localt);
    bx.ar().getGuid();
    yn.a.a().a(new Runnable()
    {
      public final void run()
      {
        TMSDKContext.sendShark(2237, this.a, new o(), new ISharkCallBackOut()
        {
          public final void onFinish(int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, int paramAnonymous2Int4, JceStruct paramAnonymous2JceStruct)
          {
            if (paramAnonymous2Int3 != 0) {
              return;
            }
            if (!(paramAnonymous2JceStruct instanceof o)) {
              return;
            }
            paramAnonymous2JceStruct = (o)paramAnonymous2JceStruct;
            if (paramAnonymous2JceStruct.a != 0) {
              return;
            }
            paramAnonymous2JceStruct = paramAnonymous2JceStruct.b;
            if (paramAnonymous2JceStruct != null)
            {
              if (paramAnonymous2JceStruct.size() <= 0) {
                return;
              }
              if (aad.1.this.b != null)
              {
                aad.a locala = aad.1.this.b;
                r localr = (r)paramAnonymous2JceStruct.get(0);
                String str = aad.1.this.c;
                if (localr == null)
                {
                  paramAnonymous2JceStruct = null;
                }
                else
                {
                  paramAnonymous2JceStruct = localr;
                  if (str.equals("com.tencent.qqpimsecure"))
                  {
                    str = localr.r.toLowerCase();
                    if ((!str.endsWith("png")) && (!str.endsWith("jpg")))
                    {
                      paramAnonymous2JceStruct = localr;
                      if (!str.endsWith("jpeg")) {}
                    }
                    else
                    {
                      localr.r = "https://privacy.qq.com/document/priview/c4c2fc8a9e8c47d19577907a72e62f11";
                      paramAnonymous2JceStruct = localr;
                    }
                  }
                }
                locala.a(paramAnonymous2JceStruct);
              }
              return;
            }
          }
        });
      }
    }, "fetchSoftwareDetail");
  }
  
  public static abstract interface a
  {
    public abstract void a(r paramr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aad
 * JD-Core Version:    0.7.0.1
 */