package com.tencent.mm.sdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.sdk.b.f;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;

public class CreateChatroom
{
  public static class Req
    extends BaseReq
  {
    public String chatroomName;
    public String chatroomNickName;
    public String extMsg;
    public String groupId;
    
    public boolean checkArgs()
    {
      return !f.c(this.groupId);
    }
    
    public int getType()
    {
      return 14;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_create_chatroom_group_id", this.groupId);
      paramBundle.putString("_wxapi_create_chatroom_chatroom_name", this.chatroomName);
      paramBundle.putString("_wxapi_create_chatroom_chatroom_nickname", this.chatroomNickName);
      paramBundle.putString("_wxapi_create_chatroom_ext_msg", this.extMsg);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public String extMsg;
    
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
      this.extMsg = paramBundle.getString("_wxapi_create_chatroom_ext_msg");
    }
    
    public int getType()
    {
      return 14;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.modelbiz.CreateChatroom
 * JD-Core Version:    0.7.0.1
 */