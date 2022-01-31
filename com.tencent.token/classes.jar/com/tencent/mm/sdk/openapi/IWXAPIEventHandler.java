package com.tencent.mm.sdk.openapi;

public abstract interface IWXAPIEventHandler
{
  public abstract void onReq(BaseReq paramBaseReq);
  
  public abstract void onResp(BaseResp paramBaseResp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.IWXAPIEventHandler
 * JD-Core Version:    0.7.0.1
 */