package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXLaunchMiniProgram
{
  public static final class Req
    extends BaseReq
  {
    public static final int MINIPROGRAM_TYPE_PREVIEW = 2;
    public static final int MINIPROGRAM_TYPE_TEST = 1;
    public static final int MINIPTOGRAM_TYPE_RELEASE = 0;
    private static final String TAG = "MicroMsg.SDK.WXLaunchMiniProgram.Req";
    public String extData = "";
    public int miniprogramType = 0;
    public String path = "";
    public String userName;
    
    public final boolean checkArgs()
    {
      if (d.b(this.userName))
      {
        Log.e("MicroMsg.SDK.WXLaunchMiniProgram.Req", "userName is null");
        return false;
      }
      if ((this.miniprogramType < 0) || (this.miniprogramType > 2))
      {
        Log.e("MicroMsg.SDK.WXLaunchMiniProgram.Req", "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW");
        return false;
      }
      return true;
    }
    
    public final int getType()
    {
      return 19;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_launch_wxminiprogram_username", this.userName);
      paramBundle.putString("_launch_wxminiprogram_path", this.path);
      paramBundle.putString("_launch_wxminiprogram_extData", this.extData);
      paramBundle.putInt("_launch_wxminiprogram_type", this.miniprogramType);
    }
  }
  
  public static final class Resp
    extends BaseResp
  {
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
      return 19;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_launch_wxminiprogram_ext_msg", this.extMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram
 * JD-Core Version:    0.7.0.1
 */