package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class df
{
  public static <T extends JceStruct> T a(byte[] paramArrayOfByte, T paramT, boolean paramBoolean)
  {
    if ((paramArrayOfByte == null) || (paramT == null)) {
      return null;
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramT = paramT.newInit();
        paramT.recyle();
        paramT.readFrom(e(paramArrayOfByte));
        return paramT;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
    }
  }
  
  public static byte[] a(JceStruct paramJceStruct)
  {
    try
    {
      JceOutputStream localJceOutputStream = new JceOutputStream();
      localJceOutputStream.setServerEncoding("UTF-8");
      paramJceStruct.writeTo(localJceOutputStream);
      paramJceStruct = localJceOutputStream.toByteArray();
      return paramJceStruct;
    }
    catch (Exception paramJceStruct) {}
    return null;
  }
  
  public static <T extends JceStruct> T b(byte[] paramArrayOfByte, T paramT, boolean paramBoolean)
  {
    if ((paramArrayOfByte == null) || (paramT == null)) {
      return null;
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        JceStruct localJceStruct = paramT.newInit();
        localObject = localJceStruct;
        if (localJceStruct == null) {
          localObject = paramT;
        }
        ((JceStruct)localObject).recyle();
        ((JceStruct)localObject).readFrom(e(paramArrayOfByte));
        return localObject;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
      Object localObject = paramT;
    }
  }
  
  private static JceInputStream e(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new JceInputStream(paramArrayOfByte);
    paramArrayOfByte.setServerEncoding("UTF-8");
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.df
 * JD-Core Version:    0.7.0.1
 */