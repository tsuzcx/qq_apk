package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import java.util.HashMap;

public class WXOpenBusinessWebview
{
  public static class Req
    extends BaseReq
  {
    public int businessType;
    public HashMap<String, String> queryInfo;
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      this.queryInfo = ((HashMap)paramBundle.getSerializable("_wxapi_open_business_webview_query_info"));
      this.businessType = paramBundle.getInt("_wxapi_open_business_webview_query_type", 0);
    }
    
    public int getType()
    {
      return 25;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putSerializable("_wxapi_open_business_webview_query_info", this.queryInfo);
      paramBundle.putInt("_wxapi_open_business_webview_query_type", this.businessType);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public int businessType;
    public String resultInfo;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      this.resultInfo = paramBundle.getString("_wxapi_open_business_webview_result");
      this.businessType = paramBundle.getInt("_wxapi_open_business_webview_query_type", 0);
    }
    
    public int getType()
    {
      return 25;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_open_business_webview_result", this.resultInfo);
      paramBundle.putInt("_wxapi_open_business_webview_query_type", this.businessType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview
 * JD-Core Version:    0.7.0.1
 */