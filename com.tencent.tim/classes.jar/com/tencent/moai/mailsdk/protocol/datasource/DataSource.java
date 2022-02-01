package com.tencent.moai.mailsdk.protocol.datasource;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.mime.DataListener;
import java.io.InputStream;
import java.io.OutputStream;

public abstract interface DataSource
{
  public abstract String getBoundary();
  
  public abstract String getBoundaryEnd();
  
  public abstract long getSize();
  
  public abstract String read(InputStream paramInputStream, DataListener paramDataListener, String paramString1, String paramString2)
    throws MessageException;
  
  public abstract void setBoundary(String paramString);
  
  public abstract void setBoundaryEnd(String paramString);
  
  public abstract void write(OutputStream paramOutputStream, DataListener paramDataListener, String paramString1, String paramString2)
    throws MessageException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.datasource.DataSource
 * JD-Core Version:    0.7.0.1
 */