package com.tencent.mobileqq.msf.core.net;

import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;

public class MsfHttpResp
{
  private String connDirective;
  private InputStream content;
  private String contentEncoding;
  private int contentLen = -1;
  private String contentType;
  private Header[] headers;
  private final MsfSocketInputBuffer sessionBuffer;
  private StatusLine statusline;
  private String transferEncoding;
  
  public MsfHttpResp(MsfSocketInputBuffer paramMsfSocketInputBuffer)
  {
    this.sessionBuffer = paramMsfSocketInputBuffer;
  }
  
  public String getConnDirective()
  {
    return this.connDirective;
  }
  
  public InputStream getContent()
  {
    return this.content;
  }
  
  public String getContentEncoding()
  {
    return this.contentEncoding;
  }
  
  public int getContentLen()
  {
    return this.contentLen;
  }
  
  public String getContentType()
  {
    return this.contentType;
  }
  
  public Header[] getHeaders()
  {
    return this.headers;
  }
  
  public ProtocolVersion getProtocolVersion()
  {
    return this.statusline.getProtocolVersion();
  }
  
  public MsfSocketInputBuffer getSessionBuffer()
  {
    return this.sessionBuffer;
  }
  
  public StatusLine getStatusLine()
  {
    return this.statusline;
  }
  
  public StatusLine getStatusline()
  {
    return this.statusline;
  }
  
  public String getTransferEncoding()
  {
    return this.transferEncoding;
  }
  
  public void setContent(InputStream paramInputStream)
  {
    this.content = paramInputStream;
  }
  
  public void setHeaders(Header[] paramArrayOfHeader)
  {
    this.headers = paramArrayOfHeader;
    int i = paramArrayOfHeader.length - 1;
    if (i >= 0)
    {
      Header localHeader = paramArrayOfHeader[i];
      if (localHeader.getName().equalsIgnoreCase("Transfer-Encoding")) {
        this.transferEncoding = localHeader.getValue();
      }
      for (;;)
      {
        i -= 1;
        break;
        if (localHeader.getName().equalsIgnoreCase("Content-Length")) {
          this.contentLen = Integer.parseInt(localHeader.getValue());
        } else if (localHeader.getName().equalsIgnoreCase("Connection")) {
          this.connDirective = localHeader.getValue();
        } else if (localHeader.getName().equalsIgnoreCase("Content-Encoding")) {
          this.contentEncoding = localHeader.getValue();
        } else if (localHeader.getName().equalsIgnoreCase("Content-Type")) {
          this.contentType = localHeader.getValue();
        }
      }
    }
  }
  
  public void setStatusline(StatusLine paramStatusLine)
  {
    this.statusline = paramStatusLine;
  }
  
  public String toString()
  {
    return getStatusLine() + " contentLen:" + getContentLen() + " transfer:" + this.transferEncoding;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.MsfHttpResp
 * JD-Core Version:    0.7.0.1
 */