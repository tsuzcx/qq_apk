package com.tencent.android.tpush.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.android.tpush.stat.b.b;

public class c
  extends d
{
  public c(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected String a()
  {
    return a(c());
  }
  
  public String a(String paramString)
  {
    try
    {
      if (this.a == null) {
        this.a = b.b();
      }
      this.a.b("read mid from sharedPreferences， key=" + paramString);
      paramString = PreferenceManager.getDefaultSharedPreferences(this.b).getString(paramString, null);
      return paramString;
    }
    finally {}
  }
  
  protected boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.c.c
 * JD-Core Version:    0.7.0.1
 */