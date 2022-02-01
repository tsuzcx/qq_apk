package com.tencent.tbs.one.impl.e.d;

import android.content.Context;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.d.a.a;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.impl.e.e.a;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public final class b
  extends com.tencent.tbs.one.impl.a.a<e<d>>
  implements a.a
{
  com.tencent.tbs.one.impl.d.a b;
  int c;
  private Context d;
  private String e;
  private String f;
  private File g;
  
  public b(Context paramContext, String paramString1, String paramString2, File paramFile)
  {
    this.d = paramContext;
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramFile;
  }
  
  public final void a()
  {
    this.b = new com.tencent.tbs.one.impl.d.a(this.d, this.f);
    this.b.f = this;
    this.b.a(new b.1(this));
  }
  
  public final void a(int paramInt, Map<String, List<String>> paramMap, InputStream paramInputStream)
  {
    Context localContext = this.d;
    String str1 = this.f;
    String str2 = this.e;
    File localFile = this.g;
    f.a("[%s] Receiving DEPS response: [%d] %s", new Object[] { str2, Integer.valueOf(paramInt), paramMap });
    if ((paramInt != 200) || (paramInputStream == null))
    {
      a(210, "Invalid DEPS response stream, url: " + str1 + ", statusCode: " + paramInt, null);
      return;
    }
    paramMap = com.tencent.tbs.one.impl.common.a.a(localContext, str2);
    if (paramMap != null)
    {
      paramInt = paramMap.shouldInterceptDEPSResponse(str2, null, paramInputStream, localFile, new b.2(this, str2, localFile));
      if (paramInt != 0)
      {
        f.a("[%s] Intercepted DEPS download stream by runtime extension", new Object[] { str2 });
        this.c = paramInt;
        return;
      }
    }
    try
    {
      paramMap = d.a(c.a(paramInputStream, "utf-8", localFile));
      a(e.a(e.a.d, paramMap));
      return;
    }
    catch (IOException paramMap)
    {
      a(305, "Failed to download online DEPS from " + str1 + " to " + localFile.getAbsolutePath(), paramMap);
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
    if (this.b != null) {
      this.b.b();
    }
    if (this.c != 0)
    {
      TBSOneRuntimeExtension localTBSOneRuntimeExtension = com.tencent.tbs.one.impl.common.a.a(this.d, this.e);
      if (localTBSOneRuntimeExtension != null) {
        localTBSOneRuntimeExtension.cancel(this.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.d.b
 * JD-Core Version:    0.7.0.1
 */