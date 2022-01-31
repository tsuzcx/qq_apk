package com.tencent.mm.sdk.openapi;

public abstract interface ConstantsAPI
{
  public static final String ACTION_HANDLE_APP_REGISTER = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
  public static final String ACTION_HANDLE_APP_UNREGISTER = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_UNREGISTER";
  public static final String ACTION_REFRESH_WXAPP = "com.tencent.mm.plugin.openapi.Intent.ACTION_REFRESH_WXAPP";
  public static final int COMMAND_GETMESSAGE_FROM_WX = 3;
  public static final int COMMAND_SENDAUTH = 1;
  public static final int COMMAND_SENDMESSAGE_TO_WX = 2;
  public static final int COMMAND_SHOWMESSAGE_FROM_WX = 4;
  public static final int COMMAND_UNKNOWN = 0;
  public static final String WX_TOKEN_KEY = "wx_token_key";
  public static final String WX_TOKEN_VALUE = "com.tencent.mm.openapi.token";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.ConstantsAPI
 * JD-Core Version:    0.7.0.1
 */