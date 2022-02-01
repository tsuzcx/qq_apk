package com.tencent.token;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Menu;
import android.view.MenuItem;

public final class hy
{
  public static Menu a(Context paramContext, dq paramdq)
  {
    return new hz(paramContext, paramdq);
  }
  
  public static MenuItem a(Context paramContext, dr paramdr)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return new ht(paramContext, paramdr);
    }
    return new hs(paramContext, paramdr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hy
 * JD-Core Version:    0.7.0.1
 */