package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

@Beta
@GwtIncompatible
public final class CharStreams
{
  public static Writer asWriter(Appendable paramAppendable)
  {
    if ((paramAppendable instanceof Writer)) {
      return (Writer)paramAppendable;
    }
    return new AppendableWriter(paramAppendable);
  }
  
  @CanIgnoreReturnValue
  public static long copy(Readable paramReadable, Appendable paramAppendable)
    throws IOException
  {
    Preconditions.checkNotNull(paramReadable);
    Preconditions.checkNotNull(paramAppendable);
    CharBuffer localCharBuffer = createBuffer();
    long l = 0L;
    while (paramReadable.read(localCharBuffer) != -1)
    {
      localCharBuffer.flip();
      paramAppendable.append(localCharBuffer);
      l += localCharBuffer.remaining();
      localCharBuffer.clear();
    }
    return l;
  }
  
  static CharBuffer createBuffer()
  {
    return CharBuffer.allocate(2048);
  }
  
  @CanIgnoreReturnValue
  public static long exhaust(Readable paramReadable)
    throws IOException
  {
    long l1 = 0L;
    CharBuffer localCharBuffer = createBuffer();
    for (;;)
    {
      long l2 = paramReadable.read(localCharBuffer);
      if (l2 == -1L) {
        break;
      }
      l1 += l2;
      localCharBuffer.clear();
    }
    return l1;
  }
  
  public static Writer nullWriter()
  {
    return NullWriter.INSTANCE;
  }
  
  @CanIgnoreReturnValue
  public static <T> T readLines(Readable paramReadable, LineProcessor<T> paramLineProcessor)
    throws IOException
  {
    Preconditions.checkNotNull(paramReadable);
    Preconditions.checkNotNull(paramLineProcessor);
    paramReadable = new LineReader(paramReadable);
    String str;
    do
    {
      str = paramReadable.readLine();
    } while ((str != null) && (paramLineProcessor.processLine(str)));
    return paramLineProcessor.getResult();
  }
  
  public static List<String> readLines(Readable paramReadable)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    paramReadable = new LineReader(paramReadable);
    for (;;)
    {
      String str = paramReadable.readLine();
      if (str == null) {
        break;
      }
      localArrayList.add(str);
    }
    return localArrayList;
  }
  
  public static void skipFully(Reader paramReader, long paramLong)
    throws IOException
  {
    Preconditions.checkNotNull(paramReader);
    while (paramLong > 0L)
    {
      long l = paramReader.skip(paramLong);
      if (l == 0L) {
        throw new EOFException();
      }
      paramLong -= l;
    }
  }
  
  public static String toString(Readable paramReadable)
    throws IOException
  {
    return toStringBuilder(paramReadable).toString();
  }
  
  private static StringBuilder toStringBuilder(Readable paramReadable)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    copy(paramReadable, localStringBuilder);
    return localStringBuilder;
  }
  
  static final class NullWriter
    extends Writer
  {
    private static final NullWriter INSTANCE = new NullWriter();
    
    public Writer append(char paramChar)
    {
      return this;
    }
    
    public Writer append(CharSequence paramCharSequence)
    {
      Preconditions.checkNotNull(paramCharSequence);
      return this;
    }
    
    public Writer append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    {
      Preconditions.checkPositionIndexes(paramInt1, paramInt2, paramCharSequence.length());
      return this;
    }
    
    public void close() {}
    
    public void flush() {}
    
    public String toString()
    {
      return "CharStreams.nullWriter()";
    }
    
    public void write(int paramInt) {}
    
    public void write(String paramString)
    {
      Preconditions.checkNotNull(paramString);
    }
    
    public void write(String paramString, int paramInt1, int paramInt2)
    {
      Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramString.length());
    }
    
    public void write(char[] paramArrayOfChar)
    {
      Preconditions.checkNotNull(paramArrayOfChar);
    }
    
    public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfChar.length);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.CharStreams
 * JD-Core Version:    0.7.0.1
 */