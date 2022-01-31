package com.tencent.commonsdk.soload;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.LinkedHashMap;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;

class MyZipFile
  implements MyZipConstants
{
  static final int GPBF_DATA_DESCRIPTOR_FLAG = 8;
  static final int GPBF_UTF8_FLAG = 2048;
  public static final int OPEN_DELETE = 4;
  public static final int OPEN_READ = 1;
  private MyZipEntry desentry = null;
  private final String fileName;
  private File fileToDeleteOnClose;
  private String libname;
  private final LinkedHashMap<String, MyZipEntry> mEntries = new LinkedHashMap();
  private RandomAccessFile mRaf;
  
  public MyZipFile(File paramFile, int paramInt, String paramString)
    throws IOException
  {
    this.libname = paramString;
    this.fileName = paramFile.getPath();
    if ((paramInt != 1) && (paramInt != 5)) {
      throw new IllegalArgumentException();
    }
    if ((paramInt & 0x4) != 0) {}
    for (this.fileToDeleteOnClose = paramFile;; this.fileToDeleteOnClose = null)
    {
      this.mRaf = new RandomAccessFile(this.fileName, "r");
      readCentralDir();
      return;
    }
  }
  
  public MyZipFile(File paramFile, String paramString)
    throws ZipException, IOException
  {
    this(paramFile, 1, paramString);
  }
  
  public MyZipFile(String paramString1, String paramString2)
    throws IOException
  {
    this(new File(paramString1), 1, paramString2);
  }
  
  private void checkNotClosed()
  {
    if (this.mRaf == null) {
      throw new IllegalStateException("Zip file closed");
    }
  }
  
  private void readCentralDir()
    throws IOException
  {
    long l2 = this.mRaf.length() - 22L;
    if (l2 < 0L) {
      throw new ZipException("too short to be Zip");
    }
    long l3 = l2 - 65536L;
    long l1 = l3;
    if (l3 < 0L) {
      l1 = 0L;
    }
    int j;
    int n;
    do
    {
      this.mRaf.seek(l2);
      if (Integer.reverseBytes(this.mRaf.readInt()) == 101010256)
      {
        localObject = new byte[18];
        this.mRaf.readFully((byte[])localObject);
        localObject = HeapBufferIterator.iterator((byte[])localObject, 0, localObject.length, ByteOrder.LITTLE_ENDIAN);
        i = ((BufferIterator)localObject).readShort();
        int k = ((BufferIterator)localObject).readShort();
        j = ((BufferIterator)localObject).readShort();
        int m = ((BufferIterator)localObject).readShort();
        ((BufferIterator)localObject).skip(4);
        n = ((BufferIterator)localObject).readInt();
        if ((j == m) && (i == 0) && (k == 0)) {
          break;
        }
        throw new ZipException("spanned archives not supported");
      }
      l3 = l2 - 1L;
      l2 = l3;
    } while (l3 >= l1);
    throw new ZipException("EOCD not found; not a Zip archive?");
    Object localObject = new BufferedInputStream(new RAFStream(this.mRaf, n), 4096);
    byte[] arrayOfByte = new byte[46];
    int i = 0;
    for (;;)
    {
      MyZipEntry localMyZipEntry;
      if (i < j)
      {
        localMyZipEntry = new MyZipEntry(arrayOfByte, (InputStream)localObject);
        this.mEntries.put(localMyZipEntry.getName(), localMyZipEntry);
        if (localMyZipEntry.getName().equals(this.libname)) {
          this.desentry = localMyZipEntry;
        }
      }
      else
      {
        return;
      }
      if (!localMyZipEntry.getName().contains("lib")) {}
      i += 1;
    }
  }
  
  public MyZipEntry getDesEntry()
  {
    return this.desentry;
  }
  
  public MyZipEntry getEntry(String paramString)
  {
    checkNotClosed();
    if (paramString == null) {
      throw new NullPointerException();
    }
    MyZipEntry localMyZipEntry2 = (MyZipEntry)this.mEntries.get(paramString);
    MyZipEntry localMyZipEntry1 = localMyZipEntry2;
    if (localMyZipEntry2 == null) {
      localMyZipEntry1 = (MyZipEntry)this.mEntries.get(paramString + "/");
    }
    return localMyZipEntry1;
  }
  
  public InputStream getInputStream(MyZipEntry arg1)
    throws IOException
  {
    Object localObject1 = getEntry(???.getName());
    if (localObject1 == null) {
      return null;
    }
    synchronized (this.mRaf)
    {
      RAFStream localRAFStream = new RAFStream(???, ((MyZipEntry)localObject1).mLocalHeaderRelOffset + 28L);
      DataInputStream localDataInputStream = new DataInputStream(localRAFStream);
      int i = Short.reverseBytes(localDataInputStream.readShort());
      localDataInputStream.close();
      localRAFStream.skip(((MyZipEntry)localObject1).nameLength + i);
      localRAFStream.mLength = (localRAFStream.mOffset + ((MyZipEntry)localObject1).compressedSize);
      if (((MyZipEntry)localObject1).compressionMethod == 8)
      {
        i = Math.max(1024, (int)Math.min(((MyZipEntry)localObject1).getSize(), 65535L));
        localObject1 = new ZipInflaterInputStream(localRAFStream, new Inflater(true), i, (MyZipEntry)localObject1);
        return localObject1;
      }
      return localRAFStream;
    }
  }
  
  public String getName()
  {
    return this.fileName;
  }
  
  static class RAFStream
    extends InputStream
  {
    long mLength;
    long mOffset;
    RandomAccessFile mSharedRaf;
    
    public RAFStream(RandomAccessFile paramRandomAccessFile, long paramLong)
      throws IOException
    {
      this.mSharedRaf = paramRandomAccessFile;
      this.mOffset = paramLong;
      this.mLength = paramRandomAccessFile.length();
    }
    
    public int available()
      throws IOException
    {
      if (this.mOffset < this.mLength) {
        return 1;
      }
      return 0;
    }
    
    public int read()
      throws IOException
    {
      return Streams.readSingleByte(this);
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      synchronized (this.mSharedRaf)
      {
        this.mSharedRaf.seek(this.mOffset);
        int i = paramInt2;
        if (paramInt2 > this.mLength - this.mOffset) {
          i = (int)(this.mLength - this.mOffset);
        }
        paramInt1 = this.mSharedRaf.read(paramArrayOfByte, paramInt1, i);
        if (paramInt1 > 0)
        {
          this.mOffset += paramInt1;
          return paramInt1;
        }
        return -1;
      }
    }
    
    public long skip(long paramLong)
      throws IOException
    {
      long l = paramLong;
      if (paramLong > this.mLength - this.mOffset) {
        l = this.mLength - this.mOffset;
      }
      this.mOffset += l;
      return l;
    }
  }
  
  static class ZipInflaterInputStream
    extends InflaterInputStream
  {
    long bytesRead = 0L;
    MyZipEntry entry;
    
    public ZipInflaterInputStream(InputStream paramInputStream, Inflater paramInflater, int paramInt, MyZipEntry paramMyZipEntry)
    {
      super(paramInflater, paramInt);
      this.entry = paramMyZipEntry;
    }
    
    public int available()
      throws IOException
    {
      if (super.available() == 0) {
        return 0;
      }
      return (int)(this.entry.getSize() - this.bytesRead);
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 != -1) {
        this.bytesRead += paramInt1;
      }
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.commonsdk.soload.MyZipFile
 * JD-Core Version:    0.7.0.1
 */