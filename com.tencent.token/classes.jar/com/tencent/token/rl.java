package com.tencent.token;

import com.tencent.halley.downloader.DownloaderTaskStatus;
import java.util.ArrayList;
import java.util.List;

public final class rl
{
  protected static boolean a = true;
  protected List<String> b = new ArrayList();
  rb.a c;
  
  rl(String paramString)
  {
    this.b.add(paramString);
  }
  
  public final rb.a a()
  {
    if (this.c == null)
    {
      Object localObject1 = rp.a();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((rp)localObject1).c.d());
      ((StringBuilder)localObject2).append(".");
      ((StringBuilder)localObject2).append(((rp)localObject1).c.e());
      ((StringBuilder)localObject2).append(".");
      ((StringBuilder)localObject2).append(((rp)localObject1).c.f());
      String str = ((StringBuilder)localObject2).toString();
      int i = -((rp)localObject1).c.g();
      localObject2 = ((rp)localObject1).c.a;
      boolean bool = false;
      if (((rm)localObject2).a("meri_update_url_type", 0) == 0) {
        bool = ((rp)localObject1).e();
      }
      localObject2 = null;
      if (bool) {
        localObject1 = ((rp)localObject1).c.a.a("meri_lastest_url", "");
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        localObject2 = new StringBuilder("com.tencent.token_");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(str);
        str = ((StringBuilder)localObject2).toString();
        localObject2 = rb.b.a().a((String)localObject1);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
        }
        else
        {
          localObject2 = new rb.a();
          ((rb.a)localObject2).a = "com.tencent.token";
          ((rb.a)localObject2).c = ((String)localObject1);
          ((rb.a)localObject2).d = str;
          localObject1 = localObject2;
        }
        localObject2 = localObject1;
        if (rb.b.a().a((rb.a)localObject1))
        {
          ((rb.a)localObject1).f = DownloaderTaskStatus.COMPLETE;
          localObject2 = localObject1;
        }
      }
      this.c = ((rb.a)localObject2);
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.rl
 * JD-Core Version:    0.7.0.1
 */