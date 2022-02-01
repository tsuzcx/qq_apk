package com.tencent.token;

import android.os.Bundle;

public final class om
{
  public static final class a
    extends oh
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
      return !ph.a(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.om
 * JD-Core Version:    0.7.0.1
 */