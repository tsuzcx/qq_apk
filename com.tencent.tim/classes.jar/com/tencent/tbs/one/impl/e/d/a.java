package com.tencent.tbs.one.impl.e.d;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.common.d.a;
import com.tencent.tbs.one.impl.d.a.a;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.impl.e.e.a;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public final class a
  extends com.tencent.tbs.one.impl.a.a<e<File>>
  implements a.a
{
  int b;
  private Context c;
  private String d;
  private d.a e;
  private File f;
  private File g;
  private com.tencent.tbs.one.impl.d.a h;
  private long i = -1L;
  private Bundle j;
  
  public a(Context paramContext, String paramString, d.a parama, File paramFile, Bundle paramBundle)
  {
    this.c = paramContext;
    this.d = paramString;
    this.e = parama;
    this.f = paramFile;
    this.j = paramBundle;
    this.g = com.tencent.tbs.one.impl.common.f.a(this.c, this.c, paramString, parama.a, parama.c);
  }
  
  public final void a()
  {
    String str = this.e.d;
    this.h = new com.tencent.tbs.one.impl.d.a(this.c, str);
    this.h.f = this;
    this.h.a(new a.1(this));
  }
  
  public final void a(int paramInt, Map<String, List<String>> paramMap, InputStream paramInputStream)
  {
    Context localContext = this.c;
    String str1 = this.d;
    String str2 = this.e.a;
    int k = this.e.c;
    String str3 = this.e.d;
    File localFile2 = this.f;
    if ((this.g != null) && (!this.g.exists())) {
      this.g.mkdirs();
    }
    if (this.g == null) {}
    for (File localFile1 = null;; localFile1 = new File(this.g, this.e.a + ".tbs"))
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Receiving component response: [%d] %s", new Object[] { str1, str2, Integer.valueOf(paramInt), paramMap });
      if ((paramInt == 200) && (paramInputStream != null)) {
        break;
      }
      a(215, "Invalid component response stream, url: " + str3 + ", statusCode: " + paramInt, null);
      return;
    }
    paramMap = (List)paramMap.get("Content-Length");
    if ((paramMap != null) && (paramMap.size() > 0)) {}
    for (;;)
    {
      try
      {
        this.i = Long.parseLong((String)paramMap.get(0));
        paramMap = com.tencent.tbs.one.impl.common.a.a(localContext, str1);
        if (paramMap == null) {
          break;
        }
        paramInt = paramMap.shouldInterceptComponentResponse(str1, str2, k, null, paramInputStream, localFile2, new a.2(this, str1, str2, localFile2));
        if (paramInt == 0) {
          break;
        }
        com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Intercepted component download stream by runtime extension", new Object[] { str1, str2 });
        this.b = paramInt;
        return;
      }
      catch (Exception localException)
      {
        com.tencent.tbs.one.impl.a.f.c("Failed to parse Content-Length header %s, url: %s", new Object[] { paramMap, str3, localException });
        continue;
      }
      com.tencent.tbs.one.impl.a.f.a("No Content-Length header exists, url: %s", new Object[] { str3 });
    }
    paramMap = this.e.e;
    long l = this.i;
    try
    {
      com.tencent.tbs.one.impl.e.f.a(paramInputStream, paramMap, l, localFile2, localFile1, new a.3(this));
      com.tencent.tbs.one.impl.e.f.a(localFile2, localFile2);
      com.tencent.tbs.one.impl.e.f.a(localFile2, k);
      com.tencent.tbs.one.impl.e.f.a(this.c.getDir("tbs", 0));
      com.tencent.tbs.one.impl.e.f.b(localFile2);
      a(e.a(e.a.d, localFile2));
      return;
    }
    catch (TBSOneException paramMap)
    {
      a(paramMap.getErrorCode(), paramMap.getMessage(), paramMap.getCause());
    }
  }
  
  public final void b()
  {
    super.b();
    if (this.h != null) {
      this.h.b();
    }
    if (this.b != 0)
    {
      TBSOneRuntimeExtension localTBSOneRuntimeExtension = com.tencent.tbs.one.impl.common.a.a(this.c, this.d);
      if (localTBSOneRuntimeExtension != null) {
        localTBSOneRuntimeExtension.cancel(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.d.a
 * JD-Core Version:    0.7.0.1
 */