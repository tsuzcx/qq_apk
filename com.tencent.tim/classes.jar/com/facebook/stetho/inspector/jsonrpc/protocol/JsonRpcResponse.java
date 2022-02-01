package com.facebook.stetho.inspector.jsonrpc.protocol;

import android.annotation.SuppressLint;
import com.facebook.stetho.json.annotation.JsonProperty;
import org.json.JSONObject;

@SuppressLint({"UsingDefaultJsonDeserializer", "EmptyJsonPropertyUse"})
public class JsonRpcResponse
{
  @JsonProperty
  public JSONObject error;
  @JsonProperty(required=true)
  public long id;
  @JsonProperty
  public JSONObject result;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcResponse
 * JD-Core Version:    0.7.0.1
 */