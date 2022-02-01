package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetHalleyUrlReq
  extends JceStruct
{
  static ArrayList<String> cache_origins = new ArrayList();
  public ArrayList<String> origins = null;
  
  static
  {
    cache_origins.add("");
  }
  
  public GetHalleyUrlReq() {}
  
  public GetHalleyUrlReq(ArrayList<String> paramArrayList)
  {
    this.origins = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.origins = ((ArrayList)paramJceInputStream.read(cache_origins, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.origins, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.GetHalleyUrlReq
 * JD-Core Version:    0.7.0.1
 */