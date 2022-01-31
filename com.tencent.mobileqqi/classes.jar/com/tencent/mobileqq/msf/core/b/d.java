package com.tencent.mobileqq.msf.core.b;

import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;

public class d
{
  private final MsfSocketInputBuffer a;
  private InputStream b;
  private StatusLine c;
  private Header[] d;
  private String e;
  private String f;
  private int g = -1;
  private String h;
  private String i;
  
  public d(MsfSocketInputBuffer paramMsfSocketInputBuffer)
  {
    this.a = paramMsfSocketInputBuffer;
  }
  
  public ProtocolVersion a()
  {
    return this.c.getProtocolVersion();
  }
  
  public void a(InputStream paramInputStream)
  {
    this.b = paramInputStream;
  }
  
  public void a(StatusLine paramStatusLine)
  {
    this.c = paramStatusLine;
  }
  
  public void a(Header[] paramArrayOfHeader)
  {
    this.d = paramArrayOfHeader;
    int j = paramArrayOfHeader.length - 1;
    if (j >= 0)
    {
      Header localHeader = paramArrayOfHeader[j];
      if (localHeader.getName().equalsIgnoreCase("Transfer-Encoding")) {
        this.i = localHeader.getValue();
      }
      for (;;)
      {
        j -= 1;
        break;
        if (localHeader.getName().equalsIgnoreCase("Content-Length")) {
          this.g = Integer.parseInt(localHeader.getValue());
        } else if (localHeader.getName().equalsIgnoreCase("Connection")) {
          this.e = localHeader.getValue();
        } else if (localHeader.getName().equalsIgnoreCase("Content-Encoding")) {
          this.h = localHeader.getValue();
        } else if (localHeader.getName().equalsIgnoreCase("Content-Type")) {
          this.f = localHeader.getValue();
        }
      }
    }
  }
  
  public StatusLine b()
  {
    return this.c;
  }
  
  public Header[] c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public int f()
  {
    return this.g;
  }
  
  public String g()
  {
    return this.h;
  }
  
  public String h()
  {
    return this.i;
  }
  
  public MsfSocketInputBuffer i()
  {
    return this.a;
  }
  
  public StatusLine j()
  {
    return this.c;
  }
  
  public InputStream k()
  {
    return this.b;
  }
  
  public String toString()
  {
    return b() + " contentLen:" + f() + " transfer:" + this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.b.d
 * JD-Core Version:    0.7.0.1
 */