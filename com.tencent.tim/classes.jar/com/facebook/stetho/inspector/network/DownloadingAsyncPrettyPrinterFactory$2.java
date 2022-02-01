package com.facebook.stetho.inspector.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

final class DownloadingAsyncPrettyPrinterFactory$2
  implements AsyncPrettyPrinter
{
  DownloadingAsyncPrettyPrinterFactory$2(String paramString1, String paramString2) {}
  
  public PrettyPrinterDisplayType getPrettifiedType()
  {
    return PrettyPrinterDisplayType.TEXT;
  }
  
  public void printTo(PrintWriter paramPrintWriter, InputStream paramInputStream)
    throws IOException
  {
    DownloadingAsyncPrettyPrinterFactory.access$000(paramPrintWriter, paramInputStream, "[Failed to parse header: " + this.val$headerName + " : " + this.val$headerValue + " ]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.network.DownloadingAsyncPrettyPrinterFactory.2
 * JD-Core Version:    0.7.0.1
 */