package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

public class WriterOutputStream
  extends OutputStream
{
  private static final int DEFAULT_BUFFER_SIZE = 1024;
  private final CharsetDecoder decoder;
  private final ByteBuffer decoderIn = ByteBuffer.allocate(128);
  private final CharBuffer decoderOut;
  private final boolean writeImmediately;
  private final Writer writer;
  
  @Deprecated
  public WriterOutputStream(Writer paramWriter)
  {
    this(paramWriter, Charset.defaultCharset(), 1024, false);
  }
  
  public WriterOutputStream(Writer paramWriter, String paramString)
  {
    this(paramWriter, paramString, 1024, false);
  }
  
  public WriterOutputStream(Writer paramWriter, String paramString, int paramInt, boolean paramBoolean)
  {
    this(paramWriter, Charset.forName(paramString), paramInt, paramBoolean);
  }
  
  public WriterOutputStream(Writer paramWriter, Charset paramCharset)
  {
    this(paramWriter, paramCharset, 1024, false);
  }
  
  public WriterOutputStream(Writer paramWriter, Charset paramCharset, int paramInt, boolean paramBoolean)
  {
    this(paramWriter, paramCharset.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).replaceWith("?"), paramInt, paramBoolean);
  }
  
  public WriterOutputStream(Writer paramWriter, CharsetDecoder paramCharsetDecoder)
  {
    this(paramWriter, paramCharsetDecoder, 1024, false);
  }
  
  public WriterOutputStream(Writer paramWriter, CharsetDecoder paramCharsetDecoder, int paramInt, boolean paramBoolean)
  {
    checkIbmJdkWithBrokenUTF16(paramCharsetDecoder.charset());
    this.writer = paramWriter;
    this.decoder = paramCharsetDecoder;
    this.writeImmediately = paramBoolean;
    this.decoderOut = CharBuffer.allocate(paramInt);
  }
  
  private static void checkIbmJdkWithBrokenUTF16(Charset paramCharset)
  {
    if (!"UTF-16".equals(paramCharset.name())) {}
    CharBuffer localCharBuffer;
    do
    {
      return;
      byte[] arrayOfByte = "vés".getBytes(paramCharset);
      paramCharset = paramCharset.newDecoder();
      ByteBuffer localByteBuffer = ByteBuffer.allocate(16);
      localCharBuffer = CharBuffer.allocate("vés".length());
      int j = arrayOfByte.length;
      int i = 0;
      if (i < j)
      {
        localByteBuffer.put(arrayOfByte[i]);
        localByteBuffer.flip();
        if (i == j - 1) {}
        for (boolean bool = true;; bool = false) {
          try
          {
            paramCharset.decode(localByteBuffer, localCharBuffer, bool);
            localByteBuffer.compact();
            i += 1;
          }
          catch (IllegalArgumentException paramCharset)
          {
            throw new UnsupportedOperationException("UTF-16 requested when runninng on an IBM JDK with broken UTF-16 support. Please find a JDK that supports UTF-16 if you intend to use UF-16 with WriterOutputStream");
          }
        }
      }
      localCharBuffer.rewind();
    } while ("vés".equals(localCharBuffer.toString()));
    throw new UnsupportedOperationException("UTF-16 requested when runninng on an IBM JDK with broken UTF-16 support. Please find a JDK that supports UTF-16 if you intend to use UF-16 with WriterOutputStream");
  }
  
  private void flushOutput()
    throws IOException
  {
    if (this.decoderOut.position() > 0)
    {
      this.writer.write(this.decoderOut.array(), 0, this.decoderOut.position());
      this.decoderOut.rewind();
    }
  }
  
  private void processInput(boolean paramBoolean)
    throws IOException
  {
    this.decoderIn.flip();
    CoderResult localCoderResult;
    for (;;)
    {
      localCoderResult = this.decoder.decode(this.decoderIn, this.decoderOut, paramBoolean);
      if (!localCoderResult.isOverflow()) {
        break;
      }
      flushOutput();
    }
    if (localCoderResult.isUnderflow())
    {
      this.decoderIn.compact();
      return;
    }
    throw new IOException("Unexpected coder result");
  }
  
  public void close()
    throws IOException
  {
    processInput(true);
    flushOutput();
    this.writer.close();
  }
  
  public void flush()
    throws IOException
  {
    flushOutput();
    this.writer.flush();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    write(new byte[] { (byte)paramInt }, 0, 1);
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    while (paramInt2 > 0)
    {
      int i = Math.min(paramInt2, this.decoderIn.remaining());
      this.decoderIn.put(paramArrayOfByte, paramInt1, i);
      processInput(false);
      paramInt2 -= i;
      paramInt1 += i;
    }
    if (this.writeImmediately) {
      flushOutput();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.output.WriterOutputStream
 * JD-Core Version:    0.7.0.1
 */