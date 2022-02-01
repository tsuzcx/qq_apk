package a.a.a.a;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.LinkedHashMap;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;

public class e
  implements c
{
  public final String a;
  public final LinkedHashMap<String, d> b = new LinkedHashMap();
  public String c;
  public File d;
  public RandomAccessFile e;
  public d f = null;
  
  public e(File paramFile, String paramString)
  {
    this.c = paramString;
    this.a = paramFile.getPath();
    this.d = null;
    this.e = new RandomAccessFile(this.a, "r");
    long l1 = this.e.length() - 22L;
    long l3;
    if (l1 >= 0L)
    {
      l3 = l1 - 65536L;
      if (l3 >= 0L) {
        break label348;
      }
    }
    for (;;)
    {
      this.e.seek(l1);
      if (Integer.reverseBytes(this.e.readInt()) == 101010256)
      {
        paramFile = new byte[18];
        this.e.readFully(paramFile);
        paramFile = a.a(paramFile, 0, paramFile.length, ByteOrder.LITTLE_ENDIAN);
        int i = paramFile.b();
        int k = paramFile.b();
        int j = paramFile.b();
        int m = paramFile.b();
        paramFile.d += 4;
        int n = paramFile.a();
        if ((j == m) && (i == 0) && (k == 0))
        {
          paramFile = new BufferedInputStream(new a(this.e, n), 4096);
          paramString = new byte[46];
          i = 0;
          for (;;)
          {
            d locald;
            if (i < j)
            {
              locald = new d(paramString, paramFile);
              this.b.put(locald.a, locald);
              if (locald.a.equals(this.c)) {
                this.f = locald;
              }
            }
            else
            {
              return;
            }
            locald.a.contains("lib");
            i += 1;
          }
        }
        throw new ZipException("spanned archives not supported");
      }
      l3 = l1 - 1L;
      l1 = l3;
      if (l3 < l2)
      {
        throw new ZipException("EOCD not found; not a Zip archive?");
        throw new ZipException("too short to be Zip");
        label348:
        l2 = l3;
      }
    }
  }
  
  public InputStream a(d paramd)
  {
    ??? = paramd.a;
    if (this.e != null) {
      if (??? != null)
      {
        paramd = (d)this.b.get(???);
        if (paramd != null) {
          break label260;
        }
        paramd = (d)this.b.get((String)??? + "/");
      }
    }
    label260:
    for (;;)
    {
      if (paramd == null) {
        return null;
      }
      ??? = paramd.a;
      a locala;
      if ((??? == null) || ((!((String)???).contains("../")) && (!((String)???).contains("..\\")))) {
        synchronized (this.e)
        {
          locala = new a((RandomAccessFile)???, paramd.g + 28L);
          DataInputStream localDataInputStream = new DataInputStream(locala);
          int i = Short.reverseBytes(localDataInputStream.readShort());
          localDataInputStream.close();
          locala.skip(paramd.f + i);
          locala.c = (locala.b + paramd.b);
          if (paramd.d != 8) {
            break label237;
          }
          i = Math.max(1024, (int)Math.min(paramd.c, 65535L));
          paramd = new b(locala, new Inflater(true), i, paramd);
          return paramd;
        }
      }
      throw new f();
      label237:
      return locala;
      throw new NullPointerException();
      throw new IllegalStateException("Zip file closed");
    }
  }
  
  public void a()
  {
    Object localObject1 = this.e;
    if (localObject1 != null) {}
    try
    {
      this.e = null;
      ((RandomAccessFile)localObject1).close();
      localObject1 = this.d;
      if (localObject1 != null)
      {
        ((File)localObject1).delete();
        this.d = null;
      }
      return;
    }
    finally {}
  }
  
  public void finalize()
  {
    try
    {
      super.finalize();
      return;
    }
    finally {}
  }
  
  public static class a
    extends InputStream
  {
    public RandomAccessFile a;
    public long b;
    public long c;
    
    public a(RandomAccessFile paramRandomAccessFile, long paramLong)
    {
      this.a = paramRandomAccessFile;
      this.b = paramLong;
      this.c = paramRandomAccessFile.length();
    }
    
    public int available()
    {
      if (this.b < this.c) {
        return 1;
      }
      return 0;
    }
    
    public int read()
    {
      int i = -1;
      byte[] arrayOfByte = new byte[1];
      if (read(arrayOfByte, 0, 1) != -1) {
        i = arrayOfByte[0] & 0xFF;
      }
      return i;
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      synchronized (this.a)
      {
        this.a.seek(this.b);
        int i = paramInt2;
        if (paramInt2 > this.c - this.b) {
          i = (int)(this.c - this.b);
        }
        paramInt1 = this.a.read(paramArrayOfByte, paramInt1, i);
        if (paramInt1 > 0)
        {
          this.b += paramInt1;
          return paramInt1;
        }
        return -1;
      }
    }
    
    public long skip(long paramLong)
    {
      long l2 = this.c;
      long l3 = this.b;
      long l1 = paramLong;
      if (paramLong > l2 - l3) {
        l1 = l2 - l3;
      }
      this.b += l1;
      return l1;
    }
  }
  
  public static class b
    extends InflaterInputStream
  {
    public d a;
    public long b = 0L;
    
    public b(InputStream paramInputStream, Inflater paramInflater, int paramInt, d paramd)
    {
      super(paramInflater, paramInt);
      this.a = paramd;
    }
    
    public int available()
    {
      if (super.available() == 0) {
        return 0;
      }
      return (int)(this.a.c - this.b);
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 != -1) {
        this.b += paramInt1;
      }
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     a.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */