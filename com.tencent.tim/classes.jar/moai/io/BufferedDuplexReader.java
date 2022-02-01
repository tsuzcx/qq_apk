package moai.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import moai.core.utilities.Indexes;

public class BufferedDuplexReader
  extends Reader
{
  private char[] buf;
  private int end;
  private Reader in;
  private int mark = -1;
  private int markLimit = -1;
  private int pos;
  
  public BufferedDuplexReader(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    this(new DuplexReader(paramInputStream, paramOutputStream));
  }
  
  public BufferedDuplexReader(Reader paramReader)
  {
    this(paramReader, 8192);
  }
  
  public BufferedDuplexReader(Reader paramReader, int paramInt)
  {
    super(paramReader);
    if (paramInt <= 0) {
      throw new IllegalArgumentException("size <= 0");
    }
    this.in = paramReader;
    this.buf = new char[paramInt];
  }
  
  private void checkNotClosed()
    throws IOException
  {
    if (isClosed()) {
      throw new IOException("BufferedReader is closed");
    }
  }
  
  private int fillBuf()
    throws IOException
  {
    int j;
    int i;
    if ((this.mark == -1) || (this.pos - this.mark >= this.markLimit))
    {
      j = this.in.read(this.buf, 0, this.buf.length);
      i = j;
      if (j > 0)
      {
        this.mark = -1;
        this.pos = 0;
        this.end = j;
        i = j;
      }
      return i;
    }
    if ((this.mark == 0) && (this.markLimit > this.buf.length))
    {
      j = this.buf.length * 2;
      i = j;
      if (j > this.markLimit) {
        i = this.markLimit;
      }
      char[] arrayOfChar = new char[i];
      System.arraycopy(this.buf, 0, arrayOfChar, 0, this.buf.length);
      this.buf = arrayOfChar;
    }
    for (;;)
    {
      j = this.in.read(this.buf, this.pos, this.buf.length - this.pos);
      i = j;
      if (j == -1) {
        break;
      }
      this.end += j;
      return j;
      if (this.mark > 0)
      {
        System.arraycopy(this.buf, this.mark, this.buf, 0, this.buf.length - this.mark);
        this.pos -= this.mark;
        this.end -= this.mark;
        this.mark = 0;
      }
    }
  }
  
  private boolean isClosed()
  {
    return this.buf == null;
  }
  
  private int readChar()
    throws IOException
  {
    int i = -1;
    if ((this.pos < this.end) || (fillBuf() != -1))
    {
      char[] arrayOfChar = this.buf;
      i = this.pos;
      this.pos = (i + 1);
      i = arrayOfChar[i];
    }
    return i;
  }
  
  public void close()
    throws IOException
  {
    synchronized (this.lock)
    {
      if (!isClosed())
      {
        this.in.close();
        this.buf = null;
      }
      return;
    }
  }
  
  public void mark(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("markLimit < 0:" + paramInt);
    }
    synchronized (this.lock)
    {
      checkNotClosed();
      this.markLimit = paramInt;
      this.mark = this.pos;
      return;
    }
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
    throws IOException
  {
    synchronized (this.lock)
    {
      checkNotClosed();
      int i = readChar();
      return i;
    }
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    label257:
    for (;;)
    {
      int j;
      int i;
      int k;
      int m;
      synchronized (this.lock)
      {
        checkNotClosed();
        Indexes.checkOffsetAndCount(paramArrayOfChar.length, paramInt1, paramInt2);
        if (paramInt2 != 0) {
          break label257;
        }
        return 0;
        j = paramInt1;
        if (paramInt1 > 0)
        {
          j = this.end - this.pos;
          i = paramInt1;
          m = k;
          if (j > 0)
          {
            i = j;
            if (j >= paramInt1) {
              i = paramInt1;
            }
            System.arraycopy(this.buf, this.pos, paramArrayOfChar, k, i);
            this.pos += i;
            m = k + i;
            i = paramInt1 - i;
          }
          j = i;
          if (i != 0)
          {
            if ((i >= paramInt2) || (this.in.ready())) {
              break label161;
            }
            j = i;
          }
        }
        paramInt1 = paramInt2 - j;
        if (paramInt1 <= 0) {
          break label252;
        }
        return paramInt1;
      }
      label161:
      if (((this.mark == -1) || (this.pos - this.mark >= this.markLimit)) && (i >= this.buf.length))
      {
        paramInt1 = this.in.read(paramArrayOfChar, m, i);
        j = i;
        if (paramInt1 > 0)
        {
          j = i - paramInt1;
          this.mark = -1;
        }
      }
      else
      {
        paramInt1 = i;
        k = m;
        if (fillBuf() == -1)
        {
          j = i;
          continue;
          label252:
          return -1;
          i = paramInt2;
          k = paramInt1;
          paramInt1 = i;
        }
      }
    }
  }
  
  public String readLineWithCRLF()
    throws IOException
  {
    int i;
    int j;
    for (;;)
    {
      synchronized (this.lock)
      {
        checkNotClosed();
        i = this.pos;
        if (i >= this.end) {
          break;
        }
        j = this.buf[i];
        if ((j != 13) || (i >= this.end - 1) || (this.buf[(i + 1)] != '\n')) {
          break label372;
        }
        String str = new String(this.buf, this.pos, i + 2 - this.pos);
        this.pos = (i + 2);
        return str;
        str = new String(this.buf, this.pos, i + 1 - this.pos);
        this.pos = (i + 1);
        return str;
      }
      label140:
      i += 1;
    }
    Object localObject2 = new StringBuilder(this.end - this.pos + 80);
    ((StringBuilder)localObject2).append(this.buf, this.pos, this.end - this.pos);
    label189:
    this.pos = this.end;
    if (fillBuf() == -1)
    {
      if (((StringBuilder)localObject2).length() > 0)
      {
        localObject2 = ((StringBuilder)localObject2).toString();
        label217:
        return localObject2;
      }
    }
    else {
      i = this.pos;
    }
    for (;;)
    {
      if (i < this.end)
      {
        j = this.buf[i];
        if ((j != 13) || (i >= this.end - 1) || (this.buf[(i + 1)] != '\n')) {
          break label392;
        }
        ((StringBuilder)localObject2).append(this.buf, this.pos, i + 2 - this.pos);
        this.pos = (i + 2);
        localObject2 = ((StringBuilder)localObject2).toString();
        return localObject2;
      }
      label372:
      while ((j == 10) || (j == 13))
      {
        ((StringBuilder)localObject2).append(this.buf, this.pos, i + 1 - this.pos);
        this.pos = (i + 1);
        localObject2 = ((StringBuilder)localObject2).toString();
        return localObject2;
        ((StringBuilder)localObject2).append(this.buf, this.pos, this.end - this.pos);
        break label189;
        if (j == 10) {
          break;
        }
        if (j != 13) {
          break label140;
        }
        break;
        localObject2 = null;
        break label217;
      }
      label392:
      i += 1;
    }
  }
  
  public boolean ready()
    throws IOException
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        checkNotClosed();
        if (this.end - this.pos <= 0)
        {
          if (!this.in.ready()) {
            break label50;
          }
          break label45;
          return bool;
        }
      }
      label45:
      boolean bool = true;
      continue;
      label50:
      bool = false;
    }
  }
  
  public void reset()
    throws IOException
  {
    synchronized (this.lock)
    {
      checkNotClosed();
      if (this.mark == -1) {
        throw new IOException("Invalid mark");
      }
    }
    this.pos = this.mark;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("charCount < 0: " + paramLong);
    }
    for (;;)
    {
      long l;
      synchronized (this.lock)
      {
        checkNotClosed();
        if (this.end - this.pos >= paramLong)
        {
          this.pos = ((int)(this.pos + paramLong));
          return paramLong;
        }
        l = this.end - this.pos;
        this.pos = this.end;
        if (l >= paramLong) {
          break;
        }
        if (fillBuf() == -1) {
          return l;
        }
        if (this.end - this.pos >= paramLong - l)
        {
          this.pos = ((int)(paramLong - l + this.pos));
          return paramLong;
        }
      }
      l += this.end - this.pos;
      this.pos = this.end;
    }
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.io.BufferedDuplexReader
 * JD-Core Version:    0.7.0.1
 */