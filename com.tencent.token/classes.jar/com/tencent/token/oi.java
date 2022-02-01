package com.tencent.token;

import android.os.Bundle;

public final class oi
{
  public static final class a
    extends oh
  {
    public int c;
    public String d;
    public String e;
    
    public final int a()
    {
      return 18;
    }
    
    public final void a(Bundle paramBundle)
    {
      super.a(paramBundle);
      paramBundle.putInt("_wxapi_subscribemessage_req_scene", this.c);
      paramBundle.putString("_wxapi_subscribemessage_req_templateid", this.d);
      paramBundle.putString("_wxapi_subscribemessage_req_reserved", this.e);
    }
    
    public final void b(Bundle paramBundle)
    {
      super.b(paramBundle);
      this.c = paramBundle.getInt("_wxapi_subscribemessage_req_scene");
      this.d = paramBundle.getString("_wxapi_subscribemessage_req_templateid");
      this.e = paramBundle.getString("_wxapi_subscribemessage_req_reserved");
    }
    
    public final boolean b()
    {
      String str = this.d;
      if (str != null)
      {
        if (str.length() == 0) {
          return false;
        }
        if (this.d.length() > 1024) {
          return false;
        }
        str = this.e;
        return (str == null) || (str.length() <= 1024);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.oi
 * JD-Core Version:    0.7.0.1
 */