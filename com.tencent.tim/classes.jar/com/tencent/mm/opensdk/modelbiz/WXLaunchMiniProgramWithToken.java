package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXLaunchMiniProgramWithToken
{
  public static final class Req
    extends BaseReq
  {
    private static final String TAG = "MicroMsg.SDK.WXLaunchMiniProgramWithToken.Req";
    public String token;
    
    public final boolean checkArgs()
    {
      if (d.b(this.token))
      {
        Log.e("MicroMsg.SDK.WXLaunchMiniProgramWithToken.Req", "token is null");
        return false;
      }
      return true;
    }
    
    public final int getType()
    {
      return 29;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_launch_wxminiprogram_token", this.token);
    }
  }
  
  public static final class Resp
    extends BaseResp
  {
    public static final int ERR_INVALID_TOKEN = -1000;
    public String extMsg;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }
    
    public final boolean checkArgs()
    {
      return true;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      this.extMsg = paramBundle.getString("_launch_wxminiprogram_ext_msg");
    }
    
    public final int getType()
    {
      return 29;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_launch_wxminiprogram_ext_msg", this.extMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgramWithToken
 * JD-Core Version:    0.7.0.1
 */