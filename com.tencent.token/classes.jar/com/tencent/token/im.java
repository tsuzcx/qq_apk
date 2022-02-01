package com.tencent.token;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Menu;
import android.view.MenuItem;

public final class im
{
  public static Menu a(Context paramContext, ee paramee)
  {
    return new in(paramContext, paramee);
  }
  
  public static MenuItem a(Context paramContext, ef paramef)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return new ih(paramContext, paramef);
    }
    return new ig(paramContext, paramef);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.im
 * JD-Core Version:    0.7.0.1
 */