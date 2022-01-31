package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;

public class LaunchFromWX
{
  public static class Req
    extends BaseReq
  {
    public Req() {}
    
    public Req(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public int getType()
    {
      return 6;
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
      return 6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.modelmsg.LaunchFromWX
 * JD-Core Version:    0.7.0.1
 */