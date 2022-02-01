package com.tencent.token;

import android.os.Bundle;

public final class oj
{
  public static final class a
    extends og
  {
    public String c;
    
    public final int a()
    {
      return 20;
    }
    
    public final void a(Bundle paramBundle)
    {
      super.b(paramBundle);
      paramBundle.putString("_wxapi_invoice_auth_insert_req_url", this.c);
    }
    
    public final void b(Bundle paramBundle)
    {
      super.b(paramBundle);
      this.c = paramBundle.getString("_wxapi_invoice_auth_insert_req_url");
    }
    
    public final boolean b()
    {
      if (pg.a(this.c)) {
        return false;
      }
      return this.c.length() <= 10240;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.oj
 * JD-Core Version:    0.7.0.1
 */