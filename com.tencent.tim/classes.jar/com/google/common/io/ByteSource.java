package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;

@GwtIncompatible
public abstract class ByteSource
{
  public static ByteSource concat(Iterable<? extends ByteSource> paramIterable)
  {
    return new ConcatenatedByteSource(paramIterable);
  }
  
  public static ByteSource concat(Iterator<? extends ByteSource> paramIterator)
  {
    return concat(ImmutableList.copyOf(paramIterator));
  }
  
  public static ByteSource concat(ByteSource... paramVarArgs)
  {
    return concat(ImmutableList.copyOf(paramVarArgs));
  }
  
  private long countBySkipping(InputStream paramInputStream)
    throws IOException
  {
    long l2;
    for (long l1 = 0L;; l1 += l2)
    {
      l2 = ByteStreams.skipUpTo(paramInputStream, 2147483647L);
      if (l2 <= 0L) {
        break;
      }
    }
    return l1;
  }
  
  public static ByteSource empty()
  {
    return EmptyByteSource.INSTANCE;
  }
  
  public static ByteSource wrap(byte[] paramArrayOfByte)
  {
    return new ByteArrayByteSource(paramArrayOfByte);
  }
  
  public CharSource asCharSource(Charset paramCharset)
  {
    return new AsCharSource(paramCharset);
  }
  
  public boolean contentEquals(ByteSource paramByteSource)
    throws IOException
  {
    Preconditions.checkNotNull(paramByteSource);
    byte[] arrayOfByte1 = ByteStreams.createBuffer();
    byte[] arrayOfByte2 = ByteStreams.createBuffer();
    Closer localCloser = Closer.create();
    try
    {
      InputStream localInputStream = (InputStream)localCloser.register(openStream());
      paramByteSource = (InputStream)localCloser.register(paramByteSource.openStream());
      int i;
      int j;
      do
      {
        i = ByteStreams.read(localInputStream, arrayOfByte1, 0, arrayOfByte1.length);
        if (i == ByteStreams.read(paramByteSource, arrayOfByte2, 0, arrayOfByte2.length))
        {
          boolean bool = Arrays.equals(arrayOfByte1, arrayOfByte2);
          if (bool) {}
        }
        else
        {
          return false;
        }
        j = arrayOfByte1.length;
      } while (i == j);
      return true;
    }
    catch (Throwable paramByteSource)
    {
      throw localCloser.rethrow(paramByteSource);
    }
    finally
    {
      localCloser.close();
    }
  }
  
  @CanIgnoreReturnValue
  public long copyTo(ByteSink paramByteSink)
    throws IOException
  {
    Preconditions.checkNotNull(paramByteSink);
    Closer localCloser = Closer.create();
    try
    {
      long l = ByteStreams.copy((InputStream)localCloser.register(openStream()), (OutputStream)localCloser.register(paramByteSink.openStream()));
      return l;
    }
    catch (Throwable paramByteSink)
    {
      throw localCloser.rethrow(paramByteSink);
    }
    finally
    {
      localCloser.close();
    }
  }
  
  @CanIgnoreReturnValue
  public long copyTo(OutputStream paramOutputStream)
    throws IOException
  {
    Preconditions.checkNotNull(paramOutputStream);
    Closer localCloser = Closer.create();
    try
    {
      long l = ByteStreams.copy((InputStream)localCloser.register(openStream()), paramOutputStream);
      return l;
    }
    catch (Throwable paramOutputStream)
    {
      throw localCloser.rethrow(paramOutputStream);
    }
    finally
    {
      localCloser.close();
    }
  }
  
  public HashCode hash(HashFunction paramHashFunction)
    throws IOException
  {
    paramHashFunction = paramHashFunction.newHasher();
    copyTo(Funnels.asOutputStream(paramHashFunction));
    return paramHashFunction.hash();
  }
  
  /* Error */
  public boolean isEmpty()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 165	com/google/common/io/ByteSource:sizeIfKnown	()Lcom/google/common/base/Optional;
    //   4: astore_3
    //   5: aload_3
    //   6: invokevirtual 170	com/google/common/base/Optional:isPresent	()Z
    //   9: ifeq +20 -> 29
    //   12: aload_3
    //   13: invokevirtual 174	com/google/common/base/Optional:get	()Ljava/lang/Object;
    //   16: checkcast 176	java/lang/Long
    //   19: invokevirtual 180	java/lang/Long:longValue	()J
    //   22: lconst_0
    //   23: lcmp
    //   24: ifne +5 -> 29
    //   27: iconst_1
    //   28: ireturn
    //   29: invokestatic 95	com/google/common/io/Closer:create	()Lcom/google/common/io/Closer;
    //   32: astore_3
    //   33: aload_3
    //   34: aload_0
    //   35: invokevirtual 99	com/google/common/io/ByteSource:openStream	()Ljava/io/InputStream;
    //   38: invokevirtual 103	com/google/common/io/Closer:register	(Ljava/io/Closeable;)Ljava/io/Closeable;
    //   41: checkcast 105	java/io/InputStream
    //   44: invokevirtual 183	java/io/InputStream:read	()I
    //   47: istore_1
    //   48: iload_1
    //   49: iconst_m1
    //   50: if_icmpne +11 -> 61
    //   53: iconst_1
    //   54: istore_2
    //   55: aload_3
    //   56: invokevirtual 118	com/google/common/io/Closer:close	()V
    //   59: iload_2
    //   60: ireturn
    //   61: iconst_0
    //   62: istore_2
    //   63: goto -8 -> 55
    //   66: astore 4
    //   68: aload_3
    //   69: aload 4
    //   71: invokevirtual 122	com/google/common/io/Closer:rethrow	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   74: athrow
    //   75: astore 4
    //   77: aload_3
    //   78: invokevirtual 118	com/google/common/io/Closer:close	()V
    //   81: aload 4
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	ByteSource
    //   47	4	1	i	int
    //   54	9	2	bool	boolean
    //   4	74	3	localObject1	Object
    //   66	4	4	localThrowable	Throwable
    //   75	7	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   33	48	66	java/lang/Throwable
    //   33	48	75	finally
    //   68	75	75	finally
  }
  
  public InputStream openBufferedStream()
    throws IOException
  {
    InputStream localInputStream = openStream();
    if ((localInputStream instanceof BufferedInputStream)) {
      return (BufferedInputStream)localInputStream;
    }
    return new BufferedInputStream(localInputStream);
  }
  
  public abstract InputStream openStream()
    throws IOException;
  
  @Beta
  @CanIgnoreReturnValue
  public <T> T read(ByteProcessor<T> paramByteProcessor)
    throws IOException
  {
    Preconditions.checkNotNull(paramByteProcessor);
    Closer localCloser = Closer.create();
    try
    {
      paramByteProcessor = ByteStreams.readBytes((InputStream)localCloser.register(openStream()), paramByteProcessor);
      return paramByteProcessor;
    }
    catch (Throwable paramByteProcessor)
    {
      throw localCloser.rethrow(paramByteProcessor);
    }
    finally
    {
      localCloser.close();
    }
  }
  
  public byte[] read()
    throws IOException
  {
    Closer localCloser = Closer.create();
    try
    {
      byte[] arrayOfByte = ByteStreams.toByteArray((InputStream)localCloser.register(openStream()));
      return arrayOfByte;
    }
    catch (Throwable localThrowable)
    {
      throw localCloser.rethrow(localThrowable);
    }
    finally
    {
      localCloser.close();
    }
  }
  
  /* Error */
  public long size()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 165	com/google/common/io/ByteSource:sizeIfKnown	()Lcom/google/common/base/Optional;
    //   4: astore_3
    //   5: aload_3
    //   6: invokevirtual 170	com/google/common/base/Optional:isPresent	()Z
    //   9: ifeq +14 -> 23
    //   12: aload_3
    //   13: invokevirtual 174	com/google/common/base/Optional:get	()Ljava/lang/Object;
    //   16: checkcast 176	java/lang/Long
    //   19: invokevirtual 180	java/lang/Long:longValue	()J
    //   22: lreturn
    //   23: invokestatic 95	com/google/common/io/Closer:create	()Lcom/google/common/io/Closer;
    //   26: astore_3
    //   27: aload_0
    //   28: aload_3
    //   29: aload_0
    //   30: invokevirtual 99	com/google/common/io/ByteSource:openStream	()Ljava/io/InputStream;
    //   33: invokevirtual 103	com/google/common/io/Closer:register	(Ljava/io/Closeable;)Ljava/io/Closeable;
    //   36: checkcast 105	java/io/InputStream
    //   39: invokespecial 203	com/google/common/io/ByteSource:countBySkipping	(Ljava/io/InputStream;)J
    //   42: lstore_1
    //   43: aload_3
    //   44: invokevirtual 118	com/google/common/io/Closer:close	()V
    //   47: lload_1
    //   48: lreturn
    //   49: astore 4
    //   51: aload_3
    //   52: invokevirtual 118	com/google/common/io/Closer:close	()V
    //   55: invokestatic 95	com/google/common/io/Closer:create	()Lcom/google/common/io/Closer;
    //   58: astore_3
    //   59: aload_3
    //   60: aload_0
    //   61: invokevirtual 99	com/google/common/io/ByteSource:openStream	()Ljava/io/InputStream;
    //   64: invokevirtual 103	com/google/common/io/Closer:register	(Ljava/io/Closeable;)Ljava/io/Closeable;
    //   67: checkcast 105	java/io/InputStream
    //   70: invokestatic 206	com/google/common/io/ByteStreams:exhaust	(Ljava/io/InputStream;)J
    //   73: lstore_1
    //   74: aload_3
    //   75: invokevirtual 118	com/google/common/io/Closer:close	()V
    //   78: lload_1
    //   79: lreturn
    //   80: astore 4
    //   82: aload_3
    //   83: invokevirtual 118	com/google/common/io/Closer:close	()V
    //   86: aload 4
    //   88: athrow
    //   89: astore 4
    //   91: aload_3
    //   92: aload 4
    //   94: invokevirtual 122	com/google/common/io/Closer:rethrow	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   97: athrow
    //   98: astore 4
    //   100: aload_3
    //   101: invokevirtual 118	com/google/common/io/Closer:close	()V
    //   104: aload 4
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	ByteSource
    //   42	37	1	l	long
    //   4	97	3	localObject1	Object
    //   49	1	4	localIOException	IOException
    //   80	7	4	localObject2	Object
    //   89	4	4	localThrowable	Throwable
    //   98	7	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   27	43	49	java/io/IOException
    //   27	43	80	finally
    //   59	74	89	java/lang/Throwable
    //   59	74	98	finally
    //   91	98	98	finally
  }
  
  @Beta
  public Optional<Long> sizeIfKnown()
  {
    return Optional.absent();
  }
  
  public ByteSource slice(long paramLong1, long paramLong2)
  {
    return new SlicedByteSource(paramLong1, paramLong2);
  }
  
  final class AsCharSource
    extends CharSource
  {
    final Charset charset;
    
    AsCharSource(Charset paramCharset)
    {
      this.charset = ((Charset)Preconditions.checkNotNull(paramCharset));
    }
    
    public ByteSource asByteSource(Charset paramCharset)
    {
      if (paramCharset.equals(this.charset)) {
        return ByteSource.this;
      }
      return super.asByteSource(paramCharset);
    }
    
    public Reader openStream()
      throws IOException
    {
      return new InputStreamReader(ByteSource.this.openStream(), this.charset);
    }
    
    public String toString()
    {
      return ByteSource.this.toString() + ".asCharSource(" + this.charset + ")";
    }
  }
  
  static class ByteArrayByteSource
    extends ByteSource
  {
    final byte[] bytes;
    final int length;
    final int offset;
    
    ByteArrayByteSource(byte[] paramArrayOfByte)
    {
      this(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    ByteArrayByteSource(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.bytes = paramArrayOfByte;
      this.offset = paramInt1;
      this.length = paramInt2;
    }
    
    public long copyTo(OutputStream paramOutputStream)
      throws IOException
    {
      paramOutputStream.write(this.bytes, this.offset, this.length);
      return this.length;
    }
    
    public HashCode hash(HashFunction paramHashFunction)
      throws IOException
    {
      return paramHashFunction.hashBytes(this.bytes, this.offset, this.length);
    }
    
    public boolean isEmpty()
    {
      return this.length == 0;
    }
    
    public InputStream openBufferedStream()
      throws IOException
    {
      return openStream();
    }
    
    public InputStream openStream()
    {
      return new ByteArrayInputStream(this.bytes, this.offset, this.length);
    }
    
    public <T> T read(ByteProcessor<T> paramByteProcessor)
      throws IOException
    {
      paramByteProcessor.processBytes(this.bytes, this.offset, this.length);
      return paramByteProcessor.getResult();
    }
    
    public byte[] read()
    {
      return Arrays.copyOfRange(this.bytes, this.offset, this.offset + this.length);
    }
    
    public long size()
    {
      return this.length;
    }
    
    public Optional<Long> sizeIfKnown()
    {
      return Optional.of(Long.valueOf(this.length));
    }
    
    public ByteSource slice(long paramLong1, long paramLong2)
    {
      boolean bool2 = true;
      if (paramLong1 >= 0L)
      {
        bool1 = true;
        Preconditions.checkArgument(bool1, "offset (%s) may not be negative", paramLong1);
        if (paramLong2 < 0L) {
          break label95;
        }
      }
      label95:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Preconditions.checkArgument(bool1, "length (%s) may not be negative", paramLong2);
        paramLong1 = Math.min(paramLong1, this.length);
        paramLong2 = Math.min(paramLong2, this.length - paramLong1);
        int i = this.offset;
        int j = (int)paramLong1;
        return new ByteArrayByteSource(this.bytes, j + i, (int)paramLong2);
        bool1 = false;
        break;
      }
    }
    
    public String toString()
    {
      return "ByteSource.wrap(" + Ascii.truncate(BaseEncoding.base16().encode(this.bytes, this.offset, this.length), 30, "...") + ")";
    }
  }
  
  static final class ConcatenatedByteSource
    extends ByteSource
  {
    final Iterable<? extends ByteSource> sources;
    
    ConcatenatedByteSource(Iterable<? extends ByteSource> paramIterable)
    {
      this.sources = ((Iterable)Preconditions.checkNotNull(paramIterable));
    }
    
    public boolean isEmpty()
      throws IOException
    {
      Iterator localIterator = this.sources.iterator();
      while (localIterator.hasNext()) {
        if (!((ByteSource)localIterator.next()).isEmpty()) {
          return false;
        }
      }
      return true;
    }
    
    public InputStream openStream()
      throws IOException
    {
      return new MultiInputStream(this.sources.iterator());
    }
    
    public long size()
      throws IOException
    {
      Iterator localIterator = this.sources.iterator();
      for (long l = 0L; localIterator.hasNext(); l = ((ByteSource)localIterator.next()).size() + l) {}
      return l;
    }
    
    public Optional<Long> sizeIfKnown()
    {
      Iterator localIterator = this.sources.iterator();
      Optional localOptional;
      for (long l = 0L; localIterator.hasNext(); l = ((Long)localOptional.get()).longValue() + l)
      {
        localOptional = ((ByteSource)localIterator.next()).sizeIfKnown();
        if (!localOptional.isPresent()) {
          return Optional.absent();
        }
      }
      return Optional.of(Long.valueOf(l));
    }
    
    public String toString()
    {
      return "ByteSource.concat(" + this.sources + ")";
    }
  }
  
  static final class EmptyByteSource
    extends ByteSource.ByteArrayByteSource
  {
    static final EmptyByteSource INSTANCE = new EmptyByteSource();
    
    EmptyByteSource()
    {
      super();
    }
    
    public CharSource asCharSource(Charset paramCharset)
    {
      Preconditions.checkNotNull(paramCharset);
      return CharSource.empty();
    }
    
    public byte[] read()
    {
      return this.bytes;
    }
    
    public String toString()
    {
      return "ByteSource.empty()";
    }
  }
  
  final class SlicedByteSource
    extends ByteSource
  {
    final long length;
    final long offset;
    
    SlicedByteSource(long paramLong1, long paramLong2)
    {
      if (paramLong1 >= 0L)
      {
        bool1 = true;
        Preconditions.checkArgument(bool1, "offset (%s) may not be negative", paramLong1);
        if (paramLong2 < 0L) {
          break label67;
        }
      }
      label67:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Preconditions.checkArgument(bool1, "length (%s) may not be negative", paramLong2);
        this.offset = paramLong1;
        this.length = paramLong2;
        return;
        bool1 = false;
        break;
      }
    }
    
    private InputStream sliceStream(InputStream paramInputStream)
      throws IOException
    {
      if (this.offset > 0L) {
        try
        {
          long l = ByteStreams.skipUpTo(paramInputStream, this.offset);
          if (l < this.offset)
          {
            paramInputStream.close();
            return new ByteArrayInputStream(new byte[0]);
          }
        }
        catch (Throwable localThrowable)
        {
          Closer localCloser = Closer.create();
          localCloser.register(paramInputStream);
          try
          {
            throw localCloser.rethrow(localThrowable);
          }
          finally
          {
            localCloser.close();
          }
        }
      }
      return ByteStreams.limit(paramInputStream, this.length);
    }
    
    public boolean isEmpty()
      throws IOException
    {
      return (this.length == 0L) || (super.isEmpty());
    }
    
    public InputStream openBufferedStream()
      throws IOException
    {
      return sliceStream(ByteSource.this.openBufferedStream());
    }
    
    public InputStream openStream()
      throws IOException
    {
      return sliceStream(ByteSource.this.openStream());
    }
    
    public Optional<Long> sizeIfKnown()
    {
      Optional localOptional = ByteSource.this.sizeIfKnown();
      if (localOptional.isPresent())
      {
        long l1 = ((Long)localOptional.get()).longValue();
        long l2 = Math.min(this.offset, l1);
        return Optional.of(Long.valueOf(Math.min(this.length, l1 - l2)));
      }
      return Optional.absent();
    }
    
    public ByteSource slice(long paramLong1, long paramLong2)
    {
      boolean bool2 = true;
      if (paramLong1 >= 0L)
      {
        bool1 = true;
        Preconditions.checkArgument(bool1, "offset (%s) may not be negative", paramLong1);
        if (paramLong2 < 0L) {
          break label72;
        }
      }
      label72:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Preconditions.checkArgument(bool1, "length (%s) may not be negative", paramLong2);
        long l = this.length;
        return ByteSource.this.slice(this.offset + paramLong1, Math.min(paramLong2, l - paramLong1));
        bool1 = false;
        break;
      }
    }
    
    public String toString()
    {
      return ByteSource.this.toString() + ".slice(" + this.offset + ", " + this.length + ")";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.ByteSource
 * JD-Core Version:    0.7.0.1
 */