package com.tencent.token;

import android.os.Bundle;

public final class oj
{
  public static final class a
    extends oh
  {
    public String c;
    
    public final int a()
    {
      return 23;
    }
    
    public final void a(Bundle paramBundle)
    {
      super.a(paramBundle);
      paramBundle.putString("_wxapi_subscribeminiprogram_req_miniprogramappid", this.c);
    }
    
    public final void b(Bundle paramBundle)
    {
      super.b(paramBundle);
      this.c = paramBundle.getString("_wxapi_subscribeminiprogram_req_miniprogramappid");
    }
    
    public final boolean b()
    {
      String str = this.c;
      return (str != null) && (str.length() != 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.oj
 * JD-Core Version:    0.7.0.1
 */