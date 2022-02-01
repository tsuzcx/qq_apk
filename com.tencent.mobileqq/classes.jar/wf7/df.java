package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class df
{
  public static <T extends JceStruct> T a(byte[] paramArrayOfByte, T paramT, boolean paramBoolean)
  {
    Object localObject;
    if (paramArrayOfByte != null)
    {
      if (paramT == null) {
        return null;
      }
      localObject = paramT;
      if (!paramBoolean) {}
    }
    try
    {
      localObject = paramT.newInit();
      ((JceStruct)localObject).recyle();
      ((JceStruct)localObject).readFrom(e(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
    return null;
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
    catch (Exception paramJceStruct)
    {
      label27:
      break label27;
    }
    return null;
  }
  
  public static <T extends JceStruct> T b(byte[] paramArrayOfByte, T paramT, boolean paramBoolean)
  {
    Object localObject;
    if (paramArrayOfByte != null)
    {
      if (paramT == null) {
        return null;
      }
      localObject = paramT;
      if (!paramBoolean) {}
    }
    label49:
    for (;;)
    {
      try
      {
        localObject = paramT.newInit();
        if (localObject != null) {
          break label49;
        }
        localObject = paramT;
        ((JceStruct)localObject).recyle();
        ((JceStruct)localObject).readFrom(e(paramArrayOfByte));
        return localObject;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
      return null;
    }
  }
  
  private static JceInputStream e(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new JceInputStream(paramArrayOfByte);
    paramArrayOfByte.setServerEncoding("UTF-8");
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.df
 * JD-Core Version:    0.7.0.1
 */