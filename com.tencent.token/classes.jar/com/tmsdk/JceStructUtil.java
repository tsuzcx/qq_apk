package com.tmsdk;

import android.util.Log;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class JceStructUtil
{
  private static final String ENCODE_TYPE = "UTF-8";
  
  private static JceInputStream createUTF8InputStream(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new JceInputStream(paramArrayOfByte);
    paramArrayOfByte.setServerEncoding("UTF-8");
    return paramArrayOfByte;
  }
  
  public static JceStruct getJceStruct(byte[] paramArrayOfByte, JceStruct paramJceStruct, boolean paramBoolean)
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
        paramJceStruct.readFrom(createUTF8InputStream(paramArrayOfByte));
        return paramJceStruct;
      }
      catch (Exception paramArrayOfByte)
      {
        Log.e("JceStructUtil", "getJceStruct exception: " + paramArrayOfByte);
        return null;
      }
    }
  }
  
  public static byte[] jceStructToUTF8ByteArray(JceStruct paramJceStruct)
  {
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding("UTF-8");
    paramJceStruct.writeTo(localJceOutputStream);
    return localJceOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.JceStructUtil
 * JD-Core Version:    0.7.0.1
 */