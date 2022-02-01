package com.facebook.stetho.inspector.jsonrpc.protocol;

import android.annotation.SuppressLint;
import com.facebook.stetho.json.annotation.JsonProperty;
import org.json.JSONObject;

@SuppressLint({"UsingDefaultJsonDeserializer", "EmptyJsonPropertyUse"})
public class JsonRpcRequest
{
  @JsonProperty
  public Long id;
  @JsonProperty(required=true)
  public String method;
  @JsonProperty
  public JSONObject params;
  
  public JsonRpcRequest() {}
  
  public JsonRpcRequest(Long paramLong, String paramString, JSONObject paramJSONObject)
  {
    this.id = paramLong;
    this.method = paramString;
    this.params = paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcRequest
 * JD-Core Version:    0.7.0.1
 */