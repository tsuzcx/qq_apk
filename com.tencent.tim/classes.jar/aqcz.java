public class aqcz
{
  public static short a(byte[] paramArrayOfByte)
  {
    int i = 0;
    short s = 0;
    while (i < 2)
    {
      s = (short)((short)(s << 8) | b(paramArrayOfByte[i]));
      i += 1;
    }
    return s;
  }
  
  public static byte[] a(short paramShort)
  {
    return new byte[] { (byte)(paramShort >>> 8), (byte)paramShort };
  }
  
  public static int b(byte paramByte)
  {
    return paramByte & 0xFF;
  }
  
  public static byte[] h(int paramInt)
  {
    byte[] arrayOfByte = new byte[4];
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < 4)
    {
      arrayOfByte[paramInt] = Integer.valueOf(i >>> 24).byteValue();
      i <<= 8;
      paramInt += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] intToByte(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)((0xFF00 & paramInt) >> 8);
    int k = (byte)((0xFF0000 & paramInt) >> 16);
    return new byte[] { (byte)((0xFF000000 & paramInt) >> 24), k, j, i };
  }
  
  public static int l(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    int i = paramInt;
    while (i < paramInt + 4)
    {
      j = j << 8 | b(paramArrayOfByte[i]);
      i += 1;
    }
    return j;
  }
  
  public static int x(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      j = j << 8 | b(paramArrayOfByte[i]);
      i += 1;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqcz
 * JD-Core Version:    0.7.0.1
 */