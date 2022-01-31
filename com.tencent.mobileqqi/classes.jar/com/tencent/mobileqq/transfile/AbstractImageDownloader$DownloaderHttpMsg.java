package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;

public class AbstractImageDownloader$DownloaderHttpMsg
  extends HttpMsg
{
  boolean a = false;
  
  public AbstractImageDownloader$DownloaderHttpMsg(String paramString, byte[] paramArrayOfByte, IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    super(paramString, paramArrayOfByte, paramIHttpCommunicatorListener);
  }
  
  public AbstractImageDownloader$DownloaderHttpMsg(String paramString, byte[] paramArrayOfByte, IHttpCommunicatorListener paramIHttpCommunicatorListener, boolean paramBoolean)
  {
    super(paramString, paramArrayOfByte, paramIHttpCommunicatorListener, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AbstractImageDownloader.DownloaderHttpMsg
 * JD-Core Version:    0.7.0.1
 */