package com.tencent.token;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;

public final class afc
  implements aew
{
  public final aez a(Context paramContext)
  {
    Object localObject4 = Uri.parse(agg.a(agg.ax));
    String str = agg.a(agg.a);
    int i = Build.VERSION.SDK_INT;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    if (i >= 17) {
      localObject4 = paramContext.getContentResolver().acquireContentProviderClient((Uri)localObject4);
    }
    try
    {
      paramContext = ((ContentProviderClient)localObject4).call(str, null, null);
      if (i < 24) {}
    }
    finally
    {
      label70:
      break label70;
    }
    paramContext = localObject3;
    if (localObject4 != null)
    {
      paramContext = localObject2;
      if (Build.VERSION.SDK_INT >= 24)
      {
        paramContext = localObject1;
        ((ContentProviderClient)localObject4).close();
      }
      else
      {
        ((ContentProviderClient)localObject4).release();
        break label122;
        paramContext = paramContext.getContentResolver().call((Uri)localObject4, str, null, null);
      }
    }
    label122:
    if (paramContext == null) {
      return aez.a(-1);
    }
    if (paramContext.getInt(agg.a(agg.ay), -1) != 0) {
      return aez.a(-2);
    }
    return new aez(paramContext.getString(agg.a(agg.az)), 0);
  }
  
  public final void b(Context paramContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afc
 * JD-Core Version:    0.7.0.1
 */