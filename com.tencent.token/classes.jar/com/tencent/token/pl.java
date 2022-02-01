package com.tencent.token;

import android.os.Bundle;

public final class pl
{
  public static final class a
    extends pb
  {
    public String c;
    public String d = "";
    public int e = 0;
    public String f = "";
    
    public final int a()
    {
      return 28;
    }
    
    public final void a(Bundle paramBundle)
    {
      super.a(paramBundle);
      paramBundle.putString("_launch_wxminiprogram_username", this.c);
      paramBundle.putString("_launch_wxminiprogram_path", this.d);
      paramBundle.putString("_launch_wxminiprogram_extData", this.f);
      paramBundle.putInt("_launch_wxminiprogram_type", this.e);
    }
    
    public final boolean b()
    {
      if (qb.a(this.c)) {
        return false;
      }
      int i = this.e;
      if (i >= 0) {
        return i <= 2;
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.pl
 * JD-Core Version:    0.7.0.1
 */