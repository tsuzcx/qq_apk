package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public class Profiler
  implements ChromeDevtoolsDomain
{
  @ChromeDevtoolsMethod
  public void disable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {}
  
  @ChromeDevtoolsMethod
  public void enable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {}
  
  @ChromeDevtoolsMethod
  public JsonRpcResult getProfileHeaders(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
  {
    paramJsonRpcPeer = new ProfileHeaderResponse(null);
    paramJsonRpcPeer.headers = Collections.emptyList();
    return paramJsonRpcPeer;
  }
  
  @ChromeDevtoolsMethod
  public void setSamplingInterval(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {}
  
  static class ProfileHeader
  {
    @JsonProperty(required=true)
    String title;
    @JsonProperty(required=true)
    String typeId;
    @JsonProperty(required=true)
    int uid;
  }
  
  static class ProfileHeaderResponse
    implements JsonRpcResult
  {
    @JsonProperty(required=true)
    public List<Profiler.ProfileHeader> headers;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.protocol.module.Profiler
 * JD-Core Version:    0.7.0.1
 */