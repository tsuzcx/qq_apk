package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;

public class ShowMessageFromWX
{
  public static class Req
    extends BaseReq
  {
    public String country;
    public String lang;
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
      this.lang = paramBundle.getString("_wxapi_showmessage_req_lang");
      this.country = paramBundle.getString("_wxapi_showmessage_req_country");
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
      paramBundle.putString("_wxapi_showmessage_req_lang", this.lang);
      paramBundle.putString("_wxapi_showmessage_req_country", this.country);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.modelmsg.ShowMessageFromWX
 * JD-Core Version:    0.7.0.1
 */