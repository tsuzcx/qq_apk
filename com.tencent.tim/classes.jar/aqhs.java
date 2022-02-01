import com.tencent.qphone.base.util.QLog;

public class aqhs
{
  private static final char[] digits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  public static final byte[] emptybytes = new byte[0];
  
  public static String String2HexString(String paramString)
  {
    return bytes2HexStr(paramString.getBytes());
  }
  
  public static String byte2HexStr(byte paramByte)
  {
    int i = digits[(paramByte & 0xF)];
    paramByte = (byte)(paramByte >>> 4);
    return new String(new char[] { digits[(paramByte & 0xF)], i });
  }
  
  public static String bytes2HexStr(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    char[] arrayOfChar;
    for (;;)
    {
      return null;
      arrayOfChar = new char[paramArrayOfByte.length * 2];
      int i = 0;
      try
      {
        while (i < paramArrayOfByte.length)
        {
          int j = paramArrayOfByte[i];
          arrayOfChar[(i * 2 + 1)] = digits[(j & 0xF)];
          j = (byte)(j >>> 4);
          arrayOfChar[(i * 2 + 0)] = digits[(j & 0xF)];
          i += 1;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramArrayOfByte) {}
    }
    QLog.d("HexUtil", 2, " === bytes2HexStr error === " + paramArrayOfByte.toString());
    return null;
    return new String(arrayOfChar);
  }
  
  public static byte char2Byte(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return (byte)(paramChar - '0');
    }
    if ((paramChar >= 'a') && (paramChar <= 'f')) {
      return (byte)(paramChar - 'a' + 10);
    }
    if ((paramChar >= 'A') && (paramChar <= 'F')) {
      return (byte)(paramChar - 'A' + 10);
    }
    return 0;
  }
  
  public static byte[] hexStr2Bytes(String paramString)
  {
    Object localObject;
    if ((paramString == null) || (paramString.equals(""))) {
      localObject = emptybytes;
    }
    for (;;)
    {
      return localObject;
      byte[] arrayOfByte = new byte[paramString.length() / 2];
      int i = 0;
      localObject = arrayOfByte;
      try
      {
        if (i < arrayOfByte.length)
        {
          char c1 = paramString.charAt(i * 2);
          char c2 = paramString.charAt(i * 2 + 1);
          arrayOfByte[i] = ((byte)(char2Byte(c1) * 16 + char2Byte(c2)));
          i += 1;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HexUtil", 2, " === hexStr2Bytes error === " + paramString.toString());
        }
      }
    }
    return emptybytes;
  }
  
  public static String hexString2String(String paramString)
  {
    return new String(hexStr2Bytes(paramString));
  }
  
  public static void printHexString(String paramString, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      printHexStringEx(paramString, paramArrayOfByte);
    }
  }
  
  public static void printHexStringEx(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      QLog.i(paramString, 2, "bytes = null or bytes.length = 0");
      return;
    }
    StringBuilder localStringBuilder1 = new StringBuilder((paramArrayOfByte.length + 15) / 16 * 73 + 85);
    localStringBuilder1.append("buf size: " + paramArrayOfByte.length).append("\r\n");
    localStringBuilder1.append("______00_01_02_03_04_05_06_07_08_09_0A_0B_0C_0D_0E_0F\r\n");
    StringBuilder localStringBuilder2 = new StringBuilder(32);
    localStringBuilder2.append(" ");
    int k = 0;
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (j < paramArrayOfByte.length)
      {
        if (i == 0) {
          localStringBuilder1.append(String.format("%04x: ", new Object[] { Integer.valueOf(j) }));
        }
        localStringBuilder1.append(String.format("%02x ", new Object[] { Byte.valueOf(paramArrayOfByte[j]) }));
        if ((paramArrayOfByte[j] >= 32) && (paramArrayOfByte[j] <= 127)) {
          localStringBuilder2.append(String.format("%c", new Object[] { Byte.valueOf(paramArrayOfByte[j]) }));
        }
      }
      for (;;)
      {
        int m = i + 1;
        i = m;
        if (m < 16) {
          break label293;
        }
        localStringBuilder1.append(localStringBuilder2.toString()).append("\r\n");
        localStringBuilder2.setLength(1);
        if (k == 0) {
          break;
        }
        do
        {
          QLog.i(paramString, 2, localStringBuilder1.toString());
          return;
          localStringBuilder2.append(".");
          break;
        } while (i == 0);
        localStringBuilder1.append("   ");
        localStringBuilder2.append(" ");
        k = 1;
      }
      i = 0;
      label293:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqhs
 * JD-Core Version:    0.7.0.1
 */