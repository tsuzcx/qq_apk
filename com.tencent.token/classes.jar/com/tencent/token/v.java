package com.tencent.token;

import android.text.TextUtils;
import com.tencent.halley.common.j;
import com.tencent.halley.downloader.a;
import com.tencent.halley.downloader.c;
import com.tencent.halley.downloader.c.d.a.a;
import com.tencent.halley.downloader.exceptions.DownloaderAddTaskException;
import java.util.Iterator;
import java.util.List;

public final class v
  implements a
{
  private static com.tencent.halley.downloader.b a(int paramInt, String paramString1, boolean paramBoolean1, String paramString2, List paramList1, String paramString3, List paramList2, String paramString4, String paramString5, c paramc, boolean paramBoolean2, long paramLong)
  {
    String str = "";
    if (TextUtils.isEmpty(paramString2))
    {
      str = "url is empty.";
      if (!j.a(paramString4)) {
        break label203;
      }
      paramString4 = h.g();
    }
    label203:
    for (;;)
    {
      if (!"".equals(str))
      {
        throw new DownloaderAddTaskException(str);
        if (paramc != null) {
          break;
        }
        str = "listener is null.";
        break;
      }
      paramString2 = new com.tencent.halley.downloader.c.d.b(paramString2, paramBoolean1);
      if (paramBoolean1)
      {
        paramString2.b(paramString3);
        if (paramList1 != null)
        {
          paramList1 = paramList1.iterator();
          while (paramList1.hasNext())
          {
            paramString3 = (String)paramList1.next();
            paramString2.a(o.a, paramString3, a.a.c);
          }
        }
        if (paramList2 != null)
        {
          paramList1 = paramList2.iterator();
          while (paramList1.hasNext())
          {
            paramString3 = (String)paramList1.next();
            paramString2.a(o.a, paramString3, a.a.h);
          }
        }
      }
      return new com.tencent.halley.downloader.c.h(paramInt, paramString1, paramString2, paramString4, paramString5, paramc, paramBoolean2, paramLong);
    }
  }
  
  public final com.tencent.halley.downloader.b a(int paramInt, String paramString1, String paramString2, List paramList1, String paramString3, List paramList2, String paramString4, String paramString5, c paramc, boolean paramBoolean, long paramLong)
  {
    return a(paramInt, paramString1, true, paramString2, paramList1, paramString3, paramList2, paramString4, paramString5, paramc, paramBoolean, paramLong);
  }
  
  public final void a(com.tencent.halley.downloader.b paramb)
  {
    y.a().n(paramb);
  }
  
  public final void a(com.tencent.halley.downloader.b paramb, boolean paramBoolean)
  {
    y.a().a(paramb, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.v
 * JD-Core Version:    0.7.0.1
 */