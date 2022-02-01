package com.facebook.stetho.inspector.jsonrpc;

import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;

public class JsonRpcException
  extends Exception
{
  private final JsonRpcError mErrorMessage;
  
  public JsonRpcException(JsonRpcError paramJsonRpcError)
  {
    super(paramJsonRpcError.code + ": " + paramJsonRpcError.message);
    this.mErrorMessage = ((JsonRpcError)Util.throwIfNull(paramJsonRpcError));
  }
  
  public JsonRpcError getErrorMessage()
  {
    return this.mErrorMessage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.jsonrpc.JsonRpcException
 * JD-Core Version:    0.7.0.1
 */