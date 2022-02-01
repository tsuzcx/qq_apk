package com.tencent.token;

import android.content.Context;
import com.tencent.turingfd.sdk.qps.Peach;
import java.util.HashMap;
import java.util.Map;

public final class afo
  extends Thread
{
  public afo(Context paramContext) {}
  
  public final void run()
  {
    Context localContext = this.a;
    Object localObject2 = Peach.a;
    try
    {
      l = Long.valueOf(Peach.b(localContext, "801")).longValue();
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
      Peach.a(localContext, (Map)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afo
 * JD-Core Version:    0.7.0.1
 */