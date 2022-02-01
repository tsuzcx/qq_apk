package moai.core.utilities.string;

public class Hex
{
  private static final char[] DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static byte[] decodeHex(char[] paramArrayOfChar)
    throws RuntimeException
  {
    int j = 0;
    int k = paramArrayOfChar.length;
    if ((k & 0x1) != 0) {
      throw new RuntimeException("Odd number of characters.");
    }
    byte[] arrayOfByte = new byte[k >> 1];
    int i = 0;
    while (j < k)
    {
      int m = toDigit(paramArrayOfChar[j], j);
      j += 1;
      int n = toDigit(paramArrayOfChar[j], j);
      j += 1;
      arrayOfByte[i] = ((byte)((m << 4 | n) & 0xFF));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static char[] encodeHex(byte[] paramArrayOfByte)
  {
    int j = 0;
    int k = paramArrayOfByte.length;
    char[] arrayOfChar = new char[k << 1];
    int i = 0;
    while (i < k)
    {
      int m = j + 1;
      arrayOfChar[j] = DIGITS[((paramArrayOfByte[i] & 0xF0) >>> 4)];
      j = m + 1;
      arrayOfChar[m] = DIGITS[(paramArrayOfByte[i] & 0xF)];
      i += 1;
    }
    return arrayOfChar;
  }
  
  protected static int toDigit(char paramChar, int paramInt)
    throws RuntimeException
  {
    int i = Character.digit(paramChar, 16);
    if (i == -1) {
      throw new RuntimeException("Illegal hexadecimal charcter " + paramChar + " at index " + paramInt);
    }
    return i;
  }
  
  /* Error */
  public Object decode(Object paramObject)
    throws RuntimeException
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 78
    //   4: ifeq +16 -> 20
    //   7: aload_1
    //   8: checkcast 78	java/lang/String
    //   11: invokevirtual 82	java/lang/String:toCharArray	()[C
    //   14: astore_1
    //   15: aload_1
    //   16: invokestatic 84	moai/core/utilities/string/Hex:decodeHex	([C)[B
    //   19: areturn
    //   20: aload_1
    //   21: checkcast 85	[C
    //   24: checkcast 85	[C
    //   27: astore_1
    //   28: goto -13 -> 15
    //   31: astore_1
    //   32: new 34	java/lang/RuntimeException
    //   35: dup
    //   36: aload_1
    //   37: invokevirtual 88	java/lang/ClassCastException:getMessage	()Ljava/lang/String;
    //   40: invokespecial 39	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	Hex
    //   0	44	1	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	15	31	java/lang/ClassCastException
    //   15	20	31	java/lang/ClassCastException
    //   20	28	31	java/lang/ClassCastException
  }
  
  public byte[] decode(byte[] paramArrayOfByte)
    throws RuntimeException
  {
    return decodeHex(new String(paramArrayOfByte).toCharArray());
  }
  
  /* Error */
  public Object encode(Object paramObject)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 78
    //   4: ifeq +16 -> 20
    //   7: aload_1
    //   8: checkcast 78	java/lang/String
    //   11: invokevirtual 99	java/lang/String:getBytes	()[B
    //   14: astore_1
    //   15: aload_1
    //   16: invokestatic 101	moai/core/utilities/string/Hex:encodeHex	([B)[C
    //   19: areturn
    //   20: aload_1
    //   21: checkcast 103	[B
    //   24: checkcast 103	[B
    //   27: astore_1
    //   28: goto -13 -> 15
    //   31: astore_1
    //   32: new 34	java/lang/RuntimeException
    //   35: dup
    //   36: aload_1
    //   37: invokevirtual 88	java/lang/ClassCastException:getMessage	()Ljava/lang/String;
    //   40: invokespecial 39	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	Hex
    //   0	44	1	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	15	31	java/lang/ClassCastException
    //   15	20	31	java/lang/ClassCastException
    //   20	28	31	java/lang/ClassCastException
  }
  
  public byte[] encode(byte[] paramArrayOfByte)
  {
    return new String(encodeHex(paramArrayOfByte)).getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.utilities.string.Hex
 * JD-Core Version:    0.7.0.1
 */