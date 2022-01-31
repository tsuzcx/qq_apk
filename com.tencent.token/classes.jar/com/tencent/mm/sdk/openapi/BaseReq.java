package com.tencent.mm.sdk.openapi;

import android.os.Bundle;

public abstract class BaseReq
{
  public String transaction;
  
  abstract boolean checkArgs();
  
  public void fromBundle(Bundle paramBundle)
  {
    this.transaction = paramBundle.getString("_wxapi_basereq_transaction");
  }
  
  public abstract int getType();
  
  public void toBundle(Bundle paramBundle)
  {
    paramBundle.putInt("_wxapi_command_type", getType());
    paramBundle.putString("_wxapi_basereq_transaction", this.transaction);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.BaseReq
 * JD-Core Version:    0.7.0.1
 */