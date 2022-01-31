package tmsdk.common.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import tmsdk.common.a;

public class h
{
  private SharedPreferences a;
  private SharedPreferences.Editor b;
  
  public h(String paramString)
  {
    this.a = a.a().getSharedPreferences(paramString, 0);
  }
  
  private SharedPreferences.Editor a()
  {
    if (this.b == null) {
      this.b = this.a.edit();
    }
    return this.b;
  }
  
  public String a(String paramString1, String paramString2)
  {
    return this.a.getString(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    a().putString(paramString1, paramString2);
    if (paramBoolean) {
      a().commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.c.a.h
 * JD-Core Version:    0.7.0.1
 */