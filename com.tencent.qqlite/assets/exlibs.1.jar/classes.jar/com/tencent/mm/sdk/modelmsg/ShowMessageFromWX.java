package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;

public class ShowMessageFromWX
{
  public static class Req
    extends BaseReq
  {
    public WXMediaMessage message;
    
    public Req() {}
    
    public Req(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }
    
    public boolean checkArgs()
    {
      if (this.message == null) {
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
      return 4;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      Bundle localBundle = WXMediaMessage.Builder.toBundle(this.message);
      super.toBundle(localBundle);
      paramBundle.putAll(localBundle);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public int getType()
    {
      return 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.modelmsg.ShowMessageFromWX
 * JD-Core Version:    0.7.0.1
 */