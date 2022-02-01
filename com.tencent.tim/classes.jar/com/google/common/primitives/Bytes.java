package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible
public final class Bytes
{
  public static List<Byte> asList(byte... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return Collections.emptyList();
    }
    return new ByteArrayAsList(paramVarArgs);
  }
  
  public static byte[] concat(byte[]... paramVarArgs)
  {
    int k = paramVarArgs.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    byte[] arrayOfByte1 = new byte[j];
    k = paramVarArgs.length;
    i = 0;
    j = 0;
    while (i < k)
    {
      byte[] arrayOfByte2 = paramVarArgs[i];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j, arrayOfByte2.length);
      j += arrayOfByte2.length;
      i += 1;
    }
    return arrayOfByte1;
  }
  
  public static boolean contains(byte[] paramArrayOfByte, byte paramByte)
  {
    boolean bool2 = false;
    int j = paramArrayOfByte.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfByte[i] == paramByte) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static byte[] ensureCapacity(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    if (paramInt1 >= 0)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1, "Invalid minLength: %s", paramInt1);
      if (paramInt2 < 0) {
        break label56;
      }
    }
    label56:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "Invalid padding: %s", paramInt2);
      byte[] arrayOfByte = paramArrayOfByte;
      if (paramArrayOfByte.length < paramInt1) {
        arrayOfByte = Arrays.copyOf(paramArrayOfByte, paramInt1 + paramInt2);
      }
      return arrayOfByte;
      bool1 = false;
      break;
    }
  }
  
  public static int hashCode(byte paramByte)
  {
    return paramByte;
  }
  
  public static int indexOf(byte[] paramArrayOfByte, byte paramByte)
  {
    return indexOf(paramArrayOfByte, paramByte, 0, paramArrayOfByte.length);
  }
  
  private static int indexOf(byte[] paramArrayOfByte, byte paramByte, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramArrayOfByte[paramInt1] == paramByte) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return -1;
  }
  
  public static int indexOf(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Preconditions.checkNotNull(paramArrayOfByte1, "array");
    Preconditions.checkNotNull(paramArrayOfByte2, "target");
    if (paramArrayOfByte2.length == 0) {
      return 0;
    }
    int i = 0;
    if (i < paramArrayOfByte1.length - paramArrayOfByte2.length + 1)
    {
      int j = 0;
      for (;;)
      {
        if (j >= paramArrayOfByte2.length) {
          break label67;
        }
        if (paramArrayOfByte1[(i + j)] != paramArrayOfByte2[j])
        {
          i += 1;
          break;
        }
        j += 1;
      }
      label67:
      return i;
    }
    return -1;
  }
  
  public static int lastIndexOf(byte[] paramArrayOfByte, byte paramByte)
  {
    return lastIndexOf(paramArrayOfByte, paramByte, 0, paramArrayOfByte.length);
  }
  
  private static int lastIndexOf(byte[] paramArrayOfByte, byte paramByte, int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    while (paramInt2 >= paramInt1)
    {
      if (paramArrayOfByte[paramInt2] == paramByte) {
        return paramInt2;
      }
      paramInt2 -= 1;
    }
    return -1;
  }
  
  public static byte[] toArray(Collection<? extends Number> paramCollection)
  {
    if ((paramCollection instanceof ByteArrayAsList)) {
      return ((ByteArrayAsList)paramCollection).toByteArray();
    }
    paramCollection = paramCollection.toArray();
    int j = paramCollection.length;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[i] = ((Number)Preconditions.checkNotNull(paramCollection[i])).byteValue();
      i += 1;
    }
    return arrayOfByte;
  }
  
  @GwtCompatible
  static class ByteArrayAsList
    extends AbstractList<Byte>
    implements Serializable, RandomAccess
  {
    private static final long serialVersionUID = 0L;
    final byte[] array;
    final int end;
    final int start;
    
    ByteArrayAsList(byte[] paramArrayOfByte)
    {
      this(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    ByteArrayAsList(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.array = paramArrayOfByte;
      this.start = paramInt1;
      this.end = paramInt2;
    }
    
    public boolean contains(Object paramObject)
    {
      return ((paramObject instanceof Byte)) && (Bytes.indexOf(this.array, ((Byte)paramObject).byteValue(), this.start, this.end) != -1);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if (paramObject == this) {}
      for (;;)
      {
        return true;
        if (!(paramObject instanceof ByteArrayAsList)) {
          break;
        }
        paramObject = (ByteArrayAsList)paramObject;
        int j = size();
        if (paramObject.size() != j) {
          return false;
        }
        int i = 0;
        while (i < j)
        {
          if (this.array[(this.start + i)] != paramObject.array[(paramObject.start + i)]) {
            return false;
          }
          i += 1;
        }
      }
      return super.equals(paramObject);
    }
    
    public Byte get(int paramInt)
    {
      Preconditions.checkElementIndex(paramInt, size());
      return Byte.valueOf(this.array[(this.start + paramInt)]);
    }
    
    public int hashCode()
    {
      int j = 1;
      int i = this.start;
      while (i < this.end)
      {
        j = j * 31 + Bytes.hashCode(this.array[i]);
        i += 1;
      }
      return j;
    }
    
    public int indexOf(Object paramObject)
    {
      if ((paramObject instanceof Byte))
      {
        int i = Bytes.indexOf(this.array, ((Byte)paramObject).byteValue(), this.start, this.end);
        if (i >= 0) {
          return i - this.start;
        }
      }
      return -1;
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public int lastIndexOf(Object paramObject)
    {
      if ((paramObject instanceof Byte))
      {
        int i = Bytes.lastIndexOf(this.array, ((Byte)paramObject).byteValue(), this.start, this.end);
        if (i >= 0) {
          return i - this.start;
        }
      }
      return -1;
    }
    
    public Byte set(int paramInt, Byte paramByte)
    {
      Preconditions.checkElementIndex(paramInt, size());
      byte b = this.array[(this.start + paramInt)];
      this.array[(this.start + paramInt)] = ((Byte)Preconditions.checkNotNull(paramByte)).byteValue();
      return Byte.valueOf(b);
    }
    
    public int size()
    {
      return this.end - this.start;
    }
    
    public List<Byte> subList(int paramInt1, int paramInt2)
    {
      Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
      if (paramInt1 == paramInt2) {
        return Collections.emptyList();
      }
      return new ByteArrayAsList(this.array, this.start + paramInt1, this.start + paramInt2);
    }
    
    byte[] toByteArray()
    {
      int i = size();
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.array, this.start, arrayOfByte, 0, i);
      return arrayOfByte;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(size() * 5);
      localStringBuilder.append('[').append(this.array[this.start]);
      int i = this.start + 1;
      while (i < this.end)
      {
        localStringBuilder.append(", ").append(this.array[i]);
        i += 1;
      }
      return ']';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.primitives.Bytes
 * JD-Core Version:    0.7.0.1
 */