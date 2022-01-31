package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QueryDownloadTaskRequest
  extends JceStruct
{
  private static IPCBaseParam cache_baseParam;
  public IPCBaseParam baseParam = null;
  
  public QueryDownloadTaskRequest() {}
  
  public QueryDownloadTaskRequest(IPCBaseParam paramIPCBaseParam)
  {
    this.baseParam = paramIPCBaseParam;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_baseParam == null) {
      cache_baseParam = new IPCBaseParam();
    }
    this.baseParam = ((IPCBaseParam)paramJceInputStream.read(cache_baseParam, 0, true));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.baseParam, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.param.jce.QueryDownloadTaskRequest
 * JD-Core Version:    0.7.0.1
 */