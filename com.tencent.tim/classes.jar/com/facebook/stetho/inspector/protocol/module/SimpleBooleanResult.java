package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.json.annotation.JsonProperty;

public class SimpleBooleanResult
  implements JsonRpcResult
{
  @JsonProperty(required=true)
  public boolean result;
  
  public SimpleBooleanResult() {}
  
  public SimpleBooleanResult(boolean paramBoolean)
  {
    this.result = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.protocol.module.SimpleBooleanResult
 * JD-Core Version:    0.7.0.1
 */