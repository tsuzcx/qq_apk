package com.tencent.token;

import android.os.Bundle;

public final class os
{
  public static final class a
    extends on
  {
    public String c;
    
    public final int a()
    {
      return 29;
    }
    
    public final void a(Bundle paramBundle)
    {
      super.a(paramBundle);
      paramBundle.putString("_launch_wxminiprogram_token", this.c);
    }
    
    public final boolean b()
    {
      return !pn.a(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.os
 * JD-Core Version:    0.7.0.1
 */