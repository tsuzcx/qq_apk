package com.tencent.mm.sdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.modelbase.BaseReq;

public class JumpToBizProfile
{
  public static final int JUMP_TO_HARD_WARE_BIZ_PROFILE = 1;
  public static final int JUMP_TO_NORMAL_BIZ_PROFILE = 0;
  
  public static class Req
    extends BaseReq
  {
    private static final int EXT_MSG_LENGTH = 1024;
    private static final String TAG = "MicroMsg.SDK.JumpToBizProfile.Req";
    public String extMsg;
    public int profileType = 0;
    public String toUserName;
    
    public boolean checkArgs()
    {
      if ((this.toUserName == null) || (this.toUserName.length() == 0))
      {
        b.a("MicroMsg.SDK.JumpToBizProfile.Req", "checkArgs fail, toUserName is invalid");
        return false;
      }
      if ((this.extMsg != null) && (this.extMsg.length() > 1024))
      {
        b.a("MicroMsg.SDK.JumpToBizProfile.Req", "ext msg is not null, while the length exceed 1024 bytes");
        return false;
      }
      if ((this.profileType == 1) && ((this.extMsg == null) || (this.extMsg.length() == 0)))
      {
        b.a("MicroMsg.SDK.JumpToBizProfile.Req", "scene is jump to hardware profile, while extmsg is null");
        return false;
      }
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      this.toUserName = paramBundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name");
      this.extMsg = paramBundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg");
    }
    
    public int getType()
    {
      return 7;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_jump_to_biz_profile_req_to_user_name", this.toUserName);
      paramBundle.putString("_wxapi_jump_to_biz_profile_req_ext_msg", this.extMsg);
      paramBundle.putInt("_wxapi_jump_to_biz_profile_req_scene", 0);
      paramBundle.putInt("_wxapi_jump_to_biz_profile_req_profile_type", this.profileType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.modelbiz.JumpToBizProfile
 * JD-Core Version:    0.7.0.1
 */