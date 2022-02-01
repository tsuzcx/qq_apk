package com.tencent.oskplayer.datasource;

import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

public class DataSourceReader
  extends Reader
{
  private final ByteBuffer bytes = ByteBuffer.allocate(8192);
  private CharsetDecoder decoder;
  private boolean endOfInput = false;
  private DataSource in;
  
  public DataSourceReader(DataSource paramDataSource)
  {
    this(paramDataSource, Charset.defaultCharset());
  }
  
  public DataSourceReader(DataSource paramDataSource, String paramString)
    throws UnsupportedEncodingException
  {
    super(paramDataSource);
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.in = paramDataSource;
    try
    {
      this.decoder = Charset.forName(paramString).newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
      this.bytes.limit(0);
      return;
    }
    catch (IllegalArgumentException paramDataSource)
    {
      throw ((UnsupportedEncodingException)new UnsupportedEncodingException(paramString).initCause(paramDataSource));
    }
  }
  
  public DataSourceReader(DataSource paramDataSource, Charset paramCharset)
  {
    super(paramDataSource);
    this.in = paramDataSource;
    this.decoder = paramCharset.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
    this.bytes.limit(0);
  }
  
  public DataSourceReader(DataSource paramDataSource, CharsetDecoder paramCharsetDecoder)
  {
    super(paramDataSource);
    paramCharsetDecoder.averageCharsPerByte();
    this.in = paramDataSource;
    this.decoder = paramCharsetDecoder;
    this.bytes.limit(0);
  }
  
  public static void checkOffsetAndCount(int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt2 | paramInt3) < 0) || (paramInt2 > paramInt1) || (paramInt1 - paramInt2 < paramInt3)) {
      throw new ArrayIndexOutOfBoundsException("arrayLength=" + paramInt1 + ",offset=" + paramInt2 + ",count=" + paramInt3);
    }
  }
  
  private boolean isOpen()
  {
    return this.in != null;
  }
  
  public void close()
    throws IOException
  {
    synchronized (this.lock)
    {
      if (this.decoder != null) {
        this.decoder.reset();
      }
      this.decoder = null;
      if (this.in != null)
      {
        this.in.close();
        this.in = null;
      }
      return;
    }
  }
  
  public int read()
    throws IOException
  {
    int i = -1;
    synchronized (this.lock)
    {
      if (!isOpen()) {
        throw new IOException("DataSourceReader is closed");
      }
    }
    char[] arrayOfChar = new char[1];
    if (read(arrayOfChar, 0, 1) != -1) {
      i = arrayOfChar[0];
    }
    return i;
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = 0;
    synchronized (this.lock)
    {
      if (!isOpen()) {
        throw new IOException("DataSourceReader is closed");
      }
    }
    checkOffsetAndCount(paramArrayOfChar.length, paramInt1, paramInt2);
    if (paramInt2 == 0) {
      return 0;
    }
    CharBuffer localCharBuffer = CharBuffer.wrap(paramArrayOfChar, paramInt1, paramInt2);
    Object localObject1 = CoderResult.UNDERFLOW;
    paramInt2 = i;
    if (!this.bytes.hasRemaining()) {
      paramInt2 = 1;
    }
    for (;;)
    {
      boolean bool = localCharBuffer.hasRemaining();
      paramArrayOfChar = (char[])localObject1;
      if ((!bool) || (paramInt2 != 0)) {}
      for (;;)
      {
        try
        {
          if (this.in.available() == 0L)
          {
            paramInt2 = localCharBuffer.position();
            if (paramInt2 > paramInt1)
            {
              paramArrayOfChar = (char[])localObject1;
              localObject1 = paramArrayOfChar;
              if (paramArrayOfChar == CoderResult.UNDERFLOW)
              {
                localObject1 = paramArrayOfChar;
                if (this.endOfInput)
                {
                  localObject1 = this.decoder.decode(this.bytes, localCharBuffer, true);
                  this.decoder.flush(localCharBuffer);
                  this.decoder.reset();
                }
              }
              if ((((CoderResult)localObject1).isMalformed()) || (((CoderResult)localObject1).isUnmappable())) {
                ((CoderResult)localObject1).throwException();
              }
              if (localCharBuffer.position() - paramInt1 != 0) {
                continue;
              }
              paramInt1 = -1;
              return paramInt1;
            }
          }
        }
        catch (Exception paramArrayOfChar)
        {
          int j;
          int k;
          continue;
          paramInt2 = 1;
        }
        paramArrayOfChar = (char[])localObject1;
        if (!this.endOfInput)
        {
          paramInt2 = this.bytes.capacity();
          i = this.bytes.limit();
          j = this.bytes.arrayOffset();
          k = this.bytes.limit();
          paramInt2 = this.in.read(this.bytes.array(), j + k, paramInt2 - i);
          if (paramInt2 == -1)
          {
            this.endOfInput = true;
            paramArrayOfChar = (char[])localObject1;
          }
          else
          {
            paramArrayOfChar = (char[])localObject1;
            if (paramInt2 != 0)
            {
              this.bytes.limit(paramInt2 + this.bytes.limit());
              localObject1 = this.decoder.decode(this.bytes, localCharBuffer, false);
              paramArrayOfChar = (char[])localObject1;
              if (((CoderResult)localObject1).isUnderflow()) {
                if (this.bytes.limit() == this.bytes.capacity())
                {
                  this.bytes.compact();
                  this.bytes.limit(this.bytes.position());
                  this.bytes.position(0);
                  continue;
                  paramInt2 = localCharBuffer.position();
                  paramInt1 = paramInt2 - paramInt1;
                  continue;
                  break;
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.DataSourceReader
 * JD-Core Version:    0.7.0.1
 */