package com.tencent.token;

import android.os.Bundle;

public final class ow
{
  public static final class a
    extends on
  {
    public String c;
    
    public final int a()
    {
      return 22;
    }
    
    public final void a(Bundle paramBundle)
    {
      super.b(paramBundle);
      paramBundle.putString("_wxapi_pay_insourance_req_url", this.c);
    }
    
    public final void b(Bundle paramBundle)
    {
      super.b(paramBundle);
      this.c = paramBundle.getString("_wxapi_pay_insourance_req_url");
    }
    
    public final boolean b()
    {
      if (pn.a(this.c)) {
        return false;
      }
      return this.c.length() <= 10240;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ow
 * JD-Core Version:    0.7.0.1
 */