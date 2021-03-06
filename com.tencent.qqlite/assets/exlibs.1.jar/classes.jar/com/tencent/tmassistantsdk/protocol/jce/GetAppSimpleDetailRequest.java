package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetAppSimpleDetailRequest
  extends JceStruct
{
  private static ArrayList cache_appReqList;
  public ArrayList appReqList = null;
  
  public GetAppSimpleDetailRequest() {}
  
  public GetAppSimpleDetailRequest(ArrayList paramArrayList)
  {
    this.appReqList = paramArrayList;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_appReqList == null)
    {
      cache_appReqList = new ArrayList();
      AppDetailParam localAppDetailParam = new AppDetailParam();
      cache_appReqList.add(localAppDetailParam);
    }
    this.appReqList = ((ArrayList)paramJceInputStream.read(cache_appReqList, 0, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.appReqList != null) {
      paramJceOutputStream.write(this.appReqList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.GetAppSimpleDetailRequest
 * JD-Core Version:    0.7.0.1
 */