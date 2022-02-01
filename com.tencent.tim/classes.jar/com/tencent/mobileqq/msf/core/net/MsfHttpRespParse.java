package com.tencent.mobileqq.msf.core.net;

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

public class MsfHttpRespParse
{
  private final CharArrayBuffer lineBuf;
  protected final LineParser lineParser;
  private final int maxHeaderCount;
  private final int maxLineLen;
  private MsfHttpResp msfHttpResp;
  
  public MsfHttpRespParse(MsfSocketInputBuffer paramMsfSocketInputBuffer)
    throws IOException
  {
    this(paramMsfSocketInputBuffer, new BasicLineParser(HttpVersion.HTTP_1_1), -1, -1);
  }
  
  public MsfHttpRespParse(MsfSocketInputBuffer paramMsfSocketInputBuffer, LineParser paramLineParser, int paramInt1, int paramInt2)
    throws IOException
  {
    this.msfHttpResp = new MsfHttpResp(paramMsfSocketInputBuffer);
    this.maxHeaderCount = paramInt1;
    this.maxLineLen = paramInt2;
    this.lineParser = BasicLineParser.DEFAULT;
    this.lineBuf = new CharArrayBuffer(128);
  }
  
  public static boolean canResponseHaveBody(MsfHttpResp paramMsfHttpResp)
  {
    int i = paramMsfHttpResp.getStatusLine().getStatusCode();
    return (i >= 200) && (i != 204) && (i != 304) && (i != 205);
  }
  
  public static MsfSocketInputBuffer createSesssionBuffer(Socket paramSocket, int paramInt)
    throws IOException
  {
    return new MsfSocketInputBuffer(paramSocket, paramInt, "US-ASCII", -1);
  }
  
  private void parseHead()
    throws IOException, HttpException, ParseException
  {
    this.lineBuf.clear();
    if (this.msfHttpResp.getSessionBuffer().readLine(this.lineBuf) == -1) {
      throw new NoHttpResponseException("The target server failed to respond");
    }
    Object localObject = new ParserCursor(0, this.lineBuf.length());
    localObject = this.lineParser.parseStatusLine(this.lineBuf, (ParserCursor)localObject);
    this.msfHttpResp.setStatusline((StatusLine)localObject);
  }
  
  public boolean isParseHeadFinished()
  {
    return false;
  }
  
  public MsfHttpResp parse()
    throws IOException, HttpException
  {
    try
    {
      parseHead();
      Header[] arrayOfHeader = parseHeaders(this.maxHeaderCount, this.maxLineLen, this.lineParser);
      this.msfHttpResp.setHeaders(arrayOfHeader);
      return this.msfHttpResp;
    }
    catch (ParseException localParseException)
    {
      throw new ProtocolException(localParseException.getMessage(), localParseException);
    }
  }
  
  protected Header[] parseHeaders(int paramInt1, int paramInt2, LineParser paramLineParser)
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
      while ((this.msfHttpResp.getSessionBuffer().readLine(paramLineParser) == -1) || (paramLineParser.length() < 1))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.MsfHttpRespParse
 * JD-Core Version:    0.7.0.1
 */