package com.tencent.token;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Menu;
import android.view.MenuItem;

public final class hv
{
  public static Menu a(Context paramContext, dn paramdn)
  {
    return new hw(paramContext, paramdn);
  }
  
  public static MenuItem a(Context paramContext, do paramdo)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return new hq(paramContext, paramdo);
    }
    return new hp(paramContext, paramdo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hv
 * JD-Core Version:    0.7.0.1
 */