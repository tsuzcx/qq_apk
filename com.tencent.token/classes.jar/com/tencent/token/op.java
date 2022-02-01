package com.tencent.token;

import android.os.Bundle;
import java.util.HashMap;

public final class op
{
  public static final class a
    extends oh
  {
    public HashMap<String, String> c;
    public int d;
    
    public final int a()
    {
      return 25;
    }
    
    public final void a(Bundle paramBundle)
    {
      super.a(paramBundle);
      paramBundle.putSerializable("_wxapi_open_business_webview_query_info", this.c);
      paramBundle.putInt("_wxapi_open_business_webview_query_type", this.d);
    }
    
    public final void b(Bundle paramBundle)
    {
      super.b(paramBundle);
      this.c = ((HashMap)paramBundle.getSerializable("_wxapi_open_business_webview_query_info"));
      this.d = paramBundle.getInt("_wxapi_open_business_webview_query_type", 0);
    }
    
    public final boolean b()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.op
 * JD-Core Version:    0.7.0.1
 */