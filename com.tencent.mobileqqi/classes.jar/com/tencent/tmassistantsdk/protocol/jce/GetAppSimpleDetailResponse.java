package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetAppSimpleDetailResponse
  extends JceStruct
{
  private static ArrayList cache_appSimpleDetailList;
  public ArrayList appSimpleDetailList = null;
  public int ret = 0;
  
  public GetAppSimpleDetailResponse() {}
  
  public GetAppSimpleDetailResponse(int paramInt, ArrayList paramArrayList)
  {
    this.ret = paramInt;
    this.appSimpleDetailList = paramArrayList;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    if (cache_appSimpleDetailList == null)
    {
      cache_appSimpleDetailList = new ArrayList();
      AppSimpleDetail localAppSimpleDetail = new AppSimpleDetail();
      cache_appSimpleDetailList.add(localAppSimpleDetail);
    }
    this.appSimpleDetailList = ((ArrayList)paramJceInputStream.read(cache_appSimpleDetailList, 1, true));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.appSimpleDetailList, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.GetAppSimpleDetailResponse
 * JD-Core Version:    0.7.0.1
 */