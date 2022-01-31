package tmsdk.common.d.a.b;

import a.e.d;
import a.e.g;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class h
{
  public static d a()
  {
    return new d();
  }
  
  public static g a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = a(paramArrayOfByte, new g());
    if (paramArrayOfByte == null) {
      return null;
    }
    return (g)paramArrayOfByte;
  }
  
  public static JceStruct a(byte[] paramArrayOfByte, JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return null;
    }
    paramJceStruct.recyle();
    paramJceStruct.readFrom(b(paramArrayOfByte));
    return paramJceStruct;
  }
  
  public static byte[] a(JceStruct paramJceStruct)
  {
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding("UTF-8");
    paramJceStruct.writeTo(localJceOutputStream);
    return localJceOutputStream.toByteArray();
  }
  
  private static JceInputStream b(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new JceInputStream(paramArrayOfByte);
    paramArrayOfByte.setServerEncoding("UTF-8");
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.h
 * JD-Core Version:    0.7.0.1
 */