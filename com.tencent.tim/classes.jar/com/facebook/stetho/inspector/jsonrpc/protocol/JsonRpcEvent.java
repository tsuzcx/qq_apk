package com.facebook.stetho.inspector.jsonrpc.protocol;

import android.annotation.SuppressLint;
import com.facebook.stetho.json.annotation.JsonProperty;
import javax.annotation.Nullable;
import org.json.JSONObject;

@SuppressLint({"UsingDefaultJsonDeserializer", "EmptyJsonPropertyUse"})
public class JsonRpcEvent
{
  @JsonProperty(required=true)
  public String method;
  @JsonProperty
  public JSONObject params;
  
  public JsonRpcEvent() {}
  
  public JsonRpcEvent(String paramString, @Nullable JSONObject paramJSONObject)
  {
    this.method = paramString;
    this.params = paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcEvent
 * JD-Core Version:    0.7.0.1
 */