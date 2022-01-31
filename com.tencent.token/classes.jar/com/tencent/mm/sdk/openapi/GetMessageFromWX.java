package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;

public final class GetMessageFromWX
{
  public static class Req
    extends BaseReq
  {
    public String username;
    
    public Req() {}
    
    public Req(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }
    
    final boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
    }
    
    public int getType()
    {
      return 3;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public WXMediaMessage message;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }
    
    final boolean checkArgs()
    {
      if (this.message == null)
      {
        Log.e("MicroMsg.SDK.GetMessageFromWX.Resp", "checkArgs fail, message is null");
        return false;
      }
      return this.message.checkArgs();
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      this.message = WXMediaMessage.Builder.fromBundle(paramBundle);
    }
    
    public int getType()
    {
      return 3;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putAll(WXMediaMessage.Builder.toBundle(this.message));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.GetMessageFromWX
 * JD-Core Version:    0.7.0.1
 */