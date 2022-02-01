package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class cp
{
  public static <T extends JceStruct> T a(byte[] paramArrayOfByte, T paramT, boolean paramBoolean)
  {
    if (paramArrayOfByte != null)
    {
      if (paramT == null) {
        return null;
      }
      Object localObject = paramT;
      if (paramBoolean) {}
      try
      {
        localObject = paramT.newInit();
        ((JceStruct)localObject).recyle();
        ((JceStruct)localObject).readFrom(h(paramArrayOfByte));
        return localObject;
      }
      catch (Exception paramArrayOfByte)
      {
        paramT = new StringBuilder();
        paramT.append("getJceStruct exception: ");
        paramT.append(paramArrayOfByte);
        eg.h("JceStructUtil", paramT.toString());
      }
    }
    return null;
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