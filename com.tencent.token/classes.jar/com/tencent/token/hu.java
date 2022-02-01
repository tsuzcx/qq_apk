package com.tencent.token;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Menu;
import android.view.MenuItem;

public final class hu
{
  public static Menu a(Context paramContext, dm paramdm)
  {
    return new hv(paramContext, paramdm);
  }
  
  public static MenuItem a(Context paramContext, dn paramdn)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return new hp(paramContext, paramdn);
    }
    return new ho(paramContext, paramdn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hu
 * JD-Core Version:    0.7.0.1
 */