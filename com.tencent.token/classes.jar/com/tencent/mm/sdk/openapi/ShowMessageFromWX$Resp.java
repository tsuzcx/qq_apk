package com.tencent.mm.sdk.openapi;

import android.os.Bundle;

public class ShowMessageFromWX$Resp
  extends BaseResp
{
  public ShowMessageFromWX$Resp() {}
  
  public ShowMessageFromWX$Resp(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }
  
  final boolean checkArgs()
  {
    return true;
  }
  
  public int getType()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.ShowMessageFromWX.Resp
 * JD-Core Version:    0.7.0.1
 */