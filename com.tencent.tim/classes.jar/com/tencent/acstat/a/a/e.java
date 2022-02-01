package com.tencent.acstat.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

class e
  extends g
{
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a(String paramString)
  {
    try
    {
      i.a("write mid to sharedPreferences");
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.a).edit();
      localEditor.putString(f(), paramString);
      localEditor.commit();
      return;
    }
    finally {}
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected String b()
  {
    try
    {
      i.a("read mid from sharedPreferences");
      String str = PreferenceManager.getDefaultSharedPreferences(this.a).getString(f(), null);
      return str;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.acstat.a.a.e
 * JD-Core Version:    0.7.0.1
 */