package com.tencent.qqlive.tvkplayer.tools.utils;

import com.tencent.qqlive.tvkplayer.thirdparties.httpclient.IWriteFuncListener;
import java.io.IOException;
import java.util.List;
import java.util.Map;

class TVKHttpClient$2
  implements IWriteFuncListener
{
  TVKHttpClient$2(TVKHttpClient paramTVKHttpClient, ITVKHttpProcessor.IWriteCallback paramIWriteCallback) {}
  
  public void onWriteBody(byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    this.val$callback.writeBody(paramArrayOfByte, paramInt);
  }
  
  public void onWriteBodyEnd()
    throws IOException
  {
    this.val$callback.onWriteBodyEnd();
  }
  
  public void onWriteHeaders(Map<String, List<String>> paramMap)
    throws IOException
  {
    this.val$callback.writeHeaders(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.TVKHttpClient.2
 * JD-Core Version:    0.7.0.1
 */