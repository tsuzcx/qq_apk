package moai.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import moai.core.utilities.Indexes;

public class DuplexReader
  extends Reader
{
  private static final String TAG = "DuplexReader";
  private static final ThreadBuffer<byte[]> writeBytes = ThreadBuffer.bytes(8192);
  private final ByteBuffer bytes = ByteBuffer.allocate(8192);
  private CharsetDecoder decoder;
  private boolean endOfInput = false;
  private InputStream in;
  private OutputStream out;
  
  public DuplexReader(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    super(paramInputStream);
    this.in = paramInputStream;
    this.out = paramOutputStream;
    this.decoder = Charset.defaultCharset().newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
    this.bytes.limit(0);
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
  
  public String getEncoding()
  {
    if (!isOpen()) {
      return null;
    }
    return this.decoder.charset().name();
  }
  
  public int read()
    throws IOException
  {
    int i = -1;
    synchronized (this.lock)
    {
      if (!isOpen()) {
        throw new IOException("InputStreamReader is closed");
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
    synchronized (this.lock)
    {
      if (!isOpen()) {
        throw new IOException("InputStreamReader is closed");
      }
    }
    Indexes.checkOffsetAndCount(paramArrayOfChar.length, paramInt1, paramInt2);
    if (paramInt2 == 0) {
      return 0;
    }
    CharBuffer localCharBuffer = CharBuffer.wrap(paramArrayOfChar, paramInt1, paramInt2);
    paramArrayOfChar = CoderResult.UNDERFLOW;
    if (!this.bytes.hasRemaining()) {
      paramInt2 = 1;
    }
    label214:
    label489:
    for (;;)
    {
      boolean bool = localCharBuffer.hasRemaining();
      Object localObject1 = paramArrayOfChar;
      if ((!bool) || (paramInt2 != 0)) {}
      for (;;)
      {
        try
        {
          if (this.in.available() == 0)
          {
            paramInt2 = localCharBuffer.position();
            if (paramInt2 > paramInt1)
            {
              localObject1 = paramArrayOfChar;
              paramArrayOfChar = (char[])localObject1;
              if (localObject1 == CoderResult.UNDERFLOW)
              {
                paramArrayOfChar = (char[])localObject1;
                if (this.endOfInput)
                {
                  localObject1 = this.decoder.decode(this.bytes, localCharBuffer, true);
                  paramArrayOfChar = (char[])localObject1;
                  if (localObject1 == CoderResult.UNDERFLOW) {
                    paramArrayOfChar = this.decoder.flush(localCharBuffer);
                  }
                  this.decoder.reset();
                }
              }
              if ((paramArrayOfChar.isMalformed()) || (paramArrayOfChar.isUnmappable())) {
                paramArrayOfChar.throwException();
              }
              if (localCharBuffer.position() - paramInt1 != 0) {
                continue;
              }
              paramInt1 = -1;
              return paramInt1;
            }
          }
        }
        catch (IOException localIOException)
        {
          int i;
          int j;
          continue;
          paramInt2 = 1;
        }
        i = this.bytes.capacity();
        j = this.bytes.limit();
        paramInt2 = this.bytes.arrayOffset() + this.bytes.limit();
        i = this.in.read(this.bytes.array(), paramInt2, i - j);
        if (i == -1)
        {
          this.endOfInput = true;
          localObject1 = paramArrayOfChar;
        }
        else
        {
          localObject1 = paramArrayOfChar;
          if (i != 0)
          {
            this.bytes.limit(this.bytes.limit() + i);
            for (j = 1;; j = 0)
            {
              paramArrayOfChar = this.decoder.decode(this.bytes, localCharBuffer, false);
              if ((j != 0) && (this.out != null))
              {
                System.arraycopy(this.bytes.array(), paramInt2, writeBytes.array(), 0, i);
                this.out.write((byte[])writeBytes.array(), 0, i);
              }
              if (paramArrayOfChar.isUnderflow())
              {
                if (this.bytes.limit() != this.bytes.capacity()) {
                  break label489;
                }
                this.bytes.compact();
                this.bytes.limit(this.bytes.position());
                this.bytes.position(0);
                break label489;
                paramInt2 = localCharBuffer.position();
                paramInt1 = paramInt2 - paramInt1;
                break label214;
              }
              localObject1 = paramArrayOfChar;
              break;
              i = 0;
              paramInt2 = 0;
            }
            for (;;)
            {
              break;
              paramInt2 = 0;
            }
          }
        }
      }
    }
  }
  
  public boolean ready()
    throws IOException
  {
    boolean bool = false;
    synchronized (this.lock)
    {
      if (this.in == null) {
        throw new IOException("InputStreamReader is closed");
      }
    }
    try
    {
      if (!this.bytes.hasRemaining())
      {
        int i = this.in.available();
        if (i <= 0) {}
      }
      else
      {
        bool = true;
      }
      return bool;
    }
    catch (IOException localIOException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.io.DuplexReader
 * JD-Core Version:    0.7.0.1
 */