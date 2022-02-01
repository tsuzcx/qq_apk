package com.tencent.mm.sdk.openapi;

import android.content.Context;

public class WXAPIFactory
{
  private static WXAPIFactory p;
  
  public static IWXAPI createWXAPI(Context paramContext, String paramString)
  {
    if (p == null) {
      p = new WXAPIFactory();
    }
    return new WXApiImplV10(paramContext, paramString);
  }
  
  public static IWXAPI createWXAPI(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (p == null) {
      p = new WXAPIFactory();
    }
    return new WXApiImplV10(paramContext, paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.WXAPIFactory
 * JD-Core Version:    0.7.0.1
 */