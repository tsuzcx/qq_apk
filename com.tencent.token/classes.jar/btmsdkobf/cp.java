package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class cp
{
  public static JceStruct a(byte[] paramArrayOfByte, JceStruct paramJceStruct, boolean paramBoolean)
  {
    if ((paramArrayOfByte == null) || (paramJceStruct == null)) {
      return null;
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramJceStruct = paramJceStruct.newInit();
        paramJceStruct.recyle();
        paramJceStruct.readFrom(h(paramArrayOfByte));
        return paramJceStruct;
      }
      catch (Exception paramArrayOfByte)
      {
        eg.h("JceStructUtil", "getJceStruct exception: " + paramArrayOfByte);
        return null;
      }
    }
  }
  
  public static byte[] b(JceStruct paramJceStruct)
  {
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding("UTF-8");
    paramJceStruct.writeTo(localJceOutputStream);
    return localJceOutputStream.toByteArray();
  }
  
  public static at bp()
  {
    return new at();
  }
  
  public static bb g(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = a(paramArrayOfByte, new bb(), false);
    if (paramArrayOfByte == null) {
      return null;
    }
    return (bb)paramArrayOfByte;
  }
  
  private static JceInputStream h(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new JceInputStream(paramArrayOfByte);
    paramArrayOfByte.setServerEncoding("UTF-8");
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cp
 * JD-Core Version:    0.7.0.1
 */