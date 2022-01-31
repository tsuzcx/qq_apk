package com.tencent.mm.sdk.openapi;

import android.os.Bundle;

public class GetMessageFromWX$Req
  extends BaseReq
{
  public String username;
  
  public GetMessageFromWX$Req() {}
  
  public GetMessageFromWX$Req(Bundle paramBundle)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.GetMessageFromWX.Req
 * JD-Core Version:    0.7.0.1
 */