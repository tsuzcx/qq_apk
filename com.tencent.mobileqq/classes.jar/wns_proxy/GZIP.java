package wns_proxy;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class GZIP
{
  private static final int BTYPE_DYNAMIC = 2;
  private static final int BTYPE_FIXED = 1;
  private static final int BTYPE_NONE = 0;
  private static final int BTYPE_RESERVED = 3;
  private static final int EOB_CODE = 256;
  private static final int FCOMMENT_MASK = 16;
  private static final int FEXTRA_MASK = 4;
  private static final int FHCRC_MASK = 2;
  private static final int FNAME_MASK = 8;
  private static final int FTEXT_MASK = 1;
  private static final int MAX_BITS = 16;
  private static final int MAX_CODE_DISTANCES = 31;
  private static final int MAX_CODE_LENGTHS = 18;
  private static final int MAX_CODE_LITERALS = 287;
  private static byte[] buffer;
  private static int buffer_bit;
  private static int buffer_byte;
  private static int buffer_index;
  private static byte[] distance_extra_bits;
  private static short[] distance_values;
  private static byte[] dynamic_length_order;
  private static byte[] length_extra_bits;
  private static short[] length_values;
  private static byte[] uncompressed;
  private static int uncompressed_index;
  
  private static int[] createHuffmanTree(byte[] paramArrayOfByte, int paramInt)
  {
    int[] arrayOfInt2 = new int[17];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      j = paramArrayOfByte[i];
      arrayOfInt2[j] += 1;
      i += 1;
    }
    arrayOfInt2[0] = 0;
    int[] arrayOfInt1 = new int[17];
    i = 1;
    int j = 0;
    while (i <= 16)
    {
      j = j + arrayOfInt2[(i - 1)] << 1;
      arrayOfInt1[i] = j;
      i += 1;
    }
    arrayOfInt2 = new int[(paramInt << 1) + 16];
    int k = 0;
    for (i = 1; k <= paramInt; i = j)
    {
      int m = paramArrayOfByte[k];
      j = i;
      if (m != 0)
      {
        int i1 = arrayOfInt1[m];
        arrayOfInt1[m] = (i1 + 1);
        m -= 1;
        j = 0;
        while (m >= 0)
        {
          if ((1 << m & i1) == 0)
          {
            n = arrayOfInt2[j] >> 16;
            if (n == 0)
            {
              arrayOfInt2[j] |= i << 16;
            }
            else
            {
              j = i;
              i = n;
              break label218;
            }
          }
          else
          {
            n = arrayOfInt2[j] & 0xFFFF;
            if (n != 0) {
              break label224;
            }
            arrayOfInt2[j] |= i;
          }
          j = i + 1;
          label218:
          int n = j;
          break label232;
          label224:
          j = n;
          n = i;
          i = j;
          label232:
          m -= 1;
          j = i;
          i = n;
        }
        arrayOfInt2[j] = (0x80000000 | k);
        j = i;
      }
      k += 1;
    }
    return arrayOfInt2;
  }
  
  private static byte[] decodeCodeLengths(int[] paramArrayOfInt, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      int k = readCode(paramArrayOfInt);
      if (k >= 16)
      {
        int n;
        int m;
        if (k == 16)
        {
          k = readBits(2) + 3;
          n = i;
          m = j;
        }
        else
        {
          if (k == 17) {
            j = readBits(3) + 3;
          } else {
            j = readBits(7) + 11;
          }
          m = 0;
          k = j;
          n = i;
        }
        for (;;)
        {
          i = n;
          j = m;
          if (k <= 0) {
            break;
          }
          arrayOfByte[n] = ((byte)m);
          n += 1;
          k -= 1;
        }
      }
      if (k != 0)
      {
        arrayOfByte[i] = ((byte)k);
        i += 1;
      }
      else
      {
        i += 1;
      }
      j = k;
    }
    return arrayOfByte;
  }
  
  public static byte[] inflate(byte[] paramArrayOfByte)
  {
    return inflate(paramArrayOfByte, 0);
  }
  
  private static byte[] inflate(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      buffer = paramArrayOfByte;
      buffer_index += paramInt;
      if ((readBits(16) == 35615) && (readBits(8) == 8))
      {
        paramInt = readBits(8);
        buffer_index += 6;
        if ((paramInt & 0x4) != 0) {
          buffer_index += readBits(16);
        }
        int i;
        do
        {
          if ((paramInt & 0x8) == 0) {
            break;
          }
          paramArrayOfByte = buffer;
          i = buffer_index;
          buffer_index = i + 1;
        } while (paramArrayOfByte[i] != 0);
        do
        {
          if ((paramInt & 0x10) == 0) {
            break;
          }
          paramArrayOfByte = buffer;
          i = buffer_index;
          buffer_index = i + 1;
        } while (paramArrayOfByte[i] != 0);
        if ((paramInt & 0x2) != 0) {
          buffer_index += 2;
        }
        paramInt = buffer_index;
        buffer_index = buffer.length - 4;
        uncompressed = new byte[readBits(16) | readBits(16) << 16];
        buffer_index = paramInt;
        length_extra_bits = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 0, 99, 99 };
        length_values = new short[] { 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 15, 17, 19, 23, 27, 31, 35, 43, 51, 59, 67, 83, 99, 115, 131, 163, 195, 227, 258, 0, 0 };
        distance_extra_bits = new byte[] { 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13 };
        distance_values = new short[] { 1, 2, 3, 4, 5, 7, 9, 13, 17, 25, 33, 49, 65, 97, 129, 193, 257, 385, 513, 769, 1025, 1537, 2049, 3073, 4097, 6145, 8193, 12289, 16385, 24577 };
        dynamic_length_order = new byte[] { 16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15 };
        do
        {
          paramInt = readBits(1);
          i = readBits(2);
          if (i == 0)
          {
            inflateStored();
          }
          else if (i == 1)
          {
            inflateFixed();
          }
          else
          {
            if (i != 2) {
              break;
            }
            inflateDynamic();
          }
        } while (paramInt == 0);
        paramArrayOfByte = uncompressed;
      }
    }
    finally
    {
      uncompressed_index = 0;
      buffer_bit = 0;
      buffer_byte = 0;
      buffer_index = 0;
      dynamic_length_order = null;
      distance_extra_bits = null;
      length_extra_bits = null;
      uncompressed = null;
      buffer = null;
      distance_values = null;
      length_values = null;
    }
    try
    {
      uncompressed_index = 0;
      buffer_bit = 0;
      buffer_byte = 0;
      buffer_index = 0;
      dynamic_length_order = null;
      distance_extra_bits = null;
      length_extra_bits = null;
      uncompressed = null;
      buffer = null;
      distance_values = null;
      length_values = null;
      return paramArrayOfByte;
    }
    finally
    {
      break label1163;
    }
    throw new IOException("Invalid GZIP block");
    throw new IOException("Invalid GZIP format");
    label1163:
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  private static void inflateBlock(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    for (;;)
    {
      int i = readCode(paramArrayOfInt1);
      if (i == 256) {
        break;
      }
      if (i > 256)
      {
        i -= 257;
        j = length_values[i];
        int k = length_extra_bits[i];
        i = j;
        if (k > 0) {
          i = j + readBits(k);
        }
        j = readCode(paramArrayOfInt2);
        k = distance_values[j];
        int m = distance_extra_bits[j];
        j = k;
        if (m > 0) {
          j = k + readBits(m);
        }
        k = 0;
        m = uncompressed_index;
        while (k < i)
        {
          arrayOfByte = uncompressed;
          int n = uncompressed_index;
          uncompressed_index = n + 1;
          arrayOfByte[n] = arrayOfByte[(m - j + k)];
          k += 1;
        }
      }
      byte[] arrayOfByte = uncompressed;
      int j = uncompressed_index;
      uncompressed_index = j + 1;
      arrayOfByte[j] = ((byte)i);
    }
  }
  
  private static void inflateDynamic()
  {
    int j = readBits(5) + 257;
    int k = readBits(5) + 1;
    int m = readBits(4);
    Object localObject = new byte[19];
    int i = 0;
    while (i < m + 4)
    {
      localObject[dynamic_length_order[i]] = ((byte)readBits(3));
      i += 1;
    }
    localObject = createHuffmanTree((byte[])localObject, 18);
    inflateBlock(createHuffmanTree(decodeCodeLengths((int[])localObject, j), j - 1), createHuffmanTree(decodeCodeLengths((int[])localObject, k), k - 1));
  }
  
  private static void inflateFixed()
  {
    Object localObject = new byte[288];
    int k = 0;
    int j = 0;
    for (;;)
    {
      i = 144;
      if (j >= 144) {
        break;
      }
      localObject[j] = 8;
      j += 1;
    }
    for (;;)
    {
      j = 256;
      if (i >= 256) {
        break;
      }
      localObject[i] = 9;
      i += 1;
    }
    for (;;)
    {
      i = 280;
      if (j >= 280) {
        break;
      }
      localObject[j] = 7;
      j += 1;
    }
    while (i < 288)
    {
      localObject[i] = 8;
      i += 1;
    }
    localObject = createHuffmanTree((byte[])localObject, 287);
    byte[] arrayOfByte = new byte[32];
    int i = k;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = 5;
      i += 1;
    }
    inflateBlock((int[])localObject, createHuffmanTree(arrayOfByte, 31));
  }
  
  private static void inflateStored()
  {
    buffer_bit = 0;
    int i = readBits(16);
    readBits(16);
    System.arraycopy(buffer, buffer_index, uncompressed, uncompressed_index, i);
    buffer_index += i;
    uncompressed_index += i;
  }
  
  public static byte[] inflateSyn(byte[] paramArrayOfByte, int paramInt)
  {
    return inflate(paramArrayOfByte, paramInt);
  }
  
  public static DataInputStream openDataInputStream(byte[] paramArrayOfByte)
  {
    return new DataInputStream(new ByteArrayInputStream(inflate(paramArrayOfByte)));
  }
  
  private static int readBits(int paramInt)
  {
    int i = buffer_bit;
    byte[] arrayOfByte;
    if (i == 0)
    {
      arrayOfByte = buffer;
      i = buffer_index;
      buffer_index = i + 1;
      i = arrayOfByte[i] & 0xFF;
      buffer_byte = i;
    }
    else
    {
      i = buffer_byte >> i;
    }
    int j = 8 - buffer_bit;
    while (j < paramInt)
    {
      arrayOfByte = buffer;
      int k = buffer_index;
      buffer_index = k + 1;
      buffer_byte = arrayOfByte[k] & 0xFF;
      i |= buffer_byte << j;
      j += 8;
    }
    buffer_bit = buffer_bit + paramInt & 0x7;
    return (1 << paramInt) - 1 & i;
  }
  
  private static int readCode(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt[0];
    while (i >= 0)
    {
      if (buffer_bit == 0)
      {
        byte[] arrayOfByte = buffer;
        int j = buffer_index;
        buffer_index = j + 1;
        buffer_byte = arrayOfByte[j] & 0xFF;
      }
      if ((buffer_byte & 1 << buffer_bit) == 0) {
        i = paramArrayOfInt[(i >> 16)];
      } else {
        i = paramArrayOfInt[(i & 0xFFFF)];
      }
      buffer_bit = buffer_bit + 1 & 0x7;
    }
    return i & 0xFFFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wns_proxy.GZIP
 * JD-Core Version:    0.7.0.1
 */