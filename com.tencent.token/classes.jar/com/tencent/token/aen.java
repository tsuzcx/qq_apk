package com.tencent.token;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public final class aen
  extends Thread
{
  public aen(Context paramContext) {}
  
  public final void run()
  {
    Context localContext = this.a;
    Object localObject2 = aef.a;
    try
    {
      l = Long.valueOf(aef.a(localContext, "801")).longValue();
    }
    finally
    {
      long l;
      label26:
      StringBuilder localStringBuilder;
      break label26;
    }
    l = 0L;
    if (l == 0L)
    {
      localContext = this.a;
      localObject2 = new HashMap();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(System.currentTimeMillis());
      ((HashMap)localObject2).put("801", localStringBuilder.toString());
      aef.a(localContext, (Map)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aen
 * JD-Core Version:    0.7.0.1
 */