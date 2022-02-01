package moai.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

public class UnicodeBOMInputStream
  extends InputStream
{
  private final BOM bom;
  private final PushbackInputStream in;
  private boolean skipped = false;
  
  public UnicodeBOMInputStream(InputStream paramInputStream)
    throws NullPointerException, IOException
  {
    if (paramInputStream == null) {
      throw new NullPointerException("invalid input stream: null is not allowed");
    }
    this.in = new PushbackInputStream(paramInputStream, 4);
    paramInputStream = new byte[4];
    int i = this.in.read(paramInputStream);
    switch (i)
    {
    default: 
      this.bom = BOM.NONE;
    }
    for (;;)
    {
      if (i > 0) {
        this.in.unread(paramInputStream, 0, i);
      }
      return;
      if ((paramInputStream[0] == -1) && (paramInputStream[1] == -2) && (paramInputStream[2] == 0) && (paramInputStream[3] == 0))
      {
        this.bom = BOM.UTF_32_LE;
      }
      else if ((paramInputStream[0] == 0) && (paramInputStream[1] == 0) && (paramInputStream[2] == -2) && (paramInputStream[3] == -1))
      {
        this.bom = BOM.UTF_32_BE;
      }
      else if ((paramInputStream[0] == -17) && (paramInputStream[1] == -69) && (paramInputStream[2] == -65))
      {
        this.bom = BOM.UTF_8;
      }
      else if ((paramInputStream[0] == -1) && (paramInputStream[1] == -2))
      {
        this.bom = BOM.UTF_16_LE;
      }
      else
      {
        if ((paramInputStream[0] != -2) || (paramInputStream[1] != -1)) {
          break;
        }
        this.bom = BOM.UTF_16_BE;
      }
    }
  }
  
  public int available()
    throws IOException
  {
    return this.in.available();
  }
  
  public void close()
    throws IOException
  {
    this.in.close();
  }
  
  public final BOM getBOM()
  {
    return this.bom;
  }
  
  public void mark(int paramInt)
  {
    try
    {
      this.in.mark(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean markSupported()
  {
    return this.in.markSupported();
  }
  
  public int read()
    throws IOException
  {
    return this.in.read();
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException, NullPointerException
  {
    return this.in.read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, NullPointerException
  {
    return this.in.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void reset()
    throws IOException
  {
    try
    {
      this.in.reset();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    return this.in.skip(paramLong);
  }
  
  public final UnicodeBOMInputStream skipBOM()
    throws IOException
  {
    try
    {
      if (!this.skipped)
      {
        this.in.skip(this.bom.bytes.length);
        this.skipped = true;
      }
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static final class BOM
  {
    public static final BOM NONE;
    public static final BOM UTF_16_BE;
    public static final BOM UTF_16_LE;
    public static final BOM UTF_32_BE;
    public static final BOM UTF_32_LE;
    public static final BOM UTF_8;
    final byte[] bytes;
    private final String description;
    
    static
    {
      if (!UnicodeBOMInputStream.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        NONE = new BOM(new byte[0], "NONE");
        UTF_8 = new BOM(new byte[] { -17, -69, -65 }, "UTF-8");
        UTF_16_LE = new BOM(new byte[] { -1, -2 }, "UTF-16 little-endian");
        UTF_16_BE = new BOM(new byte[] { -2, -1 }, "UTF-16 big-endian");
        UTF_32_LE = new BOM(new byte[] { -1, -2, 0, 0 }, "UTF-32 little-endian");
        UTF_32_BE = new BOM(new byte[] { 0, 0, -2, -1 }, "UTF-32 big-endian");
        return;
      }
    }
    
    private BOM(byte[] paramArrayOfByte, String paramString)
    {
      assert (paramArrayOfByte != null) : "invalid BOM: null is not allowed";
      assert (paramString != null) : "invalid description: null is not allowed";
      assert (paramString.length() != 0) : "invalid description: empty string is not allowed";
      this.bytes = paramArrayOfByte;
      this.description = paramString;
    }
    
    public final byte[] getBytes()
    {
      int i = this.bytes.length;
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.bytes, 0, arrayOfByte, 0, i);
      return arrayOfByte;
    }
    
    public final String toString()
    {
      return this.description;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.io.UnicodeBOMInputStream
 * JD-Core Version:    0.7.0.1
 */