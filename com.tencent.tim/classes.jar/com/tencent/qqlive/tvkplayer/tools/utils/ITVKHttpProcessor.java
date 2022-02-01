package com.tencent.qqlive.tvkplayer.tools.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract interface ITVKHttpProcessor
{
  public abstract void deleteAsync(@NonNull String paramString, @Nullable Map<String, String> paramMap, int paramInt, @NonNull ITVKHttpCallback paramITVKHttpCallback);
  
  public abstract HttpResponse deleteSync(@NonNull String paramString, @Nullable Map<String, String> paramMap, int paramInt)
    throws IOException;
  
  public abstract void getAsync(@NonNull String paramString, @Nullable Map<String, String> paramMap, int paramInt, @NonNull ITVKHttpCallback paramITVKHttpCallback);
  
  public abstract HttpResponse getSync(@NonNull String paramString, @Nullable Map<String, String> paramMap, int paramInt)
    throws IOException;
  
  public abstract void httpGetCommonSync(@NonNull String paramString, @Nullable Map<String, String> paramMap, int paramInt, @NonNull IWriteCallback paramIWriteCallback)
    throws IOException;
  
  public abstract void httpPostCommonSync(@NonNull String paramString, @Nullable Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt, @NonNull IWriteCallback paramIWriteCallback)
    throws IOException;
  
  public abstract void postAsync(@NonNull String paramString, @Nullable Map<String, String> paramMap, @NonNull byte[] paramArrayOfByte, int paramInt, @NonNull ITVKHttpCallback paramITVKHttpCallback);
  
  public abstract HttpResponse postSync(@NonNull String paramString, @Nullable Map<String, String> paramMap, @NonNull byte[] paramArrayOfByte, int paramInt)
    throws IOException;
  
  public abstract void putAsync(@NonNull String paramString, @Nullable Map<String, String> paramMap, @NonNull byte[] paramArrayOfByte, int paramInt, @NonNull ITVKHttpCallback paramITVKHttpCallback);
  
  public abstract void putSync(@NonNull String paramString, @Nullable Map<String, String> paramMap, @NonNull byte[] paramArrayOfByte, int paramInt)
    throws IOException;
  
  public static class HttpResponse
  {
    public final byte[] mData;
    public final Map<String, List<String>> mHeaders;
    
    public HttpResponse(Map<String, List<String>> paramMap, byte[] paramArrayOfByte)
    {
      this.mHeaders = paramMap;
      this.mData = paramArrayOfByte;
    }
  }
  
  public static abstract interface ITVKHttpCallback
  {
    public abstract void onFailure(IOException paramIOException);
    
    public abstract void onSuccess(ITVKHttpProcessor.HttpResponse paramHttpResponse);
  }
  
  public static abstract interface IWriteCallback
  {
    public abstract void onWriteBodyEnd()
      throws IOException;
    
    public abstract void writeBody(byte[] paramArrayOfByte, int paramInt)
      throws IOException;
    
    public abstract void writeHeaders(Map<String, List<String>> paramMap)
      throws IOException;
  }
  
  public static final class InvalidResponseCodeException
    extends IOException
  {
    public final int responseCode;
    @Nullable
    public final String responseMessage;
    
    public InvalidResponseCodeException(int paramInt, @Nullable String paramString)
    {
      super();
      this.responseCode = paramInt;
      this.responseMessage = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor
 * JD-Core Version:    0.7.0.1
 */