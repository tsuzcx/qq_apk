package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class ary
{
  public SharedPreferences a;
  private SharedPreferences.Editor b;
  
  public ary(String paramString)
  {
    this.a = arn.a().getSharedPreferences(paramString, 0);
  }
  
  public final SharedPreferences.Editor a()
  {
    if (this.b == null) {
      this.b = this.a.edit();
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ary
 * JD-Core Version:    0.7.0.1
 */