package com.tencent.token;

import android.os.Bundle;

public final class oo
{
  public static final class a
    extends oh
  {
    public String c;
    public String d;
    public String e;
    
    public final int a()
    {
      return 26;
    }
    
    public final void a(Bundle paramBundle)
    {
      super.a(paramBundle);
      paramBundle.putString("_openbusinessview_businessType", this.c);
      paramBundle.putString("_openbusinessview__query_info", this.d);
      paramBundle.putString("_openbusinessview_extInfo", this.e);
    }
    
    public final void b(Bundle paramBundle)
    {
      super.b(paramBundle);
      this.c = paramBundle.getString("_openbusinessview_businessType");
      this.d = paramBundle.getString("_openbusinessview__query_info");
      this.e = paramBundle.getString("_openbusinessview_extInfo");
    }
    
    public final boolean b()
    {
      return !ph.a(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.oo
 * JD-Core Version:    0.7.0.1
 */