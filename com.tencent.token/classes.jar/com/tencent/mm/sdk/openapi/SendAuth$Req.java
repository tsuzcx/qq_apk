package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;

public class SendAuth$Req
  extends BaseReq
{
  public String scope;
  public String state;
  
  public SendAuth$Req() {}
  
  public SendAuth$Req(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }
  
  final boolean checkArgs()
  {
    if ((this.scope == null) || (this.scope.length() == 0) || (this.scope.length() > 1024))
    {
      Log.e("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, scope is invalid");
      return false;
    }
    if ((this.state != null) && (this.state.length() > 1024))
    {
      Log.e("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, state is invalid");
      return false;
    }
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.scope = paramBundle.getString("_wxapi_sendauth_req_scope");
    this.state = paramBundle.getString("_wxapi_sendauth_req_state");
  }
  
  public int getType()
  {
    return 1;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_sendauth_req_scope", this.scope);
    paramBundle.putString("_wxapi_sendauth_req_state", this.state);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.SendAuth.Req
 * JD-Core Version:    0.7.0.1
 */