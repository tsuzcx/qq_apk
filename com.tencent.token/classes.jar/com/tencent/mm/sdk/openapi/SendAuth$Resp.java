package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;

public class SendAuth$Resp
  extends BaseResp
{
  public int expireDate;
  public String resultUrl;
  public String state;
  public String token;
  public String userName;
  
  public SendAuth$Resp() {}
  
  public SendAuth$Resp(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }
  
  final boolean checkArgs()
  {
    if ((this.state != null) && (this.state.length() > 1024))
    {
      Log.e("MicroMsg.SDK.SendAuth.Resp", "checkArgs fail, state is invalid");
      return false;
    }
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.userName = paramBundle.getString("_wxapi_sendauth_resp_userName");
    this.token = paramBundle.getString("_wxapi_sendauth_resp_token");
    this.expireDate = paramBundle.getInt("_wxapi_sendauth_resp_expireDate", 0);
    this.state = paramBundle.getString("_wxapi_sendauth_resp_state");
  }
  
  public int getType()
  {
    return 1;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_sendauth_resp_userName", this.userName);
    paramBundle.putString("_wxapi_sendauth_resp_token", this.token);
    paramBundle.putInt("_wxapi_sendauth_resp_expireDate", this.expireDate);
    paramBundle.putString("_wxapi_sendauth_resp_state", this.state);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.SendAuth.Resp
 * JD-Core Version:    0.7.0.1
 */