package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.sdk.a.e.a;
import com.tencent.smtt.sdk.a.g;
import java.util.ArrayList;

class d$1
  implements e.a
{
  d$1(d paramd, Context paramContext) {}
  
  public void a(String paramString)
  {
    paramString = com.tencent.smtt.sdk.a.d.a(paramString);
    if ((paramString != null) && (paramString.a() == 0))
    {
      g.a().a(this.a, "emergence_req_interval", paramString.b());
      paramString = paramString.c();
      if (paramString != null)
      {
        d.a(this.b, this.a, d.b(), paramString);
        return;
      }
      d.a(this.b, this.a, d.c(), new ArrayList());
      return;
    }
    d.a(this.b, this.a, d.d(), new ArrayList());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.d.1
 * JD-Core Version:    0.7.0.1
 */