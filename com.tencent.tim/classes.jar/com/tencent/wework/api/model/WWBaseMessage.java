package com.tencent.wework.api.model;

import android.os.Bundle;

public abstract class WWBaseMessage
  extends BaseMessage
{
  public String appName;
  public String appPkg;
  private String openId;
  public int sdkVer;
  private String transaction;
  
  public void fromBundle(Bundle paramBundle)
  {
    this.transaction = paramBundle.getString("_wwapi_basereq_transaction");
    this.openId = paramBundle.getString("_wwapi_basereq_openid");
    this.appName = paramBundle.getString("_wwapi_basereq_appname");
    this.appPkg = paramBundle.getString("_wwapi_basereq_appbundle");
    this.sdkVer = paramBundle.getInt("_wwobject_sdkVer", 0);
  }
  
  public void toBundle(Bundle paramBundle)
  {
    paramBundle.putString("_wwapi_basereq_transaction", this.transaction);
    paramBundle.putString("_wwapi_basereq_openid", this.openId);
    paramBundle.putString("_wwapi_basereq_appname", this.appName);
    paramBundle.putString("_wwapi_basereq_appbundle", this.appPkg);
    paramBundle.putInt("_wwobject_sdkVer", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.wework.api.model.WWBaseMessage
 * JD-Core Version:    0.7.0.1
 */