package com.tencent.mm.sdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;
import java.net.URLEncoder;

public class OpenWebview
{
  public static class Req
    extends BaseReq
  {
    private static final int MAX_URL_LENGHT = 10240;
    public String url;
    
    public boolean checkArgs()
    {
      if ((this.url == null) || (this.url.length() < 0)) {}
      while (this.url.length() > 10240) {
        return false;
      }
      return true;
    }
    
    public int getType()
    {
      return 12;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_jump_to_webview_url", URLEncoder.encode(this.url));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.modelbiz.OpenWebview
 * JD-Core Version:    0.7.0.1
 */