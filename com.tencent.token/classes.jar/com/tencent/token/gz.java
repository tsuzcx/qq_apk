package com.tencent.token;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;

public final class gz
{
  public Context a;
  
  private gz(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public static gz a(Context paramContext)
  {
    return new gz(paramContext);
  }
  
  public final int a()
  {
    Configuration localConfiguration = this.a.getResources().getConfiguration();
    int i = localConfiguration.screenWidthDp;
    int j = localConfiguration.screenHeightDp;
    if ((localConfiguration.smallestScreenWidthDp <= 600) && (i <= 600) && ((i <= 960) || (j <= 720)) && ((i <= 720) || (j <= 960)))
    {
      if ((i < 500) && ((i <= 640) || (j <= 480)) && ((i <= 480) || (j <= 640)))
      {
        if (i >= 360) {
          return 3;
        }
        return 2;
      }
      return 4;
    }
    return 5;
  }
  
  public final boolean b()
  {
    return this.a.getResources().getBoolean(gs.b.abc_action_bar_embed_tabs);
  }
  
  public final boolean c()
  {
    return this.a.getApplicationInfo().targetSdkVersion < 14;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gz
 * JD-Core Version:    0.7.0.1
 */