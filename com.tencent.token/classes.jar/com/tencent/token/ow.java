package com.tencent.token;

import android.os.Bundle;

public final class ow
  implements ou.b
{
  public String a;
  public String b;
  public String c;
  
  public final int a()
  {
    return 5;
  }
  
  public final void a(Bundle paramBundle)
  {
    paramBundle.putString("_wxwebpageobject_extInfo", this.b);
    paramBundle.putString("_wxwebpageobject_webpageUrl", this.a);
    paramBundle.putString("_wxwebpageobject_canvaspagexml", this.c);
  }
  
  public final void b(Bundle paramBundle)
  {
    this.b = paramBundle.getString("_wxwebpageobject_extInfo");
    this.a = paramBundle.getString("_wxwebpageobject_webpageUrl");
    this.c = paramBundle.getString("_wxwebpageobject_canvaspagexml");
  }
  
  public final boolean b()
  {
    String str = this.a;
    return (str != null) && (str.length() != 0) && (this.a.length() <= 10240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ow
 * JD-Core Version:    0.7.0.1
 */