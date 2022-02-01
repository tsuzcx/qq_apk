package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

@GwtIncompatible
final class ReaderInputStream
  extends InputStream
{
  private ByteBuffer byteBuffer;
  private CharBuffer charBuffer;
  private boolean doneFlushing;
  private boolean draining;
  private final CharsetEncoder encoder;
  private boolean endOfInput;
  private final Reader reader;
  private final byte[] singleByte = new byte[1];
  
  ReaderInputStream(Reader paramReader, Charset paramCharset, int paramInt)
  {
    this(paramReader, paramCharset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE), paramInt);
  }
  
  ReaderInputStream(Reader paramReader, CharsetEncoder paramCharsetEncoder, int paramInt)
  {
    this.reader = ((Reader)Preconditions.checkNotNull(paramReader));
    this.encoder = ((CharsetEncoder)Preconditions.checkNotNull(paramCharsetEncoder));
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "bufferSize must be positive: %s", paramInt);
      paramCharsetEncoder.reset();
      this.charBuffer = CharBuffer.allocate(paramInt);
      this.charBuffer.flip();
      this.byteBuffer = ByteBuffer.allocate(paramInt);
      return;
    }
  }
  
  private static int availableCapacity(Buffer paramBuffer)
  {
    return paramBuffer.capacity() - paramBuffer.limit();
  }
  
  private int drain(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 = Math.min(paramInt2, this.byteBuffer.remaining());
    this.byteBuffer.get(paramArrayOfByte, paramInt1, paramInt2);
    return paramInt2;
  }
  
  private static CharBuffer grow(CharBuffer paramCharBuffer)
  {
    CharBuffer localCharBuffer = CharBuffer.wrap(Arrays.copyOf(paramCharBuffer.array(), paramCharBuffer.capacity() * 2));
    localCharBuffer.position(paramCharBuffer.position());
    localCharBuffer.limit(paramCharBuffer.limit());
    return localCharBuffer;
  }
  
  private void readMoreChars()
    throws IOException
  {
    if (availableCapacity(this.charBuffer) == 0)
    {
      if (this.charBuffer.position() <= 0) {
        break label73;
      }
      this.charBuffer.compact().flip();
    }
    int i;
    int j;
    for (;;)
    {
      i = this.charBuffer.limit();
      j = this.reader.read(this.charBuffer.array(), i, availableCapacity(this.charBuffer));
      if (j != -1) {
        break;
      }
      this.endOfInput = true;
      return;
      label73:
      this.charBuffer = grow(this.charBuffer);
    }
    this.charBuffer.limit(i + j);
  }
  
  private void startDraining(boolean paramBoolean)
  {
    this.byteBuffer.flip();
    if ((paramBoolean) && (this.byteBuffer.remaining() == 0))
    {
      this.byteBuffer = ByteBuffer.allocate(this.byteBuffer.capacity() * 2);
      return;
    }
    this.draining = true;
  }
  
  public void close()
    throws IOException
  {
    this.reader.close();
  }
  
  public int read()
    throws IOException
  {
    if (read(this.singleByte) == 1) {
      return UnsignedBytes.toInt(this.singleByte[0]);
    }
    return -1;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    if (paramInt2 == 0) {
      return 0;
    }
    boolean bool1 = this.endOfInput;
    int i = 0;
    boolean bool2 = bool1;
    int j = i;
    if (this.draining)
    {
      j = i + drain(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
      if ((j == paramInt2) || (this.doneFlushing))
      {
        if (j > 0) {}
        for (;;)
        {
          return j;
          j = -1;
        }
      }
      this.draining = false;
      this.byteBuffer.clear();
      bool2 = bool1;
    }
    CoderResult localCoderResult;
    label182:
    label236:
    do
    {
      for (;;)
      {
        if (this.doneFlushing) {
          localCoderResult = CoderResult.UNDERFLOW;
        }
        for (;;)
        {
          if (!localCoderResult.isOverflow()) {
            break label182;
          }
          startDraining(true);
          bool1 = bool2;
          i = j;
          break;
          if (bool2) {
            localCoderResult = this.encoder.flush(this.byteBuffer);
          } else {
            localCoderResult = this.encoder.encode(this.charBuffer, this.byteBuffer, this.endOfInput);
          }
        }
        if (!localCoderResult.isUnderflow()) {
          break label236;
        }
        if (bool2)
        {
          this.doneFlushing = true;
          startDraining(false);
          bool1 = bool2;
          i = j;
          break;
        }
        if (this.endOfInput) {
          bool2 = true;
        } else {
          readMoreChars();
        }
      }
    } while (!localCoderResult.isError());
    localCoderResult.throwException();
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.ReaderInputStream
 * JD-Core Version:    0.7.0.1
 */