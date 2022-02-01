import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.weiyun.utils.Utils;

public class awrh
{
  public static ByteStringMicro d(String paramString)
  {
    return ByteStringMicro.copyFrom(Utils.hexStr2Bytes(paramString));
  }
  
  public static String g(ByteStringMicro paramByteStringMicro)
  {
    return Utils.bytes2HexStr(paramByteStringMicro.toByteArray());
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
 * Qualified Name:     awrh
 * JD-Core Version:    0.7.0.1
 */