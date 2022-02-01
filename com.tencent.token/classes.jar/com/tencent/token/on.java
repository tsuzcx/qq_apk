package com.tencent.token;

import android.os.Bundle;

public abstract class on
{
  public String a;
  public String b;
  
  public abstract int a();
  
  public void a(Bundle paramBundle)
  {
    paramBundle.putInt("_wxapi_command_type", a());
    paramBundle.putString("_wxapi_basereq_transaction", this.a);
    paramBundle.putString("_wxapi_basereq_openid", this.b);
  }
  
  public void b(Bundle paramBundle)
  {
    this.a = pk.a(paramBundle, "_wxapi_basereq_transaction");
    this.b = pk.a(paramBundle, "_wxapi_basereq_openid");
  }
  
  public abstract boolean b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.on
 * JD-Core Version:    0.7.0.1
 */