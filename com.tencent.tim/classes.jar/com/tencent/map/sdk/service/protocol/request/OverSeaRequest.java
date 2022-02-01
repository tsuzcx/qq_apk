package com.tencent.map.sdk.service.protocol.request;

import com.tencent.map.sdk.a.nc.a;
import com.tencent.map.sdk.service.net.annotation.NetRequest;
import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;

public abstract interface OverSeaRequest
  extends nc.a
{
  @NetRequest(constQuery="ctrlpf=vector&ctrlmb=and", method=NetMethod.GET, queryKeys={"apikey", "ver", "ctrlver", "uk", "frontier"})
  public abstract NetResponse checkAuth(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.service.protocol.request.OverSeaRequest
 * JD-Core Version:    0.7.0.1
 */