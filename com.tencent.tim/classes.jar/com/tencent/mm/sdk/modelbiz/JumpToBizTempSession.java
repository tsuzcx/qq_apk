package com.tencent.mm.sdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.modelbase.BaseReq;

public final class JumpToBizTempSession
{
  public static final int SHOW_CHAT = 1;
  public static final int SHOW_MENU = 0;
  
  public static class Req
    extends BaseReq
  {
    private static final int MAX_SESSION_FROM_LENGTH = 1024;
    private static final String TAG = "MicroMsg.SDK.JumpToBizTempSession.Req";
    public String sessionFrom;
    public int showType;
    public String toUserName;
    
    public boolean checkArgs()
    {
      if ((this.toUserName == null) || (this.toUserName.length() <= 0))
      {
        b.a("MicroMsg.SDK.JumpToBizTempSession.Req", "checkArgs fail, toUserName is invalid");
        return false;
      }
      if ((this.sessionFrom == null) || (this.sessionFrom.length() > 1024))
      {
        b.a("MicroMsg.SDK.JumpToBizTempSession.Req", "checkArgs fail, sessionFrom is invalid");
        return false;
      }
      return true;
    }
    
    public int getType()
    {
      return 10;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_jump_to_biz_webview_req_to_user_name", this.toUserName);
      paramBundle.putString("_wxapi_jump_to_biz_webview_req_session_from", this.sessionFrom);
      paramBundle.putInt("_wxapi_jump_to_biz_webview_req_show_type", this.showType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.modelbiz.JumpToBizTempSession
 * JD-Core Version:    0.7.0.1
 */