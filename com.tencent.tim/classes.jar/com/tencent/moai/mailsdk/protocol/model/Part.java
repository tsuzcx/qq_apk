package com.tencent.moai.mailsdk.protocol.model;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.mime.DataListener;
import java.io.InputStream;
import java.io.OutputStream;

public abstract interface Part
{
  public abstract void addHeader(String paramString1, String paramString2);
  
  public abstract Header getHeader();
  
  public abstract String getHeader(String paramString);
  
  public abstract long getSize();
  
  public abstract String read(InputStream paramInputStream, DataListener paramDataListener)
    throws MessageException;
  
  public abstract String removeHeader(String paramString);
  
  public abstract void write(OutputStream paramOutputStream, DataListener paramDataListener)
    throws MessageException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.model.Part
 * JD-Core Version:    0.7.0.1
 */