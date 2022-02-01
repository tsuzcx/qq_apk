package okio;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class Buffer
  implements Cloneable, ByteChannel, BufferedSink, BufferedSource
{
  private static final byte[] DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  static final int REPLACEMENT_CHARACTER = 65533;
  @Nullable
  Segment head;
  long size;
  
  private ByteString digest(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
      if (this.head != null)
      {
        localMessageDigest.update(this.head.data, this.head.pos, this.head.limit - this.head.pos);
        for (paramString = this.head.next; paramString != this.head; paramString = paramString.next) {
          localMessageDigest.update(paramString.data, paramString.pos, paramString.limit - paramString.pos);
        }
      }
      paramString = ByteString.of(localMessageDigest.digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new AssertionError();
    }
  }
  
  private ByteString hmac(String paramString, ByteString paramByteString)
  {
    try
    {
      Mac localMac = Mac.getInstance(paramString);
      localMac.init(new SecretKeySpec(paramByteString.toByteArray(), paramString));
      if (this.head != null)
      {
        localMac.update(this.head.data, this.head.pos, this.head.limit - this.head.pos);
        for (paramString = this.head.next; paramString != this.head; paramString = paramString.next) {
          localMac.update(paramString.data, paramString.pos, paramString.limit - paramString.pos);
        }
      }
      paramString = ByteString.of(localMac.doFinal());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new AssertionError();
    }
    catch (InvalidKeyException paramString)
    {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  private boolean rangeEquals(Segment paramSegment, int paramInt1, ByteString paramByteString, int paramInt2, int paramInt3)
  {
    int i = paramSegment.limit;
    byte[] arrayOfByte = paramSegment.data;
    while (paramInt2 < paramInt3)
    {
      int j = i;
      int k = paramInt1;
      Segment localSegment = paramSegment;
      if (paramInt1 == i)
      {
        localSegment = paramSegment.next;
        arrayOfByte = localSegment.data;
        k = localSegment.pos;
        j = localSegment.limit;
      }
      if (arrayOfByte[k] != paramByteString.getByte(paramInt2)) {
        return false;
      }
      paramInt1 = k + 1;
      paramInt2 += 1;
      i = j;
      paramSegment = localSegment;
    }
    return true;
  }
  
  private void readFrom(InputStream paramInputStream, long paramLong, boolean paramBoolean)
    throws IOException
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("in == null");
    }
    int i;
    do
    {
      localSegment.limit += i;
      this.size += i;
      paramLong -= i;
      if ((paramLong <= 0L) && (!paramBoolean)) {
        break;
      }
      Segment localSegment = writableSegment(1);
      i = (int)Math.min(paramLong, 8192 - localSegment.limit);
      i = paramInputStream.read(localSegment.data, localSegment.limit, i);
    } while (i != -1);
    if (paramBoolean) {
      return;
    }
    throw new EOFException();
  }
  
  public Buffer buffer()
  {
    return this;
  }
  
  public final void clear()
  {
    try
    {
      skip(this.size);
      return;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public Buffer clone()
  {
    Buffer localBuffer = new Buffer();
    if (this.size == 0L) {
      return localBuffer;
    }
    localBuffer.head = this.head.sharedCopy();
    Segment localSegment1 = localBuffer.head;
    Segment localSegment2 = localBuffer.head;
    Segment localSegment3 = localBuffer.head;
    localSegment2.prev = localSegment3;
    localSegment1.next = localSegment3;
    for (localSegment1 = this.head.next; localSegment1 != this.head; localSegment1 = localSegment1.next) {
      localBuffer.head.prev.push(localSegment1.sharedCopy());
    }
    localBuffer.size = this.size;
    return localBuffer;
  }
  
  public void close() {}
  
  public final long completeSegmentByteCount()
  {
    long l2 = this.size;
    long l1;
    if (l2 == 0L) {
      l1 = 0L;
    }
    Segment localSegment;
    do
    {
      do
      {
        return l1;
        localSegment = this.head.prev;
        l1 = l2;
      } while (localSegment.limit >= 8192);
      l1 = l2;
    } while (!localSegment.owner);
    return l2 - (localSegment.limit - localSegment.pos);
  }
  
  public final Buffer copyTo(OutputStream paramOutputStream)
    throws IOException
  {
    return copyTo(paramOutputStream, 0L, this.size);
  }
  
  public final Buffer copyTo(OutputStream paramOutputStream, long paramLong1, long paramLong2)
    throws IOException
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("out == null");
    }
    Util.checkOffsetAndCount(this.size, paramLong1, paramLong2);
    if (paramLong2 == 0L) {}
    for (;;)
    {
      return this;
      Segment localSegment2;
      long l1;
      long l2;
      for (Segment localSegment1 = this.head;; localSegment1 = localSegment1.next)
      {
        localSegment2 = localSegment1;
        l1 = paramLong1;
        l2 = paramLong2;
        if (paramLong1 < localSegment1.limit - localSegment1.pos) {
          break;
        }
        paramLong1 -= localSegment1.limit - localSegment1.pos;
      }
      while (l2 > 0L)
      {
        int i = (int)(localSegment2.pos + l1);
        int j = (int)Math.min(localSegment2.limit - i, l2);
        paramOutputStream.write(localSegment2.data, i, j);
        l2 -= j;
        localSegment2 = localSegment2.next;
        l1 = 0L;
      }
    }
  }
  
  public final Buffer copyTo(Buffer paramBuffer, long paramLong1, long paramLong2)
  {
    if (paramBuffer == null) {
      throw new IllegalArgumentException("out == null");
    }
    Util.checkOffsetAndCount(this.size, paramLong1, paramLong2);
    if (paramLong2 == 0L) {
      return this;
    }
    paramBuffer.size += paramLong2;
    Segment localSegment2;
    long l1;
    long l2;
    for (Segment localSegment1 = this.head;; localSegment1 = localSegment1.next)
    {
      localSegment2 = localSegment1;
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramLong1 < localSegment1.limit - localSegment1.pos) {
        break;
      }
      paramLong1 -= localSegment1.limit - localSegment1.pos;
    }
    label103:
    if (l2 > 0L)
    {
      localSegment1 = localSegment2.sharedCopy();
      localSegment1.pos = ((int)(localSegment1.pos + l1));
      localSegment1.limit = Math.min(localSegment1.pos + (int)l2, localSegment1.limit);
      if (paramBuffer.head != null) {
        break label211;
      }
      localSegment1.prev = localSegment1;
      localSegment1.next = localSegment1;
      paramBuffer.head = localSegment1;
    }
    for (;;)
    {
      l2 -= localSegment1.limit - localSegment1.pos;
      localSegment2 = localSegment2.next;
      l1 = 0L;
      break label103;
      break;
      label211:
      paramBuffer.head.prev.push(localSegment1);
    }
  }
  
  public BufferedSink emit()
  {
    return this;
  }
  
  public Buffer emitCompleteSegments()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    long l1 = 0L;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Buffer)) {
      return false;
    }
    paramObject = (Buffer)paramObject;
    if (this.size != paramObject.size) {
      return false;
    }
    if (this.size == 0L) {
      return true;
    }
    Object localObject2 = this.head;
    paramObject = paramObject.head;
    int j = ((Segment)localObject2).pos;
    int i = paramObject.pos;
    while (l1 < this.size)
    {
      long l2 = Math.min(((Segment)localObject2).limit - j, paramObject.limit - i);
      int k = 0;
      while (k < l2)
      {
        if (localObject2.data[j] != paramObject.data[i]) {
          return false;
        }
        k += 1;
        i += 1;
        j += 1;
      }
      k = j;
      Object localObject1 = localObject2;
      if (j == ((Segment)localObject2).limit)
      {
        localObject1 = ((Segment)localObject2).next;
        k = ((Segment)localObject1).pos;
      }
      j = i;
      localObject2 = paramObject;
      if (i == paramObject.limit)
      {
        localObject2 = paramObject.next;
        j = ((Segment)localObject2).pos;
      }
      l1 += l2;
      i = j;
      j = k;
      paramObject = localObject2;
      localObject2 = localObject1;
    }
    return true;
  }
  
  public boolean exhausted()
  {
    return this.size == 0L;
  }
  
  public void flush() {}
  
  public final byte getByte(long paramLong)
  {
    Util.checkOffsetAndCount(this.size, paramLong, 1L);
    if (this.size - paramLong > paramLong) {
      for (localSegment = this.head;; localSegment = localSegment.next)
      {
        int i = localSegment.limit - localSegment.pos;
        if (paramLong < i) {
          return localSegment.data[(localSegment.pos + (int)paramLong)];
        }
        paramLong -= i;
      }
    }
    paramLong -= this.size;
    for (Segment localSegment = this.head.prev;; localSegment = localSegment.prev)
    {
      paramLong += localSegment.limit - localSegment.pos;
      if (paramLong >= 0L) {
        return localSegment.data[(localSegment.pos + (int)paramLong)];
      }
    }
  }
  
  public int hashCode()
  {
    Object localObject = this.head;
    if (localObject == null) {
      return 0;
    }
    int j = 1;
    int i;
    Segment localSegment;
    do
    {
      int k = ((Segment)localObject).pos;
      int m = ((Segment)localObject).limit;
      for (i = j; k < m; i = j + i * 31)
      {
        j = localObject.data[k];
        k += 1;
      }
      localSegment = ((Segment)localObject).next;
      j = i;
      localObject = localSegment;
    } while (localSegment != this.head);
    return i;
  }
  
  public final ByteString hmacSha1(ByteString paramByteString)
  {
    return hmac("HmacSHA1", paramByteString);
  }
  
  public final ByteString hmacSha256(ByteString paramByteString)
  {
    return hmac("HmacSHA256", paramByteString);
  }
  
  public final ByteString hmacSha512(ByteString paramByteString)
  {
    return hmac("HmacSHA512", paramByteString);
  }
  
  public long indexOf(byte paramByte)
  {
    return indexOf(paramByte, 0L, 9223372036854775807L);
  }
  
  public long indexOf(byte paramByte, long paramLong)
  {
    return indexOf(paramByte, paramLong, 9223372036854775807L);
  }
  
  public long indexOf(byte paramByte, long paramLong1, long paramLong2)
  {
    if ((paramLong1 < 0L) || (paramLong2 < paramLong1)) {
      throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[] { Long.valueOf(this.size), Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    long l2 = paramLong2;
    if (paramLong2 > this.size) {
      l2 = this.size;
    }
    if (paramLong1 == l2) {
      return -1L;
    }
    Object localObject1 = this.head;
    if (localObject1 == null) {
      return -1L;
    }
    if (this.size - paramLong1 < paramLong1)
    {
      l1 = this.size;
      localObject2 = localObject1;
      for (;;)
      {
        paramLong2 = l1;
        localObject1 = localObject2;
        if (l1 <= paramLong1) {
          break;
        }
        localObject2 = ((Segment)localObject2).prev;
        l1 -= ((Segment)localObject2).limit - ((Segment)localObject2).pos;
      }
    }
    paramLong2 = 0L;
    Object localObject2 = localObject1;
    for (;;)
    {
      l1 = ((Segment)localObject2).limit - ((Segment)localObject2).pos + paramLong2;
      localObject1 = localObject2;
      if (l1 >= paramLong1) {
        break;
      }
      localObject2 = ((Segment)localObject2).next;
      paramLong2 = l1;
    }
    paramLong2 = ((Segment)localObject1).limit - ((Segment)localObject1).pos + paramLong2;
    localObject1 = ((Segment)localObject1).next;
    paramLong1 = paramLong2;
    long l1 = paramLong2;
    paramLong2 = paramLong1;
    for (;;)
    {
      if (paramLong2 < l2)
      {
        localObject2 = ((Segment)localObject1).data;
        int j = (int)Math.min(((Segment)localObject1).limit, ((Segment)localObject1).pos + l2 - paramLong2);
        int i = (int)(((Segment)localObject1).pos + l1 - paramLong2);
        while (i < j)
        {
          if (localObject2[i] == paramByte) {
            return i - ((Segment)localObject1).pos + paramLong2;
          }
          i += 1;
        }
        break;
      }
      return -1L;
      l1 = paramLong1;
    }
  }
  
  public long indexOf(ByteString paramByteString)
    throws IOException
  {
    return indexOf(paramByteString, 0L);
  }
  
  public long indexOf(ByteString paramByteString, long paramLong)
    throws IOException
  {
    if (paramByteString.size() == 0) {
      throw new IllegalArgumentException("bytes is empty");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("fromIndex < 0");
    }
    Object localObject1 = this.head;
    if (localObject1 == null) {
      return -1L;
    }
    if (this.size - paramLong < paramLong)
    {
      l2 = this.size;
      localObject2 = localObject1;
      for (;;)
      {
        l1 = l2;
        localObject1 = localObject2;
        if (l2 <= paramLong) {
          break;
        }
        localObject2 = ((Segment)localObject2).prev;
        l2 -= ((Segment)localObject2).limit - ((Segment)localObject2).pos;
      }
    }
    long l1 = 0L;
    Object localObject2 = localObject1;
    for (;;)
    {
      l2 = ((Segment)localObject2).limit - ((Segment)localObject2).pos + l1;
      localObject1 = localObject2;
      if (l2 >= paramLong) {
        break;
      }
      localObject2 = ((Segment)localObject2).next;
      l1 = l2;
    }
    int j = paramByteString.getByte(0);
    int k = paramByteString.size();
    long l2 = this.size - k + 1L;
    while (l1 < l2)
    {
      localObject2 = ((Segment)localObject1).data;
      int m = (int)Math.min(((Segment)localObject1).limit, ((Segment)localObject1).pos + l2 - l1);
      int i = (int)(((Segment)localObject1).pos + paramLong - l1);
      while (i < m)
      {
        if ((localObject2[i] == j) && (rangeEquals((Segment)localObject1, i + 1, paramByteString, 1, k))) {
          return i - ((Segment)localObject1).pos + l1;
        }
        i += 1;
      }
      paramLong = ((Segment)localObject1).limit - ((Segment)localObject1).pos + l1;
      localObject1 = ((Segment)localObject1).next;
      l1 = paramLong;
    }
    return -1L;
  }
  
  public long indexOfElement(ByteString paramByteString)
  {
    return indexOfElement(paramByteString, 0L);
  }
  
  public long indexOfElement(ByteString paramByteString, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("fromIndex < 0");
    }
    Object localObject1 = this.head;
    if (localObject1 == null) {
      return -1L;
    }
    long l2;
    if (this.size - paramLong < paramLong)
    {
      l2 = this.size;
      localObject2 = localObject1;
      for (;;)
      {
        l1 = l2;
        localObject1 = localObject2;
        if (l2 <= paramLong) {
          break;
        }
        localObject2 = ((Segment)localObject2).prev;
        l2 -= ((Segment)localObject2).limit - ((Segment)localObject2).pos;
      }
    }
    long l1 = 0L;
    Object localObject2 = localObject1;
    for (;;)
    {
      l2 = ((Segment)localObject2).limit - ((Segment)localObject2).pos + l1;
      localObject1 = localObject2;
      if (l2 >= paramLong) {
        break;
      }
      localObject2 = ((Segment)localObject2).next;
      l1 = l2;
    }
    int j;
    int k;
    int i;
    int m;
    int n;
    if (paramByteString.size() == 2)
    {
      j = paramByteString.getByte(0);
      k = paramByteString.getByte(1);
      while (l1 < this.size)
      {
        paramByteString = ((Segment)localObject1).data;
        i = (int)(((Segment)localObject1).pos + paramLong - l1);
        m = ((Segment)localObject1).limit;
        while (i < m)
        {
          n = paramByteString[i];
          if ((n == j) || (n == k)) {
            return l1 + (i - ((Segment)localObject1).pos);
          }
          i += 1;
        }
        l1 += ((Segment)localObject1).limit - ((Segment)localObject1).pos;
        localObject1 = ((Segment)localObject1).next;
        paramLong = l1;
      }
    }
    paramByteString = paramByteString.internalArray();
    while (l1 < this.size)
    {
      localObject2 = ((Segment)localObject1).data;
      i = (int)(((Segment)localObject1).pos + paramLong - l1);
      k = ((Segment)localObject1).limit;
      while (i < k)
      {
        m = localObject2[i];
        n = paramByteString.length;
        j = 0;
        while (j < n)
        {
          if (m == paramByteString[j]) {
            return l1 + (i - ((Segment)localObject1).pos);
          }
          j += 1;
        }
        i += 1;
      }
      l1 += ((Segment)localObject1).limit - ((Segment)localObject1).pos;
      localObject1 = ((Segment)localObject1).next;
      paramLong = l1;
    }
    return -1L;
  }
  
  public InputStream inputStream()
  {
    return new Buffer.2(this);
  }
  
  public boolean isOpen()
  {
    return true;
  }
  
  public final ByteString md5()
  {
    return digest("MD5");
  }
  
  public OutputStream outputStream()
  {
    return new Buffer.1(this);
  }
  
  public boolean rangeEquals(long paramLong, ByteString paramByteString)
  {
    return rangeEquals(paramLong, paramByteString, 0, paramByteString.size());
  }
  
  public boolean rangeEquals(long paramLong, ByteString paramByteString, int paramInt1, int paramInt2)
  {
    if ((paramLong < 0L) || (paramInt1 < 0) || (paramInt2 < 0) || (this.size - paramLong < paramInt2) || (paramByteString.size() - paramInt1 < paramInt2)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramInt2) {
        break label83;
      }
      if (getByte(i + paramLong) != paramByteString.getByte(paramInt1 + i)) {
        break;
      }
      i += 1;
    }
    label83:
    return true;
  }
  
  public int read(ByteBuffer paramByteBuffer)
    throws IOException
  {
    Segment localSegment = this.head;
    int i;
    if (localSegment == null) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      j = Math.min(paramByteBuffer.remaining(), localSegment.limit - localSegment.pos);
      paramByteBuffer.put(localSegment.data, localSegment.pos, j);
      localSegment.pos += j;
      this.size -= j;
      i = j;
    } while (localSegment.pos != localSegment.limit);
    this.head = localSegment.pop();
    SegmentPool.recycle(localSegment);
    return j;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    Segment localSegment = this.head;
    if (localSegment == null) {
      paramInt1 = -1;
    }
    do
    {
      return paramInt1;
      paramInt2 = Math.min(paramInt2, localSegment.limit - localSegment.pos);
      System.arraycopy(localSegment.data, localSegment.pos, paramArrayOfByte, paramInt1, paramInt2);
      localSegment.pos += paramInt2;
      this.size -= paramInt2;
      paramInt1 = paramInt2;
    } while (localSegment.pos != localSegment.limit);
    this.head = localSegment.pop();
    SegmentPool.recycle(localSegment);
    return paramInt2;
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    if (paramBuffer == null) {
      throw new IllegalArgumentException("sink == null");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.size == 0L) {
      return -1L;
    }
    long l = paramLong;
    if (paramLong > this.size) {
      l = this.size;
    }
    paramBuffer.write(this, l);
    return l;
  }
  
  public long readAll(Sink paramSink)
    throws IOException
  {
    long l = this.size;
    if (l > 0L) {
      paramSink.write(this, l);
    }
    return l;
  }
  
  public final UnsafeCursor readAndWriteUnsafe()
  {
    return readAndWriteUnsafe(new UnsafeCursor());
  }
  
  public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor paramUnsafeCursor)
  {
    if (paramUnsafeCursor.buffer != null) {
      throw new IllegalStateException("already attached to a buffer");
    }
    paramUnsafeCursor.buffer = this;
    paramUnsafeCursor.readWrite = true;
    return paramUnsafeCursor;
  }
  
  public byte readByte()
  {
    if (this.size == 0L) {
      throw new IllegalStateException("size == 0");
    }
    Segment localSegment = this.head;
    int i = localSegment.pos;
    int j = localSegment.limit;
    byte[] arrayOfByte = localSegment.data;
    int k = i + 1;
    byte b = arrayOfByte[i];
    this.size -= 1L;
    if (k == j)
    {
      this.head = localSegment.pop();
      SegmentPool.recycle(localSegment);
      return b;
    }
    localSegment.pos = k;
    return b;
  }
  
  public byte[] readByteArray()
  {
    try
    {
      byte[] arrayOfByte = readByteArray(this.size);
      return arrayOfByte;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public byte[] readByteArray(long paramLong)
    throws EOFException
  {
    Util.checkOffsetAndCount(this.size, 0L, paramLong);
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    }
    byte[] arrayOfByte = new byte[(int)paramLong];
    readFully(arrayOfByte);
    return arrayOfByte;
  }
  
  public ByteString readByteString()
  {
    return new ByteString(readByteArray());
  }
  
  public ByteString readByteString(long paramLong)
    throws EOFException
  {
    return new ByteString(readByteArray(paramLong));
  }
  
  public long readDecimalLong()
  {
    if (this.size == 0L) {
      throw new IllegalStateException("size == 0");
    }
    long l2 = 0L;
    int n = 0;
    int i1 = 0;
    int i = 0;
    long l3 = -7L;
    Object localObject = this.head;
    byte[] arrayOfByte = ((Segment)localObject).data;
    int m = ((Segment)localObject).pos;
    int i2 = ((Segment)localObject).limit;
    long l1 = l2;
    int j = n;
    int k = i1;
    l2 = l3;
    n = i;
    if (m < i2)
    {
      n = arrayOfByte[m];
      if ((n >= 48) && (n <= 57))
      {
        i1 = 48 - n;
        if ((l1 < -922337203685477580L) || ((l1 == -922337203685477580L) && (i1 < l2)))
        {
          localObject = new Buffer().writeDecimalLong(l1).writeByte(n);
          if (k == 0) {
            ((Buffer)localObject).readByte();
          }
          throw new NumberFormatException("Number too large: " + ((Buffer)localObject).readUtf8());
        }
        l1 = l1 * 10L + i1;
      }
      for (;;)
      {
        m += 1;
        j += 1;
        break;
        if ((n != 45) || (j != 0)) {
          break label250;
        }
        k = 1;
        l2 -= 1L;
      }
      label250:
      if (j == 0) {
        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(n));
      }
      n = 1;
    }
    if (m == i2)
    {
      this.head = ((Segment)localObject).pop();
      SegmentPool.recycle((Segment)localObject);
    }
    for (;;)
    {
      if (n == 0)
      {
        l3 = l2;
        i = n;
        i1 = k;
        n = j;
        l2 = l1;
        if (this.head != null) {
          break;
        }
      }
      this.size -= j;
      if (k == 0) {
        break label367;
      }
      return l1;
      ((Segment)localObject).pos = m;
    }
    label367:
    return -l1;
  }
  
  public final Buffer readFrom(InputStream paramInputStream)
    throws IOException
  {
    readFrom(paramInputStream, 9223372036854775807L, true);
    return this;
  }
  
  public final Buffer readFrom(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    readFrom(paramInputStream, paramLong, false);
    return this;
  }
  
  public void readFully(Buffer paramBuffer, long paramLong)
    throws EOFException
  {
    if (this.size < paramLong)
    {
      paramBuffer.write(this, this.size);
      throw new EOFException();
    }
    paramBuffer.write(this, paramLong);
  }
  
  public void readFully(byte[] paramArrayOfByte)
    throws EOFException
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = read(paramArrayOfByte, i, paramArrayOfByte.length - i);
      if (j == -1) {
        throw new EOFException();
      }
      i += j;
    }
  }
  
  public long readHexadecimalUnsignedLong()
  {
    if (this.size == 0L) {
      throw new IllegalStateException("size == 0");
    }
    long l2 = 0L;
    int i = 0;
    int j = 0;
    Object localObject = this.head;
    byte[] arrayOfByte = ((Segment)localObject).data;
    int m = ((Segment)localObject).pos;
    int n = ((Segment)localObject).limit;
    long l1 = l2;
    int k = i;
    label60:
    i = j;
    if (m < n)
    {
      int i1 = arrayOfByte[m];
      if ((i1 >= 48) && (i1 <= 57)) {
        i = i1 - 48;
      }
      for (;;)
      {
        if ((0x0 & l1) == 0L) {
          break label302;
        }
        localObject = new Buffer().writeHexadecimalUnsignedLong(l1).writeByte(i1);
        throw new NumberFormatException("Number too large: " + ((Buffer)localObject).readUtf8());
        if ((i1 >= 97) && (i1 <= 102))
        {
          i = i1 - 97 + 10;
        }
        else
        {
          if ((i1 < 65) || (i1 > 70)) {
            break;
          }
          i = i1 - 65 + 10;
        }
      }
      if (k == 0) {
        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(i1));
      }
      i = 1;
    }
    if (m == n)
    {
      this.head = ((Segment)localObject).pop();
      SegmentPool.recycle((Segment)localObject);
    }
    for (;;)
    {
      if (i == 0)
      {
        j = i;
        i = k;
        l2 = l1;
        if (this.head != null) {
          break;
        }
      }
      this.size -= k;
      return l1;
      label302:
      l2 = i;
      k += 1;
      m += 1;
      l1 = l2 | l1 << 4;
      break label60;
      ((Segment)localObject).pos = m;
    }
  }
  
  public int readInt()
  {
    if (this.size < 4L) {
      throw new IllegalStateException("size < 4: " + this.size);
    }
    Segment localSegment = this.head;
    int j = localSegment.pos;
    int i = localSegment.limit;
    if (i - j < 4) {
      return (readByte() & 0xFF) << 24 | (readByte() & 0xFF) << 16 | (readByte() & 0xFF) << 8 | readByte() & 0xFF;
    }
    byte[] arrayOfByte = localSegment.data;
    int k = j + 1;
    j = arrayOfByte[j];
    int n = k + 1;
    k = arrayOfByte[k];
    int m = n + 1;
    int i1 = arrayOfByte[n];
    n = m + 1;
    j = (j & 0xFF) << 24 | (k & 0xFF) << 16 | (i1 & 0xFF) << 8 | arrayOfByte[m] & 0xFF;
    this.size -= 4L;
    if (n == i)
    {
      this.head = localSegment.pop();
      SegmentPool.recycle(localSegment);
      return j;
    }
    localSegment.pos = n;
    return j;
  }
  
  public int readIntLe()
  {
    return Util.reverseBytesInt(readInt());
  }
  
  public long readLong()
  {
    if (this.size < 8L) {
      throw new IllegalStateException("size < 8: " + this.size);
    }
    Segment localSegment = this.head;
    int k = localSegment.pos;
    int i = localSegment.limit;
    if (i - k < 8) {
      return (readInt() & 0xFFFFFFFF) << 32 | readInt() & 0xFFFFFFFF;
    }
    byte[] arrayOfByte = localSegment.data;
    int j = k + 1;
    long l1 = arrayOfByte[k];
    k = j + 1;
    long l2 = arrayOfByte[j];
    j = k + 1;
    long l3 = arrayOfByte[k];
    k = j + 1;
    long l4 = arrayOfByte[j];
    j = k + 1;
    long l5 = arrayOfByte[k];
    k = j + 1;
    long l6 = arrayOfByte[j];
    j = k + 1;
    long l7 = arrayOfByte[k];
    k = j + 1;
    l1 = arrayOfByte[j] & 0xFF | (l2 & 0xFF) << 48 | (l1 & 0xFF) << 56 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8;
    this.size -= 8L;
    if (k == i)
    {
      this.head = localSegment.pop();
      SegmentPool.recycle(localSegment);
      return l1;
    }
    localSegment.pos = k;
    return l1;
  }
  
  public long readLongLe()
  {
    return Util.reverseBytesLong(readLong());
  }
  
  public short readShort()
  {
    if (this.size < 2L) {
      throw new IllegalStateException("size < 2: " + this.size);
    }
    Segment localSegment = this.head;
    int k = localSegment.pos;
    int i = localSegment.limit;
    if (i - k < 2) {
      return (short)((readByte() & 0xFF) << 8 | readByte() & 0xFF);
    }
    byte[] arrayOfByte = localSegment.data;
    int j = k + 1;
    k = arrayOfByte[k];
    int m = j + 1;
    j = arrayOfByte[j];
    this.size -= 2L;
    if (m == i)
    {
      this.head = localSegment.pop();
      SegmentPool.recycle(localSegment);
    }
    for (;;)
    {
      return (short)((k & 0xFF) << 8 | j & 0xFF);
      localSegment.pos = m;
    }
  }
  
  public short readShortLe()
  {
    return Util.reverseBytesShort(readShort());
  }
  
  public String readString(long paramLong, Charset paramCharset)
    throws EOFException
  {
    Util.checkOffsetAndCount(this.size, 0L, paramLong);
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    }
    if (paramLong == 0L) {
      paramCharset = "";
    }
    Segment localSegment;
    String str;
    do
    {
      return paramCharset;
      localSegment = this.head;
      if (localSegment.pos + paramLong > localSegment.limit) {
        return new String(readByteArray(paramLong), paramCharset);
      }
      str = new String(localSegment.data, localSegment.pos, (int)paramLong, paramCharset);
      localSegment.pos = ((int)(localSegment.pos + paramLong));
      this.size -= paramLong;
      paramCharset = str;
    } while (localSegment.pos != localSegment.limit);
    this.head = localSegment.pop();
    SegmentPool.recycle(localSegment);
    return str;
  }
  
  public String readString(Charset paramCharset)
  {
    try
    {
      paramCharset = readString(this.size, paramCharset);
      return paramCharset;
    }
    catch (EOFException paramCharset)
    {
      throw new AssertionError(paramCharset);
    }
  }
  
  public final UnsafeCursor readUnsafe()
  {
    return readUnsafe(new UnsafeCursor());
  }
  
  public final UnsafeCursor readUnsafe(UnsafeCursor paramUnsafeCursor)
  {
    if (paramUnsafeCursor.buffer != null) {
      throw new IllegalStateException("already attached to a buffer");
    }
    paramUnsafeCursor.buffer = this;
    paramUnsafeCursor.readWrite = false;
    return paramUnsafeCursor;
  }
  
  public String readUtf8()
  {
    try
    {
      String str = readString(this.size, Util.UTF_8);
      return str;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public String readUtf8(long paramLong)
    throws EOFException
  {
    return readString(paramLong, Util.UTF_8);
  }
  
  public int readUtf8CodePoint()
    throws EOFException
  {
    if (this.size == 0L) {
      throw new EOFException();
    }
    int m = getByte(0L);
    int j;
    int i;
    int k;
    if ((m & 0x80) == 0)
    {
      j = 0;
      i = m & 0x7F;
      k = 1;
    }
    while (this.size < k)
    {
      throw new EOFException("size < " + k + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(m) + ")");
      if ((m & 0xE0) == 192)
      {
        i = m & 0x1F;
        k = 2;
        j = 128;
      }
      else if ((m & 0xF0) == 224)
      {
        i = m & 0xF;
        k = 3;
        j = 2048;
      }
      else if ((m & 0xF8) == 240)
      {
        i = m & 0x7;
        k = 4;
        j = 65536;
      }
      else
      {
        skip(1L);
        return 65533;
      }
    }
    m = 1;
    while (m < k)
    {
      int n = getByte(m);
      if ((n & 0xC0) == 128)
      {
        m += 1;
        i = n & 0x3F | i << 6;
      }
      else
      {
        skip(m);
        return 65533;
      }
    }
    skip(k);
    if (i > 1114111) {
      return 65533;
    }
    if ((i >= 55296) && (i <= 57343)) {
      return 65533;
    }
    if (i < j) {
      return 65533;
    }
    return i;
  }
  
  @Nullable
  public String readUtf8Line()
    throws EOFException
  {
    long l = indexOf((byte)10);
    if (l == -1L)
    {
      if (this.size != 0L) {
        return readUtf8(this.size);
      }
      return null;
    }
    return readUtf8Line(l);
  }
  
  String readUtf8Line(long paramLong)
    throws EOFException
  {
    if ((paramLong > 0L) && (getByte(paramLong - 1L) == 13))
    {
      str = readUtf8(paramLong - 1L);
      skip(2L);
      return str;
    }
    String str = readUtf8(paramLong);
    skip(1L);
    return str;
  }
  
  public String readUtf8LineStrict()
    throws EOFException
  {
    return readUtf8LineStrict(9223372036854775807L);
  }
  
  public String readUtf8LineStrict(long paramLong)
    throws EOFException
  {
    long l1 = 9223372036854775807L;
    if (paramLong < 0L) {
      throw new IllegalArgumentException("limit < 0: " + paramLong);
    }
    if (paramLong == 9223372036854775807L) {}
    for (;;)
    {
      long l2 = indexOf((byte)10, 0L, l1);
      if (l2 == -1L) {
        break;
      }
      return readUtf8Line(l2);
      l1 = paramLong + 1L;
    }
    if ((l1 < size()) && (getByte(l1 - 1L) == 13) && (getByte(l1) == 10)) {
      return readUtf8Line(l1);
    }
    Buffer localBuffer = new Buffer();
    copyTo(localBuffer, 0L, Math.min(32L, size()));
    throw new EOFException("\\n not found: limit=" + Math.min(size(), paramLong) + " content=" + localBuffer.readByteString().hex() + '…');
  }
  
  public boolean request(long paramLong)
  {
    return this.size >= paramLong;
  }
  
  public void require(long paramLong)
    throws EOFException
  {
    if (this.size < paramLong) {
      throw new EOFException();
    }
  }
  
  List<Integer> segmentSizes()
  {
    if (this.head == null) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(this.head.limit - this.head.pos));
    for (Segment localSegment = this.head.next; localSegment != this.head; localSegment = localSegment.next) {
      localArrayList.add(Integer.valueOf(localSegment.limit - localSegment.pos));
    }
    return localArrayList;
  }
  
  public int select(Options paramOptions)
  {
    int i = selectPrefix(paramOptions, false);
    if (i == -1) {
      return -1;
    }
    long l = paramOptions.byteStrings[i].size();
    try
    {
      skip(l);
      return i;
    }
    catch (EOFException paramOptions)
    {
      throw new AssertionError();
    }
  }
  
  int selectPrefix(Options paramOptions, boolean paramBoolean)
  {
    Segment localSegment1 = this.head;
    if (localSegment1 == null)
    {
      if (paramBoolean)
      {
        n = -2;
        return n;
      }
      return paramOptions.indexOf(ByteString.EMPTY);
    }
    Object localObject = localSegment1.data;
    int i = localSegment1.pos;
    int j = localSegment1.limit;
    int[] arrayOfInt = paramOptions.trie;
    int m = 0;
    int k = -1;
    paramOptions = localSegment1;
    label65:
    int n = m + 1;
    int i4 = arrayOfInt[m];
    m = n + 1;
    n = arrayOfInt[n];
    if (n != -1) {
      k = n;
    }
    if (paramOptions == null) {}
    label131:
    int i2;
    int i3;
    int i1;
    label187:
    Segment localSegment2;
    byte[] arrayOfByte;
    do
    {
      n = k;
      if (!paramBoolean) {
        break;
      }
      return -2;
      if (i4 >= 0) {
        break label310;
      }
      n = i;
      i = j;
      j = m;
      i2 = j;
      j = n + 1;
      i3 = localObject[n];
      i1 = i2 + 1;
      n = k;
      if ((i3 & 0xFF) != arrayOfInt[i2]) {
        break;
      }
      if (i1 != m + i4 * -1) {
        break label293;
      }
      n = 1;
      if (j != i) {
        break label463;
      }
      localSegment2 = paramOptions.next;
      i2 = localSegment2.pos;
      arrayOfByte = localSegment2.data;
      i3 = localSegment2.limit;
      i = i3;
      j = i2;
      localObject = arrayOfByte;
      paramOptions = localSegment2;
      if (localSegment2 != localSegment1) {
        break label259;
      }
    } while (n == 0);
    paramOptions = null;
    localObject = arrayOfByte;
    j = i2;
    i = i3;
    label259:
    label285:
    label293:
    label310:
    label453:
    label463:
    for (;;)
    {
      if (n != 0)
      {
        n = arrayOfInt[i1];
        m = i;
        i = j;
        j = m;
        m = n;
      }
      for (;;)
      {
        if (m >= 0)
        {
          return m;
          n = 0;
          break label187;
          n = j;
          j = i1;
          break label131;
          i1 = i + 1;
          i2 = localObject[i];
          i = m;
          for (;;)
          {
            n = k;
            if (i == m + i4) {
              break;
            }
            if ((i2 & 0xFF) == arrayOfInt[i])
            {
              n = arrayOfInt[(i + i4)];
              if (i1 != j) {
                break label453;
              }
              localSegment2 = paramOptions.next;
              i1 = localSegment2.pos;
              arrayOfByte = localSegment2.data;
              i2 = localSegment2.limit;
              m = n;
              j = i2;
              i = i1;
              localObject = arrayOfByte;
              paramOptions = localSegment2;
              if (localSegment2 != localSegment1) {
                break label285;
              }
              paramOptions = null;
              m = n;
              j = i2;
              i = i1;
              localObject = arrayOfByte;
              break label285;
            }
            i += 1;
          }
        }
        m = -m;
        break label65;
        i = i1;
        m = n;
      }
    }
  }
  
  public final ByteString sha1()
  {
    return digest("SHA-1");
  }
  
  public final ByteString sha256()
  {
    return digest("SHA-256");
  }
  
  public final ByteString sha512()
  {
    return digest("SHA-512");
  }
  
  public final long size()
  {
    return this.size;
  }
  
  public void skip(long paramLong)
    throws EOFException
  {
    while (paramLong > 0L)
    {
      if (this.head == null) {
        throw new EOFException();
      }
      int i = (int)Math.min(paramLong, this.head.limit - this.head.pos);
      this.size -= i;
      long l = paramLong - i;
      Segment localSegment = this.head;
      localSegment.pos = (i + localSegment.pos);
      paramLong = l;
      if (this.head.pos == this.head.limit)
      {
        localSegment = this.head;
        this.head = localSegment.pop();
        SegmentPool.recycle(localSegment);
        paramLong = l;
      }
    }
  }
  
  public final ByteString snapshot()
  {
    if (this.size > 2147483647L) {
      throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }
    return snapshot((int)this.size);
  }
  
  public final ByteString snapshot(int paramInt)
  {
    if (paramInt == 0) {
      return ByteString.EMPTY;
    }
    return new SegmentedByteString(this, paramInt);
  }
  
  public Timeout timeout()
  {
    return Timeout.NONE;
  }
  
  public String toString()
  {
    return snapshot().toString();
  }
  
  Segment writableSegment(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 8192)) {
      throw new IllegalArgumentException();
    }
    Segment localSegment2;
    Segment localSegment1;
    if (this.head == null)
    {
      this.head = SegmentPool.take();
      localSegment2 = this.head;
      Segment localSegment3 = this.head;
      localSegment1 = this.head;
      localSegment3.prev = localSegment1;
      localSegment2.next = localSegment1;
    }
    do
    {
      return localSegment1;
      localSegment2 = this.head.prev;
      if (localSegment2.limit + paramInt > 8192) {
        break;
      }
      localSegment1 = localSegment2;
    } while (localSegment2.owner);
    return localSegment2.push(SegmentPool.take());
  }
  
  public int write(ByteBuffer paramByteBuffer)
    throws IOException
  {
    if (paramByteBuffer == null) {
      throw new IllegalArgumentException("source == null");
    }
    int j = paramByteBuffer.remaining();
    int i = j;
    while (i > 0)
    {
      Segment localSegment = writableSegment(1);
      int k = Math.min(i, 8192 - localSegment.limit);
      paramByteBuffer.get(localSegment.data, localSegment.limit, k);
      i -= k;
      localSegment.limit = (k + localSegment.limit);
    }
    this.size += j;
    return j;
  }
  
  public Buffer write(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new IllegalArgumentException("byteString == null");
    }
    paramByteString.write(this);
    return this;
  }
  
  public Buffer write(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("source == null");
    }
    return write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public Buffer write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("source == null");
    }
    Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    int i = paramInt1 + paramInt2;
    while (paramInt1 < i)
    {
      Segment localSegment = writableSegment(1);
      int j = Math.min(i - paramInt1, 8192 - localSegment.limit);
      System.arraycopy(paramArrayOfByte, paramInt1, localSegment.data, localSegment.limit, j);
      paramInt1 += j;
      localSegment.limit = (j + localSegment.limit);
    }
    this.size += paramInt2;
    return this;
  }
  
  public BufferedSink write(Source paramSource, long paramLong)
    throws IOException
  {
    while (paramLong > 0L)
    {
      long l = paramSource.read(this, paramLong);
      if (l == -1L) {
        throw new EOFException();
      }
      paramLong -= l;
    }
    return this;
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    if (paramBuffer == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramBuffer == this) {
      throw new IllegalArgumentException("source == this");
    }
    Util.checkOffsetAndCount(paramBuffer.size, 0L, paramLong);
    if (paramLong > 0L)
    {
      if (paramLong >= paramBuffer.head.limit - paramBuffer.head.pos) {
        break label191;
      }
      if (this.head == null) {
        break label162;
      }
      localSegment1 = this.head.prev;
      if ((localSegment1 == null) || (!localSegment1.owner)) {
        break label178;
      }
      l = localSegment1.limit;
      if (!localSegment1.shared) {
        break label168;
      }
    }
    label162:
    label168:
    for (int i = 0;; i = localSegment1.pos)
    {
      if (l + paramLong - i > 8192L) {
        break label178;
      }
      paramBuffer.head.writeTo(localSegment1, (int)paramLong);
      paramBuffer.size -= paramLong;
      this.size += paramLong;
      return;
      localSegment1 = null;
      break;
    }
    label178:
    paramBuffer.head = paramBuffer.head.split((int)paramLong);
    label191:
    Segment localSegment1 = paramBuffer.head;
    long l = localSegment1.limit - localSegment1.pos;
    paramBuffer.head = localSegment1.pop();
    if (this.head == null)
    {
      this.head = localSegment1;
      localSegment1 = this.head;
      Segment localSegment2 = this.head;
      Segment localSegment3 = this.head;
      localSegment2.prev = localSegment3;
      localSegment1.next = localSegment3;
    }
    for (;;)
    {
      paramBuffer.size -= l;
      this.size += l;
      paramLong -= l;
      break;
      this.head.prev.push(localSegment1).compact();
    }
  }
  
  public long writeAll(Source paramSource)
    throws IOException
  {
    if (paramSource == null) {
      throw new IllegalArgumentException("source == null");
    }
    long l2;
    for (long l1 = 0L;; l1 += l2)
    {
      l2 = paramSource.read(this, 8192L);
      if (l2 == -1L) {
        break;
      }
    }
    return l1;
  }
  
  public Buffer writeByte(int paramInt)
  {
    Segment localSegment = writableSegment(1);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit;
    localSegment.limit = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    this.size += 1L;
    return this;
  }
  
  public Buffer writeDecimalLong(long paramLong)
  {
    if (paramLong == 0L) {
      return writeByte(48);
    }
    if (paramLong < 0L)
    {
      paramLong = -paramLong;
      if (paramLong < 0L) {
        return writeUtf8("-9223372036854775808");
      }
    }
    for (int j = 1;; j = 0)
    {
      int i;
      if (paramLong < 100000000L) {
        if (paramLong < 10000L) {
          if (paramLong < 100L) {
            if (paramLong < 10L) {
              i = 1;
            }
          }
        }
      }
      int k;
      Segment localSegment;
      byte[] arrayOfByte;
      for (;;)
      {
        k = i;
        if (j != 0) {
          k = i + 1;
        }
        localSegment = writableSegment(k);
        arrayOfByte = localSegment.data;
        i = localSegment.limit + k;
        while (paramLong != 0L)
        {
          int m = (int)(paramLong % 10L);
          i -= 1;
          arrayOfByte[i] = DIGITS[m];
          paramLong /= 10L;
        }
        i = 2;
        continue;
        if (paramLong < 1000L)
        {
          i = 3;
        }
        else
        {
          i = 4;
          continue;
          if (paramLong < 1000000L)
          {
            if (paramLong < 100000L) {
              i = 5;
            } else {
              i = 6;
            }
          }
          else if (paramLong < 10000000L)
          {
            i = 7;
          }
          else
          {
            i = 8;
            continue;
            if (paramLong < 1000000000000L)
            {
              if (paramLong < 10000000000L)
              {
                if (paramLong < 1000000000L) {
                  i = 9;
                } else {
                  i = 10;
                }
              }
              else if (paramLong < 100000000000L) {
                i = 11;
              } else {
                i = 12;
              }
            }
            else if (paramLong < 1000000000000000L)
            {
              if (paramLong < 10000000000000L) {
                i = 13;
              } else if (paramLong < 100000000000000L) {
                i = 14;
              } else {
                i = 15;
              }
            }
            else if (paramLong < 100000000000000000L)
            {
              if (paramLong < 10000000000000000L) {
                i = 16;
              } else {
                i = 17;
              }
            }
            else if (paramLong < 1000000000000000000L) {
              i = 18;
            } else {
              i = 19;
            }
          }
        }
      }
      if (j != 0) {
        arrayOfByte[(i - 1)] = 45;
      }
      localSegment.limit += k;
      paramLong = this.size;
      this.size = (k + paramLong);
      return this;
    }
  }
  
  public Buffer writeHexadecimalUnsignedLong(long paramLong)
  {
    if (paramLong == 0L) {
      return writeByte(48);
    }
    int j = Long.numberOfTrailingZeros(Long.highestOneBit(paramLong)) / 4 + 1;
    Segment localSegment = writableSegment(j);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit + j - 1;
    int k = localSegment.limit;
    while (i >= k)
    {
      arrayOfByte[i] = DIGITS[((int)(0xF & paramLong))];
      paramLong >>>= 4;
      i -= 1;
    }
    localSegment.limit += j;
    paramLong = this.size;
    this.size = (j + paramLong);
    return this;
  }
  
  public Buffer writeInt(int paramInt)
  {
    Segment localSegment = writableSegment(4);
    byte[] arrayOfByte = localSegment.data;
    int j = localSegment.limit;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    localSegment.limit = (i + 1);
    this.size += 4L;
    return this;
  }
  
  public Buffer writeIntLe(int paramInt)
  {
    return writeInt(Util.reverseBytesInt(paramInt));
  }
  
  public Buffer writeLong(long paramLong)
  {
    Segment localSegment = writableSegment(8);
    byte[] arrayOfByte = localSegment.data;
    int j = localSegment.limit;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 56 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 48 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 40 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 32 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(int)(paramLong & 0xFF));
    localSegment.limit = (i + 1);
    this.size += 8L;
    return this;
  }
  
  public Buffer writeLongLe(long paramLong)
  {
    return writeLong(Util.reverseBytesLong(paramLong));
  }
  
  public Buffer writeShort(int paramInt)
  {
    Segment localSegment = writableSegment(2);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[j] = ((byte)(paramInt & 0xFF));
    localSegment.limit = (j + 1);
    this.size += 2L;
    return this;
  }
  
  public Buffer writeShortLe(int paramInt)
  {
    return writeShort(Util.reverseBytesShort((short)paramInt));
  }
  
  public Buffer writeString(String paramString, int paramInt1, int paramInt2, Charset paramCharset)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("string == null");
    }
    if (paramInt1 < 0) {
      throw new IllegalAccessError("beginIndex < 0: " + paramInt1);
    }
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("endIndex < beginIndex: " + paramInt2 + " < " + paramInt1);
    }
    if (paramInt2 > paramString.length()) {
      throw new IllegalArgumentException("endIndex > string.length: " + paramInt2 + " > " + paramString.length());
    }
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    if (paramCharset.equals(Util.UTF_8)) {
      return writeUtf8(paramString, paramInt1, paramInt2);
    }
    paramString = paramString.substring(paramInt1, paramInt2).getBytes(paramCharset);
    return write(paramString, 0, paramString.length);
  }
  
  public Buffer writeString(String paramString, Charset paramCharset)
  {
    return writeString(paramString, 0, paramString.length(), paramCharset);
  }
  
  public final Buffer writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    return writeTo(paramOutputStream, this.size);
  }
  
  public final Buffer writeTo(OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("out == null");
    }
    Util.checkOffsetAndCount(this.size, 0L, paramLong);
    Object localObject = this.head;
    if (paramLong > 0L)
    {
      int i = (int)Math.min(paramLong, ((Segment)localObject).limit - ((Segment)localObject).pos);
      paramOutputStream.write(((Segment)localObject).data, ((Segment)localObject).pos, i);
      ((Segment)localObject).pos += i;
      this.size -= i;
      paramLong -= i;
      if (((Segment)localObject).pos != ((Segment)localObject).limit) {
        break label141;
      }
      Segment localSegment = ((Segment)localObject).pop();
      this.head = localSegment;
      SegmentPool.recycle((Segment)localObject);
      localObject = localSegment;
    }
    label141:
    for (;;)
    {
      break;
      return this;
    }
  }
  
  public Buffer writeUtf8(String paramString)
  {
    return writeUtf8(paramString, 0, paramString.length());
  }
  
  public Buffer writeUtf8(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("string == null");
    }
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("beginIndex < 0: " + paramInt1);
    }
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("endIndex < beginIndex: " + paramInt2 + " < " + paramInt1);
    }
    int i;
    label142:
    int j;
    label177:
    byte[] arrayOfByte;
    int k;
    if (paramInt2 > paramString.length())
    {
      throw new IllegalArgumentException("endIndex > string.length: " + paramInt2 + " > " + paramString.length());
      i = 0;
      if ((j > 56319) || (i < 56320) || (i > 57343))
      {
        writeByte(63);
        paramInt1 += 1;
      }
    }
    else
    {
      if (paramInt1 >= paramInt2) {
        return this;
      }
      j = paramString.charAt(paramInt1);
      if (j < 128)
      {
        Segment localSegment = writableSegment(1);
        arrayOfByte = localSegment.data;
        k = localSegment.limit - paramInt1;
        int m = Math.min(paramInt2, 8192 - k);
        i = paramInt1 + 1;
        arrayOfByte[(k + paramInt1)] = ((byte)j);
        paramInt1 = i;
        label250:
        if (paramInt1 < m)
        {
          i = paramString.charAt(paramInt1);
          if (i < 128) {}
        }
        else
        {
          i = paramInt1 + k - localSegment.limit;
          localSegment.limit += i;
          this.size += i;
        }
      }
    }
    for (;;)
    {
      break label177;
      arrayOfByte[(paramInt1 + k)] = ((byte)i);
      paramInt1 += 1;
      break label250;
      if (j < 2048)
      {
        writeByte(j >> 6 | 0xC0);
        writeByte(j & 0x3F | 0x80);
        paramInt1 += 1;
      }
      else if ((j < 55296) || (j > 57343))
      {
        writeByte(j >> 12 | 0xE0);
        writeByte(j >> 6 & 0x3F | 0x80);
        writeByte(j & 0x3F | 0x80);
        paramInt1 += 1;
      }
      else
      {
        if (paramInt1 + 1 >= paramInt2) {
          break;
        }
        i = paramString.charAt(paramInt1 + 1);
        break label142;
        i = (i & 0xFFFF23FF | (j & 0xFFFF27FF) << 10) + 65536;
        writeByte(i >> 18 | 0xF0);
        writeByte(i >> 12 & 0x3F | 0x80);
        writeByte(i >> 6 & 0x3F | 0x80);
        writeByte(i & 0x3F | 0x80);
        paramInt1 += 2;
      }
    }
    return this;
  }
  
  public Buffer writeUtf8CodePoint(int paramInt)
  {
    if (paramInt < 128)
    {
      writeByte(paramInt);
      return this;
    }
    if (paramInt < 2048)
    {
      writeByte(paramInt >> 6 | 0xC0);
      writeByte(paramInt & 0x3F | 0x80);
      return this;
    }
    if (paramInt < 65536)
    {
      if ((paramInt >= 55296) && (paramInt <= 57343))
      {
        writeByte(63);
        return this;
      }
      writeByte(paramInt >> 12 | 0xE0);
      writeByte(paramInt >> 6 & 0x3F | 0x80);
      writeByte(paramInt & 0x3F | 0x80);
      return this;
    }
    if (paramInt <= 1114111)
    {
      writeByte(paramInt >> 18 | 0xF0);
      writeByte(paramInt >> 12 & 0x3F | 0x80);
      writeByte(paramInt >> 6 & 0x3F | 0x80);
      writeByte(paramInt & 0x3F | 0x80);
      return this;
    }
    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(paramInt));
  }
  
  public static final class UnsafeCursor
    implements Closeable
  {
    public Buffer buffer;
    public byte[] data;
    public int end = -1;
    public long offset = -1L;
    public boolean readWrite;
    private Segment segment;
    public int start = -1;
    
    public void close()
    {
      if (this.buffer == null) {
        throw new IllegalStateException("not attached to a buffer");
      }
      this.buffer = null;
      this.segment = null;
      this.offset = -1L;
      this.data = null;
      this.start = -1;
      this.end = -1;
    }
    
    public final long expandBuffer(int paramInt)
    {
      if (paramInt <= 0) {
        throw new IllegalArgumentException("minByteCount <= 0: " + paramInt);
      }
      if (paramInt > 8192) {
        throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + paramInt);
      }
      if (this.buffer == null) {
        throw new IllegalStateException("not attached to a buffer");
      }
      if (!this.readWrite) {
        throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
      }
      long l = this.buffer.size;
      Segment localSegment = this.buffer.writableSegment(paramInt);
      paramInt = 8192 - localSegment.limit;
      localSegment.limit = 8192;
      this.buffer.size = (paramInt + l);
      this.segment = localSegment;
      this.offset = l;
      this.data = localSegment.data;
      this.start = (8192 - paramInt);
      this.end = 8192;
      return paramInt;
    }
    
    public final int next()
    {
      if (this.offset == this.buffer.size) {
        throw new IllegalStateException();
      }
      if (this.offset == -1L) {
        return seek(0L);
      }
      return seek(this.offset + (this.end - this.start));
    }
    
    public final long resizeBuffer(long paramLong)
    {
      if (this.buffer == null) {
        throw new IllegalStateException("not attached to a buffer");
      }
      if (!this.readWrite) {
        throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
      }
      long l3 = this.buffer.size;
      long l1;
      Segment localSegment;
      int i;
      if (paramLong <= l3)
      {
        if (paramLong < 0L) {
          throw new IllegalArgumentException("newSize < 0: " + paramLong);
        }
        l1 = l3 - paramLong;
        while (l1 > 0L)
        {
          localSegment = this.buffer.head.prev;
          i = localSegment.limit - localSegment.pos;
          if (i <= l1)
          {
            this.buffer.head = localSegment.pop();
            SegmentPool.recycle(localSegment);
            l1 -= i;
          }
          else
          {
            localSegment.limit = ((int)(localSegment.limit - l1));
          }
        }
        this.segment = null;
        this.offset = paramLong;
        this.data = null;
        this.start = -1;
        this.end = -1;
      }
      for (;;)
      {
        this.buffer.size = paramLong;
        return l3;
        if (paramLong > l3)
        {
          l1 = paramLong - l3;
          i = 1;
          while (l1 > 0L)
          {
            localSegment = this.buffer.writableSegment(1);
            int j = (int)Math.min(l1, 8192 - localSegment.limit);
            localSegment.limit += j;
            long l2 = l1 - j;
            l1 = l2;
            if (i != 0)
            {
              this.segment = localSegment;
              this.offset = l3;
              this.data = localSegment.data;
              this.start = (localSegment.limit - j);
              this.end = localSegment.limit;
              i = 0;
              l1 = l2;
            }
          }
        }
      }
    }
    
    public final int seek(long paramLong)
    {
      if ((paramLong < -1L) || (paramLong > this.buffer.size)) {
        throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", new Object[] { Long.valueOf(paramLong), Long.valueOf(this.buffer.size) }));
      }
      if ((paramLong == -1L) || (paramLong == this.buffer.size))
      {
        this.segment = null;
        this.offset = paramLong;
        this.data = null;
        this.start = -1;
        this.end = -1;
        return -1;
      }
      long l1 = this.buffer.size;
      Object localObject1 = this.buffer.head;
      Object localObject2 = this.buffer.head;
      long l2;
      if (this.segment != null)
      {
        l2 = this.offset - (this.start - this.segment.pos);
        if (l2 > paramLong)
        {
          localObject2 = this.segment;
          l1 = 0L;
        }
      }
      for (;;)
      {
        if (l2 - paramLong > paramLong - l1)
        {
          for (localObject2 = localObject1;; localObject2 = ((Segment)localObject2).next)
          {
            l2 = l1;
            localObject1 = localObject2;
            if (paramLong < ((Segment)localObject2).limit - ((Segment)localObject2).pos + l1) {
              break;
            }
            l1 += ((Segment)localObject2).limit - ((Segment)localObject2).pos;
          }
          localObject1 = this.segment;
          long l3 = l1;
          l1 = l2;
          l2 = l3;
        }
        else
        {
          for (l1 = l2;; l1 -= ((Segment)localObject2).limit - ((Segment)localObject2).pos)
          {
            l2 = l1;
            localObject1 = localObject2;
            if (l1 <= paramLong) {
              break;
            }
            localObject2 = ((Segment)localObject2).prev;
          }
          localObject2 = localObject1;
          if (this.readWrite)
          {
            localObject2 = localObject1;
            if (((Segment)localObject1).shared)
            {
              localObject2 = ((Segment)localObject1).unsharedCopy();
              if (this.buffer.head == localObject1) {
                this.buffer.head = ((Segment)localObject2);
              }
              localObject2 = ((Segment)localObject1).push((Segment)localObject2);
              ((Segment)localObject2).prev.pop();
            }
          }
          this.segment = ((Segment)localObject2);
          this.offset = paramLong;
          this.data = ((Segment)localObject2).data;
          int i = ((Segment)localObject2).pos;
          this.start = ((int)(paramLong - l2) + i);
          this.end = ((Segment)localObject2).limit;
          return this.end - this.start;
          l2 = l1;
          l1 = 0L;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okio.Buffer
 * JD-Core Version:    0.7.0.1
 */