package moai.io;

import java.io.IOException;
import java.io.Writer;
import moai.core.utilities.Indexes;

public class SharedCharArrayWriter
  extends Writer
{
  protected char[] buf;
  protected int count;
  
  public SharedCharArrayWriter()
  {
    this.buf = Caches.chars(32);
    this.lock = this.buf;
  }
  
  public SharedCharArrayWriter(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("size < 0");
    }
    this.buf = Caches.chars(paramInt);
    this.lock = this.buf;
  }
  
  private void expand(int paramInt)
  {
    if (this.count + paramInt <= this.buf.length) {
      return;
    }
    char[] arrayOfChar = Caches.chars(Math.max(this.buf.length * 2, this.count + paramInt));
    System.arraycopy(this.buf, 0, arrayOfChar, 0, this.count);
    this.buf = arrayOfChar;
  }
  
  public SharedCharArrayWriter append(char paramChar)
  {
    write(paramChar);
    return this;
  }
  
  public SharedCharArrayWriter append(CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "null";
    }
    append((CharSequence)localObject, 0, ((CharSequence)localObject).length());
    return this;
  }
  
  public SharedCharArrayWriter append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "null";
    }
    paramCharSequence = ((CharSequence)localObject).subSequence(paramInt1, paramInt2).toString();
    write(paramCharSequence, 0, paramCharSequence.length());
    return this;
  }
  
  public void close() {}
  
  public void flush() {}
  
  public void reset()
  {
    synchronized (this.lock)
    {
      this.count = 0;
      return;
    }
  }
  
  public int size()
  {
    synchronized (this.lock)
    {
      int i = this.count;
      return i;
    }
  }
  
  public char[] toCharArray()
  {
    synchronized (this.lock)
    {
      char[] arrayOfChar = new char[this.count];
      System.arraycopy(this.buf, 0, arrayOfChar, 0, this.count);
      return arrayOfChar;
    }
  }
  
  public String toString()
  {
    synchronized (this.lock)
    {
      String str = new String(this.buf, 0, this.count);
      return str;
    }
  }
  
  public void write(int paramInt)
  {
    synchronized (this.lock)
    {
      expand(1);
      char[] arrayOfChar = this.buf;
      int i = this.count;
      this.count = (i + 1);
      arrayOfChar[i] = ((char)paramInt);
      return;
    }
  }
  
  public void write(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      throw new NullPointerException("str == null");
    }
    if (((paramInt1 | paramInt2) < 0) || (paramInt1 > paramString.length() - paramInt2)) {
      throw new StringIndexOutOfBoundsException("length=" + paramString.length() + "; regionStart=" + paramInt1 + "; regionLength=" + paramInt2);
    }
    synchronized (this.lock)
    {
      expand(paramInt2);
      paramString.getChars(paramInt1, paramInt1 + paramInt2, this.buf, this.count);
      this.count += paramInt2;
      return;
    }
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    Indexes.checkOffsetAndCount(paramArrayOfChar.length, paramInt1, paramInt2);
    synchronized (this.lock)
    {
      expand(paramInt2);
      System.arraycopy(paramArrayOfChar, paramInt1, this.buf, this.count, paramInt2);
      this.count += paramInt2;
      return;
    }
  }
  
  public void writeTo(Writer paramWriter)
    throws IOException
  {
    synchronized (this.lock)
    {
      paramWriter.write(this.buf, 0, this.count);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.io.SharedCharArrayWriter
 * JD-Core Version:    0.7.0.1
 */