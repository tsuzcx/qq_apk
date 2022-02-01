package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract interface IWriteFuncListener
{
  public abstract void onWriteBody(byte[] paramArrayOfByte, int paramInt)
    throws IOException;
  
  public abstract void onWriteBodyEnd()
    throws IOException;
  
  public abstract void onWriteHeaders(Map<String, List<String>> paramMap)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.IWriteFuncListener
 * JD-Core Version:    0.7.0.1
 */