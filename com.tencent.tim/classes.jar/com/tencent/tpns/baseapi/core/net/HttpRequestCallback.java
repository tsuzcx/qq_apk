package com.tencent.tpns.baseapi.core.net;

public abstract interface HttpRequestCallback
{
  public abstract void onFailure(int paramInt, String paramString);
  
  public abstract void onSuccess(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.core.net.HttpRequestCallback
 * JD-Core Version:    0.7.0.1
 */