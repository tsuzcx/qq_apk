package com.tencent.mobileqq.msf.core.b;

import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpVersion;
import org.apache.http.NoHttpResponseException;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.StatusLine;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

public class e
{
  protected final LineParser a;
  private final int b;
  private final int c;
  private final CharArrayBuffer d;
  private d e;
  
  public e(MsfSocketInputBuffer paramMsfSocketInputBuffer)
    throws IOException
  {
    this(paramMsfSocketInputBuffer, new BasicLineParser(HttpVersion.HTTP_1_1), -1, -1);
  }
  
  public e(MsfSocketInputBuffer paramMsfSocketInputBuffer, LineParser paramLineParser, int paramInt1, int paramInt2)
    throws IOException
  {
    this.e = new d(paramMsfSocketInputBuffer);
    this.b = paramInt1;
    this.c = paramInt2;
    this.a = BasicLineParser.DEFAULT;
    this.d = new CharArrayBuffer(128);
  }
  
  public static MsfSocketInputBuffer a(Socket paramSocket, int paramInt)
    throws IOException
  {
    return new MsfSocketInputBuffer(paramSocket, paramInt, "US-ASCII", -1);
  }
  
  public static boolean a(d paramd)
  {
    int i = paramd.b().getStatusCode();
    return (i >= 200) && (i != 204) && (i != 304) && (i != 205);
  }
  
  private void c()
    throws IOException, HttpException, ParseException
  {
    this.d.clear();
    if (this.e.i().readLine(this.d) == -1) {
      throw new NoHttpResponseException("The target server failed to respond");
    }
    Object localObject = new ParserCursor(0, this.d.length());
    localObject = this.a.parseStatusLine(this.d, (ParserCursor)localObject);
    this.e.a((StatusLine)localObject);
  }
  
  public d a()
    throws IOException, HttpException
  {
    try
    {
      c();
      Header[] arrayOfHeader = a(this.b, this.c, this.a);
      this.e.a(arrayOfHeader);
      return this.e;
    }
    catch (ParseException localParseException)
    {
      throw new ProtocolException(localParseException.getMessage(), localParseException);
    }
  }
  
  protected Header[] a(int paramInt1, int paramInt2, LineParser paramLineParser)
    throws HttpException, IOException
  {
    int j = 0;
    Object localObject2 = paramLineParser;
    if (paramLineParser == null) {
      localObject2 = BasicLineParser.DEFAULT;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = null;
    paramLineParser = null;
    for (;;)
    {
      if (paramLineParser == null) {
        paramLineParser = new CharArrayBuffer(64);
      }
      while ((this.e.i().readLine(paramLineParser) == -1) || (paramLineParser.length() < 1))
      {
        paramLineParser = new Header[localArrayList.size()];
        paramInt1 = j;
        while (paramInt1 < localArrayList.size())
        {
          localObject1 = (CharArrayBuffer)localArrayList.get(paramInt1);
          try
          {
            paramLineParser[paramInt1] = ((LineParser)localObject2).parseHeader((CharArrayBuffer)localObject1);
            paramInt1 += 1;
          }
          catch (ParseException paramLineParser)
          {
            int i;
            throw new ProtocolException(paramLineParser.getMessage());
          }
        }
        paramLineParser.clear();
      }
      if (((paramLineParser.charAt(0) == ' ') || (paramLineParser.charAt(0) == '\t')) && (localObject1 != null))
      {
        i = 0;
        for (;;)
        {
          if (i < paramLineParser.length())
          {
            int k = paramLineParser.charAt(i);
            if ((k == 32) || (k == 9)) {}
          }
          else
          {
            if ((paramInt2 <= 0) || (((CharArrayBuffer)localObject1).length() + 1 + paramLineParser.length() - i <= paramInt2)) {
              break;
            }
            throw new IOException("Maximum line length limit exceeded");
          }
          i += 1;
        }
        ((CharArrayBuffer)localObject1).append(' ');
        ((CharArrayBuffer)localObject1).append(paramLineParser, i, paramLineParser.length() - i);
      }
      while ((paramInt1 > 0) && (localArrayList.size() >= paramInt1))
      {
        throw new IOException("Maximum header count exceeded");
        localArrayList.add(paramLineParser);
        Object localObject3 = null;
        localObject1 = paramLineParser;
        paramLineParser = localObject3;
      }
    }
    return paramLineParser;
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.b.e
 * JD-Core Version:    0.7.0.1
 */