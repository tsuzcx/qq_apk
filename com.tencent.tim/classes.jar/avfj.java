public class avfj
{
  public static final byte[] hS = hexStringToByteArray("00A40400");
  public static final byte[] hT = hexStringToByteArray("6A82");
  public static final byte[] hU = hexStringToByteArray("9000");
  public static final byte[] hV = hexStringToByteArray("0000");
  private static final char[] hexArray = "0123456789ABCDEF".toCharArray();
  
  public static byte[] a(byte[] paramArrayOfByte, byte[]... paramVarArgs)
  {
    int j = paramArrayOfByte.length;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    byte[] arrayOfByte = copyOfRange(paramArrayOfByte, 0, j);
    j = paramArrayOfByte.length;
    k = paramVarArgs.length;
    i = 0;
    while (i < k)
    {
      paramArrayOfByte = paramVarArgs[i];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, j, paramArrayOfByte.length);
      j += paramArrayOfByte.length;
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] aj(String paramString)
  {
    byte[] arrayOfByte = hexStringToByteArray(String.format("%02X", new Object[] { Integer.valueOf(paramString.length() / 2) }));
    paramString = hexStringToByteArray(paramString);
    return a(hS, new byte[][] { arrayOfByte, paramString });
  }
  
  public static String bytesToHexString(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar[(i * 2)] = hexArray[(j >>> 4)];
      arrayOfChar[(i * 2 + 1)] = hexArray[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  private static byte[] copyOfRange(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      throw new IllegalArgumentException();
    }
    int i = paramArrayOfByte.length;
    if ((paramInt1 < 0) || (paramInt1 > i)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    paramInt2 -= paramInt1;
    i = Math.min(paramInt2, i - paramInt1);
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public static byte[] hexStringToByteArray(String paramString)
  {
    int j = paramString.length();
    byte[] arrayOfByte = new byte[j / 2];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[(i / 2)] = ((byte)((Character.digit(paramString.charAt(i), 16) << 4) + Character.digit(paramString.charAt(i + 1), 16)));
      i += 2;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avfj
 * JD-Core Version:    0.7.0.1
 */