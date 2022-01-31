package com.pay.googlewalletsdk.http;

public abstract interface IAppInstallObsrver
{
  public abstract void oninstall(String paramString);
  
  public abstract void oninstallFail(String paramString);
  
  public abstract void onuninstall(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.http.IAppInstallObsrver
 * JD-Core Version:    0.7.0.1
 */