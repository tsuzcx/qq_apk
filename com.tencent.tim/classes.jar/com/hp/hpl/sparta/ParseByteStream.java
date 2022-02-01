package com.hp.hpl.sparta;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

class ParseByteStream
  implements ParseSource
{
  private ParseCharStream parseSource_;
  
  public ParseByteStream(String paramString1, InputStream paramInputStream, ParseLog paramParseLog, String paramString2, ParseHandler paramParseHandler)
    throws ParseException, IOException
  {
    if (paramParseLog == null) {
      paramParseLog = ParseSource.DEFAULT_LOG;
    }
    for (;;)
    {
      if (!paramInputStream.markSupported()) {
        throw new Error("Precondition violation: the InputStream passed to ParseByteStream must support mark");
      }
      paramInputStream.mark(ParseSource.MAXLOOKAHEAD);
      Object localObject = new byte[4];
      int i = paramInputStream.read((byte[])localObject);
      if (paramString2 == null)
      {
        paramString2 = guessEncoding(paramString1, (byte[])localObject, i, paramParseLog);
        try
        {
          InputStreamReader localInputStreamReader;
          String str;
          for (;;)
          {
            paramInputStream.reset();
            localObject = new InputStreamReader(paramInputStream, fixEncoding(paramString2));
            try
            {
              this.parseSource_ = new ParseCharStream(paramString1, (Reader)localObject, paramParseLog, paramString2, paramParseHandler);
              return;
            }
            catch (IOException localIOException)
            {
              paramParseLog.note("Problem reading with assumed encoding of " + paramString2 + " so restarting with " + "euc-jp", paramString1, 1);
              paramInputStream.reset();
            }
          }
        }
        catch (EncodingMismatchException localUnsupportedEncodingException)
        {
          try
          {
            localInputStreamReader = new InputStreamReader(paramInputStream, fixEncoding("euc-jp"));
            this.parseSource_ = new ParseCharStream(paramString1, localInputStreamReader, paramParseLog, null, paramParseHandler);
            return;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            try
            {
              paramInputStream = new InputStreamReader(paramInputStream, fixEncoding(str));
              this.parseSource_ = new ParseCharStream(paramString1, paramInputStream, paramParseLog, null, paramParseHandler);
              return;
            }
            catch (UnsupportedEncodingException paramInputStream)
            {
              throw new ParseException(paramParseLog, paramString1, 1, 0, localUnsupportedEncodingException, "\"" + localUnsupportedEncodingException + "\" is not a supported encoding");
            }
            localUnsupportedEncodingException = localUnsupportedEncodingException;
            throw new ParseException(paramParseLog, paramString1, 1, 0, "euc-jp", "\"" + "euc-jp" + "\" is not a supported encoding");
          }
          localEncodingMismatchException = localEncodingMismatchException;
          str = localEncodingMismatchException.getDeclaredEncoding();
          paramParseLog.note("Encoding declaration of " + str + " is different that assumed " + paramString2 + " so restarting the parsing with the new encoding", paramString1, 1);
          paramInputStream.reset();
        }
      }
    }
  }
  
  private static boolean equals(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[0] == (byte)(paramInt >>> 24)) && (paramArrayOfByte[1] == (byte)(paramInt >>> 16 & 0xFF)) && (paramArrayOfByte[2] == (byte)(paramInt >>> 8 & 0xFF)) && (paramArrayOfByte[3] == (byte)(paramInt & 0xFF));
  }
  
  private static boolean equals(byte[] paramArrayOfByte, short paramShort)
  {
    return (paramArrayOfByte[0] == (byte)(paramShort >>> 8)) && (paramArrayOfByte[1] == (byte)(paramShort & 0xFF));
  }
  
  private static String fixEncoding(String paramString)
  {
    String str = paramString;
    if (paramString.toLowerCase().equals("utf8")) {
      str = "UTF-8";
    }
    return str;
  }
  
  private static String guessEncoding(String paramString, byte[] paramArrayOfByte, int paramInt, ParseLog paramParseLog)
    throws IOException
  {
    String str;
    if (paramInt != 4) {
      if (paramInt <= 0)
      {
        str = "no characters in input";
        paramParseLog.error(str, paramString, 1);
        str = "UTF-8";
      }
    }
    for (;;)
    {
      if (!str.equals("UTF-8")) {
        paramParseLog.note("From start " + hex(paramArrayOfByte[0]) + " " + hex(paramArrayOfByte[1]) + " " + hex(paramArrayOfByte[2]) + " " + hex(paramArrayOfByte[3]) + " deduced encoding = " + str, paramString, 1);
      }
      return str;
      str = "less than 4 characters in input: \"" + new String(paramArrayOfByte, 0, paramInt) + "\"";
      break;
      if ((equals(paramArrayOfByte, 65279)) || (equals(paramArrayOfByte, -131072)) || (equals(paramArrayOfByte, 65534)) || (equals(paramArrayOfByte, -16842752)) || (equals(paramArrayOfByte, 60)) || (equals(paramArrayOfByte, 1006632960)) || (equals(paramArrayOfByte, 15360)) || (equals(paramArrayOfByte, 3932160))) {
        str = "UCS-4";
      } else if (equals(paramArrayOfByte, 3932223)) {
        str = "UTF-16BE";
      } else if (equals(paramArrayOfByte, 1006649088)) {
        str = "UTF-16LE";
      } else if (equals(paramArrayOfByte, 1010792557)) {
        str = "UTF-8";
      } else if (equals(paramArrayOfByte, 1282385812)) {
        str = "EBCDIC";
      } else if ((equals(paramArrayOfByte, (short)-2)) || (equals(paramArrayOfByte, (short)-257))) {
        str = "UTF-16";
      } else {
        str = "UTF-8";
      }
    }
  }
  
  private static String hex(byte paramByte)
  {
    String str2 = Integer.toHexString(paramByte);
    String str1 = str2;
    switch (str2.length())
    {
    default: 
      str1 = str2.substring(str2.length() - 2);
    case 2: 
      return str1;
    }
    return "0" + str2;
  }
  
  public int getLineNumber()
  {
    return this.parseSource_.getLineNumber();
  }
  
  public String getSystemId()
  {
    return this.parseSource_.getSystemId();
  }
  
  public String toString()
  {
    return this.parseSource_.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.ParseByteStream
 * JD-Core Version:    0.7.0.1
 */